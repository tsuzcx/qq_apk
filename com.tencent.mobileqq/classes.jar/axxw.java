import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class axxw
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private axyi jdField_a_of_type_Axyi;
  private axyq jdField_a_of_type_Axyq;
  private axzo jdField_a_of_type_Axzo;
  
  public axxw(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public axyq a()
  {
    return this.jdField_a_of_type_Axyq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Axyq.buildComplete();
    this.jdField_a_of_type_Axzo.buildComplete();
    this.jdField_a_of_type_Axyi.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Axyi.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Axyq.buildParams(paramIntent);
    this.jdField_a_of_type_Axzo.buildParams(paramIntent);
    this.jdField_a_of_type_Axyi.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Axyq = new axyq();
    this.jdField_a_of_type_Axzo = new axzo(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Axyq);
    this.jdField_a_of_type_Axyq.a(this.jdField_a_of_type_Axzo);
    this.jdField_a_of_type_Axyi = new axyi(this.jdField_a_of_type_Axyq);
    this.jdField_a_of_type_Axyq.a(this.jdField_a_of_type_Axyi);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Axzo.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxw
 * JD-Core Version:    0.7.0.1
 */