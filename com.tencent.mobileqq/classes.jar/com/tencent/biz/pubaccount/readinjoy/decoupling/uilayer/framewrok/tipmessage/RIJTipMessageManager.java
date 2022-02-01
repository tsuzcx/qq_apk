package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgCard;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgUI;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.studymode.StudyModeManager;
import mqq.app.AppRuntime;

public class RIJTipMessageManager
{
  private RIJTipMessageManager.Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder;
  private KandianMergeManager.MessageObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver;
  private KandianMergeManager.OnTabRedNumsChangeListenner jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$OnTabRedNumsChangeListenner;
  private ReadinjoySocialMsgUI jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI;
  
  public RIJTipMessageManager(RIJTipMessageManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder = paramBuilder;
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI == null) {
      if (RIJMsgBoxUtils.b() != 2) {
        break label98;
      }
    }
    label98:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI = new ReadinjoySocialMsgCard(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a());; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI = new ReadinjoySocialMsgTips(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a(), LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a()).inflate(2131560398, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a(), false)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.a(new RIJTipMessageManager.4(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a().addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a().postInvalidate();
      return;
    }
  }
  
  private void l()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      c();
      return;
    }
    a(localKandianMsgBoxRedPntInfo);
  }
  
  public RIJTipMessageManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver = new RIJTipMessageManager.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$OnTabRedNumsChangeListenner = new RIJTipMessageManager.2(this);
  }
  
  public void b()
  {
    if (RIJMsgBoxUtils.b() == 0) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a() != 0) || (StudyModeManager.a())) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      l();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJTipMessageManager.3(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a().removeHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a().postInvalidate();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgUI = null;
    }
    f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver = null;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager$Builder.a().d();
    g();
  }
  
  public void f()
  {
    g();
    h();
  }
  
  public void g()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver);
  }
  
  public void h()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$OnTabRedNumsChangeListenner);
  }
  
  public void i()
  {
    j();
    k();
  }
  
  public void j()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver);
  }
  
  public void k()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$OnTabRedNumsChangeListenner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager
 * JD-Core Version:    0.7.0.1
 */