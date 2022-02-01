package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import java.util.Map;
import mqq.os.MqqHandler;

public class AIOZhituHelper
  implements Handler.Callback, ILifeCycleHelper, PanelListener
{
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  
  public AIOZhituHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
  }
  
  private static Drawable a(QQAppInterface paramQQAppInterface)
  {
    Drawable localDrawable = paramQQAppInterface.getApplicationContext().getResources().getDrawable(2130838030);
    if (!ABTestController.a().a()) {
      return localDrawable;
    }
    Object localObject = ABTestController.a().a("exp_qq_msg_marketface_input_icon");
    Map localMap = ((ExpEntityInfo)localObject).a();
    RichTextChatManager localRichTextChatManager = RichTextChatManager.a(paramQQAppInterface);
    if ((((ExpEntityInfo)localObject).c()) && (localMap != null))
    {
      localObject = ABTestUtil.a(ABTestUtil.a((String)localMap.get("aio_input_shan_icon_url1"), 44, 44), ABTestUtil.a((String)localMap.get("aio_input_shan_icon_url2"), 44, 44));
      paramQQAppInterface = localDrawable;
      if (localObject != null) {
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
    else
    {
      paramQQAppInterface = localDrawable;
      if (localRichTextChatManager != null)
      {
        localObject = ABTestUtil.a(ABTestUtil.a(localRichTextChatManager.c(), 44, 44), ABTestUtil.a(localRichTextChatManager.d(), 44, 44));
        paramQQAppInterface = localDrawable;
        if (localObject != null) {
          paramQQAppInterface = (QQAppInterface)localObject;
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ImageButton paramImageButton)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(a(paramQQAppInterface));
  }
  
  public void a()
  {
    ImageButton localImageButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a() != null) && (this.jdField_a_of_type_Boolean))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localImageButton);
      localImageButton.setActivated(false);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(Editable paramEditable)
  {
    if ((!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).jdField_a_of_type_Boolean) && (paramEditable.length() > 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().removeMessages(84);
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOZhituHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 84)
    {
      EditTextUI localEditTextUI = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      a();
      if ((localEditTextUI.a() != null) && (paramMessage.arg1 == 1)) {
        localEditTextUI.a("");
      }
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a() != null) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper
 * JD-Core Version:    0.7.0.1
 */