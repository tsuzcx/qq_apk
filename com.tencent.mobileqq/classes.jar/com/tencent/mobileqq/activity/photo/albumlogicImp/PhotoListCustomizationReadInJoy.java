package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
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
import java.util.List;

public class PhotoListCustomizationReadInJoy
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy";
  private boolean i;
  
  PhotoListCustomizationReadInJoy(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.i)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    ArrayList localArrayList = this.e.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NewPhotoListActivity] [onActivityResult] selectedPhotoList = ");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 4, localStringBuilder.toString());
    }
    if (paramInt2 == -1)
    {
      if (this.i)
      {
        this.c.setResult(-1, paramIntent);
        this.c.finish();
      }
    }
    else if (paramInt1 == 17)
    {
      if ((this.i) && (paramIntent != null))
      {
        this.c.setResult(0, paramIntent);
        this.c.finish();
      }
      AlbumUtil.sLastAlbumRecordTime = 0L;
      return;
    }
    PhotoUtils.onSendResult(this.c, paramInt1, paramInt2, paramIntent, this.b.k, ((PhotoOtherData)this.f).e);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.i = paramIntent.getBooleanExtra("readinjoy_video", false);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = this.c.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    }
    if (this.b.j)
    {
      paramLocalMediaInfo = AlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.e.albumId, this.e.albumName));
      }
      this.h.a(str);
      PhotoUtils.sendPhoto(this.c, localIntent, this.e.selectedPhotoList, 0, this.b.a);
      return;
    }
    if (!this.b.t)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.c, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.b.g);
    }
    else
    {
      localIntent.setClass(this.c, PhotoCropActivity.class);
      QQAlbumUtils.a(localIntent, this.e.albumId, str, this.b.N);
      localIntent.putExtra("PHOTOLIST_START_POSITION", this.h.m.findFirstVisibleItemPosition());
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
    localIntent.addFlags(603979776);
    paramLocalMediaInfo = this.c.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (!((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyUploadAvatarFragmentClazz().getName().equals(paramLocalMediaInfo))
    {
      this.c.startActivity(localIntent);
      this.c.finish();
    }
    else
    {
      this.c.startActivityForResult(localIntent, 10014);
    }
    AlbumUtil.anim(this.c, true, true);
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    if ((this.i) && (paramList != null))
    {
      int j = paramList.size() - 1;
      while (j >= paramInt)
      {
        if (!((LocalMediaInfo)paramList.get(j)).path.endsWith(".mp4")) {
          paramList.remove(j);
        }
        j -= 1;
      }
    }
    super.a(paramList, paramInt);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    if (this.i)
    {
      AlbumUtil.clearSelectItemInfo();
      AlbumUtil.a();
      this.c.setResult(0, this.c.getIntent());
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
      return;
    }
    super.b(paramView);
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
    if ((paramView.fileSize > this.e.filter.videoSizeLimit) && (!this.i))
    {
      paramView = DialogUtil.a(this.c, "你选择的视频文件过大，无法发送。");
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
      if (this.i)
      {
        this.b.u.a();
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListCustomizationReadInJoy.1(this, (Intent)localObject1, (ArrayList)localObject2), paramView);
        return;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy
 * JD-Core Version:    0.7.0.1
 */