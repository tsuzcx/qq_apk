package com.tencent.mobileqq.activity.aio.pluspanel;

import ahmu;
import ahve;
import ahvi;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import azlv;
import bhgd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public abstract class PlusPanelAppInfo
  implements Serializable, Comparable<PlusPanelAppInfo>
{
  static final long serialVersionUID = 1L;
  public String action;
  public String actionType;
  public int appid;
  public boolean canRemove;
  public String enName;
  public int enableC2C;
  public int enableGroup;
  public int groupType;
  public String hashVal;
  public String iconPress;
  public String iconUrl;
  public String iconYouth;
  public int identifyMask = 31;
  public boolean isGray;
  public String minVersion;
  public String name;
  public boolean redPoint;
  public String simpleDayPressUrl;
  public String simpleDayUrl;
  public String simpleNightPressUrl;
  public String simpleNightUrl;
  public int sort;
  public int uinType;
  public String url;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString1;
      if (paramString1.contains("$TOUIN$"))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2)) {
          str = paramString1.replace("$TOUIN$", paramString2);
        }
      }
    }
    return str;
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2)
  {
    QLog.i("PlusPanelAppInfo", 2, "onMiniAppJump jumpUrl:" + paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (MiniAppLauncher.isMiniAppUrl(paramString1)))
    {
      MiniAppLauncher.startMiniApp(paramContext, a(paramString1, paramString2), 2053, null);
      return true;
    }
    return false;
  }
  
  public int compareTo(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    if (paramPlusPanelAppInfo != null) {
      return this.sort - paramPlusPanelAppInfo.sort;
    }
    return 0;
  }
  
  public azlv createConfigProcessor()
  {
    return new ahve(this);
  }
  
  public abstract int defaultDrawableID();
  
  public abstract int getAppID();
  
  public String getAppName()
  {
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return getTitle();
  }
  
  public int getManageConfigID()
  {
    return 0;
  }
  
  public int getRedDotID()
  {
    return 0;
  }
  
  public abstract String getTitle();
  
  public void handlePanelClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    boolean bool1 = false;
    if ("miniapp".equals(this.actionType)) {
      bool1 = a(paramBaseChatPie.getActivity(), this.action, paramBaseChatPie.sessionInfo.curFriendUin);
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if ("web".equals(this.actionType)) {
        bool2 = a(paramBaseChatPie.getActivity(), this.action);
      }
    }
    if (!bool2) {
      onPlusPanelAppClick(paramahvi, paramBaseChatPie, paramSessionInfo);
    }
  }
  
  public void init()
  {
    this.appid = 0;
    this.enableC2C = 0;
    this.enableGroup = 0;
    this.sort = 0;
    this.groupType = 0;
    this.identifyMask = 0;
    this.uinType = 0;
    this.name = "";
    this.enName = "";
    this.url = "";
    this.iconUrl = "";
    this.iconPress = "";
    this.simpleDayUrl = "";
    this.simpleDayPressUrl = "";
    this.simpleNightUrl = "";
    this.simpleNightPressUrl = "";
    this.iconYouth = "";
    this.actionType = "";
    this.action = "";
    this.hashVal = "";
    this.minVersion = "";
    this.isGray = false;
    this.canRemove = false;
  }
  
  protected boolean isC2C()
  {
    return this.uinType == 0;
  }
  
  protected boolean isDiscussion()
  {
    return this.uinType == 3000;
  }
  
  protected boolean isTroop()
  {
    return this.uinType == 1;
  }
  
  protected abstract void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo);
  
  protected void showSelGAudioChatEntryActionSheet(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt == 10) {
      bhgd.b(paramBoolean);
    }
    ahmu.a(paramBaseChatPie.app, paramBaseChatPie.mActivity, paramSessionInfo, paramInt, paramBoolean, paramBaseChatPie.app.getCurrentUin(), paramString);
    paramBaseChatPie.hidePanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
 * JD-Core Version:    0.7.0.1
 */