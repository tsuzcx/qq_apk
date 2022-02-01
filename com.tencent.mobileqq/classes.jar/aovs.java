import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.qphone.base.util.QLog;

class aovs
  implements ArkAppPreloader.PreloadAppCallback
{
  aovs(aovq paramaovq) {}
  
  public void beginAppload(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      aovk.a(paramString);
    }
  }
  
  public void onAppLoaded(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      aovk.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preload app appname=", paramString, ",success=", Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void onReleaseAndReload(String paramString, int paramInt)
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload begin app = " + paramString);
    ArkAppMgr.getInstance().getAppPathByName(paramString, "", "0.0.0.1", null, new aovt(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovs
 * JD-Core Version:    0.7.0.1
 */