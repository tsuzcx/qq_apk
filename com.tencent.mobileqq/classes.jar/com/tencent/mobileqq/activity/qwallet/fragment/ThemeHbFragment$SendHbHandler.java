package com.tencent.mobileqq.activity.qwallet.fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;

class ThemeHbFragment$SendHbHandler
  extends Handler
{
  ThemeHbFragment$SendHbHandler(ThemeHbFragment paramThemeHbFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (TextUtils.isEmpty(ThemeHbFragment.a(this.a)));
    ThemeHbFragment.a(this.a).setText(ThemeHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.SendHbHandler
 * JD-Core Version:    0.7.0.1
 */