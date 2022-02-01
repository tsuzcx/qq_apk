package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.ArrayList;

class AVPreloadEngine$1
  implements AVPreloadDispatcher.Callback
{
  AVPreloadEngine$1(AVPreloadEngine paramAVPreloadEngine, AVPreloadTaskInterface paramAVPreloadTaskInterface) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("StreamDispatcher onResponse is: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" url: ");
    ((StringBuilder)localObject).append(paramString);
    AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.1
 * JD-Core Version:    0.7.0.1
 */