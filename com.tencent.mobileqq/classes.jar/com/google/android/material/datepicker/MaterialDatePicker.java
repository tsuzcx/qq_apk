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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S>
  extends DialogFragment
{
  static final Object a = "CONFIRM_BUTTON_TAG";
  static final Object b = "CANCEL_BUTTON_TAG";
  static final Object c = "TOGGLE_BUTTON_TAG";
  private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> d = new LinkedHashSet();
  private final LinkedHashSet<View.OnClickListener> e = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnCancelListener> f = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnDismissListener> g = new LinkedHashSet();
  @StyleRes
  private int h;
  @Nullable
  private DateSelector<S> i;
  private PickerFragment<S> j;
  @Nullable
  private CalendarConstraints k;
  private MaterialCalendar<S> l;
  @StringRes
  private int m;
  private CharSequence n;
  private boolean o;
  private int p;
  private TextView q;
  private CheckableImageButton r;
  @Nullable
  private MaterialShapeDrawable s;
  private Button t;
  
  private void a(@NonNull CheckableImageButton paramCheckableImageButton)
  {
    if (this.r.isChecked()) {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.N);
    } else {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.P);
    }
    this.r.setContentDescription(paramCheckableImageButton);
  }
  
  static boolean a(@NonNull Context paramContext)
  {
    return a(paramContext, 16843277);
  }
  
  static boolean a(@NonNull Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.F, MaterialCalendar.class.getCanonicalName()), new int[] { paramInt });
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    return bool;
  }
  
  static boolean b(@NonNull Context paramContext)
  {
    return a(paramContext, R.attr.N);
  }
  
  private int c(Context paramContext)
  {
    int i1 = this.h;
    if (i1 != 0) {
      return i1;
    }
    return this.i.b(paramContext);
  }
  
  private void c()
  {
    String str = a();
    this.q.setContentDescription(String.format(getString(R.string.w), new Object[] { str }));
    this.q.setText(str);
  }
  
  private void d()
  {
    int i1 = c(requireContext());
    this.l = MaterialCalendar.a(this.i, i1, this.k);
    if (this.r.isChecked()) {
      localObject = MaterialTextInputPicker.a(this.i, i1, this.k);
    } else {
      localObject = this.l;
    }
    this.j = ((PickerFragment)localObject);
    c();
    Object localObject = getChildFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).replace(R.id.K, this.j);
    ((FragmentTransaction)localObject).commitNow();
    this.j.a(new MaterialDatePicker.3(this));
  }
  
  private void d(Context paramContext)
  {
    this.r.setTag(c);
    this.r.setImageDrawable(e(paramContext));
    paramContext = this.r;
    boolean bool;
    if (this.p != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.setChecked(bool);
    ViewCompat.setAccessibilityDelegate(this.r, null);
    a(this.r);
    this.r.setOnClickListener(new MaterialDatePicker.4(this));
  }
  
  @NonNull
  private static Drawable e(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = AppCompatResources.getDrawable(paramContext, R.drawable.c);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable);
    paramContext = AppCompatResources.getDrawable(paramContext, R.drawable.d);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private static int f(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    return paramContext.getDimensionPixelSize(R.dimen.Z) + paramContext.getDimensionPixelOffset(R.dimen.aa) + paramContext.getDimensionPixelOffset(R.dimen.Y) + paramContext.getDimensionPixelSize(R.dimen.T) + (MonthAdapter.a * paramContext.getDimensionPixelSize(R.dimen.R) + (MonthAdapter.a - 1) * paramContext.getDimensionPixelOffset(R.dimen.X)) + paramContext.getDimensionPixelOffset(R.dimen.P);
  }
  
  private static int g(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i1 = paramContext.getDimensionPixelOffset(R.dimen.Q);
    int i2 = Month.a().c;
    return i1 * 2 + paramContext.getDimensionPixelSize(R.dimen.S) * i2 + (i2 - 1) * paramContext.getDimensionPixelOffset(R.dimen.W);
  }
  
  public String a()
  {
    return this.i.a(getContext());
  }
  
  @Nullable
  public final S b()
  {
    return this.i.a();
  }
  
  public final void onCancel(@NonNull DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.f.iterator();
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
    this.h = localBundle.getInt("OVERRIDE_THEME_RES_ID");
    this.i = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.k = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.m = localBundle.getInt("TITLE_TEXT_RES_ID_KEY");
    this.n = localBundle.getCharSequence("TITLE_TEXT_KEY");
    this.p = localBundle.getInt("INPUT_MODE_KEY");
  }
  
  @NonNull
  public final Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = new ReportDialog(requireContext(), c(requireContext()));
    Context localContext = paramBundle.getContext();
    this.o = a(localContext);
    int i1 = MaterialAttributes.a(localContext, R.attr.t, MaterialDatePicker.class.getCanonicalName());
    this.s = new MaterialShapeDrawable(localContext, null, R.attr.F, R.style.G);
    this.s.a(localContext);
    this.s.g(ColorStateList.valueOf(i1));
    this.s.r(ViewCompat.getElevation(paramBundle.getWindow().getDecorView()));
    return paramBundle;
  }
  
  @NonNull
  public final View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    int i1;
    if (this.o) {
      i1 = R.layout.A;
    } else {
      i1 = R.layout.z;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i1, paramViewGroup);
    paramViewGroup = paramLayoutInflater.getContext();
    if (this.o)
    {
      paramLayoutInflater.findViewById(R.id.K).setLayoutParams(new LinearLayout.LayoutParams(g(paramViewGroup), -2));
    }
    else
    {
      paramBundle = paramLayoutInflater.findViewById(R.id.L);
      localObject = paramLayoutInflater.findViewById(R.id.K);
      paramBundle.setLayoutParams(new LinearLayout.LayoutParams(g(paramViewGroup), -1));
      ((View)localObject).setMinimumHeight(f(requireContext()));
    }
    this.q = ((TextView)paramLayoutInflater.findViewById(R.id.S));
    ViewCompat.setAccessibilityLiveRegion(this.q, 1);
    this.r = ((CheckableImageButton)paramLayoutInflater.findViewById(R.id.T));
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.X);
    Object localObject = this.n;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    } else {
      paramBundle.setText(this.m);
    }
    d(paramViewGroup);
    this.t = ((Button)paramLayoutInflater.findViewById(R.id.c));
    if (this.i.b()) {
      this.t.setEnabled(true);
    } else {
      this.t.setEnabled(false);
    }
    this.t.setTag(a);
    this.t.setOnClickListener(new MaterialDatePicker.1(this));
    paramViewGroup = (Button)paramLayoutInflater.findViewById(R.id.a);
    paramViewGroup.setTag(b);
    paramViewGroup.setOnClickListener(new MaterialDatePicker.2(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public final void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    Object localObject = this.g.iterator();
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
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", this.h);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.i);
    CalendarConstraints.Builder localBuilder = new CalendarConstraints.Builder(this.k);
    if (this.l.a() != null) {
      localBuilder.a(this.l.a().e);
    }
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", localBuilder.a());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", this.m);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", this.n);
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = requireDialog().getWindow();
    if (this.o)
    {
      localWindow.setLayout(-1, -1);
      localWindow.setBackgroundDrawable(this.s);
    }
    else
    {
      localWindow.setLayout(-2, -2);
      int i1 = getResources().getDimensionPixelOffset(R.dimen.U);
      Rect localRect = new Rect(i1, i1, i1, i1);
      localWindow.setBackgroundDrawable(new InsetDrawable(this.s, i1, i1, i1, i1));
      localWindow.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), localRect));
    }
    d();
  }
  
  public void onStop()
  {
    this.j.g();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker
 * JD-Core Version:    0.7.0.1
 */