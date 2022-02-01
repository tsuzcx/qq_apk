package com.tencent.aelight.camera.ae.album.logic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoItemClickListener;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.aelight.camera.ae.album.nocropper.AECropperView;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.view.AEEditorCancelableProgressDialog;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase<K extends AEAbstractPhotoListFragment>
  extends AEPhotoListLogic<K>
  implements AEPhotoListLogic.IadapterCallback, AEPhotoListLogic.IcheckBoxCallback, AEPhotoListLogic.IitemClickCallback
{
  private float A = 0.0F;
  protected final boolean k = AEThemeUtil.b();
  private String l = null;
  private boolean m = true;
  private ArrayList<LocalMediaInfo> n = new ArrayList();
  private float o;
  private float p;
  private String q;
  private Map<String, AEPhotoCropInfoWrapper> r = new HashMap();
  private final Map<String, String> s = new HashMap();
  private String t = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  private AEEditorCancelableProgressDialog u;
  private volatile boolean v = false;
  private volatile boolean w = false;
  private volatile CountDownLatch x;
  private int y = 0;
  private int z = 0;
  
  protected AEPhotoListLogicBase(K paramK)
  {
    super(paramK);
    this.h = this;
    this.i = this;
    this.j = this;
  }
  
  private boolean A()
  {
    if (this.e.canMixPhotoAndVideo) {
      return true;
    }
    if (q() == null) {
      return true;
    }
    Object localObject = this.q;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    localObject = b((String)localObject);
    if (localObject != null)
    {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) != 0) {
        return true;
      }
      if (((LocalMediaInfo)localObject).mediaWidth == ((LocalMediaInfo)localObject).mediaHeight) {
        return true;
      }
    }
    return false;
  }
  
  private int a(ArrayList<LocalMediaInfo> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramString == null) {
        return -1;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (((LocalMediaInfo)paramArrayList.get(i)).path.equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setSelected], photoPath=");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
    paramPhotoVH.j.onClick(paramPhotoVH.h);
    boolean bool;
    if (this.e.initialHasPickedNum > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, true, ((AEAbstractPhotoListFragment)this.b.get()).d.getItemViewType(paramInt), paramInt, "1");
  }
  
  private void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.c.setVisibility(0);
  }
  
  private void a(@NonNull String paramString, @NonNull AEPhotoCropInfoWrapper paramAEPhotoCropInfoWrapper)
  {
    AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.r.put(paramString, paramAEPhotoCropInfoWrapper);
  }
  
  private void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, Matrix paramMatrix)
  {
    AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.r == null)
    {
      AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    AEPhotoCropInfoWrapper localAEPhotoCropInfoWrapper = e(paramString);
    if (localAEPhotoCropInfoWrapper == null) {
      localAEPhotoCropInfoWrapper = new AEPhotoCropInfoWrapper();
    }
    localAEPhotoCropInfoWrapper.a = paramEditorPicInfo;
    localAEPhotoCropInfoWrapper.b = paramMatrix;
    a(paramString, localAEPhotoCropInfoWrapper);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    v();
    a(false, true);
    this.q = paramString;
    ((AEAbstractPhotoListFragment)this.b.get()).l.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, 1440, 1440));
    if ((this.e.canMixPhotoAndVideo) && (((AEAbstractPhotoListFragment)this.b.get()).l.getRatioType() == 1)) {
      ((AEAbstractPhotoListFragment)this.b.get()).l.a();
    }
    this.o = ((AEAbstractPhotoListFragment)this.b.get()).l.getMinZoom();
    this.p = ((AEAbstractPhotoListFragment)this.b.get()).l.getCropToCenterZoom();
    f(((AEAbstractPhotoListFragment)this.b.get()).l.getRatioType());
    AEPhotoCropInfoWrapper localAEPhotoCropInfoWrapper = e(paramString);
    if ((localAEPhotoCropInfoWrapper != null) && (localAEPhotoCropInfoWrapper.b != null) && (b(this.c.selectedPhotoList, paramString))) {
      ((AEAbstractPhotoListFragment)this.b.get()).l.setImageMatrix(localAEPhotoCropInfoWrapper.b);
    } else {
      d(paramString);
    }
    if (paramBoolean) {
      ((AEAbstractPhotoListFragment)this.b.get()).j.b();
    }
    if (A())
    {
      ((AEAbstractPhotoListFragment)this.b.get()).g();
      return;
    }
    ((AEAbstractPhotoListFragment)this.b.get()).f();
  }
  
  @WorkerThread
  private void a(ArrayList<AEAlbumVideoModel> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    do
    {
      if (i >= j) {
        break;
      }
      AEAlbumVideoModel localAEAlbumVideoModel = (AEAlbumVideoModel)paramArrayList.get(i);
      LocalMediaInfo localLocalMediaInfo = b(localAEAlbumVideoModel.getPath());
      localAEAlbumVideoModel.setOriginPath(localAEAlbumVideoModel.getPath());
      i += 1;
      this.x = new CountDownLatch(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("batchCompress---begin, index=");
      localStringBuilder.append(i);
      AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.17(this, i, j));
      a(localLocalMediaInfo, new AEPhotoListLogicBase.18(this, i, localAEAlbumVideoModel));
      if (this.x != null)
      {
        try
        {
          this.x.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        this.x = null;
      }
    } while ((!this.v) && (!this.w));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 8;
    if (paramBoolean1)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).o.setImageDrawable(o());
      ((AEAbstractPhotoListFragment)this.b.get()).n.setVisibility(0);
      TextView localTextView = ((AEAbstractPhotoListFragment)this.b.get()).p;
      if (this.e.canMixPhotoAndVideo) {
        i = 0;
      }
      localTextView.setVisibility(i);
      ((AEAbstractPhotoListFragment)this.b.get()).l.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.b.get()).m.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.b.get()).a(false);
      ((AEAbstractPhotoListFragment)this.b.get()).g();
      s();
      this.q = null;
      return;
    }
    ((AEAbstractPhotoListFragment)this.b.get()).n.setVisibility(8);
    if (paramBoolean2)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).l.setVisibility(0);
      ((AEAbstractPhotoListFragment)this.b.get()).m.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.b.get()).a(false);
      s();
      return;
    }
    ((AEAbstractPhotoListFragment)this.b.get()).l.setVisibility(4);
    ((AEAbstractPhotoListFragment)this.b.get()).m.setVisibility(0);
    ((AEAbstractPhotoListFragment)this.b.get()).g();
  }
  
  @Nullable
  private LocalMediaInfo b(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if ((this.c != null) && (this.c.selectedMediaInfoHashMap != null)) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.c.selectedMediaInfoHashMap.get(paramString);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      Object localObject = new LinkedList(this.n);
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (!CollectionUtils.isEmpty((Collection)localObject))
      {
        localObject = ((List)localObject).iterator();
        do
        {
          localLocalMediaInfo2 = localLocalMediaInfo1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localLocalMediaInfo2 = (LocalMediaInfo)((Iterator)localObject).next();
        } while ((localLocalMediaInfo2 == null) || (TextUtils.isEmpty(localLocalMediaInfo2.path)) || (!localLocalMediaInfo2.path.equals(paramString)));
      }
    }
    return localLocalMediaInfo2;
  }
  
  private void b(int paramInt)
  {
    if (!this.l.equals(((LocalMediaInfo)this.n.get(paramInt)).path))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!currentFocusedImagePath.equals(mAllImages.get(position).path), position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      int i = a(this.n, this.l);
      this.l = ((LocalMediaInfo)this.n.get(paramInt)).path;
      if (i >= 0) {
        ((AEAbstractPhotoListFragment)this.b.get()).d.notifyItemChanged(i);
      }
    }
  }
  
  private void b(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePhotoItemClick, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.n.get(paramInt);
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if ((!paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      if ((q() != null) && (q().size() + this.e.initialHasPickedNum >= this.c.maxSelectNum))
      {
        AEQLog.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        return;
      }
      a(paramPhotoVH);
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      b(paramInt);
      bool = m();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      if (!this.e.canMixPhotoAndVideo)
      {
        if (bool) {
          paramInt = 0;
        } else {
          paramInt = 600;
        }
        c(paramInt);
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false);
      return;
    }
    if ((paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramPhotoVH);
      bool = m();
      b(paramInt);
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false);
      return;
    }
    if ((paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      if (q().size() > 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = ");
        localStringBuilder.append(paramInt);
        AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
        b(paramPhotoVH);
        b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        p();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      ((AEAbstractPhotoListFragment)this.b.get()).d.notifyDataSetChanged();
      return;
    }
    if ((!paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      if (!this.e.canMixPhotoAndVideo) {
        c(0);
      }
    }
  }
  
  private void b(int paramInt, LocalMediaInfo paramLocalMediaInfo, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.j.onClick(paramPhotoVH.h);
    paramPhotoVH = new StringBuilder();
    paramPhotoVH.append("cancelSelected image.path = ");
    paramPhotoVH.append(paramLocalMediaInfo.path);
    AEQLog.a("AEPhotoListLogicBase", paramPhotoVH.toString());
    d(paramLocalMediaInfo.path);
    boolean bool;
    if (this.e.initialHasPickedNum > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, false, ((AEAbstractPhotoListFragment)this.b.get()).d.getItemViewType(paramInt), paramInt, "1");
  }
  
  private void b(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.c.setVisibility(8);
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doShowPreviewVideo: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", autoPlay=");
    ((StringBuilder)localObject).append(paramBoolean2);
    AEQLog.b("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    if (paramBoolean1) {
      ((AEAbstractPhotoListFragment)this.b.get()).j.b();
    }
    localObject = ((AEAbstractPhotoListFragment)this.b.get()).m;
    if ((paramString != null) && (paramString.equals(this.q)))
    {
      if ((paramBoolean2) && (!((BaseVideoView)localObject).isPlaying()))
      {
        AEQLog.b("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, just resume play");
        ((BaseVideoView)localObject).play();
      }
      AEQLog.b("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, quick return");
      return;
    }
    a(false, false);
    v();
    this.q = paramString;
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mIsMute = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mSceneId = 113;
    localVideoPlayParam.mSceneName = SceneID.getSceneStr(113);
    localVideoPlayParam.mVideoPath = paramString;
    localVideoPlayParam.mCallback = new AEPhotoListLogicBase.12(this, localVideoPlayParam, paramString);
    ((BaseVideoView)localObject).setVideoParam(localVideoPlayParam);
    ((BaseVideoView)localObject).play();
    if (!paramBoolean2) {
      ((BaseVideoView)localObject).pause();
    }
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (this.e.canMixPhotoAndVideo)
      {
        int i = QAlbumUtil.getMediaType(a(paramString));
        if (i == 0)
        {
          a(paramString, paramBoolean1, paramBoolean2);
          return;
        }
        if (i == 1) {
          a(paramString, paramBoolean1, paramBoolean2, paramBoolean3);
        }
      }
      else
      {
        a(paramString, paramBoolean1, paramBoolean2);
      }
    }
    else {
      a(true, false);
    }
  }
  
  private void b(ArrayList<AEAlbumMediaBaseModel> paramArrayList)
  {
    Activity localActivity = ((AEAbstractPhotoListFragment)this.b.get()).getActivity();
    Intent localIntent = localActivity.getIntent();
    if (AECameraEntryManager.t(localIntent))
    {
      AEQLog.b("AEPhotoListLogicBase", "doRealJumpForMix---is additional pick case, setResult and finish");
      localIntent = new Intent();
      localIntent.putExtra("ae_album_selected_media_models", paramArrayList);
      localActivity.setResult(-1, localIntent);
      localActivity.finish();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ae_album_selected_media_models", paramArrayList);
    int i = AECameraEntry.y.a();
    if (AECameraEntryManager.r(localIntent)) {
      i = AECameraEntry.A.a();
    }
    AEEditorLauncher.a(localActivity, 2, localBundle, i);
  }
  
  private boolean b(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  private int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    while (i < this.n.size())
    {
      if (paramString.equals(((LocalMediaInfo)this.n.get(i)).path)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void c(int paramInt)
  {
    if ((!this.e.canMixPhotoAndVideo) && (q().size() == 1))
    {
      if (paramInt > 0)
      {
        ((AEAbstractPhotoListFragment)this.b.get()).r.postDelayed(new AEPhotoListLogicBase.9(this), paramInt);
        return;
      }
      ((AEAbstractPhotoListFragment)this.b.get()).d.notifyDataSetChanged();
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePhotoRatioChanged---lastRatio=");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.b("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    if (paramInt == 1) {
      f(2);
    } else if (paramInt == 2) {
      f(1);
    }
    if ((this.c != null) && (this.c.selectedPhotoList != null))
    {
      localObject = this.c.selectedPhotoList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Size localSize = BitmapUtil.getImageSize(str);
        EditorPicInfo localEditorPicInfo = new EditorPicInfo();
        localEditorPicInfo.picPath = str;
        localEditorPicInfo.originPicWidth = localSize.getWidth();
        localEditorPicInfo.originPicHeight = localSize.getHeight();
        double d = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
        if (paramInt == 1)
        {
          if (d <= 0.333333343267441D)
          {
            d = (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight;
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = d;
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = (localEditorPicInfo.originPicWidth / 0.333333343267441D * 1.0D / localEditorPicInfo.originPicHeight);
          }
          else if (d >= 1.777777791023254D)
          {
            localEditorPicInfo.x = ((localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) * 1.0D / 2.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = (localEditorPicInfo.originPicHeight * 1.777777791023254D * 1.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.h = 1.0D;
          }
          else
          {
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = 1.0D;
          }
        }
        else if (paramInt == 2) {
          if (d < 1.0D)
          {
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = ((localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight);
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = d;
          }
          else
          {
            localEditorPicInfo.x = ((localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight) * 1.0D / 2.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = d;
            localEditorPicInfo.h = 1.0D;
          }
        }
        a(str, localEditorPicInfo, null);
      }
    }
  }
  
  private void d(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    Map localMap = this.r;
    if ((localMap != null) && (localMap.size() > 0)) {
      this.r.remove(paramString);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.get() != null)) {
      if (q().isEmpty())
      {
        String str = null;
        ArrayList localArrayList = new ArrayList(this.n);
        int i = 0;
        while (i < localArrayList.size())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localArrayList.get(i);
          if (localLocalMediaInfo != null) {
            if (this.e.canMixPhotoAndVideo)
            {
              if (AlbumUtil.getMediaType(localLocalMediaInfo) == 1)
              {
                int j = b(localLocalMediaInfo);
                if ((j != 0) && (j != 2)) {}
              }
              else
              {
                str = localLocalMediaInfo.path;
                break label152;
              }
            }
            else if (AlbumUtil.getMediaType(localLocalMediaInfo) == 0)
            {
              str = localLocalMediaInfo.path;
              break label152;
            }
          }
          i += 1;
        }
        i = -1;
        label152:
        this.l = str;
        b(str, paramBoolean, true, false);
        if (i > 0) {
          ((AEAbstractPhotoListFragment)this.b.get()).r.post(new AEPhotoListLogicBase.1(this, i));
        }
      }
      else
      {
        AEQLog.b("AEPhotoListLogicBase", "changeFocusAndPreviewWhenDataChanged---already picked some items, preview won't change");
      }
    }
  }
  
  @Nullable
  private AEPhotoCropInfoWrapper e(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    Map localMap = this.r;
    if ((localMap != null) && (localMap.size() != 0)) {
      return (AEPhotoCropInfoWrapper)this.r.get(paramString);
    }
    return null;
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 1)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2064187427), 1).show();
      return;
    }
    if (paramInt == 2) {
      QQToast.makeText(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2064187428), 1).show();
    }
  }
  
  private EditorPicInfo f(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = e(paramString);
    if ((localObject != null) && (((AEPhotoCropInfoWrapper)localObject).a != null)) {
      return ((AEPhotoCropInfoWrapper)localObject).a;
    }
    localObject = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    ((EditorPicInfo)localObject).picPath = paramString;
    ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
    ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
    return localObject;
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 1)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).l.setGestureEnabled(true);
      ((AEAbstractPhotoListFragment)this.b.get()).l.setMinZoom(this.p);
      return;
    }
    if (paramInt == 2)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).l.setGestureEnabled(true);
      ((AEAbstractPhotoListFragment)this.b.get()).l.setMinZoom(this.o);
    }
  }
  
  private void n()
  {
    Intent localIntent = ((AEAbstractPhotoListFragment)this.b.get()).getActivity().getIntent();
    if (this.e.canMixPhotoAndVideo)
    {
      this.c.maxSelectNum = this.e.maxSelectNumForMix;
      this.d.B = true;
      this.c.isSingleMode = false;
      return;
    }
    this.c.maxSelectNum = this.e.maxSelectNumForNormal;
    this.d.B = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.c.maxSelectNum > 1) {
      this.c.isSingleMode = false;
    }
    if (localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.c.isSingleMode = false;
    }
  }
  
  private URLDrawable o()
  {
    try
    {
      URLDrawable localURLDrawable = URLDrawableHelper.getDrawable("https://downv6.qq.com/shadow_qqcamera/iOS/image/aeeditor_album_blank@2x.png");
      return localURLDrawable;
    }
    catch (Exception localException)
    {
      AEQLog.a("AEPhotoListLogicBase", "getNoPhotoTipDrawable---error: ", localException);
    }
    return null;
  }
  
  private void p()
  {
    if (!q().isEmpty())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mPhotoCommonData.selectedPhotoList.size() = ");
      ((StringBuilder)localObject).append(q().size());
      AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
      localObject = (String)q().get(q().size() - 1);
      int i1 = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = i1;
        if (i >= this.n.size()) {
          break;
        }
        if (((LocalMediaInfo)this.n.get(i)).path.equals(localObject))
        {
          j = i;
          break;
        }
        i += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = ");
      localStringBuilder.append(j);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      if (j >= 0)
      {
        this.l = ((String)localObject);
        ((AEAbstractPhotoListFragment)this.b.get()).d.notifyDataSetChanged();
      }
      b((String)localObject, false, false, true);
    }
  }
  
  private ArrayList<String> q()
  {
    return this.c.selectedPhotoList;
  }
  
  private boolean r()
  {
    return (!this.e.canMixPhotoAndVideo) && ((!q().isEmpty()) || (!this.e.canPickVideo));
  }
  
  private void s()
  {
    ((AEAbstractPhotoListFragment)this.b.get()).m.releasePlayer(false);
  }
  
  private void t()
  {
    if (VersionUtils.b())
    {
      Activity localActivity = ((AEAbstractPhotoListFragment)this.b.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
  
  private void u()
  {
    if (VersionUtils.b())
    {
      Activity localActivity = ((AEAbstractPhotoListFragment)this.b.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  private void v()
  {
    if (!TextUtils.isEmpty(this.q))
    {
      Object localObject = b(this.q);
      if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) != 0)) {
        return;
      }
      if (b(this.c.selectedPhotoList, this.q))
      {
        localObject = f(this.q);
        localObject = ((AEAbstractPhotoListFragment)this.b.get()).l.a((EditorPicInfo)localObject);
        Matrix localMatrix = ((AEAbstractPhotoListFragment)this.b.get()).l.getImageMatrix();
        if ((localObject != null) && (localMatrix != null)) {
          a(this.q, (EditorPicInfo)localObject, localMatrix);
        }
      }
      else
      {
        d(this.q);
      }
    }
  }
  
  private boolean w()
  {
    if ((this.c != null) && (this.c.selectedPhotoList != null) && (this.c.selectedPhotoList.size() > 1)) {
      return AECameraPrefsUtil.a().b("sp_key_ae_ratio_toasted", true, 0);
    }
    return false;
  }
  
  private void x()
  {
    if (!CollectionUtils.isEmpty(this.c.selectedPhotoList))
    {
      Iterator localIterator = new ArrayList(this.c.selectedPhotoList).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = b(str);
        localObject = localLocalMediaInfo;
        if (localLocalMediaInfo == null)
        {
          AEQLog.b("AEPhotoListLogicBase", "clearSelectedData---failed get media info at first, try another way");
          localObject = a(str);
        }
        if (localObject != null) {
          ((LocalMediaInfo)localObject).selectStatus = 2;
        } else {
          AEQLog.d("AEPhotoListLogicBase", "clearSelectedData---still failed to get media info");
        }
      }
      Object localObject = this.n.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LocalMediaInfo)((Iterator)localObject).next()).selectStatus = 2;
      }
      this.c.selectedPhotoList.clear();
      this.c.selectedIndex.clear();
      this.c.selectedMediaInfoHashMap.clear();
    }
  }
  
  private void y()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new LinkedList(this.c.selectedPhotoList);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      String str = (String)((List)localObject1).get(i);
      Object localObject2;
      if (TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleClickNextBtnForOnlyPhoto--empty path, drop it: ");
        ((StringBuilder)localObject2).append(str);
        AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = e(str);
        if ((localObject2 != null) && (((AEPhotoCropInfoWrapper)localObject2).a != null))
        {
          if (!new File(str).exists())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleClickNextBtnForOnlyPhoto--file not exists, drop it: ");
            ((StringBuilder)localObject2).append(str);
            AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject2).toString());
          }
          else
          {
            localArrayList.add(((AEPhotoCropInfoWrapper)localObject2).a);
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleClickNextBtnForOnlyPhoto--no crop info, drop it: ");
          ((StringBuilder)localObject2).append(str);
          AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    if (CollectionUtils.isEmpty(localArrayList))
    {
      QQToast.makeText(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2064187565, 0).show();
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
    i = AECameraEntry.y.a();
    if (AECameraEntryManager.r(((AEAbstractPhotoListFragment)this.b.get()).getActivity().getIntent())) {
      i = AECameraEntry.A.a();
    }
    AEEditorLauncher.a(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 0, (Bundle)localObject1, i);
  }
  
  private void z()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.c.selectedPhotoList);
    int i = 0;
    while (i < localLinkedList.size())
    {
      String str1 = (String)localLinkedList.get(i);
      Object localObject;
      if (TextUtils.isEmpty(str1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: ");
        ((StringBuilder)localObject).append(str1);
        AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
      }
      else if (!new File(str1).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: ");
        ((StringBuilder)localObject).append(str1);
        AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = b(str1);
        if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1))
        {
          int j = b((LocalMediaInfo)localObject);
          if ((j != 2) && (j != 0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: ");
            ((StringBuilder)localObject).append(str1);
            AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new AEAlbumVideoModel(str1);
            ((AEAlbumVideoModel)localObject).setOriginPath(str1);
            localArrayList1.add(localObject);
            if (j == 2)
            {
              String str2 = (String)this.s.get(str1);
              if (TextUtils.isEmpty(str2))
              {
                localArrayList2.add(localObject);
              }
              else
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("hit cache, no need compress for: ");
                localStringBuilder.append(str1);
                AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
                ((AEAlbumVideoModel)localObject).setPath(str2);
              }
            }
          }
        }
        else
        {
          localObject = e(str1);
          if ((localObject != null) && (((AEPhotoCropInfoWrapper)localObject).a != null))
          {
            localObject = new AEAlbumImageModel(str1, ((AEPhotoCropInfoWrapper)localObject).a);
            ((AEAlbumImageModel)localObject).setOriginPath(str1);
            localArrayList1.add(localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--no crop info, drop it: ");
            ((StringBuilder)localObject).append(str1);
            AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
          }
        }
      }
      i += 1;
    }
    if (CollectionUtils.isEmpty(localArrayList1))
    {
      AEQLog.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
      QQToast.makeText(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2064187566, 0).show();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      b(localArrayList1);
      return;
    }
    if (this.u == null)
    {
      this.u = new AEEditorCancelableProgressDialog(((AEAbstractPhotoListFragment)this.b.get()).getActivity());
      this.u.a(((AEAbstractPhotoListFragment)this.b.get()).getString(2064187707));
      this.u.a(new AEPhotoListLogicBase.14(this));
    }
    this.u.show();
    AEQLog.a("AEPhotoListLogicBase", "after show, submit compress task");
    ThreadManagerV2.excute(new AEPhotoListLogicBase.15(this, localArrayList2, localArrayList1), 16, new AEPhotoListLogicBase.16(this), true);
  }
  
  public LocalMediaInfo a(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.c;
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
  
  String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.c.maxSelectNum;
    return ((AEAbstractPhotoListFragment)this.b.get()).getResources().getString(2131892559, new Object[] { Integer.valueOf(i) });
  }
  
  public void a(float paramFloat)
  {
    ((AEAbstractPhotoListFragment)this.b.get()).q.setAlpha(paramFloat);
    paramFloat = 1.0F - paramFloat;
    if ((this.y != 0) && (this.z == 2)) {
      ((AEAbstractPhotoListFragment)this.b.get()).r.scrollBy(0, (int)(this.y * (paramFloat - this.A)));
    }
    this.A = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.z = paramInt;
    this.A = 0.0F;
    if (paramInt == 1)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).q.setVisibility(0);
      ((AEAbstractPhotoListFragment)this.b.get()).g();
      if (this.e.canSwitchSelectionMode) {
        ((AEAbstractPhotoListFragment)this.b.get()).s.setVisibility(8);
      }
    }
  }
  
  protected void a(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleVideoItemClickForMix, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.n.get(paramInt);
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if ((!paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      if ((q() != null) && (q().size() + this.e.initialHasPickedNum >= this.c.maxSelectNum))
      {
        AEQLog.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, exceededPhotoLimit");
        a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        return;
      }
      a(paramPhotoVH);
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      b(paramInt);
      bool = m();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
      return;
    }
    if ((paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramPhotoVH);
      b(paramInt);
      bool = m();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
      return;
    }
    if ((paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      if (q().size() > 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = ");
        localStringBuilder.append(paramInt);
        AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
        b(paramPhotoVH);
        b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        p();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      ((AEAbstractPhotoListFragment)this.b.get()).d.notifyDataSetChanged();
      return;
    }
    if ((!paramPhotoVH.e.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      bool = m();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (this.c.maxSelectNum > 100) {
      paramPhotoVH.e.setTextSize(10.0F);
    }
    paramPhotoVH.j = paramPhotoItemClickListener;
    int i;
    if (this.m)
    {
      this.m = false;
      this.l = ((LocalMediaInfo)this.n.get(paramInt)).path;
      paramPhotoVH.c.setVisibility(0);
    }
    else
    {
      paramPhotoItemClickListener = paramPhotoVH.c;
      if (this.l.equals(((LocalMediaInfo)this.n.get(paramInt)).path)) {
        i = 0;
      } else {
        i = 8;
      }
      paramPhotoItemClickListener.setVisibility(i);
    }
    if ((!this.c.isSingleMode) && (paramPhotoVH.h != null)) {
      paramPhotoVH.h.setVisibility(0);
    }
    paramPhotoItemClickListener = new AEPhotoListLogicBase.2(this, paramPhotoVH, paramInt);
    paramPhotoVH.e.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.h.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.j.a(paramInt);
    paramPhotoVH.j.a(paramPhotoVH.e);
    paramPhotoVH.itemView.setOnClickListener(new AEPhotoListLogicBase.3(this, paramInt, paramPhotoVH));
    Object localObject1 = paramPhotoVH.b;
    ((ImageView)localObject1).setAdjustViewBounds(false);
    paramPhotoItemClickListener = ((AEAbstractPhotoListFragment)this.b.get()).d.a(paramInt);
    Object localObject2 = QAlbumUtil.createContentDescription(0, paramPhotoItemClickListener, paramInt);
    paramPhotoVH.itemView.setContentDescription((CharSequence)localObject2);
    if (paramPhotoItemClickListener != null)
    {
      paramPhotoVH.a.setVisibility(4);
      if ((this.d.Q) && (((AEAbstractPhotoListFragment)this.b.get()).a(paramPhotoItemClickListener)))
      {
        if (paramPhotoVH.i == null)
        {
          paramPhotoVH.i = ((AEAbstractPhotoListFragment)this.b.get()).d.a();
          paramPhotoVH.i.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)paramPhotoVH.itemView).addView(paramPhotoVH.i, (ViewGroup.LayoutParams)localObject2);
        }
        paramPhotoVH.i.setVisibility(0);
      }
      else if (paramPhotoVH.i != null)
      {
        paramPhotoVH.i.setVisibility(8);
      }
      i = AlbumThumbDownloader.THUMB_WIDHT;
      paramPhotoItemClickListener.thumbHeight = i;
      paramPhotoItemClickListener.thumbWidth = i;
      localObject2 = paramPhotoVH.f;
      StringBuilder localStringBuilder = new StringBuilder("albumthumb");
      localStringBuilder.append("://");
      localStringBuilder.append(paramPhotoItemClickListener.path);
      if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
      {
        localObject2 = QAlbumUtil.generateAlbumThumbURL(paramPhotoItemClickListener);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("photoGridAdapter,getView(),image url :");
          localStringBuilder.append(((URL)localObject2).toString());
          QLog.d("PhotoListActivity", 2, localStringBuilder.toString());
        }
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, ((AEAbstractPhotoListFragment)this.b.get()).d.c, ((AEAbstractPhotoListFragment)this.b.get()).d.b);
        ((URLDrawable)localObject2).setTag(paramPhotoItemClickListener);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((URLImageView)localObject1).setURLDrawableDownListener(((AEAbstractPhotoListFragment)this.b.get()).d);
        paramPhotoVH.f = ((URLDrawable)localObject2);
      }
      i = paramPhotoItemClickListener.selectStatus;
      if (i == 1)
      {
        paramPhotoVH.e.setCheckedNumber(this.c.selectedPhotoList.indexOf(paramPhotoItemClickListener.path) + 1 + this.e.initialHasPickedNum);
        if (paramPhotoVH.itemView.getBackground() != null) {
          paramPhotoVH.itemView.setBackgroundDrawable(null);
        }
      }
      else if (i == 3)
      {
        paramPhotoVH.e.setChecked(false);
      }
      else
      {
        paramPhotoVH.e.setChecked(false);
        if (paramPhotoVH.itemView.getBackground() != null) {
          paramPhotoVH.itemView.setBackgroundDrawable(null);
        }
      }
      if (AppSetting.e)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, paramPhotoItemClickListener, paramInt, paramPhotoVH.e.isChecked());
        paramPhotoVH.e.setContentDescription((CharSequence)localObject1);
      }
      paramPhotoItemClickListener.visableTime = SystemClock.uptimeMillis();
      paramPhotoItemClickListener.listViewPosition = paramInt;
      a(paramPhotoVH, paramPhotoItemClickListener);
      if ((this.c.selectedPhotoList.size() + this.e.initialHasPickedNum >= this.c.maxSelectNum) && (i != 1) && (!this.c.isSingleMode))
      {
        paramPhotoVH.b.setAlpha(0.3F);
        return;
      }
      paramPhotoVH.b.setAlpha(1.0F);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.A = 0.0F;
    this.y = 0;
    if ((paramInt == 2) && (paramBoolean))
    {
      ((AEAbstractPhotoListFragment)this.b.get()).q.setVisibility(8);
      if (A()) {
        ((AEAbstractPhotoListFragment)this.b.get()).g();
      } else {
        ((AEAbstractPhotoListFragment)this.b.get()).f();
      }
      if (this.e.canSwitchSelectionMode) {
        ((AEAbstractPhotoListFragment)this.b.get()).s.setVisibility(0);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.d.N = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.d.N) && (l1 - l2 < 60000L))
      {
        this.c.albumName = QAlbumUtil.sLastAlbumName;
        this.c.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.c.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.c.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.c.albumId == null)
    {
      this.c.albumId = "$RecentAlbumId";
      this.c.albumName = null;
    }
    this.d.Q = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.c.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.c.selectedPhotoList == null) {
      this.c.selectedPhotoList = new ArrayList();
    }
    if (this.c.selectedMediaInfoHashMap == null) {
      this.c.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.c.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.c.selectedMediaInfoHashMap.clear();
      this.c.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.c.selectedIndex = new ArrayList();
    this.c.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    this.c.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.c.filter = MediaFileFilter.getFilter(this.c.showMediaType);
    this.d.O = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.d.O) {
      this.d.P = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.c.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    if (this.c.showMediaType == 2) {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    this.t = ((String)localObject);
    this.e.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.e.minSelectNumForMix = 2;
    this.e.maxSelectNumForMix = 30;
    this.e.minSelectNumForNormal = -2147483648;
    this.e.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    this.e.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    this.e.initialHasPickedNum = ((AEAbstractPhotoListFragment)this.b.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.e.canPickVideo = ((AEAbstractPhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    n();
    paramIntent = new StringBuilder();
    paramIntent.append("initData---aeAlbumData=");
    paramIntent.append(this.e);
    AEQLog.b("AEPhotoListLogicBase", paramIntent.toString());
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    ((AEAbstractPhotoListFragment)this.b.get()).getActivity().finish();
    QAlbumUtil.anim(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox) {}
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AEQLog.b("AEPhotoListLogicBase", "checkShowImagePreview--");
    if (!paramBoolean2)
    {
      a(paramString, paramBoolean1);
      return;
    }
    ((AEAbstractPhotoListFragment)this.b.get()).l.post(new AEPhotoListLogicBase.10(this, paramString, paramBoolean1));
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AEQLog.b("AEPhotoListLogicBase", "checkShowVideoPreview--");
    if (!paramBoolean2)
    {
      b(paramString, paramBoolean1, paramBoolean3);
      return;
    }
    ((AEAbstractPhotoListFragment)this.b.get()).l.post(new AEPhotoListLogicBase.11(this, paramString, paramBoolean1, paramBoolean3));
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList, boolean paramBoolean)
  {
    this.n = paramArrayList;
    d(paramBoolean);
  }
  
  public void a(List<LocalMediaInfo> paramList) {}
  
  protected void a(boolean paramBoolean)
  {
    n();
    ((AEAbstractPhotoListFragment)this.b.get()).b(paramBoolean);
    int i;
    if (paramBoolean)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).g();
      i = ((AEAbstractPhotoListFragment)this.b.get()).l.getRatioType();
      if (i == 1)
      {
        d(i);
        ((AEAbstractPhotoListFragment)this.b.get()).l.a();
      }
    }
    else
    {
      i = ((AEAbstractPhotoListFragment)this.b.get()).l.getRatioType();
      if (i == 2)
      {
        d(i);
        ((AEAbstractPhotoListFragment)this.b.get()).l.a();
      }
      if (!A()) {
        ((AEAbstractPhotoListFragment)this.b.get()).f();
      }
      x();
    }
    d(true);
    ((AEAbstractPhotoListFragment)this.b.get()).d.notifyDataSetChanged();
    d();
  }
  
  void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.c.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.d.A);
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.c.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.c.albumName);
    paramIntent.putExtra("ALBUM_ID", this.c.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramIntent.setClass(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), ((AEAbstractPhotoListFragment)this.b.get()).e());
    paramIntent.addFlags(603979776);
    c(paramIntent);
    QAlbumUtil.anim(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), true, true);
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    if (this.b.get() != null)
    {
      if (((AEAbstractPhotoListFragment)this.b.get()).getActivity() == null) {
        return false;
      }
      ((AEAbstractPhotoListFragment)this.b.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this));
      Object localObject;
      if (paramList == null)
      {
        if ((!this.d.O) || (!this.c.albumId.equals("$RecentAlbumId")))
        {
          localObject = paramList;
          if (this.d.P)
          {
            localObject = paramList;
            if (!this.c.albumId.equals("$VideoAlbumId")) {}
          }
        }
        else
        {
          paramList = new LocalMediaInfo();
          paramList.mMimeType = "mobileqq/camera";
          localObject = new ArrayList();
          ((List)localObject).add(0, paramList);
        }
        ((AEAbstractPhotoListFragment)this.b.get()).d.a((List)localObject, true);
        ((AEAbstractPhotoListFragment)this.b.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.7(this));
        return false;
      }
      if (((this.d.O) && (this.c.albumId.equals("$RecentAlbumId"))) || ((this.d.P) && (this.c.albumId.equals("$VideoAlbumId"))))
      {
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
        paramList.add(0, localObject);
      }
      ((AEAbstractPhotoListFragment)this.b.get()).d.a(paramList, paramBoolean);
      paramBoolean = paramList.isEmpty();
      ((AEAbstractPhotoListFragment)this.b.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.8(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public View aj_()
  {
    View localView = ((AEAbstractPhotoListFragment)this.b.get()).d.d.inflate(2064056338, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.b.get()).f, ((AEAbstractPhotoListFragment)this.b.get()).g));
    return localView;
  }
  
  public List<LocalMediaInfo> b(boolean paramBoolean)
  {
    int i;
    if (this.c.albumId.equals("$RecentAlbumId")) {
      i = 100;
    } else {
      i = -1;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), this.c.albumId, this.c.albumName, i, this.c.filter, this.c.filter.videoMaxDuration);
    LogTag.a("PEAK", "getAlbumMedias");
    List localList1 = localList2;
    if (localList2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localList1 = null;
    }
    return localList1;
  }
  
  public void b()
  {
    this.e.canMixPhotoAndVideo ^= true;
    a(this.e.canMixPhotoAndVideo);
    AEBaseDataReporter.a().a(this.e.canMixPhotoAndVideo);
  }
  
  public void b(float paramFloat)
  {
    ((AEAbstractPhotoListFragment)this.b.get()).q.setAlpha(paramFloat);
  }
  
  public void b(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (this.c.maxSelectNum > 100) {
      paramPhotoVH.e.setTextSize(10.0F);
    }
    if (this.e.canMixPhotoAndVideo)
    {
      if (this.m)
      {
        this.m = false;
        this.l = ((LocalMediaInfo)this.n.get(paramInt)).path;
        paramPhotoVH.c.setVisibility(0);
      }
      else
      {
        localObject = paramPhotoVH.c;
        if (this.l.equals(((LocalMediaInfo)this.n.get(paramInt)).path)) {
          i = 0;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else {
      paramPhotoVH.c.setVisibility(8);
    }
    paramPhotoVH.j = paramPhotoItemClickListener;
    if ((!this.c.isSingleMode) && (this.d.B) && (paramPhotoVH.h != null)) {
      paramPhotoVH.h.setVisibility(0);
    } else {
      paramPhotoVH.h.setVisibility(8);
    }
    paramPhotoItemClickListener = new AEPhotoListLogicBase.4(this, paramPhotoVH, paramInt);
    paramPhotoVH.e.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.h.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.itemView.setOnClickListener(new AEPhotoListLogicBase.5(this, paramPhotoVH, paramInt));
    paramPhotoVH.j.a(paramInt);
    paramPhotoVH.j.a(paramPhotoVH.e);
    ImageView localImageView = paramPhotoVH.b;
    localImageView.setAdjustViewBounds(false);
    Object localObject = ((AEAbstractPhotoListFragment)this.b.get()).d.a(paramInt);
    paramPhotoItemClickListener = QAlbumUtil.createContentDescription(1, (LocalMediaInfo)localObject, paramInt);
    paramPhotoVH.itemView.setContentDescription(paramPhotoItemClickListener);
    if (((LocalMediaInfo)localObject).isSystemMeidaStore) {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject, "VIDEO");
    } else {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject, "APP_VIDEO");
    }
    int i = AlbumThumbDownloader.THUMB_WIDHT;
    ((LocalMediaInfo)localObject).thumbHeight = i;
    ((LocalMediaInfo)localObject).thumbWidth = i;
    URLDrawable localURLDrawable = paramPhotoVH.f;
    if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramPhotoItemClickListener)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhotoListAdapter,getView(),vedio url :");
        localStringBuilder.append(paramPhotoItemClickListener.toString());
        QLog.d("PhotoListActivity", 2, localStringBuilder.toString());
      }
      paramPhotoItemClickListener = URLDrawableHelper.getDrawable(paramPhotoItemClickListener, ((AEAbstractPhotoListFragment)this.b.get()).d.c, ((AEAbstractPhotoListFragment)this.b.get()).d.b);
      paramPhotoItemClickListener.setTag(localObject);
      localImageView.setImageDrawable(paramPhotoItemClickListener);
      ((URLImageView)localImageView).setURLDrawableDownListener(((AEAbstractPhotoListFragment)this.b.get()).d);
      paramPhotoVH.f = paramPhotoItemClickListener;
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload();
      }
    }
    paramPhotoItemClickListener = paramPhotoVH.g;
    if ((!((LocalMediaInfo)localObject).isSystemMeidaStore) && (((LocalMediaInfo)localObject).mDuration <= 0L))
    {
      paramPhotoItemClickListener.setVisibility(8);
      paramPhotoItemClickListener = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (paramPhotoItemClickListener != null) {
        paramPhotoItemClickListener.queryMediaInfoDuration(this, (LocalMediaInfo)localObject, paramInt);
      }
    }
    else
    {
      paramPhotoItemClickListener.setVisibility(0);
      paramPhotoItemClickListener.setText(QAlbumUtil.formatTimeToString(((LocalMediaInfo)localObject).mDuration));
    }
    i = ((LocalMediaInfo)localObject).selectStatus;
    if (i == 1)
    {
      paramPhotoVH.e.setCheckedNumber(this.c.selectedPhotoList.indexOf(((LocalMediaInfo)localObject).path) + 1 + this.e.initialHasPickedNum);
      if (paramPhotoVH.itemView.getBackground() != null) {
        paramPhotoVH.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    else if (i == 3)
    {
      paramPhotoVH.e.setChecked(false);
    }
    else
    {
      paramPhotoVH.e.setChecked(false);
      if (paramPhotoVH.itemView.getBackground() != null) {
        paramPhotoVH.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    ((LocalMediaInfo)localObject).visableTime = SystemClock.uptimeMillis();
    ((LocalMediaInfo)localObject).listViewPosition = paramInt;
    if ((!r()) && ((this.c.selectedPhotoList.size() + this.e.initialHasPickedNum < this.c.maxSelectNum) || (i == 1) || (this.c.isSingleMode)))
    {
      paramPhotoVH.b.setAlpha(1.0F);
      return;
    }
    paramPhotoVH.b.setAlpha(0.3F);
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.c.selectedPhotoList;
    HashMap localHashMap1 = this.c.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.c.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.c.allMediaInfoHashMap.get(str);
      }
      if (localObject != null)
      {
        localHashMap2.put(str, localObject);
      }
      else
      {
        localObject = (LocalMediaInfo)localHashMap1.get(str);
        if (localObject != null) {
          localHashMap2.put(str, localObject);
        }
      }
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    paramIntent.putExtra("ALBUM_ID", this.c.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.c.albumName);
  }
  
  public void b(View paramView)
  {
    a(false, ((AEAbstractPhotoListFragment)this.b.get()).getActivity().getIntent());
  }
  
  public void c()
  {
    TextView localTextView = ((AEAbstractPhotoListFragment)this.b.get()).s;
    int i;
    if (this.e.canSwitchSelectionMode) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    a(this.e.canMixPhotoAndVideo);
  }
  
  public void c(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener) {}
  
  public void c(Intent paramIntent)
  {
    ((AEAbstractPhotoListFragment)this.b.get()).startActivity(paramIntent);
    ((AEAbstractPhotoListFragment)this.b.get()).getActivity().finish();
  }
  
  public void c(View paramView) {}
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (paramBoolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.c.albumName))
    {
      if (this.t.equals(this.c.albumName)) {
        return;
      }
      this.t = this.c.albumName;
      if (!CollectionUtils.isEmpty(this.n))
      {
        int i = ((AEAbstractPhotoListFragment)this.b.get()).k.findFirstVisibleItemPosition();
        this.y = (((AEAbstractPhotoListFragment)this.b.get()).r.getChildAt(0 - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.b.get()).getActivity(), 2.0F));
      }
      ((AEAbstractPhotoListFragment)this.b.get()).j.b();
    }
  }
  
  void d()
  {
    ArrayList localArrayList = this.c.selectedPhotoList;
    String str = ((AEAbstractPhotoListFragment)this.b.get()).getString(2131892542);
    int i;
    if (localArrayList.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("(");
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(")");
      localStringBuilder.toString();
    }
  }
  
  public void d(View paramView)
  {
    int i = ((AEAbstractPhotoListFragment)this.b.get()).l.getRatioType();
    if (i == 1) {
      AEBaseDataReporter.a().c(0);
    } else if (i == 2) {
      AEBaseDataReporter.a().c(1);
    }
    if (w())
    {
      AECameraPrefsUtil.a().a("sp_key_ae_ratio_toasted", false, 0);
      e(i);
    }
    d(i);
    ((AEAbstractPhotoListFragment)this.b.get()).l.a();
  }
  
  public void e(View paramView)
  {
    paramView = this.c.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.q))) {
      paramView.add(this.q);
    }
    v();
    if (this.e.canMixPhotoAndVideo)
    {
      z();
      return;
    }
    y();
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (this.d.G)
    {
      ((AEAbstractPhotoListFragment)this.b.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.13(this));
      return;
    }
    this.d.G = true;
  }
  
  public void g()
  {
    if (!this.d.z) {
      AlbumThumbManager.getInstance(((AEAbstractPhotoListFragment)this.b.get()).getActivity()).clear();
    }
    if (((AEAbstractPhotoListFragment)this.b.get()).d != null)
    {
      int i = ((AEAbstractPhotoListFragment)this.b.get()).d.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.c.albumId, Integer.valueOf(i));
    }
    if (((AEAbstractPhotoListFragment)this.b.get()).B != null) {
      ((AEAbstractPhotoListFragment)this.b.get()).B.cancel(true);
    }
    Map localMap = this.r;
    if (localMap != null) {
      localMap.clear();
    }
    this.q = null;
    a();
  }
  
  public void h()
  {
    if (((AEAbstractPhotoListFragment)this.b.get()).j.d()) {
      ((AEAbstractPhotoListFragment)this.b.get()).j.b();
    }
  }
  
  protected void i() {}
  
  public View j()
  {
    View localView = ((AEAbstractPhotoListFragment)this.b.get()).d.d.inflate(2064056341, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.b.get()).f, ((AEAbstractPhotoListFragment)this.b.get()).g));
    return localView;
  }
  
  public View k()
  {
    ImageView localImageView = new ImageView(((AEAbstractPhotoListFragment)this.b.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.b.get()).f, ((AEAbstractPhotoListFragment)this.b.get()).g));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130842448);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  protected boolean l()
  {
    return false;
  }
  
  protected boolean m()
  {
    return ((AEAbstractPhotoListFragment)this.b.get()).j.c();
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
 * JD-Core Version:    0.7.0.1
 */