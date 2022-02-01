package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class ReqDpcInfoNewItem
  implements CheckUpdateItemInterface
{
  private AppInterface a;
  
  public ReqDpcInfoNewItem(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    QLog.i("ReqDpcInfoNewItem", 1, "getCheckUpdateItemData");
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 117;
    localReqItem.cOperType = 1;
    byte[] arrayOfByte1 = ((IDPCApi)QRoute.api(IDPCApi.class)).buidldReqConfig(this.a).toByteArray();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    PkgTools.dWord2Byte(arrayOfByte2, 0, arrayOfByte1.length + 4);
    PkgTools.copyData(arrayOfByte2, 4, arrayOfByte1, arrayOfByte1.length);
    localReqItem.vecParam = arrayOfByte2;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCheckUpdateItemData");
    ((StringBuilder)localObject).append(paramRespItem.cResult);
    QLog.i("ReqDpcInfoNewItem", 1, ((StringBuilder)localObject).toString());
    if (paramRespItem.eServiceID == 117)
    {
      int i = paramRespItem.cResult;
      int j = 0;
      if (i == 2)
      {
        localObject = WupUtil.b(paramRespItem.vecUpdate);
        i = j;
        if (localObject != null)
        {
          paramRespItem = new ConfigurationService.RespGetConfig();
          try
          {
            paramRespItem.mergeFrom((byte[])localObject);
          }
          catch (InvalidProtocolBufferMicroException paramRespItem)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("error: ");
              ((StringBuilder)localObject).append(paramRespItem.getMessage());
              QLog.e("ReqDpcInfoNewItem", 2, ((StringBuilder)localObject).toString());
            }
            paramRespItem.printStackTrace();
            paramRespItem = null;
          }
          i = j;
          if (paramRespItem != null)
          {
            i = j;
            if (paramRespItem.result.get() == 0) {
              if ((paramRespItem.config_list != null) && (paramRespItem.config_list.size() > 0))
              {
                ((IDPCApi)QRoute.api(IDPCApi.class)).onDPCResponse(paramRespItem, this.a.getCurrentAccountUin());
                i = 1;
              }
              else
              {
                QLog.i("ReqDpcInfoNewItem", 1, "respGetConfig has no contentlist");
                paramRespItem = this.a;
                i = j;
                if ((paramRespItem instanceof QQAppInterface))
                {
                  ((QQStoryHandler)((QQAppInterface)paramRespItem).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1023, true, Boolean.valueOf(false));
                  i = j;
                }
              }
            }
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error happend item.cResult = ");
        ((StringBuilder)localObject).append(paramRespItem.cResult);
        QLog.i("ReqDpcInfoNewItem", 1, ((StringBuilder)localObject).toString());
        i = j;
      }
      if (i == 0) {
        ((IDPCApi)QRoute.api(IDPCApi.class)).nextServerDataState(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqDpcInfoNewItem
 * JD-Core Version:    0.7.0.1
 */