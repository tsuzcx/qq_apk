package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.PeakConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.io.File;

public class QCircleFullScreenStatusView
  extends QCircleStatusView
{
  private String g;
  private String h;
  private String i;
  private FeedCloudMeta.StTagInfo j;
  
  public QCircleFullScreenStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFullScreenStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIME_STAMP(), System.currentTimeMillis());
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIMESTAMP_LAST_ACTIVITY(), System.currentTimeMillis());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    localBundle.putBoolean("key_qcircle_reopen_carema", true);
    localBundle.putSerializable("key_bundle_common_init_bean", new QCircleInitBean());
    Object localObject = this.j;
    if (localObject != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", ((FeedCloudMeta.StTagInfo)localObject).tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.j.tagName.get());
    }
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).setClass(getContext(), QCircleTransFragmentActivity.class);
    ((Intent)localObject).putExtra("public_fragment_class", QCircleLoadingFragment.class.getName());
    getContext().startActivity((Intent)localObject);
  }
  
  public void a(String paramString)
  {
    if ((HostNetworkUtils.isNetworkAvailable() ^ true))
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      paramString = d(QCircleSkinHelper.getInstance().getUrl("img_emptystate_disconnect"));
      if (new File(paramString).exists())
      {
        this.f.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setText(QCircleConfigHelper.U());
        b(this.b, paramString);
      }
      else
      {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.f.setVisibility(0);
      }
    }
    else
    {
      this.f.setVisibility(8);
      if (!TextUtils.isEmpty(this.g)) {
        a(this.b, this.g);
      }
      if (!TextUtils.isEmpty(this.h))
      {
        this.c.setVisibility(0);
        this.c.setText(this.h);
      }
      if (!TextUtils.isEmpty(this.i))
      {
        this.e.setVisibility(0);
        this.d.setText(this.i);
      }
    }
    setVisibility(0);
  }
  
  protected String getLogTag()
  {
    return "QCircleMessageListStatusView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437401)
    {
      Object localObject = this.d.getText();
      if (localObject != null) {
        if (QCircleConfigHelper.S().equals(((CharSequence)localObject).toString()))
        {
          if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.a(getContext(), 1);
          } else {
            b();
          }
        }
        else if (QCircleConfigHelper.Q().equals(((CharSequence)localObject).toString()))
        {
          localObject = new QCircleFolderBean();
          ((QCircleFolderBean)localObject).setAssignShowTabType(6);
          QCircleLauncher.a(getContext(), (QCircleFolderBean)localObject);
        }
        else if ((getContext() != null) && (getContext().getResources() != null) && (localObject.equals(getContext().getResources().getString(2131895721))))
        {
          localObject = new Intent();
          QCircleLauncher.a(getContext(), "https://h5.qzone.qq.com/v2/wezone/recommendTag?_wv=3&_proxy=1", (Intent)localObject, -1);
        }
        else if ((getContext() != null) && (localObject.equals(getContext().getString(2131895702))))
        {
          a(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setEmptyImageAndText(String paramString1, String paramString2, String paramString3)
  {
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.j = paramStTagInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView
 * JD-Core Version:    0.7.0.1
 */