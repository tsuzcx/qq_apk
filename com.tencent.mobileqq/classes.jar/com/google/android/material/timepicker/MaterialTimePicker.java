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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker
  extends DialogFragment
{
  @DrawableRes
  private int jdField_a_of_type_Int;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private MaterialButton jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton;
  private TimeModel jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel;
  @Nullable
  private TimePickerClockPresenter jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerClockPresenter;
  @Nullable
  private TimePickerPresenter jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerPresenter;
  @Nullable
  private TimePickerTextInputPresenter jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputPresenter;
  private TimePickerView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView;
  private String jdField_a_of_type_JavaLangString;
  private final Set<View.OnClickListener> jdField_a_of_type_JavaUtilSet = new LinkedHashSet();
  @DrawableRes
  private int jdField_b_of_type_Int;
  private final Set<View.OnClickListener> jdField_b_of_type_JavaUtilSet = new LinkedHashSet();
  private int jdField_c_of_type_Int = 0;
  private final Set<DialogInterface.OnCancelListener> jdField_c_of_type_JavaUtilSet = new LinkedHashSet();
  private int jdField_d_of_type_Int = 0;
  private final Set<DialogInterface.OnDismissListener> jdField_d_of_type_JavaUtilSet = new LinkedHashSet();
  
  private Pair<Integer, Integer> a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return new Pair(Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(R.string.o));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no icon for mode: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(R.string.r));
  }
  
  private TimePickerPresenter a(int paramInt)
  {
    if (paramInt == 0)
    {
      TimePickerClockPresenter localTimePickerClockPresenter2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerClockPresenter;
      TimePickerClockPresenter localTimePickerClockPresenter1 = localTimePickerClockPresenter2;
      if (localTimePickerClockPresenter2 == null) {
        localTimePickerClockPresenter1 = new TimePickerClockPresenter(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView, this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerClockPresenter = localTimePickerClockPresenter1;
      return this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerClockPresenter;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputPresenter == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputPresenter = new TimePickerTextInputPresenter(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputPresenter.f();
    return this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputPresenter;
  }
  
  private void a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel = ((TimeModel)paramBundle.getParcelable("TIME_PICKER_TIME_MODEL"));
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel = new TimeModel();
    }
    this.jdField_d_of_type_Int = paramBundle.getInt("TIME_PICKER_INPUT_MODE", 0);
    this.jdField_c_of_type_Int = paramBundle.getInt("TIME_PICKER_TITLE_RES", 0);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("TIME_PICKER_TITLE_TEXT");
  }
  
  private void a(MaterialButton paramMaterialButton)
  {
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerPresenter;
    if (localObject != null) {
      ((TimePickerPresenter)localObject).d();
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerPresenter = a(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerPresenter.c();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerPresenter.b();
    localObject = a(this.jdField_d_of_type_Int);
    paramMaterialButton.setIconResource(((Integer)((Pair)localObject).first).intValue());
    paramMaterialButton.setContentDescription(getResources().getString(((Integer)((Pair)localObject).second).intValue()));
  }
  
  public final void onCancel(@NonNull DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilSet.iterator();
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
    paramBundle = MaterialAttributes.a(requireContext(), R.attr.E);
    Object localObject1 = requireContext();
    if (paramBundle == null) {
      i = 0;
    } else {
      i = paramBundle.data;
    }
    paramBundle = new Dialog((Context)localObject1, i);
    Object localObject2 = paramBundle.getContext();
    int i = MaterialAttributes.a((Context)localObject2, R.attr.n, MaterialTimePicker.class.getCanonicalName());
    localObject1 = new MaterialShapeDrawable((Context)localObject2, null, R.attr.D, R.style.I);
    TypedArray localTypedArray = ((Context)localObject2).obtainStyledAttributes(null, R.styleable.Z, R.attr.D, R.style.I);
    this.jdField_b_of_type_Int = localTypedArray.getResourceId(R.styleable.dq, 0);
    this.jdField_a_of_type_Int = localTypedArray.getResourceId(R.styleable.dr, 0);
    localTypedArray.recycle();
    ((MaterialShapeDrawable)localObject1).a((Context)localObject2);
    ((MaterialShapeDrawable)localObject1).g(ColorStateList.valueOf(i));
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView = ((TimePickerView)paramLayoutInflater.findViewById(R.id.A));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerView.a(new MaterialTimePicker.1(this));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramLayoutInflater.findViewById(R.id.w));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton = ((MaterialButton)paramLayoutInflater.findViewById(R.id.y));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.h);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramViewGroup.setText(this.jdField_a_of_type_JavaLangString);
    }
    int i = this.jdField_c_of_type_Int;
    if (i != 0) {
      paramViewGroup.setText(i);
    }
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton);
    ((Button)paramLayoutInflater.findViewById(R.id.z)).setOnClickListener(new MaterialTimePicker.2(this));
    ((Button)paramLayoutInflater.findViewById(R.id.x)).setOnClickListener(new MaterialTimePicker.3(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.setOnClickListener(new MaterialTimePicker.4(this));
    return paramLayoutInflater;
  }
  
  public final void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    Object localObject = this.jdField_d_of_type_JavaUtilSet.iterator();
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
    paramBundle.putParcelable("TIME_PICKER_TIME_MODEL", this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel);
    paramBundle.putInt("TIME_PICKER_INPUT_MODE", this.jdField_d_of_type_Int);
    paramBundle.putInt("TIME_PICKER_TITLE_RES", this.jdField_c_of_type_Int);
    paramBundle.putString("TIME_PICKER_TITLE_TEXT", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.MaterialTimePicker
 * JD-Core Version:    0.7.0.1
 */