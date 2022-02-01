package com.tencent.biz.qqcircle.immersive.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import java.util.List;

public abstract class QFSBaseTabFragment
  extends QFSBaseFragment
{
  private boolean c;
  protected final QCircleTabInfo u;
  protected int v;
  protected boolean w;
  
  protected QFSBaseTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    this.u = paramQCircleTabInfo;
    this.v = paramInt;
    X();
  }
  
  public static QFSBaseTabFragment a(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    if (paramQCircleTabInfo == null) {
      return null;
    }
    int i = paramQCircleTabInfo.a();
    if (i != 1)
    {
      if (i != 4)
      {
        if (i != 6) {
          return new QFSSimpleTabFragment(paramQCircleTabInfo, paramInt);
        }
        return new QFSRecommendTabFragment(paramQCircleTabInfo, paramInt);
      }
      return new QFSNearbyTabFragment(paramQCircleTabInfo, paramInt);
    }
    return new QFSFollowTabFragment(paramQCircleTabInfo, paramInt);
  }
  
  private void u()
  {
    boolean bool = QCircleReportHelper.getInstance().isLaunchFromFolderPage();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(" onAttach isLaunchFromFolderPage:");
    ((StringBuilder)localObject).append(bool);
    QLog.d("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
    if ((bool) && (aa()))
    {
      localObject = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(((QCircleInitBean)localObject).getLaunchFrom(), ((QCircleInitBean)localObject).getLaunchId(), ((QCircleInitBean)localObject).getUin(), a(), ((QCircleInitBean)localObject).getSchemeAttrs()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" launchPageId:");
      ((StringBuilder)localObject).append(a());
      QLog.d("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public abstract void B();
  
  public abstract void L();
  
  public abstract void M();
  
  public QCircleTabInfo W()
  {
    return this.u;
  }
  
  public void X() {}
  
  public void Y()
  {
    this.w = false;
  }
  
  public boolean Z()
  {
    return this.w;
  }
  
  public abstract void a(int paramInt);
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public abstract void a(IQFSTabFragmentIoc paramIQFSTabFragmentIoc);
  
  public abstract void a(Boolean paramBoolean);
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean aa()
  {
    return this.c;
  }
  
  public void bm_() {}
  
  protected abstract List<Part> d();
  
  protected void l() {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    u();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d(b(), 1, "init success QFSBaseTabFragment");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QCircleReportHelper.getInstance().pushPageScene(a());
      QCircleReportHelper.getInstance().recordPageStartShow(a());
      return;
    }
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
    QCircleReportHelper.getInstance().popPageScene(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */