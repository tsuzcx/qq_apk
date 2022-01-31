import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.2;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import com.tencent.theme.SkinnableBitmapDrawable;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class axvg
  extends axvd
  implements View.OnClickListener, bhqg
{
  MessageQueue.IdleHandler a;
  public ImageView a;
  public RelativeLayout a;
  public SeekBar a;
  public TextView a;
  public axui a;
  public Runnable a;
  public String a;
  public boolean a;
  public ImageView b;
  public TextView b;
  public String b;
  public TextView c;
  public ImageButton d;
  
  public axvg(Activity paramActivity, axui paramaxui)
  {
    super(paramActivity, paramaxui);
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new axvj(this);
    this.jdField_a_of_type_Axui = paramaxui;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_Axui.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((this.mContext == null) || (this.mContext.isFinishing()) || (this.jdField_a_of_type_Axui.getGallery() == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Axui.getGallery().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof axvl)))
    {
      localObject1 = ((axvl)((View)localObject3).getTag()).jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView;
      j = ((View)localObject3).getWidth();
      int k = ((View)localObject3).getHeight();
      if (j >= k * 2)
      {
        i = 1;
        if (k < j * 2) {
          break label349;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label394;
        }
        localMatrix = new Matrix();
        localMatrix.set(this.jdField_a_of_type_Axui.getGallery().getChildMatrix((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).getRegionBmp((Rect)localObject3, localMatrix, this.jdField_a_of_type_Axui.getGallery().getWidth(), this.jdField_a_of_type_Axui.getGallery().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = xwb.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = xwb.a(paramUri, this.mContext, 3, localSparseArray);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOFilePictureView.2(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.jdField_a_of_type_JavaLangString = paramUri.getPath();
        }
        anak.b(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "checkQQCode exception :" + localThrowable.getMessage());
      }
      i = 0;
      break;
      j = 0;
      break label119;
      label394:
      Object localObject2 = null;
      continue;
      label400:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      this.jdField_a_of_type_Axui.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      axui.updateRotation(this.galleryView, paramURLDrawable, paramRichMediaBrowserInfo.orientation);
      this.jdField_a_of_type_Axui.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private boolean a(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new axua();
    if (((axua)localObject2).a(paramAIOFilePictureData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = baul.a;
      localObject2 = ((axua)localObject2).a(paramAIOFilePictureData, 16);
      paramAIOFilePictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOFilePictureData != null) && (paramAIOFilePictureData.getStatus() == 1))
      {
        paramAIOFilePictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(baul.a);
    return true;
  }
  
  private boolean b(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePictureData.jdField_d_of_type_Boolean)
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837967));
      return true;
    }
    return false;
  }
  
  private void j()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
    if ((localAIOFilePictureData != null) && (new axua().a(localAIOFilePictureData, 20)))
    {
      if (localAIOFilePictureData.jdField_c_of_type_Long > 0L) {
        a(String.format(Locale.CHINA, this.mContext.getString(2131695500), new Object[] { arof.a(localAIOFilePictureData.jdField_c_of_type_Long) }));
      }
    }
    else {
      return;
    }
    a(this.mContext.getString(2131695497));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new axvi(this, paramAIOFilePictureData, paramFile));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFile != null)
    {
      bdig.a(2, localArrayList1);
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
        bdig.a(9, localArrayList1);
      }
      bdig.a(27, localArrayList1);
      bdig.a(39, localArrayList2);
      bdig.a(6, localArrayList2);
      if ((axtu.a().g()) && (!TextUtils.isEmpty(axtu.a().c()))) {
        bdig.a(54, localArrayList2);
      }
      if (this.jdField_a_of_type_Boolean) {
        bdig.a(52, localArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOFilePictureView.3(this, paramFile, localArrayList2));
    }
    for (;;)
    {
      a(paramAIOFilePictureData, paramFile);
      paramAIOFilePictureData = this.jdField_a_of_type_Axui.a(paramAIOFilePictureData, this.mContext);
      if (paramAIOFilePictureData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFilePictureData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if ((axtu.a().g()) && (!TextUtils.isEmpty(axtu.a().c()))) {
        bdig.a(54, localArrayList2);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public void as_()
  {
    this.jdField_a_of_type_Axui.updateSystemUIVisablity();
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
      if (localAIOFilePictureData != null)
      {
        axua localaxua = new axua();
        File localFile2 = localaxua.a(localAIOFilePictureData, 20);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localaxua.a(localAIOFilePictureData, 18);
        }
        if ((localFile1 != null) || (!axtu.a().a())) {
          break label67;
        }
      }
    }
    label67:
    while ((axtu.a().a()) || (axtu.a().c())) {
      return false;
    }
    return true;
  }
  
  public boolean back()
  {
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (axtu.a().c() == 3) || (axtu.a().c() == 2)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.mContext.getIntent().getExtras();
      if (((i == 0) && ((axtu.a().c() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (abot.a(axtu.a().a()) == 1032) || (abot.a(axtu.a().a()) == 1044) || (axtu.a().a() == 1037)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if ((this.jdField_a_of_type_Axui.a() != null) && (this.jdField_a_of_type_Axui.a().b()))
    {
      this.jdField_a_of_type_Axui.a().jdField_a_of_type_Boolean = false;
      return;
    }
    showContentView(false);
    this.jdField_a_of_type_Axui.a().g();
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        j();
      }
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.d != null)
    {
      localImageButton = this.d;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void g()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559119, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.contentView.findViewById(2131376058));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131372340));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.contentView.findViewById(2131364338));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.contentView.findViewById(2131376276));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131365977));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.contentView.findViewById(2131369767));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.d = ((ImageButton)this.contentView.findViewById(2131373460));
      this.d.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131373463));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      f(c());
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373456));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373458));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373459));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (bngs.b())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = bngs.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.setEnabled(paramBoolean);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof axvl)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      paramView = (axvl)paramView.getTag();
      localGalleryUrlImageView = paramView.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView;
      paramViewGroup = paramView.jdField_a_of_type_AndroidWidgetTextView;
      paramViewGroup.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localGalleryUrlImageView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -1;
      localGalleryUrlImageView.setLayoutParams(paramView);
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    for (;;)
    {
      g();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localRichMediaBrowserInfo = this.jdField_a_of_type_Axui.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
        break;
      }
      return localGalleryUrlImageView;
      this.galleryView = new RelativeLayout(this.mContext);
      this.galleryView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localGalleryUrlImageView = new GalleryUrlImageView(this.mContext);
      localGalleryUrlImageView.setId(2131367910);
      localGalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(14);
      this.galleryView.addView(localGalleryUrlImageView, paramView);
      paramViewGroup = new TextView(this.mContext);
      paramViewGroup.setTextSize(2, 8.0F);
      paramViewGroup.setTextColor(-1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(3, 2131367910);
      paramView.addRule(14);
      paramView.topMargin = aekt.a(20.0F, this.mContext.getResources());
      this.galleryView.addView(paramViewGroup, paramView);
      paramViewGroup.setVisibility(8);
    }
    AIOFilePictureData localAIOFilePictureData;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (localRichMediaBrowserInfo.baseData.getType() == 102)
    {
      paramView = this.jdField_a_of_type_Axui.a();
      if ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 102) || (((AIOBrowserBaseData)paramView.baseData).jdField_a_of_type_Long != ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) || (paramView.isReport)) {
        break label715;
      }
      azmj.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramView.isReport = true;
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      localObject3 = new axua();
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localRichMediaBrowserInfo);
      localGalleryUrlImageView.setIgnoreLayout(false);
      localGalleryUrlImageView.setContentDescription(this.mContext.getString(2131691664));
      localObject4 = (URLDrawable)this.jdField_a_of_type_Axui.mActiveDrawable.get(Integer.valueOf(paramInt));
      String str1 = ((axua)localObject3).a(localAIOFilePictureData, 20);
      String str2 = ((axua)localObject3).a(localAIOFilePictureData, 18);
      String str3 = ((axua)localObject3).a(localAIOFilePictureData, 16);
      localObject1 = "";
      paramView = (View)localObject1;
      if (localObject4 != null)
      {
        paramView = (View)localObject1;
        if (((URLDrawable)localObject4).getURL() != null) {
          paramView = ((URLDrawable)localObject4).getURL().toString();
        }
      }
      if ((localObject4 == null) || (((URLDrawable)localObject4).getStatus() != 1) || (TextUtils.isEmpty(paramView)) || ((!paramView.equals(str1)) && (!paramView.equals(str2)) && (!paramView.equals(str3)))) {
        break label751;
      }
      localGalleryUrlImageView.setImageDrawable((Drawable)localObject4);
      paramView = ((axua)localObject3).a(localAIOFilePictureData, 20);
      localObject1 = ((URLDrawable)localObject4).getURL().toString();
      this.jdField_a_of_type_Axui.onLoadFinish(paramInt, true);
      if (((String)localObject1).equals(paramView)) {
        localGalleryUrlImageView.setOriginalImage(true);
      }
      if (localRichMediaBrowserInfo.orientation == -2) {
        localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((URLDrawable)localObject4).getURL().getFile());
      }
      paramView = this.jdField_a_of_type_Axui;
      axui.updateRotation(this.galleryView, (URLDrawable)localObject4, localRichMediaBrowserInfo.orientation);
    }
    for (;;)
    {
      paramView = new axvl(this);
      paramView.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = localGalleryUrlImageView;
      paramView.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
      this.galleryView.setTag(paramView);
      return this.galleryView;
      label715:
      azmj.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
      label751:
      localObject4 = ((axua)localObject3).a(localAIOFilePictureData, 20);
      if (localObject4 != null)
      {
        paramView = null;
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.mScreenWidthPx;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.mScreenHeightPx;
        if (((axua)localObject3).a(localAIOFilePictureData, 16) != null)
        {
          localObject3 = URLDrawable.getFileDrawable(localAIOFilePictureData.jdField_b_of_type_JavaLangString, null);
          ((URLDrawable)localObject3).downloadImediatly();
        }
        for (((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject3);; ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = baul.a)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          try
          {
            localObject1 = URLDrawable.getFileDrawable(((File)localObject4).getAbsolutePath(), (URLDrawable.URLDrawableOptions)localObject1);
            paramView = (View)localObject1;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
            }
          }
          if (paramView == null) {
            break;
          }
          paramView.setTag(Integer.valueOf(1));
          this.jdField_a_of_type_Axui.mActiveDrawable.put(Integer.valueOf(paramInt), paramView);
          localObject1 = ((File)localObject4).getAbsolutePath();
          localGalleryUrlImageView.setGalleryImageListener(new axvk(this, localRichMediaBrowserInfo, (String)localObject1, paramView, localAIOFilePictureData, localGalleryUrlImageView));
          this.jdField_a_of_type_JavaLangRunnable = aekt.a(this.jdField_b_of_type_AndroidWidgetImageView, paramView);
          if ((this.jdField_a_of_type_JavaLangRunnable == null) && (paramView.getStatus() == 1)) {
            a(localRichMediaBrowserInfo, (String)localObject1, paramView, paramInt);
          }
          localGalleryUrlImageView.setImageDrawable(paramView);
          break;
        }
      }
      localObject4 = ((axua)localObject3).a(localAIOFilePictureData, 18);
      if (localObject4 != null)
      {
        if (localObject4 != null) {}
        paramView = null;
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        try
        {
          localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).downloadImediatly();
          paramView = (View)localObject2;
          if (paramView != null) {
            this.jdField_a_of_type_Axui.mActiveDrawable.put(Integer.valueOf(paramInt), paramView);
          }
          if ((paramView != null) && (paramView.getStatus() == 1)) {
            if (localRichMediaBrowserInfo.orientation != -2) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((File)localObject4).getAbsolutePath());
            localObject2 = this.jdField_a_of_type_Axui;
            axui.updateRotation(this.galleryView, paramView, localRichMediaBrowserInfo.orientation);
            localGalleryUrlImageView.setImageDrawable(paramView);
            this.jdField_a_of_type_Axui.onLoadFinish(paramInt, true);
            continue;
            localThrowable2 = localThrowable2;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
              localRichMediaBrowserInfo.orientation = 1;
            }
          }
          if ((!a(localAIOFilePictureData, localGalleryUrlImageView)) && (!b(localAIOFilePictureData, localGalleryUrlImageView))) {
            a(localGalleryUrlImageView);
          }
          a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
        }
      }
      else if (((axua)localObject3).a(localAIOFilePictureData, 16) != null)
      {
        if ((!a(localAIOFilePictureData, localGalleryUrlImageView)) && (!b(localAIOFilePictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): url is " + ((axua)localObject3).a(localAIOFilePictureData, 16) + ", file type is " + 16);
      }
      else
      {
        if ((!aroo.a(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) && (localAIOFilePictureData.jdField_g_of_type_Int != 1))
        {
          if (localAIOFilePictureData.jdField_d_of_type_Boolean) {
            a(localGalleryUrlImageView);
          }
          for (;;)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
            break;
            a(localGalleryUrlImageView);
            a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
          }
        }
        localGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130843806));
        paramView = (RelativeLayout.LayoutParams)localGalleryUrlImageView.getLayoutParams();
        paramView.width = aekt.a(60.0F, this.mContext.getResources());
        paramView.height = aekt.a(60.0F, this.mContext.getResources());
        localGalleryUrlImageView.setLayoutParams(paramView);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131692600);
        localGalleryUrlImageView.setTag(2131296386, Float.valueOf(1.5F));
        this.jdField_a_of_type_Axui.a().b();
      }
    }
  }
  
  public void h()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
    if ((localAIOFilePictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      if (!bdee.d(this.mContext))
      {
        QQToast.a(this.mContext, this.mContext.getString(2131694061), 0).a();
        updateUI();
      }
    }
    else {
      return;
    }
    if (localAIOFilePictureData.jdField_g_of_type_Boolean)
    {
      QQToast.a(this.mContext, this.mContext.getString(2131692939), 0).a();
      updateUI();
      return;
    }
    if (localAIOFilePictureData.h) {
      updateUI();
    }
    long l = aqxg.a();
    if ((localAIOFilePictureData.jdField_e_of_type_Long > l) && (arni.a())) {
      try
      {
        arni.a(false, this.mContext, new axvh(this, localAIOFilePictureData));
        return;
      }
      catch (Throwable localThrowable)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog throwable = " + localThrowable.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_Axui.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 2);
    RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 20);
    if (this.jdField_a_of_type_Axui.getGallery() != null)
    {
      this.jdField_a_of_type_Axui.getGallery().enableDoubleTap(true);
      this.jdField_a_of_type_Axui.getGallery().enableScaleGesture(true);
    }
    updateUI();
  }
  
  void i()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
    Object localObject2;
    Object localObject1;
    if (localAIOFilePictureData != null)
    {
      axua localaxua = new axua();
      localObject2 = localaxua.a(localAIOFilePictureData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaxua.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localaxua.a(localAIOFilePictureData, 16);
      }
      if (localObject2 != null) {}
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
    int i = 99;
    int j;
    boolean bool;
    int k;
    switch (axtu.a().c())
    {
    default: 
      j = 0;
      bool = false;
      k = 0;
      localObject1 = EditPicActivity.a(this.mContext, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
      ((Intent)localObject1).putExtra("uintype", axtu.a().a());
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
      }
      if (j != 0) {
        ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
      {
        localObject2 = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, axtu.a().a());
        if (localObject2 != null)
        {
          ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
          }
        }
      }
      ((Intent)localObject1).putExtra("not_forward", true);
      if (k != 0) {
        this.mContext.startActivityForResult((Intent)localObject1, k);
      }
      break;
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      return;
      i = 125;
      j = 0;
      bool = true;
      k = 19002;
      break;
      i = 126;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 127;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 128;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 129;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 130;
      j = 0;
      bool = true;
      k = 19000;
      break;
      this.mContext.startActivity((Intent)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370067: 
    case 2131364338: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_Axui.getSelectedItem();
        } while ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 102));
        this.jdField_a_of_type_Axui.back();
        return;
        paramView = this.jdField_a_of_type_Axui.a();
      } while (paramView == null);
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 20);
      }
      this.jdField_a_of_type_Axui.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      updateUI();
      return;
    case 2131373459: 
      d();
      return;
    case 2131373463: 
      h();
      return;
    case 2131373460: 
      i();
      this.jdField_a_of_type_Axui.f();
      return;
    case 2131373458: 
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryFilePicView", 0, "onClick qq_gallery_danmaku_view ");
    }
    paramView = this.jdField_a_of_type_Axui.a();
    if (paramView != null) {
      MiniChatActivity.a(this.mContext, axtu.a().a(), axtu.a().a(), false, 26, paramView.jdField_d_of_type_Long, 0L);
    }
    this.jdField_a_of_type_Axui.j();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject = (URLDrawable)this.jdField_a_of_type_Axui.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    AIOFilePictureData localAIOFilePictureData;
    do
    {
      do
      {
        do
        {
          return null;
        } while ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 102));
        localAIOFilePictureData = (AIOFilePictureData)paramRichMediaBrowserInfo.baseData;
        axua localaxua = new axua();
        localObject = localaxua.a(localAIOFilePictureData, 20);
        paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
        if (localObject == null)
        {
          paramRichMediaBrowserInfo = localaxua.a(localAIOFilePictureData, 18);
          if (paramRichMediaBrowserInfo == null) {}
        }
        else
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
          paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject);
          paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
          paramRichMediaBrowserInfo.startDownload();
          this.jdField_a_of_type_Axui.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
          return null;
        }
        paramRichMediaBrowserInfo = localaxua.a(localAIOFilePictureData, 16);
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
        URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject).startDownload();
      } while ((!bdee.h(this.mContext)) || (localAIOFilePictureData.jdField_e_of_type_Long > aqxg.c()) || (RichMediaBrowserManager.getInstance().getProvider() == null));
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
      return null;
    } while ((!bdee.h(this.mContext)) || (localAIOFilePictureData.jdField_e_of_type_Long > aqxg.c()));
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
    return null;
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Axui.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof axvl)))
    {
      paramAdapterView = (axvl)paramView.getTag();
      if (paramAdapterView.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView != null)
      {
        paramView = paramAdapterView.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView;
        Drawable localDrawable = paramView.getDrawable();
        paramAdapterView = this.jdField_a_of_type_Axui.a();
        if ((paramAdapterView != null) && (!paramView.isOriginalImage()) && ((localDrawable instanceof SkinnableBitmapDrawable)) && (paramAdapterView.jdField_b_of_type_Int == 1) && (paramAdapterView.jdField_c_of_type_Long > aqxg.c()) && (this.jdField_a_of_type_Axui.getGallery() != null))
        {
          this.jdField_a_of_type_Axui.getGallery().enableDoubleTap(false);
          this.jdField_a_of_type_Axui.getGallery().enableScaleGesture(false);
        }
        if (paramAdapterView != null)
        {
          paramView = new axua();
          if ((paramView.a(paramAdapterView, 20) == null) && (paramView.a(paramAdapterView, 18) == null) && (paramView.a(paramAdapterView, 16) == null) && ((aroo.a(paramAdapterView.jdField_e_of_type_Int, paramAdapterView.f, paramAdapterView.jdField_e_of_type_Long)) || (paramAdapterView.jdField_g_of_type_Int == 1))) {
            this.jdField_a_of_type_Axui.a().b();
          }
        }
      }
      updateUI();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof axvl)))
    {
      paramView = ((axvl)paramView.getTag()).jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
    Object localObject2;
    if (localAIOFilePictureData != null)
    {
      axua localaxua = new axua();
      localObject2 = localaxua.a(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaxua.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localaxua.a(localAIOFilePictureData, 16);
      }
      if ((localObject2 != null) || (!axtu.a().a())) {}
    }
    else
    {
      return;
    }
    a(localAIOFilePictureData, (File)localObject2, paramInt);
  }
  
  public void updateUI()
  {
    super.updateUI();
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_Axui.a();
    if (localAIOFilePictureData != null) {}
    switch (localAIOFilePictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + localAIOFilePictureData.status);
      return;
    case 1: 
      e(false);
      b(false);
      f(false);
      c(false);
      this.jdField_a_of_type_Axui.onLoadStart(this.jdField_a_of_type_Axui.getSelectedIndex(), localAIOFilePictureData.progress);
      return;
    case 2: 
      this.jdField_a_of_type_Axui.onLoadFinish(this.jdField_a_of_type_Axui.getSelectedIndex(), true);
      e(false);
      b(false);
      f(false);
      c(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131700430) + localAIOFilePictureData.progress / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOFilePictureData.progress / 100);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    b(b());
    c(a(this.jdField_a_of_type_Axui.getSelectedItem()));
    boolean bool;
    axua localaxua;
    if (!arof.b(localAIOFilePictureData.jdField_d_of_type_JavaLangString))
    {
      bool = true;
      e(bool);
      f(true);
      localaxua = new axua();
      if (localAIOFilePictureData.jdField_e_of_type_Long <= 10485760L) {
        break label324;
      }
      g(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axui.onLoadFinish(this.jdField_a_of_type_Axui.getSelectedIndex(), true);
      return;
      bool = false;
      break;
      label324:
      if ((localaxua.a(localAIOFilePictureData, 18) != null) || (localaxua.a(localAIOFilePictureData, 20) != null)) {
        g(true);
      } else {
        g(false);
      }
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axui.getItem(paramInt);
    Object localObject;
    AIOFilePictureData localAIOFilePictureData;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 102) && (this.galleryView != null) && ((paramView.getTag() instanceof axvl)))
    {
      paramString1 = (axvl)paramView.getTag();
      paramView = paramString1.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView;
      localObject = paramString1.jdField_a_of_type_AndroidWidgetTextView;
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      paramString1 = new axua();
      if (!localAIOFilePictureData.jdField_d_of_type_Boolean) {
        break label397;
      }
      paramString1 = paramView.getDrawable();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label687;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString2 == null) && (arof.b(localAIOFilePictureData.jdField_b_of_type_JavaLangString)))
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mLoadingDrawable = baul.a;
        paramString1.mFailedDrawable = baul.a;
        paramString1 = URLDrawable.getDrawable(new File(localAIOFilePictureData.jdField_b_of_type_JavaLangString), paramString1);
        if (paramString1 != null)
        {
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
        }
      }
      label397:
      do
      {
        do
        {
          return;
        } while ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2))));
        if ((aroo.a(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) || (localAIOFilePictureData.jdField_g_of_type_Int == 1))
        {
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130843806));
          paramString1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramString1.width = aekt.a(60.0F, this.mContext.getResources());
          paramString1.height = aekt.a(60.0F, this.mContext.getResources());
          paramView.setLayoutParams(paramString1);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setText(2131692600);
          paramView.setTag(2131296386, Float.valueOf(1.5F));
          this.jdField_a_of_type_Axui.a().b();
        }
        for (;;)
        {
          this.jdField_a_of_type_Axui.onLoadFinish(paramInt, false);
          this.jdField_a_of_type_Axui.a().d();
          return;
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837967));
        }
        localObject = paramString1.a(localAIOFilePictureData, 18);
      } while (localObject == null);
      paramString2 = paramString1.a(localAIOFilePictureData, 18);
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = paramString2 + "#PART";
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      paramString2.mUseExifOrientation = false;
      paramString2.mPlayGifImage = true;
      paramString2 = URLDrawable.getDrawable((File)localObject, paramString2);
      paramString2.setTag(Integer.valueOf(1));
      if (paramString2.getStatus() == 1) {
        if (localRichMediaBrowserInfo.orientation != -2) {}
      }
      for (;;)
      {
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((File)localObject).getAbsolutePath());
          paramView.setImageDrawable(paramString2);
          this.jdField_a_of_type_Axui.onLoadFinish(paramInt, true);
          paramView = this.jdField_a_of_type_Axui;
          axui.updateRotation(this.galleryView, paramString2, localRichMediaBrowserInfo.orientation);
          paramString2 = bdcs.b(localAIOFilePictureData.jdField_c_of_type_JavaLangString);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
          this.jdField_a_of_type_Axui.a().c();
          return;
        }
        catch (Exception localException)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
          localRichMediaBrowserInfo.orientation = 1;
          continue;
        }
        paramString2.setTag(Integer.valueOf(1));
        paramString2.startDownload();
        paramView.setDecodingDrawble(paramString2);
      }
      label687:
      paramString2 = null;
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvg
 * JD-Core Version:    0.7.0.1
 */