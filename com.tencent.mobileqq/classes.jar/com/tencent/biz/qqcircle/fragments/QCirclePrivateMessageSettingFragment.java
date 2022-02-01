package com.tencent.biz.qqcircle.fragments;

import com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCirclePrivateMessageSettingFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 32;
  }
  
  public String b()
  {
    return "QCirclePrivateMessageSettingFragment";
  }
  
  protected int c()
  {
    return 2131626919;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    QCirclePrivateMessageSettingContentPart localQCirclePrivateMessageSettingContentPart = new QCirclePrivateMessageSettingContentPart();
    localQCirclePrivateMessageSettingContentPart.a(n());
    localArrayList.add(localQCirclePrivateMessageSettingContentPart);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePrivateMessageSettingFragment
 * JD-Core Version:    0.7.0.1
 */