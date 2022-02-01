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
    localStringBuilder.append(NearbyGrayTipsManager.d());
    localStringBuilder.append(FaceScoreWording.class.getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String getWording(Random paramRandom, int paramInt)
  {
    Object localObject = this.lock;
    if (paramInt == 1) {}
    try
    {
      List localList = this.femaleWordingList;
      break label29;
      localList = this.maleWordingList;
      label29:
      int j = localList.size();
      if (j > 0)
      {
        int i = paramRandom.nextInt(j);
        paramInt = i;
        if (i == this.lastIndex) {
          paramInt = (this.lastIndex + 1) % j;
        }
        this.lastIndex = paramInt;
        paramRandom = (String)localList.get(paramInt);
      }
      else
      {
        paramRandom = "";
      }
      return paramRandom;
    }
    finally {}
  }
  
  public void saveWording(long paramLong, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveWording time= ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("  maleWordingList=");
      ((StringBuilder)localObject1).append(paramList1);
      ((StringBuilder)localObject1).append("  femaleWordingList=");
      ((StringBuilder)localObject1).append(paramList2);
      ((StringBuilder)localObject1).append("  needSaveToFile=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramList1 != null) && (paramList1.size() != 0) && (paramList2 != null))
    {
      if (paramList2.size() == 0) {
        return;
      }
      localObject1 = null;
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
          localObject1 = new FaceScoreWording(this.id);
          ((FaceScoreWording)localObject1).createTime = this.createTime;
          ((FaceScoreWording)localObject1).lastIndex = this.lastIndex;
          ((FaceScoreWording)localObject1).maleWordingList.addAll(paramList1);
          ((FaceScoreWording)localObject1).femaleWordingList.addAll(paramList2);
        }
        if ((paramBoolean) && (localObject1 != null)) {
          ThreadManager.getFileThreadHandler().post(new NearbyGrayTipsManager.FaceScoreWording.1(this, (FaceScoreWording)localObject1));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.FaceScoreWording
 * JD-Core Version:    0.7.0.1
 */