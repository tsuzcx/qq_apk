package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public abstract class ViewBase
  implements IView
{
  private static final String TAG = "ViewBase";
  public static final String TYPE = "type";
  protected float mAlpha = -1.0F;
  protected int mAutoDimDirection = 0;
  protected float mAutoDimX = 1.0F;
  protected float mAutoDimY = 1.0F;
  protected int mBackground;
  protected Bitmap mBackgroundImage = null;
  protected String mBackgroundImagePath;
  protected Paint mBackgroundPaint;
  protected int mBorderBottomLeftRadius = 0;
  protected int mBorderBottomRightRadius = 0;
  protected int mBorderColor = -16777216;
  protected Paint mBorderPaint;
  protected int mBorderRadius = 0;
  protected int mBorderTopLeftRadius = 0;
  protected int mBorderTopRightRadius = 0;
  protected int mBorderWidth = 0;
  protected String mClickEvnet;
  protected Rect mContentRect;
  protected VafContext mContext;
  protected int mDrawLeft;
  protected int mDrawTop;
  protected String mEventAttachedData;
  protected int mFlag;
  protected int mGravity;
  protected View mHolderView;
  protected boolean mIsDrawed;
  private boolean mIsSoftwareRender = false;
  private SimpleArrayMap<String, Object> mKeyedTags;
  protected Matrix mMatrixBG = null;
  protected int mMeasuredHeight;
  protected int mMeasuredWidth;
  protected int mMinHeight;
  protected int mMinWidth;
  protected String mName;
  private ViewBase.OnClickListener mOnClickListener;
  protected int mPaddingBottom;
  protected int mPaddingLeft;
  protected int mPaddingRight;
  protected int mPaddingTop;
  protected Paint mPaint;
  protected Layout.Params mParams;
  protected Layout mParent;
  protected Object mTag;
  protected int mUuid;
  protected String mViewType;
  protected int mVisibility = 0;
  
  public ViewBase(VafContext paramVafContext)
  {
    this.mContext = paramVafContext;
    this.mBackground = 0;
    this.mGravity = 9;
    this.mFlag = 0;
    this.mPaddingLeft = 0;
    this.mPaddingTop = 0;
    this.mPaddingRight = 0;
    this.mPaddingBottom = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.mName = "";
    this.mViewType = "";
    this.mUuid = 0;
  }
  
  private boolean changeVisibility()
  {
    View localView = getNativeView();
    int i;
    if (localView != null)
    {
      i = this.mVisibility;
      if (i != 0)
      {
        if (i != 4)
        {
          if (i != 8) {
            return true;
          }
          localView.setVisibility(8);
          return true;
        }
        localView.setVisibility(4);
        return true;
      }
      localView.setVisibility(0);
      return true;
    }
    if (isContainer())
    {
      i = this.mVisibility;
      if (i != 0)
      {
        if (i != 4)
        {
          if (i != 8) {
            return true;
          }
          this.mHolderView.setVisibility(8);
          return true;
        }
        this.mHolderView.setVisibility(4);
        return true;
      }
      this.mHolderView.setVisibility(0);
      return true;
    }
    return false;
  }
  
  private void setBorderRadiusArray(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(0);
    paramJSONArray = paramJSONArray.optString(1, "relative");
    if (localJSONArray != null)
    {
      double d1 = localJSONArray.optDouble(0, 0.0D);
      double d2 = localJSONArray.optDouble(1, 0.0D);
      double d3 = localJSONArray.optDouble(2, 0.0D);
      double d4 = localJSONArray.optDouble(3, 0.0D);
      if ("absolutely".equals(paramJSONArray))
      {
        this.mBorderTopLeftRadius = Utils.dp2px(d1);
        this.mBorderTopRightRadius = Utils.dp2px(d2);
        this.mBorderBottomRightRadius = Utils.dp2px(d3);
        this.mBorderBottomLeftRadius = Utils.dp2px(d4);
        return;
      }
      this.mBorderTopLeftRadius = Utils.rp2px(d1);
      this.mBorderTopRightRadius = Utils.rp2px(d2);
      this.mBorderBottomRightRadius = Utils.rp2px(d3);
      this.mBorderBottomLeftRadius = Utils.rp2px(d4);
    }
  }
  
  private void setTag(String paramString, Object paramObject)
  {
    if (this.mKeyedTags == null) {
      this.mKeyedTags = new SimpleArrayMap();
    }
    this.mKeyedTags.put(paramString, paramObject);
  }
  
  private boolean setValue(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return setValue(paramInt, (String)paramObject);
    }
    boolean bool = setAttribute(paramInt, paramObject);
    if (!bool)
    {
      Layout.Params localParams = this.mParams;
      if (localParams != null) {
        return localParams.setAttribute(paramInt, paramObject);
      }
    }
    return bool;
  }
  
  private boolean setValue(String paramString, Object paramObject)
  {
    return setValue(StringCommon.getStrIdFromString(paramString), paramObject);
  }
  
  public void bindDynamicValue(ViewBean paramViewBean)
  {
    clearDynamicData();
    if ((paramViewBean != null) && (paramViewBean.valueBean != null) && (paramViewBean.valueBean.dynamicValue != null))
    {
      Object localObject = paramViewBean.valueBean.dynamicValue.entrySet();
      if (!((Set)localObject).isEmpty())
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          setValue((String)localEntry.getKey(), localEntry.getValue());
        }
        if (this.mVisibility != 8) {
          onParseValueFinished();
        }
      }
      if (LogUtil.QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[viewBase] bind dynamicValue ");
        ((StringBuilder)localObject).append(paramViewBean.valueBean.dynamicValue);
        ((StringBuilder)localObject).append(" viewId = ");
        ((StringBuilder)localObject).append(paramViewBean.viewId);
        LogUtil.QLog.d("ViewBase", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void bindNormalValue(ViewBean paramViewBean)
  {
    if ((paramViewBean != null) && (paramViewBean.valueBean != null) && (paramViewBean.valueBean.normalValue != null))
    {
      Object localObject = paramViewBean.valueBean.normalValue.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        setValue((String)localEntry.getKey(), localEntry.getValue());
      }
      if (this.mVisibility != 8) {
        onParseValueFinished();
      }
      if (LogUtil.QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[viewBase] bind normalValue ");
        ((StringBuilder)localObject).append(paramViewBean.valueBean.normalValue);
        ((StringBuilder)localObject).append(" viewId = ");
        ((StringBuilder)localObject).append(paramViewBean.viewId);
        LogUtil.QLog.d("ViewBase", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @Deprecated
  public final boolean canHandleEvent()
  {
    return false;
  }
  
  public void clearDynamicData() {}
  
  public void comDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.mDrawLeft, this.mDrawTop);
    onComDraw(paramCanvas);
    paramCanvas.restore();
    this.mIsDrawed = true;
  }
  
  public final void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDrawLeft = paramInt1;
    this.mDrawTop = paramInt2;
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void destroy()
  {
    this.mContext = null;
  }
  
  public ViewBase findViewBaseByName(String paramString)
  {
    if (TextUtils.equals(this.mName, paramString)) {
      return this;
    }
    return null;
  }
  
  public int getAlign()
  {
    return this.mGravity;
  }
  
  public int getBackground()
  {
    return this.mBackground;
  }
  
  public Paint getBackgroundPaint()
  {
    return this.mBackgroundPaint;
  }
  
  public int getBorderRadius()
  {
    return this.mBorderRadius;
  }
  
  public int getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public ViewBase getChild(int paramInt)
  {
    return null;
  }
  
  public String getClickEvnet()
  {
    return this.mClickEvnet;
  }
  
  public Layout.Params getComLayoutParams()
  {
    return this.mParams;
  }
  
  public int getComMeasuredHeight()
  {
    return this.mMeasuredHeight;
  }
  
  public final int getComMeasuredHeightWithMargin()
  {
    return getComMeasuredHeight() + this.mParams.mLayoutMarginTop + this.mParams.mLayoutMarginBottom;
  }
  
  public int getComMeasuredWidth()
  {
    return this.mMeasuredWidth;
  }
  
  public final int getComMeasuredWidthWithMargin()
  {
    return getComMeasuredWidth() + this.mParams.mLayoutMarginLeft + this.mParams.mLayoutMarginRight;
  }
  
  public final int getComPaddingBottom()
  {
    return this.mPaddingBottom;
  }
  
  public final int getComPaddingLeft()
  {
    return this.mPaddingLeft;
  }
  
  public final int getComPaddingRight()
  {
    return this.mPaddingRight;
  }
  
  public final int getComPaddingTop()
  {
    return this.mPaddingTop;
  }
  
  public final int getDrawLeft()
  {
    if ((this.mDrawLeft == 0) && (getNativeView() != null)) {
      this.mDrawLeft = getNativeView().getLeft();
    }
    return this.mDrawLeft;
  }
  
  public final int getDrawTop()
  {
    if ((this.mDrawTop == 0) && (getNativeView() != null)) {
      this.mDrawTop = getNativeView().getTop();
    }
    return this.mDrawTop;
  }
  
  public String getEventAttachedData()
  {
    return this.mEventAttachedData;
  }
  
  public int getHeight()
  {
    return this.mMeasuredHeight;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public View getNativeView()
  {
    return null;
  }
  
  public ViewBase getParent()
  {
    Layout localLayout = this.mParent;
    Object localObject = localLayout;
    if (localLayout == null) {
      localObject = ((IContainer)this.mHolderView.getParent()).getVirtualView();
    }
    return localObject;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public Object getTag(String paramString)
  {
    SimpleArrayMap localSimpleArrayMap = this.mKeyedTags;
    if (localSimpleArrayMap != null) {
      return localSimpleArrayMap.get(paramString);
    }
    return null;
  }
  
  public int getUuid()
  {
    return this.mUuid;
  }
  
  public String getViewId()
  {
    return this.mName;
  }
  
  public String getViewType()
  {
    return this.mViewType;
  }
  
  public int getVisibility()
  {
    return this.mVisibility;
  }
  
  public int getWidth()
  {
    return this.mMeasuredWidth;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public final boolean isClickable()
  {
    return (this.mFlag & 0x20) != 0;
  }
  
  public boolean isContainer()
  {
    return false;
  }
  
  public boolean isGone()
  {
    return this.mVisibility == 8;
  }
  
  public boolean isRoot()
  {
    return this.mParent == null;
  }
  
  public final boolean isVisible()
  {
    return this.mVisibility == 0;
  }
  
  public final void measureComponent(int paramInt1, int paramInt2)
  {
    int k = this.mAutoDimDirection;
    int i = paramInt1;
    int j = paramInt2;
    if (k > 0) {
      if (k != 1)
      {
        if (k != 2)
        {
          i = paramInt1;
          j = paramInt2;
        }
        else
        {
          i = paramInt1;
          j = paramInt2;
          if (1073741824 == View.MeasureSpec.getMode(paramInt2))
          {
            i = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.mAutoDimX / this.mAutoDimY), 1073741824);
            j = paramInt2;
          }
        }
      }
      else
      {
        i = paramInt1;
        j = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt1))
        {
          j = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.mAutoDimY / this.mAutoDimX), 1073741824);
          i = paramInt1;
        }
      }
    }
    onComMeasure(i, j);
  }
  
  protected boolean onClick()
  {
    ViewBase.OnClickListener localOnClickListener = this.mOnClickListener;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      return true;
    }
    return false;
  }
  
  protected void onComDraw(Canvas paramCanvas)
  {
    if (getNativeView() == null)
    {
      if (this.mBackground != 0)
      {
        VirtualViewUtils.drawBackground(paramCanvas, this.mBackgroundPaint, this.mMeasuredWidth, this.mMeasuredHeight, this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        return;
      }
      Bitmap localBitmap = this.mBackgroundImage;
      if (localBitmap != null)
      {
        this.mMatrixBG.setScale(this.mMeasuredWidth / localBitmap.getWidth(), this.mMeasuredHeight / this.mBackgroundImage.getHeight());
        paramCanvas.drawBitmap(this.mBackgroundImage, this.mMatrixBG, this.mBackgroundPaint);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    View localView = getNativeView();
    if ((localView != null) && (softwareRender())) {
      localView.setLayerType(1, null);
    }
    if (localView != null)
    {
      float f = this.mAlpha;
      if ((f >= 0.0F) && (f <= 1.001F)) {
        localView.setAlpha(f);
      }
    }
  }
  
  public void refresh()
  {
    int i = this.mDrawLeft;
    int j = this.mDrawTop;
    refresh(i, j, this.mMeasuredWidth + i, this.mMeasuredHeight + j);
  }
  
  public void refresh(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.mHolderView;
    if (localView != null)
    {
      localView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    LogUtil.QLog.d("ViewBase", 2, "refresh holdView is null");
  }
  
  public void reset()
  {
    this.mContentRect = null;
    this.mIsDrawed = false;
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 63)
    {
      if (paramInt != 72) {
        return false;
      }
      IProteusDtReporter localIProteusDtReporter = Proteus.getInstance().getDtReporter();
      if (localIProteusDtReporter != null)
      {
        String str = (String)JsonUtils.getObjectFromJsonArray(paramObject, 0);
        if (TextUtils.isEmpty(str))
        {
          if (LogUtil.QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("setDtElement fail, id can't empty! viewID: ");
            paramObject.append(getViewId());
            LogUtil.QLog.i("ViewBase", 2, paramObject.toString());
          }
        }
        else
        {
          paramObject = JsonUtils.getObjectFromJsonArray(paramObject, 1);
          localIProteusDtReporter.setDtElementIdWithParams(getNativeView(), str, JsonUtils.covertJsonObjectToMap(paramObject));
        }
      }
    }
    else if ((paramObject instanceof JSONArray))
    {
      setBorderRadiusArray((JSONArray)paramObject);
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 53)
    {
      if (paramInt != 62)
      {
        if (paramInt != 65)
        {
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return false;
              case 38: 
                this.mEventAttachedData = paramString;
                return true;
              case 37: 
                if ("VISIBLE".equals(paramString))
                {
                  setVisibility(0);
                  return true;
                }
                setVisibility(8);
                return true;
              }
              this.mClickEvnet = paramString;
              return true;
            case 17: 
              this.mBorderRadius = Utils.rp2px(Double.valueOf(paramString).doubleValue());
              paramInt = this.mBorderRadius;
              this.mBorderTopLeftRadius = paramInt;
              this.mBorderTopRightRadius = paramInt;
              this.mBorderBottomLeftRadius = paramInt;
              this.mBorderBottomRightRadius = paramInt;
              return true;
            case 16: 
              this.mBorderColor = Utils.parseColor(paramString);
              return true;
            case 15: 
              this.mBorderWidth = Utils.rp2px(Double.valueOf(paramString).doubleValue());
              return true;
            }
            setBackgroundColor(Utils.parseColor(paramString));
            return true;
          case 11: 
            this.mPaddingBottom = Utils.rp2px(Double.valueOf(paramString).doubleValue());
            return true;
          case 10: 
            this.mPaddingTop = Utils.rp2px(Double.valueOf(paramString).doubleValue());
            return true;
          case 9: 
            this.mPaddingRight = Utils.rp2px(Double.valueOf(paramString).doubleValue());
            return true;
          case 8: 
            this.mPaddingLeft = Utils.rp2px(Double.valueOf(paramString).doubleValue());
            return true;
          }
          paramInt = Utils.rp2px(Double.valueOf(paramString).doubleValue());
          this.mPaddingBottom = paramInt;
          this.mPaddingTop = paramInt;
          this.mPaddingRight = paramInt;
          this.mPaddingLeft = paramInt;
          return true;
        }
        this.mAlpha = Utils.toFloat(paramString).floatValue();
        return true;
      }
      if ("YES".equals(paramString))
      {
        this.mIsSoftwareRender = true;
        return true;
      }
      this.mIsSoftwareRender = false;
    }
    return true;
  }
  
  public void setBackground(int paramInt)
  {
    this.mBackground = paramInt;
    refresh();
  }
  
  protected void setBackgroundColor(int paramInt)
  {
    this.mBackground = paramInt;
    View localView = getNativeView();
    if (localView != null)
    {
      localView.setBackgroundColor(paramInt);
      return;
    }
    if (this.mBackgroundPaint == null) {
      this.mBackgroundPaint = new Paint();
    }
    this.mBackgroundPaint.setColor(this.mBackground);
  }
  
  protected void setBackgroundImage(Bitmap paramBitmap)
  {
    this.mBackgroundImage = paramBitmap;
    refresh();
  }
  
  public void setBackgroundImage(String paramString)
  {
    this.mBackgroundImagePath = paramString;
    this.mBackgroundImage = null;
    if (this.mBackgroundPaint == null) {
      this.mBackgroundPaint = new Paint();
    }
    if (this.mMatrixBG == null) {
      this.mMatrixBG = new Matrix();
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    if (this.mBorderPaint == null)
    {
      this.mBorderPaint = new Paint();
      this.mBorderPaint.setStyle(Paint.Style.STROKE);
      this.mBorderPaint.setAntiAlias(true);
    }
    this.mBorderPaint.setColor(this.mBorderColor);
    refresh();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
    if (this.mBorderPaint == null)
    {
      this.mBorderPaint = new Paint();
      this.mBorderPaint.setStyle(Paint.Style.STROKE);
      this.mBorderPaint.setAntiAlias(true);
    }
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    refresh();
  }
  
  public void setClickable(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mFlag |= 0x20;
    } else {
      this.mFlag &= 0xFFFFFFDF;
    }
    if (getNativeView() != null)
    {
      getNativeView().setFocusable(false);
      getNativeView().setClickable(paramBoolean);
    }
  }
  
  public final void setComLayoutParams(Layout.Params paramParams)
  {
    this.mParams = paramParams;
  }
  
  protected final void setComMeasuredDimension(int paramInt1, int paramInt2)
  {
    this.mMeasuredWidth = paramInt1;
    this.mMeasuredHeight = paramInt2;
  }
  
  public final void setHoldView(View paramView)
  {
    this.mHolderView = paramView;
    if (softwareRender()) {
      paramView.setLayerType(1, null);
    }
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setOnClickListener(ViewBase.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      setClickable(false);
      this.mOnClickListener = null;
      return;
    }
    this.mOnClickListener = paramOnClickListener;
    setClickable(true);
    if (getNativeView() != null) {
      getNativeView().setOnClickListener(new ViewBase.1(this));
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public final boolean setValue(int paramInt, String paramString)
  {
    boolean bool2 = setAttribute(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      Layout.Params localParams = this.mParams;
      bool1 = bool2;
      if (localParams != null)
      {
        bool2 = localParams.setAttribute(paramInt, paramString);
        bool1 = bool2;
        if (bool2)
        {
          paramString = getNativeView();
          bool1 = bool2;
          if (paramString != null)
          {
            paramString.requestLayout();
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public void setViewType(String paramString)
  {
    this.mViewType = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.mVisibility != paramInt)
    {
      this.mVisibility = paramInt;
      if (!changeVisibility()) {
        refresh();
      }
    }
  }
  
  public boolean shouldDraw()
  {
    return this.mVisibility == 0;
  }
  
  public boolean softwareRender()
  {
    return this.mIsSoftwareRender;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
 * JD-Core Version:    0.7.0.1
 */