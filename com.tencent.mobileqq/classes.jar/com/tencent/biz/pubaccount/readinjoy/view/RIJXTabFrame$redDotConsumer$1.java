package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.IRIJXTabNormalRedDotConsumer;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$redDotConsumer$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJXTabNormalRedDotConsumer;", "beforeShowingRedDot", "", "info", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "showRedDot", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$redDotConsumer$1
  implements IRIJXTabNormalRedDotConsumer
{
  public void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    boolean bool = false;
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    if (!RIJXTabFrameUtils.a.a()) {}
    do
    {
      return;
      RIJXTabNormalRedDotStore.a.a();
      paramRIJXTabRedDotInfo = this.a.a().a();
    } while (paramRIJXTabRedDotInfo == null);
    int i = paramRIJXTabRedDotInfo.mChannelCoverId;
    if (RIJXTabNormalRedDotStore.a.a(i, false) != null) {
      bool = true;
    }
    QLog.d(this.a.a(), 1, "beforeShowingRedDot: " + bool);
  }
  
  public void b(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    RIJXTabFrame.a(this.a).a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame.redDotConsumer.1
 * JD-Core Version:    0.7.0.1
 */