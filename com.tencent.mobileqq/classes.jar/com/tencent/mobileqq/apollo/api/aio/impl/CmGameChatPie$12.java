package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;
import com.tencent.mobileqq.utils.VipUtils;

class CmGameChatPie$12
  implements Runnable
{
  CmGameChatPie$12(CmGameChatPie paramCmGameChatPie, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = 2;
    if (CmGameChatPie.a(this.this$0) == null) {
      CmGameChatPie.a(this.this$0, new CmGamePlayAgainDialog(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    CmGameChatPie.a(this.this$0).a(this.this$0.b);
    CmGameChatPie.a(this.this$0).a(CmGameChatPie.a(this.this$0), this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
    CmGameChatPie.a(this.this$0).show();
    CmGameChatPie.a(this.this$0);
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
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.12
 * JD-Core Version:    0.7.0.1
 */