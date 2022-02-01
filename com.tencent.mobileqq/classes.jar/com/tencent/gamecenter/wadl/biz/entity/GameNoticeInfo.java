package com.tencent.gamecenter.wadl.biz.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Date;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class GameNoticeInfo
  extends Entity
  implements Cloneable
{
  public static final String DOWNLOAD_MANAGER_PAGE = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  public static final String GAME_DETAIL_PAGE_TEMPLATE = "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1";
  public static final long HOUR_8 = 28800000L;
  public static final String KEY_APPID = "appid";
  public static final String KEY_APP_ICON = "app_icon";
  private static final String KEY_END_TIME = "endts";
  private static final String KEY_EXPE_ID = "expe_id";
  private static final String KEY_EXPE_KEY = "expe_key";
  public static final String KEY_ICON_URL = "iconURL";
  public static final String KEY_INSTALL_DEF_TIPS = "default_install_bartips_text";
  public static final String KEY_INSTALL_TIPS = "install_bartips";
  private static final String KEY_JUMP_URL = "jumpurl";
  public static final String KEY_REG_DEF_TIPS = "default_register_bartips_text";
  public static final String KEY_REG_TIPS = "register_bartips";
  private static final String KEY_START_TIME = "startts";
  private static final String KEY_TEXT = "text";
  public static final String KEY_TIPS = "tips";
  public static final String KEY_TIPS_GRAY = "install_tips_gray";
  public static final String KEY_URL = "url";
  public static final String KEY_VALID = "valid";
  public static final long MIN_5 = 300000L;
  public static final String SP_NAME_WADL_TIPSINFO = "wadl_TipInfo";
  public static final String TAG = "Wadl_GameNoticeInfo";
  public static final int TYPE_INSTALL = 1;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_REGISTER = 2;
  public String apkChannel;
  @unique
  public String appId = "";
  public String appName;
  public int bannerType;
  public long createTime;
  public int downloadType;
  public long endTime;
  @notColumn
  public String expeKey;
  public String filePath;
  @notColumn
  public String iconUrl;
  @notColumn
  public boolean infoRequested;
  @notColumn
  public boolean isGray;
  public String jumpUrl;
  public String packageName;
  public long startTime;
  public String title;
  public int versionCode;
  
  public GameNoticeInfo() {}
  
  public GameNoticeInfo(WadlResult paramWadlResult, Context paramContext)
  {
    this.appId = paramWadlResult.a.a;
    this.appName = paramWadlResult.a.j;
    this.packageName = paramWadlResult.a.f;
    this.versionCode = paramWadlResult.a.e;
    this.apkChannel = paramWadlResult.a.c;
    this.filePath = paramWadlResult.jdField_b_of_type_JavaLangString;
    this.createTime = paramWadlResult.c;
    this.downloadType = paramWadlResult.a.d;
    this.bannerType = convertToBannerType(paramWadlResult);
    setTipsInfo(paramContext);
  }
  
  public static int convertToBannerType(WadlResult paramWadlResult)
  {
    if (paramWadlResult.jdField_b_of_type_Int == 9)
    {
      if (PackageUtil.a(MobileQQ.sMobileQQ, paramWadlResult.a.f)) {
        return 2;
      }
      paramWadlResult.jdField_b_of_type_Int = 6;
    }
    if ((paramWadlResult.jdField_b_of_type_Int == 6) && (FileUtils.fileExists(paramWadlResult.jdField_b_of_type_JavaLangString))) {
      return 1;
    }
    return 0;
  }
  
  private boolean readTipInfo()
  {
    if (TextUtils.isEmpty(this.appId)) {
      return false;
    }
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("wadl_TipInfo", 4);
    int i = this.bannerType;
    Object localObject3;
    if (i == 1)
    {
      localObject1 = localSharedPreferences.getString("default_install_bartips_text", null);
      localObject3 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
    }
    else if (i == 2)
    {
      localObject1 = localSharedPreferences.getString("default_register_bartips_text", null);
      localObject3 = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { this.appId });
    }
    else
    {
      localObject1 = null;
      localObject3 = localObject1;
    }
    boolean bool;
    if ((localObject1 != null) && (localObject3 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.appName);
      localStringBuilder.append((String)localObject1);
      this.title = localStringBuilder.toString();
      this.jumpUrl = ((String)localObject3);
      bool = true;
    }
    else
    {
      bool = false;
    }
    Object localObject1 = localSharedPreferences.getString(this.appId, null);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject((String)localObject1);
        if (this.bannerType == 1)
        {
          localObject1 = ((JSONObject)localObject3).optJSONObject("install_bartips");
        }
        else
        {
          if (this.bannerType != 2) {
            break label411;
          }
          localObject1 = ((JSONObject)localObject3).optJSONObject("register_bartips");
        }
        this.iconUrl = ((JSONObject)localObject3).optString("app_icon", null);
        localObject3 = ((JSONObject)localObject3).optString("install_tips_gray");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label417;
        }
        localObject3 = new JSONObject((String)localObject3);
        if (localObject3 != null)
        {
          this.expeKey = ((JSONObject)localObject3).optString("expe_key", null);
          if (!TextUtils.isEmpty(this.expeKey)) {
            this.isGray = true;
          }
        }
        if (localObject1 != null)
        {
          long l1 = NetConnInfoCenter.getServerTime();
          long l2 = ((JSONObject)localObject1).optLong("startts", 0L);
          long l3 = ((JSONObject)localObject1).optLong("endts", 9223372036854775807L);
          if ((l2 <= l1) && (l1 <= l3))
          {
            this.title = ((JSONObject)localObject1).getString("text");
            this.jumpUrl = ((JSONObject)localObject1).getString("jumpurl");
            QLog.d("Wadl_GameNoticeInfo", 1, new Object[] { "readTipInfo: ", this });
            return true;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Wadl_GameNoticeInfo", 1, localJSONException, new Object[0]);
      }
      return bool;
      label411:
      Object localObject2 = null;
      continue;
      label417:
      localObject3 = null;
    }
  }
  
  public Object clone()
  {
    try
    {
      localGameNoticeInfo = (GameNoticeInfo)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      GameNoticeInfo localGameNoticeInfo;
      label11:
      break label11;
    }
    localGameNoticeInfo = null;
    localGameNoticeInfo.appId = this.appId;
    localGameNoticeInfo.packageName = this.packageName;
    localGameNoticeInfo.versionCode = this.versionCode;
    localGameNoticeInfo.apkChannel = this.apkChannel;
    localGameNoticeInfo.appName = this.appName;
    localGameNoticeInfo.filePath = this.filePath;
    localGameNoticeInfo.bannerType = this.bannerType;
    localGameNoticeInfo.title = this.title;
    localGameNoticeInfo.jumpUrl = this.jumpUrl;
    localGameNoticeInfo.startTime = this.startTime;
    localGameNoticeInfo.endTime = this.endTime;
    localGameNoticeInfo.createTime = this.createTime;
    localGameNoticeInfo.infoRequested = this.infoRequested;
    localGameNoticeInfo.iconUrl = this.iconUrl;
    localGameNoticeInfo.downloadType = this.downloadType;
    return localGameNoticeInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (GameNoticeInfo)paramObject;
      if (this.bannerType == paramObject.bannerType)
      {
        if (this.createTime != paramObject.createTime) {
          return false;
        }
        return this.appId.equals(paramObject.appId);
      }
    }
    return false;
  }
  
  public String getReportType()
  {
    int i = this.downloadType;
    if (i == 1) {
      return "2";
    }
    if (i == 3) {
      return "1";
    }
    return "0";
  }
  
  public boolean isValid()
  {
    if ((!TextUtils.isEmpty(this.appId)) && (this.bannerType != 0) && (this.startTime >= 1L))
    {
      if (this.endTime < 1L) {
        return false;
      }
      long l = System.currentTimeMillis();
      Object localObject;
      if (this.endTime < l)
      {
        localObject = new Date();
        ((Date)localObject).setTime(this.endTime);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isValid time expired, continue! endTime=");
        localStringBuilder.append(localObject);
        QLog.w("Wadl_GameNoticeInfo", 1, localStringBuilder.toString());
        return false;
      }
      int i = this.bannerType;
      if (i == 1)
      {
        if (TextUtils.isEmpty(this.filePath))
        {
          QLog.w("Wadl_GameNoticeInfo", 1, "isValid filePath is empty");
          return false;
        }
        if (!new File(this.filePath).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isValid file not exists filePath=");
          ((StringBuilder)localObject).append(this.filePath);
          QLog.w("Wadl_GameNoticeInfo", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        i = GameCenterUtil.a(this.packageName);
        if (i > 0)
        {
          int j = this.versionCode;
          if ((j > 0) && (i >= j))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isValid installVersion=");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(",versionCode=");
            ((StringBuilder)localObject).append(this.versionCode);
            QLog.w("Wadl_GameNoticeInfo", 1, ((StringBuilder)localObject).toString());
            return false;
          }
        }
        return true;
      }
      if (i == 2) {
        return GameCenterUtil.a(this.packageName) >= 1;
      }
    }
    return false;
  }
  
  public void setTipsInfo(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    long l2 = GameCenterSpUtils.a("MILLISECONDS_DELAY");
    long l3 = GameCenterSpUtils.a("MILLISECONDS_INTERVAL");
    long l1 = l2;
    if (l2 < 1L) {
      l1 = 300000L;
    }
    l2 = l3;
    if (l3 < 1L) {
      l2 = 28800000L;
    }
    paramContext = new StringBuilder();
    paramContext.append("setTipsInfo bannerType=");
    paramContext.append(this.bannerType);
    paramContext.append(",spDelay=");
    paramContext.append(l1);
    paramContext.append(",spInterval=");
    paramContext.append(l2);
    QLog.d("Wadl_GameNoticeInfo", 1, paramContext.toString());
    int i = this.bannerType;
    if (i == 1)
    {
      if (!TextUtils.isEmpty(this.filePath))
      {
        paramContext = new File(this.filePath);
        if (paramContext.exists())
        {
          this.startTime = (paramContext.lastModified() + l1);
          this.endTime = (this.startTime + l2);
          if (!readTipInfo())
          {
            paramContext = new StringBuilder();
            paramContext.append(this.appName);
            paramContext.append(HardCodeUtil.a(2131705155));
            this.title = paramContext.toString();
            this.jumpUrl = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
          }
        }
      }
    }
    else if (i == 2)
    {
      paramContext = GameCenterUtil.a(this.packageName);
      if (paramContext != null)
      {
        this.startTime = (paramContext.firstInstallTime + l1);
        this.endTime = (this.startTime + l2);
        if (!readTipInfo())
        {
          paramContext = new StringBuilder();
          paramContext.append(this.appName);
          paramContext.append(HardCodeUtil.a(2131705154));
          this.title = paramContext.toString();
          this.jumpUrl = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { this.appId });
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameNoticeInfo {");
    localStringBuilder.append("appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(",packageName=");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append(",iconUrl=");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append(",appName=");
    localStringBuilder.append(this.appName);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append(",bannerType=");
    localStringBuilder.append(this.bannerType);
    localStringBuilder.append(",startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(",endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(",infoRequested=");
    localStringBuilder.append(this.infoRequested);
    localStringBuilder.append(",title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(",jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append(",createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(",downloadType=");
    localStringBuilder.append(this.downloadType);
    localStringBuilder.append(",isGray=");
    localStringBuilder.append(this.isGray);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo
 * JD-Core Version:    0.7.0.1
 */