package com.tencent.aelight.camera.ae.album.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AENewPhotoListFragment
  extends AEAbstractPhotoListFragment
{
  public Handler a;
  
  public AENewPhotoListFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new AENewPhotoListFragment.NewPhotoListActivityHandler(this);
  }
  
  public int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a(paramString) != null)) {
      return AlbumUtil.getMediaType(a(paramString));
    }
    return -1;
  }
  
  protected Dialog a()
  {
    Dialog localDialog = new Dialog(getActivity(), 2131756189);
    localDialog.setContentView(2131559561);
    return localDialog;
  }
  
  public AEAbstractAlbumListFragment a()
  {
    return new AEAlbumListFragment();
  }
  
  protected AEPhotoListLogic a()
  {
    return new AEPhotoListLogicAECircle(this);
  }
  
  public LocalMediaInfo a(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a;
    Object localObject1;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localObject1 = (LocalMediaInfo)localPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localObject2 = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
      }
    }
    if ((localObject2 != null) && ((((LocalMediaInfo)localObject2).mediaWidth == 0) || (((LocalMediaInfo)localObject2).mediaHeight == 0)))
    {
      localObject1 = new MediaMetadataUtils.MetaData();
      MediaMetadataUtils.a(paramString, (MediaMetadataUtils.MetaData)localObject1);
      ((LocalMediaInfo)localObject2).mediaWidth = localObject1.a[0];
      ((LocalMediaInfo)localObject2).mediaHeight = localObject1.a[1];
      ((LocalMediaInfo)localObject2).rotation = localObject1.a[2];
      if (localPhotoCommonBaseData.allMediaInfoHashMap != null)
      {
        paramString = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
        if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
        {
          paramString.mediaWidth = ((LocalMediaInfo)localObject2).mediaWidth;
          paramString.mediaHeight = ((LocalMediaInfo)localObject2).mediaHeight;
          paramString.rotation = ((LocalMediaInfo)localObject2).rotation;
        }
      }
    }
    return localObject2;
  }
  
  public Class a()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AENewPhotoListFragment.1(this));
  }
  
  public void b(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(getActivity(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PhotoListActivity", 2, "scanMediaFile :", paramString);
    }
  }
  
  public void i()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && ("$RecentAlbumId".equals(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.albumId))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s) && ("$VideoAlbumId".equals(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.albumId)))) {
      a(false, true);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() != 2131370603) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(paramView, new Bundle(), 2, null);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!CheckPermission.isHasStoragePermission(getActivity().getApplicationContext())) {
      CheckPermission.requestStorePermission(getActivity(), null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment
 * JD-Core Version:    0.7.0.1
 */