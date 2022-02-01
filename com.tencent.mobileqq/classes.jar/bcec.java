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

public class bcec
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static bcdp a(int paramInt)
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
      return new bcdm();
    case 1: 
      return new abrt();
    }
    return new abrs();
  }
  
  public static bceh a(int paramInt, Object paramObject, bcev parambcev)
  {
    bcdp localbcdp = a(paramInt);
    if (localbcdp == null) {
      return null;
    }
    return localbcdp.a(paramObject, parambcev);
  }
  
  public static bcev a(int paramInt1, int paramInt2)
  {
    bcev localbcev = new bcev();
    localbcev.jdField_a_of_type_Int = paramInt1;
    localbcev.jdField_b_of_type_Int = paramInt2;
    return localbcev;
  }
  
  public static bcev a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    bcev localbcev = a(2, paramMessageForShortVideo.busiType);
    bcef localbcef = paramMessageForShortVideo.getDownloadInfo(localbcev.jdField_b_of_type_Int);
    localbcef.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localbcef.f = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localbcef.a = false;
      paramQQAppInterface = paramQQAppInterface.a();
      if ((!paramQQAppInterface.a()) || (!paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localbcef.g = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localbcef.e = 1001;
    }
    for (;;)
    {
      localbcev.a(localbcef);
      localbcev.a(paramMessageForShortVideo);
      return localbcev;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localbcef.a = true;
      break;
      label161:
      localbcef.g = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localbcef.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localbcef.e = 1003;
      }
    }
  }
  
  public static bcfn a(int paramInt, Object paramObject, bcev parambcev)
  {
    bcdp localbcdp = a(paramInt);
    if (localbcdp == null) {
      return null;
    }
    return localbcdp.a(paramObject, parambcev);
  }
  
  public static bcfn a(Object paramObject, bcev parambcev)
  {
    bcdp localbcdp = a(parambcev.jdField_b_of_type_Int);
    if (localbcdp == null) {
      return null;
    }
    return localbcdp.a(paramObject, parambcev);
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
      return new bcdm(paramQQAppInterface);
    case 1: 
      return new abrt(paramQQAppInterface);
    }
    return new abrs(paramQQAppInterface);
  }
  
  public static void a(bcev parambcev, QQAppInterface paramQQAppInterface)
  {
    if (parambcev == null)
    {
      ayxi.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambcev.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      ayxi.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambcev.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bcev = parambcev;
    localBaseShortVideoOprerator.f = parambcev.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = parambcev.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bcfq);
    ayxi.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambcev.jdField_a_of_type_Int) + ", reqBusiType" + parambcev.jdField_b_of_type_Int + ", uuid:" + parambcev.jdField_a_of_type_JavaLangString);
    switch (parambcev.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bcfn);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bcef);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bcfn);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bceh);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_Bceh);
      return;
    }
    localBaseShortVideoOprerator.a(parambcev.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bduk parambduk, bdzn parambdzn)
  {
    if ((parambduk == null) || (parambdzn == null)) {
      ayxi.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
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
          if (parambdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = parambdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            ayxi.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(parambdzn.c, parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Long);
            ayxi.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (parambduk.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * parambduk.e / parambduk.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == parambduk.d) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((parambduk.jdField_b_of_type_Int == 6) || (parambduk.jdField_b_of_type_Int == 17) || (parambduk.jdField_b_of_type_Int == 9) || (parambduk.jdField_b_of_type_Int == 20))
          {
            if (parambduk.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)parambduk.e);
            }
            if (parambduk.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((parambduk.d == 1002) || (parambduk.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = parambduk.d;
          localMessageForShortVideo.fileType = parambduk.jdField_b_of_type_Int;
          if ((parambduk.jdField_b_of_type_Int != 7) && (parambduk.jdField_b_of_type_Int != 16) && (parambduk.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (parambduk.d == 1003) && (parambdzn.f != null)) {
            localMessageForShortVideo.md5 = parambdzn.f;
          }
          if (parambduk.d == 2003) {
            localMessageForShortVideo.lastModified = new File(parambdzn.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (parambdzn.e != 1010)) {
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
      paramQQAppInterface.a().a(parambdzn.c, parambdzn.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((parambduk.d != 1003) && (parambduk.d != 2003));
    paramQQAppInterface.a().notifyUI(999, true, parambdzn.c);
    ayxi.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcec
 * JD-Core Version:    0.7.0.1
 */