import java.util.ArrayList;
import java.util.List;

public abstract class bcqw
{
  public float a;
  public int a;
  public bcqx a;
  public bcra a;
  public String a;
  protected List<bcre> a;
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
  
  public bcqw()
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
  
  public abstract bcrc a();
  
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
  
  public void a(bcqx parambcqx)
  {
    this.jdField_a_of_type_Bcqx = parambcqx;
  }
  
  public void a(bcrd parambcrd)
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
      for (bcqw localbcqw = (bcqw)this.jdField_a_of_type_Bcra; localbcqw != null; localbcqw = (bcqw)localbcqw.jdField_a_of_type_Bcra)
      {
        f1 += localbcqw.jdField_c_of_type_Float;
        f2 += localbcqw.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    parambcrd.jdField_a_of_type_Float = f1;
    parambcrd.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bcre... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bcre localbcre = paramVarArgs[i];
      localbcre.a();
      this.jdField_a_of_type_JavaUtilList.add(localbcre);
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
    for (bcqw localbcqw = (bcqw)this.jdField_a_of_type_Bcra; localbcqw != null; localbcqw = (bcqw)localbcqw.jdField_a_of_type_Bcra) {
      f1 *= localbcqw.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (bcqw localbcqw = (bcqw)this.jdField_a_of_type_Bcra; localbcqw != null; localbcqw = (bcqw)localbcqw.jdField_a_of_type_Bcra) {
      f1 *= localbcqw.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((bcre)this.jdField_a_of_type_JavaUtilList.get(i)).c();
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
      bcre localbcre = (bcre)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbcre.a())
      {
        if ((localbcre.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localbcre.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localbcre.jdField_b_of_type_Float;
        }
        if ((localbcre.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localbcre.jdField_c_of_type_Float;
        }
        if ((localbcre.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localbcre.jdField_a_of_type_Int;
        }
        if ((localbcre.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localbcre.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localbcre.jdField_b_of_type_Boolean)
      {
        if (!localbcre.jdField_a_of_type_Boolean) {
          break label161;
        }
        localbcre.a();
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
    if (this.jdField_a_of_type_Bcqx != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Bcqx.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Bcqx.jdField_a_of_type_ArrayOfBcqy.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Bcqx.jdField_a_of_type_ArrayOfBcqy[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Bcqx.jdField_a_of_type_ArrayOfBcqy[i].jdField_b_of_type_Float;
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
      ((bcre)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
  
  public int h_()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqw
 * JD-Core Version:    0.7.0.1
 */