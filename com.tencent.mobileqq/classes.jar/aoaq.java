import com.tencent.image.VideoDrawable;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;

public class aoaq
  implements Runnable
{
  public aoaq(ImageViewVideoPlayer paramImageViewVideoPlayer, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      if (QLog.isColorLevel()) {
        QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes = " + this.jdField_a_of_type_Int + ", costTime = " + (System.currentTimeMillis() - l));
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener.at_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoaq
 * JD-Core Version:    0.7.0.1
 */