package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ICircleCountDownView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public class ADVideoItemHolder
  extends VideoItemHolder
{
  public View A;
  public TextView B;
  public TextView C;
  public View D;
  public LinearLayout E;
  public RelativeLayout F;
  public LinearLayout G;
  public TextView H;
  public TextView I;
  public TextView J;
  public RelativeLayout K;
  public ImageView L;
  public TextView M;
  public TextView N;
  public ImageView O;
  public ReadInJoyHeadImageView P;
  public ImageView Q;
  public TextView R;
  public URLImageView S;
  public RelativeLayout T;
  public RIJDownloadView U;
  public RIJDownloadView V;
  public LinearLayout a;
  public TextView b;
  public ImageView c;
  public RelativeLayout d;
  public TextView e;
  public TextView f;
  public boolean g;
  public View h;
  public View i;
  public View j;
  public View k;
  public View l;
  public ImageView m;
  public TextView n;
  public View o;
  public TextView p;
  public View q;
  public TextView r;
  public ICircleCountDownView s;
  public URLImageView t;
  public View u;
  public View v;
  public View w;
  public View x;
  public View y;
  public ImageView z;
  
  public ADVideoItemHolder(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    if (paramInt == 4)
    {
      this.aH = ((ViewGroup)paramView.findViewById(2131434977));
      this.aJ = ((AbsReadInJoyNickNameTextView)paramView.findViewById(2131434954));
      this.aK = ((IReadInJoyHeadImageView)paramView.findViewById(2131434950));
      this.a = ((LinearLayout)paramView.findViewById(2131427705));
      this.b = ((TextView)paramView.findViewById(2131427706));
      this.c = ((ImageView)paramView.findViewById(2131427704));
      this.d = ((RelativeLayout)paramView.findViewById(2131427690));
      this.e = ((TextView)paramView.findViewById(2131427697));
      this.f = ((TextView)paramView.findViewById(2131427640));
    }
    else if ((paramInt == 5) || (paramInt == 7))
    {
      this.aH = ((ViewGroup)paramView.findViewById(2131434977));
      this.aI = ((ViewGroup)paramView.findViewById(2131427711));
      this.aJ = ((AbsReadInJoyNickNameTextView)paramView.findViewById(2131427714));
      if (ReadInJoyAdSwitchUtil.a()) {
        this.aK = ((IReadInJoyHeadImageView)paramView.findViewById(2131434950));
      } else {
        this.aK = ((IReadInJoyHeadImageView)paramView.findViewById(2131427712));
      }
      this.b = ((TextView)paramView.findViewById(2131427717));
      this.d = ((RelativeLayout)paramView.findViewById(2131427690));
      this.e = ((TextView)paramView.findViewById(2131427697));
      this.f = ((TextView)paramView.findViewById(2131427718));
      this.k = paramView.findViewById(2131434506);
      this.l = paramView.findViewById(2131434489);
      this.m = ((ImageView)paramView.findViewById(2131434498));
      this.n = ((TextView)paramView.findViewById(2131434507));
      this.o = paramView.findViewById(2131434509);
      this.p = ((TextView)paramView.findViewById(2131434511));
      this.q = paramView.findViewById(2131434495);
      this.r = ((TextView)paramView.findViewById(2131434497));
      this.s = ((ICircleCountDownView)paramView.findViewById(2131434508));
      this.g = false;
      this.t = ((URLImageView)paramView.findViewById(2131429242));
      this.K = ((RelativeLayout)paramView.findViewById(2131432123));
      this.L = ((ImageView)paramView.findViewById(2131432125));
      this.M = ((TextView)paramView.findViewById(2131432126));
      this.N = ((TextView)paramView.findViewById(2131432121));
      this.O = ((ImageView)paramView.findViewById(2131432120));
      this.u = paramView.findViewById(2131427702);
      this.v = paramView.findViewById(2131427699);
      this.w = paramView.findViewById(2131427700);
      this.x = paramView.findViewById(2131427701);
      this.y = paramView.findViewById(2131434481);
      this.z = ((ImageView)paramView.findViewById(2131434482));
      this.A = paramView.findViewById(2131434480);
      this.B = ((TextView)paramView.findViewById(2131434483));
      this.C = ((TextView)paramView.findViewById(2131434484));
      this.D = paramView.findViewById(2131434487);
      this.E = ((LinearLayout)paramView.findViewById(2131439383));
      this.F = ((RelativeLayout)paramView.findViewById(2131432122));
      this.G = ((LinearLayout)paramView.findViewById(2131432127));
      this.H = ((TextView)paramView.findViewById(2131432124));
      this.I = ((TextView)paramView.findViewById(2131432129));
      this.J = ((TextView)paramView.findViewById(2131432128));
      this.P = ((ReadInJoyHeadImageView)paramView.findViewById(2131449569));
      this.Q = ((ImageView)paramView.findViewById(2131434952));
      this.Q.setVisibility(8);
      this.R = ((TextView)paramView.findViewById(2131427752));
      this.U = ((RIJDownloadView)paramView.findViewById(2131427686));
      this.V = ((RIJDownloadView)paramView.findViewById(2131427688));
    }
    this.h = paramView.findViewById(2131427721);
    this.i = paramView.findViewById(2131427722);
    this.j = paramView.findViewById(2131427723);
    this.S = ((URLImageView)paramView.findViewById(2131427716));
    this.T = ((RelativeLayout)paramView.findViewById(2131435806));
  }
  
  public LinearLayout a()
  {
    return this.a;
  }
  
  public void a(IVideoFeedsAdapter paramIVideoFeedsAdapter, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    super.a(paramIVideoFeedsAdapter, paramLinearLayoutManager, paramBoolean);
    int i2 = paramLinearLayoutManager.getOrientation();
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
      i2 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i1 / 2));
    }
    else
    {
      i1 = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
      i2 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i1 / 2));
    }
    float f2 = Math.round(i2 / i1 * 100.0F) / 100.0F;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    if ((paramBoolean) && (f1 <= 0.5D)) {
      ((VideoFeedsHardAdBarManager)paramIVideoFeedsAdapter.k()).c();
    }
    ExposureSupplementManager.a(paramIVideoFeedsAdapter.j(), f1, this, paramBoolean);
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */