package com.tencent.hippy.qq.module.tkd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openMiniApp$1
  implements Runnable
{
  TKDCommentBizModule$openMiniApp$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    QLog.d("TKDCommentBizModule", 1, "openMiniApp --> params:" + this.$params);
    Activity localActivity = TKDCommentBizModule.access$getActivity(this.this$0);
    if (localActivity != null)
    {
      String str = this.$params.getString("miniAppUrl");
      if (TextUtils.isEmpty((CharSequence)str)) {
        break label74;
      }
      RIJJumpUtils.a((Context)localActivity, str, 2106, null);
    }
    for (;;)
    {
      return;
      label74:
      QLog.e("TKDCommentBizModule", 1, "openMiniApp --> scheme is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.openMiniApp.1
 * JD-Core Version:    0.7.0.1
 */