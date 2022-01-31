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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.PokePanel.PokeData;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
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
import vcz;
import vda;
import vdc;
import vdd;
import vde;

public class PokeItemHelper
{
  public static int a;
  public static String a;
  static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static BitSet jdField_a_of_type_JavaUtilBitSet;
  public static final Vector a;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static android.graphics.Bitmap[] a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  public static final String b;
  public static final Vector b;
  public static volatile boolean b;
  public static android.graphics.Bitmap[] b;
  public static int c;
  public static final String c;
  public static final Vector c;
  public static volatile boolean c;
  public static android.graphics.Bitmap[] c;
  public static int d;
  public static final String d;
  public static final Vector d;
  public static boolean d;
  public static android.graphics.Bitmap[] d;
  public static int e;
  public static final String e;
  public static volatile boolean e;
  public static int f;
  public static final String f;
  private static boolean f;
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
  private static String k;
  public static int l;
  private static String l;
  public static int m;
  private static String m;
  public static int n;
  private static String n;
  private static int jdField_o_of_type_Int;
  private static String jdField_o_of_type_JavaLangString;
  private static int jdField_p_of_type_Int;
  private static String jdField_p_of_type_JavaLangString;
  private static int q;
  private static int r;
  private static int s;
  private static int t;
  private static int u;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PokeItemHelper";
    jdField_o_of_type_Int = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
    jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaLangString + "/Tencent/MobileQQ/";
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString;
    jdField_e_of_type_JavaLangString = jdField_c_of_type_JavaLangString + ".vaspoke/";
    jdField_f_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "vasPokeMarket.json";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
    jdField_c_of_type_JavaUtilVector = new Vector();
    jdField_d_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Int = -1;
    jdField_l_of_type_JavaLangString = "";
    jdField_m_of_type_JavaLangString = "";
    jdField_n_of_type_JavaLangString = "";
    jdField_o_of_type_JavaLangString = "";
    jdField_p_of_type_JavaLangString = "";
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = 10;
    jdField_e_of_type_Int = 60;
    jdField_f_of_type_Int = -1;
    jdField_g_of_type_Int = -1;
    jdField_h_of_type_Int = 10;
    jdField_i_of_type_Int = 60;
    jdField_m_of_type_Int = 50;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "chuo_icon", "bixin_icon", "zan_icon", "xinsui_icon", "666_icon", "dazhao_icon", "chuo_motion", "bixin_motion", "zan_motion", "xinsui_motion", "666_motion", "dazhao_motion" };
    jdField_a_of_type_ArrayOfInt = new int[] { 22, 22, 22, 22, 22, 22, 35, 99, 25, 60, 0, 0 };
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_b_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_c_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_d_of_type_ArrayOfAndroidGraphicsBitmap = new android.graphics.Bitmap[6];
    jdField_d_of_type_Boolean = true;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 1);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramQQAppInterface.getAccount();
    if ((!jdField_h_of_type_Boolean) || (!jdField_n_of_type_JavaLangString.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version"))
      {
        jdField_p_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_unique_poke_show", 0);
        q = paramQQAppInterface.getInt(str + "_" + "aio_unique_poke_type", 0);
      }
      jdField_n_of_type_JavaLangString = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("uniquepoke show %d type %d", new Object[] { Integer.valueOf(jdField_p_of_type_Int), Integer.valueOf(q) }));
    }
    jdField_f_of_type_Boolean = true;
    if (paramInt == 1) {
      return jdField_p_of_type_Int;
    }
    if (paramInt == 2) {
      return q;
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
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, localMatrix, true);
      if ((QLog.isColorLevel()) && (paramBitmap != null)) {
        Log.d("test", "convertBmp w=" + paramBitmap.getWidth());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get pokeFriendPokeImage oom" + paramBitmap);
        }
        paramBitmap = null;
      }
    }
  }
  
  public static Drawable a(int paramInt, boolean paramBoolean, Resources paramResources)
  {
    int i3 = 2130842201;
    int i4 = 2130842200;
    if ((paramInt < 0) || (paramInt > 6)) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 0) {}
      for (int i2 = 1;; i2 = paramInt)
      {
        paramInt = i4;
        int i1 = i3;
        switch (i2)
        {
        default: 
          i1 = i3;
          paramInt = i4;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 6: 
          for (;;)
          {
            i2 -= 1;
            a(jdField_c_of_type_ArrayOfAndroidGraphicsBitmap, jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, i2, paramResources, paramInt, i1);
            if (!paramBoolean)
            {
              if ((jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[i2] != null) && (jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[i2] == null)) {
                jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[i2] = a(jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
              }
              if ((jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2] != null) && (jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2] == null)) {
                jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2] = a(jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
              }
            }
            if (!paramBoolean) {
              break;
            }
            return BitmapUtil.a(paramResources, jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[i2], jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
            paramInt = 2130842182;
            i1 = 2130842183;
            continue;
            paramInt = 2130842170;
            i1 = 2130842171;
            continue;
            paramInt = 2130842186;
            i1 = 2130842187;
            continue;
            paramInt = 2130842184;
            i1 = 2130842185;
          }
        }
        if (paramBoolean)
        {
          a(jdField_c_of_type_ArrayOfAndroidGraphicsBitmap, jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, i2 - 1, paramResources, 2130842190, 2130842191);
          return BitmapUtil.a(paramResources, jdField_c_of_type_ArrayOfAndroidGraphicsBitmap[(i2 - 1)], jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[(i2 - 1)]);
        }
        a(jdField_d_of_type_ArrayOfAndroidGraphicsBitmap, jdField_b_of_type_ArrayOfAndroidGraphicsBitmap, i2 - 1, paramResources, 2130842188, 2130842189);
        return BitmapUtil.a(paramResources, jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[(i2 - 1)], jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[(i2 - 1)]);
        return BitmapUtil.a(paramResources, jdField_d_of_type_ArrayOfAndroidGraphicsBitmap[i2], jdField_b_of_type_ArrayOfAndroidGraphicsBitmap[i2]);
      }
    }
  }
  
  public static Drawable a(android.graphics.Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, localMatrix, true);
      if ((QLog.isColorLevel()) && (paramBitmap != null)) {
        Log.d("test", "convertBmp w=" + paramBitmap.getWidth());
      }
      paramBitmap = new BitmapDrawable(paramBitmap);
      ((BitmapDrawable)paramBitmap).setTargetDensity(jdField_o_of_type_Int);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get pokeFriendPokeImage oom" + paramBitmap);
        }
        paramBitmap = null;
      }
    }
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!jdField_g_of_type_Boolean) || (!jdField_m_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version"))
        {
          jdField_k_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "aio_poke_panel_config", "".toString());
          if (jdField_k_of_type_JavaLangString == null) {
            jdField_k_of_type_JavaLangString = "";
          }
        }
        jdField_m_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, "PokePanelPlaceInfo:" + jdField_k_of_type_JavaLangString);
    }
    jdField_g_of_type_Boolean = true;
    return jdField_k_of_type_JavaLangString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface);
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
      return jdField_g_of_type_JavaLangString;
    case 6: 
      return jdField_h_of_type_JavaLangString;
    case 7: 
      return jdField_i_of_type_JavaLangString;
    }
    return jdField_j_of_type_JavaLangString;
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
  
  public static ArrayList a(AppRuntime paramAppRuntime, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(jdField_f_of_type_JavaLangString);
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = new JSONObject(FileUtils.a((File)localObject1));
        try
        {
          if (!((JSONObject)localObject1).optBoolean("lottieEnable", true))
          {
            if (!QLog.isColorLevel()) {
              break label644;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "lottie disable");
            break label644;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("itemList");
          i1 = 0;
          if (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i1);
            Object localObject3 = ((JSONObject)localObject2).optString("id");
            Object localObject4 = ((JSONObject)localObject2).optString("name");
            int i2 = ((JSONObject)localObject2).optInt("feeType", 0);
            int i3 = ((JSONObject)localObject2).optInt("status", 0);
            int i4 = ((JSONObject)localObject2).optInt("isShow", 0);
            String str = ((JSONObject)localObject2).optString("minVersion");
            if (!a(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "curr ver: 7.6.3, config qqVer:" + str);
              }
            }
            else if ((i3 == 1) && (i4 == 1))
            {
              localObject2 = new PokePanel.PokeData();
              ((PokePanel.PokeData)localObject2).jdField_a_of_type_Int = 126;
              ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int = Integer.parseInt((String)localObject3);
              ((PokePanel.PokeData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject4);
              ((PokePanel.PokeData)localObject2).jdField_c_of_type_Int = i2;
              ((PokePanel.PokeData)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject4);
              ((PokePanel.PokeData)localObject2).jdField_c_of_type_JavaLangString = str;
              localObject3 = (VasQuickUpdateManager)paramAppRuntime.getManager(183);
              if (!a("effect.gif", ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int))
              {
                ((PokePanel.PokeData)localObject2).jdField_c_of_type_Boolean = true;
                ((VasQuickUpdateManager)localObject3).a(21L, "poke.item.effect." + ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int, "parseVasPokeConfig");
                ((VasQuickUpdateManager)localObject3).a(paramCallBacker);
              }
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130844186);
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130844186);
              ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
              ((URLDrawable.URLDrawableOptions)localObject4).mGifRoundCorner = 0.0F;
              ((PokePanel.PokeData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File(jdField_e_of_type_JavaLangString + ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int + "/" + "effect.gif"), (URLDrawable.URLDrawableOptions)localObject4);
              if (QLog.isColorLevel()) {
                QLog.i(jdField_a_of_type_JavaLangString, 2, "name: " + ((PokePanel.PokeData)localObject2).jdField_a_of_type_JavaLangString + " resId: " + ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int + " feeType: " + ((PokePanel.PokeData)localObject2).jdField_c_of_type_Int);
              }
              localArrayList.add(localObject2);
              if (!a("bubble", ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int))
              {
                ((PokePanel.PokeData)localObject2).jdField_b_of_type_Boolean = true;
                if (!EmoticonUtils.b()) {
                  break label647;
                }
                ((VasQuickUpdateManager)localObject3).a(21L, "poke.item.res." + ((PokePanel.PokeData)localObject2).jdField_b_of_type_Int, "parseVasPokeConfig");
                ((VasQuickUpdateManager)localObject3).a(paramCallBacker);
              }
            }
          }
        }
        catch (Exception paramAppRuntime)
        {
          QLog.e("PokeItemHelper", 1, "parse json config fail", paramAppRuntime);
        }
      }
      catch (Throwable paramAppRuntime)
      {
        Object localObject2;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getJsonOOM,json_name:vasPoke", paramAppRuntime);
        continue;
      }
      return localArrayList;
      ((PokePanel.PokeData)localObject2).jdField_b_of_type_Boolean = false;
      break label647;
      a(paramAppRuntime, paramCallBacker);
      continue;
      label644:
      return localArrayList;
      label647:
      i1 += 1;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      jdField_a_of_type_JavaUtilArrayList.clear();
    }
    jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public static void a(int paramInt)
  {
    jdField_i_of_type_Boolean = true;
    r = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_h_of_type_Boolean = true;
    jdField_p_of_type_Int = paramInt1;
    q = paramInt2;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jdField_f_of_type_Boolean = true;
    jdField_b_of_type_Int = paramInt1;
    jdField_c_of_type_Int = paramInt2;
    jdField_d_of_type_Int = paramInt3;
    jdField_e_of_type_Int = paramInt4;
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 126)
    {
      File localFile = new File(jdField_e_of_type_JavaLangString + paramInt2 + "/pressed.png");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130844186);
      localURLDrawableOptions.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130844186);
      paramImageView.setImageDrawable(URLDrawable.getDrawable(localFile, localURLDrawableOptions));
      return;
    }
    paramImageView.setImageResource(paramInt2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramQQAppInterface != null)
    {
      str = paramQQAppInterface.getAccount();
      if ((!jdField_f_of_type_Boolean) || (!jdField_l_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (!paramQQAppInterface.contains(str + "_" + "poke_bar_config_version")) {
          break label607;
        }
        jdField_b_of_type_Int = paramQQAppInterface.getInt(str + "_" + "poke_bar_switch", jdField_f_of_type_Int);
        jdField_c_of_type_Int = paramQQAppInterface.getInt(str + "_" + "poke_pad_switch", jdField_g_of_type_Int);
        jdField_e_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_poke_unittime", jdField_i_of_type_Int);
        jdField_d_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_poke_unitcount", jdField_h_of_type_Int);
        jdField_j_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_poke_entry_type", 0);
        jdField_k_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_pe_view_type", 0);
        jdField_g_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "poke_emo_res_url", "");
        jdField_h_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "poke_emo_res_md5", "");
        jdField_i_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "poke_emo_surprice_indexs", "");
        jdField_j_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "poke_emo_order", "");
        jdField_l_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_pe_input_switch", 0);
        jdField_m_of_type_Int = paramQQAppInterface.getInt(str + "_" + "aio_pe_bubble_limit_count", 50);
        jdField_a_of_type_Int = paramQQAppInterface.getInt(str + "_" + "pe_last_tab_index", -1);
      }
    }
    for (;;)
    {
      jdField_l_of_type_JavaLangString = str;
      jdField_f_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("pokeMsg", 2, String.format("getPokeSwitch, first init, bar switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d", new Object[] { Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_c_of_type_Int), jdField_l_of_type_JavaLangString, Integer.valueOf(jdField_d_of_type_Int), Integer.valueOf(jdField_e_of_type_Int) }));
      }
      return;
      label607:
      jdField_b_of_type_Int = jdField_f_of_type_Int;
      jdField_c_of_type_Int = jdField_g_of_type_Int;
      jdField_j_of_type_Int = 0;
      jdField_k_of_type_Int = 0;
      jdField_l_of_type_Int = 0;
      jdField_m_of_type_Int = 50;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    ((VasExtensionHandler)paramQQAppInterface.a(71)).a(paramInt1, paramString1, paramInt2, paramString2, paramInt3);
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
    jdField_m_of_type_Int = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setPokeEmoPanelConfig|entryType: " + jdField_j_of_type_Int + ",peSurpriseIndexs: " + jdField_i_of_type_JavaLangString + ",peOders: " + paramString4);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = new vdc(paramQQAppInterface, paramInt2, paramActivity, paramInt1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, "温馨提示", paramString1, "取消", paramString2, paramQQAppInterface, paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.show();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, @Nullable GivingHeartItemBuilder.Holder paramHolder, int paramInt, String paramString)
  {
    if (a()) {
      ThreadManager.postImmediately(new vcz(paramInt), null, true);
    }
    paramQQAppInterface = jdField_e_of_type_JavaLangString + paramInt + "/" + paramString + "/";
    paramQQAppInterface = new File(paramQQAppInterface + paramString + ".json");
    try
    {
      paramDiniFlyAnimationView = new vda(paramDiniFlyAnimationView, paramHolder, paramString);
      paramHolder = new Bundle();
      paramHolder.putString("key", "lottie_vaspoke_" + String.valueOf(paramInt) + paramString);
      paramHolder.putString("path", jdField_e_of_type_JavaLangString + paramInt + "/" + paramString + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, new FileInputStream(paramQQAppInterface), paramDiniFlyAnimationView, paramHolder, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramQQAppInterface)
    {
      QLog.e("PokeItemHelper", 2, "vaspoke, file not found. id: " + paramInt + " ,category: " + paramString, paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("PokeItemHelper", 2, "vaspoke, exception occur, id: " + paramInt + " ,category: " + paramString, paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (!jdField_d_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmo", 2, "startDownloadPERes resUrl " + paramString1 + ",resMD5" + paramString2);
        }
        if (!jdField_c_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PokeEmo", 2, "other request is downloading ");
      return;
      if (jdField_n_of_type_Int <= 15) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PokeEmo", 2, "pe res download exceed limit 5 ");
    return;
    jdField_c_of_type_Boolean = true;
    String str = paramString3 + "pe.zip";
    paramString2 = new vde(paramString3, paramString2);
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    paramString3 = new HttpNetReq();
    paramString3.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = paramString2;
    paramString3.jdField_a_of_type_Int = 0;
    paramString3.jdField_a_of_type_JavaLangString = paramString1;
    paramString3.jdField_c_of_type_JavaLangString = str;
    paramString3.jdField_e_of_type_Int = 0;
    paramQQAppInterface.a(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (t != 2)) || ((!paramBoolean) && (t != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_unique_clicked", true).commit();
      }
      if (paramBoolean) {
        t = 2;
      }
    }
    else
    {
      return;
    }
    t = 1;
  }
  
  public static void a(String paramString)
  {
    jdField_g_of_type_Boolean = true;
    jdField_k_of_type_JavaLangString = paramString;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt(paramString + "_" + "pe_last_tab_index", paramInt);
    localEditor.apply();
  }
  
  private static void a(String paramString1, String paramString2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[res checking]" + paramString1 + paramString2);
    }
    if (paramString2.equals("dazhao_motion")) {
      jdField_a_of_type_JavaUtilBitSet.set(11, false);
    }
    for (;;)
    {
      return;
      if (paramString2.equals("666_motion"))
      {
        jdField_a_of_type_JavaUtilBitSet.set(10, false);
        return;
      }
      while (i1 < 12)
      {
        if (jdField_a_of_type_ArrayOfJavaLangString[i1].equals(paramString2))
        {
          Object localObject = new File(paramString1 + paramString2);
          if (((File)localObject).isDirectory())
          {
            localObject = ((File)localObject).list();
            if ((localObject != null) && (localObject.length == jdField_a_of_type_ArrayOfInt[i1]))
            {
              jdField_a_of_type_JavaUtilBitSet.set(i1, true);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "[res checked]" + paramString2);
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (VasQuickUpdateManager.a(paramAppRuntime, 21L, "poke.effectList", jdField_f_of_type_JavaLangString, true, paramCallBacker) != null)
    {
      paramAppRuntime = (EarlyDownloadManager)paramAppRuntime.getManager(76);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (PokeResHandler)paramAppRuntime.a("qq.android.poke.res_1228");
        if ((paramAppRuntime != null) && (!paramAppRuntime.h()))
        {
          paramAppRuntime.a();
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
    boolean bool2 = false;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.length >= 7)
        {
          bool1 = bool2;
          if (!"0".equals(localObject[6])) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt < 0) || (paramInt > 6)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if (paramInt != 6) {
              break;
            }
            if (jdField_a_of_type_JavaUtilBitSet == null)
            {
              jdField_a_of_type_JavaUtilBitSet = new BitSet(12);
              jdField_a_of_type_JavaUtilBitSet.clear();
              jdField_a_of_type_JavaUtilBitSet.set(6);
            }
            bool1 = bool2;
          } while (jdField_a_of_type_JavaUtilBitSet.get(11));
          Object localObject = jdField_c_of_type_JavaLangString + "/poke/dazhao_motion/";
          File localFile1 = new File((String)localObject, "dazhao_move.png");
          File localFile2 = new File((String)localObject, "dazhao_motion");
          localObject = new File((String)localObject, "dazhao2_motion");
          if ((localFile1.exists()) && (localFile2.exists()) && (localFile2.isDirectory()) && (localFile2.list().length == 34) && (((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).list().length == 22))
          {
            jdField_a_of_type_JavaUtilBitSet.set(11, true);
            return true;
          }
          return false;
          bool1 = bool2;
        } while (paramInt == 5);
        bool1 = bool2;
      } while (paramInt == 0);
      bool1 = bool2;
    } while (paramInt == 1);
    return c(paramInt + 6 - 1);
  }
  
  public static boolean a(SharedPreferences paramSharedPreferences)
  {
    if (t == 0) {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_unique_clicked", false)) {
        t = 1;
      }
    }
    while ((t == 1) || (t != 2))
    {
      return false;
      t = 2;
      return true;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return c(paramQQAppInterface) == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l1 = MessageCache.a();
    paramSessionInfo = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    int i1;
    MessageRecord localMessageRecord;
    boolean bool;
    if ((paramSessionInfo != null) && (paramSessionInfo.size() > 0))
    {
      int i2 = paramSessionInfo.size() - 1;
      i1 = 0;
      for (;;)
      {
        if (i2 >= 0)
        {
          localMessageRecord = (MessageRecord)paramSessionInfo.get(i2);
          if (!localMessageRecord.isSend()) {
            i2 -= 1;
          } else if (l1 - localMessageRecord.time > b(paramQQAppInterface, 3)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isCanSendPoke, isCansend= " + bool);
      }
      return bool;
      if ((localMessageRecord instanceof MessageForPoke))
      {
        int i3 = i1 + 1;
        i1 = i3;
        if (i3 < b(paramQQAppInterface, 2)) {
          break;
        }
        bool = false;
        continue;
      }
      break;
      bool = true;
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("7.6.3".compareTo(paramString.substring(0, "7.6.3".length())) < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "curr ver: 7.6.3, config qqVer:" + paramString);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return new File(jdField_e_of_type_JavaLangString + paramInt + "/" + paramString).exists();
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 2);
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface);
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return -1;
    case 1: 
      return jdField_b_of_type_Int;
    case 0: 
      return jdField_c_of_type_Int;
    case 2: 
      return jdField_d_of_type_Int;
    case 3: 
      return jdField_e_of_type_Int;
    case 4: 
      return jdField_j_of_type_Int;
    case 11: 
      return jdField_k_of_type_Int;
    case 9: 
      return jdField_l_of_type_Int;
    }
    return jdField_m_of_type_Int;
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
    jdField_j_of_type_Boolean = true;
    s = paramInt;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (u != 2)) || ((!paramBoolean) && (u != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_poke_clicked", true).commit();
      }
      if (paramBoolean) {
        u = 2;
      }
    }
    else
    {
      return;
    }
    u = 1;
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[all res checking]  dir" + paramString);
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
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        a(paramString, localObject[i1]);
        i1 += 1;
      }
    }
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo", 2, "checkPEResDownloaded mIsPeResDownloaded =  " + jdField_b_of_type_Boolean);
    }
    boolean bool;
    if (jdField_b_of_type_Boolean) {
      bool = true;
    }
    for (;;)
    {
      if ((jdField_b_of_type_Boolean) && (!PEPanelHelper.jdField_b_of_type_Boolean))
      {
        PEPanelHelper.jdField_b_of_type_Boolean = true;
        ThreadManager.executeOnSubThread(new vdd());
      }
      return bool;
      if (!jdField_d_of_type_Boolean)
      {
        File localFile = new File("/sdcard/tencent/mobileqq/pe");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        for (bool = FileUtils.b(BaseApplicationImpl.getContext(), "pe", "/sdcard/tencent/mobileqq/pe");; bool = true)
        {
          jdField_b_of_type_Boolean = bool;
          return jdField_b_of_type_Boolean;
        }
      }
      if (!SharedPreUtils.c())
      {
        if ((!TextUtils.isEmpty(jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_h_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PokeEmo", 2, "peResUrl = " + jdField_g_of_type_JavaLangString + " ,peResMD5 = " + jdField_h_of_type_JavaLangString);
          }
          a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), jdField_g_of_type_JavaLangString, jdField_h_of_type_JavaLangString, jdField_d_of_type_JavaLangString);
          bool = false;
        }
      }
      else
      {
        if (!jdField_e_of_type_Boolean)
        {
          jdField_e_of_type_Boolean = true;
          if (!new File(PEPanelHelper.jdField_a_of_type_JavaLangString).exists())
          {
            jdField_b_of_type_Boolean = false;
            SharedPreUtils.a(false);
          }
          bool = false;
          continue;
        }
        jdField_b_of_type_Boolean = true;
      }
      bool = false;
    }
  }
  
  public static boolean b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      return false;
    }
    if (paramInt == 0) {
      return true;
    }
    return c(paramInt - 1);
  }
  
  public static boolean b(SharedPreferences paramSharedPreferences)
  {
    if (u == 0) {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_poke_clicked", false)) {
        u = 2;
      }
    }
    do
    {
      return true;
      u = 1;
      return false;
      if (u == 1) {
        return false;
      }
    } while (u == 2);
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (b(paramQQAppInterface, 9) == 0) {}
    while ((b(paramQQAppInterface, 4) == 0) && (b(paramQQAppInterface, 11) == 1)) {
      return false;
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    String str = paramQQAppInterface.getAccount();
    if ((!jdField_i_of_type_Boolean) || (!jdField_o_of_type_JavaLangString.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version")) {
        r = paramQQAppInterface.getInt(str + "_" + "aio_poke_touch_effect", 0);
      }
      jdField_o_of_type_JavaLangString = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("touchEffect apply:%d", new Object[] { Integer.valueOf(r) }));
    }
    jdField_i_of_type_Boolean = true;
    return r;
  }
  
  public static int c(String paramString)
  {
    return new JSONObject(paramString).getInt("IndependentEntrance");
  }
  
  public static boolean c(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilBitSet == null)
    {
      jdField_a_of_type_JavaUtilBitSet = new BitSet(12);
      jdField_a_of_type_JavaUtilBitSet.clear();
      jdField_a_of_type_JavaUtilBitSet.set(6);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[res check] type:" + paramInt);
    }
    boolean bool2 = jdField_a_of_type_JavaUtilBitSet.get(paramInt);
    boolean bool1 = bool2;
    if (!bool2)
    {
      Object localObject = new File(jdField_c_of_type_JavaLangString + "poke/" + jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[res dir]" + jdField_c_of_type_JavaLangString + "poke/" + jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      }
      bool1 = bool2;
      if (((File)localObject).exists())
      {
        bool1 = bool2;
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          if (localObject == null) {
            break label225;
          }
          bool1 = bool2;
          if (localObject.length == jdField_a_of_type_ArrayOfInt[paramInt])
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[res checked]");
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label225:
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper
 * JD-Core Version:    0.7.0.1
 */