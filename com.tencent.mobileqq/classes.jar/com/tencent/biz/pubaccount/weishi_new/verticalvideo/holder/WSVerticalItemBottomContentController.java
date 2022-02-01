package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;

public class WSVerticalItemBottomContentController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private FeedRichTextView g;
  private TextView h;
  private stSimpleMetaFeed i;
  private WSVerticalPageFragment j;
  
  public WSVerticalItemBottomContentController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.j = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    this.g.setText(paramString);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    this.h.setText(paramString);
  }
  
  private void l()
  {
    WSVerticalJumpUtils.a(this.j, this.i);
    WSVerticalBeaconReport.e(this.j.k(), this.j.l(), this.i, ((WSVerticalPageContract.Presenter)this.j.aO_()).n());
    WSReportDC898Vertical.e();
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      this.i = localWSVerticalItemData.b();
    }
  }
  
  protected void b()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b();
      a(((stSimpleMetaFeed)localObject).feed_desc);
      b(((stSimpleMetaFeed)localObject).material_desc);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626079;
  }
  
  protected void j()
  {
    this.g = ((FeedRichTextView)c(2131449406));
    this.h = ((TextView)c(2131449407));
    this.h.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449407)
    {
      WSLog.b("WSVerticalItemBottomContentController", "跳转到微视端内");
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomContentController
 * JD-Core Version:    0.7.0.1
 */