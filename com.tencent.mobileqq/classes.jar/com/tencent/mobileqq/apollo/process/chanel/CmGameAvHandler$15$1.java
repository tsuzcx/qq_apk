package com.tencent.mobileqq.apollo.process.chanel;

import airm;
import ajac;
import ajba;
import ajbd;
import ajcf;
import ajla;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameAvHandler$15$1
  implements Runnable
{
  public CmGameAvHandler$15$1(ajbd paramajbd, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      ajba.c(this.jdField_a_of_type_Ajbd.a, true);
      this.jdField_a_of_type_Ajbd.a.a = new airm(ajac.b(ajba.a(this.jdField_a_of_type_Ajbd.a)).a(), ajba.a(this.jdField_a_of_type_Ajbd.a));
      this.jdField_a_of_type_Ajbd.a.a.a();
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Ajbd.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localGraphicRendererMgr));
      ajla.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder(localGraphicRendererMgr, localSurfaceHolder);
      ajac.a().callbackFromRequest(ajba.a(this.jdField_a_of_type_Ajbd.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */