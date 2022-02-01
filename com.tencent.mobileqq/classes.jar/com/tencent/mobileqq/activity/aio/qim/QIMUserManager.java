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
  public static String a = "qim_need_show_text_bubble";
  private static final String b;
  private static final String c;
  private static QIMUserManager e;
  private static final String g = HardCodeUtil.a(2131907532);
  private volatile int d = 0;
  private boolean f = false;
  private boolean h = false;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = g;
  private boolean p = false;
  private String q = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AIO_QIM_THEME_DIR);
    localStringBuilder.append("icons/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AIO_QIM_THEME_DIR);
    localStringBuilder.append("zip/");
    c = localStringBuilder.toString();
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
    Object localObject = new File(b);
    paramString2 = new File(c);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b);
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
      FileUtils.deleteFilesInDirectory(b);
    }
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    } else {
      FileUtils.deleteFilesInDirectory(c);
    }
    paramString2 = new StringBuilder();
    paramString2.append(c);
    paramString2.append("android_qim_theme_icons.zip");
    paramString1 = new DownloadTask(paramString1, new File(paramString2.toString()));
    paramString1.L = "profileCardDownload";
    paramString1.K = "VIP_profilecard";
    return DownloaderFactory.a(paramString1, null);
  }
  
  private boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c);
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
          FileUtils.deleteFilesInDirectory(b);
          ZipUtils.unZipFile((File)localObject, b);
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
  
  public static QIMUserManager b()
  {
    if (e == null) {
      e = new QIMUserManager();
    }
    return e;
  }
  
  private void c()
  {
    Object localObject2 = new File(b);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      Object localObject1 = BaseApplicationImpl.getApplication();
      int i1 = 0;
      localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("qim_theme_icon_names_sp", 0).edit();
      localObject2 = ((File)localObject2).list();
      StringBuilder localStringBuilder1 = new StringBuilder();
      while (i1 < localObject2.length)
      {
        String str = localObject2[i1].substring(localObject2[i1].lastIndexOf("/") + 1);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append("|");
        localStringBuilder1.append(localStringBuilder2.toString());
        i1 += 1;
      }
      ((SharedPreferences.Editor)localObject1).putString("android_qim_theme_icon_names", localStringBuilder1.toString());
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  private List<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getApplication();
    int i1 = 0;
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qim_theme_icon_names_sp", 0).getString("android_qim_theme_icon_names", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = ((String)localObject).split("\\|");
    } else {
      localObject = null;
    }
    if ((localObject != null) && (localObject.length > 0)) {
      while (i1 < localObject.length)
      {
        localArrayList.add(localObject[i1]);
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private void e()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).edit().remove("android_qim_theme_icon_names");
  }
  
  private void h(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!this.h) || (!this.q.equals(str)))
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
          this.i = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_title_bg_switch");
          this.j = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_bubble_switch");
          this.k = paramQQAppInterface.getInt(localStringBuilder.toString(), 0);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_resources_url");
          this.l = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_resources_md5");
          this.n = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_qim_website");
          this.m = paramQQAppInterface.getString(localStringBuilder.toString(), "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append("qim_user_special_config_online_wording");
          this.o = paramQQAppInterface.getString(localStringBuilder.toString(), g);
          this.p = paramQQAppInterface.getBoolean("qim_user_special_need_force_download", false);
        }
        this.q = str;
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mQimWebsite:%s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.j), this.l, this.n, this.o, Boolean.valueOf(this.p), this.m }));
        }
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.i;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new BitmapFactory.Options();
    if (paramInt != 2130852228) {
      return null;
    }
    Object localObject2 = (Drawable)GlobalImageCache.a.get("skin_header_bar.png");
    if (localObject2 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b);
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.h = true;
    this.i = paramInt1;
    this.j = paramInt2;
    this.l = paramString1;
    this.m = paramString2;
    this.n = paramString3;
    this.o = paramString4;
    this.p = paramBoolean;
    this.k = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("QIMUserManager", 2, String.format("setQimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, qimWebsite:%s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.j), this.l, this.n, this.o, Boolean.valueOf(this.p), paramString2 }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = e(paramQQAppInterface);
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
      localObject = ((FriendsManager)localObject).m(paramSessionInfo.b);
      if ((localObject != null) && (((Friends)localObject).netTypeIconId == 11))
      {
        boolean bool2 = true;
        paramSessionInfo.i = true;
        if (paramSessionInfo.i)
        {
          paramSessionInfo.k = ThemeUtil.isInNightMode(paramQQAppInterface);
          if ((c(paramQQAppInterface) == 1) || (a(paramQQAppInterface) == 1)) {
            if (g(paramQQAppInterface)) {
              a(paramQQAppInterface, true, d(paramQQAppInterface), f(paramQQAppInterface));
            } else if (!a()) {
              a(paramQQAppInterface, false, d(paramQQAppInterface), f(paramQQAppInterface));
            }
          }
          boolean bool3 = a();
          boolean bool1;
          if ((c(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramSessionInfo.l = bool1;
          if ((a(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramSessionInfo.n = bool1;
          if ((b(paramQQAppInterface) == 1) && (bool3)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          paramSessionInfo.p = bool1;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.d == 1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownLoadQimTheme QimIconsState ");
      localStringBuilder.append(this.d);
      QLog.i("QIMUserManager", 2, localStringBuilder.toString());
    }
    this.d = 1;
    e();
    if (paramBoolean)
    {
      ThreadManager.post(new QIMUserManager.1(this, paramString1, paramString2, paramQQAppInterface, paramBoolean), 8, null, true);
      return;
    }
    if (a(paramString2))
    {
      c();
      this.d = 2;
      return;
    }
    ThreadManager.post(new QIMUserManager.2(this, paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    int i1 = this.d;
    boolean bool3 = true;
    if (i1 == 2) {
      return true;
    }
    i1 = this.d;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool2 = bool1;
    if (i1 != 1)
    {
      bool2 = bool1;
      if (this.d != 3)
      {
        if (this.d == 4) {
          return false;
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isQimIconsOk QimIconsState ");
          ((StringBuilder)localObject1).append(this.d);
          QLog.i("QIMUserManager", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject3 = new File(b);
        bool1 = bool4;
        if (((File)localObject3).exists())
        {
          bool1 = bool4;
          if (((File)localObject3).isDirectory())
          {
            Object localObject2 = d();
            localObject1 = new ArrayList();
            localObject3 = ((File)localObject3).list();
            bool1 = bool4;
            if (localObject3 != null)
            {
              bool1 = bool4;
              if (localObject3.length > 0)
              {
                i1 = 0;
                while (i1 < localObject3.length)
                {
                  ((List)localObject1).add(localObject3[i1].substring(localObject3[i1].lastIndexOf("/") + 1));
                  i1 += 1;
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
          this.d = 2;
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.i) && (paramSessionInfo.p);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
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
    int i1 = b().a(paramQQAppInterface);
    boolean bool1 = true;
    if ((i1 == 1) && (!paramChatMessage.isSend()))
    {
      if (bool2) {
        break label64;
      }
      if (b().a(paramQQAppInterface, paramChatMessage.senderuin)) {
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
    if (b().b(paramQQAppInterface) == 1)
    {
      paramBoolean = bool1;
      if (!paramChatMessage.isSend()) {
        if (!bool2)
        {
          paramBoolean = bool1;
          if (!b().a(paramQQAppInterface, paramChatMessage.senderuin)) {}
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
    h(paramQQAppInterface);
    return this.k;
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
              ((StringBuilder)localObject1).append(b);
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
              ((StringBuilder)localObject1).append(b);
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
            ((StringBuilder)localObject1).append(b);
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
          ((StringBuilder)localObject1).append(b);
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
        ((StringBuilder)localObject1).append(b);
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
  
  public int c(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.j;
  }
  
  public String d(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.l;
  }
  
  public String e(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.m;
  }
  
  public String f(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.n;
  }
  
  public boolean g(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager
 * JD-Core Version:    0.7.0.1
 */