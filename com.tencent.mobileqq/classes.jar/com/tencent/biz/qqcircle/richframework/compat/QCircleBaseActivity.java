package com.tencent.biz.qqcircle.richframework.compat;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.part.IRecyclerViewPoolProvider;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.io.File;
import java.util.ArrayList;

public class QCircleBaseActivity
  extends CompatPublicActivity
  implements IRecyclerViewPoolProvider
{
  private Handler a;
  private RecyclerView.RecycledViewPool d;
  
  private void a()
  {
    boolean bool = QCircleSkinHelper.getInstance().isOldSkinPackageExist();
    if (QCircleSkinHelper.getInstance().isSkinPackageExist("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87006.skin"))
    {
      QCircleSkinHelper.getInstance().loadSkin(RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87006.skin"));
      QCircleSkinHelper.getInstance().setNeedReloadSkin(false);
      return;
    }
    QCircleSkinHelper.getInstance().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87006.skin", new QCircleBaseActivity.SkinDownloadListener(null));
    if (bool)
    {
      QCircleSkinHelper.getInstance().loadSkin(QCircleSkinHelper.getInstance().getOldSkinPath());
      QCircleSkinHelper.getInstance().setNeedReloadSkin(true);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QCircleConstants.g);
    ((StringBuilder)localObject).append("darkmode.skin");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installLocalSkinPackage start time = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("ComponentBaseActivity", 1, localStringBuilder.toString());
      bool = QCircleSkinHelper.getInstance().installLocalSkinPackage((String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("installLocalSkinPackage end time = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("success = ");
      localStringBuilder.append(bool);
      QLog.d("ComponentBaseActivity", 1, localStringBuilder.toString());
    }
    QCircleSkinHelper.getInstance().loadSkin((String)localObject);
    QCircleSkinHelper.getInstance().setNeedReloadSkin(true);
  }
  
  private static boolean b(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (!QCircleSkinHelper.getInstance().isOldSkinPackageExist()) && (new File(paramString).exists());
  }
  
  private void i()
  {
    QCircleSkinHelper.getInstance().resetDefaultSkin();
    QCircleSkinHelper.getInstance().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87006.skin", null);
  }
  
  private void j()
  {
    int i = QCircleConfigHelper.a("qqcircle", "MinKeepCachePluginVersionCode", Integer.valueOf(0)).intValue();
    try
    {
      int j = ((Integer)QCircleSpUtil.b("SP_KEY_CLEAR_DOWN_PLUGIN_VERSION_CODE", Integer.valueOf(1))).intValue();
      if (j < i)
      {
        QLog.i("ComponentBaseActivity", 1, String.format("checkIsNeedClearCache:true, currentVersion:%d, targetVersion:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        CacheHelper.fileCache().clear();
        QCircleSpUtil.a("SP_KEY_CLEAR_DOWN_PLUGIN_VERSION_CODE", Integer.valueOf(i));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public Handler d()
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper());
    }
    return this.a;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public RecyclerView.RecycledViewPool e()
  {
    if (this.d == null) {
      this.d = new RecyclerView.RecycledViewPool();
    }
    return this.d;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HostActivityResultEvent.class);
    return localArrayList;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    QCircleConfigChangeEvent localQCircleConfigChangeEvent = new QCircleConfigChangeEvent();
    localQCircleConfigChangeEvent.configuration = paramConfiguration;
    SimpleEventBus.getInstance().dispatchEvent(localQCircleConfigChangeEvent);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j();
    QCirclePluginGlobalInfo.f();
    QCircleSkinHelper.getInstance().setContext(QCircleApplication.APP);
    if (QCircleCommonUtil.isInNightMode())
    {
      a();
      return;
    }
    i();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QCirclePluginGlobalInfo.g();
    QCirclePluginGlobalInfo.a(false);
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof HostActivityResultEvent))
    {
      paramSimpleBaseEvent = (HostActivityResultEvent)paramSimpleBaseEvent;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(": onActivityResult receive event, currentHashCode:");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(",hostHashCode:");
      localStringBuilder.append(getBaseContext().hashCode());
      localStringBuilder.append(", shadowHashCode:");
      localStringBuilder.append(paramSimpleBaseEvent.getShadowTopContextHashCode());
      QLog.i("ComponentBaseActivity", 1, localStringBuilder.toString());
      onActivityResult(paramSimpleBaseEvent.getRequestCode(), paramSimpleBaseEvent.getResultCode(), paramSimpleBaseEvent.getIntent());
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity
 * JD-Core Version:    0.7.0.1
 */