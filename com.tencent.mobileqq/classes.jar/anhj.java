import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;

public class anhj
  implements LbsManager.LbsUpdateListener
{
  public anhj(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces onLbsUpdate.");
    if ((paramBoolean) && (paramBasicLocation != null) && (this.a.a != null)) {
      this.a.a(paramBasicLocation.b, paramBasicLocation.a, this.a.a);
    }
    for (;;)
    {
      paramBasicLocation = (LbsManager)SuperManager.a(9);
      if (paramBasicLocation != null) {
        paramBasicLocation.b(this);
      }
      this.a.a = null;
      return;
      SLog.e("DoodleEmojiManager", "onLbsUpdate failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anhj
 * JD-Core Version:    0.7.0.1
 */