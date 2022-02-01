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
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
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
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, 2131035217, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035217);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, android.content.res.Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 61	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 63	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 65	android/graphics/Rect:<init>	()V
    //   15: putfield 67	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 72	androidx/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 78	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   28: astore 10
    //   30: aload_0
    //   31: new 80	androidx/appcompat/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 83	androidx/appcompat/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 85	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +20 -> 64
    //   47: aload_0
    //   48: new 87	androidx/appcompat/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 90	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 92	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: goto +41 -> 102
    //   64: aload 10
    //   66: getstatic 95	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   69: iconst_0
    //   70: invokevirtual 99	androidx/appcompat/widget/TintTypedArray:getResourceId	(II)I
    //   73: istore 6
    //   75: iload 6
    //   77: ifeq +20 -> 97
    //   80: aload_0
    //   81: new 87	androidx/appcompat/view/ContextThemeWrapper
    //   84: dup
    //   85: aload_1
    //   86: iload 6
    //   88: invokespecial 101	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   91: putfield 92	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   94: goto +8 -> 102
    //   97: aload_0
    //   98: aload_1
    //   99: putfield 92	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   102: iload 4
    //   104: istore 7
    //   106: iload 4
    //   108: iconst_m1
    //   109: if_icmpne +126 -> 235
    //   112: aload_1
    //   113: aload_2
    //   114: getstatic 41	androidx/appcompat/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   117: iload_3
    //   118: iconst_0
    //   119: invokevirtual 106	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   122: astore 5
    //   124: iload 4
    //   126: istore 6
    //   128: aload 5
    //   130: astore 8
    //   132: aload 5
    //   134: iconst_0
    //   135: invokevirtual 112	android/content/res/TypedArray:hasValue	(I)Z
    //   138: ifeq +16 -> 154
    //   141: aload 5
    //   143: astore 8
    //   145: aload 5
    //   147: iconst_0
    //   148: iconst_0
    //   149: invokevirtual 115	android/content/res/TypedArray:getInt	(II)I
    //   152: istore 6
    //   154: iload 6
    //   156: istore 7
    //   158: aload 5
    //   160: ifnull +75 -> 235
    //   163: iload 6
    //   165: istore 4
    //   167: aload 5
    //   169: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   172: iload 4
    //   174: istore 7
    //   176: goto +59 -> 235
    //   179: astore 9
    //   181: goto +15 -> 196
    //   184: astore_1
    //   185: aconst_null
    //   186: astore 8
    //   188: goto +35 -> 223
    //   191: astore 9
    //   193: aconst_null
    //   194: astore 5
    //   196: aload 5
    //   198: astore 8
    //   200: ldc 21
    //   202: ldc 120
    //   204: aload 9
    //   206: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: iload 4
    //   212: istore 7
    //   214: aload 5
    //   216: ifnull +19 -> 235
    //   219: goto -52 -> 167
    //   222: astore_1
    //   223: aload 8
    //   225: ifnull +8 -> 233
    //   228: aload 8
    //   230: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   233: aload_1
    //   234: athrow
    //   235: iload 7
    //   237: ifeq +112 -> 349
    //   240: iload 7
    //   242: iconst_1
    //   243: if_icmpeq +6 -> 249
    //   246: goto +132 -> 378
    //   249: new 128	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup
    //   252: dup
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 92	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   258: aload_2
    //   259: iload_3
    //   260: invokespecial 131	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   263: astore 5
    //   265: aload_0
    //   266: getfield 92	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   269: aload_2
    //   270: getstatic 72	androidx/appcompat/R$styleable:Spinner	[I
    //   273: iload_3
    //   274: iconst_0
    //   275: invokestatic 78	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   278: astore 8
    //   280: aload_0
    //   281: aload 8
    //   283: getstatic 134	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   286: bipush 254
    //   288: invokevirtual 137	androidx/appcompat/widget/TintTypedArray:getLayoutDimension	(II)I
    //   291: putfield 139	androidx/appcompat/widget/AppCompatSpinner:mDropDownWidth	I
    //   294: aload 5
    //   296: aload 8
    //   298: getstatic 142	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   301: invokevirtual 146	androidx/appcompat/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   304: invokevirtual 150	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   307: aload 5
    //   309: aload 10
    //   311: getstatic 153	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   314: invokevirtual 157	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   317: invokevirtual 161	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   320: aload 8
    //   322: invokevirtual 162	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   325: aload_0
    //   326: aload 5
    //   328: putfield 164	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   331: aload_0
    //   332: new 166	androidx/appcompat/widget/AppCompatSpinner$1
    //   335: dup
    //   336: aload_0
    //   337: aload_0
    //   338: aload 5
    //   340: invokespecial 169	androidx/appcompat/widget/AppCompatSpinner$1:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$DropdownPopup;)V
    //   343: putfield 171	androidx/appcompat/widget/AppCompatSpinner:mForwardingListener	Landroidx/appcompat/widget/ForwardingListener;
    //   346: goto +32 -> 378
    //   349: aload_0
    //   350: new 173	androidx/appcompat/widget/AppCompatSpinner$DialogPopup
    //   353: dup
    //   354: aload_0
    //   355: invokespecial 176	androidx/appcompat/widget/AppCompatSpinner$DialogPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   358: putfield 164	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   361: aload_0
    //   362: getfield 164	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   365: aload 10
    //   367: getstatic 153	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   370: invokevirtual 157	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   373: invokeinterface 179 2 0
    //   378: aload 10
    //   380: getstatic 182	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   383: invokevirtual 186	androidx/appcompat/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   386: astore 5
    //   388: aload 5
    //   390: ifnull +27 -> 417
    //   393: new 188	android/widget/ArrayAdapter
    //   396: dup
    //   397: aload_1
    //   398: ldc 189
    //   400: aload 5
    //   402: invokespecial 192	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   405: astore_1
    //   406: aload_1
    //   407: ldc 193
    //   409: invokevirtual 197	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   412: aload_0
    //   413: aload_1
    //   414: invokevirtual 201	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   417: aload 10
    //   419: invokevirtual 162	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   422: aload_0
    //   423: iconst_1
    //   424: putfield 203	androidx/appcompat/widget/AppCompatSpinner:mPopupSet	Z
    //   427: aload_0
    //   428: getfield 205	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   431: astore_1
    //   432: aload_1
    //   433: ifnull +13 -> 446
    //   436: aload_0
    //   437: aload_1
    //   438: invokevirtual 201	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   441: aload_0
    //   442: aconst_null
    //   443: putfield 205	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   446: aload_0
    //   447: getfield 85	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   450: aload_2
    //   451: iload_3
    //   452: invokevirtual 209	androidx/appcompat/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   455: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	AppCompatSpinner
    //   0	456	1	paramContext	Context
    //   0	456	2	paramAttributeSet	AttributeSet
    //   0	456	3	paramInt1	int
    //   0	456	4	paramInt2	int
    //   0	456	5	paramTheme	android.content.res.Resources.Theme
    //   73	91	6	i	int
    //   104	140	7	j	int
    //   130	191	8	localObject	java.lang.Object
    //   179	1	9	localException1	java.lang.Exception
    //   191	14	9	localException2	java.lang.Exception
    //   28	390	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   132	141	179	java/lang/Exception
    //   145	154	179	java/lang/Exception
    //   112	124	184	finally
    //   112	124	191	java/lang/Exception
    //   132	141	222	finally
    //   145	154	222	finally
    //   200	210	222	finally
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