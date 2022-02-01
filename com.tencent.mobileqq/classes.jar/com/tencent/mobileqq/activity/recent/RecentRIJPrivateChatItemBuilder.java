package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemRIJPrivateItemData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport.R5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.RecentDynamicAvatarView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class RecentRIJPrivateChatItemBuilder
  extends RecentC2CItemBuilder
{
  public static final Bitmap h = BitmapFactory.decodeResource(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication().getResources(), 2130842705);
  public static final Drawable i = new BitmapDrawable(Bitmap.createScaledBitmap(h, ViewUtils.dip2px(52.0F), ViewUtils.dip2px(52.0F), false));
  public static final Drawable j = new BitmapDrawable(Bitmap.createScaledBitmap(h, ViewUtils.dip2px(50.0F), ViewUtils.dip2px(50.0F), false));
  public static final Drawable k = new BitmapDrawable(Bitmap.createScaledBitmap(h, ViewUtils.dip2px(40.0F), ViewUtils.dip2px(40.0F), false));
  
  private RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder b(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder))) {
      return (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
    }
    return null;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    a(paramObject);
    return super.a(paramInt, paramObject, null, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemRIJPrivateItemData))
    {
      paramRecentBaseData = (RecentItemRIJPrivateItemData)paramRecentBaseData;
      paramView = b(paramView);
      if (paramView != null) {
        paramView.a.setImageDrawable(i);
      }
      if (!TextUtils.isEmpty(paramRecentBaseData.avatarUrl))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = i;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        paramRecentBaseData = URLDrawable.getDrawable(paramRecentBaseData.avatarUrl, localURLDrawableOptions);
        paramRecentBaseData.setTag(URLDrawableDecodeHandler.a(ViewUtils.dip2px(52.0F), ViewUtils.dip2px(52.0F)));
        paramRecentBaseData.setDecodeHandler(URLDrawableDecodeHandler.c);
        if (paramView != null) {
          paramView.a.setImageDrawable(paramRecentBaseData);
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData);
  }
  
  public void a(Object paramObject)
  {
    if (this.f != null)
    {
      if (this.f.d == null) {
        return;
      }
      if ((paramObject instanceof RecentBaseData))
      {
        paramObject = (RecentBaseData)paramObject;
        if (paramObject.getRecentUserType() == 10013)
        {
          IRIJPrivateChatReport.R5Builder localR5Builder = new IRIJPrivateChatReport.R5Builder();
          ((IRIJPrivateChatReport)QRoute.api(IRIJPrivateChatReport.class)).reportData("0X800BD0C", localR5Builder.a(this.f.d.getCurrentAccountUin()).b(paramObject.getRecentUserUin()).a(15).b(this.f.d.getConversationFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType())).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentRIJPrivateChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */