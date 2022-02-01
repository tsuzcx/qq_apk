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
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PicPreviewMoveAdapter jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter;
  private PicDragHelperCallback jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback;
  private ItemTouchHelper jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
  private TextView b;
  
  public AECircleSelectPanelPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122497);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2064122589));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122783));
    this.b = ((TextView)paramView.findViewById(2064122784));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122747));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter = new PicPreviewMoveAdapter(paramView.getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    paramView = new LinearLayoutManager(paramView.getContext());
    paramView.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new PicItemDecoration(8));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.a(new AECircleSelectPanelPart.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback = new PicDragHelperCallback(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter, null);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback.a(1.2F);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback.b(0.9F);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback.a(new AECircleSelectPanelPart.3(this));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper = new ItemTouchHelper(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback);
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.attachToRecyclerView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.b.setVisibility(0);
    a();
    this.b.setOnClickListener(new AECircleSelectPanelPart.4(this));
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo) && (AECommonUtil.a(a(), "AECircleSelectPanelPart")))
    {
      AEReportUtils.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AECircleSelectPanelPart.5(this));
  }
  
  public String a()
  {
    return "AECircleSelectPanelPart";
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum;
    if (i < 1)
    {
      this.b.setEnabled(false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("下一步(");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    this.b.setText((CharSequence)localObject);
    this.b.setEnabled(true);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
  }
  
  public boolean a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
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
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.notifyDataSetChanged();
          if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= 2)
          {
            SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
            boolean bool = localSharedPreferences.getBoolean("ae_camera_is_show_tip", true);
            View localView = a().findViewById(2064122370);
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
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() - 1);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        a();
        SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      }
    }
    else if ((paramSimpleBaseEvent instanceof AECircleTitleAlbumMenuChangeEvent))
    {
      if (((AECircleTitleAlbumMenuChangeEvent)paramSimpleBaseEvent).getIsShow())
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      else if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart
 * JD-Core Version:    0.7.0.1
 */