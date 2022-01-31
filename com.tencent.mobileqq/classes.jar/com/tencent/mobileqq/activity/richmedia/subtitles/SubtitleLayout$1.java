package com.tencent.mobileqq.activity.richmedia.subtitles;

import ahyb;
import ahyi;
import com.tencent.qphone.base.util.QLog;

class SubtitleLayout$1
  implements Runnable
{
  SubtitleLayout$1(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    SubtitleLayout.a(this.this$0, true);
    if ((SubtitleLayout.a(this.this$0) != null) && (SubtitleLayout.a(this.this$0).b() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "count down, not in preview state.");
      }
      SubtitleLayout.a(this.this$0, null);
      return;
    }
    ahyb.a().a(true, false);
    this.this$0.a();
    if (this.this$0.a != 0)
    {
      SubtitleLayout.a(this.this$0);
      SubtitleLayout.b(this.this$0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "stop auto trans.");
    }
    SubtitleLayout.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout.1
 * JD-Core Version:    0.7.0.1
 */