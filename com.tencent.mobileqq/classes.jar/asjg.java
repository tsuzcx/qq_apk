import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineChannel.Receiver;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asjg
  extends AsyncTask
  implements EngineChannel.Receiver
{
  private int jdField_a_of_type_Int = 3;
  private asjf jdField_a_of_type_Asjf;
  private MiniAppInfo jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo;
  private EngineChannel jdField_a_of_type_ComTencentMobileqqMinigameManagerEngineChannel;
  private InstalledEngine jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine;
  private int b;
  
  public asjg(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", this.jdField_a_of_type_Int);
    paramBundle.putInt("enginePid", Process.myPid());
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]installEngineRequestCount " + this.b);
    if (this.b >= 2)
    {
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]GET_INSTALLED_ENGINE_LIST requestCount reaches max 2");
      onTaskFailed(103, ajyc.a(2131706805));
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMinigameManagerEngineChannel.send(paramInt, paramBundle);
    } while (paramInt != 3);
    this.b += 1;
  }
  
  private void a(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine == null)
        {
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]mEngine == null, loadEngineTask is reset?");
          return;
        }
        long l = System.currentTimeMillis();
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]initEngine");
        if (paramInstalledEngine != null) {
          asjh.a().a(paramInstalledEngine);
        }
        if (!asjh.a().a())
        {
          QLog.e("MiniAppEngineLoadTask", 1, "[MiniEng]initEngine fail");
          onTaskFailed();
          continue;
        }
        QLog.e("MiniAppEngineLoadTask", 1, "[MiniEng]loadSo cost time " + (System.currentTimeMillis() - l));
      }
      finally {}
      onTaskSucceed();
    }
  }
  
  private boolean a(InstalledEngine paramInstalledEngine, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramInstalledEngine == null) {
      bool = false;
    }
    while (paramMiniAppInfo != null) {
      return bool;
    }
    return true;
  }
  
  public void a(asjf paramasjf)
  {
    this.jdField_a_of_type_Asjf = paramasjf;
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_ComTencentMobileqqMinigameManagerEngineChannel = paramEngineChannel;
  }
  
  public void executeAsync()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerEngineChannel == null)
    {
      onTaskFailed(1, ajyc.a(2131706800));
      return;
    }
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("AppEngine(" + Process.myPid() + ")");
    localEngineChannel.setReceiver(this);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    a(1, localBundle);
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList success " + paramInt);
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo))
            {
              this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = paramBundle;
              a(paramBundle);
            }
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        onTaskFailed(101, ajyc.a(2131706802));
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
        a(3, new Bundle());
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList miniAppEngineList is null");
        onTaskFailed(102, ajyc.a(2131706798));
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList data is null");
        onTaskFailed(102, ajyc.a(2131706797));
        return;
        if (paramInt == 52)
        {
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
          return;
        }
        if (paramInt != 53) {
          break;
        }
      } while (paramBundle == null);
      paramBundle = paramBundle.getString("engineInstallerMessage");
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + paramBundle);
      return;
    } while (paramInt != 54);
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
    a(1, new Bundle());
  }
  
  public void reset()
  {
    try
    {
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]" + this + " reset ");
      this.b = 0;
      this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = null;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asjg
 * JD-Core Version:    0.7.0.1
 */