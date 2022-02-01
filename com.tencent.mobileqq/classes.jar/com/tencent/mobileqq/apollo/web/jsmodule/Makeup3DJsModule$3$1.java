package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class Makeup3DJsModule$3$1
  implements Runnable
{
  Makeup3DJsModule$3$1(Makeup3DJsModule.3 param3, String paramString) {}
  
  public void run()
  {
    Object localObject = ApolloResManagerFacade.a.a(Scene.MAKE_UP_3D).b(this.a);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] fileJsonFilePath is null!");
      this.b.c.a(this.b.a, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] file face.json is not exists!");
      this.b.c.a(this.b.a, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(ApolloConstant.b, new JSONObject((String)localObject));
        this.b.c.a(this.b.a, localJSONObject);
        return;
      }
      this.b.c.a(this.b.a, "file face.json is empty!");
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] file face.json is empty!");
      return;
    }
    catch (Exception localException)
    {
      this.b.c.a(this.b.a, localException.getMessage());
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] read file face.json error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.3.1
 * JD-Core Version:    0.7.0.1
 */