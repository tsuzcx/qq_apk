package com.tencent.biz.qqcircle.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QCircleBaseListBlock<E, T>
  extends BaseListBlock<E, T>
  implements ReportBean<QCircleReportBean>
{
  protected QCircleExtraTypeInfo mExtraTypeInfo;
  private QCircleReportBean mReportBean;
  
  public QCircleBaseListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected void assembleFromReportData()
  {
    if (getHostFragment() != null)
    {
      if (getActivity() == null) {
        return;
      }
      Object localObject = getHostFragment().getActivity().getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
      {
        localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
        if ((localObject != null) && (((QCircleInitBean)localObject).getFromReportBean() != null))
        {
          QCircleReportBean localQCircleReportBean = this.mReportBean;
          if (localQCircleReportBean != null) {
            localQCircleReportBean.assembleFromReportData(((QCircleInitBean)localObject).getFromReportBean());
          }
        }
      }
    }
  }
  
  protected QCircleStatusView createStatusView()
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
    localQCircleFullScreenStatusView.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_relationship"), QCircleConfigHelper.P(), QCircleConfigHelper.Q());
    localQCircleFullScreenStatusView.setOnRetryClickListener(new QCircleBaseListBlock.1(this, localQCircleFullScreenStatusView));
    return localQCircleFullScreenStatusView;
  }
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
  }
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean == null) {
      this.mReportBean = new QCircleReportBean();
    }
    assembleFromReportData();
    return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
  }
  
  public int getStatusBarColor()
  {
    return QCirclePluginUtil.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    QCirclePopupWindowHelper.a().c();
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d(getLogTag(), 1, "onPrepareParams");
    getBlockContainer().setStatusViewInterface(createStatusView());
    if ((this.mInitBean instanceof QCircleInitBean)) {
      this.mExtraTypeInfo = ((QCircleInitBean)this.mInitBean).getExtraTypeInfo();
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
  
  public void showEmptyView()
  {
    if ((getHostFragment() != null) && (getHostFragment().x() != null) && (getHostFragment().x().getStatusInterface() != null))
    {
      IStatusViewProvider localIStatusViewProvider = getHostFragment().x().getStatusInterface();
      String str;
      if (getEmptyHint() == null) {
        str = "";
      } else {
        str = getEmptyHint();
      }
      localIStatusViewProvider.a(str);
    }
  }
  
  protected void showErrorView(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131895632);
    }
    paramString = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" return error！errMsg:");
    localStringBuilder.append(str);
    QLog.e(paramString, 1, localStringBuilder.toString());
    if (getItemCount() > 0)
    {
      QCircleToastUtil.a(paramLong, QCircleToast.c, str, 1);
      return;
    }
    if ((getHostFragment() != null) && (getHostFragment().x() != null)) {
      ((QCircleStatusView)getHostFragment().x().getStatusInterface()).b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.QCircleBaseListBlock
 * JD-Core Version:    0.7.0.1
 */