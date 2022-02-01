package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;

public class ComponentTitle
  extends FrameLayout
  implements ComponentView
{
  CmpCtxt a;
  TextView c;
  
  public ComponentTitle(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, Object paramObject)
  {
    super(paramContext);
    a(paramContext, paramObject);
  }
  
  private void a(Context paramContext, Object paramObject)
  {
    b(paramContext);
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.a.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560269, this, true);
    this.c = ((TextView)findViewById(2131365177));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        ArticleInfo localArticleInfo = paramObject.a();
        if (((RIJItemViewType.g(localArticleInfo)) || (RIJItemViewType.i(localArticleInfo)) || (RIJItemViewType.j(localArticleInfo)) || (RIJItemViewType.k(localArticleInfo))) && (!RIJItemViewType.q(paramObject.a()))) {
          paramObject = ((SocializeFeedsInfo.UGCVideoInfo)paramObject.a().mSocialFeedInfo.a.b.get(0)).e;
        }
        for (;;)
        {
          localSpannableStringBuilder.append(paramObject);
          this.c.setText(localSpannableStringBuilder);
          return;
          if (RIJFeedsType.g(localArticleInfo)) {
            paramObject = ((NewPolymericInfo.PackArticleInfo)localArticleInfo.mNewPolymericInfo.a.get(0)).a;
          } else {
            paramObject = paramObject.a().mTitle;
          }
        }
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    if (this.a.k())
    {
      localLayoutParams1.setMargins(0, 0, 0, 0);
      if (this.a.l()) {
        this.c.setLineSpacing(4.0F, 1.0F);
      }
    }
    for (;;)
    {
      if ((DeviceInfoUtil.k() >= 1080L) && ((this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localLayoutParams1.topMargin = Math.max(localLayoutParams1.topMargin - AIOUtils.a(4.5F, getResources()), 0);
        localLayoutParams1.bottomMargin = Math.max(localLayoutParams1.bottomMargin - AIOUtils.a(6.0F, getResources()), 0);
      }
      this.c.setLayoutParams(localLayoutParams1);
      return;
      if (RIJFeedsType.g(this.a.a.a()))
      {
        this.c.setTextSize(14.0F);
        this.c.setTextColor(Color.parseColor("#D8FFFFFF"));
        this.c.setLines(2);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        localLayoutParams2.leftMargin = 0;
        localLayoutParams2.topMargin = AIOUtils.a(4.0F, getResources());
        localLayoutParams2.rightMargin = AIOUtils.a(10.0F, getResources());
        localLayoutParams2.bottomMargin = AIOUtils.a(0.0F, getResources());
        this.c.setLayoutParams(localLayoutParams2);
        this.c.setGravity(51);
        this.c.setPadding(0, AIOUtils.a(2.0F, getResources()), 0, AIOUtils.a(2.0F, getResources()));
      }
      else if (this.a.j())
      {
        int i = this.c.getPaddingTop();
        this.c.getBottom();
        int j = this.c.getPaddingLeft();
        int k = this.c.getPaddingRight();
        if (this.a.a())
        {
          localLayoutParams1.topMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams1.bottomMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams1.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams1.rightMargin = AIOUtils.a(11.0F, getResources());
          int m = AIOUtils.a(10.0F, getResources());
          this.c.setPadding(j, i, k, m);
        }
        else
        {
          localLayoutParams1.topMargin = AIOUtils.a(18.0F, getResources());
          localLayoutParams1.bottomMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams1.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams1.rightMargin = AIOUtils.a(11.0F, getResources());
          this.c.setPadding(j, i, k, 0);
        }
      }
      else if ((this.a.b()) || (this.a.c()))
      {
        localLayoutParams1.topMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.a(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.a(20.0F, getResources());
      }
      else if (this.a.d())
      {
        localLayoutParams1.topMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.a(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.a(20.0F, getResources());
      }
      else if ((this.a.e()) || (this.a.g()) || (CmpCtxt.b(this.a.a.a())) || (this.a.h()))
      {
        localLayoutParams1.topMargin = AIOUtils.a(13.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.a(17.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.a(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.a(12.0F, getResources());
      }
      else if (this.a.f())
      {
        this.c.setMinimumHeight(AIOUtils.a(40.0F, getResources()));
      }
      else if (this.a.a())
      {
        localLayoutParams1.topMargin = AIOUtils.a(13.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.a(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.a(11.0F, getResources());
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.a(13.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.a(11.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.a(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.a(11.0F, getResources());
      }
    }
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.i()) && (!this.a.k()) && (!CmpCtxt.b(this.a.a.a())))
    {
      if (!paramBoolean) {
        this.c.setTextColor(getContext().getResources().getColor(2131165357));
      }
    }
    else {
      return;
    }
    this.c.setTextColor(getContext().getResources().getColor(2131166494));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */