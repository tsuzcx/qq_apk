import com.tencent.qphone.base.util.QLog;

class bmtb
  extends bmte
{
  bmtb(bmta parambmta) {}
  
  public void onCancel(String paramString) {}
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloadListener", 2, "notifyDownloadFinish key: " + paramString + ", success " + paramBoolean);
    }
    paramString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.a.a.mProgress = 100;
        this.a.b();
        return;
      }
      finally {}
      this.a.a.mProgress = -1;
      this.a.a(4);
    }
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String arg1, int paramInt)
  {
    synchronized (this.a)
    {
      this.a.a.mProgress = paramInt;
      return;
    }
  }
  
  public void onStart(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtb
 * JD-Core Version:    0.7.0.1
 */