package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
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
import babp;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import java.util.List;
import obz;
import opw;
import pey;
import pfh;
import pjg;
import ppu;
import ppv;
import pre;
import prg;
import qoe;

public class ComponentTitle
  extends FrameLayout
  implements pey
{
  pjg a;
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
    if ((paramObject instanceof opw))
    {
      this.a.a((opw)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new pjg();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131494313, this, true);
    this.c = ((TextView)findViewById(2131299031));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      paramObject = (opw)paramObject;
      this.a.a(paramObject);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        ArticleInfo localArticleInfo = paramObject.a();
        if (((qoe.a(localArticleInfo)) || (qoe.i(localArticleInfo)) || (qoe.j(localArticleInfo)) || (qoe.k(localArticleInfo))) && (!qoe.q(paramObject.a()))) {
          paramObject = ((prg)paramObject.a().mSocialFeedInfo.a.b.get(0)).e;
        }
        for (;;)
        {
          localSpannableStringBuilder.append(paramObject);
          this.c.setText(localSpannableStringBuilder);
          return;
          if (obz.s(localArticleInfo)) {
            paramObject = ((ppv)localArticleInfo.mNewPolymericInfo.a.get(0)).a;
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
  
  public void a(pfh parampfh)
  {
    this.a.a(parampfh);
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
      if ((babp.k() >= 1080L) && (this.c != null) && ((this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localLayoutParams.topMargin = Math.max(localLayoutParams.topMargin - aciy.a(4.5F, getResources()), 0);
        localLayoutParams.bottomMargin = Math.max(localLayoutParams.bottomMargin - aciy.a(6.0F, getResources()), 0);
      }
      this.c.setLayoutParams(localLayoutParams);
      return;
      Object localObject;
      if (obz.s(this.a.a.a()))
      {
        this.c.setTextSize(14.0F);
        this.c.setTextColor(Color.parseColor("#D8FFFFFF"));
        this.c.setLines(2);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = aciy.a(4.0F, getResources());
        ((FrameLayout.LayoutParams)localObject).rightMargin = aciy.a(10.0F, getResources());
        ((FrameLayout.LayoutParams)localObject).bottomMargin = aciy.a(0.0F, getResources());
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c.setGravity(51);
        this.c.setPadding(0, aciy.a(2.0F, getResources()), 0, aciy.a(2.0F, getResources()));
      }
      else if (this.a.j())
      {
        int i = this.c.getPaddingTop();
        this.c.getBottom();
        int j = this.c.getPaddingLeft();
        int k = this.c.getPaddingRight();
        if (this.a.a())
        {
          localLayoutParams.topMargin = aciy.a(0.0F, getResources());
          localLayoutParams.bottomMargin = aciy.a(0.0F, getResources());
          localLayoutParams.leftMargin = aciy.a(11.0F, getResources());
          localLayoutParams.rightMargin = aciy.a(11.0F, getResources());
          int m = aciy.a(10.0F, getResources());
          this.c.setPadding(j, i, k, m);
        }
        else
        {
          localLayoutParams.topMargin = aciy.a(18.0F, getResources());
          localLayoutParams.bottomMargin = aciy.a(0.0F, getResources());
          localLayoutParams.leftMargin = aciy.a(11.0F, getResources());
          localLayoutParams.rightMargin = aciy.a(11.0F, getResources());
          this.c.setPadding(j, i, k, 0);
        }
      }
      else if ((this.a.b()) || (this.a.c()))
      {
        localLayoutParams.topMargin = aciy.a(0.0F, getResources());
        localLayoutParams.bottomMargin = aciy.a(0.0F, getResources());
        localLayoutParams.leftMargin = aciy.a(12.0F, getResources());
        localLayoutParams.rightMargin = aciy.a(20.0F, getResources());
      }
      else if (this.a.d())
      {
        localLayoutParams.topMargin = aciy.a(0.0F, getResources());
        localLayoutParams.bottomMargin = aciy.a(0.0F, getResources());
        localLayoutParams.leftMargin = aciy.a(12.0F, getResources());
        localLayoutParams.rightMargin = aciy.a(20.0F, getResources());
      }
      else
      {
        if ((!this.a.e()) && (!this.a.g()))
        {
          localObject = this.a;
          if ((!pjg.b(this.a.a.a())) && (!this.a.h())) {}
        }
        else
        {
          localLayoutParams.topMargin = aciy.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aciy.a(17.0F, getResources());
          localLayoutParams.leftMargin = aciy.a(12.0F, getResources());
          localLayoutParams.rightMargin = aciy.a(12.0F, getResources());
          continue;
        }
        if (this.a.f())
        {
          this.c.setMinimumHeight(aciy.a(40.0F, getResources()));
        }
        else if (this.a.a())
        {
          localLayoutParams.topMargin = aciy.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aciy.a(0.0F, getResources());
          localLayoutParams.leftMargin = aciy.a(11.0F, getResources());
          localLayoutParams.rightMargin = aciy.a(11.0F, getResources());
        }
        else
        {
          localLayoutParams.topMargin = aciy.a(13.0F, getResources());
          localLayoutParams.bottomMargin = aciy.a(11.0F, getResources());
          localLayoutParams.leftMargin = aciy.a(11.0F, getResources());
          localLayoutParams.rightMargin = aciy.a(11.0F, getResources());
        }
      }
    }
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.i()) && (!this.a.k()))
    {
      pjg localpjg = this.a;
      if (!pjg.b(this.a.a.a()))
      {
        if (paramBoolean) {
          break label68;
        }
        this.c.setTextColor(getContext().getResources().getColor(2131099738));
      }
    }
    return;
    label68:
    this.c.setTextColor(getContext().getResources().getColor(2131100738));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */