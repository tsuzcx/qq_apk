package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedIdListSeqInfo
{
  public final int a;
  public long a;
  public final String a;
  public final boolean a;
  public int b;
  public final String b;
  public boolean b;
  public final String c;
  
  public FeedIdListSeqInfo(qqstory_struct.FeedSeqInfo paramFeedSeqInfo)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramFeedSeqInfo.feed_id.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramFeedSeqInfo.seq.get();
    this.jdField_b_of_type_JavaLangString = paramFeedSeqInfo.union_id.get().toStringUtf8();
    this.c = String.valueOf(paramFeedSeqInfo.date.get());
    if (paramFeedSeqInfo.is_playable.has()) {
      if (paramFeedSeqInfo.is_playable.get() != 1) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_Long = FeedManager.a().parse(this.c).getTime();
          AssertUtils.a(this.jdField_a_of_type_JavaLangString);
          return;
          bool = false;
          break;
          this.jdField_a_of_type_Boolean = true;
        }
      }
      catch (Exception paramFeedSeqInfo)
      {
        for (;;)
        {
          SLog.c("Q.qqstory.home", "parse date " + this.c, paramFeedSeqInfo);
        }
      }
    }
  }
  
  public FeedIdListSeqInfo(@NonNull String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Long = FeedManager.a().parse(paramString3).getTime();
      AssertUtils.a(paramString1);
      return;
    }
    catch (ParseException paramString2)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.home", "parse date", paramString2);
      }
    }
  }
  
  public qqstory_struct.FeedSeqInfo a()
  {
    qqstory_struct.FeedSeqInfo localFeedSeqInfo = new qqstory_struct.FeedSeqInfo();
    localFeedSeqInfo.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localFeedSeqInfo.seq.set(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaLangString != null) {
      localFeedSeqInfo.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    try
    {
      Integer localInteger1 = Integer.valueOf(FeedManager.a().format(new Date(NetConnInfoCenter.getServerTimeMillis())));
      localFeedSeqInfo.date.set(localInteger1.intValue());
      return localFeedSeqInfo;
    }
    catch (Exception localException1)
    {
      SLog.b("FeedIdListSeqInfo", "exception ", localException1);
      try
      {
        Integer localInteger2 = Integer.valueOf(FeedManager.a().format(new Date()));
        localFeedSeqInfo.date.set(localInteger2.intValue());
        return localFeedSeqInfo;
      }
      catch (Exception localException2)
      {
        SLog.b("FeedIdListSeqInfo", "exception ", localException2);
      }
    }
    return localFeedSeqInfo;
  }
  
  public String toString()
  {
    return "FeedIdListSeqInfo{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mSeq=" + this.jdField_a_of_type_Int + ", mUnionId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", date='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo
 * JD-Core Version:    0.7.0.1
 */