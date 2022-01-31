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

public class azdd
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static azcq a(int paramInt)
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
      return new azcn();
    case 1: 
      return new zuv();
    }
    return new zuu();
  }
  
  public static azdi a(int paramInt, Object paramObject, azdx paramazdx)
  {
    azcq localazcq = a(paramInt);
    if (localazcq == null) {
      return null;
    }
    return localazcq.a(paramObject, paramazdx);
  }
  
  public static azdx a(int paramInt1, int paramInt2)
  {
    azdx localazdx = new azdx();
    localazdx.jdField_a_of_type_Int = paramInt1;
    localazdx.jdField_b_of_type_Int = paramInt2;
    return localazdx;
  }
  
  public static azdx a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    azdx localazdx = a(2, paramMessageForShortVideo.busiType);
    azdg localazdg = paramMessageForShortVideo.getDownloadInfo(localazdx.jdField_b_of_type_Int);
    localazdg.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localazdg.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localazdg.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localazdg.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localazdg.e = 1001;
    }
    for (;;)
    {
      localazdx.a(localazdg);
      localazdx.a(paramMessageForShortVideo);
      return localazdx;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localazdg.a = true;
      break;
      label161:
      localazdg.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localazdg.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localazdg.e = 1003;
      }
    }
  }
  
  public static azen a(int paramInt, Object paramObject, azdx paramazdx)
  {
    azcq localazcq = a(paramInt);
    if (localazcq == null) {
      return null;
    }
    return localazcq.a(paramObject, paramazdx);
  }
  
  public static azen a(Object paramObject, azdx paramazdx)
  {
    azcq localazcq = a(paramazdx.jdField_b_of_type_Int);
    if (localazcq == null) {
      return null;
    }
    return localazcq.a(paramObject, paramazdx);
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
      return new azcn(paramQQAppInterface);
    case 1: 
      return new zuv(paramQQAppInterface);
    }
    return new zuu(paramQQAppInterface);
  }
  
  public static void a(azdx paramazdx, QQAppInterface paramQQAppInterface)
  {
    if (paramazdx == null)
    {
      awiw.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramazdx.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      awiw.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramazdx.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Azdx = paramazdx;
    localBaseShortVideoOprerator.f = paramazdx.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramazdx.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azeq);
    awiw.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramazdx.jdField_a_of_type_Int) + ", reqBusiType" + paramazdx.jdField_b_of_type_Int + ", uuid:" + paramazdx.jdField_a_of_type_JavaLangString);
    switch (paramazdx.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azen);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azdg);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azen);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azdi);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_Azdi);
      return;
    }
    localBaseShortVideoOprerator.a(paramazdx.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bass parambass, bayk parambayk)
  {
    if ((parambass == null) || (parambayk == null)) {
      awiw.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (parambayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = parambayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            awiw.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(parambayk.c, parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Long);
            awiw.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (parambass.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * parambass.e / parambass.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == parambass.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((parambass.jdField_b_of_type_Int == 6) || (parambass.jdField_b_of_type_Int == 17) || (parambass.jdField_b_of_type_Int == 9) || (parambass.jdField_b_of_type_Int == 20))
          {
            if (parambass.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)parambass.e);
            }
            if (parambass.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((parambass.d == 1002) || (parambass.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = parambass.d;
          localMessageForShortVideo.fileType = parambass.jdField_b_of_type_Int;
          if ((parambass.jdField_b_of_type_Int != 7) && (parambass.jdField_b_of_type_Int != 16) && (parambass.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (parambass.d == 1003) && (parambayk.f != null)) {
            localMessageForShortVideo.md5 = parambayk.f;
          }
          if (parambass.d == 2003) {
            localMessageForShortVideo.lastModified = new File(parambayk.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (parambayk.e != 1010)) {
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
      paramQQAppInterface.a().a(parambayk.c, parambayk.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((parambass.d != 1003) && (parambass.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, parambayk.c);
    awiw.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdd
 * JD-Core Version:    0.7.0.1
 */