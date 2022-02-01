package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeShoppingBean;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.ilive.util.IlivePreloadHelper;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSettingMeShoppingProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeShoppingBean> b = new MutableLiveData();
  public MutableLiveData<QQSettingMeDynamicItemBean> i = new MutableLiveData();
  
  private String a(String paramString1, String paramString2)
  {
    if (IliveRedManager.isRecomRedJumpUrl(paramString2)) {
      return paramString2;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  private void a()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.c);
    Object localObject2 = Integer.valueOf(1);
    Object localObject3 = (MenumItem)((Map)localObject1).get(localObject2);
    if (localObject3 == null) {
      return;
    }
    localObject1 = new QQSettingMeDynamicItemBean();
    ((QQSettingMeDynamicItemBean)localObject1).a = QQSettingConfigManager.a().b((Integer)localObject2);
    if (!TextUtils.isEmpty(((MenumItem)localObject3).title)) {
      ((QQSettingMeDynamicItemBean)localObject1).b = ChatRoomUtil.a(((MenumItem)localObject3).title, 16);
    }
    if (!TextUtils.isEmpty(((MenumItem)localObject3).icon))
    {
      localObject2 = ((MenumItem)localObject3).icon;
      localObject3 = URLDrawableHelperConstants.a;
      ((QQSettingMeDynamicItemBean)localObject1).c = VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 1 }, (Drawable)localObject3, null, null);
    }
    this.i.postValue(localObject1);
  }
  
  public String a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = (String)RoomManager.a(paramString).get("trace_info");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ad_id", paramLong);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      return UriUtil.b(paramString, "trace_info", ((JSONObject)localObject).toString());
    }
    localObject = Uri.decode((String)localObject);
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("ad_id", paramLong);
      localObject = UriUtil.b(paramString, "trace_info", ((JSONObject)localObject).toString());
      return localObject;
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    return paramString;
  }
  
  public void a(View paramView)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfo(1, String.valueOf(101100));
    int j;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      j = 1;
    } else {
      j = 0;
    }
    String str1 = IliveRedManager.parseShopRedBuffer(localAppInfo);
    String str2 = IliveDbManager.getIliveDrawerData("drawer_shop_jump_scheme");
    paramView = IliveRedManager.getDrawerLiveReportStr2(localAppInfo);
    IliveRedManager.sRedShoppingStr2 = paramView;
    IliveShareHelper.reportAction("qq_live", "chouti_page", "zhibo", "zhibo_button", "4", 102, IliveShareHelper.getFollowInfo("", paramView, "", "", ""));
    Object localObject = this.c;
    if (j != 0) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B1F7", "0X800B1F7", 0, 0, paramView, "", "", "");
    localObject = a(str1, str2);
    long l = IliveRedManager.getRedAdId(localAppInfo);
    paramView = (View)localObject;
    if (l > 0L) {
      paramView = a((String)localObject, l);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Ilive start jump shop , redJumpUrl = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" \nshopJumpUrl = ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("\nfinalJump = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("IliveRed", 2, ((StringBuilder)localObject).toString());
    }
    if (j != 0) {
      localIRedTouchManager.reportLevelOneRedInfo(101100, 31);
    }
    if (URLUtil.isNetworkUrl(paramView))
    {
      localObject = new Intent(this.d, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.d.startActivity((Intent)localObject);
      return;
    }
    paramView = JumpParser.a((QQAppInterface)this.c, this.d, paramView);
    if (paramView != null)
    {
      paramView.a();
      return;
    }
    ShoppingFragment.a(this.d, IliveDbManager.getILiveEnterInfo(1));
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeShoppingProcessor.1(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeShoppingProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    super.a(((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(101100)), paramBoolean);
  }
  
  public String b()
  {
    return "d_qq_shopping";
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.c;
    if (paramBoolean) {
      paramAppInfo = "1";
    } else {
      paramAppInfo = "2";
    }
    ReportController.b(localAppRuntime, "dc00898", "", "", "0X800B1F6", "0X800B1F6", 0, 0, paramAppInfo, "", "", "");
  }
  
  public void c()
  {
    a();
  }
  
  public void d()
  {
    super.d();
    a();
    i();
  }
  
  public void h()
  {
    a();
    i();
  }
  
  public void i()
  {
    QQSettingMeShoppingBean localQQSettingMeShoppingBean = new QQSettingMeShoppingBean();
    boolean bool;
    if ((IliveEntranceUtil.d()) && (!StudyModeManager.h())) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMeShoppingBean.a = bool;
    if (QQSettingConfigManager.a().a((QQAppInterface)this.c, 2))
    {
      this.b.postValue(localQQSettingMeShoppingBean);
      return;
    }
    localQQSettingMeShoppingBean.b = IliveDbManager.getILiveEnterInfo(1);
    if ((!SubscribeUtils.a()) && (!QQTheme.isNowSimpleUI())) {
      localQQSettingMeShoppingBean.c = IliveDbManager.getILiveEnterInfo(2);
    }
    this.b.postValue(localQQSettingMeShoppingBean);
  }
  
  public void j()
  {
    if (QQSettingMe.b("d_qq_shopping").getVisibility() == 0) {
      IlivePreloadHelper.a(BaseApplicationImpl.getApplication(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeShoppingProcessor
 * JD-Core Version:    0.7.0.1
 */