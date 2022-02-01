package com.tencent.mobileqq.armap;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.ARPromotionRDHandler;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResHandler;

public class ResDownloadHandler
{
  public static final String a;
  public ResDownloadHandler.RDHandler[] b = new ResDownloadHandler.RDHandler[7];
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ResDownloadManager.class.getSimpleName());
    localStringBuilder.append(".");
    localStringBuilder.append(ResDownloadHandler.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public ResDownloadHandler.RDHandler a(AppInterface paramAppInterface, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 7) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.b[i];
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null)
    {
      paramAppInterface = (AppInterface)localObject;
      if (i != 2)
      {
        paramAppInterface = (AppInterface)localObject;
        if (i != 3) {
          if (i != 5)
          {
            if (i != 6) {
              paramAppInterface = (AppInterface)localObject;
            } else {
              paramAppInterface = new TroopGameCardResHandler();
            }
          }
          else {
            paramAppInterface = new ARPromotionRDHandler();
          }
        }
      }
    }
    localObject = paramAppInterface;
    if (paramAppInterface == null) {
      localObject = new ResDownloadHandler.DefaultRDHandler();
    }
    this.b[i] = localObject;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadHandler
 * JD-Core Version:    0.7.0.1
 */