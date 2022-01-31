import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class auab
{
  public static aqmx a;
  public static auad a;
  public static CharSequence a;
  static final HashMap<String, Integer> a;
  public static CharSequence b;
  
  static
  {
    jdField_a_of_type_JavaLangCharSequence = "";
    b = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("en", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("ja", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put("jp", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put("ko", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put("kr", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put("fr", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put("es", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilHashMap.put("it", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilHashMap.put("de", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilHashMap.put("tr", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put("ru", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilHashMap.put("pt", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put("vi", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put("id", Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashMap.put("ms", Integer.valueOf(13));
    jdField_a_of_type_JavaUtilHashMap.put("th", Integer.valueOf(14));
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    paramInt2 = paramOptions.outWidth;
    int i = 1;
    if (paramInt2 > paramInt1 * 1.2F)
    {
      i = j / 2;
      j = paramInt2 / 2;
      paramInt2 = 2;
      for (;;)
      {
        i = paramInt2;
        if (j / paramInt2 <= paramInt1) {
          break;
        }
        paramInt2 *= 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("OCRPerformUtil", 2, "calculateInSampleSize:" + i);
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString.trim().toLowerCase())).intValue();
    }
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    int j = 0;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1, paramFloat2);
    if (paramInt1 < 0) {}
    for (int i = 0;; i = paramInt1)
    {
      if (paramInt2 < 0) {}
      for (;;)
      {
        try
        {
          if (i + paramInt3 > paramBitmap.getWidth())
          {
            paramInt1 = paramBitmap.getWidth();
            paramInt1 -= i;
          }
          paramInt1 = paramInt3;
        }
        catch (Exception paramBitmap)
        {
          for (;;)
          {
            try
            {
              if (j + paramInt4 <= paramBitmap.getHeight()) {
                continue;
              }
              paramInt2 = paramBitmap.getHeight();
              paramInt2 -= j;
            }
            catch (Exception paramBitmap)
            {
              continue;
              paramInt2 = paramInt4;
              continue;
            }
            try
            {
              paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2, localMatrix, false);
              return paramBitmap;
            }
            catch (Exception paramBitmap)
            {
              paramInt4 = paramInt2;
            }
          }
          paramBitmap = paramBitmap;
          paramInt1 = paramInt3;
          QLog.e("OCRPerformUtil", 2, "cropBitmap error=" + paramBitmap.getMessage());
          if (QLog.isColorLevel()) {
            QLog.d("OCRPerformUtil", 2, "cropBitmap x=" + i + "y=" + j + " width=" + paramInt1 + " height=" + paramInt4 + " arc=" + paramInt5);
          }
          return null;
        }
        continue;
        j = paramInt2;
      }
    }
  }
  
  public static Bitmap a(String paramString, DisplayMetrics paramDisplayMetrics)
  {
    int i = paramDisplayMetrics.widthPixels;
    int j = paramDisplayMetrics.heightPixels;
    paramDisplayMetrics = new BitmapFactory.Options();
    paramDisplayMetrics.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramDisplayMetrics);
    i = a(paramDisplayMetrics, i, j);
    paramDisplayMetrics.inJustDecodeBounds = false;
    paramDisplayMetrics.inSampleSize = i;
    Bitmap localBitmap = aqnc.a(paramString, paramDisplayMetrics, 1, 4);
    paramDisplayMetrics = localBitmap;
    if (localBitmap != null)
    {
      i = bbdr.b(paramString);
      paramDisplayMetrics = localBitmap;
      if (i != 0)
      {
        paramDisplayMetrics = localBitmap;
        if (i % 90 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OCRPerformUtil", 2, "decodeBitmapForOcr rotate:" + i);
          }
          j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramDisplayMetrics = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
    }
    return paramDisplayMetrics;
  }
  
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static CharSequence a()
  {
    return jdField_a_of_type_JavaLangCharSequence;
  }
  
  public static CharSequence a(ArrayList<aqmz> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 1;
    if (paramArrayList.hasNext())
    {
      aqmz localaqmz = (aqmz)paramArrayList.next();
      if (localaqmz.b == i) {
        localStringBuilder.append(localaqmz.jdField_a_of_type_JavaLangString.trim());
      }
      for (;;)
      {
        break;
        localStringBuilder.append("\n\n").append(localaqmz.jdField_a_of_type_JavaLangString.trim());
        i = localaqmz.b;
      }
    }
    return new ayki(localStringBuilder.toString(), 8, 16);
  }
  
  public static String a(TextView paramTextView)
  {
    String str1 = null;
    if (paramTextView == null) {
      paramTextView = str1;
    }
    do
    {
      int i;
      int j;
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramTextView;
              i = paramTextView.getSelectionStart();
              j = paramTextView.getSelectionEnd();
              str2 = paramTextView.getText().toString();
              paramTextView = str1;
            } while (TextUtils.isEmpty(str2));
            paramTextView = str1;
          } while (i >= j);
          paramTextView = str1;
        } while (i < 0);
        paramTextView = str1;
      } while (j > str2.length());
      str1 = str2.substring(i, j);
      paramTextView = str1;
    } while (!QLog.isColorLevel());
    QLog.d("OCRPerformUtil", 2, "collectSelectedText " + str1);
    return str1;
  }
  
  public static String a(OcrConfig paramOcrConfig, String paramString)
  {
    if (paramOcrConfig != null) {
      return paramOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public static List<String> a(OcrConfig paramOcrConfig, String paramString)
  {
    if (paramOcrConfig != null) {
      return paramOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Aqmx != null) {
      jdField_a_of_type_Aqmx = null;
    }
    if (jdField_a_of_type_Auad != null) {
      jdField_a_of_type_Auad = null;
    }
    if (jdField_a_of_type_JavaLangCharSequence != null) {
      jdField_a_of_type_JavaLangCharSequence = null;
    }
    if (b != null) {
      b = null;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRPerformUtil", 2, "forwardContent error, content is empty");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras(localBundle);
    aqbc.a(paramActivity, paramString, 21);
  }
  
  public static void a(audk paramaudk, int paramInt, Bitmap paramBitmap)
  {
    paramBitmap = new StackBlurManager(paramBitmap);
    paramBitmap.setDbg(false);
    paramaudk.a = paramBitmap.process(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if (jdField_a_of_type_Auad == null)
    {
      paramQQAppInterface = (atzt)paramQQAppInterface.getManager(228);
      jdField_a_of_type_Auad = new auad();
      auad.a(jdField_a_of_type_Auad, paramQQAppInterface.a(false));
    }
    auad localauad = jdField_a_of_type_Auad;
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = "";
      localauad.jdField_a_of_type_JavaLangString = paramQQAppInterface;
      if ((paramList == null) || (paramList.isEmpty())) {
        break label187;
      }
      if (jdField_a_of_type_Auad.jdField_a_of_type_JavaUtilList != null) {
        break label173;
      }
      jdField_a_of_type_Auad.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      paramQQAppInterface = paramList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (String)paramQQAppInterface.next();
        paramList = a(auad.a(jdField_a_of_type_Auad), paramString);
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramList))) {
          jdField_a_of_type_Auad.jdField_a_of_type_JavaUtilList.add(paramString.toLowerCase());
        }
      }
      paramQQAppInterface = paramString.toLowerCase();
      break;
      label173:
      jdField_a_of_type_Auad.jdField_a_of_type_JavaUtilList.clear();
    }
    label187:
    jdField_a_of_type_Auad.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    jdField_a_of_type_Auad.jdField_b_of_type_JavaLangString = jdField_a_of_type_Auad.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_Auad.jdField_c_of_type_JavaUtilList = a(auad.a(jdField_a_of_type_Auad), jdField_a_of_type_Auad.jdField_b_of_type_JavaLangString);
    jdField_a_of_type_Auad.jdField_c_of_type_JavaLangString = ((String)jdField_a_of_type_Auad.jdField_c_of_type_JavaUtilList.get(0));
    jdField_a_of_type_Auad.jdField_b_of_type_JavaUtilList = a(auad.a(jdField_a_of_type_Auad), jdField_a_of_type_Auad.jdField_c_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformUtil", 2, "recordOcrLanInfo:ocrLanHolder:" + jdField_a_of_type_Auad.a());
    }
  }
  
  public static void a(CharSequence paramCharSequence)
  {
    jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public static void a(String paramString, int paramInt)
  {
    axqw.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l4 = 0L;
    int j = paramBitmap.getHeight() / 20;
    int i = j;
    if (j <= 0) {
      i = 5;
    }
    int k = paramBitmap.getWidth() / 20;
    j = k;
    if (k <= 0) {
      j = 5;
    }
    k = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      while (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        l4 += 1L;
        l3 += Color.red(n);
        l2 += Color.green(n);
        l1 += Color.blue(n);
        m += j;
      }
      k += i;
    }
    float f1 = (float)(l3 / l4);
    float f2 = (float)(l2 / l4);
    float f3 = (float)(l1 / l4);
    double d = f1;
    return f2 * 0.578D + d * 0.299D + f3 * 0.114D < 90.0D;
  }
  
  public static CharSequence b()
  {
    return b;
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRPerformUtil", 2, "enterCropActivity error, picture path is empty");
      }
      return;
    }
    Intent localIntent = EditPicActivity.a(paramActivity, paramString, false, false, false, true, false, 2, 99, 9);
    localIntent.putExtra("babyq_ability", 2L);
    localIntent.putExtra("sub_business_id", 103);
    paramActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformUtil", 2, String.format("enterCropActivity, path: %s", new Object[] { paramString }));
    }
    axqw.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  public static void b(CharSequence paramCharSequence)
  {
    b = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auab
 * JD-Core Version:    0.7.0.1
 */