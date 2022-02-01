package com.tencent.biz.qqstory.album;

import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoryAlbumResourceDownloader
{
  public static int a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  private String a(int paramInt)
  {
    if (paramInt == jdField_a_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(OfflineEnvHelper.a("3408"));
      localStringBuilder.append("3408");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("loading");
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new File(a(jdField_a_of_type_Int));
    boolean bool = ((File)localObject1).exists();
    int j = 0;
    Object localObject2;
    if ((bool) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localObject2 = localObject1[i];
          localHashMap.put(((File)localObject2).getName(), localObject2);
          i += 1;
        }
      }
    }
    localObject1 = new ArrayList();
    int i = j;
    while (i < 50)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(".png");
      localObject2 = (File)localHashMap.get(((StringBuilder)localObject2).toString());
      if (localObject2 != null) {
        ((List)localObject1).add(((File)localObject2).getAbsolutePath());
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
  }
  
  private void a(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource , upzip : %s", Boolean.valueOf(paramBoolean));
    HtmlOffline.b("3408", ((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface(), new StoryAlbumResourceDownloader.2(this, paramBoolean), paramBoolean, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader
 * JD-Core Version:    0.7.0.1
 */