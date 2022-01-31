import android.os.Bundle;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.minigame.task.GameEngineLoadTask.1;

public class bdqn
  extends bdla
{
  public bdqn(GameEngineLoadTask.1 param1) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
      this.a.this$0.a(paramBundle);
      bdrb.a().i("EngineLoadTask", "[MiniEng]reInitOutChannel " + paramBundle);
      bdqm.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqn
 * JD-Core Version:    0.7.0.1
 */