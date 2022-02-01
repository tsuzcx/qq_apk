import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bpqk
  extends BaseShortVideoOprerator
{
  public bpqk() {}
  
  public bpqk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(bpra parambpra)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambpra.jdField_c_of_type_JavaLangString, parambpra.jdField_d_of_type_JavaLangString, parambpra.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = parambpra.jdField_h_of_type_JavaLangString;
    if (parambpra.jdField_a_of_type_JavaLangString == null) {
      parambpra.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = parambpra.jdField_a_of_type_JavaLangString;
    if (parambpra.jdField_e_of_type_JavaLangString == null) {
      parambpra.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = parambpra.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = parambpra.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = parambpra.k;
    localMessageForShortVideo.videoFileFormat = parambpra.l;
    localMessageForShortVideo.videoFileSize = parambpra.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = parambpra.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = parambpra.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = parambpra.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (parambpra.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = parambpra.jdField_g_of_type_JavaLangString;
      if (parambpra.jdField_j_of_type_JavaLangString == null) {
        parambpra.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = parambpra.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = parambpra.m;
      localMessageForShortVideo.busiType = parambpra.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = parambpra.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = parambpra.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = parambpra.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambpra.n;
      localMessageForShortVideo.fileHeight = parambpra.o;
      if (parambpra.jdField_a_of_type_Bprb == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambpra.jdField_a_of_type_Bprb.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambpra.jdField_a_of_type_Bprb.b;
        localMessageForShortVideo.msgUid = parambpra.jdField_a_of_type_Bprb.jdField_c_of_type_Long;
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
      parambpra.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (parambpra.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (parambpra.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(bprh parambprh)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (parambprh.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = bcsa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambprh.jdField_c_of_type_JavaLangString, parambprh.jdField_d_of_type_JavaLangString, parambprh.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = parambprh.jdField_h_of_type_JavaLangString;
      if (parambprh.jdField_a_of_type_JavaLangString == null) {
        parambprh.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = parambprh.jdField_a_of_type_JavaLangString;
      if (parambprh.jdField_e_of_type_JavaLangString == null) {
        parambprh.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = parambprh.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = parambprh.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = parambprh.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = parambprh.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = parambprh.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = parambprh.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = parambprh.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = parambprh.jdField_g_of_type_JavaLangString;
      if (parambprh.k == null) {
        parambprh.k = "";
      }
      localMessageForShortVideo.fileSource = parambprh.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = parambprh.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (parambprh.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = parambprh.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = parambprh.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = parambprh.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = parambprh.jdField_e_of_type_Boolean;
      String str2 = bcrn.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (parambprh.jdField_a_of_type_Bpri == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = parambprh.jdField_a_of_type_Bpri.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = parambprh.jdField_a_of_type_Bpri.b;
        localMessageForShortVideo.msgUid = parambprh.jdField_a_of_type_Bpri.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
      label399:
      if (!parambprh.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      parambprh.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambprh.jdField_c_of_type_JavaLangString, parambprh.jdField_d_of_type_JavaLangString, parambprh.jdField_b_of_type_Int);
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
      if (2 == parambprh.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == parambprh.jdField_a_of_type_Int)
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
    azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void updateMsg(azlb paramazlb)
  {
    azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramazlb);
    if (paramazlb != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramazlb.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramazlb.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramazlb.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramazlb.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramazlb.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramazlb.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqk
 * JD-Core Version:    0.7.0.1
 */