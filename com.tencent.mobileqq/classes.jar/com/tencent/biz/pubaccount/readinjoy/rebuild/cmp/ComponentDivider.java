package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import ppu;
import qjg;
import qjp;
import qno;
import qrc;

public class ComponentDivider
  extends View
  implements qjg
{
  qno a;
  
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
    if ((paramObject instanceof ppu))
    {
      this.a.a((ppu)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new qno();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    setBackgroundColor(getContext().getResources().getColor(2131166870));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ppu))
    {
      this.a.a((ppu)paramObject);
      if ((((ppu)paramObject).a() == 53) && ((getLayoutParams() instanceof LinearLayout.LayoutParams)))
      {
        paramObject = (LinearLayout.LayoutParams)getLayoutParams();
        paramObject.leftMargin = Utils.dp2px(6.0D);
        paramObject.rightMargin = Utils.dp2px(6.0D);
        setBackgroundColor(getContext().getResources().getColor(2131165651));
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
  
  public void a(qjp paramqjp)
  {
    this.a.a(paramqjp);
  }
  
  public void b()
  {
    ppu localppu = this.a.a;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    qrc.a(getContext(), localppu, localLayoutParams);
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider
 * JD-Core Version:    0.7.0.1
 */