package com.tencent.biz.expand.flutter;

import com.peterlmeng.animate_image.AnimateImagePlugin;
import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.peterlmeng.animate_image.support.log.ILog;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.Companion;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.QFlutterReporter;
import com.qflutter.qflutter_native_router.NativeRouter;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin.Companion;
import com.qflutter.qflutter_qtoast.QFlutterToast;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin.Companion;
import com.tencent.biz.expand.flutter.router.RouterManager;
import com.tencent.biz.expand.flutter.router.RouterManager.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/ExpandFlutterUtils;", "", "()V", "EXPAND_QFLUTTER_TAG", "", "PAG_TAG", "TAG", "animateImageLog", "com/tencent/biz/expand/flutter/ExpandFlutterUtils$animateImageLog$1", "Lcom/tencent/biz/expand/flutter/ExpandFlutterUtils$animateImageLog$1;", "apngRenderFactory", "com/tencent/biz/expand/flutter/ExpandFlutterUtils$apngRenderFactory$1", "apngRenderFactory$annotations", "Lcom/tencent/biz/expand/flutter/ExpandFlutterUtils$apngRenderFactory$1;", "mIsEnginePrepared", "", "getIsEnginePrepared", "initApng", "", "initNativeRouter", "initReporter", "initToast", "setEnginePrepared", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils
{
  private static final ExpandFlutterUtils.animateImageLog.1 jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$animateImageLog$1 = new ExpandFlutterUtils.animateImageLog.1();
  private static final ExpandFlutterUtils.apngRenderFactory.1 jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$apngRenderFactory$1;
  public static final ExpandFlutterUtils a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils = new ExpandFlutterUtils();
    jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$apngRenderFactory$1 = new ExpandFlutterUtils.apngRenderFactory.1();
  }
  
  public final void a()
  {
    RouterManager.a.a().a();
    QflutterNativeRouterPlugin.Companion.setRouter((NativeRouter)new ExpandFlutterUtils.initNativeRouter.1());
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public final void b()
  {
    QflutterQtoastPlugin.Companion.setToast((QFlutterToast)new ExpandFlutterUtils.initToast.1());
  }
  
  public final void c()
  {
    QflutterBeaconReporterPlugin.Companion.setReporter((QflutterBeaconReporterPlugin.QFlutterReporter)new ExpandFlutterUtils.initReporter.1());
  }
  
  public final void d()
  {
    AnimateImagePlugin.registerRenderFactory("png", (IRenderWorkerFactory)jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$apngRenderFactory$1);
    AnimateImagePlugin.registerRenderFactory("apng", (IRenderWorkerFactory)jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$apngRenderFactory$1);
    AnimateImagePlugin.setLog((ILog)jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterUtils$animateImageLog$1);
  }
  
  public final void e()
  {
    jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterUtils
 * JD-Core Version:    0.7.0.1
 */