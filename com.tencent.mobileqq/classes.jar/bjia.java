import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class bjia
  implements atqq
{
  final int jdField_a_of_type_Int;
  bjjd jdField_a_of_type_Bjjd;
  
  public bjia(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bjjd = ((bjjd)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((bjiy)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(atqr paramatqr)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((bjiy)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramatqr.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramatqr.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramatqr.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramatqr.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramatqr.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramatqr = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramatqr != null) {
      paramatqr.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(atqr paramatqr)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramatqr.jdField_a_of_type_Int == 0)
        {
          a(paramatqr);
          this.jdField_a_of_type_Bjjd.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
          }
          i = BaseShortVideoOprerator.MultiForwardShortVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask);
          if (i == 0) {
            this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a(3, 0, this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b);
          }
        }
        else
        {
          this.jdField_a_of_type_Bjjd.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Bjjd.jdField_a_of_type_Atpr = new atpr();
          this.jdField_a_of_type_Bjjd.jdField_a_of_type_Atpr.b = paramatqr.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramatqr.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjia
 * JD-Core Version:    0.7.0.1
 */