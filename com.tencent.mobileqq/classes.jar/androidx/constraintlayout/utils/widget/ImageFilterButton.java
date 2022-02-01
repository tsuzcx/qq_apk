package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R.styleable;

public class ImageFilterButton
  extends AppCompatImageButton
{
  private float mCrossfade = 0.0F;
  private ImageFilterView.ImageMatrix mImageMatrix = new ImageFilterView.ImageMatrix();
  LayerDrawable mLayer;
  Drawable[] mLayers;
  private boolean mOverlay = true;
  private Path mPath;
  RectF mRect;
  private float mRound = (0.0F / 0.0F);
  private float mRoundPercent = 0.0F;
  ViewOutlineProvider mViewOutlineProvider;
  
  public ImageFilterButton(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public ImageFilterButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public ImageFilterButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setPadding(0, 0, 0, 0);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ImageFilterView);
      int j = paramAttributeSet.getIndexCount();
      paramContext = paramAttributeSet.getDrawable(R.styleable.ImageFilterView_altSrc);
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ImageFilterView_crossfade) {
          this.mCrossfade = paramAttributeSet.getFloat(k, 0.0F);
        } else if (k == R.styleable.ImageFilterView_warmth) {
          setWarmth(paramAttributeSet.getFloat(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_saturation) {
          setSaturation(paramAttributeSet.getFloat(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_contrast) {
          setContrast(paramAttributeSet.getFloat(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_round) {
          setRound(paramAttributeSet.getDimension(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_roundPercent) {
          setRoundPercent(paramAttributeSet.getFloat(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_overlay) {
          setOverlay(paramAttributeSet.getBoolean(k, this.mOverlay));
        }
        i += 1;
      }
      paramAttributeSet.recycle();
      if (paramContext != null)
      {
        this.mLayers = new Drawable[2];
        this.mLayers[0] = getDrawable();
        paramAttributeSet = this.mLayers;
        paramAttributeSet[1] = paramContext;
        this.mLayer = new LayerDrawable(paramAttributeSet);
        this.mLayer.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0F));
        super.setImageDrawable(this.mLayer);
      }
    }
  }
  
  private void setOverlay(boolean paramBoolean)
  {
    this.mOverlay = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i;
    if ((Build.VERSION.SDK_INT < 21) && (this.mRound != 0.0F) && (this.mPath != null))
    {
      i = 1;
      paramCanvas.save();
      paramCanvas.clipPath(this.mPath);
    }
    else
    {
      i = 0;
    }
    super.draw(paramCanvas);
    if (i != 0) {
      paramCanvas.restore();
    }
  }
  
  public float getContrast()
  {
    return this.mImageMatrix.mContrast;
  }
  
  public float getCrossfade()
  {
    return this.mCrossfade;
  }
  
  public float getRound()
  {
    return this.mRound;
  }
  
  public float getRoundPercent()
  {
    return this.mRoundPercent;
  }
  
  public float getSaturation()
  {
    return this.mImageMatrix.mSaturation;
  }
  
  public float getWarmth()
  {
    return this.mImageMatrix.mWarmth;
  }
  
  public void setBrightness(float paramFloat)
  {
    ImageFilterView.ImageMatrix localImageMatrix = this.mImageMatrix;
    localImageMatrix.mBrightness = paramFloat;
    localImageMatrix.updateMatrix(this);
  }
  
  public void setContrast(float paramFloat)
  {
    ImageFilterView.ImageMatrix localImageMatrix = this.mImageMatrix;
    localImageMatrix.mContrast = paramFloat;
    localImageMatrix.updateMatrix(this);
  }
  
  public void setCrossfade(float paramFloat)
  {
    this.mCrossfade = paramFloat;
    if (this.mLayers != null)
    {
      if (!this.mOverlay) {
        this.mLayer.getDrawable(0).setAlpha((int)((1.0F - this.mCrossfade) * 255.0F));
      }
      this.mLayer.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0F));
      super.setImageDrawable(this.mLayer);
    }
  }
  
  @RequiresApi(21)
  public void setRound(float paramFloat)
  {
    if (Float.isNaN(paramFloat))
    {
      this.mRound = paramFloat;
      paramFloat = this.mRoundPercent;
      this.mRoundPercent = -1.0F;
      setRoundPercent(paramFloat);
      return;
    }
    int i;
    if (this.mRound != paramFloat) {
      i = 1;
    } else {
      i = 0;
    }
    this.mRound = paramFloat;
    if (this.mRound != 0.0F)
    {
      if (this.mPath == null) {
        this.mPath = new Path();
      }
      if (this.mRect == null) {
        this.mRect = new RectF();
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.mViewOutlineProvider == null)
        {
          this.mViewOutlineProvider = new ImageFilterButton.2(this);
          setOutlineProvider(this.mViewOutlineProvider);
        }
        setClipToOutline(true);
      }
      int j = getWidth();
      int k = getHeight();
      this.mRect.set(0.0F, 0.0F, j, k);
      this.mPath.reset();
      Path localPath = this.mPath;
      RectF localRectF = this.mRect;
      paramFloat = this.mRound;
      localPath.addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    }
    else if (Build.VERSION.SDK_INT >= 21)
    {
      setClipToOutline(false);
    }
    if ((i != 0) && (Build.VERSION.SDK_INT >= 21)) {
      invalidateOutline();
    }
  }
  
  @RequiresApi(21)
  public void setRoundPercent(float paramFloat)
  {
    int i;
    if (this.mRoundPercent != paramFloat) {
      i = 1;
    } else {
      i = 0;
    }
    this.mRoundPercent = paramFloat;
    if (this.mRoundPercent != 0.0F)
    {
      if (this.mPath == null) {
        this.mPath = new Path();
      }
      if (this.mRect == null) {
        this.mRect = new RectF();
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.mViewOutlineProvider == null)
        {
          this.mViewOutlineProvider = new ImageFilterButton.1(this);
          setOutlineProvider(this.mViewOutlineProvider);
        }
        setClipToOutline(true);
      }
      int j = getWidth();
      int k = getHeight();
      paramFloat = Math.min(j, k) * this.mRoundPercent / 2.0F;
      this.mRect.set(0.0F, 0.0F, j, k);
      this.mPath.reset();
      this.mPath.addRoundRect(this.mRect, paramFloat, paramFloat, Path.Direction.CW);
    }
    else if (Build.VERSION.SDK_INT >= 21)
    {
      setClipToOutline(false);
    }
    if ((i != 0) && (Build.VERSION.SDK_INT >= 21)) {
      invalidateOutline();
    }
  }
  
  public void setSaturation(float paramFloat)
  {
    ImageFilterView.ImageMatrix localImageMatrix = this.mImageMatrix;
    localImageMatrix.mSaturation = paramFloat;
    localImageMatrix.updateMatrix(this);
  }
  
  public void setWarmth(float paramFloat)
  {
    ImageFilterView.ImageMatrix localImageMatrix = this.mImageMatrix;
    localImageMatrix.mWarmth = paramFloat;
    localImageMatrix.updateMatrix(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterButton
 * JD-Core Version:    0.7.0.1
 */