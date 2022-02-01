import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class apeo
  extends apeh
{
  public Boolean a;
  public ArrayList<apcd> a;
  public Boolean b;
  public String b;
  public String c;
  public int d = 3;
  public int e = 1;
  
  public apeo(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, ArrayList<apcd> paramArrayList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    super(paramString1, paramInt1, 2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = paramBoolean1;
    this.jdField_b_of_type_JavaLangBoolean = paramBoolean2;
    this.e = paramInt4;
    this.d = paramInt5;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public apcd a()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromRandFunction");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      apcd localapcd = (apcd)localIterator.next();
      if (localapcd.b == 3) {
        localArrayList.add(localapcd);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return (apcd)localArrayList.get(new Random().nextInt(localArrayList.size()));
  }
  
  public apcd a(int paramInt)
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromClickOperation");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      apcd localapcd = (apcd)localIterator.next();
      if ((paramInt <= localapcd.d) && (paramInt >= localapcd.jdField_c_of_type_Int) && (localapcd.b == 1)) {
        return localapcd;
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      return null;
    }
    return ((apcd)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((apcd)localIterator.next()).b == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public apcd b()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromTime");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    int i = Calendar.getInstance().get(11);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      apcd localapcd = (apcd)localIterator.next();
      if ((i < localapcd.d) && (i >= localapcd.jdField_c_of_type_Int) && (localapcd.b == 2)) {
        return localapcd;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeo
 * JD-Core Version:    0.7.0.1
 */