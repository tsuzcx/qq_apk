package com.tencent.aelight.camera.ae.gif;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.LinkedList;
import java.util.List;

public class AEGIFStickerListPart
  extends VideoStoryBasePart
  implements SimpleSlidingIndicator.OnTabListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Pair<String[], int[]> jdField_a_of_type_AndroidUtilPair;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AEVideoStoryGIFTplViewModel jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel;
  private AEGIFStickerAdapter jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private String jdField_a_of_type_JavaLangString;
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private List<AEMaterialWrapper> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  
  public AEGIFStickerListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  @Nullable
  private Pair<Integer, Integer> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    Object localObject = (AEGifCategoryWrapper)paramList.get(0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)) {
      return null;
    }
    if ((((AEGifCategoryWrapper)localObject).materialWrapperList.get(0) != null) && (((AEMaterialWrapper)((AEGifCategoryWrapper)localObject).materialWrapperList.get(0)).b != 1))
    {
      AEMaterialWrapper localAEMaterialWrapper = new AEMaterialWrapper();
      localAEMaterialWrapper.b = 1;
      localAEMaterialWrapper.jdField_a_of_type_JavaLangString = "none";
      ((AEGifCategoryWrapper)localObject).materialWrapperList.add(0, localAEMaterialWrapper);
    }
    localObject = b(paramList);
    if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
    {
      ((AEGifCategoryWrapper)paramList.get(((Integer)((Pair)localObject).first).intValue())).selected = true;
      return localObject;
    }
    ((AEGifCategoryWrapper)paramList.get(0)).selected = true;
    return localObject;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.c.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.4(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryGIFTplViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.5(this));
    CameraOperationHelper.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.6(this));
    CameraOperationHelper.c().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEGIFStickerListPart.7(this));
    if (!this.jdField_a_of_type_Boolean) {
      AEGifMaterialManager.a().a();
    }
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    paramIntent = paramIntent.getStringExtra("KEY_CURRENT_TAB");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initTakeSame], bottomTab=");
    localStringBuilder.append(paramIntent);
    localStringBuilder.append(", materialId=");
    localStringBuilder.append(str);
    AEQLog.a("AEGIFStickerListPart", localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = a(paramIntent, str);
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = str;
      c();
    }
  }
  
  private void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.c(paramAEMaterialWrapper);
    if (paramAEMaterialWrapper == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.b(null);
      this.c = null;
      return;
    }
    this.c = paramAEMaterialWrapper.jdField_a_of_type_JavaLangString;
    int i = paramAEMaterialWrapper.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.b(paramAEMaterialWrapper);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.a(paramAEMaterialWrapper);
  }
  
  private void a(@Nullable String paramString)
  {
    AEVideoStoryGIFTplViewModel localAEVideoStoryGIFTplViewModel = this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel;
    if (localAEVideoStoryGIFTplViewModel != null) {
      localAEVideoStoryGIFTplViewModel.d().postValue(paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (AEFontManager.a().a(paramString) != Typeface.DEFAULT) {
        return;
      }
      ThreadManager.excute(new AEGIFStickerListPart.9(this, paramString), 64, null, false);
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
    if (localObject == null) {
      return false;
    }
    localObject = (Boolean)((AEVideoStoryStateViewModel)localObject).e().getValue();
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  private boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (AECaptureMode.GIF.name.equals(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  @Nullable
  private Pair<Integer, Integer> b(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (TextUtils.isEmpty(this.c))
    {
      AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] mPendingApplyGIFId is empty");
      return null;
    }
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    int k = -1;
    if (!bool)
    {
      i = 0;
      while (i < paramList.size())
      {
        localObject1 = (AEGifCategoryWrapper)paramList.get(i);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject1).categoryId)) && (((AEGifCategoryWrapper)localObject1).categoryId.equals(this.jdField_a_of_type_JavaLangString))) {
          break label110;
        }
        i += 1;
      }
    }
    Object localObject1 = null;
    int i = -1;
    label110:
    if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
    {
      j = 0;
      while (j < ((AEGifCategoryWrapper)localObject1).materialWrapperList.size())
      {
        localObject2 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(j);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString)) && (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(this.c)))
        {
          localObject1 = localObject2;
          break label212;
        }
        j += 1;
      }
    }
    localObject1 = null;
    int j = k;
    label212:
    if (localObject1 == null)
    {
      k = i;
      int n = 0;
      i = j;
      j = k;
      for (;;)
      {
        k = j;
        m = i;
        localObject2 = localObject1;
        if (n >= paramList.size()) {
          break;
        }
        AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)paramList.get(n);
        int i1 = j;
        int i2 = i;
        Object localObject3 = localObject1;
        if (localAEGifCategoryWrapper != null) {
          if (CollectionUtils.isEmpty(localAEGifCategoryWrapper.materialWrapperList))
          {
            i1 = j;
            i2 = i;
            localObject3 = localObject1;
          }
          else
          {
            i1 = 0;
            for (;;)
            {
              k = j;
              m = i;
              localObject2 = localObject1;
              if (i1 >= localAEGifCategoryWrapper.materialWrapperList.size()) {
                break;
              }
              localObject2 = (AEMaterialWrapper)localAEGifCategoryWrapper.materialWrapperList.get(i1);
              if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString)) && (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(this.c)))
              {
                k = n;
                m = i1;
                break;
              }
              i1 += 1;
            }
            i1 = k;
            i2 = m;
            localObject3 = localObject2;
            if (localObject2 != null) {
              break;
            }
          }
        }
        n += 1;
        j = i1;
        i = i2;
        localObject1 = localObject3;
      }
    }
    Object localObject2 = localObject1;
    int m = j;
    k = i;
    if (localObject2 != null)
    {
      paramList = new StringBuilder();
      paramList.append("[findLastSelectedPosition] found tabPosition=");
      paramList.append(k);
      paramList.append(", itemPosition=");
      paramList.append(m);
      AEQLog.b("AEGIFStickerListPart", paramList.toString());
      return new Pair(Integer.valueOf(k), Integer.valueOf(m));
    }
    AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] not found");
    return null;
  }
  
  private void b()
  {
    ViewAnimator.a(new View[] { this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new AEGIFStickerListPart.8(this)).b();
  }
  
  private Pair<String[], int[]> c(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    boolean bool = CollectionUtils.isEmpty(paramList);
    int i = 0;
    if (bool) {
      return new Pair(new String[0], new int[0]);
    }
    String[] arrayOfString = new String[paramList.size()];
    int[] arrayOfInt = new int[paramList.size()];
    while (i < paramList.size())
    {
      Object localObject = (AEGifCategoryWrapper)paramList.get(i);
      if ((localObject != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject).categoryName))) {
        localObject = ((AEGifCategoryWrapper)localObject).categoryName;
      } else {
        localObject = "";
      }
      arrayOfString[i] = localObject;
      arrayOfInt[i] = i;
      i += 1;
    }
    return new Pair(arrayOfString, arrayOfInt);
  }
  
  private void c()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.mActivity, 2131756189);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(2064515390);
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new AEGIFStickerListPart.10(this));
      }
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        AEQLog.a("AEGIFStickerListPart", "[showTakeSameLoading], show dialog");
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing()))
      {
        AEQLog.a("AEGIFStickerListPart", "[hideTakeSameLoading], dismiss dialog");
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (AEGifCategoryWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(((AEGifCategoryWrapper)localObject1).categoryId)))
    {
      this.jdField_b_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
      AEBaseReportParam.a().s(this.jdField_b_of_type_JavaLangString);
      AEBaseDataReporter.a().am();
    }
    if (!paramBoolean) {
      return 0;
    }
    this.jdField_a_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
    a(((AEGifCategoryWrapper)localObject1).fontId);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(((AEGifCategoryWrapper)localObject1).materialWrapperList);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPositionWithOffset(0, 0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)) {
      localObject1 = null;
    } else {
      localObject1 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(0);
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((AEMaterialWrapper)localObject1).b == 1) {
        localObject2 = null;
      }
    }
    a(localObject2);
    return 0;
  }
  
  protected void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_AndroidUtilPair = new Pair(new String[0], new int[0]);
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.mRootView.findViewById(2064121904));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mRootView.findViewById(2064121905));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter = new AEGIFStickerAdapter(this.mRootView.getContext(), this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter.a(new AEGIFStickerListPart.1(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    a(this.mActivity.getIntent());
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AEVideoStoryCaptureModeViewModel localAEVideoStoryCaptureModeViewModel = this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
    if ((localAEVideoStoryCaptureModeViewModel != null) && (localAEVideoStoryCaptureModeViewModel.a())) {
      AEBaseDataReporter.a().aj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart
 * JD-Core Version:    0.7.0.1
 */