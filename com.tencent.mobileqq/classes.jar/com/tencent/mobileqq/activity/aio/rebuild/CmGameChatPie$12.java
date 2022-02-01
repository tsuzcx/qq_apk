package com.tencent.mobileqq.activity.aio.rebuild;

import aihy;
import anac;
import com.tencent.mobileqq.utils.VipUtils;

public class CmGameChatPie$12
  implements Runnable
{
  public CmGameChatPie$12(aihy paramaihy, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = 2;
    if (aihy.a(this.this$0) == null) {
      aihy.a(this.this$0, new anac(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    aihy.a(this.this$0).a(this.this$0.b);
    aihy.a(this.this$0).a(aihy.a(this.this$0), this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
    aihy.a(this.this$0).show();
    aihy.a(this.this$0);
    if (this.b == 2) {}
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "endPage", 0, i, new String[] { this.jdField_a_of_type_Int + "" });
      return;
      i = 1 - this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.12
 * JD-Core Version:    0.7.0.1
 */