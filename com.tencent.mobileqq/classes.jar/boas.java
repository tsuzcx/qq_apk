import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class boas
  extends BaseShortVideoOprerator
{
  public boas() {}
  
  public boas(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bobi parambobi)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = bbli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambobi.jdField_c_of_type_JavaLangString, parambobi.jdField_d_of_type_JavaLangString, parambobi.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambobi.jdField_h_of_type_JavaLangString;
    if (parambobi.jdField_a_of_type_JavaLangString == null) {
      parambobi.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambobi.jdField_a_of_type_JavaLangString;
    if (parambobi.jdField_e_of_type_JavaLangString == null) {
      parambobi.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambobi.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambobi.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambobi.k;
    localMessageForShortVideo.videoFileFormat = parambobi.l;
    localMessageForShortVideo.videoFileSize = parambobi.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambobi.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambobi.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambobi.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambobi.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambobi.jdField_g_of_type_JavaLangString;
      if (parambobi.jdField_j_of_type_JavaLangString == null) {
        parambobi.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambobi.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambobi.m;
      localMessageForShortVideo.busiType = parambobi.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambobi.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambobi.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambobi.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambobi.n;
      localMessageForShortVideo.fileHeight = parambobi.o;
      if (parambobi.jdField_a_of_type_Bobj == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambobi.jdField_a_of_type_Bobj.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambobi.jdField_a_of_type_Bobj.b;
        localMessageForShortVideo.msgUid = parambobi.jdField_a_of_type_Bobj.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;; localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG)
    {
      localMessageForShortVideo.serial();
      parambobi.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambobi.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambobi.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bobp parambobp)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambobp.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = bbli.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambobp.jdField_c_of_type_JavaLangString, parambobp.jdField_d_of_type_JavaLangString, parambobp.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambobp.jdField_h_of_type_JavaLangString;
      if (parambobp.jdField_a_of_type_JavaLangString == null) {
        parambobp.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambobp.jdField_a_of_type_JavaLangString;
      if (parambobp.jdField_e_of_type_JavaLangString == null) {
        parambobp.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambobp.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambobp.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambobp.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambobp.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambobp.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambobp.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambobp.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambobp.jdField_g_of_type_JavaLangString;
      if (parambobp.k == null) {
        parambobp.k = "";
      }
      localMessageForShortVideo.fileSource = parambobp.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambobp.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambobp.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambobp.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambobp.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambobp.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambobp.jdField_e_of_type_Boolean;
      String str2 = bbkv.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambobp.jdField_a_of_type_Bobq == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambobp.jdField_a_of_type_Bobq.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambobp.jdField_a_of_type_Bobq.b;
        localMessageForShortVideo.msgUid = parambobp.jdField_a_of_type_Bobq.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
      label399:
      if (!parambobp.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambobp.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = bbli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambobp.jdField_c_of_type_JavaLangString, parambobp.jdField_d_of_type_JavaLangString, parambobp.jdField_b_of_type_Int);
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
      if (2 == parambobp.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambobp.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void updateMsg(ayep paramayep)
  {
    ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramayep);
    if (paramayep != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramayep.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramayep.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramayep.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramayep.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramayep.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramayep.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boas
 * JD-Core Version:    0.7.0.1
 */