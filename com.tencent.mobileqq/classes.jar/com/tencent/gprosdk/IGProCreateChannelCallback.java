package com.tencent.gprosdk;

import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IGProCreateChannelCallback
{
  public abstract void onCreateChannelResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProChannel paramGProChannel, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.IGProCreateChannelCallback
 * JD-Core Version:    0.7.0.1
 */