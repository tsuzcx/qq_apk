package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stFeedBarInfo;
import UserGrowth.stSimpleMetaFeed;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.Map;

public class WSVerticalItemBottomCollectionController
  extends AbsWsVerticalUIGroup
{
  protected WSVerticalPageFragment g;
  private View h;
  private TextView i;
  private stSimpleMetaFeed j;
  private String k;
  private String l;
  private int m = -1;
  private int n = -1;
  
  public WSVerticalItemBottomCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.g = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(String paramString)
  {
    paramString = WeishiUtils.b(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      this.h.setBackgroundColor(WSFeedUtils.g(2131165578));
      return;
    }
    this.h.setBackgroundColor(Color.parseColor(paramString));
  }
  
  private void p()
  {
    stFeedBarInfo localstFeedBarInfo = this.j.feedBarInfo;
    if (localstFeedBarInfo == null) {
      return;
    }
    Map localMap = ((WSVerticalPageContract.Presenter)this.g.aO_()).n();
    String str;
    if (m()) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("bar_status", str);
    WSCollectionJumpUtil.a(this.g, this.j, localstFeedBarInfo.jump, this.g.m(), localMap);
  }
  
  private void q()
  {
    Map localMap = ((WSVerticalPageContract.Presenter)this.g.aO_()).n();
    String str;
    if (m()) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("bar_status", str);
    WSVerticalBeaconReport.a(this.g.k(), this.g.l(), this.j, localMap);
  }
  
  private boolean r()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.j;
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.feedBarInfo != null) && (this.j.feedBarInfo.switchOpen == 1) && (!TextUtils.isEmpty(this.j.feedBarInfo.text));
  }
  
  private boolean s()
  {
    View localView = this.h;
    return (localView != null) && (localView.getVisibility() == 0) && (!m());
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData != null) {
      this.j = localWSVerticalItemData.b();
    }
  }
  
  protected void b()
  {
    if (r())
    {
      this.h.setVisibility(0);
      this.i.setText(this.j.feedBarInfo.text);
      this.m = this.j.feedBarInfo.changeTime;
      this.n = this.j.feedBarInfo.progressPercentage;
      this.k = this.j.feedBarInfo.beginColor;
      this.l = this.j.feedBarInfo.endColor;
      if (m())
      {
        a(this.l);
        return;
      }
      a(this.k);
      return;
    }
    this.h.setVisibility(8);
  }
  
  protected void d(int paramInt)
  {
    if (r()) {
      q();
    }
  }
  
  protected void e(int paramInt) {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626077;
  }
  
  protected void j()
  {
    this.h = c(2131449399);
    this.h.setOnClickListener(new WSVerticalItemBottomCollectionController.1(this));
    this.i = ((TextView)c(2131449401));
  }
  
  public void l()
  {
    if (!s())
    {
      WSLog.d("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
      return;
    }
    if (c() != null) {
      ((WSVerticalItemData)c()).c(true);
    }
    Object localObject = WeishiUtils.b(this.k);
    String str = WeishiUtils.b(this.l);
    int i1;
    if (WeishiUIUtil.a((String)localObject)) {
      i1 = Color.parseColor((String)localObject);
    } else {
      i1 = -2147483648;
    }
    int i2;
    if (WeishiUIUtil.a(str)) {
      i2 = Color.parseColor(str);
    } else {
      i2 = -2139470081;
    }
    localObject = ObjectAnimator.ofInt(this.h, "backgroundColor", new int[] { i1, i2 });
    ((ObjectAnimator)localObject).addListener(new WSVerticalItemBottomCollectionController.2(this));
    ((ObjectAnimator)localObject).setDuration(500L);
    ((ObjectAnimator)localObject).setEvaluator(new ArgbEvaluator());
    ((ObjectAnimator)localObject).start();
  }
  
  public boolean m()
  {
    return (c() != null) && (((WSVerticalItemData)c()).d());
  }
  
  public int n()
  {
    int i1 = this.m;
    if (i1 == -1) {
      return 2000;
    }
    return i1 * 1000;
  }
  
  public int o()
  {
    int i2 = this.n;
    int i1 = i2;
    if (i2 == -1) {
      i1 = 20;
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController
 * JD-Core Version:    0.7.0.1
 */