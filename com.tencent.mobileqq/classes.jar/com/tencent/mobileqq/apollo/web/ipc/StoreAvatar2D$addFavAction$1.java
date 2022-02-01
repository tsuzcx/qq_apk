package com.tencent.mobileqq.apollo.web.ipc;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StoreAvatar2D$addFavAction$1
  implements Runnable
{
  StoreAvatar2D$addFavAction$1(StoreAvatar2D paramStoreAvatar2D, IStoreAvatar2D.AddFavActionCallback paramAddFavActionCallback, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat) {}
  
  public final void run()
  {
    if (StoreAvatar2D.a(this.this$0) == null)
    {
      this.a.a(null);
      return;
    }
    Object localObject2 = new ApolloFavActionData();
    ((ApolloFavActionData)localObject2).actionId = this.b;
    ((ApolloFavActionData)localObject2).text = this.c;
    ((ApolloFavActionData)localObject2).textType = this.d;
    ((ApolloFavActionData)localObject2).audioId = this.e;
    ((ApolloFavActionData)localObject2).playOriginalAudio = this.f;
    ((ApolloFavActionData)localObject2).audioStartTime = this.g;
    long l = System.currentTimeMillis();
    ((ApolloFavActionData)localObject2).favId = l;
    Object localObject1 = StoreAvatar2D.a(this.this$0);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((AppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app!!\n                .g…ava, ProcessConstant.ALL)");
    localObject1 = (IApolloDaoManagerService)localObject1;
    ((IApolloDaoManagerService)localObject1).insertFavActionPackageData((ApolloFavActionData)localObject2);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("add fav action success +");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.d("[cmshow]StoreAvatar2D", 2, ((StringBuilder)localObject3).toString());
    }
    localObject2 = StoreAvatar2D.a(this.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((AppInterface)localObject2).getHandler(ChatActivity.class);
    if (localObject2 != null)
    {
      localObject3 = StoreAvatar2D.a(this.this$0);
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = (ApolloInfo)new ApolloMainInfo(((AppInterface)localObject3).getCurrentUin());
      ((ApolloInfo)localObject3).mAction = ((IApolloDaoManagerService)localObject1).findActionById(this.b);
      ((ApolloInfo)localObject3).mActionText = this.c;
      ((ApolloInfo)localObject3).mTextType = this.d;
      ((ApolloInfo)localObject3).mAudioId = this.e;
      ((ApolloInfo)localObject3).mAudioStartTime = this.g;
      ((ApolloInfo)localObject3).mPlayOriginalAudio = this.f;
      localObject1 = ((MqqHandler)localObject2).obtainMessage(66);
      ((Message)localObject1).obj = localObject3;
      ((Message)localObject1).sendToTarget();
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("seq", l);
      ((JSONObject)localObject1).put("success", true);
    }
    catch (JSONException localJSONException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("addFavAction ipc json error + ");
      ((StringBuilder)localObject3).append(localJSONException);
      QLog.e("[cmshow]StoreAvatar2D", 1, ((StringBuilder)localObject3).toString());
    }
    this.a.a((JSONObject)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.addFavAction.1
 * JD-Core Version:    0.7.0.1
 */