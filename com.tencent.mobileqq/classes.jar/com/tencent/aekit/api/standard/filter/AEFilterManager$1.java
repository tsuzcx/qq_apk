package com.tencent.aekit.api.standard.filter;

import android.text.TextUtils;
import com.tencent.ttpic.openapi.listener.IDetectorSettingListener;
import java.util.HashMap;

class AEFilterManager$1
  implements IDetectorSettingListener
{
  AEFilterManager$1(AEFilterManager paramAEFilterManager) {}
  
  public void disableDetector(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    label10:
    String str;
    if (i < j)
    {
      str = paramArrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        break label35;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label35:
      if (AEFilterManager.access$000(this.this$0) == null) {
        AEFilterManager.access$002(this.this$0, new HashMap());
      }
      AEFilterManager.access$000(this.this$0).put(str, Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.1
 * JD-Core Version:    0.7.0.1
 */