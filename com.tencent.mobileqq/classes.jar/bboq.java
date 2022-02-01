import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class bboq
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbpi jdField_a_of_type_Bbpi;
  private bbpq jdField_a_of_type_Bbpq;
  private bbqp jdField_a_of_type_Bbqp;
  
  public bboq(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bbpq a()
  {
    return this.jdField_a_of_type_Bbpq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      return this.jdField_a_of_type_Bbpq.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      return this.jdField_a_of_type_Bbpq.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Bbpq.buildComplete();
    this.jdField_a_of_type_Bbqp.buildComplete();
    this.jdField_a_of_type_Bbpi.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Bbpi.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Bbpq.buildParams(paramIntent);
    this.jdField_a_of_type_Bbqp.buildParams(paramIntent);
    this.jdField_a_of_type_Bbpi.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Bbpq = new bbpq();
    this.jdField_a_of_type_Bbqp = new bbqp(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bbpq);
    this.jdField_a_of_type_Bbpq.a(this.jdField_a_of_type_Bbqp);
    this.jdField_a_of_type_Bbpi = new bbpi(this.jdField_a_of_type_Bbpq);
    this.jdField_a_of_type_Bbpq.a(this.jdField_a_of_type_Bbpi);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bbqp.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bbpq != null) {
      this.jdField_a_of_type_Bbpq.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboq
 * JD-Core Version:    0.7.0.1
 */