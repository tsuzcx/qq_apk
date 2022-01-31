package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import uxi;

public class HotRecommendFeedItem
  extends VideoListFeedItem<uxi, HotRecommendOwner>
{
  public static final String TAG = "HotRecommendFeedItem";
  public boolean mIsTopLocation;
  private HotRecommendOwner mOwner = new HotRecommendOwner();
  
  protected int assignType()
  {
    return 7;
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof HotRecommendFeedItem)))
    {
      super.copy(paramObject);
      paramObject = (HotRecommendFeedItem)paramObject;
      if (paramObject.mOwner != null) {
        this.mOwner = paramObject.mOwner;
      }
      this.mIsTopLocation = paramObject.mIsTopLocation;
      this.mVideoSeq = paramObject.mVideoSeq;
      this.mIsVideoEnd = paramObject.mIsVideoEnd;
      this.mVideoNextCookie = paramObject.mVideoNextCookie;
    }
  }
  
  public void covertFrom(String paramString, qqstory_struct.MultiRecommend paramMultiRecommend)
  {
    boolean bool2 = true;
    this.date = String.valueOf(paramMultiRecommend.date.get());
    super.setDate(this.date);
    if (!TextUtils.isEmpty(paramString)) {
      this.feedId = paramString;
    }
    this.mVideoSeq = paramMultiRecommend.seq.get();
    if (paramMultiRecommend.is_end.get() == 1)
    {
      bool1 = true;
      this.mIsVideoEnd = bool1;
      this.mVideoNextCookie = paramMultiRecommend.next_cookie.get().toStringUtf8();
      this.mOwner.mRecommendId = paramMultiRecommend.recommend_id.get();
      if (paramMultiRecommend.top_location.has()) {
        if (paramMultiRecommend.top_location.get() == 0) {
          break label128;
        }
      }
    }
    label128:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsTopLocation = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public byte[] covertToByte()
  {
    int j = 1;
    qqstory_struct.MultiRecommend localMultiRecommend = new qqstory_struct.MultiRecommend();
    PBUInt32Field localPBUInt32Field = localMultiRecommend.top_location;
    int i;
    if (this.mIsTopLocation) {
      i = 1;
    }
    for (;;)
    {
      localPBUInt32Field.set(i);
      localMultiRecommend.recommend_id.set(this.mOwner.mRecommendId);
      localMultiRecommend.seq.set(this.mVideoSeq);
      localPBUInt32Field = localMultiRecommend.is_end;
      if (this.mIsVideoEnd)
      {
        i = j;
        localPBUInt32Field.set(i);
        localMultiRecommend.next_cookie.set(ByteStringMicro.copyFromUtf8(this.mVideoNextCookie));
      }
      try
      {
        localMultiRecommend.date.set(Integer.parseInt(this.date));
        label105:
        return localMultiRecommend.toByteArray();
        i = 0;
        continue;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label105;
      }
    }
  }
  
  @NonNull
  public uxi generateHomeFeed()
  {
    return new uxi(this);
  }
  
  public int getCommentLikeType()
  {
    return 0;
  }
  
  @NonNull
  public HotRecommendOwner getOwner()
  {
    return this.mOwner;
  }
  
  public boolean isMyFeedItem()
  {
    return false;
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    qqstory_struct.MultiRecommend localMultiRecommend = new qqstory_struct.MultiRecommend();
    localMultiRecommend.mergeFrom(paramArrayOfByte);
    covertFrom("", localMultiRecommend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem
 * JD-Core Version:    0.7.0.1
 */