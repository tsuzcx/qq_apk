package com.tencent.mobileqq.activity;

import abye;
import android.content.Intent;

public class RegisterActivity$13$1
  implements Runnable
{
  public RegisterActivity$13$1(abye paramabye, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
      return;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("http://"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("https://")) {
        localObject1 = "http://" + (String)localObject2;
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_Abye.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("is_register_uin", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("register_uin_msg", 9);
    ((Intent)localObject2).putExtra("register_uin_class", RegisterActivity.class.getName());
    this.jdField_a_of_type_Abye.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.13.1
 * JD-Core Version:    0.7.0.1
 */