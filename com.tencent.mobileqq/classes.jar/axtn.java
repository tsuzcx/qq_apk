import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class axtn
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private axtz jdField_a_of_type_Axtz;
  private axuh jdField_a_of_type_Axuh;
  private axvf jdField_a_of_type_Axvf;
  
  public axtn(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public axuh a()
  {
    return this.jdField_a_of_type_Axuh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      return this.jdField_a_of_type_Axuh.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Axuh != null) {
      return this.jdField_a_of_type_Axuh.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Axuh.buildComplete();
    this.jdField_a_of_type_Axvf.buildComplete();
    this.jdField_a_of_type_Axtz.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Axtz.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Axuh.buildParams(paramIntent);
    this.jdField_a_of_type_Axvf.buildParams(paramIntent);
    this.jdField_a_of_type_Axtz.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Axuh = new axuh();
    this.jdField_a_of_type_Axvf = new axvf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Axuh);
    this.jdField_a_of_type_Axuh.a(this.jdField_a_of_type_Axvf);
    this.jdField_a_of_type_Axtz = new axtz(this.jdField_a_of_type_Axuh);
    this.jdField_a_of_type_Axuh.a(this.jdField_a_of_type_Axtz);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Axvf.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Axuh != null) {
      this.jdField_a_of_type_Axuh.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtn
 * JD-Core Version:    0.7.0.1
 */