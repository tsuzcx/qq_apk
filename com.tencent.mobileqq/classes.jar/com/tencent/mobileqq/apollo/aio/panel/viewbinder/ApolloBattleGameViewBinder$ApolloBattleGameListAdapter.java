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
  private final float jdField_a_of_type_Float = ViewUtils.a(6.0F);
  private List<ApolloBattleGameInfo> jdField_a_of_type_JavaUtilList;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private final float b = ViewUtils.a(5.0F);
  
  public ApolloBattleGameViewBinder$ApolloBattleGameListAdapter(ApolloBattleGameViewBinder paramApolloBattleGameViewBinder)
  {
    float f = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, 0.0F, 0.0F };
  }
  
  private void a(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, ApolloBattleGameInfo paramApolloBattleGameInfo)
  {
    String str = paramApolloBattleGameInfo.background;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setRadius(this.jdField_a_of_type_Float);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setImageURL(str);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(0);
    }
    else
    {
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(8);
    }
    str = paramApolloBattleGameInfo.avatar;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setRadius(this.b);
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setImageURL(str);
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(0);
    }
    else
    {
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(8);
    }
    paramViewHoder.jdField_a_of_type_AndroidWidgetTextView.setText(paramApolloBattleGameInfo.name);
    paramViewHoder.jdField_b_of_type_AndroidWidgetTextView.setText(paramApolloBattleGameInfo.gamerRange);
    str = paramApolloBattleGameInfo.footerIcon;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.c.setRadius(this.jdField_a_of_type_ArrayOfFloat);
      paramViewHoder.c.setImageURL(str);
      paramViewHoder.c.setVisibility(0);
    }
    else
    {
      paramViewHoder.c.setVisibility(8);
    }
    paramViewHoder.jdField_a_of_type_AndroidViewView.setOnClickListener(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.1(this, paramApolloBattleGameInfo));
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
    localStringBuilder.append(String.valueOf(CommonDataAdapter.a().a()));
    localStringBuilder.append('_');
    localStringBuilder.append(i);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = String.valueOf(paramApolloBattleGameInfo.adId);
    localTianShuReportData.jdField_a_of_type_Long = i;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.81";
    localTianShuReportData.i = "";
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo, String paramString)
  {
    if (paramApolloBattleGameInfo == null)
    {
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onItemDCReport] itemData is null");
      return;
    }
    switch (ApolloBattleGameViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder))
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_AndroidContentContext == null)
    {
      QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, "[onHallButtonClick] mContext is null");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
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
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_AndroidContentContext, paramString, 4018, null);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_AndroidContentContext, paramString, 4019, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramApolloBattleGameInfo.background;
    if (!TextUtils.isEmpty(str))
    {
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setRadius(this.jdField_a_of_type_Float);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setImageURL(str);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(0);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setOnClickListener(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2(this, bool, paramApolloBattleGameInfo));
    }
    else
    {
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(8);
    }
    a(bool, paramApolloBattleGameInfo.appid, "store_expo");
  }
  
  public ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558626, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558627, paramViewGroup, false);
    }
    return new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder(this, paramViewGroup);
  }
  
  public void a(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt) && (((ApolloBattleGameInfo)localList.get(paramInt)).boxType == 1)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter
 * JD-Core Version:    0.7.0.1
 */