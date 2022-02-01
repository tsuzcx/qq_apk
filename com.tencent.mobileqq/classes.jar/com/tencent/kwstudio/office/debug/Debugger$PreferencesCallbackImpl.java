package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import com.tencent.kwstudio.office.preview.IHostInterface.IPreferencesCallback;

final class Debugger$PreferencesCallbackImpl
  implements IHostInterface.IPreferencesCallback
{
  private final String mKey;
  
  public Debugger$PreferencesCallbackImpl(String paramString)
  {
    this.mKey = paramString;
  }
  
  public void onResult(boolean paramBoolean)
  {
    if (TextUtils.equals(this.mKey, "key_user_enable")) {
      Debugger.access$202(paramBoolean);
    }
    while (!TextUtils.equals(this.mKey, "key_white_list")) {
      return;
    }
    Debugger.access$302(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.PreferencesCallbackImpl
 * JD-Core Version:    0.7.0.1
 */