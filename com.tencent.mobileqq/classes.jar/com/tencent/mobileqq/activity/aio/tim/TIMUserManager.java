package com.tencent.mobileqq.activity.aio.tim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vzb;
import vzc;
import vzd;
import vzf;

public class TIMUserManager
{
  private static TIMUserManager jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager;
  public static String a;
  private static final String jdField_b_of_type_JavaLangString = AppConstants.cy + "icons/";
  private static final String jdField_c_of_type_JavaLangString = AppConstants.cy + "zip/";
  private volatile int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  private String g = "好友在线";
  private String h = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "tim_need_show_text_bubble";
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TIMUserManager", 2, " doDowndLoadTimThemeZip zipUrl " + paramString1);
    }
    File localFile = new File(jdField_b_of_type_JavaLangString);
    paramString2 = new File(jdField_c_of_type_JavaLangString);
    if (!localFile.exists())
    {
      localFile.mkdirs();
      localFile = new File(jdField_b_of_type_JavaLangString + ".nomedia");
    }
    for (;;)
    {
      try
      {
        localFile.createNewFile();
        if (paramString2.exists()) {
          break label183;
        }
        paramString2.mkdirs();
        paramString1 = new DownloadTask(paramString1, new File(jdField_c_of_type_JavaLangString + "android_tim_theme_icons.zip"));
        paramString1.f = "profileCardDownload";
        paramString1.e = "VIP_profilecard";
        return DownloaderFactory.a(paramString1, null);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      FileUtils.b(jdField_b_of_type_JavaLangString);
      continue;
      label183:
      FileUtils.b(jdField_c_of_type_JavaLangString);
    }
  }
  
  public static TIMUserManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager = new TIMUserManager();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager;
  }
  
  private List a()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("tim_theme_icon_names_sp", 0).getString("android_tim_theme_icon_names", "");
    String[] arrayOfString = null;
    if (!TextUtils.isEmpty(str)) {
      arrayOfString = str.split("\\|");
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      while (i < arrayOfString.length)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    int i = 0;
    Object localObject = new File(jdField_b_of_type_JavaLangString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tim_theme_icon_names_sp", 0).edit();
      localObject = ((File)localObject).list();
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < localObject.length)
      {
        String str = localObject[i].substring(localObject[i].lastIndexOf("/") + 1);
        localStringBuilder.append(str + "|");
        i += 1;
      }
      localEditor.putString("android_tim_theme_icon_names", localStringBuilder.toString());
      localEditor.apply();
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, XEditTextEx paramXEditTextEx, PanelIconLinearLayout paramPanelIconLinearLayout, PatchedButton paramPatchedButton)
  {
    ThreadManager.post(new vzd(paramLinearLayout, paramXEditTextEx, paramPanelIconLinearLayout, paramPatchedButton), 8, null, true);
  }
  
  public static void a(TextView paramTextView)
  {
    ThreadManager.post(new vzf(paramTextView), 8, null, true);
  }
  
  public static void a(SessionInfo paramSessionInfo, Context paramContext, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, ImageView paramImageView, TextView paramTextView4, LinearLayout paramLinearLayout, XEditTextEx paramXEditTextEx, PanelIconLinearLayout paramPanelIconLinearLayout, PatchedButton paramPatchedButton, ViewGroup paramViewGroup)
  {
    if ((paramSessionInfo.jdField_b_of_type_Boolean) && (paramSessionInfo.e)) {
      if (paramSessionInfo.jdField_c_of_type_Boolean)
      {
        paramTextView1.setTextColor(paramContext.getResources().getColor(2131494205));
        paramTextView2.setTextColor(paramContext.getResources().getColor(2131494205));
        paramTextView3.setTextColor(paramContext.getResources().getColor(2131494205));
        if (paramSessionInfo.jdField_c_of_type_Boolean) {
          break label110;
        }
        a(paramTextView3);
        a(paramLinearLayout, paramXEditTextEx, paramPanelIconLinearLayout, paramPatchedButton);
        paramPatchedButton.setTextColor(-1);
      }
    }
    label110:
    do
    {
      do
      {
        return;
        paramTextView3.setTextColor(-1);
        paramTextView1.setTextColor(-1);
        paramTextView2.setTextColor(-1);
        break;
        paramLinearLayout.setBackgroundResource(2130845507);
        paramPanelIconLinearLayout.setBackgroundResource(2130845549);
        paramPatchedButton.setBackgroundResource(2130837749);
        paramPatchedButton.setTextColor(paramContext.getResources().getColor(2131494201));
      } while (paramXEditTextEx == null);
      paramXEditTextEx.setBackgroundResource(2130845508);
      paramXEditTextEx.setTextColor(paramContext.getResources().getColor(2131494275));
      return;
      paramLinearLayout.setBackgroundResource(2130845507);
      paramTextView1.setTextColor(paramContext.getResources().getColor(2131494205));
      paramTextView2.setTextColor(paramContext.getResources().getColor(2131494205));
      paramTextView3.setBackgroundResource(2130846136);
      paramTextView3.setTextColor(paramContext.getResources().getColor(2131494205));
      paramPanelIconLinearLayout.setBackgroundResource(2130845549);
      paramPatchedButton.setBackgroundResource(2130837749);
      paramPatchedButton.setTextColor(paramContext.getResources().getColor(2131494201));
    } while (paramXEditTextEx == null);
    paramXEditTextEx.setBackgroundResource(2130845508);
    paramXEditTextEx.setTextColor(paramContext.getResources().getColor(2131494275));
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!this.jdField_b_of_type_Boolean) || (!this.h.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (paramQQAppInterface.contains(str + "_" + "tim_user_special_config_version"))
        {
          this.jdField_b_of_type_Int = paramQQAppInterface.getInt(str + "_" + "tim_user_special_config_avatar_switch", 0);
          this.jdField_c_of_type_Int = paramQQAppInterface.getInt(str + "_" + "tim_user_special_config_title_bg_switch", 0);
          this.jdField_d_of_type_Int = paramQQAppInterface.getInt(str + "_" + "tim_user_special_config_bubble_switch", 0);
          this.jdField_d_of_type_JavaLangString = paramQQAppInterface.getString(str + "_" + "tim_user_special_config_resources_url", "");
          this.f = paramQQAppInterface.getString(str + "_" + "tim_user_special_config_resources_md5", "");
          this.e = paramQQAppInterface.getString(str + "_" + "tim_user_special_config_tim_website", "");
          this.g = paramQQAppInterface.getString(str + "_" + "tim_user_special_config_online_wording", "好友在线");
          this.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean("tim_user_special_need_force_download", false);
        }
        this.h = str;
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("TIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mTimWebsite:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_d_of_type_JavaLangString, this.f, this.g, Boolean.valueOf(this.jdField_c_of_type_Boolean), this.e }));
        }
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 98	java/io/File
    //   3: dup
    //   4: new 24	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 48	com/tencent/mobileqq/activity/aio/tim/TIMUserManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 116
    //   19: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 104	java/io/File:exists	()Z
    //   33: ifne +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_2
    //   39: invokevirtual 376	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 379	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -14 -> 36
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 382	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   58: ifeq -22 -> 36
    //   61: getstatic 44	com/tencent/mobileqq/activity/aio/tim/TIMUserManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokestatic 137	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: getstatic 44	com/tencent/mobileqq/activity/aio/tim/TIMUserManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokestatic 387	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq -44 -> 36
    //   83: aload_1
    //   84: invokevirtual 388	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_1
    //   90: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -57 -> 36
    //   96: aload_1
    //   97: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   100: iconst_0
    //   101: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	TIMUserManager
    //   0	102	1	paramString	String
    //   28	40	2	localFile	File
    //   45	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   38	46	76	java/lang/UnsatisfiedLinkError
    //   61	74	89	java/lang/Exception
  }
  
  private void b()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("tim_theme_icon_names_sp", 0).edit().remove("android_tim_theme_icon_names");
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_b_of_type_Int;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    switch (paramInt)
    {
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      localDrawable = (Drawable)BaseApplicationImpl.sImageCache.get("skin_header_bar.png");
      localObject = localDrawable;
    } while (localDrawable != null);
    localObject = ImageUtil.a(jdField_b_of_type_JavaLangString + "skin_header_bar.png", localOptions);
    if (localObject != null)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      BaseApplicationImpl.sImageCache.put("skin_header_bar.png", localObject);
      return localObject;
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("TIMUserManager", 2, String.format("setTimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, timWebsite:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_d_of_type_JavaLangString, this.f, this.g, Boolean.valueOf(this.jdField_c_of_type_Boolean), paramString2 }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool2 = true;
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((Friends)localObject).netTypeIconId == 10))
      {
        paramSessionInfo.jdField_b_of_type_Boolean = true;
        if (paramSessionInfo.jdField_b_of_type_Boolean)
        {
          paramSessionInfo.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
          if ((c(paramQQAppInterface) == 1) || (a(paramQQAppInterface) == 1))
          {
            if (!a(paramQQAppInterface)) {
              break label178;
            }
            a(paramQQAppInterface, true, a(paramQQAppInterface), b(paramQQAppInterface));
          }
          boolean bool3 = a();
          if ((c(paramQQAppInterface) != 1) || (!bool3)) {
            break label204;
          }
          bool1 = true;
          label129:
          paramSessionInfo.e = bool1;
          if ((a(paramQQAppInterface) != 1) || (!bool3)) {
            break label209;
          }
          bool1 = true;
          label150:
          paramSessionInfo.g = bool1;
          if ((b(paramQQAppInterface) != 1) || (!bool3)) {
            break label214;
          }
        }
      }
    }
    label178:
    label204:
    label209:
    label214:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSessionInfo.i = bool1;
      return;
      if (a()) {
        break;
      }
      a(paramQQAppInterface, false, a(paramQQAppInterface), b(paramQQAppInterface));
      break;
      bool1 = false;
      break label129;
      bool1 = false;
      break label150;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TIMUserManager", 2, "startDownLoadTimTheme TimIconsState " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = 1;
    b();
    if (paramBoolean)
    {
      ThreadManager.post(new vzb(this, paramString1, paramString2, paramQQAppInterface, paramBoolean), 8, null, true);
      return;
    }
    if (a(paramString2))
    {
      a();
      this.jdField_a_of_type_Int = 2;
      return;
    }
    ThreadManager.post(new vzc(this, paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_Int == 2)
    {
      bool2 = bool1;
      return bool2;
    }
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TIMUserManager", 2, "isTimIconsOk TimIconsState " + this.jdField_a_of_type_Int);
    }
    Object localObject2 = new File(jdField_b_of_type_JavaLangString);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      Object localObject1 = a();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).list();
      bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (localObject2.length > 0)
        {
          int i = 0;
          while (i < localObject2.length)
          {
            localArrayList.add(localObject2[i].substring(localObject2[i].lastIndexOf("/") + 1));
            i += 1;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            if (!localArrayList.contains((String)((Iterator)localObject1).next())) {
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_a_of_type_Int = 2;
      return bool1;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_d_of_type_Int;
  }
  
  public Drawable b(int paramInt)
  {
    Object localObject2 = null;
    Bitmap localBitmap = null;
    Object localObject3 = new BitmapFactory.Options();
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("skin_aio_qim_header_flag.png");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localBitmap = ImageUtil.a(jdField_b_of_type_JavaLangString + "skin_aio_qim_header_flag.png", (BitmapFactory.Options)localObject3);
        localObject1 = localObject2;
        if (localBitmap != null)
        {
          localObject1 = new BitmapDrawable(localBitmap);
          BaseApplicationImpl.sImageCache.put("skin_aio_qim_header_flag.png", localObject1);
          continue;
          localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get("title_bg_round.9.png");
          if (localBitmap == null)
          {
            localObject1 = ImageUtil.a(jdField_b_of_type_JavaLangString + "title_bg_round.9.png", (BitmapFactory.Options)localObject3);
            if (localObject1 == null) {
              break;
            }
            BaseApplicationImpl.sImageCache.put("title_bg_round.9.png", localObject1);
            localObject2 = ((Bitmap)localObject1).getNinePatchChunk();
            if ((localObject2 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject2))) {
              break label501;
            }
            localObject1 = new NinePatchDrawable((Bitmap)localObject1, (byte[])localObject2, new Rect(), null);
            continue;
          }
          localObject3 = localBitmap.getNinePatchChunk();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (NinePatch.isNinePatchChunk((byte[])localObject3)) {
              localObject1 = new NinePatchDrawable(localBitmap, (byte[])localObject3, new Rect(), null);
            }
          }
          continue;
          localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("aio_qim_online_icon.png");
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localBitmap = ImageUtil.a(jdField_b_of_type_JavaLangString + "aio_qim_online_icon.png", (BitmapFactory.Options)localObject3);
            localObject1 = localObject2;
            if (localBitmap != null)
            {
              localObject1 = new BitmapDrawable(localBitmap);
              BaseApplicationImpl.sImageCache.put("skin_aio_qim_header_flag.png", localObject1);
              continue;
              localObject1 = localBitmap;
              if ((Drawable)BaseApplicationImpl.sImageCache.get("tim_title_immersive_bar.png") == null)
              {
                localObject2 = ImageUtil.a(jdField_b_of_type_JavaLangString + "tim_title_immersive_bar.png", (BitmapFactory.Options)localObject3);
                localObject1 = localBitmap;
                if (localObject2 != null)
                {
                  return new BitmapDrawable((Bitmap)localObject2);
                  localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("aio_tim_user_online_title_icon.png");
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject1 = ImageUtil.a(jdField_b_of_type_JavaLangString + "aio_tim_user_online_title_icon.png", (BitmapFactory.Options)localObject3);
                    localObject1 = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject1);
                    ((Drawable)localObject1).setBounds(0, 0, ScreenUtil.a(13.0F), ScreenUtil.a(13.0F));
                    continue;
                    label501:
                    localObject1 = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.f;
  }
  
  public int c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager
 * JD-Core Version:    0.7.0.1
 */