package com.tencent.biz.qqstory.model.item;

import ajjj;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UsrIcon;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.WatcherExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import sfp;
import sqg;
import sqs;
import srk;
import sxk;
import uls;
import urk;
import vlk;

public class QQUserUIItem
  extends BaseUIItem
  implements sfp, srk
{
  public static final int RELATION_TYPE_FOLLOWER = 1;
  public static final int RELATION_TYPE_QQ_FRIEND = 0;
  public static final int RELATION_TYPE_TROOP = 2;
  public static final String USERICON_JUMP_PREFIX = "https://story.now.qq.com/mobile/pages/medal.html?_bid=2473&_wv=1031";
  public static final String USERICON_PREFIX = "http://pub.idqqimg.com/pc/misc/qqstory_icon/";
  public String backgroundUrl;
  public int fansCount = -1;
  public int fansCountExtra = -1;
  public int followCount = -1;
  public int gradeSpeed = -2147483648;
  public long groupIdInGroup = -1L;
  public int hasLike = -1;
  public String headUrl;
  private String iconJumpUrl;
  private String iconUrl;
  public long iconUrlCacheTime = -1L;
  public int isSubscribe = -1;
  public boolean isVip;
  public int mComparePartInt;
  public String mCompareSpell;
  public int medalLevel = -2147483648;
  public String nickName;
  public String nickPostfix;
  public String qq;
  public int relationType = -1;
  public String remark;
  public int shareGroupCount = -1;
  public String signature;
  public int sourceTagType = -2147483648;
  public String symbolUrl;
  public String uid;
  public int videoCount = -1;
  public String wsScahema;
  
  public QQUserUIItem() {}
  
  public QQUserUIItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    this.uid = paramOfficialRecommendEntry.bigvUserUnionId;
    this.nickName = paramOfficialRecommendEntry.bigvUserNickName;
    this.headUrl = paramOfficialRecommendEntry.bigvUserHeadUrl;
    this.remark = paramOfficialRecommendEntry.bigvUserRemark;
    this.isVip = paramOfficialRecommendEntry.bigvUserIsVip;
    this.symbolUrl = paramOfficialRecommendEntry.bigvUserSymbolUrl;
  }
  
  public QQUserUIItem(UserEntry paramUserEntry)
  {
    this.uid = paramUserEntry.unionId;
    this.qq = paramUserEntry.qq;
    this.nickName = paramUserEntry.nickName;
    this.headUrl = paramUserEntry.headUrl;
    this.remark = paramUserEntry.remark;
    this.nickPostfix = paramUserEntry.nickPostfix;
    this.isVip = paramUserEntry.isVip;
    this.symbolUrl = paramUserEntry.symbolUrl;
    this.isSubscribe = paramUserEntry.isSubscribe;
    this.relationType = paramUserEntry.relationType;
    this.fansCount = paramUserEntry.fansCount;
    this.fansCountExtra = paramUserEntry.fansCountExtra;
    this.followCount = paramUserEntry.followCount;
    this.videoCount = paramUserEntry.videoCount;
    this.shareGroupCount = paramUserEntry.shareGroupCount;
    this.groupIdInGroup = paramUserEntry.groupIdInGroup;
    this.iconUrl = paramUserEntry.iconUrl;
    this.iconJumpUrl = paramUserEntry.iconJumpUrl;
    this.iconUrlCacheTime = paramUserEntry.dbCacheTime;
    this.wsScahema = paramUserEntry.wsSchema;
    this.medalLevel = paramUserEntry.medalLevel;
    this.gradeSpeed = paramUserEntry.gradeSpeed;
    this.sourceTagType = paramUserEntry.sourceTagType;
  }
  
  public static boolean isNotDovUser(String paramString)
  {
    boolean bool2 = false;
    try
    {
      long l = Long.parseLong(paramString);
      boolean bool1 = bool2;
      if (l > 0L)
      {
        bool1 = bool2;
        if (l < 10000L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramString)
    {
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public UserEntry convert2UserEntry()
  {
    UserEntry localUserEntry = new UserEntry();
    localUserEntry.unionId = this.uid;
    localUserEntry.qq = this.qq;
    localUserEntry.nickName = this.nickName;
    localUserEntry.headUrl = this.headUrl;
    localUserEntry.remark = this.remark;
    localUserEntry.nickPostfix = this.nickPostfix;
    localUserEntry.isVip = this.isVip;
    localUserEntry.symbolUrl = this.symbolUrl;
    localUserEntry.relationType = this.relationType;
    localUserEntry.isSubscribe = this.isSubscribe;
    localUserEntry.fansCount = this.fansCount;
    localUserEntry.fansCountExtra = this.fansCountExtra;
    localUserEntry.groupIdInGroup = this.groupIdInGroup;
    localUserEntry.followCount = this.followCount;
    localUserEntry.videoCount = this.videoCount;
    localUserEntry.shareGroupCount = this.shareGroupCount;
    localUserEntry.iconUrl = this.iconUrl;
    localUserEntry.iconJumpUrl = this.iconJumpUrl;
    localUserEntry.dbCacheTime = this.iconUrlCacheTime;
    localUserEntry.wsSchema = this.wsScahema;
    localUserEntry.medalLevel = this.medalLevel;
    localUserEntry.gradeSpeed = this.gradeSpeed;
    localUserEntry.sourceTagType = this.sourceTagType;
    return localUserEntry;
  }
  
  public void convertFrom(qqstory_struct.UserInfo paramUserInfo)
  {
    int i = 1;
    this.uid = paramUserInfo.union_id.get().toStringUtf8();
    this.qq = String.valueOf(paramUserInfo.uid.get());
    ((sqs)sqg.a(2)).a(this.uid, this.qq);
    this.nickName = paramUserInfo.nick.get().toStringUtf8();
    this.headUrl = paramUserInfo.head_url.get().toStringUtf8();
    boolean bool;
    if (paramUserInfo.is_vip.get() == 1)
    {
      bool = true;
      this.isVip = bool;
      this.symbolUrl = paramUserInfo.symbol.get().toStringUtf8();
      if (paramUserInfo.remark.has()) {
        this.remark = paramUserInfo.remark.get().toStringUtf8();
      }
      if (paramUserInfo.nick_postfix.has()) {
        this.nickPostfix = paramUserInfo.nick_postfix.get().toStringUtf8();
      }
      if (paramUserInfo.fans_count.has()) {
        this.fansCount = paramUserInfo.fans_count.get();
      }
      if (paramUserInfo.subscribe_count.has()) {
        this.followCount = paramUserInfo.subscribe_count.get();
      }
      if (paramUserInfo.fans_incr_count.has()) {
        this.fansCountExtra = paramUserInfo.fans_incr_count.get();
      }
      if (paramUserInfo.signature.has()) {
        this.signature = paramUserInfo.signature.get().toStringUtf8();
      }
      if (paramUserInfo.background_url.has()) {
        this.backgroundUrl = paramUserInfo.background_url.get().toStringUtf8();
      }
      if (paramUserInfo.watcher.has()) {
        this.hasLike = paramUserInfo.watcher.has_like.get();
      }
      if (paramUserInfo.is_subscribe.has())
      {
        if (paramUserInfo.is_subscribe.get() != 1) {
          break label603;
        }
        label312:
        this.isSubscribe = i;
      }
      if (paramUserInfo.friend_type.has()) {
        this.relationType = paramUserInfo.friend_type.get();
      }
      if (paramUserInfo.gid_in_group.has()) {
        this.groupIdInGroup = paramUserInfo.gid_in_group.get();
      }
      if (paramUserInfo.usr_icon_list.has())
      {
        this.iconUrlCacheTime = System.currentTimeMillis();
        qqstory_struct.UsrIcon localUsrIcon = (qqstory_struct.UsrIcon)paramUserInfo.usr_icon_list.get(0);
        this.iconUrl = localUsrIcon.icon_postfix.get().toStringUtf8();
        this.iconJumpUrl = localUsrIcon.jmp_postfix.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.iconUrl)) {
          this.iconUrl = ("http://pub.idqqimg.com/pc/misc/qqstory_icon/" + this.iconUrl);
        }
        if (!TextUtils.isEmpty(this.iconJumpUrl)) {
          this.iconJumpUrl = ("https://story.now.qq.com/mobile/pages/medal.html?_bid=2473&_wv=1031" + this.iconJumpUrl);
        }
      }
      if (paramUserInfo.ws_schema.has()) {
        this.wsScahema = paramUserInfo.ws_schema.get().toStringUtf8();
      }
      if (paramUserInfo.medal_level.has()) {
        this.medalLevel = paramUserInfo.medal_level.get();
      }
      if (paramUserInfo.grade_speed.has()) {
        this.gradeSpeed = paramUserInfo.grade_speed.get();
      }
      if (!paramUserInfo.video_source_tag_type.has()) {
        break label608;
      }
    }
    label603:
    label608:
    for (this.sourceTagType = paramUserInfo.video_source_tag_type.get();; this.sourceTagType = 0)
    {
      if (QLog.isColorLevel()) {
        urk.a("UserManager", "convert %s", this.uid);
      }
      return;
      bool = false;
      break;
      i = 0;
      break label312;
    }
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (QQUserUIItem)paramObject;
      this.uid = paramObject.uid;
      if (!TextUtils.isEmpty(paramObject.qq)) {
        this.qq = paramObject.qq;
      }
      if (!TextUtils.isEmpty(paramObject.nickName)) {
        this.nickName = paramObject.nickName;
      }
      if (!TextUtils.isEmpty(paramObject.headUrl))
      {
        if ((isMe()) && (!TextUtils.isEmpty(this.headUrl)) && (!TextUtils.equals(this.headUrl, paramObject.headUrl))) {
          urk.b("UserManager", "urlchange: %s -> %s  hashCode = %d -> %d %s", new Object[] { this.headUrl, paramObject.headUrl, Integer.valueOf(hashCode()), Integer.valueOf(paramObject.hashCode()), vlk.a(8) });
        }
        this.headUrl = paramObject.headUrl;
      }
      if (paramObject.remark != null) {
        this.remark = paramObject.remark;
      }
      if (!TextUtils.isEmpty(paramObject.nickPostfix)) {
        this.nickPostfix = paramObject.nickPostfix;
      }
      if (paramObject.relationType != -1) {
        this.relationType = paramObject.relationType;
      }
      if ((this.isVip) || (paramObject.isVip)) {
        this.isVip = true;
      }
      if (!TextUtils.isEmpty(paramObject.symbolUrl)) {
        this.symbolUrl = paramObject.symbolUrl;
      }
      if (paramObject.fansCount != -1) {
        this.fansCount = paramObject.fansCount;
      }
      if (paramObject.fansCountExtra != -1) {
        this.fansCountExtra = paramObject.fansCountExtra;
      }
      if (paramObject.followCount != -1) {
        this.followCount = paramObject.followCount;
      }
      if (paramObject.signature != null) {
        this.signature = paramObject.signature;
      }
      if (!TextUtils.isEmpty(paramObject.backgroundUrl)) {
        this.backgroundUrl = paramObject.backgroundUrl;
      }
      if (paramObject.hasLike != -1) {
        this.hasLike = paramObject.hasLike;
      }
      if (paramObject.isSubscribe != -1) {
        this.isSubscribe = paramObject.isSubscribe;
      }
      if (paramObject.groupIdInGroup != -1L) {
        this.groupIdInGroup = paramObject.groupIdInGroup;
      }
      if (paramObject.videoCount != -1) {
        this.videoCount = paramObject.videoCount;
      }
      if (paramObject.shareGroupCount != -1) {
        this.shareGroupCount = paramObject.shareGroupCount;
      }
      if (paramObject.iconUrl != null) {
        this.iconUrl = paramObject.iconUrl;
      }
      if (paramObject.iconJumpUrl != null) {
        this.iconJumpUrl = paramObject.iconJumpUrl;
      }
      if (paramObject.iconUrlCacheTime != -1L) {
        this.iconUrlCacheTime = paramObject.iconUrlCacheTime;
      }
      if (!TextUtils.isEmpty(paramObject.wsScahema)) {
        this.wsScahema = paramObject.wsScahema;
      }
      if (paramObject.medalLevel != -2147483648) {
        this.medalLevel = paramObject.medalLevel;
      }
      if (paramObject.gradeSpeed != -2147483648) {
        this.gradeSpeed = paramObject.gradeSpeed;
      }
    } while (paramObject.sourceTagType == -2147483648);
    this.sourceTagType = paramObject.sourceTagType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (QQUserUIItem)paramObject;
    return getUnionId().equals(paramObject.getUnionId());
  }
  
  public String getDisplayName()
  {
    if (TextUtils.isEmpty(this.remark)) {
      return this.nickName;
    }
    return this.remark;
  }
  
  public String getIconJumpUrlKey()
  {
    if (TextUtils.isEmpty(this.iconJumpUrl)) {
      return "";
    }
    return this.iconJumpUrl.substring("https://story.now.qq.com/mobile/pages/medal.html?_bid=2473&_wv=1031".length());
  }
  
  public String getName()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.nickName)) {
      return this.nickName;
    }
    return this.qq;
  }
  
  public int getRelationType()
  {
    return this.relationType;
  }
  
  public String getUnionId()
  {
    return this.uid;
  }
  
  public String getUserIconJumpURL()
  {
    return this.iconJumpUrl;
  }
  
  public String getUserIconUrl()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQUserUIItem", 2, "cache time between :" + String.valueOf(l - this.iconUrlCacheTime));
    }
    if ((this.iconUrlCacheTime == -1L) || (l - this.iconUrlCacheTime > 3600000L))
    {
      new sxk();
      sxk.a(this.uid);
    }
    return this.iconUrl;
  }
  
  public String getUserIconUrlKey()
  {
    if (TextUtils.isEmpty(this.iconUrl)) {
      return "";
    }
    return this.iconUrl.substring("http://pub.idqqimg.com/pc/misc/qqstory_icon/".length());
  }
  
  public int hashCode()
  {
    return this.uid.hashCode();
  }
  
  public boolean isAvailable()
  {
    return (!TextUtils.isEmpty(this.uid)) && (!TextUtils.isEmpty(this.nickName));
  }
  
  public boolean isFriend()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (isMe()) {}
    do
    {
      return bool2;
      if (this.relationType == 0) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (bool1);
    QQStoryContext.a();
    return ((ajjj)QQStoryContext.a().getManager(51)).b(this.qq);
  }
  
  public boolean isMe()
  {
    return QQStoryContext.a().a(this.uid);
  }
  
  public boolean isNotDovUser()
  {
    return isNotDovUser(this.qq);
  }
  
  public boolean isSubscribe()
  {
    return this.isSubscribe == 1;
  }
  
  public boolean isSubscribeButNoFriend()
  {
    return (this.isSubscribe == 1) && (!isFriend());
  }
  
  public boolean isVip()
  {
    return this.isVip;
  }
  
  public boolean isVipButNoFriend()
  {
    return (this.isVip) && (!isFriend());
  }
  
  public void setUnionId(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setUserIcon(String paramString1, String paramString2)
  {
    this.iconUrl = paramString1;
    this.iconJumpUrl = paramString2;
  }
  
  public qqstory_struct.UserInfo toPBItem()
  {
    qqstory_struct.UserInfo localUserInfo = new qqstory_struct.UserInfo();
    localUserInfo.head_url.set(ByteStringMicro.copyFromUtf8(this.headUrl));
    try
    {
      long l = Long.parseLong(this.qq);
      localUserInfo.uid.set(l);
      return localUserInfo;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return localUserInfo;
  }
  
  public String toString()
  {
    return uls.a(new Object[] { "QQUserUIItem{nickName=", this.nickName, ", uid=", this.uid, ", isVip=", Boolean.valueOf(this.isVip), ",qq=", this.qq, ",isSubscribe=", Integer.valueOf(this.isSubscribe), ", headUrl=", this.headUrl, ", sourceTagType=", Integer.valueOf(this.sourceTagType) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.QQUserUIItem
 * JD-Core Version:    0.7.0.1
 */