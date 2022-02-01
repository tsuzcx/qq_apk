package com.tencent.avgame.gamelogic.gameres;

import com.tencent.avgame.gamelogic.gameres.api.impl.ResDownloadManagerImpl;
import com.tencent.common.app.AppInterface;

public class ResDownloadHandler
{
  public static final String a;
  public ResDownloadHandler.RDHandler[] b = new ResDownloadHandler.RDHandler[2];
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ResDownloadManagerImpl.class.getSimpleName());
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
      if (paramInt <= 2) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.b[i];
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null) {
      if (i != 1) {
        paramAppInterface = (AppInterface)localObject;
      } else {
        paramAppInterface = new AvGameResHandler();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.ResDownloadHandler
 * JD-Core Version:    0.7.0.1
 */