import java.util.ArrayList;
import java.util.List;

public abstract class ayba
{
  public float a;
  public int a;
  public aybb a;
  public aybe a;
  public String a;
  protected List<aybi> a;
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
  
  public ayba()
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
  
  public abstract aybg a();
  
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
  
  public void a(aybb paramaybb)
  {
    this.jdField_a_of_type_Aybb = paramaybb;
  }
  
  public void a(aybh paramaybh)
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
      for (ayba localayba = (ayba)this.jdField_a_of_type_Aybe; localayba != null; localayba = (ayba)localayba.jdField_a_of_type_Aybe)
      {
        f1 += localayba.jdField_c_of_type_Float;
        f2 += localayba.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    paramaybh.jdField_a_of_type_Float = f1;
    paramaybh.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(aybi... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      aybi localaybi = paramVarArgs[i];
      localaybi.a();
      this.jdField_a_of_type_JavaUtilList.add(localaybi);
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
    for (ayba localayba = (ayba)this.jdField_a_of_type_Aybe; localayba != null; localayba = (ayba)localayba.jdField_a_of_type_Aybe) {
      f1 *= localayba.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (ayba localayba = (ayba)this.jdField_a_of_type_Aybe; localayba != null; localayba = (ayba)localayba.jdField_a_of_type_Aybe) {
      f1 *= localayba.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((aybi)this.jdField_a_of_type_JavaUtilList.get(i)).c();
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
      aybi localaybi = (aybi)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaybi.a())
      {
        if ((localaybi.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localaybi.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localaybi.jdField_b_of_type_Float;
        }
        if ((localaybi.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localaybi.jdField_c_of_type_Float;
        }
        if ((localaybi.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localaybi.jdField_a_of_type_Int;
        }
        if ((localaybi.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localaybi.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localaybi.jdField_b_of_type_Boolean)
      {
        if (!localaybi.jdField_a_of_type_Boolean) {
          break label161;
        }
        localaybi.a();
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
    if (this.jdField_a_of_type_Aybb != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Aybb.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Aybb.jdField_a_of_type_ArrayOfAybc.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Aybb.jdField_a_of_type_ArrayOfAybc[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Aybb.jdField_a_of_type_ArrayOfAybc[i].jdField_b_of_type_Float;
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
      ((aybi)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
 * Qualified Name:     ayba
 * JD-Core Version:    0.7.0.1
 */