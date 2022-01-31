package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import pgd;
import pxk;
import pxt;
import qbs;
import qfg;

public class ComponentDivider
  extends View
  implements pxk
{
  qbs a;
  
  public ComponentDivider(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentDivider(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentDivider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public ComponentDivider(Context paramContext, Object paramObject)
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
    setBackgroundColor(getContext().getResources().getColor(2131166786));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      this.a.a((pgd)paramObject);
      if ((((pgd)paramObject).a() == 53) && ((getLayoutParams() instanceof LinearLayout.LayoutParams)))
      {
        paramObject = (LinearLayout.LayoutParams)getLayoutParams();
        paramObject.leftMargin = Utils.dp2px(6.0D);
        paramObject.rightMargin = Utils.dp2px(6.0D);
        setBackgroundColor(getContext().getResources().getColor(2131165613));
      }
      if (this.a.a.e()) {
        setVisibility(0);
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(pxt parampxt)
  {
    this.a.a(parampxt);
  }
  
  public void b()
  {
    pgd localpgd = this.a.a;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    qfg.a(getContext(), localpgd, localLayoutParams);
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider
 * JD-Core Version:    0.7.0.1
 */