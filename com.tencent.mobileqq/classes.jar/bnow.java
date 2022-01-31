import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bnow
  extends BaseShortVideoOprerator
{
  public bnow() {}
  
  public bnow(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bnpw parambnpw)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnpw.jdField_c_of_type_JavaLangString, parambnpw.jdField_d_of_type_JavaLangString, parambnpw.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambnpw.jdField_h_of_type_JavaLangString;
    if (parambnpw.jdField_a_of_type_JavaLangString == null) {
      parambnpw.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambnpw.jdField_a_of_type_JavaLangString;
    if (parambnpw.jdField_e_of_type_JavaLangString == null) {
      parambnpw.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambnpw.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambnpw.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambnpw.k;
    localMessageForShortVideo.videoFileFormat = parambnpw.l;
    localMessageForShortVideo.videoFileSize = parambnpw.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambnpw.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambnpw.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambnpw.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambnpw.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambnpw.jdField_g_of_type_JavaLangString;
      if (parambnpw.jdField_j_of_type_JavaLangString == null) {
        parambnpw.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambnpw.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambnpw.m;
      localMessageForShortVideo.busiType = parambnpw.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambnpw.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambnpw.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambnpw.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambnpw.n;
      localMessageForShortVideo.fileHeight = parambnpw.o;
      if (parambnpw.jdField_a_of_type_Bnpx == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambnpw.jdField_a_of_type_Bnpx.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambnpw.jdField_a_of_type_Bnpx.b;
        localMessageForShortVideo.msgUid = parambnpw.jdField_a_of_type_Bnpx.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = azdf.b;; localMessageForShortVideo.msg = azdf.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambnpw.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambnpw.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambnpw.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bnqe parambnqe)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambnqe.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = azaf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnqe.jdField_c_of_type_JavaLangString, parambnqe.jdField_d_of_type_JavaLangString, parambnqe.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambnqe.jdField_h_of_type_JavaLangString;
      if (parambnqe.jdField_a_of_type_JavaLangString == null) {
        parambnqe.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambnqe.jdField_a_of_type_JavaLangString;
      if (parambnqe.jdField_e_of_type_JavaLangString == null) {
        parambnqe.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambnqe.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambnqe.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambnqe.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambnqe.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambnqe.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambnqe.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambnqe.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambnqe.jdField_g_of_type_JavaLangString;
      if (parambnqe.k == null) {
        parambnqe.k = "";
      }
      localMessageForShortVideo.fileSource = parambnqe.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambnqe.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambnqe.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambnqe.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambnqe.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambnqe.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambnqe.jdField_e_of_type_Boolean;
      String str2 = ayzs.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambnqe.jdField_a_of_type_Bnqf == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambnqe.jdField_a_of_type_Bnqf.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambnqe.jdField_a_of_type_Bnqf.b;
        localMessageForShortVideo.msgUid = parambnqe.jdField_a_of_type_Bnqf.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = azdf.b;
      label399:
      if (!parambnqe.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambnqe.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambnqe.jdField_c_of_type_JavaLangString, parambnqe.jdField_d_of_type_JavaLangString, parambnqe.jdField_b_of_type_Int);
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
      if (2 == parambnqe.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambnqe.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = azdf.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(awki paramawki)
  {
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramawki);
    if (paramawki != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramawki.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramawki.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramawki.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramawki.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramawki.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramawki.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnow
 * JD-Core Version:    0.7.0.1
 */