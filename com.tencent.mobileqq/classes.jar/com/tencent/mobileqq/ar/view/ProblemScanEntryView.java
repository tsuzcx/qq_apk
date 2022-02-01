package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.current.AnimationQIMCircleProgress;
import mqq.os.MqqHandler;

public class ProblemScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener
{
  private RelativeLayout a;
  private View b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private TextView f;
  private AnimationQIMCircleProgress g;
  private volatile boolean h;
  
  public ProblemScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    TextView localTextView = new TextView(this.E);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 13.0F);
    localTextView.setText(this.E.getString(2131893820));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramRelativeLayout.addView(localTextView, localLayoutParams);
  }
  
  private void b(RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    View localView = new View(this.E);
    localView.setBackgroundResource(2130848220);
    int i = DisplayUtil.a(this.E, 4.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(2, 2131439536);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = DisplayUtil.a(this.E, 12.0F);
    paramRelativeLayout.addView(localView, localLayoutParams);
  }
  
  private void b(String paramString)
  {
    if (this.h)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterPictureEditPage, is in recognize! filePath: ");
      localStringBuilder.append(paramString);
      QLog.e("AREngine_OCRScanEntryView", 1, localStringBuilder.toString());
      return;
    }
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#scan_page#photo_btn", null);
    this.h = true;
    if (FileUtil.d(paramString))
    {
      ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).startAnswerSearchPicEditActivity((Activity)this.E, paramString, 0, false);
      this.h = false;
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ProblemScanEntryView.1(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.a == null)
    {
      this.a = ((RelativeLayout)LayoutInflater.from(this.E).inflate(2131627303, null, false));
      paramBundle = new FrameLayout.LayoutParams(-1, -1);
      addView(this.a, paramBundle);
      paramBundle = this.a;
      this.F = paramBundle;
      this.b = paramBundle.findViewById(2131439539);
      this.d = ((TextView)this.a.findViewById(2131439535));
      UniformUtils.a(this.E, this.b);
      this.g = ((AnimationQIMCircleProgress)this.a.findViewById(2131439536));
      this.c = ((TextView)this.a.findViewById(2131439512));
      this.e = ((ImageView)this.a.findViewById(2131439511));
      this.f = ((TextView)this.a.findViewById(2131439515));
      this.g.setBackgroundResource(2130845881);
      this.g.setCenterView();
      this.g.changeMode(0);
      this.c.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.g.setOnClickListener(this);
      this.d.setText(this.E.getString(2131893821));
      paramBundle = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      paramBundle.bottomMargin = DisplayUtil.a(this.E, 18.0F);
      this.d.setLayoutParams(paramBundle);
      a(this.a);
      b(this.a);
    }
  }
  
  public void ca_()
  {
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#scan_page#album_btn", null);
    p();
  }
  
  public void f()
  {
    super.f();
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#scan_page#search_tab", null);
  }
  
  public void i_(String paramString)
  {
    if (!FileUtil.d(paramString))
    {
      QLog.d("AREngine_OCRScanEntryView", 1, String.format("doDealGalleryPicFile path: %s is not exist", new Object[] { paramString }));
      return;
    }
    b(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439536: 
      b(null);
      break;
    case 2131439512: 
      o();
      break;
    case 2131439511: 
      ca_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ProblemScanEntryView
 * JD-Core Version:    0.7.0.1
 */