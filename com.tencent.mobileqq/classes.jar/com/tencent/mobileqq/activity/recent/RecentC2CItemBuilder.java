package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.OnlineStatusCircleView;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class RecentC2CItemBuilder
  extends RecentEfficientItemBuilder
{
  private RecentC2CItemBuilder.OnlineStatusFriendListObserver h;
  
  public RecentC2CItemBuilder()
  {
    this.a = 2131629163;
    this.b = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder))) {
      paramView = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.b != null))
    {
      if (paramRecentBaseData == null) {
        return;
      }
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((OnlineStatusExposureHelper.a()) && (!SimpleUIUtil.e()) && (paramRecentBaseData.getRecentUserType() == 0) && (!OnlineStatusExposureHelper.b(localAppRuntime, paramRecentBaseData.getRecentUserUin())))
      {
        paramView.b.setVisibility(0);
        paramView.b.setImageDrawable(OnlineStatusExposureHelper.c(localAppRuntime, paramRecentBaseData.getRecentUserUin()));
        paramView.b.setOnClickListener(new RecentC2CItemBuilder.1(this, localAppRuntime, paramRecentBaseData));
        return;
      }
      paramView.b.setVisibility(8);
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {
      paramView = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.d != null))
    {
      if (paramRecentBaseData == null) {
        return;
      }
      RobotChatUtil.a(paramContext, paramView.d, paramRecentBaseData.getRecentUserUin());
    }
  }
  
  private void a(AppRuntime paramAppRuntime, RecentBaseData paramRecentBaseData)
  {
    Object localObject = Foreground.getTopActivity();
    if (!(localObject instanceof BaseActivity)) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    if (!paramAppRuntime.getCurrentUin().equals(paramRecentBaseData.getRecentUserUin()))
    {
      if (OnlineStatusExposureHelper.a(paramAppRuntime, paramRecentBaseData.getRecentUserUin()) == 1080L) {
        ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(true, true);
      }
      localIOnlineStatusService.showAIOStatusPopupDialog(paramRecentBaseData.getRecentUserUin(), (Activity)localObject, 0);
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)paramAppRuntime;
        ((QQAppInterface)localObject).removeObserver(this.h);
        this.h = new RecentC2CItemBuilder.OnlineStatusFriendListObserver((QQAppInterface)localObject, paramRecentBaseData, null);
        ((QQAppInterface)localObject).addObserver(this.h);
      }
      ((IFriendHandlerTempService)paramAppRuntime.getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(paramRecentBaseData.getRecentUserUin(), false);
      return;
    }
    paramAppRuntime = localIOnlineStatusService.newAccountPanel((QBaseActivity)localObject, 2);
    paramAppRuntime.show();
    ReportHelperKt.a("0X800BBDF", 0, String.valueOf(2));
    paramAppRuntime.a(new RecentC2CItemBuilder.2(this));
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
    a(paramView, paramRecentBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentC2CItemBuilder
 * JD-Core Version:    0.7.0.1
 */