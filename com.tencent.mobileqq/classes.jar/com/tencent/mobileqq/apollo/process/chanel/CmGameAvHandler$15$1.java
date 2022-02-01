package com.tencent.mobileqq.apollo.process.chanel;

import amsm;
import anbd;
import anbz;
import ancc;
import ande;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import anmc;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameAvHandler$15$1
  implements Runnable
{
  public CmGameAvHandler$15$1(ancc paramancc, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      anbz.c(this.jdField_a_of_type_Ancc.a, true);
      this.jdField_a_of_type_Ancc.a.a = new amsm(anbd.b(anbz.a(this.jdField_a_of_type_Ancc.a)).a(), anbz.a(this.jdField_a_of_type_Ancc.a));
      this.jdField_a_of_type_Ancc.a.a.a();
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_Ancc.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localGraphicRendererMgr));
      anmc.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder(localGraphicRendererMgr, localSurfaceHolder);
      anbd.a().callbackFromRequest(anbz.a(this.jdField_a_of_type_Ancc.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */