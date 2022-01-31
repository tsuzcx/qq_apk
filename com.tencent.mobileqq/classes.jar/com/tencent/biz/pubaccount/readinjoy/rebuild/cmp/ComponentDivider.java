package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import opw;
import pey;
import pfh;
import pjg;
import pmu;

public class ComponentDivider
  extends View
  implements pey
{
  pjg a;
  
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
    setBackgroundColor(getContext().getResources().getColor(2131101143));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      this.a.a((opw)paramObject);
      if ((((opw)paramObject).a() == 53) && ((getLayoutParams() instanceof LinearLayout.LayoutParams)))
      {
        paramObject = (LinearLayout.LayoutParams)getLayoutParams();
        paramObject.leftMargin = Utils.dp2px(6.0D);
        paramObject.rightMargin = Utils.dp2px(6.0D);
        setBackgroundColor(getContext().getResources().getColor(2131099992));
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
  
  public void a(pfh parampfh)
  {
    this.a.a(parampfh);
  }
  
  public void b()
  {
    opw localopw = this.a.a;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    pmu.a(getContext(), localopw, localLayoutParams);
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider
 * JD-Core Version:    0.7.0.1
 */