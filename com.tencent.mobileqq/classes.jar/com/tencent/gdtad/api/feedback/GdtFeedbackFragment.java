package com.tencent.gdtad.api.feedback;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.ad.tangram.AdError;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.lang.ref.WeakReference;

public final class GdtFeedbackFragment
  extends ReportDialogFragment
{
  private static final String b = "GdtFeedbackFragment";
  private static final int c = Color.parseColor("#FFFFFF");
  private static final int d = Color.parseColor("#2B2B2B");
  private static final int e = Color.parseColor("#282828");
  protected GdtFeedbackModel a;
  private Handler f = new Handler(Looper.getMainLooper());
  private WeakReference<Activity> g;
  private WeakReference<GdtFeedbackListener> h;
  private View.OnClickListener i;
  private boolean j;
  
  private View a(Context paramContext, int paramInt)
  {
    GdtFeedbackFragment.GdtFeedbackItemView localGdtFeedbackItemView = new GdtFeedbackFragment.GdtFeedbackItemView(paramContext, f());
    localGdtFeedbackItemView.a = paramInt;
    localGdtFeedbackItemView.setOnClickListener(this.i);
    ((ImageView)localGdtFeedbackItemView.findViewById(2131434099)).setImageDrawable(this.a.c(paramInt));
    Object localObject = (TextView)localGdtFeedbackItemView.findViewById(2131434101);
    ((TextView)localObject).setText(this.a.d(paramInt));
    if (localGdtFeedbackItemView.getBackground() == null) {
      paramContext = new GradientDrawable();
    } else {
      paramContext = localGdtFeedbackItemView.getBackground();
    }
    if (e())
    {
      ((TextView)localObject).setTextColor(c);
      localObject = getResources().getColorStateList(2131166133);
    }
    else
    {
      ((TextView)localObject).setTextColor(d);
      localObject = getResources().getColorStateList(2131166134);
    }
    DrawableCompat.setTintList(paramContext.mutate(), (ColorStateList)localObject);
    if (Build.VERSION.SDK_INT >= 16) {
      localGdtFeedbackItemView.setBackground(paramContext);
    } else {
      localGdtFeedbackItemView.setBackgroundDrawable(paramContext);
    }
    paramContext = (ImageView)localGdtFeedbackItemView.findViewById(2131434100);
    if (this.a.e(paramInt) != null)
    {
      paramContext.setVisibility(0);
      paramContext.setImageDrawable(this.a.g(paramInt));
    }
    return localGdtFeedbackItemView;
  }
  
  private void a(int paramInt, @Nullable String paramString)
  {
    this.f.post(new GdtFeedbackFragment.4(this, paramInt, paramString));
  }
  
  private void a(Window paramWindow)
  {
    paramWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    paramWindow.setWindowAnimations(d());
    if (f())
    {
      localLayoutParams.gravity = 17;
      localLayoutParams.width = -2;
    }
    else
    {
      localLayoutParams.gravity = 80;
      localLayoutParams.width = -1;
    }
    localLayoutParams.height = -2;
    paramWindow.setAttributes(localLayoutParams);
  }
  
  private void a(GdtFeedbackResultParams paramGdtFeedbackResultParams)
  {
    WeakReference localWeakReference = this.h;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GdtFeedbackListener)this.h.get()).a(paramGdtFeedbackResultParams);
    }
  }
  
  public static void a(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    new GdtFeedbackFragment().b(paramStartGdtFeedbackParams);
  }
  
  private int c()
  {
    if (f()) {
      return 2131624939;
    }
    return 2131624940;
  }
  
  private AdError c(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    if (paramStartGdtFeedbackParams == null) {
      return new AdError(4);
    }
    this.a = new GdtFeedbackModel();
    this.g = paramStartGdtFeedbackParams.a;
    this.h = paramStartGdtFeedbackParams.b;
    this.a.b(paramStartGdtFeedbackParams.e);
    GdtFeedbackModel localGdtFeedbackModel = this.a;
    boolean bool;
    if (paramStartGdtFeedbackParams.d != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localGdtFeedbackModel.a(bool);
    paramStartGdtFeedbackParams = a(paramStartGdtFeedbackParams.c);
    this.i = new GdtFeedbackFragment.3(this);
    return paramStartGdtFeedbackParams;
  }
  
  private int d()
  {
    if (f()) {
      return 2131952024;
    }
    return 2131952025;
  }
  
  private boolean e()
  {
    GdtFeedbackModel localGdtFeedbackModel = this.a;
    return (localGdtFeedbackModel != null) && (localGdtFeedbackModel.d());
  }
  
  private boolean f()
  {
    GdtFeedbackModel localGdtFeedbackModel = this.a;
    return (localGdtFeedbackModel != null) && (localGdtFeedbackModel.c());
  }
  
  public AdError a(GdtAd paramGdtAd)
  {
    this.a.a(paramGdtAd);
    return this.a.a();
  }
  
  public void a()
  {
    Object localObject1 = getView();
    if (localObject1 != null)
    {
      if (e())
      {
        localObject2 = ((View)localObject1).getBackground();
        ((Drawable)localObject2).setColorFilter(e, PorterDuff.Mode.MULTIPLY);
        if (Build.VERSION.SDK_INT >= 16) {
          ((View)localObject1).setBackground((Drawable)localObject2);
        } else {
          ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
        }
      }
      Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131434098);
      int k = 0;
      while (k < this.a.b())
      {
        if (k != 0)
        {
          localObject3 = new View(((View)localObject1).getContext());
          ((View)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
          ((View)localObject3).setBackgroundColor(Color.parseColor("#66979797"));
          ((LinearLayout)localObject2).addView((View)localObject3);
        }
        ((LinearLayout)localObject2).addView(a(((View)localObject1).getContext(), k));
        k += 1;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(2131434097);
      ((TextView)localObject2).setOnClickListener(new GdtFeedbackFragment.2(this));
      if (e())
      {
        ((TextView)localObject2).setTextColor(c);
        localObject1 = getResources().getColorStateList(2131166131);
      }
      else
      {
        ((TextView)localObject2).setTextColor(d);
        localObject1 = getResources().getColorStateList(2131166132);
      }
      Object localObject3 = ContextCompat.getDrawable((Context)this.g.get(), 2130840577);
      if (localObject3 != null)
      {
        DrawableCompat.setTintList(((Drawable)localObject3).mutate(), (ColorStateList)localObject1);
        if (Build.VERSION.SDK_INT >= 16)
        {
          ((TextView)localObject2).setBackground((Drawable)localObject3);
          return;
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject3);
      }
    }
  }
  
  public void b(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    paramStartGdtFeedbackParams = c(paramStartGdtFeedbackParams);
    if (!paramStartGdtFeedbackParams.isSuccess())
    {
      GdtFeedbackResultParams localGdtFeedbackResultParams = new GdtFeedbackResultParams();
      localGdtFeedbackResultParams.a = paramStartGdtFeedbackParams;
      localGdtFeedbackResultParams.b = 0;
      a(localGdtFeedbackResultParams);
      return;
    }
    show(((Activity)this.g.get()).getFragmentManager(), null);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new ReportDialog(getActivity(), 2131952074);
    if (paramBundle.getWindow() != null) {
      a(paramBundle.getWindow());
    }
    return paramBundle;
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(c(), paramViewGroup);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.f;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.j = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.f.postDelayed(new GdtFeedbackFragment.1(this), 200L);
  }
  
  public void onStart()
  {
    if (!this.j)
    {
      a();
      this.j = true;
    }
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((getDialog() != null) && (getDialog().getWindow() != null)) {
      getDialog().getWindow().setWindowAnimations(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment
 * JD-Core Version:    0.7.0.1
 */