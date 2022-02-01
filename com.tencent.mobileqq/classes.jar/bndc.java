import com.tencent.qphone.base.util.QLog;

class bndc
  extends bmte
{
  bndc(bncy parambncy) {}
  
  public void onCancel(String paramString) {}
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart onFinish key=" + paramString + " result=" + paramBoolean);
    }
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onStart(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndc
 * JD-Core Version:    0.7.0.1
 */