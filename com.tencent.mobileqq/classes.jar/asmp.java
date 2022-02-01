import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class asmp
{
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static asmp a(asne paramasne)
  {
    asmp localasmp = new asmp();
    localasmp.jdField_a_of_type_Long = paramasne.jdField_a_of_type_Long;
    localasmp.jdField_a_of_type_JavaLangString = paramasne.jdField_b_of_type_JavaLangString;
    localasmp.jdField_b_of_type_JavaLangString = paramasne.d;
    if (paramasne.jdField_a_of_type_Asmk != null)
    {
      localasmp.jdField_b_of_type_Long = paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_Long;
      Object localObject;
      if ((paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList != null) && (!paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (asnp)paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList.get(0);
        localasmp.d = ((asnp)localObject).jdField_a_of_type_JavaLangString;
        localasmp.jdField_c_of_type_Long = ((asnp)localObject).jdField_a_of_type_Long;
        localasmp.jdField_c_of_type_JavaLangString = ((asnp)localObject).jdField_b_of_type_JavaLangString;
      }
      localasmp.jdField_a_of_type_Int = paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int;
      localasmp.e = paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaLangString;
      localasmp.jdField_b_of_type_Int = paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_Int;
      if (paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localasmp.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          asno localasno = (asno)((Iterator)localObject).next();
          localasmp.jdField_a_of_type_JavaUtilArrayList.add(localasno.jdField_a_of_type_JavaLangString);
        }
      }
      localasmp.f = paramasne.jdField_a_of_type_Asmk.g;
      localasmp.g = paramasne.jdField_a_of_type_Asmk.h;
      localasmp.jdField_c_of_type_Int = paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_Int;
      localasmp.jdField_a_of_type_Int = paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int;
      localasmp.h = paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_JavaLangString;
      localasmp.i = paramasne.jdField_a_of_type_Asmk.f;
    }
    return localasmp;
  }
  
  public static asne a(asmp paramasmp)
  {
    asne localasne = new asne();
    localasne.jdField_b_of_type_JavaLangString = paramasmp.jdField_a_of_type_JavaLangString;
    localasne.jdField_b_of_type_Int = 0;
    localasne.jdField_a_of_type_Long = paramasmp.jdField_a_of_type_Long;
    localasne.d = paramasmp.jdField_b_of_type_JavaLangString;
    localasne.jdField_a_of_type_Asmk = new asmk();
    localasne.jdField_a_of_type_Asmk.jdField_a_of_type_Long = paramasmp.jdField_b_of_type_Long;
    localasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    Object localObject = new asnp(paramasmp.jdField_c_of_type_JavaLangString, paramasmp.d, paramasmp.jdField_c_of_type_Long);
    localasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    localasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaLangString = paramasmp.e;
    localasne.jdField_a_of_type_Asmk.jdField_a_of_type_Int = paramasmp.jdField_b_of_type_Int;
    if (paramasmp.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramasmp.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = paramasmp.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        asno localasno = new asno();
        localasno.jdField_a_of_type_JavaLangString = str;
        localasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList.add(localasno);
      }
    }
    localasne.jdField_a_of_type_Asmk.g = paramasmp.f;
    localasne.jdField_a_of_type_Asmk.jdField_b_of_type_Int = paramasmp.jdField_c_of_type_Int;
    localasne.jdField_a_of_type_Asmk.h = paramasmp.g;
    localasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int = paramasmp.jdField_a_of_type_Int;
    localasne.jdField_a_of_type_Asmk.jdField_c_of_type_JavaLangString = paramasmp.h;
    localasne.jdField_a_of_type_Asmk.f = paramasmp.i;
    return localasne;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Long == 2L;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmp
 * JD-Core Version:    0.7.0.1
 */