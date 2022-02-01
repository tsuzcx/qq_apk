package com.tencent.hippy.qq.module.tkd;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$onActivityResult$1
  implements Runnable
{
  TKDCommentBizModule$onActivityResult$1(TKDCommentBizModule paramTKDCommentBizModule, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void run()
  {
    if (this.$requestCode == 117) {
      this.this$0.handleOnActivityResult(this.$resultCode, this.$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.onActivityResult.1
 * JD-Core Version:    0.7.0.1
 */