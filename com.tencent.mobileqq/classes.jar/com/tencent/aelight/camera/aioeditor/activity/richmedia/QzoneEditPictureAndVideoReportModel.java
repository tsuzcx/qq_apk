package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class QzoneEditPictureAndVideoReportModel
{
  private int a;
  private final int b;
  private final int c;
  private final Class<? extends EditVideoPart> d;
  private Set<Integer> e = new HashSet();
  
  private QzoneEditPictureAndVideoReportModel(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramClass;
  }
  
  static QzoneEditPictureAndVideoReportModel a(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    return new QzoneEditPictureAndVideoReportModel(paramInt1, paramInt2, paramInt3, paramClass);
  }
  
  Class<? extends EditVideoPart> a()
  {
    return this.d;
  }
  
  void a(Set<Integer> paramSet)
  {
    this.e.addAll(paramSet);
  }
  
  void b()
  {
    if (this.e.size() > 0)
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        LpReportInfo_pf00064.allReport(this.a, this.b, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(toString());
        localStringBuilder.append(" with ");
        localStringBuilder.append(localInteger);
        QZLog.d("QzoneEditPictureAndVide", 2, new Object[] { "performReport ", localStringBuilder.toString() });
      }
    }
    LpReportInfo_pf00064.allReport(this.a, this.b, this.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("performReport ");
    ((StringBuilder)localObject).append(toString());
    QZLog.d("QzoneEditPictureAndVide", 2, ((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QzoneEditPictureReportModel{actionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", subActionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", reserve=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureAndVideoReportModel
 * JD-Core Version:    0.7.0.1
 */