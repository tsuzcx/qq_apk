package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;

@ViewPager.DecorView
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] ATTRS = { 16842804, 16842901, 16842904, 16842927 };
  private static final float SIDE_ALPHA = 0.6F;
  private static final int[] TEXT_ATTRS = { 16843660 };
  private static final int TEXT_SPACING = 16;
  TextView mCurrText;
  private int mGravity;
  private int mLastKnownCurrentPage = -1;
  float mLastKnownPositionOffset = -1.0F;
  TextView mNextText;
  private int mNonPrimaryAlpha;
  private final PagerTitleStrip.PageListener mPageListener = new PagerTitleStrip.PageListener(this);
  ViewPager mPager;
  TextView mPrevText;
  private int mScaledTextSpacing;
  int mTextColor;
  private boolean mUpdatingPositions;
  private boolean mUpdatingText;
  private WeakReference<PagerAdapter> mWatchingAdapter;
  
  public PagerTitleStrip(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTitleStrip(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.mPrevText = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mCurrText = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mNextText = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    boolean bool = false;
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      TextViewCompat.setTextAppearance(this.mPrevText, i);
      TextViewCompat.setTextAppearance(this.mCurrText, i);
      TextViewCompat.setTextAppearance(this.mNextText, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0) {
      setTextSize(0, j);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.mPrevText.setTextColor(j);
      this.mCurrText.setTextColor(j);
      this.mNextText.setTextColor(j);
    }
    this.mGravity = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
    this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
    this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, TEXT_ATTRS);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.mPrevText);
      setSingleLineAllCaps(this.mCurrText);
      setSingleLineAllCaps(this.mNextText);
    }
    else
    {
      this.mPrevText.setSingleLine();
      this.mCurrText.setSingleLine();
      this.mNextText.setSingleLine();
    }
    this.mScaledTextSpacing = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new PagerTitleStrip.SingleLineAllCapsTransform(paramTextView.getContext()));
  }
  
  int getMinHeight()
  {
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public int getTextSpacing()
  {
    return this.mScaledTextSpacing;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof ViewPager))
    {
      localObject = (ViewPager)localObject;
      PagerAdapter localPagerAdapter = ((ViewPager)localObject).getAdapter();
      ((ViewPager)localObject).setInternalPageChangeListener(this.mPageListener);
      ((ViewPager)localObject).addOnAdapterChangeListener(this.mPageListener);
      this.mPager = ((ViewPager)localObject);
      localObject = this.mWatchingAdapter;
      if (localObject != null) {
        localObject = (PagerAdapter)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      updateAdapter((PagerAdapter)localObject, localPagerAdapter);
      return;
    }
    throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ViewPager localViewPager = this.mPager;
    if (localViewPager != null)
    {
      updateAdapter(localViewPager.getAdapter(), null);
      this.mPager.setInternalPageChangeListener(null);
      this.mPager.removeOnAdapterChangeListener(this.mPageListener);
      this.mPager = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mPager != null)
    {
      float f = this.mLastKnownPositionOffset;
      if (f < 0.0F) {
        f = 0.0F;
      }
      updateTextPositions(this.mLastKnownCurrentPage, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      int j = getPaddingTop() + getPaddingBottom();
      int k = getChildMeasureSpec(paramInt2, j, -2);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
      this.mPrevText.measure(paramInt1, k);
      this.mCurrText.measure(paramInt1, k);
      this.mNextText.measure(paramInt1, k);
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      else
      {
        paramInt1 = this.mCurrText.getMeasuredHeight();
        paramInt1 = Math.max(getMinHeight(), paramInt1 + j);
      }
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.mCurrText.getMeasuredState() << 16));
      return;
    }
    throw new IllegalStateException("Must measure with an exact width");
  }
  
  public void requestLayout()
  {
    if (!this.mUpdatingText) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.mNonPrimaryAlpha = ((int)(paramFloat * 255.0F) & 0xFF);
    int i = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextColor(@ColorInt int paramInt)
  {
    this.mTextColor = paramInt;
    this.mCurrText.setTextColor(paramInt);
    paramInt = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
    this.mPrevText.setTextColor(paramInt);
    this.mNextText.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.mPrevText.setTextSize(paramInt, paramFloat);
    this.mCurrText.setTextSize(paramInt, paramFloat);
    this.mNextText.setTextSize(paramInt, paramFloat);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.mScaledTextSpacing = paramInt;
    requestLayout();
  }
  
  void updateAdapter(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (paramPagerAdapter1 != null)
    {
      paramPagerAdapter1.unregisterDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = null;
    }
    if (paramPagerAdapter2 != null)
    {
      paramPagerAdapter2.registerDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = new WeakReference(paramPagerAdapter2);
    }
    paramPagerAdapter1 = this.mPager;
    if (paramPagerAdapter1 != null)
    {
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      updateText(paramPagerAdapter1.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    }
  }
  
  void updateText(int paramInt, PagerAdapter paramPagerAdapter)
  {
    if (paramPagerAdapter != null) {
      i = paramPagerAdapter.getCount();
    } else {
      i = 0;
    }
    this.mUpdatingText = true;
    Object localObject2 = null;
    if ((paramInt >= 1) && (paramPagerAdapter != null)) {
      localObject1 = paramPagerAdapter.getPageTitle(paramInt - 1);
    } else {
      localObject1 = null;
    }
    this.mPrevText.setText((CharSequence)localObject1);
    TextView localTextView = this.mCurrText;
    if ((paramPagerAdapter != null) && (paramInt < i)) {
      localObject1 = paramPagerAdapter.getPageTitle(paramInt);
    } else {
      localObject1 = null;
    }
    localTextView.setText((CharSequence)localObject1);
    int j = paramInt + 1;
    Object localObject1 = localObject2;
    if (j < i)
    {
      localObject1 = localObject2;
      if (paramPagerAdapter != null) {
        localObject1 = paramPagerAdapter.getPageTitle(j);
      }
    }
    this.mNextText.setText((CharSequence)localObject1);
    int i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.mPrevText.measure(i, j);
    this.mCurrText.measure(i, j);
    this.mNextText.measure(i, j);
    this.mLastKnownCurrentPage = paramInt;
    if (!this.mUpdatingPositions) {
      updateTextPositions(paramInt, this.mLastKnownPositionOffset, false);
    }
    this.mUpdatingText = false;
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt != this.mLastKnownCurrentPage) {
      updateText(paramInt, this.mPager.getAdapter());
    } else if ((!paramBoolean) && (paramFloat == this.mLastKnownPositionOffset)) {
      return;
    }
    this.mUpdatingPositions = true;
    int m = this.mPrevText.getMeasuredWidth();
    int i4 = this.mCurrText.getMeasuredWidth();
    int k = this.mNextText.getMeasuredWidth();
    int i3 = i4 / 2;
    int n = getWidth();
    int i = getHeight();
    int i2 = getPaddingLeft();
    int i1 = getPaddingRight();
    paramInt = getPaddingTop();
    int j = getPaddingBottom();
    int i5 = i1 + i3;
    float f2 = 0.5F + paramFloat;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = f2 - 1.0F;
    }
    i3 = n - i5 - (int)((n - (i2 + i3) - i5) * f1) - i3;
    i4 += i3;
    int i7 = this.mPrevText.getBaseline();
    i5 = this.mCurrText.getBaseline();
    int i6 = this.mNextText.getBaseline();
    int i8 = Math.max(Math.max(i7, i5), i6);
    i7 = i8 - i7;
    i5 = i8 - i5;
    i6 = i8 - i6;
    i8 = this.mPrevText.getMeasuredHeight();
    int i9 = this.mCurrText.getMeasuredHeight();
    int i10 = this.mNextText.getMeasuredHeight();
    i8 = Math.max(Math.max(i8 + i7, i9 + i5), i10 + i6);
    i9 = this.mGravity & 0x70;
    if (i9 != 16)
    {
      if (i9 != 80)
      {
        i = i7 + paramInt;
        j = i5 + paramInt;
        paramInt += i6;
        break label372;
      }
      paramInt = i - j - i8;
    }
    else
    {
      paramInt = (i - paramInt - j - i8) / 2;
    }
    i = i7 + paramInt;
    j = i5 + paramInt;
    paramInt += i6;
    label372:
    TextView localTextView = this.mCurrText;
    localTextView.layout(i3, j, i4, localTextView.getMeasuredHeight() + j);
    j = Math.min(i2, i3 - this.mScaledTextSpacing - m);
    localTextView = this.mPrevText;
    localTextView.layout(j, i, m + j, localTextView.getMeasuredHeight() + i);
    i = Math.max(n - i1 - k, i4 + this.mScaledTextSpacing);
    localTextView = this.mNextText;
    localTextView.layout(i, paramInt, i + k, localTextView.getMeasuredHeight() + paramInt);
    this.mLastKnownPositionOffset = paramFloat;
    this.mUpdatingPositions = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */