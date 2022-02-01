package com.tencent.aelight.camera.ae.play;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.AEPath.PLAY.FILES;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.TabIcon;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEPlayShowPart
  extends VideoStoryBasePart
  implements Observer
{
  public static final int ANIMATION_DURATION = 200;
  private static final String TAG = "AEPlayShowPart";
  private AEVideoStoryCaptureModeViewModel mCaptureModeViewModel;
  private AEMaterialManager mMidMaterialManager;
  private AEPlayShowMaterialManager mPsMaterialManager;
  private AEPituCameraUnit mUnit;
  private View progressView;
  private AEPlayShowTabView tabView;
  private View tvRetryBtn;
  private ViewGroup vgContainer;
  private ViewGroup vgNoData;
  private ViewPager viewPager;
  private PlayViewPagerAdapter viewPagerAdapter;
  private ViewStub vsNoData;
  
  public AEPlayShowPart(Activity paramActivity, ViewStub paramViewStub, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramViewStub, paramVideoStoryCapturePartManager);
    this.mUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.mPsMaterialManager = ((AEPlayShowMaterialManager)AEQIMManager.a().b(2));
    this.mMidMaterialManager = ((AEMaterialManager)AEQIMManager.a().b(1));
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.1(this));
    this.mPsMaterialManager.addObserver(this, 1);
    this.mMidMaterialManager.a(this, 116);
    initViewModel();
    preLoadWebView(null);
  }
  
  private void cancelProgressDialog()
  {
    Object localObject = this.progressView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.vgNoData;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
  }
  
  private String findTabNameById(String paramString)
  {
    Object localObject = this.viewPagerAdapter.getmCategoryList();
    if (localObject != null)
    {
      AEMaterialCategory localAEMaterialCategory;
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        localObject = ((List)localObject).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject).next();
          } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null));
          localIterator = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while ((localAEMaterialMetaData == null) || (paramString == null) || (!paramString.equals(localAEMaterialMetaData.k)));
      return localAEMaterialCategory.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private String getCurTabName()
  {
    ArrayList localArrayList = this.tabView.getDataList();
    int i = this.tabView.getCurIndex();
    if ((localArrayList != null) && (i < localArrayList.size())) {
      return ((QIMSlidingTabView.TabIcon)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private AEMaterialCategory getCurrentTabMaterial(String paramString)
  {
    Object localObject = this.viewPagerAdapter.getmCategoryList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject).next();
        if ((localAEMaterialCategory != null) && (paramString != null) && (paramString.equals(localAEMaterialCategory.b))) {
          return localAEMaterialCategory;
        }
      }
    }
    return null;
  }
  
  private int getPageScrollY()
  {
    PlayViewPagerAdapter localPlayViewPagerAdapter = this.viewPagerAdapter;
    if ((localPlayViewPagerAdapter != null) && (localPlayViewPagerAdapter.getCurrentPageView() != null)) {
      return this.viewPagerAdapter.getCurrentPageView().getScrollY();
    }
    return 0;
  }
  
  @NonNull
  private List<AEMaterialCategory> getPlayShowCategories()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.mPsMaterialManager.getPsCategoryList();
  }
  
  private String getPositionFlag(String paramString)
  {
    AEPituCameraUnit localAEPituCameraUnit = this.mUnit;
    if ((localAEPituCameraUnit != null) && (localAEPituCameraUnit.a() != null) && (this.mUnit.a().getIntent() != null)) {
      return this.mUnit.a().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> getTabDataList(List<AEMaterialCategory> paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.next();
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.jdField_a_of_type_JavaLangString = localAEMaterialCategory.b;
        localArrayList.add(localTabIcon);
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private String getTabIdByMaterialId(String paramString)
  {
    Object localObject1 = this.viewPagerAdapter;
    if (localObject1 != null)
    {
      localObject1 = ((PlayViewPagerAdapter)localObject1).getmCategoryList();
      if (localObject1 != null)
      {
        AEMaterialCategory localAEMaterialCategory;
        AEMaterialMetaData localAEMaterialMetaData;
        do
        {
          localObject1 = ((List)localObject1).iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject1).next();
              } while (localAEMaterialCategory == null);
              localObject2 = localAEMaterialCategory.jdField_a_of_type_JavaUtilList;
            } while (localObject2 == null);
            localObject2 = ((List)localObject2).iterator();
          }
          localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject2).next();
        } while ((localAEMaterialMetaData == null) || (paramString == null) || (!paramString.equals(localAEMaterialMetaData.k)));
        return localAEMaterialCategory.b;
      }
    }
    return "";
  }
  
  private void initNoDataView(List<AEMaterialCategory> paramList, List<QIMSlidingTabView.TabIcon> paramList1)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (!CollectionUtils.isEmpty(paramList1)))
    {
      paramList = this.vgNoData;
      if ((paramList != null) && (paramList.getVisibility() == 0)) {
        this.vgNoData.setVisibility(8);
      }
    }
    else
    {
      if (this.vgNoData == null)
      {
        this.vgNoData = ((ViewGroup)this.vsNoData.inflate());
        this.tvRetryBtn = this.vgNoData.findViewById(2064122742);
        this.tvRetryBtn.setOnClickListener(new AEPlayShowPart.9(this));
      }
      this.vgNoData.setVisibility(0);
    }
  }
  
  private void initViewModel()
  {
    this.mCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.mUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.mCaptureModeViewModel.a.observe(this.mUnit, new AEPlayShowPart.7(this));
    CameraOperationHelper.b().observe(this.mUnit, new AEPlayShowPart.8(this));
  }
  
  private void preLoadWebView(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preLoadWebView, url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AEPlayShowPart", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this.mActivity, PreloadWebService.class);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("url", paramString);
    }
    try
    {
      this.mActivity.startService((Intent)localObject);
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AEPlayShowPart", 2, "preLoadWebView, error=", paramString);
      }
    }
  }
  
  private void refreshViews()
  {
    Object localObject2 = getPlayShowCategories();
    preLoadWebView(null);
    Object localObject3 = getTabDataList((List)localObject2);
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tabDataList size: ");
      ((StringBuilder)localObject1).append(((ArrayList)localObject3).size());
      QLog.d("AEPlayShowPart", 2, ((StringBuilder)localObject1).toString());
      localObject1 = this.vgNoData;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
      this.tabView.setVisibility(0);
      this.viewPager.setVisibility(0);
      localObject1 = getCurTabName();
      int i = getPageScrollY();
      this.tabView.initTabItemsWithRedDot((ArrayList)localObject3);
      this.viewPagerAdapter.setCategoryList((List)localObject2);
      this.viewPagerAdapter.notifyDataSetChanged();
      localObject2 = getPositionFlag("KEY_CURRENT_SELECT_ID");
      localObject3 = getPositionFlag("KEY_CURRENT_TYPE");
      String str1 = getPositionFlag("KEY_CURRENT_TAB");
      String str2 = getTabIdByMaterialId((String)localObject2);
      AEMaterialCategory localAEMaterialCategory = getCurrentTabMaterial(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chooseId: ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" typeId: ");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(" posTabName: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" isMaterial null: ");
      boolean bool;
      if (localAEMaterialCategory == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      AEQLog.a("AEPlayShowPart", localStringBuilder.toString());
      if ((localAEMaterialCategory != null) && (AECaptureMode.PLAY.name.equals(str1)))
      {
        send(655364, new Object[] { str2, localObject2 });
        return;
      }
      scrollToSpecPos((String)localObject1, i);
      return;
    }
    QLog.d("AEPlayShowPart", 2, "no data.");
    this.tabView.setVisibility(8);
    this.viewPager.setVisibility(8);
    initNoDataView((List)localObject2, (List)localObject3);
  }
  
  private void scrollToSpecItemWithClick(String paramString1, String paramString2)
  {
    paramString1 = getCurrentTabMaterial(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
      if (paramString1 == null) {
        return;
      }
      int i = 0;
      while (i < paramString1.size())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramString1.get(i);
        if ((localAEMaterialMetaData != null) && (paramString2 != null) && (paramString2.equals(localAEMaterialMetaData.k)))
        {
          paramString1 = this.viewPagerAdapter.getCurrentPageView();
          if (paramString1 != null) {
            paramString1.scrollToPosWithClick(i);
          }
          return;
        }
        i += 1;
      }
    }
  }
  
  private void scrollToSpecPos(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEPlayShowPart.6(this, paramString, paramInt));
  }
  
  @TargetApi(12)
  private void showGirdAnimation()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.vgContainer, "alpha", new float[] { 0.0F, 1.0F }));
    localAnimatorSet.setDuration(200L).start();
  }
  
  private void showProgressDialog()
  {
    if (this.progressView == null)
    {
      this.progressView = LayoutInflater.from(this.mActivity).inflate(2131559561, this.vgContainer, false);
      this.vgContainer.addView(this.progressView);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.progressView.getLayoutParams();
      localLayoutParams.addRule(13);
      this.progressView.setLayoutParams(localLayoutParams);
    }
    this.progressView.setVisibility(0);
  }
  
  private void switchToTab(int paramInt)
  {
    this.tabView.onTabChecked(paramInt);
  }
  
  protected void initAfterInflation(View paramView)
  {
    this.vgContainer = ((ViewGroup)paramView);
    this.tabView = ((AEPlayShowTabView)this.vgContainer.findViewById(2064122503));
    this.viewPager = ((ViewPager)this.vgContainer.findViewById(2064122840));
    this.vsNoData = ((ViewStub)this.vgContainer.findViewById(2064122844));
    this.tabView.setTabCheckListener(new AEPlayShowPart.2(this));
    this.viewPagerAdapter = new PlayViewPagerAdapter(this.mActivity, this.mPartManager, getPlayShowCategories());
    this.viewPager.setAdapter(this.viewPagerAdapter);
    this.viewPager.setOnPageChangeListener(new AEPlayShowPart.3(this));
    refreshViews();
  }
  
  protected void initView() {}
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      AEQLog.b("AEPlayShowPart", "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      if (hasInflated()) {
        ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
      }
    }
    else if (paramInt == 116)
    {
      AEQLog.b("AEPlayShowPart", "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
      this.mPsMaterialManager.refresh();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEPlayShowGridAdapter.selectedMaterial = null;
    AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    Object localObject = this.mMidMaterialManager;
    if (localObject != null) {
      ((AEMaterialManager)localObject).a(this);
    }
    localObject = this.mPsMaterialManager;
    if (localObject != null)
    {
      ((AEPlayShowMaterialManager)localObject).removeObserver(this);
      this.mPsMaterialManager.clearCategoryList();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt == 655361)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
        if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AEPath.PLAY.FILES.b);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(paramVarArgs.k);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = findTabNameById(paramVarArgs.k);
          AEBaseReportParam.a().f(paramVarArgs.k);
          AETemplateInfoFragment.jumpToMe(this.mActivity, (String)localObject2, (String)localObject1, paramVarArgs.k, paramVarArgs.p, paramVarArgs.s);
        }
      }
    }
    else if (paramInt == 655362)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
        if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
        {
          AEBaseReportParam.a().f(paramVarArgs.k);
          localObject1 = findTabNameById(paramVarArgs.k);
          localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
          ((Intent)localObject2).addFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          ((Intent)localObject2).putExtra("url", paramVarArgs.A);
          ((Intent)localObject2).putExtra("loc_play_show_tab_name", (String)localObject1);
          ((Intent)localObject2).putExtra("loc_play_show_material_id", paramVarArgs.k);
          ((Intent)localObject2).putExtra("key_camera_material_name", paramVarArgs.s);
          ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(this.mActivity));
          this.mActivity.startActivity((Intent)localObject2);
        }
      }
    }
    else if (paramInt == 655363)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
        if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
        {
          AEBaseReportParam.a().f(paramVarArgs.k);
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(this.mActivity, paramVarArgs.B, null, null, 2083, null);
        }
      }
    }
    else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
    {
      ensureInflate();
      localObject1 = (String)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      localObject2 = this.tabView;
      if (localObject2 != null)
      {
        localObject2 = ((AEPlayShowTabView)localObject2).getDataList();
        if (localObject2 != null)
        {
          paramInt = i;
          while (paramInt < ((List)localObject2).size())
          {
            QIMSlidingTabView.TabIcon localTabIcon = (QIMSlidingTabView.TabIcon)((List)localObject2).get(paramInt);
            if ((localTabIcon != null) && (((String)localObject1).equals(localTabIcon.jdField_a_of_type_JavaLangString)))
            {
              switchToTab(paramInt);
              this.viewPager.post(new AEPlayShowPart.4(this, (String)localObject1, paramVarArgs));
              return;
            }
            paramInt += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart
 * JD-Core Version:    0.7.0.1
 */