import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(api=18)
public class arcy
  implements arcg
{
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private vtn jdField_a_of_type_Vtn;
  
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
  
  public void a(vtr paramvtr)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Vtn != null) {
      this.jdField_a_of_type_Vtn.a(paramvtr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcy
 * JD-Core Version:    0.7.0.1
 */