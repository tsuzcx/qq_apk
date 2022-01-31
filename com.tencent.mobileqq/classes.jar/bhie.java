import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;

class bhie
  implements BaselibLoader.OnLoadBaselibListener
{
  bhie(bhid parambhid) {}
  
  public void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent)
  {
    bhck.a(bhcg.a(), 11, "0");
    if ((paramInt == 0) && (paramBaselibContent != null) && (paramBaselibContent.isBaseLibInited()))
    {
      bhid.a(this.a, paramBaselibContent);
      bhbu.a = true;
      this.a.c();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhie
 * JD-Core Version:    0.7.0.1
 */