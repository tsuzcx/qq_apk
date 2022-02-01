package com.tencent.mobileqq.app.parser;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;

class JumpActivityHelper$JumpGameShortcutClick$1
  implements WebProcessStartListener
{
  JumpActivityHelper$JumpGameShortcutClick$1(JumpActivityHelper.JumpGameShortcutClick paramJumpGameShortcutClick, JumpActivity paramJumpActivity) {}
  
  public void onResult(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_key_jump_src", 1);
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloGameCity(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, 1, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.JumpGameShortcutClick.1
 * JD-Core Version:    0.7.0.1
 */