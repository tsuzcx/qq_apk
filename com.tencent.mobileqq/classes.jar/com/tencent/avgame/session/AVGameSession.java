package com.tencent.avgame.session;

import bkdp;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lob;

public class AVGameSession
{
  public int a;
  public long a;
  private AVGameSession.SessionStatus jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus = AVGameSession.SessionStatus.NONE;
  public String a;
  public final ArrayList<lob> a;
  private final List<AVGameUserInfo> jdField_a_of_type_JavaUtilList = new ArrayList(8);
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c = 0;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public AVGameSession(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return String.format("%s-%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public AVGameSession.SessionStatus a()
  {
    return this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus;
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
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mUin != paramLong) {
            break label80;
          }
          AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          return localAVGameUserInfo;
        }
      }
      finally {}
      Object localObject2 = null;
      continue;
      label80:
      i += 1;
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
      finally {}
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_d_of_type_Int != paramInt)
    {
      bkdp.d("AVGameSession", "updateStageStatus, [" + this.jdField_d_of_type_Int + "->" + paramInt + "]");
      this.jdField_d_of_type_Int = paramInt;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = this.c;
    if (paramBoolean) {}
    for (this.c &= (paramInt ^ 0xFFFFFFFF);; this.c |= paramInt)
    {
      if (i != this.c) {
        bkdp.d("AVGameSession", "setLocalVideoFlag, mask[" + paramInt + "], clear[" + paramBoolean + "], [" + i + "->" + this.c + "]");
      }
      return;
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
  
  public void a(AVGameSession.SessionStatus paramSessionStatus)
  {
    bkdp.d("AVGameSession", "setSessionStatus. old status = " + this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus + ", new status = " + paramSessionStatus);
    this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus = paramSessionStatus;
  }
  
  public void a(List<Long> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    for (;;)
    {
      Long localLong;
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break label213;
        }
        localLong = (Long)localIterator.next();
        i = 0;
        if (i >= localArrayList.size()) {
          break label273;
        }
        if (((AVGameUserInfo)localArrayList.get(i)).mUin == localLong.longValue())
        {
          paramList = (AVGameUserInfo)localArrayList.get(i);
          if (paramList == null) {
            break label180;
          }
          this.jdField_a_of_type_JavaUtilList.add(paramList);
          localArrayList.remove(paramList);
        }
      }
      i += 1;
      continue;
      label180:
      bkdp.d("AVGameSession", "updateUserPos cur[" + localLong + "] not exist. ");
      continue;
      label213:
      if (localArrayList.size() > 0)
      {
        bkdp.d("AVGameSession", "updateUserPos, user[" + localArrayList.size() + "] not in list.");
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
      }
      return;
      label273:
      paramList = null;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus == AVGameSession.SessionStatus.NONE) || (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession$SessionStatus == AVGameSession.SessionStatus.EXITED);
  }
  
  public boolean a(int paramInt)
  {
    return (this.c & paramInt) == paramInt;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    AVGameUserInfo localAVGameUserInfo = a(paramLong);
    boolean bool1 = bool2;
    if (localAVGameUserInfo != null)
    {
      bool1 = bool2;
      if (localAVGameUserInfo.hasVideo())
      {
        localAVGameUserInfo.mBigVideo = paramBoolean;
        bool1 = true;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameSession", 4, "updateUserBigVideoFlag, uin[" + paramLong + "], bigVideoFlag[" + paramBoolean + "], updateSuccess[" + bool1 + "]");
    }
    return bool1;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AVGameUserInfo localAVGameUserInfo = a(paramLong);
    if (localAVGameUserInfo != null)
    {
      localAVGameUserInfo.mVideoOn = paramBoolean;
      localAVGameUserInfo.mVideoSrc = paramInt;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameSession", 4, "updateUserVideoStatus, uin[" + paramLong + "], on[" + paramBoolean + "], src[" + paramInt + "]");
    }
    return bool;
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
    boolean bool = false;
    AVGameUserInfo localAVGameUserInfo = a(paramLong);
    if (localAVGameUserInfo != null)
    {
      localAVGameUserInfo.mSubVideoOn = paramBoolean;
      localAVGameUserInfo.mSubVideoSrc = paramInt;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameSession", 4, "updateUserVideoStatus, uin[" + paramLong + "], on[" + paramBoolean + "], src[" + paramInt + "]");
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
      finally {}
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[sessionId: ").append(this.jdField_a_of_type_JavaLangString).append(", relationType: ").append(this.jdField_b_of_type_Int).append(", relationId: ").append(this.jdField_a_of_type_Long).append(", localSpeakerOn: ").append(this.jdField_d_of_type_Boolean).append(", localMute: ").append(this.jdField_e_of_type_Boolean).append(", localVideoFlag: ").append(this.c).append(", isAutoGoOnStage: ").append(this.g).append(", stageStatus: ").append(this.jdField_d_of_type_Int).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameSession
 * JD-Core Version:    0.7.0.1
 */