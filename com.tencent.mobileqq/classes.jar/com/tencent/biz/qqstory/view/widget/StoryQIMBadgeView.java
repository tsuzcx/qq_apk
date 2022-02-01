package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class StoryQIMBadgeView
  extends ImageView
  implements View.OnClickListener
{
  private static final LruCache<String, Boolean> a = new LruCache(50);
  private QQUserUIItem b;
  private String c;
  private boolean d = false;
  private AppInterface e;
  private FriendListObserver f;
  
  public StoryQIMBadgeView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @RequiresApi(api=21)
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  public static void b()
  {
    a.evictAll();
  }
  
  protected void a()
  {
    if (StoryDepends.b()) {
      this.f = new StoryQIMBadgeView.1(this);
    }
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (!TextUtils.isEmpty(paramQQUserUIItem.qq)))
    {
      this.b = paramQQUserUIItem;
      if (StoryDepends.b())
      {
        if ((!this.d) && (a.get(this.b.qq) != null))
        {
          a(((Boolean)a.get(this.b.qq)).booleanValue());
          return;
        }
        if (!this.d) {
          setVisibility(8);
        }
        paramQQUserUIItem = QQStoryContext.k();
        if (paramQQUserUIItem != null)
        {
          paramQQUserUIItem = (FriendListHandler)paramQQUserUIItem.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if (paramQQUserUIItem != null) {
            paramQQUserUIItem.getOnlineInfo(this.b.qq, false);
          }
        }
      }
      else
      {
        a(this.b.isVipButNoFriend());
      }
      return;
    }
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    UIUtils.a(this);
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.c))
      {
        this.c = StoryDepends.QimUtil.a(this.b);
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
      }
      UIUtils.a(this, this.c, getMeasuredWidth(), getMeasuredHeight(), null, null);
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (StoryDepends.b())
    {
      this.e = QQStoryContext.k();
      FriendListObserver localFriendListObserver = this.f;
      if (localFriendListObserver != null) {
        this.e.addObserver(localFriendListObserver);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null)
    {
      Context localContext = paramView.getContext();
      String str = StoryDepends.QimUtil.b(this.b);
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_operation_bar", true);
      localContext.startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (StoryDepends.b())
    {
      AppInterface localAppInterface = this.e;
      if (localAppInterface != null)
      {
        FriendListObserver localFriendListObserver = this.f;
        if (localFriendListObserver != null)
        {
          localAppInterface.removeObserver(localFriendListObserver);
          this.e = null;
        }
      }
    }
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView
 * JD-Core Version:    0.7.0.1
 */