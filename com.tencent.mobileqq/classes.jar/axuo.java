import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class axuo
  implements XmlSerializer
{
  XmlSerializer jdField_a_of_type_OrgXmlpullV1XmlSerializer;
  
  public axuo(AbsStructMsg paramAbsStructMsg, XmlSerializer paramXmlSerializer)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = paramXmlSerializer;
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.attribute(paramString1, paramString2, paramString3);
  }
  
  public void cdsect(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.cdsect(paramString);
  }
  
  public void comment(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.comment(paramString);
  }
  
  public void docdecl(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.docdecl(paramString);
  }
  
  public void endDocument()
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endDocument();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endTag(paramString1, paramString2);
  }
  
  public void entityRef(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.entityRef(paramString);
  }
  
  public void flush()
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.flush();
  }
  
  public int getDepth()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getDepth();
  }
  
  public boolean getFeature(String paramString)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getFeature(paramString);
  }
  
  public String getName()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getName();
  }
  
  public String getNamespace()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getNamespace();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getPrefix(paramString, paramBoolean);
  }
  
  public Object getProperty(String paramString)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.getProperty(paramString);
  }
  
  public void ignorableWhitespace(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.ignorableWhitespace(paramString);
  }
  
  public void processingInstruction(String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.processingInstruction(paramString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setFeature(paramString, paramBoolean);
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(paramOutputStream, paramString);
  }
  
  public void setOutput(Writer paramWriter)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(paramWriter);
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setPrefix(paramString1, paramString2);
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setProperty(paramString, paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startDocument(paramString, paramBoolean);
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startTag(paramString1, paramString2);
  }
  
  public XmlSerializer text(String paramString)
  {
    if (paramString != null) {
      try
      {
        XmlSerializer localXmlSerializer = this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.text(axau.a(paramString, false));
        return localXmlSerializer;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "XmlSerializer . text  IllegalArgumentException。。。。。");
        }
      }
    }
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.text(paramString);
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.text(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axuo
 * JD-Core Version:    0.7.0.1
 */