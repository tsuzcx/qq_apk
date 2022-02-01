package com.tencent.biz.qqcircle.fragments.person;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.EventListener;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QCircleTroopAddPopupWindow
  extends QCircleBaseInputPopupWindow
{
  protected ProgressBar n = (ProgressBar)findViewById(2131439919);
  
  public QCircleTroopAddPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void o()
  {
    this.l = new SoftKeyboardStateHelper(this.a);
    this.l.a(new QCircleTroopAddPopupWindow.1(this));
    if (this.c != null) {
      this.c.addTextChangedListener(new QCircleTroopAddPopupWindow.2(this));
    }
  }
  
  public int a()
  {
    return 2131626979;
  }
  
  protected void a(View paramView) {}
  
  public void d(String paramString)
  {
    if (this.d != null) {
      this.d.setText(paramString);
    }
  }
  
  public void k()
  {
    ProgressBar localProgressBar = this.n;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
  }
  
  public void l()
  {
    ProgressBar localProgressBar = this.n;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick:");
    localStringBuilder.append(paramView.getId());
    QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    int i = paramView.getId();
    if (i == 2131447156) {
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
    } else if ((i == 2131429958) && (this.j != null)) {
      this.j.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    super.show();
    o();
    if (this.c != null) {
      this.c.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow
 * JD-Core Version:    0.7.0.1
 */