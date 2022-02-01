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
    Object localObject2 = null;
    if (paramUserInfo != null)
    {
      if (!paramUserInfo.has()) {
        return null;
      }
      UserInfo localUserInfo = new UserInfo();
      int i;
      if (paramUserInfo.type.has()) {
        i = paramUserInfo.type.get();
      } else {
        i = -1;
      }
      localUserInfo.type = i;
      localUserInfo.uid = paramUserInfo.union_id.get().toStringUtf8();
      if (paramUserInfo.nick.has()) {
        localObject1 = paramUserInfo.nick.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.nick = ((String)localObject1);
      if (paramUserInfo.head_url.has()) {
        localObject1 = paramUserInfo.head_url.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.headUrl = ((String)localObject1);
      if (paramUserInfo.remark.has()) {
        localObject1 = paramUserInfo.remark.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.remark = ((String)localObject1);
      if (paramUserInfo.is_subscribe.has()) {
        bool = paramUserInfo.is_subscribe.get();
      } else {
        bool = false;
      }
      localUserInfo.isSubscribe = bool;
      if (paramUserInfo.desc.has()) {
        localObject1 = paramUserInfo.desc.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.desc = ((String)localObject1);
      if (paramUserInfo.logo_url.has()) {
        localObject1 = paramUserInfo.logo_url.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.logoURL = ((String)localObject1);
      boolean bool = paramUserInfo.view_count.has();
      long l2 = 0L;
      if (bool) {
        l1 = paramUserInfo.view_count.get();
      } else {
        l1 = 0L;
      }
      localUserInfo.viewCount = l1;
      if (paramUserInfo.fans_group_uin.has()) {
        l1 = paramUserInfo.fans_group_uin.get();
      } else {
        l1 = 0L;
      }
      localUserInfo.fansGroupUin = l1;
      if (paramUserInfo.tribe_id.has()) {
        l1 = paramUserInfo.tribe_id.get();
      } else {
        l1 = 0L;
      }
      localUserInfo.tribeId = l1;
      if (paramUserInfo.theme_color.has()) {
        i = paramUserInfo.theme_color.get();
      } else {
        i = Color.parseColor("#f8a900");
      }
      localUserInfo.themeColor = i;
      localUserInfo.themeColor |= 0xFF000000;
      long l1 = l2;
      if (paramUserInfo.subscribe_count.has()) {
        l1 = paramUserInfo.subscribe_count.get();
      }
      localUserInfo.subscribeCount = l1;
      if (paramUserInfo.union_id.has()) {
        localObject1 = paramUserInfo.union_id.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.unionId = ((String)localObject1);
      if (paramUserInfo.auth_type_name.has()) {
        localObject1 = paramUserInfo.auth_type_name.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localUserInfo.authTypeName = ((String)localObject1);
      Object localObject1 = localObject2;
      if (paramUserInfo.auth_type_icon.has()) {
        localObject1 = paramUserInfo.auth_type_icon.get().toStringUtf8();
      }
      localUserInfo.authTypeIcon = ((String)localObject1);
      return localUserInfo;
    }
    return null;
  }
  
  public boolean checkData()
  {
    if (TextUtils.isEmpty(this.headUrl)) {
      return false;
    }
    if ((!isNoNickUser()) && (TextUtils.isEmpty(this.nick))) {
      return false;
    }
    int i = this.type;
    return (i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof UserInfo))
    {
      paramObject = (UserInfo)paramObject;
      if (this.type != paramObject.type) {
        return false;
      }
      String str = this.unionId;
      if ((str != null) && (!str.equals(paramObject.unionId))) {
        return false;
      }
      if ((this.unionId == null) && (paramObject.unionId != null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isNoNickUser()
  {
    int i = this.type;
    return (i == 2) || (i == 3);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfo{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", nick='");
    localStringBuilder.append(this.nick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", remark='");
    localStringBuilder.append(this.remark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSubscribe=");
    localStringBuilder.append(this.isSubscribe);
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoURL='");
    localStringBuilder.append(this.logoURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", viewCount=");
    localStringBuilder.append(this.viewCount);
    localStringBuilder.append(", fansGroupUin=");
    localStringBuilder.append(this.fansGroupUin);
    localStringBuilder.append(", tribeId=");
    localStringBuilder.append(this.tribeId);
    localStringBuilder.append(", themeColor=");
    localStringBuilder.append(this.themeColor);
    localStringBuilder.append(", subscribeCount=");
    localStringBuilder.append(this.subscribeCount);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authTypeName='");
    localStringBuilder.append(this.authTypeName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authTypeIcon='");
    localStringBuilder.append(this.authTypeIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.pgc.model.UserInfo
 * JD-Core Version:    0.7.0.1
 */