package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class QzoneEditPictureAndVideoReportModel
{
  private int jdField_a_of_type_Int;
  private final Class<? extends EditVideoPart> jdField_a_of_type_JavaLangClass;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final int b;
  private final int c;
  
  private QzoneEditPictureAndVideoReportModel(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  static QzoneEditPictureAndVideoReportModel a(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    return new QzoneEditPictureAndVideoReportModel(paramInt1, paramInt2, paramInt3, paramClass);
  }
  
  Class<? extends EditVideoPart> a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(toString());
        localStringBuilder.append(" with ");
        localStringBuilder.append(localInteger);
        QZLog.d("QzoneEditPictureAndVide", 2, new Object[] { "performReport ", localStringBuilder.toString() });
      }
    }
    LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, this.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("performReport ");
    ((StringBuilder)localObject).append(toString());
    QZLog.d("QzoneEditPictureAndVide", 2, ((StringBuilder)localObject).toString());
  }
  
  void a(Set<Integer> paramSet)
  {
    this.jdField_a_of_type_JavaUtilSet.addAll(paramSet);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QzoneEditPictureReportModel{actionType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", subActionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", reserve=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureAndVideoReportModel
 * JD-Core Version:    0.7.0.1
 */