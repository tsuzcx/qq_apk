package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokeItemHelper
{
  public static int a = 0;
  public static String a = "PokeItemHelper";
  static ArrayList<android.graphics.Bitmap> jdField_a_of_type_JavaUtilArrayList;
  private static BitSet jdField_a_of_type_JavaUtilBitSet;
  public static final Vector<Integer> a;
  public static boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static android.graphics.Bitmap[] a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b = 0;
  public static final String b;
  public static final Vector<Integer> b;
  public static volatile boolean b = false;
  public static android.graphics.Bitmap[] b;
  public static int c = 0;
  public static final String c;
  public static final Vector<Integer> c;
  public static volatile boolean c = false;
  public static android.graphics.Bitmap[] c;
  public static int d = 0;
  public static final String d;
  public static final Vector<Integer> d;
  public static boolean d = false;
  public static android.graphics.Bitmap[] d;
  public static int e = 0;
  public static final String e;
  public static volatile boolean e = false;
  public static int f = 0;
  public static final String f;
  private static boolean f = false;
  public static int g;
  public static String g;
  private static boolean g;
  public static int h;
  public static String h;
  private static boolean h;
  public static int i;
  public static String i;
  private static boolean i;
  public static int j;
  public static String j;
  private static boolean j;
  public static int k;
  private static String jdField_k_of_type_JavaLangString;
  private static boolean jdField_k_of_type_Boolean;
  public static int l;
  private static String jdField_l_of_type_JavaLangString;
  private static boolean jdField_l_of_type_Boolean;
  public static int m;
  private static String jdField_m_of_type_JavaLangString;
  private static boolean jdField_m_of_type_Boolean;
  public static int n;
  private static String n;
  public static int o;
  private static String o;
  private static int jdField_p_of_type_Int = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
  private static String jdField_p_of_type_JavaLangString;
  private static int q;
  private static int r;
  private static int s;
  private static int t;
  private static int u;
  private static int v;
  
  static
  {
    jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("/Tencent/MobileQQ/");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    jdField_d_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(jdField_c_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append(".vaspoke/");
    jdField_e_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append("vasPokeMarket.json");
    jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
    jdField_c_of_type_JavaUtilVector = new Vector();
    jdField_d_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Boolean = false;
    jdField_l_of_type_JavaLangString = "";
    jdField_m_of_type_JavaLangString = "";
    jdField_n_of_type_JavaLangString = "";
    jdField_o_of_type_JavaLangString = "";
    jdField_p_of_type_JavaLangString = "";
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    jdField_i_of_type_Boolean = false;
    jdField_j_of_type_Boolean = false;
    jdField_k_of_type_Boolean = false;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = 10;
    jdField_e_of_type_Int = 60;
    jdField_f_of_type_Int = -1;
    jdField_g_of_type_Int = -1;
    jdField_h_of_type_Int = 10;
    jdField_i_of_type_Int = 60;
    jdField_j_of_type_Int = 0;
    jdField_k_of_type_Int = 0;
    jdField_l_of_type_Int = 0;
    jdField_m_of_type_Int = 0;
    jdField_n_of_type_Int = 50;
    jdField_l_of_type_Boolean = false;
    jdField_m_of_type_Boolean = false;
    u = 0;
    v = 0;
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_a_of_type_JavaUtilBitSet = null;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "chuo_icon", "bixin_icon", "zan_icon", "xinsui_icon", "666_icon", "dazhao_icon", "chuo_motion", "bixin_motion", "zan_motion", "xinsui_motion", "666_motion", "dazhao_motion" };
    jdField_a_of_type_ArrayOfInt = new int[] { 22, 22, 22, 22, 22, 22, 35, 99, 25, 60, 0, 0 };
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_b_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_c_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_d_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_o_of_type_Int = 0;
    jdField_d_of_type_Boolean = true;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 1);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramQQAppInterface.getAccount();
    if ((!jdField_i_of_type_Boolean) || (!jdField_n_of_type_JavaLangString.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("poke_bar_config_version");
      if (paramQQAppInterface.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("aio_unique_poke_show");
        q = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("aio_unique_poke_type");
        r = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
      }
      jdField_n_of_type_JavaLangString = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("uniquepoke show %d type %d", new Object[] { Integer.valueOf(q), Integer.valueOf(r) }));
    }
    jdField_g_of_type_Boolean = true;
    if (paramInt == 1) {
      return q;
    }
    if (paramInt == 2) {
      return r;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    return new JSONObject(paramString).getInt("comboNum");
  }
  
  public static android.graphics.Bitmap a(android.graphics.Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject, true);
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get pokeFriendPokeImage oom");
        localStringBuilder.append(paramBitmap);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramBitmap = null;
    }
    if ((QLog.isColorLevel()) && (paramBitmap != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertBmp w=");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      Log.d("test", ((StringBuilder)localObject).toString());
    }
    return paramBitmap;
  }
  
  public static Drawable a(int paramInt, boolean paramBoolean, Resources paramResources)
  {
    int i1;
    if (paramInt >= 0)
    {
      i1 = paramInt;
      if (paramInt <= 6) {}
    }
    else
    {
      i1 = 1;
    }
    int i2 = i1;
    if (i1 == 0) {
      i2 = 1;
    }
    android.graphics.Bitmap[] arrayOfBitmap1;
    android.graphics.Bitmap[] arrayOfBitmap2;
    switch (i2)
    {
    case 0: 
    case 1: 
    default: 
      paramInt = 2130844826;
      i1 = 2130844827;
      break;
    case 6: 
      paramInt = 2130844767;
      i1 = 2130844768;
      break;
    case 5: 
      if (paramBoolean)
      {
        arrayOfBitmap1 = jdField_c_of_type_ArrayOfAndroidGraphicsBitmap;
        arrayOfBitmap2 = jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
        paramInt = i2 - 1;
        a(arrayOfBitmap1, arrayOfBitmap2, paramInt, paramResources, 2130844774, 2130844775);
        return BitmapUtil.a(paramResources, jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[paramInt], jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt]);
      }
      arrayOfBitmap1 = jdField_d_of_type_ArrayOfAndroidGraphicsBitmap;
      arrayOfBitmap2 = jdField_b_of_type_ArrayOfAndroidGraphicsBitmap;
      paramInt = i2 - 1;
      a(arrayOfBitmap1, arrayOfBitmap2, paramInt, paramResources, 2130844772, 2130844773);
      return BitmapUtil.a(paramResources, jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[paramInt], jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[paramInt]);
    case 4: 
      paramInt = 2130844770;
      i1 = 2130844771;
      break;
    case 3: 
      paramInt = 2130844749;
      i1 = 2130844750;
      break;
    case 2: 
      paramInt = 2130844765;
      i1 = 2130844766;
    }
    i2 -= 1;
    a(jdField_c_of_type_ArrayOfAndroidGraphicsBitmap, jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, i2, paramResources, paramInt, i1);
    if (!paramBoolean)
    {
      arrayOfBitmap1 = jdField_c_of_type_ArrayOfAndroidGraphicsBitmap;
      if (arrayOfBitmap1[i2] != null)
      {
        arrayOfBitmap2 = jdField_d_of_type_ArrayOfAndroidGraphicsBitmap;
        if (arrayOfBitmap2[i2] == null) {
          arrayOfBitmap2[i2] = a(arrayOfBitmap1[i2]);
        }
      }
      arrayOfBitmap1 = jdField_b_of_type_ArrayOfAndroidGraphicsBitmap;
      if ((arrayOfBitmap1[i2] != null) && (arrayOfBitmap1[i2] == null)) {
        arrayOfBitmap1[i2] = a(arrayOfBitmap1[i2]);
      }
    }
    if (paramBoolean) {
      return BitmapUtil.a(paramResources, jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[i2], jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
    }
    return BitmapUtil.a(paramResources, jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[i2], jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
  }
  
  public static Drawable a(android.graphics.Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject, true);
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get pokeFriendPokeImage oom");
        localStringBuilder.append(paramBitmap);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramBitmap = null;
    }
    if ((QLog.isColorLevel()) && (paramBitmap != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertBmp w=");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      Log.d("test", ((StringBuilder)localObject).toString());
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    ((BitmapDrawable)paramBitmap).setTargetDensity(jdField_p_of_type_Int);
    return paramBitmap;
  }
  
  public static String a()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_POKE);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!jdField_h_of_type_Boolean) || (!jdField_m_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("poke_bar_config_version");
        if (paramQQAppInterface.contains(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_poke_panel_config");
          jdField_k_of_type_JavaLangString = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          if (jdField_k_of_type_JavaLangString == null) {
            jdField_k_of_type_JavaLangString = "";
          }
        }
        jdField_m_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("PokePanelPlaceInfo:");
      paramQQAppInterface.append(jdField_k_of_type_JavaLangString);
      QLog.d("pokeMsg", 2, paramQQAppInterface.toString());
    }
    jdField_h_of_type_Boolean = true;
    return jdField_k_of_type_JavaLangString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface);
    if (paramInt != 5)
    {
      if (paramInt != 6)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8) {
            return null;
          }
          return jdField_j_of_type_JavaLangString;
        }
        return jdField_i_of_type_JavaLangString;
      }
      return jdField_h_of_type_JavaLangString;
    }
    return jdField_g_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = new JSONObject(paramString);
    if (paramString.getInt("isShowPanel") == 1)
    {
      paramString = paramString.getJSONArray("panel_source");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        localStringBuilder.append(paramString.getInt(i1));
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<com.tencent.mobileqq.activity.aio.PokePanel.PokeData> a(AppRuntime paramAppRuntime, CallBacker paramCallBacker)
  {
    // Byte code:
    //   0: new 442	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 443	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: new 75	java/io/File
    //   12: dup
    //   13: getstatic 113	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 444	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 9
    //   21: aload 9
    //   23: invokevirtual 447	java/io/File:exists	()Z
    //   26: ifeq +713 -> 739
    //   29: new 308	org/json/JSONObject
    //   32: dup
    //   33: aload 9
    //   35: invokestatic 453	com/tencent/mobileqq/utils/FileUtils:readFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   38: invokespecial 311	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: ldc_w 455
    //   48: iconst_1
    //   49: invokevirtual 459	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   52: ifne +22 -> 74
    //   55: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +689 -> 747
    //   61: getstatic 339	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: iconst_2
    //   65: ldc_w 461
    //   68: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload 8
    //   73: areturn
    //   74: aload 9
    //   76: ldc_w 463
    //   79: invokevirtual 466	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 9
    //   84: iconst_0
    //   85: istore_2
    //   86: iconst_0
    //   87: istore_3
    //   88: iload_3
    //   89: aload 9
    //   91: invokevirtual 432	org/json/JSONArray:length	()I
    //   94: if_icmpge +650 -> 744
    //   97: aload 9
    //   99: iload_3
    //   100: invokevirtual 470	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   103: checkcast 308	org/json/JSONObject
    //   106: astore 10
    //   108: aload 10
    //   110: ldc_w 472
    //   113: invokevirtual 475	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 12
    //   118: aload 10
    //   120: ldc_w 477
    //   123: invokevirtual 475	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 13
    //   128: aload 10
    //   130: ldc_w 479
    //   133: iload_2
    //   134: invokevirtual 482	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   137: istore 4
    //   139: aload 10
    //   141: ldc_w 484
    //   144: iload_2
    //   145: invokevirtual 482	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   148: istore 5
    //   150: aload 10
    //   152: ldc_w 486
    //   155: iload_2
    //   156: invokevirtual 482	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   159: istore 6
    //   161: aload 10
    //   163: ldc_w 488
    //   166: invokevirtual 475	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 11
    //   171: aload 11
    //   173: invokestatic 490	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;)Z
    //   176: ifne +54 -> 230
    //   179: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +521 -> 703
    //   185: getstatic 339	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: astore 10
    //   190: new 83	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   197: astore 12
    //   199: aload 12
    //   201: ldc_w 492
    //   204: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 12
    //   210: aload 11
    //   212: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 10
    //   218: iconst_2
    //   219: aload 12
    //   221: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: goto +476 -> 703
    //   230: iload 5
    //   232: iconst_1
    //   233: if_icmpne +470 -> 703
    //   236: iload 6
    //   238: iconst_1
    //   239: if_icmpne +464 -> 703
    //   242: new 494	com/tencent/mobileqq/activity/aio/PokePanel$PokeData
    //   245: dup
    //   246: invokespecial 495	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:<init>	()V
    //   249: astore 10
    //   251: aload 10
    //   253: bipush 126
    //   255: putfield 496	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_a_of_type_Int	I
    //   258: aload 10
    //   260: aload 12
    //   262: invokestatic 499	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   265: putfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   268: aload 10
    //   270: aload 13
    //   272: putfield 501	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: aload 10
    //   277: iload 4
    //   279: putfield 502	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_c_of_type_Int	I
    //   282: aload 10
    //   284: aload 13
    //   286: putfield 503	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   289: aload 10
    //   291: aload 11
    //   293: putfield 504	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   296: aload_0
    //   297: ldc_w 506
    //   300: ldc 130
    //   302: invokevirtual 512	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   305: checkcast 506	com/tencent/mobileqq/vas/updatesystem/api/IVasQuickUpdateService
    //   308: astore 11
    //   310: ldc_w 514
    //   313: aload 10
    //   315: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   318: invokestatic 517	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;I)Z
    //   321: istore 7
    //   323: iload 7
    //   325: ifne +64 -> 389
    //   328: aload 10
    //   330: iconst_1
    //   331: putfield 518	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_c_of_type_Boolean	Z
    //   334: new 83	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   341: astore 12
    //   343: aload 12
    //   345: ldc_w 520
    //   348: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 12
    //   354: aload 10
    //   356: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   359: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 11
    //   365: ldc2_w 521
    //   368: aload 12
    //   370: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: ldc_w 524
    //   376: invokeinterface 528 5 0
    //   381: aload 11
    //   383: aload_1
    //   384: invokeinterface 532 2 0
    //   389: invokestatic 538	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   392: astore 12
    //   394: aload 12
    //   396: invokestatic 541	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   399: invokevirtual 542	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   402: ldc_w 543
    //   405: invokevirtual 547	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   408: putfield 551	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   411: aload 12
    //   413: invokestatic 541	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   416: invokevirtual 542	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   419: ldc_w 543
    //   422: invokevirtual 547	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   425: putfield 554	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   428: aload 12
    //   430: iconst_1
    //   431: putfield 557	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   434: aload 12
    //   436: fconst_0
    //   437: putfield 561	com/tencent/image/URLDrawable$URLDrawableOptions:mGifRoundCorner	F
    //   440: new 83	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   447: astore 13
    //   449: aload 13
    //   451: getstatic 109	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   454: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 13
    //   460: aload 10
    //   462: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   465: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 13
    //   471: ldc_w 563
    //   474: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 13
    //   480: ldc_w 514
    //   483: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 10
    //   489: new 75	java/io/File
    //   492: dup
    //   493: aload 13
    //   495: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokespecial 444	java/io/File:<init>	(Ljava/lang/String;)V
    //   501: aload 12
    //   503: invokestatic 568	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   506: putfield 570	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   509: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +88 -> 600
    //   515: getstatic 339	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   518: astore 12
    //   520: new 83	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   527: astore 13
    //   529: aload 13
    //   531: ldc_w 572
    //   534: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 13
    //   540: aload 10
    //   542: getfield 501	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   545: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 13
    //   551: ldc_w 574
    //   554: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 13
    //   560: aload 10
    //   562: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   565: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 13
    //   571: ldc_w 576
    //   574: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 13
    //   580: aload 10
    //   582: getfield 502	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_c_of_type_Int	I
    //   585: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 12
    //   591: iconst_2
    //   592: aload 13
    //   594: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 578	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload 8
    //   602: aload 10
    //   604: invokevirtual 581	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   607: pop
    //   608: ldc_w 583
    //   611: aload 10
    //   613: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   616: invokestatic 517	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;I)Z
    //   619: ifne +73 -> 692
    //   622: aload 10
    //   624: iconst_1
    //   625: putfield 584	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Boolean	Z
    //   628: invokestatic 588	com/tencent/mobileqq/core/util/EmoticonPanelUtils:b	()Z
    //   631: ifeq +119 -> 750
    //   634: new 83	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   641: astore 12
    //   643: aload 12
    //   645: ldc_w 590
    //   648: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 12
    //   654: aload 10
    //   656: getfield 500	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Int	I
    //   659: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 11
    //   665: ldc2_w 521
    //   668: aload 12
    //   670: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: ldc_w 524
    //   676: invokeinterface 528 5 0
    //   681: aload 11
    //   683: aload_1
    //   684: invokeinterface 532 2 0
    //   689: goto +61 -> 750
    //   692: iconst_0
    //   693: istore_2
    //   694: aload 10
    //   696: iconst_0
    //   697: putfield 584	com/tencent/mobileqq/activity/aio/PokePanel$PokeData:jdField_b_of_type_Boolean	Z
    //   700: goto +3 -> 703
    //   703: iload_3
    //   704: iconst_1
    //   705: iadd
    //   706: istore_3
    //   707: goto -619 -> 88
    //   710: astore_0
    //   711: ldc 10
    //   713: iconst_1
    //   714: ldc_w 592
    //   717: aload_0
    //   718: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: aload 8
    //   723: areturn
    //   724: astore_0
    //   725: getstatic 339	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   728: iconst_1
    //   729: ldc_w 597
    //   732: aload_0
    //   733: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aload 8
    //   738: areturn
    //   739: aload_0
    //   740: aload_1
    //   741: invokestatic 600	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;)V
    //   744: aload 8
    //   746: areturn
    //   747: aload 8
    //   749: areturn
    //   750: iconst_0
    //   751: istore_2
    //   752: goto -49 -> 703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	755	0	paramAppRuntime	AppRuntime
    //   0	755	1	paramCallBacker	CallBacker
    //   85	667	2	i1	int
    //   87	620	3	i2	int
    //   137	141	4	i3	int
    //   148	86	5	i4	int
    //   159	81	6	i5	int
    //   321	3	7	bool	boolean
    //   7	741	8	localArrayList	ArrayList
    //   19	79	9	localObject1	Object
    //   106	589	10	localObject2	Object
    //   169	513	11	localObject3	Object
    //   116	553	12	localObject4	Object
    //   126	467	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	71	710	java/lang/Exception
    //   74	84	710	java/lang/Exception
    //   88	227	710	java/lang/Exception
    //   242	323	710	java/lang/Exception
    //   328	389	710	java/lang/Exception
    //   389	600	710	java/lang/Exception
    //   600	689	710	java/lang/Exception
    //   694	700	710	java/lang/Exception
    //   29	43	724	java/lang/Throwable
    //   43	71	724	java/lang/Throwable
    //   74	84	724	java/lang/Throwable
    //   88	227	724	java/lang/Throwable
    //   242	323	724	java/lang/Throwable
    //   328	389	724	java/lang/Throwable
    //   389	600	724	java/lang/Throwable
    //   600	689	724	java/lang/Throwable
    //   694	700	724	java/lang/Throwable
    //   711	721	724	java/lang/Throwable
  }
  
  public static void a()
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public static void a(int paramInt)
  {
    jdField_j_of_type_Boolean = true;
    s = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_i_of_type_Boolean = true;
    q = paramInt1;
    r = paramInt2;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jdField_g_of_type_Boolean = true;
    jdField_b_of_type_Int = paramInt1;
    jdField_c_of_type_Int = paramInt2;
    jdField_d_of_type_Int = paramInt3;
    jdField_e_of_type_Int = paramInt4;
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 126)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("/pressed.png");
      localObject = new File(((StringBuilder)localObject).toString());
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130847636);
      localURLDrawableOptions.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130847636);
      paramImageView.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      return;
    }
    paramImageView.setImageResource(paramInt2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!jdField_g_of_type_Boolean) || (!jdField_l_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("poke_bar_config_version");
        if (paramQQAppInterface.contains(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_bar_switch");
          jdField_b_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), jdField_f_of_type_Int);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_pad_switch");
          jdField_c_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), jdField_g_of_type_Int);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_poke_unittime");
          jdField_e_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), jdField_i_of_type_Int);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_poke_unitcount");
          jdField_d_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), jdField_h_of_type_Int);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_poke_entry_type");
          jdField_j_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_pe_view_type");
          jdField_k_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_emo_res_url");
          jdField_g_of_type_JavaLangString = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_emo_res_md5");
          jdField_h_of_type_JavaLangString = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_emo_surprice_indexs");
          jdField_i_of_type_JavaLangString = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("poke_emo_order");
          jdField_j_of_type_JavaLangString = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_pe_input_switch");
          jdField_l_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_pe_feed_back_switch");
          jdField_m_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("aio_pe_bubble_limit_count");
          jdField_n_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 50);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("pe_last_tab_index");
          jdField_a_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), -1);
        }
        else
        {
          jdField_b_of_type_Int = jdField_f_of_type_Int;
          jdField_c_of_type_Int = jdField_g_of_type_Int;
          jdField_j_of_type_Int = 0;
          jdField_k_of_type_Int = 0;
          jdField_l_of_type_Int = 0;
          jdField_m_of_type_Int = 0;
          jdField_n_of_type_Int = 50;
        }
        jdField_l_of_type_JavaLangString = str;
        jdField_g_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("pokeMsg", 2, String.format("getPokeSwitch, first init, bar switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d,peInputSwitch:%d,entryType:%d,viewType:%d", new Object[] { Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_c_of_type_Int), jdField_l_of_type_JavaLangString, Integer.valueOf(jdField_d_of_type_Int), Integer.valueOf(jdField_e_of_type_Int), Integer.valueOf(jdField_l_of_type_Int), Integer.valueOf(jdField_j_of_type_Int), Integer.valueOf(jdField_k_of_type_Int) }));
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    ((IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramInt1, paramString1, paramInt2, paramString2, paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4)
  {
    jdField_j_of_type_Int = paramInt1;
    jdField_k_of_type_Int = paramInt4;
    jdField_g_of_type_JavaLangString = paramString1;
    jdField_h_of_type_JavaLangString = paramString2;
    jdField_i_of_type_JavaLangString = paramString3;
    jdField_j_of_type_JavaLangString = paramString4;
    jdField_l_of_type_Int = paramInt2;
    jdField_n_of_type_Int = paramInt3;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramString1 = new StringBuilder();
      paramString1.append("setPokeEmoPanelConfig|entryType: ");
      paramString1.append(jdField_j_of_type_Int);
      paramString1.append(",peSurpriseIndexs: ");
      paramString1.append(jdField_i_of_type_JavaLangString);
      paramString1.append(",peOders: ");
      paramString1.append(paramString4);
      QLog.d(paramQQAppInterface, 2, paramString1.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = new PokeItemHelper.3(paramQQAppInterface, paramInt2, paramActivity, paramInt1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, HardCodeUtil.a(2131708317), paramString1, HardCodeUtil.a(2131708316), paramString2, paramQQAppInterface, paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.show();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, @Nullable GivingHeartItemBuilder.Holder paramHolder, int paramInt, String paramString)
  {
    if (a()) {
      ThreadManager.postImmediately(new PokeItemHelper.1(paramInt), null, true);
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(jdField_e_of_type_JavaLangString);
    paramQQAppInterface.append(paramInt);
    paramQQAppInterface.append("/");
    paramQQAppInterface.append(paramString);
    paramQQAppInterface.append("/");
    paramQQAppInterface = paramQQAppInterface.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramQQAppInterface);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".json");
    paramQQAppInterface = new File(((StringBuilder)localObject).toString());
    try
    {
      paramHolder = new PokeItemHelper.2(paramDiniFlyAnimationView, paramHolder, paramString);
      localObject = new Bundle();
      StringBuilder localStringBuilder = AIOUtils.a();
      localStringBuilder.append("lottie_vaspoke_");
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append(paramString);
      ((Bundle)localObject).putString("key", localStringBuilder.toString());
      localStringBuilder = AIOUtils.a();
      localStringBuilder.append(jdField_e_of_type_JavaLangString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localStringBuilder.append("/images/");
      ((Bundle)localObject).putString("path", localStringBuilder.toString());
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, new FileInputStream(paramQQAppInterface), paramDiniFlyAnimationView.getLottieDrawable(), paramHolder, (Bundle)localObject, GlobalImageCache.a);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramContext = new StringBuilder();
      paramContext.append("vaspoke, exception occur, id: ");
      paramContext.append(paramInt);
      paramContext.append(" ,category: ");
      paramContext.append(paramString);
      QLog.e("PokeItemHelper", 2, paramContext.toString(), paramQQAppInterface);
      return;
    }
    catch (FileNotFoundException paramQQAppInterface)
    {
      paramContext = new StringBuilder();
      paramContext.append("vaspoke, file not found. id: ");
      paramContext.append(paramInt);
      paramContext.append(" ,category: ");
      paramContext.append(paramString);
      QLog.e("PokeItemHelper", 2, paramContext.toString(), paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (!jdField_d_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadPERes resUrl ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",resMD5");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("PokeEmo", 2, ((StringBuilder)localObject).toString());
    }
    if (jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "other request is downloading ");
      }
      return;
    }
    if (jdField_o_of_type_Int > 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download exceed limit 5 ");
      }
      return;
    }
    jdField_c_of_type_Boolean = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("pe.zip");
    localObject = ((StringBuilder)localObject).toString();
    paramString2 = new PokeItemHelper.5(paramString3, paramString2);
    paramQQAppInterface = (IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    paramString3 = new HttpNetReq();
    paramString3.mCallback = paramString2;
    paramString3.mHttpMethod = 0;
    paramString3.mReqUrl = paramString1;
    paramString3.mOutPath = ((String)localObject);
    paramString3.mPrioty = 0;
    paramQQAppInterface.sendReq(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (u != 2)) || ((!paramBoolean) && (u != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_unique_clicked", true).commit();
      }
      if (paramBoolean)
      {
        u = 2;
        return;
      }
      u = 1;
    }
  }
  
  public static void a(String paramString)
  {
    jdField_h_of_type_Boolean = true;
    jdField_k_of_type_JavaLangString = paramString;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("pe_last_tab_index");
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.apply();
  }
  
  private static void a(String paramString1, String paramString2)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[res checking]");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool = paramString2.equals("dazhao_motion");
    int i1 = 0;
    if (bool)
    {
      jdField_a_of_type_JavaUtilBitSet.set(11, false);
      return;
    }
    if (paramString2.equals("666_motion"))
    {
      jdField_a_of_type_JavaUtilBitSet.set(10, false);
      return;
    }
    while (i1 < 12)
    {
      if (jdField_a_of_type_ArrayOfJavaLangString[i1].equals(paramString2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        localObject = new File(((StringBuilder)localObject).toString());
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          if ((localObject != null) && (localObject.length >= jdField_a_of_type_ArrayOfInt[i1]))
          {
            jdField_a_of_type_JavaUtilBitSet.set(i1, true);
            if (QLog.isColorLevel())
            {
              localObject = jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[res checked]");
              localStringBuilder.append(paramString2);
              QLog.d((String)localObject, 2, localStringBuilder.toString());
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, CallBacker paramCallBacker)
  {
    if (VasUpdateUtil.a(paramAppRuntime, 21L, "poke.effectList", jdField_f_of_type_JavaLangString, true, paramCallBacker) != null)
    {
      paramAppRuntime = (IEarlyDownloadService)paramAppRuntime.getRuntimeService(IEarlyDownloadService.class, "");
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (PokeResHandler)paramAppRuntime.getEarlyHandler("qq.android.poke.res_0625");
        if ((paramAppRuntime != null) && (!paramAppRuntime.g()))
        {
          paramAppRuntime.f();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "vas poke config exists, do not download, set ready");
          }
        }
      }
    }
  }
  
  public static void a(android.graphics.Bitmap[] paramArrayOfBitmap1, android.graphics.Bitmap[] paramArrayOfBitmap2, int paramInt1, Resources paramResources, int paramInt2, int paramInt3)
  {
    if (paramArrayOfBitmap1[paramInt1] == null)
    {
      android.graphics.Bitmap localBitmap = ImageUtil.a(paramResources, paramInt2);
      if (localBitmap != null) {
        paramArrayOfBitmap1[paramInt1] = localBitmap;
      }
    }
    if (paramArrayOfBitmap2[paramInt1] == null)
    {
      paramArrayOfBitmap1 = ImageUtil.a(paramResources, paramInt3);
      if (paramArrayOfBitmap1 != null) {
        paramArrayOfBitmap2[paramInt1] = paramArrayOfBitmap1;
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 7) && (!"0".equals(localObject[6]))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 6) {
        return false;
      }
      if (paramInt == 6)
      {
        if (jdField_a_of_type_JavaUtilBitSet == null)
        {
          jdField_a_of_type_JavaUtilBitSet = new BitSet(12);
          jdField_a_of_type_JavaUtilBitSet.clear();
          jdField_a_of_type_JavaUtilBitSet.set(6);
        }
        if (!jdField_a_of_type_JavaUtilBitSet.get(11))
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/poke/dazhao_motion/");
          Object localObject2 = ((StringBuilder)localObject1).toString();
          localObject1 = new File((String)localObject2, "dazhao_move.png");
          File localFile = new File((String)localObject2, "dazhao_motion");
          localObject2 = new File((String)localObject2, "dazhao2_motion");
          if ((((File)localObject1).exists()) && (localFile.exists()) && (localFile.isDirectory()) && (localFile.list().length == 34) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (((File)localObject2).list().length == 22))
          {
            jdField_a_of_type_JavaUtilBitSet.set(11, true);
            return true;
          }
          return false;
        }
        return true;
      }
      if (paramInt == 5) {
        return true;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return true;
        }
        return c(paramInt + 6 - 1);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(SharedPreferences paramSharedPreferences)
  {
    int i1 = u;
    if (i1 == 0)
    {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_unique_clicked", false))
      {
        u = 1;
        return false;
      }
      u = 2;
      return true;
    }
    if (i1 == 1) {
      return false;
    }
    return i1 == 2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return b(paramQQAppInterface) == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l1 = MessageCache.a();
    paramSessionInfo = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    boolean bool = false;
    if ((paramSessionInfo != null) && (paramSessionInfo.size() > 0))
    {
      int i2 = paramSessionInfo.size() - 1;
      int i1;
      for (int i3 = 0; i2 >= 0; i3 = i1)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.get(i2);
        if (!localMessageRecord.isSend())
        {
          i1 = i3;
        }
        else
        {
          if (l1 - localMessageRecord.time > b(paramQQAppInterface, 3)) {
            break;
          }
          i1 = i3;
          if ((localMessageRecord instanceof MessageForPoke))
          {
            i3 += 1;
            i1 = i3;
            if (i3 >= b(paramQQAppInterface, 2)) {
              break label146;
            }
          }
        }
        i2 -= 1;
      }
    }
    bool = true;
    label146:
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("isCanSendPoke, isCansend= ");
      paramSessionInfo.append(bool);
      QLog.d(paramQQAppInterface, 2, paramSessionInfo.toString());
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (AppSetting.a(paramString) >= 0)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("curr ver: 8.7.0, config qqVer:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    QQAlbumUtils.a(jdField_e_of_type_JavaLangString);
    if ((!"bubble".equals(paramString)) && (!"fullscreen".equals(paramString)) && (!"view_aio".equals(paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_e_of_type_JavaLangString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      return new File(localStringBuilder.toString()).exists();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".json");
    return new File(localStringBuilder.toString()).exists();
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    String str = paramQQAppInterface.getAccount();
    if ((!jdField_j_of_type_Boolean) || (!jdField_o_of_type_JavaLangString.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("poke_bar_config_version");
      if (paramQQAppInterface.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("aio_poke_touch_effect");
        s = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
      }
      jdField_o_of_type_JavaLangString = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("touchEffect apply:%d", new Object[] { Integer.valueOf(s) }));
    }
    jdField_j_of_type_Boolean = true;
    return s;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              switch (paramInt)
              {
              default: 
                return -1;
              case 11: 
                return jdField_k_of_type_Int;
              case 10: 
                return jdField_n_of_type_Int;
              }
              return jdField_l_of_type_Int;
            }
            return jdField_j_of_type_Int;
          }
          return jdField_e_of_type_Int;
        }
        return jdField_d_of_type_Int;
      }
      return jdField_b_of_type_Int;
    }
    return jdField_c_of_type_Int;
  }
  
  public static int b(String paramString)
  {
    return new JSONObject(paramString).getInt("TouchFeelingEntrance");
  }
  
  public static void b()
  {
    android.graphics.Bitmap[][] arrayOfBitmap; = new android.graphics.Bitmap[4][];
    arrayOfBitmap;[0] = jdField_b_of_type_ArrayOfAndroidGraphicsBitmap;
    arrayOfBitmap;[1] = jdField_d_of_type_ArrayOfAndroidGraphicsBitmap;
    arrayOfBitmap;[2] = jdField_c_of_type_ArrayOfAndroidGraphicsBitmap;
    arrayOfBitmap;[3] = jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
    int i1 = 0;
    while (i1 < arrayOfBitmap;.length)
    {
      [Landroid.graphics.Bitmap localBitmap; = arrayOfBitmap;[i1];
      int i2 = 0;
      while (i2 < localBitmap;.length)
      {
        if (localBitmap;[i2] != null)
        {
          localBitmap;[i2].recycle();
          localBitmap;[i2] = null;
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public static void b(int paramInt)
  {
    jdField_m_of_type_Int = paramInt;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (v != 2)) || ((!paramBoolean) && (v != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_poke_clicked", true).commit();
      }
      if (paramBoolean)
      {
        v = 2;
        return;
      }
      v = 1;
    }
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[all res checking]  dir");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (jdField_a_of_type_JavaUtilBitSet == null)
    {
      jdField_a_of_type_JavaUtilBitSet = new BitSet(12);
      jdField_a_of_type_JavaUtilBitSet.clear();
      jdField_a_of_type_JavaUtilBitSet.set(7);
    }
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if (localObject != null)
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          a(paramString, localObject[i1]);
          i1 += 1;
        }
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 6))
    {
      if (paramInt == 0) {
        return true;
      }
      return c(paramInt - 1);
    }
    return false;
  }
  
  public static boolean b(SharedPreferences paramSharedPreferences)
  {
    int i1 = v;
    if (i1 == 0)
    {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_poke_clicked", false))
      {
        v = 2;
        return true;
      }
      v = 1;
      return false;
    }
    if (i1 == 1) {
      return false;
    }
    return i1 == 2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return jdField_m_of_type_Int == 1;
  }
  
  public static int c(String paramString)
  {
    return new JSONObject(paramString).getInt("IndependentEntrance");
  }
  
  public static void c(int paramInt)
  {
    jdField_k_of_type_Boolean = true;
    t = paramInt;
  }
  
  public static boolean c(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilBitSet == null)
    {
      jdField_a_of_type_JavaUtilBitSet = new BitSet(12);
      jdField_a_of_type_JavaUtilBitSet.clear();
      jdField_a_of_type_JavaUtilBitSet.set(6);
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[res check] type:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = jdField_a_of_type_JavaUtilBitSet.get(paramInt);
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("poke/");
      ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[res dir]");
        localStringBuilder.append(jdField_d_of_type_JavaLangString);
        localStringBuilder.append("poke/");
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).list();
        if (localObject1 != null)
        {
          if (localObject1.length == jdField_a_of_type_ArrayOfInt[paramInt])
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[res checked]");
            }
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    return bool;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_f_of_type_Boolean) {
      return false;
    }
    if (b(paramQQAppInterface, 9) == 0) {
      return false;
    }
    if ((b(paramQQAppInterface, 4) == 0) && (b(paramQQAppInterface, 11) == 1)) {
      return false;
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static int d(String paramString)
  {
    try
    {
      int i1 = new JSONObject(paramString).getInt("IndependentEntranceType");
      return i1;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
    }
    return 0;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkPEResDownloaded mIsPeResDownloaded =  ");
      ((StringBuilder)localObject).append(jdField_b_of_type_Boolean);
      QLog.d("PokeEmo", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = jdField_b_of_type_Boolean;
    boolean bool2 = false;
    boolean bool1 = true;
    if (bool3)
    {
      bool1 = true;
    }
    else
    {
      if (!jdField_d_of_type_Boolean)
      {
        paramQQAppInterface = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PE);
        localObject = new File(paramQQAppInterface);
        if (!((File)localObject).exists())
        {
          ((File)localObject).mkdirs();
          bool1 = FileUtils.copyAssetDirsToSdcard(BaseApplicationImpl.getContext(), "pe", paramQQAppInterface);
          QQAlbumUtils.a(paramQQAppInterface);
        }
        jdField_b_of_type_Boolean = bool1;
        return jdField_b_of_type_Boolean;
      }
      if (!SharedPreUtils.c())
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(jdField_g_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(jdField_h_of_type_JavaLangString))
          {
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("peResUrl = ");
              paramQQAppInterface.append(jdField_g_of_type_JavaLangString);
              paramQQAppInterface.append(" ,peResMD5 = ");
              paramQQAppInterface.append(jdField_h_of_type_JavaLangString);
              QLog.d("PokeEmo", 2, paramQQAppInterface.toString());
            }
            a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), jdField_g_of_type_JavaLangString, jdField_h_of_type_JavaLangString, jdField_d_of_type_JavaLangString);
            bool1 = bool2;
          }
        }
      }
      else if (!jdField_e_of_type_Boolean)
      {
        jdField_e_of_type_Boolean = true;
        if (!PEPanelHelper.a(a(paramQQAppInterface, 8)))
        {
          jdField_b_of_type_Boolean = false;
          SharedPreUtils.a(false);
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkPEResDownloaded isDownload = ");
          ((StringBuilder)localObject).append(false);
          QLog.d(paramQQAppInterface, 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
      else
      {
        jdField_b_of_type_Boolean = true;
        bool1 = bool2;
      }
    }
    if ((jdField_b_of_type_Boolean) && (!PEPanelHelper.jdField_b_of_type_Boolean))
    {
      PEPanelHelper.jdField_b_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new PokeItemHelper.4());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper
 * JD-Core Version:    0.7.0.1
 */