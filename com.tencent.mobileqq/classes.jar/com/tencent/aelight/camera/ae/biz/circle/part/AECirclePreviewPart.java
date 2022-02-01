package com.tencent.aelight.camera.ae.biz.circle.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoPreviewAdapter;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleChangeBottomTabVisibleEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleShowPhotoPreviewEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class AECirclePreviewPart
  extends AECircleBasePart
  implements View.OnClickListener, SimpleEventReceiver, PagerSnapHelper.PagerEventListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private PhotoPreviewAdapter jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoPreviewAdapter;
  private NumberCheckBox jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
  private PagerSnapHelper jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private List<LocalMediaInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private FrameLayout b;
  
  public AECirclePreviewPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(this);
  }
  
  private RecyclerView.OnItemTouchListener a()
  {
    return new AECirclePreviewPart.1(this);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1)
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().canPickVideo)
      {
        QQToast.a(a(), HardCodeUtil.a(2064515225), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return false;
      }
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(a(), paramLocalMediaInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return false;
      }
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
    AECircleMultiUnit.a(a(), 0, true);
  }
  
  private void c()
  {
    Object localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition());
    if (((LocalMediaInfo)localObject1).selectStatus == 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum >= this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b >= 1000L)
      {
        QQToast.a(a(), a((LocalMediaInfo)localObject1), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b = l;
      }
      return;
    }
    if (!a((LocalMediaInfo)localObject1)) {
      return;
    }
    ((LocalMediaInfo)localObject1).selectStatus = 1;
    String str = ((LocalMediaInfo)localObject1).path;
    Object localObject2 = MimeHelper.getMimeType(((LocalMediaInfo)localObject1).mMimeType);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().n) && (localObject2 != null) && ("video".equals(localObject2[0])))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
      ((PhotoListBaseData)localObject2).c += 1;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().c == 1) {
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().a = ((LocalMediaInfo)localObject1);
      }
    }
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject1).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject1).mMimeType)))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
      ((PhotoListBaseData)localObject2).d += 1;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedIndex.add(((LocalMediaInfo)localObject1).position);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, localObject1);
    localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, localObject1);
    }
    ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition()));
    localObject1 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject1).containsKey(str)) {
      ((HashMap)localObject1).put(str, new Pair(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumName));
    }
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  private void d()
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition());
    int i = localLocalMediaInfo.selectStatus;
    if ((i != 1) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum >= this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b >= 1000L)
      {
        QQToast.a(a(), a(localLocalMediaInfo), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b = l;
      }
      return;
    }
    if (!a(localLocalMediaInfo)) {
      return;
    }
    if (i == 1) {
      i = 2;
    } else {
      i = 1;
    }
    localLocalMediaInfo.selectStatus = i;
    if (localLocalMediaInfo.selectStatus == 1) {
      i = 1;
    } else {
      i = 0;
    }
    String str = localLocalMediaInfo.path;
    Object localObject1 = PresendPicMgr.a();
    Object localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    if (i != 0)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().n) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject1).c += 1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().c == 1) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().a = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject1).d += 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedIndex.add(localLocalMediaInfo.position);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, localObject1);
      }
      ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition()));
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new Pair(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumName));
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().n) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject2).c -= 1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().c == 1) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().a = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject2).d -= 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.remove(str);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedIndex.remove(localLocalMediaInfo.position);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(str);
      if (localObject1 != null) {
        ((PresendPicMgr)localObject1).b(str, 1013);
      }
      localObject1 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(str);
      }
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).remove(str);
      }
    }
    i = localLocalMediaInfo.selectStatus;
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum);
    } else if (i == 3) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  public String a()
  {
    return "AECirclePreviewPart";
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().maxSelectNum;
    return a().getResources().getString(2131694856, new Object[] { Integer.valueOf(i) });
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getAdapterPosition();
    paramViewHolder = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (paramViewHolder.selectStatus == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(paramViewHolder.path) + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    AEReportUtils.a(QAlbumUtil.getMediaType(paramViewHolder));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2064122483));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2064122487));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122490));
    this.b = ((FrameLayout)paramView.findViewById(2064122486));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2064122488));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper = new PagerSnapHelper();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoPreviewAdapter = new PhotoPreviewAdapter(a(), this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoPreviewAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnItemTouchListener(a());
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.next();
      if ((QAlbumUtil.getMediaType(localLocalMediaInfo) != 2) && ((TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) || (!"image/gif".equals(localLocalMediaInfo.mMimeType))))
      {
        i += 1;
      }
      else
      {
        paramList.remove();
        int j = this.jdField_a_of_type_Int;
        if (j > i) {
          this.jdField_a_of_type_Int = (j - 1);
        }
      }
    }
    paramList = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoPreviewAdapter;
    if (paramList != null) {
      paramList.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public boolean a()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    boolean bool = true;
    if (localFrameLayout != null)
    {
      if (localFrameLayout.getVisibility() != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
    {
      b();
      return true;
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleShowPhotoPreviewEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2064122487)
    {
      d();
      return;
    }
    if (paramView.getId() == 2064122488)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum < 1) {
        c();
      }
      b();
      return;
    }
    if (paramView.getId() == 2064122486) {
      b();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleShowPhotoPreviewEvent))
    {
      paramSimpleBaseEvent = (AECircleShowPhotoPreviewEvent)paramSimpleBaseEvent;
      this.jdField_a_of_type_Int = paramSimpleBaseEvent.mPosition;
      a(paramSimpleBaseEvent.mPhotoInfoList);
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.scrollToPosition(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      AECircleMultiUnit.a(a(), a().getResources().getColor(2131165411), false);
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      AEReportUtils.a(QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart
 * JD-Core Version:    0.7.0.1
 */