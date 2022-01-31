package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.ResidParser;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso.PlatInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqUserInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;

public class FavEmoRoamingHandler
  extends BusinessHandler
{
  protected FavEmoRoamingHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(List paramList1, List paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null)) {}
    Object localObject2;
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList2.size())
      {
        localObject1 = (String)paramList2.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = new ResidParser((String)localObject1);
          if ((!((ResidParser)localObject2).a()) || (TextUtils.isEmpty(((ResidParser)localObject2).c)) || (TextUtils.isEmpty(((ResidParser)localObject2).d)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + (String)localObject1);
            }
          }
          else {
            localArrayList.add(localObject2);
          }
        }
      }
      Object localObject1 = new ArrayList();
      i = 0;
      ResidParser localResidParser1;
      if (i < paramList1.size())
      {
        localObject2 = (String)paramList1.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          i += 1;
          break;
          localResidParser1 = new ResidParser((String)localObject2);
          if ((!localResidParser1.a()) || (TextUtils.isEmpty(localResidParser1.c)) || (TextUtils.isEmpty(localResidParser1.d)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + (String)localObject2);
            }
          }
          else {
            ((List)localObject1).add(localResidParser1);
          }
        }
      }
      localObject2 = new StringBuilder("");
      i = 0;
      while (i < localArrayList.size())
      {
        localResidParser1 = (ResidParser)localArrayList.get(i);
        int j = 0;
        while (j < ((List)localObject1).size())
        {
          ResidParser localResidParser2 = (ResidParser)((List)localObject1).get(j);
          if ((localResidParser1.c.equals(localResidParser2.c)) && (localResidParser2.c.equals("0")) && (localResidParser2.d.equals(localResidParser1.d)))
          {
            paramList1.remove(localResidParser2.a);
            ((StringBuilder)localObject2).append(localResidParser2.a).append(", ");
          }
          j += 1;
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FavEmoRoamingHandler", 2, "delList=" + paramList1.size() + ", roamingList=" + paramList2.size() + ", del resIds:" + localObject2);
  }
  
  protected Class a()
  {
    return FavEmoRoamingObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("cmd_fav_subcmd");
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e("favEmoticon", 1, "fail to  not send command: " + i + " to server");
      if (i == 1) {
        ((FavroamingManager)this.b.getManager(102)).d();
      }
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      a(paramObject);
      return;
    }
    a(paramObject, paramToServiceMsg.extraData.getBoolean("needSync"));
  }
  
  public void a(Object paramObject)
  {
    Object localObject = new faceroam_sso.RspBody();
    try
    {
      ((faceroam_sso.RspBody)localObject).mergeFrom((byte[])paramObject);
      paramObject = (faceroam_sso.RspUserInfo)((faceroam_sso.RspBody)localObject).rspcmd_0x01.get();
      localLong = Long.valueOf(((faceroam_sso.RspBody)localObject).ret.get());
      if (localLong.longValue() != 0L)
      {
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet ret = " + localLong);
        return;
      }
      FileUtils.c(AppConstants.aU + ".nomedia");
      localList1 = paramObject.filename.get();
      localList2 = paramObject.delete_file.get();
      localList3 = paramObject.uint32_emoji_type.get();
      localObject = paramObject.bid.get();
      j = paramObject.max_roam_size.get();
      FavEmoConstant.a = j;
      paramObject = this.b.getCurrentAccountUin();
      if (!TextUtils.isEmpty(paramObject)) {
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("fav_roaming_max" + paramObject, j).apply();
      }
      if (localList1 == null) {
        break label530;
      }
      i = localList1.size();
      if (i <= FavEmoConstant.a) {
        break label523;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      Long localLong;
      List localList1;
      List localList2;
      List localList3;
      int j;
      int i;
      while (QLog.isColorLevel())
      {
        QLog.d("FavEmoRoamingHandler", 2, "func handleUserInfoGet ends, errInfo:" + paramObject.getMessage());
        return;
        i = FavEmoConstant.a;
        continue;
        FavEmoConstant.b = FavEmoConstant.a;
      }
    }
    FavEmoConstant.b = i;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoRoamingHandler", 2, "local max size:" + FavEmoConstant.a + ",server max size:" + FavEmoConstant.b + ",delListSize=" + localList2.size() + ",fileListSize=" + localList1.size());
    }
    if ((QLog.isColorLevel()) && (localList1 != null) && (localList2 != null)) {
      QLog.d("FavEmoRoamingHandler", 2, "ret = " + localLong.toString() + " userlist= " + localList1.toString() + " delList=" + localList2.toString() + " bid=" + (String)localObject + " local_max =" + j);
    }
    paramObject = localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject = "qq_expression";
    }
    a(localList2, localList1);
    localObject = ((FavroamingDBManager)this.b.getManager(148)).a(localList2, localList1, paramObject, localList3);
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new ArrayList();
    }
    super.a(1, true, paramObject);
    return;
    label523:
    label530:
    return;
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    int j = 0;
    faceroam_sso.RspBody localRspBody = new faceroam_sso.RspBody();
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        Object localObject = (faceroam_sso.RspDeleteItem)localRspBody.rspcmd_0x02.get();
        paramObject = ((faceroam_sso.RspDeleteItem)localObject).ret.get();
        localObject = ((faceroam_sso.RspDeleteItem)localObject).filename.get();
        localArrayList = new ArrayList();
        String str = localRspBody.errmsg.get();
        long l = localRspBody.ret.get();
        int k = localRspBody.sub_cmd.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FavEmoRoamingHandler", 2, " handle ResId=" + localObject + "errMsg=" + str + " ret=" + l + "subCmd=" + k);
          i = j;
        }
        if (i < ((List)localObject).size()) {
          if (((Long)paramObject.get(i)).longValue() == 0L)
          {
            localArrayList.add(((List)localObject).get(i));
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, " delSuccess ResId=" + (String)((List)localObject).get(i));
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("FavEmoRoamingHandler", 2, " delFail ResId=" + (String)((List)localObject).get(i) + "error code = " + paramObject.get(i));
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, "func handleDelMessage ends, errInfo:" + paramObject.getMessage());
        }
        return;
      }
      ((FavroamingDBManager)this.b.getManager(148)).b(localArrayList);
      super.a(0, true, Boolean.valueOf(paramBoolean));
      a(localArrayList);
      return;
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResidParser localResidParser = new ResidParser((String)paramList.next());
        if (!TextUtils.isEmpty(localResidParser.d)) {
          localArrayList.add(localResidParser.d);
        }
      }
      if (localArrayList.size() > 0) {
        ((VipComicMqqManager)this.b.getManager(140)).a(localArrayList);
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    Object localObject = new faceroam_sso.ReqDeleteItem();
    ((faceroam_sso.ReqDeleteItem)localObject).filename.set(paramList);
    faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
    localPlatInfo.implat.set(109L);
    localPlatInfo.mqqver.set("7.6.0");
    localPlatInfo.osver.set(Build.VERSION.RELEASE);
    paramList = new faceroam_sso.ReqBody();
    paramList.uint32_sub_cmd.set(2);
    paramList.uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    paramList.reqcmd_0x02.set((MessageMicro)localObject);
    paramList.comm.set(localPlatInfo);
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "Faceroam.OpReq");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 2);
    ((ToServiceMsg)localObject).extraData.putBoolean("needSync", paramBoolean);
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    Object localObject = new faceroam_sso.ReqUserInfo();
    faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
    localPlatInfo.implat.set(109L);
    localPlatInfo.mqqver.set("7.6.0");
    localPlatInfo.osver.set(Build.VERSION.RELEASE);
    faceroam_sso.ReqBody localReqBody = new faceroam_sso.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    localReqBody.reqcmd_0x01.set((MessageMicro)localObject);
    localReqBody.comm.set(localPlatInfo);
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "Faceroam.OpReq");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingHandler
 * JD-Core Version:    0.7.0.1
 */