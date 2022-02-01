package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stOpVideo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.BaseApplication;

public class WSVerticalItemCenterBottomController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private KandianUrlImageView g;
  private TextView h;
  private stSimpleMetaFeed i;
  private stOpVideo j;
  private WSVerticalPageFragment k;
  
  public WSVerticalItemCenterBottomController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.k = paramWSVerticalVideoHolder.d;
    }
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = WSVerticalUtils.a(paramWSVerticalPageFragment.k());
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void l()
  {
    if (this.j != null)
    {
      String str2 = this.k.k();
      String str3 = this.k.l();
      WSStSchemaJumpManager localWSStSchemaJumpManager = new WSStSchemaJumpManager(d()).a(this.j.jump);
      WSVerticalPageFragment localWSVerticalPageFragment = this.k;
      String str1;
      if (this.j.jump != null) {
        str1 = this.j.jump.schema;
      } else {
        str1 = "";
      }
      localWSStSchemaJumpManager.a(a(localWSVerticalPageFragment, 17, str1)).a(new WSVerticalItemCenterBottomController.1(this, str2, str3)).j();
    }
  }
  
  protected void a() {}
  
  protected void b()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      this.i = ((WSVerticalItemData)localObject).b();
      this.j = this.i.opVideo;
      localObject = this.j;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((stOpVideo)localObject).img_url))
        {
          localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130842687);
          WSPicLoader.a().a(this.g, this.j.img_url, (Drawable)localObject);
          WSVerticalBeaconReport.a(this.i, this.k.k(), this.k.l());
        }
        if (!TextUtils.isEmpty(this.j.text)) {
          this.h.setText(this.j.text);
        }
      }
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626083;
  }
  
  protected void j()
  {
    this.g = ((KandianUrlImageView)c(2131436663));
    this.h = ((TextView)c(2131448884));
    this.g.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436663) {
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemCenterBottomController
 * JD-Core Version:    0.7.0.1
 */