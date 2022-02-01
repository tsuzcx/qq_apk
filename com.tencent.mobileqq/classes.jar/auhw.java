import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class auhw
  implements aulc
{
  auhw(auht paramauht) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    auht.a(this.a);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    bdla.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_success", 0, 1, 0, "", "", "", "");
    paramBundle.getInt("_CB_SID");
    String str = paramBundle.getString("_CB_URL");
    paramBundle = paramBundle.getBundle("_CB_USERDATA");
    auht.a(this.a, str);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.a.a != null) {
      this.a.a.getFileManagerDataCenter().a(null, -1, paramString, paramLong, 16, null, paramBundle);
    }
    for (;;)
    {
      if (paramBundle != null) {
        auku.a(paramString, paramBundle.getString("big_brother_source_key"));
      }
      auht.a(this.a);
      if ("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean".equals(str)) {
        bdla.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "download secure apk sucess", 0, 0, "", "", "", "");
      }
      return;
      auea.c(paramString);
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhw
 * JD-Core Version:    0.7.0.1
 */