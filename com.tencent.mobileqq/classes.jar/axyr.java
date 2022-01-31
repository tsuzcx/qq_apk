import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.util.concurrent.ConcurrentHashMap;

public class axyr
  extends axyp
{
  public axzp a;
  
  public Intent a(AIOFilePictureData paramAIOFilePictureData, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramAIOFilePictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOFilePictureData.jdField_a_of_type_Long, paramAIOFilePictureData.jdField_a_of_type_Int, 0);
      if (localIntent != null)
      {
        if (paramAIOFilePictureData.jdField_b_of_type_Int == 1) {}
        for (;;)
        {
          axzg.a(paramActivity, localIntent, bool);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
          return localIntent;
          bool = false;
        }
      }
    }
    return null;
  }
  
  public AIOFilePictureData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFilePictureData)) && (localRichMediaBrowserInfo.baseData.getType() == 102)) {
      return (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    AIOFilePictureData localAIOFilePictureData;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 102))
    {
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      int i = 0;
      paramInt1 = i;
      switch (paramInt2)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      localAIOFilePictureData.status = paramInt1;
      localAIOFilePictureData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOFilePictureData;
      updateItem(localRichMediaBrowserInfo);
      localRichMediaBrowserInfo = getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
        this.jdField_a_of_type_Axzp.updateUI();
      }
      return;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1 = a(paramLong);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102))
    {
      localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOFilePictureData)localObject2).status = 0;
      ((AIOFilePictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      updateItem((RichMediaBrowserInfo)localObject1);
    }
    Object localObject2 = getSelectedItem();
    if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long == paramLong))
    {
      if (paramInt2 != 18) {
        break label249;
      }
      if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null))
      {
        if (paramInt3 != 1) {
          break label242;
        }
        localObject1 = paramString;
        paramInt1 = a(paramLong, paramInt1, paramInt2, (String)localObject1);
        if ((paramInt3 == 2) && (!TextUtils.isEmpty(paramString))) {
          new axyj().b((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData, paramInt2, paramString);
        }
        this.jdField_a_of_type_Axzp.updateView(paramInt1, this.jdField_a_of_type_Axzp.galleryView, paramBoolean);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + paramInt1);
      }
    }
    label408:
    for (;;)
    {
      this.jdField_a_of_type_Axzp.updateUI();
      return;
      label242:
      localObject1 = "I:E";
      break;
      label249:
      if (paramInt2 == 20)
      {
        if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
          if (paramInt3 != 1) {
            break label408;
          }
        }
        String str;
        for (localObject1 = paramString;; localObject1 = "I:E")
        {
          a(paramLong, paramInt1, paramInt2, (String)localObject1);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
          if (paramInt3 != 1) {
            break label669;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          str = new axyj().a((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData, 20);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
          return;
        }
        paramString = null;
        URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData).c, null);
        if (localURLDrawable != null)
        {
          localURLDrawable.downloadImediatly();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
        }
        for (;;)
        {
          try
          {
            localObject1 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1);
            paramString = (String)localObject1;
          }
          catch (Throwable localThrowable)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + localThrowable.getMessage());
            continue;
            GalleryUrlImageView localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Axzp.galleryView.findViewById(2131367921);
            if (localGalleryUrlImageView == null) {
              break label642;
            }
            localGalleryUrlImageView.setGalleryImageListener(new axys(this, paramString, (RichMediaBrowserInfo)localObject2));
            localGalleryUrlImageView.setImageDrawable(paramString);
            this.jdField_a_of_type_Axzp.a = aepi.a(this.jdField_a_of_type_Axzp.b, paramString);
          }
          if (paramString != null) {
            continue;
          }
          QQToast.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_Axzp.mContext.getString(2131695501), 0).a();
          return;
          localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData).jdField_b_of_type_JavaLangString, null);
          if (localURLDrawable != null)
          {
            localURLDrawable.downloadImediatly();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
          }
        }
        if (!a().a)
        {
          a().b();
          a().a();
        }
      }
    }
    label642:
    label669:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_Axzp.mContext.getString(2131692941).equals(paramString)) {
        break label729;
      }
      QQToast.a(this.jdField_a_of_type_Axzp.mContext, paramString, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Axzp.e(true);
      break;
      label729:
      QQToast.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_Axzp.mContext.getString(2131695501), 0).a();
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Axzp != null))
    {
      if (getGallery() != null) {
        this.mActiveDrawable.put(Integer.valueOf(getGallery().getSelectedItemPosition()), paramURLDrawable);
      }
      notifyDataSetChanged();
      if (getGallery() != null) {
        getGallery().reset();
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.a != null) && (this.jdField_a_of_type_Axyq.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (!bnle.b()) {
        break label101;
      }
      this.jdField_a_of_type_Axyq.a().a((int)aepi.a(bnle.jdField_a_of_type_Int, this.jdField_a_of_type_Axzp.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axyq.a().c();
      this.jdField_a_of_type_Axyq.a().e();
      this.jdField_a_of_type_Axyq.a.a();
      return;
      label101:
      this.jdField_a_of_type_Axyq.a().a(40);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.mActiveDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + aogp.e());
    }
    return aogp.e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Axzp.a != null) {
      this.jdField_a_of_type_Axzp.b.removeCallbacks(this.jdField_a_of_type_Axzp.a);
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof axzp)) {
      this.jdField_a_of_type_Axzp = ((axzp)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyr
 * JD-Core Version:    0.7.0.1
 */