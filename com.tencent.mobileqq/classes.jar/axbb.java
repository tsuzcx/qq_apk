import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class axbb
  implements ILoadSo
{
  boolean a = false;
  
  public boolean isCkeygeneratorV2Load()
  {
    return this.a;
  }
  
  public boolean isCkguardLoad()
  {
    return this.a;
  }
  
  public boolean isDownProxyLoad()
  {
    return this.a;
  }
  
  public boolean isTPCoreLoad()
  {
    return this.a;
  }
  
  public boolean loadDownProxySync()
  {
    boolean bool = azmy.a().a("DownloadProxy").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadDownProxySync, bDownProxyResult  = " + bool);
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    azmy localazmy = azmy.a();
    paramLoadSoCallback = new axbc(this, paramLoadSoCallback);
    localazmy.a(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    boolean bool = azmy.a().a("TPCore-master").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadTPCoreSync, bTPCoreResult  = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axbb
 * JD-Core Version:    0.7.0.1
 */