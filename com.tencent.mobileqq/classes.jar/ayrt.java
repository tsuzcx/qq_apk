import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ayrt
{
  public static avat a;
  public static avaw a;
  public static ayru a;
  public static TranslateResult a;
  public static CharSequence a;
  static final HashMap<String, Integer> a;
  public static boolean a;
  public static ayru b;
  public static CharSequence b;
  
  static
  {
    jdField_a_of_type_JavaLangCharSequence = "";
    jdField_b_of_type_JavaLangCharSequence = "";
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
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("OCRPerformUtil", 2, "calculateInSampleSize:" + i);
    }
    return i;
  }
  
  public static int a(Point paramPoint1, Point paramPoint2)
  {
    int i = Math.abs(paramPoint2.x - paramPoint1.x);
    int j = Math.abs(paramPoint2.y - paramPoint1.y);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString.trim().toLowerCase())).intValue();
    }
    return 0;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("OCRPerformUtil", 0, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
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
    Bitmap localBitmap = avax.a(paramString, paramDisplayMetrics, 1, 4);
    paramDisplayMetrics = localBitmap;
    if (localBitmap != null)
    {
      i = bheg.b(paramString);
      paramDisplayMetrics = localBitmap;
      if (i != 0)
      {
        paramDisplayMetrics = localBitmap;
        if (i % 90 == 0)
        {
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("OCRPerformUtil", 2, "decodeBitmapForOcr rotate:" + i);
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
  
  public static ayru a(ayru paramayru, String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    ayru localayru = paramayru;
    if (paramayru == null) {
      localayru = new ayru();
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramayru = "";
      localayru.jdField_a_of_type_JavaLangString = paramayru;
      if ((paramList == null) || (paramList.isEmpty())) {
        break label149;
      }
      if (localayru.jdField_a_of_type_JavaUtilList != null) {
        break label136;
      }
      localayru.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      paramayru = paramList.iterator();
      while (paramayru.hasNext())
      {
        paramString = (String)paramayru.next();
        paramList = a(paramString);
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramList))) {
          localayru.jdField_a_of_type_JavaUtilList.add(paramString.toLowerCase());
        }
      }
      paramayru = paramString.toLowerCase();
      break;
      label136:
      localayru.jdField_a_of_type_JavaUtilList.clear();
    }
    label149:
    localayru.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    localayru.jdField_b_of_type_JavaLangString = localayru.jdField_a_of_type_JavaLangString;
    localayru.jdField_c_of_type_JavaUtilList = a(localayru.jdField_b_of_type_JavaLangString);
    localayru.jdField_c_of_type_JavaLangString = ((String)localayru.jdField_c_of_type_JavaUtilList.get(0));
    localayru.jdField_b_of_type_JavaUtilList = a(localayru.jdField_c_of_type_JavaLangString);
    paramayru = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/");
    int j = paramayru.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramayru[i];
      if (!localayru.a(localayru.jdField_b_of_type_JavaUtilList, paramString)) {
        localayru.jdField_b_of_type_JavaUtilList.add(paramString);
      }
      i += 1;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("OCRPerformUtil", 2, "recordOcrLanInfo:ocrLanHolder:" + localayru.a());
    }
    return localayru;
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
  
  public static CharSequence a(ArrayList<avav> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 1;
    if (paramArrayList.hasNext())
    {
      avav localavav = (avav)paramArrayList.next();
      if (localavav.b == i) {
        localStringBuilder.append(localavav.jdField_a_of_type_JavaLangString.trim());
      }
      for (;;)
      {
        break;
        localStringBuilder.append("\n\n").append(localavav.jdField_a_of_type_JavaLangString.trim());
        i = localavav.b;
      }
    }
    return new QQText(localStringBuilder.toString(), 8, 16);
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
    } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
    com.tencent.qphone.base.util.QLog.d("OCRPerformUtil", 2, "collectSelectedText " + str1);
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
    if (jdField_a_of_type_Avat != null) {
      jdField_a_of_type_Avat = null;
    }
    if (jdField_a_of_type_Ayru != null) {
      jdField_a_of_type_Ayru = null;
    }
    if (jdField_b_of_type_Ayru != null) {
      jdField_b_of_type_Ayru = null;
    }
    if (jdField_a_of_type_Avaw != null) {
      jdField_a_of_type_Avaw = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) {
      jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = null;
    }
    if (jdField_a_of_type_JavaLangCharSequence != null) {
      jdField_a_of_type_JavaLangCharSequence = null;
    }
    if (jdField_b_of_type_JavaLangCharSequence != null) {
      jdField_b_of_type_JavaLangCharSequence = null;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_succ_flag", paramInt + "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_succ_flag", paramInt + "");
    localHashMap.put("param_md5", paramString1);
    localHashMap.put("param_text", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString3, true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(Activity paramActivity, OcrImageTextView paramOcrImageTextView)
  {
    if ((paramActivity == null) || (paramOcrImageTextView == null)) {
      return;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramOcrImageTextView.getWidth(), paramOcrImageTextView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      paramOcrImageTextView.layout(paramOcrImageTextView.getLeft(), paramOcrImageTextView.getTop(), paramOcrImageTextView.getRight(), paramOcrImageTextView.getBottom());
      Drawable localDrawable = paramOcrImageTextView.getBackground();
      if (localDrawable != null) {
        localDrawable.draw(localCanvas);
      }
      paramOcrImageTextView.draw(localCanvas);
      paramOcrImageTextView = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
      paramOcrImageTextView = paramOcrImageTextView + "/" + SystemClock.uptimeMillis() + ".jpg";
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("OCRPerformUtil", 2, "forwardDrawable:" + paramOcrImageTextView);
      }
      FileUtil.writeBitmapToFile(localBitmap, paramOcrImageTextView);
      localBitmap.recycle();
      bbxq.a(paramActivity, paramOcrImageTextView);
      return;
    }
    catch (IOException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.e("OCRPerformUtil", 2, "forwardContent error, content is empty");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras(localBundle);
    aupt.a(paramActivity, paramString, 21);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    bdla.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.e("OCRPerformUtil", 2, "enterCropActivity error, picture path is empty");
      }
      return;
    }
    Intent localIntent = EditPicActivity.a(paramActivity, paramString, false, false, false, true, false, 2, 99, 9);
    localIntent.putExtra("babyq_ability", 2L);
    localIntent.putExtra("sub_business_id", 103);
    paramActivity.startActivity(localIntent);
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("OCRPerformUtil", 2, String.format("enterCropActivity, path: %s", new Object[] { paramString }));
    }
    bdla.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrt
 * JD-Core Version:    0.7.0.1
 */