package com.tencent.aelight.camera.education.api.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicCropPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;

public class AnswerSearchPicButtonPart
  extends EditPicCropPart
{
  protected RelativeLayout x;
  protected TextView y;
  
  public AnswerSearchPicButtonPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void b(Context paramContext)
  {
    paramContext = (LinearLayout)LayoutInflater.from(paramContext).inflate(2064056513, null);
    paramContext.findViewById(2063991334).setOnClickListener(this);
    paramContext.findViewById(2063991336).setOnClickListener(this);
    paramContext.findViewById(2063991335).setOnClickListener(this);
    this.x.addView(paramContext, new LinearLayout.LayoutParams(-1, -2));
  }
  
  private void k()
  {
    AnswerSearchEditPictureActivity localAnswerSearchEditPictureActivity = ((AnswerSearchEditPictureManager)this.t).e();
    if (localAnswerSearchEditPictureActivity != null)
    {
      this.b.e();
      localAnswerSearchEditPictureActivity.a(this.b.g());
    }
  }
  
  private void l()
  {
    this.f.setVisibility(8);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.y.setVisibility(8);
  }
  
  public void a(Context paramContext)
  {
    l();
    b(paramContext);
  }
  
  protected void c()
  {
    if (!this.l)
    {
      this.l = true;
      this.a = ((ViewGroup)d(2063990982));
      if (this.t.Z != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        localLayoutParams.bottomMargin = ViewUtils.dip2px(56.5F);
        this.a.setLayoutParams(localLayoutParams);
      }
      this.b = ((CropNewView)d(2063990998));
      this.c = d(2063990994);
      this.c.setOnClickListener(this);
      this.d = d(2063990996);
      this.d.setOnClickListener(this);
      this.e = ((TextView)d(2063990980));
      this.e.setOnClickListener(this);
      this.f = d(2063990957);
      this.f.setOnClickListener(this);
      this.g = ((TextView)d(2063990997));
      this.j = ((TextView)d(2063990995));
      this.j.setOnClickListener(this);
      this.k = ((TextView)d(2063991462));
      this.b.setCropListener(this);
      this.x = ((RelativeLayout)d(2063991051));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
      localLayoutParams.width = -1;
      this.x.setLayoutParams(localLayoutParams);
      this.y = ((TextView)this.d);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2063991336: 
      k();
      return;
    case 2063991335: 
      ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#photo_edit_page#rotate_btn", null);
      this.b.d();
      return;
    }
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#photo_edit_page#remake_btn", null);
    paramView = ((AnswerSearchEditPictureManager)this.t).e();
    if (paramView != null) {
      paramView.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchPicButtonPart
 * JD-Core Version:    0.7.0.1
 */