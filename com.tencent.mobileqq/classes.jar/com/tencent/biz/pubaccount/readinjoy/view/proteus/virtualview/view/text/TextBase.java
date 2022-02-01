package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import org.json.JSONArray;

public abstract class TextBase
  extends ViewBase
{
  private static final String TAG = "TextBase";
  private static final String TEXT_ALIGNMENT_CENTER = "1";
  private static final String TEXT_ALIGNMENT_LEFT = "0";
  private static final String TEXT_ALIGNMENT_RIGHT = "2";
  protected String drawableLeftPath;
  protected int mEllipsize = TextUtils.TruncateAt.END.ordinal();
  protected Boolean mEnableClickSpan;
  protected Boolean mEnableMarquee;
  protected float mFontSizeRatio = 1.0F;
  protected float mLineSpaceExtra = 0.0F;
  protected float mLineSpaceMultipiler = 1.0F;
  protected int mLines = -1;
  protected int mMaxLines = -1;
  protected int mMaxWidth;
  protected CharSequence mText = "";
  protected int mTextColor = -16777216;
  protected int mTextSize = Utils.dp2px(20.0D);
  protected int mTextStyle = 0;
  protected Typeface mTypeface;
  protected String mTypefacePath;
  
  public TextBase(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mGravity = 32;
  }
  
  private void parseFonSize(int paramInt, String paramString)
  {
    Object localObject = Utils.toDouble(paramString);
    if (localObject != null)
    {
      this.mTextSize = Utils.dp2px(((Double)localObject).doubleValue());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(paramString);
    LogUtil.QLog.d("TextBase", 2, ((StringBuilder)localObject).toString());
  }
  
  private void parseTextSizeRatio(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1)) {
        parseFonSize(paramInt, paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        this.mFontSizeRatio = Float.parseFloat(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("parseTextSizeRatio error!msg=");
      paramString2.append(paramString1);
      LogUtil.QLog.d("TextBase", 1, paramString2.toString());
    }
  }
  
  private void resetAligment()
  {
    this.mGravity &= 0xFFFFFFFE;
    this.mGravity &= 0xFFFFFFFB;
    this.mGravity &= 0xFFFFFFFD;
  }
  
  private void resetGravity()
  {
    this.mGravity &= 0xFFFFFFFB;
    this.mGravity &= 0xFFFFFFDF;
  }
  
  public String getText()
  {
    CharSequence localCharSequence = this.mText;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return "";
  }
  
  public int getTextColor()
  {
    return this.mTextColor;
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mTextSize = ((int)(this.mTextSize * this.mFontSizeRatio));
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject))
    {
      Object localObject;
      if (paramInt != 18)
      {
        if (paramInt != 64) {
          switch (paramInt)
          {
          default: 
            return false;
          case 71: 
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            parseTextSizeRatio(paramInt, JsonUtils.getStringValue(paramObject, 0), JsonUtils.getStringValue(paramObject, 1));
            this.mTextStyle = 1;
            return true;
          case 70: 
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            parseTextSizeRatio(paramInt, JsonUtils.getStringValue(paramObject, 0), JsonUtils.getStringValue(paramObject, 1));
            return true;
          case 69: 
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            paramObject = (JSONArray)paramObject;
            if (paramObject.length() < 2) {
              break;
            }
            try
            {
              localObject = paramObject.optString(1, "relative");
              double d = Double.valueOf(paramObject.getString(0)).doubleValue();
              if ("absolutely".equals(localObject))
              {
                this.mMaxWidth = Utils.dp2px(d);
                return true;
              }
              this.mMaxWidth = Utils.rp2px(d);
              return true;
            }
            catch (Exception paramObject)
            {
              LogUtil.QLog.d("TextBase", 1, "", paramObject);
              return true;
            }
          }
        }
        if (!(paramObject instanceof JSONArray)) {
          break label432;
        }
        paramObject = (JSONArray)paramObject;
        if (paramObject.length() < 3) {
          break label432;
        }
        try
        {
          localObject = Utils.toDouble(paramObject.getString(2));
          if (localObject != null) {
            this.mTextSize = Utils.dp2px(((Double)localObject).doubleValue());
          }
          this.mTypefacePath = paramObject.getString(0);
          this.mTypeface = Typeface.createFromAsset(this.mContext.getContext().getAssets(), this.mTypefacePath);
          return true;
        }
        catch (Exception paramObject)
        {
          LogUtil.QLog.d("TextBase", 1, "", paramObject);
          return true;
        }
      }
      if ((paramObject instanceof JSONArray))
      {
        localObject = JsonUtils.getStringValue((JSONArray)paramObject, 1);
        if (localObject != null) {
          try
          {
            this.mLineSpaceExtra = Float.valueOf((String)localObject).floatValue();
            this.mLineSpaceExtra = Utils.dp2px(this.mLineSpaceExtra);
          }
          catch (Exception localException)
          {
            LogUtil.QLog.e("TextBase", 1, "setAttribute: invalid value for STR_ID_TEXT, type: ", localException);
          }
        }
        this.mText = JsonUtils.getStringValue(paramObject, 0);
      }
      else if ((paramObject instanceof CharSequence))
      {
        this.mText = ((CharSequence)paramObject);
      }
      if (this.mText == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute: invalid value for STR_ID_TEXT, type: ");
        localStringBuilder.append(paramObject.getClass().getSimpleName());
        localStringBuilder.append("  value : ");
        localStringBuilder.append(paramObject);
        LogUtil.QLog.d("TextBase", 2, localStringBuilder.toString());
        return false;
      }
    }
    label432:
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (!bool) {
      if (paramInt != 41)
      {
        if (paramInt != 46)
        {
          if (paramInt != 50)
          {
            if (paramInt != 67)
            {
              if (paramInt != 68)
              {
                Object localObject;
                switch (paramInt)
                {
                default: 
                  return false;
                case 22: 
                  localObject = Utils.toInteger(paramString);
                  if (localObject != null)
                  {
                    this.mMaxLines = ((Integer)localObject).intValue();
                    return bool;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
                  ((StringBuilder)localObject).append(paramInt);
                  ((StringBuilder)localObject).append(": ");
                  ((StringBuilder)localObject).append(paramString);
                  LogUtil.QLog.d("TextBase", 2, ((StringBuilder)localObject).toString());
                  return bool;
                case 21: 
                  localObject = Utils.toDouble(paramString);
                  if (localObject != null)
                  {
                    this.mTextSize = Utils.dp2px(((Double)localObject).doubleValue());
                    this.mTextStyle = 1;
                    return bool;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
                  ((StringBuilder)localObject).append(paramInt);
                  ((StringBuilder)localObject).append(": ");
                  ((StringBuilder)localObject).append(paramString);
                  LogUtil.QLog.d("TextBase", 2, ((StringBuilder)localObject).toString());
                  return bool;
                case 20: 
                  this.mTextColor = Utils.parseColor(paramString);
                  return bool;
                case 19: 
                  parseFonSize(paramInt, paramString);
                  return bool;
                }
                this.mText = paramString;
                return bool;
              }
              if (!TextUtils.isEmpty(paramString))
              {
                this.mEnableClickSpan = Boolean.valueOf(TextUtils.equals("1", paramString));
                return bool;
              }
            }
            else if (!TextUtils.isEmpty(paramString))
            {
              this.mEnableMarquee = Boolean.valueOf(TextUtils.equals("1", paramString));
              return bool;
            }
          }
          else
          {
            resetAligment();
            if ("0".equals(paramString))
            {
              this.mGravity |= 0x1;
              return bool;
            }
            if ("1".equals(paramString))
            {
              this.mGravity |= 0x4;
              return bool;
            }
            if ("2".equals(paramString))
            {
              this.mGravity |= 0x2;
              return bool;
            }
          }
        }
        else
        {
          this.drawableLeftPath = paramString;
          setDrawableLeft(this.drawableLeftPath);
          return bool;
        }
      }
      else
      {
        resetGravity();
        if ("CenterVerticle".equals(paramString))
        {
          this.mGravity |= 0x20;
          return bool;
        }
        this.mGravity |= 0x4;
        this.mGravity |= 0x20;
      }
    }
    return bool;
  }
  
  protected void setDrawableLeft(String paramString) {}
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      refresh();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.mPaint.setColor(this.mTextColor);
      refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
 * JD-Core Version:    0.7.0.1
 */