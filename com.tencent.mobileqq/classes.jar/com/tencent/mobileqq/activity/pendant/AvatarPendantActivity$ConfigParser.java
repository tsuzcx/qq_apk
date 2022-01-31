package com.tencent.mobileqq.activity.pendant;

import java.lang.ref.WeakReference;

public class AvatarPendantActivity$ConfigParser
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<AvatarPendantActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public AvatarPendantActivity$ConfigParser(String paramString, AvatarPendantActivity paramAvatarPendantActivity)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAvatarPendantActivity);
  }
  
  public void run()
  {
    AvatarPendantActivity localAvatarPendantActivity = (AvatarPendantActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAvatarPendantActivity != null) {
      localAvatarPendantActivity.b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.ConfigParser
 * JD-Core Version:    0.7.0.1
 */