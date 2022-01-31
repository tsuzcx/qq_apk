import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.minigame.task.InstalledEngineLoadTask.1;

public class bgvh
  extends MiniCmdCallback.Stub
{
  public bgvh(InstalledEngineLoadTask.1 param1) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
      this.a.this$0.a(paramBundle);
      bgwc.a().i(bgvg.a(this.a.this$0), "[MiniEng]reInitOutChannel " + paramBundle);
      bgvg.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvh
 * JD-Core Version:    0.7.0.1
 */