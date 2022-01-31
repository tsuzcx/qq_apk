import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class bivy
  extends bjof
{
  private bivx jdField_a_of_type_Bivx;
  private bjoa<bivx> jdField_a_of_type_Bjoa = new bjoa();
  private boolean jdField_a_of_type_Boolean;
  private bivx jdField_b_of_type_Bivx;
  private boolean jdField_b_of_type_Boolean;
  
  public bivx a(biim parambiim)
  {
    String str;
    if (this.jdField_b_of_type_Bivx == null) {
      str = bihs.a;
    }
    try
    {
      i = Integer.parseInt(str);
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < bivx.a(parambiim).length) {}
      }
      else
      {
        j = 0;
      }
      this.jdField_b_of_type_Bivx = bivx.a(parambiim)[j];
      if (QLog.isColorLevel()) {
        QLog.i("AEVideoStoryCaptureModeViewModel", 2, "[getTestingMode], app_alg_entrance_id=" + j);
      }
      return this.jdField_b_of_type_Bivx;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public bjoa<bivx> a()
  {
    return this.jdField_a_of_type_Bjoa;
  }
  
  public void a(@NonNull bivx parambivx)
  {
    this.jdField_a_of_type_Bivx = parambivx;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bjoa.a() == null) {
      if (this.jdField_a_of_type_Bivx != bivx.c) {}
    }
    while (this.jdField_a_of_type_Bjoa.a() == bivx.c)
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
    if (this.jdField_a_of_type_Bjoa.a() == null) {
      if (this.jdField_a_of_type_Bivx != bivx.jdField_a_of_type_Bivx) {}
    }
    while (this.jdField_a_of_type_Bjoa.a() == bivx.jdField_a_of_type_Bivx)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Bjoa.a() == null) {
      if (this.jdField_a_of_type_Bivx != bivx.jdField_b_of_type_Bivx) {}
    }
    while (this.jdField_a_of_type_Bjoa.a() == bivx.jdField_b_of_type_Bivx)
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
 * Qualified Name:     bivy
 * JD-Core Version:    0.7.0.1
 */