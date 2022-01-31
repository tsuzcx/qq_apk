import android.content.Context;
import android.content.IntentFilter;

public class bhag
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private bhah jdField_a_of_type_Bhah;
  private bhai jdField_a_of_type_Bhai;
  
  public bhag(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhah != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Bhah, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(bhai parambhai)
  {
    this.jdField_a_of_type_Bhai = parambhai;
    this.jdField_a_of_type_Bhah = new bhah(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhah != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Bhah);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhag
 * JD-Core Version:    0.7.0.1
 */