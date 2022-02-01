package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.doodle.IDoodlePanelHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class DoodlePanelLifeHelper
  implements OnFinishListener, ILifeCycleHelper, AbsListView.OnScrollListener
{
  private AIOContext a;
  
  DoodlePanelLifeHelper(AIOContext paramAIOContext, CoreHelperProvider paramCoreHelperProvider)
  {
    this.a = paramAIOContext;
    paramCoreHelperProvider.a(this);
  }
  
  private void a()
  {
    BaseDoodlePanel localBaseDoodlePanel = (BaseDoodlePanel)this.a.a().b(18);
    if (localBaseDoodlePanel != null) {
      localBaseDoodlePanel.b();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public boolean a(int paramInt)
  {
    ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).destroyCache();
    BaseDoodlePanel localBaseDoodlePanel = (BaseDoodlePanel)this.a.a().b(18);
    if (localBaseDoodlePanel == null) {
      return false;
    }
    if (paramInt == 0) {
      return localBaseDoodlePanel.a();
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    BaseDoodlePanel localBaseDoodlePanel = (BaseDoodlePanel)this.a.a().b(18);
    if (localBaseDoodlePanel == null) {
      return false;
    }
    return localBaseDoodlePanel.a();
  }
  
  public void d(int paramInt)
  {
    ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).destroy();
  }
  
  @NonNull
  public String getTag()
  {
    return "DoodlePanelLifeHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (ChatXListView)paramAbsListView;
    int j = ((ChatXListView)localObject).getFooterViewsCount();
    int k = ((ChatXListView)localObject).getHeaderViewsCount();
    localObject = (IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class);
    int i;
    if (paramAbsListView.getChildAt(0) != null) {
      i = paramAbsListView.getChildAt(0).getTop();
    } else {
      i = 0;
    }
    ((IDoodlePanelHelper)localObject).setScrollData(paramInt1, paramInt2, k, j, paramInt3, i, paramAbsListView.getWidth(), paramAbsListView.getHeight());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).setScrollState(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DoodlePanelLifeHelper
 * JD-Core Version:    0.7.0.1
 */