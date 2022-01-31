import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;

public class anxn
  extends anxr
{
  public anxn(DoodleEmojiManager paramDoodleEmojiManager, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
  }
  
  protected void a(@Nullable DoodleEmojiItem arg1)
  {
    super.onResult(???);
    SLog.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = null;
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxn
 * JD-Core Version:    0.7.0.1
 */