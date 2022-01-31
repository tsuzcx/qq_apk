import java.util.ArrayList;
import java.util.List;

public abstract class axaw
{
  public float a;
  public int a;
  public axax a;
  public axba a;
  public String a;
  protected List<axbe> a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public int d;
  public float e;
  protected int e;
  public float f;
  protected int f;
  public float g;
  
  public axaw()
  {
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 255;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public float a()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public abstract axbc a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(axax paramaxax)
  {
    this.jdField_a_of_type_Axax = paramaxax;
  }
  
  public void a(axbd paramaxbd)
  {
    float f1 = this.jdField_c_of_type_Float;
    float f3 = this.jdField_d_of_type_Float;
    float f2;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      f2 = f3;
      switch (this.jdField_c_of_type_Int)
      {
      default: 
        f2 = f3;
      }
      break;
    }
    for (;;)
    {
      for (axaw localaxaw = (axaw)this.jdField_a_of_type_Axba; localaxaw != null; localaxaw = (axaw)localaxaw.jdField_a_of_type_Axba)
      {
        f1 += localaxaw.jdField_c_of_type_Float;
        f2 += localaxaw.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    paramaxbd.jdField_a_of_type_Float = f1;
    paramaxbd.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(axbe... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      axbe localaxbe = paramVarArgs[i];
      localaxbe.a();
      this.jdField_a_of_type_JavaUtilList.add(localaxbe);
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public float b()
  {
    float f1 = 1.0F;
    for (axaw localaxaw = (axaw)this.jdField_a_of_type_Axba; localaxaw != null; localaxaw = (axaw)localaxaw.jdField_a_of_type_Axba) {
      f1 *= localaxaw.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (axaw localaxaw = (axaw)this.jdField_a_of_type_Axba; localaxaw != null; localaxaw = (axaw)localaxaw.jdField_a_of_type_Axba) {
      f1 *= localaxaw.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((axbe)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
  }
  
  public void b(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean b()
  {
    int i = 0;
    boolean bool1 = false;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      axbe localaxbe = (axbe)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaxbe.a())
      {
        if ((localaxbe.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localaxbe.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localaxbe.jdField_b_of_type_Float;
        }
        if ((localaxbe.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localaxbe.jdField_c_of_type_Float;
        }
        if ((localaxbe.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localaxbe.jdField_a_of_type_Int;
        }
        if ((localaxbe.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localaxbe.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localaxbe.jdField_b_of_type_Boolean)
      {
        if (!localaxbe.jdField_a_of_type_Boolean) {
          break label161;
        }
        localaxbe.a();
      }
      for (j = i;; j = i - 1)
      {
        i = j + 1;
        break;
        label161:
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Axax != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Axax.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Axax.jdField_a_of_type_ArrayOfAxay.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Axax.jdField_a_of_type_ArrayOfAxay[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Axax.jdField_a_of_type_ArrayOfAxay[i].jdField_b_of_type_Float;
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((axbe)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
  }
  
  public void c(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void e(float paramFloat)
  {
    this.jdField_f_of_type_Float = paramFloat;
  }
  
  public int g_()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axaw
 * JD-Core Version:    0.7.0.1
 */