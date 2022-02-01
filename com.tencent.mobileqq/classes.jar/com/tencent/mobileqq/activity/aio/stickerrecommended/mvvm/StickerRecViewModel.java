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
  private long jdField_a_of_type_Long;
  private MutableLiveData<StickerRecLiveData> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private MutableLiveData<LayoutStatusLiveData> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_b_of_type_Boolean = false;
  private MutableLiveData<String> c = new MutableLiveData();
  
  public StickerRecViewModel(StickerRecRepository paramStickerRecRepository)
  {
    super(paramStickerRecRepository);
  }
  
  public MutableLiveData<StickerRecLiveData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramAppInterface);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
  }
  
  public void a(LayoutStatusLiveData paramLayoutStatusLiveData)
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.setValue(paramLayoutStatusLiveData);
  }
  
  public void a(ScenesRecommendItem paramScenesRecommendItem)
  {
    QLog.i("ScenesRecommendManager", 1, "handleScenesRec start");
    if (!((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().isEmotionRecSettingOpen())
    {
      QLog.i("ScenesRecommendManager", 1, "handleScenesRec isEmotionRecSettingOpen = false");
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().analyzeForScenesMode(paramScenesRecommendItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramBoolean);
    ScenesRecommendManagerImpl localScenesRecommendManagerImpl = ScenesRecommendManagerImpl.get(((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a());
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
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Editable paramEditable, String paramString)
  {
    int i = StickerRecManagerImpl.getMaxMatchLength(((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().getApplicationContext(), ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().getCurrentUin(), 6);
    paramEditable = paramEditable.toString();
    if (!TextUtils.isEmpty(paramString)) {
      paramEditable = paramString;
    }
    boolean bool = false;
    if (i >= paramEditable.length())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      bool = ((StickerRecRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().analyze(paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    }
    if (bool) {
      this.c.setValue(paramEditable);
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    if (localObject == null)
    {
      QLog.i("ScenesRecommendManager", 2, "mSessionInfo is null");
      return false;
    }
    localObject = ((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUinIsCurrentChat  uin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | curUin = ");
    localStringBuilder.append((String)localObject);
    QLog.i("ScenesRecommendManager", 2, localStringBuilder.toString());
    return ((String)localObject).equalsIgnoreCase(paramString);
  }
  
  public MutableLiveData<LayoutStatusLiveData> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModel
 * JD-Core Version:    0.7.0.1
 */