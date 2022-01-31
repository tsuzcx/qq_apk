import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;

public class anxx
  implements Runnable
{
  ShortVideoForwardInfo jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo;
  
  public anxx(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo = paramShortVideoForwardInfo;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo == null) {}
    for (;;)
    {
      return;
      ShortVideoForwardInfo localShortVideoForwardInfo = this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo;
      Object localObject;
      int i;
      if (localShortVideoForwardInfo.k == 3)
      {
        localObject = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.a(localShortVideoForwardInfo);
        i = 1;
      }
      while (localObject != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localTransferRequest.c = ((MessageRecord)localObject).frienduin;
        localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localTransferRequest.jdField_b_of_type_Int = 20;
        localTransferRequest.jdField_a_of_type_JavaLangObject = localShortVideoForwardInfo;
        localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localTransferRequest.jdField_a_of_type_Boolean = true;
        localTransferRequest.e = 0;
        localTransferRequest.f = localShortVideoForwardInfo.e;
        localTransferRequest.i = (localShortVideoForwardInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.g);
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator;
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
        if (i != 0) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.a((MessageRecord)localObject);
        }
        Logger.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        Logger.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localShortVideoForwardInfo.k == 4)
        {
          localObject = (MessageForShortVideo)localShortVideoForwardInfo.jdField_a_of_type_JavaLangObject;
          i = 0;
        }
        else
        {
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxx
 * JD-Core Version:    0.7.0.1
 */