import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class auoy
{
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!bbdj.b(paramString)))
    {
      aune.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
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
    aune.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  private static aupa a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, null);
  }
  
  private static aupa a(int paramInt1, int paramInt2, int paramInt3, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    int k = 1;
    int m = 0;
    int i;
    int j;
    if (paramThumbWidthHeightDP != null)
    {
      i = paramThumbWidthHeightDP.maxPx();
      if (paramThumbWidthHeightDP == null) {
        break label117;
      }
      j = paramThumbWidthHeightDP.minPx();
      label26:
      if (paramInt3 != 1) {
        break label126;
      }
      i = apuw.a;
      j = apuw.c;
      label41:
      if (paramInt1 <= i) {
        break label151;
      }
      if (!a(paramInt1, paramInt2, paramInt3)) {
        break label144;
      }
      paramInt2 = 1;
      paramInt1 = k;
    }
    for (;;)
    {
      paramThumbWidthHeightDP = new aupa(null);
      paramThumbWidthHeightDP.a = paramInt2;
      paramThumbWidthHeightDP.b = paramInt1;
      aune.a("compress.Utils", "getType()", " type=" + paramThumbWidthHeightDP);
      return paramThumbWidthHeightDP;
      i = aywk.a(false);
      break;
      label117:
      j = aywk.b(false);
      break label26;
      label126:
      if (paramInt3 != 2) {
        break label41;
      }
      i = apuw.b;
      j = apuw.d;
      break label41;
      label144:
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      label151:
      if ((paramInt1 <= i) && (paramInt1 > j))
      {
        if (paramInt2 > i)
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= i) && (paramInt2 > j))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= j) && (paramInt1 > 0))
      {
        if (paramInt2 > i)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= i) && (paramInt2 > j))
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= j) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = m;
    }
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (bbdj.a(paramString)))
    {
      String str2 = azaa.a(ajsf.aW + "thumb/");
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
    aune.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (bbdj.a(paramString)) && (auor.a(paramInt)))
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
        str = azaa.a(ajsf.aW + "photo/");
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label236;
        }
      }
      label236:
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
    aune.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  public static void a(Context paramContext, List<CompressInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int n;
    int m;
    int j;
    Object localObject1;
    String str2;
    String str3;
    String str4;
    String str5;
    int i1;
    int i;
    String str1;
    String str6;
    String str7;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    int k;
    if (paramList.size() > 1)
    {
      n = 1;
      m = 0;
      j = 0;
      localObject1 = "";
      str2 = BaseApplication.getContext().getString(2131691007);
      str3 = BaseApplication.getContext().getString(2131691008);
      str4 = BaseApplication.getContext().getString(2131691003);
      str5 = BaseApplication.getContext().getString(2131691004);
      i1 = 0;
      i = 0;
      str1 = "";
      str6 = BaseApplication.getContext().getString(2131691005);
      str7 = BaseApplication.getContext().getString(2131691006);
      localObject3 = BaseApplication.getContext().getString(2131691010);
      localObject2 = BaseApplication.getContext().getString(2131691011);
      localObject4 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (CompressInfo)((Iterator)localObject4).next();
          if ((localObject5 != null) && (((CompressInfo)localObject5).c)) {
            if (n != 0)
            {
              k = 1;
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label188:
      localObject4 = str1;
      localObject2 = localObject1;
      if (k == 0)
      {
        localObject5 = paramList.iterator();
        paramList = str1;
        label212:
        localObject4 = paramList;
        i1 = i;
        localObject2 = localObject1;
        m = j;
        if (((Iterator)localObject5).hasNext())
        {
          localObject2 = (CompressInfo)((Iterator)localObject5).next();
          if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
            break label436;
          }
          i1 = 1;
          j = 1;
          if (!str4.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            break label382;
          }
          localObject4 = paramList;
          i1 = i;
          localObject2 = localObject1;
          m = j;
          if (!str4.equals(localObject1))
          {
            if (n == 0) {
              break label366;
            }
            localObject2 = str5;
            m = j;
            i1 = i;
            localObject4 = paramList;
          }
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label494;
        }
        bcpw.a(paramContext, (CharSequence)localObject3, 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
        return;
        n = 0;
        break;
        k = 1;
        break label188;
        label366:
        localObject2 = str4;
        localObject4 = paramList;
        i1 = i;
        m = j;
      }
      label382:
      m = i1;
      if (str2.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
      {
        m = i1;
        if (!str2.equals(localObject1)) {
          if (n != 0)
          {
            j = 1;
            localObject1 = str3;
          }
        }
      }
      for (;;)
      {
        break label212;
        j = 1;
        localObject1 = str2;
        continue;
        label436:
        m = j;
        if (localObject2 != null)
        {
          m = j;
          if (((CompressInfo)localObject2).e)
          {
            m = j;
            if (((CompressInfo)localObject2).jdField_b_of_type_Boolean)
            {
              m = j;
              if (i == 0)
              {
                if (n != 0)
                {
                  i = 1;
                  paramList = str7;
                  continue;
                }
                i = 1;
                paramList = str6;
                continue;
                label494:
                if (m != 0)
                {
                  bcpw.a(paramContext, (CharSequence)localObject2, 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
                  return;
                }
                if (i1 == 0) {
                  break;
                }
                bcpw.a(paramContext, (CharSequence)localObject4, 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
                return;
              }
            }
          }
        }
        j = m;
      }
      localObject3 = "";
      k = 0;
    }
  }
  
  public static boolean a()
  {
    return bbev.b(BaseApplication.getContext()) == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) || (paramInt3 == 2)) {
      if (paramInt2 <= (int)(paramInt1 * 1.777778F)) {}
    }
    while (paramInt2 > paramInt1 * 3.0F)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = advu.a();
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
  
  public static boolean a(Bitmap paramBitmap, aupa paramaupa, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    return a(paramBitmap, paramaupa, paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt, null);
  }
  
  public static boolean a(Bitmap paramBitmap, aupa paramaupa, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    int n = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i;
    label24:
    int j;
    label36:
    int m;
    if (paramThumbWidthHeightDP != null)
    {
      i = paramThumbWidthHeightDP.maxPx();
      if (paramThumbWidthHeightDP == null) {
        break label440;
      }
      j = paramThumbWidthHeightDP.minPx();
      if (paramInt != 1) {
        break label449;
      }
      i = apuw.a;
      m = apuw.c;
    }
    for (;;)
    {
      label52:
      int i1;
      int k;
      int i4;
      switch (paramaupa.b)
      {
      case 2: 
      case 4: 
      case 5: 
      default: 
        j = i2;
        i1 = n;
        k = n;
        n = j;
        j = i2;
        paramThumbWidthHeightDP = new Matrix();
        i4 = aywk.a(paramString1);
        if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
          break;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        aune.a("compress.Utils", paramString3, paramString4 + " sample after W:" + k + " H:" + j + " isLongImg:" + a(0, 0, paramInt) + " type:" + paramaupa + " needRotate:" + bool2);
        int i3;
        if (i1 > n) {
          i3 = i1;
        }
        boolean bool1;
        for (i2 = n;; i2 = i1) {
          switch (paramaupa.a)
          {
          default: 
            bool1 = false;
            paramBoolean = false;
            aune.a("compress.Utils", paramString3, paramString4 + " destWidth：" + i1 + " destHeight:" + n + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramBitmap = a(paramBitmap);
            if (paramInt == 3)
            {
              paramBoolean = a(paramBitmap);
              aune.a("compress.Utils", paramString3, paramString4 + " isDrawGIFSucc：" + paramBoolean);
            }
            paramBoolean = c(paramString2, paramBitmap, 70, paramString4, null);
            if (paramBitmap != null) {
              paramBitmap.recycle();
            }
            return paramBoolean;
            i = aywk.a(false);
            break label24;
            label440:
            j = aywk.b(false);
            break label36;
            label449:
            if (paramInt != 2) {
              break label1626;
            }
            i = apuw.b;
            m = apuw.d;
            break label52;
            aune.a("compress.Utils", paramString3, paramString4 + " type.type2:136");
            if (n > i2)
            {
              j = i2;
              label507:
              if ((paramInt != 1) && (paramInt != 2)) {
                break label621;
              }
              k = (int)(j * 1.777778F);
              label529:
              if (n <= i2) {
                break label630;
              }
            }
            for (;;)
            {
              for (;;)
              {
                n = k;
                try
                {
                  if (k > paramBitmap.getWidth()) {
                    n = paramBitmap.getWidth();
                  }
                  k = j;
                  if (j > paramBitmap.getHeight()) {
                    k = paramBitmap.getHeight();
                  }
                  paramThumbWidthHeightDP = Bitmap.createBitmap(paramBitmap, 0, 0, n, k);
                  k = paramThumbWidthHeightDP.getWidth();
                  j = paramThumbWidthHeightDP.getHeight();
                  n = j;
                  i1 = k;
                  paramBitmap = paramThumbWidthHeightDP;
                }
                catch (OutOfMemoryError paramString1)
                {
                  label621:
                  label630:
                  paramBitmap.recycle();
                  paramString1.printStackTrace();
                  aune.b("compress.Utils", paramString3, paramString4 + " cut 3:1 createBitmap OutOfMemoryError, type:" + paramaupa);
                  return false;
                }
              }
              j = n;
              break label507;
              k = j * 3;
              break label529;
              n = j;
              j = k;
              k = n;
            }
            i3 = n;
          }
        }
        float f = m / (i2 * 1.0F);
        i2 = (int)(i3 * f);
        if (bool2) {
          paramThumbWidthHeightDP.postRotate(i4, k >> 1, j >> 1);
        }
        paramThumbWidthHeightDP.postScale(f, f);
        i2 = k;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (k > paramBitmap.getWidth()) {
                i2 = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i2, k, paramThumbWidthHeightDP, true);
              if (i1 > n) {
                j = m;
              }
            }
            catch (OutOfMemoryError paramString1)
            {
              try
              {
                if (i4 / 90 % 2 == 0) {
                  break label1605;
                }
                i1 = j;
                if (j > paramString1.getWidth()) {
                  i1 = paramString1.getWidth();
                }
                n = i;
                if (i > paramString1.getHeight()) {
                  n = paramString1.getHeight();
                }
                paramBitmap = Bitmap.createBitmap(paramString1, 0, 0, i1, n);
                bool1 = true;
                paramBoolean = true;
              }
              catch (OutOfMemoryError paramBitmap)
              {
                paramString1.recycle();
                paramBitmap.printStackTrace();
                aune.b("compress.Utils", paramString3, paramString4 + " case 1: cut createBitmap OutOfMemoryError, type:" + paramaupa);
                return false;
              }
              paramString1 = paramString1;
              paramBitmap.recycle();
              paramString1.printStackTrace();
              aune.b("compress.Utils", paramString3, paramString4 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + paramaupa);
              return false;
            }
            j = i;
            i = m;
            continue;
            f = i / (i3 * 1.0F);
            m = (int)(i2 * f);
            if (i1 > n)
            {
              i1 = i;
              n = m;
            }
            for (;;)
            {
              for (;;)
              {
                if (bool2) {
                  paramThumbWidthHeightDP.postRotate(i4, k >> 1, j >> 1);
                }
                paramThumbWidthHeightDP.postScale(f, f);
                i = k;
                try
                {
                  if (k > paramBitmap.getWidth()) {
                    i = paramBitmap.getWidth();
                  }
                  k = j;
                  if (j > paramBitmap.getHeight()) {
                    k = paramBitmap.getHeight();
                  }
                  paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, paramThumbWidthHeightDP, true);
                  bool1 = false;
                  paramBitmap = paramString1;
                  paramBoolean = true;
                }
                catch (OutOfMemoryError paramString1)
                {
                  paramBitmap.recycle();
                  paramString1.printStackTrace();
                  aune.b("compress.Utils", paramString3, paramString4 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + paramaupa);
                  return false;
                }
              }
              n = i;
              i1 = m;
            }
            if (!bool2) {
              break;
            }
            paramThumbWidthHeightDP.postRotate(i4, k >> 1, j >> 1);
            i = k;
            try
            {
              if (k > paramBitmap.getWidth()) {
                i = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, paramThumbWidthHeightDP, true);
              bool1 = false;
              paramBitmap = paramString1;
              paramBoolean = false;
            }
            catch (OutOfMemoryError paramString1)
            {
              paramBitmap.recycle();
              paramString1.printStackTrace();
              aune.b("compress.Utils", paramString3, paramString4 + " case 3: rotate createBitmap OutOfMemoryError, type:" + paramaupa);
              return false;
            }
          }
          if (bool2)
          {
            paramThumbWidthHeightDP.postRotate(i4, k >> 1, j >> 1);
            i = k;
          }
          for (;;)
          {
            try
            {
              if (k > paramBitmap.getWidth()) {
                i = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, paramThumbWidthHeightDP, true);
              paramBitmap = paramString1;
              if ((paramInt == 1) || (paramInt == 2))
              {
                i = (int)(i2 * 1.777778F);
                if (i1 <= n) {
                  break label1526;
                }
                j = i2;
              }
            }
            catch (OutOfMemoryError paramString1)
            {
              try
              {
                if (i4 / 90 % 2 == 0) {
                  break label1587;
                }
                i1 = j;
                if (j > paramBitmap.getWidth()) {
                  i1 = paramBitmap.getWidth();
                }
                n = i;
                if (i > paramBitmap.getHeight()) {
                  n = paramBitmap.getHeight();
                }
                paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i1, n);
                paramBitmap = paramString1;
                bool1 = true;
                paramBoolean = false;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (paramBitmap.isRecycled()) {
                  break label1549;
                }
                paramBitmap.recycle();
                paramString1.printStackTrace();
                aune.b("compress.Utils", paramString3, paramString4 + " case 4: cut createBitmap OutOfMemoryError, type:" + paramaupa);
                return false;
              }
              paramString1 = paramString1;
              paramBitmap.recycle();
              paramString1.printStackTrace();
              aune.b("compress.Utils", paramString3, paramString4 + " case 4: rotate createBitmap OutOfMemoryError, type:" + paramaupa);
              return false;
            }
            i = i2 * 3;
            continue;
            label1526:
            j = i;
            i = i2;
            continue;
            label1549:
            label1587:
            k = i;
            i = j;
            j = k;
          }
          label1605:
          k = i;
          i = j;
          j = k;
        }
      }
      label1626:
      m = j;
    }
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      aune.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      aune.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
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
      aune.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      aune.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    bbdr.a(paramString, paramOptions);
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
      aune.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      aune.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      aune.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
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
      aune.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!bbdj.b(paramString1)))
    {
      aune.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    aune.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bbdr.a(paramString1, localOptions);
    int j;
    int i;
    aupa localaupa;
    if (localOptions.outWidth > localOptions.outHeight)
    {
      j = localOptions.outWidth;
      i = localOptions.outHeight;
      localaupa = a(i, j, paramInt, paramThumbWidthHeightDP);
      if (paramThumbWidthHeightDP == null) {
        break label232;
      }
      i = paramThumbWidthHeightDP.maxPx();
      label148:
      if (paramThumbWidthHeightDP == null) {
        break label241;
      }
      paramThumbWidthHeightDP.minPx();
      label159:
      if (paramInt != 1) {
        break label249;
      }
      i = apuw.a;
      j = apuw.c;
    }
    for (;;)
    {
      if (a(localOptions, i)) {
        break label268;
      }
      aune.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localOptions.outHeight;
      i = localOptions.outWidth;
      break;
      label232:
      i = aywk.a(false);
      break label148;
      label241:
      aywk.b(false);
      break label159;
      label249:
      if (paramInt == 2)
      {
        i = apuw.b;
        j = apuw.d;
      }
    }
    try
    {
      label268:
      Bitmap localBitmap3 = SafeBitmapFactory.safeDecode(paramString1, localOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        aune.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      aune.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = bbdr.a(paramString1, localOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        aune.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localaupa, paramBoolean, paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt, paramThumbWidthHeightDP);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        aune.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
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
    if (bbdj.b(paramString))
    {
      bool1 = bool3;
      if (!bbdj.b(paramString).equals("jpg")) {}
    }
    try
    {
      float f = JpegCompressor.getJpegQuality(paramString);
      long l = bbdj.a(paramString);
      bool1 = bool2;
      if (f <= 80.0F)
      {
        bool1 = bool2;
        if (l < 307200L) {
          bool1 = true;
        }
      }
      aune.a("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + f + ",picSize = " + l + "result = " + bool1);
      return bool1;
    }
    catch (RuntimeException paramString)
    {
      aune.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + paramString + ",return false!");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      aune.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + paramString + ",return false!");
    }
    return false;
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      aune.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    aune.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new auoz((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        bben.a();
        ((JpegCompressor)localObject).compress(paramBitmap);
        bben.a("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        aune.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
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
      aune.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      aune.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!bbdj.b(paramString1)))
    {
      aune.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    aune.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    int j;
    int i;
    aupa localaupa;
    if (localJpegOptions.outWidth > localJpegOptions.outHeight)
    {
      j = localJpegOptions.outWidth;
      i = localJpegOptions.outHeight;
      localaupa = a(i, j, paramInt);
      i = aywk.a(false);
      aywk.b(false);
      if (paramInt != 1) {
        break label218;
      }
      i = apuw.a;
      j = apuw.c;
    }
    for (;;)
    {
      if (a(localJpegOptions, i)) {
        break label237;
      }
      aune.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localJpegOptions.outHeight;
      i = localJpegOptions.outWidth;
      break;
      label218:
      if (paramInt == 2)
      {
        i = apuw.b;
        j = apuw.d;
      }
    }
    try
    {
      label237:
      Bitmap localBitmap3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        aune.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      aune.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        aune.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localaupa, paramBoolean, paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        aune.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
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
    //   26: ldc_w 681
    //   29: new 24	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 614
    //   43: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 5
    //   55: iload 5
    //   57: ireturn
    //   58: ldc 20
    //   60: ldc_w 681
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 616
    //   77: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 115	aune:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 45	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 225	java/io/File:exists	()Z
    //   105: ifeq +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 619	java/io/File:delete	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokestatic 684	bbdj:a	(Ljava/lang/String;)Ljava/io/File;
    //   118: pop
    //   119: new 686	java/io/FileOutputStream
    //   122: dup
    //   123: aload 6
    //   125: invokespecial 689	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: astore 8
    //   130: new 691	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload 8
    //   136: invokespecial 694	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload_1
    //   146: getstatic 700	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   149: iload_2
    //   150: aload 7
    //   152: invokevirtual 703	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   155: pop
    //   156: aload 7
    //   158: astore 6
    //   160: aload 7
    //   162: invokevirtual 706	java/io/BufferedOutputStream:flush	()V
    //   165: aload 7
    //   167: astore 6
    //   169: aload 8
    //   171: invokevirtual 710	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +22 -> 198
    //   179: aload 7
    //   181: astore 6
    //   183: aload_1
    //   184: invokevirtual 715	java/io/FileDescriptor:valid	()Z
    //   187: ifeq +11 -> 198
    //   190: aload 7
    //   192: astore 6
    //   194: aload_1
    //   195: invokevirtual 718	java/io/FileDescriptor:sync	()V
    //   198: aload 7
    //   200: ifnull +8 -> 208
    //   203: aload 7
    //   205: invokevirtual 721	java/io/BufferedOutputStream:close	()V
    //   208: aload_0
    //   209: invokestatic 18	bbdj:b	(Ljava/lang/String;)Z
    //   212: ifne -157 -> 55
    //   215: ldc 20
    //   217: ldc_w 681
    //   220: new 24	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   227: aload_3
    //   228: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 723
    //   234: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_1
    //   246: aload 4
    //   248: ifnull +13 -> 261
    //   251: aload 7
    //   253: astore 6
    //   255: aload 4
    //   257: iconst_1
    //   258: invokevirtual 726	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   261: aload 7
    //   263: astore 6
    //   265: ldc 20
    //   267: ldc_w 681
    //   270: ldc_w 728
    //   273: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   276: goto -78 -> 198
    //   279: astore_0
    //   280: aload 7
    //   282: astore 6
    //   284: ldc 20
    //   286: ldc_w 681
    //   289: new 24	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   296: aload_3
    //   297: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 658
    //   303: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 7
    //   314: astore 6
    //   316: aload_0
    //   317: invokevirtual 659	java/io/FileNotFoundException:printStackTrace	()V
    //   320: aload 7
    //   322: ifnull +8 -> 330
    //   325: aload 7
    //   327: invokevirtual 721	java/io/BufferedOutputStream:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: aload 4
    //   335: ifnull +13 -> 348
    //   338: aload 7
    //   340: astore 6
    //   342: aload 4
    //   344: iconst_1
    //   345: invokevirtual 726	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   348: aload 7
    //   350: astore 6
    //   352: ldc 20
    //   354: ldc_w 681
    //   357: ldc_w 730
    //   360: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -165 -> 198
    //   366: astore_0
    //   367: aload 7
    //   369: astore 6
    //   371: ldc 20
    //   373: ldc_w 681
    //   376: new 24	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   383: aload_3
    //   384: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 732
    //   390: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 43	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 7
    //   401: astore 6
    //   403: aload_0
    //   404: invokevirtual 733	java/lang/Exception:printStackTrace	()V
    //   407: aload 7
    //   409: ifnull +8 -> 417
    //   412: aload 7
    //   414: invokevirtual 721	java/io/BufferedOutputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 662	java/io/IOException:printStackTrace	()V
    //   424: goto -216 -> 208
    //   427: astore_0
    //   428: aload_0
    //   429: invokevirtual 662	java/io/IOException:printStackTrace	()V
    //   432: goto -102 -> 330
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 662	java/io/IOException:printStackTrace	()V
    //   440: goto -23 -> 417
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +8 -> 457
    //   452: aload 6
    //   454: invokevirtual 721	java/io/BufferedOutputStream:close	()V
    //   457: aload_0
    //   458: athrow
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 662	java/io/IOException:printStackTrace	()V
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
 * Qualified Name:     auoy
 * JD-Core Version:    0.7.0.1
 */