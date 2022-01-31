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

public class axdq
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static axdd a(int paramInt)
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
      return new axda();
    case 1: 
      return new ybn();
    }
    return new ybm();
  }
  
  public static axdv a(int paramInt, Object paramObject, axei paramaxei)
  {
    axdd localaxdd = a(paramInt);
    if (localaxdd == null) {
      return null;
    }
    return localaxdd.a(paramObject, paramaxei);
  }
  
  public static axei a(int paramInt1, int paramInt2)
  {
    axei localaxei = new axei();
    localaxei.jdField_a_of_type_Int = paramInt1;
    localaxei.jdField_b_of_type_Int = paramInt2;
    return localaxei;
  }
  
  public static axei a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    axei localaxei = a(2, paramMessageForShortVideo.busiType);
    axdt localaxdt = paramMessageForShortVideo.getDownloadInfo(localaxei.jdField_b_of_type_Int);
    localaxdt.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localaxdt.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localaxdt.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localaxdt.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localaxdt.e = 1001;
    }
    for (;;)
    {
      localaxei.a(localaxdt);
      localaxei.a(paramMessageForShortVideo);
      return localaxei;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localaxdt.a = true;
      break;
      label161:
      localaxdt.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localaxdt.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localaxdt.e = 1003;
      }
    }
  }
  
  public static axey a(int paramInt, Object paramObject, axei paramaxei)
  {
    axdd localaxdd = a(paramInt);
    if (localaxdd == null) {
      return null;
    }
    return localaxdd.a(paramObject, paramaxei);
  }
  
  public static axey a(Object paramObject, axei paramaxei)
  {
    axdd localaxdd = a(paramaxei.jdField_b_of_type_Int);
    if (localaxdd == null) {
      return null;
    }
    return localaxdd.a(paramObject, paramaxei);
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
      return new axda(paramQQAppInterface);
    case 1: 
      return new ybn(paramQQAppInterface);
    }
    return new ybm(paramQQAppInterface);
  }
  
  public static void a(axei paramaxei, QQAppInterface paramQQAppInterface)
  {
    if (paramaxei == null)
    {
      aung.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramaxei.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      aung.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramaxei.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Axei = paramaxei;
    localBaseShortVideoOprerator.f = paramaxei.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramaxei.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axfb);
    aung.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramaxei.jdField_a_of_type_Int) + ", reqBusiType" + paramaxei.jdField_b_of_type_Int + ", uuid:" + paramaxei.jdField_a_of_type_JavaLangString);
    switch (paramaxei.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axey);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axdt);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axey);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axdv);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_Axdv);
      return;
    }
    localBaseShortVideoOprerator.a(paramaxei.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayqo paramayqo, aywc paramaywc)
  {
    if ((paramayqo == null) || (paramaywc == null)) {
      aung.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (paramaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = paramaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            aung.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(paramaywc.c, paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Long);
            aung.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramayqo.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * paramayqo.e / paramayqo.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramayqo.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramayqo.jdField_b_of_type_Int == 6) || (paramayqo.jdField_b_of_type_Int == 17) || (paramayqo.jdField_b_of_type_Int == 9) || (paramayqo.jdField_b_of_type_Int == 20))
          {
            if (paramayqo.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramayqo.e);
            }
            if (paramayqo.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramayqo.d == 1002) || (paramayqo.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramayqo.d;
          localMessageForShortVideo.fileType = paramayqo.jdField_b_of_type_Int;
          if ((paramayqo.jdField_b_of_type_Int != 7) && (paramayqo.jdField_b_of_type_Int != 16) && (paramayqo.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramayqo.d == 1003) && (paramaywc.f != null)) {
            localMessageForShortVideo.md5 = paramaywc.f;
          }
          if (paramayqo.d == 2003) {
            localMessageForShortVideo.lastModified = new File(paramaywc.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramaywc.e != 1010)) {
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
      paramQQAppInterface.a().a(paramaywc.c, paramaywc.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramayqo.d != 1003) && (paramayqo.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, paramaywc.c);
    aung.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdq
 * JD-Core Version:    0.7.0.1
 */