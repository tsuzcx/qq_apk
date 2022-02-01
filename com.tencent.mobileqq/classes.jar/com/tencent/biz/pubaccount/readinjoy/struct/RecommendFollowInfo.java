package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import qww;
import tencent.im.oidb.articlesummary.articlesummary.RecommendAccountInfo;
import tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo;

public class RecommendFollowInfo
  extends Entity
  implements Parcelable
{
  public static Parcelable.Creator<RecommendFollowInfo> CREATOR = new qww();
  public long algorithmId;
  public String className;
  public boolean hasReport;
  public String headUrl;
  public boolean isFollowed;
  public boolean isStar;
  public boolean isVip;
  public String nickName;
  public String recommendReason;
  public int strategyId;
  public int type;
  public long uin;
  
  public RecommendFollowInfo() {}
  
  public RecommendFollowInfo(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uin = paramLong;
    this.type = paramInt;
    this.recommendReason = paramString2;
    this.nickName = paramString1;
    this.headUrl = paramString3;
    this.isVip = paramBoolean1;
    this.isStar = paramBoolean2;
  }
  
  public static RecommendFollowInfo parseByPB(articlesummary.RecommendAccountInfo paramRecommendAccountInfo)
  {
    boolean bool2 = true;
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    if (paramRecommendAccountInfo.uint64_uin.has()) {
      localRecommendFollowInfo.uin = paramRecommendAccountInfo.uint64_uin.get();
    }
    if (paramRecommendAccountInfo.uint32_account_type.has()) {
      localRecommendFollowInfo.type = paramRecommendAccountInfo.uint32_account_type.get();
    }
    if (paramRecommendAccountInfo.bytes_recommend_reason.has()) {
      localRecommendFollowInfo.recommendReason = paramRecommendAccountInfo.bytes_recommend_reason.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_nick_name.has()) {
      localRecommendFollowInfo.nickName = paramRecommendAccountInfo.bytes_nick_name.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_head_img_url.has()) {
      localRecommendFollowInfo.headUrl = paramRecommendAccountInfo.bytes_head_img_url.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.uint32_is_vip.has())
    {
      if (paramRecommendAccountInfo.uint32_is_vip.get() == 1)
      {
        bool1 = true;
        localRecommendFollowInfo.isVip = bool1;
      }
    }
    else
    {
      if (paramRecommendAccountInfo.uint32_is_star.has())
      {
        if (paramRecommendAccountInfo.uint32_is_star.get() != 1) {
          break label281;
        }
        bool1 = true;
        label175:
        localRecommendFollowInfo.isStar = bool1;
      }
      if (paramRecommendAccountInfo.uint32_is_followed.has()) {
        if (paramRecommendAccountInfo.uint32_is_followed.get() != 1) {
          break label286;
        }
      }
    }
    label281:
    label286:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localRecommendFollowInfo.isFollowed = bool1;
      if (paramRecommendAccountInfo.uint64_algorithm_id.has()) {
        localRecommendFollowInfo.algorithmId = paramRecommendAccountInfo.uint64_algorithm_id.get();
      }
      if (paramRecommendAccountInfo.uint32_strategy_id.has()) {
        localRecommendFollowInfo.strategyId = paramRecommendAccountInfo.uint32_strategy_id.get();
      }
      if (paramRecommendAccountInfo.bytes_class.has()) {
        localRecommendFollowInfo.className = paramRecommendAccountInfo.bytes_class.get().toStringUtf8();
      }
      return localRecommendFollowInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label175;
    }
  }
  
  public static RecommendFollowInfo parseByPB(oidb_0xc2f.RecommendAccountInfo paramRecommendAccountInfo)
  {
    boolean bool2 = true;
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    if (paramRecommendAccountInfo.uint64_uin.has()) {
      localRecommendFollowInfo.uin = paramRecommendAccountInfo.uint64_uin.get();
    }
    if (paramRecommendAccountInfo.uint32_account_type.has()) {
      localRecommendFollowInfo.type = paramRecommendAccountInfo.uint32_account_type.get();
    }
    if (paramRecommendAccountInfo.bytes_nick_name.has()) {
      localRecommendFollowInfo.nickName = paramRecommendAccountInfo.bytes_nick_name.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_head_img_url.has()) {
      localRecommendFollowInfo.headUrl = paramRecommendAccountInfo.bytes_head_img_url.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.uint32_is_vip.has())
    {
      if (paramRecommendAccountInfo.uint32_is_vip.get() == 1)
      {
        bool1 = true;
        localRecommendFollowInfo.isVip = bool1;
      }
    }
    else if (paramRecommendAccountInfo.uint32_is_star.has()) {
      if (paramRecommendAccountInfo.uint32_is_star.get() != 1) {
        break label187;
      }
    }
    label187:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localRecommendFollowInfo.isStar = bool1;
      if (paramRecommendAccountInfo.bytes_recommend_reason.has()) {
        localRecommendFollowInfo.recommendReason = paramRecommendAccountInfo.bytes_recommend_reason.get().toStringUtf8();
      }
      return localRecommendFollowInfo;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public articlesummary.RecommendAccountInfo toPB()
  {
    int j = 1;
    articlesummary.RecommendAccountInfo localRecommendAccountInfo = new articlesummary.RecommendAccountInfo();
    localRecommendAccountInfo.uint64_uin.set(this.uin);
    localRecommendAccountInfo.uint32_account_type.set(this.type);
    if (!TextUtils.isEmpty(this.recommendReason)) {
      localRecommendAccountInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.recommendReason));
    }
    if (!TextUtils.isEmpty(this.nickName)) {
      localRecommendAccountInfo.bytes_nick_name.set(ByteStringMicro.copyFromUtf8(this.nickName));
    }
    if (!TextUtils.isEmpty(this.headUrl)) {
      localRecommendAccountInfo.bytes_head_img_url.set(ByteStringMicro.copyFromUtf8(this.headUrl));
    }
    PBUInt32Field localPBUInt32Field = localRecommendAccountInfo.uint32_is_vip;
    if (this.isVip)
    {
      i = 1;
      localPBUInt32Field.set(i);
      localPBUInt32Field = localRecommendAccountInfo.uint32_is_star;
      if (!this.isStar) {
        break label220;
      }
      i = 1;
      label140:
      localPBUInt32Field.set(i);
      localPBUInt32Field = localRecommendAccountInfo.uint32_is_followed;
      if (!this.isFollowed) {
        break label225;
      }
    }
    label220:
    label225:
    for (int i = j;; i = 0)
    {
      localPBUInt32Field.set(i);
      localRecommendAccountInfo.uint64_algorithm_id.set(this.algorithmId);
      localRecommendAccountInfo.uint32_strategy_id.set(this.strategyId);
      if (!TextUtils.isEmpty(this.className)) {
        localRecommendAccountInfo.bytes_class.set(ByteStringMicro.copyFromUtf8(this.className));
      }
      return localRecommendAccountInfo;
      i = 0;
      break;
      i = 0;
      break label140;
    }
  }
  
  public String toString()
  {
    return "RecommendFollowInfo{uin=" + this.uin + ", type=" + this.type + ", recommendReason='" + this.recommendReason + '\'' + ", nickName='" + this.nickName + '\'' + ", headUrl='" + this.headUrl + '\'' + ", isVip=" + this.isVip + ", isStar=" + this.isStar + ", algorithmID" + this.algorithmId + ", strategyId" + this.strategyId + ", isFollowed=" + this.isFollowed + ", className=" + this.className + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.recommendReason);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.headUrl);
    if (this.isVip)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.isStar) {
        break label114;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.algorithmId);
      paramParcel.writeInt(this.strategyId);
      if (!this.isFollowed) {
        break label119;
      }
    }
    label114:
    label119:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.className);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo
 * JD-Core Version:    0.7.0.1
 */