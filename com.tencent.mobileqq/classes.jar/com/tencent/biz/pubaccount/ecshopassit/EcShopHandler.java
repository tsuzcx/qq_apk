package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd;

public class EcShopHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public EcShopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqshop.SQQSHPClientRsp();
    try
    {
      ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null) {
      return;
    }
    if (paramArrayOfByte.retcode.get() != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("response from server error: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.retcode.get());
        QLog.e("EcShopHandler", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramArrayOfByte.newusrrecmd.has())
    {
      localObject = (qqshop.SQQSHPNewUserRecmd)paramArrayOfByte.newusrrecmd.get();
      if ((((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.has()) && (((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.get() == 1))
      {
        localObject = ((qqshop.SQQSHPNewUserRecmd)localObject).recmdurl.get();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("newusrrecmd url:");
            paramArrayOfByte.append((String)localObject);
            QLog.i("EcShopHandler", 2, paramArrayOfByte.toString());
          }
          notifyUI(0, true, localObject);
          return;
        }
      }
    }
    if (paramArrayOfByte.recmdlist.has())
    {
      paramArrayOfByte = paramArrayOfByte.recmdlist.get();
      if (paramArrayOfByte.size() > 0)
      {
        notifyUI(0, true, paramArrayOfByte);
        return;
      }
    }
    notifyUI(0, false, null);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    qqshop.SQQSHPClientRsp localSQQSHPClientRsp = new qqshop.SQQSHPClientRsp();
    try
    {
      localSQQSHPClientRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localSQQSHPClientRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.bindlist.has()))
    {
      paramArrayOfByte = paramArrayOfByte.bindlist.get();
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
      {
        paramArrayOfByte = (qqshop.SQQSHPAccoutRelation)paramArrayOfByte.get(0);
        if ((paramArrayOfByte.customerservice.has()) && (paramArrayOfByte.customerservice.get() == 1))
        {
          if ((paramArrayOfByte.binduin.has()) && (paramArrayOfByte.puin.has()))
          {
            EcShopAssistantManager.a.put(String.valueOf(paramArrayOfByte.puin.get()), String.valueOf(paramArrayOfByte.binduin.get()));
            notifyUI(3, true, null);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.i("EcShopHandler", 2, "no bind uin found!");
        }
      }
    }
    else
    {
      notifyUI(3, false, null);
    }
  }
  
  public void a()
  {
    notifyUI(4, true, null);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EcShopHandler", 2, "onReceive data null.");
      }
      return;
    }
    paramIntent = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    if (paramIntent.equals("GetFolderInfo"))
    {
      a(paramArrayOfByte);
      return;
    }
    if (paramIntent.equals("GetShopBindUin")) {
      return;
    }
    if (paramIntent.equals("UserEventReport")) {
      return;
    }
    if (paramIntent.equals("GetShopCustomerservice"))
    {
      b(paramArrayOfByte);
      return;
    }
    if (paramIntent.equals("GetRecommendShop"))
    {
      paramIntent = new qqshop.SQQSHPClientRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        paramIntent.printStackTrace();
        paramIntent = null;
      }
      if ((paramIntent != null) && (paramIntent.rcpuin.has())) {
        notifyUI(5, true, String.valueOf(paramIntent.rcpuin.get()));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("EcShopHandler", 2, "EcShopHandler onReceive cmd cannot be recognized");
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "getShopUinServantInfo empty uin.");
      }
      return;
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.add(Long.valueOf(paramString));
    paramString = new NewIntent(this.a.getApp(), EcShopServlet.class);
    paramString.putExtra("cmd", "GetShopCustomerservice");
    paramString.putExtra("data", localSQQSHPClientReq.toByteArray());
    paramString.putExtra("timeout", 30000);
    this.a.startServlet(paramString);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EcShopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopHandler
 * JD-Core Version:    0.7.0.1
 */