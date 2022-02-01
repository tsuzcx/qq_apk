package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicCropPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QzoneEditPicturePartReport
  extends EditVideoPart
{
  private static final SparseArray<QzoneEditPictureAndVideoReportModel> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, QzoneEditPictureAndVideoReportModel.a(98, 1, 0, QzoneEditPicturePartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, QzoneEditPictureAndVideoReportModel.a(98, 12, 0, QzoneEditPicturePartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, QzoneEditPictureAndVideoReportModel.a(98, 2, 0, QzoneEditPicturePartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, QzoneEditPictureAndVideoReportModel.a(98, 5, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, QzoneEditPictureAndVideoReportModel.a(98, 3, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, QzoneEditPictureAndVideoReportModel.a(98, 6, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, QzoneEditPictureAndVideoReportModel.a(98, 4, 0, EditPicCropPart.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, QzoneEditPictureAndVideoReportModel.a(98, 9, 0, EditPicSave.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, QzoneEditPictureAndVideoReportModel.a(98, 10, 0, QzoneEditPicturePartComment.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, QzoneEditPictureAndVideoReportModel.a(98, 8, 1, QzoneEditPicturePartScheduleDelete.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, QzoneEditPictureAndVideoReportModel.a(98, 8, 2, QzoneEditPicturePartScheduleDelete.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, QzoneEditPictureAndVideoReportModel.a(98, 11, 0, QzoneEditPicturePartComment.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if (paramClass.isInstance(localEditVideoPart)) {
        return localEditVideoPart;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (EditVideoDoodle)a(EditVideoDoodle.class);
    if ((localObject != null) && (!((EditVideoDoodle)localObject).f_()))
    {
      if (!((EditVideoDoodle)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((EditVideoDoodle)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((EditVideoDoodle)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditPicCropPart)a(EditPicCropPart.class);
    if ((localObject != null) && (((EditPicCropPart)localObject).b())) {
      localHashSet.add(Integer.valueOf(2));
    }
    return localHashSet;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (QzoneEditPictureAndVideoReportModel)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (EditVideoPart)a(paramObject.a());
      if ((paramObject instanceof EditVideoDoodle))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof EditPicCropPart))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof EditPicSave))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged save report");
        return;
      }
      QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged unsupported report");
      return;
    }
    QZLog.w("QzoneEditPicturePartRep", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state for reporting" });
  }
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof Object[])))
    {
      long l = ((Long)((Object[])(Object[])paramMessage.obj)[0]).longValue();
      View localView = (View)((Object[])(Object[])paramMessage.obj)[1];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleEditVideoMessage ");
      localStringBuilder.append(l);
      localStringBuilder.append(" ");
      localStringBuilder.append(localView);
      QZLog.d("QzoneEditPicturePartRep", 2, localStringBuilder.toString());
    }
    return super.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartReport
 * JD-Core Version:    0.7.0.1
 */