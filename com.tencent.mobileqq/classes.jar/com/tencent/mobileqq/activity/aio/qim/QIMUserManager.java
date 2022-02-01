package com.tencent.mobileqq.activity.aio.qim;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QIMUserManager
{
  private static QIMUserManager jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager;
  public static String a = "qim_need_show_text_bubble";
  private static final String jdField_b_of_type_JavaLangString;
  private static final String jdField_c_of_type_JavaLangString;
  private static final String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131709812);
  private volatile int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = jdField_d_of_type_JavaLangString;
  private String i = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AIO_QIM_THEME_DIR);
    localStringBuilder.append("icons/");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AIO_QIM_THEME_DIR);
    localStringBuilder.append("zip/");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" doDowndLoadQimThemeZip zipUrl ");
      paramString2.append(paramString1);
      QLog.i("QIMUserManager", 2, paramString2.toString());
    }
    Object localObject = new File(jdField_b_of_type_JavaLangString);
    paramString2 = new File(jdField_c_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(".nomedia");
      localObject = new File(((StringBuilder)localObject).toString());
      try
      {
        ((File)localObject).createNewFile();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    else
    {
      FileUtils.deleteFilesInDirectory(jdField_b_of_type_JavaLangString);
    }
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    } else {
      FileUtils.deleteFilesInDirectory(jdField_c_of_type_JavaLangString);
    }
    paramString2 = new StringBuilder();
    paramString2.append(jdField_c_of_type_JavaLangString);
    paramString2.append("android_qim_theme_icons.zip");
    paramString1 = new DownloadTask(paramString1, new File(paramString2.toString()));
    paramString1.f = "profileCardDownload";
    paramString1.e = "VIP_profilecard";
    return DownloaderFactory.a(paramString1, null);
  }
  
  public static QIMUserManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager = new QIMUserManager();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager;
  }
  
  private List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getApplication();
    int j = 0;
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qim_theme_icon_names_sp", 0).getString("android_qim_theme_icon_names", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = ((String)localObject).split("\\|");
    } else {
      localObject = null;
    }
    if ((localObject != null) && (localObject.length > 0)) {
      while (j < localObject.length)
      {
        localArrayList.add(localObject[j]);
        j += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Object localObject2 = new File(jdField_b_of_type_JavaLangString);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      Object localObject1 = BaseApplicationImpl.getApplication();
      int j = 0;
      localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("qim_theme_icon_names_sp", 0).edit();
      localObject2 = ((File)localObject2).list();
      StringBuilder localStringBuilder1 = new StringBuilder();
      while (j < localObject2.length)
      {
        String str = localObject2[j].substring(localObject2[j].lastIndexOf("/") + 1);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append("|");
        localStringBuilder1.append(localStringBuilder2.toString());
        j += 1;
      }
      ((SharedPreferences.Editor)localObject1).putString("android_qim_theme_icon_names", localStringBuilder1.toString());
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!this.jdField_b_of_type_Boolean) || (!this.i.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("qim_user_special_config_version");
        if (paramQQAppInterface.contains(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_avatar_switch");
          this.jdField_b_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_title_bg_switch");
          this.jdField_c_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_bubble_switch");
          this.jdField_d_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_resources_url");
          this.e = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_resources_md5");
          this.g = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_qim_website");
          this.f = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_online_wording");
          this.h = paramQQAppInterface.getString(localStringBuilder.toString(), jdField_d_of_type_JavaLangString);
          this.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean("qim_user_special_need_force_download", false);
        }
        this.i = str;
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mQimWebsite:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.e, this.g, this.h, Boolean.valueOf(this.jdField_c_of_type_Boolean), this.f }));
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("android_qim_theme_icons.zip");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      String str = FileUtils.calcMd5(((File)localObject).getPath());
      if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString))) {
        try
        {
          FileUtils.deleteFilesInDirectory(jdField_b_of_type_JavaLangString);
          ZipUtils.unZipFile((File)localObject, jdField_b_of_type_JavaLangString);
          return true;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            paramString.printStackTrace();
          }
        }
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (QLog.isColorLevel()) {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  private void b()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).edit().remove("android_qim_theme_icon_names");
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_b_of_type_Int;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new BitmapFactory.Options();
    if (paramInt != 2130850433) {
      return null;
    }
    Object localObject2 = (Drawable)GlobalImageCache.a.get("skin_header_bar.png");
    if (localObject2 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("skin_header_bar.png");
      localObject1 = ImageUtil.a(((StringBuilder)localObject2).toString(), (BitmapFactory.Options)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new BitmapDrawable((Bitmap)localObject1);
        GlobalImageCache.a.put("skin_header_bar.png", localObject1);
        return localObject1;
      }
      return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
    }
    return localObject2;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.e;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("QIMUserManager", 2, String.format("setQimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, qimWebsite:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.e, this.g, this.h, Boolean.valueOf(this.jdField_c_of_type_Boolean), paramString2 }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToQimWebsite: invoked. info: qimWebsiteUrl = ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.i("QIMUserManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramContext != null)) {
      try
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramQQAppInterface);
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMUserManager", 2, "jumpToQimWebsite: Failed. info: exception = ", paramQQAppInterface);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).e(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((Friends)localObject).netTypeIconId == 11))
      {
        boolean bool2 = true;
        paramSessionInfo.jdField_a_of_type_Boolean = true;
        if (paramSessionInfo.jdField_a_of_type_Boolean)
        {
          paramSessionInfo.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
          if ((c(paramQQAppInterface) == 1) || (a(paramQQAppInterface) == 1)) {
            if (a(paramQQAppInterface)) {
              a(paramQQAppInterface, true, a(paramQQAppInterface), c(paramQQAppInterface));
            } else if (!a()) {
              a(paramQQAppInterface, false, a(paramQQAppInterface), c(paramQQAppInterface));
            }
          }
          boolean bool3 = a();
          boolean bool1;
          if ((c(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramSessionInfo.d = bool1;
          if ((a(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramSessionInfo.f = bool1;
          if ((b(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          paramSessionInfo.h = bool1;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownLoadQimTheme QimIconsState ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("QIMUserManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = 1;
    b();
    if (paramBoolean)
    {
      ThreadManager.post(new QIMUserManager.1(this, paramString1, paramString2, paramQQAppInterface, paramBoolean), 8, null, true);
      return;
    }
    if (a(paramString2))
    {
      a();
      this.jdField_a_of_type_Int = 2;
      return;
    }
    ThreadManager.post(new QIMUserManager.2(this, paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public void a(ArrayList<QIMUserManager.QIMUserIcon> paramArrayList, ArrayList<int[]> paramArrayList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (j < paramArrayList1.size())
      {
        localArrayList.add(((int[])paramArrayList1.get(j)).clone());
        j += 1;
      }
      ThreadManager.postImmediately(new QIMUserManager.5(this, paramArrayList, localArrayList), null, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    int j = this.jdField_a_of_type_Int;
    boolean bool3 = true;
    if (j == 2) {
      return true;
    }
    j = this.jdField_a_of_type_Int;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool2 = bool1;
    if (j != 1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Int != 3)
      {
        if (this.jdField_a_of_type_Int == 4) {
          return false;
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isQimIconsOk QimIconsState ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          QLog.i("QIMUserManager", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject3 = new File(jdField_b_of_type_JavaLangString);
        bool1 = bool4;
        if (((File)localObject3).exists())
        {
          bool1 = bool4;
          if (((File)localObject3).isDirectory())
          {
            Object localObject2 = a();
            localObject1 = new ArrayList();
            localObject3 = ((File)localObject3).list();
            bool1 = bool4;
            if (localObject3 != null)
            {
              bool1 = bool4;
              if (localObject3.length > 0)
              {
                j = 0;
                while (j < localObject3.length)
                {
                  ((List)localObject1).add(localObject3[j].substring(localObject3[j].lastIndexOf("/") + 1));
                  j += 1;
                }
                localObject2 = ((List)localObject2).iterator();
                do
                {
                  bool1 = bool3;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                } while (((List)localObject1).contains((String)((Iterator)localObject2).next()));
                bool1 = false;
              }
            }
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          this.jdField_a_of_type_Int = 2;
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.jdField_a_of_type_Boolean) && (paramSessionInfo.h);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.netTypeIconId == 11) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    boolean bool2 = "2".equals(paramChatMessage.getExtInfoFromExtStr("app_qim_tail_id"));
    int j = a().a(paramQQAppInterface);
    boolean bool1 = true;
    if ((j == 1) && (!paramChatMessage.isSend()))
    {
      if (bool2) {
        break label64;
      }
      if (a().a(paramQQAppInterface, paramChatMessage.senderuin)) {
        return true;
      }
    }
    bool1 = false;
    label64:
    return bool1;
  }
  
  public boolean a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    boolean bool1 = false;
    if ((!paramBoolean) && ((!(paramObject instanceof TextItemBuilder)) || ((paramObject instanceof TextTranslationItemBuilder)))) {
      return false;
    }
    boolean bool2 = "2".equals(paramChatMessage.getExtInfoFromExtStr("app_qim_tail_id"));
    paramBoolean = bool1;
    if (a().b(paramQQAppInterface) == 1)
    {
      paramBoolean = bool1;
      if (!paramChatMessage.isSend()) {
        if (!bool2)
        {
          paramBoolean = bool1;
          if (!a().a(paramQQAppInterface, paramChatMessage.senderuin)) {}
        }
        else
        {
          paramBoolean = true;
        }
      }
    }
    return paramBoolean;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.jdField_d_of_type_Int;
  }
  
  public Drawable b(int paramInt)
  {
    Object localObject2 = new BitmapFactory.Options();
    Drawable localDrawable = null;
    Object localObject1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            localDrawable = (Drawable)GlobalImageCache.a.get("aio_qim_user_online_title_icon.png");
            localObject1 = localDrawable;
            if (localDrawable == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject1).append("aio_qim_user_online_title_icon.png");
              localObject1 = ImageUtil.a(((StringBuilder)localObject1).toString(), (BitmapFactory.Options)localObject2);
              localObject1 = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject1);
              ((Drawable)localObject1).setBounds(0, 0, ScreenUtil.dip2px(13.0F), ScreenUtil.dip2px(13.0F));
              return localObject1;
            }
          }
          else
          {
            if ((Drawable)GlobalImageCache.a.get("qim_title_immersive_bar.png") == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject1).append("qim_title_immersive_bar.png");
              localObject1 = ImageUtil.a(((StringBuilder)localObject1).toString(), (BitmapFactory.Options)localObject2);
              if (localObject1 != null) {
                return new BitmapDrawable((Bitmap)localObject1);
              }
            }
            return null;
          }
        }
        else
        {
          localDrawable = (Drawable)GlobalImageCache.a.get("aio_qim_online_icon.png");
          localObject1 = localDrawable;
          if (localDrawable == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject1).append("aio_qim_online_icon.png");
            localObject2 = ImageUtil.a(((StringBuilder)localObject1).toString(), (BitmapFactory.Options)localObject2);
            localObject1 = localDrawable;
            if (localObject2 != null)
            {
              localObject1 = new BitmapDrawable((Bitmap)localObject2);
              GlobalImageCache.a.put("skin_aio_qim_header_flag.png", localObject1);
              return localObject1;
            }
          }
        }
      }
      else
      {
        Object localObject3 = (Bitmap)GlobalImageCache.a.get("title_bg_round.9.png");
        if (localObject3 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("title_bg_round.9.png");
          localObject2 = ImageUtil.a(((StringBuilder)localObject1).toString(), (BitmapFactory.Options)localObject2);
          localObject1 = localDrawable;
          if (localObject2 != null)
          {
            GlobalImageCache.a.put("title_bg_round.9.png", localObject2);
            localObject3 = ((Bitmap)localObject2).getNinePatchChunk();
            localObject1 = localDrawable;
            if (localObject3 != null)
            {
              localObject1 = localDrawable;
              if (!NinePatch.isNinePatchChunk((byte[])localObject3)) {}
            }
          }
        }
        else
        {
          for (localObject1 = new NinePatchDrawable((Bitmap)localObject2, (byte[])localObject3, new Rect(), null);; localObject1 = new NinePatchDrawable((Bitmap)localObject3, (byte[])localObject2, new Rect(), null))
          {
            return localObject1;
            localObject2 = ((Bitmap)localObject3).getNinePatchChunk();
            localObject1 = localDrawable;
            if (localObject2 == null) {
              break;
            }
            localObject1 = localDrawable;
            if (!NinePatch.isNinePatchChunk((byte[])localObject2)) {
              break;
            }
          }
        }
      }
    }
    else
    {
      localDrawable = (Drawable)GlobalImageCache.a.get("skin_aio_qim_header_flag.png");
      localObject1 = localDrawable;
      if (localDrawable == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("skin_aio_qim_header_flag.png");
        localObject2 = ImageUtil.a(((StringBuilder)localObject1).toString(), (BitmapFactory.Options)localObject2);
        localObject1 = localDrawable;
        if (localObject2 != null)
        {
          localObject1 = new BitmapDrawable((Bitmap)localObject2);
          GlobalImageCache.a.put("skin_aio_qim_header_flag.png", localObject1);
        }
      }
    }
    return localObject1;
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
  
  public String c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager
 * JD-Core Version:    0.7.0.1
 */