package com.tencent.biz.qqstory.pgc.model;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;

public class UserInfo
  implements Serializable
{
  public static final int TYPE_PGC_ALBUM = 2;
  public static final int TYPE_PGC_ERROR = -1;
  public static final int TYPE_PGC_MEDIA = 0;
  public static final int TYPE_PGC_URL = 3;
  public static final int TYPE_PGC_V = 1;
  public static final int TYPE_SELF = -5;
  public static final int TYPE_STRANGER = -6;
  public static final int TYPE_UGC_HOT_TOPIC = 5;
  public static final int TYPE_UGC_NOW = 4;
  public static final long serialVersionUID = 1L;
  public String authTypeIcon;
  public String authTypeName;
  public String desc;
  public long fansGroupUin;
  public String headUrl;
  public boolean isSubscribe;
  public String logoURL;
  public String nick;
  public String remark;
  public long subscribeCount;
  public int themeColor;
  public long tribeId;
  public int type;
  public String uid;
  public String unionId;
  public long viewCount;
  
  public static UserInfo convertFrom(qqstory_pgc.UserInfo paramUserInfo)
  {
    long l2 = 0L;
    Object localObject2 = null;
    if ((paramUserInfo == null) || (!paramUserInfo.has())) {
      return null;
    }
    UserInfo localUserInfo = new UserInfo();
    int i;
    label89:
    label118:
    boolean bool;
    label147:
    label173:
    label202:
    label231:
    long l1;
    if (paramUserInfo.type.has())
    {
      i = paramUserInfo.type.get();
      localUserInfo.type = i;
      localUserInfo.uid = paramUserInfo.union_id.get().toStringUtf8();
      if (!paramUserInfo.nick.has()) {
        break label473;
      }
      localObject1 = paramUserInfo.nick.get().toStringUtf8();
      localUserInfo.nick = ((String)localObject1);
      if (!paramUserInfo.head_url.has()) {
        break label479;
      }
      localObject1 = paramUserInfo.head_url.get().toStringUtf8();
      localUserInfo.headUrl = ((String)localObject1);
      if (!paramUserInfo.remark.has()) {
        break label485;
      }
      localObject1 = paramUserInfo.remark.get().toStringUtf8();
      localUserInfo.remark = ((String)localObject1);
      if (!paramUserInfo.is_subscribe.has()) {
        break label491;
      }
      bool = paramUserInfo.is_subscribe.get();
      localUserInfo.isSubscribe = bool;
      if (!paramUserInfo.desc.has()) {
        break label497;
      }
      localObject1 = paramUserInfo.desc.get().toStringUtf8();
      localUserInfo.desc = ((String)localObject1);
      if (!paramUserInfo.logo_url.has()) {
        break label503;
      }
      localObject1 = paramUserInfo.logo_url.get().toStringUtf8();
      localUserInfo.logoURL = ((String)localObject1);
      if (!paramUserInfo.view_count.has()) {
        break label509;
      }
      l1 = paramUserInfo.view_count.get();
      label256:
      localUserInfo.viewCount = l1;
      if (!paramUserInfo.fans_group_uin.has()) {
        break label514;
      }
      l1 = paramUserInfo.fans_group_uin.get();
      label280:
      localUserInfo.fansGroupUin = l1;
      if (!paramUserInfo.tribe_id.has()) {
        break label519;
      }
      l1 = paramUserInfo.tribe_id.get();
      label304:
      localUserInfo.tribeId = l1;
      if (!paramUserInfo.theme_color.has()) {
        break label524;
      }
      i = paramUserInfo.theme_color.get();
      label328:
      localUserInfo.themeColor = i;
      localUserInfo.themeColor |= 0xFF000000;
      l1 = l2;
      if (paramUserInfo.subscribe_count.has()) {
        l1 = paramUserInfo.subscribe_count.get();
      }
      localUserInfo.subscribeCount = l1;
      if (!paramUserInfo.union_id.has()) {
        break label533;
      }
      localObject1 = paramUserInfo.union_id.get().toStringUtf8();
      label396:
      localUserInfo.unionId = ((String)localObject1);
      if (!paramUserInfo.auth_type_name.has()) {
        break label539;
      }
    }
    label514:
    label519:
    label524:
    label533:
    label539:
    for (Object localObject1 = paramUserInfo.auth_type_name.get().toStringUtf8();; localObject1 = null)
    {
      localUserInfo.authTypeName = ((String)localObject1);
      localObject1 = localObject2;
      if (paramUserInfo.auth_type_icon.has()) {
        localObject1 = paramUserInfo.auth_type_icon.get().toStringUtf8();
      }
      localUserInfo.authTypeIcon = ((String)localObject1);
      return localUserInfo;
      i = -1;
      break;
      label473:
      localObject1 = null;
      break label89;
      label479:
      localObject1 = null;
      break label118;
      label485:
      localObject1 = null;
      break label147;
      label491:
      bool = false;
      break label173;
      label497:
      localObject1 = null;
      break label202;
      label503:
      localObject1 = null;
      break label231;
      label509:
      l1 = 0L;
      break label256;
      l1 = 0L;
      break label280;
      l1 = 0L;
      break label304;
      i = Color.parseColor("#f8a900");
      break label328;
      localObject1 = null;
      break label396;
    }
  }
  
  public boolean checkData()
  {
    if (TextUtils.isEmpty(this.headUrl)) {}
    while ((!isNoNickUser()) && (TextUtils.isEmpty(this.nick))) {
      return false;
    }
    switch (this.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof UserInfo))
    {
      paramObject = (UserInfo)paramObject;
      if (this.type != paramObject.type) {}
      while (((this.unionId != null) && (!this.unionId.equals(paramObject.unionId))) || ((this.unionId == null) && (paramObject.unionId != null))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isNoNickUser()
  {
    switch (this.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "UserInfo{type=" + this.type + ", nick='" + this.nick + '\'' + ", headUrl='" + this.headUrl + '\'' + ", remark='" + this.remark + '\'' + ", isSubscribe=" + this.isSubscribe + ", desc='" + this.desc + '\'' + ", logoURL='" + this.logoURL + '\'' + ", viewCount=" + this.viewCount + ", fansGroupUin=" + this.fansGroupUin + ", tribeId=" + this.tribeId + ", themeColor=" + this.themeColor + ", subscribeCount=" + this.subscribeCount + ", unionId='" + this.unionId + '\'' + ", authTypeName='" + this.authTypeName + '\'' + ", authTypeIcon='" + this.authTypeIcon + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.pgc.model.UserInfo
 * JD-Core Version:    0.7.0.1
 */