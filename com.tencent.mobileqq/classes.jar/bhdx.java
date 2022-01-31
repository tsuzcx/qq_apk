import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;

class bhdx
  implements BaselibLoader.OnLoadBaselibListener
{
  bhdx(bhdw parambhdw) {}
  
  public void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent)
  {
    bgyd.a(bgxz.a(), 11, "0");
    if ((paramInt == 0) && (paramBaselibContent != null) && (paramBaselibContent.isBaseLibInited()))
    {
      bhdw.a(this.a, paramBaselibContent);
      bgxn.a = true;
      this.a.c();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdx
 * JD-Core Version:    0.7.0.1
 */