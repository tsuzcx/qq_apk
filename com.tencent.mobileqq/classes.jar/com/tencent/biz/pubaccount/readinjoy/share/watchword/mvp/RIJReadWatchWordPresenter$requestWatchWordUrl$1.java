package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jumpUrl", "", "type", "", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJReadWatchWordPresenter$requestWatchWordUrl$1
  extends Lambda
  implements Function5<String, Integer, RIJReadWatchWordModel.UserInfo, RIJReadWatchWordModel.VideoInfo, RIJReadWatchWordModel.TopicInfo, Unit>
{
  RIJReadWatchWordPresenter$requestWatchWordUrl$1(RIJReadWatchWordPresenter paramRIJReadWatchWordPresenter)
  {
    super(5);
  }
  
  public final void invoke(@NotNull String paramString, int paramInt, @Nullable RIJReadWatchWordModel.UserInfo paramUserInfo, @Nullable RIJReadWatchWordModel.VideoInfo paramVideoInfo, @Nullable RIJReadWatchWordModel.TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jumpUrl");
    QLog.i("RIJReadWatchWordPresenter", 1, "watch word jump url " + paramString);
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (ReadInJoyHelper.i()) && (!StudyModeManager.a()))
      {
        IRIJReadWatchWordShareContract.IView localIView = RIJReadWatchWordPresenter.a(this.this$0);
        if (localIView != null) {
          localIView.a(paramString, paramInt, paramUserInfo, paramVideoInfo, paramTopicInfo);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordPresenter.requestWatchWordUrl.1
 * JD-Core Version:    0.7.0.1
 */