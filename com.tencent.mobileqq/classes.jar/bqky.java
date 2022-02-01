import android.support.annotation.Nullable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

class bqky
  extends bqlf
{
  bqky(bqkv parambqkv, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
  }
  
  protected void a(@Nullable DoodleEmojiItem arg1)
  {
    super.onResult(???);
    yuk.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = null;
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqky
 * JD-Core Version:    0.7.0.1
 */