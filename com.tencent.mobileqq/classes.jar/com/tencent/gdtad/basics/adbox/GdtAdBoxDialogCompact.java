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
  private final boolean a;
  
  public GdtAdBoxDialogCompact(@NonNull Context paramContext)
  {
    super(paramContext);
    boolean bool;
    if (this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GdtLog.a("GdtAdBoxDialog", "landscape");
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369516);
        Object localObject2 = ((ImageView)localObject1).getLayoutParams();
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          ((FrameLayout.LayoutParams)localObject2).width = ViewUtils.a(25.0F);
          ((FrameLayout.LayoutParams)localObject2).height = ViewUtils.a(15.0F);
          ((FrameLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(5.0F);
          ((FrameLayout.LayoutParams)localObject2).topMargin = ViewUtils.a(5.0F);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = (ImageView)findViewById(2131380358);
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          ((FrameLayout.LayoutParams)localObject2).width = ViewUtils.a(25.0F);
          ((FrameLayout.LayoutParams)localObject2).height = ViewUtils.a(25.0F);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetGridLayout.getLayoutParams();
        if ((localObject1 instanceof FrameLayout.LayoutParams))
        {
          localObject1 = (FrameLayout.LayoutParams)localObject1;
          ((FrameLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.a(25.0F);
          this.jdField_a_of_type_AndroidWidgetGridLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindData() called with: model = [");
      ((StringBuilder)localObject).append(paramGdtAdBoxModel);
      ((StringBuilder)localObject).append("]");
      GdtLog.a("GdtAdBoxDialog", ((StringBuilder)localObject).toString());
      int j = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBox.a().getAds().size();
      if (j == 0)
      {
        paramGdtAdBoxModel = new StringBuilder();
        paramGdtAdBoxModel.append("bindData() called with: total = [");
        paramGdtAdBoxModel.append(j);
        paramGdtAdBoxModel.append("]");
        GdtLog.a("GdtAdBoxDialog", paramGdtAdBoxModel.toString());
        this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialogCompact.1(this));
        return;
      }
      if (j > 9) {
        j = 9;
      }
      int m = (int)Math.ceil(j * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = ViewUtils.a(21.0F);
      int i1 = ViewUtils.a(25.0F);
      int i2 = ViewUtils.a(8.0F);
      int i3 = ViewUtils.a(25.0F);
      int i4 = ViewUtils.a(43.0F);
      int i5 = i4 + ViewUtils.a(20.0F);
      int i6 = ViewUtils.a(12.0F);
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramGdtAdBoxModel = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
      int i = 0;
      while (i < m)
      {
        int k = 0;
        while ((k < 3) && (3 * i + k < j))
        {
          localObject = (LinearLayout)paramGdtAdBoxModel.inflate(2131559170, null);
          super.a(3, n, i1, i4, i5, i6, i, k, (LinearLayout)localObject);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView((View)localObject);
          k += 1;
        }
        i += 1;
      }
      paramGdtAdBoxModel = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramGdtAdBoxModel.width = (n + (i4 + i6) * 3 + i2);
      paramGdtAdBoxModel.height = (i1 + (i5 + i6) * m + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramGdtAdBoxModel);
      return;
    }
    super.a(paramGdtAdBoxModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialogCompact
 * JD-Core Version:    0.7.0.1
 */