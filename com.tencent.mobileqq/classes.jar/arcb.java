import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;

public class arcb
{
  private static volatile arcb jdField_a_of_type_Arcb;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new arcd(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new arcc(this);
  private ArrayList<arce> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private arcb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(true);
  }
  
  public static arcb a(Context paramContext)
  {
    if (jdField_a_of_type_Arcb == null) {}
    try
    {
      if (jdField_a_of_type_Arcb == null) {
        jdField_a_of_type_Arcb = new arcb(paramContext);
      }
      return jdField_a_of_type_Arcb;
    }
    finally {}
  }
  
  public void a(arce paramarce)
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramarce)) && (paramarce != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramarce);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      localIntentFilter.addAction("VolumeBtnDown");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public void b(arce paramarce)
  {
    if ((paramarce != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramarce))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramarce);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arcb
 * JD-Core Version:    0.7.0.1
 */