package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoProgressBar;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QzEditVideoPartManager
  extends EditVideoPartManager
{
  public boolean A;
  public boolean B;
  public Activity a;
  private int ak;
  public View b;
  public ArrayList<String> c = null;
  public int d;
  public String e;
  public String f;
  public String g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public int o;
  public int p;
  public String q;
  public int r;
  public String s;
  public boolean t;
  public boolean u;
  public int v;
  public QzoneVerticalVideoTopicInfo w;
  public boolean x;
  public boolean y;
  public boolean z;
  
  public QzEditVideoPartManager(Activity paramActivity)
  {
    boolean bool = true;
    this.d = 1;
    this.g = "";
    this.i = true;
    this.k = true;
    this.m = true;
    this.n = true;
    this.o = -1;
    this.p = -1;
    this.r = -1;
    this.A = false;
    this.ak = -1;
    this.B = false;
    this.a = paramActivity;
    if (paramActivity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) != 22) {
      bool = false;
    }
    this.A = bool;
    this.ak = paramActivity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = paramString1;
    localReportInfo.subactionType = paramString2;
    localReportInfo.reserves = paramString3;
    QZoneClickReport.report(QQStoryContext.a().g(), localReportInfo, paramBoolean);
  }
  
  private QzoneEditVideoPartReport d()
  {
    Iterator localIterator = W().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof QzoneEditVideoPartReport)) {
        return (QzoneEditVideoPartReport)localEditVideoPart;
      }
    }
    return null;
  }
  
  public void a()
  {
    a("608", "1", "0", true);
    if ((!this.t) && (this.v > 0)) {
      CodecParam.mMaxrate /= this.v;
    }
    super.a();
  }
  
  public void a(@QzEditVideoPartManager.UIEditExtraType int paramInt)
  {
    QzoneEditVideoPartReport localQzoneEditVideoPartReport = d();
    if (localQzoneEditVideoPartReport != null) {
      localQzoneEditVideoPartReport.a(paramInt, null);
    }
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
  }
  
  public void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    super.a(paramEditVideoUi, paramEditVideoParams);
    if ((paramEditVideoParams != null) && (paramEditVideoParams.d != null))
    {
      int i1 = this.ak;
      if ((i1 == 17) || (i1 == 18))
      {
        paramEditVideoUi = this.a.getResources().getString(2131915012);
        paramEditVideoParams.d.putString("extra_publish_text", paramEditVideoUi);
      }
    }
  }
  
  protected void a(List<EditVideoPart> paramList)
  {
    if (this.A)
    {
      int i1 = this.ak;
      if ((i1 == 14) || (i1 == 19)) {}
    }
    else
    {
      paramList.add(new EditVideoQzComment(this));
    }
    if (this.A) {
      paramList.add(new EditVideoProgressBar(this));
    }
    if ((this.u) && (!this.A)) {
      paramList.add(new QzoneRightButton(this, this.a));
    }
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = this.w;
    if (localQzoneVerticalVideoTopicInfo != null) {
      paramList.add(new QzoneEditTopic(this, localQzoneVerticalVideoTopicInfo));
    }
    paramList.add(new QzoneEditVideoPartReport(this));
  }
  
  public void av_()
  {
    if (this.aj != null) {
      this.aj.h();
    }
  }
  
  public void b()
  {
    super.b();
    a(3005);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */