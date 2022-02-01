package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyVideoCleanStep
  extends AbsCleanStep
{
  protected int c;
  protected int d;
  
  public MyVideoCleanStep(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (StoryConfigManager)SuperManager.a(10);
    this.c = ((Integer)paramArrayOfString.c("StoryMyCacheCountMax", Integer.valueOf(200))).intValue();
    this.d = ((Integer)paramArrayOfString.c("StoryMyCacheCountNormal", Integer.valueOf(100))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      String str = paramArrayOfString[i];
      if (!a(str, this.c))
      {
        File localFile = new File(str);
        double d1 = b(localFile);
        File[] arrayOfFile = localFile.listFiles();
        ArrayList localArrayList = new ArrayList();
        int k = arrayOfFile.length;
        int j = 0;
        while (j < k)
        {
          localArrayList.add(new MyVideoCleanStep.FileInfo(this, arrayOfFile[j]));
          j += 1;
        }
        Collections.sort(localArrayList);
        int n = localArrayList.size();
        j = 0;
        k = 0;
        while (j < n)
        {
          if (j % 150 == 0) {
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          if ((j % 20 == 0) && (a(str, this.d))) {
            return;
          }
          a(((MyVideoCleanStep.FileInfo)localArrayList.get(j)).a);
          k += 1;
          j += 1;
        }
        double d2 = b(localFile);
        paramCleanContext.d += d1 - d2;
        paramCleanContext.c += k;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return true;
    }
    return paramString.length <= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep
 * JD-Core Version:    0.7.0.1
 */