package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class OpenTKPublisherAction$checkTopicVideoUploadNum$callbackSeq$1
  implements TroopMemberApiClient.Callback
{
  OpenTKPublisherAction$checkTopicVideoUploadNum$callbackSeq$1(OpenTKPublisherAction paramOpenTKPublisherAction) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("resultCode");
    String str = paramBundle.getString("resultMsg");
    paramBundle = paramBundle.getString("video_cover_path");
    OpenTKPublisherAction localOpenTKPublisherAction = this.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "msg");
    if (paramBundle != null) {}
    for (;;)
    {
      OpenTKPublisherAction.a(localOpenTKPublisherAction, i, str, paramBundle);
      return;
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction.checkTopicVideoUploadNum.callbackSeq.1
 * JD-Core Version:    0.7.0.1
 */