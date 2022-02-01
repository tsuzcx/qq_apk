package com.tencent.mobileqq.activity.aio.rebuild.input.funbtn;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IFunBtnLongClickCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.LocalCrashCollector;

public class LocalCrashLongClickCallback
  implements IFunBtnLongClickCallback
{
  public void a(AIOContext paramAIOContext, View paramView)
  {
    if ("//findcrash".equals(paramAIOContext.a().a().a().a().toString())) {
      ThreadManager.post(new LocalCrashCollector(paramAIOContext), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.funbtn.LocalCrashLongClickCallback
 * JD-Core Version:    0.7.0.1
 */