import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class bcwk
  implements azla
{
  final int jdField_a_of_type_Int;
  bcyf jdField_a_of_type_Bcyf;
  
  public bcwk(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcyf = ((bcyf)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((bcxd)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void onSend(azlb paramazlb)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramazlb.jdField_a_of_type_Int == 0)
        {
          updateMsg(paramazlb);
          this.jdField_a_of_type_Bcyf.jdField_a_of_type_Int = 0;
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
          this.jdField_a_of_type_Bcyf.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Bcyf.jdField_a_of_type_Azkb = new azkb();
          this.jdField_a_of_type_Bcyf.jdField_a_of_type_Azkb.b = paramazlb.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bcyf.jdField_a_of_type_Azkb.jdField_a_of_type_Int = paramazlb.b;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramazlb.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
  
  public void updateMsg(azlb paramazlb)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((bcxd)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramazlb.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramazlb.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramazlb.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramazlb.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramazlb.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramazlb = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.getMultiMessageProxy();
    if (paramazlb != null) {
      paramazlb.a(localMessageForShortVideo, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwk
 * JD-Core Version:    0.7.0.1
 */