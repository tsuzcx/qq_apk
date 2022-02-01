package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.ParcelObject;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.qphone.base.util.QLog;

@ParcelAnnotation.ParcelObject
public class MsgSummary
{
  public static final int EMOJI_DEFAULT = 0;
  public static final int EMOJI_HAS = 1;
  public static final int STATE_DEFAULT = 0;
  public static final int STATE_FAILED = 2;
  public static final int STATE_SENDING = 1;
  public static final String STR_COLON = ": ";
  public static final String STR_FAILED = "F ";
  public static final String STR_SENDING = "S ";
  public boolean bShowDraft;
  public CharSequence mDraft;
  public int mEmojiFlag;
  public int nState;
  public CharSequence prefixOfContent;
  public CharSequence strContent;
  public CharSequence strPrefix;
  public CharSequence suffix;
  
  private CharSequence a(String paramString, Drawable paramDrawable, int paramInt)
  {
    Object localObject = new StringBuffer(40);
    int k = this.nState;
    int i = 1;
    int j = 2;
    if (k == 2) {
      ((StringBuffer)localObject).append("F ");
    } else if (k == 1) {
      ((StringBuffer)localObject).append("S ");
    }
    ((StringBuffer)localObject).append(paramString);
    if (!TextUtils.isEmpty(this.strPrefix))
    {
      ((StringBuffer)localObject).append(this.strPrefix);
      ((StringBuffer)localObject).append("：");
    }
    if (!TextUtils.isEmpty(this.strContent)) {
      ((StringBuffer)localObject).append(this.strContent);
    }
    CharSequence localCharSequence = this.suffix;
    if (localCharSequence != null) {
      ((StringBuffer)localObject).append(localCharSequence);
    }
    localObject = new SpannableStringBuilder(((StringBuffer)localObject).toString());
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() * 2 / 3, paramDrawable.getIntrinsicHeight() * 2 / 3);
      ((SpannableStringBuilder)localObject).setSpan(new ImageSpan(paramDrawable), 0, 1, 33);
    }
    else
    {
      i = 0;
    }
    if (paramInt > 0)
    {
      paramDrawable = new ForegroundColorSpan(paramInt);
      if (i != 0) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      ((SpannableStringBuilder)localObject).setSpan(paramDrawable, i, paramInt + paramString.length(), 33);
    }
    return localObject;
  }
  
  private CharSequence b(String paramString, Drawable paramDrawable, int paramInt)
  {
    Object localObject1 = (AbsQQText)this.strContent;
    int i = 1;
    int j = 0;
    Object localObject2 = (ImageSpan[])((AbsQQText)localObject1).getSpans(0, 1, ImageSpan.class);
    if (localObject2.length > 0) {
      ((AbsQQText)localObject1).removeSpan(localObject2[0]);
    }
    localObject2 = ((AbsQQText)localObject1).append(paramString, true, new int[0]);
    int k = this.nState;
    if (k == 2)
    {
      localObject1 = ((AbsQQText)localObject2).append("F ", true, new int[0]);
    }
    else
    {
      localObject1 = localObject2;
      if (k == 1) {
        localObject1 = ((AbsQQText)localObject2).append("S ", true, new int[0]);
      }
    }
    CharSequence localCharSequence = this.suffix;
    localObject2 = localObject1;
    if (localCharSequence != null) {
      localObject2 = ((AbsQQText)localObject1).append(localCharSequence.toString(), false, new int[0]);
    }
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() * 2 / 3, paramDrawable.getIntrinsicHeight() * 2 / 3);
      ((AbsQQText)localObject2).setSpan(new ImageSpan(paramDrawable), 0, 1, 33);
    }
    else
    {
      i = 0;
    }
    if (paramInt > 0)
    {
      paramDrawable = new ForegroundColorSpan(paramInt);
      paramInt = j;
      if (i != 0) {
        paramInt = 2;
      }
      ((AbsQQText)localObject2).setSpan(paramDrawable, i, paramInt + paramString.length(), 33);
    }
    return localObject2;
  }
  
  public CharSequence a(Context paramContext)
  {
    if ((this.bShowDraft) && (!TextUtils.isEmpty(this.mDraft))) {
      return this.mDraft;
    }
    boolean bool = this.strContent instanceof Spannable;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    int j;
    label147:
    label217:
    StringBuffer localStringBuffer;
    if (bool)
    {
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.getResources();
      }
      if (paramContext != null)
      {
        try
        {
          if (TextUtils.isEmpty(this.strPrefix)) {
            break label529;
          }
          i = this.strPrefix.length() + 2;
          j = i;
          if (!TextUtils.isEmpty(this.prefixOfContent)) {
            j = i + this.prefixOfContent.length();
          }
          if (this.nState == 2)
          {
            paramContext = paramContext.getDrawable(IMCoreResourceRoute.Resource.drawable.a);
          }
          else
          {
            if (this.nState != 1) {
              break label541;
            }
            paramContext = paramContext.getDrawable(IMCoreResourceRoute.Resource.drawable.b);
          }
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label217;
          }
          QLog.i("Q.recent", 2, paramContext.toString());
        }
        if (paramContext != null)
        {
          paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
          ((Spannable)this.strContent).setSpan(new ImageSpan(paramContext), j, i, 33);
        }
      }
      return this.strContent;
    }
    else
    {
      localStringBuffer = new StringBuffer(40);
      if (!TextUtils.isEmpty(this.strPrefix))
      {
        localStringBuffer.append(this.strPrefix);
        localStringBuffer.append(": ");
      }
      if (!TextUtils.isEmpty(this.prefixOfContent)) {
        localStringBuffer.append(this.prefixOfContent);
      }
      j = localStringBuffer.length();
      i = this.nState;
      if (i == 2)
      {
        localStringBuffer.append("F ");
        i = localStringBuffer.length();
      }
      else if (i == 1)
      {
        localStringBuffer.append("S ");
        i = localStringBuffer.length();
      }
      else
      {
        i = 0;
      }
      if (!TextUtils.isEmpty(this.strContent)) {
        localStringBuffer.append(this.strContent);
      }
      localObject1 = this.suffix;
      if (localObject1 != null) {
        localStringBuffer.append((CharSequence)localObject1);
      }
      if (paramContext == null) {
        localObject1 = null;
      } else {
        localObject1 = paramContext.getResources();
      }
      paramContext = localObject2;
      if (localObject1 != null) {
        try
        {
          if (this.nState == 2)
          {
            paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.a);
          }
          else
          {
            paramContext = localObject2;
            if (this.nState == 1) {
              paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.b);
            }
          }
        }
        catch (Exception localException)
        {
          paramContext = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.recent", 2, localException.toString());
            paramContext = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localStringBuffer.toString());
      if (paramContext != null)
      {
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
        localSpannableStringBuilder.setSpan(new ImageSpan(paramContext), j, i, 33);
      }
      return localSpannableStringBuilder;
      label529:
      i = 0;
      break;
      i = j + 2;
      break label147;
      label541:
      i = 0;
      paramContext = localSpannableStringBuilder;
      break label147;
    }
  }
  
  public CharSequence a(Context paramContext, String paramString, int paramInt)
  {
    if ((this.bShowDraft) && (!TextUtils.isEmpty(this.mDraft))) {
      return this.mDraft;
    }
    Object localObject2 = null;
    if (paramContext == null) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    Object localObject1 = localObject2;
    if (localResources != null) {
      try
      {
        if (this.nState == 2)
        {
          localObject1 = localResources.getDrawable(IMCoreResourceRoute.Resource.drawable.a);
        }
        else
        {
          localObject1 = localObject2;
          if (this.nState == 1) {
            localObject1 = localResources.getDrawable(IMCoreResourceRoute.Resource.drawable.b);
          }
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, localException.toString());
          localObject1 = localObject2;
        }
      }
    }
    int i = -1;
    if (paramInt > 0) {
      i = paramContext.getResources().getColor(IMCoreResourceRoute.Resource.color.a);
    }
    if ((this.strContent instanceof AbsQQText)) {
      return b(paramString, (Drawable)localObject1, i);
    }
    return a(paramString, (Drawable)localObject1, i);
  }
  
  public void a()
  {
    this.strPrefix = null;
    this.nState = 0;
    this.prefixOfContent = null;
    this.strContent = null;
    this.suffix = null;
    this.mEmojiFlag = 0;
    this.bShowDraft = false;
    this.mDraft = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.strPrefix);
    localStringBuilder.append(";");
    localStringBuilder.append(this.nState);
    localStringBuilder.append(";");
    localStringBuilder.append(this.strContent);
    localStringBuilder.append(";");
    localStringBuilder.append(this.suffix);
    localStringBuilder.append(";");
    localStringBuilder.append(this.mEmojiFlag);
    localStringBuilder.append(";");
    localStringBuilder.append(this.bShowDraft);
    localStringBuilder.append(";");
    localStringBuilder.append(this.mDraft);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.MsgSummary
 * JD-Core Version:    0.7.0.1
 */