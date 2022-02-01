package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SlideShowUtils
{
  private static String a = "SlideShowUtils";
  
  public static String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject2).append("multipicset/");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".mp4");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).getParentFile().exists()) {
      ((File)localObject2).getParentFile().mkdirs();
    }
    return localObject1;
  }
  
  public static String a(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j % 60;
    j /= 60;
    Object localObject1;
    if (i > 9)
    {
      localObject1 = String.valueOf(i);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(String.valueOf(i));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2;
    if (j > 9)
    {
      localObject2 = String.valueOf(j);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(String.valueOf(j));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  public static List<String> a(List<SlideItemInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if (localSlideItemInfo != null) {
        localArrayList.add(localSlideItemInfo.f);
      }
    }
    return localArrayList;
  }
  
  public static List<SlideItemInfo> a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, List<SlideItemInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (LocalMediaInfo)paramHashMap.get(paramList.get(i));
      if (localObject1 != null) {
        localObject1 = new SlideItemInfo((LocalMediaInfo)localObject1);
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (paramList1 != null)
      {
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= paramList1.size()) {
            break;
          }
          SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList1.get(j);
          if (localSlideItemInfo != null) {
            localObject2 = localSlideItemInfo.a;
          } else {
            localObject2 = null;
          }
          Object localObject3 = localObject1;
          if (localObject2 != null)
          {
            localObject3 = localObject1;
            if (((String)paramList.get(i)).equals(((LocalMediaInfo)localObject2).path))
            {
              localObject3 = (SlideItemInfo)paramList1.get(j);
              if ((localObject1 != null) && (localObject3 != null))
              {
                ((SlideItemInfo)localObject1).i = ((SlideItemInfo)localObject3).i;
                ((SlideItemInfo)localObject1).j = ((SlideItemInfo)localObject3).j;
                ((SlideItemInfo)localObject1).p = ((SlideItemInfo)localObject3).p;
                ((SlideItemInfo)localObject1).q = ((SlideItemInfo)localObject3).q;
                ((SlideItemInfo)localObject1).o = ((SlideItemInfo)localObject3).o;
                ((SlideItemInfo)localObject1).s = ((SlideItemInfo)localObject3).s;
                ((SlideItemInfo)localObject1).n = ((SlideItemInfo)localObject3).n;
                ((SlideItemInfo)localObject1).m = ((SlideItemInfo)localObject3).m;
                ((SlideItemInfo)localObject1).t = ((SlideItemInfo)localObject3).t;
                ((SlideItemInfo)localObject1).r = ((SlideItemInfo)localObject3).r;
                ((SlideItemInfo)localObject1).c = ((SlideItemInfo)localObject3).c;
                ((SlideItemInfo)localObject1).d = ((SlideItemInfo)localObject3).d;
                localObject3 = localObject1;
                if (((SlideItemInfo)localObject1).a != null)
                {
                  ((SlideItemInfo)localObject1).a.mediaWidth = ((LocalMediaInfo)localObject2).mediaWidth;
                  ((SlideItemInfo)localObject1).a.mediaHeight = ((LocalMediaInfo)localObject2).mediaHeight;
                  ((SlideItemInfo)localObject1).a.rotation = ((LocalMediaInfo)localObject2).rotation;
                  localObject3 = localObject1;
                }
              }
              else
              {
                localObject3 = localSlideItemInfo;
              }
            }
          }
          j += 1;
          localObject1 = localObject3;
        }
      }
      localArrayList.add(localObject2);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowUtils
 * JD-Core Version:    0.7.0.1
 */