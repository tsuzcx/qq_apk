import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.pic.CompressInfo;>;

public class ayfc
{
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.fileExistsAndNotEmpty(paramString)))
    {
      ayde.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    ayde.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    int j;
    int i;
    if (n > i1 * 3.0F)
    {
      j = (int)(i1 * 3.0F);
      i = i1;
    }
    for (;;)
    {
      int k = paramThumbWidthHeightDP.mMinWidth;
      int m = paramThumbWidthHeightDP.mMinHeight;
      int i2 = paramThumbWidthHeightDP.mMaxWidth;
      int i3 = paramThumbWidthHeightDP.mMaxHeight;
      if (j < i)
      {
        if (j >= k) {
          break label444;
        }
        m = (int)(i * k * 1.0F / j);
      }
      for (;;)
      {
        if (i > i3)
        {
          m = (int)(j * i3 * 1.0F / i);
          k = i3;
        }
        for (;;)
        {
          float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
          m = (int)(m * f + 0.5F);
          k = (int)(k * f + 0.5F);
          try
          {
            paramThumbWidthHeightDP = Bitmap.createBitmap(m, k, paramBitmap.getConfig());
            paramThumbWidthHeightDP.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
            Paint localPaint = new Paint(1);
            localPaint.setColor(-16777216);
            QLog.d("compress.Utils", 1, "clip w=" + n + ", h=" + i1 + ", wClip=" + j + ", hClip=" + i + ", dstW=" + m + ", dstH=" + k);
            new Canvas(paramThumbWidthHeightDP).drawBitmap(paramBitmap, new Rect(0, 0, j, i), new Rect(0, 0, m, k), localPaint);
            return paramThumbWidthHeightDP;
          }
          catch (OutOfMemoryError paramThumbWidthHeightDP)
          {
            QLog.e("compress.Utils", 1, "OutOfMemoryError", paramThumbWidthHeightDP);
            return paramBitmap;
          }
          catch (Exception paramThumbWidthHeightDP)
          {
            QLog.e("compress.Utils", 1, "Exception", paramThumbWidthHeightDP);
            return paramBitmap;
          }
          if (i1 <= n * 3.0F) {
            break label454;
          }
          i = (int)(n * 3.0F);
          j = n;
          break;
          if (i < m)
          {
            i3 = (int)(j * m * 1.0F / i);
            k = m;
          }
          for (m = i3;; m = j)
          {
            if (j > i2)
            {
              k = (int)(i * i2 * 1.0F / j);
              m = i2;
              break;
            }
            break;
            k = i;
          }
          i2 = k;
          k = m;
          m = i2;
        }
        label444:
        m = i;
        k = j;
      }
      label454:
      i = i1;
      j = n;
    }
  }
  
  public static ThumbWidthHeightDP a(ThumbWidthHeightDP paramThumbWidthHeightDP, int paramInt)
  {
    boolean bool2 = true;
    int i;
    if (paramInt == 1)
    {
      i = atal.a;
      paramInt = atal.c;
    }
    for (;;)
    {
      return new ThumbWidthHeightDP(paramInt, paramInt, i, i);
      if (paramInt == 2)
      {
        i = atal.b;
        paramInt = atal.d;
      }
      else
      {
        if (paramThumbWidthHeightDP == null) {
          break;
        }
        i = paramThumbWidthHeightDP.maxPx();
        paramInt = paramThumbWidthHeightDP.minPx();
      }
    }
    label69:
    label84:
    label102:
    int j;
    if (paramInt == 3)
    {
      bool1 = true;
      i = AIOImgThumbHelper.getAioThumbMaxPx(bool1, true);
      if (paramInt != 3) {
        break label137;
      }
      bool1 = true;
      i = Math.max(i, CommonImgThumbHelper.getImgThumbMaxPx(bool1));
      if (paramInt != 3) {
        break label143;
      }
      bool1 = true;
      j = AIOImgThumbHelper.getAioThumbMinPx(bool1, true);
      if (paramInt != 3) {
        break label149;
      }
    }
    label137:
    label143:
    label149:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramInt = Math.max(j, CommonImgThumbHelper.getImgThumbMinPx(bool1));
      break;
      bool1 = false;
      break label69;
      bool1 = false;
      break label84;
      bool1 = false;
      break label102;
    }
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExists(paramString)))
    {
      String str2 = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "thumb/");
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    ayde.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExists(paramString)) && (ayev.a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if ((j <= 0) || (j <= i))
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "photo/");
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label246;
        }
      }
      label246:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    ayde.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  public static void a(Context paramContext, List<CompressInfo> paramList)
  {
    int k = 1;
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int j;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    Object localObject1;
    Object localObject2;
    if (paramList.size() > 1)
    {
      j = 1;
      str1 = BaseApplication.getContext().getString(2131690926);
      str2 = BaseApplication.getContext().getString(2131690927);
      str3 = BaseApplication.getContext().getString(2131690922);
      str4 = BaseApplication.getContext().getString(2131690923);
      str5 = BaseApplication.getContext().getString(2131690924);
      str6 = BaseApplication.getContext().getString(2131690925);
      localObject1 = BaseApplication.getContext().getString(2131690929);
      localObject2 = BaseApplication.getContext().getString(2131690930);
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          CompressInfo localCompressInfo = (CompressInfo)localIterator.next();
          if ((localCompressInfo != null) && (localCompressInfo.c)) {
            if (j != 0) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject2 = (CompressInfo)paramList.next();
          if ((localObject2 != null) && (!((CompressInfo)localObject2).e) && (((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
            if (str3.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
            {
              if (str3.equals(localObject1)) {
                break label388;
              }
              if (j != 0)
              {
                paramList = str4;
                i = k;
              }
            }
          }
        }
      }
      for (;;)
      {
        label255:
        if (i == 0) {
          break label412;
        }
        QQToast.a(paramContext, paramList, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
        return;
        j = 0;
        break;
        break label168;
        paramList = str3;
        i = k;
        continue;
        if (str1.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
          if (!str1.equals(localObject1))
          {
            if (j != 0)
            {
              paramList = str2;
              i = k;
              continue;
            }
            paramList = str1;
            i = k;
            continue;
            if ((localObject2 != null) && (((CompressInfo)localObject2).e) && (((CompressInfo)localObject2).jdField_b_of_type_Boolean))
            {
              if (j != 0)
              {
                paramList = str6;
                i = k;
                continue;
              }
              paramList = str5;
              i = k;
              continue;
            }
          }
        }
        for (;;)
        {
          break;
          paramList = (List<CompressInfo>)localObject1;
          i = k;
          break label255;
          i = 1;
        }
        paramList = (List<CompressInfo>)localObject1;
        continue;
        paramList = (List<CompressInfo>)localObject1;
      }
      break;
      localObject1 = "";
    }
  }
  
  public static boolean a()
  {
    return NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1;
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = agjt.a();
      if (localBitmap == null) {
        return false;
      }
      int i = localBitmap.getWidth() / 2;
      int j = localBitmap.getHeight() / 2;
      int m = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      m = m - i - 7;
      k = k - j - 7;
      if ((m > 0) && (k > 0))
      {
        paramBitmap = new Canvas(paramBitmap);
        Paint localPaint = new Paint(2);
        paramBitmap.drawBitmap(localBitmap, null, new Rect(m, k, i + m, j + k), localPaint);
      }
      return true;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Bitmap paramBitmap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    boolean bool = false;
    ThumbWidthHeightDP localThumbWidthHeightDP = a(null, paramInt);
    int j = localThumbWidthHeightDP.mMaxWidth;
    int k = localThumbWidthHeightDP.mMinWidth;
    if (paramBoolean) {}
    for (int i = URLDrawableHelper.getExifRotation(paramString1);; i = 0)
    {
      ayde.a("compress.Utils", paramString3, paramString4 + " ClipStrategy begin  thumbSizeMax：" + j + " thumbSizeMin:" + k + " degree:" + i);
      if ((paramThumbWidthHeightDP != null) && (paramThumbWidthHeightDP.mLimitSizeByServer))
      {
        paramBitmap = a(paramBitmap, paramThumbWidthHeightDP);
        if (paramBitmap != null) {
          break label213;
        }
        ayde.a("compress.Utils", paramString3, paramString4 + " ClipStrategy fail");
        paramBoolean = bool;
      }
      label213:
      do
      {
        return paramBoolean;
        paramString1 = new ayet(j, k, i);
        paramBitmap = paramString1.a(paramBitmap);
        ayde.a("compress.Utils", paramString3, " needCut:" + paramString1.jdField_b_of_type_Boolean + " needScale:" + paramString1.c);
        break;
        ayde.a("compress.Utils", paramString3, paramString4 + " ClipStrategy suc  destWidth：" + paramBitmap.getWidth() + " destHeight:" + paramBitmap.getHeight());
        paramBitmap = a(paramBitmap);
        if (paramInt == 3)
        {
          paramBoolean = a(paramBitmap);
          ayde.a("compress.Utils", paramString3, paramString4 + " isDrawGIFSucc：" + paramBoolean);
        }
        bool = c(paramString2, paramBitmap, 70, paramString4, null);
        paramBoolean = bool;
      } while (paramBitmap == null);
      paramBitmap.recycle();
      return bool;
    }
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      ayde.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      ayde.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      ayde.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      ayde.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    bfvo.a(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      ayde.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      ayde.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      ayde.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramJpegOptions.inSampleSize;; paramInt = 1)
    {
      paramJpegOptions.inSampleSize = paramInt;
      ayde.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (c()) {
      return b(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    return a(paramString1, paramString2, paramBoolean, paramString3, paramInt, null);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.fileExistsAndNotEmpty(paramString1)))
    {
      ayde.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    ayde.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bfvo.a(paramString1, localOptions);
    if (!a(localOptions, a(paramThumbWidthHeightDP, paramInt).mMaxWidth))
    {
      ayde.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
    }
    try
    {
      Bitmap localBitmap3 = SafeBitmapFactory.safeDecode(paramString1, localOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        ayde.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      ayde.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = bfvo.a(paramString1, localOptions);
        int i = localBitmap2.getWidth();
        int j = localBitmap2.getHeight();
        ayde.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, paramBoolean, paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt, paramThumbWidthHeightDP);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        ayde.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      bool1 = bool3;
      if (!FileUtils.estimateFileType(paramString).equals("jpg")) {}
    }
    try
    {
      float f = JpegCompressor.getJpegQuality(paramString);
      long l = FileUtils.getFileSizes(paramString);
      bool1 = bool2;
      if (f <= 80.0F)
      {
        bool1 = bool2;
        if (l < 307200L) {
          bool1 = true;
        }
      }
      ayde.a("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + f + ",picSize = " + l + "result = " + bool1);
      return bool1;
    }
    catch (RuntimeException paramString)
    {
      ayde.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + paramString + ",return false!");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      ayde.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + paramString + ",return false!");
    }
    return false;
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      ayde.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    ayde.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new ayfd((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        bfwl.a();
        ((JpegCompressor)localObject).compress(paramBitmap);
        bfwl.a("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        ayde.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
        }
        return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
      }
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      ayde.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      ayde.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.fileExistsAndNotEmpty(paramString1)))
    {
      ayde.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    ayde.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    if (!a(localJpegOptions, a(null, paramInt).mMaxWidth))
    {
      ayde.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
    }
    try
    {
      Bitmap localBitmap3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        ayde.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      ayde.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        int i = localBitmap2.getWidth();
        int j = localBitmap2.getHeight();
        ayde.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, paramBoolean, paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt, null);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        ayde.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  /* Error */
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokestatic 12	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +17 -> 24
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: iload_2
    //   15: bipush 100
    //   17: if_icmpgt +7 -> 24
    //   20: iload_2
    //   21: ifgt +37 -> 58
    //   24: ldc 20
    //   26: ldc_w 729
    //   29: new 24	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 667
    //   43: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 5
    //   55: iload 5
    //   57: ireturn
    //   58: ldc 20
    //   60: ldc_w 729
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 669
    //   77: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 116	ayde:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 46	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 317	java/io/File:exists	()Z
    //   105: ifeq +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 672	java/io/File:delete	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokestatic 733	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   118: pop
    //   119: new 735	java/io/FileOutputStream
    //   122: dup
    //   123: aload 6
    //   125: invokespecial 738	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: astore 8
    //   130: new 740	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload 8
    //   136: invokespecial 743	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload_1
    //   146: getstatic 749	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   149: iload_2
    //   150: aload 7
    //   152: invokevirtual 752	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   155: pop
    //   156: aload 7
    //   158: astore 6
    //   160: aload 7
    //   162: invokevirtual 755	java/io/BufferedOutputStream:flush	()V
    //   165: aload 7
    //   167: astore 6
    //   169: aload 8
    //   171: invokevirtual 759	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +22 -> 198
    //   179: aload 7
    //   181: astore 6
    //   183: aload_1
    //   184: invokevirtual 764	java/io/FileDescriptor:valid	()Z
    //   187: ifeq +11 -> 198
    //   190: aload 7
    //   192: astore 6
    //   194: aload_1
    //   195: invokevirtual 767	java/io/FileDescriptor:sync	()V
    //   198: aload 7
    //   200: ifnull +8 -> 208
    //   203: aload 7
    //   205: invokevirtual 770	java/io/BufferedOutputStream:close	()V
    //   208: aload_0
    //   209: invokestatic 18	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   212: ifne -157 -> 55
    //   215: ldc 20
    //   217: ldc_w 729
    //   220: new 24	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   227: aload_3
    //   228: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 772
    //   234: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_1
    //   246: aload 4
    //   248: ifnull +13 -> 261
    //   251: aload 7
    //   253: astore 6
    //   255: aload 4
    //   257: iconst_1
    //   258: invokevirtual 775	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   261: aload 7
    //   263: astore 6
    //   265: ldc 20
    //   267: ldc_w 729
    //   270: ldc_w 777
    //   273: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   276: goto -78 -> 198
    //   279: astore_0
    //   280: aload 7
    //   282: astore 6
    //   284: ldc 20
    //   286: ldc_w 729
    //   289: new 24	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   296: aload_3
    //   297: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 710
    //   303: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 7
    //   314: astore 6
    //   316: aload_0
    //   317: invokevirtual 711	java/io/FileNotFoundException:printStackTrace	()V
    //   320: aload 7
    //   322: ifnull +8 -> 330
    //   325: aload 7
    //   327: invokevirtual 770	java/io/BufferedOutputStream:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: aload 4
    //   335: ifnull +13 -> 348
    //   338: aload 7
    //   340: astore 6
    //   342: aload 4
    //   344: iconst_1
    //   345: invokevirtual 775	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   348: aload 7
    //   350: astore 6
    //   352: ldc 20
    //   354: ldc_w 729
    //   357: ldc_w 779
    //   360: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -165 -> 198
    //   366: astore_0
    //   367: aload 7
    //   369: astore 6
    //   371: ldc 20
    //   373: ldc_w 729
    //   376: new 24	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   383: aload_3
    //   384: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 781
    //   390: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 44	ayde:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 7
    //   401: astore 6
    //   403: aload_0
    //   404: invokevirtual 782	java/lang/Exception:printStackTrace	()V
    //   407: aload 7
    //   409: ifnull +8 -> 417
    //   412: aload 7
    //   414: invokevirtual 770	java/io/BufferedOutputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 714	java/io/IOException:printStackTrace	()V
    //   424: goto -216 -> 208
    //   427: astore_0
    //   428: aload_0
    //   429: invokevirtual 714	java/io/IOException:printStackTrace	()V
    //   432: goto -102 -> 330
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 714	java/io/IOException:printStackTrace	()V
    //   440: goto -23 -> 417
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +8 -> 457
    //   452: aload 6
    //   454: invokevirtual 770	java/io/BufferedOutputStream:close	()V
    //   457: aload_0
    //   458: athrow
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 714	java/io/IOException:printStackTrace	()V
    //   464: goto -7 -> 457
    //   467: astore_0
    //   468: goto -21 -> 447
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 7
    //   475: goto -108 -> 367
    //   478: astore_0
    //   479: aconst_null
    //   480: astore 7
    //   482: goto -202 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramString1	String
    //   0	485	1	paramBitmap	Bitmap
    //   0	485	2	paramInt	int
    //   0	485	3	paramString2	String
    //   0	485	4	paramCompressInfo	CompressInfo
    //   1	55	5	bool	boolean
    //   98	355	6	localObject	Object
    //   139	342	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   128	42	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   160	165	245	java/io/SyncFailedException
    //   169	175	245	java/io/SyncFailedException
    //   183	190	245	java/io/SyncFailedException
    //   194	198	245	java/io/SyncFailedException
    //   145	156	279	java/io/FileNotFoundException
    //   160	165	279	java/io/FileNotFoundException
    //   169	175	279	java/io/FileNotFoundException
    //   183	190	279	java/io/FileNotFoundException
    //   194	198	279	java/io/FileNotFoundException
    //   255	261	279	java/io/FileNotFoundException
    //   265	276	279	java/io/FileNotFoundException
    //   342	348	279	java/io/FileNotFoundException
    //   352	363	279	java/io/FileNotFoundException
    //   160	165	332	java/io/IOException
    //   169	175	332	java/io/IOException
    //   183	190	332	java/io/IOException
    //   194	198	332	java/io/IOException
    //   145	156	366	java/lang/Exception
    //   160	165	366	java/lang/Exception
    //   169	175	366	java/lang/Exception
    //   183	190	366	java/lang/Exception
    //   194	198	366	java/lang/Exception
    //   255	261	366	java/lang/Exception
    //   265	276	366	java/lang/Exception
    //   342	348	366	java/lang/Exception
    //   352	363	366	java/lang/Exception
    //   203	208	419	java/io/IOException
    //   325	330	427	java/io/IOException
    //   412	417	435	java/io/IOException
    //   114	141	443	finally
    //   452	457	459	java/io/IOException
    //   145	156	467	finally
    //   160	165	467	finally
    //   169	175	467	finally
    //   183	190	467	finally
    //   194	198	467	finally
    //   255	261	467	finally
    //   265	276	467	finally
    //   284	312	467	finally
    //   316	320	467	finally
    //   342	348	467	finally
    //   352	363	467	finally
    //   371	399	467	finally
    //   403	407	467	finally
    //   114	141	471	java/lang/Exception
    //   114	141	478	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfc
 * JD-Core Version:    0.7.0.1
 */