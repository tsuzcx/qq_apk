import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;

class bhbm
  implements BaselibLoader.OnLoadBaselibListener
{
  bhbm(bhbi parambhbi) {}
  
  public void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent)
  {
    if ((paramInt == 0) && (paramBaselibContent != null))
    {
      paramString = paramBaselibContent.waWebviewJsStr;
      bhbi.a(this.a).a(paramString);
      this.a.appendEvent(Integer.valueOf(6));
      paramString = paramBaselibContent.waRemoteDebugStr;
      bhbi.b(this.a).a(paramString);
      this.a.appendEvent(Integer.valueOf(7));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbm
 * JD-Core Version:    0.7.0.1
 */