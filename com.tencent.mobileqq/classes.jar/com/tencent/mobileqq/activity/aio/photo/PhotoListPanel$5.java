package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoListPanel$5
  implements Runnable
{
  PhotoListPanel$5(PhotoListPanel paramPhotoListPanel, Pair paramPair, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((!((ArrayList)this.a.first).isEmpty()) || (!((ArrayList)this.a.second).isEmpty()))
    {
      this.this$0.a(this.a, this.b);
      com.tencent.mobileqq.shortvideo.SVBusiUtil.c = System.currentTimeMillis();
    }
    String str = this.c;
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, this.d, this.e, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.5
 * JD-Core Version:    0.7.0.1
 */