import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awjk
{
  private static final Object a = "PicReporter";
  
  public static void a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131695482), "qqsetting_auto_receive_pic_key", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_state", String.valueOf(bool));
    awiw.a(a, "report2G3G4GSwitchState", "param_state:" + bool);
    azri.a(BaseApplication.getContext()).a(null, "act2G3G4GSwitch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_network", String.valueOf(paramInt));
    localHashMap.put("param_limit", String.valueOf(paramLong));
    awiw.a(a, "reportOverFlow", "param_network:" + paramInt + ",param_limit:" + paramLong);
    azri.a(BaseApplication.getContext()).a(null, "actPicPreDownOverFlow", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    awiw.a(a, "reportBigPicDownCost", "uintype:" + paramInt1 + ",networktype:" + paramInt2 + ",timeCost:" + paramLong);
    if ((paramInt1 == -1) || (paramInt2 == -1) || (paramLong < 0L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uintype", String.valueOf(paramInt1));
    localHashMap.put("param_networktype", String.valueOf(paramInt2));
    localHashMap.put("param_timecost", String.valueOf(paramLong));
    azri.a(BaseApplication.getContext()).a(paramString, "actBigPicDownCost", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      awiw.a(a, "reportPicDownAutoLearn", "reportInfo == null");
      return;
    }
    if ((String)paramHashMap.get("xgPreDownCount") == null)
    {
      awiw.a(a, "reportPicDownAutoLearn", "no xg report data");
      return;
    }
    azri.a(BaseApplication.getContext()).a(paramString, "actPicDownAutoLearn", false, 0L, 0L, paramHashMap, "");
    awiw.a(a, "reportPicDownAutoLearn", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "device busy " + paramBoolean);
    }
    azri.a(BaseApplication.getContext()).a(null, "Pic.Mkdir.DeviceBusy", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "Aio preview " + paramBoolean);
    }
    azri.a(BaseApplication.getContext()).a(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjk
 * JD-Core Version:    0.7.0.1
 */