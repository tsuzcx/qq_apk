package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView;

public class QCircleCertifiedPart
  extends QCircleBasePart
{
  private ViewStub a;
  private FrameLayout c;
  private QCircleCertifiedDialogView d;
  private ImageView e;
  private boolean f;
  private QCircleTabInfo g;
  
  private void a(String paramString)
  {
    QCircleLauncher.a(g(), paramString, null, -1);
    if (this.f) {
      m();
    }
  }
  
  private void i()
  {
    if (F() != null)
    {
      if (this.a != null) {
        return;
      }
      this.a = ((ViewStub)F().findViewById(2131441592));
      Object localObject = this.a;
      if (localObject != null)
      {
        localObject = ((ViewStub)localObject).inflate();
        this.e = ((ImageView)((View)localObject).findViewById(2131441626));
        this.c = ((FrameLayout)((View)localObject).findViewById(2131441625));
        this.c.setVisibility(8);
      }
    }
  }
  
  private void l()
  {
    i();
    if (this.c != null)
    {
      this.e.setOnClickListener(new QCircleCertifiedPart.1(this));
      Object localObject = this.d;
      if (localObject == null) {
        this.d = new QCircleCertifiedDialogView(g());
      } else if (((QCircleCertifiedDialogView)localObject).getParent() != null) {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
      }
      this.d.setCertifiedListener(new QCircleCertifiedPart.2(this));
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.c.addView(this.d, (ViewGroup.LayoutParams)localObject);
      this.c.setVisibility(0);
    }
  }
  
  private void m()
  {
    FrameLayout localFrameLayout = this.c;
    if (localFrameLayout != null)
    {
      QCircleCertifiedDialogView localQCircleCertifiedDialogView = this.d;
      if (localQCircleCertifiedDialogView != null)
      {
        localFrameLayout.removeView(localQCircleCertifiedDialogView);
        this.c.setVisibility(8);
      }
    }
  }
  
  public String a()
  {
    return "QCircleCertifiedPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ("tag_cetrified_part_show".equals(paramString))
    {
      l();
      return;
    }
    if ("tag_cetrified_part_show_gone".equals(paramString)) {
      m();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCertifiedPart
 * JD-Core Version:    0.7.0.1
 */