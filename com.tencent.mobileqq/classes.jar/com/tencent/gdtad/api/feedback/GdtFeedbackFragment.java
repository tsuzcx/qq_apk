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
  private static final int jdField_a_of_type_Int = Color.parseColor("#FFFFFF");
  private static final String jdField_a_of_type_JavaLangString = "GdtFeedbackFragment";
  private static final int jdField_b_of_type_Int = Color.parseColor("#2B2B2B");
  private static final int c = Color.parseColor("#282828");
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected GdtFeedbackModel a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<GdtFeedbackListener> jdField_b_of_type_JavaLangRefWeakReference;
  
  private int a()
  {
    if (b()) {
      return 2131559184;
    }
    return 2131559185;
  }
  
  private View a(Context paramContext, int paramInt)
  {
    GdtFeedbackFragment.GdtFeedbackItemView localGdtFeedbackItemView = new GdtFeedbackFragment.GdtFeedbackItemView(paramContext, b());
    localGdtFeedbackItemView.jdField_a_of_type_Int = paramInt;
    localGdtFeedbackItemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ImageView)localGdtFeedbackItemView.findViewById(2131367557)).setImageDrawable(this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.a(paramInt));
    Object localObject = (TextView)localGdtFeedbackItemView.findViewById(2131367559);
    ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.a(paramInt));
    if (localGdtFeedbackItemView.getBackground() == null) {
      paramContext = new GradientDrawable();
    } else {
      paramContext = localGdtFeedbackItemView.getBackground();
    }
    if (a())
    {
      ((TextView)localObject).setTextColor(jdField_a_of_type_Int);
      localObject = getResources().getColorStateList(2131165670);
    }
    else
    {
      ((TextView)localObject).setTextColor(jdField_b_of_type_Int);
      localObject = getResources().getColorStateList(2131165671);
    }
    DrawableCompat.setTintList(paramContext.mutate(), (ColorStateList)localObject);
    if (Build.VERSION.SDK_INT >= 16) {
      localGdtFeedbackItemView.setBackground(paramContext);
    } else {
      localGdtFeedbackItemView.setBackgroundDrawable(paramContext);
    }
    paramContext = (ImageView)localGdtFeedbackItemView.findViewById(2131367558);
    if (this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.b(paramInt) != null)
    {
      paramContext.setVisibility(0);
      paramContext.setImageDrawable(this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.b(paramInt));
    }
    return localGdtFeedbackItemView;
  }
  
  private AdError a(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    if (paramStartGdtFeedbackParams == null) {
      return new AdError(4);
    }
    this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel = new GdtFeedbackModel();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramStartGdtFeedbackParams.jdField_a_of_type_JavaLangRefWeakReference;
    this.jdField_b_of_type_JavaLangRefWeakReference = paramStartGdtFeedbackParams.jdField_b_of_type_JavaLangRefWeakReference;
    this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.b(paramStartGdtFeedbackParams.jdField_a_of_type_Boolean);
    GdtFeedbackModel localGdtFeedbackModel = this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel;
    boolean bool;
    if (paramStartGdtFeedbackParams.jdField_a_of_type_Int != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localGdtFeedbackModel.a(bool);
    paramStartGdtFeedbackParams = a(paramStartGdtFeedbackParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new GdtFeedbackFragment.3(this);
    return paramStartGdtFeedbackParams;
  }
  
  private void a(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new GdtFeedbackFragment.4(this, paramInt, paramString));
  }
  
  private void a(Window paramWindow)
  {
    paramWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    paramWindow.setWindowAnimations(b());
    if (b())
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
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GdtFeedbackListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramGdtFeedbackResultParams);
    }
  }
  
  public static void a(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    new GdtFeedbackFragment().b(paramStartGdtFeedbackParams);
  }
  
  private boolean a()
  {
    GdtFeedbackModel localGdtFeedbackModel = this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel;
    return (localGdtFeedbackModel != null) && (localGdtFeedbackModel.b());
  }
  
  private int b()
  {
    if (b()) {
      return 2131755330;
    }
    return 2131755331;
  }
  
  private boolean b()
  {
    GdtFeedbackModel localGdtFeedbackModel = this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel;
    return (localGdtFeedbackModel != null) && (localGdtFeedbackModel.a());
  }
  
  public AdError a(GdtAd paramGdtAd)
  {
    this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.a(paramGdtAd);
    return this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.a();
  }
  
  public void a()
  {
    Object localObject1 = getView();
    if (localObject1 != null)
    {
      if (a())
      {
        localObject2 = ((View)localObject1).getBackground();
        ((Drawable)localObject2).setColorFilter(c, PorterDuff.Mode.MULTIPLY);
        if (Build.VERSION.SDK_INT >= 16) {
          ((View)localObject1).setBackground((Drawable)localObject2);
        } else {
          ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
        }
      }
      Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131367556);
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentGdtadApiFeedbackGdtFeedbackModel.a())
      {
        if (i != 0)
        {
          localObject3 = new View(((View)localObject1).getContext());
          ((View)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
          ((View)localObject3).setBackgroundColor(Color.parseColor("#66979797"));
          ((LinearLayout)localObject2).addView((View)localObject3);
        }
        ((LinearLayout)localObject2).addView(a(((View)localObject1).getContext(), i));
        i += 1;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(2131367555);
      ((TextView)localObject2).setOnClickListener(new GdtFeedbackFragment.2(this));
      if (a())
      {
        ((TextView)localObject2).setTextColor(jdField_a_of_type_Int);
        localObject1 = getResources().getColorStateList(2131165668);
      }
      else
      {
        ((TextView)localObject2).setTextColor(jdField_b_of_type_Int);
        localObject1 = getResources().getColorStateList(2131165669);
      }
      Object localObject3 = ContextCompat.getDrawable((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130840259);
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
    paramStartGdtFeedbackParams = a(paramStartGdtFeedbackParams);
    if (!paramStartGdtFeedbackParams.isSuccess())
    {
      GdtFeedbackResultParams localGdtFeedbackResultParams = new GdtFeedbackResultParams();
      localGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError = paramStartGdtFeedbackParams;
      localGdtFeedbackResultParams.jdField_a_of_type_Int = 0;
      a(localGdtFeedbackResultParams);
      return;
    }
    show(((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getFragmentManager(), null);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new ReportDialog(getActivity(), 2131755369);
    if (paramBundle.getWindow() != null) {
      a(paramBundle.getWindow());
    }
    return paramBundle;
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtFeedbackFragment.1(this), 200L);
  }
  
  public void onStart()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment
 * JD-Core Version:    0.7.0.1
 */