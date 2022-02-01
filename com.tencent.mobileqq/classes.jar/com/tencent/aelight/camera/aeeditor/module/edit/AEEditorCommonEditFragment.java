package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aeeditor.module.debug.DebugInfoPart;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.filter.EffectType;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterChangedComparator;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.TextStickerControlListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart.AEEditorTextDialogListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.TextControlListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar;
import com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar.TopBarClickListener;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.session.TAVCutSession;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.qcircle.weseevideo.model.effect.StickerModel;>;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.light.device.OfflineConfig;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, AEEditorStickerControlPanel.TextStickerControlListener, AEEditorTextControlPanel.TextControlListener, AEEditorTopBar.TopBarClickListener, BusinessObserver, QQToast.IToastValidListener
{
  public static int a = 5;
  private static final String z = "AEEditorCommonEditFragment";
  private Observer<List<MetaCategory>> A;
  private Observer<List<MetaCategory>> B;
  private Observer<List<MetaCategory>> C;
  private Observer<List<MetaCategory>> D;
  private Observer<List<MetaCategory>> E;
  private Observer<List<MetaCategory>> F;
  private HashMap<Integer, View> G;
  public AEEditorTopBar f;
  protected AEEditorFilterControlPanel g;
  protected AEEditorStickerControlPanel h;
  protected FrameLayout i;
  protected AEEditorLoadingView j;
  protected AEEditorTextControlPanel k;
  protected AEEditorCheckGroupView l;
  protected DebugInfoPart m;
  protected TextView n;
  protected Context o;
  protected AEEditorStickerPart p;
  protected boolean q;
  protected CustomHandler r;
  protected int s = -1;
  protected SparseArray<Map<String, String>> t = new SparseArray();
  protected MaterialViewModel u;
  protected AEEditorStickerViewModel v;
  protected AEEditorTextViewModel w;
  protected ArrayList<AEAlbumMediaBaseModel> x;
  protected boolean y;
  
  private void N()
  {
    ThreadManager.excute(new AEEditorCommonEditFragment.21(this), 128, null, true);
  }
  
  private void O()
  {
    if ((!(this instanceof AEEditorImageEditFragment)) && (AECommonUtil.a(getActivity(), z)))
    {
      this.l.a(2063991368);
      return;
    }
    this.l.a(2063991372);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1;
    if ((this instanceof AEEditorImageEditFragment)) {
      i1 = 87;
    } else {
      i1 = 90;
    }
    AEReportUtils.b(i1, paramInt2, b(paramInt1));
  }
  
  private void a(TextEditorData paramTextEditorData)
  {
    if (p() != null) {
      p().updateTextSticker(paramTextEditorData);
    }
  }
  
  private void a(StickerModel paramStickerModel)
  {
    TAVCutSession localTAVCutSession = p();
    if ((localTAVCutSession instanceof TAVCutImageSession))
    {
      AEQLog.b(z, "onStickerModelChanged TAVCutImageSession");
      ((TAVCutImageSession)localTAVCutSession).addSticker(localTAVCutSession.getCurrentIndex(), paramStickerModel);
      return;
    }
    if ((localTAVCutSession instanceof TAVCutVideoSession))
    {
      AEQLog.b(z, "onStickerModelChanged TAVCutVideoSession");
      ((TAVCutVideoSession)localTAVCutSession).addSticker(paramStickerModel);
    }
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 2063991582)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 2063991133: 
        return 10004;
      case 2063991132: 
        return 10006;
      case 2063991131: 
        return 10002;
      case 2063991130: 
        return 10005;
      }
      return 10001;
    }
    return 10003;
  }
  
  private void b(View paramView)
  {
    this.f = ((AEEditorTopBar)paramView.findViewById(2063991497));
    this.f.setTitle(h());
    this.f.setTopBarClickListener(this);
  }
  
  private void c(View paramView)
  {
    this.l = ((AEEditorCheckGroupView)paramView.findViewById(2063990964));
    if (!QzoneConfig.isQQCircleShowImageTemplateTab()) {
      this.l.getChildAt(0).setVisibility(8);
    }
    this.l.setOnCheckedChangeListener(new AEEditorCommonEditFragment.6(this));
    O();
  }
  
  private void d(View paramView)
  {
    this.G = new AEEditorCommonEditFragment.7(this, paramView.findViewById(2063991132), paramView.findViewById(2063991129), paramView.findViewById(2063991131), paramView.findViewById(2063991133), paramView.findViewById(2063991130), paramView.findViewById(2063991582));
    this.u.b().observe(this, new AEEditorCommonEditFragment.8(this));
  }
  
  private void e(View paramView)
  {
    this.i = ((FrameLayout)paramView.findViewById(2063991082));
  }
  
  private void f(View paramView)
  {
    boolean bool = this instanceof AEEditorImageEditFragment;
    this.g = ((AEEditorFilterControlPanel)paramView.findViewById(2063991071));
    this.g.setIsImageMode(bool);
    this.g.setFilterChangedComparator(C());
    this.g.setSelectedIndex(q());
    this.g.setToastValidListener(this);
    this.g.setFilterControlListener(i());
    this.n = ((TextView)paramView.findViewById(2063991078));
    this.g.a(this.n);
    this.h = ((AEEditorStickerControlPanel)paramView.findViewById(2063991430));
    this.h.setIsImageMode(bool);
    this.h.setStickerControlPanelListener(this);
    this.h.setStickerViewModel(this.v);
    this.h.setToastValidListener(this);
    this.k = ((AEEditorTextControlPanel)paramView.findViewById(2063991483));
    this.k.setTextControlPanelListener(this);
    this.k.setIsImageMode(bool);
    this.k.setTextViewModel(this.w);
    this.k.setToastValidListener(this);
    this.A = new AEEditorCommonEditFragment.11(this);
    AEEditorResourceManager.a().d().observeForever(this.A);
    this.B = new AEEditorCommonEditFragment.12(this);
    AEEditorResourceManager.a().h().observeForever(this.B);
    this.C = new AEEditorCommonEditFragment.13(this);
    AEEditorResourceManager.a().i().observeForever(this.C);
    this.D = new AEEditorCommonEditFragment.14(this);
    AEEditorResourceManager.a().f().observeForever(this.D);
    this.E = new AEEditorCommonEditFragment.15(this);
    AEEditorResourceManager.a().g().observeForever(this.E);
    this.F = new AEEditorCommonEditFragment.16(this);
    AEEditorResourceManager.a().e().observe(getViewLifecycleOwner(), this.F);
  }
  
  private void g(View paramView)
  {
    this.p = new AEEditorStickerPart();
    this.p.a(j());
  }
  
  private void h(View paramView) {}
  
  protected void A()
  {
    FrameLayout localFrameLayout = this.i;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.removeAllViews();
    this.j = new AEEditorLoadingView(getActivity());
    this.j.setLoadingListener(new AEEditorCommonEditFragment.9(this));
    this.j.a(1);
    this.i.addView(this.j);
  }
  
  protected void B()
  {
    FrameLayout localFrameLayout = this.i;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.removeAllViews();
    this.j = new AEEditorLoadingView(getActivity());
    this.j.setLoadingListener(new AEEditorCommonEditFragment.10(this));
    this.j.a(1);
    this.i.addView(this.j);
  }
  
  protected abstract FilterChangedComparator C();
  
  protected void D()
  {
    AEEditorLoadingView localAEEditorLoadingView = this.j;
    if (localAEEditorLoadingView != null) {
      localAEEditorLoadingView.a();
    }
    k();
  }
  
  public void E()
  {
    b().a(getActivity(), true);
  }
  
  public void F()
  {
    D();
    r();
  }
  
  public void G() {}
  
  public void H()
  {
    Object localObject1 = getArguments();
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")))
    {
      Object localObject2 = (List)((Bundle)localObject1).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((EditorPicInfo)((Iterator)localObject2).next()).picPath);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_qcircle_photo_path_image_edit", (Serializable)localObject1);
        ((Intent)localObject2).putExtra("key_qcircle_is_back_from_image_edit", true);
        getActivity().setResult(-1, (Intent)localObject2);
      }
    }
  }
  
  protected boolean I()
  {
    AEEditorFilterControlPanel localAEEditorFilterControlPanel = this.g;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAEEditorFilterControlPanel != null)
    {
      bool1 = bool2;
      if (FilterMetaMaterialKt.c(localAEEditorFilterControlPanel.getCurrentFilterInstance()) == EffectType.NETWORK) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void J()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_TEMPLATE", false, 0);
  }
  
  protected boolean K()
  {
    return AECameraPrefsUtil.a().b("SP_KEY_FIRST_ENTER_TEMPLATE", true, 0);
  }
  
  public Boolean L()
  {
    TAVCutSession localTAVCutSession = p();
    if (localTAVCutSession == null) {
      return null;
    }
    return Boolean.valueOf(localTAVCutSession.isTavStickerSelected());
  }
  
  protected String a(String paramString, List<MetaMaterial> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)paramList.next();
        if ((localMetaMaterial != null) && (paramString.equals(localMetaMaterial.id))) {
          return MetaMaterialKt.c(localMetaMaterial);
        }
      }
    }
    return "";
  }
  
  protected String a(List<StickerModel> paramList, List<MetaMaterial> paramList1)
  {
    Iterator localIterator1 = paramList.iterator();
    Object localObject = "";
    if (localIterator1.hasNext())
    {
      StickerModel localStickerModel = (StickerModel)localIterator1.next();
      Iterator localIterator2 = paramList1.iterator();
      for (paramList = (List<StickerModel>)localObject;; paramList = MetaMaterialKt.c((MetaMaterial)localObject)) {
        do
        {
          localObject = paramList;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject = (MetaMaterial)localIterator2.next();
        } while ((localObject == null) || (!localStickerModel.getMaterialId().equals(((MetaMaterial)localObject).id)));
      }
    }
    return localObject;
  }
  
  protected ArrayList<String> a(AIFilterResult paramAIFilterResult)
  {
    getResources().getString(2064187702);
    String str2 = getResources().getString(2064187703);
    String str3 = getResources().getString(2064187703);
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult))
    {
      paramAIFilterResult = this.j;
      if (paramAIFilterResult != null) {
        paramAIFilterResult.setSceneText(getResources().getString(2064187454), "", "");
      }
      return null;
    }
    Object localObject = str2;
    String str1 = str3;
    if (paramAIFilterResult != null)
    {
      if (!TextUtils.isEmpty(paramAIFilterResult.a())) {
        paramAIFilterResult.a();
      }
      localObject = str2;
      str1 = str3;
      if ((paramAIFilterResult instanceof SingleImageAIFilterResult))
      {
        List localList = ((SingleImageAIFilterResult)paramAIFilterResult).c;
        localObject = str2;
        str1 = str3;
        if (localList != null)
        {
          paramAIFilterResult = str2;
          if (localList.size() > 0)
          {
            paramAIFilterResult = str2;
            if (localList.get(0) != null) {
              paramAIFilterResult = ((YoutuResultItem)localList.get(0)).Label;
            }
          }
          localObject = paramAIFilterResult;
          str1 = str3;
          if (localList.size() > 1)
          {
            localObject = paramAIFilterResult;
            str1 = str3;
            if (localList.get(1) != null)
            {
              str1 = ((YoutuResultItem)localList.get(1)).Label;
              localObject = paramAIFilterResult;
            }
          }
        }
      }
    }
    paramAIFilterResult = new ArrayList();
    paramAIFilterResult.add(localObject);
    paramAIFilterResult.add(str1);
    return paramAIFilterResult;
  }
  
  protected final void a(int paramInt)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = ((AEEditorFilterControlPanel)localObject).getFilterMaterials();
    boolean bool;
    if (!CollectionUtils.indexOutOfBounds((Collection)localObject, paramInt)) {
      bool = FilterMetaMaterialKt.e((MetaMaterial)((List)localObject).get(paramInt));
    } else {
      bool = false;
    }
    if (bool) {
      b(true);
    } else if (!this.g.b()) {
      b(false);
    }
    this.g.c(bool);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = (View)this.G.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      ((View)localObject).setVisibility(8);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(paramString);
      localAECameraPrefsUtil.a(localStringBuilder.toString(), this.s, 0);
      if (paramBoolean) {
        a(paramInt, 2);
      }
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (AECommonUtil.a(getActivity(), z))
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  protected void a(Pair<Integer, String> paramPair)
  {
    if ((paramPair != null) && (paramPair.first != null))
    {
      if (paramPair.second == null) {
        return;
      }
      String str = (String)paramPair.second;
      int i1 = ((Integer)paramPair.first).intValue();
      if (i1 != 3)
      {
        if (i1 != 4)
        {
          if (i1 != 5) {
            return;
          }
          if (this.k.a(str)) {
            this.l.a(2063991222);
          }
        }
        else if (this.h.a(str))
        {
          this.l.a(2063991380);
        }
      }
      else if (this.g.a(str, true)) {
        this.l.a(2063991372);
      }
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, List<StickerModel> paramList)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if (((StickerModel)paramList.get(i1)).getInteractive() > 0)
      {
        paramLocalMediaInfo.mKuolieId = ((StickerModel)paramList.get(i1)).getMaterialId();
        paramLocalMediaInfo.mKuolieCenterX = ((StickerModel)paramList.get(i1)).getCenterX();
        paramLocalMediaInfo.mKuolieCenterY = ((StickerModel)paramList.get(i1)).getCenterY();
        paramLocalMediaInfo.mKuolieRotate = ((StickerModel)paramList.get(i1)).getRotate();
        float f1 = ((StickerModel)paramList.get(i1)).getScale();
        float f2 = paramLocalMediaInfo.mediaWidth * f1 * ((StickerModel)paramList.get(i1)).getHeight() / ((StickerModel)paramList.get(i1)).getWidth();
        paramLocalMediaInfo.mKuolieWidthScale = f1;
        paramLocalMediaInfo.mKuolieHeightScale = (f2 / paramLocalMediaInfo.mediaHeight);
        paramList = z;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[setKuolieData], localMediaInfo=");
        localStringBuilder.append(paramLocalMediaInfo);
        AEQLog.a(paramList, localStringBuilder.toString());
        return;
      }
      i1 += 1;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.m != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.17(this, paramString1, paramString2));
    }
  }
  
  protected void a(List<StickerModel> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (StickerModel)((Iterator)localObject).next();
      if (paramList.getInteractive() > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("ext1", paramList.getMaterialId());
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(77).setSubActionType(2).setThrActionType(0).setExtras((HashMap)localObject));
      }
    }
  }
  
  public void a(List<StickerModel> paramList, int paramInt)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    Map localMap = (Map)this.t.get(paramInt);
    int i1 = 0;
    for (;;)
    {
      int i2 = paramList.size();
      str2 = "none";
      if (i1 >= i2) {
        break;
      }
      StickerModel localStickerModel = (StickerModel)paramList.get(i1);
      if (localMap != null) {
        str1 = (String)localMap.get(localStickerModel.getUniqueId());
      } else {
        str1 = "";
      }
      if (TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
      localStringBuilder2.append(str1);
      if (this.w.a(localStickerModel.getMaterialId()) == null)
      {
        localStringBuilder1.append(localStickerModel.getMaterialId());
        if (i1 != paramList.size() - 1)
        {
          localStringBuilder2.append(",");
          localStringBuilder1.append(",");
        }
      }
      i1 += 1;
    }
    String str1 = localStringBuilder2.toString();
    String str2 = localStringBuilder1.toString();
    paramList = str1;
    if (TextUtils.isEmpty(str1)) {
      paramList = "none";
    }
    str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "none";
    }
    AEBaseReportParam.a().n().a.put(paramInt, paramList);
    AEBaseReportParam.a().n().b.put(paramInt, str1);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract void a(boolean paramBoolean, int paramInt);
  
  protected void a(String... paramVarArgs)
  {
    if (this.m != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.18(this, paramVarArgs));
    }
  }
  
  protected void b(AIFilterResult paramAIFilterResult)
  {
    String str1 = getResources().getString(2064187702);
    String str4 = getResources().getString(2064187703);
    String str5 = getResources().getString(2064187703);
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult)) {
      return;
    }
    String str2 = str1;
    Object localObject = str4;
    String str3 = str5;
    if (paramAIFilterResult != null)
    {
      if (!TextUtils.isEmpty(paramAIFilterResult.a())) {
        str1 = paramAIFilterResult.a();
      }
      str2 = str1;
      localObject = str4;
      str3 = str5;
      if ((paramAIFilterResult instanceof SingleImageAIFilterResult))
      {
        List localList = ((SingleImageAIFilterResult)paramAIFilterResult).c;
        str2 = str1;
        localObject = str4;
        str3 = str5;
        if (localList != null)
        {
          paramAIFilterResult = str4;
          if (localList.size() > 0) {
            paramAIFilterResult = ((YoutuResultItem)localList.get(0)).Label;
          }
          str2 = str1;
          localObject = paramAIFilterResult;
          str3 = str5;
          if (localList.size() > 1)
          {
            str3 = ((YoutuResultItem)localList.get(1)).Label;
            localObject = paramAIFilterResult;
            str2 = str1;
          }
        }
      }
    }
    paramAIFilterResult = this.j;
    if (paramAIFilterResult != null) {
      paramAIFilterResult.setSceneText(str2, (String)localObject, str3);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
  }
  
  public boolean c()
  {
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064187526)).setMessage(((Context)localObject).getString(2064187528)).setPositiveButton(((Context)localObject).getString(2064187527), new AEEditorCommonEditFragment.20(this)).setNegativeButton(((Context)localObject).getString(2064187459), new AEEditorCommonEditFragment.19(this));
    if (localObject != null) {}
    try
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        ((QQCustomDialog)localObject).show();
      }
      label83:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  public boolean canShowToast()
  {
    return isVisible();
  }
  
  protected abstract void f();
  
  protected abstract int g();
  
  protected abstract String h();
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      AEQLog.a(z, "sendMessage");
      o();
    }
    return false;
  }
  
  protected abstract AEEditorFilterControlPanel.FilterControlListener i();
  
  protected abstract AEEditorStickerPart.AEEditorTextDialogListener j();
  
  protected abstract void k();
  
  protected abstract void l();
  
  protected abstract void m();
  
  protected abstract void n();
  
  protected abstract void o();
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(z, "onCreate");
    super.onCreate(paramBundle);
    this.o = getActivity();
    AEEditorResourceManager.a().p();
    AEEditorResourceManager.a().q();
    AEEditorResourceManager.a().u();
    AEEditorResourceManager.a().v();
    AEEditorResourceManager.a().r();
    AEEditorResourceManager.a().s();
    AEEditorResourceManager.a().t();
    N();
    this.u = ((MaterialViewModel)AEViewModelProviders.a(this).get(MaterialViewModel.class));
    this.v = ((AEEditorStickerViewModel)AEViewModelProviders.a(this).get(AEEditorStickerViewModel.class));
    this.w = ((AEEditorTextViewModel)AEViewModelProviders.a(this).get(AEEditorTextViewModel.class));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AEQLog.b(z, "onCreateView");
    f();
    a = OfflineConfig.getPhonePerfLevel(this.o);
    this.r = new CustomHandler(Looper.getMainLooper(), this);
    return paramLayoutInflater.inflate(g(), paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    AEQLog.b(z, "onDestroyView");
    super.onDestroyView();
    AEEditorResourceManager.a().d().removeObserver(this.A);
    AEEditorResourceManager.a().h().removeObserver(this.B);
    AEEditorResourceManager.a().i().removeObserver(this.C);
    AEEditorResourceManager.a().f().removeObserver(this.D);
    AEEditorResourceManager.a().g().removeObserver(this.E);
    AEEditorResourceManager.a().e().removeObserver(this.F);
    QQStoryContext.k().removeObserver(this);
    this.r.removeMessages(0);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      p().onPause();
      return;
    }
    p().onResume();
  }
  
  public void onPause()
  {
    AEQLog.b(z, "onPause");
    super.onPause();
    D();
    this.q = true;
  }
  
  public void onResume()
  {
    AEQLog.b(z, "onResume");
    super.onResume();
    this.q = false;
    AEEditorStickerPart localAEEditorStickerPart = this.p;
    if (localAEEditorStickerPart != null) {
      localAEEditorStickerPart.a();
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (1 == paramInt) {
      AEEditorResourceManager.a().c();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(z, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    d(paramView);
    h(paramView);
    b(paramView);
    e(paramView);
    f(paramView);
    g(paramView);
    c(paramView);
    QQStoryContext.k().addObserver(this);
    ((AEEditorDataServiceHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.f)).a("MqCircleEditor");
    this.u.a(getArguments());
    this.y = getArguments().getBoolean("key_is_capsule_button");
  }
  
  protected abstract TAVCutSession p();
  
  protected abstract int q();
  
  protected abstract void r();
  
  protected boolean s()
  {
    return false;
  }
  
  protected void t()
  {
    this.v.d().observe(this, new AEEditorCommonEditFragment.1(this));
    this.v.c().observe(this, new AEEditorCommonEditFragment.2(this));
    this.w.d().observe(this, new AEEditorCommonEditFragment.3(this));
    this.w.c().observe(this, new AEEditorCommonEditFragment.4(this));
    this.u.a().observe(this, new AEEditorCommonEditFragment.5(this));
  }
  
  public void u()
  {
    this.r.removeMessages(0);
  }
  
  public void v()
  {
    this.v.a(null);
    this.r.removeMessages(0);
    Boolean localBoolean = L();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      this.r.sendEmptyMessage(0);
    }
  }
  
  public void w() {}
  
  public void x()
  {
    this.w.a(null);
    this.r.removeMessages(0);
    Boolean localBoolean = L();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      this.r.sendEmptyMessage(0);
    }
  }
  
  public void y()
  {
    b(false);
  }
  
  protected void z()
  {
    AEEditorCheckGroupView localAEEditorCheckGroupView = this.l;
    if (localAEEditorCheckGroupView != null)
    {
      int i1 = localAEEditorCheckGroupView.getCheckIndex();
      switch (this.l.getChildAt(i1).getId())
      {
      default: 
        return;
      case 2063991380: 
        a(2063991131, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2063991373: 
        a(2063991130, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2063991372: 
        a(2063991129, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2063991368: 
        a(2063991582, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2063991222: 
        a(2063991133, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      }
      a(2063991132, "SP_KEY_RED_POINT_TIME_STAMP", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */