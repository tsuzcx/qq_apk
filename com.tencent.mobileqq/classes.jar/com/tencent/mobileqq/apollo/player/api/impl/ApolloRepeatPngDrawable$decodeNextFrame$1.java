package com.tencent.mobileqq.apollo.player.api.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.player.FrameData;
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
    if (localFrameData != null) {
      localObject = localFrameData.a();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.a());
      ((StringBuilder)localObject).append(" get null nextFrameBitmap for index: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", frameList:");
      ((StringBuilder)localObject).append(ApolloRepeatPngDrawable.a(this.this$0).keySet());
      QLog.w("[cmshow]ApolloRepeatPngDrawable", 1, ((StringBuilder)localObject).toString());
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = (Function0)new ApolloRepeatPngDrawable.decodeNextFrame.1.block.1(this, localFrameData);
    if (l < this.jdField_a_of_type_Long)
    {
      ApolloRepeatPngDrawable.a(this.this$0).postDelayed((Runnable)new ApolloRepeatPngDrawable.sam.java_lang_Runnable.0((Function0)localObject), this.jdField_a_of_type_Long - l);
      return;
    }
    ApolloRepeatPngDrawable.a(this.this$0).post((Runnable)new ApolloRepeatPngDrawable.sam.java_lang_Runnable.0((Function0)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloRepeatPngDrawable.decodeNextFrame.1
 * JD-Core Version:    0.7.0.1
 */