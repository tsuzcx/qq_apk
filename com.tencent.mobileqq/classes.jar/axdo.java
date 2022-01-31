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

public class axdo
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static axdb a(int paramInt)
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
      return new axcy();
    case 1: 
      return new ybq();
    }
    return new ybp();
  }
  
  public static axdt a(int paramInt, Object paramObject, axeg paramaxeg)
  {
    axdb localaxdb = a(paramInt);
    if (localaxdb == null) {
      return null;
    }
    return localaxdb.a(paramObject, paramaxeg);
  }
  
  public static axeg a(int paramInt1, int paramInt2)
  {
    axeg localaxeg = new axeg();
    localaxeg.jdField_a_of_type_Int = paramInt1;
    localaxeg.jdField_b_of_type_Int = paramInt2;
    return localaxeg;
  }
  
  public static axeg a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    axeg localaxeg = a(2, paramMessageForShortVideo.busiType);
    axdr localaxdr = paramMessageForShortVideo.getDownloadInfo(localaxeg.jdField_b_of_type_Int);
    localaxdr.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localaxdr.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localaxdr.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localaxdr.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localaxdr.e = 1001;
    }
    for (;;)
    {
      localaxeg.a(localaxdr);
      localaxeg.a(paramMessageForShortVideo);
      return localaxeg;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localaxdr.a = true;
      break;
      label161:
      localaxdr.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localaxdr.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localaxdr.e = 1003;
      }
    }
  }
  
  public static axew a(int paramInt, Object paramObject, axeg paramaxeg)
  {
    axdb localaxdb = a(paramInt);
    if (localaxdb == null) {
      return null;
    }
    return localaxdb.a(paramObject, paramaxeg);
  }
  
  public static axew a(Object paramObject, axeg paramaxeg)
  {
    axdb localaxdb = a(paramaxeg.jdField_b_of_type_Int);
    if (localaxdb == null) {
      return null;
    }
    return localaxdb.a(paramObject, paramaxeg);
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
      return new axcy(paramQQAppInterface);
    case 1: 
      return new ybq(paramQQAppInterface);
    }
    return new ybp(paramQQAppInterface);
  }
  
  public static void a(axeg paramaxeg, QQAppInterface paramQQAppInterface)
  {
    if (paramaxeg == null)
    {
      aune.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramaxeg.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      aune.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramaxeg.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Axeg = paramaxeg;
    localBaseShortVideoOprerator.f = paramaxeg.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramaxeg.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axez);
    aune.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramaxeg.jdField_a_of_type_Int) + ", reqBusiType" + paramaxeg.jdField_b_of_type_Int + ", uuid:" + paramaxeg.jdField_a_of_type_JavaLangString);
    switch (paramaxeg.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axew);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axdr);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axew);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axdt);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_Axdt);
      return;
    }
    localBaseShortVideoOprerator.a(paramaxeg.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayqm paramayqm, aywa paramaywa)
  {
    if ((paramayqm == null) || (paramaywa == null)) {
      aune.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (paramaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = paramaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            aune.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(paramaywa.c, paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Long);
            aune.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramayqm.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * paramayqm.e / paramayqm.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramayqm.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramayqm.jdField_b_of_type_Int == 6) || (paramayqm.jdField_b_of_type_Int == 17) || (paramayqm.jdField_b_of_type_Int == 9) || (paramayqm.jdField_b_of_type_Int == 20))
          {
            if (paramayqm.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramayqm.e);
            }
            if (paramayqm.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramayqm.d == 1002) || (paramayqm.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramayqm.d;
          localMessageForShortVideo.fileType = paramayqm.jdField_b_of_type_Int;
          if ((paramayqm.jdField_b_of_type_Int != 7) && (paramayqm.jdField_b_of_type_Int != 16) && (paramayqm.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramayqm.d == 1003) && (paramaywa.f != null)) {
            localMessageForShortVideo.md5 = paramaywa.f;
          }
          if (paramayqm.d == 2003) {
            localMessageForShortVideo.lastModified = new File(paramaywa.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramaywa.e != 1010)) {
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
      paramQQAppInterface.a().a(paramaywa.c, paramaywa.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramayqm.d != 1003) && (paramayqm.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, paramaywa.c);
    aune.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdo
 * JD-Core Version:    0.7.0.1
 */