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
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public ETTextView a;
  public OnLongClickAndTouchListener a;
  public VoicePrintUtils.VoicePrintView a;
  public BreathAnimationLayout a;
  public PttAudioChangeView a;
  public PttAudioPlayView a;
  PttAudioWaveView.OnPressListener jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$OnPressListener = new PttItemBuilder.Holder.1(this);
  public PttAudioWaveView a;
  public AIOSelectableDelegateProxy a;
  public StringBuilder a;
  private boolean jdField_a_of_type_Boolean = false;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  
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
      int i = paramMessageForPtt.getSttResult().a();
      if ((i == 3) || (i == 4))
      {
        paramMessageForPtt = paramHolder.b;
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt.setVisibility(0);
          paramHolder.b.setText(paramQQAppInterface.getString(2131719263));
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
    if (localObject != null) {
      ((PttAudioWaveView)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView;
    if (localObject != null) {
      ((PttAudioChangeView)localObject).a();
    }
  }
  
  public void a(Rect paramRect)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
    paramQQAppInterface = paramHolder.jdField_a_of_type_AndroidWidgetProgressBar;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setVisibility(8);
    }
    paramQQAppInterface = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
    paramString = paramString.getResources();
    paramQQAppInterface.leftMargin = AIOUtils.b(0.0F, paramString);
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      int j = AIOUtils.b(9.0F, paramString);
      int i;
      try
      {
        i = paramString.getDrawable(2130844831).getIntrinsicHeight();
      }
      catch (Exception paramQQAppInterface)
      {
        i = AIOUtils.b(24.0F, paramString);
        QLog.e("PttItemBuilder", 1, "", paramQQAppInterface);
      }
      int k = AIOUtils.b(22.0F, paramString);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, k + i);
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
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramSpannableString);
      a(this, paramQQAppInterface, paramSpannableString.toString());
      PttItemBuilder.a(this, paramMessageForPtt, j, bool2, paramMessageForPtt.timeStr, bool1, paramQQAppInterface, paramInt, paramSpannableString.toString());
      a(this, paramQQAppInterface, paramMessageForPtt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      ETTextView localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if ((localETTextView != null) && (paramInt2 == 2) && (localETTextView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */