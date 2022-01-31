import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.hw.group_mgr.CardInfo;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class ameq
  implements alpg, BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, group_mgr.CardInfo paramCardInfo) {}
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void a(bbuo parambbuo) {}
  
  protected void a(Boolean paramBoolean) {}
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2, byte paramByte) {}
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, String paramString3) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, bcpe parambcpe) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<bcpf> paramArrayList) {}
  
  protected void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, long paramLong, List paramList, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  public void a(boolean paramBoolean, bbyf parambbyf) {}
  
  public void a(boolean paramBoolean, bcxk parambcxk) {}
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString) {}
  
  protected void a(boolean paramBoolean, Long paramLong, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, int paramInt) {}
  
  protected void a(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString1, ArrayList<bcty> paramArrayList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString) {}
  
  protected void a(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<bcwi> paramList, int paramInt) {}
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void b() {}
  
  protected void b(Boolean paramBoolean) {}
  
  protected void b(String paramString) {}
  
  protected void b(String paramString, int paramInt) {}
  
  protected void b(String paramString1, String paramString2) {}
  
  protected void b(String paramString1, String paramString2, String paramString3) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList) {}
  
  protected void b(boolean paramBoolean, List<RecommendTroopItem> paramList) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(String paramString) {}
  
  protected void c(String paramString1, String paramString2) {}
  
  protected void c(String paramString1, String paramString2, String paramString3) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList) {}
  
  protected void c(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(String paramString) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  protected void d(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void d(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList) {}
  
  protected void d(boolean paramBoolean, ArrayList<ahfc> paramArrayList) {}
  
  protected void e(String paramString) {}
  
  protected void e(boolean paramBoolean, String paramString) {}
  
  protected void e(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void f(boolean paramBoolean, String paramString) {}
  
  protected void g(boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    a(paramInt);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    label2418:
    int j;
    switch (paramInt)
    {
    case 4: 
    case 13: 
    case 14: 
    case 17: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 28: 
    case 31: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 42: 
    case 43: 
    case 49: 
    case 78: 
    case 81: 
    case 123: 
    case 124: 
    default: 
    case 2: 
    case 80: 
    case 3: 
    case 5: 
    case 76: 
    case 41: 
    case 7: 
    case 6: 
    case 8: 
    case 9: 
    case 91: 
    case 11: 
    case 50: 
    case 79: 
    case 10: 
    case 16: 
    case 12: 
    case 92: 
    case 93: 
    case 94: 
    case 29: 
    case 15: 
    case 18: 
    case 26: 
    case 19: 
    case 20: 
    case 21: 
    case 51: 
    case 27: 
    case 30: 
    case 62: 
    case 90: 
    case 67: 
    case 33: 
    case 44: 
    case 45: 
    case 32: 
    case 34: 
    case 46: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                        a(paramBoolean);
                                        a();
                                        return;
                                        a();
                                        return;
                                        b(paramBoolean);
                                      } while (paramObject == null);
                                      b(paramBoolean, (ArrayList)paramObject);
                                      return;
                                      localObject1 = (Object[])paramObject;
                                      if (localObject1.length == 5)
                                      {
                                        localObject2 = (String)localObject1[0];
                                        if (localObject1[1] == null) {}
                                        for (paramObject = null;; paramObject = (List)localObject1[1])
                                        {
                                          a((String)localObject2, paramBoolean, paramObject, ((Integer)localObject1[2]).intValue(), ((Long)localObject1[3]).longValue(), ((Integer)localObject1[4]).intValue());
                                          return;
                                        }
                                      }
                                      QLog.d("TroopObserver", 1, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
                                      return;
                                      a(paramBoolean, (List)paramObject);
                                      return;
                                      a(paramBoolean, ((Integer)paramObject).intValue());
                                      return;
                                      localObject1 = (Object[])paramObject;
                                      byte b = ((Byte)localObject1[0]).byteValue();
                                      if (localObject1[1] != null) {}
                                      for (paramObject = (TroopInfo)localObject1[1];; paramObject = null)
                                      {
                                        a(true, b, paramObject, ((Boolean)localObject1[2]).booleanValue());
                                        return;
                                      }
                                      paramObject = (Object[])paramObject;
                                      if ((paramObject[1] instanceof Integer)) {}
                                      for (paramInt = ((Integer)paramObject[1]).intValue(); paramBoolean; paramInt = ((Byte)paramObject[1]).byteValue())
                                      {
                                        a(((Integer)paramObject[0]).intValue(), paramInt, (String)paramObject[2]);
                                        return;
                                      }
                                      a(((Integer)paramObject[0]).intValue(), paramInt);
                                      return;
                                      paramObject = (Object[])paramObject;
                                      if (paramBoolean)
                                      {
                                        a(true, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], (String[])paramObject[3]);
                                        return;
                                      }
                                      a(false, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], null);
                                      return;
                                      a(paramBoolean, (String)paramObject);
                                      return;
                                      try
                                      {
                                        paramObject = (Object[])paramObject;
                                        a(paramBoolean, (Long)paramObject[0], (List)paramObject[1]);
                                        return;
                                      }
                                      catch (Exception paramObject) {}
                                    } while (!QLog.isColorLevel());
                                    QLog.d("onGetInvitedUinList", 2, paramObject.toString());
                                    return;
                                    if (paramObject != null)
                                    {
                                      localObject1 = (Object[])paramObject;
                                      paramObject = (ArrayList)localObject1[0];
                                      localObject1 = (Boolean)localObject1[1];
                                      if (QLog.isColorLevel()) {
                                        QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
                                      }
                                      if (QLog.isColorLevel()) {
                                        QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = " + localObject1);
                                      }
                                      a(paramBoolean, paramObject);
                                      a(paramBoolean, paramObject, ((Boolean)localObject1).booleanValue());
                                      return;
                                    }
                                    a(paramBoolean, null);
                                    a(paramBoolean, null, false);
                                  } while (!QLog.isColorLevel());
                                  QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
                                  return;
                                  b(paramBoolean, paramObject);
                                  return;
                                  c(paramBoolean, paramObject);
                                  return;
                                  paramObject = (Object[])paramObject;
                                  if ((paramObject != null) && (paramObject.length > 1))
                                  {
                                    a(paramBoolean, (ArrayList)paramObject[0], (String)paramObject[1]);
                                    return;
                                  }
                                  a(paramBoolean, null, "");
                                  return;
                                  c(paramBoolean, (ArrayList)paramObject);
                                  return;
                                  try
                                  {
                                    paramObject = (Object[])paramObject;
                                    a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
                                    return;
                                  }
                                  catch (Exception paramObject) {}
                                } while (!QLog.isColorLevel());
                                QLog.d("Q.troopinfo", 2, paramObject.toString());
                                return;
                                try
                                {
                                  paramObject = (Object[])paramObject;
                                  a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (oidb_0x88d.GroupInfo)paramObject[4]);
                                  return;
                                }
                                catch (Exception paramObject) {}
                              } while (!QLog.isColorLevel());
                              QLog.d("oidb_0x91a_1", 2, paramObject.toString());
                              return;
                              paramObject = (Object[])paramObject;
                              if ((paramObject != null) && (paramObject.length > 1))
                              {
                                a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
                                return;
                              }
                              a(paramBoolean, -1, "");
                              return;
                              try
                              {
                                paramObject = (Object[])paramObject;
                                c(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                                return;
                              }
                              catch (Exception paramObject) {}
                            } while (!QLog.isColorLevel());
                            QLog.d("oidb_0x91a_1", 2, paramObject.toString());
                            return;
                            b(paramBoolean, (ArrayList)paramObject);
                            return;
                            paramObject = (amer)paramObject;
                            a(paramObject.jdField_a_of_type_Long, paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean, paramObject.jdField_a_of_type_JavaLangString, paramObject.b, paramObject.c);
                            return;
                            paramObject = (Object[])paramObject;
                            localObject1 = new Object[2];
                            if (paramObject.length == 7)
                            {
                              localObject1[0] = paramObject[5];
                              localObject1[1] = paramObject[6];
                            }
                            a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (Object[])localObject1);
                            return;
                            paramObject = (Object[])paramObject;
                            a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                            return;
                            paramObject = (Object[])paramObject;
                            a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
                            return;
                            paramObject = (Object[])paramObject;
                            b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
                            return;
                            paramObject = (Object[])paramObject;
                            a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                            return;
                            paramObject = (Object[])paramObject;
                            b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                            return;
                            if (paramBoolean)
                            {
                              paramObject = (Object[])paramObject;
                              a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                              return;
                            }
                            a(false, null, -1);
                            return;
                          } while (!(paramObject instanceof Object[]));
                          paramObject = (Object[])paramObject;
                          a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
                          return;
                        } while (!(paramObject instanceof Object[]));
                        paramObject = (Object[])paramObject;
                        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
                        return;
                      } while (!(paramObject instanceof Object[]));
                      d(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                      return;
                    } while (!(paramObject instanceof Object[]));
                    paramObject = (Object[])paramObject;
                  } while (paramObject.length != 3);
                  a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
                  return;
                  if (!paramBoolean) {
                    break;
                  }
                } while (!(paramObject instanceof Object[]));
                paramObject = (Object[])paramObject;
                a(paramBoolean, ((Long)paramObject[0]).longValue(), (RespBatchProcess)paramObject[1]);
                return;
                a(paramBoolean, -1L, null);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              paramInt = ((Integer)paramObject[0]).intValue();
              localObject1 = (ArrayList)paramObject[1];
              a(paramBoolean, paramInt, (ArrayList)localObject1);
              if (paramObject.length > 2)
              {
                a(paramBoolean, paramInt, (ArrayList)localObject1, (String)paramObject[2]);
                return;
              }
              a(paramBoolean, paramInt, (ArrayList)localObject1, null);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
            return;
          } while (!(paramObject instanceof Object[]));
          localObject2 = (Object[])paramObject;
          localObject1 = null;
          paramObject = localObject1;
          if (localObject2.length >= 3)
          {
            paramObject = localObject1;
            if ((localObject2[2] instanceof String)) {
              paramObject = (String)localObject2[2];
            }
          }
          c(paramBoolean, paramObject);
          return;
        } while (!(paramObject instanceof Object[]));
        Object[] arrayOfObject = (Object[])paramObject;
        localObject2 = null;
        localObject3 = null;
        localObject1 = localObject2;
        paramObject = localObject3;
        if (arrayOfObject.length >= 3)
        {
          localObject1 = localObject2;
          paramObject = localObject3;
          if ((arrayOfObject[2] instanceof TroopInfo))
          {
            localObject1 = (TroopInfo)arrayOfObject[2];
            paramObject = (String)arrayOfObject[5];
          }
        }
        a(paramBoolean, (TroopInfo)localObject1, paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject2 = (Object[])paramObject;
      paramObject = null;
      i = -1;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          localObject1 = (List)localObject2[4];
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          if ((localObject2[2] instanceof String)) {
            paramObject = (String)localObject2[2];
          }
          if ((localObject2[1] instanceof Integer)) {
            i = ((Integer)localObject2[1]).intValue();
          }
          if ((localObject2[0] instanceof String))
          {
            localObject3 = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = localObject3;
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, paramObject, paramInt, (String)localObject1, i, (List)localObject2);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      localObject2 = (Object[])paramObject;
      paramObject = null;
      i = -1;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          localObject1 = (List)localObject2[4];
          label2581:
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          if ((localObject2[2] instanceof String)) {
            paramObject = (String)localObject2[2];
          }
          if ((localObject2[1] instanceof Integer)) {
            i = ((Integer)localObject2[1]).intValue();
          }
          if ((localObject2[0] instanceof String))
          {
            localObject3 = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = localObject3;
          }
        }
      }
      for (;;)
      {
        b(paramBoolean, paramObject, paramInt, (String)localObject1, i, (List)localObject2);
        return;
        a(paramBoolean, (bcxk)paramObject);
        return;
        long l;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length > 0)
          {
            l = ((Long)paramObject[0]).longValue();
            label2736:
            if (paramObject.length > 1) {
              paramInt = ((Integer)paramObject[1]).intValue();
            }
          }
        }
        for (;;)
        {
          b(paramBoolean, l, paramInt);
          return;
          localObject2 = null;
          localObject1 = localObject2;
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            localObject1 = localObject2;
            if (paramObject.length > 0) {
              localObject1 = (bbyf)paramObject[0];
            }
          }
          a(paramBoolean, (bbyf)localObject1);
          return;
          i = 0;
          paramInt = i;
          if (paramObject != null)
          {
            paramInt = i;
            if ((paramObject instanceof Integer)) {
              paramInt = ((Integer)paramObject).intValue();
            }
          }
          b(paramBoolean, paramInt);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ArrayList)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue());
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ProfileActivity.AllInOne)paramObject[6]);
          return;
          a(Boolean.valueOf(paramBoolean));
          return;
          b(Boolean.valueOf(paramBoolean));
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(Boolean.valueOf(paramBoolean), (ArrayList)paramObject[0], (List)paramObject[1]);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
          return;
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (String)paramObject[6], (String)paramObject[7]);
            return;
          }
          a(paramBoolean, null, null, 0, 0, 0, 0, null, null);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          localObject1 = (String)paramObject[0];
          ((Integer)paramObject[1]).intValue();
          paramInt = -1;
          if (paramBoolean) {
            paramInt = ((Integer)paramObject[2]).intValue();
          }
          b(paramBoolean, (String)localObject1, paramInt);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          paramInt = ((Integer)paramObject[0]).intValue();
          localObject1 = (List)paramObject[1];
          if (paramObject.length >= 3)
          {
            a(paramBoolean, paramInt, (List)localObject1, (List)paramObject[2]);
            return;
          }
          a(paramBoolean, paramInt, (List)localObject1, null);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          localObject1 = (String)paramObject[0];
          boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
          localObject2 = (String)paramObject[2];
          localObject3 = (String)paramObject[3];
          boolean bool1 = false;
          if (paramObject.length >= 5) {
            bool1 = ((Boolean)paramObject[4]).booleanValue();
          }
          a(paramBoolean, (String)localObject1, bool2, (String)localObject2, (String)localObject3, bool1);
          return;
          a(paramBoolean, paramObject);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          bool1 = ((Boolean)paramObject[0]).booleanValue();
          bool2 = ((Boolean)paramObject[1]).booleanValue();
          boolean bool3 = ((Boolean)paramObject[2]).booleanValue();
          a((String)paramObject[3], paramBoolean, bool1, bool2, bool3);
          return;
          if ((paramObject == null) || (!(paramObject instanceof String))) {
            break;
          }
          b((String)paramObject);
          return;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          b((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
          return;
          if ((paramObject instanceof String))
          {
            a((String)paramObject);
            return;
          }
          a(null);
          return;
          if ((paramObject instanceof Long))
          {
            a(paramBoolean, ((Long)paramObject).longValue());
            return;
          }
          a(paramBoolean, 0L);
          return;
          c((String)paramObject);
          return;
          if (paramBoolean)
          {
            a(0, "", (group_mgr.CardInfo)paramObject);
            return;
          }
          paramObject = (Object[])paramObject;
          a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], null);
          return;
          paramObject = (Object[])paramObject;
          a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          localObject1 = new RecvGVideoLevelInfo[paramObject.length];
          paramInt = 0;
          while (paramInt < localObject1.length)
          {
            localObject1[paramInt] = ((RecvGVideoLevelInfo)paramObject[paramInt]);
            paramInt += 1;
          }
          a((RecvGVideoLevelInfo[])localObject1);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
          return;
          paramObject = (Object[])paramObject;
          c((String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          if (paramObject.length > 3)
          {
            a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue());
            return;
          }
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), false, 0, 0);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
          return;
          b(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
          return;
          a(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
          return;
          paramObject = (Object[])paramObject;
          d(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), ((Long)paramObject[9]).longValue());
          return;
          a((bbuo)paramObject);
          return;
          paramObject = (Object[])paramObject;
          d(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          c(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
          return;
          paramObject = (Object[])paramObject;
          b(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          b(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          c(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          c(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), (HashMap)paramObject[6], (List)paramObject[7]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
          return;
          localObject1 = (Object[])paramObject;
          if (localObject1[2] != null) {}
          for (paramObject = (List)localObject1[2];; paramObject = null)
          {
            a(paramBoolean, (String)localObject1[0], ((Integer)localObject1[1]).intValue(), paramObject);
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue());
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
            return;
            paramObject = (Pair)paramObject;
            a(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
            return;
            b();
            return;
            d((String)((Object[])(Object[])paramObject)[0]);
            return;
            paramObject = (Object[])paramObject;
            a((oidb_0xaf4.RspBody)paramObject[0], ((Integer)paramObject[1]).intValue());
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4]);
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
            return;
            e(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
            return;
            paramObject = (Object[])paramObject;
            b(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
            return;
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], (String)paramObject[1]);
            return;
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], (List)paramObject[1]);
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, (homework.RspSend1V1Msg)paramObject[0], (homework.ReqSend1V1Msg)paramObject[1]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            b(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            b((String)paramObject[0], ((Integer)paramObject[1]).intValue());
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            e((String)((Object[])(Object[])paramObject)[0]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            f(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
            return;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Integer)paramObject[4]).intValue());
              return;
            }
            a(false, -1, 0, 0, null, 0);
            return;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              if (paramObject.length >= 2)
              {
                a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
                return;
              }
              a(false, 0L, null);
              return;
            }
            a(false, 0L, null);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 3) {
              break;
            }
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 3) {
              break;
            }
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (bcpe)paramObject[2]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 4) {
              break;
            }
            paramInt = ((Integer)paramObject[3]).intValue();
            if (paramInt == 0)
            {
              b(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
              return;
            }
            if (paramInt != 1) {
              break;
            }
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 3) {
              break;
            }
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            localObject3 = (Object[])paramObject;
            if (localObject3.length < 4) {
              break;
            }
            paramObject = (Boolean)localObject3[0];
            localObject1 = (String)localObject3[1];
            localObject2 = (String)localObject3[2];
            localObject3 = (String)localObject3[3];
            if (paramObject.booleanValue())
            {
              c((String)localObject1, (String)localObject2, (String)localObject3);
              return;
            }
            a((String)localObject1, (String)localObject2, (String)localObject3);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length != 2) {
              break;
            }
            a((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
            return;
            localObject1 = "";
            if ((paramObject instanceof Object[])) {
              localObject1 = (String)((Object[])(Object[])paramObject)[0];
            }
            g(paramBoolean, (String)localObject1);
            return;
            localObject1 = "";
            localObject2 = "";
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              localObject1 = (String)paramObject[0];
              localObject2 = (String)paramObject[1];
            }
            e(paramBoolean, (String)localObject1, (String)localObject2);
            return;
            paramInt = -1;
            l = 0L;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              paramInt = ((Integer)paramObject[0]).intValue();
              l = ((Long)paramObject[1]).longValue();
            }
            a(paramBoolean, paramInt, l);
            return;
            bool1 = true;
            if ((paramObject instanceof Object[])) {
              bool1 = ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue();
            }
            c(paramBoolean, bool1);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            l = ((Long)paramObject[0]).longValue();
            paramInt = ((Integer)paramObject[1]).intValue();
            i = ((Integer)paramObject[2]).intValue();
            paramObject = (ArrayList)paramObject[3];
            if (i == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              a(paramBoolean, l, paramInt, bool1, paramObject);
              return;
            }
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            paramInt = ((Integer)paramObject[0]).intValue();
            localObject1 = (String)paramObject[1];
            i = ((Integer)paramObject[2]).intValue();
            j = ((Integer)paramObject[3]).intValue();
            localObject2 = (ArrayList)paramObject[4];
            bool2 = ((Boolean)paramObject[5]).booleanValue();
            if (j == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              a(paramBoolean, paramInt, (String)localObject1, i, bool1, (ArrayList)localObject2, bool2);
              return;
            }
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            paramInt = ((Integer)paramObject[0]).intValue();
            i = ((Integer)paramObject[1]).intValue();
            j = ((Integer)paramObject[2]).intValue();
            localObject1 = (ArrayList)paramObject[3];
            bool2 = ((Boolean)paramObject[4]).booleanValue();
            if (j == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              a(paramBoolean, paramInt, i, bool1, (ArrayList)localObject1, bool2);
              return;
            }
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 2) {
              break;
            }
            b((String)paramObject[0], (String)paramObject[1]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 3) {
              break;
            }
            a((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            d(paramBoolean, (ArrayList)((Object[])(Object[])paramObject)[0]);
            return;
            if (!(paramObject instanceof Object[])) {
              break;
            }
            paramObject = (Object[])paramObject;
            if (paramObject.length < 5) {
              break;
            }
            a(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1], (byte[])paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
            return;
            if ((paramObject != null) && ((paramObject instanceof Object[])))
            {
              paramObject = (Object[])paramObject;
              if (paramObject.length == 3)
              {
                a(paramBoolean, ((Long)paramObject[0]).longValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
                return;
              }
              a(false, 0L, null, -1);
              return;
            }
            a(false, 0L, null, -1);
            return;
          }
          paramInt = 0;
          continue;
          l = -1L;
          break label2736;
          l = -1L;
          paramInt = 0;
        }
        localObject2 = localObject1;
        j = paramInt;
        localObject3 = null;
        localObject1 = paramObject;
        paramInt = i;
        paramObject = localObject3;
        i = j;
        continue;
        localObject1 = null;
        break label2581;
        localObject2 = null;
        i = -1;
        paramObject = null;
        localObject1 = null;
        paramInt = -1;
      }
      localObject2 = localObject1;
      j = paramInt;
      localObject3 = null;
      localObject1 = paramObject;
      paramInt = i;
      paramObject = localObject3;
      i = j;
      continue;
      localObject1 = null;
      break label2418;
      localObject2 = null;
      i = -1;
      paramObject = null;
      localObject1 = null;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ameq
 * JD-Core Version:    0.7.0.1
 */