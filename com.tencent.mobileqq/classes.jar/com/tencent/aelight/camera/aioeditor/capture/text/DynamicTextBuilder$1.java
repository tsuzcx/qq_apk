package com.tencent.aelight.camera.aioeditor.capture.text;

import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Arrays;
import java.util.Map;

final class DynamicTextBuilder$1
  implements Runnable
{
  public void run()
  {
    String str1 = CaptureContext.a().getCurrentNickname();
    Map localMap = DynamicTextBuilder.a();
    String str2 = HardCodeUtil.a(2131703756);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MY JOURNEY \n");
    localStringBuilder.append(str1);
    localMap.put(Integer.valueOf(5), Arrays.asList(new String[] { str2, localStringBuilder.toString() }));
    DynamicTextBuilder.a().put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */