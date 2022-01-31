import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;

public class anvz
  implements Runnable
{
  public anvz(HWEditImportVideoPlayer paramHWEditImportVideoPlayer, long paramLong) {}
  
  public void run()
  {
    long l2 = this.jdField_a_of_type_Long / 1000000L;
    long l1;
    if (l2 < HWEditImportVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditImportVideoPlayer)) {
      l1 = HWEditImportVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditImportVideoPlayer);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditImportVideoPlayer.a.a(Message.obtain(null, 13, Long.valueOf(l1)));
      return;
      l1 = l2;
      if (l2 > HWEditImportVideoPlayer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditImportVideoPlayer)) {
        l1 = HWEditImportVideoPlayer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditImportVideoPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvz
 * JD-Core Version:    0.7.0.1
 */