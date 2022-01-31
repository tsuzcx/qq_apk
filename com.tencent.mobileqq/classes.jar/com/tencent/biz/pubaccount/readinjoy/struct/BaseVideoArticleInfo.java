package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import aukm;
import aulx;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.readinjoy.Readinjoy.ArticleSummary;
import localpb.readinjoy.Readinjoy.VideoData;
import qas;
import qea;
import quo;

public class BaseVideoArticleInfo
  extends aukm
  implements Parcelable, Cloneable, Comparable<BaseVideoArticleInfo>
{
  public static final Parcelable.Creator<BaseVideoArticleInfo> CREATOR = new qas();
  public static final String TAG = "VideoArticleInfo";
  public int adsJumpType;
  public String adsJumpUrl;
  public long algorithmID;
  public String articleContentUrl;
  public long articleID;
  @aulx
  public List<BaseVideoArticleInfo> articleList;
  public byte[] articleListBytes;
  @aulx
  public List<Readinjoy.ArticleSummary> articleListObj;
  public int articleStyle;
  public byte[] businessInfo;
  public int channelID;
  public int channelType;
  public int commentCount;
  public int feedsType;
  public boolean isUgc;
  @aulx
  public List<SimpleChannelInfo> labelList;
  public String pagePicUrl;
  public String pushContext;
  public String recommendReason;
  public long recommendSeq;
  public long recommendTime;
  public String rowkey;
  public int strategyID;
  public String subscribeID;
  public String subscribeIcon;
  public String subscribeName;
  public String summary;
  public long time;
  public String title;
  public int uptime;
  public int videoCount;
  @aulx
  public qea videoData;
  public byte[] videoDataBytes;
  @aulx
  public Readinjoy.VideoData videoDataObj;
  public int videoPlayCount;
  public String videoReportInfo;
  
  public BaseVideoArticleInfo() {}
  
  public BaseVideoArticleInfo(Parcel paramParcel)
  {
    this.articleID = paramParcel.readLong();
    this.rowkey = paramParcel.readString();
    boolean bool;
    int i;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.isUgc = bool;
      this.uptime = paramParcel.readInt();
      this.feedsType = paramParcel.readInt();
      this.videoCount = paramParcel.readInt();
      this.title = paramParcel.readString();
      this.summary = paramParcel.readString();
      this.pagePicUrl = paramParcel.readString();
      this.articleContentUrl = paramParcel.readString();
      this.time = paramParcel.readLong();
      this.subscribeName = paramParcel.readString();
      this.subscribeIcon = paramParcel.readString();
      this.subscribeID = paramParcel.readString();
      this.commentCount = paramParcel.readInt();
      this.recommendTime = paramParcel.readLong();
      this.recommendSeq = paramParcel.readLong();
      this.algorithmID = paramParcel.readLong();
      this.strategyID = paramParcel.readInt();
      this.recommendReason = paramParcel.readString();
      i = paramParcel.readInt();
      if (i > 0) {
        break label280;
      }
      this.videoDataBytes = null;
      label184:
      this.channelID = paramParcel.readInt();
      this.channelType = paramParcel.readInt();
      this.pushContext = paramParcel.readString();
      this.videoPlayCount = paramParcel.readInt();
      this.adsJumpUrl = paramParcel.readString();
      this.adsJumpType = paramParcel.readInt();
      this.videoReportInfo = paramParcel.readString();
      this.articleStyle = paramParcel.readInt();
      paramParcel.readByteArray(this.businessInfo);
      i = paramParcel.readInt();
      if (i > 0) {
        break label341;
      }
      this.articleListBytes = null;
    }
    for (;;)
    {
      for (;;)
      {
        postRead();
        return;
        bool = false;
        break;
        label280:
        this.videoDataBytes = new byte[i];
        paramParcel.readByteArray(this.videoDataBytes);
        Readinjoy.VideoData localVideoData = new Readinjoy.VideoData();
        try
        {
          localVideoData.mergeFrom(this.videoDataBytes);
          this.videoData = quo.a(localVideoData);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          this.videoData = null;
        }
      }
      break label184;
      label341:
      this.articleListBytes = new byte[i];
      paramParcel.readByteArray(this.articleListBytes);
    }
  }
  
  public BaseVideoArticleInfo clone()
  {
    try
    {
      BaseVideoArticleInfo localBaseVideoArticleInfo = (BaseVideoArticleInfo)super.clone();
      return localBaseVideoArticleInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoArticleInfo", 2, "ArticleInfo CloneNotSupportedException e= " + localCloneNotSupportedException);
      }
    }
    return null;
  }
  
  public int compareTo(@NonNull BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (this.time == paramBaseVideoArticleInfo.time) {
      return 0;
    }
    if (this.time < paramBaseVideoArticleInfo.time) {
      return -1;
    }
    return 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void postRead()
  {
    if ((this.videoDataBytes != null) && (this.videoDataBytes.length > 0)) {
      this.videoDataObj = new Readinjoy.VideoData();
    }
    try
    {
      this.videoDataObj.mergeFrom(this.videoDataBytes);
      if (this.videoDataObj != null) {
        this.videoData = quo.a(this.videoDataObj);
      }
      if ((this.articleListBytes != null) && (this.articleListBytes.length > 0))
      {
        CodedInputStreamMicro localCodedInputStreamMicro = CodedInputStreamMicro.newInstance(this.articleListBytes);
        PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(Readinjoy.ArticleSummary.class);
        try
        {
          while (!localCodedInputStreamMicro.isAtEnd())
          {
            localCodedInputStreamMicro.readTag();
            localPBRepeatMessageField.readFrom(localCodedInputStreamMicro);
          }
          this.articleList = new ArrayList();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.articleListObj = localPBRepeatMessageField.get();
          if (this.articleListObj == null) {
            return;
          }
        }
        int i = 0;
        while (i < this.articleListObj.size())
        {
          this.articleList.add(quo.a((Readinjoy.ArticleSummary)this.articleListObj.get(i)));
          i += 1;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        this.videoDataObj = null;
      }
    }
  }
  
  public void prewrite()
  {
    if (this.videoData != null)
    {
      this.videoDataObj = quo.a(this.videoData);
      if (this.videoDataObj != null) {
        this.videoDataBytes = this.videoDataObj.toByteArray();
      }
    }
    Object localObject1;
    Object localObject2;
    if (this.articleList != null)
    {
      this.articleListObj = new ArrayList();
      localObject1 = this.articleList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseVideoArticleInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          this.articleListObj.add(quo.a((BaseVideoArticleInfo)localObject2));
        }
      }
      if (!this.articleListObj.isEmpty())
      {
        localObject1 = PBField.initRepeatMessage(Readinjoy.ArticleSummary.class);
        ((PBRepeatMessageField)localObject1).addAll(this.articleListObj);
        localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
      }
    }
    try
    {
      CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
      ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      this.articleListBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public String toString()
  {
    return "BaseVideoArticleInfo{rowKey=" + this.rowkey + "\n,mArticleID=" + this.articleID + "\n, mRecommendSeq=" + this.recommendSeq + "\n, mTitle='" + this.title + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    prewrite();
    paramParcel.writeLong(this.articleID);
    paramParcel.writeString(this.rowkey);
    if (this.isUgc)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.uptime);
      paramParcel.writeInt(this.feedsType);
      paramParcel.writeInt(this.videoCount);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.summary);
      paramParcel.writeString(this.pagePicUrl);
      paramParcel.writeString(this.articleContentUrl);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.subscribeName);
      paramParcel.writeString(this.subscribeIcon);
      paramParcel.writeString(this.subscribeID);
      paramParcel.writeInt(this.commentCount);
      paramParcel.writeLong(this.recommendTime);
      paramParcel.writeLong(this.recommendSeq);
      paramParcel.writeLong(this.algorithmID);
      paramParcel.writeInt(this.strategyID);
      paramParcel.writeString(this.recommendReason);
      if (this.videoDataBytes != null) {
        break label303;
      }
      paramInt = -1;
      label182:
      paramParcel.writeInt(paramInt);
      if (paramInt > 0) {
        paramParcel.writeByteArray(this.videoDataBytes);
      }
      paramParcel.writeInt(this.channelID);
      paramParcel.writeInt(this.channelType);
      paramParcel.writeString(this.pushContext);
      paramParcel.writeInt(this.videoPlayCount);
      paramParcel.writeString(this.adsJumpUrl);
      paramParcel.writeInt(this.adsJumpType);
      paramParcel.writeString(this.videoReportInfo);
      paramParcel.writeInt(this.articleStyle);
      paramParcel.writeByteArray(this.businessInfo);
      if (this.articleListBytes != null) {
        break label312;
      }
    }
    label303:
    label312:
    for (paramInt = i;; paramInt = this.articleListBytes.length)
    {
      paramParcel.writeInt(paramInt);
      if (paramInt > 0) {
        paramParcel.writeByteArray(this.articleListBytes);
      }
      return;
      paramInt = 0;
      break;
      paramInt = this.videoDataBytes.length;
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo
 * JD-Core Version:    0.7.0.1
 */