import android.content.Context;
import android.content.IntentFilter;

public class bgvz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private bgwa jdField_a_of_type_Bgwa;
  private bgwb jdField_a_of_type_Bgwb;
  
  public bgvz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bgwa != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Bgwa, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(bgwb parambgwb)
  {
    this.jdField_a_of_type_Bgwb = parambgwb;
    this.jdField_a_of_type_Bgwa = new bgwa(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgwa != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Bgwa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvz
 * JD-Core Version:    0.7.0.1
 */