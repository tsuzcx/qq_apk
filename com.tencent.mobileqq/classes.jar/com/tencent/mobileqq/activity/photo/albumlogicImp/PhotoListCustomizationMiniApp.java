package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationMiniApp
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp";
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  
  PhotoListCustomizationMiniApp(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    paramView.putExtra("from_miniapp_cur_sizetype", this.jdField_a_of_type_Int);
    return paramView;
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 6) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694855, new Object[] { Integer.valueOf(i) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694859, new Object[] { Integer.valueOf(i) });
    }
    return super.a(paramLocalMediaInfo);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        FileUtils.deleteDirectory(new File(str).getParent());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(0, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_miniapp_enable_bottombar", false);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        int k = ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject);
        localObject = ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject);
        if ((k == 1) && (localObject != null)) {
          localHashMap.put(Integer.valueOf(j), localObject);
        }
        j += 1;
      }
      i += 1;
    }
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    paramIntent.setComponent(null);
    paramIntent.setAction(paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME"));
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.sendBroadcast(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d("PhotoListCustomizationMiniApp", 1, "sendPhoto fail!", paramIntent);
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 2;
      return;
    }
    ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
  }
  
  public void b(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
      return;
    }
    QLog.e("PhotoListCustomizationMiniApp", 2, "onTitleBtnRightClick");
    localObject = new Intent();
    String str = paramView.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListCustomizationMiniApp", 2, String.format("sendPhoto action=%s", new Object[] { str }));
    }
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListCustomizationMiniApp", 2, String.format("sendPhoto extras=%s", new Object[] { paramView.getExtras() }));
      }
      ((Intent)localObject).setComponent(null);
      ((Intent)localObject).setAction(str);
      ((Intent)localObject).setFlags(paramView.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
    }
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
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请选择不超过");
      ((StringBuilder)localObject1).append((float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F);
      ((StringBuilder)localObject1).append("G的视频");
      paramView = DialogUtil.a(paramView, ((StringBuilder)localObject1).toString());
      paramView.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      return;
    }
    if (paramView.mDuration > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请选择不超过");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration / 60L / 1000L);
      ((StringBuilder)localObject1).append("分钟的视频");
      paramView = DialogUtil.a(paramView, ((StringBuilder)localObject1).toString());
      paramView.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult((Intent)localObject2, 17);
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp
 * JD-Core Version:    0.7.0.1
 */