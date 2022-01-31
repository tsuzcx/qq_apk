import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class bkzc
  implements auoq
{
  final int jdField_a_of_type_Int;
  blaf jdField_a_of_type_Blaf;
  
  public bkzc(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Blaf = ((blaf)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((blaa)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(auor paramauor)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((blaa)this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramauor.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramauor.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramauor.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramauor.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramauor.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramauor = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.a();
    if (paramauor != null) {
      paramauor.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(auor paramauor)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramauor.jdField_a_of_type_Int == 0)
        {
          a(paramauor);
          this.jdField_a_of_type_Blaf.jdField_a_of_type_Int = 0;
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
          this.jdField_a_of_type_Blaf.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Blaf.jdField_a_of_type_Aunr = new aunr();
          this.jdField_a_of_type_Blaf.jdField_a_of_type_Aunr.b = paramauor.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramauor.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzc
 * JD-Core Version:    0.7.0.1
 */