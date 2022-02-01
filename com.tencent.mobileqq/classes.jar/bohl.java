import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
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
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.10;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class bohl<K extends bogn>
  extends bohc<K>
  implements bohd, bohe, bohf
{
  protected float a;
  int jdField_a_of_type_Int = 0;
  protected String a;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected Map<String, bogh> a;
  protected boolean a;
  protected float b;
  int b;
  protected String b;
  protected final boolean b;
  float jdField_c_of_type_Float = 0.0F;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  
  protected bohl(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    this.jdField_b_of_type_Boolean = bpan.a();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bohf = this;
    this.jdField_a_of_type_Bohd = this;
    this.jdField_a_of_type_Bohe = this;
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
  
  private URLDrawable a()
  {
    return beyq.a("https://downv6.qq.com/shadow_qqcamera/Android/image/ae_camera_circle_no_photo_tip_light.png");
  }
  
  private ArrayList<String> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
  }
  
  private void a()
  {
    String str;
    int i;
    if (!a().isEmpty())
    {
      bpam.a("AEPhotoListLogicBase", "mPhotoCommonData.selectedPhotoList.size() = " + a().size());
      str = (String)a().get(a().size() - 1);
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label158;
      }
      if (!((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).path.equals(str)) {
        break label151;
      }
    }
    for (;;)
    {
      bpam.a("AEPhotoListLogicBase", "!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = " + i);
      if (i >= 0)
      {
        this.jdField_c_of_type_JavaLangString = str;
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.notifyDataSetChanged();
      }
      b(str, false, false);
      return;
      label151:
      i += 1;
      break;
      label158:
      i = -1;
    }
  }
  
  private void a(int paramInt, bogs parambogs)
  {
    boolean bool1 = true;
    bpam.a("AEPhotoListLogicBase", "handlePhotoItemClick, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((!parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambogs.c.getVisibility() == 8))
    {
      bpam.a("AEPhotoListLogicBase", "没有选中，没有focus，点击后变选中且focus, position = " + paramInt);
      if ((a() != null) && (a().size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        bpam.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(localLocalMediaInfo, parambogs);
      }
    }
    label258:
    do
    {
      return;
      a(parambogs);
      a(localLocalMediaInfo, parambogs);
      c(paramInt);
      bool1 = g();
      int i;
      if (!bool1)
      {
        i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        paramInt = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
        this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
      }
      if (bool1)
      {
        paramInt = 0;
        d(paramInt);
        parambogs = localLocalMediaInfo.path;
        if (bool1) {
          break label258;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        a(parambogs, bool1, false);
        return;
        paramInt = 600;
        break;
      }
      if ((parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambogs.c.getVisibility() == 8))
      {
        bpam.a("AEPhotoListLogicBase", "选中，没有focus，点击后变选中且focus, position = " + paramInt);
        a(parambogs);
        boolean bool2 = g();
        c(paramInt);
        if (!bool2)
        {
          i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
          paramInt = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i).getTop();
          this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + paramInt);
        }
        parambogs = localLocalMediaInfo.path;
        if (!bool2) {}
        for (;;)
        {
          a(parambogs, bool1, false);
          return;
          bool1 = false;
        }
      }
      if ((parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambogs.c.getVisibility() == 0))
      {
        if (a().size() > 1)
        {
          bpam.a("AEPhotoListLogicBase", "选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = " + paramInt);
          b(parambogs);
          b(localLocalMediaInfo, parambogs);
          a();
          return;
        }
        bpam.a("AEPhotoListLogicBase", "选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = " + paramInt);
        b(localLocalMediaInfo, parambogs);
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.notifyDataSetChanged();
        return;
      }
    } while ((parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) || (parambogs.c.getVisibility() != 0));
    bpam.a("AEPhotoListLogicBase", "没有选中，有focus，点击后变选中且focus, position = " + paramInt);
    a(localLocalMediaInfo, parambogs);
    d(0);
  }
  
  private void a(bogs parambogs)
  {
    parambogs.c.setVisibility(0);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, bogs parambogs)
  {
    bpam.a("AEPhotoListLogicBase", "[setSelected], photoPath=" + paramLocalMediaInfo.path);
    parambogs.jdField_a_of_type_Bogr.onClick(parambogs.jdField_a_of_type_AndroidViewView);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    h();
    this.jdField_a_of_type_JavaLangString = paramString;
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, 1440, 1440));
    this.jdField_a_of_type_Float = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.jdField_b_of_type_Float = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.b();
    b(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a());
    bogh localbogh = a(paramString);
    if ((localbogh != null) && (localbogh.jdField_a_of_type_AndroidGraphicsMatrix != null) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, paramString))) {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageMatrix(localbogh.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    for (;;)
    {
      if (paramBoolean) {
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
      }
      if (!f()) {
        break;
      }
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      return;
      b(paramString);
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
  }
  
  private boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  private void b(bogs parambogs)
  {
    parambogs.c.setVisibility(8);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, bogs parambogs)
  {
    parambogs.jdField_a_of_type_Bogr.onClick(parambogs.jdField_a_of_type_AndroidViewView);
    bpam.a("AEPhotoListLogicBase", "cancelSelected image.path = " + paramLocalMediaInfo.path);
    b(paramLocalMediaInfo.path);
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!bhsr.a(paramString)) {
      a(paramString, paramBoolean1, paramBoolean2);
    }
    b(bhsr.a(paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(4);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    } while (!f());
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    return;
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(0);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_c_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path))
    {
      bpam.a("AEPhotoListLogicBase", "!currentFocusedImagePath.equals(mAllImages.get(position).path), position = " + paramInt);
      int i = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      if (i >= 0) {
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.notifyItemChanged(i);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (a().size() == 1)
    {
      if (paramInt > 0) {
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEPhotoListLogicBase.8(this), paramInt);
      }
    }
    else {
      return;
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.notifyDataSetChanged();
  }
  
  private boolean d()
  {
    return (!a().isEmpty()) || (!a());
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 1) {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689676), 1).a();
    }
    while (paramInt != 2) {
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689677), 1).a();
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
          bool1 = bozz.a().a("sp_key_ae_ratio_toasted", true, 0);
        }
      }
    }
    return bool1;
  }
  
  private boolean f()
  {
    if (a() == null) {}
    Object localObject1;
    do
    {
      do
      {
        return true;
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
    } while (CollectionUtils.isEmpty((Collection)localObject2));
    boolean bool2 = false;
    Object localObject2 = ((List)localObject2).iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject2).next();
    } while ((localLocalMediaInfo == null) || (TextUtils.isEmpty(localLocalMediaInfo.path)) || (!localLocalMediaInfo.path.equals(localObject1)) || (localLocalMediaInfo.mediaWidth != localLocalMediaInfo.mediaHeight));
    boolean bool1 = true;
    bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null)
      {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_JavaLangString);
        bool2 = bool1;
        if (localObject1 != null)
        {
          bool2 = bool1;
          if (((LocalMediaInfo)localObject1).mediaWidth == ((LocalMediaInfo)localObject1).mediaHeight) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean g()
  {
    return ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.a();
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
    Intent localIntent = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(paramView.path)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramView.path, paramView);
      }
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    }
    localIntent.setClass(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public View a()
  {
    View localView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558487, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  @Nullable
  protected bogh a(@NonNull String paramString)
  {
    bpam.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {
      return null;
    }
    return (bogh)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  protected EditorPicInfo a(@NonNull String paramString)
  {
    bpam.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = a(paramString);
    if ((localObject == null) || (((bogh)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo == null))
    {
      localObject = new EditorPicInfo();
      Size localSize = BitmapUtil.getImageSize(paramString);
      ((EditorPicInfo)localObject).picPath = paramString;
      ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
      ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
      return localObject;
    }
    return ((bogh)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo;
  }
  
  String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    return ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694317, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit);
    bhnn.a("PEAK", "getAlbumMedias");
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
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
    paramFloat = 1.0F - paramFloat;
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int == 2)) {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, (int)(this.jdField_a_of_type_Int * (paramFloat - this.jdField_c_of_type_Float)));
    }
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Float = 0.0F;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(0);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(int paramInt, bogs parambogs, bogr parambogr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    parambogs.jdField_a_of_type_Bogr = parambogr;
    Object localObject1;
    label327:
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_c_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      parambogs.c.setVisibility(0);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) && (parambogs.jdField_a_of_type_AndroidViewView != null)) {
        parambogs.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      parambogr = new bohm(this, parambogs, paramInt);
      parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnTouchListener(parambogr);
      parambogs.jdField_a_of_type_AndroidViewView.setOnTouchListener(parambogr);
      parambogs.jdField_a_of_type_Bogr.a(paramInt);
      parambogs.jdField_a_of_type_Bogr.a(parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      parambogs.itemView.setOnClickListener(new bohn(this, paramInt, parambogs));
      localObject1 = parambogs.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject1).setAdjustViewBounds(false);
      parambogr = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
      Object localObject2 = QAlbumUtil.createContentDescription(0, parambogr, paramInt);
      parambogs.itemView.setContentDescription((CharSequence)localObject2);
      if (parambogr != null)
      {
        parambogs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon) || (!((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(parambogr))) {
          break label728;
        }
        if (parambogs.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          parambogs.jdField_b_of_type_AndroidWidgetTextView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a();
          parambogs.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)parambogs.itemView).addView(parambogs.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        }
        parambogs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        i = AlbumThumbDownloader.THUMB_WIDHT;
        parambogr.thumbHeight = i;
        parambogr.thumbWidth = i;
        localObject2 = parambogs.jdField_a_of_type_ComTencentImageURLDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(parambogr.path);
        if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject2 = QAlbumUtil.generateAlbumThumbURL(parambogr);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "photoGridAdapter,getView(),image url :" + ((URL)localObject2).toString());
          }
          localObject2 = beyq.a((URL)localObject2, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject2).setTag(parambogr);
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setURLDrawableDownListener(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq);
          parambogs.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
        }
        i = parambogr.selectStatus;
        if (i != 1) {
          break label747;
        }
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(parambogr.path) + 1 + a());
        if (parambogs.itemView.getBackground() != null) {
          parambogs.itemView.setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, parambogr, paramInt, parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      parambogr.visableTime = SystemClock.uptimeMillis();
      parambogr.listViewPosition = paramInt;
      a(parambogs, parambogr);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)) {
        break label793;
      }
      parambogs.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      parambogr = parambogs.c;
      if (this.jdField_c_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {}
      for (i = 0;; i = 8)
      {
        parambogr.setVisibility(i);
        break;
      }
      label728:
      if (parambogs.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label327;
      }
      parambogs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label327;
      label747:
      if (i == 3)
      {
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambogs.itemView.getBackground() != null) {
          parambogs.itemView.setBackgroundDrawable(null);
        }
      }
    }
    label793:
    parambogs.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = 0;
    if ((paramInt == 2) && (paramBoolean))
    {
      this.jdField_a_of_type_Boolean = false;
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(8);
      if (f())
      {
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
      }
    }
    else
    {
      return;
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
      }
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
        break label608;
      }
    }
    label608:
    for (paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;; paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent;
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
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      localLocalMediaInfo = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
      i = localLocalMediaInfo.selectStatus;
      if ((i == 1) || (paramView.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.lastTimeShowToast < 1000L);
    QQToast.a(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
    paramCheckBox.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.lastTimeShowToast = l;
    return;
    boolean bool1;
    label209:
    Object localObject;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label606;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      if (!bool1) {
        break label612;
      }
      localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
        ((PhotoListBaseData)localObject).videoSelectedCnt += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
        ((PhotoListBaseData)localObject).gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      paramView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      if (paramView != null) {
        break label829;
      }
      paramView = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
    }
    label537:
    label829:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName));
      }
      if (this.jdField_a_of_type_Bohg != null) {
        this.jdField_a_of_type_Bohg.a(bool1, localLocalMediaInfo);
      }
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (bogn)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.b(bool1);
        return;
        i = 1;
        break;
        label606:
        bool1 = false;
        break label209;
        label612:
        localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
          ((PhotoListBaseData)localObject).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt == 1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
          ((PhotoListBaseData)localObject).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        paramView = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = QAlbumUtil.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label537;
        }
        paramView.remove(paramCheckBox);
        break label537;
      }
    }
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void a(bogs parambogs, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(@NonNull String paramString, @NonNull bogh parambogh)
  {
    bpam.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambogh);
  }
  
  protected void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, Matrix paramMatrix)
  {
    bpam.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      bpam.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    bogh localbogh = a(paramString);
    if (localbogh != null) {}
    for (;;)
    {
      localbogh.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo = paramEditorPicInfo;
      localbogh.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
      a(paramString, localbogh);
      return;
      localbogh = new bogh();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      a(paramString, paramBoolean1);
      return;
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.9(this, paramString, paramBoolean1));
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    paramArrayList = new LinkedList(paramArrayList);
    int i;
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      if (!a().isEmpty()) {
        break label130;
      }
      i = 0;
      if (i >= paramArrayList.size()) {
        break label155;
      }
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramArrayList.get(i);
      if (localLocalMediaInfo == null) {}
      while (bhkd.getMediaType(localLocalMediaInfo) != 0)
      {
        i += 1;
        break;
      }
      paramArrayList = localLocalMediaInfo.path;
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaLangString = paramArrayList;
      b(paramArrayList, true, true);
      if (i > 0) {
        ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicBase.1(this, i));
      }
      return;
      label130:
      paramArrayList = (String)a().get(a().size() - 1);
      i = -1;
      continue;
      label155:
      paramArrayList = null;
      i = -1;
    }
  }
  
  public void a(List<LocalMediaInfo> paramList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) || (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    if (!CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0 - i).getTop();
      this.jdField_a_of_type_Int = (DisplayUtil.dip2px(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2.0F) + i);
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
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
      PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
      paramIntent.addFlags(603979776);
      c(paramIntent);
      QAlbumUtil.anim(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.currentPhotoPath);
    }
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return false;
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.5(this));
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
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a((List)localObject);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this));
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramList);
    boolean bool = paramList.isEmpty();
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.7(this, bool));
    return true;
  }
  
  public View b()
  {
    View localView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558488, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public void b(float paramFloat)
  {
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
  }
  
  protected void b(int paramInt)
  {
    if (paramInt == 1)
    {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_b_of_type_Float);
    }
    while (paramInt != 2) {
      return;
    }
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(false);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_a_of_type_Float);
  }
  
  public void b(int paramInt, bogs parambogs, bogr parambogr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 100) {
      parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    parambogs.itemView.setOnClickListener(new boho(this, parambogs, paramInt));
    LocalMediaInfo localLocalMediaInfo;
    label195:
    int i;
    if (d())
    {
      parambogs.c.setVisibility(0);
      parambogs.jdField_a_of_type_Bogr = parambogr;
      if (parambogs.jdField_a_of_type_AndroidViewView != null) {
        parambogs.jdField_a_of_type_AndroidViewView.setOnClickListener(parambogs.jdField_a_of_type_Bogr);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (parambogs.jdField_a_of_type_AndroidViewView != null)) {
        parambogs.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      parambogs.jdField_a_of_type_Bogr.a(paramInt);
      parambogs.jdField_a_of_type_Bogr.a(parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      ImageView localImageView = parambogs.jdField_b_of_type_AndroidWidgetImageView;
      localImageView.setAdjustViewBounds(false);
      localLocalMediaInfo = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
      parambogr = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
      parambogs.itemView.setContentDescription(parambogr);
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label542;
      }
      parambogr = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = parambogs.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(parambogr)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + parambogr.toString());
        }
        parambogr = beyq.a(parambogr, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        parambogr.setTag(localLocalMediaInfo);
        localImageView.setImageDrawable(parambogr);
        ((URLImageView)localImageView).setURLDrawableDownListener(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq);
        parambogs.jdField_a_of_type_ComTencentImageURLDrawable = parambogr;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      parambogr = parambogs.jdField_a_of_type_AndroidWidgetTextView;
      if ((localLocalMediaInfo.isSystemMeidaStore) || (localLocalMediaInfo.mDuration > 0L)) {
        break label554;
      }
      parambogr.setVisibility(8);
      parambogr = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (parambogr != null) {
        parambogr.queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
      label406:
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label574;
      }
      parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + a());
      if (parambogs.itemView.getBackground() != null) {
        parambogs.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    for (;;)
    {
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)) {
        break label623;
      }
      parambogs.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      parambogs.c.setVisibility(8);
      break;
      label542:
      parambogr = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break label195;
      label554:
      parambogr.setVisibility(0);
      parambogr.setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
      break label406;
      label574:
      if (i == 3)
      {
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambogs.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambogs.itemView.getBackground() != null) {
          parambogs.itemView.setBackgroundDrawable((Drawable)null);
        }
      }
    }
    label623:
    parambogs.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
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
  }
  
  public void b(View paramView)
  {
    a(false, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent());
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
    if (paramView == null) {}
    do
    {
      return;
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      localObject1 = QAlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(paramView.path))
      {
        localObject2 = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        ((HashMap)localObject1).put(paramView.path, localObject2);
      }
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView.path);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode);
    paramView = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    Object localObject1 = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
    }
    paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
    paramView.setClass(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    paramView.addFlags(603979776);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  protected void b(@NonNull String paramString)
  {
    bpam.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0)) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public View c()
  {
    ImageView localImageView = new ImageView(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130841483);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  public void c() {}
  
  public void c(int paramInt, bogs parambogs, bogr parambogr) {}
  
  public void c(Intent paramIntent)
  {
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
  }
  
  public void c(View paramView) {}
  
  public void c(View paramView, int paramInt) {}
  
  protected boolean c()
  {
    return false;
  }
  
  public void d()
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
      str = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131694302);
      break;
    }
  }
  
  public void d(View paramView)
  {
    int i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    label66:
    label94:
    String str;
    EditorPicInfo localEditorPicInfo;
    double d1;
    if (i == 1)
    {
      bozr.a().e(0);
      if (e())
      {
        bozz.a().a("sp_key_ae_ratio_toasted", false, 0);
        e(i);
      }
      if (i != 1) {
        break label283;
      }
      b(2);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null)) {
        break label511;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      if (!paramView.hasNext()) {
        break label511;
      }
      str = (String)paramView.next();
      Size localSize = BitmapUtil.getImageSize(str);
      localEditorPicInfo = new EditorPicInfo();
      localEditorPicInfo.picPath = str;
      localEditorPicInfo.originPicWidth = localSize.getWidth();
      localEditorPicInfo.originPicHeight = localSize.getHeight();
      d1 = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (i != 1) {
        break label401;
      }
      if (d1 > 0.333333343267441D) {
        break label297;
      }
      d1 = 1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) / 2.0D / localEditorPicInfo.originPicHeight;
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = d1;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = (1.0D * (localEditorPicInfo.originPicWidth / 0.333333343267441D) / localEditorPicInfo.originPicHeight);
    }
    label401:
    for (;;)
    {
      a(str, localEditorPicInfo, null);
      break label94;
      if (i != 2) {
        break;
      }
      bozr.a().e(1);
      break;
      label283:
      if (i != 2) {
        break label66;
      }
      b(1);
      break label66;
      label297:
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
        if (i == 2) {
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
    label511:
    ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask)
    {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.10(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask = true;
  }
  
  public void e(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      paramView.add(this.jdField_a_of_type_JavaLangString);
    }
    h();
    paramView = new ArrayList();
    Object localObject = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    int i = 0;
    if (i < ((List)localObject).size())
    {
      String str = (String)((List)localObject).get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        bogh localbogh = a(str);
        if ((localbogh != null) && (localbogh.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo != null) && (new File(str).exists())) {
          paramView.add(localbogh.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo);
        }
      }
    }
    if (CollectionUtils.isEmpty(paramView))
    {
      QQToast.a(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689734, 0).a();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", paramView);
    i = born.y.a();
    if (born.k(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = born.A.a();
    }
    bpbj.a(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 0, (Bundle)localObject, i);
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.backPressed) {
      AlbumThumbManager.getInstance(((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    if (((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq != null)
    {
      int i = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(i));
    }
    if (((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask != null) {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_JavaLangString = null;
    b();
  }
  
  public void g()
  {
    if (((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b()) {
      ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
    }
  }
  
  protected void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      EditorPicInfo localEditorPicInfo = a(this.jdField_a_of_type_JavaLangString);
      localEditorPicInfo = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a(localEditorPicInfo);
      Matrix localMatrix = ((bogn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      if ((localEditorPicInfo != null) && (localMatrix != null)) {
        a(this.jdField_a_of_type_JavaLangString, localEditorPicInfo, localMatrix);
      }
    }
    return;
    label91:
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohl
 * JD-Core Version:    0.7.0.1
 */