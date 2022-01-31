import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class atbm
  implements apwk
{
  atbm(atbk paramatbk) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.d(atbk.a(this.a), 2, "onDownloadFailed,errCode=" + paramInt);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.d(atbk.a(this.a), 2, "onDownloadSucess,filePath:" + paramString);
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbm
 * JD-Core Version:    0.7.0.1
 */