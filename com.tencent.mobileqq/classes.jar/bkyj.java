import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bkyj
  extends BaseShortVideoOprerator
{
  public bkyj() {}
  
  public bkyj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bkzj parambkzj)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambkzj.jdField_c_of_type_JavaLangString, parambkzj.jdField_d_of_type_JavaLangString, parambkzj.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambkzj.jdField_h_of_type_JavaLangString;
    if (parambkzj.jdField_a_of_type_JavaLangString == null) {
      parambkzj.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambkzj.jdField_a_of_type_JavaLangString;
    if (parambkzj.jdField_e_of_type_JavaLangString == null) {
      parambkzj.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambkzj.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambkzj.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambkzj.k;
    localMessageForShortVideo.videoFileFormat = parambkzj.l;
    localMessageForShortVideo.videoFileSize = parambkzj.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambkzj.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambkzj.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambkzj.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambkzj.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambkzj.jdField_g_of_type_JavaLangString;
      if (parambkzj.jdField_j_of_type_JavaLangString == null) {
        parambkzj.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambkzj.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambkzj.m;
      localMessageForShortVideo.busiType = parambkzj.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambkzj.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambkzj.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambkzj.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambkzj.n;
      localMessageForShortVideo.fileHeight = parambkzj.o;
      if (parambkzj.jdField_a_of_type_Bkzk == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambkzj.jdField_a_of_type_Bkzk.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambkzj.jdField_a_of_type_Bkzk.b;
        localMessageForShortVideo.msgUid = parambkzj.jdField_a_of_type_Bkzk.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = axdq.b;; localMessageForShortVideo.msg = axdq.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambkzj.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambkzj.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambkzj.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bkzr parambkzr)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambkzr.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = axaq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambkzr.jdField_c_of_type_JavaLangString, parambkzr.jdField_d_of_type_JavaLangString, parambkzr.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambkzr.jdField_h_of_type_JavaLangString;
      if (parambkzr.jdField_a_of_type_JavaLangString == null) {
        parambkzr.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambkzr.jdField_a_of_type_JavaLangString;
      if (parambkzr.jdField_e_of_type_JavaLangString == null) {
        parambkzr.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambkzr.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambkzr.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambkzr.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambkzr.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambkzr.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambkzr.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambkzr.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambkzr.jdField_g_of_type_JavaLangString;
      if (parambkzr.k == null) {
        parambkzr.k = "";
      }
      localMessageForShortVideo.fileSource = parambkzr.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambkzr.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambkzr.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambkzr.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambkzr.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambkzr.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambkzr.jdField_e_of_type_Boolean;
      String str2 = axad.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambkzr.jdField_a_of_type_Bkzs == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambkzr.jdField_a_of_type_Bkzs.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambkzr.jdField_a_of_type_Bkzs.b;
        localMessageForShortVideo.msgUid = parambkzr.jdField_a_of_type_Bkzs.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = axdq.b;
      label399:
      if (!parambkzr.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambkzr.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambkzr.jdField_c_of_type_JavaLangString, parambkzr.jdField_d_of_type_JavaLangString, parambkzr.jdField_b_of_type_Int);
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
      if (2 == parambkzr.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambkzr.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = axdq.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(auop paramauop)
  {
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramauop);
    if (paramauop != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramauop.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramauop.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramauop.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramauop.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramauop.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramauop.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkyj
 * JD-Core Version:    0.7.0.1
 */