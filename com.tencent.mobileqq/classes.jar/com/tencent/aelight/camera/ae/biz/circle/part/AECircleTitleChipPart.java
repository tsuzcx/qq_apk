package com.tencent.aelight.camera.ae.biz.circle.part;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

public class AECircleTitleChipPart
  extends AECircleBasePart
  implements View.OnClickListener
{
  private View a;
  private TextView b;
  private long f;
  private boolean g;
  
  public AECircleTitleChipPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.c.a(this);
  }
  
  protected void a(View paramView)
  {
    this.a = paramView.findViewById(2063991165);
    this.b = ((TextView)paramView.findViewById(2063991166));
    this.a.setVisibility(0);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (this.g) {
      this.b.setVisibility(0);
    } else {
      this.b.setVisibility(8);
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String b()
  {
    return "AECircleTitleChipPart";
  }
  
  protected void d()
  {
    if (this.c.e().selectedPhotoList.size() + this.c.g().initialHasPickedNum < 1)
    {
      this.b.setEnabled(false);
      return;
    }
    this.b.setEnabled(true);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.f < 1000L) {
      return;
    }
    this.f = System.currentTimeMillis();
    if (this.c == null) {
      return;
    }
    int i = paramView.getId();
    if (i == 2063991165)
    {
      this.c.a(paramView);
      return;
    }
    if (i == 2063991166) {
      this.c.m();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleTitleChipPart
 * JD-Core Version:    0.7.0.1
 */