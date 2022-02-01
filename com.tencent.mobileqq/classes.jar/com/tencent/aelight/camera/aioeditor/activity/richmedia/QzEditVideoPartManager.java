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
  public int a;
  public Activity a;
  public View a;
  public QzoneVerticalVideoTopicInfo a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public boolean f;
  public boolean g;
  private int h;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  
  public QzEditVideoPartManager(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    boolean bool = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.f = true;
    this.g = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.m = false;
    this.jdField_h_of_type_Int = -1;
    this.n = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (paramActivity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) != 22) {
      bool = false;
    }
    this.m = bool;
    this.jdField_h_of_type_Int = paramActivity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
  }
  
  private QzoneEditVideoPartReport a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof QzoneEditVideoPartReport)) {
        return (QzoneEditVideoPartReport)localEditVideoPart;
      }
    }
    return null;
  }
  
  static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = paramString1;
    localReportInfo.subactionType = paramString2;
    localReportInfo.reserves = paramString3;
    QZoneClickReport.report(QQStoryContext.a().a(), localReportInfo, paramBoolean);
  }
  
  public void a()
  {
    a("608", "1", "0", true);
    if ((!this.jdField_h_of_type_Boolean) && (this.e > 0)) {
      CodecParam.mMaxrate /= this.e;
    }
    super.a();
  }
  
  public void a(@QzEditVideoPartManager.UIEditExtraType int paramInt)
  {
    QzoneEditVideoPartReport localQzoneEditVideoPartReport = a();
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
    if ((paramEditVideoParams != null) && (paramEditVideoParams.a != null))
    {
      int i1 = this.jdField_h_of_type_Int;
      if ((i1 == 17) || (i1 == 18))
      {
        paramEditVideoUi = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717537);
        paramEditVideoParams.a.putString("extra_publish_text", paramEditVideoUi);
      }
    }
  }
  
  protected void a(List<EditVideoPart> paramList)
  {
    if (this.m)
    {
      int i1 = this.jdField_h_of_type_Int;
      if ((i1 == 14) || (i1 == 19)) {}
    }
    else
    {
      paramList.add(new EditVideoQzComment(this));
    }
    if (this.m) {
      paramList.add(new EditVideoProgressBar(this));
    }
    if ((this.i) && (!this.m)) {
      paramList.add(new QzoneRightButton(this, this.jdField_a_of_type_AndroidAppActivity));
    }
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
    if (localQzoneVerticalVideoTopicInfo != null) {
      paramList.add(new QzoneEditTopic(this, localQzoneVerticalVideoTopicInfo));
    }
    paramList.add(new QzoneEditVideoPartReport(this));
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
  
  public void u_()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */