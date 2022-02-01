package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QzoneEditPicturePartManager
  extends EditPicPartManager
{
  public int a;
  public View a;
  private final QzoneEditPictureActivity jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity;
  private QzoneEditPicturePartComment jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartComment;
  private QzoneEditPicturePartSave jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartSave;
  private QzoneEditPicturePartScheduleDelete jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartScheduleDelete;
  public String a;
  public ArrayList<String> a;
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
  public String e;
  public boolean e = true;
  private boolean f;
  private boolean g;
  
  public QzoneEditPicturePartManager(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity = paramQzoneEditPictureActivity;
    this.g = paramBoolean;
  }
  
  private void A()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity.findViewById(2064122499);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity).inflate(2131562251, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.jdField_a_of_type_Int, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131375363).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375361).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375364).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131562249, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, a().getContext().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    int i;
    if (LiuHaiUtils.e > 0) {
      i = LiuHaiUtils.e;
    } else {
      i = AIOUtils.b(60.0F, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity.getResources());
    }
    localLayoutParams.bottomMargin = i;
    View localView = new View(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPictureActivity);
    localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localRelativeLayout.addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView;
  }
  
  private QzoneEditPicturePartReport a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof QzoneEditPicturePartReport)) {
        return (QzoneEditPicturePartReport)localEditVideoPart;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    QzoneEditPicturePartReport localQzoneEditPicturePartReport = a();
    if (localQzoneEditPicturePartReport != null) {
      localQzoneEditPicturePartReport.a(paramInt, null);
    }
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    a(3005);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    int i = (paramEditVideoParams.jdField_c_of_type_Int | 0x2000) & 0xFFFFEFFF;
    if (a())
    {
      super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, i & 0xFFFFFDFF, paramEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, i, paramEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
  }
  
  protected void a(List<EditVideoPart> paramList)
  {
    super.a(paramList);
    if (a())
    {
      Object localObject = new QzoneEditPicturePartComment(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartComment = ((QzoneEditPicturePartComment)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartScheduleDelete(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartScheduleDelete = ((QzoneEditPicturePartScheduleDelete)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartSave(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartSave = ((QzoneEditPicturePartSave)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new QzoneEditVideoPartReport(this));
      return;
    }
    catch (Exception paramList)
    {
      label94:
      break label94;
    }
    QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public void b()
  {
    super.b();
    a(3006);
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    if (a()) {
      A();
    }
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartManager
 * JD-Core Version:    0.7.0.1
 */