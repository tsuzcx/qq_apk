package com.tencent.mobileqq.activity.richmedia.subtitles;

import ahyd;
import ahyk;
import ajyc;

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
        String str1 = ajyc.a(2131714672);
        String str2 = "Record and speak with subtitles added.";
        if (!ahyd.a(false))
        {
          str1 = ajyc.a(2131714674);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout.2
 * JD-Core Version:    0.7.0.1
 */