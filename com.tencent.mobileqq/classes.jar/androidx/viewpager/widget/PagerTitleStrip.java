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
    for (;;)
    {
      this.mScaledTextSpacing = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.mPrevText.setSingleLine();
      this.mCurrText.setSingleLine();
      this.mNextText.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new PagerTitleStrip.SingleLineAllCapsTransform(paramTextView.getContext()));
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.mScaledTextSpacing;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    PagerAdapter localPagerAdapter = ((ViewPager)localObject).getAdapter();
    ((ViewPager)localObject).setInternalPageChangeListener(this.mPageListener);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.mPageListener);
    this.mPager = ((ViewPager)localObject);
    if (this.mWatchingAdapter != null) {}
    for (localObject = (PagerAdapter)this.mWatchingAdapter.get();; localObject = null)
    {
      updateAdapter((PagerAdapter)localObject, localPagerAdapter);
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mPager != null)
    {
      updateAdapter(this.mPager.getAdapter(), null);
      this.mPager.setInternalPageChangeListener(null);
      this.mPager.removeOnAdapterChangeListener(this.mPageListener);
      this.mPager = null;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.mPager != null)
    {
      if (this.mLastKnownPositionOffset >= 0.0F) {
        f = this.mLastKnownPositionOffset;
      }
      updateTextPositions(this.mLastKnownCurrentPage, f, true);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.mPrevText.measure(paramInt1, k);
    this.mCurrText.measure(paramInt1, k);
    this.mNextText.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.mCurrText.getMeasuredState() << 16));
      return;
      paramInt1 = this.mCurrText.getMeasuredHeight();
    }
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
    this.mNonPrimaryAlpha = ((int)(255.0F * paramFloat) & 0xFF);
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
    if (this.mPager != null)
    {
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      updateText(this.mPager.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    }
  }
  
  void updateText(int paramInt, PagerAdapter paramPagerAdapter)
  {
    Object localObject2 = null;
    int i;
    if (paramPagerAdapter != null)
    {
      i = paramPagerAdapter.getCount();
      this.mUpdatingText = true;
      if ((paramInt < 1) || (paramPagerAdapter == null)) {
        break label236;
      }
    }
    label236:
    for (Object localObject1 = paramPagerAdapter.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.mPrevText.setText((CharSequence)localObject1);
      TextView localTextView = this.mCurrText;
      if ((paramPagerAdapter != null) && (paramInt < i)) {}
      for (localObject1 = paramPagerAdapter.getPageTitle(paramInt);; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (paramPagerAdapter != null) {
            localObject1 = paramPagerAdapter.getPageTitle(paramInt + 1);
          }
        }
        this.mNextText.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.mPrevText.measure(i, j);
        this.mCurrText.measure(i, j);
        this.mNextText.measure(i, j);
        this.mLastKnownCurrentPage = paramInt;
        if (!this.mUpdatingPositions) {
          updateTextPositions(paramInt, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int m;
    int i4;
    int k;
    int i3;
    int n;
    int i;
    int i2;
    int i1;
    int j;
    int i5;
    int i7;
    int i6;
    int i8;
    if (paramInt != this.mLastKnownCurrentPage)
    {
      updateText(paramInt, this.mPager.getAdapter());
      this.mUpdatingPositions = true;
      m = this.mPrevText.getMeasuredWidth();
      i4 = this.mCurrText.getMeasuredWidth();
      k = this.mNextText.getMeasuredWidth();
      i3 = i4 / 2;
      n = getWidth();
      i = getHeight();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      paramInt = getPaddingTop();
      j = getPaddingBottom();
      i5 = i1 + i3;
      float f2 = 0.5F + paramFloat;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = f2 - 1.0F;
      }
      i3 = n - i5 - (int)(f1 * (n - (i2 + i3) - i5)) - i4 / 2;
      i4 = i3 + i4;
      i7 = this.mPrevText.getBaseline();
      i6 = this.mCurrText.getBaseline();
      i5 = this.mNextText.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.mPrevText.getMeasuredHeight();
      int i9 = this.mCurrText.getMeasuredHeight();
      int i10 = this.mNextText.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.mGravity & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = i6 + paramInt;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.mCurrText.layout(i3, i, i4, this.mCurrText.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.mScaledTextSpacing - m);
      this.mPrevText.layout(i, j, m + i, this.mPrevText.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.mScaledTextSpacing + i4);
      this.mNextText.layout(i, paramInt, i + k, this.mNextText.getMeasuredHeight() + paramInt);
      this.mLastKnownPositionOffset = paramFloat;
      this.mUpdatingPositions = false;
      return;
      if ((paramBoolean) || (paramFloat != this.mLastKnownPositionOffset)) {
        break;
      }
      return;
      paramInt = (i - paramInt - j - i8) / 2;
      j = paramInt + i7;
      i = i6 + paramInt;
      paramInt += i5;
      continue;
      paramInt = i - j - i8;
      j = paramInt + i7;
      i = i6 + paramInt;
      paramInt += i5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */