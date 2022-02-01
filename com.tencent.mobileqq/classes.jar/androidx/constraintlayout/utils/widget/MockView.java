package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.constraintlayout.widget.R.styleable;

public class MockView
  extends View
{
  private int mDiagonalsColor = Color.argb(255, 0, 0, 0);
  private boolean mDrawDiagonals = true;
  private boolean mDrawLabel = true;
  private int mMargin = 4;
  private Paint mPaintDiagonals = new Paint();
  private Paint mPaintText = new Paint();
  private Paint mPaintTextBackground = new Paint();
  protected String mText = null;
  private int mTextBackgroundColor = Color.argb(255, 50, 50, 50);
  private Rect mTextBounds = new Rect();
  private int mTextColor = Color.argb(255, 200, 200, 200);
  
  public MockView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public MockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public MockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MockView);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.MockView_mock_label) {
          this.mText = paramAttributeSet.getString(k);
        } else if (k == R.styleable.MockView_mock_showDiagonals) {
          this.mDrawDiagonals = paramAttributeSet.getBoolean(k, this.mDrawDiagonals);
        } else if (k == R.styleable.MockView_mock_diagonalsColor) {
          this.mDiagonalsColor = paramAttributeSet.getColor(k, this.mDiagonalsColor);
        } else if (k == R.styleable.MockView_mock_labelBackgroundColor) {
          this.mTextBackgroundColor = paramAttributeSet.getColor(k, this.mTextBackgroundColor);
        } else if (k == R.styleable.MockView_mock_labelColor) {
          this.mTextColor = paramAttributeSet.getColor(k, this.mTextColor);
        } else if (k == R.styleable.MockView_mock_showLabel) {
          this.mDrawLabel = paramAttributeSet.getBoolean(k, this.mDrawLabel);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    if (this.mText == null) {}
    try
    {
      this.mText = paramContext.getResources().getResourceEntryName(getId());
      label210:
      this.mPaintDiagonals.setColor(this.mDiagonalsColor);
      this.mPaintDiagonals.setAntiAlias(true);
      this.mPaintText.setColor(this.mTextColor);
      this.mPaintText.setAntiAlias(true);
      this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
      this.mMargin = Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0F));
      return;
    }
    catch (Exception paramContext)
    {
      break label210;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getWidth();
    int k = getHeight();
    int j = m;
    int i = k;
    float f1;
    float f2;
    if (this.mDrawDiagonals)
    {
      j = m - 1;
      i = k - 1;
      f1 = j;
      f2 = i;
      paramCanvas.drawLine(0.0F, 0.0F, f1, f2, this.mPaintDiagonals);
      paramCanvas.drawLine(0.0F, f2, f1, 0.0F, this.mPaintDiagonals);
      paramCanvas.drawLine(0.0F, 0.0F, f1, 0.0F, this.mPaintDiagonals);
      paramCanvas.drawLine(f1, 0.0F, f1, f2, this.mPaintDiagonals);
      paramCanvas.drawLine(f1, f2, 0.0F, f2, this.mPaintDiagonals);
      paramCanvas.drawLine(0.0F, f2, 0.0F, 0.0F, this.mPaintDiagonals);
    }
    Object localObject = this.mText;
    if ((localObject != null) && (this.mDrawLabel))
    {
      this.mPaintText.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.mTextBounds);
      f1 = (j - this.mTextBounds.width()) / 2.0F;
      f2 = (i - this.mTextBounds.height()) / 2.0F + this.mTextBounds.height();
      this.mTextBounds.offset((int)f1, (int)f2);
      localObject = this.mTextBounds;
      ((Rect)localObject).set(((Rect)localObject).left - this.mMargin, this.mTextBounds.top - this.mMargin, this.mTextBounds.right + this.mMargin, this.mTextBounds.bottom + this.mMargin);
      paramCanvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
      paramCanvas.drawText(this.mText, f1, f2, this.mPaintText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.MockView
 * JD-Core Version:    0.7.0.1
 */