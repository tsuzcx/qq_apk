package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pxx;

public class ReadInJoyDraftboxItem$ReadInJoyDraftboxContent
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ReadInJoyDraftboxContent> CREATOR = new pxx();
  private static final long serialVersionUID = 1L;
  public int adTag;
  public ArrayList<ReadInJoyDraftboxItem.PicData> adapterList;
  public String answerTitle;
  public int articleType;
  public String commentString;
  public ArrayList<SocializeFeedsInfo.BiuCommentInfo> multiBiuStruct;
  public int originFrom;
  public ArrayList<ReadInJoyDraftboxItem.PicData> picDataList;
  public ArrayList<ReadInJoyDraftboxItem.PicData> realList;
  public String richTextContent;
  public int srcSize;
  public String topicId;
  public List<Integer> typeList;
  public String ugcEditCookie;
  
  public ReadInJoyDraftboxItem$ReadInJoyDraftboxContent() {}
  
  public ReadInJoyDraftboxItem$ReadInJoyDraftboxContent(Parcel paramParcel)
  {
    this.topicId = paramParcel.readString();
    this.ugcEditCookie = paramParcel.readString();
    this.adTag = paramParcel.readInt();
    this.commentString = paramParcel.readString();
    this.typeList = paramParcel.readArrayList(Integer.class.getClassLoader());
    this.srcSize = paramParcel.readInt();
    this.multiBiuStruct = paramParcel.createTypedArrayList(SocializeFeedsInfo.BiuCommentInfo.CREATOR);
    this.picDataList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.realList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.adapterList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.richTextContent = paramParcel.readString();
    this.answerTitle = paramParcel.readString();
    this.articleType = paramParcel.readInt();
    this.originFrom = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ReadInJoyDraftboxContent{topicId='" + this.topicId + '\'' + ", ugcEditCookie='" + this.ugcEditCookie + '\'' + ", adTag=" + this.adTag + ", commentString='" + this.commentString + '\'' + ", typeList=" + this.typeList + ", srcSize=" + this.srcSize + ", multiBiuStruct=" + this.multiBiuStruct + ", picDataList=" + this.picDataList + ", realList=" + this.realList + ", adapterList=" + this.adapterList + ", richTextContent='" + this.richTextContent + '\'' + ", answerTitle='" + this.answerTitle + '\'' + ", articleType=" + this.articleType + ", originFrom=" + this.originFrom + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.topicId);
    paramParcel.writeString(this.ugcEditCookie);
    paramParcel.writeInt(this.adTag);
    paramParcel.writeString(this.commentString);
    paramParcel.writeList(this.typeList);
    paramParcel.writeInt(this.srcSize);
    paramParcel.writeTypedList(this.multiBiuStruct);
    paramParcel.writeTypedList(this.picDataList);
    paramParcel.writeTypedList(this.realList);
    paramParcel.writeTypedList(this.adapterList);
    paramParcel.writeString(this.richTextContent);
    paramParcel.writeString(this.answerTitle);
    paramParcel.writeInt(this.articleType);
    paramParcel.writeInt(this.originFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent
 * JD-Core Version:    0.7.0.1
 */