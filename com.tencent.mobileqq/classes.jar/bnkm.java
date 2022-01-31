import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class bnkm
  implements awfy
{
  final int jdField_a_of_type_Int;
  bnlp jdField_a_of_type_Bnlp;
  
  public bnkm(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bnlp = ((bnlp)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((bnlk)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(awfz paramawfz)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((bnlk)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramawfz.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramawfz.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramawfz.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramawfz.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramawfz.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramawfz = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramawfz != null) {
      paramawfz.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(awfz paramawfz)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramawfz.jdField_a_of_type_Int == 0)
        {
          a(paramawfz);
          this.jdField_a_of_type_Bnlp.jdField_a_of_type_Int = 0;
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
          this.jdField_a_of_type_Bnlp.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Bnlp.jdField_a_of_type_Awey = new awey();
          this.jdField_a_of_type_Bnlp.jdField_a_of_type_Awey.b = paramawfz.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramawfz.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkm
 * JD-Core Version:    0.7.0.1
 */