package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;
import java.util.List;

public class QCirclePrivacySettingFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 32;
  }
  
  public String b()
  {
    return "QCirclePrivacySettingFragment";
  }
  
  protected int c()
  {
    return 2131626918;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QCirclePrivacySettingContentPart());
    return localArrayList;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(1).setPageId(a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePrivacySettingFragment
 * JD-Core Version:    0.7.0.1
 */