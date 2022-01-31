import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.story.mode.StoryEffectTextMode.6.1;
import mqq.os.MqqHandler;

public class bmds
  implements nbs
{
  bmds(bmdi parambmdi) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (paramString == null) && (bmdi.a(this.a, bmdi.a(this.a).d))) {
      ThreadManager.getUIHandler().post(new StoryEffectTextMode.6.1(this));
    }
    QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "HtmlOffline.checkUpByBusinessId QG_SO_BID, loaded:code =" + paramInt);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmds
 * JD-Core Version:    0.7.0.1
 */