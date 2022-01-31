import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendHandler.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.EntryDelay;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendCard;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendPerson;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.ReqBody;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RspBody;

public class arxh
  extends ajfb
{
  private arxi a;
  
  public arxh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = ((arxi)paramQQAppInterface.getManager(347));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    Object localObject1;
    int i;
    int j;
    long l1;
    long l2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool = true;
      localObject1 = new oidb_cmd0xdcc.RspBody();
      i = -1;
      if (!bool) {
        break label1169;
      }
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
      i = j;
      if (j == 0) {
        break label1169;
      }
      i = j;
      bool = false;
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberRecommend.Handler", 2, "handleGetTroopMemRecommendCards, isSuc=" + bool + ",oidbesult=" + i);
      }
      l1 = 0L;
      paramFromServiceMsg = new ArrayList();
      if (bool) {
        l2 = l1;
      }
    }
    Object localObject2;
    int k;
    for (;;)
    {
      long l4;
      try
      {
        paramToServiceMsg = ((oidb_cmd0xdcc.RspBody)localObject1).rpt_msg_recommend_card.get();
        l2 = l1;
        localObject2 = ((oidb_cmd0xdcc.RspBody)localObject1).rpt_msg_entry_delay.get();
        l2 = l1;
        if (!((oidb_cmd0xdcc.RspBody)localObject1).uint64_group_id.has()) {
          break label503;
        }
        l2 = l1;
        l1 = ((oidb_cmd0xdcc.RspBody)localObject1).uint64_group_id.get();
        l2 = l1;
        if (!((oidb_cmd0xdcc.RspBody)localObject1).uint32_timestamp.has()) {
          break label509;
        }
        l2 = l1;
        l3 = ((oidb_cmd0xdcc.RspBody)localObject1).uint32_timestamp.get();
        l2 = l1;
        paramObject = this.a.a();
        if (localObject2 == null) {
          break label584;
        }
        l2 = l1;
        if (((List)localObject2).size() <= 0) {
          break label584;
        }
        l2 = l1;
        localObject1 = ((List)localObject2).iterator();
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break label584;
        }
        l2 = l1;
        localObject2 = (oidb_cmd0xdcc.EntryDelay)((Iterator)localObject1).next();
        l2 = l1;
        if (!((oidb_cmd0xdcc.EntryDelay)localObject2).em_entry.has()) {
          break label515;
        }
        l2 = l1;
        j = ((oidb_cmd0xdcc.EntryDelay)localObject2).em_entry.get();
        l2 = l1;
        if (!((oidb_cmd0xdcc.EntryDelay)localObject2).uint32_delay.has()) {
          break label521;
        }
        l2 = l1;
        k = ((oidb_cmd0xdcc.EntryDelay)localObject2).uint32_delay.get();
        l4 = k + l3;
        l2 = l1;
        if (QLog.isColorLevel())
        {
          l2 = l1;
          QLog.i("TroopMemberRecommend.Handler", 2, "handleGetTroopMemRecommendCards, nextFetchTS =" + l4);
        }
        if (j != 11) {
          break label528;
        }
        l2 = l1;
        paramObject.edit().putLong("key_LeftSlide_fetch_ts" + String.valueOf(l1), l4).commit();
        continue;
        if (this.a == null) {
          break label496;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TroopMemberRecommend.Handler", 1, "handleGetTroopMemRecommendCards exception, isSuc=" + bool + ",oidbesult=" + i, paramToServiceMsg);
      }
      label474:
      this.a.a(bool, paramFromServiceMsg, String.valueOf(l2));
      label496:
      return;
      bool = false;
      break;
      label503:
      l1 = 0L;
      continue;
      label509:
      long l3 = 0L;
      continue;
      label515:
      j = 0;
      continue;
      label521:
      k = 86400;
      continue;
      label528:
      if (j == 12)
      {
        l2 = l1;
        paramObject.edit().putLong("key_AIO_fetch_ts" + String.valueOf(l1), l4).commit();
      }
    }
    label584:
    oidb_cmd0xdcc.RecommendPerson localRecommendPerson1;
    label685:
    RecommendPerson localRecommendPerson;
    if (paramToServiceMsg != null)
    {
      l2 = l1;
      if (paramToServiceMsg.size() > 0)
      {
        l2 = l1;
        paramObject = paramToServiceMsg.iterator();
        do
        {
          do
          {
            do
            {
              l2 = l1;
              if (!paramObject.hasNext()) {
                break;
              }
              l2 = l1;
              localObject1 = (oidb_cmd0xdcc.RecommendCard)paramObject.next();
              l2 = l1;
              paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject1).rpt_msg_person.get();
            } while (paramToServiceMsg == null);
            l2 = l1;
          } while (paramToServiceMsg.size() <= 0);
          l2 = l1;
          localObject2 = paramToServiceMsg.iterator();
          j = 0;
          l2 = l1;
        } while (!((Iterator)localObject2).hasNext());
        l2 = l1;
        localRecommendPerson1 = (oidb_cmd0xdcc.RecommendPerson)((Iterator)localObject2).next();
        l2 = l1;
        localRecommendPerson = new RecommendPerson();
        l2 = l1;
        localRecommendPerson.troopUin = String.valueOf(l1);
        l2 = l1;
        if (!((oidb_cmd0xdcc.RecommendCard)localObject1).enum_card_id.has()) {
          break label1172;
        }
        l2 = l1;
        k = ((oidb_cmd0xdcc.RecommendCard)localObject1).enum_card_id.get();
        label771:
        l2 = l1;
        localRecommendPerson.cardTypeID = k;
        l2 = l1;
        if (!((oidb_cmd0xdcc.RecommendCard)localObject1).bytes_main_title.has()) {
          break label1178;
        }
        l2 = l1;
        paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject1).bytes_main_title.get().toStringUtf8();
        label813:
        l2 = l1;
        localRecommendPerson.cardMainTitle = paramToServiceMsg;
        l2 = l1;
        if (!((oidb_cmd0xdcc.RecommendCard)localObject1).bytes_sub_title.has()) {
          break label1185;
        }
        l2 = l1;
        paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject1).bytes_sub_title.get().toStringUtf8();
        label854:
        l2 = l1;
        localRecommendPerson.cardSubTitle = paramToServiceMsg;
        l2 = l1;
        if (!((oidb_cmd0xdcc.RecommendCard)localObject1).uint32_show_max.has()) {
          break label1192;
        }
        l2 = l1;
        k = ((oidb_cmd0xdcc.RecommendCard)localObject1).uint32_show_max.get();
        label893:
        l2 = l1;
        localRecommendPerson.cardMaxDisplayPersonNum = k;
        l2 = l1;
        if (!localRecommendPerson1.uint64_uin.has()) {
          break label1198;
        }
        l2 = l1;
        paramToServiceMsg = String.valueOf(localRecommendPerson1.uint64_uin.get());
        label935:
        l2 = l1;
        localRecommendPerson.uin = paramToServiceMsg;
        l2 = l1;
        if (!localRecommendPerson1.bytes_reason.has()) {
          break label1205;
        }
        l2 = l1;
        paramToServiceMsg = localRecommendPerson1.bytes_reason.get().toStringUtf8();
        label976:
        l2 = l1;
        localRecommendPerson.recommendReason = paramToServiceMsg;
        l2 = l1;
        if (!localRecommendPerson1.bytes_keyword.has()) {
          break label1212;
        }
        l2 = l1;
        paramToServiceMsg = localRecommendPerson1.bytes_keyword.get().toStringUtf8();
        label1017:
        l2 = l1;
        localRecommendPerson.recommendKeyword = paramToServiceMsg;
        l2 = l1;
        if (!localRecommendPerson1.bytes_alghrithm.has()) {
          break label1219;
        }
        l2 = l1;
        paramToServiceMsg = localRecommendPerson1.bytes_alghrithm.get().toStringUtf8();
        label1058:
        l2 = l1;
        localRecommendPerson.recommendALghrithm = paramToServiceMsg;
        l2 = l1;
        if (!localRecommendPerson1.bytes_recall.has()) {
          break label1226;
        }
        l2 = l1;
      }
    }
    label1169:
    label1172:
    label1178:
    label1185:
    label1192:
    label1198:
    label1205:
    label1212:
    label1219:
    label1226:
    for (paramToServiceMsg = localRecommendPerson1.bytes_recall.get().toStringUtf8();; paramToServiceMsg = "")
    {
      l2 = l1;
      localRecommendPerson.recommendRecall = paramToServiceMsg;
      l2 = l1;
      localRecommendPerson.addedIndex = j;
      l2 = l1;
      paramFromServiceMsg.add(localRecommendPerson);
      j += 1;
      break label685;
      l2 = l1;
      ThreadManager.excute(new TroopMemberRecommendHandler.1(this, l1, paramFromServiceMsg), 32, null, true);
      l2 = l1;
      break label474;
      break;
      k = 0;
      break label771;
      paramToServiceMsg = "";
      break label813;
      paramToServiceMsg = "";
      break label854;
      k = 0;
      break label893;
      paramToServiceMsg = "";
      break label935;
      paramToServiceMsg = "";
      break label976;
      paramToServiceMsg = "";
      break label1017;
      paramToServiceMsg = "";
      break label1058;
    }
  }
  
  public void a(String paramString, int paramInt, List<Long> paramList)
  {
    try
    {
      oidb_cmd0xdcc.ReqBody localReqBody = new oidb_cmd0xdcc.ReqBody();
      localReqBody.uint64_group_id.set(Long.parseLong(paramString));
      localReqBody.em_entry.set(paramInt);
      ArrayList localArrayList = new ArrayList();
      if (paramList != null) {
        localArrayList.addAll(localArrayList);
      }
      localReqBody.rpt_uint64_filter_uin.set(localArrayList);
      paramList = makeOIDBPkg("OidbSvc.oidb_0xdcc", 3532, 1, localReqBody.toByteArray());
      paramList.extraData.putString("troop_uin", paramString);
      sendPbReq(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberRecommend.Handler", 2, "getTroopMemRecommendCards, request =" + paramList);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean a(atmp paramatmp, atmo paramatmo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramatmp.a()) {
      if (paramatmo.getStatus() == 1000)
      {
        paramatmp.b(paramatmo);
        if (paramatmo.getStatus() == 1001) {
          bool1 = true;
        }
        paramatmp.a();
      }
    }
    do
    {
      return bool1;
      if ((paramatmo.getStatus() != 1001) && (paramatmo.getStatus() != 1002)) {
        break;
      }
      bool1 = paramatmp.a(paramatmo);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberRecommend.Handler", 2, "updateEntity em closed e=" + paramatmo.getTableName());
    return false;
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return arxj.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Handler", 2, " onReceive() res =" + paramFromServiceMsg.getServiceCmd());
    }
    if ("OidbSvc.oidb_0xdcc".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arxh
 * JD-Core Version:    0.7.0.1
 */