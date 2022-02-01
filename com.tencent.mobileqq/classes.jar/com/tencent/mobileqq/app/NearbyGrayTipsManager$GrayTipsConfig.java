package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class NearbyGrayTipsManager$GrayTipsConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public ArrayList<Integer> aioTypes;
  public long createTime;
  public ArrayList<NearbyGrayTipsManager.Wording> favoriteGrayTipWordings1;
  public ArrayList<NearbyGrayTipsManager.Wording> favoriteGrayTipWordings2;
  public int globalMaxTipsCountPerDay;
  public ArrayList<NearbyGrayTipsManager.Wording> grayTipWordings;
  public boolean grayTipsEnable;
  public int id;
  public int maxTipsCount;
  public int messageCount;
  public int priority;
  public ArrayList<String> randomWordings;
  public NearbyGrayTipsManager.SceneFive sceneFive;
  public NearbyGrayTipsManager.SceneFour sceneFour;
  public int sceneId;
  public NearbyGrayTipsManager.SceneOne sceneOne;
  public NearbyGrayTipsManager.SceneThree sceneThree;
  public NearbyGrayTipsManager.SceneTwo sceneTwo;
  public ArrayList<Integer> sexTypes;
  public boolean showKeyboard;
  public int singleTaskMaxTipsCount;
  public int singleTaskMaxTipsCountPerDay;
  public ArrayList<NearbyGrayTipsManager.TimeRangeInOneDay> timeRange;
  public boolean timeRangeControl;
  public String url;
  
  public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording1(Random paramRandom)
  {
    Object localObject = this.favoriteGrayTipWordings1;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    localObject = null;
    if ((i > 1) && (paramRandom != null))
    {
      int m = paramRandom.nextInt(i);
      int j = m;
      while (j < i)
      {
        paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(j);
        if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
          break label90;
        }
        j += 1;
      }
      paramRandom = null;
      label90:
      localObject = paramRandom;
      if (paramRandom == null)
      {
        i = k;
        for (;;)
        {
          localObject = paramRandom;
          if (i >= m) {
            break;
          }
          paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(i);
          if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
            return paramRandom;
          }
          i += 1;
          paramRandom = null;
        }
      }
      return localObject;
    }
    paramRandom = (Random)localObject;
    if (i == 1) {
      paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(0);
    }
    return paramRandom;
  }
  
  public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording2(Random paramRandom)
  {
    Object localObject = this.favoriteGrayTipWordings2;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    localObject = null;
    if ((i > 1) && (paramRandom != null))
    {
      int m = paramRandom.nextInt(i);
      int j = m;
      while (j < i)
      {
        paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(j);
        if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
          break label90;
        }
        j += 1;
      }
      paramRandom = null;
      label90:
      localObject = paramRandom;
      if (paramRandom == null)
      {
        i = k;
        for (;;)
        {
          localObject = paramRandom;
          if (i >= m) {
            break;
          }
          paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(i);
          if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
            return paramRandom;
          }
          i += 1;
          paramRandom = null;
        }
      }
      return localObject;
    }
    paramRandom = (Random)localObject;
    if (i == 1) {
      paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(0);
    }
    return paramRandom;
  }
  
  public NearbyGrayTipsManager.Wording getGrayTipWording(Random paramRandom)
  {
    Object localObject = this.grayTipWordings;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    localObject = null;
    if ((i > 1) && (paramRandom != null))
    {
      int m = paramRandom.nextInt(i);
      int j = m;
      while (j < i)
      {
        paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(j);
        if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
          break label90;
        }
        j += 1;
      }
      paramRandom = null;
      label90:
      localObject = paramRandom;
      if (paramRandom == null)
      {
        i = k;
        for (;;)
        {
          localObject = paramRandom;
          if (i >= m) {
            break;
          }
          paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(i);
          if ((paramRandom != null) && (!TextUtils.isEmpty(paramRandom.text))) {
            return paramRandom;
          }
          i += 1;
          paramRandom = null;
        }
      }
      return localObject;
    }
    paramRandom = (Random)localObject;
    if (i == 1) {
      paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(0);
    }
    return paramRandom;
  }
  
  public boolean isInValidRangeDaily(long paramLong)
  {
    if (this.timeRangeControl)
    {
      Object localObject = this.timeRange;
      if (localObject != null)
      {
        if (((ArrayList)localObject).size() == 0) {
          return true;
        }
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(paramLong);
        int i = ((Calendar)localObject).get(11);
        localObject = this.timeRange.iterator();
        boolean bool2 = false;
        boolean bool1;
        label167:
        do
        {
          NearbyGrayTipsManager.TimeRangeInOneDay localTimeRangeInOneDay;
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localTimeRangeInOneDay = (NearbyGrayTipsManager.TimeRangeInOneDay)((Iterator)localObject).next();
          } while (localTimeRangeInOneDay == null);
          if (localTimeRangeInOneDay.beginTime <= localTimeRangeInOneDay.endTime) {
            if ((i < localTimeRangeInOneDay.beginTime) || (i >= localTimeRangeInOneDay.endTime)) {}
          }
          for (;;)
          {
            bool1 = true;
            break;
            do
            {
              bool1 = false;
              break label167;
              if ((i >= localTimeRangeInOneDay.beginTime) && (i < 24)) {
                break;
              }
            } while ((i < 0) || (i >= localTimeRangeInOneDay.endTime));
          }
          bool2 = bool1;
        } while (!bool1);
        return bool1;
      }
    }
    return true;
  }
  
  public boolean isValid(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    ArrayList localArrayList = this.aioTypes;
    if ((localArrayList != null) && (!localArrayList.contains(Integer.valueOf(paramInt1)))) {
      return false;
    }
    if (this.sexTypes != null)
    {
      paramInt1 = ((INearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(paramInt2);
      if (!this.sexTypes.contains(Integer.valueOf(paramInt1))) {
        return false;
      }
    }
    return isInValidRangeDaily(paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GrayTipsConfig{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(", grayTipsEnable=");
    localStringBuilder.append(this.grayTipsEnable);
    localStringBuilder.append(", global_MaxTipsCountPerDay=");
    localStringBuilder.append(this.globalMaxTipsCountPerDay);
    localStringBuilder.append(", maxTipsCount=");
    localStringBuilder.append(this.maxTipsCount);
    localStringBuilder.append(", messageCount=");
    localStringBuilder.append(this.messageCount);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.priority);
    localStringBuilder.append(", singleTask_MaxTipsCountPerDay=");
    localStringBuilder.append(this.singleTaskMaxTipsCountPerDay);
    localStringBuilder.append(", singleTask_maxTipsCount=");
    localStringBuilder.append(this.singleTaskMaxTipsCount);
    localStringBuilder.append(", aioTypes=");
    localStringBuilder.append(this.aioTypes);
    localStringBuilder.append(", sexTypes=");
    localStringBuilder.append(this.sexTypes);
    localStringBuilder.append(", timeRangeControl=");
    localStringBuilder.append(this.timeRangeControl);
    localStringBuilder.append(", timeRange=");
    localStringBuilder.append(this.timeRange);
    localStringBuilder.append(", showKeyboard=");
    localStringBuilder.append(this.showKeyboard);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", grayTipWordings=");
    localStringBuilder.append(this.grayTipWordings);
    localStringBuilder.append(", favoriteGrayTipWordings1=");
    localStringBuilder.append(this.favoriteGrayTipWordings1);
    localStringBuilder.append(", favoriteGrayTipWordings2=");
    localStringBuilder.append(this.favoriteGrayTipWordings2);
    localStringBuilder.append(", sceneId=");
    localStringBuilder.append(this.sceneId);
    localStringBuilder.append(", randomWordings=");
    localStringBuilder.append(this.randomWordings);
    localStringBuilder.append(", sceneOne=");
    localStringBuilder.append(this.sceneOne);
    localStringBuilder.append(", sceneTwo=");
    localStringBuilder.append(this.sceneTwo);
    localStringBuilder.append(", sceneThree=");
    localStringBuilder.append(this.sceneThree);
    localStringBuilder.append(", sceneFour=");
    localStringBuilder.append(this.sceneFour);
    localStringBuilder.append(", sceneFive=");
    localStringBuilder.append(this.sceneFive);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */