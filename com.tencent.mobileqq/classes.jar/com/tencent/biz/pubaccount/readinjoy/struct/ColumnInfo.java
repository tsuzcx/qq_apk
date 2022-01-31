package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awbv;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.NotNull;
import qkn;
import qtm;
import tencent.kandian.ugc.topic_info.TopicInfo;
import tencent.kandian.ugc.topic_info.TopicInfoExt;

public class ColumnInfo
  extends awbv
  implements Parcelable
{
  public static final Parcelable.Creator<ColumnInfo> CREATOR = new qkn();
  public static final int SOURCE_UGC = 5;
  public int columnID;
  public int commentCount;
  public String coverUrl = "";
  public String intro = "";
  public int source;
  public int subscribeCount;
  public String title = "";
  private long uid;
  public int videoCount;
  
  public ColumnInfo() {}
  
  public ColumnInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.columnID = paramInt;
    this.coverUrl = paramString1;
    this.title = paramString2;
    this.intro = paramString3;
  }
  
  public ColumnInfo(Parcel paramParcel)
  {
    this.columnID = paramParcel.readInt();
    this.coverUrl = paramParcel.readString();
    this.title = paramParcel.readString();
    this.intro = paramParcel.readString();
    this.source = paramParcel.readInt();
    this.uid = paramParcel.readLong();
    this.subscribeCount = paramParcel.readInt();
    this.commentCount = paramParcel.readInt();
    this.videoCount = paramParcel.readInt();
  }
  
  public ColumnInfo(qtm paramqtm)
  {
    String str;
    if (paramqtm.a != null)
    {
      str = paramqtm.a;
      this.coverUrl = str;
      if (paramqtm.b == null) {
        break label80;
      }
      str = paramqtm.b;
      label51:
      this.title = str;
      if (paramqtm.c == null) {
        break label86;
      }
    }
    label80:
    label86:
    for (paramqtm = paramqtm.c;; paramqtm = "")
    {
      this.intro = paramqtm;
      return;
      str = "";
      break;
      str = "";
      break label51;
    }
  }
  
  public ColumnInfo(topic_info.TopicInfo paramTopicInfo)
  {
    this.columnID = paramTopicInfo.id.get();
    if (paramTopicInfo.cover_img.has()) {
      this.coverUrl = paramTopicInfo.cover_img.get();
    }
    if (paramTopicInfo.title.has()) {
      this.title = paramTopicInfo.title.get();
    }
    if (paramTopicInfo.intro.has()) {
      this.intro = paramTopicInfo.intro.get();
    }
    this.source = paramTopicInfo.source.get();
    this.uid = paramTopicInfo.creator_uid.get();
    this.subscribeCount = paramTopicInfo.ext.subscribe_num.get();
    this.commentCount = paramTopicInfo.ext.comment_num.get();
    this.videoCount = paramTopicInfo.ext.content_count.get();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getUid()
  {
    return this.uid;
  }
  
  public topic_info.TopicInfo parseToTopicInfo()
  {
    topic_info.TopicInfo localTopicInfo = new topic_info.TopicInfo();
    localTopicInfo.id.set(this.columnID);
    PBStringField localPBStringField = localTopicInfo.cover_img;
    if (this.coverUrl != null)
    {
      str = this.coverUrl;
      localPBStringField.set(str);
      localPBStringField = localTopicInfo.title;
      if (this.title == null) {
        break label157;
      }
      str = this.title;
      label58:
      localPBStringField.set(str);
      localPBStringField = localTopicInfo.intro;
      if (this.intro == null) {
        break label163;
      }
    }
    label157:
    label163:
    for (String str = this.intro;; str = "")
    {
      localPBStringField.set(str);
      localTopicInfo.source.set(this.source);
      localTopicInfo.creator_uid.set(this.uid);
      localTopicInfo.ext.subscribe_num.set(this.subscribeCount);
      localTopicInfo.ext.comment_num.set(this.commentCount);
      localTopicInfo.ext.content_count.set(this.videoCount);
      return localTopicInfo;
      str = "";
      break;
      str = "";
      break label58;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "ColumnInfo{columnID='" + this.columnID + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", title='" + this.title + '\'' + ", intro='" + this.intro + '\'' + ", source='" + this.source + '\'' + ", uid='" + this.uid + '\'' + ", subscribeCount='" + this.subscribeCount + '\'' + ", commentCount='" + this.commentCount + '\'' + ", videoCount='" + this.videoCount + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.columnID);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.intro);
    paramParcel.writeInt(this.source);
    paramParcel.writeLong(this.uid);
    paramParcel.writeInt(this.subscribeCount);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeInt(this.videoCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */