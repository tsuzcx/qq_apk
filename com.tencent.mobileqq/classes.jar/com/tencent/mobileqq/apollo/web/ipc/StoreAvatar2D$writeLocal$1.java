package com.tencent.mobileqq.apollo.web.ipc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStrategy;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StoreAvatar2D$writeLocal$1
  implements Runnable
{
  StoreAvatar2D$writeLocal$1(StoreAvatar2D paramStoreAvatar2D, IStoreAvatar2D.WriteLocalCallback paramWriteLocalCallback, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    if (StoreAvatar2D.a(this.this$0) == null)
    {
      this.a.a(null);
      return;
    }
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localObject1 = this.b.optString("optType");
        boolean bool2 = Intrinsics.areEqual("flower", localObject1);
        bool1 = false;
        Object localObject2;
        if (bool2)
        {
          localObject1 = this.b.optJSONObject("data");
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optString("toUin");
            Object localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
            localObject2 = Calendar.getInstance();
            localObject3 = ((SharedPreferences)localObject3).edit();
            StringBuilder localStringBuilder = new StringBuilder();
            AppInterface localAppInterface = StoreAvatar2D.a(this.this$0);
            if (localAppInterface == null) {
              Intrinsics.throwNpe();
            }
            localStringBuilder.append(localAppInterface.getCurrentAccountUin());
            localStringBuilder.append("apollo_today_has_vote");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(((Calendar)localObject2).get(1));
            localStringBuilder.append(((Calendar)localObject2).get(2));
            localStringBuilder.append(((Calendar)localObject2).get(5));
            ((SharedPreferences.Editor)localObject3).putBoolean(localStringBuilder.toString(), true).commit();
            localJSONObject.put("result", 0);
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("msg", HardCodeUtil.a(2131904552));
          }
        }
        else
        {
          bool2 = Intrinsics.areEqual("gameIntro", localObject1);
          if (bool2)
          {
            localObject1 = this.b.optJSONObject("data");
            if (localObject1 != null)
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("apollo_game_first_clk_");
              ((StringBuilder)localObject2).append(i);
              ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
              localJSONObject.put("result", 0);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("gameIntro from web write, gameId:");
                ((StringBuilder)localObject1).append(i);
                QLog.d("[cmshow]StoreAvatar2D", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
          else if (Intrinsics.areEqual("lifeChange", localObject1))
          {
            localObject1 = this.b.optJSONObject("data");
            if ((localObject1 != null) && (StoreAvatar2D.a(this.this$0) != null))
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              int j = ((JSONObject)localObject1).optInt("life");
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(", game coin count=");
                ((StringBuilder)localObject1).append(j);
                QLog.d("[cmshow]StoreAvatar2D", 2, new Object[] { "lifeChange, gameId", Integer.valueOf(i), ((StringBuilder)localObject1).toString() });
              }
              ApolloGameUtil.a(StoreAvatar2D.a(this.this$0), j);
              localObject1 = StoreAvatar2D.a(this.this$0);
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              localObject1 = ((AppInterface)localObject1).getHandler(ChatActivity.class);
              if (localObject1 != null)
              {
                localObject1 = ((MqqHandler)localObject1).obtainMessage(76);
                if (localObject1 != null) {
                  ((Message)localObject1).sendToTarget();
                }
              }
              localJSONObject.put("result", 0);
            }
            else
            {
              localJSONObject.put("result", 1);
              localJSONObject.put("msg", HardCodeUtil.a(2131904572));
            }
          }
          else if (Intrinsics.areEqual("danUpgrade", localObject1))
          {
            localObject1 = StoreAvatar2D.a(this.this$0);
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject1 = ((AppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
            if (localObject1 != null)
            {
              localObject1 = (ApolloExtensionHandler)localObject1;
              localObject2 = StoreAvatar2D.a(this.this$0);
              if (localObject2 == null) {
                Intrinsics.throwNpe();
              }
              ((ApolloExtensionHandler)localObject1).a(((AppInterface)localObject2).getCurrentUin(), '', "refreshAction");
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]StoreAvatar2D", 2, "ipc call danUpgrade,maybe have new slave action");
              }
              localJSONObject.put("result", 0);
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler");
            }
          }
          else if (Intrinsics.areEqual("drawerAudio", localObject1))
          {
            localObject1 = this.b.optJSONObject("data");
            if (localObject1 != null)
            {
              if (((JSONObject)localObject1).has("audio"))
              {
                i = ((JSONObject)localObject1).optInt("audio");
                break label978;
              }
              QLog.e("ApolloJsApi", 1, "drawerVoice has no val");
              i = 0;
              break label978;
              CardDrawerStrategy.a(bool1);
            }
          }
          else if (Intrinsics.areEqual("lastShopScheme", localObject1))
          {
            localObject1 = this.b.optJSONObject("data");
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]StoreAvatar2D", 2, new Object[] { "lastShopScheme, data=", localObject1 });
            }
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("lastShopScheme");
              localObject2 = StoreAvatar2D.a(this.this$0);
              if (localObject2 == null) {
                Intrinsics.throwNpe();
              }
              localObject2 = ((AppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "app!!\n                  …ava, ProcessConstant.ALL)");
              ((IApolloManagerService)localObject2).updateLastShopTabInfo((String)localObject1);
            }
          }
        }
        this.a.a(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("delFavAction json error + ");
        ((StringBuilder)localObject1).append(localJSONException);
        QLog.e("[cmshow]StoreAvatar2D", 1, ((StringBuilder)localObject1).toString());
        this.a.a(null);
        return;
      }
      label978:
      if (i != 0) {
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.writeLocal.1
 * JD-Core Version:    0.7.0.1
 */