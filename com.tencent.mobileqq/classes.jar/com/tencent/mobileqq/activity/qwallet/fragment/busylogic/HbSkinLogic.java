package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import Wallet.SkinInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class HbSkinLogic
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705458);
  private int jdField_a_of_type_Int = -1;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new HbSkinLogic.3(this);
  private SendHbActivity jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity;
  private HbSkinInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo = HbSkinInfo.HbSkinFactory.a(jdField_a_of_type_JavaLangString);
  private IRedPacket.OnGetSkinListener jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener = new HbSkinLogic.2(this);
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = null;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  List<HbSkinLogic.ItemSelectListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new HbSkinLogic.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private List<HbSkinInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private List<LinearLayout> c = new ArrayList();
  
  public HbSkinLogic(SendHbActivity paramSendHbActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity = paramSendHbActivity;
    d();
  }
  
  private void a(List<HbSkinInfo> paramList)
  {
    paramList.add(HbSkinInfo.HbSkinFactory.b(jdField_a_of_type_JavaLangString));
    if ((b()) && (!paramList.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo)))
    {
      QLog.d("HbSkinLogic", 2, "add vip info to list!");
      paramList.add(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo);
    }
  }
  
  private void b(List<HbSkinInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinInfo localSkinInfo = ((HbSkinInfo)paramList.next()).jdField_a_of_type_WalletSkinInfo;
      RedPacketInfoBase localRedPacketInfoBase = new RedPacketInfoBase();
      localRedPacketInfoBase.skinType = 1;
      localRedPacketInfoBase.skinId = localSkinInfo.skin_id;
      localRedPacketInfoBase.isCache = HbSkinInfo.jdField_a_of_type_Boolean;
      RedPacketManager.getInstance().getSkin(localRedPacketInfoBase, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener);
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a();
    }
    return false;
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = new QwAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity, localArrayList, 2131560637, new HbSkinLogic.HbSkinHolder(this));
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getAppRuntime().getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER));
    RedPacketManager.getInstance().registRedPacketSkinListObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    ApngImage.playByTag(0);
  }
  
  public int a()
  {
    return HbSkinInfo.a(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList());
  }
  
  public void a()
  {
    QLog.i("HbSkinLogic", 2, "onDestroy called...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity = null;
    this.c.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList().clear();
    RedPacketManager.getInstance().unregistRedPacketSkinListObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    if (RedPacketManager.getInstance().isRiskSwitchOpen()) {}
    do
    {
      return;
      b(0);
    } while (this.jdField_b_of_type_Boolean);
    QLog.i("HbSkinLogic", 2, "request skin list...");
    String str = paramBundle.getString("hb_from_type", "");
    if ("100".equals(str))
    {
      paramBundle = paramBundle.getString("hb_from", "");
      RedPacketManager.getInstance().requestRedPacketSkinList(str, paramBundle, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      RedPacketManager.getInstance().requestRedPacketSkinList();
    }
  }
  
  public void a(View paramView)
  {
    this.c.remove(paramView);
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.c.add(paramLinearLayout);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(226.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getResources()));
    HorizontalListView localHorizontalListView = new HorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity);
    localHorizontalListView.setDividerWidth(AIOUtils.a(12.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getResources()));
    paramLinearLayout.addView(localHorizontalListView, localLayoutParams);
    localHorizontalListView.setAdapter(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter);
    localHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
  }
  
  public void a(HbSkinLogic.ItemSelectListener paramItemSelectListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramItemSelectListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    int i = a();
    QLog.i("HbSkinLogic", 2, "set select skin: " + i);
    if (this.jdField_b_of_type_Int != i)
    {
      QLog.i("HbSkinLogic", 2, "set select skin id : " + i + " serverSkinId = " + this.jdField_b_of_type_Int);
      RedPacketManager.getInstance().setSelectedSkin(i, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    if (-2 != i)
    {
      QLog.i("HbSkinLogic", 2, "clear vip info...");
      if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(0, 0, true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ViewGroup)((LinearLayout)localIterator.next()).getParent()).setVisibility(paramInt);
    }
  }
  
  public void c()
  {
    List localList = this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList();
    QLog.d("HbSkinLogic", 2, "is vip: " + b());
    if (b()) {
      if (!localList.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo))
      {
        QLog.d("HbSkinLogic", 2, "add vip info to list!");
        localList.add(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo);
        HbSkinInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id;
        HbSkinInfo.a(localList);
        this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
      }
    }
    while (!localList.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo)) {
      return;
    }
    QLog.d("HbSkinLogic", 2, "remove vip info to list!");
    localList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo);
    HbSkinInfo.c = 0;
    HbSkinInfo.a(localList);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinLogic
 * JD-Core Version:    0.7.0.1
 */