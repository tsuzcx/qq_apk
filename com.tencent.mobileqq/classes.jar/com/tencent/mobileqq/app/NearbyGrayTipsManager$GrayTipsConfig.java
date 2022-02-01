package com.tencent.mobileqq.app;

import android.text.TextUtils;
import axby;
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
  public int global_MaxTipsCountPerDay;
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
  public int singleTask_MaxTipsCountPerDay;
  public int singleTask_maxTipsCount;
  public ArrayList<NearbyGrayTipsManager.TimeRangeInOneDay> timeRange;
  public boolean timeRangeControl;
  public String url;
  
  public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording1(Random paramRandom)
  {
    int k = 0;
    int i;
    int m;
    int j;
    if (this.favoriteGrayTipWordings1 != null)
    {
      i = this.favoriteGrayTipWordings1.size();
      if ((i <= 1) || (paramRandom == null)) {
        break label140;
      }
      m = paramRandom.nextInt(i);
      j = m;
      label37:
      if (j >= i) {
        break label159;
      }
      paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(j);
      if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
        break label124;
      }
    }
    for (;;)
    {
      Object localObject = paramRandom;
      if (paramRandom == null) {
        i = k;
      }
      for (;;)
      {
        localObject = paramRandom;
        if (i < m)
        {
          localObject = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(i);
          if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
        }
        else
        {
          return localObject;
          i = 0;
          break;
          label124:
          j += 1;
          break label37;
        }
        i += 1;
        paramRandom = null;
      }
      label140:
      if (i == 1) {
        return (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(0);
      }
      return null;
      label159:
      paramRandom = null;
    }
  }
  
  public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording2(Random paramRandom)
  {
    int k = 0;
    int i;
    int m;
    int j;
    if (this.favoriteGrayTipWordings2 != null)
    {
      i = this.favoriteGrayTipWordings2.size();
      if ((i <= 1) || (paramRandom == null)) {
        break label140;
      }
      m = paramRandom.nextInt(i);
      j = m;
      label37:
      if (j >= i) {
        break label159;
      }
      paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(j);
      if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
        break label124;
      }
    }
    for (;;)
    {
      Object localObject = paramRandom;
      if (paramRandom == null) {
        i = k;
      }
      for (;;)
      {
        localObject = paramRandom;
        if (i < m)
        {
          localObject = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(i);
          if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
        }
        else
        {
          return localObject;
          i = 0;
          break;
          label124:
          j += 1;
          break label37;
        }
        i += 1;
        paramRandom = null;
      }
      label140:
      if (i == 1) {
        return (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(0);
      }
      return null;
      label159:
      paramRandom = null;
    }
  }
  
  public NearbyGrayTipsManager.Wording getGrayTipWording(Random paramRandom)
  {
    int k = 0;
    int i;
    int m;
    int j;
    if (this.grayTipWordings != null)
    {
      i = this.grayTipWordings.size();
      if ((i <= 1) || (paramRandom == null)) {
        break label140;
      }
      m = paramRandom.nextInt(i);
      j = m;
      label37:
      if (j >= i) {
        break label159;
      }
      paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(j);
      if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
        break label124;
      }
    }
    for (;;)
    {
      Object localObject = paramRandom;
      if (paramRandom == null) {
        i = k;
      }
      for (;;)
      {
        localObject = paramRandom;
        if (i < m)
        {
          localObject = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(i);
          if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
        }
        else
        {
          return localObject;
          i = 0;
          break;
          label124:
          j += 1;
          break label37;
        }
        i += 1;
        paramRandom = null;
      }
      label140:
      if (i == 1) {
        return (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(0);
      }
      return null;
      label159:
      paramRandom = null;
    }
  }
  
  public boolean isInValidRangeDaily(long paramLong)
  {
    boolean bool2;
    if ((!this.timeRangeControl) || (this.timeRange == null) || (this.timeRange.size() == 0))
    {
      bool2 = true;
      return bool2;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int i = ((Calendar)localObject).get(11);
    localObject = this.timeRange.iterator();
    boolean bool1 = false;
    label61:
    while (((Iterator)localObject).hasNext())
    {
      NearbyGrayTipsManager.TimeRangeInOneDay localTimeRangeInOneDay = (NearbyGrayTipsManager.TimeRangeInOneDay)((Iterator)localObject).next();
      if (localTimeRangeInOneDay != null)
      {
        if (localTimeRangeInOneDay.beginTime <= localTimeRangeInOneDay.endTime) {
          if ((i >= localTimeRangeInOneDay.beginTime) && (i < localTimeRangeInOneDay.endTime)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          break label61;
          bool1 = false;
          continue;
          if (((i >= localTimeRangeInOneDay.beginTime) && (i < 24)) || ((i >= 0) && (i < localTimeRangeInOneDay.endTime))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isValid(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.aioTypes != null) && (!this.aioTypes.contains(Integer.valueOf(paramInt1)))) {
      return false;
    }
    if (this.sexTypes != null)
    {
      paramInt1 = ((axby)paramQQAppInterface.getManager(106)).a(paramInt2);
      if (!this.sexTypes.contains(Integer.valueOf(paramInt1))) {
        return false;
      }
    }
    return isInValidRangeDaily(paramLong);
  }
  
  public String toString()
  {
    return "GrayTipsConfig{id=" + this.id + ", createTime=" + this.createTime + ", grayTipsEnable=" + this.grayTipsEnable + ", global_MaxTipsCountPerDay=" + this.global_MaxTipsCountPerDay + ", maxTipsCount=" + this.maxTipsCount + ", messageCount=" + this.messageCount + ", priority=" + this.priority + ", singleTask_MaxTipsCountPerDay=" + this.singleTask_MaxTipsCountPerDay + ", singleTask_maxTipsCount=" + this.singleTask_maxTipsCount + ", aioTypes=" + this.aioTypes + ", sexTypes=" + this.sexTypes + ", timeRangeControl=" + this.timeRangeControl + ", timeRange=" + this.timeRange + ", showKeyboard=" + this.showKeyboard + ", url='" + this.url + '\'' + ", grayTipWordings=" + this.grayTipWordings + ", favoriteGrayTipWordings1=" + this.favoriteGrayTipWordings1 + ", favoriteGrayTipWordings2=" + this.favoriteGrayTipWordings2 + ", sceneId=" + this.sceneId + ", randomWordings=" + this.randomWordings + ", sceneOne=" + this.sceneOne + ", sceneTwo=" + this.sceneTwo + ", sceneThree=" + this.sceneThree + ", sceneFour=" + this.sceneFour + ", sceneFive=" + this.sceneFive + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */