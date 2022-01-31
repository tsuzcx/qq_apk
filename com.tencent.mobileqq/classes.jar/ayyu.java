import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ayyu
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static ayyh a(int paramInt)
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
      return new ayye();
    case 1: 
      return new zqg();
    }
    return new zqf();
  }
  
  public static ayyz a(int paramInt, Object paramObject, ayzo paramayzo)
  {
    ayyh localayyh = a(paramInt);
    if (localayyh == null) {
      return null;
    }
    return localayyh.a(paramObject, paramayzo);
  }
  
  public static ayzo a(int paramInt1, int paramInt2)
  {
    ayzo localayzo = new ayzo();
    localayzo.jdField_a_of_type_Int = paramInt1;
    localayzo.jdField_b_of_type_Int = paramInt2;
    return localayzo;
  }
  
  public static ayzo a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    ayzo localayzo = a(2, paramMessageForShortVideo.busiType);
    ayyx localayyx = paramMessageForShortVideo.getDownloadInfo(localayzo.jdField_b_of_type_Int);
    localayyx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localayyx.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localayyx.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localayyx.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localayyx.e = 1001;
    }
    for (;;)
    {
      localayzo.a(localayyx);
      localayzo.a(paramMessageForShortVideo);
      return localayzo;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localayyx.a = true;
      break;
      label161:
      localayyx.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localayyx.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localayyx.e = 1003;
      }
    }
  }
  
  public static azae a(int paramInt, Object paramObject, ayzo paramayzo)
  {
    ayyh localayyh = a(paramInt);
    if (localayyh == null) {
      return null;
    }
    return localayyh.a(paramObject, paramayzo);
  }
  
  public static azae a(Object paramObject, ayzo paramayzo)
  {
    ayyh localayyh = a(paramayzo.jdField_b_of_type_Int);
    if (localayyh == null) {
      return null;
    }
    return localayyh.a(paramObject, paramayzo);
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
      return new ayye(paramQQAppInterface);
    case 1: 
      return new zqg(paramQQAppInterface);
    }
    return new zqf(paramQQAppInterface);
  }
  
  public static void a(ayzo paramayzo, QQAppInterface paramQQAppInterface)
  {
    if (paramayzo == null)
    {
      awen.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramayzo.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      awen.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramayzo.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Ayzo = paramayzo;
    localBaseShortVideoOprerator.f = paramayzo.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramayzo.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Azah);
    awen.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramayzo.jdField_a_of_type_Int) + ", reqBusiType" + paramayzo.jdField_b_of_type_Int + ", uuid:" + paramayzo.jdField_a_of_type_JavaLangString);
    switch (paramayzo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Azae);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Ayyx);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Azae);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Ayyz);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_Ayyz);
      return;
    }
    localBaseShortVideoOprerator.a(paramayzo.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, baoj parambaoj, baub parambaub)
  {
    if ((parambaoj == null) || (parambaub == null)) {
      awen.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (parambaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = parambaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            awen.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(parambaub.c, parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Long);
            awen.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (parambaoj.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * parambaoj.e / parambaoj.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == parambaoj.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((parambaoj.jdField_b_of_type_Int == 6) || (parambaoj.jdField_b_of_type_Int == 17) || (parambaoj.jdField_b_of_type_Int == 9) || (parambaoj.jdField_b_of_type_Int == 20))
          {
            if (parambaoj.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)parambaoj.e);
            }
            if (parambaoj.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((parambaoj.d == 1002) || (parambaoj.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = parambaoj.d;
          localMessageForShortVideo.fileType = parambaoj.jdField_b_of_type_Int;
          if ((parambaoj.jdField_b_of_type_Int != 7) && (parambaoj.jdField_b_of_type_Int != 16) && (parambaoj.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (parambaoj.d == 1003) && (parambaub.f != null)) {
            localMessageForShortVideo.md5 = parambaub.f;
          }
          if (parambaoj.d == 2003) {
            localMessageForShortVideo.lastModified = new File(parambaub.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (parambaub.e != 1010)) {
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
      paramQQAppInterface.a().a(parambaub.c, parambaub.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((parambaoj.d != 1003) && (parambaoj.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, parambaub.c);
    awen.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyu
 * JD-Core Version:    0.7.0.1
 */