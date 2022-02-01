package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSShowFeedDebugEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.LocalMultiProcConfig;

class QCirclePluginDebugPart$1
  implements ActionSheet.OnButtonClickListener
{
  QCirclePluginDebugPart$1(QCirclePluginDebugPart paramQCirclePluginDebugPart, ActionSheet paramActionSheet, SharedPreferences paramSharedPreferences) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.d(paramInt);
    SharedPreferences.Editor localEditor = this.b.edit();
    if (paramView.startsWith(this.c.g().getResources().getString(2131895683)))
    {
      QCircleLauncher.b(HostUIHelper.getInstance().getHostApplicationContext());
    }
    else if (paramView.startsWith(this.c.g().getResources().getString(2131895682)))
    {
      QCircleLauncher.c(this.c.g());
    }
    else if (this.c.g().getResources().getString(2131895684).equals(paramView))
    {
      localEditor.putBoolean("qcircle_is_net_open", false);
      localEditor.commit();
    }
    else if (this.c.g().getResources().getString(2131895685).equals(paramView))
    {
      localEditor.putBoolean("qcircle_is_net_open", true);
      localEditor.commit();
    }
    else if (this.c.g().getResources().getString(2131895687).equals(paramView))
    {
      UploadServiceBuilder.getInstance().setDebugServerRoute(DebugServerRoute.DEBUG8);
    }
    else if (this.c.g().getResources().getString(2131895644).equals(paramView))
    {
      UploadServiceBuilder.getInstance().setDebugServerRoute(DebugServerRoute.DEV);
    }
    else if (this.c.g().getResources().getString(2131895678).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_NEW_LAYER", true).commit();
    }
    else if (this.c.g().getResources().getString(2131895666).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_NEW_LAYER", false).commit();
    }
    else if (this.c.g().getResources().getString(2131895679).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_NEW_PUBLISH", true).commit();
    }
    else if (this.c.g().getResources().getString(2131895668).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_NEW_PUBLISH", false).commit();
    }
    else if (this.c.g().getResources().getString(2131895671).equals(paramView))
    {
      LocalMultiProcConfig.putBool("SP_KEY_OPEN_IMAGE_EDIT_MODE", true);
    }
    else if (this.c.g().getResources().getString(2131895672).equals(paramView))
    {
      LocalMultiProcConfig.putBool("SP_KEY_OPEN_IMAGE_EDIT_MODE", false);
    }
    else if (this.c.g().getResources().getString(2131895674).equals(paramView))
    {
      localEditor.putBoolean("qcircle_force_enable_floatlayer_flutter", true);
      localEditor.commit();
    }
    else if (this.c.g().getResources().getString(2131895686).equals(paramView))
    {
      localEditor.putBoolean("qcircle_force_enable_floatlayer_flutter", false);
      localEditor.commit();
    }
    else if (paramView.contains("卡顿检测"))
    {
      boolean bool = paramView.startsWith("开启");
      localEditor.putBoolean("SP_KEY_IS_BLOCK_CHECK_OPEN", bool);
      localEditor.commit();
      if (bool) {
        QCircleBlockCheckListBlock.tryInjectBlockLooperListener();
      } else {
        QCircleBlockCheckListBlock.clearBlockLooperListener();
      }
    }
    else if (this.c.g().getResources().getString(2131895664).equals(paramView))
    {
      CacheHelper.fileCache().clear();
    }
    else if ("显示贴纸范围".equals(paramView))
    {
      QCirclePluginDebugPart.a(this.c, this.b, true);
    }
    else if ("取消贴纸范围显示".equals(paramView))
    {
      QCirclePluginDebugPart.a(this.c, this.b, false);
    }
    else if (this.c.g().getResources().getString(2131895677).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_RE_RANK", true);
      localEditor.apply();
    }
    else if (this.c.g().getResources().getString(2131895670).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_OPEN_RE_RANK", false);
      localEditor.apply();
    }
    else if (this.c.g().getResources().getString(2131895676).equals(paramView))
    {
      LocalMultiProcConfig.putBool("SP_KEY_IS_PUBLISH_MATERIAL_TEST_OPEN", true);
    }
    else if (this.c.g().getResources().getString(2131895669).equals(paramView))
    {
      LocalMultiProcConfig.putBool("SP_KEY_IS_PUBLISH_MATERIAL_TEST_OPEN", false);
    }
    else if (this.c.g().getResources().getString(2131895675).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_GLOBAL_FEED_CENTER", true);
      localEditor.apply();
    }
    else if (this.c.g().getResources().getString(2131895667).equals(paramView))
    {
      localEditor.putBoolean("SP_KEY_GLOBAL_FEED_CENTER", false);
      localEditor.apply();
    }
    else if (this.c.g().getString(2131895901).equals(paramView))
    {
      QCirclePluginDebugPart.a(this.c);
    }
    else if (paramView.equals(this.c.g().getString(2131896238)))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QFSShowFeedDebugEvent(true));
    }
    else if (paramView.equals(this.c.g().getString(2131896223)))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QFSShowFeedDebugEvent(false));
    }
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePluginDebugPart.1
 * JD-Core Version:    0.7.0.1
 */