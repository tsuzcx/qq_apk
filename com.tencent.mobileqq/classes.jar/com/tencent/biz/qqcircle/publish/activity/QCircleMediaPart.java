package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishMediaDeleteEvent;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QCircleMediaPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private QCirclePublishViewModel a;
  private SquareImageView c;
  private SquareImageView d;
  private SquareImageView e;
  private ImageView f;
  private ImageView g;
  private RelativeLayout h;
  private TextView i;
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    a(paramLocalMediaInfo.thumbnailPath, this.d);
    if (this.a.b(paramLocalMediaInfo.path)) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.i.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  private void a(HashMap<String, LocalMediaInfo> paramHashMap, DynamicArrayList<String> paramDynamicArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramDynamicArrayList.size() > 1) && (paramHashMap.get(paramDynamicArrayList.get(1)) != null))
    {
      paramHashMap = (LocalMediaInfo)paramHashMap.get(paramDynamicArrayList.get(1));
      this.c.setVisibility(0);
      a(paramHashMap.path, this.c);
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.i.setText(String.valueOf(paramDynamicArrayList.size()));
    }
    else
    {
      this.c.setVisibility(8);
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
    }
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    a(paramLocalMediaInfo.path, this.d);
  }
  
  private void i()
  {
    if (this.a == null) {
      this.a = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.a.a.observe(j(), new QCircleMediaPart.1(this));
    this.a.b.observe(j(), new QCircleMediaPart.2(this));
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleMediaPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    HostUIHelper.closeHostEnvironment();
    QLog.d("[QcirclePublish]QCircleMediaPart", 1, new Object[] { "onActivityResult... requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    if (paramIntent != null) {
      this.a.k = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_EDITOR_FROM_PHOTO_PICKER_TAB());
    }
    if ((QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) && (paramInt2 == 0) && (this.a.B) && ((this.a.f.size() == 0) || (this.a.n)))
    {
      this.a.n = false;
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.a.w), QCircleReportHelper.newEntry("ext1", String.valueOf(this.a.l)), QCircleReportHelper.newEntry("ret_code", "0") }));
      c().finish();
      return;
    }
    if ((QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) && (paramInt2 == -1))
    {
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.a.w), QCircleReportHelper.newEntry("ext1", String.valueOf(this.a.l)), QCircleReportHelper.newEntry("ret_code", "0") }));
      if (paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false)) {
        this.a.b(j());
      } else {
        this.a.a(paramIntent);
      }
    }
    else if ((paramInt1 == 8) && (paramInt2 == -1))
    {
      this.a.c(paramIntent);
    }
    else if ((paramInt1 == 10078) && (paramInt2 == -1))
    {
      this.a.b(paramIntent);
      this.a.h();
    }
    this.a.n = false;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    i();
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setImageView... url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[QcirclePublish]QCircleMediaPart", 1, ((StringBuilder)localObject).toString());
    if (paramImageView.getVisibility() != 0) {
      paramImageView.setVisibility(0);
    }
    localObject = new Option();
    ((Option)localObject).setUrl(paramString).setTargetView(paramImageView).setPredecode(true).setRequestWidth(ViewUtils.a(105.0F)).setRequestHeight(ViewUtils.a(105.0F));
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
  }
  
  protected void b(View paramView)
  {
    this.c = ((SquareImageView)paramView.findViewById(2131441814));
    this.d = ((SquareImageView)paramView.findViewById(2131441815));
    this.g = ((ImageView)paramView.findViewById(2131441822));
    this.h = ((RelativeLayout)paramView.findViewById(2131441801));
    this.i = ((TextView)paramView.findViewById(2131441810));
    this.f = ((ImageView)paramView.findViewById(2131441799));
    this.e = ((SquareImageView)paramView.findViewById(2131441813));
    this.e.setRoundRect(ViewUtils.a(4.0F));
    this.c.setRoundRect(ViewUtils.a(4.0F));
    this.d.setRoundRect(ViewUtils.a(4.0F));
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishMediaDeleteEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131441815) && (paramView.getId() != 2131441813) && (paramView.getId() != 2131441799))
    {
      if (paramView.getId() == 2131441801) {
        this.a.i();
      }
    }
    else
    {
      QCirclePublishViewModel localQCirclePublishViewModel = this.a;
      localQCirclePublishViewModel.B = false;
      localQCirclePublishViewModel.a(c(), 10078);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishMediaDeleteEvent))
    {
      int j = ((QCirclePublishMediaDeleteEvent)paramSimpleBaseEvent).position;
      this.a.a(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleMediaPart
 * JD-Core Version:    0.7.0.1
 */