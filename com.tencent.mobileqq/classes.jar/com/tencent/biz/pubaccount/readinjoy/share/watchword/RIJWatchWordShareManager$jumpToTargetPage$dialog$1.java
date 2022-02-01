package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.UserInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$jumpToTargetPage$dialog$1
  implements DialogInterface.OnClickListener
{
  RIJWatchWordShareManager$jumpToTargetPage$dialog$1(RIJWatchWordShareManager paramRIJWatchWordShareManager, RIJReadWatchWordModel.UserInfo paramUserInfo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordRIJWatchWordShareManager;
    RIJReadWatchWordModel.UserInfo localUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$UserInfo;
    if (localUserInfo != null) {}
    for (long l = localUserInfo.a();; l = 0L)
    {
      RIJWatchWordShareManager.a(paramDialogInterface, 2, "", "", l, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.jumpToTargetPage.dialog.1
 * JD-Core Version:    0.7.0.1
 */