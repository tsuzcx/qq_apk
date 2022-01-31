package com.tencent.mobileqq.armap;

import com.tencent.av.redpacket.config.AVRedPacketRDHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.armap.config.ARMapRDHandler;
import com.tencent.mobileqq.armap.config.PreloadMapRDHandler;

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
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler = new ResDownloadHandler.RDHandler[5];
  }
  
  public ResDownloadHandler.RDHandler a(AppInterface paramAppInterface, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 5) {}
    }
    else
    {
      i = 0;
    }
    ResDownloadHandler.RDHandler localRDHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler[i];
    Object localObject = localRDHandler;
    if (localRDHandler == null) {
      switch (i)
      {
      default: 
        localObject = localRDHandler;
      }
    }
    for (;;)
    {
      paramAppInterface = (AppInterface)localObject;
      if (localObject == null) {
        paramAppInterface = new ResDownloadHandler.DefaultRDHandler();
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqArmapResDownloadHandler$RDHandler[i] = paramAppInterface;
      return paramAppInterface;
      localObject = new ARMapRDHandler(paramAppInterface);
      continue;
      localObject = new PreloadMapRDHandler();
      continue;
      localObject = new AVRedPacketRDHandler();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadHandler
 * JD-Core Version:    0.7.0.1
 */