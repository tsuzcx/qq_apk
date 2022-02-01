package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.qphone.base.util.QLog;

public class ArticleCommentView
  extends TextBase
{
  private NativeCommentView a;
  
  public ArticleCommentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.mLineSpaceExtra = Utils.rp2px(5.0D);
    this.a = new NativeCommentView(paramVafContext.getContext());
    this.a.setTextColor(-654311424);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a.setModel(paramIReadInJoyModel);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setBackgroundColor(this.mBackground);
    this.a.setTextSize(0, this.mTextSize);
    this.a.setLineSpacing(this.mLineSpaceExtra, 1.0F);
    this.a.setIncludeFontPadding(false);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    return super.setAttribute(paramInt, paramObject);
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1176: 
      try
      {
        this.a.setPreBlankNum(Integer.valueOf(paramString).intValue());
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1177: 
      try
      {
        this.a.setPreAccountUin(Long.parseLong(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1178: 
      try
      {
        this.a.a("1".equals(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1192: 
      try
      {
        paramInt = Color.parseColor(paramString);
        this.a.setTextColor(paramInt);
        QLog.d("ArticleCommentView", 1, "setEmotionFontColor: " + paramInt);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1191: 
      try
      {
        this.mTextSize = Utils.dp2px(Integer.valueOf(paramString).intValue());
        QLog.d("ArticleCommentView", 1, "setEmotionFontSize: " + this.mTextSize);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1193: 
      try
      {
        this.mLineSpaceExtra = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
        QLog.d("ArticleCommentView", 1, "setEmotionlineSpace: " + this.mLineSpaceExtra);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
        return false;
      }
    }
    try
    {
      paramInt = Color.parseColor(paramString);
      this.a.setLinkedTextColor(paramInt);
      QLog.d("ArticleCommentView", 1, "ArticleCommentView | setLinkTextColor: " + paramInt);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ArticleCommentView", 1, paramString, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView
 * JD-Core Version:    0.7.0.1
 */