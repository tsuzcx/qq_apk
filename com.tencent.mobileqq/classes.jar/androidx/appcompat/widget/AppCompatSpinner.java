package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  private static final int MAX_ITEMS_MEASURED = 15;
  private static final int MODE_DIALOG = 0;
  private static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "AppCompatSpinner";
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  int mDropDownWidth;
  private ForwardingListener mForwardingListener;
  private AppCompatSpinner.SpinnerPopup mPopup;
  private final Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  final Rect mTempRect;
  
  public AppCompatSpinner(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2, android.content.res.Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 68	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 70	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 72	android/graphics/Rect:<init>	()V
    //   15: putfield 74	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 78	androidx/appcompat/widget/AppCompatSpinner:getContext	()Landroid/content/Context;
    //   23: invokestatic 84	androidx/appcompat/widget/ThemeUtils:checkAppCompatTheme	(Landroid/view/View;Landroid/content/Context;)V
    //   26: aload_1
    //   27: aload_2
    //   28: getstatic 89	androidx/appcompat/R$styleable:Spinner	[I
    //   31: iload_3
    //   32: iconst_0
    //   33: invokestatic 95	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   36: astore 10
    //   38: aload_0
    //   39: new 97	androidx/appcompat/widget/AppCompatBackgroundHelper
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 100	androidx/appcompat/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   47: putfield 102	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   50: aload 5
    //   52: ifnull +20 -> 72
    //   55: aload_0
    //   56: new 104	androidx/appcompat/view/ContextThemeWrapper
    //   59: dup
    //   60: aload_1
    //   61: aload 5
    //   63: invokespecial 107	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   66: putfield 109	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   69: goto +41 -> 110
    //   72: aload 10
    //   74: getstatic 112	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   77: iconst_0
    //   78: invokevirtual 116	androidx/appcompat/widget/TintTypedArray:getResourceId	(II)I
    //   81: istore 6
    //   83: iload 6
    //   85: ifeq +20 -> 105
    //   88: aload_0
    //   89: new 104	androidx/appcompat/view/ContextThemeWrapper
    //   92: dup
    //   93: aload_1
    //   94: iload 6
    //   96: invokespecial 118	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   99: putfield 109	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   102: goto +8 -> 110
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 109	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   110: iload 4
    //   112: istore 7
    //   114: iload 4
    //   116: iconst_m1
    //   117: if_icmpne +126 -> 243
    //   120: aload_1
    //   121: aload_2
    //   122: getstatic 41	androidx/appcompat/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   125: iload_3
    //   126: iconst_0
    //   127: invokevirtual 123	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   130: astore 5
    //   132: iload 4
    //   134: istore 6
    //   136: aload 5
    //   138: astore 8
    //   140: aload 5
    //   142: iconst_0
    //   143: invokevirtual 129	android/content/res/TypedArray:hasValue	(I)Z
    //   146: ifeq +16 -> 162
    //   149: aload 5
    //   151: astore 8
    //   153: aload 5
    //   155: iconst_0
    //   156: iconst_0
    //   157: invokevirtual 132	android/content/res/TypedArray:getInt	(II)I
    //   160: istore 6
    //   162: iload 6
    //   164: istore 7
    //   166: aload 5
    //   168: ifnull +75 -> 243
    //   171: iload 6
    //   173: istore 4
    //   175: aload 5
    //   177: invokevirtual 135	android/content/res/TypedArray:recycle	()V
    //   180: iload 4
    //   182: istore 7
    //   184: goto +59 -> 243
    //   187: astore 9
    //   189: goto +15 -> 204
    //   192: astore_1
    //   193: aconst_null
    //   194: astore 8
    //   196: goto +35 -> 231
    //   199: astore 9
    //   201: aconst_null
    //   202: astore 5
    //   204: aload 5
    //   206: astore 8
    //   208: ldc 21
    //   210: ldc 137
    //   212: aload 9
    //   214: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: iload 4
    //   220: istore 7
    //   222: aload 5
    //   224: ifnull +19 -> 243
    //   227: goto -52 -> 175
    //   230: astore_1
    //   231: aload 8
    //   233: ifnull +8 -> 241
    //   236: aload 8
    //   238: invokevirtual 135	android/content/res/TypedArray:recycle	()V
    //   241: aload_1
    //   242: athrow
    //   243: iload 7
    //   245: ifeq +112 -> 357
    //   248: iload 7
    //   250: iconst_1
    //   251: if_icmpeq +6 -> 257
    //   254: goto +132 -> 386
    //   257: new 145	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup
    //   260: dup
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 109	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   266: aload_2
    //   267: iload_3
    //   268: invokespecial 148	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   271: astore 5
    //   273: aload_0
    //   274: getfield 109	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   277: aload_2
    //   278: getstatic 89	androidx/appcompat/R$styleable:Spinner	[I
    //   281: iload_3
    //   282: iconst_0
    //   283: invokestatic 95	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   286: astore 8
    //   288: aload_0
    //   289: aload 8
    //   291: getstatic 151	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   294: bipush 254
    //   296: invokevirtual 154	androidx/appcompat/widget/TintTypedArray:getLayoutDimension	(II)I
    //   299: putfield 156	androidx/appcompat/widget/AppCompatSpinner:mDropDownWidth	I
    //   302: aload 5
    //   304: aload 8
    //   306: getstatic 159	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   309: invokevirtual 163	androidx/appcompat/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   312: invokevirtual 167	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   315: aload 5
    //   317: aload 10
    //   319: getstatic 170	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   322: invokevirtual 174	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   325: invokevirtual 178	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   328: aload 8
    //   330: invokevirtual 179	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   333: aload_0
    //   334: aload 5
    //   336: putfield 181	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   339: aload_0
    //   340: new 183	androidx/appcompat/widget/AppCompatSpinner$1
    //   343: dup
    //   344: aload_0
    //   345: aload_0
    //   346: aload 5
    //   348: invokespecial 186	androidx/appcompat/widget/AppCompatSpinner$1:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$DropdownPopup;)V
    //   351: putfield 188	androidx/appcompat/widget/AppCompatSpinner:mForwardingListener	Landroidx/appcompat/widget/ForwardingListener;
    //   354: goto +32 -> 386
    //   357: aload_0
    //   358: new 190	androidx/appcompat/widget/AppCompatSpinner$DialogPopup
    //   361: dup
    //   362: aload_0
    //   363: invokespecial 193	androidx/appcompat/widget/AppCompatSpinner$DialogPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   366: putfield 181	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   369: aload_0
    //   370: getfield 181	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   373: aload 10
    //   375: getstatic 170	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   378: invokevirtual 174	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   381: invokeinterface 196 2 0
    //   386: aload 10
    //   388: getstatic 199	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   391: invokevirtual 203	androidx/appcompat/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   394: astore 5
    //   396: aload 5
    //   398: ifnull +28 -> 426
    //   401: new 205	android/widget/ArrayAdapter
    //   404: dup
    //   405: aload_1
    //   406: ldc 206
    //   408: aload 5
    //   410: invokespecial 209	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   413: astore_1
    //   414: aload_1
    //   415: getstatic 214	androidx/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   418: invokevirtual 218	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   421: aload_0
    //   422: aload_1
    //   423: invokevirtual 222	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   426: aload 10
    //   428: invokevirtual 179	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   431: aload_0
    //   432: iconst_1
    //   433: putfield 224	androidx/appcompat/widget/AppCompatSpinner:mPopupSet	Z
    //   436: aload_0
    //   437: getfield 226	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   440: astore_1
    //   441: aload_1
    //   442: ifnull +13 -> 455
    //   445: aload_0
    //   446: aload_1
    //   447: invokevirtual 222	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   450: aload_0
    //   451: aconst_null
    //   452: putfield 226	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   455: aload_0
    //   456: getfield 102	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   459: aload_2
    //   460: iload_3
    //   461: invokevirtual 230	androidx/appcompat/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   464: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	AppCompatSpinner
    //   0	465	1	paramContext	Context
    //   0	465	2	paramAttributeSet	AttributeSet
    //   0	465	3	paramInt1	int
    //   0	465	4	paramInt2	int
    //   0	465	5	paramTheme	android.content.res.Resources.Theme
    //   81	91	6	i	int
    //   112	140	7	j	int
    //   138	191	8	localObject	java.lang.Object
    //   187	1	9	localException1	java.lang.Exception
    //   199	14	9	localException2	java.lang.Exception
    //   36	391	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   140	149	187	java/lang/Exception
    //   153	162	187	java/lang/Exception
    //   120	132	192	finally
    //   120	132	199	java/lang/Exception
    //   140	149	230	finally
    //   153	162	230	finally
    //   208	218	230	finally
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int k = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i3 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i3 - i)));
    View localView = null;
    i = 0;
    while (j < i3)
    {
      int n = paramSpinnerAdapter.getItemViewType(j);
      int m = k;
      if (n != k)
      {
        localView = null;
        m = n;
      }
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i1, i2);
      i = Math.max(i, localView.getMeasuredWidth());
      j += 1;
      k = m;
    }
    j = i;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.mTempRect);
      j = i + (this.mTempRect.left + this.mTempRect.right);
    }
    return j;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.mPopup != null) {
      return this.mDropDownWidth;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  @VisibleForTesting
  final AppCompatSpinner.SpinnerPopup getInternalPopup()
  {
    return this.mPopup;
  }
  
  public Drawable getPopupBackground()
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    return this.mPopupContext;
  }
  
  public CharSequence getPrompt()
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getHintText();
    }
    return super.getPrompt();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportBackgroundTintList()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if ((localSpinnerPopup != null) && (localSpinnerPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AppCompatSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.mShowDropdown)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new AppCompatSpinner.2(this));
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppCompatSpinner.SavedState localSavedState = new AppCompatSpinner.SavedState(super.onSaveInstanceState());
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    boolean bool;
    if ((localSpinnerPopup != null) && (localSpinnerPopup.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.mShowDropdown = bool;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ForwardingListener localForwardingListener = this.mForwardingListener;
    if ((localForwardingListener != null) && (localForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      if (!localSpinnerPopup.isShowing()) {
        showPopup();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet)
    {
      this.mTempAdapter = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null)
    {
      Context localContext2 = this.mPopupContext;
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      this.mPopup.setAdapter(new AppCompatSpinner.DropDownAdapter(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      localSpinnerPopup.setHorizontalOriginalOffset(paramInt);
      this.mPopup.setHorizontalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      localSpinnerPopup.setVerticalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null)
    {
      this.mDropDownWidth = paramInt;
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      localSpinnerPopup.setBackgroundDrawable(paramDrawable);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    AppCompatSpinner.SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      localSpinnerPopup.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  void showPopup()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.mPopup.show(getTextDirection(), getTextAlignment());
      return;
    }
    this.mPopup.show(-1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */