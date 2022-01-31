import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;

public class axau
{
  public int a;
  public Object a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<String> b;
  public boolean b;
  public String c;
  public ArrayList<String> c;
  public boolean c;
  public boolean d;
  
  public axau()
  {
    this.jdField_a_of_type_Int = -99999;
    this.jdField_b_of_type_Int = -99999;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static axau a(axau paramaxau)
  {
    if (paramaxau == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clone() return, backData == null.");
      }
      return null;
    }
    axau localaxau = new axau();
    localaxau.jdField_a_of_type_JavaLangString = paramaxau.jdField_a_of_type_JavaLangString;
    localaxau.jdField_a_of_type_Int = paramaxau.jdField_a_of_type_Int;
    localaxau.jdField_b_of_type_JavaLangString = paramaxau.jdField_b_of_type_JavaLangString;
    localaxau.jdField_c_of_type_JavaLangString = paramaxau.jdField_c_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    if (paramaxau.jdField_a_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramaxau.jdField_a_of_type_JavaUtilArrayList);
    }
    localaxau.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (paramaxau.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramaxau.jdField_b_of_type_JavaUtilArrayList);
    }
    localaxau.jdField_b_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (paramaxau.jdField_c_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramaxau.jdField_c_of_type_JavaUtilArrayList);
    }
    localaxau.jdField_c_of_type_JavaUtilArrayList = localArrayList;
    localaxau.jdField_a_of_type_JavaLangObject = paramaxau.jdField_a_of_type_JavaLangObject;
    localaxau.jdField_b_of_type_Int = paramaxau.jdField_b_of_type_Int;
    localaxau.jdField_a_of_type_Boolean = paramaxau.jdField_a_of_type_Boolean;
    localaxau.jdField_b_of_type_Boolean = paramaxau.jdField_b_of_type_Boolean;
    localaxau.jdField_c_of_type_Boolean = paramaxau.jdField_c_of_type_Boolean;
    localaxau.d = paramaxau.d;
    return localaxau;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.addNewUin subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
    } while (this.jdField_b_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(oidb_0x7a2.RspBody paramRspBody, ArrayList<String> paramArrayList)
  {
    if (paramRspBody == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      for (;;)
      {
        if ((paramRspBody.uint64_bind_uin.has()) && (paramRspBody.uint64_bind_uin.get() > 10000L))
        {
          this.jdField_c_of_type_JavaLangString = Long.toString(paramRspBody.uint64_bind_uin.get());
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangString);
        }
        if (!paramRspBody.uint64_multi_bind_uin.has()) {
          break;
        }
        paramRspBody = paramRspBody.uint64_multi_bind_uin.get();
        if (paramRspBody == null) {
          break;
        }
        paramRspBody = paramRspBody.iterator();
        while (paramRspBody.hasNext())
        {
          Object localObject = (Long)paramRspBody.next();
          if (((Long)localObject).longValue() > 10000L)
          {
            localObject = Long.toString(((Long)localObject).longValue());
            if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
            if (this.jdField_c_of_type_JavaLangString == null) {
              this.jdField_c_of_type_JavaLangString = ((String)localObject);
            }
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramRspBody = paramArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          paramArrayList = (String)paramRspBody.next();
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramArrayList)) {
            this.jdField_c_of_type_JavaUtilArrayList.add(paramArrayList);
          }
          this.jdField_b_of_type_JavaUtilArrayList.remove(paramArrayList);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=" + String.valueOf(this.jdField_b_of_type_JavaUtilArrayList) + " overdue SubUins=" + String.valueOf(this.jdField_c_of_type_JavaUtilArrayList));
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_c_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList<String> c()
  {
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
      return localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
      }
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axau
 * JD-Core Version:    0.7.0.1
 */