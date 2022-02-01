package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(14)
public class CapacityCleanStep
  extends AbsCleanStep
{
  protected int a;
  protected int b;
  
  public CapacityCleanStep(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (StoryConfigManager)SuperManager.a(10);
    this.a = ((Integer)paramArrayOfString.b("StoryFriendCacheCountMax", Integer.valueOf(300))).intValue();
    this.jdField_b_of_type_Int = ((Integer)paramArrayOfString.b("StoryFriendCacheCountNormal", Integer.valueOf(200))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      String str = paramArrayOfString[i];
      int j;
      if (paramCleanContext.a) {
        j = 50;
      } else {
        j = this.a;
      }
      if (!a(str, j))
      {
        File localFile = new File(str);
        double d1 = a(localFile);
        File[] arrayOfFile = localFile.listFiles();
        ArrayList localArrayList = new ArrayList();
        int k = arrayOfFile.length;
        j = 0;
        while (j < k)
        {
          localArrayList.add(new CapacityCleanStep.FileInfo(this, arrayOfFile[j]));
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
          if ((j % 20 == 0) && (a(str, this.jdField_b_of_type_Int))) {
            return;
          }
          a(((CapacityCleanStep.FileInfo)localArrayList.get(j)).a);
          k += 1;
          j += 1;
        }
        double d2 = a(localFile);
        paramCleanContext.jdField_b_of_type_Double += d1 - d2;
        paramCleanContext.jdField_b_of_type_Int += k;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep
 * JD-Core Version:    0.7.0.1
 */