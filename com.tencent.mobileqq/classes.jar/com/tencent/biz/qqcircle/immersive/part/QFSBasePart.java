package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QFSBasePart
  extends Part
{
  public int i()
  {
    return l().getPageId();
  }
  
  public QCircleReportBean l()
  {
    Object localObject = D();
    if (!(localObject instanceof QCircleReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("QFSBasePart", 1, "getReportBean but QCircleReportBean is null");
        return new QCircleReportBean();
      }
      QLog.e("QFSBasePart", 1, "getReportBean but QCircleReportBean is null , debug");
      throw new RuntimeException("getReportBean but QCircleReportBean is null");
    }
    return (QCircleReportBean)localObject;
  }
  
  public QCircleBaseFragment m()
  {
    BasePartFragment localBasePartFragment = super.j();
    if ((localBasePartFragment instanceof QCircleBaseFragment)) {
      return (QCircleBaseFragment)localBasePartFragment;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSBasePart
 * JD-Core Version:    0.7.0.1
 */