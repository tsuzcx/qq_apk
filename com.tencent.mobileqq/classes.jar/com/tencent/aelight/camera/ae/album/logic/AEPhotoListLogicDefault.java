package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault
  extends AEPhotoListLogicBase<AENewPhotoListFragment>
  implements AEPhotoListLogic.IadapterCallback, AEPhotoListLogic.IcheckBoxCallback, AEPhotoListLogic.IitemClickCallback
{
  protected PhotoListData l;
  private List<AEPhotoListLogicDefault.InitResult> m = new ArrayList();
  
  public AEPhotoListLogicDefault(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    super(paramAENewPhotoListFragment);
    this.h = this;
    this.i = this;
    this.j = this;
    this.d = new PhotoListData();
    this.l = ((PhotoListData)this.d);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.m.add(new AEPhotoListLogicDefault.InitResult(this, paramInt));
    }
  }
  
  private void o()
  {
    if (!AEKitForQQ.a())
    {
      this.m.add(new AEPhotoListLogicDefault.InitResult(this, -1));
    }
    else
    {
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
    TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.n(), new AEPhotoListLogicDefault.1(this));
  }
  
  private void p()
  {
    this.m.size();
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.c.maxSelectNum;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      str1 = str2;
      if (this.l.B)
      {
        str1 = str2;
        if (paramLocalMediaInfo != null)
        {
          str1 = str2;
          if ("video".equals(paramLocalMediaInfo[0])) {
            str1 = ((AENewPhotoListFragment)this.b.get()).getResources().getString(2131892559, new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
    return str1;
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbum initData(),intent extras is:");
      localStringBuilder.append(paramIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
    super.a(paramIntent);
    o();
    p();
    this.l.q = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    ReplacePhotoDataUtil.a(((AENewPhotoListFragment)this.b.get()).getActivity(), paramIntent, false, this.l.s);
    this.l.b = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.l.b == null) {
      this.l.b = new HashMap(1);
    }
    this.c.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.l.d = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.l.e = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.l.a = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.l.j = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.l.k = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.l.m = paramIntent.getIntExtra("uintype", -1);
    this.l.l = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.l.n = paramIntent.getStringExtra("uinname");
    this.l.o = paramIntent.getStringExtra("uin");
    this.c.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.l.c = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.c.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    if (!this.l.f) {
      this.l.f = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if (this.l.f)
    {
      this.l.g = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.l.h = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.l.i = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.l.r = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new HashMap();
    boolean bool = false;
    int i2 = 0;
    int j = 0;
    int i = 0;
    int i1 = 0;
    while (i2 < paramArrayList.size())
    {
      Object localObject2 = (String)paramArrayList.get(i2);
      if (!ImageManager.isNetworkUrl((String)localObject2))
      {
        int k;
        int n;
        if (((AENewPhotoListFragment)this.b.get()).c((String)localObject2) == 1)
        {
          localObject2 = ((AENewPhotoListFragment)this.b.get()).d((String)localObject2);
          k = j;
          n = i;
          if (localObject2 != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject2).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(i1), localSendVideoInfo);
            n = i + 1;
            k = j;
          }
        }
        else
        {
          k = j + 1;
          n = i;
        }
        i1 += 1;
        i = n;
        j = k;
      }
      i2 += 1;
    }
    if (!((HashMap)localObject1).isEmpty())
    {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramBoolean = bool;
    if (SVBusiUtil.c != 0L)
    {
      paramBoolean = bool;
      if (System.currentTimeMillis() - SVBusiUtil.c < 300000L) {
        paramBoolean = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload video isConfirmed=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" allowUploadInXGTime=");
      ((StringBuilder)localObject1).append(SVBusiUtil.c);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!paramBoolean) && (i != 0))
    {
      localObject1 = ((AENewPhotoListFragment)this.b.get()).getResources().getString(2131916238);
      paramIntent = new AEPhotoListLogicDefault.2(this, paramIntent, paramArrayList);
      if (FreeWifiHelper.a(((AENewPhotoListFragment)this.b.get()).getActivity(), 4, new AEPhotoListLogicDefault.3(this, paramIntent))) {
        DialogUtil.a(((AENewPhotoListFragment)this.b.get()).getActivity(), 232, null, (String)localObject1, new AEPhotoListLogicDefault.4(this, paramIntent), new AEPhotoListLogicDefault.5(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    PhotoUtils.sendPhoto(((AENewPhotoListFragment)this.b.get()).getActivity(), paramIntent, paramArrayList, 2, this.l.a);
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    ((AENewPhotoListFragment)this.b.get()).l();
    ArrayList localArrayList = this.c.selectedPhotoList;
    if ((paramMessage.obj instanceof String))
    {
      String str = (String)paramMessage.obj;
      QZLog.d("QQAlbum", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() >= this.c.maxSelectNum)
      {
        QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), String.format(((AENewPhotoListFragment)this.b.get()).getResources().getString(2131892559), new Object[] { Integer.valueOf(this.c.maxSelectNum) }), 0).show();
      }
      else
      {
        this.c.selectedPhotoList.add(str);
        ((AENewPhotoListFragment)this.b.get()).m();
      }
      ((AENewPhotoListFragment)this.b.get()).b(str);
    }
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
    int i;
    if (this.c.selectedPhotoList != null) {
      i = this.c.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.l.l)
    {
      ((AENewPhotoListFragment)this.b.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.b.get()).getActivity(), false, false);
      return;
    }
    paramView = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      AEQLog.d("AEPhotoListLogicDefault", "onTitleBtnCancelClick---className is null, return");
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((AENewPhotoListFragment)this.b.get()).startActivity(paramView);
    ((AENewPhotoListFragment)this.b.get()).getActivity().finish();
    AlbumUtil.anim(((AENewPhotoListFragment)this.b.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (this.c.isSingleMode) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramView = new StringBuilder();
      paramView.append("current select count:");
      paramView.append(this.c.selectedPhotoList.size());
      QLog.d("QQAlbum", 2, paramView.toString());
    }
    LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.b.get()).d.a(paramInt);
    int j = localLocalMediaInfo.selectStatus;
    long l1;
    if ((j != 1) && (this.c.selectedPhotoList.size() + this.e.initialHasPickedNum >= this.c.maxSelectNum))
    {
      l1 = System.currentTimeMillis();
      if (l1 - this.l.H >= 1000L)
      {
        QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), a(localLocalMediaInfo), 0).show(((AENewPhotoListFragment)this.b.get()).i);
        paramCheckBox.setChecked(false);
        this.l.H = l1;
      }
      return;
    }
    if ((this.l.m == 9501) && (((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (j != 1))
    {
      l1 = 0L;
      paramView = this.c.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        l1 += FileUtils.getFileSizes((String)paramView.next());
      }
      if (l1 + FileUtils.getFileSizes(localLocalMediaInfo.path) > 52428800L)
      {
        QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), "选择图片总大小不能超过50M", 0).show(((AENewPhotoListFragment)this.b.get()).i);
        paramCheckBox.setChecked(false);
        return;
      }
    }
    if ((((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((AENewPhotoListFragment)this.b.get()).a(localLocalMediaInfo)) && (FileUtils.getFileSizes(localLocalMediaInfo.path) > 3145728L))
    {
      QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), "图片文件过大", 0).show(((AENewPhotoListFragment)this.b.get()).i);
      paramCheckBox.setChecked(false);
      return;
    }
    if (j != 1) {
      i = 1;
    }
    localLocalMediaInfo.selectStatus = i;
    if (localLocalMediaInfo.selectStatus == 1) {
      bool = true;
    } else {
      bool = false;
    }
    String str = localLocalMediaInfo.path;
    paramView = PresendPicMgr.a();
    if (bool)
    {
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      PhotoListData localPhotoListData;
      if ((this.l.B) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        localPhotoListData = this.l;
        localPhotoListData.C += 1;
        if (this.l.C == 1) {
          this.l.E = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localPhotoListData = this.l;
        localPhotoListData.D += 1;
      }
      this.c.selectedPhotoList.add(str);
      this.c.selectedIndex.add(localLocalMediaInfo.position);
      this.c.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if ((paramView != null) && (paramCheckBox != null) && (paramCheckBox[0] != null) && (!"video".equals(paramCheckBox[0]))) {
        paramView.a(str, 1052, ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      StatisticConstants.a(((AENewPhotoListFragment)this.b.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramCheckBox = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.c.albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.c.albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.b.get()).r.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.c.albumId, this.c.albumName));
      }
    }
    else
    {
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.l.B) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.l;
        paramCheckBox.C -= 1;
        if (this.l.C == 1) {
          this.l.E = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        paramCheckBox = this.l;
        paramCheckBox.D -= 1;
      }
      this.c.selectedPhotoList.remove(str);
      this.c.selectedIndex.remove(localLocalMediaInfo.position);
      this.c.selectedMediaInfoHashMap.remove(str);
      if (paramView != null) {
        paramView.b(str, 1013);
      }
      StatisticConstants.a(((AENewPhotoListFragment)this.b.get()).getActivity().getIntent(), "param_cancelSelNum");
      paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.c.albumId);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.sSelectItemAlbum;
      if (paramView.containsKey(str)) {
        paramView.remove(str);
      }
    }
    if (this.g != null) {
      this.g.a(bool, localLocalMediaInfo);
    }
    ((AENewPhotoListFragment)this.b.get()).a(paramInt, bool);
    ((AENewPhotoListFragment)this.b.get()).d(bool ^ true);
    d();
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  protected void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ReplacePhotoDataUtil.a(paramLocalMediaInfo.path, this.l.s))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramPhotoVH.d.setImageDrawable(((AENewPhotoListFragment)this.b.get()).getActivity().getDrawable(2130839532));
      } else {
        paramPhotoVH.d.setImageResource(2130839532);
      }
      paramPhotoVH.d.setVisibility(0);
      return;
    }
    paramPhotoVH.d.setVisibility(8);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    ReplacePhotoDataUtil.a(paramList, 0, null, this.l.s);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    AlbumUtil.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.c.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.l.A);
    }
    paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.c.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.c.albumName);
    paramIntent.putExtra("ALBUM_ID", this.c.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramIntent.putExtra("PasterConstants.pasters_data", this.l.g);
    PhotoListData.w = ((GridLayoutManager)((AENewPhotoListFragment)this.b.get()).r.getLayoutManager()).findFirstVisibleItemPosition();
    paramIntent.setClass(((AENewPhotoListFragment)this.b.get()).getActivity(), NewPhotoPreviewActivity.class);
    paramIntent.addFlags(603979776);
    c(paramIntent);
    AlbumUtil.anim(((AENewPhotoListFragment)this.b.get()).getActivity(), true, true);
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    Object localObject = this.b.get();
    int n = 0;
    if (localObject == null) {
      return false;
    }
    if (super.a(paramList, paramBoolean))
    {
      if (this.l.y)
      {
        localObject = this.l;
        ((PhotoListData)localObject).y = false;
        int j;
        if (((PhotoListData)localObject).F == -1) {
          j = PhotoListData.w;
        } else {
          j = this.l.F;
        }
        if (j == -1)
        {
          localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.c.albumId);
          i = j;
          if (localObject != null)
          {
            k = ((LinkedHashMap)localObject).size();
            i = j;
            if (k > 0) {
              i = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(k - 1)])).intValue();
            }
          }
          int k = i;
          if (i == -1)
          {
            k = i;
            if (this.l.N)
            {
              localObject = paramList.iterator();
              j = 0;
              for (;;)
              {
                k = i;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus == 3)
                {
                  k = j;
                  break;
                }
                j += 1;
              }
            }
          }
          localObject = this.c.selectedPhotoList;
          if ((k == -1) && (this.c.albumId.equals("$RecentAlbumId")) && (!((ArrayList)localObject).isEmpty()))
          {
            j = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            i = n;
            while ((i < j) && (!((String)localObject).equals(((LocalMediaInfo)paramList.get(i)).path))) {
              i += 1;
            }
          }
        }
        else
        {
          PhotoListData.w = -1;
        }
        int i = ((AENewPhotoListFragment)this.b.get()).d.getItemCount();
        if (i != 0) {}
        ((AENewPhotoListFragment)this.b.get()).r.post(new AEPhotoListLogicDefault.8(this));
      }
      return true;
    }
    return false;
  }
  
  public List<LocalMediaInfo> b(boolean paramBoolean)
  {
    int i;
    if ((this.c.albumId.equals("$RecentAlbumId")) && (paramBoolean)) {
      i = 15;
    } else {
      i = -1;
    }
    List localList = AlbumUtil.getAlbumMedias(((AENewPhotoListFragment)this.b.get()).getActivity(), this.c.albumId, this.c.albumName, i, this.c.filter, this.c.filter.videoMaxDuration);
    LogTag.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.c.selectedPhotoList != null) && (this.c.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.c.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.c.selectedPhotoList.get(i))) {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.c.isShowQzoneAlbum);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  public void c()
  {
    d();
    super.c();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    if (!this.c.selectedPhotoList.isEmpty()) {
      ((AENewPhotoListFragment)this.b.get()).a((String)this.c.selectedPhotoList.get(this.c.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.c.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.c.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        FileUtils.getFileSizes((String)paramView.next());
      }
      if (FileManagerUtil.b())
      {
        FMDialogUtil.a(((AENewPhotoListFragment)this.b.get()).getActivity(), 2131889584, 2131889589, new AEPhotoListLogicDefault.6(this));
        return;
      }
    }
    n();
  }
  
  protected void d()
  {
    super.d();
    ArrayList localArrayList = this.c.selectedPhotoList;
    localArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateButton selectedPhotoList.size()=");
      localStringBuilder.append(localArrayList.size());
      QLog.d("_photo", 2, localStringBuilder.toString());
    }
  }
  
  public boolean e()
  {
    return super.e();
  }
  
  public void f()
  {
    super.f();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    if (this.l.J == 10016)
    {
      if (!((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false))
      {
        ((AENewPhotoListFragment)this.b.get()).getActivity().finish();
        return;
      }
      ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.l.J = 0;
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public View k()
  {
    return super.k();
  }
  
  protected void n()
  {
    if (this.c.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.b.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    } else if ((!this.c.albumName.equalsIgnoreCase("Camera")) && (!this.c.albumName.equalsIgnoreCase("camera")) && (!this.c.albumName.contains("Camera")) && (!this.c.albumName.contains("camera"))) {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.b.get()).getActivity()).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
    } else {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.b.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
    }
    PresendPicMgr.a();
    if (this.l.f)
    {
      if (!TextUtils.isEmpty(this.l.h)) {
        return;
      }
      if (!TextUtils.isEmpty(this.l.i)) {
        return;
      }
    }
    if (this.c.selectedPhotoList != null) {
      StatisticConstants.a(((AENewPhotoListFragment)this.b.get()).getActivity().getIntent(), this.c.selectedPhotoList.size());
    }
    Intent localIntent = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
    localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.c.selectedMediaInfoHashMap);
    if (this.c.selectedPhotoList != null) {
      NewFlowCameraReporter.a(this.c.selectedPhotoList);
    }
    a(localIntent, false, this.c.selectedPhotoList);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((AENewPhotoListFragment)this.b.get()).C;
    if (localHandler == null) {
      return;
    }
    Object localObject = ((AENewPhotoListFragment)this.b.get()).d;
    if ((localObject != null) && (((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a != null))
    {
      localObject = (LocalMediaInfo)((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a.get(paramInt);
      if ((localObject != null) && (paramLocalMediaInfo != null) && (((LocalMediaInfo)localObject).path != null))
      {
        if (paramLocalMediaInfo.path == null) {
          return;
        }
        if (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)) {
          return;
        }
        localObject = localHandler.obtainMessage();
        ((Message)localObject).what = 0;
        Bundle localBundle = new Bundle();
        localBundle.putInt("ALBUMLIST_POSITION", paramInt);
        localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
        ((Message)localObject).setData(localBundle);
        localHandler.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault
 * JD-Core Version:    0.7.0.1
 */