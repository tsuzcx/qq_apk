package com.tencent.mobileqq.app.friendlist.receiver;

import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.net.parser.NetBaseParser;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x972.oidb_0x972.RspBody;
import unite.DynamicSearch.ResultItemGroup;

public class SearchFriendReceiver
  extends BaseHandlerReceiver
{
  public SearchFriendReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("search_version");
    Object localObject2 = paramToServiceMsg.extraData.getIntArray("search_list");
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = -1;
    if (j == 2)
    {
      bool1 = paramObject instanceof RespSearch & bool1;
      i = 85;
    }
    else if (j == 3)
    {
      bool1 = paramObject instanceof ArrayList & bool1;
      i = 86;
    }
    Object localObject1;
    boolean bool2;
    int k;
    if (bool1)
    {
      localObject1 = (RespHead)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (localObject1 != null)
      {
        j = ((RespHead)localObject1).iResult;
        localObject1 = ((RespHead)localObject1).strErrorMsg;
      }
      else
      {
        bool1 = false;
        localObject1 = null;
        j = 0;
      }
      bool2 = paramToServiceMsg.extraData.getBoolean("search_decode");
      k = j;
    }
    else
    {
      localObject1 = null;
      k = 0;
      bool2 = false;
    }
    paramFromServiceMsg = (RespSearch)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
    if (paramFromServiceMsg != null)
    {
      int m = paramFromServiceMsg.result;
      j = m;
      if (m != 1) {
        break label344;
      }
      if (localObject2 == ContactSearchFacade.a)
      {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 1, "handleSearchFriend search troop and hit TwiLight");
      }
      else
      {
        localObject2 = new DynamicSearch.ResultItemGroup();
        try
        {
          ((DynamicSearch.ResultItemGroup)localObject2).mergeFrom(paramFromServiceMsg.weiguang);
          paramFromServiceMsg = new ArrayList();
          paramFromServiceMsg.add(localObject2);
          paramFromServiceMsg = new NetBaseParser().a(new Object[] { paramToServiceMsg.extraData.getString("param_keyword"), paramFromServiceMsg, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
          j = m;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          j = m;
          break label344;
        }
      }
    }
    j = 0;
    label344:
    paramFromServiceMsg = null;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleSearchFriend  searchType = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" isSuccess = ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" subId = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" data =");
      ((StringBuilder)localObject2).append(paramObject);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject2).toString());
    }
    a(48, bool1, new Object[] { Integer.valueOf(i), paramObject, Integer.valueOf(k), localObject1, Boolean.valueOf(bool2), Long.valueOf(paramToServiceMsg.extraData.getLong("session_id")), Integer.valueOf(j), paramFromServiceMsg });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    int i;
    if (bool1)
    {
      paramFromServiceMsg = (RespHead)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.iResult;
        paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
      }
      else
      {
        bool2 = false;
      }
    }
    else
    {
      i = 0;
      bool1 = bool2;
    }
    a(72, bool1, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x972.RspBody localRspBody = new oidb_0x972.RspBody();
    FriendListHandler localFriendListHandler = this.a;
    int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleCondSearchFriendNewProto resultCode = ");
      paramObject.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
    }
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (i == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    a(72, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), localRspBody, Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
  }
  
  public boolean a(String paramString)
  {
    return ("SummaryCard.ReqSearch".equals(paramString)) || ("SummaryCard.ReqCondSearch".equals(paramString)) || ("OidbSvc.0x972_5".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("SummaryCard.ReqSearch".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("SummaryCard.ReqCondSearch".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x972_5".equals(str)) {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.SearchFriendReceiver
 * JD-Core Version:    0.7.0.1
 */