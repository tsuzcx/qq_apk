package com.tencent.biz.qqcircle.publish.activity;

import android.os.Bundle;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;
import java.util.List;

public class QCirclePublishPicPreviewFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  
  public int a()
  {
    return 0;
  }
  
  public String b()
  {
    return "QCirclePublishPicPreviewFragment";
  }
  
  protected int c()
  {
    return 2131626900;
  }
  
  protected List<Part> d()
  {
    this.c = new ArrayList();
    QCirclePublishPicPreviewPart localQCirclePublishPicPreviewPart = new QCirclePublishPicPreviewPart();
    this.c.add(localQCirclePublishPicPreviewPart);
    return this.c;
  }
  
  protected String f()
  {
    return "pg_xsj_publish_page_preview_pics";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewFragment
 * JD-Core Version:    0.7.0.1
 */