package com.tencent.av.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;

public class VideoWifiLock
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  WifiManager.WifiLock jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = null;
  String jdField_a_of_type_JavaLangString = null;
  
  public VideoWifiLock(Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.release();
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock == null) {
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = ((WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi")).createWifiLock(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock != null)
    {
      if (!this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.isHeld()) {
        this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.acquire();
      }
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock != null) && (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.isHeld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.VideoWifiLock
 * JD-Core Version:    0.7.0.1
 */