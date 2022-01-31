import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bnkk
  extends BaseShortVideoOprerator
{
  public bnkk() {}
  
  public bnkk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bnlk parambnlk)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnlk.jdField_c_of_type_JavaLangString, parambnlk.jdField_d_of_type_JavaLangString, parambnlk.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambnlk.jdField_h_of_type_JavaLangString;
    if (parambnlk.jdField_a_of_type_JavaLangString == null) {
      parambnlk.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambnlk.jdField_a_of_type_JavaLangString;
    if (parambnlk.jdField_e_of_type_JavaLangString == null) {
      parambnlk.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambnlk.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambnlk.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambnlk.k;
    localMessageForShortVideo.videoFileFormat = parambnlk.l;
    localMessageForShortVideo.videoFileSize = parambnlk.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambnlk.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambnlk.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambnlk.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambnlk.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambnlk.jdField_g_of_type_JavaLangString;
      if (parambnlk.jdField_j_of_type_JavaLangString == null) {
        parambnlk.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambnlk.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambnlk.m;
      localMessageForShortVideo.busiType = parambnlk.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambnlk.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambnlk.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambnlk.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambnlk.n;
      localMessageForShortVideo.fileHeight = parambnlk.o;
      if (parambnlk.jdField_a_of_type_Bnll == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambnlk.jdField_a_of_type_Bnll.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambnlk.jdField_a_of_type_Bnll.b;
        localMessageForShortVideo.msgUid = parambnlk.jdField_a_of_type_Bnll.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = ayyw.b;; localMessageForShortVideo.msg = ayyw.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambnlk.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambnlk.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambnlk.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bnls parambnls)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambnls.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = ayvw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnls.jdField_c_of_type_JavaLangString, parambnls.jdField_d_of_type_JavaLangString, parambnls.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambnls.jdField_h_of_type_JavaLangString;
      if (parambnls.jdField_a_of_type_JavaLangString == null) {
        parambnls.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambnls.jdField_a_of_type_JavaLangString;
      if (parambnls.jdField_e_of_type_JavaLangString == null) {
        parambnls.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambnls.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambnls.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambnls.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambnls.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambnls.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambnls.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambnls.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambnls.jdField_g_of_type_JavaLangString;
      if (parambnls.k == null) {
        parambnls.k = "";
      }
      localMessageForShortVideo.fileSource = parambnls.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambnls.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambnls.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambnls.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambnls.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambnls.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambnls.jdField_e_of_type_Boolean;
      String str2 = ayvj.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambnls.jdField_a_of_type_Bnlt == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambnls.jdField_a_of_type_Bnlt.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambnls.jdField_a_of_type_Bnlt.b;
        localMessageForShortVideo.msgUid = parambnls.jdField_a_of_type_Bnlt.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = ayyw.b;
      label399:
      if (!parambnls.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambnls.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnls.jdField_c_of_type_JavaLangString, parambnls.jdField_d_of_type_JavaLangString, parambnls.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 0;
      break;
      label552:
      if (localMessageForShortVideo.istroop == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break label234;
      }
      if (localMessageForShortVideo.istroop != 1) {
        break label234;
      }
      localMessageForShortVideo.fileType = 9;
      break label234;
      label592:
      if (2 == parambnls.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambnls.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 2;
        break label252;
      }
      localMessageForShortVideo.busiType = 0;
      break label252;
      label635:
      str1 = "0";
      break label324;
      label643:
      i = 0;
      break label342;
      label648:
      localMessageForShortVideo.msg = ayyw.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(awfz paramawfz)
  {
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramawfz);
    if (paramawfz != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramawfz.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramawfz.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramawfz.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramawfz.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramawfz.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramawfz.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkk
 * JD-Core Version:    0.7.0.1
 */