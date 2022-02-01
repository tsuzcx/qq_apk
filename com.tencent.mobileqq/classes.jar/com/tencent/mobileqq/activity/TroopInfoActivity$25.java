package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopInfoActivity$25
  extends TroopBusinessObserver
{
  TroopInfoActivity$25(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
      this.a.c();
    }
  }
  
  public void onGetTroopAuditTimes(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    this.a.c = paramInt1;
    this.a.d = paramInt2;
    this.a.e = paramInt3;
    if ((this.a.c == 1) || (this.a.c == 2)) {
      this.a.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4).edit().remove("has_shown_tips").commit();
    }
    if (this.a.c == 2)
    {
      paramString = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
        this.a.a(10, paramString, true);
      }
      paramString = paramGroupInfo.group_geo_info.bytes_geocontent.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString)) {
        this.a.a(5, paramString, true);
      }
      paramString = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(paramGroupInfo.uint32_group_class_ext.get()));
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
        this.a.a(4, paramString.a(), true);
      }
      paramString = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
        paramString = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.a.a(8, paramString, true, 2, true);
      }
      paramString = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramString;
        this.a.a(6, paramString, true);
      }
    }
    TroopInfoActivity.e(this.a);
  }
  
  public void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.b = paramInt;
    }
  }
  
  public void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString1)))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramString2;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong))) {}
    do
    {
      do
      {
        return;
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
          }
          if (paramBoolean)
          {
            this.a.a(2131693436, 2);
            return;
          }
          this.a.a(2131693435, 1);
          TroopInfoActivity.a(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 4) {}
    while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.g(this.a);
      return;
    }
    this.a.a(2131719023, 1);
  }
  
  public void onSetTroopAuditTimes(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.g(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getString(2131693435);
    }
    QQToast.a(localBaseApplication, 1, str, 0).b(this.a.getTitleBarHeight());
  }
  
  public void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramTroopInfo == null) || (!Utils.a(paramTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onTroopSearch|result = " + paramByte + ", p = " + paramTroopInfo);
      }
    } while (paramByte != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.25
 * JD-Core Version:    0.7.0.1
 */