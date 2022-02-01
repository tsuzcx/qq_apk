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
  public static List<PTFaceAttr> b;
  private ViewGroup c;
  private BaseVMPeakActivity d;
  private HashMap<String, String> e;
  private RecyclerView f;
  private TextView g;
  private AEGIFChunkPreviewAdapter h;
  private List<AEGIFPreviewWrapper> i = new ArrayList();
  private String j;
  private AEGIFMaterialViewModel k;
  private AEGIFTextEditViewModel l;
  private TextView m;
  private PngsCreateWorkingQueue n;
  private String o;
  private PngCreateResult.PngResultItem p;
  private boolean q = false;
  private long r = 9223372036854775807L;
  
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
    List localList = this.i;
    if (localList == null) {
      return null;
    }
    if (paramInt >= 0)
    {
      if (paramInt >= localList.size()) {
        return null;
      }
      if (this.i.get(paramInt) != null)
      {
        if (((AEGIFPreviewWrapper)this.i.get(paramInt)).c == null) {
          return null;
        }
        return ((AEGIFPreviewWrapper)this.i.get(paramInt)).c.id;
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
      if ((localObject2 != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject2).categoryName)) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject2).materialWrapperList)) && (((AEGifCategoryWrapper)localObject2).categoryName.equals(paramRecognizedEmotionBean.b)))
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
    if ((localObject1 != null) && (this.i != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[prepareMaterialByEmotion], matchedMaterialList.size() = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      AEQLog.a("AEGIFChunkPreviewFragment", ((StringBuilder)localObject2).toString());
      int i2 = Math.min(((List)localObject1).size(), paramRecognizedEmotionBean.d);
      Collections.shuffle((List)localObject1);
      int i1 = 0;
      while (i1 < i2)
      {
        paramRecognizedEmotionBean = (AEMaterialWrapper)((List)localObject1).get(i1);
        localObject2 = new AEGIFPreviewWrapper();
        ((AEGIFPreviewWrapper)localObject2).c = paramRecognizedEmotionBean.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[prepareMaterialByEmotion], sssigning material to item index = ");
        localStringBuilder.append(i1);
        localStringBuilder.append("material id = ");
        localStringBuilder.append(paramRecognizedEmotionBean.b.id);
        AEQLog.a("AEGIFChunkPreviewFragment", localStringBuilder.toString());
        ((AEGIFPreviewWrapper)localObject2).b = 0;
        ((AEGIFPreviewWrapper)localObject2).a = 10;
        ((AEGIFPreviewWrapper)localObject2).d = "";
        AEBaseDataReporter.a().n(paramRecognizedEmotionBean.a);
        if (this.i.size() >= this.r) {
          break;
        }
        this.i.add(localObject2);
        this.h.notifyItemInserted(this.i.size() - 1);
        this.k.a(AECaptureContext.a(), (AEGIFPreviewWrapper)localObject2);
        i1 += 1;
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
  
  private void c()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.c.findViewById(2063991394);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(LightDeviceUtils.getScreenHeight(this.d) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.c.findViewById(2063991116).setOnClickListener(new AEGIFChunkPreviewFragment.2(this));
    this.m = ((TextView)this.c.findViewById(2063991569));
    int i1 = (int)(LightDeviceUtils.getScreenWidth(this.d) * 0.04F);
    this.m.setPadding(i1, DisplayUtil.a(this.d, 9.0F), 0, DisplayUtil.a(this.d, 9.0F));
    this.g = ((TextView)this.c.findViewById(2063991408));
    this.g.setEnabled(false);
    this.g.setOnClickListener(new AEGIFChunkPreviewFragment.3(this));
    d();
  }
  
  private void d()
  {
    this.f = ((RecyclerView)this.c.findViewById(2063991407));
    this.f.setLayoutManager(new GridLayoutManager(this.d, 2));
    this.f.addItemDecoration(new AEGIFChunkPreviewFragment.4(this));
    e();
  }
  
  private void e()
  {
    Object localObject = new AEGIFPreviewWrapper();
    ((AEGIFPreviewWrapper)localObject).c = null;
    ((AEGIFPreviewWrapper)localObject).d = null;
    ((AEGIFPreviewWrapper)localObject).b = 2;
    this.i.add(0, new AEGIFPreviewWrapper());
    this.h = new AEGIFChunkPreviewAdapter(this.d, this.i, this.j);
    this.h.a(this);
    this.h.a(this.g);
    this.f.setAdapter(this.h);
    localObject = new MaterialWrapper();
    ((MaterialWrapper)localObject).a = 0;
    this.n.a((MaterialWrapper)localObject);
  }
  
  private void f()
  {
    this.l = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.d).get(AEGIFTextEditViewModel.class));
    this.h.a(this.l, this.d);
    this.l.b().postValue("");
    this.l.a().postValue(new AEGIFTextColorConfig.SmartTextColor("#ccffffff", "#000000"));
    this.l.c().observe(this.d, new AEGIFChunkPreviewFragment.5(this));
    this.l.d();
    this.k = ((AEGIFMaterialViewModel)AEViewModelProviders.a(this.d).get(AEGIFMaterialViewModel.class));
    AEGIFRecommandTextViewModel.a().observe(this.d, new AEGIFChunkPreviewFragment.6(this));
  }
  
  private void g()
  {
    Object localObject = this.f.getChildAt(0);
    localObject = AEGIFTextEditFragment.a(this.o, true, (View)localObject, this.j);
    getFragmentManager().beginTransaction().add(2063991109, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  public void a()
  {
    g();
  }
  
  protected int b()
  {
    return 2064056475;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.r = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("availableEmoCount = ");
    localStringBuilder.append(this.r);
    QLog.d("AEGIFChunkPreviewFragment", 4, localStringBuilder.toString());
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.j = getArguments().getString("KEY_FONT_ID");
    }
    this.n = new PngsCreateWorkingQueue(paramBundle, b, this.j, getActivity());
    this.n.a(new AEGIFChunkPreviewFragment.1(this));
    this.e = new HashMap();
    this.e.put("happy", HardCodeUtil.a(2131898231));
    this.e.put("neutral", HardCodeUtil.a(2131898232));
    this.e.put("sad", HardCodeUtil.a(2131898237));
    this.e.put("anger", HardCodeUtil.a(2131898235));
    this.e.put("disgust", HardCodeUtil.a(2131898233));
    this.e.put("fear", HardCodeUtil.a(2131898240));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = ((ViewGroup)paramLayoutInflater.inflate(b(), paramViewGroup, false));
    c();
    f();
    return this.c;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PngsCreateWorkingQueue localPngsCreateWorkingQueue = this.n;
    if (localPngsCreateWorkingQueue != null) {
      localPngsCreateWorkingQueue.a(this.q ^ true);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AEBaseDataReporter.a().at();
  }
  
  public void onResume()
  {
    super.onResume();
    this.q = false;
    AEBaseReportParam.a().Q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment
 * JD-Core Version:    0.7.0.1
 */