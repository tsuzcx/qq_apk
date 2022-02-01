package com.tencent.aelight.camera.ae.flashshow.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/demo/DemoFSTextFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DemoFSTextFragment
  extends Fragment
{
  private HashMap a;
  
  public void a()
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.getContext();
      if (paramViewGroup != null)
      {
        paramLayoutInflater = new FrameLayout(paramViewGroup);
        paramLayoutInflater.setBackgroundColor(Color.parseColor("#FAFAFB"));
        paramBundle = new TextView(paramViewGroup);
        paramBundle.setText((CharSequence)"Demo 文字编辑");
        paramBundle.setTextSize(1, 50.0F);
        paramBundle = (View)paramBundle;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        paramLayoutInflater.addView(paramBundle, (ViewGroup.LayoutParams)localLayoutParams);
        paramViewGroup = new TextView(paramViewGroup);
        paramViewGroup.setText((CharSequence)"这里是底部");
        paramViewGroup = (View)paramViewGroup;
        paramBundle = new FrameLayout.LayoutParams(-2, -2);
        paramBundle.gravity = 85;
        paramLayoutInflater.addView(paramViewGroup, (ViewGroup.LayoutParams)paramBundle);
        return (View)paramLayoutInflater;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.demo.DemoFSTextFragment
 * JD-Core Version:    0.7.0.1
 */