package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.BaseViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;

public class CTEntryController
  extends BaseViewController
{
  protected QQAppInterface b;
  protected FrameLayout c;
  protected AlphaClickableRelativeLayout d;
  protected TextView e;
  protected ImageView f;
  protected XListView g;
  protected CTEntryController.OnCTEntryDataChangeListener h;
  private StudyModeChangeListener i = new CTEntryController.1(this);
  
  public CTEntryController(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.b = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((FrameLayout)paramView.findViewById(2131446070));
    this.d = ((AlphaClickableRelativeLayout)paramView.findViewById(2131444461));
    this.e = ((TextView)paramView.findViewById(2131444466));
    this.g = ((XListView)paramView.findViewById(2131438025));
    this.f = ((ImageView)paramView.findViewById(2131427828));
    this.g.setSelector(new ColorDrawable(0));
    this.g.setNeedCheckSpringback(false);
    this.g.setCacheColorHint(0);
    this.g.setDivider(null);
    this.g.setOverScrollMode(2);
    this.g.mForContacts = true;
  }
  
  public void a(CTEntryController.OnCTEntryDataChangeListener paramOnCTEntryDataChangeListener)
  {
    this.h = paramOnCTEntryDataChangeListener;
  }
  
  protected boolean bV_()
  {
    boolean bool = StudyModeManager.h();
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool ^ true;
  }
  
  public void c()
  {
    super.c();
    StudyModeManager.a(this.i);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e()
  {
    super.e();
    StudyModeManager.b(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryController
 * JD-Core Version:    0.7.0.1
 */