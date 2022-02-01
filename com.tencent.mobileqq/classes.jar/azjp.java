import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class azjp
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
    boolean bool = bbzm.a().a("DownloadProxy").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadDownProxySync, bDownProxyResult  = " + bool);
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    bbzm localbbzm = bbzm.a();
    paramLoadSoCallback = new azjq(this, paramLoadSoCallback);
    localbbzm.a(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    boolean bool = bbzm.a().a("TPCore-master").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadTPCoreSync, bTPCoreResult  = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjp
 * JD-Core Version:    0.7.0.1
 */