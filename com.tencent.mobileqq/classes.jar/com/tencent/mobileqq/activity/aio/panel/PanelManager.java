package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioShortcutBarProvider;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.apollo.api.aio.panel.ICmGamePanelProvider;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;

public class PanelManager
  implements XPanelContainer.PanelCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<PanelProvider<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  
  public PanelManager(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public View a(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.createPanel(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public void a()
  {
    a(new PlusPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new PokeAndEmoPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new HongbaoPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ArkAppManagerPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new PhotoListPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new RelateEmoPanelProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    Object localObject = (ICmGamePanelProvider)QRoute.api(ICmGamePanelProvider.class);
    if (localObject != null)
    {
      ((ICmGamePanelProvider)localObject).init(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      a((PanelProvider)localObject);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof LimitChatPie))) {
      a(new AioShortcutBarProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    }
    a(new QQAssistantProvider());
    localObject = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(105);
    if (localObject != null) {
      a((PanelProvider)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      localPanelProvider.onPanelIconClick(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).onPanelChanged(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  void a(PanelProvider<? extends View> paramPanelProvider)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramPanelProvider.getPanelId(), paramPanelProvider);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
  }
  
  public boolean a(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.isNeedRecreatePanel();
    }
    return false;
  }
  
  public <T extends View> T b(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.getPanel();
    }
    return null;
  }
  
  public void s()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).onHideAllPanel();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelManager
 * JD-Core Version:    0.7.0.1
 */