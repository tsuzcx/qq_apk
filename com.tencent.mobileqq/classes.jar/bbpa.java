import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class bbpa
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbps jdField_a_of_type_Bbps;
  private bbqa jdField_a_of_type_Bbqa;
  private bbqz jdField_a_of_type_Bbqz;
  
  public bbpa(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bbqa a()
  {
    return this.jdField_a_of_type_Bbqa;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Bbqa.buildComplete();
    this.jdField_a_of_type_Bbqz.buildComplete();
    this.jdField_a_of_type_Bbps.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Bbps.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Bbqa.buildParams(paramIntent);
    this.jdField_a_of_type_Bbqz.buildParams(paramIntent);
    this.jdField_a_of_type_Bbps.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Bbqa = new bbqa();
    this.jdField_a_of_type_Bbqz = new bbqz(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bbqa);
    this.jdField_a_of_type_Bbqa.a(this.jdField_a_of_type_Bbqz);
    this.jdField_a_of_type_Bbps = new bbps(this.jdField_a_of_type_Bbqa);
    this.jdField_a_of_type_Bbqa.a(this.jdField_a_of_type_Bbps);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bbqz.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpa
 * JD-Core Version:    0.7.0.1
 */