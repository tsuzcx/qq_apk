package com.tencent.mobileqq.apollo.process.chanel;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameAvHandler$15$1
  implements Runnable
{
  CmGameAvHandler$15$1(CmGameAvHandler.15 param15, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      CmGameAvHandler.c(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a, true);
      Object localObject = CmGameUtil.b(CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a));
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a.a = new AVCameraCaptureModel(((CmGameLauncher)localObject).a(), CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a));
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a.a.a();
      }
      localObject = GraphicRendererMgr.getInstance();
      SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a.a.a.getHolder();
      QLog.e("onSDKEnterRoom", 1, "onSDKEnterRoom mgr=" + String.valueOf(localObject));
      AVManager.a(BaseApplicationImpl.getContext()).a().setRenderMgrAndHolder((GraphicRendererMgr)localObject, localSurfaceHolder);
      CmGameUtil.a().callbackFromRequest(CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler$15.a), this.jdField_a_of_type_Int, "cs.audioRoom_enter.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1
 * JD-Core Version:    0.7.0.1
 */