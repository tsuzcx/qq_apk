package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mtt.hippy.HippyEngine.EngineListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HippyQQEngine$4
  implements HippyEngine.EngineListener
{
  HippyQQEngine$4(HippyQQEngine paramHippyQQEngine) {}
  
  public void onInitialized(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: initEngine statusCode=" + paramInt + ", msg=" + paramString);
    }
    if (paramInt != 0)
    {
      if (HippyQQEngine.access$200(this.this$0) != null) {
        HippyQQEngine.access$200(this.this$0).onError(paramInt, paramString);
      }
      return;
    }
    paramInt = UpdateSetting.getInstance().getModuleVersion(HippyQQEngine.access$500(this.this$0));
    if (paramInt != -1)
    {
      paramString = HippyQQFileUtil.getModuleIndex(HippyQQEngine.access$500(this.this$0), paramInt);
      if ((paramString != null) && (paramString.exists()))
      {
        HippyQQEngine.access$002(this.this$0, paramInt);
        HippyQQEngine.access$100(this.this$0, paramString.getAbsolutePath());
      }
    }
    HippyQQEngine.access$600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.4
 * JD-Core Version:    0.7.0.1
 */