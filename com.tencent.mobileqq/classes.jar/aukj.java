import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;

class aukj
  implements blvp
{
  aukj(auke paramauke) {}
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    QLog.d("qqidentification_server", 1, new Object[] { "AE res download finish, success : ", Boolean.valueOf(paramBoolean), " path : ", paramString });
    auke.a(this.a, 2, paramBoolean);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukj
 * JD-Core Version:    0.7.0.1
 */