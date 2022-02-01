package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalVideoAvatarBottomItemView
  extends WSVerticalVideoOperationRightItemView
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  
  public WSVerticalVideoAvatarBottomItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void q()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = l();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null))
    {
      ((WSVerticalItemBottomAvatarController)this.a).a(localstSimpleMetaFeed.poster);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVerticalVideoAvatarBottomItemView.java][updateFollowBtnUI] title:");
      localStringBuilder.append(localstSimpleMetaFeed.feed_desc);
      WSLog.e("WSVerticalVideoAvatarBottomItemViewLog", localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if (localAbsWsUIGroup != null)
    {
      int i;
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      localAbsWsUIGroup.a(i);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject = l();
    if (localObject != null)
    {
      localObject = ((stSimpleMetaFeed)localObject).poster;
      if (localObject == null) {
        return;
      }
      ((WSVerticalItemBottomAvatarController)this.a).b((stSimpleMetaPerson)localObject);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if (localAbsWsUIGroup != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localAbsWsUIGroup.a(i);
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt == 1) && ((this.a instanceof WSVerticalItemBottomAvatarController)))
    {
      q();
      return;
    }
    super.d(paramInt);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449747);
    this.a = new WSVerticalItemBottomAvatarController(this.g, this.f);
    this.a.a(localViewStub);
    a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoAvatarBottomItemView
 * JD-Core Version:    0.7.0.1
 */