package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.text.Editable;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.LayoutStatusLiveData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.StickerRecLiveData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl.IScenesRecEmoUIHelper;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class StickerRecViewModel
  extends BaseViewModel<StickerRecRepository>
  implements IStickerRecViewModel, ScenesRecommendManagerImpl.IScenesRecEmoUIHelper
{
  private MutableLiveData<StickerRecLiveData> a = new MutableLiveData();
  private MutableLiveData<LayoutStatusLiveData> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private BaseSessionInfo d;
  private long e;
  private boolean f = false;
  private boolean g = false;
  
  public StickerRecViewModel(StickerRecRepository paramStickerRecRepository)
  {
    super(paramStickerRecRepository);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((StickerRecRepository)this.z).a(paramAppInterface);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo)
  {
    this.d = paramBaseSessionInfo;
    ((StickerRecRepository)this.z).c();
  }
  
  public void a(LayoutStatusLiveData paramLayoutStatusLiveData)
  {
    this.b.setValue(paramLayoutStatusLiveData);
  }
  
  public void a(ScenesRecommendItem paramScenesRecommendItem)
  {
    QLog.i("ScenesRecommendManager", 1, "handleScenesRec start");
    if (!((StickerRecRepository)this.z).b().isEmotionRecSettingOpen())
    {
      QLog.i("ScenesRecommendManager", 1, "handleScenesRec isEmotionRecSettingOpen = false");
      return;
    }
    this.e = System.currentTimeMillis();
    ((StickerRecRepository)this.z).b().analyzeForScenesMode(paramScenesRecommendItem, this.d.a, this.d.b);
  }
  
  public void a(boolean paramBoolean)
  {
    ((StickerRecRepository)this.z).a(paramBoolean);
    ScenesRecommendManagerImpl localScenesRecommendManagerImpl = ScenesRecommendManagerImpl.get(((StickerRecRepository)this.z).a());
    StickerRecViewModel localStickerRecViewModel;
    if (paramBoolean) {
      localStickerRecViewModel = this;
    } else {
      localStickerRecViewModel = null;
    }
    localScenesRecommendManagerImpl.setUiHelper(localStickerRecViewModel);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(Editable paramEditable, String paramString)
  {
    int i = StickerRecManagerImpl.getMaxMatchLength(((StickerRecRepository)this.z).a().getApplicationContext(), ((StickerRecRepository)this.z).a().getCurrentUin(), 6);
    paramEditable = paramEditable.toString();
    if (!TextUtils.isEmpty(paramString)) {
      paramEditable = paramString;
    }
    boolean bool = false;
    if (i >= paramEditable.length())
    {
      this.e = System.currentTimeMillis();
      bool = ((StickerRecRepository)this.z).b().analyze(paramEditable, this.d);
    }
    if (bool) {
      this.c.setValue(paramEditable);
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      QLog.i("ScenesRecommendManager", 2, "mSessionInfo is null");
      return false;
    }
    localObject = ((BaseSessionInfo)localObject).b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUinIsCurrentChat  uin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | curUin = ");
    localStringBuilder.append((String)localObject);
    QLog.i("ScenesRecommendManager", 2, localStringBuilder.toString());
    return ((String)localObject).equalsIgnoreCase(paramString);
  }
  
  public MutableLiveData<StickerRecLiveData> b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public MutableLiveData<LayoutStatusLiveData> c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public MutableLiveData<String> d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public void f()
  {
    if (this.e != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.e;
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
      this.e = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModel
 * JD-Core Version:    0.7.0.1
 */