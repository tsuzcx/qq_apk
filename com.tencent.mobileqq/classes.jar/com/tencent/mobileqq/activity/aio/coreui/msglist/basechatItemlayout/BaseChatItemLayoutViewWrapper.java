package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public abstract class BaseChatItemLayoutViewWrapper<T extends IBaseChatItemLayoutProcessor>
{
  protected Context a;
  protected BaseChatItemLayout a;
  protected T a;
  
  public BaseChatItemLayoutViewWrapper(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor = b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor.a();
  }
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor = b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor.a(paramInt);
  }
  
  @Nullable
  public T a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor = b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutIBaseChatItemLayoutProcessor;
  }
  
  @NonNull
  protected abstract T b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapper
 * JD-Core Version:    0.7.0.1
 */