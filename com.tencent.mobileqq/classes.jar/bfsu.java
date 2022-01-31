import android.app.Activity;
import android.content.IntentFilter;
import android.view.KeyEvent;
import cooperation.qzone.util.QZLog;

public class bfsu
{
  public static String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public bfsw a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WatchActivityManager";
  }
  
  public bfsu()
  {
    this.jdField_a_of_type_Bfsw = new bfsw(this, null);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.d = false;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_Bfsw, localIntentFilter);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_Bfsw);
    }
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.c = true;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    e();
  }
  
  public boolean a()
  {
    QZLog.i(jdField_a_of_type_JavaLangString, 4, "ljh, mActivityStopped = " + this.d + ", mPressScreenOff = " + this.jdField_a_of_type_Boolean + ", mPressMenuKey = " + this.c + ", mPressHomeKey = " + this.b);
    return (this.d) && (!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b);
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfsu
 * JD-Core Version:    0.7.0.1
 */