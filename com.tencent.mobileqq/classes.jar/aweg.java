import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aweg
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static awdt a(int paramInt)
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
      return new awdq();
    case 1: 
      return new xsn();
    }
    return new xsm();
  }
  
  public static awel a(int paramInt, Object paramObject, awey paramawey)
  {
    awdt localawdt = a(paramInt);
    if (localawdt == null) {
      return null;
    }
    return localawdt.a(paramObject, paramawey);
  }
  
  public static awey a(int paramInt1, int paramInt2)
  {
    awey localawey = new awey();
    localawey.jdField_a_of_type_Int = paramInt1;
    localawey.jdField_b_of_type_Int = paramInt2;
    return localawey;
  }
  
  public static awey a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    awey localawey = a(2, paramMessageForShortVideo.busiType);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(localawey.jdField_b_of_type_Int);
    localawej.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localawej.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localawej.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localawej.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localawej.e = 1001;
    }
    for (;;)
    {
      localawey.a(localawej);
      localawey.a(paramMessageForShortVideo);
      return localawey;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localawej.a = true;
      break;
      label161:
      localawej.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localawej.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localawej.e = 1003;
      }
    }
  }
  
  public static awfo a(int paramInt, Object paramObject, awey paramawey)
  {
    awdt localawdt = a(paramInt);
    if (localawdt == null) {
      return null;
    }
    return localawdt.a(paramObject, paramawey);
  }
  
  public static awfo a(Object paramObject, awey paramawey)
  {
    awdt localawdt = a(paramawey.jdField_b_of_type_Int);
    if (localawdt == null) {
      return null;
    }
    return localawdt.a(paramObject, paramawey);
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
      return new awdq(paramQQAppInterface);
    case 1: 
      return new xsn(paramQQAppInterface);
    }
    return new xsm(paramQQAppInterface);
  }
  
  public static void a(awey paramawey, QQAppInterface paramQQAppInterface)
  {
    if (paramawey == null)
    {
      atpg.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramawey.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      atpg.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramawey.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Awey = paramawey;
    localBaseShortVideoOprerator.f = paramawey.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramawey.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awfr);
    atpg.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramawey.jdField_a_of_type_Int) + ", reqBusiType" + paramawey.jdField_b_of_type_Int + ", uuid:" + paramawey.jdField_a_of_type_JavaLangString);
    switch (paramawey.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awfo);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awej);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awfo);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awel);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_Awel);
      return;
    }
    localBaseShortVideoOprerator.a(paramawey.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axqf paramaxqf, axvt paramaxvt)
  {
    if ((paramaxqf == null) || (paramaxvt == null)) {
      atpg.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (paramaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = paramaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            atpg.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(paramaxvt.c, paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Long);
            atpg.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramaxqf.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * paramaxqf.e / paramaxqf.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramaxqf.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramaxqf.jdField_b_of_type_Int == 6) || (paramaxqf.jdField_b_of_type_Int == 17) || (paramaxqf.jdField_b_of_type_Int == 9) || (paramaxqf.jdField_b_of_type_Int == 20))
          {
            if (paramaxqf.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramaxqf.e);
            }
            if (paramaxqf.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramaxqf.d == 1002) || (paramaxqf.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramaxqf.d;
          localMessageForShortVideo.fileType = paramaxqf.jdField_b_of_type_Int;
          if ((paramaxqf.jdField_b_of_type_Int != 7) && (paramaxqf.jdField_b_of_type_Int != 16) && (paramaxqf.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramaxqf.d == 1003) && (paramaxvt.f != null)) {
            localMessageForShortVideo.md5 = paramaxvt.f;
          }
          if (paramaxqf.d == 2003) {
            localMessageForShortVideo.lastModified = new File(paramaxvt.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramaxvt.e != 1010)) {
            break label497;
          }
          if ((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) {
            break;
          }
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(localMessageForShortVideo, null);
          return;
        }
      } while ((localMessageForShortVideo instanceof MessageForBlessPTV));
      paramQQAppInterface.a().a(paramaxvt.c, paramaxvt.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramaxqf.d != 1003) && (paramaxqf.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, paramaxvt.c);
    atpg.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aweg
 * JD-Core Version:    0.7.0.1
 */