package com.tencent.aelight.camera.aebase.fragment;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;

public class AEFullScreenPublicFragment
  extends QPublicBaseFragment
{
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity = paramActivity.getWindow();
    paramActivity.clearFlags(2048);
    paramActivity.addFlags(1024);
    paramActivity.addFlags(256);
    if (Build.VERSION.SDK_INT >= 28)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      paramActivity.setAttributes(localLayoutParams);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 16))
    {
      View localView = getActivity().getWindow().getDecorView();
      int j = localView.getSystemUiVisibility() | 0x100 | 0x200 | 0x400 | 0x2 | 0x4;
      int i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j | 0x1000;
      }
      localView.setSystemUiVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment
 * JD-Core Version:    0.7.0.1
 */