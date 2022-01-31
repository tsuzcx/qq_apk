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

public class barz
  extends baqo
{
  public barz(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public barz(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private basa a(DownloadParams paramDownloadParams)
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    basa localbasa = new basa(this);
    localbasa.jdField_a_of_type_JavaNetURL = paramDownloadParams.url;
    awiw.a("PIC_TAG", "getDownloadData", "url:" + localbasa.jdField_a_of_type_JavaNetURL);
    localbasa.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    localbasa.jdField_a_of_type_Long = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof awjs)))
    {
      Object localObject = (awjs)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        localbasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localbasa.d = awji.a();
        localbasa.jdField_c_of_type_Int = awji.a(localbasa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localbasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      localbasa.jdField_a_of_type_Awjd = ((awjs)localObject).getPicDownloadInfo();
      a(localbasa, "getDownloadData", "uuid:" + localbasa.jdField_a_of_type_Awjd.g + ",md5：" + localbasa.jdField_a_of_type_Awjd.f);
      localbasa.jdField_a_of_type_JavaLangString = a(localbasa.jdField_a_of_type_Awjd.jdField_b_of_type_Int);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (localbasa.jdField_a_of_type_Awjd.jdField_e_of_type_Int == 1) {
        bool = true;
      }
      localbasa.jdField_a_of_type_Int = bayu.a(paramDownloadParams, bool);
      if (((awjs)localObject).isSendFromLocal())
      {
        localbasa.jdField_a_of_type_Boolean = true;
        localbasa.jdField_a_of_type_Awju = ((awjs)localObject).getPicUploadInfo();
        localbasa.jdField_a_of_type_Awjd.jdField_a_of_type_Boolean = true;
        if (localbasa.jdField_a_of_type_Int != 65537) {
          break label461;
        }
        if (localbasa.jdField_a_of_type_Awju.jdField_c_of_type_Int != baye.f) {
          break label427;
        }
        localObject = ((bavm)localbasa.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangObject).jdField_c_of_type_JavaLangString;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = a(localbasa, (String)localObject);
        }
      }
      label427:
      label461:
      for (localbasa.jdField_b_of_type_JavaLangString = paramDownloadParams;; localbasa.jdField_b_of_type_JavaLangString = localbasa.jdField_a_of_type_Awju.g)
      {
        a(localbasa, "getDownloadData", "path:" + localbasa.jdField_a_of_type_Awju.g + ",sendPath：" + localbasa.jdField_b_of_type_JavaLangString);
        return localbasa;
        if (localbasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isQzonePic)
        {
          paramDownloadParams = localbasa.jdField_a_of_type_Awju.h;
          break;
        }
        paramDownloadParams = a(localbasa, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      localbasa.jdField_b_of_type_JavaLangString = ((String)paramDownloadParams.tag);
      return localbasa;
    }
    if (paramDownloadParams.tag == null) {
      a(localbasa, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      a(localbasa, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
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
  
  private String a(basa parambasa, String paramString)
  {
    if (bdhb.a(paramString)) {}
    while (!bdhb.a(parambasa.jdField_a_of_type_Awju.g)) {
      return paramString;
    }
    paramString = new CompressInfo(parambasa.jdField_a_of_type_Awju.g, 0);
    paramString.jdField_a_of_type_JavaLangString = parambasa.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString;
    awkj.b(paramString);
    return paramString.jdField_e_of_type_JavaLangString;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = a(paramMessageRecord.istroop);
        Object localObject = new baye();
        ((baye)localObject).a(paramMessageRecord.msg);
        if (((baye)localObject).jdField_a_of_type_Int == 1)
        {
          String str2 = ((baye)localObject).jdField_b_of_type_JavaLangString;
          localObject = ((baye)localObject).jdField_c_of_type_JavaLangString;
          if ((bdex.a(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = bayu.a((MessageForPic)paramMessageRecord, 65537, null);
            if (a(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              a(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = bayu.a((MessageForPic)paramMessageRecord, 65537, null);
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
      paramString1 = new baqs(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
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
    if ((paramObject instanceof basa)) {
      if (QLog.isColorLevel())
      {
        paramObject = (basa)paramObject;
        if (paramObject.jdField_a_of_type_Awju == null) {
          break label58;
        }
        i = baws.a(paramObject.jdField_a_of_type_Int);
        baws.c(paramObject.jdField_a_of_type_Awju.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Awju.jdField_a_of_type_Long), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.jdField_a_of_type_Awjd != null)
        {
          i = baws.a(paramObject.jdField_a_of_type_Int);
          baws.c(paramObject.jdField_a_of_type_Awjd.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Awjd.jdField_a_of_type_Long), paramString1, paramString2);
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
  
  bayr a(basa parambasa)
  {
    if (parambasa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    try
    {
      parambasa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)parambasa.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(parambasa.jdField_a_of_type_Awjd.jdField_b_of_type_JavaLangString));
      label28:
      if (parambasa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        a(parambasa, "stepDownload", "params.app == null ,selfuin:" + parambasa.jdField_a_of_type_Awjd.jdField_b_of_type_JavaLangString);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + parambasa.jdField_a_of_type_Awjd.jdField_b_of_type_JavaLangString, false, false);
      }
      awid localawid = new awid(parambasa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localawid.jdField_a_of_type_Awjl = new awjl();
      localawid.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = parambasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      localawid.jdField_b_of_type_JavaLangString = "PIC_TAG";
      localawid.jdField_a_of_type_JavaLangString = parambasa.jdField_c_of_type_JavaLangString;
      parambasa.jdField_a_of_type_Awjd.jdField_e_of_type_JavaLangString = parambasa.jdField_a_of_type_JavaNetURL.getProtocol();
      if (parambasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
      {
        parambasa.jdField_a_of_type_Awjd.d = parambasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.bEnableEnc;
        parambasa.jdField_a_of_type_Awjd.c = parambasa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.time;
      }
      awiw.a("PIC_TAG", parambasa.jdField_c_of_type_JavaLangString, "stepDownload", "url:" + parambasa.jdField_a_of_type_JavaNetURL + ",info:" + parambasa.jdField_a_of_type_Awjd);
      return localawid.a(parambasa.jdField_a_of_type_Awjd, parambasa.jdField_a_of_type_ComTencentImageURLDrawableHandler, parambasa.jdField_a_of_type_JavaNetURL.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    float f3;
    int i1;
    int n;
    int j;
    int i;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    int m;
    int k;
    label347:
    label496:
    try
    {
      f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
      i8 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
      boolean bool = biqe.a(paramDownloadParams.mImgType);
      i1 = bayu.b(bool);
      n = bayu.b(bool);
      j = bayu.a(bool);
      i = bayu.a(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject = (MessageForPic)paramDownloadParams.tag;
        i1 = aepi.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        n = aepi.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        j = aepi.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        i = aepi.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      localObject = new Paint(1);
      ((Paint)localObject).setColor(-16777216);
      i5 = bayu.d(bool);
      i4 = bayu.d(bool);
      i3 = bayu.c(bool);
      i2 = bayu.c(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label712;
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
      Object localObject;
      label369:
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
    if (b(paramDownloadParams)) {
      if (m < k)
      {
        if (m >= i1) {
          break label701;
        }
        n = (int)(k * i1 * 1.0F / m);
        j = i1;
        if (k <= i) {
          break label694;
        }
        j = (int)(m * i * 1.0F / k);
      }
    }
    for (;;)
    {
      paramDownloadParams = Bitmap.createBitmap(j, i, bayu.b);
      paramDownloadParams.setDensity(i8);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, m, k), new Rect(0, 0, j, i), (Paint)localObject);
      return new RoundRectBitmap(paramDownloadParams, 12.0F * f3);
      if (k < n)
      {
        i1 = (int)(m * n * 1.0F / k);
        i = n;
        n = i1;
        label471:
        if (m > j)
        {
          i = (int)(k * j * 1.0F / m);
          continue;
          if (m < k)
          {
            n = (int)(i1 / m * k + 0.5F);
            j = n;
            if (n <= i) {
              break label799;
            }
            j = i;
            break label799;
          }
          i1 = (int)(n / k * m + 0.5F);
          i = i1;
          if (i1 <= j) {
            break label818;
          }
          i = j;
          break label818;
        }
      }
      label590:
      do
      {
        float f1;
        if (m > k)
        {
          f1 = j / m;
          if (m <= k) {
            break label651;
          }
        }
        for (float f2 = n / k;; f2 = i1 / m)
        {
          f1 = Math.max(f1, f2);
          j = (int)(m * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
          break;
          f1 = i / k;
          break label590;
        }
        j = n;
        break label369;
        i = k;
        n = m;
        break label471;
        i = n;
        break label369;
        n = k;
        j = m;
        break label347;
        if (i6 > i7 * 3.0F)
        {
          m = (int)(i7 * 3.0F);
          k = i7;
          break;
        }
        k = i7;
        m = i6;
        if (i7 <= i6 * 3.0F) {
          break;
        }
        k = (int)(i6 * 3.0F);
        m = i6;
        break;
        if (m < i5) {
          break label496;
        }
        if (k < i4)
        {
          break label496;
          i = i1;
          for (;;)
          {
            n = i;
            i = j;
            j = n;
            break;
            j = n;
          }
        }
      } while ((m >= i3) || (k >= i2));
      label651:
      label694:
      label701:
      label712:
      j = (int)(m * f3 + 0.5F);
      label799:
      label818:
      i = (int)(k * f3 + 0.5F);
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
      if ((paramDownloadParams.jdField_a_of_type_Awju == null) || (paramDownloadParams.jdField_b_of_type_JavaLangString == null)) {
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
    if (paramDownloadParams.jdField_a_of_type_Awjd == null)
    {
      a(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      a(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString + ",uniseq:" + paramDownloadParams.jdField_a_of_type_Awjd.jdField_a_of_type_Long);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((bdeu.a()) && (bdeu.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bdeu.b());
    }
    bayr localbayr = a(paramDownloadParams);
    int j;
    if (localbayr.jdField_a_of_type_Int == 0)
    {
      j = 1;
      if (j == 0) {
        break label374;
      }
    }
    label374:
    for (paramOutputStream = "successed";; paramOutputStream = "failed " + localbayr.jdField_a_of_type_JavaLangString)
    {
      a(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label482;
      }
      paramOutputStream = PicDownloadExplicitError.getPicError(localbayr);
      if (paramOutputStream == null) {
        break label402;
      }
      throw paramOutputStream;
      j = 0;
      break;
    }
    label402:
    if (localbayr.jdField_a_of_type_Long == 9037L) {
      paramURLDrawableHandler.doCancel();
    }
    label482:
    while (i == 0)
    {
      return null;
      if ((localbayr.jdField_a_of_type_Long == -9527L) && ("H_404_-124".equals(localbayr.jdField_a_of_type_JavaLangString)))
      {
        a(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localbayr.jdField_a_of_type_Long, 0L, localbayr.jdField_a_of_type_JavaLangString, false, false);
    }
    if (paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (paramOutputStream = paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramOutputStream = null)
    {
      awjk.a(paramOutputStream, paramDownloadParams.jdField_c_of_type_Int, paramDownloadParams.d, SystemClock.uptimeMillis() - l);
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barz
 * JD-Core Version:    0.7.0.1
 */