package com.tencent.mobileqq.apollo.web.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StoreAvatar2D$getFavAction$1
  implements Runnable
{
  StoreAvatar2D$getFavAction$1(StoreAvatar2D paramStoreAvatar2D, IStoreAvatar2D.GetFavActionCallback paramGetFavActionCallback) {}
  
  public final void run()
  {
    if (this.a == null) {
      return;
    }
    if (StoreAvatar2D.a(this.this$0) == null)
    {
      this.a.a(1, null);
      return;
    }
    Object localObject1 = StoreAvatar2D.a(this.this$0);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((AppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app!!\n                .g…ava, ProcessConstant.ALL)");
    List localList = ((IApolloDaoManagerService)localObject1).getFavPackageActionList();
    localObject1 = new JSONObject();
    Object localObject2 = new JSONArray();
    if (localList != null) {
      try
      {
        int j = ((Collection)localList).size();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("seq", ((ApolloFavActionData)localList.get(i)).favId);
          localJSONObject.put("actionId", ((ApolloFavActionData)localList.get(i)).actionId);
          localJSONObject.put("actionText", ((ApolloFavActionData)localList.get(i)).text);
          localJSONObject.put("textType", ((ApolloFavActionData)localList.get(i)).textType);
          localJSONObject.put("audioId", ((ApolloFavActionData)localList.get(i)).audioId);
          if (!Float.isNaN(((ApolloFavActionData)localList.get(i)).audioStartTime)) {
            localJSONObject.put("audioStartTime", ((ApolloFavActionData)localList.get(i)).audioStartTime);
          }
          ((JSONArray)localObject2).put(localJSONObject);
          i += 1;
        }
        ((JSONObject)localObject1).put("favActionSet", localObject2);
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getLocalFavAction json error ");
        ((StringBuilder)localObject2).append(localJSONException);
        QLog.e("[cmshow]StoreAvatar2D", 1, ((StringBuilder)localObject2).toString());
      }
    }
    this.a.a(0, (JSONObject)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.getFavAction.1
 * JD-Core Version:    0.7.0.1
 */