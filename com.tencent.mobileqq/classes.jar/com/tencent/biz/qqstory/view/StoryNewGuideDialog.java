package com.tencent.biz.qqstory.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StoryNewGuideDialog
  extends ReportDialog
{
  protected AnimationPoint a;
  protected TextView b;
  
  public StoryNewGuideDialog(Context paramContext)
  {
    super(paramContext, 2131951625);
    View localView = LayoutInflater.from(paramContext).inflate(2131628100, null);
    localView.setOnTouchListener(new StoryNewGuideDialog.1(this));
    super.setContentView(localView);
    this.a = ((AnimationPoint)super.findViewById(2131428367));
    this.b = ((TextView)super.findViewById(2131434517));
    this.a.setRadius(UIUtils.a(paramContext, 25.0F));
    this.a.setLoopTime(2000L);
    this.a.setDuration(4000L);
    this.a.setOnAnimationListener(new StoryNewGuideDialog.2(this, paramContext));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setIsVertical(paramBoolean);
  }
  
  public void dismiss()
  {
    this.a.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.a.a();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryNewGuideDialog
 * JD-Core Version:    0.7.0.1
 */