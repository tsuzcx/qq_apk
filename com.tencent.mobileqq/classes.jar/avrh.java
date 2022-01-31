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
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class avrh
{
  public static asfn a;
  public static avrj a;
  public static CharSequence a;
  public static final HashMap<String, Integer> a;
  public static CharSequence b;
  
  static
  {
    jdField_a_of_type_JavaLangCharSequence = "";
    b = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("zh", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("en", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put("ja", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put("jp", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put("ko", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put("kr", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put("fr", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilHashMap.put("es", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilHashMap.put("it", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilHashMap.put("de", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put("tr", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilHashMap.put("ru", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put("pt", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put("vi", Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashMap.put("id", Integer.valueOf(13));
    jdField_a_of_type_JavaUtilHashMap.put("ms", Integer.valueOf(14));
    jdField_a_of_type_JavaUtilHashMap.put("th", Integer.valueOf(15));
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
    if (!TextUtils.isEmpty(paramString)) {
      return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString.trim().toLowerCase())).intValue();
    }
    return 0;
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 138	android/graphics/Matrix
    //   9: dup
    //   10: invokespecial 139	android/graphics/Matrix:<init>	()V
    //   13: astore 10
    //   15: aload 10
    //   17: fload 6
    //   19: fload 7
    //   21: invokevirtual 143	android/graphics/Matrix:postScale	(FF)Z
    //   24: pop
    //   25: iload_1
    //   26: ifge +204 -> 230
    //   29: iconst_0
    //   30: istore 8
    //   32: iload_2
    //   33: ifge +191 -> 224
    //   36: iconst_0
    //   37: istore 9
    //   39: iload 8
    //   41: iload_3
    //   42: iadd
    //   43: aload_0
    //   44: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   47: if_icmple +172 -> 219
    //   50: aload_0
    //   51: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   54: istore_1
    //   55: iload_1
    //   56: iload 8
    //   58: isub
    //   59: istore_1
    //   60: iload 9
    //   62: iload 4
    //   64: iadd
    //   65: aload_0
    //   66: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   69: if_icmple +144 -> 213
    //   72: aload_0
    //   73: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   76: istore_2
    //   77: iload_2
    //   78: iload 9
    //   80: isub
    //   81: istore_2
    //   82: aload_0
    //   83: iload 8
    //   85: iload 9
    //   87: iload_1
    //   88: iload_2
    //   89: aload 10
    //   91: iconst_0
    //   92: invokestatic 155	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   95: astore_0
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: iload_3
    //   100: istore_1
    //   101: ldc 90
    //   103: iconst_2
    //   104: new 92	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   111: ldc 157
    //   113: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +68 -> 200
    //   135: ldc 90
    //   137: iconst_2
    //   138: new 92	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   145: ldc 165
    //   147: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 8
    //   152: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 167
    //   157: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 9
    //   162: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc 169
    //   167: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload_1
    //   171: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 171
    //   176: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 4
    //   181: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 173
    //   186: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 5
    //   191: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_0
    //   203: goto -102 -> 101
    //   206: astore_0
    //   207: iload_2
    //   208: istore 4
    //   210: goto -109 -> 101
    //   213: iload 4
    //   215: istore_2
    //   216: goto -134 -> 82
    //   219: iload_3
    //   220: istore_1
    //   221: goto -161 -> 60
    //   224: iload_2
    //   225: istore 9
    //   227: goto -188 -> 39
    //   230: iload_1
    //   231: istore 8
    //   233: goto -201 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramBitmap	Bitmap
    //   0	236	1	paramInt1	int
    //   0	236	2	paramInt2	int
    //   0	236	3	paramInt3	int
    //   0	236	4	paramInt4	int
    //   0	236	5	paramInt5	int
    //   0	236	6	paramFloat1	float
    //   0	236	7	paramFloat2	float
    //   30	202	8	i	int
    //   37	189	9	j	int
    //   13	77	10	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   39	55	98	java/lang/Exception
    //   60	77	202	java/lang/Exception
    //   82	96	206	java/lang/Exception
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
    Bitmap localBitmap = asfs.a(paramString, paramDisplayMetrics, 1, 4);
    paramDisplayMetrics = localBitmap;
    if (localBitmap != null)
    {
      i = bdda.b(paramString);
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
  
  public static CharSequence a(ArrayList<asfp> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 1;
    if (paramArrayList.hasNext())
    {
      asfp localasfp = (asfp)paramArrayList.next();
      if (localasfp.b == i) {
        localStringBuilder.append(localasfp.jdField_a_of_type_JavaLangString.trim());
      }
      for (;;)
      {
        break;
        localStringBuilder.append("\n\n").append(localasfp.jdField_a_of_type_JavaLangString.trim());
        i = localasfp.b;
      }
    }
    return new baig(localStringBuilder.toString(), 8, 16);
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
  
  public static String a(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public static List<String> a(String paramString)
  {
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Asfn != null) {
      jdField_a_of_type_Asfn = null;
    }
    if (jdField_a_of_type_Avrj != null) {
      jdField_a_of_type_Avrj = null;
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
    arum.a(paramActivity, paramString, 21);
  }
  
  public static void a(avuq paramavuq, int paramInt, Bitmap paramBitmap)
  {
    paramBitmap = new StackBlurManager(paramBitmap);
    paramBitmap.setDbg(false);
    paramavuq.a = paramBitmap.process(paramInt);
  }
  
  public static void a(CharSequence paramCharSequence)
  {
    jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    azmj.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static void a(String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if (jdField_a_of_type_Avrj == null) {
      jdField_a_of_type_Avrj = new avrj();
    }
    Object localObject = jdField_a_of_type_Avrj;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      ((avrj)localObject).jdField_a_of_type_JavaLangString = paramString;
      if ((paramList == null) || (paramList.isEmpty())) {
        break label160;
      }
      if (jdField_a_of_type_Avrj.jdField_a_of_type_JavaUtilList != null) {
        break label146;
      }
      jdField_a_of_type_Avrj.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localObject = a(paramList);
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          jdField_a_of_type_Avrj.jdField_a_of_type_JavaUtilList.add(paramList.toLowerCase());
        }
      }
      paramString = paramString.toLowerCase();
      break;
      label146:
      jdField_a_of_type_Avrj.jdField_a_of_type_JavaUtilList.clear();
    }
    label160:
    jdField_a_of_type_Avrj.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    jdField_a_of_type_Avrj.jdField_b_of_type_JavaLangString = jdField_a_of_type_Avrj.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_Avrj.jdField_c_of_type_JavaUtilList = a(jdField_a_of_type_Avrj.jdField_b_of_type_JavaLangString);
    jdField_a_of_type_Avrj.jdField_c_of_type_JavaLangString = ((String)jdField_a_of_type_Avrj.jdField_c_of_type_JavaUtilList.get(0));
    jdField_a_of_type_Avrj.jdField_b_of_type_JavaUtilList = a(jdField_a_of_type_Avrj.jdField_c_of_type_JavaLangString);
    paramString = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramList = paramString[i];
      if (!jdField_a_of_type_Avrj.a(jdField_a_of_type_Avrj.jdField_b_of_type_JavaUtilList, paramList)) {
        jdField_a_of_type_Avrj.jdField_b_of_type_JavaUtilList.add(paramList);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformUtil", 2, "recordOcrLanInfo:ocrLanHolder:" + jdField_a_of_type_Avrj.a());
    }
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
    azmj.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  public static void b(CharSequence paramCharSequence)
  {
    b = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrh
 * JD-Core Version:    0.7.0.1
 */