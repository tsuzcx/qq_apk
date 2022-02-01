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
  public View a;
  public ArrayList<String> b = null;
  public int c = 1;
  public String d;
  public String e;
  public String f = "";
  public boolean g = true;
  public boolean h;
  public boolean i = true;
  public boolean j;
  public boolean k = true;
  public int l = -1;
  public int m = -1;
  public String n;
  public int o = -1;
  public String p;
  private QzoneEditPicturePartComment q;
  private QzoneEditPicturePartScheduleDelete r;
  private QzoneEditPicturePartSave s;
  private boolean t;
  private final QzoneEditPictureActivity u;
  private boolean v;
  
  public QzoneEditPicturePartManager(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.u = paramQzoneEditPictureActivity;
    this.v = paramBoolean;
  }
  
  private QzoneEditPicturePartReport Z()
  {
    Iterator localIterator = W().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof QzoneEditPicturePartReport)) {
        return (QzoneEditPicturePartReport)localEditVideoPart;
      }
    }
    return null;
  }
  
  private void aa()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.u.findViewById(2063991313);
    Object localObject = (LinearLayout)LayoutInflater.from(this.u).inflate(2131628679, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.d, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131443549).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131443547).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131443550).setVisibility(8);
    localObject = (RelativeLayout)this.u.getLayoutInflater().inflate(2131628677, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, M().getContext().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    int i1;
    if (LiuHaiUtils.j > 0) {
      i1 = LiuHaiUtils.j;
    } else {
      i1 = AIOUtils.b(60.0F, this.u.getResources());
    }
    localLayoutParams.bottomMargin = i1;
    View localView = new View(this.u);
    localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localRelativeLayout.addView(localView);
    this.a = localView;
  }
  
  public void a(int paramInt)
  {
    QzoneEditPicturePartReport localQzoneEditPicturePartReport = Z();
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
    int i1 = (paramEditVideoParams.c | 0x2000) & 0xFFFFEFFF;
    if (d())
    {
      super.a(new EditVideoParams(paramEditVideoParams.a, i1 & 0xFFFFFDFF, paramEditVideoParams.e, paramEditVideoParams.d));
      a(this.J);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.a, i1, paramEditVideoParams.e, paramEditVideoParams.d));
  }
  
  protected void a(List<EditVideoPart> paramList)
  {
    super.a(paramList);
    if (d())
    {
      Object localObject = new QzoneEditPicturePartComment(this);
      this.q = ((QzoneEditPicturePartComment)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartScheduleDelete(this);
      this.r = ((QzoneEditPicturePartScheduleDelete)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartSave(this);
      this.s = ((QzoneEditPicturePartSave)localObject);
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
    this.t = paramBoolean;
  }
  
  public void b()
  {
    super.b();
    a(3006);
  }
  
  public void c()
  {
    if (d()) {
      aa();
    }
    super.c();
  }
  
  public boolean d()
  {
    return this.v;
  }
  
  public boolean e()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartManager
 * JD-Core Version:    0.7.0.1
 */