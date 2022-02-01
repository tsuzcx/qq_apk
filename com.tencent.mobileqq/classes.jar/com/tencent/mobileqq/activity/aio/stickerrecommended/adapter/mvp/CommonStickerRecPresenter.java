package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerDrawableDownloader;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class CommonStickerRecPresenter
  implements IStickerPresenter
{
  private static HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static List<StickerRecCacheEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public AppInterface a;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new CommonStickerRecPresenter.1(this);
  BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  public BaseAIOContext a;
  IStickerRecEmoticon jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
  CommonStickerRecView jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView;
  public QBaseActivity a;
  String jdField_a_of_type_JavaLangString;
  
  public CommonStickerRecPresenter(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseAIOContext.a();
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramIStickerRecEmoticon.a();
    paramIStickerRecEmoticon = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    paramIStickerRecEmoticon.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.a();
    paramIStickerRecEmoticon.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.a();
    paramIStickerRecEmoticon.mGifRoundCorner = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.c;
    paramIStickerRecEmoticon.mPlayGifImage = true;
    return paramIStickerRecEmoticon;
  }
  
  public static List<StickerRecCacheEntity> a()
  {
    return new ArrayList(jdField_a_of_type_JavaUtilList);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
  }
  
  private void a(URLDrawable paramURLDrawable, long paramLong)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
    if (localObject == null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.b;
    }
    if (StickerRecManagerImpl.isStickerRecFromLocal((IStickerRecEmoticon)localObject)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.b;
    }
    if (!StickerRecManagerImpl.isStickerRecFromRemote(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.b;
    }
    localObject = (StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
    float f1 = ((StickerRecData)localObject).g();
    float f2 = ((StickerRecData)localObject).h();
    float f3 = f1 / f2;
    if ((f3 <= 1.777778F) && (f3 >= 0.5625F))
    {
      int j = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_Int * f1 / f2);
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.b;
      }
      return i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.b;
  }
  
  public IStickerModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonStickerRec", 2, "sendPic");
    }
    if (paramIStickerRecEmoticon == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    int j = 1;
    Object localObject1 = localObject2;
    Object localObject3;
    if (i == 1)
    {
      localObject3 = ScenesRecommendManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface).findScenesRecItemByID(this.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ScenesRecommendItem)localObject3).c();
      }
    }
    StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface).setCurrentText((String)localObject1);
    if (StickerRecManagerImpl.isStickerRecFromLocal(paramIStickerRecEmoticon))
    {
      paramIStickerRecEmoticon.a((BaseQQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
      paramIStickerRecEmoticon = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(getClass());
      if (paramIStickerRecEmoticon != null) {
        paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
      }
      return;
    }
    paramIStickerRecEmoticon = (StickerRecData)paramIStickerRecEmoticon;
    localObject1 = new Intent();
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(paramIStickerRecEmoticon.m());
    ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b);
    ((Intent)localObject1).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject1).putExtra("send_in_background", true);
    ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
    ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject1).putExtra("quick_send_original_md5", paramIStickerRecEmoticon.c());
    ((Intent)localObject1).putExtra("quick_send_original_size", paramIStickerRecEmoticon.b());
    ((Intent)localObject1).putExtra("quick_send_thumb_md5", paramIStickerRecEmoticon.g());
    ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject1).putExtra("HOT_PIC_HAS_EXTRA", true);
    i = j;
    if (!TextUtils.isEmpty(paramIStickerRecEmoticon.i())) {
      if (paramIStickerRecEmoticon.i().length() <= 100) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0)
    {
      ((Intent)localObject1).putExtra("key_emotion_source_from", paramIStickerRecEmoticon.e());
      ((Intent)localObject1).putExtra("key_emotion_source_info", paramIStickerRecEmoticon.h());
      ((Intent)localObject1).putExtra("key_emotion_source_weburl", paramIStickerRecEmoticon.i());
      ((Intent)localObject1).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject1).putExtra("key_emotion_source_packagename", paramIStickerRecEmoticon.j());
      ((Intent)localObject1).putExtra("key_emotion_source_epid", paramIStickerRecEmoticon.f());
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("CommonStickerRec", 2, "sendPic over limited!");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("md5:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.c());
      ((StringBuilder)localObject3).append("srcfrom:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.e());
      ((StringBuilder)localObject3).append(", desc:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.h());
      ((StringBuilder)localObject3).append(", webUrl:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.i());
      ((StringBuilder)localObject3).append(", pack:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.j());
      ((StringBuilder)localObject3).append(", epid:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.f());
      QLog.i("CommonStickerRec", 2, ((StringBuilder)localObject3).toString());
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendRecEmoPic(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (Intent)localObject1, (ArrayList)localObject2);
    paramIStickerRecEmoticon = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(getClass());
    if (paramIStickerRecEmoticon != null) {
      paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
    }
  }
  
  public void a(IStickerView paramIStickerView, IStickerModel paramIStickerModel)
  {
    if (!a(paramIStickerView))
    {
      QLog.e("CommonStickerRec", 1, "binding view error!");
      return;
    }
    if (!a(paramIStickerModel))
    {
      QLog.e("CommonStickerRec", 1, "binding model error!");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.a(false);
      return;
    }
    paramIStickerView = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon.a();
    if (paramIStickerView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.a(false);
      return;
    }
    paramIStickerModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
    paramIStickerView = paramIStickerModel.a(paramIStickerView, a(paramIStickerModel));
    paramIStickerView.setDecodeHandler(StickerDrawableDownloader.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.setTag(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon);
    if (paramIStickerView.getStatus() != 1)
    {
      paramIStickerView.addHeader("my_uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      paramIStickerView.addHeader("emo_big", "true");
      paramIStickerView.addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
      if ((paramIStickerView.getStatus() == 2) || (paramIStickerView.getStatus() == 3)) {
        paramIStickerView.restartDownload();
      }
    }
    else if ((StickerRecManagerImpl.isStickerRecFromRemote(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon)) && (!jdField_a_of_type_JavaUtilHashSet.contains(((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).k())))
    {
      jdField_a_of_type_JavaUtilHashSet.add(((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).k());
      paramIStickerModel = ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).m();
      jdField_a_of_type_JavaUtilList.add(new StickerRecCacheEntity(paramIStickerModel, System.currentTimeMillis(), ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).k()));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIStickerView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
    if (StickerRecManagerImpl.isStickerRecFromRemote(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon))
    {
      ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).a(true);
      if (QLog.isColorLevel())
      {
        paramIStickerView = new StringBuilder();
        paramIStickerView.append("md5:");
        paramIStickerView.append(((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).c());
        QLog.e("CommonStickerRec", 2, paramIStickerView.toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.a(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() instanceof URLDrawable))
    {
      if (((URLDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable()).getStatus() == 1)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon);
        bool = true;
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.e("CommonStickerRec", 2, "onClick:URLDrawable status != successed");
      }
    }
    boolean bool = false;
    label66:
    if (bool)
    {
      IStickerRecEmoticon localIStickerRecEmoticon = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
      if ((localIStickerRecEmoticon != null) && (StickerRecManagerImpl.isStickerRecFromRemote(localIStickerRecEmoticon))) {
        ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).b(true);
      }
    }
    return bool;
  }
  
  public boolean a(IStickerModel paramIStickerModel)
  {
    if ((paramIStickerModel instanceof IStickerRecEmoticon))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon = ((IStickerRecEmoticon)paramIStickerModel);
      return true;
    }
    return false;
  }
  
  public boolean a(IStickerView paramIStickerView)
  {
    if ((paramIStickerView instanceof CommonStickerRecView))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpCommonStickerRecView = ((CommonStickerRecView)paramIStickerView);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon instanceof StickerRecCameraData;
  }
  
  public boolean c()
  {
    IStickerRecEmoticon localIStickerRecEmoticon = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
    if ((localIStickerRecEmoticon instanceof StickerRecLocalData)) {
      return ((StickerRecLocalData)localIStickerRecEmoticon).d();
    }
    if ((localIStickerRecEmoticon instanceof StickerRecFavoriteData)) {
      return ((StickerRecFavoriteData)localIStickerRecEmoticon).d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecPresenter
 * JD-Core Version:    0.7.0.1
 */