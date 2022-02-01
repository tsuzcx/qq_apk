package com.tencent.aelight.camera.ae.biz.circle.part;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleChangeBottomTabVisibleEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleTitleAlbumMenuChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicItemDecoration;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.ArrayList;

public class AECircleSelectPanelPart
  extends AECircleBasePart
  implements SimpleEventReceiver
{
  private ItemTouchHelper a;
  private PicDragHelperCallback b;
  private RecyclerView f;
  private TextView g;
  private View h;
  private TextView i;
  private ImageView j;
  private PicPreviewMoveAdapter k;
  private boolean l = true;
  
  public AECircleSelectPanelPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.c.a(this);
  }
  
  private void b(View paramView)
  {
    this.h = paramView.findViewById(2063991311);
    this.f = ((RecyclerView)paramView.findViewById(2063991406));
    this.g = ((TextView)paramView.findViewById(2063991558));
    this.i = ((TextView)paramView.findViewById(2063991559));
    this.j = ((ImageView)paramView.findViewById(2063991521));
    this.h.setVisibility(8);
    this.k = new PicPreviewMoveAdapter(paramView.getContext(), this.c);
    this.k.a(this.c.c.selectedPhotoList);
    paramView = new LinearLayoutManager(paramView.getContext());
    paramView.setOrientation(0);
    this.f.setLayoutManager(paramView);
    this.f.addItemDecoration(new PicItemDecoration(8));
    this.f.setAdapter(this.k);
    this.k.a(new AECircleSelectPanelPart.2(this));
    this.b = new PicDragHelperCallback(this.k, null);
    this.b.a(1.2F);
    this.b.b(0.9F);
    this.b.a(new AECircleSelectPanelPart.3(this));
    this.a = new ItemTouchHelper(this.b);
    this.a.attachToRecyclerView(this.f);
    this.i.setVisibility(0);
    d();
    this.i.setOnClickListener(new AECircleSelectPanelPart.4(this));
    if ((this.c != null) && (this.c.m.canPickVideo) && (AECommonUtil.a(g(), "AECircleSelectPanelPart")) && (this.l) && (!this.c.p()))
    {
      AEReportUtils.a();
      this.j.setVisibility(0);
    }
    else
    {
      this.j.setVisibility(8);
    }
    this.j.setOnClickListener(new AECircleSelectPanelPart.5(this));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
  }
  
  public boolean a()
  {
    View localView = this.h;
    boolean bool = true;
    if (localView != null)
    {
      if (localView.getVisibility() != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public String b()
  {
    return "AECircleSelectPanelPart";
  }
  
  protected void d()
  {
    int m = this.c.e().selectedPhotoList.size() + this.c.g().initialHasPickedNum;
    if (m < 1)
    {
      this.i.setEnabled(false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("下一步(");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    this.i.setText((CharSequence)localObject);
    this.i.setEnabled(true);
  }
  
  public void e()
  {
    this.l = false;
    ImageView localImageView = this.j;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    localArrayList.add(AECircleTitleAlbumMenuChangeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent))
    {
      if ((this.c != null) && (this.c.c != null) && (this.c.c.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.c.c.selectedPhotoList.size() > 0)
        {
          this.h.setVisibility(0);
          this.k.notifyDataSetChanged();
          if (this.c.c.selectedPhotoList.size() >= 2)
          {
            SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
            boolean bool = localSharedPreferences.getBoolean("ae_camera_is_show_tip", true);
            View localView = g().findViewById(2063991244);
            if (bool)
            {
              localView.setVisibility(0);
              localSharedPreferences.edit().putBoolean("ae_camera_is_show_tip", false).apply();
              localView.postDelayed(new AECircleSelectPanelPart.1(this, localView), 4000L);
            }
            else
            {
              localView.setVisibility(8);
            }
          }
          if (!((AECircleSelectChangeEvent)paramSimpleBaseEvent).getImageDragEventFlag()) {
            this.f.smoothScrollToPosition(this.c.c.selectedPhotoList.size() - 1);
          }
        }
        else
        {
          this.h.setVisibility(8);
        }
        d();
        SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      }
    }
    else if ((paramSimpleBaseEvent instanceof AECircleTitleAlbumMenuChangeEvent))
    {
      if (((AECircleTitleAlbumMenuChangeEvent)paramSimpleBaseEvent).getIsShow())
      {
        this.h.setVisibility(8);
      }
      else if ((this.c != null) && (this.c.c != null) && (this.c.c.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.c.c.selectedPhotoList.size() > 0) {
          this.h.setVisibility(0);
        }
      }
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart
 * JD-Core Version:    0.7.0.1
 */