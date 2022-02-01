import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bqfq
  extends BaseShortVideoOprerator
{
  public bqfq() {}
  
  public bqfq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bqgm parambqgm)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambqgm.jdField_c_of_type_JavaLangString, parambqgm.jdField_d_of_type_JavaLangString, parambqgm.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambqgm.jdField_h_of_type_JavaLangString;
    if (parambqgm.jdField_a_of_type_JavaLangString == null) {
      parambqgm.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambqgm.jdField_a_of_type_JavaLangString;
    if (parambqgm.jdField_e_of_type_JavaLangString == null) {
      parambqgm.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambqgm.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambqgm.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambqgm.k;
    localMessageForShortVideo.videoFileFormat = parambqgm.l;
    localMessageForShortVideo.videoFileSize = parambqgm.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambqgm.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambqgm.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambqgm.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambqgm.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambqgm.jdField_g_of_type_JavaLangString;
      if (parambqgm.jdField_j_of_type_JavaLangString == null) {
        parambqgm.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambqgm.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambqgm.m;
      localMessageForShortVideo.busiType = parambqgm.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambqgm.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambqgm.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambqgm.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambqgm.n;
      localMessageForShortVideo.fileHeight = parambqgm.o;
      if (parambqgm.jdField_a_of_type_Bqgn == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambqgm.jdField_a_of_type_Bqgn.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambqgm.jdField_a_of_type_Bqgn.b;
        localMessageForShortVideo.msgUid = parambqgm.jdField_a_of_type_Bqgn.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = bcee.b;; localMessageForShortVideo.msg = bcee.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      parambqgm.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambqgm.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambqgm.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bqgs parambqgs)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambqgs.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = bbzh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambqgs.jdField_c_of_type_JavaLangString, parambqgs.jdField_d_of_type_JavaLangString, parambqgs.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambqgs.jdField_h_of_type_JavaLangString;
      if (parambqgs.jdField_a_of_type_JavaLangString == null) {
        parambqgs.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambqgs.jdField_a_of_type_JavaLangString;
      if (parambqgs.jdField_e_of_type_JavaLangString == null) {
        parambqgs.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambqgs.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambqgs.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambqgs.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambqgs.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambqgs.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambqgs.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambqgs.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambqgs.jdField_g_of_type_JavaLangString;
      if (parambqgs.k == null) {
        parambqgs.k = "";
      }
      localMessageForShortVideo.fileSource = parambqgs.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambqgs.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambqgs.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambqgs.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambqgs.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambqgs.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambqgs.jdField_e_of_type_Boolean;
      String str2 = bbyw.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambqgs.jdField_a_of_type_Bqgt == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambqgs.jdField_a_of_type_Bqgt.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambqgs.jdField_a_of_type_Bqgt.b;
        localMessageForShortVideo.msgUid = parambqgs.jdField_a_of_type_Bqgt.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = bcee.b;
      label399:
      if (!parambqgs.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambqgs.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambqgs.jdField_c_of_type_JavaLangString, parambqgs.jdField_d_of_type_JavaLangString, parambqgs.jdField_b_of_type_Int);
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
      if (2 == parambqgs.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambqgs.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = bcee.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(ayyu paramayyu)
  {
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramayyu);
    if (paramayyu != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramayyu.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramayyu.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramayyu.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramayyu.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramayyu.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramayyu.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfq
 * JD-Core Version:    0.7.0.1
 */