package com.tencent.biz.pubaccount.weishi_new.drama.holder.controller;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSDramaItemVideoAreaController
  extends AbsWSDramaUIGroup
  implements View.OnClickListener
{
  private ViewGroup j;
  private KandianUrlImageView k;
  private TextView l;
  private View m;
  
  public WSDramaItemVideoAreaController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void o()
  {
    if (q())
    {
      this.k.setVisibility(8);
      return;
    }
    this.k.setVisibility(0);
    Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842687);
    WSPicLoader.a().a(this.k, p(), localDrawable);
  }
  
  private String p()
  {
    if ((this.g != null) && (this.g.dramaInfo != null)) {
      return this.g.dramaInfo.coverImg;
    }
    return "";
  }
  
  private boolean q()
  {
    return false;
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianUrlImageView localKandianUrlImageView = this.k;
    if (localKandianUrlImageView == null) {
      return;
    }
    if (paramInt1 == localKandianUrlImageView.getVisibility()) {
      return;
    }
    WeishiUtils.a(this.k, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.m.setVisibility(0);
    this.l.setVisibility(0);
    this.l.setText(paramString);
  }
  
  protected void b()
  {
    o();
    n();
  }
  
  public void d(int paramInt) {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626048;
  }
  
  protected void j()
  {
    this.j = ((FrameLayout)c(2131449415));
    this.k = ((KandianUrlImageView)c(2131449416));
    this.l = ((TextView)c(2131449418));
    this.m = c(2131449417);
    this.m.setOnClickListener(this);
  }
  
  public ViewGroup l()
  {
    return this.j;
  }
  
  public ImageView m()
  {
    return this.k;
  }
  
  public void n()
  {
    this.m.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449417) {
      n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController
 * JD-Core Version:    0.7.0.1
 */