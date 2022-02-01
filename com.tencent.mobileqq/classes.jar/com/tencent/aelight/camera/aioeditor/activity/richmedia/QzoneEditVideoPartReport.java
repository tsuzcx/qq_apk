package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.music.EditVideoQimMusic;
import com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneEditVideoPartReport
  extends EditVideoPart
{
  private static final SparseArray<QzoneEditPictureAndVideoReportModel> c = new SparseArray();
  CaptureComboManager.CaptureComboListener a = new QzoneEditVideoPartReport.1(this);
  private Set<Integer> b = new HashSet();
  
  static
  {
    c.put(3000, QzoneEditPictureAndVideoReportModel.a(99, 1, 0, QzoneEditVideoPartReport.class));
    c.put(2, QzoneEditPictureAndVideoReportModel.a(99, 3, 0, EditVideoDoodle.class));
    c.put(3, QzoneEditPictureAndVideoReportModel.a(99, 5, 0, EditVideoDoodle.class));
    c.put(4, QzoneEditPictureAndVideoReportModel.a(99, 7, 0, EditVideoDoodle.class));
    c.put(1, QzoneEditPictureAndVideoReportModel.a(99, 4, 0, EditVideoQimMusic.class));
    c.put(14, QzoneEditPictureAndVideoReportModel.a(99, 6, 0, EditProviderPart.class));
    c.put(12, QzoneEditPictureAndVideoReportModel.a(99, 9, 0, EditVideoSpeedFilter.class));
    c.put(13, QzoneEditPictureAndVideoReportModel.a(99, 8, 0, EditProviderPart.class));
    c.put(4001, QzoneEditPictureAndVideoReportModel.a(99, 16, 0, EditProviderPart.class));
    c.put(3005, QzoneEditPictureAndVideoReportModel.a(99, 2, 0, QzoneEditVideoPartReport.class));
    c.put(3006, QzoneEditPictureAndVideoReportModel.a(99, 15, 0, QzoneEditVideoPartReport.class));
    c.put(3002, QzoneEditPictureAndVideoReportModel.a(99, 10, 1, QzoneEditVideoPartReport.class));
    c.put(3003, QzoneEditPictureAndVideoReportModel.a(99, 10, 2, QzoneEditVideoPartReport.class));
    c.put(3001, QzoneEditPictureAndVideoReportModel.a(99, 13, 0, QzoneEditVideoPartReport.class));
    c.put(3007, QzoneEditPictureAndVideoReportModel.a(99, 12, 1, QzoneEditVideoPartReport.class));
    c.put(3008, QzoneEditPictureAndVideoReportModel.a(99, 12, 2, QzoneEditVideoPartReport.class));
    c.put(3004, QzoneEditPictureAndVideoReportModel.a(99, 14, 0, QzoneEditVideoPartReport.class));
    c.put(3009, QzoneEditPictureAndVideoReportModel.a(99, 11, 0, QzoneEditVideoPartReport.class));
  }
  
  public QzoneEditVideoPartReport(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void c()
  {
    Iterator localIterator = this.t.W().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (EditVideoPart)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof EditVideoDoodle))
      {
        localObject2 = (EditVideoDoodle)localObject1;
        if (!((EditVideoDoodle)localObject2).b().p())
        {
          if (!((EditVideoDoodle)localObject2).b().getLineLayer().c()) {
            this.b.add(Integer.valueOf(5));
          }
          if (!((EditVideoDoodle)localObject2).b().getTextLayer().c()) {
            this.b.add(Integer.valueOf(1));
          }
          if (!((EditVideoDoodle)localObject2).b().getFaceLayer().c()) {
            this.b.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof EditProviderPart))
      {
        localObject1 = (EditProviderPart)localObject1;
        localObject2 = new JSONObject();
        ((EditProviderPart)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(EditProviderPart.d)) {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(EditProviderPart.d);
            if (((JSONObject)localObject1).has("comboItem"))
            {
              QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has combo item" });
              this.b.add(Integer.valueOf(4));
            }
            else if (((JSONObject)localObject1).has("musicItem"))
            {
              QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has music item" });
              this.b.add(Integer.valueOf(2));
            }
            else if (((JSONObject)localObject1).has("filterItem"))
            {
              QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has filter item" });
            }
          }
          catch (JSONException localJSONException)
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", localJSONException);
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    a(3000, null);
    ((CaptureComboManager)QIMManager.a(5)).a(this.a);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (paramGenerateContext.d.saveMode != 0) {
      this.b.add(Integer.valueOf(7));
    }
    c();
    a(3006, null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (QzoneEditPictureAndVideoReportModel)c.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3006) {
        paramObject.a(this.b);
      }
      paramObject.b();
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("editVideoStateChanged we are not interested at this edit state ");
    paramObject.append(paramInt);
    QZLog.w("QzoneEditVideoPartRepor", 2, new Object[] { paramObject.toString() });
  }
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 9) && (paramMessage.arg1 == 12)) {
      a(paramMessage.arg1, null);
    }
    return super.a(paramMessage);
  }
  
  public void g()
  {
    super.g();
    ((CaptureComboManager)QIMManager.a(5)).b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoPartReport
 * JD-Core Version:    0.7.0.1
 */