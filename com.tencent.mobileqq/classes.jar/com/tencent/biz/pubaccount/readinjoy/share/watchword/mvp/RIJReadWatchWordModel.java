package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.ReqBody;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.WatchWordReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "()V", "requestWatchWordUrl", "", "watchWord", "", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "jumpUrl", "", "type", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "topicInfo", "Companion", "TopicInfo", "UserInfo", "VideoInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordModel
  implements IRIJReadWatchWordShareContract.IModel
{
  public static final RIJReadWatchWordModel.Companion a = new RIJReadWatchWordModel.Companion(null);
  
  public void a(@NotNull String paramString, @Nullable Function5<? super String, ? super Integer, ? super RIJReadWatchWordModel.UserInfo, ? super RIJReadWatchWordModel.VideoInfo, ? super RIJReadWatchWordModel.TopicInfo, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "watchWord");
    QLog.i("RIJReadWatchWordModel", 1, "requestWatchWordUrl " + paramString);
    cmd0xe5c.ReqBody localReqBody = new cmd0xe5c.ReqBody();
    cmd0xe5c.WatchWordReqBody localWatchWordReqBody = new cmd0xe5c.WatchWordReqBody();
    localWatchWordReqBody.watch_word.set(paramString);
    localReqBody.watch_word_req_body.set((MessageMicro)localWatchWordReqBody);
    localReqBody.type.set(2);
    paramString = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
    paramString = paramString.getRuntime();
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    ProtoUtils.a((AppRuntime)paramString, (ProtoUtils.TroopProtocolObserver)new RIJReadWatchWordModel.requestWatchWordUrl.1(paramFunction5), localReqBody.toByteArray(), "OidbSvc.0xe5c", 3676, 2, new Bundle(), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel
 * JD-Core Version:    0.7.0.1
 */