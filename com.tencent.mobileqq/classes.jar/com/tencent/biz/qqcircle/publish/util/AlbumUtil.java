package com.tencent.biz.qqcircle.publish.util;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AlbumUtil
{
  public static final HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("image", Integer.valueOf(0));
    a.put("video", Integer.valueOf(1));
    a.put("mobileqq", Integer.valueOf(2));
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    String[] arrayOfString = HostStaticInvokeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if (arrayOfString == null) {
      return 0;
    }
    Object localObject = (Integer)a.get(arrayOfString[0]);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMediaType fail : ");
      ((StringBuilder)localObject).append(paramLocalMediaInfo.mMimeType);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(arrayOfString[0]);
      QLog.w("QAlbumUtil", 1, ((StringBuilder)localObject).toString());
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public static boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    return a(paramLocalMediaInfo) == 1;
  }
  
  public static boolean c(LocalMediaInfo paramLocalMediaInfo)
  {
    return a(paramLocalMediaInfo) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */