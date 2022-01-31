package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ExtraInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.TaskInfo;

public class POITaskInfo
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h = 8;
  public static int i = 9;
  public static int j = 11;
  public static int k = 12;
  public static int l = 1;
  public static int m = 2;
  public static int n = 1;
  public static int o = 2;
  public long a;
  public String a;
  public List a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  public String f;
  public String g;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public int u = 0;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
    jdField_f_of_type_Int = 6;
    jdField_g_of_type_Int = 7;
  }
  
  public POITaskInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public static POITaskInfo a(oidb_0x7bb.TaskInfo paramTaskInfo)
  {
    long l2 = 0L;
    int i2 = 0;
    if (paramTaskInfo == null) {
      return new POITaskInfo();
    }
    POITaskInfo localPOITaskInfo = new POITaskInfo();
    long l1;
    int i1;
    if (paramTaskInfo.task_id.has())
    {
      l1 = paramTaskInfo.task_id.get();
      localPOITaskInfo.jdField_a_of_type_Long = l1;
      if (!paramTaskInfo.set_id.has()) {
        break label553;
      }
      i1 = paramTaskInfo.set_id.get();
      label68:
      localPOITaskInfo.p = i1;
      if (!paramTaskInfo.name.has()) {
        break label558;
      }
      localObject = paramTaskInfo.name.get().toStringUtf8();
      label96:
      localPOITaskInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.type.has()) {
        break label565;
      }
      i1 = paramTaskInfo.type.get();
      label121:
      localPOITaskInfo.q = i1;
      if (!paramTaskInfo.priority.has()) {
        break label570;
      }
      i1 = paramTaskInfo.priority.get();
      label145:
      localPOITaskInfo.r = i1;
      if (!paramTaskInfo.icon.has()) {
        break label575;
      }
      localObject = paramTaskInfo.icon.get().toStringUtf8();
      label173:
      localPOITaskInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.banner.has()) {
        break label582;
      }
      localObject = paramTaskInfo.banner.get().toStringUtf8();
      label202:
      localPOITaskInfo.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.appid.has()) {
        break label589;
      }
      i1 = paramTaskInfo.appid.get();
      label227:
      localPOITaskInfo.s = i1;
      if (!paramTaskInfo.status.has()) {
        break label594;
      }
      i1 = paramTaskInfo.status.get();
      label251:
      localPOITaskInfo.t = i1;
      if (!paramTaskInfo.begtime.has()) {
        break label599;
      }
      l1 = paramTaskInfo.begtime.get();
      label275:
      localPOITaskInfo.jdField_b_of_type_Long = l1;
      if (!paramTaskInfo.endtime.has()) {
        break label604;
      }
      l1 = paramTaskInfo.endtime.get();
      label299:
      localPOITaskInfo.jdField_c_of_type_Long = l1;
      l1 = l2;
      if (paramTaskInfo.mtime.has()) {
        l1 = paramTaskInfo.mtime.get();
      }
      localPOITaskInfo.jdField_d_of_type_Long = l1;
      i1 = i2;
      if (paramTaskInfo.cooldown.has()) {
        i1 = paramTaskInfo.cooldown.get();
      }
      localPOITaskInfo.u = i1;
      if (!paramTaskInfo.animation.has()) {
        break label609;
      }
      localObject = paramTaskInfo.animation.get().toStringUtf8();
      label380:
      localPOITaskInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.jump_url.has()) {
        break label616;
      }
      localObject = paramTaskInfo.jump_url.get().toStringUtf8();
      label409:
      localPOITaskInfo.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.screen_info.has()) {
        break label623;
      }
      localObject = paramTaskInfo.screen_info.get().toStringUtf8();
      label438:
      localPOITaskInfo.jdField_f_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.config.has()) {
        break label630;
      }
    }
    label553:
    label558:
    label565:
    label570:
    label575:
    label582:
    label589:
    label594:
    label599:
    label604:
    label609:
    label616:
    label623:
    label630:
    for (Object localObject = paramTaskInfo.config.get().toStringUtf8();; localObject = "")
    {
      localPOITaskInfo.jdField_g_of_type_JavaLangString = ((String)localObject);
      if (!paramTaskInfo.extras.has()) {
        break label637;
      }
      localPOITaskInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramTaskInfo = paramTaskInfo.extras.get().iterator();
      while (paramTaskInfo.hasNext())
      {
        localObject = POITaskInfo.ExtraInfo.a((oidb_0x7bb.ExtraInfo)paramTaskInfo.next());
        localPOITaskInfo.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      l1 = 0L;
      break;
      i1 = 0;
      break label68;
      localObject = "";
      break label96;
      i1 = 0;
      break label121;
      i1 = 0;
      break label145;
      localObject = "";
      break label173;
      localObject = "";
      break label202;
      i1 = 0;
      break label227;
      i1 = 0;
      break label251;
      l1 = 0L;
      break label275;
      l1 = 0L;
      break label299;
      localObject = "";
      break label380;
      localObject = "";
      break label409;
      localObject = "";
      break label438;
    }
    label637:
    return localPOITaskInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTaskId:").append(this.jdField_a_of_type_Long).append(", mSetId:").append(this.p).append(", mTaskName:").append(this.jdField_a_of_type_JavaLangString).append(", mTaskType:").append(this.q).append(", mPriority:").append(this.r).append(", mIconUrl:").append(this.jdField_b_of_type_JavaLangString).append(", mBannerUrl:").append(this.jdField_c_of_type_JavaLangString).append(", mBussinessId:").append(this.s).append(", mTaskStatus:").append(this.t).append(", mBeginTime:").append(this.jdField_b_of_type_Long).append(", mEndTime:").append(this.jdField_c_of_type_Long).append(", mModifyTime:").append(this.jdField_d_of_type_Long).append(", mCooldown:").append(this.u).append(", mAnimationJson:").append(this.jdField_d_of_type_JavaLangString).append(", mJumpUrl:").append(this.jdField_e_of_type_JavaLangString).append(", mScreenInfoJson:").append(this.jdField_f_of_type_JavaLangString).append(", mConfig:").append(this.jdField_g_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.POITaskInfo
 * JD-Core Version:    0.7.0.1
 */