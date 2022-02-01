package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAISceneAni;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEPreDownloadResMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEBottomListAdapter
  extends RecyclerView.Adapter<AEBottomListAdapter.ViewHolder>
{
  public static int a = 0;
  private static boolean jdField_a_of_type_Boolean = false;
  public static int b = 0;
  private static List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public static int c = 2130837714;
  private static int d = 54;
  private static int e = 54;
  public AEPituCameraUnit a;
  private AECaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
  private AEBottomListAdapter.AEBottomListListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$AEBottomListListener;
  private AEBottomListScrollView jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  private AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  private AEMaterialDownloader.MaterialDownloadListener jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener = new AEBottomListAdapter.4(this);
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new AEBottomListAdapter.1(this);
  private List<AEMaterialMetaData> jdField_a_of_type_JavaUtilList;
  private Map<String, AEBottomListAdapter.ViewHolder> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  public AEBottomListAdapter(AEPituCameraUnit paramAEPituCameraUnit, AEBottomListScrollView paramAEBottomListScrollView, AECaptureController paramAECaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = paramAEPituCameraUnit;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = paramAECaptureController;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    if (AECameraEntryManager.a(paramAEPituCameraUnit))
    {
      d = 69;
      e = 53;
    }
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    if ((paramAEPreDownloadResMetaData != null) && (!paramAEPreDownloadResMetaData.d()))
    {
      AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
      localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEPreDownloadResMetaData.a, paramAEPreDownloadResMetaData, this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener);
    }
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, paramAEMaterialMetaData));
  }
  
  private void d()
  {
    AECaptureController localAECaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if ((localAECaptureController != null) && (localAECaptureController.a != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a.b())) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.l, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
    }
  }
  
  public AEBottomListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = AECameraEntryManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit);
    if (bool) {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318474, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318699, paramViewGroup, false);
    }
    return new AEBottomListAdapter.ViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, bool);
  }
  
  public AEMaterialMetaData a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.k = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localAEMaterialMetaData);
      i += 1;
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(AEBottomListAdapter.AEBottomListListener paramAEBottomListListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$AEBottomListListener = paramAEBottomListListener;
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k, paramViewHolder);
    }
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, paramAEMaterialMetaData);
        notifyDataSetChanged();
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(1, paramAEMaterialMetaData);
      notifyDataSetChanged();
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new AEMaterialMetaData();
      paramList.k = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(TTAutoAISceneAni.c());
    a(TTAutoAISceneAni.b());
    a(TTAutoAISceneAni.a());
  }
  
  public void b(AEBottomListAdapter.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k))) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!AEResUtil.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131716137), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
      return;
    }
    int i;
    if (paramAEMaterialMetaData == null)
    {
      i = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.a();
      if (i >= getItemCount()) {
        return;
      }
      paramAEMaterialMetaData = a(i);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if (paramAEMaterialMetaData != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialMetaData.k);
    }
    paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if ("stub_placeholder_material_id".equals(paramAEMaterialMetaData.k)) {
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.a()) && (!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k.equals("call_material_id"))
      {
        paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$AEBottomListListener;
        if (paramAEMaterialMetaData != null) {
          paramAEMaterialMetaData.a();
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.e)
      {
        c(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.b(i);
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.f) && (!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.e) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager != null))
      {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getContext()))
        {
          ToastUtil.a().a(HardCodeUtil.a(2131716132));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.videostory.capture", 2, "start download template runnable");
        }
        paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
        paramAEMaterialMetaData.a(paramAEMaterialMetaData.getApp(), this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, false);
    QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
    paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if (paramAEMaterialMetaData != null) {
      paramAEMaterialMetaData.a(null);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().getIntent().removeExtra("widgetinfo");
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter
 * JD-Core Version:    0.7.0.1
 */