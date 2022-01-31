package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import bdgk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import java.util.List;
import ors;
import pgd;
import pxk;
import pxt;
import qbs;
import qlj;
import qlk;
import qmw;
import qmy;
import rqj;

public class ComponentTitle
  extends FrameLayout
  implements pxk
{
  qbs a;
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
    if ((paramObject instanceof pgd))
    {
      this.a.a((pgd)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new qbs();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559978, this, true);
    this.c = ((TextView)findViewById(2131364669));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.a.a(paramObject);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        ArticleInfo localArticleInfo = paramObject.a();
        if (((rqj.b(localArticleInfo)) || (rqj.i(localArticleInfo)) || (rqj.j(localArticleInfo)) || (rqj.k(localArticleInfo))) && (!rqj.q(paramObject.a()))) {
          paramObject = ((qmy)paramObject.a().mSocialFeedInfo.a.b.get(0)).e;
        }
        for (;;)
        {
          localSpannableStringBuilder.append(paramObject);
          this.c.setText(localSpannableStringBuilder);
          return;
          if (ors.s(localArticleInfo)) {
            paramObject = ((qlk)localArticleInfo.mNewPolymericInfo.a.get(0)).a;
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
  
  public void a(pxt parampxt)
  {
    this.a.a(parampxt);
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
      if ((bdgk.k() >= 1080L) && (this.c != null) && ((this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localLayoutParams.topMargin = Math.max(localLayoutParams.topMargin - aepi.a(4.5F, getResources()), 0);
        localLayoutParams.bottomMargin = Math.max(localLayoutParams.bottomMargin - aepi.a(6.0F, getResources()), 0);
      }
      this.c.setLayoutParams(localLayoutParams);
      return;
      Object localObject;
      if (ors.s(this.a.a.a()))
      {
        this.c.setTextSize(14.0F);
        this.c.setTextColor(Color.parseColor("#D8FFFFFF"));
        this.c.setLines(2);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = aepi.a(4.0F, getResources());
        ((FrameLayout.LayoutParams)localObject).rightMargin = aepi.a(10.0F, getResources());
        ((FrameLayout.LayoutParams)localObject).bottomMargin = aepi.a(0.0F, getResources());
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c.setGravity(51);
        this.c.setPadding(0, aepi.a(2.0F, getResources()), 0, aepi.a(2.0F, getResources()));
      }
      else if (this.a.j())
      {
        int i = this.c.getPaddingTop();
        this.c.getBottom();
        int j = this.c.getPaddingLeft();
        int k = this.c.getPaddingRight();
        if (this.a.a())
        {
          localLayoutParams.topMargin = aepi.a(0.0F, getResources());
          localLayoutParams.bottomMargin = aepi.a(0.0F, getResources());
          localLayoutParams.leftMargin = aepi.a(11.0F, getResources());
          localLayoutParams.rightMargin = aepi.a(11.0F, getResources());
          int m = aepi.a(10.0F, getResources());
          this.c.setPadding(j, i, k, m);
        }
        else
        {
          localLayoutParams.topMargin = aepi.a(18.0F, getResources());
          localLayoutParams.bottomMargin = aepi.a(0.0F, getResources());
          localLayoutParams.leftMargin = aepi.a(11.0F, getResources());
          localLayoutParams.rightMargin = aepi.a(11.0F, getResources());
          this.c.setPadding(j, i, k, 0);
        }
      }
      else if ((this.a.b()) || (this.a.c()))
      {
        localLayoutParams.topMargin = aepi.a(0.0F, getResources());
        localLayoutParams.bottomMargin = aepi.a(0.0F, getResources());
        localLayoutParams.leftMargin = aepi.a(12.0F, getResources());
        localLayoutParams.rightMargin = aepi.a(20.0F, getResources());
      }
      else if (this.a.d())
      {
        localLayoutParams.topMargin = aepi.a(0.0F, getResources());
        localLayoutParams.bottomMargin = aepi.a(0.0F, getResources());
        localLayoutParams.leftMargin = aepi.a(12.0F, getResources());
        localLayoutParams.rightMargin = aepi.a(20.0F, getResources());
      }
      else
      {
        if ((!this.a.e()) && (!this.a.g()))
        {
          localObject = this.a;
          if ((!qbs.b(this.a.a.a())) && (!this.a.h())) {}
        }
        else
        {
          localLayoutParams.topMargin = aepi.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aepi.a(17.0F, getResources());
          localLayoutParams.leftMargin = aepi.a(12.0F, getResources());
          localLayoutParams.rightMargin = aepi.a(12.0F, getResources());
          continue;
        }
        if (this.a.f())
        {
          this.c.setMinimumHeight(aepi.a(40.0F, getResources()));
        }
        else if (this.a.a())
        {
          localLayoutParams.topMargin = aepi.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aepi.a(0.0F, getResources());
          localLayoutParams.leftMargin = aepi.a(11.0F, getResources());
          localLayoutParams.rightMargin = aepi.a(11.0F, getResources());
        }
        else
        {
          localLayoutParams.topMargin = aepi.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aepi.a(11.0F, getResources());
          localLayoutParams.leftMargin = aepi.a(11.0F, getResources());
          localLayoutParams.rightMargin = aepi.a(11.0F, getResources());
        }
      }
    }
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.i()) && (!this.a.k()))
    {
      qbs localqbs = this.a;
      if (!qbs.b(this.a.a.a()))
      {
        if (paramBoolean) {
          break label68;
        }
        this.c.setTextColor(getContext().getResources().getColor(2131165307));
      }
    }
    return;
    label68:
    this.c.setTextColor(getContext().getResources().getColor(2131166380));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */