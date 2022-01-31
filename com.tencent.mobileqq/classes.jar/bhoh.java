import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class bhoh
  implements bhof
{
  private bhog jdField_a_of_type_Bhog;
  private boolean jdField_a_of_type_Boolean;
  
  public bhoh(bhog parambhog)
  {
    this.jdField_a_of_type_Bhog = parambhog;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Bhog == null);
    this.jdField_a_of_type_Bhog.a(a(), null);
  }
  
  private void c()
  {
    Object localObject = BaseApplication.getContext().getPackageManager();
    if (localObject != null) {
      localObject = ((PackageManager)localObject).getInstalledPackages(8192).iterator();
    }
    for (;;)
    {
      PackageInfo localPackageInfo;
      if (((Iterator)localObject).hasNext())
      {
        localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        return;
      }
      if (this.jdField_a_of_type_Bhog != null) {
        this.jdField_a_of_type_Bhog.b(a(), localPackageInfo);
      }
    }
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_Bhog == null);
    this.jdField_a_of_type_Bhog.c(a(), null);
  }
  
  public String a()
  {
    return "App";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      b();
      c();
      label16:
      d();
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhoh
 * JD-Core Version:    0.7.0.1
 */