package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCmdService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectURLImageView;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter
  extends RecyclerView.Adapter<ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder>
{
  private final float jdField_a_of_type_Float = ViewUtils.a(6.0F);
  private List<ApolloBattleGameInfo> jdField_a_of_type_JavaUtilList;
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, 0.0F, 0.0F };
  private final float b = ViewUtils.a(5.0F);
  
  public ApolloBattleGameViewBinder$ApolloBattleGameListAdapter(ApolloBattleGameViewBinder paramApolloBattleGameViewBinder) {}
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo)
  {
    if (paramApolloBattleGameInfo == null) {
      QLog.e("ApolloBattleGameViewBinder", 1, "[onActionButtonClick] itemData is null");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_AndroidContentContext;
    IMiniCmdService localIMiniCmdService = (IMiniCmdService)QRoute.api(IMiniCmdService.class);
    paramApolloBattleGameInfo = paramApolloBattleGameInfo.appid;
    if (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {}
    for (int i = 1;; i = 0)
    {
      localIMiniCmdService.createUpdatableMsg(paramApolloBattleGameInfo, "657667B4D8C04B3F84E4AAA3D046A903", 1, i, ApolloBattleGameViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder), this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, null, new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2(this, localActivity));
      return;
    }
  }
  
  private void a(ApolloBattleGameInfo paramApolloBattleGameInfo, int paramInt)
  {
    if (paramApolloBattleGameInfo == null)
    {
      QLog.e("ApolloBattleGameViewBinder", 1, "[onItemTianshuReport] itemData is null");
      return;
    }
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.b = (String.valueOf(CommonDataAdapter.a().a()) + '_' + i);
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
    String str1 = null;
    if (paramApolloBattleGameInfo == null) {
      QLog.e("ApolloBattleGameViewBinder", 1, "[onItemDCReport] itemData is null");
    }
    Object localObject;
    do
    {
      return;
      switch (ApolloBattleGameViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder))
      {
      case 4020: 
      default: 
        localObject = null;
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (TextUtils.isEmpty(paramApolloBattleGameInfo.footerIcon)) {}
    for (String str2 = "0";; str2 = "1")
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ(paramApolloBattleGameInfo.appid, (String)localObject, str1, paramString, str2, "", "", "");
      return;
      localObject = "cmgame_aio";
      str1 = "cmgame_aio_c2c";
      break;
      localObject = "cmgame_aio";
      str1 = "cmgame_aio_qun";
      break;
      localObject = "cmgame_aio_cm";
      str1 = "cmgame_aio_cm_c2c";
      break;
      localObject = "cmgame_aio_cm";
      str1 = "cmgame_aio_cm_qun";
      break;
    }
  }
  
  public ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558729, paramViewGroup, false));
  }
  
  public void a(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.ViewHoder paramViewHoder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > paramInt))
    {
      localObject = (ApolloBattleGameInfo)((List)localObject).get(paramInt);
      String str = ((ApolloBattleGameInfo)localObject).background;
      if (TextUtils.isEmpty(str)) {
        break label223;
      }
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setRadius(this.jdField_a_of_type_Float);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setImageURL(str);
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(0);
      str = ((ApolloBattleGameInfo)localObject).avatar;
      if (TextUtils.isEmpty(str)) {
        break label235;
      }
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setRadius(this.b);
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setImageURL(str);
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(0);
      label114:
      paramViewHoder.jdField_a_of_type_AndroidWidgetTextView.setText(((ApolloBattleGameInfo)localObject).name);
      paramViewHoder.jdField_b_of_type_AndroidWidgetTextView.setText(((ApolloBattleGameInfo)localObject).gamerRange);
      str = ((ApolloBattleGameInfo)localObject).footerIcon;
      if (TextUtils.isEmpty(str)) {
        break label247;
      }
      paramViewHoder.c.setRadius(this.jdField_a_of_type_ArrayOfFloat);
      paramViewHoder.c.setImageURL(str);
      paramViewHoder.c.setVisibility(0);
    }
    for (;;)
    {
      paramViewHoder.jdField_a_of_type_AndroidViewView.setOnClickListener(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.1(this, (ApolloBattleGameInfo)localObject));
      a((ApolloBattleGameInfo)localObject, "game_expo");
      a((ApolloBattleGameInfo)localObject, 101);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHoder, paramInt, getItemId(paramInt));
      return;
      label223:
      paramViewHoder.jdField_a_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(8);
      break;
      label235:
      paramViewHoder.jdField_b_of_type_ComTencentWidgetRoundRectURLImageView.setVisibility(8);
      break label114;
      label247:
      paramViewHoder.c.setVisibility(8);
    }
  }
  
  public void a(List<ApolloBattleGameInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter
 * JD-Core Version:    0.7.0.1
 */