package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailBannerIndicator
  extends LinearLayout
{
  private final String a = "#FFFFFFFF";
  private final String b = "#33FFFFFF";
  private Context c;
  private int d = 0;
  private int e = 0;
  private ArrayList<ImageView> f = new ArrayList();
  
  public AccountDetailBannerIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.c = paramContext;
    this.d = paramInt;
    a();
  }
  
  private void a()
  {
    int j = AIOUtils.b(6.0F, this.c.getResources());
    int k = AIOUtils.b(9.0F, this.c.getResources());
    int i = 0;
    while (i < this.d)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.c);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(k, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.c);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
      if (i == 0) {
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
      } else {
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
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
    ((ImageView)this.f.get(this.e)).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
    this.e = j;
    ((ImageView)this.f.get(this.e)).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerIndicator
 * JD-Core Version:    0.7.0.1
 */