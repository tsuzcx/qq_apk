package com.tencent.mobileqq.apollo.process.chanel;

import akix;
import akro;
import aksm;
import aksp;
import aktr;
import alcm;
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
  public CmGameAvHandler$15$1(aksp paramaksp, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      aksm.c(this.jdField_a_of_type_Aksp.a, true);
      this.jdField_a_of_type_Aksp.a.a = new akix(akro.b(aksm.a(this.jdField_a_of_type_Aksp.a)).a(), aksm.a(this.jdField_a_of_type_Aksp.a));
      this.jdField_a_of_type_Aksp.a.a.a();
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Aksp.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localGraphicRendererMgr));
      alcm.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder(localGraphicRendererMgr, localSurfaceHolder);
      akro.a().callbackFromRequest(aksm.a(this.jdField_a_of_type_Aksp.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */