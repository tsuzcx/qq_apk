package com.tencent.mobileqq.app.friendlist.batchupdate;

import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import amrb;
import amsw;
import amzf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anii;
import axvv;
import axys;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class FriendInfoBatchUpdater
{
  public static final String TAG = "Q.contacttab.friend.ExtensionInfoBatchUpdater";
  private QQAppInterface app;
  private boolean bComplete;
  FriendInfoBatchUpdater.FriendListSaveCallback callback;
  private amsw fm;
  Friends[] friendList;
  private FriendListHandler friendListHandler;
  ArrayList<Friends> friendsListWithNewName;
  ArrayList<Friends> friendsListWithNewRemark;
  private long timeStamp;
  
  public FriendInfoBatchUpdater(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean, FriendInfoBatchUpdater.FriendListSaveCallback paramFriendListSaveCallback)
  {
    this.app = paramQQAppInterface;
    this.friendList = paramArrayOfFriends;
    this.timeStamp = paramLong;
    this.bComplete = paramBoolean;
    this.friendsListWithNewName = new ArrayList();
    this.friendsListWithNewRemark = new ArrayList();
    this.callback = paramFriendListSaveCallback;
    this.fm = ((amsw)paramQQAppInterface.getManager(51));
    this.friendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1));
  }
  
  public void saveInBatch()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ExtensionInfoBatchUpdater", 2, "saveInBatch friendList size=" + this.friendList.length);
    }
    amrb localamrb = (amrb)this.app.getManager(53);
    Iterator localIterator;
    Friends localFriends;
    String str;
    if (this.friendsListWithNewName.size() > 0)
    {
      localIterator = this.friendsListWithNewName.iterator();
      while (localIterator.hasNext())
      {
        localFriends = (Friends)localIterator.next();
        str = localFriends.name;
        amzf.a(Long.parseLong(localFriends.uin), str, localamrb);
      }
    }
    if (this.friendsListWithNewRemark.size() > 0)
    {
      localIterator = this.friendsListWithNewRemark.iterator();
      while (localIterator.hasNext())
      {
        localFriends = (Friends)localIterator.next();
        str = localFriends.remark;
        amzf.b(Long.parseLong(localFriends.uin), str, localamrb);
      }
    }
    this.callback.onSaveFriendsList(this.friendList, this.timeStamp, this.bComplete);
  }
  
  public void update(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    int j = 0;
    paramFriends.uin = String.valueOf(paramFriendInfo.friendUin);
    paramFriends.name = paramFriendInfo.nick;
    paramFriends.remark = paramFriendInfo.remark;
    paramFriends.groupid = paramFriendInfo.groupId;
    paramFriends.cSpecialFlag = paramFriendInfo.cSpecialFlag;
    paramFriends.detalStatusFlag = paramFriendInfo.detalStatusFlag;
    paramFriends.datetime = this.timeStamp;
    paramFriends.alias = paramFriendInfo.sShowName;
    paramFriends.abilityBits = paramFriendInfo.uAbiFlag;
    paramFriends.eNetwork = paramFriendInfo.eNetworkType;
    paramFriends.netTypeIconId = paramFriendInfo.eIconType;
    paramFriends.strTermDesc = paramFriendInfo.strTermDesc;
    paramFriends.setShieldFlag(false);
    paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
    paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
    paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
    boolean bool;
    label289:
    Friends localFriends;
    int i;
    if (paramFriendInfo.cKingOfGloryFlag == 1)
    {
      bool = true;
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      paramFriends.strMasterUin = paramFriendInfo.strMasterUin;
      paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
      paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
      axys.a(paramFriends, paramFriendInfo.vecMusicInfo, "GetFriendList");
      if ((!TextUtils.isEmpty(paramFriends.uin)) && (this.friendListHandler.app.getCurrentUin().equals(paramFriends.uin))) {
        this.friendListHandler.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.friendListHandler.app.getCurrentUin(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (paramFriendInfo.cOlympicTorch != 1) {
        break label929;
      }
      bool = true;
      paramFriends.setOlympicTorchFlag(bool);
      localFriends = this.fm.e(paramFriends.uin);
      paramFriends.iTermType = paramFriendInfo.iTermType;
      Object localObject = paramFriendInfo.oVipInfo;
      int k = EVIPSPEC.E_SP_QQVIP.value();
      if (localFriends == null) {
        break label935;
      }
      i = localFriends.qqVipInfo;
      label341:
      paramFriends.qqVipInfo = anii.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends == null) {
        break label940;
      }
      i = localFriends.superQqInfo;
      label378:
      paramFriends.superQqInfo = anii.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends == null) {
        break label945;
      }
      i = localFriends.superVipInfo;
      label415:
      paramFriends.superVipInfo = anii.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_BIGCLUB.value();
      i = j;
      if (localFriends != null) {
        i = localFriends.bigClubInfo;
      }
      paramFriends.bigClubInfo = anii.a((VipBaseInfo)localObject, k, i);
      paramFriends.cNewLoverDiamondFlag = paramFriendInfo.cNewLoverDiamondFlag;
      if ((paramFriendInfo.oVipInfo != null) && (paramFriendInfo.oVipInfo.mOpenInfo != null))
      {
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject != null) {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localObject != null) {
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        paramFriends.nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
        paramFriends.grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
      }
      if (localFriends != null)
      {
        paramFriends.showLoginClient = localFriends.showLoginClient;
        paramFriends.lastLoginType = localFriends.lastLoginType;
      }
      axvv.a(paramFriends, paramFriendInfo.vecExtOnlineBusinessInfo, "GetFriendList", localFriends);
      if ((localFriends != null) && (amzf.a(paramFriends.name, localFriends.name)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.friendsListWithNewName.add(paramFriends);
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(paramFriendInfo.nick)) && (!paramFriendInfo.nick.equals(paramFriendInfo.remark)) && (amzf.b(paramFriends.remark, localFriends.remark)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.friendsListWithNewRemark.add(paramFriends);
      }
      if (localFriends != null)
      {
        if (localFriends.gathtertype != 1) {
          break label950;
        }
        paramFriends.gathtertype = 1;
      }
    }
    for (;;)
    {
      paramFriends.age = localFriends.age;
      paramFriends.smartRemark = localFriends.smartRemark;
      paramFriends.gender = localFriends.gender;
      paramFriends.recommReason = localFriends.recommReason;
      return;
      bool = false;
      break;
      label929:
      bool = false;
      break label289;
      label935:
      i = 0;
      break label341;
      label940:
      i = 0;
      break label378;
      label945:
      i = 0;
      break label415;
      label950:
      if (localFriends.gathtertype == 2) {
        paramFriends.gathtertype = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.batchupdate.FriendInfoBatchUpdater
 * JD-Core Version:    0.7.0.1
 */