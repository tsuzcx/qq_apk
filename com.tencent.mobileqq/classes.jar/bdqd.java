import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class bdqd
  extends DefaultHandler
  implements bdou
{
  bdqc jdField_a_of_type_Bdqc;
  private String jdField_a_of_type_JavaLangString;
  Stack<bdqc> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AbsStructMsg a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Bdqc == null) {}
    label161:
    for (;;)
    {
      return localObject1;
      if (this.jdField_a_of_type_Bdqc.a() > 0) {}
      for (Object localObject2 = this.jdField_a_of_type_Bdqc.a(0);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label161;
        }
        int i = Integer.parseInt(this.jdField_a_of_type_Bdqc.a("serviceID"));
        if (i == 2) {
          return new StructMsgForAudioShare(this.jdField_a_of_type_Bdqc);
        }
        if ((i == 3) || (i == 82) || (i == 120)) {
          return new StructMsgForHypertext(this.jdField_a_of_type_Bdqc, i);
        }
        if ((i == 5) || (i == 137)) {
          return new StructMsgForImageShare(this.jdField_a_of_type_Bdqc);
        }
        if (i == 150)
        {
          localObject2 = new StructMsgSubImageVideo(this.jdField_a_of_type_Bdqc);
          localObject1 = localObject2;
          if (((StructMsgSubImageVideo)localObject2).isValid()) {
            break;
          }
        }
        return new StructMsgForGeneralShare(this.jdField_a_of_type_Bdqc);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    bdqc localbdqc;
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      localbdqc = (bdqc)this.jdField_a_of_type_JavaUtilStack.peek();
      if (localbdqc != null) {
        if (localbdqc.jdField_a_of_type_JavaLangString != null) {
          break label81;
        }
      }
    }
    for (;;)
    {
      localbdqc.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      localbdqc.jdField_a_of_type_JavaLangString = begd.b(localbdqc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b);
      return;
      label81:
      paramArrayOfChar = localbdqc.jdField_a_of_type_JavaLangString.concat(paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    this.jdField_a_of_type_JavaUtilStack.clear();
    this.jdField_a_of_type_JavaUtilStack = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString1 = (bdqc)this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        this.jdField_a_of_type_Bdqc = paramString1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.jdField_a_of_type_JavaLangString))) {
          paramString1.jdField_a_of_type_Int = 3;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      localHashMap.put(paramAttributes.getLocalName(i), begd.b(paramAttributes.getValue(i), this.jdField_a_of_type_JavaLangString, this.b));
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StructMsg", 2, "StructMsgParserHandler startElement uri = " + paramString1 + ", localName = " + paramString2 + ", qName = " + paramString3 + ", map = " + localHashMap);
    }
    paramString1 = new bdqc(paramString2, localHashMap);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString2 = (bdqc)this.jdField_a_of_type_JavaUtilStack.peek();
      if (paramString2 != null)
      {
        paramString1.jdField_a_of_type_Bdqc = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqd
 * JD-Core Version:    0.7.0.1
 */