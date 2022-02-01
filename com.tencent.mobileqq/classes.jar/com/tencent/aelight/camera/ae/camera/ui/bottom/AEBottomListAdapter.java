package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAISceneAni;
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
  public static int b = 0;
  public static int c = 2130837738;
  private static List<String> l = new ArrayList();
  private static boolean n;
  private static int o = 65;
  private static int p = 65;
  public AEPituCameraUnit d;
  private List<AEMaterialMetaData> e;
  private AEBottomListScrollView f;
  private AECaptureController g;
  private AEMaterialViewModel h;
  private AEMaterialMetaData i;
  private AEMaterialManager j;
  private Map<String, AEBottomListAdapter.ViewHolder> k;
  private AEBottomListAdapter.AEBottomListListener m;
  private AEVideoStoryCaptureModeViewModel q;
  private boolean r = false;
  private INetEventHandler s = new AEBottomListAdapter.1(this);
  private AEMaterialDownloader.MaterialDownloadListener t = new AEBottomListAdapter.4(this);
  
  static
  {
    l.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    l.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    l.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    l.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    l.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    l.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    l.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  public AEBottomListAdapter(AEPituCameraUnit paramAEPituCameraUnit, AEBottomListScrollView paramAEBottomListScrollView, AECaptureController paramAECaptureController)
  {
    this.d = paramAEPituCameraUnit;
    this.f = paramAEBottomListScrollView;
    this.g = paramAECaptureController;
    this.h = ((AEMaterialViewModel)AEViewModelProviders.a(this.d).get(AEMaterialViewModel.class));
    this.e = new ArrayList();
    this.j = ((AEMaterialManager)AEQIMManager.a(1));
    this.k = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.f.getContext(), this.s);
    this.q = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryCaptureModeViewModel.class));
    if (AECameraEntryManager.a(paramAEPituCameraUnit))
    {
      o = 69;
      p = 53;
    }
  }
  
  private void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    if ((paramAEPreDownloadResMetaData != null) && (!paramAEPreDownloadResMetaData.h()))
    {
      AEMaterialManager localAEMaterialManager = this.j;
      localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEPreDownloadResMetaData.a, paramAEPreDownloadResMetaData, this.t);
    }
  }
  
  public static void b(int paramInt)
  {
    c = paramInt;
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, paramAEMaterialMetaData));
  }
  
  private void f()
  {
    AECaptureController localAECaptureController = this.g;
    if ((localAECaptureController != null) && (localAECaptureController.b != null) && (this.g.b.c())) {
      this.g.b.a(this.i.o, this.i.m);
    }
  }
  
  public AEBottomListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = AECameraEntryManager.a(this.d);
    if (bool) {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056334, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056516, paramViewGroup, false);
    }
    return new AEBottomListAdapter.ViewHolder(paramViewGroup, this.f, bool);
  }
  
  public AEMaterialMetaData a(int paramInt)
  {
    List localList = this.e;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (AEMaterialMetaData)this.e.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.e.clear();
    this.e.add(AEMaterialMetaData.l);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.m = "stub_placeholder_material_id";
    int i1 = 0;
    while (i1 < 10)
    {
      this.e.add(localAEMaterialMetaData);
      i1 += 1;
    }
    n = false;
    notifyDataSetChanged();
  }
  
  public void a(AEBottomListAdapter.AEBottomListListener paramAEBottomListListener)
  {
    this.m = paramAEBottomListListener;
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((paramViewHolder.a != null) && (!TextUtils.isEmpty(paramViewHolder.a.m))) {
      this.k.put(paramViewHolder.a.m, paramViewHolder);
    }
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a((AEMaterialMetaData)this.e.get(paramInt));
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (this.e.size() >= 1))
    {
      if (n)
      {
        this.e.remove(1);
        this.e.add(1, paramAEMaterialMetaData);
        notifyDataSetChanged();
        return;
      }
      this.e.add(1, paramAEMaterialMetaData);
      notifyDataSetChanged();
      n = true;
    }
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.e.clear();
    this.e.add(AEMaterialMetaData.l);
    this.e.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new AEMaterialMetaData();
      paramList.m = "call_material_id";
      this.e.add(paramList);
    }
    n = false;
    notifyDataSetChanged();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
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
    if ((paramViewHolder.a != null) && (!TextUtils.isEmpty(paramViewHolder.a.m))) {
      this.k.remove(paramViewHolder.a.m);
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!AEResUtil.e())
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131913586), 0).show();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
      return;
    }
    if (paramAEMaterialMetaData == null)
    {
      int i1 = this.f.getCurrentItem();
      if (i1 >= getItemCount()) {
        return;
      }
      paramAEMaterialMetaData = a(i1);
    }
    this.i = paramAEMaterialMetaData;
    paramAEMaterialMetaData = this.i;
    if (paramAEMaterialMetaData != null) {
      this.j.a(paramAEMaterialMetaData.m);
    }
    paramAEMaterialMetaData = this.i;
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if ("stub_placeholder_material_id".equals(paramAEMaterialMetaData.m)) {
      return;
    }
    if ((!TextUtils.isEmpty(this.i.m)) && (!this.i.a()) && (!this.i.equals(AEMaterialMetaData.l)))
    {
      if (this.i.m.equals("call_material_id"))
      {
        paramAEMaterialMetaData = this.m;
        if (paramAEMaterialMetaData != null) {
          paramAEMaterialMetaData.a();
        }
        return;
      }
      if (this.i.A)
      {
        c(this.i);
        return;
      }
      if ((!this.i.B) && (!this.i.A) && (!TextUtils.isEmpty(this.i.m)) && (this.j != null))
      {
        if (!NetworkUtil.isNetworkAvailable(this.f.getContext()))
        {
          ToastUtil.a().a(HardCodeUtil.a(2131913581));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.videostory.capture", 2, "start download template runnable");
        }
        paramAEMaterialMetaData = this.j;
        paramAEMaterialMetaData.a(paramAEMaterialMetaData.getApp(), this.i, this.t);
      }
      return;
    }
    this.j.a(this.i, false);
    QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
    paramAEMaterialMetaData = this.g;
    if (paramAEMaterialMetaData != null)
    {
      AEMaterialViewModel localAEMaterialViewModel = this.h;
      if (localAEMaterialViewModel != null) {
        localAEMaterialViewModel.a(0, null);
      } else {
        paramAEMaterialMetaData.a(null);
      }
    }
    this.d.s().getIntent().removeExtra("widgetinfo");
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.s);
  }
  
  public boolean d()
  {
    return this.r;
  }
  
  public int getItemCount()
  {
    List localList = this.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter
 * JD-Core Version:    0.7.0.1
 */