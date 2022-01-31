import android.support.annotation.Nullable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

class bmnl
  extends bmns
{
  bmnl(bmni parambmni, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
  }
  
  protected void a(@Nullable DoodleEmojiItem arg1)
  {
    super.onResult(???);
    wsv.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = null;
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnl
 * JD-Core Version:    0.7.0.1
 */