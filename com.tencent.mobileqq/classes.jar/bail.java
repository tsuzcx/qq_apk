import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class bail
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bajd jdField_a_of_type_Bajd;
  private bajl jdField_a_of_type_Bajl;
  private bakk jdField_a_of_type_Bakk;
  
  public bail(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bajl a()
  {
    return this.jdField_a_of_type_Bajl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Bajl.buildComplete();
    this.jdField_a_of_type_Bakk.buildComplete();
    this.jdField_a_of_type_Bajd.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Bajd.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Bajl.buildParams(paramIntent);
    this.jdField_a_of_type_Bakk.buildParams(paramIntent);
    this.jdField_a_of_type_Bajd.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Bajl = new bajl();
    this.jdField_a_of_type_Bakk = new bakk(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bajl);
    this.jdField_a_of_type_Bajl.a(this.jdField_a_of_type_Bakk);
    this.jdField_a_of_type_Bajd = new bajd(this.jdField_a_of_type_Bajl);
    this.jdField_a_of_type_Bajl.a(this.jdField_a_of_type_Bajd);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bakk.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bail
 * JD-Core Version:    0.7.0.1
 */