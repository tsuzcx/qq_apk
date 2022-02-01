package com.app.hubert.guide.core;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnPageChangedListener;
import com.app.hubert.guide.model.GuidePage;
import java.util.ArrayList;
import java.util.List;

public class Builder
{
  Activity activity;
  boolean alwaysShow;
  View anchor;
  android.app.Fragment fragment;
  List<GuidePage> guidePages = new ArrayList();
  String label;
  OnGuideChangedListener onGuideChangedListener;
  OnPageChangedListener onPageChangedListener;
  int showCounts = 1;
  android.support.v4.app.Fragment v4Fragment;
  
  public Builder(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public Builder(android.app.Fragment paramFragment)
  {
    this.fragment = paramFragment;
    this.activity = paramFragment.getActivity();
  }
  
  public Builder(android.support.v4.app.Fragment paramFragment)
  {
    this.v4Fragment = paramFragment;
    this.activity = paramFragment.getActivity();
  }
  
  private void check()
  {
    if (TextUtils.isEmpty(this.label)) {
      throw new IllegalArgumentException("the param 'label' is missing, please call setLabel()");
    }
    if ((this.activity == null) && ((this.fragment != null) || (this.v4Fragment != null))) {
      throw new IllegalStateException("activity is null, please make sure that fragment is showing when call NewbieGuide");
    }
  }
  
  public Builder addGuidePage(GuidePage paramGuidePage)
  {
    this.guidePages.add(paramGuidePage);
    return this;
  }
  
  public Builder alwaysShow(boolean paramBoolean)
  {
    this.alwaysShow = paramBoolean;
    return this;
  }
  
  public Builder anchor(View paramView)
  {
    this.anchor = paramView;
    return this;
  }
  
  public Controller build()
  {
    check();
    return new Controller(this);
  }
  
  public Builder setLabel(String paramString)
  {
    this.label = paramString;
    return this;
  }
  
  public Builder setOnGuideChangedListener(OnGuideChangedListener paramOnGuideChangedListener)
  {
    this.onGuideChangedListener = paramOnGuideChangedListener;
    return this;
  }
  
  public Builder setOnPageChangedListener(OnPageChangedListener paramOnPageChangedListener)
  {
    this.onPageChangedListener = paramOnPageChangedListener;
    return this;
  }
  
  public Builder setShowCounts(int paramInt)
  {
    this.showCounts = paramInt;
    return this;
  }
  
  public Controller show()
  {
    check();
    Controller localController = new Controller(this);
    localController.show();
    return localController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.app.hubert.guide.core.Builder
 * JD-Core Version:    0.7.0.1
 */