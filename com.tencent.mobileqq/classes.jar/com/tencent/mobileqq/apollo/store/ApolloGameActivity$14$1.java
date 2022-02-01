package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.ShortcutCreateListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.ShortcutCreateResult;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloGameActivity$14$1
  implements ApolloGameUtil.ShortcutCreateResult
{
  ApolloGameActivity$14$1(ApolloGameActivity.14 param14) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.a, 2, new Object[] { "createShortcut result:", Integer.valueOf(paramInt) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateListener.a(paramInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, paramInt, new String[] { String.valueOf(this.a.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.14.1
 * JD-Core Version:    0.7.0.1
 */