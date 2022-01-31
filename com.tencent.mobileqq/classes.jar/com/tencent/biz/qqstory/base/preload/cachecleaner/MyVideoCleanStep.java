package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import myz;

public class MyVideoCleanStep
  extends AbsCleanStep
{
  protected int a;
  protected int b;
  
  public MyVideoCleanStep(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (StoryConfigManager)SuperManager.a(10);
    this.jdField_a_of_type_Int = ((Integer)paramArrayOfString.b("StoryMyCacheCountMax", Integer.valueOf(200))).intValue();
    this.b = ((Integer)paramArrayOfString.b("StoryMyCacheCountNormal", Integer.valueOf(100))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    String str;
    if (i < m)
    {
      str = paramArrayOfString[i];
      if (!a(str, this.jdField_a_of_type_Int)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      File localFile = new File(str);
      double d = a(localFile);
      File[] arrayOfFile = localFile.listFiles();
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      int j = 0;
      while (j < k)
      {
        localArrayList.add(new myz(this, arrayOfFile[j]));
        j += 1;
      }
      Collections.sort(localArrayList);
      int n = localArrayList.size();
      k = 0;
      j = 0;
      while (j < n)
      {
        if (j % 150 == 0) {}
        try
        {
          Thread.sleep(100L);
          if ((j % 20 == 0) && (a(str, this.b))) {
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          a(((myz)localArrayList.get(j)).a);
          k += 1;
          j += 1;
        }
      }
      paramCleanContext.jdField_a_of_type_Double = (d - a(localFile) + paramCleanContext.jdField_a_of_type_Double);
      paramCleanContext.jdField_a_of_type_Int += k;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {}
    while (paramString.length <= paramInt) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep
 * JD-Core Version:    0.7.0.1
 */