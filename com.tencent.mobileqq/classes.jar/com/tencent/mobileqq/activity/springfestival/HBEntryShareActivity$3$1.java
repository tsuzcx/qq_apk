package com.tencent.mobileqq.activity.springfestival;

import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;

class HBEntryShareActivity$3$1
  implements Runnable
{
  HBEntryShareActivity$3$1(HBEntryShareActivity.3 param3) {}
  
  public void run()
  {
    HBEntryShareActivity.a(this.a.this$0, false);
    if (FileUtil.a(HBEntryShareActivity.a(this.a.this$0))) {
      ScreenShotHelper.a(this.a.this$0, HBEntryShareActivity.a(this.a.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity.3.1
 * JD-Core Version:    0.7.0.1
 */