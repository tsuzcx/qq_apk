import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class brhb
  extends BaseShortVideoOprerator
{
  public brhb() {}
  
  public brhb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(brhx parambrhx)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambrhx.jdField_c_of_type_JavaLangString, parambrhx.jdField_d_of_type_JavaLangString, parambrhx.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambrhx.jdField_h_of_type_JavaLangString;
    if (parambrhx.jdField_a_of_type_JavaLangString == null) {
      parambrhx.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambrhx.jdField_a_of_type_JavaLangString;
    if (parambrhx.jdField_e_of_type_JavaLangString == null) {
      parambrhx.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambrhx.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambrhx.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambrhx.k;
    localMessageForShortVideo.videoFileFormat = parambrhx.l;
    localMessageForShortVideo.videoFileSize = parambrhx.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambrhx.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambrhx.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambrhx.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambrhx.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambrhx.jdField_g_of_type_JavaLangString;
      if (parambrhx.jdField_j_of_type_JavaLangString == null) {
        parambrhx.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambrhx.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambrhx.m;
      localMessageForShortVideo.busiType = parambrhx.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambrhx.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambrhx.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambrhx.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambrhx.n;
      localMessageForShortVideo.fileHeight = parambrhx.o;
      if (parambrhx.jdField_a_of_type_Brhy == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambrhx.jdField_a_of_type_Brhy.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambrhx.jdField_a_of_type_Brhy.b;
        localMessageForShortVideo.msgUid = parambrhx.jdField_a_of_type_Brhy.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = bcww.b;; localMessageForShortVideo.msg = bcww.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambrhx.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambrhx.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambrhx.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(brie parambrie)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambrie.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = bcry.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambrie.jdField_c_of_type_JavaLangString, parambrie.jdField_d_of_type_JavaLangString, parambrie.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambrie.jdField_h_of_type_JavaLangString;
      if (parambrie.jdField_a_of_type_JavaLangString == null) {
        parambrie.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambrie.jdField_a_of_type_JavaLangString;
      if (parambrie.jdField_e_of_type_JavaLangString == null) {
        parambrie.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambrie.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambrie.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambrie.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambrie.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambrie.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambrie.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambrie.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambrie.jdField_g_of_type_JavaLangString;
      if (parambrie.k == null) {
        parambrie.k = "";
      }
      localMessageForShortVideo.fileSource = parambrie.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambrie.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambrie.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambrie.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambrie.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambrie.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambrie.jdField_e_of_type_Boolean;
      String str2 = bcrn.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambrie.jdField_a_of_type_Brif == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambrie.jdField_a_of_type_Brif.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambrie.jdField_a_of_type_Brif.b;
        localMessageForShortVideo.msgUid = parambrie.jdField_a_of_type_Brif.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = bcww.b;
      label399:
      if (!parambrie.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambrie.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambrie.jdField_c_of_type_JavaLangString, parambrie.jdField_d_of_type_JavaLangString, parambrie.jdField_b_of_type_Int);
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
      if (2 == parambrie.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambrie.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = bcww.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(azrh paramazrh)
  {
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramazrh);
    if (paramazrh != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramazrh.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramazrh.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramazrh.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramazrh.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramazrh.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramazrh.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhb
 * JD-Core Version:    0.7.0.1
 */