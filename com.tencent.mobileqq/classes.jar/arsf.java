import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class arsf
  extends DefaultHandler
{
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  Stack<Object> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public HashMap<String, Object> a()
  {
    return (HashMap)this.jdField_a_of_type_JavaLangObject;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    System.out.println("characters:");
    if (paramInt2 > 0)
    {
      if (this.b)
      {
        this.jdField_a_of_type_JavaLangString = new String(paramArrayOfChar, paramInt1, paramInt2);
        System.out.println("key:" + this.jdField_a_of_type_JavaLangString);
      }
      if (this.c)
      {
        if (!HashMap.class.equals(this.jdField_a_of_type_JavaUtilStack.peek().getClass())) {
          break label157;
        }
        HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilStack.peek();
        String str = new String(paramArrayOfChar, paramInt1, paramInt2);
        localHashMap.put(this.jdField_a_of_type_JavaLangString, str);
      }
    }
    for (;;)
    {
      System.out.println("value:" + new String(paramArrayOfChar, paramInt1, paramInt2));
      return;
      label157:
      if (ArrayList.class.equals(this.jdField_a_of_type_JavaUtilStack.peek().getClass())) {
        ((ArrayList)this.jdField_a_of_type_JavaUtilStack.peek()).add(new String(paramArrayOfChar, paramInt1, paramInt2));
      }
    }
  }
  
  public void endDocument()
  {
    System.out.println(alud.a(2131704943));
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ((!"plist".equals(paramString3)) || ("key".equals(paramString3))) {
      this.b = false;
    }
    if ("string".equals(paramString3)) {
      this.c = false;
    }
    if ("integer".equals(paramString3)) {
      this.c = false;
    }
    if ("array".equals(paramString3)) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
    }
    if ("dict".equals(paramString3)) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
    }
  }
  
  public void startDocument()
  {
    System.out.println(alud.a(2131704932));
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    boolean bool2 = false;
    if ("plist".equals(paramString3)) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool1;
    if ("dict".equals(paramString3))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label228;
      }
      this.jdField_a_of_type_JavaUtilStack.push(new HashMap());
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
    else
    {
      if ("key".equals(paramString3)) {
        this.b = true;
      }
      if ("true".equals(paramString3)) {
        ((HashMap)this.jdField_a_of_type_JavaUtilStack.peek()).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
      }
      if ("false".equals(paramString3)) {
        ((HashMap)this.jdField_a_of_type_JavaUtilStack.peek()).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
      }
      if ("array".equals(paramString3))
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label295;
        }
        paramString1 = new ArrayList();
        this.jdField_a_of_type_JavaUtilStack.push(paramString1);
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean) {
          bool1 = true;
        }
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
    for (;;)
    {
      if ("string".equals(paramString3)) {
        this.c = true;
      }
      if ("integer".equals(paramString3)) {
        this.c = true;
      }
      return;
      bool1 = false;
      break;
      label228:
      paramString1 = this.jdField_a_of_type_JavaUtilStack.peek();
      paramString2 = new HashMap();
      if ((paramString1 instanceof ArrayList)) {
        ((ArrayList)paramString1).add(paramString2);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilStack.push(paramString2);
        break;
        if ((paramString1 instanceof HashMap)) {
          ((HashMap)paramString1).put(this.jdField_a_of_type_JavaLangString, paramString2);
        }
      }
      label295:
      paramString1 = (HashMap)this.jdField_a_of_type_JavaUtilStack.peek();
      paramString2 = new ArrayList();
      this.jdField_a_of_type_JavaUtilStack.push(paramString2);
      paramString1.put(this.jdField_a_of_type_JavaLangString, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsf
 * JD-Core Version:    0.7.0.1
 */