package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class BaseChatItemLayoutViewWrapperFactory
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private Map<Class<? extends BaseChatItemLayoutViewWrapper>, BaseChatItemLayoutViewWrapper> jdField_a_of_type_JavaUtilMap;
  
  public BaseChatItemLayoutViewWrapperFactory(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.put(NickNameLayoutViewWrapper.class, new NickNameLayoutViewWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilMap.put(BubbleViewWrapper.class, new BubbleViewWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilMap.put(HeadIconWrapper.class, new HeadIconWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  @Nullable
  public <T extends BaseChatItemLayoutViewWrapper> T a(Class<? extends BaseChatItemLayoutViewWrapper> paramClass)
  {
    a();
    paramClass = (BaseChatItemLayoutViewWrapper)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (paramClass == null) {
      QLog.e("BaseChatItemLayoutViewWrapperFactory", 1, "wrapper check failed");
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapperFactory
 * JD-Core Version:    0.7.0.1
 */