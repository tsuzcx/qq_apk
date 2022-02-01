package com.tencent.gdtad.api.adbox;

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
import com.tencent.gdtad.views.GdtUIUtils;
import java.util.List;

public class GdtAdBoxDialogCompact
  extends GdtAdBoxDialog
{
  private final boolean a;
  
  public GdtAdBoxDialogCompact(@NonNull Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GdtLog.a("GdtAdBoxDialog", "landscape");
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369829);
        Object localObject = localImageView.getLayoutParams();
        if ((localObject instanceof FrameLayout.LayoutParams))
        {
          localObject = (FrameLayout.LayoutParams)localObject;
          ((FrameLayout.LayoutParams)localObject).width = GdtUIUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          ((FrameLayout.LayoutParams)localObject).height = GdtUIUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localImageView = (ImageView)findViewById(2131381103);
        int i = GdtUIUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localImageView.setPadding(i, i, i, i);
      }
      return;
    }
    super.a();
    GdtLog.a("GdtAdBoxDialog", "portrait");
  }
  
  protected void a(GdtAdBoxModel paramGdtAdBoxModel)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      GdtLog.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramGdtAdBoxModel + "]");
      i = this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox.a().getAds().size();
      if (i == 0)
      {
        GdtLog.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
        this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialogCompact.1(this));
        return;
      }
      if (i <= 9) {
        break label399;
      }
      i = 9;
    }
    label399:
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = GdtUIUtils.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = GdtUIUtils.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = GdtUIUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = GdtUIUtils.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = GdtUIUtils.a(55.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + GdtUIUtils.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = GdtUIUtils.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramGdtAdBoxModel = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramGdtAdBoxModel.inflate(2131559297, null);
          super.a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramGdtAdBoxModel = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramGdtAdBoxModel.width = (3 * (i4 + i6) + n + i2);
      paramGdtAdBoxModel.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramGdtAdBoxModel);
      return;
      super.a(paramGdtAdBoxModel);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxDialogCompact
 * JD-Core Version:    0.7.0.1
 */