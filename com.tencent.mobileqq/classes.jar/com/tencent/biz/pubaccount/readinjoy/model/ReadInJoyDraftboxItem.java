package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;

public class ReadInJoyDraftboxItem
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyDraftboxItem> CREATOR = new ReadInJoyDraftboxItem.1();
  public static final int DEFAULT_DRAFTID = -1;
  public static final String TABLE_NAME = ReadInJoyDraftboxItem.class.getSimpleName();
  public static final int TYPE_ANSWER = 2;
  public static final int TYPE_ARTICLE = 1;
  public static final int TYPE_QUESTION = 3;
  public static final int TYPE_UGC = 0;
  public byte[] content;
  public String digest;
  public byte[] firstPic;
  public ReadInJoyDraftboxItem.PicData firstPicData;
  public long time;
  public String title;
  public int type = 0;
  
  public ReadInJoyDraftboxItem() {}
  
  public ReadInJoyDraftboxItem(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.digest = paramParcel.readString();
    this.time = paramParcel.readLong();
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.firstPic);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.content);
    }
    this.type = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ReadInJoyDraftboxItem{id='" + getId() + '\'' + "title='" + this.title + '\'' + ", digest='" + this.digest + '\'' + ", time=" + this.time + ", type=" + this.type + ", firstPicData=" + this.firstPicData + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.digest);
    paramParcel.writeLong(this.time);
    if ((this.firstPic != null) && (this.firstPic.length > 0))
    {
      paramParcel.writeInt(this.firstPic.length);
      paramParcel.writeByteArray(this.firstPic);
      if ((this.content == null) || (this.content.length <= 0)) {
        break label105;
      }
      paramParcel.writeInt(this.content.length);
      paramParcel.writeByteArray(this.content);
    }
    for (;;)
    {
      paramParcel.writeInt(this.type);
      return;
      paramParcel.writeInt(0);
      break;
      label105:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem
 * JD-Core Version:    0.7.0.1
 */