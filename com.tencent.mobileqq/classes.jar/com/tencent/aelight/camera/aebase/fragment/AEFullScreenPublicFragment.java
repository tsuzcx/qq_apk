package com.tencent.aelight.camera.aebase.fragment;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;

public class AEFullScreenPublicFragment
  extends QPublicBaseFragment
{
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().clearFlags(2048);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().addFlags(256);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment
 * JD-Core Version:    0.7.0.1
 */