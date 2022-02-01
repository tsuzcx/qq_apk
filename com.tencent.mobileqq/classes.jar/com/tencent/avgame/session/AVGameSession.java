package com.tencent.avgame.session;

import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameSession
{
  public int a;
  public long a;
  public String a;
  public final ArrayList<VideoViewInfo> a;
  private final List<AVGameUserInfo> a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  private int f;
  public boolean f;
  public boolean g = false;
  
  public AVGameSession(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return String.format("%s-%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public AVGameUserInfo a()
  {
    return a(this.jdField_b_of_type_Long);
  }
  
  public AVGameUserInfo a(long paramLong)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label90;
        }
        if (((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mUin == paramLong)
        {
          AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          return localAVGameUserInfo;
        }
      }
      finally
      {
        continue;
        throw localObject1;
        continue;
        i += 1;
      }
      continue;
      label90:
      Object localObject2 = null;
    }
  }
  
  public AVGameUserInfo a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (paramMultiUserInfo == null) {
      return null;
    }
    ??? = a(paramMultiUserInfo.mUin);
    if (??? != null)
    {
      QavDef.MultiUserInfo.copyTo(paramMultiUserInfo, (QavDef.MultiUserInfo)???);
      return ???;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      paramMultiUserInfo = new AVGameUserInfo(paramMultiUserInfo, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_JavaUtilList.add(paramMultiUserInfo);
      return paramMultiUserInfo;
    }
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).hasVideo()) && (((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mBigVideo)) {
            ((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mBigVideo = false;
          }
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("AVGameSession", 4, "clearUserBigVideoFlag");
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSessionStatus. old status = ");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", new status = ");
    localStringBuilder.append(paramInt);
    AVLog.d("AVGameSession", localStringBuilder.toString());
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = this.jdField_c_of_type_Int;
    if (paramBoolean) {
      this.jdField_c_of_type_Int = ((paramInt ^ 0xFFFFFFFF) & i);
    } else {
      this.jdField_c_of_type_Int = (i | paramInt);
    }
    if (i != this.jdField_c_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalVideoFlag, mask[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], clear[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], [");
      localStringBuilder.append(i);
      localStringBuilder.append("->");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("]");
      AVLog.d("AVGameSession", localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    AVGameUserInfo localAVGameUserInfo = a(paramLong);
    if (localAVGameUserInfo != null) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localAVGameUserInfo);
        return;
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    ArrayList localArrayList;
    if (paramList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          Long localLong = (Long)localIterator.next();
          Object localObject = null;
          i = 0;
          paramList = localObject;
          if (i < localArrayList.size())
          {
            if (((AVGameUserInfo)localArrayList.get(i)).mUin != localLong.longValue()) {
              break label294;
            }
            paramList = (AVGameUserInfo)localArrayList.get(i);
          }
          if (paramList != null)
          {
            this.jdField_a_of_type_JavaUtilList.add(paramList);
            localArrayList.remove(paramList);
            continue;
          }
          paramList = new StringBuilder();
          paramList.append("updateUserPos cur[");
          paramList.append(localLong);
          paramList.append("] not exist. ");
          AVLog.d("AVGameSession", paramList.toString());
          continue;
        }
        if (localArrayList.size() > 0)
        {
          paramList = new StringBuilder();
          paramList.append("updateUserPos, user[");
          paramList.append(localArrayList.size());
          paramList.append("] not in list.");
          AVLog.d("AVGameSession", paramList.toString());
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
        return;
      }
      return;
      label294:
      i += 1;
    }
  }
  
  public boolean a()
  {
    int i = this.jdField_f_of_type_Int;
    return (i == 0) || (i == 4);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_c_of_type_Int & paramInt) == paramInt;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if ((localObject != null) && (((AVGameUserInfo)localObject).hasVideo()))
    {
      ((AVGameUserInfo)localObject).mBigVideo = paramBoolean;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserBigVideoFlag, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], bigVideoFlag[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], updateSuccess[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if (localObject != null)
    {
      ((AVGameUserInfo)localObject).mVideoOn = paramBoolean;
      ((AVGameUserInfo)localObject).mVideoSrc = paramInt;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserVideoStatus, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], on[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], src[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_d_of_type_Int != paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStageStatus, [");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      AVLog.d("AVGameSession", localStringBuilder.toString());
      this.jdField_d_of_type_Int = paramInt;
    }
  }
  
  public void b(List<AVGameUserInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList.clear();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      paramList.addAll(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if (localObject != null)
    {
      ((AVGameUserInfo)localObject).mSubVideoOn = paramBoolean;
      ((AVGameUserInfo)localObject).mSubVideoSrc = paramInt;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserVideoStatus, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], on[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], src[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void c(List<AVGameUserInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList.clear();
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).hasVideo()) {
            paramList.add(this.jdField_a_of_type_JavaUtilList.get(i));
          }
        }
        else {
          return;
        }
      }
      finally
      {
        continue;
        throw paramList;
        continue;
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[sessionId: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", relationType: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", relationId: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", localSpeakerOn: ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", localMute: ");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append(", localVideoFlag: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", isAutoGoOnStage: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", stageStatus: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameSession
 * JD-Core Version:    0.7.0.1
 */