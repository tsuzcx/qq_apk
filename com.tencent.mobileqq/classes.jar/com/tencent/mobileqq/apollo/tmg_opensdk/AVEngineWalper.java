package com.tencent.mobileqq.apollo.tmg_opensdk;

import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
import java.util.HashMap;
import java.util.Map;
import zbv;
import zbx;
import zby;
import zca;
import zcb;
import zcc;
import zcd;

public class AVEngineWalper
{
  static AVEngineWalper jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper;
  int jdField_a_of_type_Int = 0;
  public Context a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new zcc(this);
  private AVManager.RoomInfoListener jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$RoomInfoListener = new zcd(this);
  TMG_DownloadInfo jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo;
  public AVEngineEventHandler a;
  public String a;
  public Map a;
  private boolean jdField_a_of_type_Boolean;
  
  private AVEngineWalper()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static AVEngineWalper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper == null) {
      jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper = new AVEngineWalper();
    }
    return jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper;
  }
  
  private void d()
  {
    TMG_Downloader.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo, new zbv(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a();
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo = new TMG_DownloadInfo(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, TMGProformanceHelper.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$RoomInfoListener);
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new AVManager.AppInfo();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(AVEngineEventHandler paramAVEngineEventHandler)
  {
    this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler = paramAVEngineEventHandler;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new zbx(this));
  }
  
  public void a(boolean paramBoolean)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new zca(this));
  }
  
  public boolean a()
  {
    try
    {
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      int i = localGraphicRendererMgr.getRecvDecoderFrameFunctionptr();
      QLog.e("AVEngineWalper", 1, "mgr=" + String.valueOf(localGraphicRendererMgr) + ", nFunID=" + String.valueOf(i));
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AVEngineWalper", 1, "CheckGraphicMgrStart stack=" + QLog.getStackTraceString(localThrowable));
    }
    return false;
  }
  
  public void b()
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    SSOTunnelEvent.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new zby(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new zcb(this));
  }
  
  public void c()
  {
    AVManager.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper
 * JD-Core Version:    0.7.0.1
 */