package com.tencent.biz.qqstory.takevideo2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.Set;

public class StoryPublishParams
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      SLog.b(paramString, ", logBundleDetails : null");
      return;
    }
    SLog.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      SLog.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    SLog.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishParams
 * JD-Core Version:    0.7.0.1
 */