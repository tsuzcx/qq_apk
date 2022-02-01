package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectURLImageView;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;

public class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter
  extends RecyclerView.Adapter<ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder>
{
  private List<ApolloBattleGameInfo> b;
  private final float c = ViewUtils.dip2px(6.0F);
  private final float d = ViewUtils.dip2px(5.0F);
  private final float[] e;
  
  public ApolloBattleGameViewBinder$ApolloBattleGameListAdapter(ApolloBattleGameViewBinder paramApolloBattleGameViewBinder)
  {
    float f = this.c;
    this.e = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, 0.0F, 0.0F };
  }
  
  private void a(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, ApolloBattleGameInfo paramApolloBattleGameInfo)
  {
    String str = paramApolloBattleGameInfo.background;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.a.setRadius(this.c);
      paramViewHoder.a.setImageURL(str);
      paramViewHoder.a.setVisibility(0);
    }
    else
    {
      paramViewHoder.a.setVisibility(8);
    }
    str = paramApolloBattleGameInfo.avatar;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.b.setRadius(this.d);
      paramViewHoder.b.setImageURL(str);
      paramViewHoder.b.setVisibility(0);
    }
    else
    {
      paramViewHoder.b.setVisibility(8);
    }
    paramViewHoder.c.setText(paramApolloBattleGameInfo.name);
    paramViewHoder.d.setText(paramApolloBattleGameInfo.gamerRange);
    str = paramApolloBattleGameInfo.footerIcon;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.f.setRadius(this.e);
      paramViewHoder.f.setImageURL(str);
      paramViewHoder.f.setVisibility(0);
    }
    else
    {
      paramViewHoder.f.setVisibility(8);
    }
    paramViewHoder.e.setOnClickListener(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.1(this, paramApolloBattleGameInfo));
    a(paramApolloBattleGameInfo, "game_expo");
    a(paramApolloBattleGameInfo, 101);
  }
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo, int paramInt)
  {
    if (paramApolloBattleGameInfo == null)
    {
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onItemTianshuReport] itemData is null");
      return;
    }
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    TianShuReportData localTianShuReportData = new TianShuReportData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(CommonDataAdapter.a().c()));
    localStringBuilder.append('_');
    localStringBuilder.append(i);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.p = paramInt;
    localTianShuReportData.q = 1;
    localTianShuReportData.h = String.valueOf(paramApolloBattleGameInfo.adId);
    localTianShuReportData.o = i;
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "tianshu.81";
    localTianShuReportData.j = "";
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo, String paramString)
  {
    if (paramApolloBattleGameInfo == null)
    {
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onItemDCReport] itemData is null");
      return;
    }
    switch (ApolloBattleGameViewBinder.a(this.a))
    {
    case 4020: 
    default: 
      str1 = null;
      str2 = str1;
      break;
    case 4022: 
      str2 = "cmgame_aio_cm_qun";
      break;
    case 4021: 
      str2 = "cmgame_aio_cm_c2c";
      str1 = "cmgame_aio_cm";
      break;
    case 4019: 
      str2 = "cmgame_aio_qun";
      break;
    }
    String str2 = "cmgame_aio_c2c";
    String str1 = "cmgame_aio";
    if (!TextUtils.isEmpty(str1))
    {
      String str3;
      if (TextUtils.isEmpty(paramApolloBattleGameInfo.footerIcon)) {
        str3 = "0";
      } else {
        str3 = "1";
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ(paramApolloBattleGameInfo.appid, str1, str2, paramString, str3, "", "", "");
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.a.i == null)
    {
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onHallButtonClick] mContext is null");
      return;
    }
    String str = this.a.m.b;
    if ((!paramBoolean) || (!TextUtils.equals(str, BaseApplicationImpl.getApplication().getRuntime().getAccount())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&gid=");
      localStringBuilder.append(str);
      localStringBuilder.append("&touin=");
      localStringBuilder.append(str);
      paramString = localStringBuilder.toString();
    }
    if (paramBoolean)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a.i, paramString, 4018, null);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a.i, paramString, 4019, null);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new SimpleMiniAppConfig.SimpleMiniAppInfo();
    ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject).appId = paramString1;
    localObject = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject);
    paramString1 = ((SimpleMiniAppConfig)localObject).launchParam;
    int i;
    if (paramBoolean) {
      i = 4018;
    } else {
      i = 4019;
    }
    paramString1.scene = i;
    if (paramBoolean) {
      paramString1 = "cmgame_aio_c2c";
    } else {
      paramString1 = "cmgame_aio_qun";
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async((SimpleMiniAppConfig)localObject, "cmgame_aio", paramString1, paramString2, "");
  }
  
  private void b(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, ApolloBattleGameInfo paramApolloBattleGameInfo)
  {
    boolean bool;
    if (this.a.m.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramApolloBattleGameInfo.background;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.a.setRadius(this.c);
      paramViewHoder.a.setImageURL(str);
      paramViewHoder.a.setVisibility(0);
      paramViewHoder.a.setOnClickListener(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2(this, bool, paramApolloBattleGameInfo));
    }
    else
    {
      paramViewHoder.a.setVisibility(8);
    }
    a(bool, paramApolloBattleGameInfo.appid, "store_expo");
  }
  
  public ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624191, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624192, paramViewGroup, false);
    }
    return new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder(this, paramViewGroup);
  }
  
  public void a(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > paramInt))
    {
      localObject = (ApolloBattleGameInfo)((List)localObject).get(paramInt);
      if (((ApolloBattleGameInfo)localObject).boxType == 0)
      {
        a(paramViewHoder, (ApolloBattleGameInfo)localObject);
        return;
      }
      if (((ApolloBattleGameInfo)localObject).boxType == 1)
      {
        b(paramViewHoder, (ApolloBattleGameInfo)localObject);
        return;
      }
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onBindViewHolder] itemData type error");
    }
  }
  
  public void a(List<ApolloBattleGameInfo> paramList)
  {
    this.b = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > paramInt) && (((ApolloBattleGameInfo)localList.get(paramInt)).boxType == 1)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter
 * JD-Core Version:    0.7.0.1
 */