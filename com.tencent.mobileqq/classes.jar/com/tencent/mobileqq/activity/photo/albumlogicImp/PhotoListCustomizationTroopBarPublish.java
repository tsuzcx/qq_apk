package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationTroopBarPublish
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopBarPublish";
  private boolean a;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  
  PhotoListCustomizationTroopBarPublish(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NewPhotoListActivity] [onActivityResult] selectedPhotoList = ");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 4, localStringBuilder.toString());
    }
    if ((paramInt2 == -1) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      return;
    }
    PhotoUtils.onSendResult(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.g, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
    this.jdField_a_of_type_Boolean = "tribe".equals(paramIntent.getStringExtra("video_refer"));
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    super.a(paramView, paramBundle, paramInt, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) {
      TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!Utils.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131718574), 0).a();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if (paramView == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (paramView.fileSize > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit)
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      if (this.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        localObject1 = new Intent("key_video_size_overflow");
        ((Intent)localObject1).putExtra("className", paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.sendBroadcast((Intent)localObject1);
      }
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (paramView.mDuration - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration > 999L))
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131708114));
      paramView.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = new Intent("key_video_time_overflow");
        ((Intent)localObject1).putExtra("className", paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.sendBroadcast((Intent)localObject1);
      }
      return;
    }
    Object localObject2 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject2).containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      ((HashMap)localObject2).put(paramView.path, localPair);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(paramView.path);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean)
    {
      ((Intent)localObject1).putExtra("file_send_path", paramView.path);
      ((Intent)localObject1).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      ((Intent)localObject1).putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
      ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
      ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
      ((Intent)localObject1).putExtra("media_info", paramView);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramView.path);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivityHandler.a();
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListCustomizationTroopBarPublish.1(this, (Intent)localObject1, (ArrayList)localObject2), paramView);
        return;
      }
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, (Intent)localObject1, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaLangString);
      PhotoListData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaUtilHashMap);
      paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
        ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, true, true);
      return;
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras((Intent)localObject1);
    ((Intent)localObject2).putExtra("file_send_path", paramView.path);
    ((Intent)localObject2).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject2).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject2).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.d);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    ((Intent)localObject2).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult((Intent)localObject2, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopBarPublish
 * JD-Core Version:    0.7.0.1
 */