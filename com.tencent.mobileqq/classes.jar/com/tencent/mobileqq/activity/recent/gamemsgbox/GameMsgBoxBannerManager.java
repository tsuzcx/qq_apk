package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GameMsgBoxBannerManager
  implements View.OnClickListener
{
  private View a;
  private View b;
  private LinearLayout c;
  private GameMsgBoxBannerInfo d;
  private TianShuGetAdvCallback e = new -..Lambda.GameMsgBoxBannerManager.f88BUyczWAn3SFQubdlhq2mRXe4(this);
  private DownloadParams.DecodeHandler f = new -..Lambda.GameMsgBoxBannerManager.SxQBteoNZp0RBACCdEs9mS9_Jsc(this);
  
  public GameMsgBoxBannerManager(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a = View.inflate(paramContext, 2131624888, null);
    this.c = ((LinearLayout)this.a.findViewById(2131433996));
    this.c.setVisibility(8);
    a(paramContext, ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null));
  }
  
  private String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      paramString = new JSONObject(paramString).optString("msg_id");
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("GameMsgBoxBannerManager", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("GameMsgBoxBannerManager", 1, new Object[] { "report2Tianshu action:", Integer.valueOf(paramInt), ", itemId=", paramString1, ",traceInfo=", paramString2 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "52";
    localTianShuReportData.g = "52";
    localTianShuReportData.h = paramString1;
    localTianShuReportData.i = "";
    localTianShuReportData.o = l;
    localTianShuReportData.p = paramInt;
    localTianShuReportData.q = 1;
    localTianShuReportData.r = 1;
    localTianShuReportData.s = paramString2;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      GradientDrawable localGradientDrawable = (GradientDrawable)paramContext.getDrawable(2130840493);
      localGradientDrawable.setColor(Color.parseColor(paramString1));
      ((LinearLayout)this.a.findViewById(2131437461)).setBackgroundDrawable(localGradientDrawable);
      ((TextView)this.a.findViewById(2131448593)).setTextColor(Color.parseColor(paramString2));
      ((ImageView)this.a.findViewById(2131436258)).setImageDrawable(paramContext.getResources().getDrawable(paramInt));
      this.c.setBackgroundColor(Color.parseColor(paramString3));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("GameMsgBoxBannerManager", 1, paramContext, new Object[0]);
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, "#FF1C1D1E", "#FF8E8E93", "#000000", 2130842437);
      return;
    }
    a(paramContext, "#FF28B9FF", "#FFFFFFFF", "#FFFFFFFF", 2130840492);
  }
  
  private void a(GameMsgBoxBannerInfo paramGameMsgBoxBannerInfo)
  {
    if (paramGameMsgBoxBannerInfo == null) {
      return;
    }
    this.a.setOnClickListener(this);
    c();
    ImageView localImageView = (ImageView)this.a.findViewById(2131436403);
    TextView localTextView = (TextView)this.a.findViewById(2131448593);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DisplayUtils.a(this.a.getContext(), 24.0F));
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)DisplayUtils.a(this.a.getContext(), 24.0F));
    Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130841060);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    localObject = URLDrawable.getDrawable(paramGameMsgBoxBannerInfo.c, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setDecodeHandler(this.f);
    ((URLDrawable)localObject).startDownload();
    localImageView.setImageDrawable((Drawable)localObject);
    if (!TextUtils.isEmpty(paramGameMsgBoxBannerInfo.d)) {
      localTextView.setText(paramGameMsgBoxBannerInfo.d);
    }
    this.c.setVisibility(0);
    QLog.i("GameMsgBoxBannerManager", 1, "[showBanner] ends");
    h();
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    try
    {
      QLog.i("GameMsgBoxBannerManager", 1, "[handleSingleAdItem]");
      if (paramAdItem == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      Object localObject1 = paramAdItem.argList.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        localHashMap.put(((TianShuAccess.MapEntry)localObject2).key.get(), ((TianShuAccess.MapEntry)localObject2).value.get());
      }
      localObject1 = (String)localHashMap.get("pic");
      Object localObject2 = (String)localHashMap.get("text");
      String str1 = (String)localHashMap.get("url");
      String str2 = (String)localHashMap.get("busi_id");
      int i = Integer.parseInt((String)localHashMap.get("type"));
      this.d = new GameMsgBoxBannerInfo();
      this.d.c = ((String)localObject1);
      this.d.d = ((String)localObject2);
      this.d.e = str1;
      this.d.g = str2;
      this.d.b = i;
      this.d.a = String.valueOf(paramAdItem.iAdId.get());
      this.d.f = a(str2);
      this.d.h = paramAdItem.traceinfo.get();
      paramAdItem = new StringBuilder();
      paramAdItem.append("avatarUrl:");
      paramAdItem.append((String)localObject1);
      paramAdItem.append(",wording:");
      paramAdItem.append((String)localObject2);
      paramAdItem.append(",busInf:");
      paramAdItem.append(str2);
      paramAdItem.append(",jumpUrl:");
      paramAdItem.append(str1);
      paramAdItem.append(",type:");
      paramAdItem.append(i);
      paramAdItem.append(",reportId:");
      paramAdItem.append(this.d.f);
      QLog.i("GameMsgBoxBannerManager", 1, paramAdItem.toString());
      ThreadManager.getUIHandler().post(new -..Lambda.GameMsgBoxBannerManager.Bb3RqY6ZcSE8yLuVRXoQYpgXz7Q(this));
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle("QQGameCenter", "game_msg_box", null);
      return;
    }
    catch (Throwable paramAdItem)
    {
      e();
      QLog.e("GameMsgBoxBannerManager", 1, paramAdItem.getMessage());
    }
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    for (;;)
    {
      try
      {
        if (paramGetAdsRsp.mapAds.has())
        {
          paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
          if ((paramGetAdsRsp != null) && (paramGetAdsRsp.size() != 0))
          {
            paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.get(0);
            if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst != null))
            {
              paramGetAdsRsp = paramGetAdsRsp.value.lst.get();
              if ((paramGetAdsRsp != null) && (paramGetAdsRsp.size() != 0))
              {
                a((TianShuAccess.AdItem)paramGetAdsRsp.get(0));
                return;
              }
              QLog.i("GameMsgBoxBannerManager", 1, "no ads item~");
              e();
              return;
            }
            QLog.i("GameMsgBoxBannerManager", 1, "ads resp param is error.");
            e();
            return;
          }
          e();
          return;
        }
      }
      catch (Throwable paramGetAdsRsp)
      {
        e();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleGetAdvCallback], error happens! ");
        localStringBuilder.append(paramGetAdsRsp.getMessage());
        QLog.e("GameMsgBoxBannerManager", 1, localStringBuilder.toString());
        return;
      }
      paramGetAdsRsp = null;
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(paramContext, JumpActivity.class);
      localIntent.setData(Uri.parse(paramString));
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)this.a.findViewById(2131437461)).getLayoutParams();
      localLayoutParams.height = ((int)DisplayUtils.a(this.a.getContext(), 40.0F));
      int i = (int)DisplayUtils.a(this.a.getContext(), 12.0F);
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setBannerHeight]:");
      localStringBuilder.append(localThrowable);
      QLog.e("GameMsgBoxBannerManager", 1, localStringBuilder.toString());
    }
  }
  
  private List<TianShuAdPosItemData> d()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.b = 1;
    localTianShuAdPosItemData.a = 889;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new -..Lambda.GameMsgBoxBannerManager.hWBVs6GgJTE8PxvlrVlUSotW05g(this));
  }
  
  private boolean f()
  {
    Object localObject = ABTestController.a().a("exp_game_box_banner");
    boolean bool;
    if ((localObject != null) && (((ExpEntityInfo)localObject).f())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isExp:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("GameMsgBoxBannerManager", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private boolean g()
  {
    Object localObject = ABTestController.a().a("exp_game_box_banner");
    boolean bool;
    if ((localObject != null) && (((ExpEntityInfo)localObject).g())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isComp:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("GameMsgBoxBannerManager", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void h()
  {
    if (this.d == null) {
      return;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92045", "209160", this.d.f, "", "8", "");
    a(101, this.d.a, this.d.h);
  }
  
  private void i()
  {
    if (this.d == null) {
      return;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92045", "209161", this.d.f, "", "20", "");
    a(102, this.d.a, this.d.h);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void b()
  {
    QLog.i("GameMsgBoxBannerManager", 1, "[requestAdv]");
    ThreadManager.getSubThreadHandler().post(new -..Lambda.GameMsgBoxBannerManager.L9n3Yw4TfW_cK7rQuQlKrUR4gVI(this));
  }
  
  public void onClick(View paramView)
  {
    if ((this.d != null) && (paramView.getId() == 2131433996))
    {
      e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpType:");
      localStringBuilder.append(this.d.b);
      QLog.i("GameMsgBoxBannerManager", 1, localStringBuilder.toString());
      int i = this.d.b;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            QLog.w("GameMsgBoxBannerManager", 1, "invalid jump type.");
          } else {
            a(this.c.getContext(), this.d.e);
          }
        }
        else {
          b(this.c.getContext(), this.d.e);
        }
        i();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxBannerManager
 * JD-Core Version:    0.7.0.1
 */