package com.tencent.biz.qqstory.boundaries.delegates;

import android.app.Activity;
import android.os.Bundle;

public abstract interface ActivityDelegate<T extends Activity>
{
  public abstract void a(T paramT);
  
  public abstract void a(T paramT, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate
 * JD-Core Version:    0.7.0.1
 */