package com.tencent.mobileqq.activity;

import ajxl;
import axrm;
import bbcz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

class BaseChatpieHelper$1
  implements Runnable
{
  BaseChatpieHelper$1(BaseChatpieHelper paramBaseChatpieHelper, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    String str1;
    Object localObject;
    if (this.jdField_a_of_type_Int == -1) {
      if (BaseChatpieHelper.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        str2 = "";
        str3 = "";
        str1 = str2;
        localObject = str3;
        if (this.b != 2) {
          break label155;
        }
        localObject = (ajxl)BaseChatpieHelper.a(this.this$0).getManager(51);
        if (BaseChatpieHelper.a(this.this$0).jdField_a_of_type_Int != 1008) {
          break label74;
        }
      }
    }
    for (;;)
    {
      return;
      label74:
      Friends localFriends = ((ajxl)localObject).e(BaseChatpieHelper.a(this.this$0).jdField_a_of_type_JavaLangString);
      str1 = str2;
      localObject = str3;
      if (localFriends != null)
      {
        str1 = "" + bbcz.a(localFriends);
        localObject = "" + bbcz.a(localFriends, BaseChatpieHelper.a(this.this$0));
      }
      label155:
      axrm.a(BaseChatpieHelper.a(this.this$0), "clt", BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).jdField_a_of_type_JavaLangString, "msg", this.b + "", "", "", str1, (String)localObject, BaseChatpieHelper.a(this.this$0) + "");
      BaseChatpieHelper.a(this.this$0, 0);
      return;
      localObject = null;
      switch (BaseChatpieHelper.a(this.this$0).jdField_a_of_type_Int)
      {
      }
      while (localObject != null)
      {
        axrm.a(BaseChatpieHelper.a(this.this$0), (String)localObject, BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).jdField_a_of_type_JavaLangString, "pic", "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, "", "", "");
        return;
        localObject = "clt";
        continue;
        localObject = "grp";
        continue;
        localObject = "discuss";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper.1
 * JD-Core Version:    0.7.0.1
 */