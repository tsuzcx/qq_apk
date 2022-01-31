package com.tencent.mobileqq.activity.aio.rebuild;

import agjp;
import akqn;
import com.tencent.mobileqq.utils.VipUtils;

public class CmGameChatPie$12
  implements Runnable
{
  public CmGameChatPie$12(agjp paramagjp, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = 2;
    if (agjp.a(this.this$0) == null) {
      agjp.a(this.this$0, new akqn(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    agjp.a(this.this$0).a(this.this$0.b);
    agjp.a(this.this$0).a(agjp.a(this.this$0), this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
    agjp.a(this.this$0).show();
    agjp.a(this.this$0);
    if (this.b == 2) {}
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "endPage", 0, i, new String[] { this.jdField_a_of_type_Int + "" });
      return;
      i = 1 - this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.12
 * JD-Core Version:    0.7.0.1
 */