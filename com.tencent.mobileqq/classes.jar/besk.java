import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class besk
  extends bera
{
  public besk(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public besk(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private besl a(DownloadParams paramDownloadParams)
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    besl localbesl = new besl(this);
    localbesl.jdField_a_of_type_JavaNetURL = paramDownloadParams.url;
    azpw.a("PIC_TAG", "getDownloadData", "url:" + localbesl.jdField_a_of_type_JavaNetURL);
    localbesl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    localbesl.jdField_a_of_type_Long = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof azqr)))
    {
      Object localObject = (azqr)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        localbesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localbesl.d = azqi.a();
        localbesl.jdField_c_of_type_Int = azqi.a(localbesl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localbesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      localbesl.jdField_a_of_type_Azqd = ((azqr)localObject).getPicDownloadInfo();
      a(localbesl, "getDownloadData", "uuid:" + localbesl.jdField_a_of_type_Azqd.g + ",md5：" + localbesl.jdField_a_of_type_Azqd.f);
      localbesl.jdField_a_of_type_JavaLangString = a(localbesl.jdField_a_of_type_Azqd.jdField_b_of_type_Int);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (localbesl.jdField_a_of_type_Azqd.jdField_e_of_type_Int == 1) {
        bool = true;
      }
      localbesl.jdField_a_of_type_Int = beyq.a(paramDownloadParams, bool);
      if (((azqr)localObject).isSendFromLocal())
      {
        localbesl.jdField_a_of_type_Boolean = true;
        localbesl.jdField_a_of_type_Azqt = ((azqr)localObject).getPicUploadInfo();
        localbesl.jdField_a_of_type_Azqd.jdField_a_of_type_Boolean = true;
        if (localbesl.jdField_a_of_type_Int != 65537) {
          break label461;
        }
        if (localbesl.jdField_a_of_type_Azqt.jdField_c_of_type_Int != beya.f) {
          break label427;
        }
        localObject = ((bevt)localbesl.jdField_a_of_type_Azqt.jdField_a_of_type_JavaLangObject).jdField_c_of_type_JavaLangString;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = a(localbesl, (String)localObject);
        }
      }
      label427:
      label461:
      for (localbesl.jdField_b_of_type_JavaLangString = paramDownloadParams;; localbesl.jdField_b_of_type_JavaLangString = localbesl.jdField_a_of_type_Azqt.g)
      {
        a(localbesl, "getDownloadData", "path:" + localbesl.jdField_a_of_type_Azqt.g + ",sendPath：" + localbesl.jdField_b_of_type_JavaLangString);
        return localbesl;
        if (localbesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isQzonePic)
        {
          paramDownloadParams = localbesl.jdField_a_of_type_Azqt.h;
          break;
        }
        paramDownloadParams = a(localbesl, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      localbesl.jdField_b_of_type_JavaLangString = ((String)paramDownloadParams.tag);
      return localbesl;
    }
    if (paramDownloadParams.tag == null) {
      a(localbesl, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      a(localbesl, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
    }
  }
  
  static String a(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default: 
      str = "C2C";
    case 6000: 
      return str;
    case 1: 
      return "Troup";
    case 3000: 
      return "Disscussion";
    }
    return "C2C";
  }
  
  private String a(besl parambesl, String paramString)
  {
    if (bhmi.a(paramString)) {}
    while (!bhmi.a(parambesl.jdField_a_of_type_Azqt.g)) {
      return paramString;
    }
    paramString = new CompressInfo(parambesl.jdField_a_of_type_Azqt.g, 0);
    paramString.jdField_a_of_type_JavaLangString = parambesl.jdField_a_of_type_Azqt.jdField_a_of_type_JavaLangString;
    azrm.b(paramString);
    return paramString.jdField_e_of_type_JavaLangString;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = a(paramMessageRecord.istroop);
        Object localObject = new beya();
        ((beya)localObject).a(paramMessageRecord.msg);
        if (((beya)localObject).jdField_a_of_type_Int == 1)
        {
          String str2 = ((beya)localObject).jdField_b_of_type_JavaLangString;
          localObject = ((beya)localObject).jdField_c_of_type_JavaLangString;
          if ((bhka.a(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = beyq.a((MessageForPic)paramMessageRecord, 65537, null);
            if (a(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              a(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = beyq.a((MessageForPic)paramMessageRecord, 65537, null);
          if (a(localURL.toString()) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatImageDownloader", 2, "reportClientExist bigURL:" + localURL);
            }
            a(paramMessageRecord, str1, str2, (String)localObject, false);
          }
        }
        return;
      }
      catch (Exception paramMessageRecord)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("reportClientExist", 2, "error", paramMessageRecord);
        return;
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool1 = paramString1.equals("C2C");
    boolean bool2 = paramString1.equals("Troup");
    boolean bool3 = paramString1.equals("Disscussion");
    if (bool1) {
      if (paramBoolean)
      {
        paramString1 = "dim.buddy_thumbpic_down";
        if (!paramBoolean) {
          break label105;
        }
        localObject1 = "actC2CPicSmallDownV1";
      }
    }
    for (;;)
    {
      paramString1 = new berb(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
      paramString1.jdField_a_of_type_Boolean = true;
      paramString1.jdField_a_of_type_Long = paramMessageRecord.time;
      a(paramString1, true, (int)0L, 0, "", null, null, null);
      return;
      paramString1 = "dim.buddy_pic_down";
      break;
      label105:
      localObject1 = "actC2CPicDownloadV1";
      continue;
      if (bool2)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.group_thumbpic_down";
          label127:
          if (!paramBoolean) {
            break label147;
          }
        }
        label147:
        for (localObject1 = "actGroupPicSmallDownV1";; localObject1 = "actGroupPicDownloadV1")
        {
          break;
          paramString1 = "dim.group_pic_down";
          break label127;
        }
      }
      if (bool3)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.discuss_thumbpic_down";
          label169:
          if (!paramBoolean) {
            break label189;
          }
        }
        label189:
        for (localObject1 = "actDiscussPicSmallDown";; localObject1 = "actDiscussPicDown")
        {
          break;
          paramString1 = "dim.discuss_pic_down";
          break label169;
        }
      }
      Object localObject2 = null;
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof besl)) {
      if (QLog.isColorLevel())
      {
        paramObject = (besl)paramObject;
        if (paramObject.jdField_a_of_type_Azqt == null) {
          break label58;
        }
        i = bews.a(paramObject.jdField_a_of_type_Int);
        bews.c(paramObject.jdField_a_of_type_Azqt.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Azqt.jdField_a_of_type_Long), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.jdField_a_of_type_Azqd != null)
        {
          i = bews.a(paramObject.jdField_a_of_type_Int);
          bews.c(paramObject.jdField_a_of_type_Azqd.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Azqd.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
      return;
    }
    QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
  }
  
  private boolean b(DownloadParams paramDownloadParams)
  {
    if (!(paramDownloadParams.tag instanceof MessageForPic)) {
      return false;
    }
    paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
    if ((paramDownloadParams.thumbWidthHeightDP != null) && (paramDownloadParams.thumbWidthHeightDP.mLimitSizeByServer)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  beyn a(besl parambesl)
  {
    if (parambesl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    try
    {
      parambesl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)parambesl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(parambesl.jdField_a_of_type_Azqd.jdField_b_of_type_JavaLangString));
      label28:
      if (parambesl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        a(parambesl, "stepDownload", "params.app == null ,selfuin:" + parambesl.jdField_a_of_type_Azqd.jdField_b_of_type_JavaLangString);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + parambesl.jdField_a_of_type_Azqd.jdField_b_of_type_JavaLangString, false, false);
      }
      azpc localazpc = new azpc(parambesl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localazpc.jdField_a_of_type_Azqk = new azqk();
      localazpc.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = parambesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      localazpc.jdField_b_of_type_JavaLangString = "PIC_TAG";
      localazpc.jdField_a_of_type_JavaLangString = parambesl.jdField_c_of_type_JavaLangString;
      parambesl.jdField_a_of_type_Azqd.jdField_e_of_type_JavaLangString = parambesl.jdField_a_of_type_JavaNetURL.getProtocol();
      if (parambesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
      {
        parambesl.jdField_a_of_type_Azqd.d = parambesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.bEnableEnc;
        parambesl.jdField_a_of_type_Azqd.c = parambesl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.time;
      }
      azpw.a("PIC_TAG", parambesl.jdField_c_of_type_JavaLangString, "stepDownload", "url:" + parambesl.jdField_a_of_type_JavaNetURL + ",info:" + parambesl.jdField_a_of_type_Azqd);
      return localazpc.a(parambesl.jdField_a_of_type_Azqd, parambesl.jdField_a_of_type_ComTencentImageURLDrawableHandler, parambesl.jdField_a_of_type_JavaNetURL.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    float f1;
    int j;
    int i;
    int m;
    int k;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    label344:
    int i1;
    int n;
    try
    {
      f1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
      i8 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
      f3 = 12.0F * f1;
      boolean bool = bmgb.a(paramDownloadParams.mImgType);
      j = besm.b(bool);
      i = besm.b(bool);
      m = besm.a(bool);
      k = besm.a(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject = (MessageForPic)paramDownloadParams.tag;
        j = agej.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        i = agej.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        m = agej.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        k = agej.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      localObject = new Paint(1);
      ((Paint)localObject).setColor(-16777216);
      i5 = besm.d(bool);
      i4 = besm.d(bool);
      i3 = besm.c(bool);
      i2 = besm.c(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label636;
      }
      MessageForPic localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      i5 = localMessageForPic.getThumbWidthHeightDP(bool).mMinWidth;
      i4 = localMessageForPic.getThumbWidthHeightDP(bool).mMinHeight;
      i3 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxWidth;
      i2 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      int i8;
      float f3;
      Object localObject;
      label387:
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
    if (b(paramDownloadParams))
    {
      return new RoundRectBitmap(azru.a(paramBitmap, ((MessageForPic)paramDownloadParams.tag).thumbWidthHeightDP), f3);
      if (i1 < n)
      {
        m = (int)(j / i1 * n + 0.5F);
        i = m;
        if (m <= k) {
          break label723;
        }
        i = k;
        break label723;
      }
    }
    label563:
    label723:
    for (;;)
    {
      paramDownloadParams = Bitmap.createBitmap(j, i, paramBitmap.getConfig());
      paramDownloadParams.setDensity(i8);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, i1, n), new Rect(0, 0, j, i), (Paint)localObject);
      paramDownloadParams = new RoundRectBitmap(paramDownloadParams, f3);
      return paramDownloadParams;
      k = (int)(i / n * i1 + 0.5F);
      j = k;
      if (k > m) {
        j = m;
      }
      continue;
      label624:
      label636:
      do
      {
        if ((i1 < i3) && (n < i2))
        {
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(n * f1 + 0.5F);
          break label387;
        }
        if (i1 > n)
        {
          f1 = m / i1;
          if (i1 <= n) {
            break label624;
          }
        }
        for (float f2 = i / n;; f2 = j / i1)
        {
          f1 = Math.max(f1, f2);
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
          f1 = k / n;
          break label563;
        }
        if (i6 > i7 * 3.0F)
        {
          i1 = (int)(i7 * 3.0F);
          n = i7;
          break;
        }
        n = i7;
        i1 = i6;
        if (i7 <= i6 * 3.0F) {
          break;
        }
        n = (int)(i6 * 3.0F);
        i1 = i6;
        break;
        if (i1 < i5) {
          break label344;
        }
      } while (n >= i4);
      break label344;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = SystemClock.uptimeMillis();
    if ((paramDownloadParams.urlStr != null) && (paramDownloadParams.urlStr.startsWith("chatimg"))) {}
    for (int i = 1;; i = 0)
    {
      paramDownloadParams = a(paramDownloadParams);
      paramDownloadParams.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
      paramDownloadParams.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramDownloadParams.jdField_a_of_type_Azqt == null) || (paramDownloadParams.jdField_b_of_type_JavaLangString == null)) {
        break;
      }
      paramOutputStream = new File(paramDownloadParams.jdField_b_of_type_JavaLangString);
      if (!paramOutputStream.exists()) {
        break;
      }
      a(paramDownloadParams, "result", "success file(send) exist, copy file from:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      a(paramDownloadParams.jdField_a_of_type_JavaIoOutputStream, paramOutputStream, paramDownloadParams.jdField_a_of_type_ComTencentImageURLDrawableHandler);
      return null;
    }
    paramURLDrawableHandler.publishProgress(0);
    if (paramDownloadParams.jdField_a_of_type_Azqd == null)
    {
      a(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      a(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString + ",uniseq:" + paramDownloadParams.jdField_a_of_type_Azqd.jdField_a_of_type_Long);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((bhjx.a()) && (bhjx.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bhjx.b());
    }
    beyn localbeyn = a(paramDownloadParams);
    int j;
    if (localbeyn.jdField_a_of_type_Int == 0)
    {
      j = 1;
      if (j == 0) {
        break label374;
      }
    }
    label374:
    for (paramOutputStream = "successed";; paramOutputStream = "failed " + localbeyn.jdField_a_of_type_JavaLangString)
    {
      a(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label482;
      }
      paramOutputStream = PicDownloadExplicitError.getPicError(localbeyn);
      if (paramOutputStream == null) {
        break label402;
      }
      throw paramOutputStream;
      j = 0;
      break;
    }
    label402:
    if (localbeyn.jdField_a_of_type_Long == 9037L) {
      paramURLDrawableHandler.doCancel();
    }
    label482:
    while (i == 0)
    {
      return null;
      if ((localbeyn.jdField_a_of_type_Long == -9527L) && ("H_404_-124".equals(localbeyn.jdField_a_of_type_JavaLangString)))
      {
        a(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localbeyn.jdField_a_of_type_Long, 0L, localbeyn.jdField_a_of_type_JavaLangString, false, false);
    }
    if (paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (paramOutputStream = paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramOutputStream = null)
    {
      azqj.a(paramOutputStream, paramDownloadParams.jdField_c_of_type_Int, paramDownloadParams.d, SystemClock.uptimeMillis() - l);
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected boolean a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = paramDownloadParams.tag;
    if (((localObject instanceof MessageForPic)) && (anxg.a((MessageForPic)localObject))) {
      return false;
    }
    return super.a(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "chatthumb".equals(paramDownloadParams.url.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besk
 * JD-Core Version:    0.7.0.1
 */