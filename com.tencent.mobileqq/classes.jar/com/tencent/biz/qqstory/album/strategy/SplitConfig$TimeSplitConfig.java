package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryAlbumConfig.FestivalConfig;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.data.Card;
import java.text.DateFormat;
import java.util.Date;

public class SplitConfig$TimeSplitConfig
  extends BaseSplitConfig
{
  public long g;
  public long h;
  public String i;
  
  public SplitConfig$TimeSplitConfig(StoryAlbumConfig.FestivalConfig paramFestivalConfig, int paramInt)
  {
    super(paramFestivalConfig);
    int j = paramFestivalConfig.a;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.i = paramFestivalConfig.g;
    j = paramInt;
    if (paramInt == 0) {
      j = paramFestivalConfig.h;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramFestivalConfig.i);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFestivalConfig.j);
    paramFestivalConfig = localStringBuilder.toString();
    long l1 = StoryAlbumConfig.a.parse((String)localObject).getTime() / 1000L;
    long l2 = StoryAlbumConfig.a.parse(paramFestivalConfig).getTime() / 1000L;
    this.g = l1;
    this.h = l2;
  }
  
  public SplitConfig$TimeSplitConfig(StoryAlbumConfig.FestivalConfig paramFestivalConfig, Card paramCard, int paramInt)
  {
    super(paramFestivalConfig);
    int j = paramFestivalConfig.a;
    int k = 0;
    boolean bool;
    if (j == 6) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.i = paramFestivalConfig.g;
    if (paramCard != null) {
      j = (int)((paramCard.lBirthday & 0xFF00) >> 8);
    } else {
      j = 0;
    }
    if (paramCard != null) {
      k = (int)(paramCard.lBirthday & 0xFF);
    }
    if ((j > 0) && (k > 0))
    {
      if (j < 10)
      {
        paramCard = new StringBuilder();
        paramCard.append("0");
        paramCard.append(j);
        paramCard = paramCard.toString();
      }
      else
      {
        paramCard = String.valueOf(j);
      }
      Object localObject;
      if (k < 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(k);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = String.valueOf(k);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("-");
      localStringBuilder.append(paramCard);
      localStringBuilder.append("-");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramFestivalConfig.i);
      paramCard = localStringBuilder.toString();
      paramCard = StoryAlbumConfig.a.parse(paramCard);
      long l1 = paramCard.getTime() / 1000L;
      long l2 = paramCard.getTime() / 1000L;
      long l3 = paramFestivalConfig.k * 60 * 60;
      this.g = l1;
      this.h = (l2 + l3);
      return;
    }
    this.g = 0L;
    this.h = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("TimeSplitConfig =[");
    localStringBuilder1.append(" mStartTime=");
    localStringBuilder1.append(this.g);
    localStringBuilder1.append(" mEndTime=");
    localStringBuilder1.append(this.h);
    localStringBuilder1.append(" mAlbumName=");
    localStringBuilder1.append(this.i);
    localStringBuilder1.append("] ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(localStringBuilder1.toString());
    localStringBuilder2.append(super.toString());
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig.TimeSplitConfig
 * JD-Core Version:    0.7.0.1
 */