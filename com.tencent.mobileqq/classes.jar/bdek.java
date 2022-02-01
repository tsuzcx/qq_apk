import java.util.ArrayList;
import java.util.List;

public abstract class bdek
{
  public float a;
  public int a;
  public bdel a;
  public bdeo a;
  public String a;
  protected List<bdes> a;
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
  
  public bdek()
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
  
  public abstract bdeq a();
  
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
  
  public void a(bdel parambdel)
  {
    this.jdField_a_of_type_Bdel = parambdel;
  }
  
  public void a(bder parambder)
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
      for (bdek localbdek = (bdek)this.jdField_a_of_type_Bdeo; localbdek != null; localbdek = (bdek)localbdek.jdField_a_of_type_Bdeo)
      {
        f1 += localbdek.jdField_c_of_type_Float;
        f2 += localbdek.jdField_d_of_type_Float;
      }
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
      break;
      f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      break;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f3;
      continue;
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F + f3;
    }
    parambder.jdField_a_of_type_Float = f1;
    parambder.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bdes... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bdes localbdes = paramVarArgs[i];
      localbdes.a();
      this.jdField_a_of_type_JavaUtilList.add(localbdes);
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
    for (bdek localbdek = (bdek)this.jdField_a_of_type_Bdeo; localbdek != null; localbdek = (bdek)localbdek.jdField_a_of_type_Bdeo) {
      f1 *= localbdek.jdField_e_of_type_Float;
    }
    return f1;
  }
  
  public int b()
  {
    float f1 = 1.0F;
    for (bdek localbdek = (bdek)this.jdField_a_of_type_Bdeo; localbdek != null; localbdek = (bdek)localbdek.jdField_a_of_type_Bdeo) {
      f1 *= localbdek.jdField_a_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((bdes)this.jdField_a_of_type_JavaUtilList.get(i)).c();
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
      bdes localbdes = (bdes)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbdes.a())
      {
        if ((localbdes.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localbdes.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localbdes.jdField_b_of_type_Float;
        }
        if ((localbdes.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localbdes.jdField_c_of_type_Float;
        }
        if ((localbdes.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localbdes.jdField_a_of_type_Int;
        }
        if ((localbdes.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localbdes.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localbdes.jdField_b_of_type_Boolean)
      {
        if (!localbdes.jdField_a_of_type_Boolean) {
          break label161;
        }
        localbdes.a();
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
    if (this.jdField_a_of_type_Bdel != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_Bdel.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_Bdel.jdField_a_of_type_ArrayOfBdem.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_Bdel.jdField_a_of_type_ArrayOfBdem[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_Bdel.jdField_a_of_type_ArrayOfBdem[i].jdField_b_of_type_Float;
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
      ((bdes)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
 * Qualified Name:     bdek
 * JD-Core Version:    0.7.0.1
 */