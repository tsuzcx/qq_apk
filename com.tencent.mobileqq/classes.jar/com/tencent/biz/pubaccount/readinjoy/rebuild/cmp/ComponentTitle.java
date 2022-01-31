package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;

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
    LayoutInflater.from(paramContext).inflate(2130969587, this, true);
    this.c = ((TextView)findViewById(2131367055));
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
      try
      {
        ArticleInfo localArticleInfo = paramObject.a();
        if (((ReadInJoyBaseAdapter.f(localArticleInfo)) || (ReadInJoyBaseAdapter.g(localArticleInfo)) || (ReadInJoyBaseAdapter.h(localArticleInfo)) || (ReadInJoyBaseAdapter.i(localArticleInfo))) && (!ReadInJoyBaseAdapter.o(paramObject.a())))
        {
          this.c.setText(((SocializeFeedsInfo.UGCVideoInfo)paramObject.a().mSocialFeedInfo.a.b.get(0)).e);
          return;
        }
        this.c.setText(paramObject.a().mTitle);
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
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    if (this.a.k())
    {
      localLayoutParams.setMargins(0, 0, 0, 0);
      if (this.a.l()) {
        this.c.setLineSpacing(4.0F, 1.0F);
      }
    }
    for (;;)
    {
      if ((DeviceInfoUtil.l() >= 1080L) && (this.c != null) && ((this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localLayoutParams.topMargin = Math.max(localLayoutParams.topMargin - AIOUtils.a(4.5F, getResources()), 0);
        localLayoutParams.bottomMargin = Math.max(localLayoutParams.bottomMargin - AIOUtils.a(6.0F, getResources()), 0);
      }
      this.c.setLayoutParams(localLayoutParams);
      return;
      if (this.a.j())
      {
        int i = this.c.getPaddingTop();
        this.c.getBottom();
        int j = this.c.getPaddingLeft();
        int k = this.c.getPaddingRight();
        if (this.a.a())
        {
          localLayoutParams.topMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams.rightMargin = AIOUtils.a(11.0F, getResources());
          int m = AIOUtils.a(10.0F, getResources());
          this.c.setPadding(j, i, k, m);
        }
        else
        {
          localLayoutParams.topMargin = AIOUtils.a(18.0F, getResources());
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams.rightMargin = AIOUtils.a(11.0F, getResources());
          this.c.setPadding(j, i, k, 0);
        }
      }
      else if ((this.a.b()) || (this.a.c()))
      {
        localLayoutParams.topMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams.leftMargin = AIOUtils.a(12.0F, getResources());
        localLayoutParams.rightMargin = AIOUtils.a(20.0F, getResources());
      }
      else if (this.a.d())
      {
        localLayoutParams.topMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(0.0F, getResources());
        localLayoutParams.leftMargin = AIOUtils.a(12.0F, getResources());
        localLayoutParams.rightMargin = AIOUtils.a(20.0F, getResources());
      }
      else
      {
        if ((!this.a.e()) && (!this.a.g()))
        {
          CmpCtxt localCmpCtxt = this.a;
          if ((!CmpCtxt.b(this.a.a.a())) && (!this.a.h())) {}
        }
        else
        {
          localLayoutParams.topMargin = AIOUtils.a(13.0F, getResources());
          localLayoutParams.bottomMargin = AIOUtils.a(17.0F, getResources());
          localLayoutParams.leftMargin = AIOUtils.a(12.0F, getResources());
          localLayoutParams.rightMargin = AIOUtils.a(12.0F, getResources());
          continue;
        }
        if (this.a.f())
        {
          this.c.setMinimumHeight(AIOUtils.a(40.0F, getResources()));
        }
        else if (this.a.a())
        {
          localLayoutParams.topMargin = AIOUtils.a(13.0F, getResources());
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, getResources());
          localLayoutParams.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams.rightMargin = AIOUtils.a(11.0F, getResources());
        }
        else
        {
          localLayoutParams.topMargin = AIOUtils.a(13.0F, getResources());
          localLayoutParams.bottomMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams.leftMargin = AIOUtils.a(11.0F, getResources());
          localLayoutParams.rightMargin = AIOUtils.a(11.0F, getResources());
        }
      }
    }
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.i()) && (!this.a.k()))
    {
      CmpCtxt localCmpCtxt = this.a;
      if (!CmpCtxt.b(this.a.a.a()))
      {
        if (paramBoolean) {
          break label68;
        }
        this.c.setTextColor(getContext().getResources().getColor(2131492971));
      }
    }
    return;
    label68:
    this.c.setTextColor(getContext().getResources().getColor(2131493482));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */