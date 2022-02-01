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
  public CharSequence mText = "";
  protected int mTextColor = -16777216;
  public int mTextSize = Utils.dp2px(20.0D);
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
    Double localDouble = Utils.toDouble(paramString);
    if (localDouble != null)
    {
      this.mTextSize = Utils.dp2px(localDouble.doubleValue());
      return;
    }
    LogUtil.QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
  }
  
  private void parseTextSizeRatio(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1)) {
        parseFonSize(paramInt, paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.mFontSizeRatio = Float.parseFloat(paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      LogUtil.QLog.d("TextBase", 1, "parseTextSizeRatio error!msg=" + paramString1);
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
    if (this.mText != null) {
      return this.mText.toString();
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
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject))
    {
      String str;
      switch (paramInt)
      {
      default: 
        return false;
      case 18: 
        if ((paramObject instanceof JSONArray))
        {
          str = JsonUtils.getStringValue((JSONArray)paramObject, 1);
          if (str == null) {
            break;
          }
        }
      case 64: 
        for (;;)
        {
          try
          {
            this.mLineSpaceExtra = Float.valueOf(str).floatValue();
            this.mLineSpaceExtra = Utils.dp2px(this.mLineSpaceExtra);
            this.mText = JsonUtils.getStringValue(paramObject, 0);
            if (this.mText != null) {
              break;
            }
            LogUtil.QLog.d("TextBase", 2, "setAttribute: invalid value for STR_ID_TEXT, type: " + paramObject.getClass().getSimpleName() + "  value : " + paramObject);
            return false;
          }
          catch (Exception localException)
          {
            LogUtil.QLog.e("TextBase", 1, "setAttribute: invalid value for STR_ID_TEXT, type: ", localException);
            continue;
          }
          if ((paramObject instanceof CharSequence))
          {
            this.mText = ((CharSequence)paramObject);
            continue;
            if ((paramObject instanceof JSONArray))
            {
              paramObject = (JSONArray)paramObject;
              if (paramObject.length() < 3) {
                break;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = Utils.toDouble(paramObject.getString(2));
        if (localObject != null) {
          this.mTextSize = Utils.dp2px(((Double)localObject).doubleValue());
        }
        this.mTypefacePath = paramObject.getString(0);
        this.mTypeface = Typeface.createFromAsset(this.mContext.getContext().getAssets(), this.mTypefacePath);
      }
      catch (Exception paramObject)
      {
        LogUtil.QLog.d("TextBase", 1, "", paramObject);
        continue;
      }
      return true;
      if ((paramObject instanceof JSONArray))
      {
        parseTextSizeRatio(paramInt, JsonUtils.getStringValue(paramObject, 0), JsonUtils.getStringValue(paramObject, 1));
        continue;
        if ((paramObject instanceof JSONArray))
        {
          parseTextSizeRatio(paramInt, JsonUtils.getStringValue(paramObject, 0), JsonUtils.getStringValue(paramObject, 1));
          this.mTextStyle = 1;
          continue;
          if ((paramObject instanceof JSONArray))
          {
            paramObject = (JSONArray)paramObject;
            if (paramObject.length() >= 2)
            {
              double d;
              try
              {
                localObject = paramObject.optString(1, "relative");
                d = Double.valueOf(paramObject.getString(0)).doubleValue();
                if (!"absolutely".equals(localObject)) {
                  break label422;
                }
                this.mMaxWidth = Utils.dp2px(d);
              }
              catch (Exception paramObject)
              {
                LogUtil.QLog.d("TextBase", 1, "", paramObject);
              }
              continue;
              label422:
              this.mMaxWidth = Utils.rp2px(d);
            }
          }
        }
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = super.setAttribute(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2) {
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          this.mText = paramString;
          return bool2;
          parseFonSize(paramInt, paramString);
          return bool2;
          this.mTextColor = Utils.parseColor(paramString);
          return bool2;
          Object localObject = Utils.toDouble(paramString);
          if (localObject != null)
          {
            this.mTextSize = Utils.dp2px(((Double)localObject).doubleValue());
            this.mTextStyle = 1;
            return bool2;
          }
          LogUtil.QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
          return bool2;
          localObject = Utils.toInteger(paramString);
          if (localObject != null)
          {
            this.mMaxLines = ((Integer)localObject).intValue();
            return bool2;
          }
          LogUtil.QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
          return bool2;
          resetGravity();
          if ("CenterVerticle".equals(paramString))
          {
            this.mGravity |= 0x20;
            return bool2;
          }
          this.mGravity |= 0x4;
          this.mGravity |= 0x20;
          return bool2;
          resetAligment();
          if ("0".equals(paramString))
          {
            this.mGravity |= 0x1;
            return bool2;
          }
          if ("1".equals(paramString))
          {
            this.mGravity |= 0x4;
            return bool2;
          }
          bool1 = bool2;
        } while (!"2".equals(paramString));
        this.mGravity |= 0x2;
        return bool2;
        this.drawableLeftPath = paramString;
        setDrawableLeft(this.drawableLeftPath);
        return bool2;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString));
      this.mEnableMarquee = Boolean.valueOf(TextUtils.equals("1", paramString));
      return bool2;
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramString));
    this.mEnableClickSpan = Boolean.valueOf(TextUtils.equals("1", paramString));
    return bool2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
 * JD-Core Version:    0.7.0.1
 */