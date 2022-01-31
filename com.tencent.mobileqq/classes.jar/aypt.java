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

public class aypt
  extends ayoh
{
  public aypt(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public aypt(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private aypu a(DownloadParams paramDownloadParams)
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    aypu localaypu = new aypu(this);
    localaypu.jdField_a_of_type_JavaNetURL = paramDownloadParams.url;
    aune.a("PIC_TAG", "getDownloadData", "url:" + localaypu.jdField_a_of_type_JavaNetURL);
    localaypu.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    localaypu.jdField_a_of_type_Long = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof auoa)))
    {
      Object localObject = (auoa)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        localaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localaypu.d = aunq.a();
        localaypu.jdField_c_of_type_Int = aunq.a(localaypu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      localaypu.jdField_a_of_type_Aunl = ((auoa)localObject).getPicDownloadInfo();
      a(localaypu, "getDownloadData", "uuid:" + localaypu.jdField_a_of_type_Aunl.g + ",md5：" + localaypu.jdField_a_of_type_Aunl.f);
      localaypu.jdField_a_of_type_JavaLangString = a(localaypu.jdField_a_of_type_Aunl.jdField_b_of_type_Int);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (localaypu.jdField_a_of_type_Aunl.jdField_e_of_type_Int == 1) {
        bool = true;
      }
      localaypu.jdField_a_of_type_Int = aywk.a(paramDownloadParams, bool);
      if (((auoa)localObject).isSendFromLocal())
      {
        localaypu.jdField_a_of_type_Boolean = true;
        localaypu.jdField_a_of_type_Auob = ((auoa)localObject).getPicUploadInfo();
        localaypu.jdField_a_of_type_Aunl.jdField_a_of_type_Boolean = true;
        if (localaypu.jdField_a_of_type_Int != 65537) {
          break label461;
        }
        if (localaypu.jdField_a_of_type_Auob.jdField_c_of_type_Int != ayvu.f) {
          break label427;
        }
        localObject = ((ayte)localaypu.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangObject).jdField_c_of_type_JavaLangString;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = a(localaypu, (String)localObject);
        }
      }
      label427:
      label461:
      for (localaypu.jdField_b_of_type_JavaLangString = paramDownloadParams;; localaypu.jdField_b_of_type_JavaLangString = localaypu.jdField_a_of_type_Auob.g)
      {
        a(localaypu, "getDownloadData", "path:" + localaypu.jdField_a_of_type_Auob.g + ",sendPath：" + localaypu.jdField_b_of_type_JavaLangString);
        return localaypu;
        if (localaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isQzonePic)
        {
          paramDownloadParams = localaypu.jdField_a_of_type_Auob.h;
          break;
        }
        paramDownloadParams = a(localaypu, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      localaypu.jdField_b_of_type_JavaLangString = ((String)paramDownloadParams.tag);
      return localaypu;
    }
    if (paramDownloadParams.tag == null) {
      a(localaypu, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      a(localaypu, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
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
  
  private String a(aypu paramaypu, String paramString)
  {
    if (bbdj.a(paramString)) {}
    while (!bbdj.a(paramaypu.jdField_a_of_type_Auob.g)) {
      return paramString;
    }
    paramString = new CompressInfo(paramaypu.jdField_a_of_type_Auob.g, 0);
    paramString.jdField_a_of_type_JavaLangString = paramaypu.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString;
    auoq.b(paramString);
    return paramString.jdField_e_of_type_JavaLangString;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = a(paramMessageRecord.istroop);
        Object localObject = new ayvu();
        ((ayvu)localObject).a(paramMessageRecord.msg);
        if (((ayvu)localObject).jdField_a_of_type_Int == 1)
        {
          String str2 = ((ayvu)localObject).jdField_b_of_type_JavaLangString;
          localObject = ((ayvu)localObject).jdField_c_of_type_JavaLangString;
          if ((bbbg.a(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = aywk.a((MessageForPic)paramMessageRecord, 65537, null);
            if (a(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              a(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = aywk.a((MessageForPic)paramMessageRecord, 65537, null);
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
      paramString1 = new ayol(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
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
    if ((paramObject instanceof aypu)) {
      if (QLog.isColorLevel())
      {
        paramObject = (aypu)paramObject;
        if (paramObject.jdField_a_of_type_Auob == null) {
          break label58;
        }
        i = ayui.a(paramObject.jdField_a_of_type_Int);
        ayui.c(paramObject.jdField_a_of_type_Auob.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Auob.jdField_a_of_type_Long), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.jdField_a_of_type_Aunl != null)
        {
          i = ayui.a(paramObject.jdField_a_of_type_Int);
          ayui.c(paramObject.jdField_a_of_type_Aunl.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Aunl.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
      return;
    }
    QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
  }
  
  aywh a(aypu paramaypu)
  {
    if (paramaypu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    try
    {
      paramaypu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramaypu.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramaypu.jdField_a_of_type_Aunl.jdField_b_of_type_JavaLangString));
      label28:
      if (paramaypu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        a(paramaypu, "stepDownload", "params.app == null ,selfuin:" + paramaypu.jdField_a_of_type_Aunl.jdField_b_of_type_JavaLangString);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + paramaypu.jdField_a_of_type_Aunl.jdField_b_of_type_JavaLangString, false, false);
      }
      auml localauml = new auml(paramaypu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localauml.jdField_a_of_type_Aunt = new aunt();
      localauml.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      localauml.jdField_b_of_type_JavaLangString = "PIC_TAG";
      localauml.jdField_a_of_type_JavaLangString = paramaypu.jdField_c_of_type_JavaLangString;
      paramaypu.jdField_a_of_type_Aunl.jdField_e_of_type_JavaLangString = paramaypu.jdField_a_of_type_JavaNetURL.getProtocol();
      if (paramaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
      {
        paramaypu.jdField_a_of_type_Aunl.d = paramaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.bEnableEnc;
        paramaypu.jdField_a_of_type_Aunl.c = paramaypu.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.time;
      }
      aune.a("PIC_TAG", paramaypu.jdField_c_of_type_JavaLangString, "stepDownload", "url:" + paramaypu.jdField_a_of_type_JavaNetURL + ",info:" + paramaypu.jdField_a_of_type_Aunl);
      return localauml.a(paramaypu.jdField_a_of_type_Aunl, paramaypu.jdField_a_of_type_ComTencentImageURLDrawableHandler, paramaypu.jdField_a_of_type_JavaNetURL.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    float f3;
    int j;
    int i;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    int n;
    try
    {
      f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
      i8 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
      boolean bool = bgkh.a(paramDownloadParams.mImgType);
      j = aywk.b(bool);
      i = aywk.b(bool);
      m = aywk.a(bool);
      k = aywk.a(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject = (MessageForPic)paramDownloadParams.tag;
        j = actn.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        i = actn.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        m = actn.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxWidth, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        k = actn.a(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxHeight, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      localObject = new Paint(1);
      ((Paint)localObject).setColor(-16777216);
      i5 = aywk.d(bool);
      i4 = aywk.d(bool);
      i3 = aywk.c(bool);
      i2 = aywk.c(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label553;
      }
      paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
      i5 = paramDownloadParams.getThumbWidthHeightDP(bool).mMinWidth;
      i4 = paramDownloadParams.getThumbWidthHeightDP(bool).mMinHeight;
      i3 = paramDownloadParams.getThumbWidthHeightDP(bool).mMaxWidth;
      i2 = paramDownloadParams.getThumbWidthHeightDP(bool).mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      int i8;
      int m;
      int k;
      Object localObject;
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
    if (i1 < n)
    {
      m = (int)(j / i1 * n + 0.5F);
      i = m;
      if (m <= k) {
        break label598;
      }
      i = k;
    }
    for (;;)
    {
      label344:
      paramDownloadParams = Bitmap.createBitmap(j, i, aywk.b);
      paramDownloadParams.setDensity(i8);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, i1, n), new Rect(0, 0, j, i), (Paint)localObject);
      return new RoundRectBitmap(paramDownloadParams, 12.0F * f3);
      k = (int)(i / n * i1 + 0.5F);
      j = k;
      if (k > m) {
        j = m;
      }
      label467:
      label598:
      do
      {
        float f1;
        if (i1 > n)
        {
          f1 = m / i1;
          if (i1 <= n) {
            break label528;
          }
        }
        for (float f2 = i / n;; f2 = j / i1)
        {
          f1 = Math.max(f1, f2);
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
          f1 = k / n;
          break label467;
        }
        if (i6 > i7 * 3.0F)
        {
          i1 = (int)(i7 * 3.0F);
          n = i7;
        }
        while (i1 >= i5)
        {
          if (n >= i4) {
            break label643;
          }
          break;
          break label344;
          n = i7;
          i1 = i6;
          if (i7 > i6 * 3.0F)
          {
            n = (int)(i6 * 3.0F);
            i1 = i6;
          }
        }
        break label344;
      } while ((i1 >= i3) || (n >= i2));
      label528:
      label553:
      j = (int)(i1 * f3 + 0.5F);
      label643:
      i = (int)(n * f3 + 0.5F);
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
      if ((paramDownloadParams.jdField_a_of_type_Auob == null) || (paramDownloadParams.jdField_b_of_type_JavaLangString == null)) {
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
    if (paramDownloadParams.jdField_a_of_type_Aunl == null)
    {
      a(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      a(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString + ",uniseq:" + paramDownloadParams.jdField_a_of_type_Aunl.jdField_a_of_type_Long);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((bbbd.a()) && (bbbd.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bbbd.b());
    }
    aywh localaywh = a(paramDownloadParams);
    int j;
    if (localaywh.jdField_a_of_type_Int == 0)
    {
      j = 1;
      if (j == 0) {
        break label374;
      }
    }
    label374:
    for (paramOutputStream = "successed";; paramOutputStream = "failed " + localaywh.jdField_a_of_type_JavaLangString)
    {
      a(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label482;
      }
      paramOutputStream = PicDownloadExplicitError.getPicError(localaywh);
      if (paramOutputStream == null) {
        break label402;
      }
      throw paramOutputStream;
      j = 0;
      break;
    }
    label402:
    if (localaywh.jdField_a_of_type_Long == 9037L) {
      paramURLDrawableHandler.doCancel();
    }
    label482:
    while (i == 0)
    {
      return null;
      if ((localaywh.jdField_a_of_type_Long == -9527L) && ("H_404_-124".equals(localaywh.jdField_a_of_type_JavaLangString)))
      {
        a(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localaywh.jdField_a_of_type_Long, 0L, localaywh.jdField_a_of_type_JavaLangString, false, false);
    }
    if (paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (paramOutputStream = paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramOutputStream = null)
    {
      auns.a(paramOutputStream, paramDownloadParams.jdField_c_of_type_Int, paramDownloadParams.d, SystemClock.uptimeMillis() - l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */