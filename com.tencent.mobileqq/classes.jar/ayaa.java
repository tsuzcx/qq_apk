import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.annotation.RequiresApi;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.7;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
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
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ayaa
  extends axzm
  implements View.OnClickListener, bhun
{
  public int a;
  public long a;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new ayac(this);
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public SeekBar a;
  public TextView a;
  private axyv jdField_a_of_type_Axyv;
  public ayan a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public Runnable a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  private int b;
  public ImageView b;
  public TextView b;
  public String b;
  public boolean b;
  public TextView c;
  public boolean c;
  public ImageButton d;
  public TextView d;
  
  public ayaa(Activity paramActivity, axyv paramaxyv)
  {
    super(paramActivity, paramaxyv);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Axyv = paramaxyv;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_Axyv.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((this.mContext == null) || (this.mContext.isFinishing()) || (this.jdField_a_of_type_Axyv.getGallery() == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Axyv.getGallery().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof ayam)))
    {
      localObject1 = ((ayam)((View)localObject3).getTag()).a;
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
        localMatrix.set(this.jdField_a_of_type_Axyv.getGallery().getChildMatrix((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).getRegionBmp((Rect)localObject3, localMatrix, this.jdField_a_of_type_Axyv.getGallery().getWidth(), this.jdField_a_of_type_Axyv.getGallery().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = yak.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = yak.a(paramUri, this.mContext, 3, localSparseArray);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOPictureView.7(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.jdField_a_of_type_JavaLangString = paramUri.getPath();
        }
        anet.b(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "checkQQCode exception :" + localThrowable.getMessage());
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
  
  private void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject2 = new axyn();
    Object localObject1 = ((axyn)localObject2).a(paramAIOPictureData, 4);
    if (localObject1 == null) {
      localObject1 = ((axyn)localObject2).a(paramAIOPictureData, 2);
    }
    for (;;)
    {
      if ((localObject1 == null) && (axyd.a().a())) {
        return;
      }
      if (localObject1 != null) {
        this.jdField_b_of_type_JavaLangString = ((File)localObject1).getPath();
      }
      localObject2 = bhuf.c(this.mContext);
      if (abti.a(axyd.a().a()) != 1032)
      {
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (localObject1 != null)
        {
          if ((axyd.a().a() != 1037) && (abti.a(axyd.a().a()) != 1044)) {
            bdmp.a(2, (ArrayList)localObject2);
          }
          if ((axyd.a().a() != 1037) && (abti.a(axyd.a().a()) != 1044))
          {
            if (paramAIOPictureData.jdField_e_of_type_JavaLangString != null) {
              bdmp.a(50, (ArrayList)localObject2);
            }
            if ((this.jdField_a_of_type_Boolean) && (paramAIOPictureData.jdField_e_of_type_JavaLangString != null)) {
              bdmp.a(51, (ArrayList)localObject2);
            }
          }
          bdmp.a(27, (ArrayList)localObject2);
          if ((PicShareToWX.a().a()) && (PicShareToWX.a().a((File)localObject1))) {
            bdmp.a(9, (ArrayList)localObject2);
          }
          if (this.jdField_b_of_type_Boolean)
          {
            bdmp.a(48, localArrayList);
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          if (!asrc.a().a()) {
            bdmp.a(39, localArrayList);
          }
          if (!this.jdField_b_of_type_Boolean) {
            bdmp.a(6, localArrayList);
          }
          if ((axyd.a().a() != 1037) && (abti.a(axyd.a().a()) != 1044))
          {
            if ((axyd.a().g()) && (!TextUtils.isEmpty(axyd.a().c())) && (!axyd.a().c())) {
              bdmp.a(54, localArrayList);
            }
            if (this.jdField_c_of_type_Boolean) {
              bdmp.a(52, localArrayList);
            }
            ThreadManager.getFileThreadHandler().post(new AIOPictureView.3(this, (File)localObject1, localArrayList));
          }
          if ((paramAIOPictureData.jdField_g_of_type_Int == 4) && (!this.jdField_b_of_type_Boolean) && (!paramAIOPictureData.l)) {
            bdmp.a(66, localArrayList);
          }
          a(paramAIOPictureData, paramRichMediaBrowserInfo, (File)localObject1);
          if (this.mContext != null)
          {
            localObject1 = this.mContext.getIntent();
            if (!this.jdField_b_of_type_Boolean) {
              break label653;
            }
            paramAIOPictureData = "biz_src_jc_groupgif";
            label485:
            ((Intent)localObject1).putExtra("big_brother_source_key", paramAIOPictureData);
          }
          if ((axyd.a().a() != 1037) && (abti.a(axyd.a().a()) != 1044))
          {
            if (this.jdField_a_of_type_Axyv != null) {
              break label660;
            }
            paramAIOPictureData = null;
            label530:
            if (paramAIOPictureData == null) {
              break label676;
            }
            paramAIOPictureData.putExtra("key_new_img_shareactionsheet", 1);
            paramAIOPictureData.putExtra("k_dataline", true);
            this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOPictureData);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
          return;
          if ((axyd.a().c()) || (axyd.a().a() == 1037) || (!axyd.a().g()) || (TextUtils.isEmpty(axyd.a().c())) || (abti.a(axyd.a().a()) == 1044)) {
            break;
          }
          bdmp.a(54, localArrayList);
          break;
          label653:
          paramAIOPictureData = "biz_src_jc_photo";
          break label485;
          label660:
          paramAIOPictureData = this.jdField_a_of_type_Axyv.a(paramRichMediaBrowserInfo, this.mContext);
          break label530;
          label676:
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(null);
          QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
        }
      }
      if ((abti.a(axyd.a().a()) == 1032) && (localObject1 != null)) {
        ((bhuf)localObject2).b(2131693497);
      }
      ((bhuf)localObject2).c(2131692991);
      ((bhuf)localObject2).a(new ayaf(this, (bhuf)localObject2));
      ((bhuf)localObject2).show();
      ((bhuf)localObject2).a(this);
      return;
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      paramURLDrawable.setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Axyv.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      paramString = this.jdField_a_of_type_Axyv;
      axyv.updateRotation(this.galleryView, paramURLDrawable, paramRichMediaBrowserInfo.orientation);
      this.jdField_a_of_type_Axyv.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private boolean a(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage()");
    axyn localaxyn = new axyn();
    if (localaxyn.a(paramAIOPictureData, 8) != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      if ((paramAIOPictureData.jdField_d_of_type_Int == 1) && ((paramAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
      }
      Object localObject1 = null;
      try
      {
        localObject2 = URLDrawable.getDrawable(localaxyn.a(paramAIOPictureData, 8), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = localObject2;
        ((URLDrawable)localObject2).downloadImediatly();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): url is " + localaxyn.a(paramAIOPictureData, 8) + ", file type is " + 8);
      }
      if ((localObject1 != null) && (localObject1.getStatus() == 1))
      {
        localObject1.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(localObject1);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(bayu.a);
    return true;
  }
  
  private boolean b(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealThumbImage()");
    Object localObject2 = new axyn();
    if (((axyn)localObject2).a(paramAIOPictureData, 1) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = bayu.a;
      if ((paramAIOPictureData.jdField_d_of_type_Int == 1) && ((paramAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
      }
      localObject2 = ((axyn)localObject2).a(paramAIOPictureData, 1);
      paramAIOPictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOPictureData = (AIOPictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOPictureData = (AIOPictureData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOPictureData != null) && (paramAIOPictureData.getStatus() == 1))
      {
        paramAIOPictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean c(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    boolean bool = false;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    if ((paramAIOPictureData.jdField_f_of_type_Boolean) || (paramAIOPictureData.jdField_e_of_type_Boolean) || (paramAIOPictureData.jdField_d_of_type_Boolean))
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968));
      this.jdField_a_of_type_Axyv.onLoadFinish(this.jdField_a_of_type_Axyv.getSelectedIndex(), false);
      bool = true;
    }
    return bool;
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (new axyn().a((AIOPictureData)localObject, 4))
      {
        if (((AIOPictureData)localObject).jdField_c_of_type_Long <= 0L) {
          break label98;
        }
        a(String.format(Locale.CHINA, this.mContext.getString(2131695502), new Object[] { arso.a(((AIOPictureData)localObject).jdField_c_of_type_Long) }));
      }
    }
    return;
    label98:
    a(this.mContext.getString(2131695499));
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (!TextUtils.isEmpty(((AIOPictureData)localObject).o))
      {
        bnld.a(this.mContext, ((AIOPictureData)localObject).o);
        azqs.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", ((AIOPictureData)localObject).o, "");
      }
    }
  }
  
  public AIOPictureData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100)) {
      return (AIOPictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, GalleryUrlImageView paramGalleryUrlImageView)
  {
    if (((paramDrawable instanceof URLDrawable)) && (((URLDrawable)paramDrawable).isFakeSize()) && (paramURLDrawable == null))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getURL();
      if (("file".equals(paramDrawable.getProtocol())) && (paramDrawable.getRef() == null))
      {
        if ((paramInt != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label113;
        }
        paramDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "use exist raw drawable");
      }
    }
    while (paramDrawable.getStatus() == 1)
    {
      paramGalleryUrlImageView.setIgnoreLayout(true);
      paramGalleryUrlImageView.setImageDrawable(paramDrawable);
      paramGalleryUrlImageView.setIgnoreLayout(false);
      return;
      label113:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "rawDrawable is exist");
      paramDrawable = paramDrawable.toString() + "#" + "NOSAMPLE";
      paramURLDrawable = URLDrawable.URLDrawableOptions.obtain();
      paramURLDrawable.mUseExifOrientation = false;
      paramURLDrawable.mUseMemoryCache = false;
      paramDrawable = URLDrawable.getDrawable(paramDrawable, paramURLDrawable);
      paramDrawable.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramDrawable;
      this.jdField_b_of_type_Int = paramInt;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "create rawDrawable, position:" + paramInt);
    }
    paramGalleryUrlImageView.setDecodingDrawble(paramDrawable);
    paramDrawable.startDownload();
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(bdgm.a(this.mContext, 230, this.mContext.getString(2131719324), this.mContext.getString(2131719323), new ayak(this, paramInt, paramObject), new ayal(this)));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyv.getItem(paramInt);
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject1;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100) && (this.galleryView != null) && ((this.galleryView.getTag() instanceof ayam)))
    {
      localObject3 = ((ayam)this.galleryView.getTag()).a;
      localObject2 = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localObject4 = new axyn();
      if (!((AIOPictureData)localObject2).jdField_e_of_type_Boolean) {
        break label213;
      }
      localObject1 = ((GalleryUrlImageView)localObject3).getDrawable();
      if (!URLDrawable.class.isInstance(localObject1)) {
        break label727;
      }
      localObject1 = (URLDrawable)localObject1;
      localObject2 = ((URLDrawable)localObject1).getURL().getRef();
    }
    for (;;)
    {
      if ((localObject1 == null) || (localObject2 == null) || ((!"PART".equals(localObject2)) && (!"DISPLAY".equals(localObject2))))
      {
        ((GalleryUrlImageView)localObject3).setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968));
        this.jdField_a_of_type_Axyv.onLoadFinish(paramInt, false);
        this.jdField_a_of_type_Axyv.a().d();
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      return;
      label213:
      File localFile = ((axyn)localObject4).a((AIOPictureData)localObject2, 2);
      if (localFile != null)
      {
        localObject1 = ((axyn)localObject4).a((AIOPictureData)localObject2, 2);
        if (!paramBoolean) {
          break label724;
        }
        localObject1 = (String)localObject1 + "#PART";
      }
      label724:
      for (;;)
      {
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): read orientation:" + localRichMediaBrowserInfo.orientation);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (((AIOPictureData)localObject2).jdField_d_of_type_Int == 3)
          {
            localObject4 = ((axyn)localObject4).a((AIOPictureData)localObject2, 1);
            if (localObject4 != null)
            {
              localObject4 = URLDrawable.getDrawable((File)localObject4, null);
              if (((URLDrawable)localObject4).getStatus() == 1)
              {
                localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
                localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
              }
            }
          }
          localURLDrawableOptions.mUseExifOrientation = false;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject4 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
          ((URLDrawable)localObject4).setTag(Integer.valueOf(1));
          if ((((URLDrawable)localObject4).getStatus() == 1) && (!((AIOPictureData)localObject2).jdField_g_of_type_Boolean)) {
            if (localRichMediaBrowserInfo.orientation != -2) {}
          }
        }
        catch (Exception localException2)
        {
          try
          {
            localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
            ((GalleryUrlImageView)localObject3).setImageDrawable((Drawable)localObject4);
            this.jdField_a_of_type_Axyv.onLoadFinish(paramInt, true);
            localObject3 = this.jdField_a_of_type_Axyv;
            axyv.updateRotation(this.galleryView, (URLDrawable)localObject4, localRichMediaBrowserInfo.orientation);
            localObject3 = bdhb.b(((AIOPictureData)localObject2).jdField_b_of_type_JavaLangString);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + (String)localObject1 + ",extName = " + (String)localObject3);
            ((AIOPictureData)localObject2).jdField_g_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_Axyv.a().c();
            return;
            localException2 = localException2;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException2.getMessage());
          }
          catch (Exception localException1)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException1.getMessage());
            localRichMediaBrowserInfo.orientation = 1;
            continue;
          }
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "setDecodingDrawble");
          ((URLDrawable)localObject4).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject4).startDownload();
          ((GalleryUrlImageView)localObject3).setDecodingDrawble((URLDrawable)localObject4);
          continue;
        }
        if (((axyn)localObject4).a((AIOPictureData)localObject2, 1) == null) {
          break;
        }
        ((GalleryUrlImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((axyn)localObject4).a((AIOPictureData)localObject2, 1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label727:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool) {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 24);
      }
      return;
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void a(ayan paramayan)
  {
    this.jdField_a_of_type_Ayan = paramayan;
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_Axyv.mActiveDrawable.get(Integer.valueOf(paramInt)) != null) {
      this.jdField_a_of_type_Axyv.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new ayag(this, paramAIOPictureData, paramRichMediaBrowserInfo, paramFile));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new ayaj(this));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void ap_()
  {
    this.jdField_a_of_type_Axyv.updateSystemUIVisablity();
  }
  
  public boolean b()
  {
    Object localObject;
    if (super.b())
    {
      localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
      {
        AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        axyn localaxyn = new axyn();
        localObject = localaxyn.a(localAIOPictureData, 4);
        if (localObject != null) {
          break label109;
        }
        localObject = localaxyn.a(localAIOPictureData, 2);
      }
    }
    label109:
    for (;;)
    {
      if ((localObject == null) && (axyd.a().a())) {
        return false;
      }
      return (!axyd.a().a()) && (!axyd.a().c());
    }
  }
  
  public boolean back()
  {
    Object localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (((AIOPictureData)localObject).status == 2)
      {
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 4);
        }
        this.jdField_a_of_type_Axyv.a(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 0);
      }
    }
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
    a(new ayab(this));
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    paramIntent = paramIntent.getExtras();
    this.jdField_a_of_type_Boolean = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_a_of_type_Int = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_b_of_type_Boolean = paramIntent.getBoolean("group.emo.big.preview", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (axyd.a().c() == 3) || (axyd.a().c() == 2) || (axyd.a().c() == 6)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.mContext.getIntent().getExtras();
      if (((i == 0) && ((axyd.a().c() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (abti.a(axyd.a().a()) == 1032) || (abti.a(axyd.a().a()) == 1044) || (axyd.a().a() == 1037)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void clearTheOuchCache()
  {
    this.jdField_a_of_type_Axyv.mActiveDrawable.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (this.jdField_a_of_type_Axyv.c())
    {
      this.jdField_a_of_type_Axyv.a().jdField_a_of_type_Boolean = false;
      return;
    }
    showContentView(false);
    this.jdField_a_of_type_Axyv.a().g();
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
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
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
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559118, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.contentView.findViewById(2131376112));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131372360));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.contentView.findViewById(2131364340));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.contentView.findViewById(2131376330));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131365979));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.contentView.findViewById(2131369786));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.contentView.findViewById(2131363905));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131363906));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373508));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373512));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373510));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131373515));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373511));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (bnle.b())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = bnle.jdField_a_of_type_Int;
      }
      c(a(this.jdField_a_of_type_Axyv.getSelectedItem()));
      f(c());
      b(b());
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
  }
  
  @RequiresApi(api=4)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof ayam)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      localGalleryUrlImageView = ((ayam)paramView.getTag()).a;
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    for (;;)
    {
      g();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localRichMediaBrowserInfo = this.jdField_a_of_type_Axyv.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
        break;
      }
      return localGalleryUrlImageView;
      this.galleryView = new RelativeLayout(this.mContext);
      this.galleryView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localGalleryUrlImageView = new GalleryUrlImageView(this.mContext);
      localGalleryUrlImageView.setId(2131367921);
      localGalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      this.galleryView.addView(localGalleryUrlImageView, paramView);
    }
    AIOPictureData localAIOPictureData;
    Object localObject2;
    if (localRichMediaBrowserInfo.baseData.getType() == 100)
    {
      localAIOPictureData = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localObject2 = new axyn();
      paramView = this.jdField_a_of_type_Axyv.a();
      if ((paramView != null) && ((paramView.baseData instanceof AIOPictureData)))
      {
        paramViewGroup = (AIOPictureData)paramView.baseData;
        if ((paramViewGroup.getType() != 100) || (paramViewGroup.jdField_a_of_type_Long != localAIOPictureData.jdField_a_of_type_Long) || (paramViewGroup.jdField_a_of_type_Int != localAIOPictureData.jdField_a_of_type_Int) || (paramView.isReport)) {
          break label800;
        }
        azqs.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
        paramView.isReport = true;
      }
    }
    boolean bool2;
    boolean bool1;
    Object localObject1;
    for (;;)
    {
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localRichMediaBrowserInfo);
      localGalleryUrlImageView.setIgnoreLayout(false);
      localGalleryUrlImageView.setContentDescription(this.mContext.getString(2131691665));
      bool2 = false;
      bool1 = false;
      localObject1 = null;
      paramView = null;
      paramViewGroup = (URLDrawable)this.jdField_a_of_type_Axyv.mActiveDrawable.get(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
      {
        localGalleryUrlImageView.setImageDrawable(paramViewGroup);
        paramView = ((axyn)localObject2).a(localAIOPictureData, 4);
        localObject1 = paramViewGroup.getURL().toString();
        if (((String)localObject1).equals(paramView)) {
          localGalleryUrlImageView.setOriginalImage(true);
        }
        if (localRichMediaBrowserInfo.orientation == -2) {}
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramViewGroup.getURL().getFile());
          paramView = this.jdField_a_of_type_Axyv;
          axyv.updateRotation(this.galleryView, paramViewGroup, localRichMediaBrowserInfo.orientation);
          if (localGalleryUrlImageView.isOriginalImage())
          {
            paramView = localAIOPictureData.jdField_c_of_type_JavaLangString;
            paramView = bdhb.b(paramView);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): cache url is " + (String)localObject1 + ", cache type is " + ((axyn)localObject2).a(localAIOPictureData, paramViewGroup.getURL().getFile()) + ",extName = + " + paramView);
            if ((localAIOPictureData.jdField_g_of_type_Boolean) && (RichMediaBrowserManager.getInstance().getProvider() != null)) {
              RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
            }
            bool1 = true;
            if (!localGalleryUrlImageView.isOriginalImage()) {
              break label892;
            }
            paramView = "original";
            paramInt = 1;
            if (paramInt != 0)
            {
              paramInt = localRichMediaBrowserInfo.hashCode();
              this.jdField_a_of_type_Axyv.a(paramInt);
              paramViewGroup = this.jdField_a_of_type_Axyv.a();
              paramViewGroup.a(paramInt);
              paramViewGroup.a(paramInt, localAIOPictureData.jdField_e_of_type_Long, localAIOPictureData.jdField_f_of_type_Long);
              paramViewGroup.b(paramInt, biqe.a(localAIOPictureData.jdField_c_of_type_Int));
              if (localAIOPictureData.h) {
                paramViewGroup.d(paramInt);
              }
              if (paramView != null)
              {
                paramViewGroup.a(paramInt, paramView);
                paramViewGroup.a(paramInt, bool1);
              }
            }
            paramView = localAIOPictureData.jdField_a_of_type_Long + "_" + localAIOPictureData.jdField_a_of_type_Int;
            if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramView)) && (RichMediaBrowserManager.getInstance().getProvider() != null))
            {
              RichMediaBrowserManager.getInstance().getProvider().payFlow(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int);
              this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
            }
            paramView = new ayam(this);
            paramView.a = localGalleryUrlImageView;
            this.galleryView.setTag(paramView);
            return this.galleryView;
            label800:
            azqs.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + paramView.getMessage());
            localRichMediaBrowserInfo.orientation = 0;
            continue;
            paramView = localAIOPictureData.jdField_b_of_type_JavaLangString;
            continue;
            label892:
            paramView = "large";
          }
        }
      }
    }
    Object localObject3 = ((axyn)localObject2).a(localAIOPictureData, 4);
    int i;
    if (localObject3 != null)
    {
      if (localObject3 != null)
      {
        i = 1;
        label922:
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = this.mScreenWidthPx;
        paramViewGroup.mRequestHeight = this.mScreenHeightPx;
        if (((axyn)localObject2).a(localAIOPictureData, 1) == null) {
          break label1175;
        }
        paramView = URLDrawable.getFileDrawable(localAIOPictureData.jdField_a_of_type_JavaLangString, null);
        paramView.downloadImediatly();
        paramViewGroup.mLoadingDrawable = paramView;
        label972:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "TYPE_ORIGINAL_IMAGE");
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mDecodeFileStrategy = 2;
        if ((localAIOPictureData.jdField_d_of_type_Int == 1) && ((localAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
          paramViewGroup.mUseAutoScaleParams = false;
        }
        paramView = null;
        localObject1 = ((axyn)localObject2).a(localAIOPictureData, 4);
      }
      try
      {
        paramViewGroup = URLDrawable.getDrawable((String)localObject1, paramViewGroup);
        paramView = paramViewGroup;
        paramViewGroup.setTag(Integer.valueOf(1));
        paramView = paramViewGroup;
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
          continue;
          bool1 = false;
          continue;
          paramView = "large";
        }
      }
      paramViewGroup = ((File)localObject3).getAbsolutePath();
      localGalleryUrlImageView.setGalleryImageListener(new ayad(this, localRichMediaBrowserInfo, paramViewGroup, paramView, localAIOPictureData, localGalleryUrlImageView));
      this.jdField_a_of_type_JavaLangRunnable = aepi.a(this.jdField_b_of_type_AndroidWidgetImageView, paramView);
      if ((this.jdField_a_of_type_JavaLangRunnable == null) && (paramView.getStatus() == 1)) {
        a(localRichMediaBrowserInfo, paramViewGroup, paramView, paramInt);
      }
      localGalleryUrlImageView.setImageDrawable(paramView);
      if (!paramView.isDownloadStarted()) {
        break label1917;
      }
      if (BaseApplicationImpl.sImageCache.get(paramView.getURL().toString()) != null)
      {
        bool1 = true;
        if (i == 0) {
          break label1212;
        }
        paramView = "original";
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramInt = 1;
        break;
        i = 0;
        break label922;
        label1175:
        paramViewGroup.mLoadingDrawable = bayu.a;
        break label972;
        label1212:
        File localFile = ((axyn)localObject2).a(localAIOPictureData, 2);
        if (localFile != null)
        {
          if (localObject3 != null)
          {
            i = 1;
            label1242:
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.mScreenWidthPx;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.mScreenHeightPx;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bayu.a;
            ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
            ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
            ((URLDrawable.URLDrawableOptions)localObject3).mDecodeFileStrategy = 2;
            if ((localAIOPictureData.jdField_d_of_type_Int == 1) && ((localAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
            }
            paramViewGroup = null;
            if (i == 0) {
              break label1507;
            }
            paramView = ((axyn)localObject2).a(localAIOPictureData, 4);
          }
          try
          {
            paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject3);
            paramViewGroup = paramView;
            paramView.setTag(Integer.valueOf(1));
            paramViewGroup = paramView;
            paramView.downloadImediatly();
            paramViewGroup = paramView;
            paramView = (View)localObject1;
            bool1 = bool2;
            if (paramViewGroup != null)
            {
              paramView = (View)localObject1;
              bool1 = bool2;
              if (paramViewGroup.isDownloadStarted())
              {
                if (BaseApplicationImpl.sImageCache.get(paramViewGroup.getURL().toString()) == null) {
                  break label1574;
                }
                bool1 = true;
                if (i == 0) {
                  break label1580;
                }
                paramView = "original";
              }
            }
            if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1)) {
              if (localRichMediaBrowserInfo.orientation != -2) {}
            }
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              try
              {
                localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
                this.jdField_a_of_type_Axyv.mActiveDrawable.put(Integer.valueOf(paramInt), paramViewGroup);
                localObject1 = this.jdField_a_of_type_Axyv;
                axyv.updateRotation(this.galleryView, paramViewGroup, localRichMediaBrowserInfo.orientation);
                localGalleryUrlImageView.setImageDrawable(paramViewGroup);
                this.jdField_a_of_type_Axyv.onLoadFinish(paramInt, true);
                paramInt = 1;
                break;
                i = 0;
                break label1242;
                label1507:
                localObject2 = ((axyn)localObject2).a(localAIOPictureData, 2);
                paramView = (View)localObject2;
                if (!localAIOPictureData.jdField_g_of_type_Boolean) {
                  continue;
                }
                paramView = (String)localObject2 + "#PART";
                continue;
                paramView = paramView;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
                continue;
                label1574:
                bool1 = false;
                continue;
                label1580:
                paramView = "large";
              }
              catch (Exception localException)
              {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException.getMessage());
                localRichMediaBrowserInfo.orientation = 1;
                continue;
              }
              if ((!a(localAIOPictureData, localGalleryUrlImageView)) && (!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
                a(localGalleryUrlImageView);
              }
              a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
            }
          }
        }
      }
      if (((axyn)localObject2).a(localAIOPictureData, 8) != null)
      {
        if ((!a(localAIOPictureData, localGalleryUrlImageView)) && (!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
        paramInt = 1;
        break;
      }
      if (((axyn)localObject2).a(localAIOPictureData, 1) != null)
      {
        if ((!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
        paramInt = 1;
        break;
      }
      if ((localAIOPictureData.jdField_f_of_type_Boolean) || (localAIOPictureData.jdField_e_of_type_Boolean) || (localAIOPictureData.jdField_d_of_type_Boolean))
      {
        if (c(localAIOPictureData, localGalleryUrlImageView)) {
          break label1912;
        }
        a(localGalleryUrlImageView);
        paramInt = 0;
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
      a(localGalleryUrlImageView);
      a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
      label1912:
      paramInt = 0;
      break;
      label1917:
      paramView = null;
      bool1 = false;
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Axyv.a(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 2);
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 4);
      updateUI();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_Axyv.getSelectedItem();
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            i = j;
            if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100)
            {
              i = j;
              if (!axyd.a().f())
              {
                i = j;
                if (!axyd.a().c())
                {
                  i = j;
                  if (axpm.a())
                  {
                    i = j;
                    if (ShortVideoUtils.g())
                    {
                      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
                      long l = localAIOPictureData.jdField_a_of_type_Long;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOPictureData.o))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.mContext.getString(2131692983);
                        if (!TextUtils.isEmpty(localAIOPictureData.p)) {
                          localObject = localAIOPictureData.p;
                        }
                        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        if (this.jdField_a_of_type_Long != l)
                        {
                          azqs.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", localAIOPictureData.o, "");
                          this.jdField_a_of_type_Long = l;
                        }
                        i = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  void i()
  {
    Object localObject1 = this.jdField_a_of_type_Axyv.getSelectedItem();
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
      axyn localaxyn = new axyn();
      localObject2 = localaxyn.a(localAIOPictureData, 4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaxyn.a(localAIOPictureData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localaxyn.a(localAIOPictureData, 1);
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
    switch (axyd.a().c())
    {
    default: 
      j = 0;
      bool = false;
      k = 0;
      localObject1 = EditPicActivity.a(this.mContext, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
      ((Intent)localObject1).putExtra("uintype", axyd.a().a());
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
      }
      if (j != 0) {
        ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if (k != 0) {
        this.mContext.startActivityForResult((Intent)localObject1, k);
      }
      break;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
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
  
  public void notifyImageModelDataChanged()
  {
    super.notifyImageModelDataChanged();
    clearTheOuchCache();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370086: 
    case 2131364340: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_Axyv.getSelectedItem();
        } while ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 100) || (((AIOPictureData)paramView.baseData).jdField_d_of_type_Int != 3));
        this.jdField_a_of_type_Axyv.back();
        return;
        paramView = this.jdField_a_of_type_Axyv.getSelectedItem();
      } while ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 100));
      paramView = (AIOPictureData)paramView.baseData;
      switch (paramView.status)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_Axyv.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
        updateUI();
        return;
        if (RichMediaBrowserManager.getInstance().getProvider() != null)
        {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 4);
          continue;
          if (RichMediaBrowserManager.getInstance().getProvider() != null)
          {
            RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 2);
            continue;
            if (RichMediaBrowserManager.getInstance().getProvider() != null) {
              RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 24);
            }
          }
        }
      }
    case 2131373511: 
      d();
      return;
    case 2131373515: 
      h();
      return;
    case 2131373512: 
      i();
      this.jdField_a_of_type_Axyv.f();
      return;
    case 2131373510: 
      c();
      return;
    case 2131373508: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
      }
      paramView = this.jdField_a_of_type_Axyv.getSelectedItem();
      if ((paramView != null) && (paramView.baseData != null)) {
        MiniChatActivity.a(this.mContext, axyd.a().a(), axyd.a().a(), false, 26, ((AIOPictureData)paramView.baseData).jdField_d_of_type_Long, 0L);
      }
      this.jdField_a_of_type_Axyv.j();
      return;
    }
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      paramView = (AIOGalleryActivity)this.mContext;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!amrk.a(this.mContext))
        {
          paramView.requestPermissions(new ayae(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        k();
        return;
      }
      k();
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "onClick, activity:" + this.mContext);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    clearTheOuchCache();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject = (URLDrawable)this.jdField_a_of_type_Axyv.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    while ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return null;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    axyn localaxyn = new axyn();
    localObject = localaxyn.a(localAIOPictureData, 4);
    if (localObject == null)
    {
      paramRichMediaBrowserInfo = localaxyn.a(localAIOPictureData, 2);
      if (paramRichMediaBrowserInfo == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = 1;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
        if ((localAIOPictureData.jdField_d_of_type_Int == 1) && ((localAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!localAIOPictureData.jdField_g_of_type_Boolean)) {
          break label261;
        }
      }
      label261:
      for (paramRichMediaBrowserInfo = URLDrawable.getDrawable(localaxyn.a(localAIOPictureData, 2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject);; paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject))
      {
        paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
        paramRichMediaBrowserInfo.startDownload();
        this.jdField_a_of_type_Axyv.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
        return null;
        i = 0;
        break;
      }
      if ((localAIOPictureData.jdField_f_of_type_Boolean) || (localAIOPictureData.jdField_e_of_type_Boolean) || (localAIOPictureData.jdField_d_of_type_Boolean)) {
        break;
      }
      if (localaxyn.a(localAIOPictureData, 1) != null)
      {
        paramRichMediaBrowserInfo = URLDrawable.URLDrawableOptions.obtain();
        paramRichMediaBrowserInfo.mLoadingDrawable = bayu.a;
        paramRichMediaBrowserInfo.mFailedDrawable = bayu.a;
        if ((localAIOPictureData.jdField_d_of_type_Int == 1) && ((localAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
          paramRichMediaBrowserInfo.mUseAutoScaleParams = false;
        }
        URLDrawable.getDrawable(localaxyn.a(localAIOPictureData, 1), paramRichMediaBrowserInfo).startDownload();
        if ((!bdin.h(this.mContext)) || (biqe.a(localAIOPictureData.jdField_c_of_type_Int)) || (RichMediaBrowserManager.getInstance().getProvider() == null)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
        return null;
      }
      if ((!bdin.h(this.mContext)) || (biqe.a(localAIOPictureData.jdField_c_of_type_Int)) || (RichMediaBrowserManager.getInstance().getProvider() == null)) {
        break;
      }
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return null;
      paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearTheOuchCache();
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_Axyv.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_Axyv.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
    if (paramInt == this.jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_b_of_type_Int = -1;
    }
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
    h(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Axyv.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof ayam)))
    {
      paramAdapterView = (ayam)paramView.getTag();
      if (paramAdapterView.a != null)
      {
        paramView = paramAdapterView.a;
        paramAdapterView = paramView.getDrawable();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyv.getSelectedItem();
        if ((!paramView.isOriginalImage()) && (localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100))
        {
          paramView = (AIOPictureData)localRichMediaBrowserInfo.baseData;
          if (((paramAdapterView instanceof SkinnableBitmapDrawable)) && (paramView.jdField_b_of_type_Int == 1) && (paramView.jdField_c_of_type_Long > arbp.c()) && (this.jdField_a_of_type_Axyv.getGallery() != null))
          {
            this.jdField_a_of_type_Axyv.getGallery().enableDoubleTap(false);
            this.jdField_a_of_type_Axyv.getGallery().enableScaleGesture(false);
          }
        }
      }
      updateUI();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ayam)))
    {
      paramView = ((ayam)paramView.getTag()).a.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_b_of_type_Int = -1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "destory rawDrawable, position: " + paramInt);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof ayam)))
    {
      paramView = ((ayam)paramView.getTag()).a.getDrawable();
      if ((paramRichMediaBrowserInfo != null) && ((paramView instanceof URLDrawable)) && (this.jdField_a_of_type_Axyv.a() != null)) {
        this.jdField_a_of_type_Axyv.a().b(paramRichMediaBrowserInfo.hashCode());
      }
    }
    if (this.jdField_a_of_type_Axyv.a() != null) {
      this.jdField_a_of_type_Axyv.a().a();
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ayam)))
    {
      paramView = ((ayam)paramView.getTag()).a;
      paramViewGroup = paramView.getDrawable();
      URLDrawable localURLDrawable = paramView.mDecoding;
      if (((paramViewGroup instanceof URLDrawable)) && (((URLDrawable)paramViewGroup).isFakeSize()) && (localURLDrawable == null)) {
        a(paramInt, paramViewGroup, localURLDrawable, paramView);
      }
    }
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyv.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100))
    {
      a((AIOPictureData)localRichMediaBrowserInfo.baseData, localRichMediaBrowserInfo);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "showActionSheet, from:" + paramInt);
    }
  }
  
  public void updateUI()
  {
    super.updateUI();
    AIOPictureData localAIOPictureData = a();
    if (localAIOPictureData != null) {}
    switch (localAIOPictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "updateUI status is error, status = " + localAIOPictureData.status);
      return;
    case 1: 
      e(false);
      b(false);
      f(false);
      this.jdField_a_of_type_Axyv.onLoadStart(this.jdField_a_of_type_Axyv.getSelectedIndex(), localAIOPictureData.progress);
      return;
    case 2: 
      this.jdField_a_of_type_Axyv.onLoadFinish(this.jdField_a_of_type_Axyv.getSelectedIndex(), true);
      e(false);
      b(false);
      c(false);
      f(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700434) + localAIOPictureData.progress / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    case 3: 
      this.jdField_a_of_type_Axyv.onLoadFinish(this.jdField_a_of_type_Axyv.getSelectedIndex(), true);
      e(false);
      b(false);
      c(false);
      f(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700418) + localAIOPictureData.progress / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Axyv.onLoadFinish(this.jdField_a_of_type_Axyv.getSelectedIndex(), true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    b(b());
    c(a(this.jdField_a_of_type_Axyv.getSelectedItem()));
    f(c());
    h(true);
    axyn localaxyn = new axyn();
    if ((localaxyn.a(localAIOPictureData, 2) != null) || (localaxyn.a(localAIOPictureData, 4) != null)) {
      g(true);
    }
    while ((localaxyn.a(localAIOPictureData, 4)) && (localaxyn.a(localAIOPictureData, 4) == null))
    {
      e(true);
      return;
      g(false);
    }
    e(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayaa
 * JD-Core Version:    0.7.0.1
 */