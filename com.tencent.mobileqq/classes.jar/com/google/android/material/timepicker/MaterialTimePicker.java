package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker
  extends DialogFragment
{
  private final Set<View.OnClickListener> a = new LinkedHashSet();
  private final Set<View.OnClickListener> b = new LinkedHashSet();
  private final Set<DialogInterface.OnCancelListener> c = new LinkedHashSet();
  private final Set<DialogInterface.OnDismissListener> d = new LinkedHashSet();
  private TimePickerView e;
  private LinearLayout f;
  private ViewStub g;
  @Nullable
  private TimePickerClockPresenter h;
  @Nullable
  private TimePickerTextInputPresenter i;
  @Nullable
  private TimePickerPresenter j;
  @DrawableRes
  private int k;
  @DrawableRes
  private int l;
  private int m = 0;
  private String n;
  private MaterialButton o;
  private int p = 0;
  private TimeModel q;
  
  private TimePickerPresenter a(int paramInt)
  {
    if (paramInt == 0)
    {
      TimePickerClockPresenter localTimePickerClockPresenter2 = this.h;
      TimePickerClockPresenter localTimePickerClockPresenter1 = localTimePickerClockPresenter2;
      if (localTimePickerClockPresenter2 == null) {
        localTimePickerClockPresenter1 = new TimePickerClockPresenter(this.e, this.q);
      }
      this.h = localTimePickerClockPresenter1;
      return this.h;
    }
    if (this.i == null)
    {
      this.f = ((LinearLayout)this.g.inflate());
      this.i = new TimePickerTextInputPresenter(this.f, this.q);
    }
    this.i.f();
    return this.i;
  }
  
  private void a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.q = ((TimeModel)paramBundle.getParcelable("TIME_PICKER_TIME_MODEL"));
    if (this.q == null) {
      this.q = new TimeModel();
    }
    this.p = paramBundle.getInt("TIME_PICKER_INPUT_MODE", 0);
    this.m = paramBundle.getInt("TIME_PICKER_TITLE_RES", 0);
    this.n = paramBundle.getString("TIME_PICKER_TITLE_TEXT");
  }
  
  private void a(MaterialButton paramMaterialButton)
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((TimePickerPresenter)localObject).d();
    }
    this.j = a(this.p);
    this.j.c();
    this.j.b();
    localObject = b(this.p);
    paramMaterialButton.setIconResource(((Integer)((Pair)localObject).first).intValue());
    paramMaterialButton.setContentDescription(getResources().getString(((Integer)((Pair)localObject).second).intValue()));
  }
  
  private Pair<Integer, Integer> b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return new Pair(Integer.valueOf(this.l), Integer.valueOf(R.string.o));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no icon for mode: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return new Pair(Integer.valueOf(this.k), Integer.valueOf(R.string.r));
  }
  
  public final void onCancel(@NonNull DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((DialogInterface.OnCancelListener)localIterator.next()).onCancel(paramDialogInterface);
    }
    super.onCancel(paramDialogInterface);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    a(localBundle);
  }
  
  @NonNull
  public final Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = MaterialAttributes.a(requireContext(), R.attr.L);
    Object localObject1 = requireContext();
    if (paramBundle == null) {
      i1 = 0;
    } else {
      i1 = paramBundle.data;
    }
    paramBundle = new ReportDialog((Context)localObject1, i1);
    Object localObject2 = paramBundle.getContext();
    int i1 = MaterialAttributes.a((Context)localObject2, R.attr.t, MaterialTimePicker.class.getCanonicalName());
    localObject1 = new MaterialShapeDrawable((Context)localObject2, null, R.attr.K, R.style.K);
    TypedArray localTypedArray = ((Context)localObject2).obtainStyledAttributes(null, R.styleable.eW, R.attr.K, R.style.K);
    this.l = localTypedArray.getResourceId(R.styleable.eX, 0);
    this.k = localTypedArray.getResourceId(R.styleable.eY, 0);
    localTypedArray.recycle();
    ((MaterialShapeDrawable)localObject1).a((Context)localObject2);
    ((MaterialShapeDrawable)localObject1).g(ColorStateList.valueOf(i1));
    localObject2 = paramBundle.getWindow();
    ((Window)localObject2).setBackgroundDrawable((Drawable)localObject1);
    ((Window)localObject2).requestFeature(1);
    ((Window)localObject2).setLayout(-2, -2);
    return paramBundle;
  }
  
  @NonNull
  public final View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(R.layout.s, paramViewGroup);
    this.e = ((TimePickerView)paramLayoutInflater.findViewById(R.id.A));
    this.e.a(new MaterialTimePicker.1(this));
    this.g = ((ViewStub)paramLayoutInflater.findViewById(R.id.w));
    this.o = ((MaterialButton)paramLayoutInflater.findViewById(R.id.y));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.h);
    if (!TextUtils.isEmpty(this.n)) {
      paramViewGroup.setText(this.n);
    }
    int i1 = this.m;
    if (i1 != 0) {
      paramViewGroup.setText(i1);
    }
    a(this.o);
    ((Button)paramLayoutInflater.findViewById(R.id.z)).setOnClickListener(new MaterialTimePicker.2(this));
    ((Button)paramLayoutInflater.findViewById(R.id.x)).setOnClickListener(new MaterialTimePicker.3(this));
    this.o.setOnClickListener(new MaterialTimePicker.4(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public final void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((DialogInterface.OnDismissListener)((Iterator)localObject).next()).onDismiss(paramDialogInterface);
    }
    localObject = (ViewGroup)getView();
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
    super.onDismiss(paramDialogInterface);
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("TIME_PICKER_TIME_MODEL", this.q);
    paramBundle.putInt("TIME_PICKER_INPUT_MODE", this.p);
    paramBundle.putInt("TIME_PICKER_TITLE_RES", this.m);
    paramBundle.putString("TIME_PICKER_TITLE_TEXT", this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.MaterialTimePicker
 * JD-Core Version:    0.7.0.1
 */