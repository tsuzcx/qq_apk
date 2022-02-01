package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IndentingWriter;
import com.android.dx.util.TwoColumnOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

public abstract class BaseDumper
  implements ParseObserver
{
  protected Args args;
  private int at;
  private final byte[] bytes;
  private final String filePath;
  private final int hexCols;
  private int indent;
  private final PrintStream out;
  private final boolean rawBytes;
  private String separator;
  private final boolean strictParse;
  private final int width;
  
  public BaseDumper(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, Args paramArgs)
  {
    this.bytes = paramArrayOfByte;
    this.rawBytes = paramArgs.rawBytes;
    this.out = paramPrintStream;
    int i;
    label70:
    int j;
    if (paramArgs.width <= 0)
    {
      i = 79;
      this.width = i;
      this.filePath = paramString;
      this.strictParse = paramArgs.strictParse;
      this.indent = 0;
      if (!this.rawBytes) {
        break label130;
      }
      paramArrayOfByte = "|";
      this.separator = paramArrayOfByte;
      this.at = 0;
      this.args = paramArgs;
      j = (this.width - 5) / 15 + 1 & 0xFFFFFFFE;
      if (j >= 6) {
        break label136;
      }
      i = 6;
    }
    for (;;)
    {
      this.hexCols = i;
      return;
      i = paramArgs.width;
      break;
      label130:
      paramArrayOfByte = "";
      break label70;
      label136:
      i = j;
      if (j > 10) {
        i = 10;
      }
    }
  }
  
  static int computeParamWidth(ConcreteMethod paramConcreteMethod, boolean paramBoolean)
  {
    return paramConcreteMethod.getEffectiveDescriptor().getParameterTypes().getWordCount();
  }
  
  public void changeIndent(int paramInt)
  {
    this.indent += paramInt;
    if (this.rawBytes) {}
    for (String str = "|";; str = "")
    {
      this.separator = str;
      paramInt = 0;
      while (paramInt < this.indent)
      {
        this.separator += "  ";
        paramInt += 1;
      }
    }
  }
  
  public void endParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2, Member paramMember) {}
  
  protected final int getAt()
  {
    return this.at;
  }
  
  protected final byte[] getBytes()
  {
    return this.bytes;
  }
  
  protected final String getFilePath()
  {
    return this.filePath;
  }
  
  protected final boolean getRawBytes()
  {
    return this.rawBytes;
  }
  
  protected final boolean getStrictParse()
  {
    return this.strictParse;
  }
  
  protected final int getWidth1()
  {
    if (this.rawBytes) {
      return this.hexCols * 2 + 5 + this.hexCols / 2;
    }
    return 0;
  }
  
  protected final int getWidth2()
  {
    if (this.rawBytes) {}
    for (int i = getWidth1() + 1;; i = 0) {
      return this.width - i - this.indent * 2;
    }
  }
  
  protected final String hexDump(int paramInt1, int paramInt2)
  {
    return Hex.dump(this.bytes, paramInt1, paramInt2, paramInt1, this.hexCols, 4);
  }
  
  public void parsed(ByteArray paramByteArray, int paramInt1, int paramInt2, String paramString)
  {
    paramInt1 = paramByteArray.underlyingOffset(paramInt1, getBytes());
    boolean bool = getRawBytes();
    if (paramInt1 < this.at)
    {
      println("<dump skipped backwards to " + Hex.u4(paramInt1) + ">");
      this.at = paramInt1;
      if (!bool) {
        break label172;
      }
    }
    label172:
    for (paramByteArray = hexDump(paramInt1, paramInt2);; paramByteArray = "")
    {
      print(twoColumns(paramByteArray, paramString));
      this.at += paramInt2;
      return;
      if (paramInt1 <= this.at) {
        break;
      }
      if (bool) {}
      for (paramByteArray = hexDump(this.at, paramInt1 - this.at);; paramByteArray = "")
      {
        print(twoColumns(paramByteArray, "<skipped to " + Hex.u4(paramInt1) + ">"));
        this.at = paramInt1;
        break;
      }
    }
  }
  
  protected final void print(String paramString)
  {
    this.out.print(paramString);
  }
  
  protected final void println(String paramString)
  {
    this.out.println(paramString);
  }
  
  protected final void setAt(ByteArray paramByteArray, int paramInt)
  {
    this.at = paramByteArray.underlyingOffset(paramInt, this.bytes);
  }
  
  public void startParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2) {}
  
  protected final String twoColumns(String paramString1, String paramString2)
  {
    int j = getWidth1();
    int i = getWidth2();
    if (j == 0) {}
    try
    {
      j = paramString2.length();
      paramString1 = new StringWriter(j * 2);
      IndentingWriter localIndentingWriter = new IndentingWriter(paramString1, i, this.separator);
      localIndentingWriter.write(paramString2);
      if ((j == 0) || (paramString2.charAt(j - 1) != '\n')) {
        localIndentingWriter.write(10);
      }
      localIndentingWriter.flush();
      return paramString1.toString();
    }
    catch (IOException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    paramString1 = TwoColumnOutput.toString(paramString1, j, this.separator, paramString2, i);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.BaseDumper
 * JD-Core Version:    0.7.0.1
 */