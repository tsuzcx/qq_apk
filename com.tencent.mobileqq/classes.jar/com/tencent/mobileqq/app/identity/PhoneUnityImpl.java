package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.api.IPhoneUnityInterface;

public class PhoneUnityImpl
  implements IPhoneUnityInterface
{
  public boolean a(Activity paramActivity)
  {
    return paramActivity instanceof PhoneUnityBindInfoActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.PhoneUnityImpl
 * JD-Core Version:    0.7.0.1
 */