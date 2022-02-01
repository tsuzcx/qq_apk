package com.tencent.biz.qqcircle.immersive.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class QFSMultiTabView
{
  private final FrameLayout a;
  private final TextView b;
  private final View c;
  private final ImageView d;
  
  public QFSMultiTabView(ViewGroup paramViewGroup)
  {
    this.a = ((FrameLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627126, paramViewGroup, false));
    this.b = ((TextView)this.a.findViewById(16908308));
    this.c = this.a.findViewById(2131433874);
    this.d = ((ImageView)this.a.findViewById(2131439452));
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      localViewGroup.setClipChildren(false);
      localViewGroup.setClipToPadding(false);
    }
    if ((paramView.getParent() instanceof View)) {
      a((View)paramView.getParent());
    }
  }
  
  public void b()
  {
    View localView = this.c;
    if (localView == null) {
      return;
    }
    localView.setVisibility(0);
  }
  
  public void c()
  {
    View localView = this.c;
    if (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void d()
  {
    QLog.d("QCircleFolderTabView", 2, "showNewTips");
    a(this.a);
    this.d.setVisibility(0);
  }
  
  public void e()
  {
    QLog.d("QCircleFolderTabView", 2, "hideNewTips");
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSMultiTabView
 * JD-Core Version:    0.7.0.1
 */