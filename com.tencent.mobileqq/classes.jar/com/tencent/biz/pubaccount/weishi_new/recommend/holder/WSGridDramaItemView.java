package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stDrama;
import UserGrowth.stDramaFall;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.util.ArrayList;

public class WSGridDramaItemView
  extends AbsWSItemView<stSimpleMetaFeed>
  implements View.OnClickListener
{
  private static final int d = WSFeedUtils.a(5.0F);
  private TextView e;
  private KandianUrlImageView f;
  private RoundCornerImageView g;
  private RoundCornerImageView h;
  private RoundCornerImageView i;
  private RoundCornerImageView j;
  private WSRecommendAdapter k;
  private stSimpleMetaFeed l;
  private int m;
  private String n;
  
  public WSGridDramaItemView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  private void e()
  {
    stDramaFall localstDramaFall = this.l.dramaInfo;
    if (localstDramaFall == null) {
      return;
    }
    Object localObject1 = this.k;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((WSRecommendAdapter)localObject1).l)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("feeds_");
      ((StringBuilder)localObject1).append(this.k.l);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "feeds";
    }
    Object localObject2 = localstDramaFall.dramaInfo;
    String str = "";
    if ((localObject2 != null) && (localstDramaFall.dramaInfo.dramaInfo != null))
    {
      localObject2 = localstDramaFall.dramaInfo.dramaInfo.coverImg;
      str = localstDramaFall.dramaInfo.dramaInfo.name;
      this.n = localstDramaFall.dramaInfo.dramaInfo.id;
    }
    else
    {
      localObject2 = "";
    }
    this.e.setText(str);
    WSPicLoader.a().a(this.j, (String)localObject2, WSFeedUtils.f(2131166336), (String)localObject1, this.m);
    WSPicLoader.a().a(this.g, localstDramaFall.bgCover, WSFeedUtils.f(2131168464));
    WSPicLoader.a().a(this.f, localstDramaFall.titleCover, WSFeedUtils.f(2131168376));
    if (localstDramaFall.images != null)
    {
      if (localstDramaFall.images.size() > 0) {
        WSPicLoader.a().a(this.i, (String)localstDramaFall.images.get(0), WSFeedUtils.f(2131166336));
      }
      if (localstDramaFall.images.size() > 1) {
        WSPicLoader.a().a(this.h, (String)localstDramaFall.images.get(1), WSFeedUtils.f(2131166336));
      }
    }
  }
  
  private void e(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    localLayoutParams.height = ((int)(paramInt * 1.777778F + WSItemDecoration.a));
    this.a.setLayoutParams(localLayoutParams);
  }
  
  private int f()
  {
    return (WeishiUIUtil.c() - WSItemDecoration.a * 3) / 2;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.l = paramstSimpleMetaFeed;
    e();
  }
  
  public void a(WSRecommendAdapter paramWSRecommendAdapter)
  {
    this.k = paramWSRecommendAdapter;
  }
  
  public void b()
  {
    this.g = ((RoundCornerImageView)this.a.findViewById(2131444885));
    this.e = ((TextView)this.a.findViewById(2131448447));
    this.f = ((KandianUrlImageView)this.a.findViewById(2131436375));
    this.h = ((RoundCornerImageView)this.a.findViewById(2131444889));
    this.i = ((RoundCornerImageView)this.a.findViewById(2131444888));
    this.j = ((RoundCornerImageView)this.a.findViewById(2131444886));
    this.g.setCorner(d, 0);
    this.j.setCorner(d, 0);
    this.i.setCorner(d, 1);
    this.h.setCorner(d, 1);
    this.a.setOnClickListener(this);
    e(f());
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public void onClick(View paramView)
  {
    WSDramaPageIntentParams localWSDramaPageIntentParams = new WSDramaPageIntentParams("grid_drama_card", this.b).a(this.n);
    paramView = this.k;
    if (paramView != null) {
      paramView = paramView.l;
    } else {
      paramView = "";
    }
    WSDramaPageFragment.a(localWSDramaPageIntentParams.c(paramView));
    paramView = this.l;
    WSGridBeaconReport.a("gzh_click", paramView, UserActionReportPresenter.a(paramView, this.m), 1000001, this.k.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridDramaItemView
 * JD-Core Version:    0.7.0.1
 */