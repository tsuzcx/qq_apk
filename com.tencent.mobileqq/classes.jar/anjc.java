import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicSearch.ResultItemGroup;

public class anjc
  extends anio
{
  public anjc(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("search_version");
    Object localObject2 = paramToServiceMsg.extraData.getIntArray("search_list");
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (i != 2) {
        break label334;
      }
      bool1 &= paramObject instanceof RespSearch;
      i = 87;
    }
    for (;;)
    {
      label55:
      int m = 0;
      Object localObject1;
      int j;
      label107:
      boolean bool2;
      int k;
      if (bool1)
      {
        localObject1 = (RespHead)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (localObject1 != null)
        {
          j = ((RespHead)localObject1).iResult;
          localObject1 = ((RespHead)localObject1).strErrorMsg;
          bool2 = paramToServiceMsg.extraData.getBoolean("search_decode");
          k = j;
        }
      }
      for (;;)
      {
        paramFromServiceMsg = (RespSearch)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
        j = m;
        if (paramFromServiceMsg != null)
        {
          m = paramFromServiceMsg.result;
          j = m;
          if (m == 1) {
            if (localObject2 == ahyh.a)
            {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 1, "handleSearchFriend search troop and hit TwiLight");
              j = 0;
            }
          }
        }
        for (paramFromServiceMsg = null;; paramFromServiceMsg = null) {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSearchFriend  searchType = " + i + " isSuccess = " + bool1 + " subId = " + j + " data =" + paramObject);
            }
            a(49, bool1, new Object[] { Integer.valueOf(i), paramObject, Integer.valueOf(k), localObject1, Boolean.valueOf(bool2), Long.valueOf(paramToServiceMsg.extraData.getLong("session_id")), Integer.valueOf(j), paramFromServiceMsg });
            return;
            bool1 = false;
            break;
            label334:
            if (i != 3) {
              break label483;
            }
            bool1 &= paramObject instanceof ArrayList;
            i = 88;
            break label55;
            j = 0;
            bool1 = false;
            localObject1 = null;
            break label107;
            localObject2 = new DynamicSearch.ResultItemGroup();
            try
            {
              ((DynamicSearch.ResultItemGroup)localObject2).mergeFrom(paramFromServiceMsg.weiguang);
              paramFromServiceMsg = new ArrayList();
              paramFromServiceMsg.add(localObject2);
              paramFromServiceMsg = new bbap().a(new Object[] { paramToServiceMsg.extraData.getString("param_keyword"), paramFromServiceMsg, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
              j = m;
            }
            catch (Exception paramFromServiceMsg)
            {
              paramFromServiceMsg.printStackTrace();
              j = m;
            }
          }
        }
        k = 0;
        localObject1 = null;
        bool2 = false;
      }
      label483:
      i = -1;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label135;
      }
      paramFromServiceMsg = (RespHead)this.a.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label126;
      }
      i = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
      return;
      bool = false;
      break;
      label126:
      i = 0;
      bool = false;
      continue;
      label135:
      i = 0;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("SummaryCard.ReqSearch".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"SummaryCard.ReqCondSearch".equals(str)) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(String paramString)
  {
    return ("SummaryCard.ReqSearch".equals(paramString)) || ("SummaryCard.ReqCondSearch".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjc
 * JD-Core Version:    0.7.0.1
 */