package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import QQService.BindUin;
import QQService.DeviceItemDes;
import SecurityAccountServer.RespondQueryQQBindingStat;
import aean;
import amjp;
import amsh;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import anud;
import anui;
import anws;
import anym;
import anyn;
import anyo;
import anyp;
import anyq;
import anyr;
import anyt;
import anyu;
import anyw;
import aobl;
import aofp;
import aoim;
import aope;
import aopy;
import aoqa;
import aoqb;
import aoqc;
import aoqd;
import aoqe;
import aoqf;
import aoqg;
import aoqh;
import aoqi;
import aoqj;
import aoqk;
import aoql;
import aoqm;
import aoqn;
import aoqo;
import aoqp;
import aoqq;
import aoqr;
import aoqs;
import aoqt;
import aoqu;
import aoqv;
import aoqw;
import aoqx;
import apdc;
import aqqr;
import axfr;
import axup;
import bapc;
import bayl;
import bbbq;
import bbbs;
import bbbt;
import bcuc;
import bdmc;
import bhjr;
import bhjx;
import bhlf;
import bhnv;
import bhsr;
import bhzq;
import bkgt;
import blqm;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.app.FriendListHandler.QQHeadDetails;>;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.Key;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import mrs;
import nnr;
import nok;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.ReqBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed.ReqBody;
import tencent.im.oidb.cmd0xc83.ReqBody;
import tencent.im.oidb.cmd0xc85.ReqBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.ReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DeleteReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.ReqBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.ReqBody;
import tencent.im.oidb.oidb_0xc26.ReqBody;
import tencent.im.oidb.oidb_0xc34.ReqBody;
import tencent.im.oidb.oidb_0xc35.ExposeItem;
import tencent.im.oidb.oidb_0xc35.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x11e.SubMsgType0x11e.MsgBody;

public class FriendListHandler
  extends anud
  implements aoqd
{
  public static int a;
  private static int h = 100;
  public long a;
  anyr jdField_a_of_type_Anyr = new anyn(this);
  private final bbbs jdField_a_of_type_Bbbs = new bbbs();
  private bbbt jdField_a_of_type_Bbbt;
  private QQHeadDownloadHandler jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<oidb_0x7df.FriendScore> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, String> jdField_a_of_type_JavaUtilHashMap;
  private Hashtable<Integer, ArrayList<FriendListHandler.QQHeadDetails>> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<aoqf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private short jdField_a_of_type_Short = 20002;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  anyr jdField_b_of_type_Anyr = new anyo(this);
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable<String, Long> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  anyr jdField_c_of_type_Anyr = new anyp(this);
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private Hashtable<String, anyt> jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private Hashtable<String, anyq> jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long;
  private volatile int g = -1;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  protected FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Long = 15000L;
    a();
    b();
  }
  
  public static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(byte paramByte1, byte paramByte2, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList, List<QQHeadInfo> paramList1)
  {
    List localList;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localList = paramQQHeadUrlRsp.dstHeadInfos.get();
      paramArrayList = paramArrayList.iterator();
    }
    label60:
    label320:
    for (;;)
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails;
      Object localObject;
      QQHeadUrl.RspHeadInfo localRspHeadInfo;
      if (paramArrayList.hasNext())
      {
        localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.next();
        localObject = localList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label316;
        }
        localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject).next();
        if (paramByte2 == 1)
        {
          paramQQHeadUrlRsp = localRspHeadInfo.dstUid.get();
          label96:
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramQQHeadUrlRsp)) {
            break label290;
          }
          localObject = new QQHeadInfo();
          ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          if (paramByte2 != 1) {
            break label292;
          }
          ((QQHeadInfo)localObject).phoneNum = localRspHeadInfo.dstUid.get();
          ((QQHeadInfo)localObject).dwTimestamp = localRspHeadInfo.timestamp.get();
          ((QQHeadInfo)localObject).cHeadType = ((byte)localRspHeadInfo.faceType.get());
          ((QQHeadInfo)localObject).dstUsrType = paramByte1;
          ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
          ((QQHeadInfo)localObject).downLoadUrl = localRspHeadInfo.url.get();
          ((QQHeadInfo)localObject).systemHeadID = ((short)localRspHeadInfo.sysid.get());
          if (!localRspHeadInfo.headVerify.has()) {
            break label308;
          }
          paramQQHeadUrlRsp = localRspHeadInfo.headVerify.get();
          label240:
          ((QQHeadInfo)localObject).headVerify = paramQQHeadUrlRsp;
          paramList1.add(localObject);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label320;
        }
        paramList.add(localQQHeadDetails);
        break;
        paramQQHeadUrlRsp = String.valueOf(localRspHeadInfo.dstUin.get());
        break label96;
        break label60;
        ((QQHeadInfo)localObject).uin = localRspHeadInfo.dstUin.get();
        break label145;
        paramQQHeadUrlRsp = "";
        break label240;
        return;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<FriendListHandler.QQHeadDetails> paramList, anyr paramanyr)
  {
    if (paramList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
      }
      EntityManager localEntityManager = this.app.a().createEntityManager();
      EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      int i = 0;
      try
      {
        while (i < paramList.size())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramList.get(i);
          com.tencent.mobileqq.data.Setting localSetting = (com.tencent.mobileqq.data.Setting)localEntityManager.find(com.tencent.mobileqq.data.Setting.class, paramanyr.a(paramInt1, paramInt2, localQQHeadDetails));
          if (localSetting != null)
          {
            localSetting.updateTimestamp = System.currentTimeMillis();
            this.app.a(localSetting);
            localEntityManager.update(localSetting);
          }
          b(paramanyr.b(paramInt1, paramInt2, localQQHeadDetails), true);
          i += 1;
        }
        return;
      }
      catch (Exception paramList)
      {
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label37:
    String str;
    label76:
    Object localObject2;
    Object localObject1;
    label114:
    int i;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      if (localIterator2.hasNext())
      {
        paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (paramInt2 == 0)
        {
          str = String.valueOf(paramArrayList.dstUin.get());
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str)) {
            break label191;
          }
          localObject2 = paramArrayList.dstHeadInfos.get();
          localObject1 = null;
          paramArrayList = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          if (!localIterator3.hasNext()) {
            break label218;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i != 1) {
            break label193;
          }
          localObject1 = localObject2;
        }
      }
    }
    label543:
    label551:
    for (;;)
    {
      break label114;
      if (paramInt2 == 1)
      {
        str = String.valueOf(paramArrayList.dstTid.get());
        break label76;
      }
      str = paramArrayList.dstOpenid.get();
      break label76;
      label191:
      break label37;
      label193:
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject2;
        continue;
        label218:
        if (paramArrayList != null)
        {
          label223:
          localObject1 = this.app.a(32, str, paramInt1);
          if (this.app.a(32, str, paramInt1)) {
            break label471;
          }
          i = 1;
          label255:
          if (i == 0) {
            break label551;
          }
          localObject1 = new QQHeadInfo();
          ((QQHeadInfo)localObject1).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          ((QQHeadInfo)localObject1).idType = paramInt1;
          ((QQHeadInfo)localObject1).phoneNum = str;
          ((QQHeadInfo)localObject1).dwTimestamp = paramArrayList.timestamp.get();
          ((QQHeadInfo)localObject1).cHeadType = ((byte)paramArrayList.faceType.get());
          ((QQHeadInfo)localObject1).dstUsrType = 32;
          ((QQHeadInfo)localObject1).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
          ((QQHeadInfo)localObject1).downLoadUrl = paramArrayList.url.get();
          ((QQHeadInfo)localObject1).systemHeadID = ((short)paramArrayList.sysid.get());
          ((QQHeadInfo)localObject1).originUsrType = paramArrayList.usrType.get();
          if (!paramArrayList.headVerify.has()) {
            break label543;
          }
        }
        for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
        {
          ((QQHeadInfo)localObject1).headVerify = paramArrayList;
          paramList2.add(localObject1);
          break;
          if (localObject1 != null)
          {
            paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject1;
            break label223;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + str);
          break;
          label471:
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mobileqq.data.Setting)((Pair)localObject1).second;
            if (localObject1 == null)
            {
              i = 1;
              break label255;
            }
            if (((com.tencent.mobileqq.data.Setting)localObject1).headImgTimestamp != paramArrayList.timestamp.get())
            {
              i = 1;
              break label255;
            }
            paramList1.add(localQQHeadDetails);
            i = 0;
            break label255;
          }
          i = 1;
          break label255;
        }
        notifyUI(5, true, new Object[] { localQQHeadDetails.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt1), Boolean.valueOf(true) });
        break label37;
        break;
        return;
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new FriendListHandler.3(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean);
  }
  
  private void a(int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
    localMultiBusidUrlReq.dstUidType.set(0);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label171;
      }
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i);
      MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(bapc.b(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
      }
      i += 1;
    }
    label171:
    new HashMap().put("connum", String.valueOf(paramArrayList.size()));
    ToServiceMsg localToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    sendPbReq(localToServiceMsg);
  }
  
  private void a(int paramInt, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label36:
    String str;
    Object localObject;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
          str = bapc.a(paramArrayList.dstUin.get());
          if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str))
          {
            localObject = paramArrayList.dstHeadInfos.get();
            paramArrayList = null;
            Iterator localIterator3 = ((List)localObject).iterator();
            label102:
            if (localIterator3.hasNext())
            {
              localObject = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
              ((MultiHeadUrl.RspHeadInfo)localObject).usrType.get();
              if (((MultiHeadUrl.RspHeadInfo)localObject).faceType.get() == 0) {
                break label570;
              }
              paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject;
            }
          }
        }
      }
    }
    label154:
    label441:
    label570:
    for (;;)
    {
      break label102;
      int i;
      if (paramArrayList != null)
      {
        localObject = this.app.a(16, str, paramInt);
        if (this.app.a(16, str, paramInt)) {
          break label441;
        }
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + paramInt);
          i = j;
        }
        label238:
        if (i == 0) {
          break label560;
        }
        localObject = new QQHeadInfo();
        ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
        ((QQHeadInfo)localObject).idType = paramInt;
        ((QQHeadInfo)localObject).phoneNum = str;
        ((QQHeadInfo)localObject).dwTimestamp = paramArrayList.timestamp.get();
        ((QQHeadInfo)localObject).cHeadType = ((byte)paramArrayList.faceType.get());
        ((QQHeadInfo)localObject).dstUsrType = 16;
        ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
        ((QQHeadInfo)localObject).downLoadUrl = paramArrayList.url.get();
        ((QQHeadInfo)localObject).systemHeadID = ((short)paramArrayList.sysid.get());
        ((QQHeadInfo)localObject).originUsrType = paramArrayList.usrType.get();
        if (!paramArrayList.headVerify.has()) {
          break label562;
        }
      }
      for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
      {
        ((QQHeadInfo)localObject).headVerify = paramArrayList;
        paramList2.add(localObject);
        break label36;
        if (0 != 0)
        {
          paramArrayList = null;
          break label154;
        }
        if (!QLog.isColorLevel()) {
          break label36;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label36;
        break;
        if (localObject != null)
        {
          localObject = (com.tencent.mobileqq.data.Setting)((Pair)localObject).second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + localObject + "targetInfo.timestamp=" + paramArrayList.timestamp.get());
          }
          if (localObject == null)
          {
            i = 1;
            break label238;
          }
          if (((com.tencent.mobileqq.data.Setting)localObject).headImgTimestamp != paramArrayList.timestamp.get())
          {
            i = 1;
            break label238;
          }
          paramList1.add(localQQHeadDetails);
          i = 0;
          break label238;
        }
        i = 1;
        break label238;
        break label36;
      }
      return;
    }
  }
  
  private void a(long paramLong, int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i);
      ((ArrayList)localObject).add(localQQHeadDetails.a());
      a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
      i += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
    localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject);
    localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
    send(localToServiceMsg);
  }
  
  private void a(anyw paramanyw)
  {
    Object localObject = amjp.a(this.app);
    if ((paramanyw != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramanyw.b(str))
        {
          amjp.b(str, this.app);
          if (amjp.b(str, this.app)) {
            amjp.c(str, this.app);
          }
        }
      }
    }
  }
  
  public static void a(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
  {
    if (paramInt == 13568)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.specialRingSwitch = 0;
          return;
        }
        if (!Pattern.compile("[0-9]*").matcher(paramString).matches()) {
          return;
        }
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString);
        paramSpecialCareInfo.specialRingSwitch = 1;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramString);
        }
        paramSpecialCareInfo.specialRingSwitch = 0;
        return;
      }
    }
    else
    {
      if (paramInt == 13573)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label111;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          return;
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
        return;
        label111:
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
      if (paramInt == 13572) {
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            paramSpecialCareInfo.qzoneSwitch = 0;
            return;
          }
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (QLog.isColorLevel())
          {
            QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
            return;
            paramSpecialCareInfo.qzoneSwitch = 1;
          }
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = -1)
    {
      ((StringBuilder)localObject).append(i);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
      return;
    }
    i = 0;
    if (i < localArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localArrayList.get(i);
      String str = localQQHeadDetails.jdField_a_of_type_Int + "_" + localQQHeadDetails.jdField_a_of_type_JavaLangString;
      int j;
      if (localQQHeadDetails.jdField_a_of_type_Int == 32)
      {
        j = paramToServiceMsg.extraData.getInt("subtype");
        localObject = "stranger_" + j + "_" + str;
      }
      for (;;)
      {
        b((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.jdField_a_of_type_Int, 2, 0, null, paramInt, 0L);
        if (localQQHeadDetails != null) {
          localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long);
        }
        localObject = (apdc)this.app.getManager(199);
        if ((localObject != null) && (((apdc)localObject).a())) {
          ((apdc)localObject).a(localQQHeadDetails.jdField_a_of_type_JavaLangString);
        }
        i += 1;
        break;
        localObject = str;
        if (localQQHeadDetails.jdField_a_of_type_Int == 16)
        {
          j = paramToServiceMsg.extraData.getInt("subtype");
          localObject = "qcall_" + j + "_" + str;
        }
      }
    }
    QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i = 65535;
      if (paramQQHeadUrlResp != null) {
        i = paramQQHeadUrlResp.result;
      }
    }
    label262:
    do
    {
      for (;;)
      {
        a(paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + i);
        }
        return;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label262;
          }
          localObject = (FriendListHandler.QQHeadDetails)paramFromServiceMsg.next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_Byte;
            paramToServiceMsg.add(localQQHeadInfo);
          }
        }
        paramQQHeadUrlResp.UserHeadInfoList = paramToServiceMsg;
      }
      o();
      paramToServiceMsg = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
      i = 0;
      while (i < paramQQHeadUrlResp.UserHeadInfoList.size())
      {
        paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i);
        a(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
        paramToServiceMsg.append(" qqHeadUrlResp id=").append(i).append(" QQHeadInfo.uin=").append(bhsr.e(Long.toString(paramFromServiceMsg.uin))).append(" QQHeadInfo.systemId=").append(paramFromServiceMsg.systemHeadID).append("  QQHeadInfo.headtype=").append(paramFromServiceMsg.cHeadType).append("|");
        localObject = new FaceInfo();
        ((FaceInfo)localObject).jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b((FaceInfo)localObject);
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (paramGetFriendListResp != null) {
        if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
          a(paramToServiceMsg, paramGetFriendListResp);
        }
      }
    }
    short s;
    do
    {
      do
      {
        return;
        if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
        {
          a(paramFromServiceMsg.getUin(), paramGetFriendListResp, paramToServiceMsg);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
      return;
      if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
      {
        s = paramToServiceMsg.extraData.getShort("friendStartIndex");
        i = paramToServiceMsg.extraData.getShort("friendTotalCount");
        QLog.e("FriendListHandler", 1, "friend list unserialize error");
        a(false, i, s, paramFromServiceMsg.getResultCode());
        this.jdField_c_of_type_Long = 0L;
      }
      notifyUI(1, false, null);
      notifyUI(99, false, null);
      return;
      if ((paramFromServiceMsg.getResultCode() != 2901) || (paramToServiceMsg == null) || (paramToServiceMsg.extraData == null)) {
        break label348;
      }
      int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "k_resend_cnt" + i);
      }
      if (i >= 2) {
        break;
      }
      paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
      send(paramToServiceMsg);
    } while (paramToServiceMsg.extraData.getBoolean("getSingleFriend"));
    this.jdField_c_of_type_Int += 1;
    return;
    if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
    {
      QLog.e("FriendListHandler", 1, "getFriendList timeout");
      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
      a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
      this.jdField_c_of_type_Long = 0L;
    }
    notifyUI(1, false, null);
    notifyUI(99, false, null);
    return;
    label348:
    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")))
    {
      QLog.e("FriendListHandler", 1, "getFriendList fail " + paramFromServiceMsg.getResultCode());
      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
      a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
      this.jdField_c_of_type_Long = 0L;
    }
    notifyUI(1, false, null);
    notifyUI(99, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switch", 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    int k = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switch", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (m != 0)
            {
              paramToServiceMsg.e(paramFromServiceMsg);
              paramObject = new SpecialCareInfo();
              paramObject.globalSwitch = 1;
              paramObject.specialRingSwitch = 1;
              paramObject.friendRingId = 1;
              paramObject.qzoneSwitch = 1;
              paramObject.uin = paramFromServiceMsg;
              paramToServiceMsg.a(paramObject);
              amjp.a(paramFromServiceMsg, "1", this.app);
            }
            else
            {
              paramToServiceMsg.e(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (m == 0) {
              break label395;
            }
          }
          for (j = 1;; j = 0)
          {
            paramObject.specialRingSwitch = j;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            amjp.a(paramFromServiceMsg, "1", this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label433;
        }
        for (j = 1;; j = 0)
        {
          paramFromServiceMsg.qzoneSwitch = j;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        m = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switch", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          paramToServiceMsg = (anyw)this.app.getManager(51);
          i = 0;
          while (i < arrayOfString.length)
          {
            paramFromServiceMsg = arrayOfString[i];
            m = arrayOfBoolean[i];
            switch (k)
            {
            default: 
              i += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      int j;
      label395:
      label433:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(k);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (k)
      {
      default: 
        return;
      case 1: 
        notifyUI(96, m, paramToServiceMsg);
        return;
      case 2: 
        notifyUI(97, m, paramToServiceMsg);
        return;
      }
      notifyUI(98, m, paramToServiceMsg);
      return;
      int n = 0;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    paramToServiceMsg = new Friends();
    aoqx localaoqx = new aoqx(this.app, this);
    localaoqx.a(paramToServiceMsg, localFriendInfo);
    aoqw localaoqw = new aoqw(this.app, this);
    localaoqw.a(paramToServiceMsg, localFriendInfo, paramGetFriendListResp);
    paramGetFriendListResp = new aoqv(this.app);
    paramGetFriendListResp.a(paramToServiceMsg, localFriendInfo);
    localaoqx.a(paramToServiceMsg);
    localaoqw.a();
    paramGetFriendListResp.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + paramToServiceMsg.uin + " | group = " + paramToServiceMsg.groupid);
    }
    if (this.jdField_c_of_type_Long == 0L) {
      notifyUI(1, true, Boolean.valueOf(true));
    }
    paramGetFriendListResp = (axfr)this.app.getManager(11);
    if (paramGetFriendListResp != null) {
      paramGetFriendListResp.f();
    }
    b(new String[] { paramToServiceMsg.uin });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      notifyUI(65, false, new Object[] { paramObject, null });
      a(paramToServiceMsg);
      return;
    }
    HashMap localHashMap = new HashMap(paramObject.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
    }
    notifyUI(65, true, new Object[] { paramObject, localHashMap });
    a(paramToServiceMsg);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean1 + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean1)
    {
      if (((anyw)this.app.getManager(51)).c()) {
        notifyUI(1, true, null);
      }
    }
    else {
      notifyUI(1, true, Boolean.valueOf(false));
    }
    paramString = createToServiceMsg("friendlist.getFriendGroupList");
    paramString.setEnableFastResend(true);
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendTotalCount", paramShort);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    paramString.extraData.putBoolean("is_manual_pull_refresh", paramBoolean2);
    send(paramString);
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("timeStamp");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uinList");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("is_manual_pull_refresh");
    int m = paramGetFriendListResp.startIndex;
    int n = paramGetFriendListResp.friend_count;
    int k = paramGetFriendListResp.wGetExtSnsRspCode;
    int i = 0;
    if (paramGetFriendListResp.stSubSrvRspCode != null) {
      i = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
    }
    for (int j = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;; j = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + m + ", " + n + " totalCount=" + paramGetFriendListResp.totoal_friend_count + " wGetExtSnsRspCode:" + k + " wGetMutualMarkRspCode:" + i + " wGetIntimateInfoRspCode:" + j);
      }
      if (paramGetFriendListResp.result == 1)
      {
        QLog.e("FriendListHandler", 2, "handleGetFriendList fail code");
        notifyUI(1, false, Boolean.valueOf(false));
        notifyUI(99, false, null);
        if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0) {}
        for (i = paramGetFriendListResp.totoal_friend_count;; i = paramToServiceMsg.extraData.getShort("friendTotalCount"))
        {
          a(false, i, paramToServiceMsg.extraData.getShort("friendStartIndex"), 1);
          return;
        }
      }
      blqm.a("handleGetFriendList");
      if (m == 0)
      {
        this.jdField_d_of_type_Int = 0;
        l = System.currentTimeMillis();
      }
      b(paramGetFriendListResp.cShowPcIcon);
      anyw localanyw = (anyw)this.app.getManager(51);
      aoqe.a(this.app, paramGetFriendListResp);
      aoqe.a(this.app, paramGetFriendListResp, l);
      if (m + n >= paramGetFriendListResp.totoal_friend_count) {}
      int i1;
      Object localObject;
      aoqc localaoqc;
      aoqb localaoqb;
      aoqa localaoqa;
      for (boolean bool1 = true;; bool1 = false)
      {
        i1 = paramGetFriendListResp.vecFriendInfo.size();
        this.jdField_d_of_type_Int += i1;
        localObject = new Friends[i1];
        localaoqc = new aoqc(this.app, (Friends[])localObject, l, bool1, this);
        localaoqb = new aoqb(this.app, i1, l, bool1, k, i);
        localaoqa = new aoqa(this.app, i1);
        k = 0;
        while (k < i1)
        {
          FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(k);
          Friends localFriends = new Friends();
          localaoqc.a(localFriends, localFriendInfo);
          localaoqb.a(localFriends, localFriendInfo);
          localaoqa.a(localFriends, localFriendInfo);
          localObject[k] = localFriends;
          localArrayList.add(localFriends.uin);
          k += 1;
        }
      }
      bkgt.a(this.app, (Friends[])localObject);
      localaoqc.a();
      localaoqb.a();
      localaoqa.a();
      if ((i1 > 0) && (QLog.isColorLevel()))
      {
        localObject = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
        QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject).friendUin + " | eNetwork=" + ((FriendInfo)localObject).eNetworkType + " | iTermType=" + ((FriendInfo)localObject).iTermType + " | abilityBits=" + ((FriendInfo)localObject).uAbiFlag + " | name=" + bhjx.a(((FriendInfo)localObject).nick) + " | netTypeIconId=" + ((FriendInfo)localObject).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject).eIconType + " | hasTorch=" + ((FriendInfo)localObject).cOlympicTorch);
      }
      blqm.a();
      if (!bool1)
      {
        a(paramString, m + n, 200, 0, 0, l, localArrayList, true, bool2, paramGetFriendListResp.totoal_friend_count);
        notifyUI(1, true, Boolean.valueOf(false));
        notifyUI(99, true, new Object[] { Boolean.valueOf(false), null });
        return;
      }
      if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0)
      {
        k = paramGetFriendListResp.totoal_friend_count;
        a(true, k, paramToServiceMsg.extraData.getShort("friendStartIndex"), 0);
        this.jdField_c_of_type_Long = 0L;
        this.jdField_d_of_type_Int = 0;
        paramString = new StringBuilder().append("actual friend count is ");
        if (this.jdField_d_of_type_Int != paramGetFriendListResp.totoal_friend_count) {
          break label1074;
        }
        bool1 = true;
        label890:
        QLog.d("FriendListHandler", 2, bool1);
        paramString = (PhoneContactManagerImp)this.app.getManager(11);
        paramString.f();
        if (!bool2) {
          paramString.b();
        }
        this.app.A();
        notifyUI(1, true, Boolean.valueOf(true));
        notifyUI(99, true, new Object[] { Boolean.valueOf(true), null });
        a(localArrayList);
        a(localanyw);
        aofp.a(this.app, "775_hot_friend_new_boat_clear_version");
        aofp.a(this.app, "top_position_and_disturb_clear_version");
        aofp.a(this.app, "check_message_preview_version_clear");
        this.jdField_d_of_type_Long = paramGetFriendListResp.serverTime;
        paramString = this.app;
        if (i != 0) {
          break label1080;
        }
        bool1 = true;
        label1033:
        if (j != 0) {
          break label1086;
        }
      }
      label1074:
      label1080:
      label1086:
      for (bool2 = true;; bool2 = false)
      {
        aoqe.a(paramString, bool1, bool2, paramGetFriendListResp.serverTime);
        a(0);
        return;
        k = paramToServiceMsg.extraData.getShort("friendTotalCount");
        break;
        bool1 = false;
        break label890;
        bool1 = false;
        break label1033;
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    String[] arrayOfString;
    if (!paramArrayList.isEmpty())
    {
      arrayOfString = new String[paramArrayList.size()];
      paramArrayList.toArray(arrayOfString);
      paramArrayList.clear();
      if (this.app.a.c()) {
        a(arrayOfString);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
  }
  
  private void a(List<QQHeadInfo> paramList, boolean paramBoolean)
  {
    o();
    int i = 0;
    if (i < paramList.size())
    {
      QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramList.get(i);
      a(0, a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum), localQQHeadInfo.dstUsrType, 2);
      FaceInfo localFaceInfo = new FaceInfo();
      if (paramBoolean) {}
      for (String str = localQQHeadInfo.phoneNum;; str = String.valueOf(localQQHeadInfo.uin))
      {
        localFaceInfo.jdField_a_of_type_JavaLangString = str;
        localFaceInfo.jdField_b_of_type_Int = localQQHeadInfo.idType;
        localFaceInfo.jdField_a_of_type_Int = localQQHeadInfo.dstUsrType;
        localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = localQQHeadInfo;
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b(localFaceInfo);
        i += 1;
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, short paramShort, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("reqGetStatus", str);
      localHashMap.put("currNetStatus", nnr.a());
      localHashMap.put("friendListCount", "" + paramInt1);
      localHashMap.put("fromIndex", "" + paramShort);
      localHashMap.put("reqCountEveryPage", "200");
      localHashMap.put("retryCount", "" + this.jdField_c_of_type_Int);
      localHashMap.put("totalConsume", "" + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
      localHashMap.put("errorCode", "" + paramInt2);
      bdmc.a(BaseApplicationImpl.getApplication()).a(null, "QQFriendListReqGetEvent", true, 0L, 0L, localHashMap, null);
      this.jdField_c_of_type_Int = 0;
      if (paramBoolean) {
        break;
      }
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
      }
      return;
    }
    m();
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramInt1 >= paramArrayOfString.length) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "doGetRichStatus uinArray.lenth = " + paramArrayOfString.length + " reqType = " + paramInt2 + "pos = " + paramInt1);
    }
    int i = Math.min(50, paramArrayOfString.length - paramInt1);
    String[] arrayOfString = new String[i];
    System.arraycopy(paramArrayOfString, paramInt1, arrayOfString, 0, i);
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", i + paramInt1);
    localToServiceMsg.extraData.putStringArray("sendArray", arrayOfString);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    send(localToServiceMsg);
  }
  
  private boolean a(bcuc parambcuc, RespItem paramRespItem)
  {
    if ((parambcuc == null) || (paramRespItem == null)) {
      return false;
    }
    try
    {
      parambcuc.a(paramRespItem);
      return true;
    }
    catch (OutOfMemoryError parambcuc)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, String.format("encounter OutOfMemoryError when handleCheckUpdateItem() sId=%d ret=%d ex=%s \n%s", new Object[] { Integer.valueOf(paramRespItem.eServiceID), Byte.valueOf(paramRespItem.cResult), parambcuc.getMessage(), Log.getStackTraceString(parambcuc) }));
      return true;
    }
    catch (Throwable parambcuc)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, parambcuc.getMessage(), parambcuc);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo)
  {
    return false;
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    label103:
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "getQQHead, uin=" + paramString + ",headType=" + paramInt1 + ",idType=" + paramInt2 + ",level=" + paramByte1 + ",faceFileType=" + paramByte2);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt1 != 1) {
          break label103;
        }
        paramBoolean = Friends.isValidUin(paramString);
        if (paramBoolean) {
          break label103;
        }
      }
      for (;;)
      {
        return;
        localObject = paramInt1 + "_" + paramString;
        if (paramInt1 == 32) {
          localObject = "stranger_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (paramInt1 == 16) {
          localObject = "qcall_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (c((String)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, noNeedDownload= " + (String)localObject);
        }
      }
      b((String)localObject, false);
    }
    finally {}
    boolean bool;
    label295:
    label356:
    int i;
    if ((this.app.a != null) && (this.app.a.b()))
    {
      bool = true;
      if (!QLog.isColorLevel()) {
        break label614;
      }
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead end keyStr = " + (String)localObject + ",isImmediatelyGet=" + this.jdField_c_of_type_Boolean + ",InActionLoginB=" + bool);
      break label614;
      this.jdField_e_of_type_Int += 1;
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
      if (localObject != null) {
        break label605;
      }
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i), localObject);
      if (!QLog.isColorLevel()) {
        break label626;
      }
      QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i + "destQQHeadInfoTable.size = " + this.jdField_a_of_type_JavaUtilHashtable.size());
      break label626;
    }
    for (;;)
    {
      paramBoolean = this.app.a(paramInt1, paramString, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.app.a(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString, l1, paramByte1));
        if ((!this.jdField_c_of_type_Boolean) && (bool) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin()))) {
          break;
        }
        n();
        break;
        bool = false;
        break label295;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      label605:
      break label626;
      label614:
      do
      {
        i = paramInt1;
        break;
      } while (paramInt1 != 32);
      i = paramInt2;
      break label356;
      label626:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void b(int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i;
    switch (paramInt)
    {
    case 203: 
    default: 
      i = 0;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq;
    label321:
    for (;;)
    {
      localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(i);
      int j = 0;
      label115:
      if (j < paramArrayList.size())
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(j);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          for (;;)
          {
            a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
            localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
            if (QLog.isColorLevel()) {
              QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + localReqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + localReqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + localReqUsrInfo.dstOpenid);
            }
            j += 1;
            break label115;
            i = 2;
            break;
            i = 1;
            break;
            if (i != 1) {
              break label321;
            }
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("ERROR", 2, localException.getMessage());
              continue;
              if (i == 2) {
                localReqUsrInfo.dstOpenid.set(localException.jdField_a_of_type_JavaLangString);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    bdmc.a(BaseApplication.getContext()).a(this.app.getCurrentAccountUin(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void b(long paramLong, int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = paramInt;
    if (paramInt == 4) {
      i = 8;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq", null);
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localQQHeadUrlReq.dstUsrType.set(i);
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
      QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
        localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        label169:
        break label169;
      }
      paramInt += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("dstUsrType", i);
    localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switches_of_a_person", 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String str = paramToServiceMsg.extraData.getString("param_uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_type");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_ring_ids");
    int i;
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int j;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switches_of_a_person", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (m != 0)
            {
              paramToServiceMsg.e(str);
              paramFromServiceMsg = new SpecialCareInfo();
              paramFromServiceMsg.globalSwitch = 1;
              paramFromServiceMsg.uin = str;
              paramToServiceMsg.a(paramFromServiceMsg);
              amjp.a(str, "1", this.app);
            }
            else
            {
              paramToServiceMsg.e(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (m == 0) {
              break label436;
            }
          }
          for (k = 1;; k = 0)
          {
            paramObject.specialRingSwitch = k;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            amjp.a(str, paramFromServiceMsg, this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label475;
        }
        for (int k = 1;; k = 0)
        {
          paramFromServiceMsg.qzoneSwitch = k;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        m = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switches_of_a_person", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          paramToServiceMsg = (anyw)this.app.getManager(51);
          if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString != null) && (arrayOfBoolean.length >= arrayOfInt.length) && (arrayOfString.length >= arrayOfInt.length))
          {
            j = 0;
            while (j < arrayOfInt.length)
            {
              k = arrayOfInt[j];
              m = arrayOfBoolean[j];
              paramFromServiceMsg = arrayOfString[j];
              switch (k)
              {
              default: 
                j += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label436:
      label475:
      notifyUI(100, m, new Object[] { Integer.valueOf(i), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int n = 0;
      continue;
      n = 0;
      i = -1;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    anyw localanyw = (anyw)this.app.getManager(51);
    if ((paramObject == null) || (paramObject.cResult != 0) || (paramObject.vstSigInfo == null) || (paramObject.vstSigInfo.size() == 0) || (localanyw == null))
    {
      if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
        this.jdField_b_of_type_Boolean = false;
      }
      a(paramToServiceMsg);
      return;
    }
    ArrayList localArrayList1 = new ArrayList(paramObject.vstSigInfo.size());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramObject.vstSigInfo.iterator();
    while (localIterator.hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
      String str = Long.toString(localResRichSigInfo.lUin);
      if (localResRichSigInfo.cStatus == 1)
      {
        ExtensionInfo localExtensionInfo = localanyw.a(str);
        paramObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          paramObject = new ExtensionInfo();
          paramObject.uin = str;
        }
        if ((paramObject.richTime != localResRichSigInfo.dwTime) || (!Arrays.equals(paramObject.richBuffer, localResRichSigInfo.vbSigInfo)))
        {
          paramObject.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          paramObject.isAdded2C2C = SignatureManager.a(this.app, str, paramObject.getRichStatus());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "insertSignMsgIfNeeded from FriendList uin = " + str + " result = " + paramObject.isAdded2C2C);
          }
          localArrayList1.add(paramObject);
          localArrayList2.add(str);
        }
      }
    }
    if (localArrayList2.size() > 0)
    {
      paramObject = new String[localArrayList2.size()];
      localArrayList2.toArray(paramObject);
      notifyUI(2, true, paramObject);
      localanyw.b(localArrayList1);
    }
    if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.jdField_b_of_type_Boolean) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
    {
      this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.jdField_d_of_type_Long).commit();
      this.jdField_b_of_type_Boolean = false;
    }
    a(paramToServiceMsg);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    Object localObject2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      if (paramBundle != null) {
        paramBundle.getString("troop_uin");
      }
      localObject2 = new StringBuilder(300);
      localStringBuilder = ((StringBuilder)localObject2).append("addFriendInternal, uin:").append(paramString1).append(", sourceID:").append(paramInt2).append(", subSourceId:").append(paramInt3).append(", extraUin:").append(paramString2).append(", friendSetting:").append(paramInt1).append(", groupId:").append(paramByte1).append(", msg:").append(paramString3).append(", autoSend:").append(paramBoolean1).append(", isContactBothWay:").append(paramBoolean2).append(", remark:").append(paramString4).append(", sourceName:").append(paramString5).append(", myCard:").append(paramByte2).append(", extraParam:").append(paramBundle).append(", sig:");
      if (paramArrayOfByte != null) {
        break label532;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append(localObject1).append(", ticket:");
      if (paramString6 != null) {
        break label543;
      }
    }
    label532:
    label543:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramString6.length()))
    {
      localStringBuilder.append(localObject1);
      QLog.d("addFriendTag", 2, ((StringBuilder)localObject2).toString());
      localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.addFriend");
      localObject2 = ((ToServiceMsg)localObject1).extraData;
      ((Bundle)localObject2).putString("uin", paramString1);
      ((Bundle)localObject2).putInt("friend_setting", paramInt1);
      ((Bundle)localObject2).putByte("group_id", paramByte1);
      ((Bundle)localObject2).putString("msg", paramString3);
      ((Bundle)localObject2).putInt("source_id", paramInt2);
      ((Bundle)localObject2).putByte("show_my_card", paramByte2);
      ((Bundle)localObject2).putInt("sub_source_id", paramInt3);
      ((Bundle)localObject2).putString("extra", paramString2);
      ((Bundle)localObject2).putBoolean("auto_send", paramBoolean1);
      ((Bundle)localObject2).putByteArray("sig", paramArrayOfByte);
      ((Bundle)localObject2).putBoolean("contact_bothway", paramBoolean2);
      ((Bundle)localObject2).putString("remark", paramString4);
      ((Bundle)localObject2).putString("src_name", paramString5);
      if (paramBundle != null)
      {
        ((Bundle)localObject2).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject2).putString("troop_code", paramBundle.getString("troop_code"));
        ((Bundle)localObject2).putInt("flc_notify_type", paramBundle.getInt("flc_notify_type"));
        ((Bundle)localObject2).putString("flc_recommend_uin", paramBundle.getString("flc_recommend_uin"));
        paramString2 = paramBundle.getByteArray("friend_src_desc");
        if (paramString2 != null) {
          ((Bundle)localObject2).putByteArray("friend_src_desc", paramString2);
        }
      }
      paramString1 = this.jdField_a_of_type_Bbbs.a(paramString1, paramInt2, paramInt3);
      if ((paramString1 != null) && (paramString1.length > 0)) {
        ((Bundle)localObject2).putByteArray("flc_add_frd_token", paramString1);
      }
      ((Bundle)localObject2).putString("security_ticket", paramString6);
      send((ToServiceMsg)localObject1);
      return;
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
      break;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      notifyUI(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        i = 1;
        if (i != 0) {
          break label119;
        }
        notifyUI(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      i = 0;
    }
    label119:
    ArrayList localArrayList = new ArrayList();
    paramFromServiceMsg = new HashSet();
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int n = localByteBuffer.getShort();
        anyw localanyw = (anyw)this.app.getManager(51);
        int j = 0;
        while (j < n)
        {
          i = 0;
          long l = bhjx.a(localByteBuffer.getInt());
          paramObject = localanyw.a(String.valueOf(l));
          paramToServiceMsg = paramObject;
          if (paramObject == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = String.valueOf(l);
            i = 1;
          }
          int i1 = localByteBuffer.getShort();
          int m = i;
          if (i1 > 0)
          {
            int k = 0;
            for (;;)
            {
              m = i;
              if (k >= i1) {
                break;
              }
              m = localByteBuffer.getShort();
              boolean bool1 = aopy.a(localByteBuffer, paramToServiceMsg, m);
              boolean bool2 = aopy.b(localByteBuffer, paramToServiceMsg, m);
              boolean bool3 = aopy.c(localByteBuffer, paramToServiceMsg, m);
              aopy.a(this.app, localByteBuffer, l, m);
              k += 1;
              i = bool3 | i | bool1 | bool2;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
          }
          if (m != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            localArrayList.add(paramToServiceMsg);
            paramFromServiceMsg.add(paramToServiceMsg.uin);
          }
          j += 1;
        }
        localanyw.b(localArrayList);
      }
    }
    if (paramFromServiceMsg.size() == 0) {}
    for (paramToServiceMsg = null;; paramToServiceMsg = paramFromServiceMsg)
    {
      notifyUI(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + localArrayList.size());
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_QCall ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label268;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        paramObject.dstUidType.get();
        i = paramToServiceMsg.extraData.getInt("idType");
        a(i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        a(localArrayList2, true);
        a(0, i, localArrayList1, this.jdField_b_of_type_Anyr);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          a(paramToServiceMsg, i);
          return;
        }
      }
      label268:
      paramObject = null;
    }
  }
  
  private boolean d(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((anyw)this.app.getManager(51)).c(paramString);
      l1 = bhlf.b(localContext, paramString) + 28800000L;
      l2 = System.currentTimeMillis() + 28800000L;
      l3 = localCard.iXManScene1DelayTime * 1000;
      if ((l1 / 86400000L == l2 / 86400000L) || (Math.abs(l2 - l1) <= 28800000L) || (l2 % 86400000L < l3)) {
        break label238;
      }
    }
    label238:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXMan toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s lastReqDay=%s currentDay=%s lastReqInterval=%s time=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1 / 86400000L), Long.valueOf(l2 / 86400000L), Long.valueOf(Math.abs(l2 - l1)), Long.valueOf(l2 % 86400000L) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label271;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        i = paramObject.dstUidType.get();
        int j = paramToServiceMsg.extraData.getInt("idType");
        a(j, i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        a(localArrayList2, true);
        a(0, j, localArrayList1, this.jdField_c_of_type_Anyr);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          a(paramToServiceMsg, i);
          return;
        }
      }
      label271:
      paramObject = null;
    }
  }
  
  private boolean e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 friendUin=%s", new Object[] { paramString }));
    }
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((anyw)this.app.getManager(51)).c(paramString);
      l1 = bhlf.c(localContext, paramString);
      l2 = System.currentTimeMillis();
      l3 = localCard.iXManScene2DelayTime * 1000;
      if ((l3 < 0L) || (Math.abs(l2 - l1) <= l3)) {
        break label181;
      }
    }
    label181:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localQQHeadUrlRsp = null;
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      notifyUI(133, false, new Object[] { Integer.valueOf(0), paramToServiceMsg });
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleQQHead_New qqHeadUrlResp=" + localObject1 + " qqHeadUrlRespData = " + paramObject);
    }
    QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (localObject1 == null) || (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() != 0))
    {
      i = 65535;
      if (localObject1 != null)
      {
        i = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
        a(paramToServiceMsg, i);
        i = paramToServiceMsg.extraData.getInt("dstUsrType", 1);
        if ((i != 1) && (i != 32)) {
          break label297;
        }
        paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        paramToServiceMsg = new ArrayList();
        if (!(paramFromServiceMsg instanceof ArrayList)) {
          break label274;
        }
        paramFromServiceMsg = ((ArrayList)paramFromServiceMsg).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = paramFromServiceMsg.next();
          if ((paramObject instanceof FriendListHandler.QQHeadDetails)) {
            paramToServiceMsg.add(((FriendListHandler.QQHeadDetails)paramObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      label274:
      label297:
      return;
    }
    int i = localQQHeadUrlRsp.dstUsrType.get();
    if (i == 8) {
      i = 4;
    }
    for (;;)
    {
      byte b1 = (byte)localQQHeadUrlRsp.dstEncryptType.get();
      paramObject = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      a((byte)i, b1, localQQHeadUrlRsp, paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject, false);
      a(i, 0, paramFromServiceMsg, this.jdField_a_of_type_Anyr);
      if ((paramFromServiceMsg.size() <= 0) || ((i != 1) && (i != 32))) {
        break;
      }
      paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((FriendListHandler.QQHeadDetails)paramFromServiceMsg.next()).jdField_a_of_type_JavaLangString);
      }
      notifyUI(133, true, new Object[] { Integer.valueOf(0), paramToServiceMsg });
      return;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000) {
      notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    for (;;)
    {
      return;
      int i = paramToServiceMsg.extraData.getInt("startIndex");
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        label73:
        if (!paramToServiceMsg.uint32_result.has())
        {
          notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label73;
        int j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + j);
        }
        paramFromServiceMsg = new StringBuilder(1024);
        if (j == 0)
        {
          paramObject = new cmd0x7c4.RspBody();
          cmd0x7c4.GetSNFrdListRsp localGetSNFrdListRsp;
          int k;
          anyw localanyw;
          ArrayList localArrayList;
          for (;;)
          {
            try
            {
              paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              localGetSNFrdListRsp = (cmd0x7c4.GetSNFrdListRsp)paramObject.msg_get_sn_frd_list_rsp.get();
              localGetSNFrdListRsp.uint64_uin.get();
              j = localGetSNFrdListRsp.uint32_sequence.get();
              k = localGetSNFrdListRsp.uint32_over.get();
              if (paramObject.rpt_msg_recommend_reason.has())
              {
                paramToServiceMsg = paramObject.rpt_msg_recommend_reason.get();
                ((anyw)this.app.getManager(51)).f(paramToServiceMsg);
              }
              paramToServiceMsg = localGetSNFrdListRsp.rpt_msg_one_frd_data.get();
              localanyw = (anyw)this.app.getManager(51);
              if (paramToServiceMsg == null) {
                break label593;
              }
              localArrayList = new ArrayList();
              Iterator localIterator = paramToServiceMsg.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
              Friends localFriends = new Friends();
              localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
              localFriends.age = localOneFrdData.uint32_ages.get();
              if (localOneFrdData.bytes_smart_remark.has())
              {
                paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
                localFriends.smartRemark = paramToServiceMsg;
                localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
                int m = localOneFrdData.uint32_reason_id.get();
                localFriends.recommReason = localanyw.a(m);
                localArrayList.add(localFriends);
                if (QLog.isColorLevel()) {
                  QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList Gather List : " + localFriends.uin + " ; resonId = " + m + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
                }
              }
              else
              {
                paramToServiceMsg = null;
              }
            }
            catch (Exception paramToServiceMsg)
            {
              notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
              return;
            }
          }
          localanyw.a(localArrayList, i);
          label593:
          if (localGetSNFrdListRsp.uint32_recommend_frd_count.has())
          {
            i = localGetSNFrdListRsp.uint32_recommend_frd_count.get();
            paramFromServiceMsg.append("|recommend cnt=").append(i);
            localanyw.b(i);
            label634:
            boolean bool = paramObject.msg_box.has();
            this.app.getHandler(Conversation.class);
            if (!bool) {
              break label826;
            }
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
            }
            paramToServiceMsg = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
            bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
            paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
            paramFromServiceMsg.append("|has no MsgBox hasPulled=").append(bool);
            label739:
            if (k != 0) {
              break label837;
            }
            i = localGetSNFrdListRsp.uint32_next_start_idx.get();
            paramFromServiceMsg.append("|not Completed. continue to get. startIndex =").append(i);
            a(i);
            notifyUI(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
          }
          while (QLog.isColorLevel())
          {
            QLog.i("FriendListHandler", 2, paramFromServiceMsg.toString());
            return;
            paramFromServiceMsg.append("|no recommend field");
            break label634;
            label826:
            paramFromServiceMsg.append("|has no MsgBox");
            break label739;
            label837:
            paramFromServiceMsg.append("|not Completed. continue to get. Completed.");
            this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", j).commit();
            notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
            if (localanyw != null) {
              localanyw.h();
            }
          }
        }
        if (j == 1)
        {
          notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
          return;
        }
        notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool3 = true;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      bool4 = paramToServiceMsg.extraData.getBoolean("isGather", true);
      bool5 = paramToServiceMsg.extraData.getBoolean("needNotifyPlugin", false);
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("friendUinList");
      bool1 = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramFromServiceMsg = (anyw)this.app.getManager(51);
        if (!bool4) {
          continue;
        }
        paramFromServiceMsg.e(paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp fail: resultCode = " + i);
        continue;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp ssoPkg is null");
        continue;
        notifyUI(91, bool1, paramToServiceMsg);
        continue;
        bool2 = false;
        continue;
        bool2 = bool3;
        if (!bool1) {
          continue;
        }
        bool2 = false;
        continue;
      }
      if (!bool4) {
        continue;
      }
      notifyUI(90, bool1, paramToServiceMsg);
      if (bool5)
      {
        paramFromServiceMsg = new Intent("action_gather_resp");
        paramFromServiceMsg.putStringArrayListExtra("key_uin_list", paramToServiceMsg);
        paramFromServiceMsg.putExtra("key_is_suc", bool1);
        if (!bool4) {
          continue;
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool3;
        paramFromServiceMsg.putExtra("key_is_gather", bool2);
        BaseApplicationImpl.getContext().sendBroadcast(paramFromServiceMsg);
      }
      return;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      paramFromServiceMsg.d(paramToServiceMsg);
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.jdField_a_of_type_Bbbt == null) {
      return;
    }
    this.jdField_a_of_type_Bbbt.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void m()
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Int != 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mFriendListFailedCount", this.jdField_b_of_type_Int + "");
      localHashMap.put("failedTime", System.currentTimeMillis() - this.jdField_b_of_type_Long + "");
      bdmc.a(BaseApplicationImpl.getApplication()).a(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, localHashMap, null);
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_Long = 0L;
    }
  }
  
  private void n()
  {
    for (;;)
    {
      label155:
      int i;
      Object localObject3;
      try
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead start !!! ");
        }
        if (this.jdField_e_of_type_Int > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.jdField_e_of_type_Int);
          }
          localObject1 = this.app.getCurrentAccountUin();
          if (localObject1 == null) {
            break label576;
          }
        }
        Enumeration localEnumeration;
        try
        {
          l = Long.valueOf((String)localObject1).longValue();
          if (l == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l = -1L;
          continue;
          localEnumeration = this.jdField_a_of_type_JavaUtilHashtable.keys();
        }
        if (!localEnumeration.hasMoreElements()) {
          break label555;
        }
        i = ((Integer)localEnumeration.nextElement()).intValue();
        Object localObject1 = (List)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + i);
        }
        if (!QLog.isColorLevel()) {
          break label361;
        }
        localObject3 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=").append(i);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator.next();
          ((StringBuilder)localObject3).append(" QQheadDetail uinOrMobile=").append(bhsr.e(localQQHeadDetails.jdField_a_of_type_JavaLangString)).append(",Timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long).append("|");
          continue;
        }
        ((StringBuilder)localObject3).append(" QQHeadDetailList length = ").append(localList.size());
      }
      finally {}
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject3).toString());
      label361:
      if ((localList != null) && (!localList.isEmpty())) {}
      for (Object localObject2 = aope.a(localList, 50);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label574;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new ArrayList((List)((Iterator)localObject2).next());
          if (i == 11)
          {
            a(l, i, (ArrayList)localObject3);
          }
          else if (i >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "realGetQQHead_Stranger = " + i);
            }
            b(i, (ArrayList)localObject3);
          }
          else if (i == 16)
          {
            a(i, (ArrayList)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL = " + i);
            }
          }
          else
          {
            b(l, i, (ArrayList)localObject3);
          }
        }
        break label155;
        label555:
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        break;
      }
      label574:
      continue;
      label576:
      long l = -1L;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
        }
        return;
      }
    }
  }
  
  public bbbs a()
  {
    return this.jdField_a_of_type_Bbbs;
  }
  
  public QQHeadDownloadHandler a()
  {
    o();
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
  }
  
  public VasFaceManager a()
  {
    return ((bhzq)this.app.getManager(235)).a;
  }
  
  public String a()
  {
    o();
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.a();
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public String a(long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      Object localObject1 = this.app.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int j = localObject1.length;
          while (i < j)
          {
            Object localObject2 = localObject1[i].split(":");
            long l = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localObject2);
            i += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public ArrayList<oidb_0x7df.FriendScore> a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new anym(this, this.app.getApp().getMainLooper());
    ThreadManager.excute(new FriendListHandler.2(this), 16, null, false);
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    send(localToServiceMsg);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.app.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(i);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(h);
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getGatheredContactsList(). startIndex = " + paramInt + " | seq = " + i);
    }
    localReqBody.msg_get_sn_frd_list_req.set(localGetSNFrdListReq);
    localReqBody.uint32_client_ver.set(2);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = false;
    int i = 1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getConnectionsPerson, entryType=").append(paramInt1).append(" tabID=").append(paramInt2).append(" hasCookie=");
      if (paramArrayOfByte != null) {
        bool = true;
      }
      QLog.i("FriendListHandler", 2, bool + " isFirstPage=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xc26.ReqBody();
        aobl localaobl = (aobl)this.app.getManager(159);
        if ((localaobl == null) || (!localaobl.a())) {
          break label309;
        }
        ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
        if (!QLog.isColorLevel()) {
          break label309;
        }
        QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, paramArrayOfByte.toString());
        return;
      }
      QLog.e("FriendListHandler", 1, "getConnectionsPerson, unknown entry type");
      i = -1;
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(i);
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(paramInt2);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      if (paramArrayOfByte != null) {
        ((oidb_0xc26.ReqBody)localObject).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xc26_1", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramArrayOfByte.addAttribute("tabID", Integer.valueOf(paramInt2));
      paramArrayOfByte.addAttribute("isFirstPage", Boolean.valueOf(paramBoolean));
      paramArrayOfByte.addAttribute("extra_bd", paramBundle);
      sendPbReq(paramArrayOfByte);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      label309:
      switch (paramInt1)
      {
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    localArrayList.add("message.ring.care");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((axfr)this.app.getManager(11)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l = Long.parseLong((String)localObject);; l = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      send(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
  {
    boolean bool;
    long l1;
    if (paramInt1 == 0)
    {
      bool = true;
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = System.currentTimeMillis();
      }
      if (paramInt3 != 1) {
        break label654;
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
      }
      paramString2 = new anyt(this);
      paramString2.jdField_a_of_type_Long = l1;
      paramString2.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_JavaUtilHashtable.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.jdField_b_of_type_Long - paramString2.jdField_a_of_type_Long;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.jdField_c_of_type_Long > paramString2.jdField_b_of_type_Long)
        {
          paramLong = l1;
          if (paramString2.jdField_b_of_type_Long > 0L) {
            paramLong = paramString2.jdField_c_of_type_Long - paramString2.jdField_b_of_type_Long;
          }
        }
        l1 = paramString2.jdField_d_of_type_Long - paramString2.jdField_c_of_type_Long;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.jdField_e_of_type_Long > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.jdField_e_of_type_Long) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
          if (!QLog.isColorLevel()) {
            break label826;
          }
        }
      }
      label654:
      label826:
      for (paramInt3 = 2;; paramInt3 = 1)
      {
        QLog.d("QQHeadCostTime", paramInt3, ((StringBuffer)localObject).toString());
        if (bhnv.d(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.jdField_a_of_type_Int));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(aoim.a().a()));
          paramString1 = FaceDownloader.a(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            bdmc.a(BaseApplication.getContext()).a(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.jdField_e_of_type_Long, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
          }
          paramString1 = FaceDownloader.b(paramInt2);
          bdmc.a(BaseApplication.getContext()).a(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.jdField_e_of_type_Long, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
            break label832;
          }
          localObject = (anyt)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((anyt)localObject).jdField_b_of_type_Long = l1;
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((anyt)localObject).jdField_e_of_type_Long = (((anyt)localObject).jdField_b_of_type_Long - ((anyt)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((anyt)localObject).jdField_c_of_type_Long = l1;
          paramString2 = (String)localObject;
          break;
          ((anyt)localObject).jdField_d_of_type_Long = l1;
          ((anyt)localObject).jdField_a_of_type_Int = paramInt4;
          ((anyt)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((anyt)localObject).jdField_e_of_type_Long = (((anyt)localObject).jdField_d_of_type_Long - ((anyt)localObject).jdField_a_of_type_Long);
          this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
        }
      }
      label832:
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ArrayList<FriendsStatusUtil.UpdateFriendStatusItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 4, " create0x5d6SendPackage serType=" + paramInt);
    }
    if ((paramArrayList == null) || (paramArrayList.size() > 20))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("create0x5d6SendPackage serType=").append(paramInt).append(" length=");
        if (paramArrayList != null) {
          break label93;
        }
      }
      label93:
      for (paramInt = 0;; paramInt = paramArrayList.size())
      {
        QLog.d("FriendListHandler", 4, paramInt);
        return;
      }
    }
    Object localObject1 = new ArrayList(1);
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject3 = (FriendsStatusUtil.UpdateFriendStatusItem)paramArrayList.get(i);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Long.parseLong(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).jdField_a_of_type_JavaLangString));
      ArrayList localArrayList = new ArrayList(1);
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      localSnsUpdateItem.uint32_update_sns_type.set(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).jdField_b_of_type_Int);
      localObject3 = ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).a();
      if (localObject3 != null) {
        localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
      }
      localArrayList.add(localSnsUpdateItem);
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set(localArrayList);
      ((List)localObject1).add(localObject2);
      i += 1;
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    paramString = createToServiceMsg(paramString);
    paramString.extraData.putParcelableArrayList("param_status_item_list", paramArrayList);
    paramString.extraData.putInt("param_type", paramInt);
    paramString.extraData.putBoolean("param_notify_plugin", paramBoolean);
    paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq(paramString);
  }
  
  public <T> void a(int paramInt, List<T> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleMayKnowRecommendPush: " + paramList + ", opType: " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ThreadManager.getSubThreadHandler().post(new FriendListHandler.4(this));
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do add mayknow list");
      }
      try
      {
        notifyUI(114, ((aobl)this.app.getManager(159)).a(true, paramList), paramList);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("FriendListHandler", 1, paramList, new Object[0]);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do del mayknow list");
    }
    try
    {
      notifyUI(115, ((aobl)this.app.getManager(159)).b(true, paramList), paramList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("FriendListHandler", 1, paramList, new Object[0]);
    }
  }
  
  public void a(int paramInt, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = createToServiceMsg("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    send((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getSuspiciousMsgList ").append(paramInt).append(" ");
      if (paramArrayOfByte != null) {
        break label166;
      }
    }
    label166:
    for (Object localObject1 = " no cookie ";; localObject1 = " has cookie ")
    {
      QLog.i("FriendListHandler", 2, (String)localObject1 + paramObject);
      localObject1 = new oidb_cmd0xd69.ReqBody();
      ((oidb_cmd0xd69.ReqBody)localObject1).cmd_type.set(1);
      localObject2 = new oidb_cmd0xd69.GetListReqBody();
      ((oidb_cmd0xd69.GetListReqBody)localObject2).req_num.set(paramInt);
      if (paramArrayOfByte != null) {
        ((oidb_cmd0xd69.GetListReqBody)localObject2).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((oidb_cmd0xd69.ReqBody)localObject1).msg_get_list_body.set((MessageMicro)localObject2);
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject1).toByteArray());
      paramArrayOfByte.addAttribute("cmd", Integer.valueOf(1));
      paramArrayOfByte.addAttribute("exactData", paramObject);
      sendPbReq(paramArrayOfByte);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setMessageNotificationSetting(). uin size=");
      if (paramArrayOfString != null) {
        break label88;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label95;
      }
    }
    label88:
    label95:
    for (int i = -1;; i = paramArrayOfBoolean.length)
    {
      QLog.d("tag_msg_notification", 2, i);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label102;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label102:
    Object localObject1 = new ArrayList();
    Object localObject2 = (anyw)this.app.getManager(51);
    i = 0;
    boolean bool = false;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      Object localObject3 = ((anyw)localObject2).a(str, false);
      if (localObject3 == null)
      {
        QLog.d("FriendListHandler", 1, new Object[] { "setMessageNotificationSetting: invoked. ", " extensionInfo: ", localObject3 });
        i += 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, new Object[] { "setMessageNotificationSetting: invoked. ", " type: ", Integer.valueOf(paramInt), " uin: ", str, " isSwitchOn: ", Boolean.valueOf(bool) });
        }
        Object localObject5 = aqqr.a((ExtensionInfo)localObject3);
        int k = paramArrayOfBoolean[i];
        Object localObject4 = new oidb_0x5d6.SnsUpdateItem();
        localObject3 = new ArrayList();
        byte[] arrayOfByte = new byte[2];
        if (paramInt == 1) {
          if (k != 0)
          {
            j = 0;
            label306:
            ((ExtensionInfo)localObject5).messageEnablePreviewNew = j;
          }
        }
        do
        {
          localObject5 = aqqr.a((ExtensionInfo)localObject5);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13582);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject5));
          ((List)localObject3).add(localObject4);
          localObject4 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(Long.parseLong(str));
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
          ((List)localObject1).add(localObject4);
          break;
          j = 1;
          break label306;
          if (paramInt == 3)
          {
            if (k != 0) {}
            for (j = 0;; j = 1)
            {
              ((ExtensionInfo)localObject5).messageEnableVibrateNew = j;
              break;
            }
          }
        } while (paramInt != 2);
        if (k != 0) {}
        for (int j = 0;; j = 1)
        {
          ((ExtensionInfo)localObject5).messageEnableSoundNew = j;
          break;
        }
      }
    }
    localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteSuspiciousMsg " + paramLong);
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(3);
    oidb_cmd0xd69.DeleteReqBody localDeleteReqBody = new oidb_cmd0xd69.DeleteReqBody();
    localDeleteReqBody.doubt_uin.set(paramLong);
    ((oidb_cmd0xd69.ReqBody)localObject).msg_delete_body.set(localDeleteReqBody);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(3));
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.setIsSupportRetry(true);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index1", paramInt3);
    localToServiceMsg.extraData.putInt("param_age_index2", paramInt4);
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    localToServiceMsg.extraData.putInt("param_job_index", paramInt5);
    localToServiceMsg.extraData.putInt("param_xingzuo_index", paramInt6);
    localToServiceMsg.extraData.putInt("param_search_from", paramInt7);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList<amsh> paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      amsh localamsh = (amsh)paramArrayList.get(paramInt2);
      if (localamsh == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localamsh.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localamsh.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localamsh.b.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localamsh.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localamsh.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localamsh.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = createToServiceMsg("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if (paramBoolean)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l);
      }
      if (!paramBoolean) {
        break label321;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      i = 2;
      break;
      label321:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = createToServiceMsg("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 4051, paramBoolean);
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2;
    int i;
    label70:
    bcuc localbcuc;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("FriendListHandler, handleCheckUpdate, ");
      if (paramCheckUpdateResp != null)
      {
        i = paramCheckUpdateResp.result;
        QLog.d("ProfileService.CheckUpdateReq", 2, i);
      }
    }
    else
    {
      if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0)) {
        break label224;
      }
      Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
      paramCheckUpdateResp = null;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (RespItem)localIterator.next();
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      localbcuc = this.app.a.a(((RespItem)localObject2).eServiceID);
      if (((RespItem)localObject2).eServiceID != 101) {
        break label197;
      }
      localObject1 = localbcuc;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
      break label70;
      i = -1;
      break;
      label197:
      a(localbcuc, (RespItem)localObject2);
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    a(paramCheckUpdateResp, (RespItem)localObject1);
    label224:
    this.app.a.a();
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, ArrayList<String> paramArrayList, FromServiceMsg paramFromServiceMsg, ArrayList<KQQ.ProfSmpInfoRes> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 51
    //   6: invokevirtual 778	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 660	anyw
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 2838	anyw:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore_3
    //   20: new 49	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 51	java/util/ArrayList:<init>	()V
    //   27: astore 5
    //   29: new 49	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 51	java/util/ArrayList:<init>	()V
    //   36: astore 6
    //   38: aload_3
    //   39: invokevirtual 336	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   42: aload 4
    //   44: invokevirtual 195	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore 8
    //   49: aload 8
    //   51: invokeinterface 200 1 0
    //   56: ifeq +429 -> 485
    //   59: aload 8
    //   61: invokeinterface 204 1 0
    //   66: checkcast 2840	KQQ/ProfSmpInfoRes
    //   69: astore 9
    //   71: aload 9
    //   73: getfield 2843	KQQ/ProfSmpInfoRes:dwUin	J
    //   76: invokestatic 297	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   79: astore 10
    //   81: aload_2
    //   82: aload 10
    //   84: invokevirtual 2846	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   87: ifeq -38 -> 49
    //   90: aload 9
    //   92: aload 10
    //   94: aload_0
    //   95: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 484	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   101: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: aload_0
    //   105: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: aload 10
    //   110: invokestatic 2849	aopy:a	(LKQQ/ProfSmpInfoRes;ZLcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   113: aload 9
    //   115: getfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   118: ifge +18 -> 136
    //   121: ldc 155
    //   123: iconst_1
    //   124: ldc_w 2854
    //   127: invokestatic 531	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 9
    //   132: iconst_0
    //   133: putfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   136: aload 9
    //   138: getfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   141: invokestatic 2859	nok:a	(I)Z
    //   144: ifne +14 -> 158
    //   147: aload 9
    //   149: getfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   152: invokestatic 2861	bkgt:b	(I)Z
    //   155: ifeq +28 -> 183
    //   158: aload 5
    //   160: aload 10
    //   162: invokeinterface 284 2 0
    //   167: pop
    //   168: aload 9
    //   170: getfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   173: invokestatic 2859	nok:a	(I)Z
    //   176: aload_0
    //   177: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: invokestatic 2864	aopy:a	(ZLcom/tencent/mobileqq/app/QQAppInterface;)V
    //   183: aload 7
    //   185: aload 9
    //   187: getfield 2843	KQQ/ProfSmpInfoRes:dwUin	J
    //   190: invokestatic 297	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   193: aload 9
    //   195: getfield 2867	KQQ/ProfSmpInfoRes:strNick	Ljava/lang/String;
    //   198: aload 9
    //   200: getfield 2852	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   203: aload 9
    //   205: getfield 2870	KQQ/ProfSmpInfoRes:cSex	B
    //   208: i2s
    //   209: aload 9
    //   211: getfield 2873	KQQ/ProfSmpInfoRes:wAge	B
    //   214: invokevirtual 2876	anyw:a	(Ljava/lang/String;Ljava/lang/String;BSB)V
    //   217: aload 7
    //   219: aload 10
    //   221: invokevirtual 1745	anyw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   224: astore 11
    //   226: aload_0
    //   227: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: aload 9
    //   232: aload 11
    //   234: aload 10
    //   236: aload_2
    //   237: invokestatic 2879	aopy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LKQQ/ProfSmpInfoRes;Lcom/tencent/mobileqq/data/Card;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   240: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +126 -> 369
    //   246: new 2317	java/lang/StringBuffer
    //   249: dup
    //   250: sipush 200
    //   253: invokespecial 2318	java/lang/StringBuffer:<init>	(I)V
    //   256: astore 12
    //   258: aload 12
    //   260: ldc_w 2881
    //   263: invokevirtual 2323	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   266: pop
    //   267: aload 12
    //   269: aload 9
    //   271: getfield 2884	KQQ/ProfSmpInfoRes:isShowXMan	I
    //   274: invokevirtual 2326	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   277: pop
    //   278: aload 12
    //   280: ldc_w 2886
    //   283: invokevirtual 2323	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: pop
    //   287: aload 12
    //   289: aload 9
    //   291: getfield 2889	KQQ/ProfSmpInfoRes:dwLoginDay	J
    //   294: invokevirtual 2344	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   297: pop
    //   298: aload 12
    //   300: ldc_w 2891
    //   303: invokevirtual 2323	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   306: pop
    //   307: aload 12
    //   309: aload 9
    //   311: getfield 2894	KQQ/ProfSmpInfoRes:dwPhoneQQXManDay	J
    //   314: invokevirtual 2344	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   317: pop
    //   318: aload 12
    //   320: ldc_w 2896
    //   323: invokevirtual 2323	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   326: pop
    //   327: aload 12
    //   329: aload 11
    //   331: getfield 2899	com/tencent/mobileqq/data/Card:allowClick	Z
    //   334: invokevirtual 2902	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload 12
    //   340: ldc_w 2904
    //   343: invokevirtual 2323	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   346: pop
    //   347: aload 12
    //   349: aload 11
    //   351: getfield 2907	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   354: invokevirtual 2902	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   357: pop
    //   358: ldc 155
    //   360: iconst_2
    //   361: aload 12
    //   363: invokevirtual 2356	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   366: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 7
    //   371: aload 11
    //   373: invokevirtual 2910	anyw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   376: pop
    //   377: aload_0
    //   378: aload_1
    //   379: aload 9
    //   381: aload 6
    //   383: aload 10
    //   385: invokestatic 2913	aopy:a	(Lcom/tencent/mobileqq/app/FriendListHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;Ljava/util/List;Ljava/lang/String;)V
    //   388: aload_0
    //   389: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   392: aload_1
    //   393: aload 9
    //   395: invokestatic 2916	aopy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   398: aload_0
    //   399: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: aload_1
    //   403: aload 9
    //   405: invokestatic 2918	aopy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   408: aload_0
    //   409: iconst_3
    //   410: iconst_1
    //   411: aload 10
    //   413: invokevirtual 437	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   416: goto -367 -> 49
    //   419: astore_2
    //   420: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +13 -> 436
    //   426: ldc 155
    //   428: iconst_2
    //   429: ldc_w 2920
    //   432: aload_2
    //   433: invokestatic 2922	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   436: aload_3
    //   437: ifnull +7 -> 444
    //   440: aload_3
    //   441: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   444: aload_0
    //   445: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   448: aload 5
    //   450: invokestatic 2925	aopy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   453: aload_0
    //   454: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   457: aload 6
    //   459: invokestatic 2927	aopy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   462: aload_1
    //   463: getfield 555	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   466: ldc_w 2929
    //   469: invokevirtual 745	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   472: ifeq +12 -> 484
    //   475: aload_0
    //   476: bipush 67
    //   478: iconst_1
    //   479: aload 4
    //   481: invokevirtual 437	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   484: return
    //   485: aload_3
    //   486: invokevirtual 373	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   489: aload_3
    //   490: ifnull -46 -> 444
    //   493: aload_3
    //   494: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   497: goto -53 -> 444
    //   500: astore_1
    //   501: aload_3
    //   502: ifnull +7 -> 509
    //   505: aload_3
    //   506: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   509: aload_1
    //   510: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	FriendListHandler
    //   0	511	1	paramToServiceMsg	ToServiceMsg
    //   0	511	2	paramArrayList	ArrayList<String>
    //   0	511	3	paramFromServiceMsg	FromServiceMsg
    //   0	511	4	paramArrayList1	ArrayList<KQQ.ProfSmpInfoRes>
    //   27	422	5	localArrayList1	ArrayList
    //   36	422	6	localArrayList2	ArrayList
    //   12	358	7	localanyw	anyw
    //   47	13	8	localIterator	Iterator
    //   69	335	9	localProfSmpInfoRes	KQQ.ProfSmpInfoRes
    //   79	333	10	str	String
    //   224	148	11	localCard	Card
    //   256	106	12	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   38	49	419	java/lang/Exception
    //   49	136	419	java/lang/Exception
    //   136	158	419	java/lang/Exception
    //   158	183	419	java/lang/Exception
    //   183	369	419	java/lang/Exception
    //   369	416	419	java/lang/Exception
    //   485	489	419	java/lang/Exception
    //   38	49	500	finally
    //   49	136	500	finally
    //   136	158	500	finally
    //   158	183	500	finally
    //   183	369	500	finally
    //   369	416	500	finally
    //   420	436	500	finally
    //   485	489	500	finally
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    anyw localanyw = (anyw)this.app.getManager(51);
    if (paramBoolean) {
      localanyw.a(paramDelGroupResp.cGroupid);
    }
    notifyUI(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 0, paramByte1, paramByte2, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      if (paramInt == 2)
      {
        ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
      break;
      label168:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      }
    }
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramString2, 0);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt1 + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    localToServiceMsg.extraData.putInt("random_key", paramInt3);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    send(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    sendPbReq(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    sendPbReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    b(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    b(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle)
  {
    b(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putInt("filter_type", paramInt3);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendListHandler", 4, "search friend with filter:" + paramInt3);
    }
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramBoolean, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean1)
    {
      localObject = createToServiceMsg("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify_plugin", paramBoolean2);
      send((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (anyw)this.app.getManager(51);
      Card localCard = paramString2.c(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((anws)this.app.getManager(53)).b(paramString1, (String)localObject);
      paramString1 = (axfr)this.app.getManager(11);
    } while (paramString1 == null);
    paramString1.f();
  }
  
  public void a(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (a(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", b(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", d(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      send(localToServiceMsg);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("uin=").append(paramString).append(", type size=");
      if (paramArrayOfInt != null) {
        break label142;
      }
      localObject1 = "";
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", switchState size=");
      if (paramArrayOfBoolean != null) {
        break label152;
      }
      localObject1 = "null";
      label64:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ringId size=");
      if (paramArrayOfString != null) {
        break label162;
      }
    }
    label142:
    label152:
    label162:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayOfString.length))
    {
      QLog.d("set_special_care_switches_of_a_person", 2, localObject1);
      if ((!bhsr.a(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
        break label173;
      }
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt.length);
      break;
      localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      break label64;
    }
    label173:
    Object localObject2 = new ArrayList();
    localObject1 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      int k = paramArrayOfBoolean[i];
      Object localObject3 = paramArrayOfString[i];
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      switch (j)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (k != 0)
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
        }
        else
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          if (k != 0)
          {
            if (bhsr.a((String)localObject3)) {
              throw new IllegalArgumentException("special ring id can not be empty!");
            }
            localObject3 = ((String)localObject3).getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          if (k != 0)
          {
            localObject3 = "1".getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
        }
      }
    }
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList, String paramString, int paramInt1, int paramInt2, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList1)
  {
    if ((paramInt2 != 3078) && (paramInt2 != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "addBatchPhoneFriend, sourceId=" + paramInt2 + " is invalid.");
      }
      return;
    }
    Object localObject2 = new ArrayList(30);
    int k = paramInt1 * 30;
    int i = paramArrayList.size() - k;
    int j;
    if (i > 30)
    {
      j = k + 30;
      i = paramInt1 + 1;
    }
    while (k < j)
    {
      ((List)localObject2).add(ByteStringMicro.copyFrom(((PhoneContact)paramArrayList.get(k)).unifiedCode.getBytes()));
      k += 1;
      continue;
      if (i == 30)
      {
        j = k + 30;
        i = -1;
      }
      else
      {
        j = i + k;
        i = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("addFriendTag", 2, String.format("addBatchPhoneFriend sourceId:%s, pkgIndex:%s, verifyMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    }
    Object localObject1 = new oidb_0x829.ReqBody();
    ((oidb_0x829.ReqBody)localObject1).uint32_source_id.set(paramInt2);
    ((oidb_0x829.ReqBody)localObject1).uint32_sub_source_id.set(1);
    ((oidb_0x829.ReqBody)localObject1).bytes_msg.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    ((oidb_0x829.ReqBody)localObject1).rpt_bytes_mobiles.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2089);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x829.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x829_1");
    ((ToServiceMsg)localObject1).extraData.putSerializable("phones", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putInt("package", i);
    ((ToServiceMsg)localObject1).extraData.putString("verifyMsg", paramString);
    ((ToServiceMsg)localObject1).extraData.putSerializable("resultList", paramArrayList1);
    ((ToServiceMsg)localObject1).extraData.putInt("sourceId", paramInt2);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (this.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty or app is null");
      }
      return;
    }
    Object localObject2 = this.app.getCurrentAccountUin();
    Object localObject1 = "";
    int i = paramArrayList.size() - 1;
    label55:
    String str;
    if (i >= 0)
    {
      str = (String)paramArrayList.get(i);
      if ((str == null) || (str.length() == 0) || (!Friends.isValidUin(str)) || (!a(str))) {
        paramArrayList.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label55;
      if (str.equals(localObject2))
      {
        localObject1 = localObject2;
        continue;
        if (paramArrayList.isEmpty())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty");
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendListHandler", 4, String.format(Locale.getDefault(), "getFriendInfoBatch size: %d, friendUin: %s", new Object[] { Integer.valueOf(paramArrayList.size()), localObject1 }));
        }
        localObject2 = createToServiceMsg("ProfileService.GetSimpleInfo");
        ((ToServiceMsg)localObject2).extraData.putStringArrayList("uinList", paramArrayList);
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqSelfLevel", b((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqXMan", d((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqDateNick", paramBoolean);
        ((ToServiceMsg)localObject2).extraData.putBoolean("batch_data", true);
        send((ToServiceMsg)localObject2);
        return;
      }
    }
  }
  
  public void a(List<oidb_0x7df.FriendScore> paramList)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      return;
    }
  }
  
  public void a(ConcurrentHashMap<String, MayKnowExposure> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, needReportCnt=" + paramConcurrentHashMap.size());
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        long l = Long.parseLong(this.mApp.getCurrentAccountUin());
        localArrayList = new ArrayList();
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        i = 0;
        if ((paramConcurrentHashMap.hasNext()) && (i < 99)) {
          break label189;
        }
        paramConcurrentHashMap = new oidb_0xc35.ReqBody();
        paramConcurrentHashMap.uint64_uin.set(l);
        paramConcurrentHashMap.rpt_msg_expose_info.set(localArrayList);
        sendPbReq(makeOIDBPkg("OidbSvc.0xc35_0", 3125, 0, paramConcurrentHashMap.toByteArray()));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, realReportCnt=" + i);
        return;
      }
      catch (Exception paramConcurrentHashMap) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
      return;
      label189:
      MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Map.Entry)paramConcurrentHashMap.next()).getValue();
      oidb_0xc35.ExposeItem localExposeItem = new oidb_0xc35.ExposeItem();
      localExposeItem.uint64_friend.set(Long.parseLong(localMayKnowExposure.uin));
      localExposeItem.uint32_action_id.set(localMayKnowExposure.actionId);
      localExposeItem.uint32_entrance_Id.set(localMayKnowExposure.entranceId);
      localExposeItem.uint32_expose_count.set(localMayKnowExposure.exposeCnt);
      localExposeItem.uint32_expose_time.set(localMayKnowExposure.exposeTime);
      localExposeItem.uint32_page_id.set(localMayKnowExposure.pageId);
      if (localMayKnowExposure.acBuffer != null) {
        localExposeItem.bytes_algo_buffer.set(ByteStringMicro.copyFrom(localMayKnowExposure.acBuffer));
      }
      if (localMayKnowExposure.additive != null) {
        localExposeItem.bytes_addition.set(ByteStringMicro.copyFrom(localMayKnowExposure.additive));
      }
      localArrayList.add(localExposeItem);
      i += 1;
    }
  }
  
  public void a(short paramShort, List<String> paramList, boolean paramBoolean)
  {
    a(paramShort, paramList, paramBoolean, false);
  }
  
  public void a(short paramShort, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramShort <= 0) || (paramList == null) || (paramShort != paramList.size())) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1268);
        localOIDBSSOPkg.uint32_service_type.set(5);
        if (!paramBoolean1) {
          break label302;
        }
        s = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s);
        ((ByteBuffer)localObject).putShort(paramShort);
        s = 0;
        if (s >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(bhjx.a(Long.parseLong((String)paramList.get(s))));
        if (paramBoolean1)
        {
          ((ByteBuffer)localObject).putShort((short)2);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject).putShort((short)1);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)0);
        }
      }
      catch (Exception paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "gatherContacts  Exception " + paramList.getMessage());
      return;
      label203:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      Object localObject = createToServiceMsg("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).extraData.putBoolean("needNotifyPlugin", paramBoolean2);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      s += 1;
      continue;
      label302:
      short s = paramShort * 9 + 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.CheckUpdateReq");
    localToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    localToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c6.ReqBody();
    ((cmd0x7c6.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    int i;
    if (paramInt == 1)
    {
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
      if (paramBoolean)
      {
        i = 1;
        paramString.set(i);
        label48:
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1990);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c6.ReqBody)localObject).toByteArray()));
        localObject = createToServiceMsg("OidbSvc.0x7c6_0");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        if (paramInt != 1) {
          break label290;
        }
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putBoolean("key_dongtai_permission", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      i = 0;
      break;
      if (paramInt == 2)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          paramString.set(i);
          break;
        }
      }
      if (paramInt == 3)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
        if (paramBoolean)
        {
          i = 1;
          label216:
          paramString.set(i);
          paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
          if (!paramBoolean) {
            break label250;
          }
        }
        label250:
        for (i = 1;; i = 0)
        {
          paramString.set(i);
          break;
          i = 0;
          break label216;
        }
      }
      if (paramInt != 4) {
        break label48;
      }
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_recv_msg_box;
      if (paramBoolean == true) {}
      for (i = 1;; i = 0)
      {
        paramString.set(i);
        break;
      }
      label290:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      } else if (paramInt == 4) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 4);
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 355	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +43 -> 52
    //   12: ldc_w 1027
    //   15: iconst_2
    //   16: new 157	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1029
    //   26: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_3
    //   30: invokevirtual 774	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 1034
    //   36: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 887	com/tencent/mobileqq/app/FriendListHandler:jdField_c_of_type_Long	J
    //   43: invokevirtual 774	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 887	com/tencent/mobileqq/app/FriendListHandler:jdField_c_of_type_Long	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +23 -> 81
    //   61: aload_0
    //   62: getfield 887	com/tencent/mobileqq/app/FriendListHandler:jdField_c_of_type_Long	J
    //   65: lstore 5
    //   67: lload_3
    //   68: lload 5
    //   70: lsub
    //   71: ldc2_w 3320
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 887	com/tencent/mobileqq/app/FriendListHandler:jdField_c_of_type_Long	J
    //   86: new 49	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 51	java/util/ArrayList:<init>	()V
    //   93: astore 7
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 314	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 484	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: iconst_0
    //   104: bipush 20
    //   106: iconst_0
    //   107: bipush 100
    //   109: lconst_0
    //   110: aload 7
    //   112: iload_1
    //   113: iload_2
    //   114: iconst_0
    //   115: invokespecial 1216	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;IIIIJLjava/util/ArrayList;ZZS)V
    //   118: goto -40 -> 78
    //   121: astore 7
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 7
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	FriendListHandler
    //   0	128	1	paramBoolean1	boolean
    //   0	128	2	paramBoolean2	boolean
    //   5	78	3	l1	long
    //   65	4	5	l2	long
    //   93	18	7	localArrayList	ArrayList
    //   121	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	121	finally
    //   52	67	121	finally
    //   81	118	121	finally
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        SubMsgType0x11e.MsgBody localMsgBody = new SubMsgType0x11e.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_type.has()) {
          break label172;
        }
        l = localMsgBody.uint32_type.get();
        if (!localMsgBody.str_reason.has()) {
          break label179;
        }
        paramArrayOfByte = localMsgBody.str_reason.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "decodePush0x210_0x11e,type = " + l + " reason = " + paramArrayOfByte);
        }
        if (l == 1L)
        {
          a(true);
          return;
        }
        if (l != 2L) {
          break label171;
        }
        a(true, 8);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e decode error, e=" + paramArrayOfByte.toString());
        return;
      }
      QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e pbData = null");
      label171:
      return;
      label172:
      long l = -1L;
      continue;
      label179:
      paramArrayOfByte = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    send(localToServiceMsg);
  }
  
  public void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    ((anyw)this.app.getManager(51)).a(paramArrayOfFriends, paramLong, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 3, null, false);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    int j = -1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setHiddenChat(). uin size=");
      if (paramArrayOfString != null) {
        break label92;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label99;
      }
    }
    label92:
    label99:
    for (int i = j;; i = paramArrayOfBoolean.length)
    {
      QLog.d("tag_hidden_chat", 2, i);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label106;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label106:
    Object localObject1 = new ArrayList();
    i = 0;
    if (i < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i];
      int k = paramArrayOfBoolean[i];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      if (k != 0)
      {
        ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
        byte[] arrayOfByte = "1".getBytes();
        ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
        localArrayList.add(localObject3);
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
        break;
        ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
        localArrayList.add(localObject3);
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).extraData.putIntArray("param_chat_types", paramArrayOfInt);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: start: " + paramInt1 + ", count: " + paramInt2 + ", uinList: " + paramArrayList + ", isSort: " + paramBoolean1 + ", reqNick: " + paramBoolean2);
    }
    if (((paramArrayList == null) || (paramArrayList.size() <= 0)) && ((paramInt1 < 0) || (paramInt2 <= 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
      }
      return false;
    }
    paramArrayList = new oidb_0x7df.ReqBody();
    paramArrayList.uint32_seq.set(0);
    paramArrayList.uint32_start_index.set(paramInt1);
    paramArrayList.uint32_req_num.set(paramInt2);
    Object localObject = paramArrayList.uint32_sort;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = paramArrayList.uint32_nick;
      paramInt1 = i;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2015);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      paramArrayList = createToServiceMsg("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      sendPbReq(paramArrayList);
      jdField_a_of_type_Int = 3;
      return true;
    }
  }
  
  public boolean a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.jdField_d_of_type_JavaUtilHashtable)
    {
      if (!this.jdField_d_of_type_JavaUtilHashtable.containsKey(paramString)) {
        break label181;
      }
      paramString = (anyq)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
      l2 = Math.abs(l1 - paramString.jdField_a_of_type_Long);
      if (paramString.jdField_c_of_type_Long > 0L)
      {
        if (l1 < paramString.jdField_c_of_type_Long) {
          return false;
        }
        paramString.jdField_c_of_type_Long = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.jdField_b_of_type_Long = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.jdField_b_of_type_Long += 1L;
    if ((paramString.jdField_b_of_type_Long >= 8L) && (l2 < 120000L)) {
      paramString.jdField_c_of_type_Long = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      if (l2 > 60000L)
      {
        paramString.jdField_c_of_type_Long = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.jdField_b_of_type_Long = 1L;
      }
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.jdField_d_of_type_JavaUtilHashtable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_d_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        anyq localanyq = (anyq)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localanyq.jdField_c_of_type_Long == 0L) && (l1 - localanyq.jdField_a_of_type_Long > 60000L)) || ((localanyq.jdField_c_of_type_Long > 0L) && (l1 > localanyq.jdField_c_of_type_Long))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(i);
        this.jdField_d_of_type_JavaUtilHashtable.remove(localObject2);
        i += 1;
      }
      else
      {
        localObject1 = new anyq();
        ((anyq)localObject1).jdField_a_of_type_Long = l1;
        ((anyq)localObject1).jdField_b_of_type_Long = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    paramString2 = (anyw)this.app.getManager(51);
    Object localObject = (PhoneContactManagerImp)this.app.getManager(11);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b();
    }
    paramBoolean1 = paramString2.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean1);
    }
    if (paramBoolean1)
    {
      this.app.a().b(paramString1, 0);
      if (this.jdField_c_of_type_Long == 0L) {
        notifyUI(1, true, Boolean.valueOf(true));
      }
      notifyUI(63, true, paramString1);
      localObject = (axup)this.app.getManager(106);
      if (localObject != null) {
        ((axup)localObject).d.put("" + paramString1, Integer.valueOf(1));
      }
      a(paramString1);
      paramString2.a(paramString1, false);
      ((bayl)this.app.getManager(91)).a(Long.valueOf(paramString1).longValue());
      if ((bkgt.b(this.app, paramString1)) || ((!nok.b(this.app, paramString1)) && (!nok.c(this.app, paramString1)))) {
        this.app.a().a(paramString1, paramInt2);
      }
      aopy.a(nok.b(this.app, paramString1), this.app);
    }
    paramString2 = paramString2.a();
    if (paramString2 != null) {
      paramString2.b(paramString1);
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    aean.a(this.app, BaseApplication.getContext(), paramString2);
    return paramBoolean1;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bbbt == null) {
      this.jdField_a_of_type_Bbbt = new bbbt();
    }
    paramBoolean = this.jdField_a_of_type_Bbbt.a(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean) {
      this.jdField_a_of_type_Bbbt.a(this);
    }
    return paramBoolean;
  }
  
  public boolean a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.jdField_a_of_type_Short).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(bhjx.a(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(List<Long> paramList1, List<Long> paramList2, int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getMayKnowRecommend, filterUins=");
      if (paramList1 == null) {
        break label227;
      }
      localObject = paramList1;
      QLog.i("FriendListHandler", 2, localObject + ", entryType=" + paramInt);
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xc26.ReqBody();
        if (paramList1 != null) {
          ((oidb_0xc26.ReqBody)localObject).rpt_filter_uins.set(paramList1);
        }
        paramList1 = (aobl)this.app.getManager(159);
        if ((paramList1 == null) || (!paramList1.a())) {
          break label286;
        }
        ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
        if (!QLog.isColorLevel()) {
          break label286;
        }
        QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
      }
      catch (Exception paramList1)
      {
        label227:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, paramList1, new Object[0]);
        return true;
      }
      QLog.e("FriendListHandler", 1, "getMayKnowRecommend, unknown entry type");
      paramInt = i;
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(paramInt);
      ((oidb_0xc26.ReqBody)localObject).uint32_fetch_rgroup.set(1);
      if (paramList2 != null) {
        ((oidb_0xc26.ReqBody)localObject).rpt_expected_uins.set(paramList2);
      }
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(23);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      paramList1 = makeOIDBPkg("OidbSvc.0xc26_0", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramList1.extraData.putBundle("EXTRA:OidbSvc.0xc26_0", paramBundle);
      sendPbReq(paramList1);
      return true;
      localObject = "";
      break;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      label286:
      int i = -1;
      switch (paramInt)
      {
      }
    }
  }
  
  public String b()
  {
    o();
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(new aoqk(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoql(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqj(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqm(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqq(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqn(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqg(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqh(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqp(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqs(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqt(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqr(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqi(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqo(this.app, this));
    this.jdField_a_of_type_JavaUtilList.add(new aoqu(this.app, this));
  }
  
  public void b(byte paramByte)
  {
    byte b1 = 1;
    boolean bool;
    if ((paramByte == 0) || (paramByte == 1))
    {
      if (paramByte != 1) {
        break label59;
      }
      bool = true;
      if (bool != d()) {
        if (!bool) {
          break label64;
        }
      }
    }
    label59:
    label64:
    for (paramByte = b1;; paramByte = 0)
    {
      this.g = paramByte;
      bhlf.a(this.app.getApp().getApplicationContext(), this.app.getAccount(), bool);
      return;
      bool = false;
      break;
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    cmd0xcf0.ReqBody localReqBody = new cmd0xcf0.ReqBody();
    localReqBody.uint32_expect_bind_contacts_frd_num.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvc.0xcf0_0", 3312, 0, localReqBody.toByteArray()));
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getFriendsHasBindPhone :" + paramInt);
    }
  }
  
  public void b(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setSpecialCareSwitch(). type=").append(paramInt).append(", uin size=");
      if (paramArrayOfString != null) {
        break label108;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label115;
      }
    }
    label108:
    label115:
    for (int i = -1;; i = paramArrayOfBoolean.length)
    {
      QLog.d("set_special_care_switch", 2, i);
      if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label122;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label122:
    Object localObject1 = new ArrayList();
    i = 0;
    if (i < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i];
      int j = paramArrayOfBoolean[i];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
        break;
        byte[] arrayOfByte;
        if (j != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          if (j != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          if (j != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "agreeSuspiciousMsg " + paramLong);
    }
    Object localObject = new oidb_cmd0xd72.ReqBody();
    ((oidb_cmd0xd72.ReqBody)localObject).doubt_uin.set(paramLong);
    ((oidb_cmd0xd72.ReqBody)localObject).uin.set(this.app.getLongAccountUin());
    localObject = makeOIDBPkg("OidbSvc.0xd72", 3442, 0, ((oidb_cmd0xd72.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("toUin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    send(localToServiceMsg);
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    send(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.FriendListHandler", 2, String.format("reqLastChatTime frdUin=%s daysForward=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc85.ReqBody();
      ((cmd0xc85.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc85.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc85.ReqBody)localObject).uint32_op.set(2);
      ((cmd0xc85.ReqBody)localObject).uint32_interval_days.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xc85", 3205, 0, ((cmd0xc85.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public void b(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "getQCallHead QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level =  faceFileType = " + paramByte2);
    }
    a(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, uinOrMobile= " + paramString + ",isRemove=" + paramBoolean + "downloadSize=" + this.jdField_b_of_type_JavaUtilHashtable.size());
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        a(9205, (String)localObject2, -1, 4);
        i += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i = 0;
      }
    }
  }
  
  public void b(List<QIMNotifyAddFriend> paramList)
  {
    Object localObject = new cmd0xaed.ReqBody();
    ((cmd0xaed.ReqBody)localObject).uint64_qq_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    StringBuilder localStringBuilder = new StringBuilder("addBatchQIMFriends ");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QIMNotifyAddFriend localQIMNotifyAddFriend = (QIMNotifyAddFriend)paramList.next();
      ((cmd0xaed.ReqBody)localObject).rpt_uint64_add_qim_uins.add(Long.valueOf(localQIMNotifyAddFriend.uin));
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(localQIMNotifyAddFriend.uin);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.QIM", 2, localStringBuilder.toString());
    }
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2797);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xaed.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xaed_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i = 0;
    }
    ((ByteBuffer)localObject).put((byte)i);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis() - this.jdField_e_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l + " | sGetOnlineFriendDelay = " + QQAppInterface.jdField_f_of_type_Int);
    }
    return (this.jdField_e_of_type_Long > 0L) && ((l < QQAppInterface.jdField_f_of_type_Int) || (l > QQAppInterface.jdField_e_of_type_Int - QQAppInterface.jdField_f_of_type_Int));
  }
  
  public boolean b(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l;
    if (bool1)
    {
      l = bhlf.a(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
      if (Math.abs(System.currentTimeMillis() - l) <= 86400000L) {
        break label109;
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
  }
  
  public void c(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    send(localToServiceMsg);
  }
  
  public void c(String paramString)
  {
    a(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void c(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    send(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", mrs.a(paramString));
    }
  }
  
  public void c(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      j = paramArrayOfString.length;
      i = 0;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((Friends.isValidUin(str)) && (a(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfString[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    b(paramArrayOfString);
    paramArrayOfString = createToServiceMsg("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    send(paramArrayOfString);
  }
  
  public boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_f_of_type_Long;
    if ((l2 < this.jdField_a_of_type_Long) && (l2 > -this.jdField_a_of_type_Long)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.jdField_f_of_type_Long = l1;
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label275;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          a(9205, paramString, -1, 4);
          i = 0;
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = bhjr.a();
            if (((bool3) && (bhjr.a() < 2048L)) || ((!bool3) && (bhjr.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, whatIf= " + i + ", NeedDownload=" + bool2);
            }
            return bool2;
          }
        }
        else
        {
          i = 1;
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          bhlf.a(this.app.getApp().getApplicationContext(), true);
          bool2 = bool1;
          continue;
          label275:
          i = -1;
          bool1 = true;
        }
      }
    }
  }
  
  public void d()
  {
    String str = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (d(str))) {
      b(str);
    }
  }
  
  public void d(String paramString)
  {
    a(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void d(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (b())) {}
    do
    {
      return;
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      send(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public boolean d()
  {
    if (this.g == -1) {}
    for (;;)
    {
      try
      {
        if (!bhlf.a(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
          continue;
        }
        i = 1;
        this.g = i;
      }
      catch (Exception localException)
      {
        int i;
        this.g = 0;
        continue;
      }
      if (this.g != 1) {
        break label62;
      }
      return true;
      i = 0;
    }
    label62:
    return false;
  }
  
  public void e()
  {
    Object localObject = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (e((String)localObject)) && (Friends.isValidUin((String)localObject)) && (a((String)localObject)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      localObject = createToServiceMsg("ProfileService.GetSimpleInfo");
      ((ToServiceMsg)localObject).extraData.putStringArrayList("uinList", localArrayList);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqSelfLevel", false);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqXMan", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqDateNick", false);
      ((ToServiceMsg)localObject).extraData.putInt("getXManInfoScene", 2);
      send((ToServiceMsg)localObject);
    }
  }
  
  public void e(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public boolean e()
  {
    boolean bool1;
    if (this.app.getCurrentAccountUin() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = bhlf.b(this.app.getApp().getApplicationContext(), this.app.getAccount());
      bool1 = bool2;
    } while (!bool2);
    a(0L, 0L, 0L);
    return bool2;
  }
  
  public void f()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void f(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new FriendListHandler.5(this, paramString));
  }
  
  public void g()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive.FriendListHandler", 2, "reqRecheckInHotReactive frdUin=" + paramString);
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc83.ReqBody();
      ((cmd0xc83.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc83.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc83.ReqBody)localObject).uint32_op.set(2);
      localObject = makeOIDBPkg("OidbSvc.0xc83", 3203, 0, ((cmd0xc83.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_0", 3124, 0, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend exception", localException);
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_1", 3124, 1, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend exception", localException);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getSuspiciousFriendsUnreadNum");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(2);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(2));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteAllSuspiciousMsg ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(4);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(4));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "sendReadReportSuspicious ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(5);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(5));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("friendlist.getFriendGroupList");
      this.allowCmdSet.add("friendlist.GetLastLoginInfoReq");
      this.allowCmdSet.add("ProfileService.GetRichSig");
      this.allowCmdSet.add("ProfileService.GetSimpleInfo");
      this.allowCmdSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0xc34_0");
      this.allowCmdSet.add("OidbSvc.0xc34_1");
      this.allowCmdSet.add("OidbSvc.0xc83");
      this.allowCmdSet.add("OidbSvc.0xc85");
      this.allowCmdSet.add("StatSvc.GetDevLoginInfo");
      this.allowCmdSet.add("StatSvc.DelDevLoginInfo");
      this.allowCmdSet.add("StatSvc.SvcReqKikOut");
      this.allowCmdSet.add("StatSvc.BindUin");
      this.allowCmdSet.add("ProfileService.ReqGetSettings");
      this.allowCmdSet.add("ProfileService.ReqSetSettings");
      this.allowCmdSet.add("friendlist.MovGroupMemReq");
      this.allowCmdSet.add("BumpSvc.ReqComfirmContactFriend");
      this.allowCmdSet.add("friendlist.addFriend");
      this.allowCmdSet.add("friendlist.getUserAddFriendSetting");
      this.allowCmdSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.allowCmdSet.add("friendlist.GetOnlineInfoReq");
      this.allowCmdSet.add("friendlist.delFriend");
      this.allowCmdSet.add("friendlist.SetGroupReq");
      this.allowCmdSet.add("ProfileService.ChangeFriendName");
      this.allowCmdSet.add("ProfileService.SetRichSig");
      this.allowCmdSet.add("StatSvc.register");
      this.allowCmdSet.add("friendlist.GetAutoInfoReq");
      this.allowCmdSet.add("ProfileService.CheckUpdateReq");
      this.allowCmdSet.add("SummaryCard.ReqSearch");
      this.allowCmdSet.add("SummaryCard.ReqCondSearch");
      this.allowCmdSet.add("OidbSvc.0x5d1_0");
      this.allowCmdSet.add("OidbSvc.0x4fc_30");
      this.allowCmdSet.add("DevLockAuthSvc.RecommendAuth");
      this.allowCmdSet.add("DevLockAuthSvc.ConfirmAuth");
      this.allowCmdSet.add("OidbSvc.0x476_146");
      this.allowCmdSet.add("OidbSvc.0x476_147");
      this.allowCmdSet.add("OidbSvc.0x490_107");
      this.allowCmdSet.add("OidbSvc.0x491_107");
      this.allowCmdSet.add("OidbSvc.0x5e1_8");
      this.allowCmdSet.add("OidbSvc.0x49d_107");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0x7c4_0");
      this.allowCmdSet.add("OidbSvc.0x4f4_5");
      this.allowCmdSet.add("OidbSvc.0x7c6_0");
      this.allowCmdSet.add("OidbSvc.0x7c7_0");
      this.allowCmdSet.add("OidbSvc.0x847_3");
      this.allowCmdSet.add("OidbSvc.0x53b_0");
      this.allowCmdSet.add("OidbSvc.0x6c9_0");
      this.allowCmdSet.add("OidbSvc.0x7df_3");
      this.allowCmdSet.add("OidbSvc.0x5d6_7");
      this.allowCmdSet.add("OidbSvc.0x5d6_19");
      this.allowCmdSet.add("OidbSvc.0x5d6_18");
      this.allowCmdSet.add("OidbSvc.0x77c");
      this.allowCmdSet.add("OidbSvc.0x5d6_21");
      this.allowCmdSet.add("OidbSvc.0x829_1");
      this.allowCmdSet.add("OidbSvc.0x777");
      this.allowCmdSet.add("OidbSvc.0xc26_0");
      this.allowCmdSet.add("OidbSvc.0xc36_0");
      this.allowCmdSet.add("OidbSvc.0xc35_0");
      this.allowCmdSet.add("OidbSvc.0xcf0_0");
      this.allowCmdSet.add("OidbSvc.0xd69");
      this.allowCmdSet.add("OidbSvc.0xd72");
      this.allowCmdSet.add("OidbSvc.0x5d6_21");
      this.allowCmdSet.add("OidbSvc.0xc26_1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends anui> observerClass()
  {
    return anyu.class;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.a();
    }
    m();
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              aoqf localaoqf = (aoqf)((Iterator)localObject).next();
              if (localaoqf.a(paramFromServiceMsg.getServiceCmd()))
              {
                localaoqf.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
            }
            if (paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList"))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (GetFriendListResp)paramObject);
              return;
            }
            if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
              break;
            }
          } while (!paramFromServiceMsg.isSuccess());
          int i = paramToServiceMsg.extraData.getInt("reqType", 0);
          if ((i == 0) || (i == 3))
          {
            b(paramToServiceMsg, paramObject);
            return;
          }
          a(paramToServiceMsg, paramObject);
          return;
          if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
          localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
        } while (!paramFromServiceMsg.isSuccess());
        paramObject = (ArrayList)paramObject;
      } while ((paramObject == null) || (localObject == null));
      a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
      return;
      if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
        return;
      }
      if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x777".equals(paramFromServiceMsg.getServiceCmd()));
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */