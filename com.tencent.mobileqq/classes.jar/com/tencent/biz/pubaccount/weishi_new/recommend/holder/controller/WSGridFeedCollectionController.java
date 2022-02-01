package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUI;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData;
import com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class WSGridFeedCollectionController
  extends AbsWsUI<WSCollectionItemData>
  implements View.OnClickListener
{
  private static final int f = Color.parseColor("#e1e1e1");
  private View g;
  private WSRoundedImageView h;
  private TextView i;
  private TextView j;
  private final Context k;
  private final stSimpleMetaFeed l;
  private String m;
  private int n;
  
  public WSGridFeedCollectionController(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super(paramContext);
    this.k = paramContext;
    this.l = paramstSimpleMetaFeed;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = LayoutInflater.from(paramContext).inflate(2131626468, null);
    this.h = ((WSRoundedImageView)this.g.findViewById(2131432953));
    this.h.setStrokeWidth(WeishiUIUtil.a);
    this.h.setStrokeColor(f);
    this.i = ((TextView)this.g.findViewById(2131432955));
    this.j = ((TextView)this.g.findViewById(2131432954));
    this.g.setOnClickListener(this);
  }
  
  protected void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((ViewGroup)this.g.getParent() != null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(36.0F));
    int i1 = ViewUtils.dpToPx(7.5F);
    localLayoutParams.bottomMargin = i1;
    localLayoutParams.topMargin = i1;
    paramViewGroup.addView(this.g, localLayoutParams);
  }
  
  public void a(WSCollectionItemData paramWSCollectionItemData)
  {
    super.a(paramWSCollectionItemData);
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  protected void b()
  {
    this.i.setText(((WSCollectionItemData)this.e).b());
    this.j.setText(((WSCollectionItemData)this.e).c());
    WSPicLoader.a().a(this.k, this.h, ((WSCollectionItemData)this.e).a());
  }
  
  public void c(int paramInt)
  {
    this.n = paramInt;
  }
  
  protected void f() {}
  
  public void i()
  {
    ViewGroup localViewGroup = (ViewGroup)this.g.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.g);
    }
  }
  
  public void onClick(View paramView)
  {
    WSCollectionJumpUtil.a(d(), this.l, ((WSCollectionItemData)this.e).d(), this.c, this.n, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCollectionController
 * JD-Core Version:    0.7.0.1
 */