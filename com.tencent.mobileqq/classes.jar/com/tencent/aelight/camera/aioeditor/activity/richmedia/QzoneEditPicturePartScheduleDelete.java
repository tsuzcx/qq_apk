package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class QzoneEditPicturePartScheduleDelete
  extends EditVideoPart
  implements View.OnClickListener
{
  private LinearLayout a;
  private Button b;
  
  public QzoneEditPicturePartScheduleDelete(@NonNull QzoneEditPicturePartManager paramQzoneEditPicturePartManager)
  {
    super(paramQzoneEditPicturePartManager);
  }
  
  private void c()
  {
    DialogUtil.a(t().getActivity(), 230).setMessage(2131915136).setPositiveButton(2131914647, new QzoneEditPicturePartScheduleDelete.3(this)).setNegativeButton(2131888010, new QzoneEditPicturePartScheduleDelete.2(this)).show();
  }
  
  public void a()
  {
    super.a();
    this.a = ((LinearLayout)d(2131443549));
    this.b = ((Button)d(2131433458));
    this.b.setOnClickListener(new QzoneEditPicturePartScheduleDelete.1(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
  }
  
  public QzoneEditPicturePartManager b()
  {
    return (QzoneEditPicturePartManager)this.t;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartScheduleDelete
 * JD-Core Version:    0.7.0.1
 */