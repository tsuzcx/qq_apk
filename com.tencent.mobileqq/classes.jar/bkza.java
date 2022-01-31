import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class bkza
  extends BaseShortVideoOprerator
{
  public bkza() {}
  
  public bkza(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(blaa paramblaa)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramblaa.jdField_c_of_type_JavaLangString, paramblaa.jdField_d_of_type_JavaLangString, paramblaa.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramblaa.jdField_h_of_type_JavaLangString;
    if (paramblaa.jdField_a_of_type_JavaLangString == null) {
      paramblaa.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramblaa.jdField_a_of_type_JavaLangString;
    if (paramblaa.jdField_e_of_type_JavaLangString == null) {
      paramblaa.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramblaa.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = paramblaa.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = paramblaa.k;
    localMessageForShortVideo.videoFileFormat = paramblaa.l;
    localMessageForShortVideo.videoFileSize = paramblaa.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramblaa.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramblaa.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramblaa.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramblaa.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramblaa.jdField_g_of_type_JavaLangString;
      if (paramblaa.jdField_j_of_type_JavaLangString == null) {
        paramblaa.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramblaa.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramblaa.m;
      localMessageForShortVideo.busiType = paramblaa.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = paramblaa.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramblaa.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramblaa.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramblaa.n;
      localMessageForShortVideo.fileHeight = paramblaa.o;
      if (paramblaa.jdField_a_of_type_Blab == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramblaa.jdField_a_of_type_Blab.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramblaa.jdField_a_of_type_Blab.b;
        localMessageForShortVideo.msgUid = paramblaa.jdField_a_of_type_Blab.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = axds.b;; localMessageForShortVideo.msg = axds.jdField_a_of_type_JavaLangString)
    {
      localMessageForShortVideo.serial();
      paramblaa.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramblaa.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramblaa.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(blai paramblai)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (paramblai.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = axas.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramblai.jdField_c_of_type_JavaLangString, paramblai.jdField_d_of_type_JavaLangString, paramblai.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramblai.jdField_h_of_type_JavaLangString;
      if (paramblai.jdField_a_of_type_JavaLangString == null) {
        paramblai.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = paramblai.jdField_a_of_type_JavaLangString;
      if (paramblai.jdField_e_of_type_JavaLangString == null) {
        paramblai.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = paramblai.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramblai.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = paramblai.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = paramblai.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = paramblai.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = paramblai.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramblai.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramblai.jdField_g_of_type_JavaLangString;
      if (paramblai.k == null) {
        paramblai.k = "";
      }
      localMessageForShortVideo.fileSource = paramblai.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramblai.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (paramblai.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = paramblai.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramblai.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = paramblai.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = paramblai.jdField_e_of_type_Boolean;
      String str2 = axaf.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (paramblai.jdField_a_of_type_Blaj == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramblai.jdField_a_of_type_Blaj.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramblai.jdField_a_of_type_Blaj.b;
        localMessageForShortVideo.msgUid = paramblai.jdField_a_of_type_Blaj.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = axds.b;
      label399:
      if (!paramblai.jdField_g_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      paramblai.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramblai.jdField_c_of_type_JavaLangString, paramblai.jdField_d_of_type_JavaLangString, paramblai.jdField_b_of_type_Int);
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
      if (2 == paramblai.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == paramblai.jdField_a_of_type_Int)
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
      localMessageForShortVideo.msg = axds.jdField_a_of_type_JavaLangString;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(auor paramauor)
  {
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramauor);
    if (paramauor != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramauor.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramauor.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramauor.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramauor.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramauor.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramauor.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkza
 * JD-Core Version:    0.7.0.1
 */