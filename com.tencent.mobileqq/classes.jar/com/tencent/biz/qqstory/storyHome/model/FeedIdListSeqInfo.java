package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import java.util.Iterator;
import java.util.List;

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
    boolean bool2 = paramFeedSeqInfo.is_playable.has();
    boolean bool1 = true;
    if (bool2)
    {
      if (paramFeedSeqInfo.is_playable.get() != 1) {
        bool1 = false;
      }
      this.jdField_a_of_type_Boolean = bool1;
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
    }
    try
    {
      if (!TextUtils.isEmpty(this.c)) {
        this.jdField_a_of_type_Long = FeedManager.a().parse(this.c).getTime();
      }
    }
    catch (Exception paramFeedSeqInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse date ");
      localStringBuilder.append(this.c);
      SLog.c("Q.qqstory.home", localStringBuilder.toString(), paramFeedSeqInfo);
    }
    AssertUtils.checkNotEmpty(this.jdField_a_of_type_JavaLangString);
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
      if (!TextUtils.isEmpty(this.c)) {
        this.jdField_a_of_type_Long = FeedManager.a().parse(this.c).getTime();
      }
    }
    catch (ParseException paramString2)
    {
      SLog.c("Q.qqstory.home", "parse date", paramString2);
    }
    AssertUtils.checkNotNull(paramString1);
  }
  
  public static int a(List<FeedIdListSeqInfo> paramList, String paramString)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (((FeedIdListSeqInfo)paramList.next()).jdField_a_of_type_JavaLangString.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedIdListSeqInfo{feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSeq=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mUnionId='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo
 * JD-Core Version:    0.7.0.1
 */