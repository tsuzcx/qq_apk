package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.f.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;

public class b
  implements c
{
  public void a(Context paramContext, BaseMode paramBaseMode, IDataMessageCallBackService paramIDataMessageCallBackService)
  {
    if (paramBaseMode == null) {
      return;
    }
    if (paramBaseMode.getType() == 4103)
    {
      paramBaseMode = (DataMessage)paramBaseMode;
      if (paramIDataMessageCallBackService != null) {
        f.b(new b.1(this, paramIDataMessageCallBackService, paramContext, paramBaseMode));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.e.b
 * JD-Core Version:    0.7.0.1
 */