import java.util.ArrayList;
import java.util.List;

public abstract class bdxf
{
  public float a;
  public int a;
  public bdxg a;
  public bdxj a;
  public String a;
  protected List<bdxn> a;
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
  
  public bdxf()
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
  
  public abstract bdxl a();
  
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
  
  public void a(bdxg parambdxg)
  {
    this.jdField_a_of_type_Bdxg = parambdxg;
  }
  
  public void a(bdxm parambdxm)
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
      for (bdxf localbdxf = (bdxf)this.jdField_a_of_type_Bdxj; localbdxf != null; localbdxf = (bdxf)localbdxf.jdField_a_of_type_Bdxj)
      {
        f1 += localbdxf.jdField_c_of_type_Float;
        f2 += localbdxf.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    parambdxm.jdField_a_of_type_Float = f1;
    parambdxm.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bdxn... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bdxn localbdxn = paramVarArgs[i];
      localbdxn.a();
      this.jdField_a_of_type_JavaUtilList.add(localbdxn);
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
    for (bdxf localbdxf = (bdxf)this.jdField_a_of_type_Bdxj; localbdxf != null; localbdxf = (bdxf)localbdxf.jdField_a_of_type_Bdxj) {
      f1 *= localbdxf.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (bdxf localbdxf = (bdxf)this.jdField_a_of_type_Bdxj; localbdxf != null; localbdxf = (bdxf)localbdxf.jdField_a_of_type_Bdxj) {
      f1 *= localbdxf.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((bdxn)this.jdField_a_of_type_JavaUtilList.get(i)).c();
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
      bdxn localbdxn = (bdxn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbdxn.a())
      {
        if ((localbdxn.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localbdxn.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localbdxn.jdField_b_of_type_Float;
        }
        if ((localbdxn.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localbdxn.jdField_c_of_type_Float;
        }
        if ((localbdxn.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localbdxn.jdField_a_of_type_Int;
        }
        if ((localbdxn.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localbdxn.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localbdxn.jdField_b_of_type_Boolean)
      {
        if (!localbdxn.jdField_a_of_type_Boolean) {
          break label161;
        }
        localbdxn.a();
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
    if (this.jdField_a_of_type_Bdxg != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Bdxg.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Bdxg.jdField_a_of_type_ArrayOfBdxh.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Bdxg.jdField_a_of_type_ArrayOfBdxh[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Bdxg.jdField_a_of_type_ArrayOfBdxh[i].jdField_b_of_type_Float;
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
      ((bdxn)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
  
  public int i_()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxf
 * JD-Core Version:    0.7.0.1
 */