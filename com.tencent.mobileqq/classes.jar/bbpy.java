import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bbpy
  extends bbpp
  implements INetInfoHandler
{
  private bbrp a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  
  public bbpy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bbpz(this);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    ascz localascz = new ascz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localascz, localascz);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localascz;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    return ((paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileStatus == paramInt1) && (paramInt2 - paramInt3 < 10);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Bbrp != null) && (this.jdField_a_of_type_Bbrp.a != null)) {
      return this.jdField_a_of_type_Bbrp.a.getCurPlayingPos();
    }
    return 0L;
  }
  
  public long a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Long;
    }
    return 0L;
  }
  
  public akss a(AIOVideoData paramAIOVideoData)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    Object localObject = new File(paramAIOVideoData.b);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (paramAIOVideoData.d == 1) {
        bool = false;
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      if (bool)
      {
        localObject = bbqj.a().a(paramAIOVideoData.jdField_a_of_type_Long);
        if ((localObject != null) && (((bbqm)localObject).a()))
        {
          akss localakss = new akss();
          localakss.jdField_a_of_type_Boolean = true;
          localakss.jdField_a_of_type_ArrayOfJavaLangString = ((bbqm)localObject).jdField_a_of_type_ArrayOfJavaLangString;
          localakss.jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
          localakss.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((bbqm)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          localakss.jdField_a_of_type_Int = ((bbqm)localObject).jdField_a_of_type_Int;
          localakss.jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
          localakss.b = paramAIOVideoData.jdField_a_of_type_Int;
          return localakss;
          if (l < paramAIOVideoData.c)
          {
            bool = true;
            continue;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            bool = true;
          }
        }
        else
        {
          return null;
        }
      }
      else
      {
        localObject = new akss();
        ((akss)localObject).jdField_a_of_type_Boolean = false;
        ((akss)localObject).jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
        ((akss)localObject).b = paramAIOVideoData.jdField_a_of_type_Int;
        ((akss)localObject).jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
        ((akss)localObject).d = l;
        return localObject;
      }
      bool = false;
    }
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject = a(a());
    MessageForShortVideo localMessageForShortVideo;
    if (localObject != null) {
      localMessageForShortVideo = ((akss)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    }
    for (int j = ((akss)localObject).jdField_a_of_type_Int;; j = -1)
    {
      if ((localMessageForShortVideo == null) || (paramInt == -1)) {}
      do
      {
        int k;
        do
        {
          int i;
          do
          {
            return;
            k = 0;
            i = k;
            if (paramLong > 0L)
            {
              i = k;
              if (localMessageForShortVideo.videoFileSize > 0) {
                i = (int)(100L * paramLong / localMessageForShortVideo.videoFileSize);
              }
            }
            if (localMessageForShortVideo.videoFileProgress < 0) {
              localMessageForShortVideo.videoFileProgress = 0;
            }
          } while (a(localMessageForShortVideo, paramInt, i, localMessageForShortVideo.videoFileProgress));
          if ((j != 6) && (j != 17) && (j != 9))
          {
            k = i;
            if (j != 20) {}
          }
          else
          {
            if ((paramInt == 2002) && (paramLong > 0L)) {
              localMessageForShortVideo.transferedSize = ((int)paramLong);
            }
            k = i;
            if (paramInt == 2003)
            {
              localMessageForShortVideo.transferedSize = 0;
              k = 100;
            }
          }
        } while (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramInt == 1002) || (paramInt == 2002)));
        localMessageForShortVideo.videoFileStatus = paramInt;
        localMessageForShortVideo.fileType = j;
        if (k > 0) {
          localMessageForShortVideo.videoFileProgress = k;
        }
        localObject = ShortVideoUtils.c(localMessageForShortVideo);
        if ((paramInt == 2003) && (!bhsr.a((String)localObject))) {
          localMessageForShortVideo.lastModified = new File((String)localObject).lastModified();
        }
      } while (this.jdField_a_of_type_Bbpq.a() == null);
      this.jdField_a_of_type_Bbpq.a().a(localMessageForShortVideo);
      return;
      localMessageForShortVideo = null;
    }
  }
  
  public void a(int paramInt, File paramFile)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      if (str != null) {
        bdll.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.c();
      if (zom.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        QQToast.a(this.jdField_a_of_type_Bbrp.mContext, 2, anzj.a(2131699055), 0).a();
      }
      break;
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      QQToast.a(this.jdField_a_of_type_Bbrp.mContext, 1, anzj.a(2131699056), 0).a();
    }
  }
  
  public void a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).g = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 101) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)localRichMediaBrowserInfo.baseData;
      if (paramInt2 == 256) {
        localAIOVideoData.status = 2;
      }
      localAIOVideoData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Bbrp.updateUI();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 101) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)localRichMediaBrowserInfo.baseData;
      localAIOVideoData.status = 0;
      localAIOVideoData.progress = 0;
      localRichMediaBrowserInfo.baseData = localAIOVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_Bbrp.updateUI();
      if (paramInt2 != 256) {
        break label225;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label195;
      }
      QQToast.a(this.jdField_a_of_type_Bbrp.mContext, 2, this.jdField_a_of_type_Bbrp.mContext.getString(2131717539), 0).a();
    }
    label195:
    label225:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      QQToast.a(this.jdField_a_of_type_Bbrp.mContext, 1, this.jdField_a_of_type_Bbrp.mContext.getString(2131717554), 0).a();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Bbrp.updateView(getSelectedIndex(), this.jdField_a_of_type_Bbrp.mBrowserItemView, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bbrp.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean = paramBoolean;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData)
  {
    if ((paramAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "dealSaveVideo");
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 256);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bhmi.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.b.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "url  is null");
  }
  
  public boolean a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).h;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bbpq != null) && (this.jdField_a_of_type_Bbpq.a != null) && (this.jdField_a_of_type_Bbpq.a() != null))
    {
      if (!LiuHaiUtils.b()) {
        break label94;
      }
      this.jdField_a_of_type_Bbpq.a().a((int)agej.a(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_Bbrp.mContext.getResources()) + 46);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbpq.a().d();
      this.jdField_a_of_type_Bbpq.a().c();
      this.jdField_a_of_type_Bbpq.a.a();
      return;
      label94:
      this.jdField_a_of_type_Bbpq.a().a(46);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.b.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).h = paramBoolean;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(AIOVideoData paramAIOVideoData)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 1);
    }
  }
  
  public boolean b()
  {
    boolean bool = aqwc.b();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "isImmersionOpen:" + bool);
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean;
    }
    return false;
  }
  
  public boolean b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).g;
    }
    return false;
  }
  
  public void buildPresenter()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_Bbrp.mContext, this);
  }
  
  public boolean c()
  {
    Object localObject = getSelectedItem();
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)))
    {
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((AIOBrowserBaseData)localObject).d)) != null) && (((Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((AIOBrowserBaseData)localObject).d))).size() > 0);
    }
    return false;
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    bbqj.a().a();
  }
  
  public void onNetMobile2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    bbqj.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.jdField_a_of_type_Bbrp.a();
    bbqj.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    bbqj.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.jdField_a_of_type_Bbrp.a();
    bbqj.a().a();
  }
  
  public void onNetWifi2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof bbrp)) {
      this.jdField_a_of_type_Bbrp = ((bbrp)paramBrowserBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpy
 * JD-Core Version:    0.7.0.1
 */