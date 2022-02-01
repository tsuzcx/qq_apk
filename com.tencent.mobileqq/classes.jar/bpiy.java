import com.tencent.qphone.base.util.QLog;

class bpiy
  extends boiw
{
  bpiy(bpix parambpix) {}
  
  public void onCancel(String paramString) {}
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      bpix.a(this.a, true);
      bpix.a(this.a);
      return;
    }
    QLog.i("EditPicQzComment", 2, "download music fail" + paramInt);
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onStart(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpiy
 * JD-Core Version:    0.7.0.1
 */