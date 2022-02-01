import com.tencent.qphone.base.util.QLog;

class bomt
  extends bomw
{
  bomt(boms paramboms) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String arg1, int paramInt)
  {
    synchronized (this.a)
    {
      this.a.a.mProgress = paramInt;
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomt
 * JD-Core Version:    0.7.0.1
 */