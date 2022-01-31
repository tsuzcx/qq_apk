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

public class azsb
  extends DefaultHandler
  implements azqs
{
  azsa jdField_a_of_type_Azsa;
  private String jdField_a_of_type_JavaLangString;
  Stack<azsa> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AbsStructMsg a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Azsa == null) {}
    label161:
    for (;;)
    {
      return localObject1;
      if (this.jdField_a_of_type_Azsa.a() > 0) {}
      for (Object localObject2 = this.jdField_a_of_type_Azsa.a(0);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label161;
        }
        int i = Integer.parseInt(this.jdField_a_of_type_Azsa.a("serviceID"));
        if (i == 2) {
          return new StructMsgForAudioShare(this.jdField_a_of_type_Azsa);
        }
        if ((i == 3) || (i == 82) || (i == 120)) {
          return new StructMsgForHypertext(this.jdField_a_of_type_Azsa, i);
        }
        if ((i == 5) || (i == 137)) {
          return new StructMsgForImageShare(this.jdField_a_of_type_Azsa);
        }
        if (i == 150)
        {
          localObject2 = new StructMsgSubImageVideo(this.jdField_a_of_type_Azsa);
          localObject1 = localObject2;
          if (((StructMsgSubImageVideo)localObject2).isValid()) {
            break;
          }
        }
        return new StructMsgForGeneralShare(this.jdField_a_of_type_Azsa);
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
    azsa localazsa;
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      localazsa = (azsa)this.jdField_a_of_type_JavaUtilStack.peek();
      if (localazsa != null) {
        if (localazsa.jdField_a_of_type_JavaLangString != null) {
          break label81;
        }
      }
    }
    for (;;)
    {
      localazsa.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      localazsa.jdField_a_of_type_JavaLangString = bahu.b(localazsa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b);
      return;
      label81:
      paramArrayOfChar = localazsa.jdField_a_of_type_JavaLangString.concat(paramArrayOfChar);
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
      paramString1 = (azsa)this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        this.jdField_a_of_type_Azsa = paramString1;
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
      localHashMap.put(paramAttributes.getLocalName(i), bahu.b(paramAttributes.getValue(i), this.jdField_a_of_type_JavaLangString, this.b));
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StructMsg", 2, "StructMsgParserHandler startElement uri = " + paramString1 + ", localName = " + paramString2 + ", qName = " + paramString3 + ", map = " + localHashMap);
    }
    paramString1 = new azsa(paramString2, localHashMap);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString2 = (azsa)this.jdField_a_of_type_JavaUtilStack.peek();
      if (paramString2 != null)
      {
        paramString1.jdField_a_of_type_Azsa = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsb
 * JD-Core Version:    0.7.0.1
 */