package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.ICMResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Makeup3DJsModule$1
  implements IApolloResManager.ApolloDressInfoListener
{
  Makeup3DJsModule$1(Makeup3DJsModule paramMakeup3DJsModule, Map paramMap, String paramString1, String paramString2) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleCmShowInit3DAvatar] onGetApolloDressInfo: ");
    ((StringBuilder)localObject).append(paramHashMap);
    ((StringBuilder)localObject).append(", errMsg: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("[cmshow]Makeup3DJsModule", 1, ((StringBuilder)localObject).toString());
    paramString = new CmShowAssetsData();
    if (paramHashMap != null)
    {
      localObject = this.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramString.b.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
    }
    ((ICMResManager)ApolloIPCModule.a(ICMResManager.class)).a(this.b, 1, new Makeup3DJsModule.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.1
 * JD-Core Version:    0.7.0.1
 */