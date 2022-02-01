package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotReporter;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.mobileqq.app.FrameFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$mObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "onChannelListRedPointupdate", "", "hasRedPoint", "", "onXTabRedDotExposure", "info", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$mObserver$1
  extends ReadInJoyObserver
{
  public void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    FrameFragment localFrameFragment = this.a.a();
    if ((localFrameFragment != null) && (localFrameFragment.isVisible() == true)) {
      RIJXTabNormalRedDotReporter.a(paramRIJXTabRedDotInfo);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RIJXTabFrame.a(this.a).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame.mObserver.1
 * JD-Core Version:    0.7.0.1
 */