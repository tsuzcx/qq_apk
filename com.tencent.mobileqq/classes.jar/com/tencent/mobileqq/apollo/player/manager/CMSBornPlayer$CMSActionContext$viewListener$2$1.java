package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$viewListener$2$1", "Lcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;", "onNotifyLongTouch", "", "name", "", "onNotifyStatusChanged", "clickPart", "", "apolloId", "onSurfaceReady", "w", "h", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$CMSActionContext$viewListener$2$1
  implements OnApolloViewListener
{
  public void onNotifyLongTouch(@Nullable String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, @Nullable String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "onSurfaceReady, " + this.a.this$0.a().d() + " width:" + paramInt1 + ", height:" + paramInt2);
    this.a.this$0.a().invoke(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.viewListener.2.1
 * JD-Core Version:    0.7.0.1
 */