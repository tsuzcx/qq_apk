import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class brhd
  implements azrg
{
  final int jdField_a_of_type_Int;
  brid jdField_a_of_type_Brid;
  
  public brhd(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Brid = ((brid)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((brhx)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(azrh paramazrh)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((brhx)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramazrh.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramazrh.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramazrh.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramazrh.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramazrh.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramazrh = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramazrh != null) {
      paramazrh.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(azrh paramazrh)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramazrh.jdField_a_of_type_Int == 0)
        {
          a(paramazrh);
          this.jdField_a_of_type_Brid.jdField_a_of_type_Int = 0;
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
          this.jdField_a_of_type_Brid.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Brid.jdField_a_of_type_Azqh = new azqh();
          this.jdField_a_of_type_Brid.jdField_a_of_type_Azqh.b = paramazrh.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramazrh.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhd
 * JD-Core Version:    0.7.0.1
 */