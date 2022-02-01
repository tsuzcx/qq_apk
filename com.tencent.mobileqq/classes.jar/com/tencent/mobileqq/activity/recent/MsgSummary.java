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
  
  private CharSequence buildMsgWithExtraInfoAsQQText(String paramString, Drawable paramDrawable, int paramInt)
  {
    Object localObject1 = (AbsQQText)this.strContent;
    Object localObject2 = (ImageSpan[])((AbsQQText)localObject1).getSpans(0, 1, ImageSpan.class);
    if (localObject2.length > 0) {
      ((AbsQQText)localObject1).removeSpan(localObject2[0]);
    }
    localObject2 = ((AbsQQText)localObject1).append(paramString, true, new int[0]);
    if (this.nState == 2)
    {
      localObject1 = ((AbsQQText)localObject2).append("F ", true, new int[0]);
      if (this.suffix == null) {
        break label236;
      }
      localObject1 = ((AbsQQText)localObject1).append(this.suffix.toString(), false, new int[0]);
    }
    label164:
    label219:
    label224:
    label236:
    for (;;)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() * 2 / 3, paramDrawable.getIntrinsicHeight() * 2 / 3);
        ((AbsQQText)localObject1).setSpan(new ImageSpan(paramDrawable), 0, 1, 33);
      }
      for (int i = 1;; i = 0)
      {
        if (paramInt > 0)
        {
          paramDrawable = new ForegroundColorSpan(paramInt);
          if (i == 0) {
            break label219;
          }
          paramInt = 1;
          if (i == 0) {
            break label224;
          }
        }
        for (i = 2;; i = 0)
        {
          ((AbsQQText)localObject1).setSpan(paramDrawable, paramInt, i + paramString.length(), 33);
          return localObject1;
          localObject1 = localObject2;
          if (this.nState != 1) {
            break;
          }
          localObject1 = ((AbsQQText)localObject2).append("S ", true, new int[0]);
          break;
          paramInt = 0;
          break label164;
        }
      }
    }
  }
  
  private CharSequence buildMsgWithExtraInfoAsSpannableString(String paramString, Drawable paramDrawable, int paramInt)
  {
    int j = 2;
    int k = 1;
    Object localObject = new StringBuffer(40);
    if (this.nState == 2)
    {
      ((StringBuffer)localObject).append("F ");
      ((StringBuffer)localObject).append(paramString);
      if (!TextUtils.isEmpty(this.strPrefix))
      {
        ((StringBuffer)localObject).append(this.strPrefix);
        ((StringBuffer)localObject).append("：");
      }
      if (!TextUtils.isEmpty(this.strContent)) {
        ((StringBuffer)localObject).append(this.strContent);
      }
      if (this.suffix != null) {
        ((StringBuffer)localObject).append(this.suffix);
      }
      localObject = new SpannableStringBuilder(((StringBuffer)localObject).toString());
      if (paramDrawable == null) {
        break label244;
      }
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() * 2 / 3, paramDrawable.getIntrinsicHeight() * 2 / 3);
      ((SpannableStringBuilder)localObject).setSpan(new ImageSpan(paramDrawable), 0, 1, 33);
    }
    label186:
    label233:
    label238:
    label244:
    for (int i = 1;; i = 0)
    {
      if (paramInt > 0)
      {
        paramDrawable = new ForegroundColorSpan(paramInt);
        if (i == 0) {
          break label233;
        }
        paramInt = k;
        if (i == 0) {
          break label238;
        }
      }
      for (i = j;; i = 0)
      {
        ((SpannableStringBuilder)localObject).setSpan(paramDrawable, paramInt, i + paramString.length(), 33);
        return localObject;
        if (this.nState != 1) {
          break;
        }
        ((StringBuffer)localObject).append("S ");
        break;
        paramInt = 0;
        break label186;
      }
    }
  }
  
  public CharSequence parseMsg(Context paramContext)
  {
    Object localObject2 = null;
    StringBuffer localStringBuffer = null;
    int k = 0;
    if ((this.bShowDraft) && (!TextUtils.isEmpty(this.mDraft))) {
      return this.mDraft;
    }
    Object localObject1;
    if ((this.strContent instanceof Spannable)) {
      if (paramContext == null)
      {
        localObject1 = null;
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      int j;
      try
      {
        if (TextUtils.isEmpty(this.strPrefix)) {
          break label554;
        }
        i = this.strPrefix.length() + ": ".length();
        if (TextUtils.isEmpty(this.prefixOfContent)) {
          break label549;
        }
        j = i + this.prefixOfContent.length();
        if (this.nState != 2) {
          continue;
        }
        paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_failed);
        i = j + "F ".length();
        if (paramContext != null)
        {
          paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
          ((Spannable)this.strContent).setSpan(new ImageSpan(paramContext), j, i, 33);
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, paramContext.toString());
        continue;
      }
      return this.strContent;
      localObject1 = paramContext.getResources();
      break;
      int i = k;
      paramContext = localStringBuffer;
      if (this.nState == 1)
      {
        paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_sending);
        i = "S ".length();
        i = j + i;
        continue;
        localStringBuffer = new StringBuffer(40);
        if (!TextUtils.isEmpty(this.strPrefix)) {
          localStringBuffer.append(this.strPrefix).append(": ");
        }
        if (!TextUtils.isEmpty(this.prefixOfContent)) {
          localStringBuffer.append(this.prefixOfContent);
        }
        j = localStringBuffer.length();
        if (this.nState == 2)
        {
          localStringBuffer.append("F ");
          i = localStringBuffer.length();
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.strContent)) {
            localStringBuffer.append(this.strContent);
          }
          if (this.suffix != null) {
            localStringBuffer.append(this.suffix);
          }
          if (paramContext == null)
          {
            localObject1 = null;
            label374:
            paramContext = localObject2;
            if (localObject1 == null) {}
          }
          try
          {
            if (this.nState == 2) {
              paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_failed);
            }
            for (;;)
            {
              localObject1 = new SpannableStringBuilder(localStringBuffer.toString());
              if (paramContext != null)
              {
                paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
                ((SpannableStringBuilder)localObject1).setSpan(new ImageSpan(paramContext), j, i, 33);
              }
              return localObject1;
              if (this.nState != 1) {
                break label544;
              }
              localStringBuffer.append("S ");
              i = localStringBuffer.length();
              break;
              localObject1 = paramContext.getResources();
              break label374;
              paramContext = localObject2;
              if (this.nState == 1) {
                paramContext = ((Resources)localObject1).getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_sending);
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramContext = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.recent", 2, localException.toString());
                paramContext = localObject2;
              }
            }
            label544:
            i = 0;
          }
        }
        label549:
        j = i;
        continue;
        label554:
        i = 0;
      }
    }
  }
  
  public CharSequence parseMsgWithExtraInfo(Context paramContext, String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((this.bShowDraft) && (!TextUtils.isEmpty(this.mDraft))) {
      localObject1 = this.mDraft;
    }
    while (paramContext == null) {
      return localObject1;
    }
    Resources localResources = paramContext.getResources();
    if (localResources != null) {}
    int i;
    Drawable localDrawable;
    for (;;)
    {
      try
      {
        if (this.nState == 2)
        {
          localObject1 = localResources.getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_failed);
          i = -1;
          if (paramInt > 0) {
            i = paramContext.getResources().getColor(IMCoreResourceRoute.Resource.color.skin_orange);
          }
          if (!(this.strContent instanceof AbsQQText)) {
            break;
          }
          return buildMsgWithExtraInfoAsQQText(paramString, (Drawable)localObject1, i);
        }
        localObject1 = localObject2;
        if (this.nState == 1)
        {
          localObject1 = localResources.getDrawable(IMCoreResourceRoute.Resource.drawable.recent_icon_sending);
          continue;
          localDrawable = null;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
    }
    return buildMsgWithExtraInfoAsSpannableString(paramString, localDrawable, i);
  }
  
  public void reset()
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
    localStringBuilder.append(this.strPrefix).append(";");
    localStringBuilder.append(this.nState).append(";");
    localStringBuilder.append(this.strContent).append(";");
    localStringBuilder.append(this.suffix).append(";");
    localStringBuilder.append(this.mEmojiFlag).append(";");
    localStringBuilder.append(this.bShowDraft).append(";");
    localStringBuilder.append(this.mDraft);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.MsgSummary
 * JD-Core Version:    0.7.0.1
 */