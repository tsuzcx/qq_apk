import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bajo
  extends bajk
{
  public bakr a;
  public MqqHandler a;
  
  public bajo()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bajp(this);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Bakr != null) && (this.jdField_a_of_type_Bakr.a != null)) {
      return this.jdField_a_of_type_Bakr.a.getCurPlayingPos();
    }
    return 0L;
  }
  
  public Intent a(AIOFileVideoData paramAIOFileVideoData, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramAIOFileVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 0);
      if (localIntent != null)
      {
        if (paramAIOFileVideoData.b == 1) {}
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
  
  public AIOFileVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).h = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localAIOFileVideoData.g = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)) && (((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Bakr.updateUI();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    AIOFileVideoData localAIOFileVideoData;
    if ((paramInt2 == 269484034) && (localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish:" + paramLong);
      if (paramInt3 == 1)
      {
        if (!TextUtils.isEmpty(paramString)) {
          localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramString;
        }
        localAIOFileVideoData.f = true;
        localAIOFileVideoData.h = false;
        if (!localAIOFileVideoData.j) {
          break label274;
        }
        localAIOFileVideoData.status = 6;
        label131:
        paramBoolean = localAIOFileVideoData.j;
        localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
        updateItem(localRichMediaBrowserInfo);
      }
    }
    for (;;)
    {
      if (paramInt2 == 269484034)
      {
        paramString = getSelectedItem();
        if ((paramString != null) && ((paramString.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)paramString.baseData).jdField_a_of_type_Long == paramLong)) {
          if (paramBoolean)
          {
            if (paramInt3 != 1) {
              break label283;
            }
            QQToast.a(this.jdField_a_of_type_Bakr.mContext, 2, this.jdField_a_of_type_Bakr.mContext.getString(2131717775), 0).a();
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Bakr.updateUI();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish set playing!");
        return;
        if (paramInt3 != 2) {
          break;
        }
        localAIOFileVideoData.f = false;
        break;
        label274:
        localAIOFileVideoData.status = 5;
        break label131;
        label283:
        if (paramInt3 == 2) {
          QQToast.a(this.jdField_a_of_type_Bakr.mContext, 1, this.jdField_a_of_type_Bakr.mContext.getString(2131717790), 0).a();
        }
      }
      paramBoolean = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bakr.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleUnDownloadVideo failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.jdField_a_of_type_Long, 11, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.a != null) && (this.jdField_a_of_type_Bajl.a() != null))
    {
      boolean bool = false;
      AIOFileVideoData localAIOFileVideoData = a();
      if (localAIOFileVideoData != null) {
        bool = FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString);
      }
      if (bool)
      {
        if (!LiuHaiUtils.b()) {
          break label117;
        }
        this.jdField_a_of_type_Bajl.a().a((int)AIOUtils.px2dp(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_Bakr.mContext.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bajl.a().c();
      this.jdField_a_of_type_Bajl.a().e();
      this.jdField_a_of_type_Bajl.a.a();
      return;
      label117:
      this.jdField_a_of_type_Bajl.a().a(46);
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
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).i = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "cancelDownload failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.jdField_a_of_type_Long, 12, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenterXOXO", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + appl.b());
    }
    return appl.b();
  }
  
  public boolean b(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).h;
    }
    return false;
  }
  
  public void c(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.jdField_a_of_type_Long, 10, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void d(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.jdField_a_of_type_Long, 14, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof bakr)) {
      this.jdField_a_of_type_Bakr = ((bakr)paramBrowserBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajo
 * JD-Core Version:    0.7.0.1
 */