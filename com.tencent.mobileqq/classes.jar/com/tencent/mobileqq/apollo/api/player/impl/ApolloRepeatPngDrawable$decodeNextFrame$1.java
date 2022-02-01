package com.tencent.mobileqq.apollo.api.player.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloRepeatPngDrawable$decodeNextFrame$1
  implements Runnable
{
  ApolloRepeatPngDrawable$decodeNextFrame$1(ApolloRepeatPngDrawable paramApolloRepeatPngDrawable, int paramInt, long paramLong) {}
  
  public final void run()
  {
    FrameData localFrameData = (FrameData)ApolloRepeatPngDrawable.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localFrameData != null) {}
    for (Object localObject = localFrameData.a();; localObject = null)
    {
      if (localObject == null) {
        QLog.w("ApolloRepeatPngDrawable", 1, this.this$0.a() + " get null nextFrameBitmap for index: " + this.jdField_a_of_type_Int + ", frameList:" + ApolloRepeatPngDrawable.a(this.this$0).keySet());
      }
      long l = SystemClock.uptimeMillis();
      localObject = (Function0)new ApolloRepeatPngDrawable.decodeNextFrame.1.block.1(this, localFrameData);
      if (l >= this.jdField_a_of_type_Long) {
        break;
      }
      ApolloRepeatPngDrawable.a(this.this$0).postDelayed((Runnable)new ApolloRepeatPngDrawable.sam.java_lang_Runnable.0((Function0)localObject), this.jdField_a_of_type_Long - l);
      return;
    }
    ApolloRepeatPngDrawable.a(this.this$0).post((Runnable)new ApolloRepeatPngDrawable.sam.java_lang_Runnable.0((Function0)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloRepeatPngDrawable.decodeNextFrame.1
 * JD-Core Version:    0.7.0.1
 */