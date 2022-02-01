package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;

public class QCircleHalfScreenStatusView
  extends QCircleStatusView
{
  private static RFWMultiDownloadHelper g = new RFWMultiDownloadHelper();
  
  static
  {
    g.addTask(new RFWMultiDownloadHelper.DownloadTask("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_halfscreen_disconnect.png", QCirclePluginConfig.e()));
    g.start();
  }
  
  public QCircleHalfScreenStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleHalfScreenStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b(String paramString)
  {
    if ((HostNetworkUtils.isNetworkAvailable() ^ true))
    {
      this.c.setVisibility(8);
      this.b.setVisibility(8);
      paramString = d(QCircleSkinHelper.getInstance().getUrl("img_emptystate_disconnect"));
      if (new File(paramString).exists())
      {
        this.f.setVisibility(8);
        this.c.setVisibility(0);
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
      a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_disconnect"));
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(paramString)) {
        this.c.setText(paramString);
      } else {
        this.c.setText(QCircleConfigHelper.V());
      }
    }
    setVisibility(0);
  }
  
  public int getLayoutId()
  {
    return 2131626842;
  }
  
  protected String getLogTag()
  {
    return "QCircleMessageListStatusView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleHalfScreenStatusView
 * JD-Core Version:    0.7.0.1
 */