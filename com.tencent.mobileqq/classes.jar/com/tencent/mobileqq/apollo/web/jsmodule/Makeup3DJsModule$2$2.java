package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class Makeup3DJsModule$2$2
  implements Runnable
{
  Makeup3DJsModule$2$2(Makeup3DJsModule.2 param2, HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject1 = new JSONObject();
    try
    {
      Object localObject2 = this.b.b.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        int i = ((Integer)((Iterator)localObject2).next()).intValue();
        localObject3 = (String)this.a.get(Integer.valueOf(i));
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = ApolloResManagerFacade.a.a(Scene.MAKE_UP_3D).b((String)localObject3);
          boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
          if (bool)
          {
            QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] fileJsonFilePath is null!");
            this.b.g.a(this.b.c, "file face.json is not exists!");
            return;
          }
          localObject3 = new File((String)localObject3);
          if (((File)localObject3).exists())
          {
            localObject3 = FileUtils.readFileToString((File)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              ApolloUtilImpl.mergeJSON((JSONObject)localObject1, new JSONObject((String)localObject3));
            }
            else
            {
              QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] file face.json is empty!");
              this.b.g.a(this.b.c, "file face.json is empty!");
              Makeup3DJsModule.a(this.b.g, false, "file face.json is empty!");
            }
          }
          else
          {
            QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] file face.json is not exists!");
            this.b.g.a(this.b.c, "file face.json is not exists!");
          }
        }
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put(ApolloConstant.b, localObject1);
      localObject1 = Makeup3DJsModule.a(this.b.g);
      if (localObject1 != null)
      {
        localObject3 = new CmShowAssetsData();
        ((CmShowAssetsData)localObject3).c = ((JSONObject)localObject2).toString();
        ((IApolloJsCallBack)localObject1).a((CmShowAssetsData)localObject3, 0);
      }
      this.b.g.b(this.b.c);
      Makeup3DJsModule.a(this.b.g, true, "");
      return;
    }
    catch (Exception localException)
    {
      this.b.g.a(this.b.c, localException.getMessage());
      Makeup3DJsModule.a(this.b.g, false, localException.getMessage());
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] read file face.json error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.2.2
 * JD-Core Version:    0.7.0.1
 */