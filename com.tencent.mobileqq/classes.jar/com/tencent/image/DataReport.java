package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.util.HashMap;
import java.util.LinkedList;

public class DataReport
{
  public static final int CONTINUOUS_DROP_TIMES = 5;
  public static final String EVENTCODE_SHORTVIDEO_PLAY = "ShortVideo.Play";
  public static final String PARAM_FRAM_DELAY_TIME = "param_framDelayTime";
  private final String TAG = "URLDrawable_DataReport";
  private LinkedList<Integer> mList = new LinkedList();
  
  private void doReport(LinkedList<Integer> paramLinkedList)
  {
    long l1 = System.currentTimeMillis();
    if (paramLinkedList != null)
    {
      if (paramLinkedList.size() < 5) {
        return;
      }
      int k = paramLinkedList.size();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((Integer)paramLinkedList.get(i)).intValue();
        i += 1;
      }
      i = (int)(j / k);
      new HashMap().put("param_framDelayTime", String.valueOf(i));
      long l2 = System.currentTimeMillis();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramLinkedList = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doReport(), cost:");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append("ms, averageTime=");
        localStringBuilder.append(i);
        paramLinkedList.d("URLDrawable_DataReport", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onVideoFrameDroped(boolean paramBoolean, int paramInt)
  {
    int i = this.mList.size();
    if (paramBoolean)
    {
      this.mList.add(Integer.valueOf(paramInt));
      if (i >= 5)
      {
        doReport(this.mList);
        this.mList.clear();
      }
    }
    else
    {
      if (i < 5)
      {
        this.mList.clear();
        return;
      }
      doReport(this.mList);
      this.mList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.DataReport
 * JD-Core Version:    0.7.0.1
 */