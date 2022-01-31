import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bkpw
  extends bjxn
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
  public int f = -1;
  public boolean f;
  public int g;
  public boolean g;
  private int h = -1;
  public boolean h;
  public boolean i = true;
  public boolean j;
  public boolean k = true;
  public boolean l = true;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  
  public bkpw(Activity paramActivity)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (paramActivity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22) {}
    for (;;)
    {
      this.r = bool;
      this.h = paramActivity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
      return;
      bool = false;
    }
  }
  
  private bkqn a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      bjxl localbjxl = (bjxl)localIterator.next();
      if ((localbjxl instanceof bkqn)) {
        return (bkqn)localbjxl;
      }
    }
    return null;
  }
  
  static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    bgyj localbgyj = new bgyj();
    localbgyj.jdField_c_of_type_JavaLangString = paramString1;
    localbgyj.d = paramString2;
    localbgyj.e = paramString3;
    QZoneClickReport.report(QQStoryContext.a().a(), localbgyj, paramBoolean);
  }
  
  public void a()
  {
    b("608", "1", "0", true);
    if ((!this.m) && (this.jdField_g_of_type_Int > 0)) {
      axim.r /= this.jdField_g_of_type_Int;
    }
    super.a();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
  }
  
  public void a(bjyv parambjyv, EditVideoParams paramEditVideoParams)
  {
    super.a(parambjyv, paramEditVideoParams);
    if ((paramEditVideoParams != null) && (paramEditVideoParams.a != null) && ((this.h == 17) || (this.h == 18)))
    {
      parambjyv = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718127);
      paramEditVideoParams.a.putString("extra_publish_text", parambjyv);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  protected void a(List<bjxl> paramList)
  {
    if ((!this.r) || ((this.h != 14) && (this.h != 19))) {
      paramList.add(new bkpk(this));
    }
    if (this.r) {
      paramList.add(new bjyb(this));
    }
    if ((this.n) && (!this.r)) {
      paramList.add(new bkqp(this, this.jdField_a_of_type_AndroidAppActivity));
    }
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null) {
      paramList.add(new bkqj(this, this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo));
    }
    paramList.add(new bkqn(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.k();
    }
  }
  
  public void d(int paramInt)
  {
    bkqn localbkqn = a();
    if (localbkqn != null) {
      localbkqn.a_(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    d(3005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpw
 * JD-Core Version:    0.7.0.1
 */