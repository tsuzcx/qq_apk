import com.tencent.qphone.base.util.QLog;

class avqe
  implements bnkw
{
  avqe(avpz paramavpz) {}
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    QLog.d("qqidentification_server", 1, new Object[] { "AE res download finish, success : ", Boolean.valueOf(paramBoolean), " path : ", paramString });
    avpz.a(this.a, 2, paramBoolean);
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqe
 * JD-Core Version:    0.7.0.1
 */