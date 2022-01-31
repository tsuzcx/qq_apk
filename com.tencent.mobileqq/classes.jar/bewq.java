import android.content.Context;
import android.content.IntentFilter;

public class bewq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private bewr jdField_a_of_type_Bewr;
  private bews jdField_a_of_type_Bews;
  
  public bewq(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bewr != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Bewr, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(bews parambews)
  {
    this.jdField_a_of_type_Bews = parambews;
    this.jdField_a_of_type_Bewr = new bewr(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bewr != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Bewr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewq
 * JD-Core Version:    0.7.0.1
 */