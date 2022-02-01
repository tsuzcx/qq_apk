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

public class bcwu
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static bcwh a(int paramInt)
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
      return new bcwe();
    case 1: 
      return new abvx();
    }
    return new abvw();
  }
  
  public static bcwz a(int paramInt, Object paramObject, bcxn parambcxn)
  {
    bcwh localbcwh = a(paramInt);
    if (localbcwh == null) {
      return null;
    }
    return localbcwh.a(paramObject, parambcxn);
  }
  
  public static bcxn a(int paramInt1, int paramInt2)
  {
    bcxn localbcxn = new bcxn();
    localbcxn.jdField_a_of_type_Int = paramInt1;
    localbcxn.jdField_b_of_type_Int = paramInt2;
    return localbcxn;
  }
  
  public static bcxn a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    bcxn localbcxn = a(2, paramMessageForShortVideo.busiType);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localbcwx.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localbcwx.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localbcwx.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localbcwx.e = 1001;
    }
    for (;;)
    {
      localbcxn.a(localbcwx);
      localbcxn.a(paramMessageForShortVideo);
      return localbcxn;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localbcwx.a = true;
      break;
      label161:
      localbcwx.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localbcwx.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localbcwx.e = 1003;
      }
    }
  }
  
  public static bcyf a(int paramInt, Object paramObject, bcxn parambcxn)
  {
    bcwh localbcwh = a(paramInt);
    if (localbcwh == null) {
      return null;
    }
    return localbcwh.a(paramObject, parambcxn);
  }
  
  public static bcyf a(Object paramObject, bcxn parambcxn)
  {
    bcwh localbcwh = a(parambcxn.jdField_b_of_type_Int);
    if (localbcwh == null) {
      return null;
    }
    return localbcwh.a(paramObject, parambcxn);
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
      return new bcwe(paramQQAppInterface);
    case 1: 
      return new abvx(paramQQAppInterface);
    }
    return new abvw(paramQQAppInterface);
  }
  
  public static void a(bcxn parambcxn, QQAppInterface paramQQAppInterface)
  {
    if (parambcxn == null)
    {
      azpw.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambcxn.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      azpw.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambcxn.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bcxn = parambcxn;
    localBaseShortVideoOprerator.f = parambcxn.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = parambcxn.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcyi);
    azpw.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambcxn.jdField_a_of_type_Int) + ", reqBusiType" + parambcxn.jdField_b_of_type_Int + ", uuid:" + parambcxn.jdField_a_of_type_JavaLangString);
    switch (parambcxn.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcyf);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcwx);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcyf);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcwz);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_Bcwz);
      return;
    }
    localBaseShortVideoOprerator.a(parambcxn.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bete parambete, beyg parambeyg)
  {
    if ((parambete == null) || (parambeyg == null)) {
      azpw.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (parambeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = parambeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            azpw.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(parambeyg.c, parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Long);
            azpw.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (parambete.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * parambete.e / parambete.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == parambete.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((parambete.jdField_b_of_type_Int == 6) || (parambete.jdField_b_of_type_Int == 17) || (parambete.jdField_b_of_type_Int == 9) || (parambete.jdField_b_of_type_Int == 20))
          {
            if (parambete.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)parambete.e);
            }
            if (parambete.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((parambete.d == 1002) || (parambete.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = parambete.d;
          localMessageForShortVideo.fileType = parambete.jdField_b_of_type_Int;
          if ((parambete.jdField_b_of_type_Int != 7) && (parambete.jdField_b_of_type_Int != 16) && (parambete.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (parambete.d == 1003) && (parambeyg.f != null)) {
            localMessageForShortVideo.md5 = parambeyg.f;
          }
          if (parambete.d == 2003) {
            localMessageForShortVideo.lastModified = new File(parambeyg.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (parambeyg.e != 1010)) {
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
      paramQQAppInterface.a().a(parambeyg.c, parambeyg.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((parambete.d != 1003) && (parambete.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, parambeyg.c);
    azpw.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwu
 * JD-Core Version:    0.7.0.1
 */