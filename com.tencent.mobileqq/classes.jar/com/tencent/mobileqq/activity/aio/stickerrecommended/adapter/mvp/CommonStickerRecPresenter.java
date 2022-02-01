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
  private static List<StickerRecCacheEntity> a = new ArrayList();
  private static HashSet<String> b = new HashSet();
  CommonStickerRecView c;
  IStickerRecEmoticon d;
  public AppInterface e;
  public QBaseActivity f;
  public BaseAIOContext g;
  EditText h;
  BaseSessionInfo i;
  String j;
  int k;
  private URLDrawableDownListener l = new CommonStickerRecPresenter.1(this);
  
  public CommonStickerRecPresenter(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, EditText paramEditText)
  {
    this.e = paramAppInterface;
    this.f = paramQBaseActivity;
    this.g = paramBaseAIOContext;
    this.i = paramBaseAIOContext.O();
    this.h = paramEditText;
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
  
  @NotNull
  private URLDrawable.URLDrawableOptions b(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramIStickerRecEmoticon.c();
    paramIStickerRecEmoticon = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    paramIStickerRecEmoticon.mLoadingDrawable = this.c.e();
    paramIStickerRecEmoticon.mFailedDrawable = this.c.e();
    paramIStickerRecEmoticon.mGifRoundCorner = this.c.d;
    paramIStickerRecEmoticon.mPlayGifImage = true;
    return paramIStickerRecEmoticon;
  }
  
  public static void e()
  {
    b.clear();
    a.clear();
  }
  
  public static List<StickerRecCacheEntity> f()
  {
    return new ArrayList(a);
  }
  
  public IStickerModel a()
  {
    return this.d;
  }
  
  protected void a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonStickerRec", 2, "sendPic");
    }
    if (paramIStickerRecEmoticon == null) {
      return;
    }
    Object localObject2 = this.j;
    int m = this.k;
    int n = 1;
    Object localObject1 = localObject2;
    Object localObject3;
    if (m == 1)
    {
      localObject3 = ScenesRecommendManagerImpl.get(this.e).findScenesRecItemByID(this.j);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ScenesRecommendItem)localObject3).c();
      }
    }
    StickerRecManagerImpl.get(this.e).setCurrentText((String)localObject1);
    if (StickerRecManagerImpl.isStickerRecFromLocal(paramIStickerRecEmoticon))
    {
      paramIStickerRecEmoticon.a((BaseQQAppInterface)this.e, this.f, this.i);
      paramIStickerRecEmoticon = this.e.getHandler(getClass());
      if (paramIStickerRecEmoticon != null) {
        paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
      }
      return;
    }
    paramIStickerRecEmoticon = (StickerRecData)paramIStickerRecEmoticon;
    localObject1 = new Intent();
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(paramIStickerRecEmoticon.B());
    ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject1).putExtra("uin", this.i.b);
    ((Intent)localObject1).putExtra("uintype", this.i.a);
    ((Intent)localObject1).putExtra("troop_uin", this.i.c);
    ((Intent)localObject1).putExtra("key_confess_topicid", this.i.v);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject1).putExtra("send_in_background", true);
    ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
    ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject1).putExtra("quick_send_original_md5", paramIStickerRecEmoticon.l());
    ((Intent)localObject1).putExtra("quick_send_original_size", paramIStickerRecEmoticon.q());
    ((Intent)localObject1).putExtra("quick_send_thumb_md5", paramIStickerRecEmoticon.p());
    ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject1).putExtra("HOT_PIC_HAS_EXTRA", true);
    m = n;
    if (!TextUtils.isEmpty(paramIStickerRecEmoticon.u())) {
      if (paramIStickerRecEmoticon.u().length() <= 100) {
        m = n;
      } else {
        m = 0;
      }
    }
    if (m != 0)
    {
      ((Intent)localObject1).putExtra("key_emotion_source_from", paramIStickerRecEmoticon.s());
      ((Intent)localObject1).putExtra("key_emotion_source_info", paramIStickerRecEmoticon.t());
      ((Intent)localObject1).putExtra("key_emotion_source_weburl", paramIStickerRecEmoticon.u());
      ((Intent)localObject1).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject1).putExtra("key_emotion_source_packagename", paramIStickerRecEmoticon.v());
      ((Intent)localObject1).putExtra("key_emotion_source_epid", paramIStickerRecEmoticon.w());
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
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.l());
      ((StringBuilder)localObject3).append("srcfrom:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.s());
      ((StringBuilder)localObject3).append(", desc:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.t());
      ((StringBuilder)localObject3).append(", webUrl:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.u());
      ((StringBuilder)localObject3).append(", pack:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.v());
      ((StringBuilder)localObject3).append(", epid:");
      ((StringBuilder)localObject3).append(paramIStickerRecEmoticon.w());
      QLog.i("CommonStickerRec", 2, ((StringBuilder)localObject3).toString());
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendRecEmoPic(this.e, this.f, this.g, this.h.getEditableText(), (Intent)localObject1, (ArrayList)localObject2);
    paramIStickerRecEmoticon = this.e.getHandler(getClass());
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
      this.c.a(false);
      return;
    }
    paramIStickerView = this.d.k();
    if (paramIStickerView == null)
    {
      this.c.a(false);
      return;
    }
    paramIStickerModel = this.d;
    paramIStickerView = paramIStickerModel.a(paramIStickerView, b(paramIStickerModel));
    paramIStickerView.setDecodeHandler(StickerDrawableDownloader.a);
    this.c.e.setTag(this.d);
    if (paramIStickerView.getStatus() != 1)
    {
      paramIStickerView.addHeader("my_uin", this.e.getAccount());
      paramIStickerView.addHeader("emo_big", "true");
      paramIStickerView.addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
      if ((paramIStickerView.getStatus() == 2) || (paramIStickerView.getStatus() == 3)) {
        paramIStickerView.restartDownload();
      }
    }
    else if ((StickerRecManagerImpl.isStickerRecFromRemote(this.d)) && (!b.contains(((StickerRecData)this.d).x())))
    {
      b.add(((StickerRecData)this.d).x());
      paramIStickerModel = ((StickerRecData)this.d).B();
      a.add(new StickerRecCacheEntity(paramIStickerModel, System.currentTimeMillis(), ((StickerRecData)this.d).x()));
    }
    this.c.e.setImageDrawable(paramIStickerView);
    this.c.e.setURLDrawableDownListener(this.l);
    this.c.e.setFocusable(true);
    this.c.e.setFocusableInTouchMode(true);
    if (StickerRecManagerImpl.isStickerRecFromRemote(this.d))
    {
      ((StickerRecData)this.d).a(true);
      if (QLog.isColorLevel())
      {
        paramIStickerView = new StringBuilder();
        paramIStickerView.append("md5:");
        paramIStickerView.append(((StickerRecData)this.d).l());
        QLog.e("CommonStickerRec", 2, paramIStickerView.toString());
      }
    }
    this.c.a(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.j = paramString;
    this.k = paramInt;
  }
  
  public boolean a(IStickerModel paramIStickerModel)
  {
    if ((paramIStickerModel instanceof IStickerRecEmoticon))
    {
      this.d = ((IStickerRecEmoticon)paramIStickerModel);
      return true;
    }
    return false;
  }
  
  public boolean a(IStickerView paramIStickerView)
  {
    if ((paramIStickerView instanceof CommonStickerRecView))
    {
      this.c = ((CommonStickerRecView)paramIStickerView);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if ((this.c.e.getDrawable() instanceof URLDrawable))
    {
      if (((URLDrawable)this.c.e.getDrawable()).getStatus() == 1)
      {
        a(this.d);
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
      IStickerRecEmoticon localIStickerRecEmoticon = this.d;
      if ((localIStickerRecEmoticon != null) && (StickerRecManagerImpl.isStickerRecFromRemote(localIStickerRecEmoticon))) {
        ((StickerRecData)this.d).b(true);
      }
    }
    return bool;
  }
  
  public int g()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return this.c.c;
    }
    if (StickerRecManagerImpl.isStickerRecFromLocal((IStickerRecEmoticon)localObject)) {
      return this.c.c;
    }
    if (!StickerRecManagerImpl.isStickerRecFromRemote(this.d)) {
      return this.c.c;
    }
    localObject = (StickerRecData)this.d;
    float f1 = ((StickerRecData)localObject).z();
    float f2 = ((StickerRecData)localObject).A();
    float f3 = f1 / f2;
    if ((f3 <= 1.777778F) && (f3 >= 0.5625F))
    {
      int n = (int)(this.c.b * f1 / f2);
      int m = n;
      if (n == 0) {
        m = this.c.c;
      }
      return m;
    }
    return this.c.c;
  }
  
  public boolean h()
  {
    return this.d instanceof StickerRecCameraData;
  }
  
  public boolean i()
  {
    IStickerRecEmoticon localIStickerRecEmoticon = this.d;
    if ((localIStickerRecEmoticon instanceof StickerRecLocalData)) {
      return ((StickerRecLocalData)localIStickerRecEmoticon).n();
    }
    if ((localIStickerRecEmoticon instanceof StickerRecFavoriteData)) {
      return ((StickerRecFavoriteData)localIStickerRecEmoticon).n();
    }
    return false;
  }
  
  public String j()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecPresenter
 * JD-Core Version:    0.7.0.1
 */