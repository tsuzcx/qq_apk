import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bpik
  extends botw
{
  public Activity a;
  public View a;
  public QzoneVerticalVideoTopicInfo a;
  public String a;
  public ArrayList<String> a;
  public String b;
  public int c;
  public String c;
  public int d = -1;
  public String d;
  public int e = -1;
  public String e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  private int h;
  public boolean h;
  public boolean i;
  public boolean j = true;
  public boolean k = true;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  
  public bpik(Activity paramActivity)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_f_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_f_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (paramActivity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22) {}
    for (;;)
    {
      this.q = bool;
      this.jdField_h_of_type_Int = paramActivity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
      return;
      bool = false;
    }
  }
  
  private bpjb a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      botu localbotu = (botu)localIterator.next();
      if ((localbotu instanceof bpjb)) {
        return (bpjb)localbotu;
      }
    }
    return null;
  }
  
  static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = paramString1;
    localReportInfo.subactionType = paramString2;
    localReportInfo.reserves = paramString3;
    QZoneClickReport.report(QQStoryContext.a().a(), localReportInfo, paramBoolean);
  }
  
  public void a()
  {
    b("608", "1", "0", true);
    if ((!this.l) && (this.g > 0)) {
      CodecParam.mMaxrate /= this.g;
    }
    super.a();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
  }
  
  public void a(bouo parambouo, EditVideoParams paramEditVideoParams)
  {
    super.a(parambouo, paramEditVideoParams);
    if ((paramEditVideoParams != null) && (paramEditVideoParams.a != null) && ((this.jdField_h_of_type_Int == 17) || (this.jdField_h_of_type_Int == 18)))
    {
      parambouo = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717383);
      paramEditVideoParams.a.putString("extra_publish_text", parambouo);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  protected void a(List<botu> paramList)
  {
    if ((!this.q) || ((this.jdField_h_of_type_Int != 14) && (this.jdField_h_of_type_Int != 19))) {
      paramList.add(new bphy(this));
    }
    if (this.q) {
      paramList.add(new boue(this));
    }
    if ((this.m) && (!this.q)) {
      paramList.add(new bpjd(this, this.jdField_a_of_type_AndroidAppActivity));
    }
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null) {
      paramList.add(new bpix(this, this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo));
    }
    paramList.add(new bpjb(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.l();
    }
  }
  
  public void c(int paramInt)
  {
    bpjb localbpjb = a();
    if (localbpjb != null) {
      localbpjb.a(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    c(3005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpik
 * JD-Core Version:    0.7.0.1
 */