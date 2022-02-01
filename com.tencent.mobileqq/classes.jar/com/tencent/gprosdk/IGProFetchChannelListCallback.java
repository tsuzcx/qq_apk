package com.tencent.gprosdk;

import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IGProFetchChannelListCallback
{
  public abstract void onFetchChannelList(int paramInt, String paramString, boolean paramBoolean, HashMap<Long, ArrayList<GProChannel>> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.IGProFetchChannelListCallback
 * JD-Core Version:    0.7.0.1
 */