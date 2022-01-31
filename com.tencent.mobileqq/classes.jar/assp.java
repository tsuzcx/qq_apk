import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;

public class assp
{
  private static volatile assp jdField_a_of_type_Assp;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new assr(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new assq(this);
  private ArrayList<asss> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private assp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(true);
  }
  
  public static assp a(Context paramContext)
  {
    if (jdField_a_of_type_Assp == null) {}
    try
    {
      if (jdField_a_of_type_Assp == null) {
        jdField_a_of_type_Assp = new assp(paramContext);
      }
      return jdField_a_of_type_Assp;
    }
    finally {}
  }
  
  public void a(asss paramasss)
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramasss)) && (paramasss != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramasss);
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
  
  public void b(asss paramasss)
  {
    if ((paramasss != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramasss))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramasss);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assp
 * JD-Core Version:    0.7.0.1
 */