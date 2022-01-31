import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bjhy
  extends BaseShortVideoOprerator
{
  public bjhy() {}
  
  public bjhy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bjiy parambjiy)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = awbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambjiy.jdField_c_of_type_JavaLangString, parambjiy.jdField_d_of_type_JavaLangString, parambjiy.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambjiy.jdField_h_of_type_JavaLangString;
    if (parambjiy.jdField_a_of_type_JavaLangString == null) {
      parambjiy.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambjiy.jdField_a_of_type_JavaLangString;
    if (parambjiy.jdField_e_of_type_JavaLangString == null) {
      parambjiy.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambjiy.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambjiy.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambjiy.k;
    localMessageForShortVideo.videoFileFormat = parambjiy.l;
    localMessageForShortVideo.videoFileSize = parambjiy.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambjiy.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambjiy.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambjiy.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambjiy.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambjiy.jdField_g_of_type_JavaLangString;
      if (parambjiy.jdField_j_of_type_JavaLangString == null) {
        parambjiy.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambjiy.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambjiy.m;
      localMessageForShortVideo.busiType = parambjiy.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambjiy.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambjiy.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambjiy.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambjiy.n;
      localMessageForShortVideo.fileHeight = parambjiy.o;
      if (parambjiy.jdField_a_of_type_Bjiz == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambjiy.jdField_a_of_type_Bjiz.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambjiy.jdField_a_of_type_Bjiz.b;
        localMessageForShortVideo.msgUid = parambjiy.jdField_a_of_type_Bjiz.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = awei.b;; localMessageForShortVideo.msg = awei.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambjiy.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambjiy.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambjiy.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bjjg parambjjg)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambjjg.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = awbi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambjjg.jdField_c_of_type_JavaLangString, parambjjg.jdField_d_of_type_JavaLangString, parambjjg.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambjjg.jdField_h_of_type_JavaLangString;
      if (parambjjg.jdField_a_of_type_JavaLangString == null) {
        parambjjg.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambjjg.jdField_a_of_type_JavaLangString;
      if (parambjjg.jdField_e_of_type_JavaLangString == null) {
        parambjjg.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambjjg.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambjjg.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambjjg.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambjjg.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambjjg.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambjjg.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambjjg.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambjjg.jdField_g_of_type_JavaLangString;
      if (parambjjg.k == null) {
        parambjjg.k = "";
      }
      localMessageForShortVideo.fileSource = parambjjg.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambjjg.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambjjg.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambjjg.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambjjg.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambjjg.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambjjg.jdField_e_of_type_Boolean;
      String str2 = awav.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambjjg.jdField_a_of_type_Bjjh == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambjjg.jdField_a_of_type_Bjjh.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambjjg.jdField_a_of_type_Bjjh.b;
        localMessageForShortVideo.msgUid = parambjjg.jdField_a_of_type_Bjjh.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = awei.b;
      label399:
      if (!parambjjg.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambjjg.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = awbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambjjg.jdField_c_of_type_JavaLangString, parambjjg.jdField_d_of_type_JavaLangString, parambjjg.jdField_b_of_type_Int);
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
      if (2 == parambjjg.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambjjg.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = awei.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(atqr paramatqr)
  {
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramatqr);
    if (paramatqr != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramatqr.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramatqr.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramatqr.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramatqr.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramatqr.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramatqr.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhy
 * JD-Core Version:    0.7.0.1
 */