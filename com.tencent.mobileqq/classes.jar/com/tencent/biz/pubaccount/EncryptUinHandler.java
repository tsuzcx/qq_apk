package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinReqBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinResult;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinRspBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.ReqBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.RspBody;

public class EncryptUinHandler
  extends BusinessHandler
{
  private EncryptUinHandler.EncryptUinObserver jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$EncryptUinObserver;
  private EncryptUinHandler.GetEncryptUinCallback jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$GetEncryptUinCallback;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public EncryptUinHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public EncryptUinHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private void a(List<Long> paramList, int paramInt)
  {
    oidb_0xc13.ReqBody localReqBody = new oidb_0xc13.ReqBody();
    localReqBody.msg_encrypt_uin_req_body.rpt_uint64_uin.set(paramList);
    localReqBody.msg_encrypt_uin_req_body.setHasFlag(true);
    paramList = makeOIDBPkg("OidbSvc.0xc13", 3091, 1, localReqBody.toByteArray());
    paramList.addAttribute("ARGS_TYPE", Integer.valueOf(paramInt));
    sendPbReq(paramList);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$EncryptUinObserver == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$EncryptUinObserver = new EncryptUinHandler.2(this);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$EncryptUinObserver);
      ThreadManager.excute(new EncryptUinHandler.3(this), 128, null, true);
    }
  }
  
  public void a(EncryptUinHandler.GetEncryptUinCallback paramGetEncryptUinCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$GetEncryptUinCallback = paramGetEncryptUinCallback;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EncryptUinHandler.EncryptUinObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler$EncryptUinObserver);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xc13.RspBody();
    Bundle localBundle = new Bundle();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int i = 0;
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive: isSuccess=");
      paramFromServiceMsg.append(bool);
      paramFromServiceMsg.append(", code=");
      paramFromServiceMsg.append(j);
      QLog.d("EncryptUinHandler", 2, paramFromServiceMsg.toString());
    }
    if (bool)
    {
      localObject = (oidb_0xc13.EncryptUinRspBody)((oidb_0xc13.RspBody)localObject).msg_encrypt_uin_rsp_body.get();
      paramObject = null;
      paramFromServiceMsg = paramObject;
      if (localObject != null)
      {
        localObject = ((oidb_0xc13.EncryptUinRspBody)localObject).rpt_msg_encrypt_result.get();
        paramFromServiceMsg = paramObject;
        if (localObject != null)
        {
          paramFromServiceMsg = paramObject;
          if (!((List)localObject).isEmpty())
          {
            paramObject = new ArrayList();
            localObject = ((List)localObject).iterator();
            for (;;)
            {
              paramFromServiceMsg = paramObject;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              paramFromServiceMsg = (oidb_0xc13.EncryptUinResult)((Iterator)localObject).next();
              EncryptUinInfo localEncryptUinInfo = new EncryptUinInfo();
              localEncryptUinInfo.jdField_a_of_type_Long = paramFromServiceMsg.uint64_original_uin.get();
              localEncryptUinInfo.jdField_a_of_type_Int = paramFromServiceMsg.int32_result.get();
              if (paramFromServiceMsg.bytes_encrypt_uin.get() != null) {
                localEncryptUinInfo.jdField_a_of_type_JavaLangString = paramFromServiceMsg.bytes_encrypt_uin.get().toStringUtf8();
              }
              paramObject.add(localEncryptUinInfo);
            }
          }
        }
      }
      localBundle.putParcelableArrayList("KEY_ENCRYPT_RESULT_LIST", paramFromServiceMsg);
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("ARGS_TYPE");
    if (paramToServiceMsg != null) {
      i = ((Integer)paramToServiceMsg).intValue();
    }
    notifyUI(i, bool, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinHandler
 * JD-Core Version:    0.7.0.1
 */