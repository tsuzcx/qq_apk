import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(api=18)
public class avxs
  implements avwq
{
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private zjr jdField_a_of_type_Zjr;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_yuv", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(zjv paramzjv)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Zjr != null) {
      this.jdField_a_of_type_Zjr.a(paramzjv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxs
 * JD-Core Version:    0.7.0.1
 */