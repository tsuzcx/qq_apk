package com.tencent.mobileqq.apollo.web.ipc;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StoreAvatar2D$delFavList$1
  implements Runnable
{
  StoreAvatar2D$delFavList$1(StoreAvatar2D paramStoreAvatar2D, JSONArray paramJSONArray, IStoreAvatar2D.DelFavListCallback paramDelFavListCallback) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    Object localObject3;
    Object localObject2;
    List localList;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
    {
      if (StoreAvatar2D.a(this.this$0) == null)
      {
        this.b.a(null);
        return;
      }
      localObject1 = StoreAvatar2D.a(this.this$0);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((AppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "app!!\n                .g…ava, ProcessConstant.ALL)");
      localObject3 = (IApolloDaoManagerService)localObject1;
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      localList = (List)new ArrayList();
    }
    for (;;)
    {
      int i;
      try
      {
        int j = this.a.length();
        i = 0;
        if (i < j)
        {
          Object localObject4 = this.a.getJSONObject(i);
          long l = ((JSONObject)localObject4).optLong("seq");
          int k = ((JSONObject)localObject4).optInt("actionId");
          localObject4 = ((IApolloDaoManagerService)localObject3).findFavActionById(l);
          if ((localObject4 != null) && (k == ((ApolloFavActionData)localObject4).actionId))
          {
            localList.add(localObject4);
            break label434;
          }
          ((JSONArray)localObject2).put(l);
          break label434;
        }
        if (localList.size() > 0)
        {
          ((IApolloDaoManagerService)localObject3).delFavActionList(localList);
          localObject3 = StoreAvatar2D.a(this.this$0);
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          localObject3 = ((AppInterface)localObject3).getHandler(ChatActivity.class);
          if (localObject3 != null)
          {
            localObject3 = ((MqqHandler)localObject3).obtainMessage(66);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "chatActivityHandler\n    …_UPDATE_APOLLO_FAV_PANEL)");
            ((Message)localObject3).arg1 = 1;
            ((Message)localObject3).sendToTarget();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("del fav action success +");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d("[cmshow]StoreAvatar2D", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        i = ((JSONArray)localObject2).length();
        if (i > 0) {
          ((JSONObject)localObject1).put("delHasError", true);
        } else {
          ((JSONObject)localObject1).put("delHasError", false);
        }
        ((JSONObject)localObject1).put("errorList", ((JSONArray)localObject2).toString());
        this.b.a((JSONObject)localObject1);
        return;
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("delFavAction json error + ");
        ((StringBuilder)localObject2).append(localJSONException);
        QLog.e("[cmshow]StoreAvatar2D", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      this.b.a(null);
      return;
      label434:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.delFavList.1
 * JD-Core Version:    0.7.0.1
 */