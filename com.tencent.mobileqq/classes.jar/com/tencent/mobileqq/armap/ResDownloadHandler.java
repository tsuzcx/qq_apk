package com.tencent.mobileqq.armap;

import com.tencent.av.redpacket.config.AVRedPacketRDHandler;
import com.tencent.avgame.gamelogic.gameres.AvGameResHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.ARPromotionRDHandler;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResHandler;

public class ResDownloadHandler
{
  public static final String a;
  public ResDownloadHandler.RDHandler[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ResDownloadManager.class.getSimpleName() + "." + ResDownloadHandler.class.getSimpleName();
  }
  
  public ResDownloadHandler()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler = new ResDownloadHandler.RDHandler[8];
  }
  
  public ResDownloadHandler.RDHandler a(AppInterface paramAppInterface, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 8) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler[i];
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null)
    {
      paramAppInterface = (AppInterface)localObject;
      switch (i)
      {
      default: 
        paramAppInterface = (AppInterface)localObject;
      }
    }
    for (;;)
    {
      localObject = paramAppInterface;
      if (paramAppInterface == null) {
        localObject = new ResDownloadHandler.DefaultRDHandler();
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler[i] = localObject;
      return localObject;
      paramAppInterface = new AVRedPacketRDHandler();
      continue;
      paramAppInterface = new ARPromotionRDHandler();
      continue;
      paramAppInterface = new AvGameResHandler();
      continue;
      paramAppInterface = new TroopGameCardResHandler();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadHandler
 * JD-Core Version:    0.7.0.1
 */