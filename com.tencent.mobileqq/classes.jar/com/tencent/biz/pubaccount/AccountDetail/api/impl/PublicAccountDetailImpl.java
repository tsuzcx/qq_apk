package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.oac.OACProfilePb.BaseData;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class PublicAccountDetailImpl
  extends Entity
  implements IPublicAccountDetail
{
  @notColumn
  public static final int ANCIENT = 0;
  @notColumn
  public static final int VERSION_839 = 1;
  public byte[] accountData = null;
  public int accountFlag = 0;
  public long accountFlag2 = 0L;
  @notColumn
  public int cardStyle = 0;
  public String certifiedDescription = "";
  @notColumn
  public String certifiedEnterprise = "";
  public int certifiedGrade = 0;
  @notColumn
  public String certifiedWeixin = "";
  public String configBackgroundColor = "3d7fe3";
  @notColumn
  public String configBackgroundImg = "";
  @notColumn
  public List<IPublicAccountConfigAttr> customConfigAttrs;
  public String displayNumber = "";
  public int followType = 0;
  @notColumn
  public List<IPublicAccountConfigAttr> fullscreenConfigAttrs;
  public int groupId = 0;
  public List<mobileqq_mp.ConfigGroupInfo> groupInfoList;
  public boolean isAgreeSyncLbs = false;
  public boolean isConfirmed = false;
  public boolean isRecvMsg = false;
  public boolean isRecvPush = false;
  public boolean isShowFollowButton = false;
  public boolean isShowShareButton = false;
  public boolean isSyncLbs = false;
  public boolean isSyncLbsSelected = false;
  public String lastHistoryMsg = null;
  public int mShowMsgFlag = -1;
  @notColumn
  public mobileqq_mp.GetPublicAccountMenuResponse menuButtonResp;
  public String name = HardCodeUtil.a(2131898007);
  public List<mobileqq_mp.ConfigGroupInfo> newGroupInfoList;
  @notColumn
  public List<IPublicAccountConfigAttr> paConfigAttrs;
  public byte[] protocol839Data = null;
  public int protocolVersion = 0;
  public int seqno = 0;
  public int sharedFollowerCount = 0;
  public int showFlag = 0;
  public String summary = HardCodeUtil.a(2131898009);
  @unique
  public String uin;
  @notColumn
  public String unifiedDesrpition;
  
  public PublicAccountDetailImpl() {}
  
  public PublicAccountDetailImpl(OACProfilePb.ProfileDataRsp paramProfileDataRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramProfileDataRsp.base_data.puin.get());
    this.uin = localStringBuilder.toString();
    this.name = paramProfileDataRsp.base_data.name.get();
    this.summary = paramProfileDataRsp.base_data.summary.get();
    this.isRecvMsg = paramProfileDataRsp.base_data.is_recv_msg.get();
    this.isShowFollowButton = paramProfileDataRsp.base_data.is_show_follow_button.get();
    this.followType = paramProfileDataRsp.base_data.follow_type.get();
    this.isRecvPush = paramProfileDataRsp.base_data.is_recv_push.get();
    this.accountFlag = paramProfileDataRsp.base_data.account_flag.get();
    this.accountFlag2 = paramProfileDataRsp.base_data.account_flag2.get();
    this.displayNumber = paramProfileDataRsp.base_data.display_number.get();
    if (paramProfileDataRsp.base_data.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramProfileDataRsp.base_data.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    this.menuButtonResp = paramProfileDataRsp.menu_rsp;
    this.protocolVersion = 1;
    this.protocol839Data = paramProfileDataRsp.toByteArray();
    this.sharedFollowerCount = paramProfileDataRsp.common_follower_count.get();
    this.showFlag = 1;
  }
  
  public static int getReportAccountType(AppInterface paramAppInterface, String paramString, PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if ((paramAppInterface == null) && (paramPublicAccountDetailImpl == null)) {
      return 1;
    }
    Object localObject = paramPublicAccountDetailImpl;
    if (paramPublicAccountDetailImpl == null)
    {
      paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      localObject = paramPublicAccountDetailImpl;
      if (paramAppInterface != null)
      {
        paramAppInterface = (PublicAccountDetailImpl)paramAppInterface.findAccountDetailInfo(paramString);
        localObject = paramAppInterface;
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountDetailImpl", 2, "getReportAccountType--> input accountdetail null");
          localObject = paramAppInterface;
        }
      }
    }
    if (localObject == null) {
      return 1;
    }
    int i;
    if (((PublicAccountDetailImpl)localObject).accountFlag < 0) {
      i = -9;
    } else {
      i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((PublicAccountDetailImpl)localObject).accountFlag);
    }
    if (i != -9)
    {
      if (i != -6)
      {
        if (i != -5)
        {
          if (i != -4)
          {
            if (i != -3)
            {
              if (i != -2) {
                return 1;
              }
              return 3;
            }
            return 5;
          }
          i = 4;
          if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(((PublicAccountDetailImpl)localObject).accountFlag2) == -8L) {
            return 8;
          }
        }
        else
        {
          return 6;
        }
      }
      else {
        return 7;
      }
    }
    else {
      i = 9;
    }
    return i;
  }
  
  public void clone(IPublicAccountDetail paramIPublicAccountDetail)
  {
    paramIPublicAccountDetail = (PublicAccountDetailImpl)paramIPublicAccountDetail;
    this.uin = paramIPublicAccountDetail.uin;
    this.seqno = paramIPublicAccountDetail.seqno;
    this.name = paramIPublicAccountDetail.name;
    this.summary = paramIPublicAccountDetail.summary;
    this.isRecvMsg = paramIPublicAccountDetail.isRecvMsg;
    this.followType = paramIPublicAccountDetail.followType;
    this.isShowFollowButton = paramIPublicAccountDetail.isShowFollowButton;
    this.accountData = paramIPublicAccountDetail.accountData;
    this.groupInfoList = paramIPublicAccountDetail.groupInfoList;
    this.displayNumber = paramIPublicAccountDetail.displayNumber;
    this.groupId = paramIPublicAccountDetail.groupId;
    this.isRecvPush = paramIPublicAccountDetail.isRecvPush;
    this.isSyncLbs = paramIPublicAccountDetail.isSyncLbs;
    this.certifiedGrade = paramIPublicAccountDetail.certifiedGrade;
    this.showFlag = paramIPublicAccountDetail.showFlag;
    this.accountFlag = paramIPublicAccountDetail.accountFlag;
    this.accountFlag2 = paramIPublicAccountDetail.accountFlag2;
    this.mShowMsgFlag = paramIPublicAccountDetail.mShowMsgFlag;
    this.configBackgroundColor = paramIPublicAccountDetail.configBackgroundColor;
    this.configBackgroundImg = paramIPublicAccountDetail.configBackgroundImg;
    this.newGroupInfoList = paramIPublicAccountDetail.newGroupInfoList;
    this.certifiedDescription = paramIPublicAccountDetail.certifiedDescription;
    this.isAgreeSyncLbs = paramIPublicAccountDetail.isAgreeSyncLbs;
    this.isSyncLbsSelected = paramIPublicAccountDetail.isSyncLbsSelected;
    this.unifiedDesrpition = paramIPublicAccountDetail.unifiedDesrpition;
    this.paConfigAttrs = paramIPublicAccountDetail.paConfigAttrs;
    this.customConfigAttrs = paramIPublicAccountDetail.customConfigAttrs;
    this.fullscreenConfigAttrs = paramIPublicAccountDetail.fullscreenConfigAttrs;
    this.cardStyle = paramIPublicAccountDetail.cardStyle;
    this.menuButtonResp = paramIPublicAccountDetail.menuButtonResp;
    this.protocolVersion = paramIPublicAccountDetail.protocolVersion;
    this.protocol839Data = paramIPublicAccountDetail.protocol839Data;
    this.sharedFollowerCount = paramIPublicAccountDetail.sharedFollowerCount;
  }
  
  public byte[] getAccountData()
  {
    return this.accountData;
  }
  
  public int getAccountFlag()
  {
    return this.accountFlag;
  }
  
  public long getAccountFlag2()
  {
    return this.accountFlag2;
  }
  
  public List<mobileqq_mp.ButtonInfo> getButtonInfo()
  {
    Object localObject = this.menuButtonResp;
    if (localObject != null) {
      return ((mobileqq_mp.GetPublicAccountMenuResponse)localObject).button_info.get();
    }
    if (this.protocol839Data != null) {
      localObject = new OACProfilePb.ProfileDataRsp();
    }
    try
    {
      ((OACProfilePb.ProfileDataRsp)localObject).mergeFrom(this.protocol839Data);
      this.menuButtonResp = ((OACProfilePb.ProfileDataRsp)localObject).menu_rsp;
      localObject = this.menuButtonResp.button_info.get();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
    return null;
  }
  
  public long getCertifiedGrade()
  {
    return this.certifiedGrade;
  }
  
  public String getDisplayNumber()
  {
    return this.displayNumber;
  }
  
  public Entity getEntity()
  {
    return this;
  }
  
  public int getFollowType()
  {
    return this.followType;
  }
  
  public long getId()
  {
    return super.getId();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getReportAccountType(AppInterface paramAppInterface, String paramString)
  {
    return getReportAccountType(paramAppInterface, paramString, null);
  }
  
  public int getShowFlag()
  {
    return this.showFlag;
  }
  
  public int getShowMsgFlag()
  {
    return this.showFlag;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public IPublicAccountDetail init(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF);
    this.uin = localStringBuilder.toString();
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountFlag2 = paramGetPublicAccountDetailInfoResponse.account_flag2.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.configBackgroundColor = paramGetPublicAccountDetailInfoResponse.config_background_color.get();
    this.configBackgroundImg = paramGetPublicAccountDetailInfoResponse.config_background_img.get();
    this.newGroupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
    this.certifiedDescription = paramGetPublicAccountDetailInfoResponse.certified_description.get();
    if (paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    if (this.unifiedDesrpition != null)
    {
      initShowMsgFlag_v5_9();
      initLbsItem_v5_9();
    }
    else
    {
      initShowMsgFlag(paramGetPublicAccountDetailInfoResponse);
      initLbsItem(paramGetPublicAccountDetailInfoResponse);
    }
    this.protocolVersion = 0;
    return this;
  }
  
  void initLbsItem(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    if ((paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) && (!paramGetPublicAccountDetailInfoResponse.config_group_info_new.isEmpty()))
    {
      paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if ((paramGetPublicAccountDetailInfoResponse != null) && (paramGetPublicAccountDetailInfoResponse.size() > 0))
      {
        paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
        int i = 0;
        do
        {
          j = i;
          if (!paramGetPublicAccountDetailInfoResponse.hasNext()) {
            break;
          }
          Object localObject = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          j = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
          {
            j = i;
            if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty())
            {
              localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
              do
              {
                j = i;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
                j = i;
                if (localConfigInfo.type.has())
                {
                  j = i;
                  if (localConfigInfo.type.get() == 2)
                  {
                    j = i;
                    if (localConfigInfo.state_id.has())
                    {
                      j = i;
                      if (localConfigInfo.state_id.get() == 3)
                      {
                        this.isSyncLbs = true;
                        if (localConfigInfo.state.has())
                        {
                          i = localConfigInfo.state.get();
                          if (i != 0)
                          {
                            if (i != 1)
                            {
                              if (i != 2)
                              {
                                if (QLog.isColorLevel())
                                {
                                  StringBuilder localStringBuilder = new StringBuilder();
                                  localStringBuilder.append("Error Eqq lbs state value: ");
                                  localStringBuilder.append(localConfigInfo.state.get());
                                  QLog.e("EqqDetail", 2, localStringBuilder.toString());
                                }
                              }
                              else
                              {
                                this.isSyncLbsSelected = true;
                                this.isAgreeSyncLbs = false;
                              }
                            }
                            else
                            {
                              this.isSyncLbsSelected = true;
                              this.isAgreeSyncLbs = true;
                            }
                          }
                          else
                          {
                            this.isSyncLbsSelected = false;
                            this.isAgreeSyncLbs = false;
                          }
                        }
                        j = 1;
                      }
                    }
                  }
                }
                i = j;
              } while (j == 0);
            }
          }
          i = j;
        } while (j == 0);
        break label338;
      }
    }
    int j = 0;
    label338:
    if (j == 0) {
      this.isSyncLbs = false;
    }
  }
  
  void initLbsItem_v5_9()
  {
    Object localObject1 = this.paConfigAttrs;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j;
    do
    {
      do
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IPublicAccountConfigAttr)((Iterator)localObject1).next();
      } while ((((IPublicAccountConfigAttr)localObject2).getType() == 1) || (((IPublicAccountConfigAttr)localObject2).getConfigs() == null));
      Object localObject2 = ((IPublicAccountConfigAttr)localObject2).getConfigs().iterator();
      do
      {
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject2).next();
        j = i;
        if (localPaConfigInfo.a == 2)
        {
          j = i;
          if (localPaConfigInfo.g == 3)
          {
            this.isSyncLbs = true;
            i = localPaConfigInfo.f;
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Error Eqq lbs state value: ");
                    localStringBuilder.append(localPaConfigInfo.f);
                    QLog.e("EqqDetail", 2, localStringBuilder.toString());
                  }
                }
                else
                {
                  this.isSyncLbsSelected = true;
                  this.isAgreeSyncLbs = false;
                }
              }
              else
              {
                this.isSyncLbsSelected = true;
                this.isAgreeSyncLbs = true;
              }
            }
            else
            {
              this.isSyncLbsSelected = false;
              this.isAgreeSyncLbs = false;
            }
            j = 1;
          }
        }
        i = j;
      } while (j == 0);
      i = j;
    } while (j == 0);
    if (j == 0) {
      this.isSyncLbs = false;
    }
  }
  
  void initShowMsgFlag(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info.get());
    }
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info_new.get());
    }
  }
  
  void initShowMsgFlag_v5_9()
  {
    Object localObject1 = this.paConfigAttrs;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j;
    do
    {
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IPublicAccountConfigAttr)((Iterator)localObject1).next();
      } while ((((IPublicAccountConfigAttr)localObject2).getType() == 1) || (((IPublicAccountConfigAttr)localObject2).getConfigs() == null));
      Object localObject2 = ((IPublicAccountConfigAttr)localObject2).getConfigs().iterator();
      IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo;
      do
      {
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject2).next();
      } while (localPaConfigInfo.g != 5);
      if (localPaConfigInfo.f == 1) {
        i = 1;
      } else {
        i = 0;
      }
      this.mShowMsgFlag = i;
      j = 1;
      i = j;
    } while (j == 0);
  }
  
  public boolean isAgreeSyncLbs()
  {
    return this.isAgreeSyncLbs;
  }
  
  public boolean isRecvMsg()
  {
    return this.isRecvMsg;
  }
  
  public boolean isRecvPush()
  {
    return this.isRecvPush;
  }
  
  public boolean isShowFollowButton()
  {
    return this.isShowFollowButton;
  }
  
  public boolean isSyncLbs()
  {
    return this.isSyncLbs;
  }
  
  public boolean isSyncLbsSelected()
  {
    return this.isSyncLbsSelected;
  }
  
  public void parser()
  {
    Object localObject = this.unifiedDesrpition;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.certifiedDescription = ((JSONObject)localObject).optString("certified_description");
      this.configBackgroundColor = ((JSONObject)localObject).optString("background_color");
      this.certifiedEnterprise = ((JSONObject)localObject).optString("certified_enterprise");
      this.certifiedWeixin = ((JSONObject)localObject).optString("certified_weixin");
      this.paConfigAttrs = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).parser(((JSONObject)localObject).optJSONArray("config_arr"));
      this.customConfigAttrs = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).parser(((JSONObject)localObject).optJSONArray("custom_arr"));
      this.fullscreenConfigAttrs = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).parser(((JSONObject)localObject).optJSONArray("fullscreen_arr"));
      this.cardStyle = ((JSONObject)localObject).optInt("card_style");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void parserMsgFlag(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      int j;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = (mobileqq_mp.ConfigGroupInfo)paramList.next();
        j = i;
        if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
        {
          localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
          mobileqq_mp.ConfigInfo localConfigInfo;
          do
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
          } while (localConfigInfo.state_id.get() != 5);
          if (localConfigInfo.state.get() == 1) {
            i = 1;
          } else {
            i = 0;
          }
          this.mShowMsgFlag = i;
          j = 1;
        }
        i = j;
      } while (j == 0);
    }
  }
  
  public void setFollowType(int paramInt)
  {
    this.followType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl
 * JD-Core Version:    0.7.0.1
 */