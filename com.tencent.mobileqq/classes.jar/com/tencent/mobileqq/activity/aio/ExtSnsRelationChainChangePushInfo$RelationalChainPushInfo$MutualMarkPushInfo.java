package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo_17;

public class ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo
{
  public long a;
  public long b;
  public long c;
  public long d;
  public int e;
  public String f;
  public String g;
  public long h;
  public long i;
  public long j;
  public long k;
  public int l;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public boolean r = false;
  public boolean s = false;
  
  public static MutualMarkPushInfo a(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject2 = new mutualmark.MutualmarkInfo();
    try
    {
      ((mutualmark.MutualmarkInfo)localObject2).mergeFrom(paramArrayOfByte);
      localObject1 = new MutualMarkPushInfo();
      ((MutualMarkPushInfo)localObject1).a = paramLong;
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_level.has()) {
        ((MutualMarkPushInfo)localObject1).b = ((mutualmark.MutualmarkInfo)localObject2).uint32_level.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_last_action_time.has()) {
        ((MutualMarkPushInfo)localObject1).c = ((mutualmark.MutualmarkInfo)localObject2).uint64_last_action_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_last_change_time.has()) {
        ((MutualMarkPushInfo)localObject1).d = ((mutualmark.MutualmarkInfo)localObject2).uint64_last_change_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_continue_days.has()) {
        ((MutualMarkPushInfo)localObject1).e = ((mutualmark.MutualmarkInfo)localObject2).uint32_continue_days.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_wildcard_wording.has()) {
        ((MutualMarkPushInfo)localObject1).f = ((mutualmark.MutualmarkInfo)localObject2).bytes_wildcard_wording.get().toStringUtf8();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_duplicate_removal_key.has()) {
        ((MutualMarkPushInfo)localObject1).g = ((mutualmark.MutualmarkInfo)localObject2).bytes_duplicate_removal_key.get().toStringUtf8();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_notify_time.has()) {
        ((MutualMarkPushInfo)localObject1).h = ((mutualmark.MutualmarkInfo)localObject2).uint64_notify_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status.has()) {
        ((MutualMarkPushInfo)localObject1).i = ((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status_end_time.has()) {
        ((MutualMarkPushInfo)localObject1).j = ((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status_end_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_sub_level.has()) {
        ((MutualMarkPushInfo)localObject1).k = ((mutualmark.MutualmarkInfo)localObject2).uint64_sub_level.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_graytip_type.has()) {
        ((MutualMarkPushInfo)localObject1).l = ((mutualmark.MutualmarkInfo)localObject2).uint32_graytip_type.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_close_flag.has())
      {
        boolean bool;
        if (((mutualmark.MutualmarkInfo)localObject2).uint32_close_flag.get() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((MutualMarkPushInfo)localObject1).r = bool;
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_resource_info.has())
      {
        paramArrayOfByte = new mutualmark.ResourceInfo_17();
        try
        {
          paramArrayOfByte.mergeFrom(((mutualmark.MutualmarkInfo)localObject2).bytes_resource_info.get().toByteArray());
        }
        catch (Throwable paramArrayOfByte)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ResourceInfo_17 parseFrom error:");
          localStringBuilder.append(paramArrayOfByte.getMessage());
          QLog.i("MutualMarkInfo", 1, localStringBuilder.toString());
          paramArrayOfByte = null;
        }
        a((MutualMarkPushInfo)localObject1, paramArrayOfByte);
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_grade_resource_info.has())
      {
        paramArrayOfByte = new mutualmark.ResourceInfo();
        try
        {
          paramArrayOfByte.mergeFrom(((mutualmark.MutualmarkInfo)localObject2).bytes_grade_resource_info.get().toByteArray());
        }
        catch (Throwable paramArrayOfByte)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ResourceInfo parseFrom error:");
          ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
          QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject2).toString());
          paramArrayOfByte = null;
        }
        a((MutualMarkPushInfo)localObject1, paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("parseFrom retInfo:");
        paramArrayOfByte.append(localObject1);
        QLog.i("MutualMarkInfo", 1, paramArrayOfByte.toString());
      }
      return localObject1;
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MutualMarkPushInfo parseFrom error:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo paramResourceInfo)
  {
    if (paramResourceInfo != null)
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.m = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.m = MutualMarkUtils.g(paramMutualMarkPushInfo.m);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.n = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.n = MutualMarkUtils.g(paramMutualMarkPushInfo.n);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.o = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.o = MutualMarkUtils.g(paramMutualMarkPushInfo.o);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.p = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramMutualMarkPushInfo.q = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo.uint32_play_cartoon.has())
      {
        int i1 = paramResourceInfo.uint32_play_cartoon.get();
        boolean bool = true;
        if (i1 != 1) {
          bool = false;
        }
        paramMutualMarkPushInfo.s = bool;
      }
    }
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    if (paramResourceInfo_17 != null)
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.m = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.m = MutualMarkUtils.g(paramMutualMarkPushInfo.m);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.n = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.n = MutualMarkUtils.g(paramMutualMarkPushInfo.n);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.o = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.o = MutualMarkUtils.g(paramMutualMarkPushInfo.o);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.p = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramMutualMarkPushInfo.q = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo_17.uint32_play_cartoon.has())
      {
        int i1 = paramResourceInfo_17.uint32_play_cartoon.get();
        boolean bool = true;
        if (i1 != 1) {
          bool = false;
        }
        paramMutualMarkPushInfo.s = bool;
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsMutualMarkPushInfo{");
    localStringBuilder.append("relation_type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("relation_level:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_action_time:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_change_time:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append("continue_days:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append("notify_time:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status_end_time:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", ");
    localStringBuilder.append("sub_level:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipType:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", ");
    localStringBuilder.append("wildcard_wording:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("gray_tip_duplicate_key:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_static_url:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_dynamic_url:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_url:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_md5:");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_name:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", ");
    localStringBuilder.append("user_close_flag:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", ");
    localStringBuilder.append("play_cartoon:");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo
 * JD-Core Version:    0.7.0.1
 */