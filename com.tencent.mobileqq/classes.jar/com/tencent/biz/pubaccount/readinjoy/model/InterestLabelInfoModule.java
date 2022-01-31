package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import lul;
import lum;
import lun;
import luo;
import lup;
import tencent.im.oidb.cmd0x6e4.oidb_cmd0x6e4.ReqBody;
import tencent.im.oidb.cmd0x6e4.oidb_cmd0x6e4.RspBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.ReqBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.RspBody;

public class InterestLabelInfoModule
  extends ReadInJoyEngineModule
{
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public InterestLabelInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    oidb_cmd0x6e5.RspBody localRspBody = new oidb_cmd0x6e5.RspBody();
    boolean bool = false;
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      if (localRspBody.uint64_uin.has()) {
        localRspBody.uint64_uin.get();
      }
      if ((!localRspBody.rpt_uint32_default_interest_label_id_list.has()) || (localRspBody.rpt_uint32_default_interest_label_id_list.get() == null)) {
        break label195;
      }
    }
    label195:
    for (paramFromServiceMsg = localRspBody.rpt_uint32_default_interest_label_id_list.get();; paramFromServiceMsg = null)
    {
      paramToServiceMsg = localObject;
      if (localRspBody.rpt_interest_label_list.has())
      {
        paramToServiceMsg = localObject;
        if (localRspBody.rpt_interest_label_list.get() != null) {
          paramToServiceMsg = ReadInJoyMSFHandlerUtils.a(localRspBody.rpt_interest_label_list.get(), paramFromServiceMsg);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && ((!localRspBody.rpt_uint64_last_interest_label_id_list.has()) || (localRspBody.rpt_uint64_last_interest_label_id_list.get() == null) || (localRspBody.rpt_uint64_last_interest_label_id_list.get().size() <= 0)))
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(true);
        bool = true;
      }
      for (;;)
      {
        a(bool, paramToServiceMsg);
        return;
        paramToServiceMsg = ReadInJoyMSFHandlerUtils.a(null, null);
        continue;
        bool = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new luo(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    oidb_cmd0x6e5.ReqBody localReqBody = new oidb_cmd0x6e5.ReqBody();
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_req_all_interest_label_list.set(paramInt1);
    localReqBody.uint32_req_default_interest_label_id_list.set(paramInt2);
    localReqBody.uint32_req_last_interest_label_id_list.set(paramInt3);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(ReadInJoyOidbHelper.a("OidbSvc.0x6e5", 1765, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e5")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e4")) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList)
  {
    oidb_cmd0x6e4.ReqBody localReqBody = new oidb_cmd0x6e4.ReqBody();
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue();
    localReqBody.uint64_uin.set(l);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)paramList.next()).intValue();
      localReqBody.rpt_uint32_interest_label_ids.add(Integer.valueOf(i));
    }
    a(ReadInJoyOidbHelper.a("OidbSvc.0x6e4", 1764, 0, localReqBody.toByteArray()));
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new lun(this, paramList));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lul(this));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x6e4.RspBody()));
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lum(this, paramList));
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new lup(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule
 * JD-Core Version:    0.7.0.1
 */