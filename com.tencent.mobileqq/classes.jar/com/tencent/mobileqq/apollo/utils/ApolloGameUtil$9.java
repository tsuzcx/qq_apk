package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;

final class ApolloGameUtil$9
  implements Runnable
{
  ApolloGameUtil$9(ApolloFragment paramApolloFragment, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment instanceof ApolloWebViewFragment)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ((ApolloWebViewFragment)this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.9
 * JD-Core Version:    0.7.0.1
 */