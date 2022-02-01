package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S>
  extends DialogFragment
{
  static final Object jdField_a_of_type_JavaLangObject = "CONFIRM_BUTTON_TAG";
  static final Object jdField_b_of_type_JavaLangObject = "CANCEL_BUTTON_TAG";
  static final Object jdField_c_of_type_JavaLangObject = "TOGGLE_BUTTON_TAG";
  @StyleRes
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  @Nullable
  private DateSelector<S> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  private MaterialCalendar<S> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar;
  private PickerFragment<S> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerPickerFragment;
  private CheckableImageButton jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  @Nullable
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private boolean jdField_a_of_type_Boolean;
  @StringRes
  private int jdField_b_of_type_Int;
  private final LinkedHashSet<View.OnClickListener> jdField_b_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private int jdField_c_of_type_Int;
  private final LinkedHashSet<DialogInterface.OnCancelListener> jdField_c_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnDismissListener> d = new LinkedHashSet();
  
  private int a(Context paramContext)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      return i;
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a(paramContext);
  }
  
  @NonNull
  private static Drawable a(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = AppCompatResources.getDrawable(paramContext, R.drawable.jdField_c_of_type_Int);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable);
    paramContext = AppCompatResources.getDrawable(paramContext, R.drawable.d);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private void a()
  {
    String str = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(R.string.w), new Object[] { str }));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setTag(jdField_c_of_type_JavaLangObject);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setImageDrawable(a(paramContext));
    paramContext = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
    boolean bool;
    if (this.jdField_c_of_type_Int != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.setChecked(bool);
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton, null);
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setOnClickListener(new MaterialDatePicker.4(this));
  }
  
  private void a(@NonNull CheckableImageButton paramCheckableImageButton)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.isChecked()) {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.N);
    } else {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.P);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.setContentDescription(paramCheckableImageButton);
  }
  
  static boolean a(@NonNull Context paramContext)
  {
    return a(paramContext, 16843277);
  }
  
  static boolean a(@NonNull Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.y, MaterialCalendar.class.getCanonicalName()), new int[] { paramInt });
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    return bool;
  }
  
  private static int b(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    return paramContext.getDimensionPixelSize(R.dimen.Z) + paramContext.getDimensionPixelOffset(R.dimen.aa) + paramContext.getDimensionPixelOffset(R.dimen.Y) + paramContext.getDimensionPixelSize(R.dimen.T) + (MonthAdapter.jdField_a_of_type_Int * paramContext.getDimensionPixelSize(R.dimen.R) + (MonthAdapter.jdField_a_of_type_Int - 1) * paramContext.getDimensionPixelOffset(R.dimen.X)) + paramContext.getDimensionPixelOffset(R.dimen.P);
  }
  
  private void b()
  {
    int i = a(requireContext());
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar = MaterialCalendar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector, i, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.isChecked()) {
      localObject = MaterialTextInputPicker.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector, i, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
    } else {
      localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerPickerFragment = ((PickerFragment)localObject);
    a();
    Object localObject = getChildFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).replace(R.id.K, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerPickerFragment);
    ((FragmentTransaction)localObject).commitNow();
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerPickerFragment.a(new MaterialDatePicker.3(this));
  }
  
  static boolean b(@NonNull Context paramContext)
  {
    return a(paramContext, R.attr.G);
  }
  
  private static int c(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelOffset(R.dimen.Q);
    int j = Month.a().jdField_c_of_type_Int;
    return i * 2 + paramContext.getDimensionPixelSize(R.dimen.S) * j + (j - 1) * paramContext.getDimensionPixelOffset(R.dimen.W);
  }
  
  @Nullable
  public final S a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a(getContext());
  }
  
  public final void onCancel(@NonNull DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      ((DialogInterface.OnCancelListener)localIterator.next()).onCancel(paramDialogInterface);
    }
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.jdField_a_of_type_Int = localBundle.getInt("OVERRIDE_THEME_RES_ID");
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.jdField_b_of_type_Int = localBundle.getInt("TITLE_TEXT_RES_ID_KEY");
    this.jdField_a_of_type_JavaLangCharSequence = localBundle.getCharSequence("TITLE_TEXT_KEY");
    this.jdField_c_of_type_Int = localBundle.getInt("INPUT_MODE_KEY");
  }
  
  @NonNull
  public final Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = new Dialog(requireContext(), a(requireContext()));
    Context localContext = paramBundle.getContext();
    this.jdField_a_of_type_Boolean = a(localContext);
    int i = MaterialAttributes.a(localContext, R.attr.n, MaterialDatePicker.class.getCanonicalName());
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable(localContext, null, R.attr.y, R.style.E);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(localContext);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(i));
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.r(ViewCompat.getElevation(paramBundle.getWindow().getDecorView()));
    return paramBundle;
  }
  
  @NonNull
  public final View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = R.layout.A;
    } else {
      i = R.layout.z;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup);
    paramViewGroup = paramLayoutInflater.getContext();
    if (this.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater.findViewById(R.id.K).setLayoutParams(new LinearLayout.LayoutParams(c(paramViewGroup), -2));
    }
    else
    {
      paramBundle = paramLayoutInflater.findViewById(R.id.L);
      localObject = paramLayoutInflater.findViewById(R.id.K);
      paramBundle.setLayoutParams(new LinearLayout.LayoutParams(c(paramViewGroup), -1));
      ((View)localObject).setMinimumHeight(b(requireContext()));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(R.id.S));
    ViewCompat.setAccessibilityLiveRegion(this.jdField_a_of_type_AndroidWidgetTextView, 1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton = ((CheckableImageButton)paramLayoutInflater.findViewById(R.id.T));
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.X);
    Object localObject = this.jdField_a_of_type_JavaLangCharSequence;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    } else {
      paramBundle.setText(this.jdField_b_of_type_Int);
    }
    a(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(R.id.jdField_c_of_type_Int));
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a()) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    } else {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setTag(jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new MaterialDatePicker.1(this));
    paramViewGroup = (Button)paramLayoutInflater.findViewById(R.id.jdField_a_of_type_Int);
    paramViewGroup.setTag(jdField_b_of_type_JavaLangObject);
    paramViewGroup.setOnClickListener(new MaterialDatePicker.2(this));
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
  
  public final void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", this.jdField_a_of_type_Int);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector);
    CalendarConstraints.Builder localBuilder = new CalendarConstraints.Builder(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a() != null) {
      localBuilder.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a().a);
    }
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", localBuilder.a());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", this.jdField_b_of_type_Int);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = requireDialog().getWindow();
    if (this.jdField_a_of_type_Boolean)
    {
      localWindow.setLayout(-1, -1);
      localWindow.setBackgroundDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable);
    }
    else
    {
      localWindow.setLayout(-2, -2);
      int i = getResources().getDimensionPixelOffset(R.dimen.U);
      Rect localRect = new Rect(i, i, i, i);
      localWindow.setBackgroundDrawable(new InsetDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable, i, i, i, i));
      localWindow.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), localRect));
    }
    b();
  }
  
  public void onStop()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerPickerFragment.b();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker
 * JD-Core Version:    0.7.0.1
 */