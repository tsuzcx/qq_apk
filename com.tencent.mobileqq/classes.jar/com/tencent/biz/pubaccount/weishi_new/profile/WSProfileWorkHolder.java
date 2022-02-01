package com.tencent.biz.pubaccount.weishi_new.profile;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSTextFormatter;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseViewHolder;

public class WSProfileWorkHolder
  extends BaseViewHolder<WSVerticalItemData>
{
  public static final int a = WeishiUIUtil.u;
  private RoundCornerImageView b;
  private TextView c;
  private View d;
  private WSProfileWorkAdapter e;
  private stSimpleMetaFeed f;
  
  public WSProfileWorkHolder(ViewGroup paramViewGroup, WSProfileWorkAdapter paramWSProfileWorkAdapter)
  {
    super(paramViewGroup, 1929773080);
    this.e = paramWSProfileWorkAdapter;
    c();
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (FrameLayout)((View)localObject).findViewById(1929707531);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (paramInt != 0)
    {
      if (paramInt == 2)
      {
        paramInt = a;
        localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, paramInt, paramInt, 0.0F, 0.0F, 0.0F, 0.0F });
      }
    }
    else
    {
      paramInt = a;
      localGradientDrawable.setCornerRadii(new float[] { paramInt, paramInt, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    }
    localGradientDrawable.setColor(b().getResources().getColor(2131165568));
    ((FrameLayout)localObject).setBackgroundDrawable(localGradientDrawable);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.itemView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.itemView.setLayoutParams(localLayoutParams);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      localObject = this.f;
      if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (TextUtils.equals(this.e.a(), this.f.id)))
      {
        if (this.d == null)
        {
          this.d = ((ViewStub)this.itemView.findViewById(1929707538)).inflate();
          localObject = (TextView)this.d.findViewById(1929707587);
          Drawable localDrawable = b().getResources().getDrawable(2130844246);
          localDrawable.setBounds(new Rect(0, 0, WeishiUIUtil.k, WeishiUIUtil.k));
          ((TextView)localObject).setCompoundDrawablePadding(WeishiUIUtil.c);
          ((TextView)localObject).setCompoundDrawables(localDrawable, null, null, null);
        }
        localObject = this.d;
        if (localObject != null)
        {
          localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).width = paramInt1;
          ((FrameLayout.LayoutParams)localObject).height = paramInt2;
          this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.d.setVisibility(0);
        }
        a(getAdapterPosition());
        return;
      }
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void c()
  {
    this.b = ((RoundCornerImageView)this.itemView.findViewById(1929707568));
    this.c = ((TextView)this.itemView.findViewById(1929707610));
  }
  
  private void d()
  {
    int i = getAdapterPosition();
    if (i != 0)
    {
      if (i != 2)
      {
        this.b.setCorner(0, -1);
        return;
      }
      this.b.setCorner(WeishiUIUtil.u, 3);
      return;
    }
    this.b.setCorner(WeishiUIUtil.u, 2);
  }
  
  private Pair<Integer, Integer> e()
  {
    return new Pair(Integer.valueOf(f()), Integer.valueOf((int)(f() * 1.333333F)));
  }
  
  private int f()
  {
    return (WeishiUIUtil.c() - WeishiUIUtil.i * 2 - WeishiUIUtil.c * 2) / 3;
  }
  
  public stSimpleMetaFeed a()
  {
    return this.f;
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    if (paramWSVerticalItemData != null)
    {
      paramWSVerticalItemData = paramWSVerticalItemData.b();
      this.f = paramWSVerticalItemData;
      if (paramWSVerticalItemData == null) {
        return;
      }
      d();
      WSPicLoader.a().a(this.b, this.f, true, "homepage_main", getAdapterPosition());
      paramWSVerticalItemData = b().getResources().getDrawable(2130844246);
      paramWSVerticalItemData.setBounds(new Rect(0, 0, WeishiUIUtil.h, WeishiUIUtil.h));
      this.c.setCompoundDrawablePadding(WeishiUIUtil.c);
      this.c.setCompoundDrawables(paramWSVerticalItemData, null, null, null);
      this.c.setText(WSTextFormatter.b(this.f.playNum));
      paramWSVerticalItemData = e();
      a(((Integer)paramWSVerticalItemData.first).intValue(), ((Integer)paramWSVerticalItemData.second).intValue());
      b(((Integer)paramWSVerticalItemData.first).intValue(), ((Integer)paramWSVerticalItemData.second).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorkHolder
 * JD-Core Version:    0.7.0.1
 */