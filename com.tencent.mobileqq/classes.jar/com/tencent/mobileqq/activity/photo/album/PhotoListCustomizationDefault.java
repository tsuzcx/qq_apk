package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.Holder;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PhotoListCustomizationDefault
  extends PhotoListCustomizationBase<PhotoOtherData>
{
  protected PhotoListData b;
  protected NewPhotoListActivity c;
  
  public PhotoListCustomizationDefault(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    this.c = ((NewPhotoListActivity)paramAbstractPhotoListActivity);
    this.g = new PhotoListData();
    this.b = ((PhotoListData)this.g);
  }
  
  public Holder a(@NonNull Holder paramHolder, int paramInt)
  {
    return super.a(paramHolder, paramInt);
  }
  
  public void a()
  {
    super.a();
    ArrayList localArrayList = this.e.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateButton selectedPhotoList.size()=");
      localStringBuilder.append(localArrayList.size());
      QLog.d("_photo", 2, localStringBuilder.toString());
    }
    if (this.c.qualityCheckBox != null)
    {
      if (i == 0)
      {
        this.c.qualityCheckBox.setChecked(false);
        this.c.qualityCheckBox.setEnabled(false);
      }
      this.c.qualityCheckBox.setVisibility(8);
      if (this.b.d)
      {
        this.c.qualityCheckBox.setVisibility(0);
        if (i != 0) {
          this.c.qualityCheckBox.setEnabled(true);
        }
      }
    }
    if (this.c.qualityTv != null)
    {
      if (i == 0) {
        this.c.qualityTv.setEnabled(false);
      }
      this.c.qualityTv.setVisibility(8);
      if (this.b.d)
      {
        this.c.qualityTv.setVisibility(0);
        if (i != 0) {
          this.c.qualityTv.setEnabled(true);
        }
      }
    }
    if (this.c.qualityCountTv != null)
    {
      if (i == 0) {
        this.c.qualityCountTv.setEnabled(false);
      }
      this.c.qualityCountTv.setVisibility(8);
      if ((this.b.d) && (i != 0)) {
        this.c.qualityCountTv.setEnabled(true);
      }
      if (!this.b.e) {
        this.c.qualityCountTv.setVisibility(8);
      }
    }
    f();
    if (this.c.magicStickBtn != null)
    {
      if (this.b.f)
      {
        if ((localArrayList.size() == 1) && ((((PhotoOtherData)this.f).g == null) || (((PhotoOtherData)this.f).g.size() <= 0)) && (((PhotoOtherData)this.f).a(this.e, (String)localArrayList.get(0)) == 0))
        {
          this.c.magicStickBtn.setEnabled(true);
          return;
        }
        this.c.magicStickBtn.setEnabled(false);
        return;
      }
      this.c.magicStickBtn.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.e.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NewPhotoListActivity] [onActivityResult] selectedPhotoList = ");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 4, localStringBuilder.toString());
    }
    this.b.J = paramInt1;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 16)
      {
        if (paramInt1 != 10007)
        {
          if (paramInt1 != 10010)
          {
            if (paramInt1 == 10014)
            {
              this.c.setResult(-1, paramIntent);
              this.c.finish();
            }
          }
          else
          {
            if (paramIntent == null) {
              return;
            }
            this.e.selectedPhotoList = paramIntent.getStringArrayListExtra("img_list");
          }
        }
        else
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
          paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
          this.c.setResult(-1, paramIntent);
          this.c.finish();
        }
      }
      else {
        a(true, this.c.getIntent());
      }
    }
    else if (paramInt1 == 17)
    {
      QAlbumUtil.sLastAlbumRecordTime = 0L;
      return;
    }
    QQAlbumUtils.a(this.c, paramInt1, paramInt2, paramIntent, this.b.k, ((PhotoOtherData)this.f).e);
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQAlbum initData(),intent extras is:");
      ((StringBuilder)localObject).append(paramIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, ((StringBuilder)localObject).toString());
    }
    super.a(paramIntent);
    if (paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false))
    {
      this.e.filter.needVideo = false;
      this.e.filter.needGif = false;
    }
    this.b.q = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    ReplacePhotoDataUtil.a(this.c, paramIntent, false, this.b.s);
    this.b.b = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.b.b == null) {
      this.b.b = new HashMap(1);
    }
    this.e.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    ((PhotoOtherData)this.f).g = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.b.d = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.b.e = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    ((PhotoOtherData)this.f).e = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.b.a = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.b.j = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.b.k = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.b.m = paramIntent.getIntExtra("uintype", -1);
    ((PhotoOtherData)this.f).d = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.e.isSingleMode = false;
    }
    this.b.l = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.b.n = paramIntent.getStringExtra("uinname");
    this.b.o = paramIntent.getStringExtra("uin");
    this.e.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.b.c = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.e.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    boolean bool = paramIntent.getBooleanExtra("NEED_HEIF", false);
    if (bool) {
      this.e.filter.needHeif = bool;
    }
    if (!this.b.f) {
      this.b.f = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if (this.b.f)
    {
      this.b.g = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.b.h = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.b.i = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.b.r = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
    if (this.e.isShowQzoneAlbum)
    {
      localObject = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
      if (localObject != null)
      {
        if (this.b.v == null) {
          this.b.v = new QZoneGetAlbumListNumObserver((PhotoOtherData)this.f);
        }
        ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.b.v, Long.valueOf((String)localObject).longValue());
      }
      else
      {
        this.e.isShowQzoneAlbum = false;
      }
    }
    this.b.t = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
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
        if (((PhotoOtherData)this.f).a(this.e, (String)localObject) == 1)
        {
          localObject = ((PhotoOtherData)this.f).b(this.e, (String)localObject);
          if (localObject != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            localHashMap.put(Integer.valueOf(j), localSendVideoInfo);
          }
        }
        j += 1;
      }
      i += 1;
    }
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    if (paramBoolean)
    {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.c, paramIntent, paramArrayList, this.b.b, ((PhotoOtherData)this.f).d, false);
      return;
    }
    ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.c, paramIntent, paramArrayList, ((PhotoOtherData)this.f).d, this.b.a);
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    this.b.u.b();
    ArrayList localArrayList = this.e.selectedPhotoList;
    if ((paramMessage.obj instanceof String))
    {
      String str = (String)paramMessage.obj;
      QZLog.d("QQAlbum", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() >= PhotoCommonBaseData.getInstance().maxSelectNum)
      {
        paramMessage = this.c;
        QQToast.makeText(paramMessage, String.format(paramMessage.getResources().getString(2131892559), new Object[] { Integer.valueOf(PhotoCommonBaseData.getInstance().maxSelectNum) }), 0).show();
      }
      else
      {
        PhotoCommonBaseData.getInstance().selectedPhotoList.add(str);
        QQAlbumUtils.a(this);
      }
      QQAlbumUtils.a(this.c, str);
    }
  }
  
  public void a(View paramView)
  {
    if (this.h.o != null) {
      this.h.o.setClickable(false);
    }
    if (!this.e.selectedPhotoList.isEmpty()) {
      this.h.a((String)this.e.selectedPhotoList.get(this.e.selectedPhotoList.size() - 1));
    }
    if (this.e.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    this.c.getIntent();
    c();
  }
  
  public void a(View paramView, int paramInt)
  {
    a(this.h.t.a(paramInt), paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.e.selectedPhotoList;
    if (this.e.isSingleMode) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current select count:");
      localStringBuilder.append(paramView.size());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    paramView = this.h.t.a(paramInt);
    int i = paramView.selectStatus;
    if (!a(paramView, paramCheckBox)) {
      return;
    }
    boolean bool;
    if (i != 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      d(paramView);
    } else {
      e(paramView);
    }
    a(bool, paramView);
    this.h.a(paramInt, bool);
    this.h.b(bool ^ true);
    a();
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.e.selectedPhotoList.size() > 0)
    {
      d(((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(this.c, paramIntent, (String)this.e.selectedPhotoList.get(0), paramInt, paramBundle));
      if (this.c.magicStickBtn != null) {
        this.c.magicStickBtn.setClickable(false);
      }
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
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
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.b.j)
    {
      paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.e.albumId, this.e.albumName));
      }
      this.h.a(str);
      ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.c, localIntent, this.e.selectedPhotoList, 0, this.b.a);
      return;
    }
    if (!this.b.t)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.c, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.b.g);
      paramLocalMediaInfo = localIntent;
    }
    else
    {
      paramLocalMediaInfo = ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).toCropActivity(this.c, localIntent);
      QQAlbumUtils.a(paramLocalMediaInfo, this.e.albumId, str, this.b.N);
      paramLocalMediaInfo.putExtra("PHOTOLIST_START_POSITION", this.h.m.findFirstVisibleItemPosition());
    }
    paramLocalMediaInfo.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramLocalMediaInfo.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
    paramLocalMediaInfo.addFlags(603979776);
    this.c.startActivity(paramLocalMediaInfo);
    this.c.finish();
    QAlbumUtil.anim(this.c, true, true);
  }
  
  protected void a(Holder paramHolder, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ReplacePhotoDataUtil.a(paramLocalMediaInfo.path, this.b.s))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramHolder.e.setImageDrawable(this.c.getDrawable(2130839532));
      } else {
        paramHolder.e.setImageResource(2130839532);
      }
      paramHolder.e.setVisibility(0);
      return;
    }
    paramHolder.e.setVisibility(8);
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    if (paramList != null) {
      ReplacePhotoDataUtil.a(paramList, paramInt, null, this.b.s);
    }
    super.a(paramList, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.e.isSingleMode) {}
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.e.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
    }
    else
    {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.b.A);
    }
    if ((((PhotoOtherData)this.f).g != null) && (((PhotoOtherData)this.f).g.size() > 0))
    {
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((PhotoOtherData)this.f).g);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    else
    {
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.e.albumName);
    paramIntent.putExtra("ALBUM_ID", this.e.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    paramIntent.putExtra("PasterConstants.pasters_data", this.b.g);
    PhotoListData.w = this.h.m.findFirstVisibleItemPosition();
    paramIntent.setClass(this.c, NewPhotoPreviewActivity.class);
    paramIntent.addFlags(603979776);
    b(paramIntent);
    QAlbumUtil.anim(this.c, true, true);
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo, CheckBox paramCheckBox)
  {
    long l;
    if ((paramLocalMediaInfo.selectStatus != 1) && (this.e.selectedPhotoList.size() >= this.e.maxSelectNum))
    {
      l = System.currentTimeMillis();
      if (l - this.b.H >= 1000L)
      {
        QQToast.makeText(this.c, c(paramLocalMediaInfo), 0).show();
        paramCheckBox.setChecked(false);
        this.b.H = l;
      }
      return false;
    }
    if ((this.b.m == 9501) && (this.c.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (paramLocalMediaInfo.selectStatus != 1))
    {
      l = 0L;
      Iterator localIterator = this.e.selectedPhotoList.iterator();
      while (localIterator.hasNext()) {
        l += FileUtils.getFileSizes((String)localIterator.next());
      }
      if (l + FileUtils.getFileSizes(paramLocalMediaInfo.path) > 52428800L)
      {
        QQToast.makeText(this.c, "选择图片总大小不能超过50M", 0).show();
        paramCheckBox.setChecked(false);
        return false;
      }
    }
    if ((this.c.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (QAlbumUtil.isGif(paramLocalMediaInfo)) && (FileUtils.getFileSizes(paramLocalMediaInfo.path) > 3145728L))
    {
      QQToast.makeText(this.c, "图片文件过大", 0).show();
      paramCheckBox.setChecked(false);
      return false;
    }
    return true;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.e;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.b.B) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {
      return false;
    }
    int i = paramLocalMediaInfo.selectStatus;
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {
      return false;
    }
    if ((i == 2) && (paramBoolean) && (localPhotoCommonBaseData.selectedPhotoList.size() >= localPhotoCommonBaseData.maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.b.H >= 700L)
      {
        QQToast.makeText(this.c, c(paramLocalMediaInfo), 1000).show();
        paramLocalMediaInfo = this.b;
        paramLocalMediaInfo.H = l;
        paramLocalMediaInfo.I = true;
      }
      return false;
    }
    this.b.I = false;
    if (paramBoolean) {
      a(paramLocalMediaInfo);
    } else {
      b(paramLocalMediaInfo);
    }
    this.h.b(paramBoolean ^ true);
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if (super.a(paramList))
    {
      if (this.b.y)
      {
        this.b.y = false;
        int i = b(paramList);
        this.h.l.post(new PhotoListCustomizationDefault.4(this, i));
      }
      return true;
    }
    return false;
  }
  
  int b(List<LocalMediaInfo> paramList)
  {
    int i;
    if (this.b.F == -1) {
      i = PhotoListData.w;
    } else {
      i = this.b.F;
    }
    int j;
    if (i == -1)
    {
      Object localObject = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
      k = i;
      if (localObject != null)
      {
        j = ((LinkedHashMap)localObject).size();
        k = i;
        if (j > 0) {
          k = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
        }
      }
      j = k;
      if (k == -1)
      {
        j = k;
        if (this.b.N)
        {
          localObject = paramList.iterator();
          i = 0;
          for (;;)
          {
            j = k;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus == 3)
            {
              j = i;
              break;
            }
            i += 1;
          }
        }
      }
      localObject = this.e.selectedPhotoList;
      i = j;
      if (j == -1)
      {
        i = j;
        if (this.e.albumId.equals("$RecentAlbumId"))
        {
          i = j;
          if (!((ArrayList)localObject).isEmpty())
          {
            int m = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = 0;
            for (;;)
            {
              i = j;
              if (k >= m) {
                break;
              }
              if (((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path))
              {
                i = k;
                break;
              }
              k += 1;
            }
          }
        }
      }
    }
    else
    {
      PhotoListData.w = -1;
    }
    int k = this.h.t.getItemCount();
    if ((k > 0) && (i != -1))
    {
      j = i;
      if (i <= k - 1) {}
    }
    else
    {
      j = 0;
    }
    return j;
  }
  
  public Intent b(View paramView, int paramInt)
  {
    paramView = super.b(paramView, paramInt);
    paramView.putExtra("PhotoConst.MY_UIN", ((PhotoOtherData)this.f).e);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.b.f);
    paramView.putExtra("PhotoConst.editPathMap", ReplacePhotoDataUtil.a(this.b.s));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.b.h);
    paramView.putExtra("PasterConstants.paster_cate_id", this.b.i);
    paramView.putExtra("PasterConstants.pasters_data", this.b.g);
    if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.size() > 0)) {
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X8005674", "0X8005674", 0, this.e.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected PhotoOtherData b()
  {
    return new PhotoListCustomizationDefault.1(this);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    
    if (!this.b.l)
    {
      this.c.finish();
      QAlbumUtil.anim(this.c, false, false);
      return;
    }
    paramView = this.c.getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null) {
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    this.c.startActivity(paramView);
    this.c.finish();
    QAlbumUtil.anim(this.c, false, false);
  }
  
  protected void b(LocalMediaInfo paramLocalMediaInfo)
  {
    g(paramLocalMediaInfo);
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.e.maxSelectNum;
    String str2 = super.c(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      str1 = str2;
      if (this.b.B)
      {
        str1 = str2;
        if (paramLocalMediaInfo != null)
        {
          str1 = str2;
          if ("video".equals(paramLocalMediaInfo[0])) {
            str1 = this.c.getResources().getString(2131892559, new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
    return str1;
  }
  
  protected void c()
  {
    if (this.e.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    } else if ((!this.e.albumName.equalsIgnoreCase("Camera")) && (!this.e.albumName.equalsIgnoreCase("camera")) && (!this.e.albumName.contains("Camera")) && (!this.e.albumName.contains("camera"))) {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
    } else {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
    }
    if ((this.b.f) && ((!TextUtils.isEmpty(this.b.h)) || (!TextUtils.isEmpty(this.b.i))))
    {
      if (this.c.magicStickBtn != null) {
        this.c.magicStickBtn.performClick();
      }
    }
    else
    {
      Intent localIntent = this.c.getIntent();
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
      a(localIntent, false, this.e.selectedPhotoList);
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.e.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((PhotoOtherData)this.f).g);
    paramIntent.putExtra("peak.myUin", ((PhotoOtherData)this.f).e);
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!Utils.b())
    {
      paramView = this.c;
      QQToast.makeText(paramView, paramView.getResources().getString(2131916075), 0).show();
      return;
    }
    paramView = this.h.t.a(paramInt);
    if (paramView == null) {
      return;
    }
    Object localObject1 = this.c.getIntent();
    Object localObject2 = QAlbumUtil.sSelectItemAlbum;
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
      ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.c, (Intent)localObject1, (ArrayList)localObject2, 2, false);
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
      QAlbumUtil.anim(this.c, true, true);
      return;
    }
    localObject2 = new ActivityURIRequest(this.c, "/base/album/shortvideopreview");
    ((ActivityURIRequest)localObject2).extra().putAll(((Intent)localObject1).getExtras());
    ((ActivityURIRequest)localObject2).extra().putString("file_send_path", paramView.path);
    ((ActivityURIRequest)localObject2).extra().putLong("file_send_size", paramView.fileSize);
    ((ActivityURIRequest)localObject2).extra().putLong("file_send_duration", paramView.mDuration);
    ((ActivityURIRequest)localObject2).extra().putInt("file_width", paramView.mediaWidth);
    ((ActivityURIRequest)localObject2).extra().putInt("file_height", paramView.mediaHeight);
    ((ActivityURIRequest)localObject2).extra().putString("uin", this.b.o);
    ((ActivityURIRequest)localObject2).extra().putInt("uintype", this.b.m);
    ((ActivityURIRequest)localObject2).extra().putString("file_source", "album");
    ((ActivityURIRequest)localObject2).extra().putBoolean("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.b.B)
    {
      ((ActivityURIRequest)localObject2).extra().putBoolean("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((ActivityURIRequest)localObject2).extra().putStringArrayList("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    }
    ((ActivityURIRequest)localObject2).setRequestCode(17);
    QRoute.startUri((URIRequest)localObject2);
  }
  
  public void c(List<LocalMediaInfo> paramList)
  {
    if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.size() != 0))
    {
      int j;
      for (int i = 0; i < this.e.selectedPhotoList.size(); i = j + 1)
      {
        String str = (String)this.e.selectedPhotoList.get(i);
        if (TextUtils.isEmpty(str))
        {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
          j = i;
        }
        else
        {
          j = i;
          if (!new File(str).exists()) {
            if ((str.startsWith("http")) && (((PhotoOtherData)this.f).g != null))
            {
              j = i;
              if (((PhotoOtherData)this.f).g.containsKey(str)) {}
            }
            else
            {
              this.e.selectedPhotoList.remove(i);
              i -= 1;
              j = i;
              if (this.e.selectedMediaInfoHashMap != null)
              {
                j = i;
                if (this.e.selectedMediaInfoHashMap.containsKey(str))
                {
                  this.e.selectedMediaInfoHashMap.remove(str);
                  j = i;
                }
              }
            }
          }
        }
      }
    }
    super.c(paramList);
  }
  
  protected void d(Intent paramIntent)
  {
    this.c.startActivity(paramIntent);
  }
  
  public void d(View paramView, int paramInt)
  {
    if (!Utils.b())
    {
      paramView = this.c;
      QQToast.makeText(paramView, paramView.getResources().getString(2131916075), 0).show();
      return;
    }
    this.c.dispatchTakePictureIntent();
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  public void e()
  {
    super.e();
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListCustomizationDefault.2(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    g(paramLocalMediaInfo);
  }
  
  public void f()
  {
    if (this.c.qualityCheckBox != null)
    {
      int i = ((PhotoOtherData)this.f).d;
      if (i != 0)
      {
        if (i != 2) {
          return;
        }
        if (this.c.qualityCountTv != null) {
          QQAlbumUtils.a(this.c.qualityCountTv, this.e.selectedPhotoList, this.e.allMediaInfoHashMap, this.b.p, this.c, this.b.b, this.e.selectedMediaInfoHashMap);
        }
        this.c.qualityCheckBox.setChecked(true);
        return;
      }
      this.c.qualityCheckBox.setChecked(false);
    }
  }
  
  public void f(Intent paramIntent)
  {
    super.f(paramIntent);
    this.b.u.a();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    VideoCompositeHelper localVideoCompositeHelper = new VideoCompositeHelper();
    localVideoCompositeHelper.a(true);
    localObject = VideoCompositeHelper.a((String)localObject);
    String str = QQAlbumUtils.b(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("QQAlbum", 1, "get target path fail");
      return;
    }
    localVideoCompositeHelper.a((PublishVideoEntry)localObject, str, false, true, new PhotoListCustomizationDefault.3(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 1;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.b.B) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.b;
      ((PhotoListData)localObject).C += 1;
      if (this.b.C == 1) {
        this.b.E = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.b;
      ((PhotoListData)localObject).D += 1;
    }
    this.e.selectedPhotoList.add(str);
    this.e.selectedIndex.add(paramLocalMediaInfo.position);
    this.e.selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
    localObject = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
    paramLocalMediaInfo = (LocalMediaInfo)localObject;
    if (localObject == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.e.albumId, paramLocalMediaInfo);
    }
    paramLocalMediaInfo.put(str, Integer.valueOf(this.h.m.findFirstVisibleItemPosition()));
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (!paramLocalMediaInfo.containsKey(str)) {
      paramLocalMediaInfo.put(str, new Pair(this.e.albumId, this.e.albumName));
    }
  }
  
  public void g()
  {
    super.g();
    SmallScreenUtils.a(MobileQQ.getContext(), true);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(MobileQQ.getContext(), 2, false);
    if (this.b.J == 10016)
    {
      if (!this.c.getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false))
      {
        this.c.finish();
        return;
      }
      this.c.getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.b.J = 0;
    }
    if (this.c.magicStickBtn != null) {
      this.c.magicStickBtn.setClickable(true);
    }
  }
  
  protected void g(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 2;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.b.B) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.b;
      ((PhotoListData)localObject).C -= 1;
      if (this.b.C == 1) {
        this.b.E = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.b;
      ((PhotoListData)localObject).D -= 1;
    }
    this.e.selectedPhotoList.remove(str);
    this.e.selectedIndex.remove(paramLocalMediaInfo.position);
    this.e.selectedMediaInfoHashMap.remove(str);
    paramLocalMediaInfo = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo.remove(str);
    }
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (paramLocalMediaInfo.containsKey(str)) {
      paramLocalMediaInfo.remove(str);
    }
  }
  
  public void h()
  {
    if (this.e.isShowQzoneAlbum) {
      MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.b.v);
    }
    super.h();
    if (QLog.isColorLevel()) {
      QLog.e("PhotoList", 2, "doOnDestroy");
    }
  }
  
  public Class i()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  public AbstractAlbumListFragment j()
  {
    return new AlbumListFragment();
  }
  
  public void k()
  {
    super.k();
    if (this.h.h != null)
    {
      this.c.magicStickBtn = ((TextView)this.h.h.findViewById(2131437877));
      this.c.qualityCheckBox = ((CheckBox)this.h.h.findViewById(2131442912));
      this.c.qualityTv = ((TextView)this.h.h.findViewById(2131442918));
      this.c.qualityCountTv = ((TextView)this.h.h.findViewById(2131442913));
      this.c.imgCountTipsTv = ((TextView)this.h.h.findViewById(2131435539));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.h.f.setFitsSystemWindows(true);
      this.h.f.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.c), 0, 0);
    }
    this.h.l.addOnScrollListener(new PhotoListCustomizationDefault.5(this));
    if (this.h.h != null)
    {
      View localView = this.h.h;
      int i;
      if ((!this.e.isSingleMode) && (this.e.showMediaType != 2)) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (this.h.n != null) {
      this.h.n.setOnClickListener(this.h);
    }
    if (this.h.o != null) {
      this.h.o.setOnClickListener(this.h);
    }
    if (this.c.magicStickBtn != null) {
      if (this.b.f)
      {
        this.c.magicStickBtn.setVisibility(0);
        this.c.magicStickBtn.setOnClickListener(new PhotoListCustomizationDefault.6(this));
      }
      else
      {
        this.c.magicStickBtn.setVisibility(8);
      }
    }
    if ((this.b.d) && (this.c.qualityCheckBox != null)) {
      this.c.qualityCheckBox.setOnCheckedChangeListener(this.h);
    }
    a();
    this.b.u = new NewPhotoListActivityHandler(this);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    NewPhotoListActivityHandler localNewPhotoListActivityHandler = this.b.u;
    if (localNewPhotoListActivityHandler == null) {
      return;
    }
    Object localObject = this.h.t;
    if ((localObject != null) && (((PhotoListAdapter)localObject).d != null))
    {
      localObject = (LocalMediaInfo)((PhotoListAdapter)localObject).d.get(paramInt);
      if ((localObject != null) && (paramLocalMediaInfo != null) && (((LocalMediaInfo)localObject).path != null))
      {
        if (paramLocalMediaInfo.path == null) {
          return;
        }
        if (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)) {
          return;
        }
        localObject = localNewPhotoListActivityHandler.obtainMessage();
        ((Message)localObject).what = 0;
        Bundle localBundle = new Bundle();
        localBundle.putInt("ALBUMLIST_POSITION", paramInt);
        localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
        ((Message)localObject).setData(localBundle);
        localNewPhotoListActivityHandler.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
 * JD-Core Version:    0.7.0.1
 */