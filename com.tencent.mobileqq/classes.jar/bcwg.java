import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class bcwg
  implements azrg
{
  final int jdField_a_of_type_Int;
  bcyb jdField_a_of_type_Bcyb;
  
  public bcwg(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcyb = ((bcyb)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((bcwz)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(azrh paramazrh)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((bcwz)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramazrh.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramazrh.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramazrh.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramazrh.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramazrh.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramazrh = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramazrh != null) {
      paramazrh.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(azrh paramazrh)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramazrh.jdField_a_of_type_Int == 0)
        {
          a(paramazrh);
          this.jdField_a_of_type_Bcyb.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
          }
          i = BaseShortVideoOprerator.MultiForwardShortVideoTask.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask);
          if (i == 0) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a(3, 0, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b);
          }
        }
        else
        {
          this.jdField_a_of_type_Bcyb.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Bcyb.jdField_a_of_type_Azqh = new azqh();
          this.jdField_a_of_type_Bcyb.jdField_a_of_type_Azqh.b = paramazrh.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bcyb.jdField_a_of_type_Azqh.jdField_a_of_type_Int = paramazrh.b;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramazrh.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwg
 * JD-Core Version:    0.7.0.1
 */