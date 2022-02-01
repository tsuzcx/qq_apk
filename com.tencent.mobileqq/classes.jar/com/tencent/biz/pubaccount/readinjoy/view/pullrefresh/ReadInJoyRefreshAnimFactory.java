package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;

public class ReadInJoyRefreshAnimFactory
{
  public static ReadInJoyAnimBaseManager a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ReadInJoyAnimDefaultManager(paramContext);
    case 2: 
      return new ReadInJoySkinAnimManager(paramContext);
    }
    return new ReadInJoyAnimOldManager(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyRefreshAnimFactory
 * JD-Core Version:    0.7.0.1
 */