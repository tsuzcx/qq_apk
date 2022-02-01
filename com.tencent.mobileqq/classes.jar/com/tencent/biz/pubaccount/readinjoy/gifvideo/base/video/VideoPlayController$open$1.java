package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$open$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$open$1(VideoPlayController paramVideoPlayController)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (!TextUtils.isEmpty((CharSequence)this.this$0.b()))
    {
      String str = this.this$0.b();
      if (str != null) {
        this.this$0.d(str);
      }
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)this.this$0.c()))
    {
      VideoPlayController.a(this.this$0);
      return;
    }
    QLog.d(this.this$0.a(), 1, "both url and vid are null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.open.1
 * JD-Core Version:    0.7.0.1
 */