package com.tencent.mobileqq.apollo.process.chanel;

import aiev;
import aing;
import aioe;
import aioh;
import aipj;
import aixa;
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
  public CmGameAvHandler$15$1(aioh paramaioh, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      aioe.c(this.jdField_a_of_type_Aioh.a, true);
      this.jdField_a_of_type_Aioh.a.a = new aiev(aing.b(aioe.a(this.jdField_a_of_type_Aioh.a)).a(), aioe.a(this.jdField_a_of_type_Aioh.a));
      this.jdField_a_of_type_Aioh.a.a.a();
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Aioh.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localGraphicRendererMgr));
      aixa.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder(localGraphicRendererMgr, localSurfaceHolder);
      aing.a().callbackFromRequest(aioe.a(this.jdField_a_of_type_Aioh.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */