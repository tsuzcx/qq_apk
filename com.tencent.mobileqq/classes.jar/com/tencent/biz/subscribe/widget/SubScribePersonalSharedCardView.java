package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;

public class SubScribePersonalSharedCardView
  extends AbsSubscribeShareCardView
{
  private SquareImageView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private RelativeLayout r;
  private ImageView s;
  
  public SubScribePersonalSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    this.l = paramView.findViewById(2131445817);
    this.m = ((SquareImageView)paramView.findViewById(2131445812));
    this.n = ((TextView)paramView.findViewById(2131445819));
    this.o = ((TextView)paramView.findViewById(2131445813));
    this.p = ((TextView)paramView.findViewById(2131445820));
    this.q = ((TextView)paramView.findViewById(2131445815));
    this.r = ((RelativeLayout)paramView.findViewById(2131445810));
    this.s = ((ImageView)paramView.findViewById(2131445811));
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    super.a(paramShareInfoBean, paramBitmap, paramShareDataBindListener);
    if ((paramShareInfoBean != null) && (paramShareInfoBean.a() != null) && (paramShareInfoBean.a().poster != null))
    {
      CertifiedAccountMeta.StUser localStUser = paramShareInfoBean.a().poster;
      if (TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        paramShareInfoBean = localStUser.icon;
      } else {
        paramShareInfoBean = localStUser.iconInfo.iconUrl;
      }
      paramShareInfoBean = paramShareInfoBean.get();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramShareInfoBean);
      localArrayList2.add(this.m);
      a(localArrayList1, localArrayList2, paramShareDataBindListener);
      this.n.setText(localStUser.nick.get());
      paramShareDataBindListener = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramShareDataBindListener)) && (!paramShareDataBindListener.equals(HardCodeUtil.a(2131916909))))
      {
        paramShareInfoBean = paramShareDataBindListener;
        if (!TextUtils.isEmpty(paramShareDataBindListener.trim())) {}
      }
      else
      {
        paramShareInfoBean = HardCodeUtil.a(2131916908);
      }
      this.o.setText(paramShareInfoBean);
      paramShareInfoBean = SubscribeGlobalInfo.b();
      if (paramShareInfoBean != null)
      {
        this.q.setText(SubscribeUtils.b(paramShareInfoBean.fansCount.get()));
        this.p.setText(SubscribeUtils.b(paramShareInfoBean.feedCount.get()));
        measure(c, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.s.setImageBitmap(paramBitmap);
    }
  }
  
  public int getLayoutId()
  {
    return 2131624393;
  }
  
  protected URLImageView getTopImg()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */