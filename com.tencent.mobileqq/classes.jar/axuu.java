import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

public class axuu
  implements XmlSerializer
{
  private int jdField_a_of_type_Int;
  private BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[12];
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[4];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = new String[8];
  
  private final String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2 - 2;
    Object localObject;
    int j;
    if (i >= 0) {
      if ((this.jdField_b_of_type_ArrayOfJavaLangString[(i + 1)].equals(paramString)) && ((paramBoolean1) || (this.jdField_b_of_type_ArrayOfJavaLangString[i].length() != 0)))
      {
        localObject = this.jdField_b_of_type_ArrayOfJavaLangString[i];
        j = i + 2;
        label70:
        if (j >= this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2) {
          break label275;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[j].equals(localObject)) {
          localObject = null;
        }
      }
    }
    label275:
    for (;;)
    {
      if (localObject != null)
      {
        return localObject;
        j += 1;
        break label70;
      }
      i -= 2;
      break;
      if (!paramBoolean2) {
        return null;
      }
      if (paramString.length() == 0)
      {
        localObject = "";
        paramBoolean1 = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = false;
        setPrefix((String)localObject, paramString);
        this.jdField_a_of_type_Boolean = paramBoolean1;
        return localObject;
      }
      label174:
      localObject = new StringBuilder().append("n");
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      String str = i;
      i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2 - 2;
      for (;;)
      {
        localObject = str;
        if (i >= 0)
        {
          if (str.equals(this.jdField_b_of_type_ArrayOfJavaLangString[i])) {
            localObject = null;
          }
        }
        else
        {
          if (localObject == null) {
            break label174;
          }
          break;
        }
        i -= 2;
      }
    }
  }
  
  private static void a(char paramChar)
  {
    throw new IllegalArgumentException("Illegal character (" + Integer.toHexString(paramChar) + ")");
  }
  
  private final void a(String paramString, int paramInt)
  {
    int i = 0;
    if (i < paramString.length())
    {
      int k = paramString.charAt(i);
      String str;
      switch (k)
      {
      default: 
        if (k == paramInt)
        {
          BufferedWriter localBufferedWriter = this.jdField_a_of_type_JavaIoBufferedWriter;
          if (k == 34)
          {
            str = "&quot;";
            label99:
            localBufferedWriter.write(str);
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == -1)
        {
          this.jdField_a_of_type_JavaIoBufferedWriter.write(k);
        }
        else
        {
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&#" + k + ';');
          continue;
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&amp;");
          continue;
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&gt;");
          continue;
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&lt;");
          continue;
          str = "&apos;";
          break label99;
          if (((k >= 32) && (k <= 55295)) || ((k >= 57344) && (k <= 65533))) {}
          for (int j = 1;; j = 0)
          {
            if ((j == 0) && ((!this.jdField_b_of_type_Boolean) && (k >= 127))) {
              break label276;
            }
            this.jdField_a_of_type_JavaIoBufferedWriter.write(k);
            break;
          }
          label276:
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&#" + k + ";");
        }
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfBoolean.length <= this.jdField_b_of_type_Int)
    {
      localObject = new boolean[this.jdField_b_of_type_Int + 4];
      System.arraycopy(this.jdField_a_of_type_ArrayOfBoolean, 0, localObject, 0, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ArrayOfBoolean = ((boolean[])localObject);
    }
    this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] = this.jdField_a_of_type_ArrayOfBoolean[(this.jdField_b_of_type_Int - 1)];
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int - 1)];
    if (i < this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int])
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write(32);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("xmlns");
      if (this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2)].length() != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2)]);
      }
      while ((getNamespace() == null) || (getNamespace().length() != 0) || (this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2 + 1)].length() == 0))
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write("=\"");
        a(this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2 + 1)], 34);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(34);
        i += 1;
        break;
      }
      throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
    }
    if (this.jdField_a_of_type_ArrayOfInt.length <= this.jdField_b_of_type_Int + 1)
    {
      localObject = new int[this.jdField_b_of_type_Int + 8];
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localObject, 0, this.jdField_b_of_type_Int + 1);
      this.jdField_a_of_type_ArrayOfInt = ((int[])localObject);
    }
    this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] = this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
    BufferedWriter localBufferedWriter = this.jdField_a_of_type_JavaIoBufferedWriter;
    if (paramBoolean) {}
    for (Object localObject = " />";; localObject = ">")
    {
      localBufferedWriter.write((String)localObject);
      return;
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("illegal position for attribute");
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if (str.length() == 0)
    {
      paramString1 = "";
      this.jdField_a_of_type_JavaIoBufferedWriter.write(32);
      if (paramString1.length() != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString1);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(61);
      if (paramString3.indexOf('"') != -1) {
        break label142;
      }
    }
    label142:
    for (int i = 34;; i = 39)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write(i);
      a(paramString3, i);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(i);
      return this;
      paramString1 = a(str, false, true);
      break;
    }
  }
  
  public void cdsect(String paramString)
  {
    a(false);
    paramString = paramString.replace("]]>", "]]]]><![CDATA[>").toCharArray();
    int m = paramString.length;
    int j = 0;
    if (j < m)
    {
      int i = paramString[j];
      if (((i >= 32) && (i <= 55295)) || (i == 9) || (i == 10) || (i == 13) || ((i >= 57344) && (i <= 65533))) {}
      for (int k = 1;; k = 0)
      {
        if (k == 0) {
          a(i);
        }
        j += 1;
        break;
      }
    }
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<![CDATA[");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString, 0, paramString.length);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("]]>");
  }
  
  public void comment(String paramString)
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<!--");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("-->");
  }
  
  public void docdecl(String paramString)
  {
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<!DOCTYPE");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(">");
  }
  
  public void endDocument()
  {
    while (this.jdField_b_of_type_Int > 0) {
      endTag(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 - 3)], this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Int -= 1;
    }
    if (((paramString1 == null) && (this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3)] != null)) || ((paramString1 != null) && (!paramString1.equals(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3)]))) || (!this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 + 2)].equals(paramString2))) {
      throw new IllegalArgumentException("</{" + paramString1 + "}" + paramString2 + "> does not match start");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(true);
      this.jdField_b_of_type_Int -= 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] = this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
      return this;
      if (this.jdField_a_of_type_ArrayOfBoolean[(this.jdField_b_of_type_Int + 1)] != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write("\r\n");
        int i = 0;
        while (i < this.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_JavaIoBufferedWriter.write("  ");
          i += 1;
        }
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write("</");
      paramString1 = this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 + 1)];
      if (paramString1.length() != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString1);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(62);
    }
  }
  
  public void entityRef(String paramString)
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(38);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(59);
  }
  
  public void flush()
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.flush();
  }
  
  public int getDepth()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Int + 1;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = a(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<?");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("os == null");
    }
    if (paramString == null) {}
    for (paramOutputStream = new OutputStreamWriter(paramOutputStream);; paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString))
    {
      setOutput(paramOutputStream);
      this.jdField_a_of_type_JavaLangString = paramString;
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("utf"))) {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    if ((paramWriter instanceof BufferedWriter)) {}
    for (this.jdField_a_of_type_JavaIoBufferedWriter = ((BufferedWriter)paramWriter);; this.jdField_a_of_type_JavaIoBufferedWriter = new BufferedWriter(paramWriter, 500))
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 2;
      this.jdField_a_of_type_ArrayOfInt[1] = 2;
      this.jdField_b_of_type_ArrayOfJavaLangString[0] = "";
      this.jdField_b_of_type_ArrayOfJavaLangString[1] = "";
      this.jdField_b_of_type_ArrayOfJavaLangString[2] = "xml";
      this.jdField_b_of_type_ArrayOfJavaLangString[3] = "http://www.w3.org/XML/1998/namespace";
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    a(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(a(paramString1, true, false))) {
      return;
    }
    paramString2 = this.jdField_a_of_type_ArrayOfInt;
    int i = this.jdField_b_of_type_Int + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    if (this.jdField_b_of_type_ArrayOfJavaLangString.length < i + 1)
    {
      paramString2 = new String[this.jdField_b_of_type_ArrayOfJavaLangString.length + 16];
      System.arraycopy(this.jdField_b_of_type_ArrayOfJavaLangString, 0, paramString2, 0, i);
      this.jdField_b_of_type_ArrayOfJavaLangString = paramString2;
    }
    this.jdField_b_of_type_ArrayOfJavaLangString[i] = str;
    this.jdField_b_of_type_ArrayOfJavaLangString[(i + 1)] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new RuntimeException("Unsupported Property:" + paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if (paramString.toLowerCase(Locale.US).startsWith("utf")) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("encoding='");
      this.jdField_a_of_type_JavaIoBufferedWriter.write(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("' ");
    }
    BufferedWriter localBufferedWriter;
    if (paramBoolean != null)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("standalone='");
      localBufferedWriter = this.jdField_a_of_type_JavaIoBufferedWriter;
      if (!paramBoolean.booleanValue()) {
        break label133;
      }
    }
    label133:
    for (paramString = "yes";; paramString = "no")
    {
      localBufferedWriter.write(paramString);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("' ");
      this.jdField_a_of_type_JavaIoBufferedWriter.write("?>");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    a(false);
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] != 0)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("\r\n");
      i = 0;
      while (i < this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write("  ");
        i += 1;
      }
    }
    int j = this.jdField_b_of_type_Int * 3;
    Object localObject;
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length < j + 3)
    {
      localObject = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length + 12];
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangString, 0, localObject, 0, j);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
    }
    if (paramString1 == null)
    {
      localObject = "";
      if ((paramString1 != null) && (paramString1.length() == 0)) {
        i = this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
      }
    }
    else
    {
      for (;;)
      {
        if (i >= this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)]) {
          break label207;
        }
        if ((this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2)].length() == 0) && (this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2 + 1)].length() != 0))
        {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
          localObject = a(paramString1, true, true);
          break;
        }
        i += 1;
      }
    }
    label207:
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    this.jdField_a_of_type_ArrayOfJavaLangString[i] = localObject;
    this.jdField_a_of_type_ArrayOfJavaLangString[(i + 1)] = paramString2;
    this.jdField_a_of_type_JavaIoBufferedWriter.write(60);
    if (((String)localObject).length() != 0)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write((String)localObject);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
    }
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    a(false);
    this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] = false;
    a(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axuu
 * JD-Core Version:    0.7.0.1
 */