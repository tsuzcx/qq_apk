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
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
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
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.4;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
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

public class bkrh<K extends bkql>
  extends bkrb<K>
  implements bkrc, bkrd, bkre
{
  public float a;
  public String a;
  private ArrayList<LocalMediaInfo> a;
  protected Map<String, bkqf> a;
  protected boolean a;
  public float b;
  protected String b;
  private boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  
  protected bkrh(K paramK)
  {
    super(paramK);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    this.jdField_a_of_type_Bkre = this;
    this.jdField_a_of_type_Bkrc = this;
    this.jdField_a_of_type_Bkrd = this;
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
  
  private ArrayList<String> a()
  {
    return this.jdField_a_of_type_Aiqy.selectedPhotoList;
  }
  
  private void a()
  {
    String str;
    int i;
    if (!a().isEmpty())
    {
      bljn.a("AEPhotoListLogicBase", "mPhotoCommonData.selectedPhotoList.size() = " + a().size());
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
      bljn.a("AEPhotoListLogicBase", "!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = " + i);
      if (i >= 0)
      {
        this.jdField_c_of_type_JavaLangString = str;
        a(str, false);
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.notifyItemChanged(i);
      }
      return;
      label151:
      i += 1;
      break;
      label158:
      i = -1;
    }
  }
  
  private void a(int paramInt, bkqp parambkqp)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    bljn.a("AEPhotoListLogicBase", "handlePhotoItemClick, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((!parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambkqp.c.getVisibility() == 8))
    {
      bljn.a("AEPhotoListLogicBase", "没有选中，没有focus，点击后变选中且focus, position = " + paramInt);
      if ((a() != null) && (a().size() >= this.jdField_a_of_type_Aiqy.maxSelectNum))
      {
        bljn.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(localLocalMediaInfo, parambkqp);
      }
    }
    do
    {
      return;
      a(parambkqp);
      a(localLocalMediaInfo, parambkqp);
      c(paramInt);
      bool2 = d();
      if (!bool2) {
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 1);
      }
      if (bool2) {}
      for (paramInt = 0;; paramInt = 600)
      {
        d(paramInt);
        parambkqp = localLocalMediaInfo.path;
        if (!bool2) {
          bool1 = true;
        }
        a(parambkqp, bool1);
        return;
      }
      if ((parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambkqp.c.getVisibility() == 8))
      {
        bljn.a("AEPhotoListLogicBase", "选中，没有focus，点击后变选中且focus, position = " + paramInt);
        a(parambkqp);
        bool1 = d();
        c(paramInt);
        if (!bool1) {
          ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 1);
        }
        parambkqp = localLocalMediaInfo.path;
        if (!bool1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(parambkqp, bool1);
          return;
        }
      }
      if ((parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) && (parambkqp.c.getVisibility() == 0))
      {
        if (a().size() > 1)
        {
          bljn.a("AEPhotoListLogicBase", "选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = " + paramInt);
          b(parambkqp);
          b(localLocalMediaInfo, parambkqp);
          a();
          return;
        }
        bljn.a("AEPhotoListLogicBase", "选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = " + paramInt);
        b(localLocalMediaInfo, parambkqp);
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.notifyDataSetChanged();
        return;
      }
    } while ((parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked()) || (parambkqp.c.getVisibility() != 0));
    bljn.a("AEPhotoListLogicBase", "没有选中，有focus，点击后变选中且focus, position = " + paramInt);
    a(localLocalMediaInfo, parambkqp);
    d(0);
  }
  
  private void a(bkqp parambkqp)
  {
    parambkqp.c.setVisibility(0);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, bkqp parambkqp)
  {
    bljn.a("AEPhotoListLogicBase", "[setSelected], photoPath=" + paramLocalMediaInfo.path);
    parambkqp.jdField_a_of_type_Bkqo.onClick(parambkqp.jdField_a_of_type_AndroidViewView);
  }
  
  private boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  private void b(bkqp parambkqp)
  {
    parambkqp.c.setVisibility(8);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, bkqp parambkqp)
  {
    parambkqp.jdField_a_of_type_Bkqo.onClick(parambkqp.jdField_a_of_type_AndroidViewView);
    bljn.a("AEPhotoListLogicBase", "cancelSelected image.path = " + paramLocalMediaInfo.path);
    c(paramLocalMediaInfo.path);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return;
    }
    if (paramBoolean)
    {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(4);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(0);
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean b()
  {
    return !a().isEmpty();
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_c_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path))
    {
      bljn.a("AEPhotoListLogicBase", "!currentFocusedImagePath.equals(mAllImages.get(position).path), position = " + paramInt);
      int i = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      if (i >= 0) {
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.notifyItemChanged(i);
      }
    }
  }
  
  private boolean c()
  {
    if (a() == null) {}
    String str;
    do
    {
      do
      {
        return true;
      } while ((a().size() > 1) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
      str = this.jdField_a_of_type_JavaLangString;
      localObject = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
    } while (CollectionUtils.isEmpty((Collection)localObject));
    Object localObject = ((List)localObject).iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
    } while ((localLocalMediaInfo == null) || (TextUtils.isEmpty(localLocalMediaInfo.path)) || (!localLocalMediaInfo.path.equals(str)) || (localLocalMediaInfo.mediaWidth != localLocalMediaInfo.mediaHeight));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d(int paramInt)
  {
    if (a().size() == 1)
    {
      if (paramInt > 0) {
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEPhotoListLogicBase.7(this), paramInt);
      }
    }
    else {
      return;
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.notifyDataSetChanged();
  }
  
  private boolean d()
  {
    return ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.a();
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    Intent localIntent = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aiqy.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    if (this.jdField_a_of_type_Aiqy.needMediaInfo)
    {
      if (!this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.containsKey(paramView.path)) {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.put(paramView.path, paramView);
      }
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
    }
    localIntent.setClass(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public View a()
  {
    View localView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558552, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  @Nullable
  public bkqf a(@NonNull String paramString)
  {
    bljn.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {
      return null;
    }
    return (bkqf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  protected EditorPicInfo a(@NonNull String paramString)
  {
    bljn.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = a(paramString);
    if ((localObject == null) || (((bkqf)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo == null))
    {
      localObject = new EditorPicInfo();
      Size localSize = BitmapUtil.getImageSize(paramString);
      ((EditorPicInfo)localObject).picPath = paramString;
      ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
      ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
      return localObject;
    }
    return ((bkqf)localObject).jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo;
  }
  
  String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Aiqy.maxSelectNum;
    return ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695260, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit);
    bdif.a("PEAK", "getAlbumMedias");
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
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(0);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, bkqp parambkqp, bkqo parambkqo)
  {
    if (this.jdField_a_of_type_Aiqy.maxSelectNum > 100) {
      parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    parambkqp.jdField_a_of_type_Bkqo = parambkqo;
    Object localObject1;
    label300:
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_JavaLangString = ((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path;
      parambkqp.c.setVisibility(0);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) && (parambkqp.jdField_a_of_type_AndroidViewView != null)) {
        parambkqp.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      parambkqp.jdField_a_of_type_Bkqo.a(paramInt);
      parambkqp.jdField_a_of_type_Bkqo.a(parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      parambkqp.itemView.setOnClickListener(new bkri(this, paramInt, parambkqp));
      localObject1 = parambkqp.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject1).setAdjustViewBounds(false);
      parambkqo = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
      Object localObject2 = QAlbumUtil.createContentDescription(0, parambkqo, paramInt);
      parambkqp.itemView.setContentDescription((CharSequence)localObject2);
      if (parambkqo != null)
      {
        parambkqp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon) || (!((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(parambkqo))) {
          break label696;
        }
        if (parambkqp.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          parambkqp.jdField_b_of_type_AndroidWidgetTextView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a();
          parambkqp.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)parambkqp.itemView).addView(parambkqp.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        }
        parambkqp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        i = AlbumThumbDownloader.THUMB_WIDHT;
        parambkqo.thumbHeight = i;
        parambkqo.thumbWidth = i;
        localObject2 = parambkqp.jdField_a_of_type_ComTencentImageURLDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(parambkqo.path);
        if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject2 = QAlbumUtil.generateAlbumThumbURL(parambkqo);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "photoGridAdapter,getView(),image url :" + ((URL)localObject2).toString());
          }
          localObject2 = bayu.a((URL)localObject2, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject2).setTag(parambkqo);
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setURLDrawableDownListener(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn);
          parambkqp.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
        }
        i = parambkqo.selectStatus;
        if (i != 1) {
          break label715;
        }
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Aiqy.selectedPhotoList.indexOf(parambkqo.path) + 1);
        if (parambkqp.itemView.getBackground() != null) {
          parambkqp.itemView.setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, parambkqo, paramInt, parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      parambkqo.visableTime = SystemClock.uptimeMillis();
      parambkqo.listViewPosition = paramInt;
      a(parambkqp, parambkqo);
      if ((this.jdField_a_of_type_Aiqy.selectedPhotoList.size() < this.jdField_a_of_type_Aiqy.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)) {
        break label761;
      }
      parambkqp.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      parambkqo = parambkqp.c;
      if (this.jdField_c_of_type_JavaLangString.equals(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).path)) {}
      for (i = 0;; i = 8)
      {
        parambkqo.setVisibility(i);
        break;
      }
      label696:
      if (parambkqp.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label300;
      }
      parambkqp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label300;
      label715:
      if (i == 3)
      {
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambkqp.itemView.getBackground() != null) {
          parambkqp.itemView.setBackgroundDrawable(null);
        }
      }
    }
    label761:
    parambkqp.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean))
    {
      this.jdField_a_of_type_Boolean = false;
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(8);
      if (c()) {
        ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
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
        this.jdField_a_of_type_Aiqy.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_Aiqy.albumId = QAlbumUtil.sLastAlbumId;
      }
      if (this.jdField_a_of_type_Aiqy.albumId == null)
      {
        this.jdField_a_of_type_Aiqy.albumId = "$RecentAlbumId";
        this.jdField_a_of_type_Aiqy.albumName = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_Aiqy.selectedPhotoList = ((ArrayList)localObject);
      }
      if (this.jdField_a_of_type_Aiqy.selectedPhotoList == null) {
        this.jdField_a_of_type_Aiqy.selectedPhotoList = new ArrayList();
      }
      if (this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap == null) {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == ((HashMap)localObject).size()))
      {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.clear();
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.putAll((Map)localObject);
      }
      this.jdField_a_of_type_Aiqy.selectedIndex = new ArrayList();
      this.jdField_a_of_type_Aiqy.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      if (this.jdField_a_of_type_Aiqy.maxSelectNum > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showMediaType);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoGif)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showMediaType = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.photoListStartPos = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.jdField_a_of_type_Aiqy.needMediaInfo) {
        this.jdField_a_of_type_Aiqy.needMediaInfo = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showMediaType != 2) {
        break label608;
      }
    }
    label608:
    for (paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;; paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent;
      return;
      this.jdField_a_of_type_Aiqy.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_Aiqy.albumId = paramIntent.getStringExtra("ALBUM_ID");
      break;
    }
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_Aiqy.selectedPhotoList;
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
      localLocalMediaInfo = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
      i = localLocalMediaInfo.selectStatus;
      if ((i == 1) || (paramView.size() < this.jdField_a_of_type_Aiqy.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.lastTimeShowToast < 1000L);
    QQToast.a(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
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
      this.jdField_a_of_type_Aiqy.selectedIndex.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      paramView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
      if (paramView != null) {
        break label829;
      }
      paramView = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_Aiqy.albumId, paramView);
    }
    label537:
    label829:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName));
      }
      if (this.jdField_a_of_type_Bkrf != null) {
        this.jdField_a_of_type_Bkrf.a(bool1, localLocalMediaInfo);
      }
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (bkql)this.jdField_a_of_type_MqqUtilWeakReference.get();
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
        this.jdField_a_of_type_Aiqy.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
          this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        paramView = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
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
  
  protected void a(bkqp parambkqp, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(@NonNull String paramString, @NonNull bkqf parambkqf)
  {
    bljn.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambkqf);
  }
  
  protected void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, @NonNull Matrix paramMatrix)
  {
    bljn.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      bljn.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    bkqf localbkqf = a(paramString);
    if (localbkqf != null) {}
    for (;;)
    {
      localbkqf.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo = paramEditorPicInfo;
      localbkqf.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
      a(paramString, localbkqf);
      return;
      localbkqf = new bkqf();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.8(this, paramString, paramBoolean));
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      b(false);
      return;
    }
    LinkedList localLinkedList = new LinkedList(paramArrayList);
    if (CollectionUtils.isEmpty(localLinkedList))
    {
      b(false);
      return;
    }
    int i = 0;
    if (i < localLinkedList.size())
    {
      paramArrayList = (LocalMediaInfo)localLinkedList.get(i);
      if (paramArrayList == null) {}
      while (bdfa.getMediaType(paramArrayList) != 0)
      {
        i += 1;
        break;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      if ((paramArrayList != null) && (this.jdField_c_of_type_Boolean) && (i >= 0))
      {
        this.jdField_c_of_type_Boolean = false;
        if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
        {
          a(paramArrayList.path, true);
          ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicBase.1(this, i));
        }
      }
      b(bool);
      return;
      i = -1;
      paramArrayList = null;
    }
  }
  
  public void a(List<LocalMediaInfo> paramList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_Aiqy.albumName)) || (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Aiqy.albumName)));
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aiqy.albumName;
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
    } while (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilArrayList));
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(0, 0);
  }
  
  void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiqy.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
      paramIntent.addFlags(603979776);
      c(paramIntent);
      QAlbumUtil.anim(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
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
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return false;
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.4(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) || (!this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo)
        {
          localObject = paramList;
          if (!this.jdField_a_of_type_Aiqy.albumId.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a((List)localObject);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.5(this));
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && (this.jdField_a_of_type_Aiqy.albumId.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramList);
    boolean bool = paramList.isEmpty();
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this, bool));
    return true;
  }
  
  public View b()
  {
    View localView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558553, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    return localView;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_b_of_type_Float);
    }
    while (paramInt != 2) {
      return;
    }
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(false);
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.jdField_a_of_type_Float);
  }
  
  public void b(int paramInt, bkqp parambkqp, bkqo parambkqo)
  {
    if (this.jdField_a_of_type_Aiqy.maxSelectNum > 100) {
      parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    parambkqp.itemView.setOnClickListener(new bkrj(this, parambkqp, paramInt));
    LocalMediaInfo localLocalMediaInfo;
    label195:
    int i;
    if (b())
    {
      parambkqp.c.setVisibility(0);
      parambkqp.jdField_a_of_type_Bkqo = parambkqo;
      if (parambkqp.jdField_a_of_type_AndroidViewView != null) {
        parambkqp.jdField_a_of_type_AndroidViewView.setOnClickListener(parambkqp.jdField_a_of_type_Bkqo);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (parambkqp.jdField_a_of_type_AndroidViewView != null)) {
        parambkqp.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      parambkqp.jdField_a_of_type_Bkqo.a(paramInt);
      parambkqp.jdField_a_of_type_Bkqo.a(parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      ImageView localImageView = parambkqp.jdField_b_of_type_AndroidWidgetImageView;
      localImageView.setAdjustViewBounds(false);
      localLocalMediaInfo = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
      parambkqo = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
      parambkqp.itemView.setContentDescription(parambkqo);
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label537;
      }
      parambkqo = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = parambkqp.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(parambkqo)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + parambkqo.toString());
        }
        parambkqo = bayu.a(parambkqo, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        parambkqo.setTag(localLocalMediaInfo);
        localImageView.setImageDrawable(parambkqo);
        ((URLImageView)localImageView).setURLDrawableDownListener(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn);
        parambkqp.jdField_a_of_type_ComTencentImageURLDrawable = parambkqo;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      parambkqo = parambkqp.jdField_a_of_type_AndroidWidgetTextView;
      if ((localLocalMediaInfo.isSystemMeidaStore) || (localLocalMediaInfo.mDuration > 0L)) {
        break label549;
      }
      parambkqo.setVisibility(8);
      parambkqo = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (parambkqo != null) {
        parambkqo.queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
      label406:
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label569;
      }
      parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Aiqy.selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1);
      if (parambkqp.itemView.getBackground() != null) {
        parambkqp.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    for (;;)
    {
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      if ((this.jdField_a_of_type_Aiqy.selectedPhotoList.size() < this.jdField_a_of_type_Aiqy.maxSelectNum) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)) {
        break label618;
      }
      parambkqp.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
      parambkqp.c.setVisibility(8);
      break;
      label537:
      parambkqo = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break label195;
      label549:
      parambkqo.setVisibility(0);
      parambkqo.setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
      break label406;
      label569:
      if (i == 3)
      {
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        parambkqp.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (parambkqp.itemView.getBackground() != null) {
          parambkqp.itemView.setBackgroundDrawable((Drawable)null);
        }
      }
    }
    label618:
    parambkqp.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.jdField_a_of_type_Aiqy.needMediaInfo)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.jdField_a_of_type_Aiqy.allMediaInfoHashMap != null) {
          localObject = (LocalMediaInfo)this.jdField_a_of_type_Aiqy.allMediaInfoHashMap.get(str);
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
    a(false, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent());
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    if (paramView == null) {}
    do
    {
      return;
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      localObject1 = QAlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(paramView.path))
      {
        localObject2 = new Pair(this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName);
        ((HashMap)localObject1).put(paramView.path, localObject2);
      }
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView.path);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode);
    paramView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
    paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
    Object localObject1 = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aiqy.selectedIndex);
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
    }
    paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
    paramView.setClass(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    paramView.addFlags(603979776);
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    QAlbumUtil.anim(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  public View c()
  {
    ImageView localImageView = new ImageView(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130841170);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  public void c()
  {
    View localView = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      return;
    }
  }
  
  public void c(int paramInt, bkqp parambkqp, bkqo parambkqo) {}
  
  public void c(Intent paramIntent)
  {
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
  }
  
  public void c(View paramView) {}
  
  public void c(View paramView, int paramInt) {}
  
  public void c(@NonNull String paramString)
  {
    bljn.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0)) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  public void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    String str;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText;
      if (localArrayList.size() <= 0) {
        break label145;
      }
      bool = true;
      label35:
      if (!bool) {
        break label150;
      }
      str = str + "(" + localArrayList.size() + ")";
    }
    label145:
    label150:
    for (;;)
    {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText(str);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
      return;
      str = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695245);
      break;
      bool = false;
      break label35;
    }
  }
  
  public void d(View paramView)
  {
    int i = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    if (i == 1) {
      b(2);
    }
    for (;;)
    {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      return;
      if (i == 2) {
        b(1);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask)
    {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.9(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask = true;
  }
  
  public void e(View paramView)
  {
    paramView = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      paramView.add(this.jdField_a_of_type_JavaLangString);
    }
    h();
    paramView = new ArrayList();
    Object localObject = new LinkedList(this.jdField_a_of_type_Aiqy.selectedPhotoList);
    int i = 0;
    if (i < ((List)localObject).size())
    {
      String str = (String)((List)localObject).get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        bkqf localbkqf = a(str);
        if ((localbkqf != null) && (localbkqf.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo != null) && (new File(str).exists())) {
          paramView.add(localbkqf.jdField_a_of_type_DovComQqImAeeditorModuleClipImageEditorPicInfo);
        }
      }
    }
    if (CollectionUtils.isEmpty(paramView))
    {
      QQToast.a(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689824, 0).a();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", paramView);
    i = blat.y.a();
    if (blat.j(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = blat.A.a();
    }
    bljx.a(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 0, (Bundle)localObject, i);
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.backPressed) {
      AlbumThumbManager.getInstance(((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    if (((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn != null)
    {
      int i = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_Aiqy.albumId, Integer.valueOf(i));
    }
    if (((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask != null) {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_JavaLangString = null;
    b();
  }
  
  public void g()
  {
    if (((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b()) {
      ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!a(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      EditorPicInfo localEditorPicInfo = a(this.jdField_a_of_type_JavaLangString);
      localEditorPicInfo = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a(localEditorPicInfo);
      Matrix localMatrix = ((bkql)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
      if ((localEditorPicInfo != null) && (localMatrix != null)) {
        a(this.jdField_a_of_type_JavaLangString, localEditorPicInfo, localMatrix);
      }
    }
    return;
    label91:
    c(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrh
 * JD-Core Version:    0.7.0.1
 */