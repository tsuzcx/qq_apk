package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalItemAtPopGuideController;", "Lcom/tencent/biz/pubaccount/weishi_new/baseui/AbsWsUIGroup;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "context", "Landroid/content/Context;", "mVideoItemView", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;)V", "mPagAtPopGuide", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "getViewStubLayoutId", "", "hideAtPopGuideView", "", "initView", "onRecycle", "onReset", "onUpdateData", "onUpdateUI", "playPag", "pagView", "Lorg/libpag/PAGView;", "startAtPopGuideAnimation", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVerticalItemAtPopGuideController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  public static final WSVerticalItemAtPopGuideController.Companion g = new WSVerticalItemAtPopGuideController.Companion(null);
  private VasPagView h;
  private final AbsWSVideoItemView i;
  
  public WSVerticalItemAtPopGuideController(@NotNull Context paramContext, @NotNull AbsWSVideoItemView paramAbsWSVideoItemView)
  {
    super(paramContext);
    this.i = paramAbsWSVideoItemView;
  }
  
  private final void a(PAGView paramPAGView)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().resources");
    localObject = PAGFile.Load(((Resources)localObject).getAssets(), "wspag/ws_comment_at_pop_guide.pag");
    if (localObject != null)
    {
      paramPAGView.setVisibility(0);
      paramPAGView.setComposition((PAGComposition)localObject);
      paramPAGView.setRepeatCount(1);
      paramPAGView.play();
    }
  }
  
  protected void a() {}
  
  protected void b()
  {
    m();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626074;
  }
  
  protected void j()
  {
    Object localObject = c(2131439782);
    if (localObject != null)
    {
      this.h = ((VasPagView)localObject);
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
      }
      ((VasPagView)localObject).g().a();
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
      }
      ((VasPagView)localObject).setOnClickListener((View.OnClickListener)new WSVerticalItemAtPopGuideController.initView.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.ui.VasPagView");
  }
  
  public final void l()
  {
    VasPagView localVasPagView = this.h;
    if (localVasPagView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
    }
    localVasPagView.g().a((Function1)new WSVerticalItemAtPopGuideController.startAtPopGuideAnimation.1(this));
  }
  
  public final void m()
  {
    VasPagView localVasPagView = this.h;
    if (localVasPagView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
    }
    localVasPagView.g().a((Function1)WSVerticalItemAtPopGuideController.hideAtPopGuideView.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemAtPopGuideController
 * JD-Core Version:    0.7.0.1
 */