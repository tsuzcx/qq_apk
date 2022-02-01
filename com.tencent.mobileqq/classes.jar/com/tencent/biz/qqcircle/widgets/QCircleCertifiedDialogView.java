package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QCircleCertifiedDialogView
  extends RelativeLayout
  implements View.OnClickListener
{
  private URLImageView a;
  private URLImageView b;
  private ImageView c;
  private ImageView d;
  private QCircleCertifiedDialogView.ICertifiedListener e;
  
  public QCircleCertifiedDialogView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131626769, this);
    setBackgroundDrawable(getResources().getDrawable(2130845055));
    this.a = ((URLImageView)findViewById(2131449806));
    this.b = ((URLImageView)findViewById(2131449807));
    this.c = ((ImageView)findViewById(2131436304));
    this.d = ((ImageView)findViewById(2131436305));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.a.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_RUD3Zf0Pyz.png");
    this.b.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_OASs9ECpAn.png");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QCircleCertifiedDialogView.ICertifiedListener localICertifiedListener;
    if ((i != 2131436304) && (i != 2131449806))
    {
      if ((i == 2131449807) || (i == 2131436305))
      {
        localICertifiedListener = this.e;
        if (localICertifiedListener != null) {
          localICertifiedListener.b();
        }
      }
    }
    else
    {
      localICertifiedListener = this.e;
      if (localICertifiedListener != null) {
        localICertifiedListener.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCertifiedListener(QCircleCertifiedDialogView.ICertifiedListener paramICertifiedListener)
  {
    this.e = paramICertifiedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView
 * JD-Core Version:    0.7.0.1
 */