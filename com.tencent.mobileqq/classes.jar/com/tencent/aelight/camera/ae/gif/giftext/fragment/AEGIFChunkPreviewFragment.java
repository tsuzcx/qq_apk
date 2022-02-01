package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.OnTextClickListener;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import com.tencent.aelight.camera.ae.gif.video.MaterialWrapper;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult.PngResultItem;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModelFactory;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.light.device.LightDeviceUtils;

public class AEGIFChunkPreviewFragment
  extends Fragment
  implements AEGIFChunkPreviewAdapter.OnTextClickListener
{
  public static double a = 1.0D;
  public static List<PTFaceAttr> a;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEGIFChunkPreviewAdapter jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter;
  private AEGIFMaterialViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFMaterialViewModel;
  private AEGIFRecommandTextViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel;
  private AEGIFTextEditViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private PngCreateResult.PngResultItem jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngCreateResult$PngResultItem;
  private PngsCreateWorkingQueue jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue;
  private BaseVMPeakActivity jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List<AEGIFPreviewWrapper> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public static AEGIFChunkPreviewFragment a(String paramString1, long paramLong, String paramString2)
  {
    AEGIFChunkPreviewFragment localAEGIFChunkPreviewFragment = new AEGIFChunkPreviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localAEGIFChunkPreviewFragment.setArguments(localBundle);
    return localAEGIFChunkPreviewFragment;
  }
  
  @Nullable
  private String a(int paramInt)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    if (paramInt >= 0)
    {
      if (paramInt >= localList.size()) {
        return null;
      }
      if (this.jdField_b_of_type_JavaUtilList.get(paramInt) != null)
      {
        if (((AEGIFPreviewWrapper)this.jdField_b_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null) {
          return null;
        }
        return ((AEGIFPreviewWrapper)this.jdField_b_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
      }
    }
    return null;
  }
  
  private void a(@NonNull RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
    Object localObject1 = AEGifMaterialManager.a().a(3).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AEGifCategoryWrapper)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject2).categoryName)) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject2).materialWrapperList)) && (((AEGifCategoryWrapper)localObject2).categoryName.equals(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString)))
      {
        localObject1 = ((AEGifCategoryWrapper)localObject2).materialWrapperList;
        break label101;
      }
    }
    localObject1 = null;
    label101:
    if (localObject1 == null) {
      AEQLog.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList == null");
    } else if (((List)localObject1).isEmpty()) {
      AEQLog.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], aeMaterialWrappers is empty");
    }
    if ((localObject1 != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[prepareMaterialByEmotion], matchedMaterialList.size() = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      AEQLog.a("AEGIFChunkPreviewFragment", ((StringBuilder)localObject2).toString());
      int j = Math.min(((List)localObject1).size(), paramRecognizedEmotionBean.b);
      Collections.shuffle((List)localObject1);
      int i = 0;
      while (i < j)
      {
        paramRecognizedEmotionBean = (AEMaterialWrapper)((List)localObject1).get(i);
        localObject2 = new AEGIFPreviewWrapper();
        ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = paramRecognizedEmotionBean.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[prepareMaterialByEmotion], sssigning material to item index = ");
        localStringBuilder.append(i);
        localStringBuilder.append("material id = ");
        localStringBuilder.append(paramRecognizedEmotionBean.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        AEQLog.a("AEGIFChunkPreviewFragment", localStringBuilder.toString());
        ((AEGIFPreviewWrapper)localObject2).b = 0;
        ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_Int = 10;
        ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_JavaLangString = "";
        AEBaseDataReporter.a().l(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
        if (this.jdField_b_of_type_JavaUtilList.size() >= this.jdField_a_of_type_Long) {
          break;
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter.notifyItemInserted(this.jdField_b_of_type_JavaUtilList.size() - 1);
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFMaterialViewModel.a(AECaptureContext.a(), (AEGIFPreviewWrapper)localObject2);
        i += 1;
      }
    }
    AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new AEGIFChunkPreviewFragment.7(this));
    getActivity().setResult(201);
    getActivity().finish();
    paramArrayList1 = getActivity().getApplicationContext();
    ThreadManager.getUIHandler().post(new AEGIFChunkPreviewFragment.8(this, paramArrayList1));
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122576);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(LightDeviceUtils.getScreenHeight(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122234).setOnClickListener(new AEGIFChunkPreviewFragment.2(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122794));
    int i = (int)(LightDeviceUtils.getScreenWidth(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 9.0F), 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122591));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AEGIFChunkPreviewFragment.3(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122590));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new AEGIFChunkPreviewFragment.4(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new AEGIFPreviewWrapper();
    ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_JavaLangString = null;
    ((AEGIFPreviewWrapper)localObject).b = 2;
    this.jdField_b_of_type_JavaUtilList.add(0, new AEGIFPreviewWrapper());
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter = new AEGIFChunkPreviewAdapter(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter);
    localObject = new MaterialWrapper();
    ((MaterialWrapper)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue.a((MaterialWrapper)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity).get(AEGIFTextEditViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel, this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.b().postValue("");
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.a().postValue(new AEGIFTextColorConfig.SmartTextColor("#ccffffff", "#000000"));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.c().observe(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, new AEGIFChunkPreviewFragment.5(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFMaterialViewModel = ((AEGIFMaterialViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity).get(AEGIFMaterialViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel = ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, new AEGIFChunkPreviewFragment.6(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = AEGIFTextEditFragment.a(this.jdField_b_of_type_JavaLangString, true, (View)localObject, this.jdField_a_of_type_JavaLangString);
    getFragmentManager().beginTransaction().add(2064122227, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2064318597;
  }
  
  public void a()
  {
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.jdField_a_of_type_Long = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("availableEmoCount = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.d("AEGIFChunkPreviewFragment", 4, localStringBuilder.toString());
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue = new PngsCreateWorkingQueue(paramBundle, jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString, getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue.a(new AEGIFChunkPreviewFragment.1(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", HardCodeUtil.a(2131700187));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", HardCodeUtil.a(2131700188));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", HardCodeUtil.a(2131700193));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", HardCodeUtil.a(2131700191));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", HardCodeUtil.a(2131700189));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", HardCodeUtil.a(2131700196));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    b();
    e();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PngsCreateWorkingQueue localPngsCreateWorkingQueue = this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue;
    if (localPngsCreateWorkingQueue != null) {
      localPngsCreateWorkingQueue.a(this.jdField_a_of_type_Boolean ^ true);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AEBaseDataReporter.a().ao();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    AEBaseReportParam.a().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment
 * JD-Core Version:    0.7.0.1
 */