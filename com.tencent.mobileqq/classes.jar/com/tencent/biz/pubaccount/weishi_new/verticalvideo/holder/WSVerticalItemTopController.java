package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.open.base.ToastUtil;

public class WSVerticalItemTopController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private WSVerticalPageFragment g;
  private WSRoundedImageView h;
  private TextView i;
  private TextView j;
  private WSUserBusiness k;
  private stSimpleMetaFeed l;
  
  public WSVerticalItemTopController(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSVerticalItemTopController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.g = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(WeishiUtils.n(), paramstSimpleMetaPerson.id))
    {
      this.j.setVisibility(8);
      return;
    }
    int m = paramstSimpleMetaPerson.followStatus;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("followStatus:");
    localStringBuilder.append(m);
    localStringBuilder.append(",personInfo hashCode:");
    localStringBuilder.append(paramstSimpleMetaPerson.hashCode());
    WSLog.d("WSVerticalItemTopController", localStringBuilder.toString());
    if (WSFeedUtils.b(paramstSimpleMetaPerson.followStatus))
    {
      this.j.setVisibility(8);
      return;
    }
    this.j.setText("关注");
    this.j.setVisibility(0);
  }
  
  private void d(int paramInt)
  {
    WSVerticalBeaconReport.c(this.g.k(), this.g.l(), paramInt, this.l, ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
  }
  
  private void l()
  {
    ((WSVerticalPageContract.Presenter)this.g.aO_()).a("profile", this.g, this.l);
    d(1000001);
    WSLog.b("WSVerticalItemTopController", "Jump to personal page.");
  }
  
  private void m()
  {
    if (!NetworkUtil.a(d()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    if (this.k == null) {
      this.k = WSUserBusiness.a();
    }
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    WSLog.b("WSVerticalItemTopController", "Follow user.");
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b().poster;
      if (localObject != null)
      {
        if (WSFeedUtils.b(((stSimpleMetaPerson)localObject).followStatus))
        {
          WSFeedUtils.a(d(), new WSVerticalItemTopController.1(this, (stSimpleMetaPerson)localObject), null);
          return;
        }
        this.k.a(((stSimpleMetaPerson)localObject).id, 1);
        ((stSimpleMetaPerson)localObject).followStatus = 1;
        this.j.setText("已关注");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("---> followStatus:");
        localStringBuilder.append(((stSimpleMetaPerson)localObject).followStatus);
        localStringBuilder.append(",personInfo hashCode:");
        localStringBuilder.append(localObject.hashCode());
        WSLog.a("WSVerticalItemTopController", localStringBuilder.toString());
        this.j.setVisibility(8);
      }
    }
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData == null) {
      return;
    }
    if ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)) {
      this.l = localWSVerticalItemData.b();
    }
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateUI hashcode******************************");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(",position:");
    ((StringBuilder)localObject).append(h());
    WSLog.a("WSVerticalItemTopController", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b().poster;
      if (localObject != null)
      {
        this.i.setText(((stSimpleMetaPerson)localObject).nick);
        WSPicLoader.a().a(this.a, this.h, ((stSimpleMetaPerson)localObject).avatar);
        a((stSimpleMetaPerson)localObject);
      }
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626090;
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = WeishiUIUtil.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = WeishiUIUtil.b((Activity)this.a);
    localLayoutParams.leftMargin = WeishiUIUtil.a();
    this.b.setLayoutParams(localLayoutParams);
    this.h = ((WSRoundedImageView)c(2131449397));
    this.h.setOnClickListener(this);
    this.i = ((TextView)c(2131449403));
    this.i.setOnClickListener(this);
    this.j = ((TextView)c(2131449402));
    this.j.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131449402: 
      m();
      WSVerticalBeaconReport.d(this.g.k(), this.g.l(), this.l, ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopController
 * JD-Core Version:    0.7.0.1
 */