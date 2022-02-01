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
  public PttAudioWaveView a;
  public AIOSelectableDelegateProxy a;
  public StringBuilder a;
  private boolean a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  
  public PttItemBuilder$Holder()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Holder paramHolder, QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if ((paramHolder == null) || (paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramMessageForPtt == null) || (paramMessageForPtt.getSttResult() == null)) {}
    int i;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
      } while (paramQQAppInterface == null);
      i = paramMessageForPtt.getSttResult().a();
    } while (((i != 3) && (i != 4)) || (paramHolder.b == null));
    paramHolder.b.setVisibility(0);
    paramHolder.b.setText(paramQQAppInterface.getString(2131719545));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.a();
    }
  }
  
  public void a(Rect paramRect)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramRect != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void a(Holder paramHolder, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    label147:
    for (;;)
    {
      return;
      if (paramHolder != null)
      {
        if (paramQQAppInterface != null) {}
        for (paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();; paramQQAppInterface = null)
        {
          if (paramQQAppInterface == null) {
            break label147;
          }
          if (paramHolder.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          paramString = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          paramQQAppInterface = paramQQAppInterface.getResources();
          paramString.leftMargin = AIOUtils.a(0.0F, paramQQAppInterface);
          if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) {
            break;
          }
          int j = AIOUtils.a(9.0F, paramQQAppInterface);
          try
          {
            i = paramQQAppInterface.getDrawable(2130844955).getIntrinsicHeight();
            int k = AIOUtils.a(22.0F, paramQQAppInterface);
            paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, i + k);
            return;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              int i = AIOUtils.a(24.0F, paramQQAppInterface);
              QLog.e("PttItemBuilder", 1, "", paramString);
            }
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, SpannableString paramSpannableString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      QLog.e("PttItemBuilder", 1, "refreshSttUIForShardAnimator app is null!");
    }
    int i;
    int j;
    boolean bool1;
    do
    {
      return;
      i = PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt);
      j = PttItemBuilder.b(paramMessageForPtt, i, paramQQAppInterface);
      bool1 = PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt);
    } while (!a(i, j));
    boolean bool2 = VoicePrintUtils.a(paramQQAppInterface, paramQQAppInterface.getApp().getBaseContext(), this, paramMessageForPtt);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramSpannableString);
    a(this, paramQQAppInterface, paramSpannableString.toString());
    PttItemBuilder.a(this, paramMessageForPtt, j, bool2, paramMessageForPtt.timeStr, bool1, paramQQAppInterface, paramInt, paramSpannableString.toString());
    a(this, paramQQAppInterface, paramMessageForPtt);
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
    switch (paramInt1)
    {
    }
    do
    {
      return false;
    } while ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) || (paramInt2 != 2) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() != 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */