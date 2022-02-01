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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.BitmapUtil;
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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private AEEditorCancelableProgressDialog jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog;
  private String jdField_a_of_type_JavaLangString = null;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, AEPhotoCropInfoWrapper> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  protected final boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private final Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private String jdField_c_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private volatile boolean d = false;
  
  protected AEPhotoListLogicBase(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IitemClickCallback = this;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IadapterCallback = this;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IcheckBoxCallback = this;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (paramString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).path)) {
        return i;
      }
      i += 1;
    }
    return -1;
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
  
  @Nullable
  private AEPhotoCropInfoWrapper a(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.size() != 0)) {
      return (AEPhotoCropInfoWrapper)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  private EditorPicInfo a(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = a(paramString);
    if ((localObject != null) && (((AEPhotoCropInfoWrapper)localObject).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo != null)) {
      return ((AEPhotoCropInfoWrapper)localObject).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo;
    }
    localObject = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    ((EditorPicInfo)localObject).picPath = paramString;
    ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
    ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
    return localObject;
  }
  
  private URLDrawable a()
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
  
  private ArrayList<String> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setSelected], photoPath=");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, true, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemViewType(paramInt), paramInt);
  }
  
  private void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.c.setVisibility(0);
  }
  
  private void a(@NonNull String paramString)
  {
    AEQLog.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.size() > 0)) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  private void a(@NonNull String paramString, @NonNull AEPhotoCropInfoWrapper paramAEPhotoCropInfoWrapper)
  {
    AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramAEPhotoCropInfoWrapper);
  }
  
  private void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, Matrix paramMatrix)
  {
    AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      AEQLog.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    AEPhotoCropInfoWrapper localAEPhotoCropInfoWrapper = a(paramString);
    if (localAEPhotoCropInfoWrapper == null) {
      localAEPhotoCropInfoWrapper = new AEPhotoCropInfoWrapper();
    }
    localAEPhotoCropInfoWrapper.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo = paramEditorPicInfo;
    localAEPhotoCropInfoWrapper.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
    a(paramString, localAEPhotoCropInfoWrapper);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    n();
    a(false, true);
    this.jdField_b_of_type_JavaLangString = paramString;
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, 1440, 1440));
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a() == 1)) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
    }
    this.jdField_a_of_type_Float = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
    this.jdField_b_of_type_Float = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.b();
    f(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a());
    AEPhotoCropInfoWrapper localAEPhotoCropInfoWrapper = a(paramString);
    if ((localAEPhotoCropInfoWrapper != null) && (localAEPhotoCropInfoWrapper.jdField_a_of_type_AndroidGraphicsMatrix != null) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, paramString))) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setImageMatrix(localAEPhotoCropInfoWrapper.jdField_a_of_type_AndroidGraphicsMatrix);
    } else {
      a(paramString);
    }
    if (paramBoolean) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.b();
    }
    if (f())
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      return;
    }
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
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
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("batchCompress---begin, index=");
      localStringBuilder.append(i);
      AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.17(this, i, j));
      a(localLocalMediaInfo, new AEPhotoListLogicBase.18(this, i, localAEAlbumVideoModel));
      if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch != null)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = null;
      }
    } while ((!this.jdField_c_of_type_Boolean) && (!this.d));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 8;
    if (paramBoolean1)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      TextView localTextView = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
        i = 0;
      }
      localTextView.setVisibility(i);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      k();
      this.jdField_b_of_type_JavaLangString = null;
      return;
    }
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    if (paramBoolean2)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setVisibility(0);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
      k();
      return;
    }
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setVisibility(4);
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(0);
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
  }
  
  private boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  @Nullable
  private LocalMediaInfo b(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null)) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      Object localObject = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
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
    if (!this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!currentFocusedImagePath.equals(mAllImages.get(position).path), position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      int i = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      if (i >= 0) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyItemChanged(i);
      }
    }
  }
  
  private void b(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePhotoItemClick, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if ((!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      if ((a() != null) && (a().size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        AEQLog.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        return;
      }
      a(paramPhotoVH);
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      b(paramInt);
      bool = c();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
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
    if ((paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramPhotoVH);
      bool = c();
      b(paramInt);
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false);
      return;
    }
    if ((paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      if (a().size() > 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = ");
        localStringBuilder.append(paramInt);
        AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
        b(paramPhotoVH);
        b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        j();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyDataSetChanged();
      return;
    }
    if ((!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
        c(0);
      }
    }
  }
  
  private void b(int paramInt, LocalMediaInfo paramLocalMediaInfo, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    paramPhotoVH = new StringBuilder();
    paramPhotoVH.append("cancelSelected image.path = ");
    paramPhotoVH.append(paramLocalMediaInfo.path);
    AEQLog.a("AEPhotoListLogicBase", paramPhotoVH.toString());
    a(paramLocalMediaInfo.path);
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, false, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemViewType(paramInt), paramInt);
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
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.b();
    }
    localObject = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_JavaLangString)))
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
    n();
    this.jdField_b_of_type_JavaLangString = paramString;
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mIsMute = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mSceneId = 113;
    localVideoPlayParam.mSceneName = SceneID.a(113);
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
    if (!StringUtil.a(paramString))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
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
    Activity localActivity = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    Intent localIntent = localActivity.getIntent();
    if (AECameraEntryManager.o(localIntent))
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
    if (AECameraEntryManager.m(localIntent)) {
      i = AECameraEntry.A.a();
    }
    AEEditorLauncher.a(localActivity, 2, localBundle, i);
  }
  
  private void c(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (a().size() == 1))
    {
      if (paramInt > 0)
      {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEPhotoListLogicBase.9(this), paramInt);
        return;
      }
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyDataSetChanged();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      if (a().isEmpty())
      {
        String str = null;
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        int i = 0;
        while (i < localArrayList.size())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localArrayList.get(i);
          if (localLocalMediaInfo != null) {
            if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
            {
              if (AlbumUtil.getMediaType(localLocalMediaInfo) == 1)
              {
                int j = a(localLocalMediaInfo);
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
        this.jdField_a_of_type_JavaLangString = str;
        b(str, paramBoolean, true, false);
        if (i > 0) {
          ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicBase.1(this, i));
        }
      }
      else
      {
        AEQLog.b("AEPhotoListLogicBase", "changeFocusAndPreviewWhenDataChanged---already picked some items, preview won't change");
      }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Size localSize = BitmapUtil.getImageSize(str);
        EditorPicInfo localEditorPicInfo = new EditorPicInfo();
        localEditorPicInfo.picPath = str;
        localEditorPicInfo.originPicWidth = localSize.getWidth();
        localEditorPicInfo.originPicHeight = localSize.getHeight();
        double d1 = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
        if (paramInt == 1)
        {
          if (d1 <= 0.333333343267441D)
          {
            d1 = (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight;
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = d1;
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = (localEditorPicInfo.originPicWidth / 0.333333343267441D * 1.0D / localEditorPicInfo.originPicHeight);
          }
          else if (d1 >= 1.777777791023254D)
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
          if (d1 < 1.0D)
          {
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = ((localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight);
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = d1;
          }
          else
          {
            localEditorPicInfo.x = ((localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight) * 1.0D / 2.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = d1;
            localEditorPicInfo.h = 1.0D;
          }
        }
        a(str, localEditorPicInfo, null);
      }
    }
  }
  
  private boolean d()
  {
    return (!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && ((!a().isEmpty()) || (!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo));
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 1)
    {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2064515096), 1).a();
      return;
    }
    if (paramInt == 2) {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2064515097), 1).a();
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 1)) {
      return AECameraPrefsUtil.a().a("sp_key_ae_ratio_toasted", true, 0);
    }
    return false;
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 1)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setMinZoom(this.jdField_b_of_type_Float);
      return;
    }
    if (paramInt == 2)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setMinZoom(this.jdField_a_of_type_Float);
    }
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
      return true;
    }
    if (a() == null) {
      return true;
    }
    Object localObject = this.jdField_b_of_type_JavaLangString;
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
  
  private void i()
  {
    Intent localIntent = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForMix;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    }
    if (localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    }
  }
  
  private void j()
  {
    if (!a().isEmpty())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mPhotoCommonData.selectedPhotoList.size() = ");
      ((StringBuilder)localObject).append(a().size());
      AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
      localObject = (String)a().get(a().size() - 1);
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).path.equals(localObject))
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
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyDataSetChanged();
      }
      b((String)localObject, false, false, true);
    }
  }
  
  private void k()
  {
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
  }
  
  private void l()
  {
    if (VersionUtils.b())
    {
      Activity localActivity = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
  
  private void m()
  {
    if (VersionUtils.b())
    {
      Activity localActivity = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  private void n()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject = b(this.jdField_b_of_type_JavaLangString);
      if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) != 0)) {
        return;
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_b_of_type_JavaLangString))
      {
        localObject = a(this.jdField_b_of_type_JavaLangString);
        localObject = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a((EditorPicInfo)localObject);
        Matrix localMatrix = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
        if ((localObject != null) && (localMatrix != null)) {
          a(this.jdField_b_of_type_JavaLangString, (EditorPicInfo)localObject, localMatrix);
        }
      }
      else
      {
        a(this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void o()
  {
    if (!CollectionUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList))
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList).iterator();
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
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LocalMediaInfo)((Iterator)localObject).next()).selectStatus = 2;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
    }
  }
  
  private void p()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
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
        localObject2 = a(str);
        if ((localObject2 != null) && (((AEPhotoCropInfoWrapper)localObject2).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo != null))
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
            localArrayList.add(((AEPhotoCropInfoWrapper)localObject2).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo);
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
      QQToast.a(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2064515218, 0).a();
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
    i = AECameraEntry.y.a();
    if (AECameraEntryManager.m(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = AECameraEntry.A.a();
    }
    AEEditorLauncher.a(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 0, (Bundle)localObject1, i);
  }
  
  private void q()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
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
          int j = a((LocalMediaInfo)localObject);
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
              String str2 = (String)this.jdField_b_of_type_JavaUtilMap.get(str1);
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
          localObject = a(str1);
          if ((localObject != null) && (((AEPhotoCropInfoWrapper)localObject).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo != null))
          {
            localObject = new AEAlbumImageModel(str1, ((AEPhotoCropInfoWrapper)localObject).jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo);
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
      QQToast.a(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2064515219, 0).a();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      b(localArrayList1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog = new AEEditorCancelableProgressDialog(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.a(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2064515420));
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.a(new AEPhotoListLogicBase.14(this));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.show();
    AEQLog.a("AEPhotoListLogicBase", "after show, submit compress task");
    ThreadManagerV2.excute(new AEPhotoListLogicBase.15(this, localArrayList2, localArrayList1), 16, new AEPhotoListLogicBase.16(this), true);
  }
  
  public View a()
  {
    View localView = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318478, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
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
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    return ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694856, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    } else {
      i = -1;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration);
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
  
  public void a(float paramFloat)
  {
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
    paramFloat = 1.0F - paramFloat;
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int == 2)) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, (int)(this.jdField_a_of_type_Int * (paramFloat - this.jdField_c_of_type_Float)));
    }
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Float = 0.0F;
    if (paramInt == 1)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout.setVisibility(0);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  protected void a(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleVideoItemClickForMix, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if ((!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      if ((a() != null) && (a().size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        AEQLog.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, exceededPhotoLimit");
        a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        return;
      }
      a(paramPhotoVH);
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      b(paramInt);
      bool = c();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
      return;
    }
    if ((paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 8))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，没有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramPhotoVH);
      b(paramInt);
      bool = c();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
      return;
    }
    if ((paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      if (a().size() > 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = ");
        localStringBuilder.append(paramInt);
        AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
        b(paramPhotoVH);
        b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
        j();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyDataSetChanged();
      return;
    }
    if ((!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (paramPhotoVH.c.getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，有focus，点击后变选中且focus, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AEPhotoListLogicBase", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      bool = c();
      if (!bool)
      {
        i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      a(((LocalMediaInfo)localObject).path, bool ^ true, false, true);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener = paramPhotoItemClickListener;
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      paramPhotoVH.c.setVisibility(0);
    }
    else
    {
      paramPhotoItemClickListener = paramPhotoVH.c;
      if (this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {
        i = 0;
      } else {
        i = 8;
      }
      paramPhotoItemClickListener.setVisibility(i);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) && (paramPhotoVH.jdField_a_of_type_AndroidViewView != null)) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramPhotoItemClickListener = new AEPhotoListLogicBase.2(this, paramPhotoVH, paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    paramPhotoVH.itemView.setOnClickListener(new AEPhotoListLogicBase.3(this, paramInt, paramPhotoVH));
    Object localObject1 = paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView;
    ((ImageView)localObject1).setAdjustViewBounds(false);
    paramPhotoItemClickListener = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
    Object localObject2 = QAlbumUtil.createContentDescription(0, paramPhotoItemClickListener, paramInt);
    paramPhotoVH.itemView.setContentDescription((CharSequence)localObject2);
    if (paramPhotoItemClickListener != null)
    {
      paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.t) && (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramPhotoItemClickListener)))
      {
        if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a();
          paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)paramPhotoVH.itemView).addView(paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        }
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      i = AlbumThumbDownloader.THUMB_WIDHT;
      paramPhotoItemClickListener.thumbHeight = i;
      paramPhotoItemClickListener.thumbWidth = i;
      localObject2 = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
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
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject2).setTag(paramPhotoItemClickListener);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((URLImageView)localObject1).setURLDrawableDownListener(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter);
        paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
      }
      i = paramPhotoItemClickListener.selectStatus;
      if (i == 1)
      {
        paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(paramPhotoItemClickListener.path) + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
        if (paramPhotoVH.itemView.getBackground() != null) {
          paramPhotoVH.itemView.setBackgroundDrawable(null);
        }
      }
      else if (i == 3)
      {
        paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (paramPhotoVH.itemView.getBackground() != null) {
          paramPhotoVH.itemView.setBackgroundDrawable(null);
        }
      }
      if (AppSetting.d)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, paramPhotoItemClickListener, paramInt, paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      paramPhotoItemClickListener.visableTime = SystemClock.uptimeMillis();
      paramPhotoItemClickListener.listViewPosition = paramInt;
      a(paramPhotoVH, paramPhotoItemClickListener);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (i != 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode))
      {
        paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
        return;
      }
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = 0;
    if ((paramInt == 2) && (paramBoolean))
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout.setVisibility(8);
      if (f()) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      } else {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.t = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    this.jdField_c_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.minSelectNumForMix = 2;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForMix = 30;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.minSelectNumForNormal = -2147483648;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    i();
    paramIntent = new StringBuilder();
    paramIntent.append("initData---aeAlbumData=");
    paramIntent.append(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData);
    AEQLog.b("AEPhotoListLogicBase", paramIntent.toString());
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
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
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.10(this, paramString, paramBoolean1));
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AEQLog.b("AEPhotoListLogicBase", "checkShowVideoPreview--");
    if (!paramBoolean2)
    {
      b(paramString, paramBoolean1, paramBoolean3);
      return;
    }
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.11(this, paramString, paramBoolean1, paramBoolean3));
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    c(paramBoolean);
  }
  
  public void a(List<LocalMediaInfo> paramList) {}
  
  protected void a(boolean paramBoolean)
  {
    i();
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramBoolean);
    int i;
    if (paramBoolean)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
      if (i == 1)
      {
        d(i);
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
      }
    }
    else
    {
      i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
      if (i == 2)
      {
        d(i);
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
      }
      if (!f()) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
      }
      o();
    }
    c(true);
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.notifyDataSetChanged();
    d();
  }
  
  void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.e);
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramIntent.setClass(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    paramIntent.addFlags(603979776);
    c(paramIntent);
    QAlbumUtil.anim(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      if (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null) {
        return false;
      }
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this));
      Object localObject;
      if (paramList == null)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
        {
          localObject = paramList;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s)
          {
            localObject = paramList;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId")) {}
          }
        }
        else
        {
          paramList = new LocalMediaInfo();
          paramList.mMimeType = "mobileqq/camera";
          localObject = new ArrayList();
          ((List)localObject).add(0, paramList);
        }
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a((List)localObject, true);
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.7(this));
        return false;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId"))))
      {
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
        paramList.add(0, localObject);
      }
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramList, paramBoolean);
      paramBoolean = paramList.isEmpty();
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.8(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public View b()
  {
    View localView = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318481, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo ^= true;
    a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
    AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
  }
  
  public void b(float paramFloat)
  {
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
  }
  
  public void b(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
        paramPhotoVH.c.setVisibility(0);
      }
      else
      {
        localObject = paramPhotoVH.c;
        if (this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {
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
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener = paramPhotoItemClickListener;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (paramPhotoVH.jdField_a_of_type_AndroidViewView != null)) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    paramPhotoItemClickListener = new AEPhotoListLogicBase.4(this, paramPhotoVH, paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramPhotoItemClickListener);
    paramPhotoVH.itemView.setOnClickListener(new AEPhotoListLogicBase.5(this, paramPhotoVH, paramInt));
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    Object localObject = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
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
    URLDrawable localURLDrawable = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramPhotoItemClickListener)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhotoListAdapter,getView(),vedio url :");
        localStringBuilder.append(paramPhotoItemClickListener.toString());
        QLog.d("PhotoListActivity", 2, localStringBuilder.toString());
      }
      paramPhotoItemClickListener = URLDrawableHelper.getDrawable(paramPhotoItemClickListener, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramPhotoItemClickListener.setTag(localObject);
      localImageView.setImageDrawable(paramPhotoItemClickListener);
      ((URLImageView)localImageView).setURLDrawableDownListener(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter);
      paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = paramPhotoItemClickListener;
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload();
      }
    }
    paramPhotoItemClickListener = paramPhotoVH.jdField_a_of_type_AndroidWidgetTextView;
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
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(((LocalMediaInfo)localObject).path) + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
      if (paramPhotoVH.itemView.getBackground() != null) {
        paramPhotoVH.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    else if (i == 3)
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    else
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      if (paramPhotoVH.itemView.getBackground() != null) {
        paramPhotoVH.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    ((LocalMediaInfo)localObject).visableTime = SystemClock.uptimeMillis();
    ((LocalMediaInfo)localObject).listViewPosition = paramInt;
    if ((!d()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)))
    {
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    }
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
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
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
  }
  
  public void b(View paramView)
  {
    a(false, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent());
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))
    {
      if (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) {
        return;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
      if (!CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilArrayList))
      {
        int i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        this.jdField_a_of_type_Int = (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0 - i).getTop() + DisplayUtil.dip2px(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F));
      }
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.b();
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public View c()
  {
    ImageView localImageView = new ImageView(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130841555);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  public void c()
  {
    TextView localTextView = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView;
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
  }
  
  public void c(int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, AEAbstractPhotoListFragment.PhotoItemClickListener paramPhotoItemClickListener) {}
  
  public void c(Intent paramIntent)
  {
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
  }
  
  public void c(View paramView) {}
  
  protected boolean c()
  {
    return ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.a();
  }
  
  void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    String str = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131694839);
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
    int i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
    if (i == 1) {
      AEBaseDataReporter.a().b(0);
    } else if (i == 2) {
      AEBaseDataReporter.a().b(1);
    }
    if (e())
    {
      AECameraPrefsUtil.a().a("sp_key_ae_ratio_toasted", false, 0);
      e(i);
    }
    d(i);
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o)
    {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.13(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o = true;
  }
  
  public void e(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      paramView.add(this.jdField_b_of_type_JavaLangString);
    }
    n();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      q();
      return;
    }
    p();
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.m) {
      AlbumThumbManager.getInstance(((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    if (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter != null)
    {
      int i = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(i));
    }
    if (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask != null) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
    this.jdField_b_of_type_JavaLangString = null;
    a();
  }
  
  public void g()
  {
    if (((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.b()) {
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.b();
    }
  }
  
  protected void h() {}
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
 * JD-Core Version:    0.7.0.1
 */