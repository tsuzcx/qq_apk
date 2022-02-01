package com.tencent.av.business.manager.support;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class SupportZimu
  extends SupportBase
{
  boolean a;
  int c = -1;
  int d = -1;
  
  public SupportZimu(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i;
    if ("750".equalsIgnoreCase(paramString)) {
      i = this.c;
    }
    for (;;)
    {
      AVLog.printColorLog("SupportZimu", "isSupportPeer:" + paramString + "|" + i);
      return i;
      if ("735".equalsIgnoreCase(paramString))
      {
        i = this.d;
      }
      else
      {
        i = j;
        if ("live".equalsIgnoreCase(paramString))
        {
          i = j;
          if (this.jdField_a_of_type_Boolean) {
            i = 1;
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    AVLog.printColorLog("SupportZimu", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\|");
      paramString = null;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      }
      switch (paramInt)
      {
      }
      while (("SUPPORT_TRUE".equalsIgnoreCase(paramString)) || ("SUPPORT_FALSE".equalsIgnoreCase(paramString)))
      {
        return true;
        if ("SUPPORT_TRUE".equalsIgnoreCase(paramString))
        {
          this.c = 1;
        }
        else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString))
        {
          this.c = 0;
          continue;
          if ("SUPPORT_TRUE".equalsIgnoreCase(paramString))
          {
            this.d = 1;
          }
          else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString))
          {
            this.d = 0;
            continue;
            if ("SUPPORT_TRUE".equalsIgnoreCase(paramString)) {
              this.jdField_a_of_type_Boolean = true;
            } else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString)) {
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void b()
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localVideoController.a(12, "SUPPORT_TRUE");
    localVideoController.a(13, "SUPPORT_TRUE");
    AVLog.printColorLog("SupportZimu", "sendSupportMsg");
  }
  
  public void c()
  {
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportZimu
 * JD-Core Version:    0.7.0.1
 */