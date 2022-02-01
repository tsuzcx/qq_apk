package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;

public class StatusView
  extends BaseWidgetView
{
  private View c;
  private ImageView d;
  private TextView e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private LinearLayout j;
  private String k;
  private String l = getResources().getString(2131899714);
  private int m = 18;
  private int n = -16777216;
  
  public StatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  public void a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8)) {
      this.e.setVisibility(0);
    }
    localObject = this.d;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 8)) {
      this.d.setVisibility(0);
    }
    setVisible(true);
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.c = paramView.findViewById(2131445015);
    this.d = ((ImageView)paramView.findViewById(2131436363));
    this.f = ((ImageView)paramView.findViewById(2131436448));
    this.e = ((TextView)paramView.findViewById(2131448433));
    this.g = ((TextView)paramView.findViewById(2131448629));
    this.h = ((TextView)paramView.findViewById(2131448790));
    this.i = ((TextView)paramView.findViewById(2131448663));
    this.j = ((LinearLayout)paramView.findViewById(2131437523));
    paramContext = new StringBuilder();
    paramContext.append(SubscribeUtils.b());
    paramContext.append("/certified_account_feed_error.png");
    setHintImageFilePath(paramContext.toString());
    setBackgroundColor(-1);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SubscribeUtils.b());
    ((StringBuilder)localObject).append("/certified_account_feeds_empty.png");
    setHintImageFilePath(((StringBuilder)localObject).toString());
    a(HardCodeUtil.a(2131916927), 13, getResources().getColor(2131168245));
    localObject = this.g;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.g.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SubscribeUtils.b());
    ((StringBuilder)localObject).append("/certified_account_feeds_empty.png");
    setHintImageFilePath(((StringBuilder)localObject).toString());
    a(HardCodeUtil.a(2131916930), 13, getResources().getColor(2131168245));
    localObject = this.j;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.h.setOnClickListener(paramOnClickListener1);
      this.i.setOnClickListener(paramOnClickListener2);
    }
  }
  
  protected void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    a(paramString, this.m, this.n);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    a();
  }
  
  public void b()
  {
    setVisible(false);
  }
  
  public void b(String paramString)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      if (!paramString.equals(this.k)) {
        try
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130853592);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130853592);
          this.f.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
          this.k = paramString;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      setVisible(true);
    }
  }
  
  public void c()
  {
    this.f.setVisibility(8);
    setVisible(false);
  }
  
  public ImageView getIvHintPic()
  {
    return this.d;
  }
  
  public ImageView getIvLoadingPic()
  {
    return this.f;
  }
  
  protected int getLayoutId()
  {
    return 2131624360;
  }
  
  public TextView getTvHint()
  {
    return this.e;
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.d != null) {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130853592);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130853592);
        this.d.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setTextHint(String paramString)
  {
    setTextHint(paramString, this.m, this.n);
  }
  
  public void setTextHint(String paramString, float paramFloat, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.l;
    }
    paramString = this.e;
    if (paramString != null)
    {
      paramString.setText(str);
      this.e.setTextSize(paramFloat);
      this.e.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.StatusView
 * JD-Core Version:    0.7.0.1
 */