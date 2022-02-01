package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
  private boolean mAsyncFontPending;
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mFontWeight = -1;
  private int mStyle = 0;
  @NonNull
  private final TextView mView;
  
  AppCompatTextHelper(@NonNull TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  private void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
    }
  }
  
  private static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      paramAppCompatDrawableManager.mHasTintList = true;
      paramAppCompatDrawableManager.mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5, Drawable paramDrawable6)
  {
    if ((Build.VERSION.SDK_INT >= 17) && ((paramDrawable5 != null) || (paramDrawable6 != null)))
    {
      paramDrawable3 = this.mView.getCompoundDrawablesRelative();
      paramDrawable1 = this.mView;
      if (paramDrawable5 == null) {
        paramDrawable5 = paramDrawable3[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable3[1];
      }
      if (paramDrawable6 == null) {
        paramDrawable6 = paramDrawable3[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable3[3];
      }
      paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
      return;
    }
    if ((paramDrawable1 != null) || (paramDrawable2 != null) || (paramDrawable3 != null) || (paramDrawable4 != null))
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramDrawable5 = this.mView.getCompoundDrawablesRelative();
        if ((paramDrawable5[0] != null) || (paramDrawable5[2] != null))
        {
          paramDrawable1 = this.mView;
          paramDrawable3 = paramDrawable5[0];
          if (paramDrawable2 == null) {
            paramDrawable2 = paramDrawable5[1];
          }
          paramDrawable6 = paramDrawable5[2];
          if (paramDrawable4 == null) {
            paramDrawable4 = paramDrawable5[3];
          }
          paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable3, paramDrawable2, paramDrawable6, paramDrawable4);
          return;
        }
      }
      paramDrawable6 = this.mView.getCompoundDrawables();
      paramDrawable5 = this.mView;
      if (paramDrawable1 == null) {
        paramDrawable1 = paramDrawable6[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable6[1];
      }
      if (paramDrawable3 == null) {
        paramDrawable3 = paramDrawable6[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable6[3];
      }
      paramDrawable5.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
  }
  
  private void setCompoundTints()
  {
    TintInfo localTintInfo = this.mDrawableTint;
    this.mDrawableLeftTint = localTintInfo;
    this.mDrawableTopTint = localTintInfo;
    this.mDrawableRightTint = localTintInfo;
    this.mDrawableBottomTint = localTintInfo;
    this.mDrawableStartTint = localTintInfo;
    this.mDrawableEndTint = localTintInfo;
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i >= 28)
    {
      this.mFontWeight = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
      if (this.mFontWeight != -1) {
        this.mStyle = (this.mStyle & 0x2 | 0x0);
      }
    }
    if ((!paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily)) && (!paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface))
      {
        this.mAsyncFontPending = false;
        i = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            this.mFontTypeface = Typeface.MONOSPACE;
            return;
          }
          this.mFontTypeface = Typeface.SERIF;
          return;
        }
        this.mFontTypeface = Typeface.SANS_SERIF;
      }
      return;
    }
    this.mFontTypeface = null;
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
      i = R.styleable.TextAppearance_fontFamily;
    } else {
      i = R.styleable.TextAppearance_android_fontFamily;
    }
    int j = this.mFontWeight;
    int k = this.mStyle;
    if (!paramContext.isRestricted()) {
      paramContext = new AppCompatTextHelper.1(this, j, k, new WeakReference(this.mView));
    }
    try
    {
      paramContext = paramTintTypedArray.getFont(i, this.mStyle, paramContext);
      if (paramContext == null) {
        break label294;
      }
      if ((Build.VERSION.SDK_INT < 28) || (this.mFontWeight == -1)) {
        break label289;
      }
      paramContext = Typeface.create(paramContext, 0);
      j = this.mFontWeight;
      if ((this.mStyle & 0x2) == 0) {
        break label405;
      }
      bool1 = true;
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    this.mFontTypeface = Typeface.create(paramContext, j, bool1);
    break label294;
    label289:
    this.mFontTypeface = paramContext;
    label294:
    if (this.mFontTypeface == null)
    {
      bool1 = true;
      this.mAsyncFontPending = bool1;
      if (this.mFontTypeface == null)
      {
        paramContext = paramTintTypedArray.getString(i);
        if (paramContext != null)
        {
          if ((Build.VERSION.SDK_INT >= 28) && (this.mFontWeight != -1))
          {
            paramContext = Typeface.create(paramContext, 0);
            i = this.mFontWeight;
            bool1 = bool2;
            if ((this.mStyle & 0x2) != 0) {
              bool1 = true;
            }
            this.mFontTypeface = Typeface.create(paramContext, i, bool1);
            return;
          }
          this.mFontTypeface = Typeface.create(paramContext, this.mStyle);
        }
      }
      return;
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    Drawable[] arrayOfDrawable;
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null)))
    {
      arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void autoSizeText()
  {
    this.mAutoSizeTextHelper.autoSizeText();
  }
  
  int getAutoSizeMaxTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }
  
  int getAutoSizeMinTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }
  
  int getAutoSizeStepGranularity()
  {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }
  
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }
  
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }
  
  @Nullable
  ColorStateList getCompoundDrawableTintList()
  {
    TintInfo localTintInfo = this.mDrawableTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintList;
    }
    return null;
  }
  
  @Nullable
  PorterDuff.Mode getCompoundDrawableTintMode()
  {
    TintInfo localTintInfo = this.mDrawableTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintMode;
    }
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    Object localObject1 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    Object localObject2 = this.mView;
    ViewCompat.saveAttributeDataForStyleable((View)localObject2, ((TextView)localObject2).getContext(), R.styleable.AppCompatTextHelper, paramAttributeSet, ((TintTypedArray)localObject1).getWrappedTypeArray(), paramInt, 0);
    int i = ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      this.mDrawableLeftTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      this.mDrawableTopTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      this.mDrawableRightTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      this.mDrawableBottomTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
        this.mDrawableStartTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
      }
      if (((TintTypedArray)localObject1).hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
        this.mDrawableEndTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
      }
    }
    ((TintTypedArray)localObject1).recycle();
    boolean bool2 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1;
    Object localObject5;
    Object localObject3;
    label458:
    Object localObject4;
    if (i != -1)
    {
      localObject6 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if ((!bool2) && (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool1 = ((TintTypedArray)localObject6).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
      }
      else
      {
        i = 0;
        bool1 = false;
      }
      updateTypefaceAndStyle(localContext, (TintTypedArray)localObject6);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColor)) {
          localObject1 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColor);
        } else {
          localObject1 = null;
        }
        if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          localObject2 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        } else {
          localObject2 = null;
        }
        if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColorLink))
        {
          localObject5 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorLink);
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break label458;
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
      localObject5 = null;
      if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_textLocale)) {
        localObject4 = ((TintTypedArray)localObject6).getString(R.styleable.TextAppearance_textLocale);
      } else {
        localObject4 = null;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_fontVariationSettings))) {
        localObject3 = ((TintTypedArray)localObject6).getString(R.styleable.TextAppearance_fontVariationSettings);
      } else {
        localObject3 = null;
      }
      ((TintTypedArray)localObject6).recycle();
    }
    else
    {
      localObject1 = null;
      localObject3 = null;
      i = 0;
      bool1 = false;
      localObject2 = null;
      localObject4 = null;
      localObject5 = null;
    }
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    if ((!bool2) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)))
    {
      bool1 = localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
      i = 1;
    }
    Object localObject6 = localObject1;
    Object localObject7 = localObject2;
    Object localObject8 = localObject5;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
        localObject2 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      }
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
        localObject1 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
      }
      localObject6 = localObject1;
      localObject7 = localObject2;
      localObject8 = localObject5;
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink))
      {
        localObject8 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        localObject7 = localObject2;
        localObject6 = localObject1;
      }
    }
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textLocale)) {
      localObject4 = localTintTypedArray.getString(R.styleable.TextAppearance_textLocale);
    }
    localObject1 = localObject3;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = localObject3;
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
        localObject1 = localTintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
      }
    }
    if ((Build.VERSION.SDK_INT >= 28) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(localContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (localObject7 != null) {
      this.mView.setTextColor(localObject7);
    }
    if (localObject6 != null) {
      this.mView.setHintTextColor((ColorStateList)localObject6);
    }
    if (localObject8 != null) {
      this.mView.setLinkTextColor((ColorStateList)localObject8);
    }
    if ((!bool2) && (i != 0)) {
      setAllCaps(bool1);
    }
    localObject2 = this.mFontTypeface;
    if (localObject2 != null) {
      if (this.mFontWeight == -1) {
        this.mView.setTypeface((Typeface)localObject2, this.mStyle);
      } else {
        this.mView.setTypeface((Typeface)localObject2);
      }
    }
    if (localObject1 != null) {
      this.mView.setFontVariationSettings((String)localObject1);
    }
    if (localObject4 != null) {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mView.setTextLocales(LocaleList.forLanguageTags((String)localObject4));
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = ((String)localObject4).substring(0, ((String)localObject4).indexOf(','));
        this.mView.setTextLocale(Locale.forLanguageTag((String)localObject1));
      }
    }
    this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
    {
      localObject1 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
      if (localObject1.length > 0) {
        if (this.mView.getAutoSizeStepGranularity() != -1.0F) {
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        } else {
          this.mView.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
        }
      }
    }
    localObject6 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
    if (paramInt != -1) {
      paramAttributeSet = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      paramAttributeSet = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
    if (paramInt != -1) {
      localObject1 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject1 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
    if (paramInt != -1) {
      localObject2 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject2 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
    if (paramInt != -1) {
      localObject3 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject3 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
    if (paramInt != -1) {
      localObject4 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject4 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
    if (paramInt != -1) {
      localObject5 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject5 = null;
    }
    setCompoundDrawables(paramAttributeSet, (Drawable)localObject1, (Drawable)localObject2, (Drawable)localObject3, (Drawable)localObject4, (Drawable)localObject5);
    if (((TintTypedArray)localObject6).hasValue(R.styleable.AppCompatTextView_drawableTint))
    {
      paramAttributeSet = ((TintTypedArray)localObject6).getColorStateList(R.styleable.AppCompatTextView_drawableTint);
      TextViewCompat.setCompoundDrawableTintList(this.mView, paramAttributeSet);
    }
    if (((TintTypedArray)localObject6).hasValue(R.styleable.AppCompatTextView_drawableTintMode))
    {
      paramAttributeSet = DrawableUtils.parseTintMode(((TintTypedArray)localObject6).getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null);
      TextViewCompat.setCompoundDrawableTintMode(this.mView, paramAttributeSet);
    }
    paramInt = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    i = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    int j = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
    ((TintTypedArray)localObject6).recycle();
    if (paramInt != -1) {
      TextViewCompat.setFirstBaselineToTopHeight(this.mView, paramInt);
    }
    if (i != -1) {
      TextViewCompat.setLastBaselineToBottomHeight(this.mView, i);
    }
    if (j != -1) {
      TextViewCompat.setLineHeight(this.mView, j);
    }
  }
  
  void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mFontTypeface = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null) {
        paramWeakReference.setTypeface(paramTypeface, this.mStyle);
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
      autoSizeText();
    }
  }
  
  void onSetCompoundDrawables()
  {
    applyCompoundDrawablesTints();
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
      setAllCaps(localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.mView.setTextColor(localColorStateList);
      }
    }
    if ((localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    if ((Build.VERSION.SDK_INT >= 26) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)))
    {
      paramContext = localTintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
      if (paramContext != null) {
        this.mView.setFontVariationSettings(paramContext);
      }
    }
    localTintTypedArray.recycle();
    paramContext = this.mFontTypeface;
    if (paramContext != null) {
      this.mView.setTypeface(paramContext, this.mStyle);
    }
  }
  
  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  void setCompoundDrawableTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mDrawableTint;
    localTintInfo.mTintList = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    localTintInfo.mHasTintList = bool;
    setCompoundTints();
  }
  
  void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mDrawableTint;
    localTintInfo.mTintMode = paramMode;
    boolean bool;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    }
    localTintInfo.mHasTintMode = bool;
    setCompoundTints();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled())) {
      setTextSizeInternal(paramInt, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextHelper
 * JD-Core Version:    0.7.0.1
 */