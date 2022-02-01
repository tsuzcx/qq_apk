package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedHintView;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class QFSPersonalHintViewPart
  extends QFSBasePart
{
  private QFSPersonalFeedHintView a;
  private FrameLayout b;
  private View c;
  private AlphaAnimation d;
  private String e = "no_product";
  
  private void n()
  {
    VideoReport.setElementId(this.a, "em_xsj_void_item");
    QFSPersonalHintViewPart.1 local1 = new QFSPersonalHintViewPart.1(this);
    VideoReport.setEventDynamicParams(this.a, local1);
  }
  
  public String a()
  {
    return "FSPersonalFeedPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((QFSPersonalFeedHintView)paramView.findViewById(2131441958));
    this.b = ((FrameLayout)paramView.findViewById(2131441969));
    this.c = paramView.findViewById(2131441993);
    n();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
    this.b.setVisibility(8);
    this.e = "no_product";
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.a.b(paramString1, paramString2);
    this.b.setVisibility(8);
  }
  
  public void d()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    if (this.d == null)
    {
      this.d = new AlphaAnimation(1.0F, 0.5F);
      this.d.setRepeatMode(2);
      this.d.setRepeatCount(2147483647);
      this.d.setDuration(1000L);
    }
    this.c.startAnimation(this.d);
  }
  
  public void e()
  {
    this.a.b();
    this.b.setVisibility(8);
    this.e = "set_permission";
  }
  
  public void f()
  {
    this.a.d();
    this.b.setVisibility(8);
    this.c.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart
 * JD-Core Version:    0.7.0.1
 */