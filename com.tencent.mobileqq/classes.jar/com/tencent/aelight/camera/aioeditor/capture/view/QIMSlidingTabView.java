package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QIMSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private static final int DEFAULT_ROUNDED_SIZE = 2;
  public static final String KEY_CHECKED_IMAGE_BG_ID = "checked_image_bg_id";
  public static final String KEY_NOMAL_IMAGE_BG_ID = "normal_image_bg_id";
  private static final String TAG = "SlidingTabView";
  private boolean mCheckX = false;
  private int mCurrentIndex = 0;
  private int mIndicatorColor = -16776961;
  private int mIndicatorHeight = 4;
  private int mIndicatorPadding = 0;
  private int mIndicatorStartX = 0;
  private LinearLayout.LayoutParams mLayoutParam = null;
  private QIMSlidingTabView.IOnTabCheckListener mListener;
  private Paint mPaint = null;
  private int mPrevIndex = 0;
  private LinearLayout mRootLayout = null;
  private int mScrollOffset = 52;
  private ArrayList<View> mTabItemList = new ArrayList(5);
  private int mTabPadding = 15;
  private int mTabStartEndMargin = 0;
  private int mTabTextSize = 14;
  private int mTextColorChecked = -16777216;
  private int mTextColorNormal = -7829368;
  private int mUnderlineColor = -3355444;
  private int mUnderlineHeight = 1;
  private int roundedSize = 2;
  private int roundedSizeDP = 2;
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext, paramAttributeSet);
  }
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext, paramAttributeSet);
  }
  
  private int addTabItem(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    paramView.setOnClickListener(new QIMSlidingTabView.1(this, paramInt));
    this.mTabItemList.add(paramInt, paramView);
    this.mRootLayout.addView(paramView, paramInt);
    return 0;
  }
  
  @TargetApi(11)
  private void doIndicatorAnimation()
  {
    int i = this.mPrevIndex;
    int j = this.mCurrentIndex;
    if (i != j)
    {
      Object localObject = this.mRootLayout.getChildAt(i);
      View localView = this.mRootLayout.getChildAt(this.mCurrentIndex);
      if ((localObject != null) && (localView != null))
      {
        i = ((View)localObject).getLeft();
        j = localView.getLeft();
        if ((i == 0) && (j == 0))
        {
          this.mCheckX = true;
          return;
        }
        this.mCheckX = false;
        localObject = ValueAnimator.ofInt(new int[] { i, j });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QIMSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.mIndicatorStartX = this.mRootLayout.getChildAt(j).getLeft();
      this.mCheckX = true;
      invalidate();
    }
  }
  
  private void initUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mLayoutParam = new LinearLayout.LayoutParams(-2, -1);
    this.mRootLayout = new LinearLayout(paramContext);
    this.mRootLayout.setOrientation(0);
    this.mRootLayout.setLayoutParams(this.mLayoutParam);
    addView(this.mRootLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mTabStartEndMargin = ((int)TypedValue.applyDimension(1, this.mTabStartEndMargin, localDisplayMetrics));
    this.mScrollOffset = ((int)TypedValue.applyDimension(1, this.mScrollOffset, localDisplayMetrics));
    this.mIndicatorHeight = ((int)TypedValue.applyDimension(1, this.mIndicatorHeight, localDisplayMetrics));
    this.mUnderlineHeight = ((int)TypedValue.applyDimension(1, this.mUnderlineHeight, localDisplayMetrics));
    this.mTabPadding = ((int)TypedValue.applyDimension(1, this.mTabPadding, localDisplayMetrics));
    this.mTabTextSize = ((int)TypedValue.applyDimension(1, this.mTabTextSize, localDisplayMetrics));
    this.mIndicatorPadding = ((int)TypedValue.applyDimension(1, this.mIndicatorPadding, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.mTabStartEndMargin = paramContext.getDimensionPixelSize(4, this.mTabStartEndMargin);
    this.mTabPadding = paramContext.getDimensionPixelSize(3, this.mTabPadding);
    this.mIndicatorColor = paramContext.getColor(0, this.mIndicatorColor);
    this.mIndicatorHeight = paramContext.getDimensionPixelSize(1, this.mIndicatorHeight);
    this.mTextColorNormal = paramContext.getColor(6, this.mTextColorNormal);
    this.mTextColorChecked = paramContext.getColor(5, this.mTextColorChecked);
    this.mUnderlineColor = paramContext.getColor(8, this.mUnderlineColor);
    this.mUnderlineHeight = paramContext.getDimensionPixelSize(9, this.mUnderlineHeight);
    this.mTabTextSize = paramContext.getDimensionPixelSize(7, this.mTabTextSize);
    this.mIndicatorPadding = paramContext.getDimensionPixelSize(2, this.mIndicatorPadding);
    paramContext.recycle();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.mIndicatorColor);
    this.mPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.roundedSize = ScreenUtil.dip2px(this.roundedSizeDP);
  }
  
  private void resetTabItemLayoutParams()
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mRootLayout.getChildAt(i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (i == 0) {
        localLayoutParams.setMargins(this.mTabStartEndMargin, 0, 0, 0);
      } else if (i == j - 1) {
        localLayoutParams.setMargins(0, 0, this.mTabStartEndMargin, 0);
      }
      localView.setLayoutParams(localLayoutParams);
      i += 1;
    }
  }
  
  private void scrollToTab(int paramInt)
  {
    View localView = this.mRootLayout.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i = this.mTabPadding * 4;
      int j = localView.getRight() - paramInt - getWidth() + i;
      if (j > 0)
      {
        smoothScrollBy(j, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  private void setTabChangeBackgroud(int paramInt)
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.mRootLayout.getChildAt(i);
      Object localObject1 = this.mTabItemList;
      if ((localObject1 != null) && (i < ((ArrayList)localObject1).size()))
      {
        localObject1 = (View)this.mTabItemList.get(i);
        if (i == paramInt)
        {
          if ((localObject1 instanceof ImageView))
          {
            localObject2 = (Bundle)((View)localObject1).getTag();
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("checked_image_bg_id", 2130846887));
            }
          }
          else if ((localObject1 instanceof RedDotTextView))
          {
            localObject1 = (RedDotTextView)localObject2;
            ((RedDotTextView)localObject1).setTextColor(this.mTextColorChecked);
            ((RedDotTextView)localObject1).a(false);
          }
          else if ((localObject1 instanceof TextView))
          {
            ((TextView)localObject2).setTextColor(this.mTextColorChecked);
          }
          else if ((localObject1 instanceof QIMSlidingItemView))
          {
            ((QIMSlidingItemView)localObject2).a(this.mTextColorChecked, true);
          }
        }
        else if ((localObject1 instanceof ImageView))
        {
          localObject2 = (Bundle)((View)localObject1).getTag();
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("normal_image_bg_id", 2130846886));
          }
        }
        else if ((localObject1 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject2).setTextColor(this.mTextColorNormal);
        }
        else if ((localObject1 instanceof TextView))
        {
          ((TextView)localObject2).setTextColor(this.mTextColorNormal);
        }
        else if ((localObject1 instanceof QIMSlidingItemView))
        {
          ((QIMSlidingItemView)localObject2).a(this.mTextColorNormal, false);
        }
      }
      i += 1;
    }
  }
  
  public int getTabCount()
  {
    return this.mTabItemList.size();
  }
  
  public ArrayList<View> getmTabItemList()
  {
    return this.mTabItemList;
  }
  
  public void initTabItemsWithIconString(ArrayList<QIMSlidingItemView.SlidingItemData> paramArrayList)
  {
    this.mRootLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject;
      if (((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setText(((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i)).jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setTextSize(0, this.mTabTextSize);
        int j = this.mTabPadding;
        ((TextView)localObject).setPadding(j, 0, j, 0);
        addTabItem(i, (View)localObject);
      }
      else
      {
        localObject = new QIMSlidingItemView(getContext());
        ((QIMSlidingItemView)localObject).a(this.mTabTextSize, this.mTabPadding);
        ((QIMSlidingItemView)localObject).setData((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i));
        addTabItem(i, (View)localObject);
      }
      i += 1;
    }
    resetTabItemLayoutParams();
    onTabChecked(0);
  }
  
  public void initTabItemsWithRedDot(ArrayList<QIMSlidingTabView.TabIcon> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.mTabItemList.clear();
      this.mRootLayout.removeAllViews();
      int i = 0;
      while (i < paramArrayList.size())
      {
        RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
        localRedDotTextView.setText(((QIMSlidingTabView.TabIcon)paramArrayList.get(i)).jdField_a_of_type_JavaLangString);
        localRedDotTextView.setGravity(17);
        localRedDotTextView.setSingleLine();
        localRedDotTextView.setTextSize(0, this.mTabTextSize);
        int j = this.mTabPadding;
        localRedDotTextView.setPadding(j, 0, j, 0);
        localRedDotTextView.a(((QIMSlidingTabView.TabIcon)paramArrayList.get(i)).jdField_a_of_type_Boolean);
        String str = ((QIMSlidingTabView.TabIcon)paramArrayList.get(i)).b;
        if (!TextUtils.isEmpty(str)) {
          localRedDotTextView.setContentDescription(str);
        }
        addTabItem(i, localRedDotTextView);
        i += 1;
      }
      resetTabItemLayoutParams();
      return;
    }
    this.mRootLayout.removeAllViews();
  }
  
  public void initTabItemsWithString(ArrayList<String> paramArrayList)
  {
    this.mRootLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setText((CharSequence)paramArrayList.get(i));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(0, this.mTabTextSize);
      int j = this.mTabPadding;
      localTextView.setPadding(j, 0, j, 0);
      addTabItem(i, localTextView);
      i += 1;
    }
    resetTabItemLayoutParams();
    onTabChecked(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    Object localObject = this.mRootLayout.getChildAt(this.mCurrentIndex);
    if (localObject != null)
    {
      if (this.mCheckX)
      {
        this.mIndicatorStartX = ((View)localObject).getLeft();
        scrollToTab(this.mCurrentIndex);
        this.mCheckX = false;
      }
      if ((this.mCurrentIndex == 0) && (this.mIndicatorStartX < ((View)localObject).getLeft())) {
        this.mIndicatorStartX = ((View)localObject).getLeft();
      }
      this.mPaint.setColor(this.mIndicatorColor);
      int j = this.mIndicatorStartX;
      localObject = new RectF(this.mIndicatorPadding + j, i - this.mIndicatorHeight, j + ((View)localObject).getWidth() - this.mIndicatorPadding, i);
      i = this.roundedSize;
      paramCanvas.drawRoundRect((RectF)localObject, i, i, this.mPaint);
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("selected index: ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("SlidingTabView", ((StringBuilder)localObject).toString());
    if (paramInt >= 0)
    {
      if (paramInt >= this.mTabItemList.size()) {
        return;
      }
      this.mCurrentIndex = paramInt;
      setTabChangeBackgroud(paramInt);
      scrollToTab(paramInt);
      doIndicatorAnimation();
      localObject = this.mListener;
      if (localObject != null) {
        ((QIMSlidingTabView.IOnTabCheckListener)localObject).onTabChecked(paramInt);
      }
      this.mPrevIndex = this.mCurrentIndex;
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.mIndicatorColor = paramInt;
    this.mPaint.setColor(this.mIndicatorColor);
    invalidate();
  }
  
  public void setTabCheckListener(QIMSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.mListener = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView
 * JD-Core Version:    0.7.0.1
 */