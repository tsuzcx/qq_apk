package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.util.ArrayList;
import java.util.List;

public class QzEditVideoPartManager
  extends EditVideoPartManager
{
  public int a;
  public View a;
  private EditVideoQzComment jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditVideoQzComment;
  private QzEditVideoPartManager.GenerateGifCheck jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzEditVideoPartManager$GenerateGifCheck;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b = -1;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d = -1;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public boolean f;
  public boolean k;
  
  public QzEditVideoPartManager()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
  }
  
  static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.jdField_c_of_type_JavaLangString = paramString1;
    localReportInfo.d = paramString2;
    localReportInfo.e = paramString3;
    QZoneClickReport.report(QQStoryContext.a().a(), localReportInfo, paramBoolean);
  }
  
  public void a()
  {
    b("608", "1", "0", true);
    if ((!this.f) && (this.jdField_e_of_type_Int > 0)) {
      CodecParam.r /= this.jdField_e_of_type_Int;
    }
    super.a();
  }
  
  public void a(QzEditVideoPartManager.GenerateGifCheck paramGenerateGifCheck)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzEditVideoPartManager$GenerateGifCheck = paramGenerateGifCheck;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  protected void a(List paramList)
  {
    EditVideoQzComment localEditVideoQzComment = new EditVideoQzComment(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditVideoQzComment = localEditVideoQzComment;
    paramList.add(localEditVideoQzComment);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzEditVideoPartManager$GenerateGifCheck != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzEditVideoPartManager$GenerateGifCheck.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */