import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;

class bhcz
  implements BaselibLoader.OnLoadBaselibListener
{
  bhcz(bhcw parambhcw) {}
  
  public void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent)
  {
    if ((paramInt == 0) && (paramBaselibContent != null)) {
      this.a.a(paramBaselibContent.waServiceJsStr, paramBaselibContent.waServicePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcz
 * JD-Core Version:    0.7.0.1
 */