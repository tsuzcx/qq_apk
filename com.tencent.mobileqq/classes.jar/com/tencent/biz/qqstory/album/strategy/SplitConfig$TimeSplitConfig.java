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
  public long a;
  public long b;
  public String c;
  
  public SplitConfig$TimeSplitConfig(StoryAlbumConfig.FestivalConfig paramFestivalConfig, int paramInt)
  {
    super(paramFestivalConfig);
    int i = paramFestivalConfig.a;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.c = paramFestivalConfig.c;
    i = paramInt;
    if (paramInt == 0) {
      i = paramFestivalConfig.jdField_d_of_type_Int;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramFestivalConfig.jdField_d_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFestivalConfig.jdField_e_of_type_JavaLangString);
    paramFestivalConfig = localStringBuilder.toString();
    long l1 = StoryAlbumConfig.a.parse((String)localObject).getTime() / 1000L;
    long l2 = StoryAlbumConfig.a.parse(paramFestivalConfig).getTime() / 1000L;
    this.a = l1;
    this.b = l2;
  }
  
  public SplitConfig$TimeSplitConfig(StoryAlbumConfig.FestivalConfig paramFestivalConfig, Card paramCard, int paramInt)
  {
    super(paramFestivalConfig);
    int i = paramFestivalConfig.a;
    int j = 0;
    boolean bool;
    if (i == 6) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.c = paramFestivalConfig.c;
    if (paramCard != null) {
      i = (int)((paramCard.lBirthday & 0xFF00) >> 8);
    } else {
      i = 0;
    }
    if (paramCard != null) {
      j = (int)(paramCard.lBirthday & 0xFF);
    }
    if ((i > 0) && (j > 0))
    {
      if (i < 10)
      {
        paramCard = new StringBuilder();
        paramCard.append("0");
        paramCard.append(i);
        paramCard = paramCard.toString();
      }
      else
      {
        paramCard = String.valueOf(i);
      }
      Object localObject;
      if (j < 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(j);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = String.valueOf(j);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("-");
      localStringBuilder.append(paramCard);
      localStringBuilder.append("-");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramFestivalConfig.jdField_d_of_type_JavaLangString);
      paramCard = localStringBuilder.toString();
      paramCard = StoryAlbumConfig.a.parse(paramCard);
      long l1 = paramCard.getTime() / 1000L;
      long l2 = paramCard.getTime() / 1000L;
      long l3 = paramFestivalConfig.jdField_e_of_type_Int * 60 * 60;
      this.a = l1;
      this.b = (l2 + l3);
      return;
    }
    this.a = 0L;
    this.b = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("TimeSplitConfig =[");
    localStringBuilder1.append(" mStartTime=");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append(" mEndTime=");
    localStringBuilder1.append(this.b);
    localStringBuilder1.append(" mAlbumName=");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("] ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(localStringBuilder1.toString());
    localStringBuilder2.append(super.toString());
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig.TimeSplitConfig
 * JD-Core Version:    0.7.0.1
 */