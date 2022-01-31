package com.tencent.mobileqq.activity.recent;

import ahqv;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import ayki;
import com.tencent.qphone.base.util.QLog;

@ahqv
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
  public CharSequence strContent;
  public CharSequence strPrefix;
  public CharSequence suffix;
  
  public CharSequence a(Context paramContext)
  {
    Object localObject2 = null;
    StringBuffer localStringBuffer = null;
    int i = 0;
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
          break label504;
        }
        j = this.strPrefix.length() + ": ".length();
        if (this.nState != 2) {
          continue;
        }
        paramContext = ((Resources)localObject1).getDrawable(2130848508);
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
      paramContext = localStringBuffer;
      if (this.nState == 1)
      {
        paramContext = ((Resources)localObject1).getDrawable(2130848509);
        i = "S ".length();
        i = j + i;
        continue;
        localStringBuffer = new StringBuffer(40);
        if (!TextUtils.isEmpty(this.strPrefix)) {
          localStringBuffer.append(this.strPrefix).append(": ");
        }
        for (j = localStringBuffer.length();; j = 0)
        {
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
              label326:
              paramContext = localObject2;
              if (localObject1 == null) {}
            }
            try
            {
              if (this.nState == 2) {
                paramContext = ((Resources)localObject1).getDrawable(2130848508);
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
                  break label494;
                }
                localStringBuffer.append("S ");
                i = localStringBuffer.length();
                break;
                localObject1 = paramContext.getResources();
                break label326;
                paramContext = localObject2;
                if (this.nState == 1) {
                  paramContext = ((Resources)localObject1).getDrawable(2130848509);
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
              label494:
              i = 0;
            }
          }
        }
        label504:
        j = 0;
      }
    }
  }
  
  public CharSequence a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int j = 2;
    int k = 1;
    if ((this.bShowDraft) && (!TextUtils.isEmpty(this.mDraft))) {
      localObject1 = this.mDraft;
    }
    while (paramContext == null) {
      return localObject1;
    }
    Resources localResources = paramContext.getResources();
    if (localResources != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.nState == 2)
        {
          localObject1 = localResources.getDrawable(2130848508);
          if (paramInt <= 0) {
            break label618;
          }
          paramInt = paramContext.getResources().getColor(2131166955);
          if (!(this.strContent instanceof ayki)) {
            break label369;
          }
          paramContext = (ayki)this.strContent;
          localObject3 = (ImageSpan[])paramContext.getSpans(0, 1, ImageSpan.class);
          if (localObject3.length > 0) {
            paramContext.removeSpan(localObject3[0]);
          }
          localObject3 = paramContext.a(paramString, true, new int[0]);
          if (this.nState != 2) {
            break label332;
          }
          paramContext = ((ayki)localObject3).a("F ", true, new int[0]);
          if (this.suffix == null) {
            break label615;
          }
          paramContext = paramContext.a(this.suffix.toString(), false, new int[0]);
          if (localObject1 == null) {
            break label609;
          }
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth() * 2 / 3, ((Drawable)localObject1).getIntrinsicHeight() * 2 / 3);
          paramContext.setSpan(new ImageSpan((Drawable)localObject1), 0, 1, 33);
          i = 1;
          if (paramInt > 0)
          {
            localObject1 = new ForegroundColorSpan(paramInt);
            if (i == 0) {
              break label358;
            }
            paramInt = k;
            if (i == 0) {
              break label363;
            }
            i = 2;
            paramContext.setSpan(localObject1, paramInt, i + paramString.length(), 33);
          }
          return paramContext;
        }
        localObject1 = localObject3;
        if (this.nState != 1) {
          continue;
        }
        localObject1 = localResources.getDrawable(2130848509);
        continue;
        localObject2 = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
      Object localObject2;
      continue;
      label332:
      paramContext = (Context)localObject3;
      if (this.nState == 1)
      {
        paramContext = ((ayki)localObject3).a("S ", true, new int[0]);
        continue;
        label358:
        paramInt = 0;
        continue;
        label363:
        i = 0;
        continue;
        label369:
        paramContext = new StringBuffer(40);
        if (this.nState == 2)
        {
          paramContext.append("F ");
          paramContext.append(paramString);
          if (!TextUtils.isEmpty(this.strPrefix))
          {
            paramContext.append(this.strPrefix);
            paramContext.append("：");
          }
          if (!TextUtils.isEmpty(this.strContent)) {
            paramContext.append(this.strContent);
          }
          if (this.suffix != null) {
            paramContext.append(this.suffix);
          }
          paramContext = new SpannableStringBuilder(paramContext.toString());
          if (localObject2 == null) {
            break label603;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() * 2 / 3, ((Drawable)localObject2).getIntrinsicHeight() * 2 / 3);
          paramContext.setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 33);
        }
        label547:
        label597:
        label603:
        for (i = 1;; i = 0)
        {
          localObject2 = paramContext;
          if (paramInt <= 0) {
            break;
          }
          localObject2 = new ForegroundColorSpan(paramInt);
          if (i != 0)
          {
            paramInt = 1;
            if (i == 0) {
              break label597;
            }
          }
          for (i = j;; i = 0)
          {
            paramContext.setSpan(localObject2, paramInt, paramString.length() + i, 33);
            return paramContext;
            if (this.nState != 1) {
              break;
            }
            paramContext.append("S ");
            break;
            paramInt = 0;
            break label547;
          }
        }
        label609:
        i = 0;
        continue;
        label615:
        continue;
        label618:
        paramInt = -1;
      }
    }
  }
  
  public void a()
  {
    this.strPrefix = null;
    this.nState = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.MsgSummary
 * JD-Core Version:    0.7.0.1
 */