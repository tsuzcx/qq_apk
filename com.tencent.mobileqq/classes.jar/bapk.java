import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class bapk
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
    boolean bool = bdgx.a().a("DownloadProxy").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadDownProxySync, bDownProxyResult  = " + bool);
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    bdgx localbdgx = bdgx.a();
    paramLoadSoCallback = new bapl(this, paramLoadSoCallback);
    localbdgx.a(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    boolean bool = bdgx.a().a("TPCore-master").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadTPCoreSync, bTPCoreResult  = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapk
 * JD-Core Version:    0.7.0.1
 */