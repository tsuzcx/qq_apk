import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class awew
  extends DefaultHandler
{
  private SparseArray<awbm> jdField_a_of_type_AndroidUtilSparseArray;
  private awbm jdField_a_of_type_Awbm;
  private awen jdField_a_of_type_Awen;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<awen> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Stack<awbm> jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<Integer> b;
  private ArrayList<awbm> c;
  
  public awew()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("StateList", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("SubStateList", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("RichState", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionId", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("Display", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionName", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("Describe", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("IconURL", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("TinyIcon", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("Type", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilHashMap.put("Parameter", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("DataURL", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilHashMap.put("CoverURL", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeList", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilHashMap.put("ListParam", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeDetail", Integer.valueOf(16));
    this.jdField_a_of_type_JavaUtilHashMap.put("DetailParam", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilHashMap.put("Tags", Integer.valueOf(18));
    this.jdField_a_of_type_JavaUtilHashMap.put("StateTag", Integer.valueOf(19));
    this.jdField_a_of_type_JavaUtilHashMap.put("TagName", Integer.valueOf(20));
    this.jdField_a_of_type_JavaUtilHashMap.put("IdList", Integer.valueOf(21));
    this.jdField_a_of_type_JavaUtilHashMap.put("Action_id", Integer.valueOf(22));
  }
  
  public SparseArray<awbm> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public ArrayList<awen> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (awen)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((awen)localObject).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = ((awen)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          int j = ((Integer)((Iterator)localObject).next()).intValue();
          awbm localawbm = (awbm)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
          if ((localawbm != null) && (localawbm.jdField_b_of_type_Int == 2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RichStatus", 2, "filter xml name = " + localawbm.c);
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      i += 1;
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = false;
    paramString1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    paramString2 = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    if (paramString2 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramString2.intValue())
            {
            case 18: 
            case 19: 
            case 21: 
            default: 
              return;
            case 1: 
            case 2: 
              this.jdField_a_of_type_Awbm = ((awbm)this.jdField_a_of_type_JavaUtilStack.pop());
              if (this.c.size() == 0) {
                this.jdField_a_of_type_Awbm.jdField_a_of_type_JavaUtilArrayList = null;
              }
              break;
            }
          } while (this.jdField_a_of_type_JavaUtilStack.size() <= 0);
          this.c = ((awbm)this.jdField_a_of_type_JavaUtilStack.lastElement()).jdField_a_of_type_JavaUtilArrayList;
          return;
        } while (this.jdField_a_of_type_Awbm.jdField_a_of_type_Int == 0);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Awbm.jdField_a_of_type_Int, this.jdField_a_of_type_Awbm);
        if (this.jdField_a_of_type_Awbm.jdField_a_of_type_Boolean) {
          this.c.add(this.jdField_a_of_type_Awbm);
        }
        this.jdField_a_of_type_Awbm = null;
        return;
        try
        {
          this.jdField_a_of_type_Awbm.jdField_a_of_type_Int = Integer.parseInt(paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, paramString1.toString() + ", " + paramString1.getStackTrace().toString());
      return;
      this.jdField_a_of_type_Awbm.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramString1);
      return;
      this.jdField_a_of_type_Awbm.c = paramString1;
      return;
      this.jdField_a_of_type_Awbm.jdField_a_of_type_JavaLangString = paramString1;
      return;
      this.jdField_a_of_type_Awbm.jdField_b_of_type_JavaLangString = paramString1;
      return;
      if ("0".equals(paramString1))
      {
        this.jdField_a_of_type_Awbm.jdField_b_of_type_Int = 4;
        return;
      }
      if ("1".equals(paramString1))
      {
        this.jdField_a_of_type_Awbm.jdField_b_of_type_Int = 3;
        return;
      }
      if ("2".equals(paramString1))
      {
        this.jdField_a_of_type_Awbm.jdField_b_of_type_Int = 2;
        return;
      }
    } while (!"4".equals(paramString1));
    this.jdField_a_of_type_Awbm.jdField_b_of_type_Int = 5;
    return;
    this.jdField_a_of_type_Awbm.d = paramString1;
    return;
    this.jdField_a_of_type_Awbm.e = paramString1;
    return;
    this.jdField_a_of_type_Awbm.f = paramString1;
    return;
    this.jdField_a_of_type_Awbm.g = paramString1;
    return;
    this.jdField_a_of_type_Awbm.h = paramString1;
    return;
    this.jdField_a_of_type_Awbm.i = paramString1;
    return;
    this.jdField_a_of_type_Awbm.j = paramString1;
    return;
    this.jdField_a_of_type_Awbm.k = paramString1;
    return;
    this.jdField_a_of_type_Awen.jdField_a_of_type_JavaLangString = paramString1;
    return;
    this.b.add(Integer.valueOf(Integer.parseInt(paramString1)));
  }
  
  public void startDocument()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Awen = new awen();
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_a_of_type_Awbm = new awbm(-1);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(-1, this.jdField_a_of_type_Awbm);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangStringBuilder.replace(0, this.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    if (("StateList".equals(paramString2)) || ("SubStateList".equals(paramString2)))
    {
      this.c = new ArrayList();
      this.jdField_a_of_type_Awbm.jdField_a_of_type_JavaUtilArrayList = this.c;
      this.jdField_a_of_type_JavaUtilStack.push(this.jdField_a_of_type_Awbm);
    }
    do
    {
      return;
      if ("RichState".equals(paramString2))
      {
        this.jdField_a_of_type_Awbm = new awbm(-1);
        return;
      }
      if ("StateTag".equals(paramString2))
      {
        this.jdField_a_of_type_Awen = new awen();
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Awen);
        return;
      }
    } while (!"IdList".equals(paramString2));
    this.b = new ArrayList();
    this.jdField_a_of_type_Awen.jdField_a_of_type_JavaUtilArrayList = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awew
 * JD-Core Version:    0.7.0.1
 */