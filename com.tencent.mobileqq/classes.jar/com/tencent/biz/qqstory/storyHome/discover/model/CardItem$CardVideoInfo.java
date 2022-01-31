package com.tencent.biz.qqstory.storyHome.discover.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nvu;

public class CardItem$CardVideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new nvu();
  private qqstory_struct.CardVideoInfo a;
  
  public CardItem$CardVideoInfo(Parcel paramParcel)
  {
    try
    {
      this.a = new qqstory_struct.CardVideoInfo();
      this.a.mergeFrom(paramParcel.createByteArray());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel) {}
  }
  
  public CardItem$CardVideoInfo(qqstory_struct.CardVideoInfo paramCardVideoInfo)
  {
    this.a = paramCardVideoInfo;
  }
  
  public CardItem$CardVideoInfo(String paramString1, String paramString2, @NonNull List paramList)
  {
    this.a = new qqstory_struct.CardVideoInfo();
    this.a.feed_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    this.a.video_cover.set(ByteStringMicro.copyFromUtf8(paramString2));
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      this.a.vid_list.add(ByteStringMicro.copyFromUtf8(paramString2));
    }
    this.a.label.set(ByteStringMicro.copyFromUtf8("投稿卡片"));
  }
  
  public int a()
  {
    return this.a.total_like_num.get();
  }
  
  public long a()
  {
    return this.a.view_total_num.get();
  }
  
  public String a()
  {
    return this.a.vid.get().toStringUtf8();
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.vid_list.size())
    {
      localArrayList.add(((ByteStringMicro)this.a.vid_list.get().get(i)).toStringUtf8());
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.a.total_like_num.set(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.a.view_total_num.set(paramLong);
  }
  
  public String b()
  {
    return this.a.video_cover.get().toStringUtf8();
  }
  
  public String c()
  {
    return this.a.feed_id.get().toStringUtf8();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.a.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo
 * JD-Core Version:    0.7.0.1
 */