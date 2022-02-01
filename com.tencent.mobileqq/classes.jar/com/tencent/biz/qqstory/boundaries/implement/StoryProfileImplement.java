package com.tencent.biz.qqstory.boundaries.implement;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;

public class StoryProfileImplement
{
  public static Intent a(Context paramContext, int paramInt, String paramString)
  {
    return QQStoryMemoriesActivity.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    QQStoryMemoriesActivity.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext.startActivity(a(paramContext, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.StoryProfileImplement
 * JD-Core Version:    0.7.0.1
 */