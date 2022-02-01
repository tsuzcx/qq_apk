package com.tencent.biz.qqstory.boundaries.implement.staticmethods;

import android.content.Intent;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.extension.config.QQStoryConfigServletHandlerExt.Constants;
import mqq.app.MSFServlet;

public class StaticMethods$ConfigServlet
{
  public static void a(SparseIntArray paramSparseIntArray)
  {
    int[][] arrayOfInt = QQStoryConfigServletHandlerExt.Constants.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int[] arrayOfInt1 = arrayOfInt[i];
      int k = arrayOfInt1[0];
      int m = arrayOfInt1[1];
      if (k != -1) {
        paramSparseIntArray.put(StoryApi.a(k), m);
      } else {
        paramSparseIntArray.put(m, m);
      }
      i += 1;
    }
  }
  
  public static void a(MSFServlet paramMSFServlet, Intent paramIntent, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.staticmethods.StaticMethods.ConfigServlet
 * JD-Core Version:    0.7.0.1
 */