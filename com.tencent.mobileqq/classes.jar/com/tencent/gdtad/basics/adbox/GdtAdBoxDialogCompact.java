package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class GdtAdBoxDialogCompact
  extends GdtAdBoxDialog
{
  private final boolean h;
  
  public GdtAdBoxDialogCompact(@NonNull Context paramContext)
  {
    super(paramContext);
    boolean bool;
    if (this.a.getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
  }
  
  protected void a()
  {
    if (this.h)
    {
      GdtLog.a("GdtAdBoxDialog", "landscape");
      if (this.f != null)
      {
        Object localObject1 = (ImageView)this.f.findViewById(2131436603);
        Object localObject2 = ((ImageView)localObject1).getLayoutParams();
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          ((FrameLayout.LayoutParams)localObject2).width = ViewUtils.dip2px(25.0F);
          ((FrameLayout.LayoutParams)localObject2).height = ViewUtils.dip2px(15.0F);
          ((FrameLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(5.0F);
          ((FrameLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(5.0F);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = (ImageView)findViewById(2131449302);
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          ((FrameLayout.LayoutParams)localObject2).width = ViewUtils.dip2px(25.0F);
          ((FrameLayout.LayoutParams)localObject2).height = ViewUtils.dip2px(25.0F);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = this.e.getLayoutParams();
        if ((localObject1 instanceof FrameLayout.LayoutParams))
        {
          localObject1 = (FrameLayout.LayoutParams)localObject1;
          ((FrameLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.dip2px(25.0F);
          this.e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    else
    {
      super.a();
      GdtLog.a("GdtAdBoxDialog", "portrait");
    }
  }
  
  protected void a(GdtAdBoxModel paramGdtAdBoxModel)
  {
    if (this.h)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindData() called with: model = [");
      ((StringBuilder)localObject).append(paramGdtAdBoxModel);
      ((StringBuilder)localObject).append("]");
      GdtLog.a("GdtAdBoxDialog", ((StringBuilder)localObject).toString());
      int j = this.b.a().getAds().size();
      if (j == 0)
      {
        paramGdtAdBoxModel = new StringBuilder();
        paramGdtAdBoxModel.append("bindData() called with: total = [");
        paramGdtAdBoxModel.append(j);
        paramGdtAdBoxModel.append("]");
        GdtLog.a("GdtAdBoxDialog", paramGdtAdBoxModel.toString());
        this.f.post(new GdtAdBoxDialogCompact.1(this));
        return;
      }
      if (j > 9) {
        j = 9;
      }
      int m = (int)Math.ceil(j * 1.0F / 3);
      this.e.setColumnCount(3);
      this.e.setRowCount(m);
      int n = ViewUtils.dip2px(21.0F);
      int i1 = ViewUtils.dip2px(25.0F);
      int i2 = ViewUtils.dip2px(8.0F);
      int i3 = ViewUtils.dip2px(25.0F);
      int i4 = ViewUtils.dip2px(43.0F);
      int i5 = i4 + ViewUtils.dip2px(20.0F);
      int i6 = ViewUtils.dip2px(12.0F);
      this.e.removeAllViews();
      paramGdtAdBoxModel = LayoutInflater.from(this.a);
      int i = 0;
      while (i < m)
      {
        int k = 0;
        while ((k < 3) && (3 * i + k < j))
        {
          localObject = (LinearLayout)paramGdtAdBoxModel.inflate(2131624925, null);
          super.a(3, n, i1, i4, i5, i6, i, k, (LinearLayout)localObject);
          this.e.addView((View)localObject);
          k += 1;
        }
        i += 1;
      }
      paramGdtAdBoxModel = this.f.getLayoutParams();
      paramGdtAdBoxModel.width = (n + (i4 + i6) * 3 + i2);
      paramGdtAdBoxModel.height = (i1 + (i5 + i6) * m + i3);
      this.f.setLayoutParams(paramGdtAdBoxModel);
      return;
    }
    super.a(paramGdtAdBoxModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialogCompact
 * JD-Core Version:    0.7.0.1
 */