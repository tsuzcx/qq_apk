package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import java.util.HashMap;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

public class WSVerticalItemBottomCommentController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private AbsWSVideoItemView g;
  private WSVerticalPageFragment h;
  private TextView i;
  private View j;
  private ImageView k;
  private KandianUrlImageView l;
  private VasPagView m;
  private stSimpleMetaFeed n;
  
  public WSVerticalItemBottomCommentController(Context paramContext, AbsWSVideoItemView paramAbsWSVideoItemView)
  {
    super(paramContext);
    this.g = paramAbsWSVideoItemView;
    if (paramAbsWSVideoItemView.f != null) {
      this.h = paramAbsWSVideoItemView.f.d;
    }
  }
  
  private void a(int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.h;
    if ((localWSVerticalPageFragment != null) && (localWSVerticalPageFragment.f != null))
    {
      this.h.f.a(WSVerticalBeaconReport.c(this.h.k()), this.h.l());
      this.h.f.a(h());
      this.h.f.a(this.n);
      this.h.f.a(paramInt1, paramInt2, this.h.l(), paramMap);
    }
  }
  
  private void a(PAGView paramPAGView, PAGView.PAGViewListener paramPAGViewListener)
  {
    PAGFile localPAGFile = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "wspag/ws_comment_at_guide.pag");
    if (localPAGFile != null)
    {
      paramPAGView.setVisibility(0);
      paramPAGView.setComposition(localPAGFile);
      paramPAGView.setRepeatCount(1);
      paramPAGView.addListener(new WSVerticalItemBottomCommentController.6(this, paramPAGViewListener));
      paramPAGView.play();
      q();
    }
  }
  
  private void b(View paramView)
  {
    l();
    AbsWSVideoItemView localAbsWSVideoItemView = this.g;
    if ((localAbsWSVideoItemView instanceof WSVerticalVideoOperationRightItemView)) {
      ((WSVerticalVideoOperationRightItemView)localAbsWSVideoItemView).onClick(paramView);
    }
    a(0, 8, d(1));
  }
  
  private Map<String, String> d(int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (WSVerticalPageContract.Presenter)((WSVerticalPageFragment)localObject).aO_();
      if (localObject != null)
      {
        localObject = ((WSVerticalPageContract.Presenter)localObject).n();
        break label39;
      }
    }
    localObject = new HashMap();
    label39:
    if (paramInt != -1) {
      ((Map)localObject).put("btn_status", String.valueOf(paramInt));
    }
    return localObject;
  }
  
  private void m()
  {
    if (WSCommentAtHelper.a.b())
    {
      this.l.setVisibility(0);
      this.m.setVisibility(0);
      String str = WSCommentAtHelper.a.c();
      WSPicLoader.a().a(this.l, str, WSFeedUtils.f(2130853547));
    }
    else
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
    }
    l();
  }
  
  private void n()
  {
    a(0, 8, d(0));
  }
  
  private void o()
  {
    a(0, 4, d(-1));
  }
  
  private void p()
  {
    a(1, 7, d(-1));
  }
  
  private void q()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (WSVerticalPageContract.Presenter)((WSVerticalPageFragment)localObject).aO_();
      if (localObject != null) {
        localObject = ((WSVerticalPageContract.Presenter)localObject).n();
      } else {
        localObject = new HashMap();
      }
      WSVerticalBeaconReport.b(this.h.k(), this.h.l(), this.n, (Map)localObject);
    }
  }
  
  protected void a()
  {
    if (c() != null) {
      this.n = ((WSVerticalItemData)c()).b();
    }
  }
  
  public void a(PAGView.PAGViewListener paramPAGViewListener)
  {
    this.m.g().a(new WSVerticalItemBottomCommentController.5(this, paramPAGViewListener));
  }
  
  protected void b()
  {
    String str = WSGlobalConfig.a().p();
    if (!TextUtils.isEmpty(str)) {
      this.i.setText(str);
    }
    m();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626078;
  }
  
  protected void j()
  {
    this.i = ((TextView)c(2131448340));
    this.j = c(2131439658);
    this.j.setOnClickListener(new WSVerticalItemBottomCommentController.1(this));
    this.k = ((ImageView)c(2131436294));
    this.k.setOnClickListener(new WSVerticalItemBottomCommentController.2(this));
    this.l = ((KandianUrlImageView)c(2131436293));
    this.l.setOnClickListener(new WSVerticalItemBottomCommentController.3(this));
    this.m = ((VasPagView)c(2131439781));
    this.m.g().a();
    this.m.setOnClickListener(new WSVerticalItemBottomCommentController.4(this));
  }
  
  public void l()
  {
    this.m.g().a(new WSVerticalItemBottomCommentController.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCommentController
 * JD-Core Version:    0.7.0.1
 */