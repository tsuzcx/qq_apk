package com.tencent.aelight.camera.ae.flashshow;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment;

class AEFlashShowMultiUnit$5
  extends PagerAdapter
{
  AEFlashShowMultiUnit$5(AEFlashShowMultiUnit paramAEFlashShowMultiUnit) {}
  
  public int getCount()
  {
    return 2;
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    FrameLayout localFrameLayout = new FrameLayout(AEFlashShowMultiUnit.c(this.a));
    if (paramInt == 0)
    {
      AEQLog.b("AEFlashShowMultiUnit", "instantiate capture page");
      AEFlashShowMultiUnit.a(this.a, localFrameLayout);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.setBackgroundColor(Color.parseColor("#111111"));
      localFrameLayout.setPadding(0, 0, 0, AEFlashShowMultiUnit.d(this.a));
      localFrameLayout.addView(AEFlashShowMultiUnit.e(this.a).a(localFrameLayout), new ViewGroup.LayoutParams(-1, -1));
      if (AEFlashShowMultiUnit.f(this.a) == 0) {
        AEFlashShowMultiUnit.e(this.a).a();
      }
    }
    else if (paramInt == 1)
    {
      AEQLog.b("AEFlashShowMultiUnit", "instantiate album page");
      AEFlashShowMultiUnit.b(this.a, localFrameLayout);
      localFrameLayout.setPadding(0, 0, 0, AEFlashShowMultiUnit.d(this.a));
      localFrameLayout.setBackgroundColor(-1);
      AEFlashShowMultiUnit.a(this.a, (WinkCirclePhotoListFragment)AEFlashShowViewFactory.a());
      paramInt = ViewCompat.generateViewId();
      localFrameLayout.setId(paramInt);
      AEFlashShowMultiUnit.c(this.a).getSupportFragmentManager().beginTransaction().add(paramInt, AEFlashShowMultiUnit.g(this.a)).commit();
    }
    paramViewGroup.addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowMultiUnit.5
 * JD-Core Version:    0.7.0.1
 */