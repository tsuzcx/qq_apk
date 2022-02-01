import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;

public class arvs
  extends asbj
{
  public arvs(VerifyPwdView paramVerifyPwdView) {}
  
  protected void onNeedVerifyPwdFailed(int paramInt, String paramString)
  {
    aszk.a(paramString);
    VerifyPwdView.c(this.a);
  }
  
  protected void onNeedVerifyPwdSuccess(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      VerifyPwdView.a(this.a);
      return;
    }
    VerifyPwdView.b(this.a);
  }
  
  protected void onVerifyPwdFailed(int paramInt, String paramString)
  {
    aszk.a(paramString);
  }
  
  protected void onVerifyPwdSuccess()
  {
    VerifyPwdView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvs
 * JD-Core Version:    0.7.0.1
 */