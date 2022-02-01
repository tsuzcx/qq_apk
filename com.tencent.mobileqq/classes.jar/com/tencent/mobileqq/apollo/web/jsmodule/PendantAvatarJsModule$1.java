package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.ipc.business.ICmShowAvatar.IAvatarInterface;

class PendantAvatarJsModule$1
  implements ICmShowAvatar.IAvatarInterface
{
  PendantAvatarJsModule$1(PendantAvatarJsModule paramPendantAvatarJsModule, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmodulePendantAvatarJsModule.a(this.jdField_a_of_type_JavaLangString, 0, "set avatar succeed");
      PendantAvatarJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmodulePendantAvatarJsModule, paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmodulePendantAvatarJsModule.a(this.jdField_a_of_type_JavaLangString, "set avatar fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule.1
 * JD-Core Version:    0.7.0.1
 */