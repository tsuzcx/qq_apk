package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class HotRecommendFeedItem
  extends VideoListFeedItem<HotRecommendHomeFeed, HotRecommendOwner>
{
  public static final String TAG = "HotRecommendFeedItem";
  public boolean mIsTopLocation = false;
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
      HotRecommendOwner localHotRecommendOwner = paramObject.mOwner;
      if (localHotRecommendOwner != null) {
        this.mOwner = localHotRecommendOwner;
      }
      this.mIsTopLocation = paramObject.mIsTopLocation;
      this.mVideoSeq = paramObject.mVideoSeq;
      this.mIsVideoEnd = paramObject.mIsVideoEnd;
      this.mVideoNextCookie = paramObject.mVideoNextCookie;
    }
  }
  
  public void covertFrom(String paramString, qqstory_struct.MultiRecommend paramMultiRecommend)
  {
    this.date = String.valueOf(paramMultiRecommend.date.get());
    super.setDate(this.date);
    if (!TextUtils.isEmpty(paramString)) {
      this.feedId = paramString;
    }
    this.mVideoSeq = paramMultiRecommend.seq.get();
    int i = paramMultiRecommend.is_end.get();
    boolean bool2 = false;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsVideoEnd = bool1;
    this.mVideoNextCookie = paramMultiRecommend.next_cookie.get().toStringUtf8();
    this.mOwner.mRecommendId = paramMultiRecommend.recommend_id.get();
    if (paramMultiRecommend.top_location.has())
    {
      bool1 = bool2;
      if (paramMultiRecommend.top_location.get() != 0) {
        bool1 = true;
      }
      this.mIsTopLocation = bool1;
    }
  }
  
  public byte[] covertToByte()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  public HotRecommendHomeFeed generateHomeFeed()
  {
    return new HotRecommendHomeFeed(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem
 * JD-Core Version:    0.7.0.1
 */