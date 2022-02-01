package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.qphone.base.util.QLog;

public class StickerTextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ((SpecWordEmotionThinkHelper)paramAIOContext.a(41)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a(AIOContext paramAIOContext)
  {
    return ((FullScreenInputHelper)paramAIOContext.a(24)).e();
  }
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check zhitu condition: ");
      ((StringBuilder)localObject).append(paramEditable.length());
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(((ReceiptHelper)paramAIOContext.a(118)).a);
      QLog.d("StickerTextChangeCallback", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (StickerRecHelper)paramAIOContext.a(14);
    ((StickerRecHelper)localObject).b(paramEditable);
    if (b(paramAIOContext, paramEditable)) {
      ((StickerRecHelper)localObject).a(paramEditable);
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean b(AIOContext paramAIOContext, Editable paramEditable)
  {
    Object localObject1 = (StickerRecHelper)paramAIOContext.a(14);
    localObject1 = (AIOZhituHelper)paramAIOContext.a(116);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check zhitu condition: ");
      ((StringBuilder)localObject2).append(((AIOZhituHelper)localObject1).a);
      QLog.d("StickerTextChangeCallback", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (ReplyHelper)paramAIOContext.a(119);
    return (paramEditable.length() > 0) && (!((ReceiptHelper)paramAIOContext.a(118)).a) && (!((AIOZhituHelper)localObject1).a) && (!((ReplyHelper)localObject2).b()) && (!a(paramAIOContext)) && (((IStickerRecManager)paramAIOContext.a().getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.StickerTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */