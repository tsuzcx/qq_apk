import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.ProfileCardUtil.1;
import com.tencent.mobileqq.util.ProfileCardUtil.2;
import com.tencent.mobileqq.util.ProfileCardUtil.3;
import com.tencent.mobileqq.util.ProfileCardUtil.4;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class bbac
{
  public static int a;
  protected static long a;
  public static String a;
  public static StringBuilder a;
  public static ArrayList<auvf> a;
  protected static HashMap<String, String> a;
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE", "GB", "US" };
  public static int b;
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString;
  public static int c;
  public static int d;
  public static int e;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(1080, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static int a(Context paramContext)
  {
    int i = a(paramContext.getResources());
    return (int)((paramContext.getResources().getDisplayMetrics().heightPixels - i) * 0.75F);
  }
  
  public static final int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i;
      if ((paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 21)) {
        i = 1000;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42)) {
        i = 1001;
      } else if (paramAllInOne.jdField_a_of_type_Int == 86) {
        i = 10002;
      } else if (paramAllInOne.jdField_a_of_type_Int == 94) {
        i = 10004;
      } else if (paramAllInOne.jdField_a_of_type_Int == 3) {
        i = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 2) {
        i = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 74) {
        i = 1023;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 32) || (paramAllInOne.jdField_a_of_type_Int == 31) || (paramAllInOne.jdField_a_of_type_Int == 51) || (paramAllInOne.jdField_a_of_type_Int == 50) || (paramAllInOne.jdField_a_of_type_Int == 34) || (paramAllInOne.jdField_a_of_type_Int == 53)) {
        i = 1006;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47)) {
        i = 1004;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57)) {
        i = 1009;
      } else if (paramAllInOne.jdField_a_of_type_Int == 58) {
        i = 1020;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 72)) {
        i = 1021;
      } else if (paramAllInOne.jdField_a_of_type_Int != 70) {
        if ((paramAllInOne.jdField_a_of_type_Int == 27) || (paramAllInOne.jdField_a_of_type_Int == 25)) {
          i = 1022;
        } else if ((paramAllInOne.jdField_a_of_type_Int == 75) || (paramAllInOne.jdField_a_of_type_Int == 76)) {
          i = 1010;
        } else if (paramAllInOne.jdField_a_of_type_Int == 80) {
          i = 25;
        } else {
          i = 1001;
        }
      }
    }
  }
  
  public static int a(String paramString)
  {
    int i1 = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.56338F);
    if (paramString == null) {}
    int i;
    do
    {
      return j;
      int k = 0;
      int n = 0;
      j = 0;
      while (k < paramString.getHeight())
      {
        int m = 0;
        i = n;
        if (m < paramString.getWidth())
        {
          n = paramString.getPixel(m, k);
          int i2 = Color.red(n);
          int i3 = Color.green(n);
          if ((Color.blue(n) + (i2 + i3)) / 3 > 127)
          {
            n = j + 1;
            j = i;
          }
          for (i = n;; i = n)
          {
            n = m + 1;
            m = i;
            i = j;
            j = m;
            m = n;
            break;
            n = j;
            j = i + 1;
          }
        }
        k += 1;
        n = i;
      }
      i = i1;
      if (j >= n) {
        i = 1;
      }
      paramString.recycle();
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - l) + "(ms)");
    return i;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() - jdField_a_of_type_Long;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.jdField_c_of_type_JavaLangString != null) && (paramAllInOne.jdField_c_of_type_JavaLangString.length() > 0)) {
      paramQQAppInterface = paramAllInOne.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l = Long.valueOf(paramAllInOne).longValue();
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.jdField_d_of_type_JavaLangString != null) && (paramAllInOne.jdField_d_of_type_JavaLangString.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.jdField_d_of_type_JavaLangString });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  public static Intent a(Intent paramIntent, String paramString, QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, BusinessCard paramBusinessCard)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return paramIntent;
    }
    String str = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.getAppid()), "android-8.3.0" });
    paramString = str;
    if (b()) {
      paramString = str + "&intl=1";
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
    }
    paramIntent = new Intent(paramIntent);
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("AllInOne", paramAllInOne);
    paramIntent.putExtra("BusinessCard", paramBusinessCard);
    return paramIntent;
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: new 376	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: invokevirtual 382	java/io/File:exists	()Z
    //   17: ifeq +19 -> 36
    //   20: aload_0
    //   21: invokevirtual 384	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +10 -> 36
    //   29: aload_0
    //   30: invokevirtual 387	java/io/File:isDirectory	()Z
    //   33: ifeq +9 -> 42
    //   36: aconst_null
    //   37: astore 7
    //   39: aload 7
    //   41: areturn
    //   42: new 389	java/io/BufferedInputStream
    //   45: dup
    //   46: new 391	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 397	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 403	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +13 -> 79
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: aload 6
    //   81: invokevirtual 226	android/graphics/Bitmap:getWidth	()I
    //   84: istore_3
    //   85: aload 6
    //   87: invokevirtual 223	android/graphics/Bitmap:getHeight	()I
    //   90: istore 4
    //   92: iload_3
    //   93: iload_1
    //   94: if_icmple +68 -> 162
    //   97: iload_1
    //   98: i2f
    //   99: fload_2
    //   100: fdiv
    //   101: f2i
    //   102: istore 5
    //   104: new 408	android/graphics/Matrix
    //   107: dup
    //   108: invokespecial 409	android/graphics/Matrix:<init>	()V
    //   111: astore 7
    //   113: aload 7
    //   115: iload_1
    //   116: i2f
    //   117: iload_3
    //   118: i2f
    //   119: fdiv
    //   120: iload 5
    //   122: i2f
    //   123: iload 4
    //   125: i2f
    //   126: fdiv
    //   127: invokevirtual 413	android/graphics/Matrix:postScale	(FF)Z
    //   130: pop
    //   131: aload 6
    //   133: iconst_0
    //   134: iconst_0
    //   135: iload_3
    //   136: iload 4
    //   138: aload 7
    //   140: iconst_1
    //   141: invokestatic 417	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   144: astore 7
    //   146: aload 6
    //   148: invokevirtual 243	android/graphics/Bitmap:recycle	()V
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   159: aload 7
    //   161: areturn
    //   162: aload 6
    //   164: astore 7
    //   166: aload_0
    //   167: ifnull -128 -> 39
    //   170: aload_0
    //   171: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   174: aload 6
    //   176: areturn
    //   177: astore_0
    //   178: aload 6
    //   180: areturn
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore 6
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   219: aload 6
    //   221: athrow
    //   222: astore_0
    //   223: goto -146 -> 77
    //   226: astore_0
    //   227: goto -68 -> 159
    //   230: astore_0
    //   231: goto -39 -> 192
    //   234: astore_0
    //   235: goto -30 -> 205
    //   238: astore_0
    //   239: goto -20 -> 219
    //   242: astore 6
    //   244: goto -33 -> 211
    //   247: astore 6
    //   249: goto -52 -> 197
    //   252: astore 6
    //   254: goto -70 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   0	257	1	paramInt	int
    //   0	257	2	paramFloat	float
    //   84	52	3	i	int
    //   90	47	4	j	int
    //   102	19	5	k	int
    //   62	117	6	localBitmap	Bitmap
    //   207	13	6	localObject1	Object
    //   242	1	6	localObject2	Object
    //   247	1	6	localException	Exception
    //   252	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   37	128	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   170	174	177	java/lang/Exception
    //   42	58	181	java/lang/OutOfMemoryError
    //   42	58	194	java/lang/Exception
    //   42	58	207	finally
    //   73	77	222	java/lang/Exception
    //   155	159	226	java/lang/Exception
    //   188	192	230	java/lang/Exception
    //   201	205	234	java/lang/Exception
    //   215	219	238	java/lang/Exception
    //   58	64	242	finally
    //   79	92	242	finally
    //   97	151	242	finally
    //   58	64	247	java/lang/Exception
    //   79	92	247	java/lang/Exception
    //   97	151	247	java/lang/Exception
    //   58	64	252	java/lang/OutOfMemoryError
    //   79	92	252	java/lang/OutOfMemoryError
    //   97	151	252	java/lang/OutOfMemoryError
  }
  
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!bbti.a(paramContext, paramInt2)) {
      bbti.a((QQAppInterface)localAppInterface, paramInt2, null, false);
    }
    Object localObject1;
    if (paramInt3 == 0)
    {
      localObject1 = new SpannableString("*");
      paramInt1 = (int)paramContext.getResources().getDimension(2131297088);
      paramContext = paramContext.getResources().getDrawable(2130845004);
      paramContext = bbqz.a(localAppInterface, a(paramInt2, jdField_a_of_type_Int), "", paramContext, bbqz.b, "halfstar", false, null);
      paramContext.setBounds(0, 0, paramInt1, paramInt1);
      ProfileActivity.a(localAppInterface, paramContext);
      ((SpannableString)localObject1).setSpan(new ImageSpan(paramContext), 0, 1, 33);
      return localObject1;
    }
    int k = paramInt3 / 64;
    paramInt3 %= 64;
    int m = paramInt3 / 16;
    int i1 = paramInt3 % 16;
    int n = i1 / 4;
    Object localObject4 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt3 = 0;
      localObject1 = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt3)
        {
          localObject4 = (String)localObject4 + (String)localObject1;
          j += 1;
        }
        localObject1 = "!";
        paramInt3 = k;
        continue;
        localObject1 = "@";
        paramInt3 = m;
        continue;
        localObject1 = "#";
        paramInt3 = n;
        continue;
        localObject1 = "%";
        paramInt3 = i1 % 4;
      }
      i += 1;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject5;
      try
      {
        if (((String)localObject4).length() <= paramInt1) {
          break label941;
        }
        localObject1 = ((String)localObject4).substring(0, paramInt1);
        localObject7 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject5 = paramContext.getResources().getDrawable(2130849636);
          if (localObject5 != null)
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            ((Drawable)localObject5).setBounds(0, 0, i, i);
            localObject1 = localObject5;
            localObject4 = localObject5;
            localSpannableString.setSpan(new ImageSpan((Drawable)localObject5), paramInt3, paramInt3 + 1, 33);
          }
          return localSpannableString;
        }
        catch (Error localError)
        {
          for (;;)
          {
            Object localObject7;
            Object localObject6;
            Object localObject8;
            Object localObject2;
            localObject5 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.FrdProfileCard", 2, localError.toString());
              localObject5 = localObject2;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localObject5 = localError;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.FrdProfileCard", 2, localException2.toString());
              localObject5 = localError;
            }
          }
        }
        localException1 = localException1;
        localException1.printStackTrace();
        localObject7 = localObject4;
        continue;
        localObject2 = localObject6;
        localObject4 = localObject8;
        if (!"!".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject6;
        localObject4 = localObject8;
        localObject5 = paramContext.getResources().getDrawable(2130845002);
        localObject2 = localObject6;
        localObject4 = localObject8;
        localObject5 = bbqz.a(localAppInterface, a(paramInt2, jdField_e_of_type_Int), "", (Drawable)localObject5, bbqz.b, "crown", false, null);
        localObject6 = localObject5;
        localObject2 = localObject5;
        localObject4 = localObject5;
        if (!"@".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = paramContext.getResources().getDrawable(2130845006);
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = bbqz.a(localAppInterface, a(paramInt2, jdField_d_of_type_Int), "", (Drawable)localObject6, bbqz.b, "sun", false, null);
        localObject5 = localObject6;
        localObject2 = localObject6;
        localObject4 = localObject6;
        if (!"#".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject6;
        localObject4 = localObject6;
        localObject5 = paramContext.getResources().getDrawable(2130845003);
        localObject2 = localObject6;
        localObject4 = localObject6;
        localObject5 = bbqz.a(localAppInterface, a(paramInt2, jdField_c_of_type_Int), "", (Drawable)localObject5, bbqz.b, "moon", false, null);
        localObject2 = localObject5;
        localObject4 = localObject5;
        if (!"%".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          break label934;
        }
      }
      SpannableString localSpannableString = new SpannableString(localObject7);
      i = (int)paramContext.getResources().getDimension(2131297088);
      paramInt3 = 0;
      if (paramInt3 < localObject7.length())
      {
        localObject6 = null;
        localObject8 = null;
        localObject5 = null;
        if ((paramInt3 == paramInt1 - 1) && (paramBoolean == true))
        {
          localObject1 = localObject6;
          localObject4 = localObject8;
        }
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = paramContext.getResources().getDrawable(2130845005);
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject5 = bbqz.a(localAppInterface, a(paramInt2, jdField_b_of_type_Int), "", (Drawable)localObject6, bbqz.b, "star", false, null);
      }
      label934:
      for (localObject2 = localObject5;; localObject3 = localObject5)
      {
        localObject5 = localObject2;
        if (localObject5 != null)
        {
          ((Drawable)localObject5).setBounds(0, 0, i, i);
          ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject5);
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject5), paramInt3, paramInt3 + 1, 33);
        }
        paramInt3 += 1;
        break;
        return localSpannableString;
      }
      label941:
      Object localObject3 = localError;
    }
  }
  
  public static auvf a(auvf paramauvf)
  {
    if (paramauvf == null) {
      return null;
    }
    auvf localauvf = new auvf();
    localauvf.jdField_o_of_type_Long = paramauvf.jdField_o_of_type_Long;
    localauvf.jdField_a_of_type_JavaLangString = paramauvf.jdField_a_of_type_JavaLangString;
    localauvf.jdField_b_of_type_JavaLangString = paramauvf.jdField_b_of_type_JavaLangString;
    localauvf.jdField_c_of_type_JavaLangString = paramauvf.jdField_c_of_type_JavaLangString;
    localauvf.jdField_a_of_type_Int = paramauvf.jdField_a_of_type_Int;
    localauvf.jdField_b_of_type_Int = paramauvf.jdField_b_of_type_Int;
    localauvf.jdField_c_of_type_Int = paramauvf.jdField_c_of_type_Int;
    localauvf.jdField_d_of_type_JavaLangString = paramauvf.jdField_d_of_type_JavaLangString;
    localauvf.jdField_e_of_type_JavaLangString = paramauvf.jdField_e_of_type_JavaLangString;
    localauvf.jdField_f_of_type_JavaLangString = paramauvf.jdField_f_of_type_JavaLangString;
    localauvf.jdField_g_of_type_JavaLangString = paramauvf.jdField_g_of_type_JavaLangString;
    localauvf.jdField_h_of_type_JavaLangString = paramauvf.jdField_h_of_type_JavaLangString;
    localauvf.jdField_i_of_type_JavaLangString = paramauvf.jdField_i_of_type_JavaLangString;
    localauvf.jdField_j_of_type_JavaLangString = paramauvf.jdField_j_of_type_JavaLangString;
    localauvf.jdField_k_of_type_JavaLangString = paramauvf.jdField_k_of_type_JavaLangString;
    localauvf.jdField_d_of_type_Int = paramauvf.jdField_d_of_type_Int;
    localauvf.p = paramauvf.p;
    localauvf.q = paramauvf.q;
    localauvf.r = paramauvf.r;
    localauvf.s = paramauvf.s;
    localauvf.jdField_l_of_type_JavaLangString = paramauvf.jdField_l_of_type_JavaLangString;
    localauvf.n = paramauvf.n;
    localauvf.m = paramauvf.m;
    localauvf.jdField_o_of_type_JavaLangString = paramauvf.jdField_o_of_type_JavaLangString;
    localauvf.jdField_h_of_type_Int = paramauvf.jdField_h_of_type_Int;
    localauvf.t = paramauvf.t;
    localauvf.jdField_i_of_type_Int = paramauvf.jdField_i_of_type_Int;
    localauvf.jdField_j_of_type_Int = paramauvf.jdField_j_of_type_Int;
    localauvf.jdField_k_of_type_Int = paramauvf.jdField_k_of_type_Int;
    localauvf.jdField_e_of_type_Int = paramauvf.jdField_e_of_type_Int;
    localauvf.jdField_f_of_type_Int = paramauvf.jdField_f_of_type_Int;
    localauvf.jdField_g_of_type_Int = paramauvf.jdField_g_of_type_Int;
    localauvf.jdField_l_of_type_Int = paramauvf.jdField_l_of_type_Int;
    localauvf.jdField_a_of_type_Boolean = paramauvf.jdField_a_of_type_Boolean;
    return localauvf;
  }
  
  public static auvf a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int k = 0;
    if (paramLong == auvf.jdField_a_of_type_Long) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true, paramBoolean);
    int m = localArrayList.size();
    int i = 0;
    paramQQAppInterface = null;
    int j = k;
    if (i < m)
    {
      paramQQAppInterface = (auvf)localArrayList.get(i);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.jdField_o_of_type_Long == paramLong)) {
        j = 1;
      }
    }
    else
    {
      if ((j != 1) || (paramQQAppInterface == null)) {
        break label92;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i += 1;
      break;
      label92:
      paramQQAppInterface = null;
    }
  }
  
  public static ayvz a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    String str = a();
    bbef.a(paramString, str, 1080, 1080, 100);
    return a(paramQQAppInterface, str, paramIntent, true);
  }
  
  private static ayvz a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    long l = ((File)localObject).length();
    ayvz localayvz = new ayvz();
    if (!((File)localObject).exists())
    {
      localayvz.jdField_a_of_type_Int = -10000;
      localayvz.jdField_a_of_type_JavaLangString = "file not exist";
      a("onAvatarChanged", localayvz.jdField_a_of_type_Int, localayvz.jdField_a_of_type_JavaLangString);
      return localayvz;
    }
    if (!bbfj.d(paramQQAppInterface.getApp()))
    {
      localayvz.jdField_a_of_type_Int = -10001;
      localayvz.jdField_a_of_type_JavaLangString = "network error";
      a("onAvatarChanged", localayvz.jdField_a_of_type_Int, localayvz.jdField_a_of_type_JavaLangString);
      return localayvz;
    }
    if ((l <= 0L) || (l >= 1749600L))
    {
      a("onAvatarChanged", 0, String.valueOf(l));
      localayvz.jdField_a_of_type_Int = -10000;
      localayvz.jdField_a_of_type_JavaLangString = "image illegal, size must be square.";
      a("onAvatarChanged", localayvz.jdField_a_of_type_Int, localayvz.jdField_a_of_type_JavaLangString);
      return localayvz;
    }
    if (paramBoolean)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = ((BitmapFactory.Options)localObject).outWidth;
      if ((i != ((BitmapFactory.Options)localObject).outHeight) || (i <= 0) || (i > 1080))
      {
        localayvz.jdField_a_of_type_Int = -10000;
        localayvz.jdField_a_of_type_JavaLangString = "image illegal, size must be square.";
        a("onAvatarChanged", localayvz.jdField_a_of_type_Int, localayvz.jdField_a_of_type_JavaLangString);
        return localayvz;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l);
    }
    localayvz.jdField_a_of_type_Int = 0;
    localayvz.jdField_a_of_type_JavaLangString = "ok";
    a(paramString);
    paramQQAppInterface.a().a(paramQQAppInterface, paramString, paramIntent);
    return localayvz;
  }
  
  public static bbpr a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ProfileCardUtil", 2, "do parse ProfileCardBgInfo");
      }
      bbpr localbbpr = new bbpr();
      try
      {
        paramString = new JSONObject(paramString);
        localbbpr.jdField_b_of_type_Int = paramString.getInt("frameInterval");
        localbbpr.jdField_a_of_type_Int = paramString.getInt("frameNumber");
        localbbpr.jdField_a_of_type_Float = ((float)paramString.getDouble("positionX"));
        localbbpr.jdField_b_of_type_Float = ((float)paramString.getDouble("positionY"));
        localbbpr.c = ((float)paramString.getDouble("width"));
        localbbpr.d = ((float)paramString.getDouble("height"));
        return localbbpr;
      }
      catch (JSONException paramString)
      {
        QLog.e("ProfileCardUtil", 2, "parse, exception=" + MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return null;
  }
  
  public static FriendProfileCardBgDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    bbpr localbbpr = null;
    if (!paramString1.equals(""))
    {
      localbbpr = a(bbdx.a(new File(paramString1, "config.json"), -1));
      if (localbbpr != null)
      {
        String[] arrayOfString = new String[localbbpr.jdField_a_of_type_Int];
        int i = 0;
        while (i < localbbpr.jdField_a_of_type_Int)
        {
          arrayOfString[i] = (paramString1 + "/" + (i + 1) + ".png");
          i += 1;
        }
        localbbpr.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
      }
    }
    paramString1 = localbbpr;
    if (localbbpr == null) {
      paramString1 = new bbpr();
    }
    if (paramString1 != null) {
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
    }
    return new FriendProfileCardBgDrawable(paramResources, paramString1);
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    byte b2 = 1;
    ajxl localajxl;
    OlympicManager localOlympicManager;
    byte b1;
    try
    {
      localajxl = (ajxl)paramQQAppInterface.getManager(51);
      localOlympicManager = (OlympicManager)paramQQAppInterface.getManager(167);
      if (localajxl == null) {
        break label568;
      }
      localObject1 = localajxl.e(paramString);
      paramQQAppInterface = localajxl.b(paramString);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCardUtil", 2, "initCard card = null, uin = " + paramString);
        }
        paramQQAppInterface = new Card();
        paramQQAppInterface.uin = paramString;
        paramQQAppInterface.shGender = -1;
        if (localOlympicManager.a(paramString))
        {
          b1 = 1;
          paramQQAppInterface.olympicTorch = b1;
          if (localObject1 == null) {
            break label415;
          }
          paramQQAppInterface.strNick = ((Friends)localObject1).name;
          paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
          paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            break label400;
          }
          b1 = 1;
          label166:
          paramQQAppInterface.bQQVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label405;
          }
          b1 = 1;
          label184:
          paramQQAppInterface.bSuperVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
            break label410;
          }
          b1 = b2;
          label202:
          paramQQAppInterface.bSuperQQOpen = b1;
          if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
            QLog.d("ProfileCardUtil", 2, "initCard bSuperVipOpen=" + paramQQAppInterface.bSuperVipOpen + ",bQQVipOpen=" + paramQQAppInterface.bQQVipOpen + ",uin = " + paramString);
          }
          paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
          paramQQAppInterface.namePlateOfKingGameId = ((Friends)localObject1).namePlateOfKingGameId;
          paramQQAppInterface.namePlateOfKingLoginTime = ((Friends)localObject1).namePlateOfKingLoginTime;
        }
        for (;;)
        {
          if (localajxl == null) {
            break label565;
          }
          localajxl.a(paramQQAppInterface);
          label381:
          if (paramQQAppInterface != null) {
            paramQQAppInterface.getPersonalityLabel();
          }
          return paramQQAppInterface;
          b1 = 0;
          break;
          label400:
          b1 = 0;
          break label166;
          label405:
          b1 = 0;
          break label184;
          label410:
          b1 = 0;
          break label202;
          label415:
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
        }
      }
      if (localObject1 == null) {
        break label542;
      }
    }
    finally {}
    int i;
    label474:
    boolean bool2;
    boolean bool1;
    if (!bbbr.a(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
    {
      paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
      i = 1;
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      bool2 = localOlympicManager.a(paramString);
      if (paramQQAppInterface.olympicTorch == 1)
      {
        bool1 = true;
        break label581;
      }
    }
    for (;;)
    {
      label517:
      paramQQAppInterface.olympicTorch = b1;
      i = 1;
      label525:
      if ((localajxl != null) && (i != 0)) {
        localajxl.a(paramQQAppInterface);
      }
      label542:
      break label381;
      bool1 = false;
      label565:
      label568:
      label581:
      do
      {
        b1 = 0;
        break label517;
        do
        {
          break label525;
          i = 0;
          break label474;
          break label381;
          Object localObject2 = null;
          paramQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = localObject2;
          break;
        } while (bool1 == bool2);
      } while (!bool2);
      b1 = 1;
    }
  }
  
  @NotNull
  public static BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(-1);
    atxd localatxd = (atxd)BaseApplicationImpl.getApplication().getRuntime().getManager(160);
    RedTouchItem localRedTouchItem = localatxd.a(-4);
    if ((localatxd.a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      QLog.d("ProfileCardUtil", 1, "getProfileMsgListRedTouch");
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
    }
    return localRedTypeInfo;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ajti.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return bbvj.a(localStringBuilder.toString());
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return ajya.a(2131708452);
    case 2: 
      return ajya.a(2131708444);
    case 3: 
      return ajya.a(2131708470);
    case 4: 
      return ajya.a(2131708442);
    case 5: 
      return ajya.a(2131708449);
    case 6: 
      return ajya.a(2131708448);
    case 7: 
      return ajya.a(2131708462);
    case 8: 
      return ajya.a(2131708475);
    case 9: 
      return ajya.a(2131708484);
    case 10: 
      return ajya.a(2131708492);
    case 11: 
      return ajya.a(2131708472);
    }
    return ajya.a(2131708464);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    bbti localbbti = bbti.a;
    switch (paramInt2)
    {
    default: 
      return "_";
    case 0: 
      return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/half.png";
    case 1: 
      return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/star.png";
    case 2: 
      return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/moon.png";
    case 3: 
      return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/sun.png";
    case 4: 
      return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/crown.png";
    }
    return localbbti.getDir(BaseApplicationImpl.getApplication(), localbbti.getScid(paramInt1)) + "/more.png";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + "8.3.0";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131694074));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131719971));
        localStringBuilder.append("  ");
      }
      paramContext = bazx.c(paramInt3);
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(paramContext);
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!ajya.a(2131708483).equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + "-";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + "-";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131692394));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131694074));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131719971));
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!ajya.a(2131708456).equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + " ";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + " ";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131692394));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, auuy paramauuy)
  {
    Card localCard = paramauuy.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramauuy.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i = -1;
    paramauuy = "";
    Object localObject;
    if (localCard != null)
    {
      i = localCard.age;
      localObject = paramauuy;
      if (i > 0)
      {
        localObject = paramauuy;
        if (!b()) {
          localObject = i + paramContext.getString(2131719971);
        }
      }
      paramauuy = "";
      if (localCard == null) {
        break label356;
      }
      paramContext = paramauuy;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContext = paramauuy;
        if (!ajya.a(2131708454).equals(localCard.strCountry)) {
          paramContext = "" + localCard.strCountry;
        }
      }
      paramauuy = paramContext;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        paramauuy = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramauuy = paramContext + " ";
        }
        paramauuy = paramauuy + localCard.strProvince;
      }
      paramContext = paramauuy;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContext = paramauuy;
        if (!TextUtils.isEmpty(paramauuy)) {
          paramContext = paramauuy + " ";
        }
        paramContext = paramContext + localCard.strCity;
      }
      label263:
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label554;
      }
    }
    label554:
    for (paramauuy = "" + " " + (String)localObject;; paramauuy = "")
    {
      localObject = paramauuy;
      if (paramContext != null)
      {
        localObject = paramauuy;
        if (paramContext.length() > 0) {
          localObject = paramauuy + " " + paramContext;
        }
      }
      return localObject;
      if (localContactCard == null) {
        break;
      }
      i = localContactCard.bAge;
      break;
      label356:
      paramContext = paramauuy;
      if (localContactCard == null) {
        break label263;
      }
      paramContext = paramauuy;
      if (!TextUtils.isEmpty(localContactCard.strCountry))
      {
        paramContext = paramauuy;
        if (!ajya.a(2131708467).equals(localContactCard.strCountry)) {
          paramContext = "" + localContactCard.strCountry;
        }
      }
      paramauuy = paramContext;
      if (!TextUtils.isEmpty(localContactCard.strProvince))
      {
        paramauuy = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramauuy = paramContext + " ";
        }
        paramauuy = paramauuy + localContactCard.strProvince;
      }
      paramContext = paramauuy;
      if (TextUtils.isEmpty(localContactCard.strCity)) {
        break label263;
      }
      paramContext = paramauuy;
      if (!TextUtils.isEmpty(paramauuy)) {
        paramContext = paramauuy + " ";
      }
      paramContext = paramContext + localContactCard.strCity;
      break label263;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return c(paramContext) + e(paramString);
  }
  
  public static String a(auuy paramauuy, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramauuy == null) || (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      String str2 = paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str1 = paramauuy.jdField_a_of_type_JavaLangString;
      paramauuy = (bduf)paramQQAppInterface.getManager(165);
      if (paramauuy.a(str2)) {
        return String.format("https://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", new Object[] { str2, String.valueOf(paramQQAppInterface.getAppid()), "android-8.3.0" });
      }
      if (paramauuy.f(str2)) {
        return paramActivity.getIntent().getStringExtra("key_qidian_detail_url");
      }
      paramQQAppInterface = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { str2, String.valueOf(paramQQAppInterface.getAppid()), "android-8.3.0" });
      paramauuy = paramQQAppInterface;
      if (!TextUtils.isEmpty(str1)) {
        paramauuy = paramQQAppInterface + "&troopUin=" + str1;
      }
      paramQQAppInterface = paramauuy;
    } while (!b());
    return paramauuy + "&intl=1";
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    String str = "";
    Object localObject = str;
    if (paramAllInOne != null)
    {
      localObject = str;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = str;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject == null) {
            break label99;
          }
        }
      }
    }
    label99:
    for (str = ((ProfileActivity.CardContactInfo)localObject).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject).jdField_c_of_type_JavaLangString;; str = "")
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) {
          localObject = paramAllInOne.jdField_a_of_type_JavaLangString;
        }
      }
      return localObject;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(ajsd.cm);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramQQAppInterface = "0" + i;
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label308;
      }
      paramQQAppInterface = "0" + i;
      label111:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label316;
      }
      paramQQAppInterface = "0" + i;
      label152:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label324;
      }
      paramQQAppInterface = "0" + i;
      label193:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label332;
      }
    }
    label308:
    label316:
    label324:
    label332:
    for (paramQQAppInterface = "0" + i;; paramQQAppInterface = Integer.valueOf(i))
    {
      localStringBuilder.append(paramQQAppInterface);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label340;
      }
      return localStringBuilder.toString() + ".jpg";
      paramQQAppInterface = Integer.valueOf(i);
      break;
      paramQQAppInterface = Integer.valueOf(i);
      break label111;
      paramQQAppInterface = Integer.valueOf(i);
      break label152;
      paramQQAppInterface = Integer.valueOf(i);
      break label193;
    }
    label340:
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramQQAppInterface.append('(');
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(')');
        paramQQAppInterface.append(".jpg");
        if (new File(paramQQAppInterface.toString()).exists()) {}
      }
      else
      {
        return paramQQAppInterface.toString();
      }
      paramQQAppInterface.delete(j, paramQQAppInterface.length());
      i += 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return paramQQAppInterface + File.separator + "common_" + "583";
    }
    if ((paramLong != auvf.jdField_a_of_type_Long) && (paramLong > 0L)) {
      return paramQQAppInterface + File.separator + paramLong;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(ajti.jdField_a_of_type_JavaLangString).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return bbvj.a(localStringBuilder.toString());
  }
  
  public static String a(List<String> paramList, int paramInt1, int paramInt2, String paramString, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null)
    {
      paramStringBuilder = new StringBuilder();
      if (paramList != null) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = paramList.size())
    {
      int j = paramInt1;
      while ((j >= 0) && (j < paramInt2) && (j < i))
      {
        if (j > paramInt1) {
          paramStringBuilder.append(paramString);
        }
        paramStringBuilder.append((String)paramList.get(j));
        j += 1;
      }
      paramStringBuilder.setLength(0);
      break;
    }
    return paramStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://club.vip.qq.com/profile/custom?_wv=131072&_fv=0");
    if (paramBoolean) {
      localStringBuilder.append("&from=guest");
    }
    localStringBuilder.append("&templateId=").append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  /* Error */
  public static ArrayList<auvf> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 344
    //   12: iconst_2
    //   13: ldc_w 1214
    //   16: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 640	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 1216	bbac:b	(Landroid/content/Context;)Ljava/lang/String;
    //   28: astore 8
    //   30: new 376	java/io/File
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 382	java/io/File:exists	()Z
    //   46: istore 5
    //   48: iload 5
    //   50: ifne +8 -> 58
    //   53: ldc_w 1218
    //   56: astore 8
    //   58: getstatic 32	bbac:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: aload 8
    //   63: invokestatic 1221	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   66: ifeq +20 -> 86
    //   69: getstatic 28	bbac:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   72: invokevirtual 1223	java/util/ArrayList:isEmpty	()Z
    //   75: ifne +11 -> 86
    //   78: iload_1
    //   79: ifne +7 -> 86
    //   82: getstatic 28	bbac:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: areturn
    //   86: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +13 -> 102
    //   92: ldc_w 344
    //   95: iconst_2
    //   96: ldc_w 1225
    //   99: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: new 23	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 26	java/util/ArrayList:<init>	()V
    //   109: astore 10
    //   111: iload 5
    //   113: ifeq +103 -> 216
    //   116: new 391	java/io/FileInputStream
    //   119: dup
    //   120: aload 7
    //   122: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: new 1227	java/io/ByteArrayOutputStream
    //   129: dup
    //   130: invokespecial 1228	java/io/ByteArrayOutputStream:<init>	()V
    //   133: astore 7
    //   135: sipush 4096
    //   138: newarray byte
    //   140: astore 6
    //   142: aload_0
    //   143: aload 6
    //   145: iconst_0
    //   146: sipush 4096
    //   149: invokevirtual 1234	java/io/InputStream:read	([BII)I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_m1
    //   155: if_icmpeq +75 -> 230
    //   158: aload 7
    //   160: aload 6
    //   162: iconst_0
    //   163: iload_2
    //   164: invokevirtual 1238	java/io/ByteArrayOutputStream:write	([BII)V
    //   167: goto -25 -> 142
    //   170: astore 9
    //   172: aload 7
    //   174: astore 6
    //   176: aload 9
    //   178: astore 7
    //   180: aload 7
    //   182: invokevirtual 1239	java/lang/Throwable:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 1240	java/io/InputStream:close	()V
    //   193: aload 6
    //   195: ifnull +8 -> 203
    //   198: aload 6
    //   200: invokevirtual 1241	java/io/ByteArrayOutputStream:close	()V
    //   203: aload 8
    //   205: putstatic 32	bbac:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload 10
    //   210: putstatic 28	bbac:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   213: aload 10
    //   215: areturn
    //   216: aload_0
    //   217: invokevirtual 1245	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   220: ldc_w 1247
    //   223: invokevirtual 1253	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   226: astore_0
    //   227: goto -101 -> 126
    //   230: new 42	java/lang/String
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 1257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   239: ldc_w 1259
    //   242: invokespecial 1262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 280	java/lang/String:length	()I
    //   252: ifle +627 -> 879
    //   255: new 702	org/json/JSONObject
    //   258: dup
    //   259: aload 6
    //   261: invokespecial 703	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   264: astore 6
    //   266: aload 6
    //   268: ldc_w 1264
    //   271: invokevirtual 1267	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +605 -> 879
    //   277: aload 6
    //   279: ldc_w 1264
    //   282: invokevirtual 1271	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   285: astore 6
    //   287: aload 6
    //   289: invokevirtual 1274	org/json/JSONArray:length	()I
    //   292: istore_3
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: iload_3
    //   297: if_icmpge +489 -> 786
    //   300: aload 6
    //   302: iload_2
    //   303: invokevirtual 1278	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   306: astore 9
    //   308: new 527	auvf
    //   311: dup
    //   312: invokespecial 528	auvf:<init>	()V
    //   315: astore 11
    //   317: aload 11
    //   319: aload 9
    //   321: ldc_w 1280
    //   324: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   327: i2l
    //   328: putfield 531	auvf:jdField_o_of_type_Long	J
    //   331: aload 11
    //   333: aload 9
    //   335: ldc_w 1284
    //   338: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: putfield 532	auvf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: aload 11
    //   346: aload 9
    //   348: ldc_w 1289
    //   351: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: putfield 534	auvf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   357: aload 11
    //   359: aload 9
    //   361: ldc_w 1291
    //   364: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: putfield 535	auvf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   370: aload 11
    //   372: aload 9
    //   374: ldc_w 1293
    //   377: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: putfield 536	auvf:jdField_a_of_type_Int	I
    //   383: aload 11
    //   385: aload 9
    //   387: ldc_w 1295
    //   390: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   393: putfield 537	auvf:jdField_b_of_type_Int	I
    //   396: aload 11
    //   398: aload 9
    //   400: ldc_w 1297
    //   403: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   406: putfield 538	auvf:jdField_c_of_type_Int	I
    //   409: aload 11
    //   411: aload 9
    //   413: ldc_w 1299
    //   416: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 539	auvf:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   422: aload 11
    //   424: aload 9
    //   426: ldc_w 1301
    //   429: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: putfield 541	auvf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   435: aload 11
    //   437: aload 9
    //   439: ldc_w 1303
    //   442: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 544	auvf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   448: aload 11
    //   450: aload 9
    //   452: ldc_w 1305
    //   455: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: putfield 547	auvf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   461: aload 11
    //   463: aload 9
    //   465: ldc_w 1307
    //   468: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: putfield 550	auvf:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   474: aload 11
    //   476: aload 9
    //   478: ldc_w 1309
    //   481: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: putfield 552	auvf:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   487: aload 11
    //   489: aload 9
    //   491: ldc_w 1311
    //   494: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   497: putfield 555	auvf:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   500: aload 11
    //   502: aload 9
    //   504: ldc_w 1313
    //   507: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: putfield 558	auvf:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   513: aload 11
    //   515: aload 9
    //   517: ldc_w 1315
    //   520: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 559	auvf:jdField_d_of_type_Int	I
    //   526: aload 11
    //   528: aload 9
    //   530: ldc_w 1317
    //   533: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   536: putfield 562	auvf:p	Ljava/lang/String;
    //   539: aload 11
    //   541: aload 9
    //   543: ldc_w 1319
    //   546: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   549: putfield 565	auvf:q	Ljava/lang/String;
    //   552: aload 11
    //   554: aload 9
    //   556: ldc_w 1321
    //   559: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: putfield 568	auvf:r	Ljava/lang/String;
    //   565: aload 11
    //   567: aload 9
    //   569: ldc_w 1323
    //   572: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   575: putfield 571	auvf:s	Ljava/lang/String;
    //   578: aload 11
    //   580: aload 9
    //   582: ldc_w 1325
    //   585: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: putfield 574	auvf:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   591: aload 11
    //   593: aload 9
    //   595: ldc_w 1327
    //   598: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: putfield 577	auvf:n	Ljava/lang/String;
    //   604: aload 11
    //   606: aload 9
    //   608: ldc_w 1329
    //   611: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   614: putfield 580	auvf:m	Ljava/lang/String;
    //   617: aload 11
    //   619: aload 9
    //   621: ldc_w 1331
    //   624: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: putfield 582	auvf:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   630: aload 11
    //   632: aload 9
    //   634: ldc_w 1333
    //   637: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   640: putfield 584	auvf:jdField_h_of_type_Int	I
    //   643: aload 11
    //   645: aload 9
    //   647: ldc_w 1335
    //   650: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 587	auvf:t	Ljava/lang/String;
    //   656: aload 11
    //   658: aload 9
    //   660: ldc_w 1337
    //   663: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   666: putfield 589	auvf:jdField_i_of_type_Int	I
    //   669: aload 11
    //   671: aload 9
    //   673: ldc_w 1339
    //   676: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: putfield 591	auvf:jdField_j_of_type_Int	I
    //   682: aload 11
    //   684: aload 9
    //   686: ldc_w 1341
    //   689: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   692: putfield 593	auvf:jdField_k_of_type_Int	I
    //   695: aload 11
    //   697: aload 9
    //   699: ldc_w 1343
    //   702: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   705: putfield 594	auvf:jdField_e_of_type_Int	I
    //   708: aload 11
    //   710: aload 9
    //   712: ldc_w 1345
    //   715: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   718: putfield 596	auvf:jdField_f_of_type_Int	I
    //   721: aload 11
    //   723: aload 9
    //   725: ldc_w 1347
    //   728: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: putfield 598	auvf:jdField_g_of_type_Int	I
    //   734: aload 9
    //   736: ldc_w 1349
    //   739: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   742: istore 4
    //   744: aload 11
    //   746: aload 9
    //   748: ldc_w 1351
    //   751: invokevirtual 1283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   754: putfield 600	auvf:jdField_l_of_type_Int	I
    //   757: iload 4
    //   759: iconst_1
    //   760: if_icmpne +230 -> 990
    //   763: iconst_1
    //   764: istore_1
    //   765: aload 11
    //   767: iload_1
    //   768: putfield 602	auvf:jdField_a_of_type_Boolean	Z
    //   771: aload 10
    //   773: aload 11
    //   775: invokevirtual 1354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   778: pop
    //   779: iload_2
    //   780: iconst_1
    //   781: iadd
    //   782: istore_2
    //   783: goto -488 -> 295
    //   786: new 527	auvf
    //   789: dup
    //   790: invokespecial 528	auvf:<init>	()V
    //   793: astore 6
    //   795: aload 6
    //   797: ldc2_w 1355
    //   800: putfield 531	auvf:jdField_o_of_type_Long	J
    //   803: aload 6
    //   805: iconst_1
    //   806: putfield 602	auvf:jdField_a_of_type_Boolean	Z
    //   809: aload 10
    //   811: aload 6
    //   813: invokevirtual 1354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   816: pop
    //   817: new 527	auvf
    //   820: dup
    //   821: invokespecial 528	auvf:<init>	()V
    //   824: astore 6
    //   826: aload 6
    //   828: ldc2_w 1357
    //   831: putfield 531	auvf:jdField_o_of_type_Long	J
    //   834: aload 6
    //   836: iconst_1
    //   837: putfield 602	auvf:jdField_a_of_type_Boolean	Z
    //   840: aload 10
    //   842: aload 6
    //   844: invokevirtual 1354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   847: pop
    //   848: new 527	auvf
    //   851: dup
    //   852: invokespecial 528	auvf:<init>	()V
    //   855: astore 6
    //   857: aload 6
    //   859: ldc2_w 1359
    //   862: putfield 531	auvf:jdField_o_of_type_Long	J
    //   865: aload 6
    //   867: iconst_1
    //   868: putfield 602	auvf:jdField_a_of_type_Boolean	Z
    //   871: aload 10
    //   873: aload 6
    //   875: invokevirtual 1354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   878: pop
    //   879: aload_0
    //   880: ifnull +7 -> 887
    //   883: aload_0
    //   884: invokevirtual 1240	java/io/InputStream:close	()V
    //   887: aload 7
    //   889: ifnull -686 -> 203
    //   892: aload 7
    //   894: invokevirtual 1241	java/io/ByteArrayOutputStream:close	()V
    //   897: goto -694 -> 203
    //   900: astore_0
    //   901: aload_0
    //   902: invokevirtual 1361	java/io/IOException:printStackTrace	()V
    //   905: goto -702 -> 203
    //   908: astore_0
    //   909: aload_0
    //   910: invokevirtual 1361	java/io/IOException:printStackTrace	()V
    //   913: goto -710 -> 203
    //   916: astore 6
    //   918: aconst_null
    //   919: astore 7
    //   921: aconst_null
    //   922: astore_0
    //   923: aload_0
    //   924: ifnull +7 -> 931
    //   927: aload_0
    //   928: invokevirtual 1240	java/io/InputStream:close	()V
    //   931: aload 7
    //   933: ifnull +8 -> 941
    //   936: aload 7
    //   938: invokevirtual 1241	java/io/ByteArrayOutputStream:close	()V
    //   941: aload 6
    //   943: athrow
    //   944: astore_0
    //   945: aload_0
    //   946: invokevirtual 1361	java/io/IOException:printStackTrace	()V
    //   949: goto -8 -> 941
    //   952: astore 6
    //   954: aconst_null
    //   955: astore 7
    //   957: goto -34 -> 923
    //   960: astore 6
    //   962: goto -39 -> 923
    //   965: astore 8
    //   967: aload 6
    //   969: astore 7
    //   971: aload 8
    //   973: astore 6
    //   975: goto -52 -> 923
    //   978: astore 7
    //   980: aconst_null
    //   981: astore_0
    //   982: goto -802 -> 180
    //   985: astore 7
    //   987: goto -807 -> 180
    //   990: iconst_0
    //   991: istore_1
    //   992: goto -227 -> 765
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	paramQQAppInterface	QQAppInterface
    //   0	995	1	paramBoolean	boolean
    //   152	631	2	i	int
    //   292	6	3	j	int
    //   742	19	4	k	int
    //   46	66	5	bool	boolean
    //   1	873	6	localObject1	Object
    //   916	26	6	localObject2	Object
    //   952	1	6	localObject3	Object
    //   960	8	6	localObject4	Object
    //   973	1	6	localObject5	Object
    //   39	931	7	localObject6	Object
    //   978	1	7	localThrowable1	java.lang.Throwable
    //   985	1	7	localThrowable2	java.lang.Throwable
    //   28	176	8	str	String
    //   965	7	8	localObject7	Object
    //   170	7	9	localThrowable3	java.lang.Throwable
    //   306	441	9	localJSONObject	JSONObject
    //   109	763	10	localArrayList	ArrayList
    //   315	459	11	localauvf	auvf
    // Exception table:
    //   from	to	target	type
    //   135	142	170	java/lang/Throwable
    //   142	153	170	java/lang/Throwable
    //   158	167	170	java/lang/Throwable
    //   230	293	170	java/lang/Throwable
    //   300	757	170	java/lang/Throwable
    //   765	779	170	java/lang/Throwable
    //   786	879	170	java/lang/Throwable
    //   883	887	900	java/io/IOException
    //   892	897	900	java/io/IOException
    //   189	193	908	java/io/IOException
    //   198	203	908	java/io/IOException
    //   116	126	916	finally
    //   216	227	916	finally
    //   927	931	944	java/io/IOException
    //   936	941	944	java/io/IOException
    //   126	135	952	finally
    //   135	142	960	finally
    //   142	153	960	finally
    //   158	167	960	finally
    //   230	293	960	finally
    //   300	757	960	finally
    //   765	779	960	finally
    //   786	879	960	finally
    //   180	185	965	finally
    //   116	126	978	java/lang/Throwable
    //   216	227	978	java/lang/Throwable
    //   126	135	985	java/lang/Throwable
  }
  
  public static ArrayList<auvf> a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getProfileTemplateList isReturnHidden=" + paramBoolean1 + ",returnExpire=" + paramBoolean2);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramQQAppInterface, false);
    if (!((ArrayList)localObject).isEmpty())
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        auvf localauvf = (auvf)((Iterator)localObject).next();
        if ((paramBoolean1) || (!localauvf.jdField_a_of_type_Boolean)) {
          if (paramBoolean2) {
            localArrayList.add(localauvf);
          } else if (a(paramQQAppInterface, localauvf)) {
            localArrayList.add(localauvf);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<String> a(Context paramContext, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList(3);
    if ((paramContext == null) || (paramCard == null)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
    }
    int i = paramCard.shGender;
    if (i == 0) {
      localArrayList.add(paramContext.getString(2131694074));
    }
    for (;;)
    {
      paramContext = d(paramCard.strSchool);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(paramContext);
      }
      paramContext = d(paramCard.strCompany);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(paramContext);
      }
      if (localArrayList.size() >= 4) {
        break;
      }
      paramContext = d(paramCard.strCountry);
      String str1 = d(paramCard.strProvince);
      String str2 = d(paramCard.strCity);
      StringBuilder localStringBuilder = new StringBuilder(50);
      if ((!TextUtils.isEmpty(paramContext)) && (!ajya.a(2131708463).equals(paramContext))) {
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str1))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str1);
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str2);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(localStringBuilder.toString());
      }
      if (localArrayList.size() >= 4) {
        break;
      }
      paramContext = d(bazx.c(paramCard.constellation));
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localArrayList.add(paramContext);
      return localArrayList;
      if (i == 1) {
        localArrayList.add(paramContext.getString(2131692394));
      }
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = null;
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    a(paramActivity, paramView, paramString, false, false);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("curType", paramInt);
    paramView = xpu.a(paramView);
    localIntent.putExtra("is_from_face2face_add_friend", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramView, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = xpu.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramActivity, paramView, paramString, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", xpu.a(paramView));
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_hide_actionsheet", paramBoolean1);
    localIntent.putExtra("is_hide_footbar", paramBoolean2);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne)
  {
    a(paramActivity, paramBusinessCard, paramAllInOne, false);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    a(paramActivity, paramBusinessCard, paramAllInOne, paramBoolean, null);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = new Intent(paramActivity, BusinessCardEditActivity.class);
      if (paramAllInOne.jdField_a_of_type_Int != 0) {
        break label166;
      }
      localIntent.putExtra("mode_type", 3);
      localIntent.putExtra("source_activity", 3);
    }
    for (;;)
    {
      localIntent.putExtra("cur_card_body", paramBusinessCard);
      localIntent.putExtra("is_edit_mode", true);
      localIntent.putExtra("finish_immedia", true);
      Object localObject = paramAllInOne.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label207;
      }
      paramBusinessCard = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBusinessCard.add(((ProfileActivity.CardContactInfo)((Iterator)localObject).next()).jdField_c_of_type_JavaLangString);
      }
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", BusinessCardEditActivity.class.getName());
      break;
      label166:
      localIntent.putExtra("mode_type", 2);
      localIntent.putExtra("source_activity", 1);
      paramBusinessCard.bindUin = paramAllInOne.jdField_a_of_type_JavaLangString;
    }
    localIntent.putExtra("bind_phone_num", paramBusinessCard);
    label207:
    if (paramBoolean)
    {
      localIntent.putExtra("notify_plugin", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivity(localIntent);
    if (paramAllInOne.jdField_a_of_type_Int == 0)
    {
      axqy.b(null, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(null, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    paramString4 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("isShowAd", false);
    paramString4.putExtra("hide_more_button", true);
    paramString4.putExtra("has_red_dot", paramBoolean2);
    paramString4.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = bbqd.a(paramActivity, "card", paramString2);
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString2 + "&" + paramString3;
    }
    paramString1 = paramString1 + "&entryId=" + paramInt2 + "&isCache=" + paramInt1 + "&tabId=" + paramInt3;
    if ((paramActivity instanceof FriendProfileCardActivity))
    {
      if (paramInt2 != 0) {
        break label208;
      }
      paramString4.putExtra("individuation_url_type", 40202);
    }
    for (;;)
    {
      paramString4.putExtra("url", paramString1);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString1, -1L, paramString4, paramBoolean1, 1025);
      return;
      label208:
      if (paramInt2 == 1) {
        paramString4.putExtra("individuation_url_type", 40203);
      } else if (paramInt2 == 3) {
        paramString4.putExtra("individuation_url_type", 40204);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString1);
      Card localCard = a((QQAppInterface)localObject, paramString2);
      paramString1 = new ProfileActivity.AllInOne(paramString2, 9);
      paramString1.jdField_h_of_type_JavaLangString = bbcz.a((QQAppInterface)localObject, paramString2);
      paramString1.jdField_f_of_type_JavaLangString = paramString2;
      paramString1.jdField_e_of_type_Int = paramInt;
      paramString1.jdField_g_of_type_Int = 2;
      paramString1.jdField_h_of_type_Int = 123;
      paramString2 = new auuy();
      paramString2.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
      paramString2.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = paramString1;
      paramString2 = amev.a((QQAppInterface)localObject, paramString2);
      if (paramString2.mobilesNum.size() >= 3)
      {
        bcql.a(paramActivity, 0, 2131695059, 0).a();
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("add_phone_num", paramString3);
      a(paramActivity, paramString2, paramString1, false, (Bundle)localObject);
      return;
    }
    catch (AccountNotMatchException paramActivity)
    {
      QLog.e("openBusinessCardToAddingPhone", 1, paramActivity, new Object[0]);
    }
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long < 1500L) {
      return;
    }
    jdField_b_of_type_Long = l;
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/signature/msglist?_wv=3&_wwv=128");
    paramContext.startActivity(localIntent);
    paramContext = (atxd)BaseApplicationImpl.getApplication().getRuntime().getManager(160);
    paramContext.a(10019, false);
    paramContext.a(10020, false);
    paramContext.a(10022, false);
    paramContext.a(10021, false);
    paramContext.a(10023, false);
    paramContext.a(10024, false);
    paramContext.a(10025, false);
    paramContext.a(10026, false);
    QLog.d("ProfileCardUtil", 1, "jumpProfileBubbleMsgList");
  }
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = String.format(bbqd.a("rareCard"), new Object[] { Long.valueOf(paramLong) });
    }
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramTextView == null) {
      return;
    }
    String str = paramTextView.getText().toString();
    aush localaush = new aush(str);
    if ((paramString1 != null) && (str.contains(paramString1)))
    {
      localaush.a("复制QQ号", paramString1);
      if ((paramString2 != null) && (paramString2.length() > 0) && (str.length() > paramString1.length() + 2)) {
        localaush.a(ajya.a(2131708494), paramString2);
      }
    }
    for (;;)
    {
      paramTextView.setTag(new ausw(89, localaush));
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
      paramTextView.setOnLongClickListener(paramOnLongClickListener);
      return;
      if ((paramString2 != null) && (str.contains(paramString2))) {
        localaush.a(ajya.a(2131708460), paramString2);
      } else {
        localaush.a(ajya.a(2131708445), str);
      }
    }
  }
  
  public static void a(auuy paramauuy, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramauuy == null) || (paramQQAppInterface == null) || (paramActivity == null)) {}
    do
    {
      return;
      paramauuy = a(paramauuy, paramQQAppInterface, paramActivity);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "openDetails url: %s", new Object[] { paramauuy }));
      }
    } while (TextUtils.isEmpty(paramauuy));
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramauuy);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
    paramActivity.startActivity(localIntent);
  }
  
  @Deprecated
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    xkn.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, "", new Bundle());
  }
  
  @Deprecated
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    xkn.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, paramString3, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ProfileCardUtil.4(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0L, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, "", 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, int paramInt, String paramString3, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, String paramString5, long paramLong4)
  {
    paramQQAppInterface.a(new ProfileCardUtil.3(paramInt, paramString3, paramString4, paramFloat1, paramFloat2, paramFloat3, paramQQAppInterface, paramLong4, paramLong1, paramLong2, paramString1, paramLong3, paramString2, paramString5));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, String paramString3, long paramLong4)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, paramString3, paramLong4);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      baxo localbaxo = ((DynamicAvatarView)paramView).a;
      if ((localbaxo != null) && (localbaxo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localbaxo.jdField_c_of_type_JavaLangString)))
      {
        b(paramActivity, paramView, localbaxo.jdField_c_of_type_JavaLangString);
        paramInt1 = 1;
        if (paramInt2 == 0) {
          if (paramInt1 == 0) {
            break label159;
          }
        }
      }
    }
    label159:
    for (paramActivity = "1";; paramActivity = "0")
    {
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramActivity, "", "", "");
      return;
      if (paramInt2 == 1)
      {
        a(paramActivity, paramView, paramString, paramInt1);
        paramInt1 = 0;
        break;
      }
      a(paramActivity, paramView, paramString, true, true);
      for (;;)
      {
        paramInt1 = 0;
        break;
        if (paramInt2 == 1)
        {
          a(paramActivity, paramView, paramString, paramInt1);
          paramInt1 = 0;
          break;
        }
        a(paramActivity, paramView, paramString, true, true);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, a(paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big_fhd", null, b(paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i < arrayOfFile.length)
        {
          String str = arrayOfFile[i].getName();
          if ((str.startsWith(String.valueOf(paramString1))) && (!str.endsWith(paramString2)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramString1) + "_" + str;
            bbdx.a(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((paramCard != null) && (paramQQAppInterface != null)) {
      paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).edit().putBoolean("new_school_guide_init_" + paramCard.uin, false).commit();
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      jdField_a_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    jdField_b_of_type_JavaLangString = paramString;
    jdField_a_of_type_Boolean = true;
  }
  
  public static final void a(String paramString1, int paramInt, String paramString2)
  {
    if (jdField_a_of_type_JavaLangStringBuilder == null) {
      jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangStringBuilder.append(paramString1).append(", reason = [").append(paramString2).append("], code = [").append(paramInt).append("]");
      QLog.i("UPLOAD_AVATAR_FAIL", 1, jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      axrn.a(BaseApplication.getContext()).a(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!aypb.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == -9527) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(aypb.jdField_k_of_type_JavaLangString, paramString4);
        label316:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label379;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      label379:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, Activity paramActivity)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:activity:");
        if (paramActivity != null) {
          break label53;
        }
      }
      for (;;)
      {
        QLog.i("forwardtofriend", 2, bool);
        return;
        label53:
        bool = false;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_thumb", paramString);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    aqbe.a(paramActivity, paramString, 21);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:app:");
        if (paramQQAppInterface != null) {
          break label79;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(",activity:");
        if (paramActivity != null) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.i("forwardQzone", 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    bgyw localbgyw = bgyw.a();
    localbgyw.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localbgyw.jdField_b_of_type_JavaLangString = bbcz.h(paramQQAppInterface, localbgyw.jdField_a_of_type_JavaLangString);
    bgyp.a(paramActivity, localbgyw, paramString, paramActivity.getString(2131692226), "", -1);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openAddPersonalityLabel");
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", auta.jdField_c_of_type_JavaLangString);
    paramString.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
    paramString.putExtra("fromProfile", paramBoolean);
    paramActivity.startActivity(paramString);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = bbea.a(paramArrayOfByte);
      String str = bbea.a(paramArrayOfByte);
      ThreadManager.post(new ProfileCardUtil.1(str, c(paramArrayOfByte)), 8, null, false);
      b(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = a(paramContext, paramString);
    boolean bool1;
    try
    {
      paramContext = new File(paramContext);
      if ((paramContext.exists()) && (paramContext.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
        return false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(auuw paramauuw)
  {
    return paramauuw.jdField_a_of_type_Int == 160;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = a(paramQQAppInterface, -1L);
    if (localObject != null)
    {
      paramQQAppInterface = new File((String)localObject);
      localObject = new File((String)localObject + File.separator + "config_black.json");
      bool1 = bool2;
      if (paramQQAppInterface.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common dir exists=" + paramQQAppInterface.isDirectory() + " templateConfig exists= " + ((File)localObject).exists());
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, auvf paramauvf)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (((paramauvf.jdField_j_of_type_Int > 100) && (l < paramauvf.jdField_j_of_type_Int)) || ((paramauvf.jdField_k_of_type_Int > 100) && (l > paramauvf.jdField_k_of_type_Int)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ProfileCardUtil", 2, "filterTemplate->sytle:" + paramauvf.jdField_o_of_type_Long + ",beginTime:" + paramauvf.jdField_j_of_type_Int + ",endTime:" + paramauvf.jdField_k_of_type_Int);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    if (bbxj.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) >= 3) {}
    long l;
    do
    {
      return false;
      l = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0).getLong(paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    boolean bool = false;
    if (a(paramQQAppInterface, paramString, paramIntent, false).jdField_a_of_type_Int == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCard != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramCard.isNewSchoolStatusWriteForGuide())
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramCard.strSchool)) {
            bool1 = paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).getBoolean("new_school_guide_init_" + paramCard.uin, true);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "isNeedGuideForNewSchoolData " + bool1);
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean a(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(2));
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = bbea.a(paramString);
    }
    return arrayOfByte;
  }
  
  public static int b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (int)((Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - 10) * 0.8F + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    return (int)(0.56338F * a(paramContext));
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static long b()
  {
    try
    {
      if (bbbr.a()) {
        return bbbr.a(new File(ajsd.aV));
      }
      long l = bbbr.a(new File(Environment.getRootDirectory().getPath()));
      return l;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "8.3.0";
  }
  
  public static String b(Context paramContext, auuy paramauuy)
  {
    int j = -1;
    String str = "";
    Card localCard = paramauuy.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramauuy.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1))
    {
      i = paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
      if (i != 0) {
        break label150;
      }
      str = paramContext.getString(2131694074);
    }
    for (;;)
    {
      return str + a(paramContext, paramauuy);
      if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
      {
        i = localCard.shGender;
        break;
      }
      i = j;
      if (localContactCard == null) {
        break;
      }
      if (localContactCard.bSex != 0)
      {
        i = j;
        if (localContactCard.bSex != 1) {
          break;
        }
      }
      i = localContactCard.bSex;
      break;
      label150:
      if (i == 1) {
        str = paramContext.getString(2131692394);
      }
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(ajti.jdField_a_of_type_JavaLangString).append("FHDAvatar").append("/").append(paramString).append(".jpg");
    return bbvj.a(localStringBuilder.toString());
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardUtil", 2, "clear drawables from doOnDestroy.");
    }
    if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((auvf)localIterator.next()).a();
      }
    }
  }
  
  public static void b(Activity paramActivity, View paramView, String paramString)
  {
    Object localObject = new PicInfo();
    ((PicInfo)localObject).jdField_d_of_type_JavaLangString = paramString;
    paramString = new ArrayList(1);
    paramString.add(localObject);
    localObject = new Intent(paramActivity, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", 0);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramString);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", xpu.a(paramView));
    ((Intent)localObject).addFlags(536870912);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void b(@NonNull QQAppInterface paramQQAppInterface)
  {
    bbxj.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", bbxj.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) + 1);
  }
  
  public static void b(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0);
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin() + "_" + paramString;
    localSharedPreferences.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).apply();
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:app:");
        if (paramQQAppInterface != null) {
          break label79;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(",activity:");
        if (paramActivity != null) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.i("forwardFavorite", 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    try
    {
      bgpu.b(paramString).a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("forwardFavorite", 2, "", paramString);
      }
      bcql.a(paramActivity, paramActivity.getResources().getString(2131692902), 0).a();
    }
  }
  
  public static boolean b()
  {
    Locale localLocale = Locale.getDefault();
    String str = localLocale.getCountry();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!TextUtils.equals(str, arrayOfString[i])) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("TRUETe", 4, String.format(localLocale, "isEuropeAndAmerica country:%s, local: %s", new Object[] { str, localLocale }));
      }
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = b(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, "clearFHDAvatar " + paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean b(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(1));
  }
  
  public static int c(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static final int c(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ajti.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_cardbg.tmp");
    return bbvj.a(localStringBuilder.toString());
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      if (bbbr.a()) {
        return ajsd.cm;
      }
      String str = paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, "getBGDir error, e = " + localException);
    }
    return paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  @NotNull
  public static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (atxd)paramQQAppInterface.getManager(160);
    paramQQAppInterface.a(10019, false);
    paramQQAppInterface.a(10020, false);
    paramQQAppInterface.a(10022, false);
    paramQQAppInterface.a(10021, false);
    paramQQAppInterface.a(10023, false);
    paramQQAppInterface.a(10024, false);
    paramQQAppInterface.a(10025, false);
    paramQQAppInterface.a(10026, false);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ProfileCardUtil.2(paramString));
  }
  
  public static boolean c(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(3));
  }
  
  public static int d(Activity paramActivity)
  {
    return c(paramActivity) * 3 / 4;
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public static boolean d(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!b(paramArrayList)) && (!c(paramArrayList)) && (!a(paramArrayList))) {
      return false;
    }
    return true;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
  
  public static boolean e(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!b(paramArrayList)) && (!c(paramArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbac
 * JD-Core Version:    0.7.0.1
 */