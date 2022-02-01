package com.tencent.biz.qrcode.logindev;

import java.util.Comparator;

class LoginDevicesManager$1
  implements Comparator<LoginDevItem>
{
  LoginDevicesManager$1(LoginDevicesManager paramLoginDevicesManager) {}
  
  public int a(LoginDevItem paramLoginDevItem1, LoginDevItem paramLoginDevItem2)
  {
    if (paramLoginDevItem1.d > paramLoginDevItem2.d) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevicesManager.1
 * JD-Core Version:    0.7.0.1
 */