package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;

public class QCircleLayerStatusView
  extends QCircleStatusView
{
  private static RFWMultiDownloadHelper g = new RFWMultiDownloadHelper();
  
  static
  {
    g.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("img_emptystate_detailpage_disconnect"), QCirclePluginConfig.e()));
    g.start();
  }
  
  public QCircleLayerStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleLayerStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f.setVisibility(8);
    a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_detailpage_feed"));
    this.c.setVisibility(0);
    this.c.setText(QCircleConfigHelper.T());
    this.e.setVisibility(0);
    this.d.setText(QCircleConfigHelper.Q());
    setVisibility(0);
  }
  
  public void b(String paramString)
  {
    if ((HostNetworkUtils.isNetworkAvailable() ^ true))
    {
      this.e.setVisibility(8);
      paramString = d(QCircleSkinHelper.getInstance().getUrl("img_emptystate_detailpage_feed"));
      if (new File(paramString).exists())
      {
        this.c.setVisibility(0);
        this.f.setVisibility(8);
        b(this.b, paramString);
        this.c.setText(QCircleConfigHelper.U());
      }
      else
      {
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.b.setVisibility(8);
      }
    }
    else
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_detailpage_feed"));
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(paramString)) {
        this.c.setText(paramString);
      } else {
        this.c.setText(QCircleConfigHelper.V());
      }
    }
    d();
    setVisibility(0);
  }
  
  public int getLayoutId()
  {
    return 2131626862;
  }
  
  protected String getLogTag()
  {
    return "QCirclePersonalBottomStatusView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437401)
    {
      Object localObject = this.d.getText();
      if (localObject != null) {
        if (localObject.equals(QCircleConfigHelper.Q()))
        {
          localObject = new QCircleFolderBean();
          ((QCircleFolderBean)localObject).setAssignShowTabType(6);
          QCircleLauncher.a(getContext(), (QCircleFolderBean)localObject);
        }
        else if ((getContext() != null) && (localObject.equals(getContext().getString(2131895702))))
        {
          a(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView
 * JD-Core Version:    0.7.0.1
 */