package com.tencent.mobileqq.app;

import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.hw.group_mgr.CardInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;
import zvl;

public class TroopObserver
  implements BusinessObserver, mqq.observer.BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, group_mgr.CardInfo paramCardInfo) {}
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  public void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void a(Boolean paramBoolean) {}
  
  public void a(Boolean paramBoolean, ArrayList paramArrayList, List paramList) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, byte paramByte) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void a(String paramString, boolean paramBoolean, List paramList, int paramInt, long paramLong) {}
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void a(oidb_0xaf4.RspBody paramRspBody, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4, int paramInt5) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2) {}
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject) {}
  
  public void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  public void a(boolean paramBoolean, RespBatchProcess paramRespBatchProcess) {}
  
  public void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString) {}
  
  public void a(boolean paramBoolean, HomeworkInfo paramHomeworkInfo) {}
  
  public void a(boolean paramBoolean, TroopShareResp paramTroopShareResp) {}
  
  public void a(boolean paramBoolean, Long paramLong, List paramList) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2, HashMap paramHashMap) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, int paramInt, boolean paramBoolean3, HashMap paramHashMap) {}
  
  public void a(boolean paramBoolean, String paramString, List paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List paramList, int paramInt) {}
  
  public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  public void b() {}
  
  public void b(Boolean paramBoolean) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  public void b(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString, List paramList) {}
  
  public void b(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean, List paramList) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, String paramString) {}
  
  public void c(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void c(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void c(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void d(String paramString) {}
  
  public void d(boolean paramBoolean, String paramString) {}
  
  public void d(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void e(String paramString) {}
  
  public void e(boolean paramBoolean, String paramString) {}
  
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
    String str;
    int i;
    label2159:
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
                                      if (localObject1.length == 4)
                                      {
                                        localObject2 = (String)localObject1[0];
                                        if (localObject1[1] == null) {}
                                        for (paramObject = null;; paramObject = (List)localObject1[1])
                                        {
                                          a((String)localObject2, paramBoolean, paramObject, ((Integer)localObject1[2]).intValue(), ((Long)localObject1[3]).longValue());
                                          return;
                                        }
                                      }
                                    } while (!QLog.isColorLevel());
                                    QLog.e("TroopObserver", 2, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
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
                                c(paramBoolean, (ArrayList)paramObject);
                                return;
                                d(paramBoolean, (ArrayList)paramObject);
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
                          paramObject = (zvl)paramObject;
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
                    c(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                } while (paramObject.length != 3);
                a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
                return;
                if (paramBoolean)
                {
                  a(paramBoolean, (RespBatchProcess)paramObject);
                  return;
                }
                a(paramBoolean, null);
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
          b(paramBoolean, paramObject);
          return;
        } while (!(paramObject instanceof Object[]));
        Object[] arrayOfObject = (Object[])paramObject;
        localObject2 = null;
        str = null;
        localObject1 = localObject2;
        paramObject = str;
        if (arrayOfObject.length >= 3)
        {
          localObject1 = localObject2;
          paramObject = str;
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
            str = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = str;
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
          label2322:
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
            str = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = str;
          }
        }
      }
      for (;;)
      {
        b(paramBoolean, paramObject, paramInt, (String)localObject1, i, (List)localObject2);
        return;
        a(paramBoolean, (TroopShareResp)paramObject);
        return;
        long l;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length > 0)
          {
            l = ((Long)paramObject[0]).longValue();
            label2477:
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
              localObject1 = (HomeworkInfo)paramObject[0];
            }
          }
          a(paramBoolean, (HomeworkInfo)localObject1);
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
          a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3]);
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
          boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
          boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
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
          a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
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
          b(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
          return;
          paramObject = (Object[])paramObject;
          b((String)paramObject[0], (String)paramObject[1]);
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
          b(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), ((Long)paramObject[9]).longValue());
          return;
          a((TroopEnterEffectController.TroopEnterEffectData)paramObject);
          return;
          paramObject = (Object[])paramObject;
          c(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          b(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Boolean)paramObject[5]).booleanValue(), (HashMap)paramObject[6]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), (HashMap)paramObject[4]);
          return;
          d(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
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
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
          paramObject = (Object[])paramObject;
          a((String)paramObject[0], (String)paramObject[1]);
          return;
          e((String)((Object[])(Object[])paramObject)[0]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (homework.RspSend1V1Msg)paramObject[0], (homework.ReqSend1V1Msg)paramObject[1]);
          return;
          paramInt = 0;
          continue;
          l = -1L;
          break label2477;
          l = -1L;
          paramInt = 0;
        }
        localObject2 = localObject1;
        j = paramInt;
        str = null;
        localObject1 = paramObject;
        paramInt = i;
        paramObject = str;
        i = j;
        continue;
        localObject1 = null;
        break label2322;
        localObject2 = null;
        i = -1;
        paramObject = null;
        localObject1 = null;
        paramInt = -1;
      }
      localObject2 = localObject1;
      j = paramInt;
      str = null;
      localObject1 = paramObject;
      paramInt = i;
      paramObject = str;
      i = j;
      continue;
      localObject1 = null;
      break label2159;
      localObject2 = null;
      i = -1;
      paramObject = null;
      localObject1 = null;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopObserver
 * JD-Core Version:    0.7.0.1
 */