import android.app.Activity;
import java.util.ArrayList;

public class bohn
{
  int jdField_a_of_type_Int;
  public long a;
  public bohz a;
  public boic a;
  public boij a;
  bois jdField_a_of_type_Bois;
  ArrayList<bohe> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bohn(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bpjt.a().b(null, null, this.jdField_a_of_type_Int);
    bpjt.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boic = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bohz != null) && (this.jdField_a_of_type_Bohz.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bohz.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bohz.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boic != null)
    {
      this.jdField_a_of_type_Boic.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boic.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bohz parambohz)
  {
    this.jdField_a_of_type_Bohz = parambohz;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(boic paramboic)
  {
    this.jdField_a_of_type_Boic = paramboic;
    this.b = System.currentTimeMillis();
  }
  
  public void a(boij paramboij)
  {
    this.jdField_a_of_type_Boij = paramboij;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boic == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bpjt.a().a(this.jdField_a_of_type_Int);
    bpjt.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bohz localbohz = bpjt.a().a[this.jdField_a_of_type_Int];
    if (localbohz != null) {
      localbohz.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bpjt.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bpjt.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bohz = null;
    this.jdField_a_of_type_Boic = null;
    this.jdField_a_of_type_Bois = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohn
 * JD-Core Version:    0.7.0.1
 */