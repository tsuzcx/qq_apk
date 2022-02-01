package com.tencent.av.app;

import com.tencent.av.qav_gvideo_sdk_transfer.gVideoAcceptType;
import com.tencent.av.qav_gvideo_sdk_transfer.gVideoDownChannelControl;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GVideoDownloadChannelControl
{
  public static volatile int a = -1;
  volatile HashMap<Long, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  volatile boolean jdField_a_of_type_Boolean = false;
  
  public static int a()
  {
    return AudioHelper.a(20);
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i = a();
    if (i >= 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CheckUinIsBig Debug Mode DEBUG_SMALL_CHANNEL_NUM=");
        localStringBuilder.append(i);
        QLog.d("GVideoDownloadChannelControl", 2, localStringBuilder.toString());
      }
      return paramInt >= i;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).intValue() == 2;
    }
    return a();
  }
  
  public boolean a(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GVideoDownloadChannelControl", 2, "UpdateChannelCtlList start");
    }
    int m = a();
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramgVideoDownChannelControl == null) {
      return false;
    }
    if (paramgVideoDownChannelControl.uint32_switch.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1 != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = bool1;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (!bool1)
    {
      a();
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (m < 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    HashMap localHashMap = new HashMap();
    int n = paramgVideoDownChannelControl.uint32_videoacceptTypeSize.get();
    int k = 0;
    int j = i;
    int i = k;
    while (i < n)
    {
      Object localObject = (qav_gvideo_sdk_transfer.gVideoAcceptType)paramgVideoDownChannelControl.msg_video_accept_type.get(i);
      long l = ((qav_gvideo_sdk_transfer.gVideoAcceptType)localObject).uint64_account.get();
      k = ((qav_gvideo_sdk_transfer.gVideoAcceptType)localObject).video_type.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UpdateChannelCtlList index=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" |uin=");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" |type=");
        ((StringBuilder)localObject).append(k);
        QLog.d("GVideoDownloadChannelControl", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject == null) || (((Integer)localObject).intValue() != k))
      {
        localHashMap.put(Long.valueOf(l), Integer.valueOf(k));
        j = 1;
      }
      i += 1;
    }
    if ((n != this.jdField_a_of_type_JavaUtilHashMap.size()) || (j != 0)) {
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    }
    boolean bool1 = bool3;
    if (j != 0)
    {
      bool1 = bool3;
      if (m < 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GVideoDownloadChannelControl
 * JD-Core Version:    0.7.0.1
 */