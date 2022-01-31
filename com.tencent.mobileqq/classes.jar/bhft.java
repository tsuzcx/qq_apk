import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;

class bhft
  implements BaselibLoader.OnLoadBaselibListener
{
  bhft(bhfp parambhfp) {}
  
  public void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent)
  {
    if ((paramInt == 0) && (paramBaselibContent != null))
    {
      paramString = paramBaselibContent.waWebviewJsStr;
      bhfp.a(this.a).a(paramString);
      this.a.appendEvent(Integer.valueOf(6));
      paramString = paramBaselibContent.waRemoteDebugStr;
      bhfp.b(this.a).a(paramString);
      this.a.appendEvent(Integer.valueOf(7));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhft
 * JD-Core Version:    0.7.0.1
 */