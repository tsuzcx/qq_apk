import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
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

public class bajt
  extends bajk
  implements INetInfoHandler
{
  private balk a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  
  public bajt()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new baju(this);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    aqww localaqww = new aqww(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localaqww, localaqww);
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
    return localaqww;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    return ((paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileStatus == paramInt1) && (paramInt2 - paramInt3 < 10);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Balk != null) && (this.jdField_a_of_type_Balk.a != null)) {
      return this.jdField_a_of_type_Balk.a.getCurPlayingPos();
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
  
  public ajqi a(AIOVideoData paramAIOVideoData)
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
        localObject = bake.a().a(paramAIOVideoData.jdField_a_of_type_Long);
        if ((localObject != null) && (((bakh)localObject).a()))
        {
          ajqi localajqi = new ajqi();
          localajqi.jdField_a_of_type_Boolean = true;
          localajqi.jdField_a_of_type_ArrayOfJavaLangString = ((bakh)localObject).jdField_a_of_type_ArrayOfJavaLangString;
          localajqi.jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
          localajqi.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((bakh)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          localajqi.jdField_a_of_type_Int = ((bakh)localObject).jdField_a_of_type_Int;
          localajqi.jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
          localajqi.b = paramAIOVideoData.jdField_a_of_type_Int;
          return localajqi;
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
        localObject = new ajqi();
        ((ajqi)localObject).jdField_a_of_type_Boolean = false;
        ((ajqi)localObject).jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
        ((ajqi)localObject).b = paramAIOVideoData.jdField_a_of_type_Int;
        ((ajqi)localObject).jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
        ((ajqi)localObject).d = l;
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
      localMessageForShortVideo = ((ajqi)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    }
    for (int j = ((ajqi)localObject).jdField_a_of_type_Int;; j = -1)
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
        localObject = ShortVideoUtils.findVideoPathIfExists(localMessageForShortVideo);
        if ((paramInt == 2003) && (!StringUtil.isEmpty((String)localObject))) {
          localMessageForShortVideo.lastModified = new File((String)localObject).lastModified();
        }
      } while (this.jdField_a_of_type_Bajl.a() == null);
      this.jdField_a_of_type_Bajl.a().a(localMessageForShortVideo);
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
        bcef.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.getLocalShortVideoPath();
      if (ypi.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        QQToast.a(this.jdField_a_of_type_Balk.mContext, 2, amtj.a(2131699290), 0).a();
      }
      break;
    }
    for (;;)
    {
      bcef.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      QQToast.a(this.jdField_a_of_type_Balk.mContext, 1, amtj.a(2131699291), 0).a();
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
      this.jdField_a_of_type_Balk.updateUI();
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
      this.jdField_a_of_type_Balk.updateUI();
      if (paramInt2 != 256) {
        break label225;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label195;
      }
      QQToast.a(this.jdField_a_of_type_Balk.mContext, 2, this.jdField_a_of_type_Balk.mContext.getString(2131717775), 0).a();
    }
    label195:
    label225:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      QQToast.a(this.jdField_a_of_type_Balk.mContext, 1, this.jdField_a_of_type_Balk.mContext.getString(2131717790), 0).a();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Balk.updateView(getSelectedIndex(), this.jdField_a_of_type_Balk.mBrowserItemView, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Balk.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
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
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
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
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.a != null) && (this.jdField_a_of_type_Bajl.a() != null))
    {
      if (!LiuHaiUtils.b()) {
        break label94;
      }
      this.jdField_a_of_type_Bajl.a().a((int)AIOUtils.px2dp(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_Balk.mContext.getResources()) + 46);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bajl.a().d();
      this.jdField_a_of_type_Bajl.a().c();
      this.jdField_a_of_type_Bajl.a.a();
      return;
      label94:
      this.jdField_a_of_type_Bajl.a().a(46);
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
    boolean bool = appl.b();
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
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_Balk.mContext, this);
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
    bake.a().a();
  }
  
  public void onNetMobile2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    bake.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.jdField_a_of_type_Balk.a();
    bake.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    bake.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.jdField_a_of_type_Balk.a();
    bake.a().a();
  }
  
  public void onNetWifi2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof balk)) {
      this.jdField_a_of_type_Balk = ((balk)paramBrowserBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajt
 * JD-Core Version:    0.7.0.1
 */