package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PttItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public TextView A;
  public RelativeLayout B;
  public ProgressBar C;
  public OnLongClickAndTouchListener D;
  PttAudioWaveView.OnPressListener E = new PttItemBuilder.Holder.1(this);
  private boolean F = false;
  public StringBuilder a;
  public ImageView b;
  public VoicePrintUtils.VoicePrintView c;
  public TextView d;
  public ImageView e;
  public ETTextView f;
  public AIOSelectableDelegateProxy g;
  public PttAudioPlayView s;
  public PttAudioChangeView t;
  public PttAudioWaveView u;
  public BreathAnimationLayout v;
  public ImageView w;
  public ImageView x;
  public ImageView y;
  public ImageView z;
  
  private void a(Holder paramHolder, QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if ((paramHolder != null) && (paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null) && (paramMessageForPtt != null))
    {
      if (paramMessageForPtt.getSttResult() == null) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
      if (paramQQAppInterface == null) {
        return;
      }
      int i = paramMessageForPtt.getSttResult().e();
      if ((i == 3) || (i == 4))
      {
        paramMessageForPtt = paramHolder.A;
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt.setVisibility(0);
          paramHolder.A.setText(paramQQAppInterface.getString(2131916815));
        }
      }
    }
  }
  
  public void a(Rect paramRect)
  {
    RelativeLayout localRelativeLayout = this.B;
    if ((localRelativeLayout != null) && (paramRect != null)) {
      localRelativeLayout.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void a(Holder paramHolder, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramHolder == null) {
      return;
    }
    paramString = null;
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getApp().getApplicationContext();
    }
    if (paramString == null) {
      return;
    }
    paramQQAppInterface = paramHolder.C;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setVisibility(8);
    }
    paramQQAppInterface = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
    paramString = paramString.getResources();
    paramQQAppInterface.leftMargin = AIOUtils.b(0.0F, paramString);
    if (paramHolder.f != null)
    {
      int j = AIOUtils.b(9.0F, paramString);
      int i;
      try
      {
        i = paramString.getDrawable(2130846265).getIntrinsicHeight();
      }
      catch (Exception paramQQAppInterface)
      {
        i = AIOUtils.b(24.0F, paramString);
        QLog.e("PttItemBuilder", 1, "", paramQQAppInterface);
      }
      int k = AIOUtils.b(22.0F, paramString);
      paramHolder.f.setPadding(j, BaseChatItemLayout.n, j, k + i);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, SpannableString paramSpannableString, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("PttItemBuilder", 1, "refreshSttUIForShardAnimator app is null!");
      return;
    }
    int i = PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt);
    int j = PttItemBuilder.b(paramMessageForPtt, i, paramQQAppInterface);
    boolean bool1 = PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt);
    if (a(i, j))
    {
      boolean bool2 = VoicePrintUtils.a(paramQQAppInterface, paramQQAppInterface.getApp().getBaseContext(), this, paramMessageForPtt);
      this.f.setText(paramSpannableString);
      a(this, paramQQAppInterface, paramSpannableString.toString());
      PttItemBuilder.a(this, paramMessageForPtt, j, bool2, paramMessageForPtt.timeStr, bool1, paramQQAppInterface, paramInt, paramSpannableString.toString());
      a(this, paramQQAppInterface, paramMessageForPtt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public boolean a()
  {
    return this.F;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      ETTextView localETTextView = this.f;
      if ((localETTextView != null) && (paramInt2 == 2) && (localETTextView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.s;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).b();
    }
    localObject = this.u;
    if (localObject != null) {
      ((PttAudioWaveView)localObject).b();
    }
    localObject = this.t;
    if (localObject != null) {
      ((PttAudioChangeView)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */