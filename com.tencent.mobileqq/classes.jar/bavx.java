import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class bavx
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bawp jdField_a_of_type_Bawp;
  private bawx jdField_a_of_type_Bawx;
  private baxw jdField_a_of_type_Baxw;
  
  public bavx(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bawx a()
  {
    return this.jdField_a_of_type_Bawx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      return this.jdField_a_of_type_Bawx.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Bawx != null) {
      return this.jdField_a_of_type_Bawx.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Bawx.buildComplete();
    this.jdField_a_of_type_Baxw.buildComplete();
    this.jdField_a_of_type_Bawp.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Bawp.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Bawx.buildParams(paramIntent);
    this.jdField_a_of_type_Baxw.buildParams(paramIntent);
    this.jdField_a_of_type_Bawp.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Bawx = new bawx();
    this.jdField_a_of_type_Baxw = new baxw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bawx);
    this.jdField_a_of_type_Bawx.a(this.jdField_a_of_type_Baxw);
    this.jdField_a_of_type_Bawp = new bawp(this.jdField_a_of_type_Bawx);
    this.jdField_a_of_type_Bawx.a(this.jdField_a_of_type_Bawp);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Baxw.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bawx != null) {
      this.jdField_a_of_type_Bawx.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavx
 * JD-Core Version:    0.7.0.1
 */