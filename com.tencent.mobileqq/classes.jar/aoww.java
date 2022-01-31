import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoResult;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

class aoww
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  ShortVideoResult jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult;
  
  aoww(aowv paramaowv, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult = ((ShortVideoResult)paramaowv.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_Aowv.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_Aowv.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramSendResult.d;
    localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
    localMessageForShortVideo.serial();
    paramSendResult = this.jdField_a_of_type_Aowv.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.a.a();
    if (paramSendResult != null) {
      paramSendResult.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Aowv.b)
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          a(paramSendResult);
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
          }
          i = aowv.a(this.jdField_a_of_type_Aowv);
          if (i == 0) {
            this.jdField_a_of_type_Aowv.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.a(3, 0, this.jdField_a_of_type_Aowv.b);
          }
        }
        else
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramSendResult.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_Aowv.jdField_a_of_type_Int == this.jdField_a_of_type_Aowv.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_Aowv.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoww
 * JD-Core Version:    0.7.0.1
 */