import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.story.mode.StoryEffectTextMode.6.1;
import mqq.os.MqqHandler;

public class bqbf
  implements nmg
{
  bqbf(bqav parambqav) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (paramString == null) && (bqav.a(this.a, bqav.a(this.a).d))) {
      ThreadManager.getUIHandler().post(new StoryEffectTextMode.6.1(this));
    }
    QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "HtmlOffline.checkUpByBusinessId QG_SO_BID, loaded:code =" + paramInt);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbf
 * JD-Core Version:    0.7.0.1
 */