package com.tencent.biz.pubaccount.readinjoy.viola.components;

import android.content.Context;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tuy;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationComponent;", "Lcom/tencent/viola/ui/baseComponent/VComponent;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationView;", "instance", "Lcom/tencent/viola/core/ViolaInstance;", "dom", "Lcom/tencent/viola/ui/dom/DomObject;", "parent", "Lcom/tencent/viola/ui/baseComponent/VComponentContainer;", "(Lcom/tencent/viola/core/ViolaInstance;Lcom/tencent/viola/ui/dom/DomObject;Lcom/tencent/viola/ui/baseComponent/VComponentContainer;)V", "destroy", "", "initComponentHostView", "context", "Landroid/content/Context;", "initHostView", "hostView", "isReuse", "", "onActivityDestroy", "onActivityPause", "onActivityResume", "pause", "play", "removedByDiff", "removedByJs", "resume", "stop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoAnimationComponent
  extends VComponent<VideoAnimationView>
{
  @NotNull
  public static final String AUTO_PLAY = "isAutoPlay";
  public static final tuy Companion = new tuy(null);
  
  public VideoAnimationComponent(@NotNull ViolaInstance paramViolaInstance, @NotNull DomObject paramDomObject, @NotNull VComponentContainer<?> paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private final void initHostView(VideoAnimationView paramVideoAnimationView)
  {
    boolean bool = true;
    Object localObject = getDomObject();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "domObject");
    if (((DomObject)localObject).getAttributes().containsKey("isAutoPlay"))
    {
      localObject = getDomObject();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "domObject");
      bool = ViolaUtils.getBoolean(((DomObject)localObject).getAttributes().get("isAutoPlay"));
    }
    localObject = getDomObject();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "domObject");
    localObject = ViolaUtils.getString(((DomObject)localObject).getAttributes().get("src"), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViolaUtils.getString(dom…ct.attributes[\"src\"], \"\")");
    DomObject localDomObject = getDomObject();
    Intrinsics.checkExpressionValueIsNotNull(localDomObject, "domObject");
    paramVideoAnimationView.a(bool, (String)localObject, ViolaUtils.getBoolean(localDomObject.getAttributes().get("loop")));
  }
  
  public void destroy()
  {
    super.destroy();
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.e();
    }
  }
  
  @NotNull
  protected VideoAnimationView initComponentHostView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new VideoAnimationView(paramContext);
    paramContext.a(this);
    initHostView(paramContext);
    return paramContext;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.e();
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    pause();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    resume();
  }
  
  @JSMethod
  public final void pause()
  {
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.b();
    }
  }
  
  @JSMethod
  public final void play()
  {
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.a();
    }
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.e();
    }
  }
  
  public void removedByJs()
  {
    super.removedByJs();
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.e();
    }
  }
  
  @JSMethod
  public final void resume()
  {
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.c();
    }
  }
  
  @JSMethod
  public final void stop()
  {
    VideoAnimationView localVideoAnimationView = (VideoAnimationView)getHostView();
    if (localVideoAnimationView != null) {
      localVideoAnimationView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.components.VideoAnimationComponent
 * JD-Core Version:    0.7.0.1
 */