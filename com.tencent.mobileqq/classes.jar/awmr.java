import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.JsonReader;
import android.util.Pair;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileQVipDiyView;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class awmr
{
  public static long a;
  public static Typeface a;
  public static final HashMap<String, String> a;
  public static JSONObject a;
  public static long b;
  public static Typeface b;
  public static JSONObject b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  public static long m;
  public static long n;
  public int a;
  public String a;
  public ConcurrentHashMap<String, Object> a;
  public boolean a;
  public int b;
  public String b;
  private HashMap<String, Integer> b;
  public int c;
  public String c;
  private HashMap<String, Shader.TileMode> c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public String m;
  public String n;
  public long o;
  public String o;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  
  static
  {
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Long = 4L;
    jdField_d_of_type_Long = 5L;
    jdField_e_of_type_Long = 6L;
    jdField_f_of_type_Long = 7L;
    jdField_g_of_type_Long = 8L;
    jdField_h_of_type_Long = 9L;
    jdField_i_of_type_Long = 10L;
    jdField_j_of_type_Long = 11L;
    jdField_k_of_type_Long = 21L;
    jdField_l_of_type_Long = 22L;
    jdField_m_of_type_Long = 23L;
    jdField_n_of_type_Long = 10000L;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public awmr()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap.put("top", Integer.valueOf(48));
    this.jdField_b_of_type_JavaUtilHashMap.put("bottom", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("left", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("right", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center_horizontal", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill_horizontal", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("clip_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("clip_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clamp", Shader.TileMode.CLAMP);
    this.jdField_c_of_type_JavaUtilHashMap.put("repeat", Shader.TileMode.REPEAT);
    this.jdField_c_of_type_JavaUtilHashMap.put("mirror", Shader.TileMode.MIRROR);
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_b_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_c_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_d_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_e_of_type_Long), "photo");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_g_of_type_Long), "simple");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_h_of_type_Long), "shopping");
  }
  
  public static long a(@Nullable Card paramCard)
  {
    long l2 = 0L;
    if (paramCard == null) {}
    while ((!a(paramCard.lCurrentStyleId)) || (TextUtils.isEmpty(paramCard.diyComplicatedInfo))) {
      return 0L;
    }
    paramCard = new JsonReader(new StringReader(paramCard.diyComplicatedInfo));
    try
    {
      paramCard.beginObject();
      for (;;)
      {
        long l1 = l2;
        if (paramCard.hasNext())
        {
          if ("v".equals(paramCard.nextName())) {
            l1 = paramCard.nextLong();
          }
        }
        else {
          try
          {
            paramCard.close();
            return l1;
          }
          catch (IOException paramCard)
          {
            paramCard.printStackTrace();
            return l1;
          }
        }
        paramCard.skipValue();
      }
      try
      {
        paramCard.close();
        throw localObject;
      }
      catch (IOException paramCard)
      {
        for (;;)
        {
          paramCard.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramCard.close();
        return 0L;
      }
      catch (IOException paramCard)
      {
        paramCard.printStackTrace();
        return 0L;
      }
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public static void a(View paramView, String paramString1, awmr paramawmr, String paramString2)
  {
    if ((paramView == null) || (paramawmr == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (a(paramawmr.jdField_o_of_type_Long))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      return;
                                      paramawmr = paramawmr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
                                    } while (paramawmr == null);
                                    if ((!paramString1.equalsIgnoreCase("color")) || (!(paramView instanceof TextView))) {
                                      break;
                                    }
                                    paramView = (TextView)paramView;
                                    if ((paramawmr instanceof ColorStateList))
                                    {
                                      paramView.setTextColor((ColorStateList)paramawmr);
                                      return;
                                    }
                                  } while (!(paramawmr instanceof String));
                                  paramString1 = (String)paramawmr;
                                } while (!paramString1.startsWith("#"));
                                paramView.setTextColor(Color.parseColor(paramString1));
                                return;
                                if ((!paramString1.equalsIgnoreCase("color")) || (!(paramView instanceof SingleLineTextView))) {
                                  break;
                                }
                                paramView = (SingleLineTextView)paramView;
                                if ((paramawmr instanceof ColorStateList))
                                {
                                  paramView.setTextColor((ColorStateList)paramawmr);
                                  return;
                                }
                              } while (!(paramawmr instanceof String));
                              paramString1 = (String)paramawmr;
                            } while (!paramString1.startsWith("#"));
                            paramView.setTextColor(Color.parseColor(paramString1));
                            return;
                            if (!paramString1.equalsIgnoreCase("background")) {
                              break;
                            }
                            if ((paramawmr instanceof Drawable))
                            {
                              paramString1 = ((Drawable)paramawmr).getConstantState().newDrawable();
                              paramawmr = new Rect();
                              paramString1.getPadding(paramawmr);
                              int i1 = paramView.getPaddingTop();
                              int i2 = paramawmr.top;
                              int i3 = paramView.getPaddingLeft();
                              int i4 = paramawmr.left;
                              int i5 = paramView.getPaddingRight();
                              int i6 = paramawmr.right;
                              int i7 = paramView.getPaddingBottom();
                              int i8 = paramawmr.bottom;
                              paramawmr = paramView.findViewById(2131373522);
                              if (Build.VERSION.SDK_INT >= 16)
                              {
                                paramView.setBackground(paramString1);
                                if (paramawmr != null) {
                                  paramawmr.setBackground(paramString1);
                                }
                              }
                              for (;;)
                              {
                                paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
                                return;
                                paramView.setBackgroundDrawable(paramString1);
                                if (paramawmr != null) {
                                  paramawmr.setBackgroundDrawable(paramString1);
                                }
                              }
                            }
                          } while (!(paramawmr instanceof String));
                          paramString1 = (String)paramawmr;
                        } while (!paramString1.startsWith("#"));
                        paramView.setBackgroundColor(Color.parseColor(paramString1));
                        return;
                        if ((!paramString1.equalsIgnoreCase("drawableleft")) || (!(paramView instanceof TextView))) {
                          break;
                        }
                      } while (!(paramawmr instanceof Drawable));
                      paramView = (TextView)paramView;
                    } while (!(paramawmr instanceof Drawable));
                    paramView.setCompoundDrawablesWithIntrinsicBounds(((Drawable)paramawmr).getConstantState().newDrawable(), null, null, null);
                    return;
                    if ((!paramString1.equalsIgnoreCase("drawableright")) || (!(paramView instanceof TextView))) {
                      break;
                    }
                  } while (!(paramawmr instanceof Drawable));
                  paramView = (TextView)paramView;
                } while (!(paramawmr instanceof Drawable));
                paramView.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable)paramawmr).getConstantState().newDrawable(), null);
                return;
                if ((!paramString1.equalsIgnoreCase("src")) || (!(paramView instanceof ImageView))) {
                  break;
                }
              } while (!(paramawmr instanceof Drawable));
              paramView = (ImageView)paramView;
            } while (!(paramawmr instanceof Drawable));
            paramView.setImageDrawable(((Drawable)paramawmr).getConstantState().newDrawable());
            return;
            if ((!paramString1.equalsIgnoreCase("contentBackground")) || (!(paramView instanceof ListView))) {
              break;
            }
          } while (!(paramawmr instanceof Drawable));
          paramView = (ListView)paramView;
        } while (!(paramawmr instanceof Drawable));
        paramView.setContentBackground(((Drawable)paramawmr).getConstantState().newDrawable());
        return;
        if ((!paramString1.equalsIgnoreCase("apngDrawable")) || (!(paramView instanceof ImageView))) {
          break;
        }
      } while (!(paramawmr instanceof URLDrawable));
      ((ImageView)paramView).setImageDrawable((URLDrawable)paramawmr);
      return;
    } while ((!paramString1.equalsIgnoreCase("shimmer_mask")) || (!(paramView instanceof ShimmerLinearLayout)) || (!(paramawmr instanceof BitmapDrawable)));
    paramString1 = (BitmapDrawable)paramawmr;
    paramawmr = (ShimmerLinearLayout)paramView;
    ((ShimmerLinearLayout)paramView).setMask(paramString1.getBitmap(), 1, 2000, 1000);
  }
  
  public static void a(ProfileQVipDiyView paramProfileQVipDiyView, String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    paramProfileQVipDiyView.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == jdField_l_of_type_Long) || (paramLong == jdField_m_of_type_Long);
  }
  
  public static boolean a(Card paramCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCard != null) {
      if (paramCard.lCurrentStyleId != jdField_i_of_type_Long)
      {
        bool1 = bool2;
        if (paramCard.lCurrentStyleId != jdField_j_of_type_Long) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ColorStateList a(JSONArray paramJSONArray)
  {
    int i4;
    int i3;
    Object localObject1;
    Object localObject2;
    int i5;
    Object localObject3;
    int i1;
    int i2;
    int i6;
    if (paramJSONArray != null)
    {
      i4 = 20;
      i3 = 0;
      localObject1 = new int[20];
      localObject2 = new int[20][];
      int i7 = paramJSONArray.length();
      i5 = 0;
      if (i5 < i7)
      {
        localObject3 = paramJSONArray.optJSONObject(i5);
        if ((localObject3 == null) || (!((JSONObject)localObject3).has("color"))) {
          break label702;
        }
        Object localObject4 = ((JSONObject)localObject3).optString("color");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label702;
        }
        Object localObject5 = ((JSONObject)localObject3).keys();
        int[] arrayOfInt = new int[((JSONObject)localObject3).length()];
        i1 = -65536;
        i2 = 0;
        if (((Iterator)localObject5).hasNext())
        {
          String str = (String)((Iterator)localObject5).next();
          if (str.equalsIgnoreCase("state_pressed")) {
            if (((JSONObject)localObject3).optBoolean("state_pressed"))
            {
              i6 = 16842919;
              label158:
              arrayOfInt[i2] = i6;
              i6 = i2 + 1;
              i2 = i1;
              i1 = i6;
            }
          }
          for (;;)
          {
            label174:
            i6 = i2;
            i2 = i1;
            i1 = i6;
            break;
            i6 = -16842919;
            break label158;
            if (str.equalsIgnoreCase("state_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_focused")) {}
              for (i6 = 16842908;; i6 = -16842908)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_selected"))
            {
              if (((JSONObject)localObject3).optBoolean("state_selected")) {}
              for (i6 = 16842913;; i6 = -16842913)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checkable"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checkable")) {}
              for (i6 = 16842911;; i6 = -16842911)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checked"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checked")) {}
              for (i6 = 16842912;; i6 = -16842912)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_enabled"))
            {
              if (((JSONObject)localObject3).optBoolean("state_enabled")) {}
              for (i6 = 16842910;; i6 = -16842910)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_window_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_window_focused")) {}
              for (i6 = 16842909;; i6 = -16842909)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (!str.equalsIgnoreCase("color")) {
              break label691;
            }
            i6 = Color.parseColor((String)localObject4);
            i1 = i2;
            i2 = i6;
          }
        }
        localObject5 = StateSet.trimStateSet(arrayOfInt, i2);
        if (i3 + 1 < i4) {
          break label685;
        }
        i2 = i3 + 1;
        localObject3 = new int[i2];
        System.arraycopy(localObject1, 0, localObject3, 0, i3);
        localObject4 = new int[i2][];
        System.arraycopy(localObject2, 0, localObject4, 0, i3);
        localObject1 = localObject3;
        localObject2 = localObject4;
        label606:
        localObject1[i3] = i1;
        localObject2[i3] = localObject5;
        i1 = i3 + 1;
        i4 = i2;
      }
    }
    for (;;)
    {
      i5 += 1;
      i3 = i1;
      break;
      paramJSONArray = new int[i3];
      localObject3 = new int[i3][];
      System.arraycopy(localObject1, 0, paramJSONArray, 0, i3);
      System.arraycopy(localObject2, 0, localObject3, 0, i3);
      return new ColorStateList((int[][])localObject3, paramJSONArray);
      return null;
      label685:
      i2 = i4;
      break label606;
      label691:
      i6 = i1;
      i1 = i2;
      i2 = i6;
      break label174;
      label702:
      i1 = i3;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable fileName=" + paramString);
    }
    String str = null;
    Object localObject2 = null;
    label718:
    label724:
    label729:
    label732:
    label735:
    for (;;)
    {
      try
      {
        localResources = paramQQAppInterface.getApp().getResources();
        localObject1 = str;
        if (paramString == null) {
          break label732;
        }
        localObject1 = str;
        if (paramString.length() <= 0) {
          break label732;
        }
        Object localObject3 = bcyw.a(paramQQAppInterface, -1L);
        localObject1 = str;
        if (localObject3 == null) {
          break label732;
        }
        localObject1 = str;
        if (((String)localObject3).length() <= 0) {
          break label732;
        }
        localObject1 = (String)localObject3 + File.separator + paramString;
        if (!paramBoolean2) {
          break label729;
        }
        localObject1 = paramString;
        str = "profilecard:" + (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable filePath=" + (String)localObject1);
        }
        if (paramBoolean1)
        {
          localObject3 = (Pair)BaseApplicationImpl.sImageCache.get(str);
          if ((localObject3 != null) && (((Pair)localObject3).first != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable form sImageCache filePath=" + (String)localObject1);
            }
            return ((Drawable.ConstantState)((Pair)localObject3).first).newDrawable();
          }
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inDensity = 320;
        ((BitmapFactory.Options)localObject3).inScreenDensity = paramQQAppInterface.getApp().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inTargetDensity = paramQQAppInterface.getApp().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inScaled = true;
        if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramQQAppInterface = new BufferedInputStream(new FileInputStream((String)localObject1));
        localObject1 = BitmapFactory.decodeStream(paramQQAppInterface, null, (BitmapFactory.Options)localObject3);
        paramQQAppInterface.close();
        if (localObject1 == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap density=" + ((Bitmap)localObject1).getDensity() + ",width=" + ((Bitmap)localObject1).getWidth() + ",height=" + ((Bitmap)localObject1).getHeight());
        }
        i1 = Utils.getBitmapSize((Bitmap)localObject1);
        if (!paramString.endsWith(".9.png")) {
          continue;
        }
        paramQQAppInterface = ((Bitmap)localObject1).getNinePatchChunk();
        if (paramQQAppInterface == null) {
          break label724;
        }
        paramQQAppInterface = new NinePatchDrawable(localResources, (Bitmap)localObject1, paramQQAppInterface, new Rect(0, 0, 0, 0), null);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        return null;
        if ((!paramString.endsWith(".png")) && (!paramString.endsWith(".jpg")) && (!paramString.endsWith(".jpeg"))) {
          continue;
        }
        paramQQAppInterface = new BitmapDrawable(localResources, (Bitmap)localObject1);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
        continue;
        if (!QLog.isColorLevel()) {
          break label718;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable file not ");
        paramQQAppInterface = localObject2;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap is null");
        int i1 = 0;
        paramQQAppInterface = localObject2;
        continue;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable exception fileName=" + paramString + ",msg=" + paramQQAppInterface.getMessage());
        return null;
      }
      Object localObject1 = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface;
        if (paramBoolean1)
        {
          BaseApplicationImpl.sImageCache.put(str, new Pair(paramQQAppInterface.getConstantState(), Integer.valueOf(i1)));
          return paramQQAppInterface;
          paramQQAppInterface = localObject2;
          continue;
          paramQQAppInterface = null;
          break label735;
          continue;
        }
      }
      return localObject1;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("src")))
    {
      Object localObject = paramJSONObject.optString("src");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = (BitmapDrawable)a(paramQQAppInterface, (String)localObject, true, false);
        Iterator localIterator = paramJSONObject.keys();
        if (localObject != null) {
          for (;;)
          {
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramQQAppInterface = (String)localIterator.next();
            if (paramQQAppInterface.equalsIgnoreCase("antialias"))
            {
              ((BitmapDrawable)localObject).setAntiAlias(paramJSONObject.optBoolean("antialias"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("dither"))
            {
              ((BitmapDrawable)localObject).setDither(paramJSONObject.optBoolean("dither"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("filter"))
            {
              ((BitmapDrawable)localObject).setFilterBitmap(paramJSONObject.optBoolean("filter"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("gravity"))
            {
              paramQQAppInterface = paramJSONObject.optString("gravity").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface))) {
                ((BitmapDrawable)localObject).setGravity(((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramQQAppInterface)).intValue());
              }
            }
            else if (paramQQAppInterface.equalsIgnoreCase("tileMode"))
            {
              paramQQAppInterface = paramJSONObject.optString("tileMode", "disabled").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface)))
              {
                paramQQAppInterface = (Shader.TileMode)this.jdField_c_of_type_JavaUtilHashMap.get(paramQQAppInterface);
                ((BitmapDrawable)localObject).setTileModeXY(paramQQAppInterface, paramQQAppInterface);
              }
              else
              {
                ((BitmapDrawable)localObject).setTileModeXY(null, null);
              }
            }
          }
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  public StateListDrawable a(QQAppInterface paramQQAppInterface, JSONArray paramJSONArray)
  {
    StateListDrawable localStateListDrawable;
    int i2;
    Object localObject;
    String str1;
    int[] arrayOfInt;
    int i1;
    Drawable localDrawable;
    label97:
    String str2;
    int i3;
    if (paramJSONArray != null)
    {
      localStateListDrawable = new StateListDrawable();
      int i4 = paramJSONArray.length();
      i2 = 0;
      if (i2 < i4)
      {
        localObject = paramJSONArray.optJSONObject(i2);
        if ((localObject != null) && (((JSONObject)localObject).has("drawable")))
        {
          str1 = ((JSONObject)localObject).optString("drawable");
          if ((str1 != null) && (str1.length() > 0))
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            arrayOfInt = new int[((JSONObject)localObject).length()];
            i1 = 0;
            localDrawable = null;
            if (localIterator.hasNext())
            {
              str2 = (String)localIterator.next();
              i3 = Build.VERSION.SDK_INT;
              if (str2.equalsIgnoreCase("state_pressed")) {
                if (((JSONObject)localObject).optBoolean("state_pressed"))
                {
                  i3 = 16842919;
                  label151:
                  arrayOfInt[i1] = i3;
                  i1 += 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break label97;
      i3 = -16842919;
      break label151;
      if (str2.equalsIgnoreCase("state_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_focused")) {}
        for (i3 = 16842908;; i3 = -16842908)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_hovered")) && (i3 >= 14))
      {
        if (((JSONObject)localObject).optBoolean("state_hovered")) {}
        for (i3 = 16843623;; i3 = -16843623)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_selected"))
      {
        if (((JSONObject)localObject).optBoolean("state_selected")) {}
        for (i3 = 16842913;; i3 = -16842913)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checkable"))
      {
        if (((JSONObject)localObject).optBoolean("state_checkable")) {}
        for (i3 = 16842911;; i3 = -16842911)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checked"))
      {
        if (((JSONObject)localObject).optBoolean("state_checked")) {}
        for (i3 = 16842912;; i3 = -16842912)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_enabled"))
      {
        if (((JSONObject)localObject).optBoolean("state_enabled")) {}
        for (i3 = 16842910;; i3 = -16842910)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_activated")) && (i3 >= 11))
      {
        if (((JSONObject)localObject).optBoolean("state_activated")) {}
        for (i3 = 16843518;; i3 = -16843518)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_window_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_window_focused")) {}
        for (i3 = 16842909;; i3 = -16842909)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("drawable"))
      {
        localDrawable = a(paramQQAppInterface, str1, true, false);
        continue;
        localObject = StateSet.trimStateSet(arrayOfInt, i1);
        if (localDrawable != null) {
          localStateListDrawable.addState((int[])localObject, localDrawable);
        }
        i2 += 1;
        break;
        return localStateListDrawable;
        return null;
      }
    }
  }
  
  /* Error */
  public JSONObject a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    // Byte code:
    //   0: lload_2
    //   1: lconst_1
    //   2: lcmp
    //   3: ifne +60 -> 63
    //   6: ldc_w 782
    //   9: astore 5
    //   11: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +31 -> 45
    //   17: ldc_w 531
    //   20: iconst_2
    //   21: new 533	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 784
    //   31: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 5
    //   36: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 546	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lload_2
    //   46: lconst_1
    //   47: lcmp
    //   48: ifne +23 -> 71
    //   51: getstatic 786	awmr:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   54: ifnull +17 -> 71
    //   57: getstatic 786	awmr:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: ldc_w 788
    //   66: astore 5
    //   68: goto -57 -> 11
    //   71: lload_2
    //   72: lconst_1
    //   73: lcmp
    //   74: ifeq +13 -> 87
    //   77: getstatic 790	awmr:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   80: ifnull +7 -> 87
    //   83: getstatic 790	awmr:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   86: areturn
    //   87: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +31 -> 121
    //   93: ldc_w 531
    //   96: iconst_2
    //   97: new 533	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 792
    //   107: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 5
    //   112: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 546	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: ldc2_w 559
    //   125: invokestatic 565	bcyw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +142 -> 272
    //   133: aload_1
    //   134: invokevirtual 460	java/lang/String:length	()I
    //   137: ifle +135 -> 272
    //   140: new 533	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   147: aload_1
    //   148: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: getstatic 570	java/io/File:separator	Ljava/lang/String;
    //   154: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: new 567	java/io/File
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 793	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 796	java/io/File:exists	()Z
    //   179: ifeq +239 -> 418
    //   182: new 637	java/io/FileInputStream
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 799	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   190: astore 5
    //   192: aload 5
    //   194: astore_1
    //   195: new 801	java/io/ByteArrayOutputStream
    //   198: dup
    //   199: invokespecial 802	java/io/ByteArrayOutputStream:<init>	()V
    //   202: astore 6
    //   204: aload 5
    //   206: astore_1
    //   207: sipush 4096
    //   210: newarray byte
    //   212: astore 7
    //   214: aload 5
    //   216: astore_1
    //   217: aload 5
    //   219: aload 7
    //   221: iconst_0
    //   222: sipush 4096
    //   225: invokevirtual 808	java/io/InputStream:read	([BII)I
    //   228: istore 4
    //   230: iload 4
    //   232: iconst_m1
    //   233: if_icmpeq +41 -> 274
    //   236: aload 5
    //   238: astore_1
    //   239: aload 6
    //   241: aload 7
    //   243: iconst_0
    //   244: iload 4
    //   246: invokevirtual 812	java/io/ByteArrayOutputStream:write	([BII)V
    //   249: goto -35 -> 214
    //   252: astore 6
    //   254: aload 5
    //   256: astore_1
    //   257: aload 6
    //   259: invokevirtual 813	java/lang/Exception:printStackTrace	()V
    //   262: aload 5
    //   264: ifnull +8 -> 272
    //   267: aload 5
    //   269: invokevirtual 814	java/io/InputStream:close	()V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 5
    //   276: astore_1
    //   277: new 207	java/lang/String
    //   280: dup
    //   281: aload 6
    //   283: invokevirtual 817	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   286: ldc_w 819
    //   289: invokespecial 822	java/lang/String:<init>	([BLjava/lang/String;)V
    //   292: astore 7
    //   294: aload 5
    //   296: astore 6
    //   298: aload 7
    //   300: ifnull +121 -> 421
    //   303: aload 5
    //   305: astore 6
    //   307: aload 5
    //   309: astore_1
    //   310: aload 7
    //   312: invokevirtual 460	java/lang/String:length	()I
    //   315: ifle +106 -> 421
    //   318: lload_2
    //   319: lconst_1
    //   320: lcmp
    //   321: ifne +50 -> 371
    //   324: aload 5
    //   326: astore_1
    //   327: new 452	org/json/JSONObject
    //   330: dup
    //   331: aload 7
    //   333: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   336: putstatic 786	awmr:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   339: aload 5
    //   341: astore_1
    //   342: getstatic 786	awmr:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   345: astore 6
    //   347: aload 6
    //   349: astore_1
    //   350: aload 5
    //   352: ifnull -291 -> 61
    //   355: aload 5
    //   357: invokevirtual 814	java/io/InputStream:close	()V
    //   360: aload 6
    //   362: areturn
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   368: aload 6
    //   370: areturn
    //   371: aload 5
    //   373: astore_1
    //   374: new 452	org/json/JSONObject
    //   377: dup
    //   378: aload 7
    //   380: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: putstatic 790	awmr:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   386: aload 5
    //   388: astore_1
    //   389: getstatic 790	awmr:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   392: astore 6
    //   394: aload 6
    //   396: astore_1
    //   397: aload 5
    //   399: ifnull -338 -> 61
    //   402: aload 5
    //   404: invokevirtual 814	java/io/InputStream:close	()V
    //   407: aload 6
    //   409: areturn
    //   410: astore_1
    //   411: aload_1
    //   412: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   415: aload 6
    //   417: areturn
    //   418: aconst_null
    //   419: astore 6
    //   421: aload 6
    //   423: ifnull -151 -> 272
    //   426: aload 6
    //   428: invokevirtual 814	java/io/InputStream:close	()V
    //   431: goto -159 -> 272
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   439: goto -167 -> 272
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   447: goto -175 -> 272
    //   450: astore 5
    //   452: aconst_null
    //   453: astore_1
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 814	java/io/InputStream:close	()V
    //   462: aload 5
    //   464: athrow
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 276	java/io/IOException:printStackTrace	()V
    //   470: goto -8 -> 462
    //   473: astore 5
    //   475: goto -21 -> 454
    //   478: astore 6
    //   480: aconst_null
    //   481: astore 5
    //   483: goto -229 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	awmr
    //   0	486	1	paramQQAppInterface	QQAppInterface
    //   0	486	2	paramLong	long
    //   228	17	4	i1	int
    //   9	394	5	localObject1	Object
    //   450	13	5	localObject2	Object
    //   473	1	5	localObject3	Object
    //   481	1	5	localObject4	Object
    //   202	38	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   252	30	6	localException1	Exception
    //   296	131	6	localObject5	Object
    //   478	1	6	localException2	Exception
    //   212	167	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   195	204	252	java/lang/Exception
    //   207	214	252	java/lang/Exception
    //   217	230	252	java/lang/Exception
    //   239	249	252	java/lang/Exception
    //   277	294	252	java/lang/Exception
    //   310	318	252	java/lang/Exception
    //   327	339	252	java/lang/Exception
    //   342	347	252	java/lang/Exception
    //   374	386	252	java/lang/Exception
    //   389	394	252	java/lang/Exception
    //   355	360	363	java/io/IOException
    //   402	407	410	java/io/IOException
    //   426	431	434	java/io/IOException
    //   267	272	442	java/io/IOException
    //   166	192	450	finally
    //   458	462	465	java/io/IOException
    //   195	204	473	finally
    //   207	214	473	finally
    //   217	230	473	finally
    //   239	249	473	finally
    //   257	262	473	finally
    //   277	294	473	finally
    //   310	318	473	finally
    //   327	339	473	finally
    //   342	347	473	finally
    //   374	386	473	finally
    //   389	394	473	finally
    //   166	192	478	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getValue() instanceof Drawable)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config file is " + paramLong1);
        }
        localObject1 = "";
        str2 = (String)jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramLong2));
        localObject2 = localObject1;
        try
        {
          localJSONObject1 = a(paramQQAppInterface, paramLong1);
          if (localJSONObject1 != null) {
            continue;
          }
          bool = false;
        }
        catch (Exception paramQQAppInterface)
        {
          try
          {
            JSONObject localJSONObject1;
            Iterator localIterator;
            if (!localIterator.hasNext()) {
              continue;
            }
            str1 = (String)localIterator.next();
            localObject2 = str1;
            if (!str1.startsWith("common"))
            {
              localObject2 = str1;
              if (TextUtils.isEmpty(str2)) {
                continue;
              }
              localObject2 = str1;
              if (!str1.startsWith(str2)) {
                continue;
              }
            }
            localObject2 = str1;
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str1);
            if (localJSONObject2 != null)
            {
              localObject2 = str1;
              String str3 = localJSONObject2.optString("type");
              if (str3 != null)
              {
                localObject2 = str1;
                if (str3.length() > 0)
                {
                  localObject1 = null;
                  localObject2 = str1;
                  if (str3.equalsIgnoreCase("ColorStateList"))
                  {
                    localObject2 = str1;
                    localObject1 = a(localJSONObject2.optJSONArray("data"));
                    if (localObject1 != null)
                    {
                      localObject2 = str1;
                      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localObject1);
                      localObject2 = str1;
                      if (!QLog.isColorLevel()) {
                        break label1177;
                      }
                      localObject2 = str1;
                      QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",put templateAttr and size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
                      break label1177;
                    }
                  }
                  else
                  {
                    localObject2 = str1;
                    if (str3.equalsIgnoreCase("BitmapDrawable"))
                    {
                      localObject2 = str1;
                      localObject1 = a(paramQQAppInterface, localJSONObject2.optString("data"), true, false);
                      continue;
                    }
                    localObject2 = str1;
                    if (str3.equalsIgnoreCase("XMLBitmap"))
                    {
                      localObject2 = str1;
                      localObject1 = a(paramQQAppInterface, localJSONObject2.optJSONObject("data"));
                      continue;
                    }
                    localObject2 = str1;
                    if (str3.equalsIgnoreCase("StateListDrawable"))
                    {
                      localObject2 = str1;
                      localObject1 = a(paramQQAppInterface, localJSONObject2.optJSONArray("data"));
                      continue;
                    }
                    localObject2 = str1;
                    if (str3.equalsIgnoreCase("String"))
                    {
                      localObject2 = str1;
                      localObject1 = localJSONObject2.optString("data");
                      continue;
                    }
                    localObject2 = str1;
                    if (!str3.equalsIgnoreCase("Color")) {
                      continue;
                    }
                    localObject2 = str1;
                    localObject1 = localJSONObject2.optString("data");
                    continue;
                  }
                  localObject2 = str1;
                  if (!QLog.isColorLevel()) {
                    break label1184;
                  }
                  localObject2 = str1;
                  QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",init error");
                  break label1184;
                }
              }
            }
            else
            {
              localObject2 = str1;
              if (QLog.isColorLevel())
              {
                localObject2 = str1;
                QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",value is null");
              }
            }
          }
          catch (Exception paramQQAppInterface)
          {
            localObject2 = localObject1;
            continue;
            int i1 = 1;
            continue;
            localObject1 = str1;
          }
          paramQQAppInterface = paramQQAppInterface;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = paramQQAppInterface.getClass().getName() + "," + paramQQAppInterface.getMessage();
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig key=" + (String)localObject2 + ",exception msg=" + (String)localObject1);
          paramQQAppInterface.printStackTrace();
          i1 = 0;
          if (i1 == 0) {
            continue;
          }
          i1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
          if (i1 <= 0) {
            continue;
          }
          bool = true;
          continue;
          localObject2 = str1;
          if (!QLog.isColorLevel()) {
            break label1170;
          }
          localObject2 = str1;
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key is not used,key=" + str1);
          localObject1 = str1;
          continue;
          if ((paramLong2 != jdField_i_of_type_Long) && (paramLong2 != jdField_j_of_type_Long)) {
            break label1164;
          }
          if (!awny.a(paramQQAppInterface)) {
            continue;
          }
          str1 = awob.a(paramQQAppInterface.getApp());
          localObject2 = bdpt.a(paramQQAppInterface, str1 + "logo.png", "-wzry-card-logo-", a(paramQQAppInterface, str1 + "logo.png", true, true), new int[] { 7 }, "-wzry-card-logo-", null);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("wzryLogo", localObject2);
          localObject2 = a(paramQQAppInterface, str1 + "bgImage.jpg", true, true);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("wzryGameInfoBackground", localObject2);
          localObject2 = a(paramQQAppInterface, str1 + "logo_bg.png", true, true);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("wzryLogoBg", localObject2);
          localObject2 = a(paramQQAppInterface, str1 + "shimmer_mask.png", true, true);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("wzryShimmer", localObject2);
          paramQQAppInterface = a(paramQQAppInterface, str1 + "addIcon.png", true, true);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("addIcon", paramQQAppInterface);
          if (jdField_a_of_type_AndroidGraphicsTypeface != null) {
            continue;
          }
          jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(str1 + "font_chs.tff");
          if (jdField_b_of_type_AndroidGraphicsTypeface != null) {
            continue;
          }
          jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(str1 + "font_num.tff");
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("commonMaskBackground", "#e61c212c");
          i1 = 1;
          continue;
          i1 = 0;
          continue;
          bool = false;
          continue;
        }
        return bool;
      }
      finally {}
      Object localObject2 = localObject1;
      localIterator = localJSONObject1.keys();
      Object localObject1 = "";
      label1164:
      label1170:
      continue;
      label1177:
      localObject1 = str1;
      continue;
      label1184:
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int i2 = arrayOfField.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        Field localField = arrayOfField[i1];
        if (localField.getModifiers() != 8) {}
        try
        {
          Object localObject = localField.get(this);
          localStringBuilder.append(localField.getName());
          localStringBuilder.append('=');
          localStringBuilder.append(localObject);
          localStringBuilder.append(',');
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmr
 * JD-Core Version:    0.7.0.1
 */