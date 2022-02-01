package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class NearbyGrayTipsManager$FaceScoreWording
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long createTime;
  public List<String> femaleWordingList;
  public int id;
  public int lastIndex;
  public Object lock = new Object();
  public List<String> maleWordingList;
  
  public NearbyGrayTipsManager$FaceScoreWording(int paramInt)
  {
    this.id = paramInt;
    this.maleWordingList = new ArrayList(5);
    this.femaleWordingList = new ArrayList(5);
  }
  
  public NearbyGrayTipsManager$FaceScoreWording(int paramInt1, long paramLong, List<String> paramList1, List<String> paramList2, int paramInt2)
  {
    this.id = paramInt1;
    this.createTime = paramLong;
    this.maleWordingList = paramList1;
    this.femaleWordingList = paramList2;
    this.lastIndex = paramInt2;
  }
  
  public static String getPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGrayTipsManager.a()).append(FaceScoreWording.class.getSimpleName()).append("_").append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String getWording(Random paramRandom, int paramInt)
  {
    String str = "";
    localObject = this.lock;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        localList = this.femaleWordingList;
        int j = localList.size();
        if (j > 0)
        {
          int i = paramRandom.nextInt(j);
          paramInt = i;
          if (i == this.lastIndex) {
            paramInt = (this.lastIndex + 1) % j;
          }
          this.lastIndex = paramInt;
          str = (String)localList.get(paramInt);
        }
        return str;
      }
      finally {}
      List localList = this.maleWordingList;
    }
  }
  
  public void saveWording(long paramLong, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "saveWording time= " + paramLong + "  maleWordingList=" + paramList1 + "  femaleWordingList=" + paramList2 + "  needSaveToFile=" + paramBoolean);
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramList2 == null) || (paramList2.size() == 0)) {}
    for (;;)
    {
      return;
      FaceScoreWording localFaceScoreWording = null;
      synchronized (this.lock)
      {
        if ((this.maleWordingList.size() == 0) || (this.createTime < paramLong))
        {
          this.createTime = paramLong;
          this.maleWordingList.clear();
          this.maleWordingList.addAll(paramList1);
        }
        if ((this.femaleWordingList.size() == 0) || (this.createTime < paramLong))
        {
          this.createTime = paramLong;
          this.femaleWordingList.clear();
          this.femaleWordingList.addAll(paramList2);
        }
        if (paramBoolean)
        {
          localFaceScoreWording = new FaceScoreWording(this.id);
          localFaceScoreWording.createTime = this.createTime;
          localFaceScoreWording.lastIndex = this.lastIndex;
          localFaceScoreWording.maleWordingList.addAll(paramList1);
          localFaceScoreWording.femaleWordingList.addAll(paramList2);
        }
        if ((!paramBoolean) || (localFaceScoreWording == null)) {
          continue;
        }
        ThreadManager.getFileThreadHandler().post(new NearbyGrayTipsManager.FaceScoreWording.1(this, localFaceScoreWording));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.FaceScoreWording
 * JD-Core Version:    0.7.0.1
 */