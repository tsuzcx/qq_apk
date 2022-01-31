import java.util.ArrayList;
import java.util.List;

public abstract class azyx
{
  public float a;
  public int a;
  public azyy a;
  public azzb a;
  public String a;
  protected List<azzf> a;
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
  
  public azyx()
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
  
  public abstract azzd a();
  
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
  
  public void a(azyy paramazyy)
  {
    this.jdField_a_of_type_Azyy = paramazyy;
  }
  
  public void a(azze paramazze)
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
      for (azyx localazyx = (azyx)this.jdField_a_of_type_Azzb; localazyx != null; localazyx = (azyx)localazyx.jdField_a_of_type_Azzb)
      {
        f1 += localazyx.jdField_c_of_type_Float;
        f2 += localazyx.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    paramazze.jdField_a_of_type_Float = f1;
    paramazze.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(azzf... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      azzf localazzf = paramVarArgs[i];
      localazzf.a();
      this.jdField_a_of_type_JavaUtilList.add(localazzf);
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
    for (azyx localazyx = (azyx)this.jdField_a_of_type_Azzb; localazyx != null; localazyx = (azyx)localazyx.jdField_a_of_type_Azzb) {
      f1 *= localazyx.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (azyx localazyx = (azyx)this.jdField_a_of_type_Azzb; localazyx != null; localazyx = (azyx)localazyx.jdField_a_of_type_Azzb) {
      f1 *= localazyx.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((azzf)this.jdField_a_of_type_JavaUtilList.get(i)).c();
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
      azzf localazzf = (azzf)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localazzf.a())
      {
        if ((localazzf.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localazzf.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localazzf.jdField_b_of_type_Float;
        }
        if ((localazzf.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localazzf.jdField_c_of_type_Float;
        }
        if ((localazzf.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localazzf.jdField_a_of_type_Int;
        }
        if ((localazzf.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localazzf.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localazzf.jdField_b_of_type_Boolean)
      {
        if (!localazzf.jdField_a_of_type_Boolean) {
          break label161;
        }
        localazzf.a();
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
    if (this.jdField_a_of_type_Azyy != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Azyy.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Azyy.jdField_a_of_type_ArrayOfAzyz.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Azyy.jdField_a_of_type_ArrayOfAzyz[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Azyy.jdField_a_of_type_ArrayOfAzyz[i].jdField_b_of_type_Float;
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
      ((azzf)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyx
 * JD-Core Version:    0.7.0.1
 */