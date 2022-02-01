import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aury
  extends QIPCModule
{
  private static volatile aury jdField_a_of_type_Aury;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  public aury(String paramString)
  {
    super(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WatchTogetherClientIPCModule", 2, "WatchTogetherClientIPCModule register");
    }
  }
  
  public static aury a()
  {
    if (jdField_a_of_type_Aury == null) {}
    try
    {
      if (jdField_a_of_type_Aury == null) {
        jdField_a_of_type_Aury = new aury("WatchTogetherClientIPCModule");
      }
      return jdField_a_of_type_Aury;
    }
    finally {}
  }
  
  private boolean a()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  public void a(String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (a())
    {
      if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString)) {
        aurt.a().a(BaseApplicationImpl.getContext(), paramWatchTogetherFloatingData);
      }
      do
      {
        return;
        if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
        {
          aurt.a().a(paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
          return;
        }
      } while (!"ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(paramString));
      aurt.a().b();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherClientIPCModule.1(this, paramString, paramWatchTogetherFloatingData));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchTogetherClientIPCModule", 2, "call TogetherBusinessIPCModule action=" + paramString);
    }
    EIPCResult localEIPCResult = new EIPCResult();
    if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString)) {
      if (paramBundle != null)
      {
        paramBundle = (WatchTogetherFloatingData)paramBundle.getSerializable("BUNDLE_KEY_UI_DATA");
        if (paramBundle != null)
        {
          a(paramString, paramBundle);
          localEIPCResult.code = 0;
        }
      }
    }
    for (;;)
    {
      callbackResult(paramInt, localEIPCResult);
      return localEIPCResult;
      localEIPCResult.code = -102;
      continue;
      localEIPCResult.code = -102;
      continue;
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
      {
        if (paramBundle != null)
        {
          paramBundle = (WatchTogetherFloatingData)paramBundle.getSerializable("BUNDLE_KEY_UI_DATA");
          if (paramBundle != null)
          {
            a(paramString, paramBundle);
            localEIPCResult.code = 0;
          }
          else
          {
            localEIPCResult.code = -102;
          }
        }
        else
        {
          localEIPCResult.code = -102;
        }
      }
      else if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(paramString))
      {
        a(paramString, new WatchTogetherFloatingData());
        localEIPCResult.code = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aury
 * JD-Core Version:    0.7.0.1
 */