import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.concurrent.ConcurrentHashMap;

public class bajm
  extends bajk
{
  public bakl a;
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject;
    String str;
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null))
    {
      if (paramInt3 == 1)
      {
        localObject = paramString;
        a(paramLong, paramInt1, paramInt2, (String)localObject);
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label424;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      str = new baje().a((AIOFilePictureData)paramRichMediaBrowserInfo.baseData, 20);
      if (!TextUtils.isEmpty(str)) {
        break label159;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
    }
    label159:
    do
    {
      return;
      localObject = "I:E";
      break;
      paramString = null;
      URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).c, null);
      if (localURLDrawable != null)
      {
        localURLDrawable.downloadImediatly();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
      }
      for (;;)
      {
        try
        {
          localObject = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
          paramString = (String)localObject;
          ((URLDrawable)localObject).setTag(Integer.valueOf(1));
          paramString = (String)localObject;
        }
        catch (Throwable localThrowable)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + localThrowable.getMessage());
          continue;
          GalleryUrlImageView localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Bakl.mBrowserItemView.findViewById(2131368344);
          if (localGalleryUrlImageView == null) {
            break label399;
          }
          localGalleryUrlImageView.setGalleryImageListener(new bajn(this, paramString, paramRichMediaBrowserInfo));
          localGalleryUrlImageView.setImageDrawable(paramString);
          this.jdField_a_of_type_Bakl.a = AIOUtils.showDelayView(this.jdField_a_of_type_Bakl.b, paramString);
        }
        if (paramString != null) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_Bakl.mContext, this.jdField_a_of_type_Bakl.mContext.getString(2131694569), 0).a();
        return;
        localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).jdField_b_of_type_JavaLangString, null);
        if (localURLDrawable != null)
        {
          localURLDrawable.downloadImediatly();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
        }
      }
    } while (a().a);
    label399:
    a().b();
    a().a();
    return;
    label424:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_Bakl.mContext.getString(2131692520).equals(paramString)) {
        break label480;
      }
      QQToast.a(this.jdField_a_of_type_Bakl.mContext, paramString, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bakl.f(true);
      return;
      label480:
      QQToast.a(this.jdField_a_of_type_Bakl.mContext, this.jdField_a_of_type_Bakl.mContext.getString(2131694569), 0).a();
    }
  }
  
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
          bakc.a(paramActivity, localIntent, bool);
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
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      if ((this.jdField_a_of_type_Bakl != null) && (paramInt == getCurrentPosition())) {
        this.jdField_a_of_type_Bakl.bindView(paramInt);
      }
    }
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
        this.jdField_a_of_type_Bakl.updateUI();
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
        break label250;
      }
      if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null))
      {
        if (paramInt3 != 1) {
          break label243;
        }
        localObject1 = paramString;
        paramInt1 = a(paramLong, paramInt1, paramInt2, (String)localObject1);
        if ((paramInt3 == 2) && (!TextUtils.isEmpty(paramString))) {
          new baje().b((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData, paramInt2, paramString);
        }
        this.jdField_a_of_type_Bakl.updateView(paramInt1, this.jdField_a_of_type_Bakl.mBrowserItemView, paramBoolean);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + paramInt1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bakl.updateUI();
      return;
      label243:
      localObject1 = "I:E";
      break;
      label250:
      if (paramInt2 == 20) {
        a(paramLong, paramInt1, paramInt2, paramInt3, paramString, (RichMediaBrowserInfo)localObject2);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.a != null) && (this.jdField_a_of_type_Bajl.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (!LiuHaiUtils.b()) {
        break label101;
      }
      this.jdField_a_of_type_Bajl.a().a((int)AIOUtils.px2dp(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_Bakl.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bajl.a().c();
      this.jdField_a_of_type_Bajl.a().e();
      this.jdField_a_of_type_Bajl.a.a();
      return;
      label101:
      this.jdField_a_of_type_Bajl.a().a(40);
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
      QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + appl.a());
    }
    return appl.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bakl.a != null) {
      this.jdField_a_of_type_Bakl.b.removeCallbacks(this.jdField_a_of_type_Bakl.a);
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof bakl)) {
      this.jdField_a_of_type_Bakl = ((bakl)paramBrowserBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajm
 * JD-Core Version:    0.7.0.1
 */