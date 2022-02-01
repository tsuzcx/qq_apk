package com.tencent.biz.qqcircle.publish.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.publish.view.QCirclePreviewVideo;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QCircleVideoPreviewPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private QCirclePreviewVideo a;
  private TextView c;
  private TextView d;
  private ImageView e;
  private List<String> f;
  private int g;
  private int h;
  
  private void i()
  {
    QCirclePreviewVideo localQCirclePreviewVideo = this.a;
    if ((localQCirclePreviewVideo != null) && (localQCirclePreviewVideo.w())) {
      this.a.h();
    }
  }
  
  private void l()
  {
    QCircleCustomDialog.a(g(), g().getResources().getString(2131895942), null, 2131887648, 2131888010, new QCircleVideoPreviewPart.2(this), new QCircleVideoPreviewPart.3(this)).show();
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleVideoPreviewPart";
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[QcirclePublish]QCircleVideoPreviewPart", 1, "QCircleVideoPreviewPart... intent == null");
      c().finish();
      return;
    }
    this.f = paramIntent.getStringArrayListExtra("key_photo_previewer_list");
    this.h = paramIntent.getIntExtra("key_photo_previewer_video_cover_width", 0);
    this.g = paramIntent.getIntExtra("key_photo_previewer_video_cover_height", 0);
    paramIntent = this.f;
    if ((paramIntent != null) && (paramIntent.size() != 0))
    {
      QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, new Object[] { "QCircleVideoPreviewPart... list:", this.f, " mWidth:", Integer.valueOf(this.h), " mHeight:", Integer.valueOf(this.g) });
      return;
    }
    QLog.w("[QcirclePublish]QCircleVideoPreviewPart", 1, "QCircleVideoPreviewPart... mList == null || mList.size() == 0");
    c().finish();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "onInitView...");
    this.c = ((TextView)paramView.findViewById(2131441735));
    this.d = ((TextView)paramView.findViewById(2131441736));
    this.e = ((ImageView)paramView.findViewById(2131431689));
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.c);
    }
    this.a = ((QCirclePreviewVideo)paramView.findViewById(2131441796));
    this.a.setVisibility(0);
    paramView.findViewById(2131441818).setVisibility(8);
    this.a.setLoopBack(false);
    this.a.setData(this.f.get(0));
    this.a.setBaseVideoViewListenerSets(new QCircleVideoPreviewPart.1(this));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.release();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QLog.i("[QcirclePublish]QCircleVideoPreviewPart", 1, "onActivityPaused");
    this.a.b();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "onActivityResumed...");
    i();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441735) {
      c().finish();
    } else if (paramView.getId() == 2131431689) {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.QCircleVideoPreviewPart
 * JD-Core Version:    0.7.0.1
 */