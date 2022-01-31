import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class axdc
  implements auoq
{
  final int jdField_a_of_type_Int;
  axeu jdField_a_of_type_Axeu;
  
  public axdc(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Axeu = ((axeu)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((axdv)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(auor paramauor)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((axdv)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramauor.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramauor.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramauor.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramauor.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramauor.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramauor = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramauor != null) {
      paramauor.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(auor paramauor)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramauor.jdField_a_of_type_Int == 0)
        {
          a(paramauor);
          this.jdField_a_of_type_Axeu.jdField_a_of_type_Int = 0;
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
          this.jdField_a_of_type_Axeu.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Axeu.jdField_a_of_type_Aunr = new aunr();
          this.jdField_a_of_type_Axeu.jdField_a_of_type_Aunr.b = paramauor.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Axeu.jdField_a_of_type_Aunr.jdField_a_of_type_Int = paramauor.b;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramauor.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdc
 * JD-Core Version:    0.7.0.1
 */