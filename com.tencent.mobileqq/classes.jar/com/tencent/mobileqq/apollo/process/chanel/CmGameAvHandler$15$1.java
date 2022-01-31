package com.tencent.mobileqq.apollo.process.chanel;

import airo;
import ajae;
import ajbc;
import ajbf;
import ajch;
import ajlc;
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
  public CmGameAvHandler$15$1(ajbf paramajbf, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      ajbc.c(this.jdField_a_of_type_Ajbf.a, true);
      this.jdField_a_of_type_Ajbf.a.a = new airo(ajae.b(ajbc.a(this.jdField_a_of_type_Ajbf.a)).a(), ajbc.a(this.jdField_a_of_type_Ajbf.a));
      this.jdField_a_of_type_Ajbf.a.a.a();
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Ajbf.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localGraphicRendererMgr));
      ajlc.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder(localGraphicRendererMgr, localSurfaceHolder);
      ajae.a().callbackFromRequest(ajbc.a(this.jdField_a_of_type_Ajbf.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */