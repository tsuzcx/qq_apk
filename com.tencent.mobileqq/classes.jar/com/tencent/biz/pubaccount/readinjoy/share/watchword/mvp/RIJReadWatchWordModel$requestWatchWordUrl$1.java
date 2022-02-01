package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.RspBody;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.TopicInfo;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.UserInfo;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoInfo;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.WatchRspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$requestWatchWordUrl$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordModel$requestWatchWordUrl$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJReadWatchWordModel$requestWatchWordUrl$1(Function5 paramFunction5) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    QLog.i("RIJReadWatchWordModel", 1, "requestWatchWordUrl error code = " + paramInt);
    cmd0xe5c.RspBody localRspBody;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    String str;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localRspBody = new cmd0xe5c.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = ((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).type.get();
      paramArrayOfByte = (RIJReadWatchWordModel.VideoInfo)null;
      paramBundle = (RIJReadWatchWordModel.TopicInfo)null;
      localObject2 = (RIJReadWatchWordModel.UserInfo)null;
      if (((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).from.has())
      {
        localObject1 = (cmd0xe5c.UserInfo)((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).from.get();
        localObject2 = ((cmd0xe5c.UserInfo)localObject1).username.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "tmp.username.get()");
        localObject2 = new RIJReadWatchWordModel.UserInfo((String)localObject2, ((cmd0xe5c.UserInfo)localObject1).uin.get());
      }
      if (paramInt == 1)
      {
        localObject1 = (cmd0xe5c.VideoInfo)((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).video.get();
        if (!((cmd0xe5c.VideoInfo)localObject1).has()) {
          break label577;
        }
        paramArrayOfByte = ((cmd0xe5c.VideoInfo)localObject1).cover.get();
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "tmp.cover.get()");
        localObject3 = ((cmd0xe5c.VideoInfo)localObject1).title.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "tmp.title.get()");
        int i = ((cmd0xe5c.VideoInfo)localObject1).type.get();
        str = ((cmd0xe5c.VideoInfo)localObject1).rowkey.get();
        Intrinsics.checkExpressionValueIsNotNull(str, "tmp.rowkey.get()");
        paramArrayOfByte = new RIJReadWatchWordModel.VideoInfo(paramArrayOfByte, (String)localObject3, i, str);
        localObject3 = ((cmd0xe5c.VideoInfo)localObject1).schema.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "tmp.schema.get()");
        localObject1 = paramBundle;
        paramBundle = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject3;
      }
    }
    for (;;)
    {
      if ((((cmd0xe5c.WatchRspBody)localRspBody.watch_rsp_body.get()).is_expired.get()) || (((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).is_deleted.get())) {
        paramArrayOfByte = "expired_or_deleted";
      }
      localObject3 = this.a;
      if (localObject3 != null) {
        paramArrayOfByte = (Unit)((Function5)localObject3).invoke(paramArrayOfByte, Integer.valueOf(paramInt), localObject2, paramBundle, localObject1);
      }
      do
      {
        return;
        if (paramInt != 2) {
          break label577;
        }
        localObject3 = (cmd0xe5c.TopicInfo)((cmd0xe5c.WatchRspBody)((cmd0xe5c.RspBody)localRspBody.get()).watch_rsp_body.get()).topic.get();
        if (!((cmd0xe5c.TopicInfo)localObject3).has()) {
          break label577;
        }
        paramBundle = ((cmd0xe5c.TopicInfo)localObject3).icon.get();
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "tmp.icon.get()");
        localObject1 = ((cmd0xe5c.TopicInfo)localObject3).title.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "tmp.title.get()");
        str = ((cmd0xe5c.TopicInfo)localObject3).topic_id.get();
        Intrinsics.checkExpressionValueIsNotNull(str, "tmp.topic_id.get()");
        localObject1 = new RIJReadWatchWordModel.TopicInfo(paramBundle, (String)localObject1, str);
        localObject3 = RIJUgcUtils.a() + ((cmd0xe5c.TopicInfo)localObject3).topic_id.get();
        paramBundle = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject3;
        break;
        paramArrayOfByte = this.a;
      } while (paramArrayOfByte == null);
      paramArrayOfByte = (Unit)paramArrayOfByte.invoke("", Integer.valueOf(0), null, null, null);
      return;
      label577:
      localObject1 = paramBundle;
      localObject3 = "";
      paramBundle = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.requestWatchWordUrl.1
 * JD-Core Version:    0.7.0.1
 */