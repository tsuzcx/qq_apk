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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
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
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.10;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.11;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.13;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.15;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.17;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
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

public class bmzr<K extends bmyq>
  extends bmzh<K>
  implements bmzi, bmzj, bmzk
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bnrv jdField_a_of_type_Bnrv;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, bmyk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  protected final boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private final Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private String jdField_c_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  
  protected bmzr(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_Boolean = bnri.a();
    this.jdField_a_of_type_Bmzk = this;
    this.jdField_a_of_type_Bmzi = this;
    this.jdField_a_of_type_Bmzj = this;
  }
  
  private int a(String paramString)
  {
    int j;
    if (TextUtils.isEmpty(paramString))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label54;
      }
      j = i;
      if (paramString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).path)) {
        break;
      }
      i += 1;
    }
    label54:
    return -1;
  }
  
  private int a(ArrayList<LocalMediaInfo> paramArrayList, String paramString)
  {
    int j;
    if ((paramArrayList == null) || (paramString == null))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label52;
      }
      j = i;
      if (((LocalMediaInfo)paramArrayList.get(i)).path.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label52:
    return -1;
  }
  
  @Nullable
  private bmyk a(@NonNull String paramString)
  {
    bnrh.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {
      return null;
    }
    return (bmyk)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
      bnrh.a("AEPhotoListLogicBase", "getNoPhotoTipDrawable---error: ", localException);
    }
    return null;
  }
  
  private EditorPicInfo a(@NonNull String paramString)
  {
    bnrh.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = a(paramString);
    if ((localObject == null) || (((bmyk)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo == null))
    {
      localObject = new EditorPicInfo();
      Size localSize = BitmapUtil.getImageSize(paramString);
      ((EditorPicInfo)localObject).picPath = paramString;
      ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
      ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
      return localObject;
    }
    return ((bmyk)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo;
  }
  
  private ArrayList<String> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
  }
  
  private void a()
  {
    Intent localIntent = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForMix;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
      }
    } while (!localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
  }
  
  private void a(bmyx parambmyx)
  {
    parambmyx.c.setVisibility(0);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, bmyx parambmyx)
  {
    bnrh.a("AEPhotoListLogicBase", "[setSelected], photoPath=" + paramLocalMediaInfo.path);
    parambmyx.jdField_a_of_type_Bmyw.onClick(parambmyx.jdField_a_of_type_AndroidViewView);
  }
  
  private void a(@NonNull String paramString)
  {
    bnrh.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0)) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  private void a(@NonNull String paramString, @NonNull bmyk parambmyk)
  {
    bnrh.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambmyk);
  }
  
  private void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, Matrix paramMatrix)
  {
    bnrh.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      bnrh.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    bmyk localbmyk = a(paramString);
    if (localbmyk != null) {}
    for (;;)
    {
      localbmyk.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo = paramEditorPicInfo;
      localbmyk.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
      a(paramString, localbmyk);
      return;
      localbmyk = new bmyk();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    o();
    a(false, true);
    this.jdField_b_of_type_JavaLangString = paramString;
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, 1440, 1440));
    if ((this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a() == 1)) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    }
    this.jdField_a_of_type_Float = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.jdField_b_of_type_Float = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.b();
    f(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a());
    bmyk localbmyk = a(paramString);
    if ((localbmyk != null) && (localbmyk.jdField_a_of_type_AndroidGraphicsMatrix != null) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, paramString))) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageMatrix(localbmyk.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    for (;;)
    {
      if (paramBoolean) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
      }
      if (!f()) {
        break;
      }
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      return;
      a(paramString);
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      TextView localTextView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {}
      for (int i = 0;; i = 8)
      {
        localTextView.setVisibility(i);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(4);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
        l();
        this.jdField_b_of_type_JavaLangString = null;
        return;
      }
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    if (paramBoolean2)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(0);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
      l();
      return;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(4);
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(0);
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
  }
  
  private boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  @Nullable
  private LocalMediaInfo b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
      }
    }
    if (localObject1 == null)
    {
      localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
      if (!CollectionUtils.isEmpty((Collection)localObject2))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject2).next();
          if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)) && (localLocalMediaInfo.path.equals(paramString))) {
            return localLocalMediaInfo;
          }
        }
      }
    }
    return localObject1;
  }
  
  private void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path))
    {
      bnrh.a("AEPhotoListLogicBase", "!currentFocusedImagePath.equals(mAllImages.get(position).path), position = " + paramInt);
      int i = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      if (i >= 0) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyItemChanged(i);
      }
    }
  }
  
  private void b(int paramInt, bmyx parambmyx)
  {
    boolean bool1 = true;
    bnrh.a("AEPhotoListLogicBase", "handlePhotoItemClick, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((!parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 8))
    {
      bnrh.a("AEPhotoListLogicBase", "没有选中，没有focus，点击后变选中且focus, position = " + paramInt);
      if ((a() != null) && (a().size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        bnrh.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(localLocalMediaInfo, parambmyx);
      }
    }
    label279:
    do
    {
      do
      {
        return;
        a(parambmyx);
        a(localLocalMediaInfo, parambmyx);
        b(paramInt);
        bool1 = c();
        int i;
        if (!bool1)
        {
          i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
          paramInt = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
          this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
        }
        if (!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
        {
          if (bool1)
          {
            paramInt = 0;
            c(paramInt);
          }
        }
        else
        {
          parambmyx = localLocalMediaInfo.path;
          if (bool1) {
            break label279;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          a(parambmyx, bool1, false);
          return;
          paramInt = 600;
          break;
        }
        if ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 8))
        {
          bnrh.a("AEPhotoListLogicBase", "选中，没有focus，点击后变选中且focus, position = " + paramInt);
          a(parambmyx);
          boolean bool2 = c();
          b(paramInt);
          if (!bool2)
          {
            i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
            paramInt = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
            this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
          }
          parambmyx = localLocalMediaInfo.path;
          if (!bool2) {}
          for (;;)
          {
            a(parambmyx, bool1, false);
            return;
            bool1 = false;
          }
        }
        if ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 0))
        {
          if (a().size() > 1)
          {
            bnrh.a("AEPhotoListLogicBase", "选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = " + paramInt);
            b(parambmyx);
            b(localLocalMediaInfo, parambmyx);
            k();
            return;
          }
          bnrh.a("AEPhotoListLogicBase", "选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = " + paramInt);
          b(localLocalMediaInfo, parambmyx);
          ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
          return;
        }
      } while ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) || (parambmyx.c.getVisibility() != 0));
      bnrh.a("AEPhotoListLogicBase", "没有选中，有focus，点击后变选中且focus, position = " + paramInt);
      a(localLocalMediaInfo, parambmyx);
    } while (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
    c(0);
  }
  
  private void b(bmyx parambmyx)
  {
    parambmyx.c.setVisibility(8);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, bmyx parambmyx)
  {
    parambmyx.jdField_a_of_type_Bmyw.onClick(parambmyx.jdField_a_of_type_AndroidViewView);
    bnrh.a("AEPhotoListLogicBase", "cancelSelected image.path = " + paramLocalMediaInfo.path);
    a(paramLocalMediaInfo.path);
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bnrh.b("AEPhotoListLogicBase", "doShowPreviewVideo: " + paramString + ", autoPlay=" + paramBoolean2);
    if (paramBoolean1) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
    }
    BaseVideoView localBaseVideoView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if ((paramBoolean2) && (!localBaseVideoView.isPlaying()))
      {
        bnrh.b("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, just resume play");
        localBaseVideoView.play();
      }
      bnrh.b("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, quick return");
    }
    do
    {
      return;
      a(false, false);
      o();
      this.jdField_b_of_type_JavaLangString = paramString;
      VideoPlayParam localVideoPlayParam = new VideoPlayParam();
      localVideoPlayParam.mIsLoop = true;
      localVideoPlayParam.mIsLocal = true;
      localVideoPlayParam.mIsMute = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      localVideoPlayParam.mSceneId = 113;
      localVideoPlayParam.mSceneName = bapv.a(113);
      localVideoPlayParam.mVideoPath = paramString;
      localVideoPlayParam.mCallback = new bmzs(this, localVideoPlayParam, paramString);
      localBaseVideoView.setVideoParam(localVideoPlayParam);
      localBaseVideoView.play();
    } while (paramBoolean2);
    localBaseVideoView.pause();
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
      {
        int i = QAlbumUtil.getMediaType(a(paramString));
        if (i == 0) {
          a(paramString, paramBoolean1, paramBoolean2);
        }
        while (i != 1) {
          return;
        }
        a(paramString, paramBoolean1, paramBoolean2, paramBoolean3);
        return;
      }
      a(paramString, paramBoolean1, paramBoolean2);
      return;
    }
    a(true, false);
  }
  
  @WorkerThread
  private void b(ArrayList<AEAlbumVideoModel> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        AEAlbumVideoModel localAEAlbumVideoModel = (AEAlbumVideoModel)paramArrayList.get(i);
        LocalMediaInfo localLocalMediaInfo = b(localAEAlbumVideoModel.getPath());
        int k = i + 1;
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
        bnrh.b("AEPhotoListLogicBase", "batchCompress---begin, index=" + k);
        ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.17(this, k, j));
        a(localLocalMediaInfo, new bmzv(this, k, localAEAlbumVideoModel));
        if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch == null) {}
      }
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = null;
        if ((this.jdField_c_of_type_Boolean) || (this.d)) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (a().size() == 1))
    {
      if (paramInt > 0) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEPhotoListLogicBase.9(this), paramInt);
      }
    }
    else {
      return;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
  }
  
  private void c(ArrayList<AEAlbumMediaBaseModel> paramArrayList)
  {
    Activity localActivity = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    Intent localIntent = localActivity.getIntent();
    if (bnlb.m(localIntent))
    {
      bnrh.b("AEPhotoListLogicBase", "doRealJumpForMix---is additional pick case, setResult and finish");
      localIntent = new Intent();
      localIntent.putExtra("ae_album_selected_media_models", paramArrayList);
      localActivity.setResult(-1, localIntent);
      localActivity.finish();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ae_album_selected_media_models", paramArrayList);
    int i = bnlb.y.a();
    if (bnlb.k(localIntent)) {
      i = bnlb.A.a();
    }
    bnsl.a(localActivity, 2, localBundle, i);
  }
  
  private void d(int paramInt)
  {
    bnrh.b("AEPhotoListLogicBase", "handlePhotoRatioChanged---lastRatio=" + paramInt);
    label64:
    String str;
    EditorPicInfo localEditorPicInfo;
    double d1;
    if (paramInt == 1)
    {
      f(2);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null)) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      str = (String)localIterator.next();
      Size localSize = BitmapUtil.getImageSize(str);
      localEditorPicInfo = new EditorPicInfo();
      localEditorPicInfo.picPath = str;
      localEditorPicInfo.originPicWidth = localSize.getWidth();
      localEditorPicInfo.originPicHeight = localSize.getHeight();
      d1 = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (paramInt != 1) {
        break label355;
      }
      if (d1 > 0.333333343267441D) {
        break label251;
      }
      d1 = 1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) / 2.0D / localEditorPicInfo.originPicHeight;
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = d1;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = (1.0D * (localEditorPicInfo.originPicWidth / 0.333333343267441D) / localEditorPicInfo.originPicHeight);
    }
    label355:
    for (;;)
    {
      a(str, localEditorPicInfo, null);
      break label64;
      if (paramInt != 2) {
        break;
      }
      f(1);
      break;
      label251:
      if (d1 >= 1.777777791023254D)
      {
        localEditorPicInfo.x = (1.0D * (localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) / 2.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = (1.0D * (localEditorPicInfo.originPicHeight * 1.777777791023254D) / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.h = 1.0D;
      }
      else
      {
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = 1.0D;
        localEditorPicInfo.h = 1.0D;
        continue;
        if (paramInt == 2) {
          if (d1 < 1.0D)
          {
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = (1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth) / 2.0D / localEditorPicInfo.originPicHeight);
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = d1;
          }
          else
          {
            localEditorPicInfo.x = (1.0D * (localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight) / 2.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = d1;
            localEditorPicInfo.h = 1.0D;
          }
        }
      }
    }
  }
  
  private boolean d()
  {
    return (!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && ((!a().isEmpty()) || (!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo));
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 1) {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689683), 1).a();
    }
    while (paramInt != 2) {
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689684), 1).a();
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 1) {
          bool1 = bnqu.a().a("sp_key_ae_ratio_toasted", true, 0);
        }
      }
    }
    return bool1;
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 1)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_b_of_type_Float);
    }
    while (paramInt != 2) {
      return;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(true);
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_a_of_type_Float);
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return true;
        } while (a() == null);
        localObject = this.jdField_b_of_type_JavaLangString;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = b((String)localObject);
    } while ((localObject != null) && ((QAlbumUtil.getMediaType((LocalMediaInfo)localObject) != 0) || (((LocalMediaInfo)localObject).mediaWidth == ((LocalMediaInfo)localObject).mediaHeight)));
    return false;
  }
  
  private void j()
  {
    Object localObject;
    int i;
    LocalMediaInfo localLocalMediaInfo;
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      if (!a().isEmpty()) {
        break label177;
      }
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      i = 0;
      if (i >= ((List)localObject).size()) {
        break label186;
      }
      localLocalMediaInfo = (LocalMediaInfo)((List)localObject).get(i);
      if (localLocalMediaInfo == null) {}
      int j;
      do
      {
        i += 1;
        break;
        if (!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
          break label160;
        }
        if (AlbumUtil.getMediaType(localLocalMediaInfo) != 1) {
          break label110;
        }
        j = a(localLocalMediaInfo);
      } while ((j != 0) && (j != 2));
      label110:
      localObject = localLocalMediaInfo.path;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      b((String)localObject, true, true, false);
      if (i > 0) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicBase.1(this, i));
      }
      return;
      label160:
      if (AlbumUtil.getMediaType(localLocalMediaInfo) != 0) {
        break;
      }
      localObject = localLocalMediaInfo.path;
      continue;
      label177:
      bnrh.b("AEPhotoListLogicBase", "changeFocusAndPreviewWhenDataChanged---already picked some items, preview won't change");
      return;
      label186:
      localObject = null;
      i = -1;
    }
  }
  
  private void k()
  {
    String str;
    int i;
    if (!a().isEmpty())
    {
      bnrh.a("AEPhotoListLogicBase", "mPhotoCommonData.selectedPhotoList.size() = " + a().size());
      str = (String)a().get(a().size() - 1);
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label161;
      }
      if (!((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).path.equals(str)) {
        break label154;
      }
    }
    for (;;)
    {
      bnrh.a("AEPhotoListLogicBase", "!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = " + i);
      if (i >= 0)
      {
        this.jdField_a_of_type_JavaLangString = str;
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
      }
      b(str, false, false, true);
      return;
      label154:
      i += 1;
      break;
      label161:
      i = -1;
    }
  }
  
  private void l()
  {
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
  }
  
  private void m()
  {
    if (VersionUtils.isrFroyo())
    {
      Activity localActivity = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
  
  private void n()
  {
    if (VersionUtils.isrFroyo())
    {
      Activity localActivity = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  private void o()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = b(this.jdField_b_of_type_JavaLangString);
      if ((localObject == null) || (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 0)) {
        break label31;
      }
    }
    label31:
    Matrix localMatrix;
    do
    {
      return;
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      localObject = a(this.jdField_b_of_type_JavaLangString);
      localObject = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a((EditorPicInfo)localObject);
      localMatrix = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    } while ((localObject == null) || (localMatrix == null));
    a(this.jdField_b_of_type_JavaLangString, (EditorPicInfo)localObject, localMatrix);
    return;
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  private void p()
  {
    Object localObject;
    if (!CollectionUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList))
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList).iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = b(str);
        if (localObject != null) {
          break label161;
        }
        bnrh.b("AEPhotoListLogicBase", "clearSelectedData---failed get media info at first, try another way");
        localObject = a(str);
      }
    }
    label161:
    for (;;)
    {
      if (localObject != null)
      {
        ((LocalMediaInfo)localObject).selectStatus = 2;
        break;
      }
      bnrh.d("AEPhotoListLogicBase", "clearSelectedData---still failed to get media info");
      break;
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LocalMediaInfo)((Iterator)localObject).next()).selectStatus = 2;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
      return;
    }
  }
  
  private void q()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    int i = 0;
    if (i < ((List)localObject).size())
    {
      String str = (String)((List)localObject).get(i);
      if (TextUtils.isEmpty(str)) {
        bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--empty path, drop it: " + str);
      }
      for (;;)
      {
        i += 1;
        break;
        bmyk localbmyk = a(str);
        if ((localbmyk == null) || (localbmyk.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo == null)) {
          bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--no crop info, drop it: " + str);
        } else if (!new File(str).exists()) {
          bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--file not exists, drop it: " + str);
        } else {
          localArrayList.add(localbmyk.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo);
        }
      }
    }
    if (CollectionUtils.isEmpty(localArrayList))
    {
      QQToast.a(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689752, 0).a();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
    i = bnlb.y.a();
    if (bnlb.k(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = bnlb.A.a();
    }
    bnsl.a(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 0, (Bundle)localObject, i);
  }
  
  private void r()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    int i = 0;
    if (i < localLinkedList.size())
    {
      String str1 = (String)localLinkedList.get(i);
      if (TextUtils.isEmpty(str1)) {
        bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: " + str1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!new File(str1).exists())
        {
          bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: " + str1);
        }
        else
        {
          Object localObject = b(str1);
          if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1))
          {
            int j = a((LocalMediaInfo)localObject);
            if ((j == 2) || (j == 0))
            {
              localObject = new AEAlbumVideoModel(str1);
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
                  bnrh.a("AEPhotoListLogicBase", "hit cache, no need compress for: " + str1);
                  ((AEAlbumVideoModel)localObject).setPath(str2);
                }
              }
            }
            else
            {
              bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: " + str1);
            }
          }
          else
          {
            localObject = a(str1);
            if ((localObject == null) || (((bmyk)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo == null)) {
              bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--no crop info, drop it: " + str1);
            } else {
              localArrayList1.add(new AEAlbumImageModel(str1, ((bmyk)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo));
            }
          }
        }
      }
    }
    if (CollectionUtils.isEmpty(localArrayList1))
    {
      bnrh.d("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
      QQToast.a(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689753, 0).a();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      c(localArrayList1);
      return;
    }
    if (this.jdField_a_of_type_Bnrv == null)
    {
      this.jdField_a_of_type_Bnrv = new bnrv(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Bnrv.a(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131719919));
      this.jdField_a_of_type_Bnrv.a(new bmzt(this));
    }
    this.jdField_a_of_type_Bnrv.show();
    bnrh.a("AEPhotoListLogicBase", "after show, submit compress task");
    ThreadManagerV2.excute(new AEPhotoListLogicBase.15(this, localArrayList2, localArrayList1), 16, new bmzu(this), true);
  }
  
  public View a()
  {
    View localView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558490, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bptj localbptj = new bptj();
        bpti.a(paramString, localbptj);
        localLocalMediaInfo.mediaWidth = localbptj.a[0];
        localLocalMediaInfo.mediaHeight = localbptj.a[1];
        localLocalMediaInfo.rotation = localbptj.a[2];
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null)
        {
          paramString = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    return ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694632, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit);
    bhfd.a("PEAK", "getAlbumMedias");
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
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
    paramFloat = 1.0F - paramFloat;
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int == 2)) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, (int)(this.jdField_a_of_type_Int * (paramFloat - this.jdField_c_of_type_Float)));
    }
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Float = 0.0F;
    if (paramInt == 1)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(0);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  protected void a(int paramInt, bmyx parambmyx)
  {
    bnrh.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((!parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 8))
    {
      bnrh.a("AEPhotoListLogicBase", "没有选中，没有focus，点击后变选中且focus, position = " + paramInt);
      if ((a() != null) && (a().size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        bnrh.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, exceededPhotoLimit");
        a(localLocalMediaInfo, parambmyx);
      }
    }
    int i;
    do
    {
      return;
      a(parambmyx);
      a(localLocalMediaInfo, parambmyx);
      b(paramInt);
      bool = c();
      if (!bool)
      {
        i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        paramInt = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
        this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
      }
      parambmyx = localLocalMediaInfo.path;
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        a(parambmyx, bool, false, true);
        return;
      }
      if ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 8))
      {
        bnrh.a("AEPhotoListLogicBase", "选中，没有focus，点击后变选中且focus, position = " + paramInt);
        a(parambmyx);
        b(paramInt);
        bool = c();
        if (!bool)
        {
          i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
          paramInt = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
          this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
        }
        parambmyx = localLocalMediaInfo.path;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          a(parambmyx, bool, false, true);
          return;
        }
      }
      if ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambmyx.c.getVisibility() == 0))
      {
        if (a().size() > 1)
        {
          bnrh.a("AEPhotoListLogicBase", "选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = " + paramInt);
          b(parambmyx);
          b(localLocalMediaInfo, parambmyx);
          k();
          return;
        }
        bnrh.a("AEPhotoListLogicBase", "选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = " + paramInt);
        b(localLocalMediaInfo, parambmyx);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
        return;
      }
    } while ((parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) || (parambmyx.c.getVisibility() != 0));
    bnrh.a("AEPhotoListLogicBase", "没有选中，有focus，点击后变选中且focus, position = " + paramInt);
    a(localLocalMediaInfo, parambmyx);
    boolean bool = c();
    if (!bool)
    {
      i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      paramInt = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
      this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
    }
    parambmyx = localLocalMediaInfo.path;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      a(parambmyx, bool, false, true);
      return;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(int paramInt, bmyx parambmyx, bmyw parambmyw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    parambmyx.jdField_a_of_type_Bmyw = parambmyw;
    Object localObject1;
    label327:
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      parambmyx.c.setVisibility(0);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) && (parambmyx.jdField_a_of_type_AndroidViewView != null)) {
        parambmyx.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      parambmyw = new bmzw(this, parambmyx, paramInt);
      parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnTouchListener(parambmyw);
      parambmyx.jdField_a_of_type_AndroidViewView.setOnTouchListener(parambmyw);
      parambmyx.jdField_a_of_type_Bmyw.a(paramInt);
      parambmyx.jdField_a_of_type_Bmyw.a(parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      parambmyx.itemView.setOnClickListener(new bmzx(this, paramInt, parambmyx));
      localObject1 = parambmyx.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject1).setAdjustViewBounds(false);
      parambmyw = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(paramInt);
      Object localObject2 = QAlbumUtil.createContentDescription(0, parambmyw, paramInt);
      parambmyx.itemView.setContentDescription((CharSequence)localObject2);
      if (parambmyw != null)
      {
        parambmyx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon) || (!((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(parambmyw))) {
          break label739;
        }
        if (parambmyx.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          parambmyx.jdField_b_of_type_AndroidWidgetTextView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a();
          parambmyx.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)parambmyx.itemView).addView(parambmyx.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        }
        parambmyx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        i = AlbumThumbDownloader.THUMB_WIDHT;
        parambmyw.thumbHeight = i;
        parambmyw.thumbWidth = i;
        localObject2 = parambmyx.jdField_a_of_type_ComTencentImageURLDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(parambmyw.path);
        if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject2 = QAlbumUtil.generateAlbumThumbURL(parambmyw);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "photoGridAdapter,getView(),image url :" + ((URL)localObject2).toString());
          }
          localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject2).setTag(parambmyw);
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setURLDrawableDownListener(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv);
          parambmyx.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
        }
        i = parambmyw.selectStatus;
        if (i != 1) {
          break label758;
        }
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(parambmyw.path) + 1 + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
        if (parambmyx.itemView.getBackground() != null) {
          parambmyx.itemView.setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, parambmyw, paramInt, parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      parambmyw.visableTime = SystemClock.uptimeMillis();
      parambmyw.listViewPosition = paramInt;
      a(parambmyx, parambmyw);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)) {
        break label804;
      }
      parambmyx.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      parambmyw = parambmyx.c;
      if (this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {}
      for (i = 0;; i = 8)
      {
        parambmyw.setVisibility(i);
        break;
      }
      label739:
      if (parambmyx.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label327;
      }
      parambmyx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label327;
      label758:
      if (i == 3)
      {
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambmyx.itemView.getBackground() != null) {
          parambmyx.itemView.setBackgroundDrawable(null);
        }
      }
    }
    label804:
    parambmyx.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = 0;
    if ((paramInt == 2) && (paramBoolean))
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(8);
      if (!f()) {
        break label85;
      }
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
      label85:
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.photoListStartPos = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType != 2) {
        break label725;
      }
    }
    label725:
    for (Object localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;; localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      this.jdField_c_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForMix = 2;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForMix = 30;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForNormal = -2147483648;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
      a();
      bnrh.b("AEPhotoListLogicBase", "initData---aeAlbumData=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
      break;
    }
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox) {}
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void a(bmyx parambmyx, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bnrh.b("AEPhotoListLogicBase", "checkShowImagePreview--");
    if (!paramBoolean2)
    {
      a(paramString, paramBoolean1);
      return;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.10(this, paramString, paramBoolean1));
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    bnrh.b("AEPhotoListLogicBase", "checkShowVideoPreview--");
    if (!paramBoolean2)
    {
      b(paramString, paramBoolean1, paramBoolean3);
      return;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.11(this, paramString, paramBoolean1, paramBoolean3));
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    j();
  }
  
  public void a(List<LocalMediaInfo> paramList) {}
  
  protected void a(boolean paramBoolean)
  {
    a();
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramBoolean);
    int i;
    if (paramBoolean)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      if (i == 1)
      {
        d(i);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      }
    }
    for (;;)
    {
      j();
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
      e();
      return;
      i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      if (i == 2)
      {
        d(i);
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      }
      if (!f()) {
        ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
      }
      p();
    }
  }
  
  void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
      paramIntent.addFlags(603979776);
      c(paramIntent);
      QAlbumUtil.anim(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.currentPhotoPath);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return false;
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo)
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
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a((List)localObject);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.7(this));
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(paramList);
    boolean bool = paramList.isEmpty();
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.8(this, bool));
    return true;
  }
  
  public View b()
  {
    View localView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558491, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public void b(float paramFloat)
  {
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
  }
  
  public void b(int paramInt, bmyx parambmyx, bmyw parambmyw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    label110:
    Object localObject;
    label237:
    int i;
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
        parambmyx.c.setVisibility(0);
        parambmyx.jdField_a_of_type_Bmyw = parambmyw;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) || (parambmyx.jdField_a_of_type_AndroidViewView == null)) {
          break label652;
        }
        parambmyx.jdField_a_of_type_AndroidViewView.setVisibility(0);
        parambmyw = new bmzy(this, parambmyx, paramInt);
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnTouchListener(parambmyw);
        parambmyx.jdField_a_of_type_AndroidViewView.setOnTouchListener(parambmyw);
        parambmyx.itemView.setOnClickListener(new bmzz(this, parambmyx, paramInt));
        parambmyx.jdField_a_of_type_Bmyw.a(paramInt);
        parambmyx.jdField_a_of_type_Bmyw.a(parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
        ImageView localImageView = parambmyx.jdField_b_of_type_AndroidWidgetImageView;
        localImageView.setAdjustViewBounds(false);
        localObject = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(paramInt);
        parambmyw = QAlbumUtil.createContentDescription(1, (LocalMediaInfo)localObject, paramInt);
        parambmyx.itemView.setContentDescription(parambmyw);
        if (!((LocalMediaInfo)localObject).isSystemMeidaStore) {
          break label664;
        }
        parambmyw = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject, "VIDEO");
        i = AlbumThumbDownloader.THUMB_WIDHT;
        ((LocalMediaInfo)localObject).thumbHeight = i;
        ((LocalMediaInfo)localObject).thumbWidth = i;
        URLDrawable localURLDrawable = parambmyx.jdField_a_of_type_ComTencentImageURLDrawable;
        if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(parambmyw)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + parambmyw.toString());
          }
          parambmyw = URLDrawableHelper.getDrawable(parambmyw, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          parambmyw.setTag(localObject);
          localImageView.setImageDrawable(parambmyw);
          ((URLImageView)localImageView).setURLDrawableDownListener(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv);
          parambmyx.jdField_a_of_type_ComTencentImageURLDrawable = parambmyw;
          if (localURLDrawable != null) {
            localURLDrawable.cancelDownload();
          }
        }
        parambmyw = parambmyx.jdField_a_of_type_AndroidWidgetTextView;
        if ((((LocalMediaInfo)localObject).isSystemMeidaStore) || (((LocalMediaInfo)localObject).mDuration > 0L)) {
          break label676;
        }
        parambmyw.setVisibility(8);
        parambmyw = MediaScanner.getInstance(BaseApplicationImpl.getContext());
        if (parambmyw != null) {
          parambmyw.queryMediaInfoDuration(this, (LocalMediaInfo)localObject, paramInt);
        }
        label448:
        i = ((LocalMediaInfo)localObject).selectStatus;
        if (i != 1) {
          break label696;
        }
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(((LocalMediaInfo)localObject).path) + 1 + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
        if (parambmyx.itemView.getBackground() != null) {
          parambmyx.itemView.setBackgroundDrawable((Drawable)null);
        }
      }
    }
    for (;;)
    {
      ((LocalMediaInfo)localObject).visableTime = SystemClock.uptimeMillis();
      ((LocalMediaInfo)localObject).listViewPosition = paramInt;
      if ((!d()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode))) {
        break label745;
      }
      parambmyx.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      localObject = parambmyx.c;
      if (this.jdField_a_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {}
      for (i = 0;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        break;
      }
      parambmyx.c.setVisibility(8);
      break;
      label652:
      parambmyx.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label110;
      label664:
      parambmyw = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject, "APP_VIDEO");
      break label237;
      label676:
      parambmyw.setVisibility(0);
      parambmyw.setText(AbstractPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject).mDuration));
      break label448;
      label696:
      if (i == 3)
      {
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambmyx.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambmyx.itemView.getBackground() != null) {
          parambmyx.itemView.setBackgroundDrawable((Drawable)null);
        }
      }
    }
    label745:
    parambmyx.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo)
    {
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
    }
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
  }
  
  public void b(View paramView)
  {
    a(false, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent());
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) || (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    if (!CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0 - i).getTop();
      this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + i);
    }
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public View c()
  {
    ImageView localImageView = new ImageView(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130841526);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  public void c()
  {
    AEAlbumLogicData localAEAlbumLogicData = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData;
    if (!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {}
    for (boolean bool = true;; bool = false)
    {
      localAEAlbumLogicData.canMixPhotoAndVideo = bool;
      a(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
      bnqm.a().a(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
      return;
    }
  }
  
  public void c(int paramInt, bmyx parambmyx, bmyw parambmyw) {}
  
  public void c(Intent paramIntent)
  {
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
  }
  
  public void c(View paramView) {}
  
  protected boolean c()
  {
    return ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.a();
  }
  
  public void d()
  {
    TextView localTextView = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      a(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo);
      return;
    }
  }
  
  public void d(View paramView)
  {
    int i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    if (i == 1) {
      bnqm.a().e(0);
    }
    for (;;)
    {
      if (e())
      {
        bnqu.a().a("sp_key_ae_ratio_toasted", false, 0);
        e(i);
      }
      d(i);
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      return;
      if (i == 2) {
        bnqm.a().e(1);
      }
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText;
      if (localArrayList.size() <= 0) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new StringBuilder().append(str).append("(").append(localArrayList.size()).append(")").toString();
      }
      return;
      str = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131694617);
      break;
    }
  }
  
  public void e(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      paramView.add(this.jdField_b_of_type_JavaLangString);
    }
    o();
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      r();
      return;
    }
    q();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask)
    {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.13(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask = true;
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.backPressed) {
      AlbumThumbManager.getInstance(((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    if (((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv != null)
    {
      int i = ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(i));
    }
    if (((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask != null) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_b_of_type_JavaLangString = null;
    b();
  }
  
  public void h()
  {
    if (((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b()) {
      ((bmyq)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
    }
  }
  
  protected void i() {}
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzr
 * JD-Core Version:    0.7.0.1
 */