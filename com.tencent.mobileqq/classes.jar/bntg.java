import com.tencent.qphone.base.util.QLog;

class bntg
  extends bmte
{
  bntg(bntf parambntf) {}
  
  public void onCancel(String paramString) {}
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      bntf.a(this.a, true);
      bntf.a(this.a);
      return;
    }
    QLog.i("EditPicQzComment", 2, "download music fail" + paramInt);
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onStart(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntg
 * JD-Core Version:    0.7.0.1
 */