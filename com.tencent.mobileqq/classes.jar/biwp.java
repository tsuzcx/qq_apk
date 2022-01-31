import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class biwp
  extends bjow
{
  private biwo jdField_a_of_type_Biwo;
  private bjor<biwo> jdField_a_of_type_Bjor = new bjor();
  private boolean jdField_a_of_type_Boolean;
  private biwo jdField_b_of_type_Biwo;
  private boolean jdField_b_of_type_Boolean;
  
  public biwo a(bijd parambijd)
  {
    String str;
    if (this.jdField_b_of_type_Biwo == null) {
      str = biij.a;
    }
    try
    {
      i = Integer.parseInt(str);
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < biwo.a(parambijd).length) {}
      }
      else
      {
        j = 0;
      }
      this.jdField_b_of_type_Biwo = biwo.a(parambijd)[j];
      if (QLog.isColorLevel()) {
        QLog.i("AEVideoStoryCaptureModeViewModel", 2, "[getTestingMode], app_alg_entrance_id=" + j);
      }
      return this.jdField_b_of_type_Biwo;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public bjor<biwo> a()
  {
    return this.jdField_a_of_type_Bjor;
  }
  
  public void a(@NonNull biwo parambiwo)
  {
    this.jdField_a_of_type_Biwo = parambiwo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bjor.a() == null) {
      if (this.jdField_a_of_type_Biwo != biwo.c) {}
    }
    while (this.jdField_a_of_type_Bjor.a() == biwo.c)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bjor.a() == null) {
      if (this.jdField_a_of_type_Biwo != biwo.jdField_a_of_type_Biwo) {}
    }
    while (this.jdField_a_of_type_Bjor.a() == biwo.jdField_a_of_type_Biwo)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Bjor.a() == null) {
      if (this.jdField_a_of_type_Biwo != biwo.jdField_b_of_type_Biwo) {}
    }
    while (this.jdField_a_of_type_Bjor.a() == biwo.jdField_b_of_type_Biwo)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwp
 * JD-Core Version:    0.7.0.1
 */