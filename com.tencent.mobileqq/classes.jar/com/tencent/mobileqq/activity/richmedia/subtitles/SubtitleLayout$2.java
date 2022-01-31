package com.tencent.mobileqq.activity.richmedia.subtitles;

import ajua;
import ajuh;
import alud;

class SubtitleLayout$2
  implements Runnable
{
  SubtitleLayout$2(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    if (SubtitleLayout.a(this.this$0))
    {
      if (SubtitleLayout.a(this.this$0) != null)
      {
        long l = System.currentTimeMillis();
        String str1 = alud.a(2131715067);
        String str2 = "Record and speak with subtitles added.";
        if (!ajua.a(false))
        {
          str1 = alud.a(2131715069);
          str2 = "Unable to Recognize Your Speaking due to Poor Internet Connection";
        }
        if (SubtitleLayout.a(this.this$0).a(false) <= 4) {
          SubtitleLayout.a(this.this$0).a(l, 1000L + l, str1, str2, true);
        }
      }
      SubtitleLayout.a(this.this$0, 1000);
      SubtitleLayout.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout.2
 * JD-Core Version:    0.7.0.1
 */