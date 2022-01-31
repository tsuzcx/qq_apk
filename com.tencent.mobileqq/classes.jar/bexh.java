import android.content.Context;
import android.content.IntentFilter;

public class bexh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private bexi jdField_a_of_type_Bexi;
  private bexj jdField_a_of_type_Bexj;
  
  public bexh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bexi != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Bexi, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(bexj parambexj)
  {
    this.jdField_a_of_type_Bexj = parambexj;
    this.jdField_a_of_type_Bexi = new bexi(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bexi != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Bexi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexh
 * JD-Core Version:    0.7.0.1
 */