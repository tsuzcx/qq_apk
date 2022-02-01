package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;

public class QCirclePushRankIndicator
  extends LinearLayout
{
  private static final int a = QCircleSkinHelper.getInstance().getColor(2131167076);
  private static final int b = QCircleSkinHelper.getInstance().getColor(2131167073);
  private Context c;
  private int d = 0;
  private int e = 0;
  private ArrayList<ImageView> f = new ArrayList();
  
  public QCirclePushRankIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.c = paramContext;
    this.d = paramInt;
    a();
  }
  
  private void a()
  {
    int j = ViewUtils.a(4.0F);
    int k = ViewUtils.a(20.0F);
    int m = ViewUtils.a(9.0F);
    int i = 0;
    while (i < this.d)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.c);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(m, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.c);
      if (i == 0)
      {
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(k, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(a));
      }
      else
      {
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(b));
      }
      localBubbleViewLayout.addView((View)localObject);
      this.f.add(localObject);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.d;
    if (i > 1) {
      i = paramInt % i;
    } else {
      i = paramInt;
    }
    int j = i;
    if (paramInt < 0) {
      j = i + this.d;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurrentItem->pos:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", newPos:");
      localStringBuilder.append(j);
      QLog.d("AccountDetailBannerIndicator", 2, localStringBuilder.toString());
    }
    paramInt = ViewUtils.a(4.0F);
    i = ViewUtils.a(20.0F);
    ((ImageView)this.f.get(this.e)).setImageDrawable(new ColorDrawable(a));
    ((ImageView)this.f.get(this.e)).setLayoutParams(new RelativeLayout.LayoutParams(paramInt, paramInt));
    this.e = j;
    ((ImageView)this.f.get(this.e)).setImageDrawable(new ColorDrawable(b));
    ((ImageView)this.f.get(this.e)).setLayoutParams(new RelativeLayout.LayoutParams(i, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator
 * JD-Core Version:    0.7.0.1
 */