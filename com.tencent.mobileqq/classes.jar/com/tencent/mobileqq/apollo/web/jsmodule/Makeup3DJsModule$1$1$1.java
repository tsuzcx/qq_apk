package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class Makeup3DJsModule$1$1$1
  implements Runnable
{
  Makeup3DJsModule$1$1$1(Makeup3DJsModule.1.1 param1) {}
  
  public void run()
  {
    Object localObject = ApolloResManagerFacade.a.a(Scene.MAKE_UP_3D).c(this.a.b.b);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] fileJsonFilePath is null!");
      this.a.b.d.a(this.a.b.c, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] file face.json is not exists!");
      this.a.b.d.a(this.a.b.c, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a.b.d.a(this.a.b.c, "file face.json is empty!");
        return;
      }
      IApolloJsCallBack localIApolloJsCallBack = Makeup3DJsModule.a(this.a.b.d);
      if (localIApolloJsCallBack == null)
      {
        this.a.b.d.a(this.a.b.c, "no apolloJsCallBack to handle this event!");
        QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] no apolloJsCallBack to handle this event!");
        return;
      }
      this.a.a.c = ((String)localObject);
      localIApolloJsCallBack.a(this.a.a, 3);
      this.a.b.d.b(this.a.b.c);
      return;
    }
    catch (Exception localException)
    {
      this.a.b.d.a(this.a.b.c, localException.getMessage());
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] read file face.json error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.1.1.1
 * JD-Core Version:    0.7.0.1
 */