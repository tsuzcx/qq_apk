package com.tencent.biz.qcircleshadow.lib;

import bnkt;
import bnky;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone;
import vve;

public class QCircleHostAEHelper
{
  public static void addListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    vve.a().a(paramQCircleAEEditorGenerateResultListener);
  }
  
  public static void addUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    vve.a().a(paramQCircleAEEditorUICallbackListener);
  }
  
  public static void cancelMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().cancelMission(paramString);
  }
  
  public static boolean checkAEResVersionOKForAEBasePackage()
  {
    return bnky.a(bnkt.b);
  }
  
  public static LocalMediaInfo getMissionInfo(String paramString)
  {
    return AEEditorManagerForQzone.getInstance().getMissionInfo(paramString);
  }
  
  public static void initAEEditorManagerForQzone()
  {
    AEEditorManagerForQzone.getInstance().init();
  }
  
  public static void removeListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    vve.a().b(paramQCircleAEEditorGenerateResultListener);
  }
  
  public static void removeUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    vve.a().b(paramQCircleAEEditorUICallbackListener);
  }
  
  public static void retryMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().retryMission(paramString);
  }
  
  public static void saveMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().saveMission(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper
 * JD-Core Version:    0.7.0.1
 */