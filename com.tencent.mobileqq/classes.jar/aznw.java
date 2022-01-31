import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

public class aznw
  extends QIPCModule
{
  private static aznw jdField_a_of_type_Aznw;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public aznw(String paramString)
  {
    super(paramString);
  }
  
  public static aznw a()
  {
    if (jdField_a_of_type_Aznw == null) {}
    try
    {
      if (jdField_a_of_type_Aznw == null) {
        jdField_a_of_type_Aznw = new aznw("BatteryModule");
      }
      return jdField_a_of_type_Aznw;
    }
    finally {}
  }
  
  void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_process_id", BaseApplicationImpl.sProcessId);
    QIPCClientHelper.getInstance().callServer("BatteryModule", "action_monitor", localBundle, new aznx(this));
  }
  
  void a(Bundle paramBundle)
  {
    paramBundle.putString("key_process_name", BaseApplicationImpl.getApplication().getQQProcessName());
    QIPCClientHelper.getInstance().getClient().callServer("BatteryModule", "action_report", paramBundle, null);
  }
  
  void a(String... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("key_message", paramVarArgs);
    QIPCClientHelper.getInstance().getClient().callServer("BatteryModule", "action_record", localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("BatteryStats.Module", 2, "action = " + paramString);
    }
    int i;
    if ("action_monitor".equals(paramString))
    {
      i = azob.a().a();
      if ((i == 0) || (i == 1))
      {
        paramString = new Bundle();
        if (i == 1) {}
        for (;;)
        {
          paramString.putBoolean("key_monitor", bool);
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
          return null;
          bool = false;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramBundle.getInt("key_process_id")), Integer.valueOf(paramInt));
      return null;
    }
    if ("action_record".equals(paramString))
    {
      azob.a().a(paramBundle.getInt("key_process_id"), paramBundle.getStringArray("key_message"));
      return EIPCResult.createSuccessResult(null);
    }
    if ("action_alarm".equals(paramString))
    {
      paramInt = paramBundle.getInt("monitor_type", -1);
      i = paramBundle.getInt("except_type", -1);
      int j = paramBundle.getInt("key_level", -1);
      paramString = paramBundle.getString("key_message");
      paramBundle = paramBundle.getString("key_description");
      azob.a().a(paramInt, i, j, paramString, paramBundle);
    }
    for (;;)
    {
      return null;
      if ("action_report".equals(paramString)) {
        azob.a().a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznw
 * JD-Core Version:    0.7.0.1
 */