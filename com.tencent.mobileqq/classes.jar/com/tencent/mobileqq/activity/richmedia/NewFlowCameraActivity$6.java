package com.tencent.mobileqq.activity.richmedia;

import aepi;
import ajpx;
import ajry;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import azln;
import bcyz;
import bhtb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.HashMap;

class NewFlowCameraActivity$6
  implements Runnable
{
  NewFlowCameraActivity$6(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = null;
    if (this.this$0.D) {
      return;
    }
    if (!this.this$0.f)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.this$0.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      azln.a(this.this$0.jdField_b_of_type_AndroidWidgetImageView, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
      if (bhtb.e()) {
        this.this$0.I();
      }
      NewFlowCameraActivity.a(this.this$0).put("cameraType", String.valueOf(ajpx.a));
      NewFlowCameraActivity.a(this.this$0).put("isTemplateMode", String.valueOf(this.this$0.f));
      if (this.this$0.jdField_a_of_type_Ajry != null) {
        str = this.this$0.jdField_a_of_type_Ajry.a();
      }
      NewFlowCameraActivity.a(this.this$0).put("templateId", str);
      if ((this.this$0.o != 90) && (this.this$0.o != 270)) {
        break label569;
      }
    }
    label562:
    label569:
    for (int i = 1;; i = 0)
    {
      NewFlowCameraActivity.a(this.this$0).put("cameraOrientation", String.valueOf(i));
      NewFlowCameraActivity.a(this.this$0).put("isFaceDectected", String.valueOf(NewFlowCameraActivity.jdField_b_of_type_Boolean));
      NewFlowCameraActivity.a(this.this$0, System.currentTimeMillis());
      if ((NewFlowCameraActivity.a(this.this$0) > 0L) && (NewFlowCameraActivity.b(this.this$0) - NewFlowCameraActivity.a(this.this$0) > 0L)) {}
      for (long l = NewFlowCameraActivity.b(this.this$0) - NewFlowCameraActivity.a(this.this$0);; l = 0L)
      {
        NewFlowCameraActivity.b(this.this$0, 0L);
        NewFlowCameraActivity.a(this.this$0).put("previewDuration", String.valueOf(l));
        return;
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        Object localObject;
        if (this.this$0.jdField_a_of_type_Ajry != null)
        {
          localObject = this.this$0.jdField_a_of_type_Ajry.a();
          if ((localObject == null) || (TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl))) {
            break label499;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          i = aepi.a(50.0F, this.this$0.getResources());
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(this.this$0.getResources().getColor(2131165804));
          localGradientDrawable.setShape(1);
          localGradientDrawable.setSize(i, i);
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
          localURLDrawableOptions.mLoadingDrawable = localGradientDrawable;
          localObject = URLDrawable.getDrawable(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl, localURLDrawableOptions);
          ((URLDrawable)localObject).setTag(bcyz.a(i, i));
          ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
          this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        for (;;)
        {
          if (!bhtb.e()) {
            break label562;
          }
          this.this$0.I();
          break;
          label499:
          if ((localObject != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals("0")))
          {
            this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            this.this$0.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            azln.a(this.this$0.jdField_b_of_type_AndroidWidgetImageView, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.6
 * JD-Core Version:    0.7.0.1
 */