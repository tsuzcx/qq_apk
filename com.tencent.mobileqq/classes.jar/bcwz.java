import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bcwz
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static bcwm a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new bcwi();
    case 1: 
      return new abhs();
    }
    return new abhr();
  }
  
  public static bcxd a(int paramInt, Object paramObject, bcxr parambcxr)
  {
    bcwm localbcwm = a(paramInt);
    if (localbcwm == null) {
      return null;
    }
    return localbcwm.a(paramObject, parambcxr);
  }
  
  public static bcxr a(int paramInt1, int paramInt2)
  {
    bcxr localbcxr = new bcxr();
    localbcxr.jdField_a_of_type_Int = paramInt1;
    localbcxr.jdField_b_of_type_Int = paramInt2;
    return localbcxr;
  }
  
  public static bcxr a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    bcxr localbcxr = a(2, paramMessageForShortVideo.busiType);
    bcxb localbcxb = paramMessageForShortVideo.getDownloadInfo(localbcxr.jdField_b_of_type_Int);
    localbcxb.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localbcxb.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localbcxb.a = false;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if ((!paramQQAppInterface.isChatting()) || (!paramQQAppInterface.getCurrChatUin().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localbcxb.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localbcxb.e = 1001;
    }
    for (;;)
    {
      localbcxr.a(localbcxb);
      localbcxr.a(paramMessageForShortVideo);
      return localbcxr;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localbcxb.a = true;
      break;
      label161:
      localbcxb.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localbcxb.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localbcxb.e = 1003;
      }
    }
  }
  
  public static bcyj a(int paramInt, Object paramObject, bcxr parambcxr)
  {
    bcwm localbcwm = a(paramInt);
    if (localbcwm == null) {
      return null;
    }
    return localbcwm.a(paramObject, parambcxr);
  }
  
  public static bcyj a(Object paramObject, bcxr parambcxr)
  {
    bcwm localbcwm = a(parambcxr.jdField_b_of_type_Int);
    if (localbcwm == null) {
      return null;
    }
    return localbcwm.a(paramObject, parambcxr);
  }
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new bcwi(paramQQAppInterface);
    case 1: 
      return new abhs(paramQQAppInterface);
    }
    return new abhr(paramQQAppInterface);
  }
  
  public static void a(bcxr parambcxr, QQAppInterface paramQQAppInterface)
  {
    if (parambcxr == null)
    {
      azjq.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambcxr.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      azjq.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambcxr.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bcxr = parambcxr;
    localBaseShortVideoOprerator.f = parambcxr.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = parambcxr.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcyl);
    azjq.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.getReqCmdStr(parambcxr.jdField_a_of_type_Int) + ", reqBusiType" + parambcxr.jdField_b_of_type_Int + ", uuid:" + parambcxr.jdField_a_of_type_JavaLangString);
    switch (parambcxr.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcyj);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcxb);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcyj);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcxd);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_Bcxd);
      return;
    }
    localBaseShortVideoOprerator.a(parambcxr.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileMsg paramFileMsg, TransferRequest paramTransferRequest)
  {
    if ((paramFileMsg == null) || (paramTransferRequest == null)) {
      azjq.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
    }
    label497:
    do
    {
      MessageRecord localMessageRecord;
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          return;
          if (paramTransferRequest.mRec != null) {
            localMessageRecord = paramTransferRequest.mRec;
          }
          while (localMessageRecord == null)
          {
            azjq.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, paramTransferRequest.mUniseq);
            azjq.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramFileMsg.fileSize == 0L) {}
        for (int i = 0;; i = (int)(100L * paramFileMsg.transferedSize / paramFileMsg.fileSize))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramFileMsg.status) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
          {
            if (paramFileMsg.status == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramFileMsg.transferedSize);
            }
            if (paramFileMsg.status == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.status == 1002) || (paramFileMsg.status == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramFileMsg.status;
          localMessageForShortVideo.fileType = paramFileMsg.fileType;
          if ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 16) && (paramFileMsg.fileType != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramFileMsg.status == 1003) && (paramTransferRequest.mMd5 != null)) {
            localMessageForShortVideo.md5 = paramTransferRequest.mMd5;
          }
          if (paramFileMsg.status == 2003) {
            localMessageForShortVideo.lastModified = new File(paramTransferRequest.mOutFilePath).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramTransferRequest.mBusiType != 1010)) {
            break label497;
          }
          if ((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) {
            break;
          }
          paramQQAppInterface = paramQQAppInterface.getMultiMessageProxy();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(localMessageForShortVideo, null);
          return;
        }
      } while ((localMessageForShortVideo instanceof MessageForBlessPTV));
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramFileMsg.status != 1003) && (paramFileMsg.status != 2003));
    paramQQAppInterface.getMsgHandler().notifyUI(999, true, paramTransferRequest.mPeerUin);
    azjq.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwz
 * JD-Core Version:    0.7.0.1
 */