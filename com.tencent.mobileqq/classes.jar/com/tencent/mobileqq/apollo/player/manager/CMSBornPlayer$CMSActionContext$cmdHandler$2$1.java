package com.tencent.mobileqq.apollo.player.manager;

import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$cmdHandler$2$1", "Lcom/tencent/mobileqq/apollo/api/channel/IRequestHandler;", "checkReCreateOnActivityChanged", "", "activity", "Landroid/app/Activity;", "destroyHandler", "", "getHandlePriority", "", "handleCmd", "Lcom/tencent/mobileqq/apollo/aioChannel/HandleResult;", "jsState", "", "cmd", "", "reqData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$CMSActionContext$cmdHandler$2$1
  implements IRequestHandler
{
  public int a()
  {
    return 100;
  }
  
  @Nullable
  public HandleResult a(long paramLong, @Nullable String paramString1, @Nullable String paramString2)
  {
    if (this.a.this$0.a().getLuaState() != paramLong) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return null;
          } while (paramString1 == null);
          switch (paramString1.hashCode())
          {
          default: 
            return null;
          }
        } while (!paramString1.equals("cs.script_action_status_notify.local"));
        paramString1 = new JSONObject(paramString2);
        i = paramString1.optInt("taskId");
        int j = paramString1.optInt("status");
        paramString1 = CMSHelper.a.a(j);
        if (QLog.isColorLevel()) {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 2, "action status notify, " + this.a.this$0.a().d() + " taskId:" + i + ", status:" + paramString1);
        }
      } while (i != this.a.this$0.a().a().a);
      this.a.this$0.a().a(this.a.this$0.a(), paramString1);
      return null;
    } while (!paramString1.equals("cs.first_frame_drawn.local"));
    this.a.this$0.a().a(this.a.this$0.a());
    return null;
  }
  
  public void a() {}
  
  public boolean a(@Nullable Activity paramActivity)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.cmdHandler.2.1
 * JD-Core Version:    0.7.0.1
 */