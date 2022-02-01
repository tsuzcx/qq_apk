package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;

public class FaceDetectTipViewStubHolder
  extends BaseViewStubHolder
{
  private View a;
  private TextView b;
  
  public FaceDetectTipViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = paramView.findViewById(2063991060);
    this.b = ((TextView)paramView.findViewById(2063991059));
  }
  
  public void d()
  {
    c();
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.b.setText(2064187663);
  }
  
  public void e()
  {
    if (ap_())
    {
      this.a.setVisibility(8);
      this.b.setVisibility(8);
    }
  }
  
  public void f()
  {
    if (!ap_()) {
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.FaceDetectTipViewStubHolder
 * JD-Core Version:    0.7.0.1
 */