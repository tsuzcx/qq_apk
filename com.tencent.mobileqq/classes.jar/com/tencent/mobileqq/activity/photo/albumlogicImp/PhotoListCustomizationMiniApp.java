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
  private boolean i = false;
  private int j = 0;
  
  PhotoListCustomizationMiniApp(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        FileUtils.deleteDirectory(new File(str).getParent());
      }
      this.c.setResult(0, paramIntent);
      this.c.finish();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.i = paramIntent.getBooleanExtra("from_miniapp_enable_bottombar", false);
    this.j = paramIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
    this.e.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int k = 0;
    int m = 0;
    while (k < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(k);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        int n = ((PhotoOtherData)this.f).a(this.e, (String)localObject);
        localObject = ((PhotoOtherData)this.f).b(this.e, (String)localObject);
        if ((n == 1) && (localObject != null)) {
          localHashMap.put(Integer.valueOf(m), localObject);
        }
        m += 1;
      }
      k += 1;
    }
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    paramIntent.setComponent(null);
    paramIntent.setAction(paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME"));
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      this.c.sendBroadcast(paramIntent);
      this.c.finish();
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
      ((PhotoOtherData)this.f).d = 2;
      return;
    }
    ((PhotoOtherData)this.f).d = 0;
  }
  
  public Intent b(View paramView, int paramInt)
  {
    paramView = super.b(paramView, paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    paramView.putExtra("from_miniapp_cur_sizetype", this.j);
    return paramView;
  }
  
  public void b(View paramView)
  {
    paramView = this.c.getIntent();
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int k;
    if (this.e.selectedPhotoList != null) {
      k = this.e.selectedPhotoList.size();
    } else {
      k = 0;
    }
    StatisticConstants.b(paramView, k);
    if (!this.b.l)
    {
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
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
      this.c.sendBroadcast((Intent)localObject);
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
    }
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int k = this.e.maxSelectNum;
    if (this.e.showMediaType == 6) {
      return this.c.getResources().getString(2131892558, new Object[] { Integer.valueOf(k) });
    }
    if (this.e.showMediaType == 2) {
      return this.c.getResources().getString(2131892562, new Object[] { Integer.valueOf(k) });
    }
    return super.c(paramLocalMediaInfo);
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!Utils.b())
    {
      QQToast.makeText(this.c, this.c.getResources().getString(2131916075), 0).show();
      return;
    }
    paramView = this.h.t.a(paramInt);
    if (paramView == null) {
      return;
    }
    Object localObject1 = this.c.getIntent();
    if (paramView.fileSize > this.e.filter.videoSizeLimit)
    {
      paramView = this.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请选择不超过");
      ((StringBuilder)localObject1).append((float)this.e.filter.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F);
      ((StringBuilder)localObject1).append("G的视频");
      paramView = DialogUtil.a(paramView, ((StringBuilder)localObject1).toString());
      paramView.setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      return;
    }
    if (paramView.mDuration > this.e.filter.videoMaxDuration)
    {
      paramView = this.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请选择不超过");
      ((StringBuilder)localObject1).append(this.e.filter.videoMaxDuration / 60L / 1000L);
      ((StringBuilder)localObject1).append("分钟的视频");
      paramView = DialogUtil.a(paramView, ((StringBuilder)localObject1).toString());
      paramView.setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      return;
    }
    Object localObject2 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject2).containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.e.albumId, this.e.albumName);
      ((HashMap)localObject2).put(paramView.path, localPair);
    }
    this.h.a(paramView.path);
    if (!this.b.c)
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
      PhotoUtils.sendPhoto(this.c, (Intent)localObject1, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.e.isSingleMode)
    {
      paramView = this.c.getIntent();
      paramView.putExtra("ALBUM_NAME", this.e.albumName);
      paramView.putExtra("ALBUM_ID", this.e.albumId);
      localObject1 = this.h.t.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.e.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.b.f);
      paramView.putExtra("PasterConstants.paster_id", this.b.h);
      paramView.putExtra("PasterConstants.paster_cate_id", this.b.i);
      PhotoListData.w = this.h.m.findFirstVisibleItemPosition();
      localObject2 = this.e.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.b.g);
      paramView.setClass(this.c, NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.size() > 0)) {
        ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X8005674", "0X8005674", 0, this.e.selectedPhotoList.size(), 0, "", "", "", "");
      }
      this.c.startActivity(paramView);
      this.c.finish();
      AlbumUtil.anim(this.c, true, true);
      return;
    }
    localObject2 = new Intent(this.c, ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras((Intent)localObject1);
    ((Intent)localObject2).putExtra("file_send_path", paramView.path);
    ((Intent)localObject2).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject2).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject2).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.b.o);
    ((Intent)localObject2).putExtra("uintype", this.b.m);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.b.B)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    }
    this.c.startActivityForResult((Intent)localObject2, 17);
  }
  
  public void k()
  {
    super.k();
    if (this.i) {
      this.h.h.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp
 * JD-Core Version:    0.7.0.1
 */