package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter
  implements Closeable, Flushable
{
  private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
  private static final String[] REPLACEMENT_CHARS = new String[''];
  private String deferredName;
  private boolean htmlSafe;
  private String indent;
  private boolean lenient;
  private final Writer out;
  private String separator;
  private boolean serializeNulls;
  private int[] stack = new int[32];
  private int stackSize = 0;
  
  static
  {
    int i = 0;
    while (i <= 31)
    {
      REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    REPLACEMENT_CHARS[34] = "\\\"";
    REPLACEMENT_CHARS[92] = "\\\\";
    REPLACEMENT_CHARS[9] = "\\t";
    REPLACEMENT_CHARS[8] = "\\b";
    REPLACEMENT_CHARS[10] = "\\n";
    REPLACEMENT_CHARS[13] = "\\r";
    REPLACEMENT_CHARS[12] = "\\f";
    HTML_SAFE_REPLACEMENT_CHARS = (String[])REPLACEMENT_CHARS.clone();
    HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
    HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
    HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
    HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
    HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
  }
  
  public JsonWriter(Writer paramWriter)
  {
    push(6);
    this.separator = ":";
    this.serializeNulls = true;
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.out = paramWriter;
  }
  
  private void beforeName()
  {
    int i = peek();
    if (i == 5) {
      this.out.write(44);
    }
    while (i == 3)
    {
      newline();
      replaceTop(4);
      return;
    }
    throw new IllegalStateException("Nesting problem.");
  }
  
  private void beforeValue()
  {
    switch (peek())
    {
    case 3: 
    case 5: 
    default: 
      throw new IllegalStateException("Nesting problem.");
    case 7: 
      if (!this.lenient) {
        throw new IllegalStateException("JSON must have only one top-level value.");
      }
    case 6: 
      replaceTop(7);
      return;
    case 1: 
      replaceTop(2);
      newline();
      return;
    case 2: 
      this.out.append(',');
      newline();
      return;
    }
    this.out.append(this.separator);
    replaceTop(5);
  }
  
  private JsonWriter close(int paramInt1, int paramInt2, String paramString)
  {
    int i = peek();
    if ((i != paramInt2) && (i != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.deferredName != null) {
      throw new IllegalStateException("Dangling name: " + this.deferredName);
    }
    this.stackSize -= 1;
    if (i == paramInt2) {
      newline();
    }
    this.out.write(paramString);
    return this;
  }
  
  private void newline()
  {
    if (this.indent == null) {}
    for (;;)
    {
      return;
      this.out.write("\n");
      int i = 1;
      int j = this.stackSize;
      while (i < j)
      {
        this.out.write(this.indent);
        i += 1;
      }
    }
  }
  
  private JsonWriter open(int paramInt, String paramString)
  {
    beforeValue();
    push(paramInt);
    this.out.write(paramString);
    return this;
  }
  
  private int peek()
  {
    if (this.stackSize == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    return this.stack[(this.stackSize - 1)];
  }
  
  private void push(int paramInt)
  {
    if (this.stackSize == this.stack.length)
    {
      arrayOfInt = new int[this.stackSize * 2];
      System.arraycopy(this.stack, 0, arrayOfInt, 0, this.stackSize);
      this.stack = arrayOfInt;
    }
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    this.stackSize = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  private void replaceTop(int paramInt)
  {
    this.stack[(this.stackSize - 1)] = paramInt;
  }
  
  private void string(String paramString)
  {
    int j = 0;
    if (this.htmlSafe) {}
    int m;
    int i;
    int n;
    int k;
    for (String[] arrayOfString = HTML_SAFE_REPLACEMENT_CHARS;; arrayOfString = REPLACEMENT_CHARS)
    {
      this.out.write("\"");
      m = paramString.length();
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label153;
        }
        n = paramString.charAt(i);
        if (n >= 128) {
          break;
        }
        String str2 = arrayOfString[n];
        str1 = str2;
        if (str2 != null) {
          break label101;
        }
        k = j;
        i += 1;
        j = k;
      }
    }
    if (n == 8232) {}
    for (String str1 = "\\u2028";; str1 = "\\u2029")
    {
      label101:
      if (j < i) {
        this.out.write(paramString, j, i - j);
      }
      this.out.write(str1);
      k = i + 1;
      break;
      k = j;
      if (n != 8233) {
        break;
      }
    }
    label153:
    if (j < m) {
      this.out.write(paramString, j, m - j);
    }
    this.out.write("\"");
  }
  
  private void writeDeferredName()
  {
    if (this.deferredName != null)
    {
      beforeName();
      string(this.deferredName);
      this.deferredName = null;
    }
  }
  
  public JsonWriter beginArray()
  {
    writeDeferredName();
    return open(1, "[");
  }
  
  public JsonWriter beginObject()
  {
    writeDeferredName();
    return open(3, "{");
  }
  
  public void close()
  {
    this.out.close();
    int i = this.stackSize;
    if ((i > 1) || ((i == 1) && (this.stack[(i - 1)] != 7))) {
      throw new IOException("Incomplete document");
    }
    this.stackSize = 0;
  }
  
  public JsonWriter endArray()
  {
    return close(1, 2, "]");
  }
  
  public JsonWriter endObject()
  {
    return close(3, 5, "}");
  }
  
  public void flush()
  {
    if (this.stackSize == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.out.flush();
  }
  
  public final boolean getSerializeNulls()
  {
    return this.serializeNulls;
  }
  
  public final boolean isHtmlSafe()
  {
    return this.htmlSafe;
  }
  
  public boolean isLenient()
  {
    return this.lenient;
  }
  
  public JsonWriter jsonValue(String paramString)
  {
    if (paramString == null) {
      return nullValue();
    }
    writeDeferredName();
    beforeValue();
    this.out.append(paramString);
    return this;
  }
  
  public JsonWriter name(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.deferredName != null) {
      throw new IllegalStateException();
    }
    if (this.stackSize == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.deferredName = paramString;
    return this;
  }
  
  public JsonWriter nullValue()
  {
    if (this.deferredName != null)
    {
      if (this.serializeNulls) {
        writeDeferredName();
      }
    }
    else
    {
      beforeValue();
      this.out.write("null");
      return this;
    }
    this.deferredName = null;
    return this;
  }
  
  public final void setHtmlSafe(boolean paramBoolean)
  {
    this.htmlSafe = paramBoolean;
  }
  
  public final void setIndent(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.indent = null;
      this.separator = ":";
      return;
    }
    this.indent = paramString;
    this.separator = ": ";
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.lenient = paramBoolean;
  }
  
  public final void setSerializeNulls(boolean paramBoolean)
  {
    this.serializeNulls = paramBoolean;
  }
  
  public JsonWriter value(double paramDouble)
  {
    writeDeferredName();
    if ((!this.lenient) && ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble);
    }
    beforeValue();
    this.out.append(Double.toString(paramDouble));
    return this;
  }
  
  public JsonWriter value(long paramLong)
  {
    writeDeferredName();
    beforeValue();
    this.out.write(Long.toString(paramLong));
    return this;
  }
  
  public JsonWriter value(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return nullValue();
    }
    writeDeferredName();
    beforeValue();
    Writer localWriter = this.out;
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "true";; paramBoolean = "false")
    {
      localWriter.write(paramBoolean);
      return this;
    }
  }
  
  public JsonWriter value(Number paramNumber)
  {
    if (paramNumber == null) {
      return nullValue();
    }
    writeDeferredName();
    String str = paramNumber.toString();
    if ((!this.lenient) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
    }
    beforeValue();
    this.out.append(str);
    return this;
  }
  
  public JsonWriter value(String paramString)
  {
    if (paramString == null) {
      return nullValue();
    }
    writeDeferredName();
    beforeValue();
    string(paramString);
    return this;
  }
  
  public JsonWriter value(boolean paramBoolean)
  {
    writeDeferredName();
    beforeValue();
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.stream.JsonWriter
 * JD-Core Version:    0.7.0.1
 */