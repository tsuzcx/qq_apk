package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameMsgBoxItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameMsgBoxItemBuilder
  extends RecentItemBaseBuilder
{
  private GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if (paramView != null)
    {
      if (paramRecentBaseData == null) {
        return null;
      }
      if ((paramView.getTag() instanceof GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder)) {
        paramRecentBaseData = (GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder)paramView.getTag();
      } else {
        paramRecentBaseData = null;
      }
      if (paramRecentBaseData == null)
      {
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder();
          paramRecentBaseData.append("bindView|holder is null, tag = ");
          paramRecentBaseData.append(paramView.getTag());
          QLog.i("Q.recent", 2, paramRecentBaseData.toString());
        }
        return null;
      }
      return paramRecentBaseData;
    }
    return null;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder paramGameMsgBoxItemBuilderHolder)
  {
    int j = paramRecentBaseData.mUnreadNum;
    int i = paramRecentBaseData.mUnreadFlag;
    if (j > 0) {
      if (i == 0)
      {
        paramGameMsgBoxItemBuilderHolder.i.setDragViewType(-1, paramView);
      }
      else
      {
        if (i == 2)
        {
          paramGameMsgBoxItemBuilderHolder.i.setDragViewType(-1, paramView);
          i = 1;
          break label186;
        }
        if (i == 3)
        {
          paramRecentBaseData = ABTestController.a().a("message_reminder_layer2_1505_20210618");
          paramRecentBaseData.h();
          if (paramRecentBaseData.f())
          {
            k = 11;
            j = 0;
            i = 2130852597;
          }
          else
          {
            paramGameMsgBoxItemBuilderHolder.i.setTextColor(paramContext.getResources().getColor(2131168173));
            k = 3;
            i = 2130852596;
          }
          paramGameMsgBoxItemBuilderHolder.i.setDragViewType(1, paramView);
          int m = i;
          i = k;
          k = m;
          break label192;
        }
        paramGameMsgBoxItemBuilderHolder.i.setDragViewType(0, paramView);
        paramGameMsgBoxItemBuilderHolder.i.setTextColor(paramContext.getResources().getColor(2131168174));
        i = 3;
        k = 2130852592;
        break label192;
      }
    }
    i = 0;
    label186:
    j = 0;
    int k = 0;
    label192:
    CustomWidgetUtil.a(paramGameMsgBoxItemBuilderHolder.i, i, j, k, 99, null);
  }
  
  private void a(View paramView, GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder paramGameMsgBoxItemBuilderHolder, Object paramObject)
  {
    VideoReport.setPageId(paramView, "pg_gb_message");
    VideoReport.setElementId(paramView, "em_gb_message");
    int i = 0;
    try
    {
      IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGameMsgBoxManager.class, "");
      if ((paramObject instanceof RecentBaseData))
      {
        paramObject = localIGameMsgBoxManager.findGameDetailInfoByConvertUin(((RecentBaseData)paramObject).getRecentUserUin());
        if (paramObject != null) {
          VideoReport.setElementParam(paramView, "gameid", paramObject.c);
        }
      }
    }
    catch (Exception paramObject)
    {
      QLog.e("GameMsgBoxItemBuilder", 1, paramObject, new Object[0]);
    }
    paramGameMsgBoxItemBuilderHolder = paramGameMsgBoxItemBuilderHolder.rightMenuItems;
    int j = paramGameMsgBoxItemBuilderHolder.length;
    while (i < j)
    {
      paramObject = paramGameMsgBoxItemBuilderHolder[i];
      if (paramObject.menuId == 3) {
        VideoReport.setElementId(paramObject.menuView, "em_gb_top");
      }
      if (paramObject.menuId == 0) {
        VideoReport.setElementId(paramObject.menuView, "em_gb_delete");
      }
      if (paramObject.menuId == 2) {
        VideoReport.setElementId(paramObject.menuView, "em_gb_top_cancel");
      }
      i += 1;
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
  }
  
  private void a(ImageView paramImageView, Context paramContext, String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = 8;
    } else {
      i = 0;
    }
    paramImageView.setVisibility(i);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = null;
    try
    {
      paramContext = paramContext.getResources().getDrawable(2130841060);
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("GameMsgBoxItemBuilder", 1, "-->create color drawable oom.", paramContext);
      paramContext = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    try
    {
      paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    catch (IllegalArgumentException paramContext)
    {
      QLog.e("GameMsgBoxItemBuilder", 1, new Object[] { "setImageUrl exception url=", paramString, ",excption=", paramContext });
      paramContext = localObject;
    }
    if (paramContext == null) {
      return;
    }
    if (paramContext.getStatus() == 2) {
      paramContext.restartDownload();
    }
    if (paramContext.getStatus() != 2)
    {
      paramImageView.setImageDrawable(paramContext);
      return;
    }
    QLog.e("GameMsgBoxItemBuilder", 1, "getImageError: ");
  }
  
  private void a(ImageView paramImageView, RecentGameMsgBoxItem paramRecentGameMsgBoxItem)
  {
    if (paramRecentGameMsgBoxItem.mSex == 1)
    {
      paramImageView.setImageResource(2130846699);
      return;
    }
    if (paramRecentGameMsgBoxItem.mSex == 2)
    {
      paramImageView.setImageResource(2130846696);
      return;
    }
    paramImageView.setImageResource(0);
  }
  
  private void a(RecentBaseData paramRecentBaseData, GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder paramGameMsgBoxItemBuilderHolder)
  {
    try
    {
      paramGameMsgBoxItemBuilderHolder.j.setText(paramRecentBaseData.mLastMsg);
      return;
    }
    catch (Exception localException)
    {
      label12:
      StringBuilder localStringBuilder;
      break label12;
    }
    paramGameMsgBoxItemBuilderHolder = paramGameMsgBoxItemBuilderHolder.j;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentBaseData.mLastMsg);
    localStringBuilder.append(" ");
    paramGameMsgBoxItemBuilderHolder.setText(localStringBuilder.toString());
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
    }
    else
    {
      paramView = new GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder();
      paramViewGroup = a(paramContext, 2131629165, paramView);
      paramView.a = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131435219));
      paramView.i = ((DragTextView)paramViewGroup.findViewById(2131449128));
      paramView.e = ((TextView)paramViewGroup.findViewById(2131434004));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131449283));
      paramView.g = ((URLImageView)paramViewGroup.findViewById(2131433989));
      paramView.h = ((URLImageView)paramViewGroup.findViewById(2131434013));
      paramView.f = paramViewGroup.findViewById(2131433957);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131449281));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131447345));
      paramView.j = ((SingleLineTextView)paramViewGroup.findViewById(2131431757));
      paramView.j.setGravity(16);
      localObject = paramContext.getResources();
      paramOnDragModeChangedListener = ((Resources)localObject).getColorStateList(2131168122);
      localObject = ((Resources)localObject).getColorStateList(2131168001);
      paramView.b.setTextColor((ColorStateList)localObject);
      paramView.d.setTextColor(paramOnDragModeChangedListener);
      paramView.j.setTextColor(paramOnDragModeChangedListener);
      paramView.e.setTextColor(paramOnDragModeChangedListener);
      paramView.j.setExtendTextPadding((int)(DeviceInfoUtil.A() * 2.0F), 1);
      paramView.j.setExtendTextSize(14.0F, 1);
      paramViewGroup.setTag(paramView);
      if (this.f != null) {
        paramView.i.setOnModeChangeListener(this.f.b());
      }
    }
    paramView.i.setTag(Integer.valueOf(paramInt));
    boolean bool = AppSetting.e;
    paramOnDragModeChangedListener = null;
    if (bool) {
      paramViewGroup.setContentDescription(null);
    }
    if ((paramObject instanceof RecentBaseData))
    {
      localObject = (RecentBaseData)paramObject;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject);
      }
      a(paramViewGroup, (RecentBaseData)localObject, paramContext, paramOnDragModeChangedListener);
    }
    else
    {
      paramView.b.setText("");
      paramView.j.setText("");
      paramView.i.setVisibility(4);
    }
    if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedspots()) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
      paramView.i.setDragViewType(4, paramViewGroup);
    }
    a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
    a(paramViewGroup, paramView, paramObject);
    return paramViewGroup;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    GameMsgBoxItemBuilder.GameMsgBoxItemBuilderHolder localGameMsgBoxItemBuilderHolder = a(paramView, paramRecentBaseData);
    if (localGameMsgBoxItemBuilderHolder == null) {
      return;
    }
    if ((paramRecentBaseData instanceof RecentGameMsgBoxItem))
    {
      localObject = (RecentGameMsgBoxItem)paramRecentBaseData;
      localGameMsgBoxItemBuilderHolder.e.setText(((RecentGameMsgBoxItem)localObject).mGameName);
      a(localGameMsgBoxItemBuilderHolder.c, (RecentGameMsgBoxItem)localObject);
      a(localGameMsgBoxItemBuilderHolder.g, paramContext, ((RecentGameMsgBoxItem)localObject).mGameLevelUrl);
      a(localGameMsgBoxItemBuilderHolder.h, paramContext, ((RecentGameMsgBoxItem)localObject).mGameRankUrl);
      if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
        localGameMsgBoxItemBuilderHolder.f.setBackgroundResource(2130846701);
      } else {
        localGameMsgBoxItemBuilderHolder.f.setBackgroundResource(2130846700);
      }
    }
    RecentUtil.a(paramRecentBaseData, (BaseActivity)paramContext, paramDrawable, localGameMsgBoxItemBuilderHolder.a);
    a(localGameMsgBoxItemBuilderHolder.a);
    localGameMsgBoxItemBuilderHolder.d.setText(paramRecentBaseData.mShowTime);
    Object localObject = localGameMsgBoxItemBuilderHolder.b;
    if (TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
      paramDrawable = paramRecentBaseData.mTitleName;
    } else {
      paramDrawable = paramRecentBaseData.mTitleNameCs;
    }
    ((TextView)localObject).setText(paramDrawable);
    RecentUtil.a(paramRecentBaseData, localGameMsgBoxItemBuilderHolder.j);
    a(paramRecentBaseData, localGameMsgBoxItemBuilderHolder);
    a(paramView, paramRecentBaseData, paramContext, localGameMsgBoxItemBuilderHolder);
    RecentUtil.a(paramRecentBaseData, localGameMsgBoxItemBuilderHolder.leftView);
    if (AppSetting.e) {
      paramView.setContentDescription(paramRecentBaseData.mContentDesc);
    }
    localGameMsgBoxItemBuilderHolder.a.showTroopCreditStatus(paramRecentBaseData.getFaceExtraFlag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxItemBuilder
 * JD-Core Version:    0.7.0.1
 */