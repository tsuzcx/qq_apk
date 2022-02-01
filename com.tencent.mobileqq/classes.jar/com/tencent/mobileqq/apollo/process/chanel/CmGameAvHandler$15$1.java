package com.tencent.mobileqq.apollo.process.chanel;

import amlh;
import amwn;
import amxj;
import amxm;
import amyo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import anie;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameAvHandler$15$1
  implements Runnable
{
  public CmGameAvHandler$15$1(amxm paramamxm, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      amxj.c(this.jdField_a_of_type_Amxm.a, true);
      Object localObject = amwn.b(amxj.a(this.jdField_a_of_type_Amxm.a));
      if (localObject != null)
      {
        this.jdField_a_of_type_Amxm.a.a = new amlh(((amyo)localObject).a(), amxj.a(this.jdField_a_of_type_Amxm.a));
        this.jdField_a_of_type_Amxm.a.a.a();
      }
      localObject = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Amxm.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localObject));
      anie.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder((GraphicRendererMgr)localObject, localSurfaceHolder);
      amwn.a().callbackFromRequest(amxj.a(this.jdField_a_of_type_Amxm.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */