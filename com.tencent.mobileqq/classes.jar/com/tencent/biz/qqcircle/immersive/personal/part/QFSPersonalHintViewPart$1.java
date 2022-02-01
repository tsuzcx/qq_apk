package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.Map;

class QFSPersonalHintViewPart$1
  implements IDynamicParams
{
  QFSPersonalHintViewPart$1(QFSPersonalHintViewPart paramQFSPersonalHintViewPart) {}
  
  public Map<String, Object> getDynamicParams(String paramString)
  {
    paramString = new QCircleDTParamBuilder().buildElementParams();
    paramString.put("xsj_void_item_status", QFSPersonalHintViewPart.a(this.a));
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart.1
 * JD-Core Version:    0.7.0.1
 */