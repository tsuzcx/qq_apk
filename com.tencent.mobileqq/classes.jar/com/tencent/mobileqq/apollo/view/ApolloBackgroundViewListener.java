package com.tencent.mobileqq.apollo.view;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloBackgroundViewListener
  implements IRenderCallback, OnApolloViewListener
{
  public WeakReference<BaseChatPie> a;
  private WeakReference<IRenderCallback> b;
  
  public ApolloBackgroundViewListener(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onCompleteRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((IRenderCallback)this.b.get()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onStartRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((IRenderCallback)this.b.get()).a(paramInt, paramString);
    }
  }
  
  public void a(IRenderCallback paramIRenderCallback)
  {
    this.b = new WeakReference(paramIRenderCallback);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return;
          localObject2 = (BaseChatPie)this.a.get();
        } while ((localObject2 == null) || (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null));
        localObject1 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a();
      } while ((localObject1 == null) || (localObject2 == null));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBackgroundViewListener", 2, "surfaceView.getWidth():" + ((ApolloTextureView)localObject2).getWidth());
      }
      ((ApolloTextureView)localObject2).getRenderImpl().a(1, null, 0, 1.0F, 250.0F, 0.0F);
      ((ApolloTextureView)localObject2).getRenderImpl().a(1000L);
      localObject1 = ((SpriteScriptManagerImpl)((AppInterface)localObject1).getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
    } while (localObject1 == null);
    ((SpriteBackgroundManager)localObject1).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloBackgroundViewListener
 * JD-Core Version:    0.7.0.1
 */