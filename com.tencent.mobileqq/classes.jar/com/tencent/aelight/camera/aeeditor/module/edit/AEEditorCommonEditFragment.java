package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.Context;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weseevideo.model.effect.StickerModel;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.weseevideo.model.effect.StickerModel;>;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.light.device.OfflineConfig;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, AEEditorStickerControlPanel.TextStickerControlListener, AEEditorTextControlPanel.TextControlListener, AEEditorTopBar.TopBarClickListener, BusinessObserver, QQToast.IToastValidListener
{
  public static int a = 5;
  private static final String jdField_b_of_type_JavaLangString = "AEEditorCommonEditFragment";
  protected Context a;
  protected SparseArray<Map<String, String>> a;
  protected FrameLayout a;
  protected TextView a;
  private Observer<List<MetaCategory>> jdField_a_of_type_AndroidxLifecycleObserver;
  protected MaterialViewModel a;
  protected DebugInfoPart a;
  protected AEEditorCheckGroupView a;
  protected AEEditorFilterControlPanel a;
  protected AEEditorStickerControlPanel a;
  protected AEEditorStickerPart a;
  protected AEEditorStickerViewModel a;
  protected AEEditorTextControlPanel a;
  protected AEEditorTextViewModel a;
  public AEEditorTopBar a;
  protected AEEditorLoadingView a;
  protected CustomHandler a;
  protected ArrayList<AEAlbumMediaBaseModel> a;
  private HashMap<Integer, View> jdField_a_of_type_JavaUtilHashMap;
  protected boolean a;
  protected int b;
  private Observer<List<MetaCategory>> jdField_b_of_type_AndroidxLifecycleObserver;
  protected boolean b;
  private Observer<List<MetaCategory>> c;
  private Observer<List<MetaCategory>> d;
  private Observer<List<MetaCategory>> e;
  private Observer<List<MetaCategory>> f;
  
  public AEEditorCommonEditFragment()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 2064122808)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 2064122259: 
        return 10004;
      case 2064122258: 
        return 10006;
      case 2064122257: 
        return 10002;
      case 2064122256: 
        return 10005;
      }
      return 10001;
    }
    return 10003;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i;
    if ((this instanceof AEEditorImageEditFragment)) {
      i = 87;
    } else {
      i = 90;
    }
    AEReportUtils.b(i, paramInt2, a(paramInt1));
  }
  
  private void a(TextEditorData paramTextEditorData)
  {
    if (a() != null) {
      a().updateTextSticker(paramTextEditorData);
    }
  }
  
  private void a(StickerModel paramStickerModel)
  {
    TAVCutSession localTAVCutSession = a();
    if ((localTAVCutSession instanceof TAVCutImageSession))
    {
      AEQLog.b(jdField_b_of_type_JavaLangString, "onStickerModelChanged TAVCutImageSession");
      ((TAVCutImageSession)localTAVCutSession).addSticker(localTAVCutSession.getCurrentIndex(), paramStickerModel);
      return;
    }
    if ((localTAVCutSession instanceof TAVCutVideoSession))
    {
      AEQLog.b(jdField_b_of_type_JavaLangString, "onStickerModelChanged TAVCutVideoSession");
      ((TAVCutVideoSession)localTAVCutSession).addSticker(paramStickerModel);
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2064122717));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView = ((AEEditorCheckGroupView)paramView.findViewById(2064122033));
    if (!QzoneConfig.isQQCircleShowImageTemplateTab()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.getChildAt(0).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.setOnCheckedChangeListener(new AEEditorCommonEditFragment.6(this));
    y();
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new AEEditorCommonEditFragment.7(this, paramView.findViewById(2064122258), paramView.findViewById(2064122255), paramView.findViewById(2064122257), paramView.findViewById(2064122259), paramView.findViewById(2064122256), paramView.findViewById(2064122808));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.b().observe(this, new AEEditorCommonEditFragment.8(this));
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122203));
  }
  
  private void f(View paramView)
  {
    boolean bool = this instanceof AEEditorImageEditFragment;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel = ((AEEditorFilterControlPanel)paramView.findViewById(2064122191));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setIsImageMode(bool);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setFilterChangedComparator(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(b());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setToastValidListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122197));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel = ((AEEditorStickerControlPanel)paramView.findViewById(2064122641));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.setIsImageMode(bool);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.setStickerControlPanelListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.setStickerViewModel(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.setToastValidListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel = ((AEEditorTextControlPanel)paramView.findViewById(2064122693));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.setTextControlPanelListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.setIsImageMode(bool);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.setTextViewModel(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.setToastValidListener(this);
    this.jdField_a_of_type_AndroidxLifecycleObserver = new AEEditorCommonEditFragment.11(this);
    AEEditorResourceManager.a().a().observeForever(this.jdField_a_of_type_AndroidxLifecycleObserver);
    this.jdField_b_of_type_AndroidxLifecycleObserver = new AEEditorCommonEditFragment.12(this);
    AEEditorResourceManager.a().e().observeForever(this.jdField_b_of_type_AndroidxLifecycleObserver);
    this.c = new AEEditorCommonEditFragment.13(this);
    AEEditorResourceManager.a().f().observeForever(this.c);
    this.d = new AEEditorCommonEditFragment.14(this);
    AEEditorResourceManager.a().c().observeForever(this.d);
    this.e = new AEEditorCommonEditFragment.15(this);
    AEEditorResourceManager.a().d().observeForever(this.e);
    this.f = new AEEditorCommonEditFragment.16(this);
    AEEditorResourceManager.a().b().observe(getViewLifecycleOwner(), this.f);
  }
  
  private void g(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart = new AEEditorStickerPart();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart.a(a());
  }
  
  private void h(View paramView) {}
  
  private void x()
  {
    ThreadManager.excute(new AEEditorCommonEditFragment.21(this), 128, null, true);
  }
  
  private void y()
  {
    if ((!(this instanceof AEEditorImageEditFragment)) && (AECommonUtil.a(getActivity(), jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122551);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122555);
  }
  
  protected abstract int a();
  
  protected abstract AEEditorFilterControlPanel.FilterControlListener a();
  
  protected abstract FilterChangedComparator a();
  
  protected abstract AEEditorStickerPart.AEEditorTextDialogListener a();
  
  protected abstract TAVCutSession a();
  
  public Boolean a()
  {
    TAVCutSession localTAVCutSession = a();
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
          return MetaMaterialKt.b(localMetaMaterial);
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
      for (paramList = (List<StickerModel>)localObject;; paramList = MetaMaterialKt.b((MetaMaterial)localObject)) {
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
    getResources().getString(2064515415);
    String str2 = getResources().getString(2064515416);
    String str3 = getResources().getString(2064515416);
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult))
    {
      paramAIFilterResult = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView;
      if (paramAIFilterResult != null) {
        paramAIFilterResult.setSceneText(getResources().getString(2064515112), "", "");
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
        List localList = ((SingleImageAIFilterResult)paramAIFilterResult).a;
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
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel;
    if (localObject == null) {
      return;
    }
    localObject = ((AEEditorFilterControlPanel)localObject).a();
    boolean bool;
    if (!CollectionUtils.indexOutOfBounds((Collection)localObject, paramInt)) {
      bool = FilterMetaMaterialKt.d((MetaMaterial)((List)localObject).get(paramInt));
    } else {
      bool = false;
    }
    if (bool) {
      b(true);
    } else if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a()) {
      b(false);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.c(bool);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      ((View)localObject).setVisibility(8);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(paramString);
      localAECameraPrefsUtil.a(localStringBuilder.toString(), this.jdField_b_of_type_Int, 0);
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
    if (AECommonUtil.a(getActivity(), jdField_b_of_type_JavaLangString))
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
      int i = ((Integer)paramPair.first).intValue();
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.a(str)) {
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122349);
          }
        }
        else if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.a(str))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122562);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(str, true)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122555);
      }
    }
  }
  
  protected void a(AIFilterResult paramAIFilterResult)
  {
    String str1 = getResources().getString(2064515415);
    String str4 = getResources().getString(2064515416);
    String str5 = getResources().getString(2064515416);
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
        List localList = ((SingleImageAIFilterResult)paramAIFilterResult).a;
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
    paramAIFilterResult = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView;
    if (paramAIFilterResult != null) {
      paramAIFilterResult.setSceneText(str2, (String)localObject, str3);
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, List<StickerModel> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((StickerModel)paramList.get(i)).getInteractive() > 0)
      {
        paramLocalMediaInfo.mKuolieId = ((StickerModel)paramList.get(i)).getMaterialId();
        paramLocalMediaInfo.mKuolieCenterX = ((StickerModel)paramList.get(i)).getCenterX();
        paramLocalMediaInfo.mKuolieCenterY = ((StickerModel)paramList.get(i)).getCenterY();
        paramLocalMediaInfo.mKuolieRotate = ((StickerModel)paramList.get(i)).getRotate();
        float f1 = ((StickerModel)paramList.get(i)).getScale();
        float f2 = paramLocalMediaInfo.mediaWidth * f1 * ((StickerModel)paramList.get(i)).getHeight() / ((StickerModel)paramList.get(i)).getWidth();
        paramLocalMediaInfo.mKuolieWidthScale = f1;
        paramLocalMediaInfo.mKuolieHeightScale = (f2 / paramLocalMediaInfo.mediaHeight);
        paramList = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[setKuolieData], localMediaInfo=");
        localStringBuilder.append(paramLocalMediaInfo);
        AEQLog.a(paramList, localStringBuilder.toString());
        return;
      }
      i += 1;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleDebugDebugInfoPart != null) {
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
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 77, 2, 0, (HashMap)localObject, null, null);
      }
    }
  }
  
  public void a(List<StickerModel> paramList, int paramInt)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    Map localMap = (Map)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int i = 0;
    for (;;)
    {
      int j = paramList.size();
      str2 = "none";
      if (i >= j) {
        break;
      }
      StickerModel localStickerModel = (StickerModel)paramList.get(i);
      if (localMap != null) {
        str1 = (String)localMap.get(localStickerModel.getUniqueId());
      } else {
        str1 = "";
      }
      if (TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
      localStringBuilder2.append(str1);
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(localStickerModel.getMaterialId()) == null)
      {
        localStringBuilder1.append(localStickerModel.getMaterialId());
        if (i != paramList.size() - 1)
        {
          localStringBuilder2.append(",");
          localStringBuilder1.append(",");
        }
      }
      i += 1;
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
    AEBaseReportParam.a().a().jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramList);
    AEBaseReportParam.a().a().b.put(paramInt, str1);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract void a(boolean paramBoolean, int paramInt);
  
  protected void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleDebugDebugInfoPart != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.18(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064515180)).setMessage(((Context)localObject).getString(2064515182)).setPositiveButton(((Context)localObject).getString(2064515181), new AEEditorCommonEditFragment.20(this)).setNegativeButton(((Context)localObject).getString(2064515117), new AEEditorCommonEditFragment.19(this));
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
  
  protected abstract int b();
  
  protected abstract String b();
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(paramBoolean);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected abstract void c();
  
  protected boolean c()
  {
    AEEditorFilterControlPanel localAEEditorFilterControlPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAEEditorFilterControlPanel != null)
    {
      bool1 = bool2;
      if (FilterMetaMaterialKt.a(localAEEditorFilterControlPanel.a()) == EffectType.NETWORK) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected abstract void d();
  
  protected boolean d()
  {
    return AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_TEMPLATE", true, 0);
  }
  
  protected abstract void e();
  
  public boolean e()
  {
    return isVisible();
  }
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected abstract void h();
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      AEQLog.a(jdField_b_of_type_JavaLangString, "sendMessage");
      h();
    }
    return false;
  }
  
  protected abstract void i();
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.b().observe(this, new AEEditorCommonEditFragment.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a().observe(this, new AEEditorCommonEditFragment.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.b().observe(this, new AEEditorCommonEditFragment.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a().observe(this, new AEEditorCommonEditFragment.4(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a().observe(this, new AEEditorCommonEditFragment.5(this));
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    Boolean localBoolean = a();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(0);
    }
  }
  
  public void m() {}
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    Boolean localBoolean = a();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(0);
    }
  }
  
  public void o()
  {
    b(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    AEEditorResourceManager.a().d();
    AEEditorResourceManager.a().e();
    AEEditorResourceManager.a().i();
    AEEditorResourceManager.a().j();
    AEEditorResourceManager.a().f();
    AEEditorResourceManager.a().g();
    AEEditorResourceManager.a().h();
    x();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel = ((MaterialViewModel)AEViewModelProviders.a(this).get(MaterialViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel = ((AEEditorStickerViewModel)AEViewModelProviders.a(this).get(AEEditorStickerViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel = ((AEEditorTextViewModel)AEViewModelProviders.a(this).get(AEEditorTextViewModel.class));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onCreateView");
    c();
    jdField_a_of_type_Int = OfflineConfig.getPhonePerfLevel(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(Looper.getMainLooper(), this);
    return paramLayoutInflater.inflate(a(), paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    AEEditorResourceManager.a().a().removeObserver(this.jdField_a_of_type_AndroidxLifecycleObserver);
    AEEditorResourceManager.a().e().removeObserver(this.jdField_b_of_type_AndroidxLifecycleObserver);
    AEEditorResourceManager.a().f().removeObserver(this.c);
    AEEditorResourceManager.a().c().removeObserver(this.d);
    AEEditorResourceManager.a().d().removeObserver(this.e);
    AEEditorResourceManager.a().b().removeObserver(this.f);
    QQStoryContext.a().removeObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      a().onPause();
      return;
    }
    a().onResume();
  }
  
  public void onPause()
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onPause");
    super.onPause();
    s();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    AEEditorStickerPart localAEEditorStickerPart = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart;
    if (localAEEditorStickerPart != null) {
      localAEEditorStickerPart.a();
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (1 == paramInt) {
      AEEditorResourceManager.a().b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    d(paramView);
    h(paramView);
    b(paramView);
    e(paramView);
    f(paramView);
    g(paramView);
    c(paramView);
    QQStoryContext.a().addObserver(this);
    ((AEEditorDataServiceHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.e)).a("MqCircleEditor");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a(getArguments());
    this.jdField_b_of_type_Boolean = getArguments().getBoolean("key_is_capsule_button");
  }
  
  protected void p()
  {
    AEEditorCheckGroupView localAEEditorCheckGroupView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView;
    if (localAEEditorCheckGroupView != null)
    {
      int i = localAEEditorCheckGroupView.a();
      switch (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.getChildAt(i).getId())
      {
      default: 
        return;
      case 2064122562: 
        a(2064122257, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2064122556: 
        a(2064122256, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2064122555: 
        a(2064122255, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2064122551: 
        a(2064122808, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      case 2064122349: 
        a(2064122259, "SP_KEY_RED_POINT_TIME_STAMP", false);
        return;
      }
      a(2064122258, "SP_KEY_RED_POINT_TIME_STAMP", false);
    }
  }
  
  protected void q()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView = new AEEditorLoadingView(getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.setLoadingListener(new AEEditorCommonEditFragment.9(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a(1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView);
  }
  
  protected void r()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView = new AEEditorLoadingView(getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.setLoadingListener(new AEEditorCommonEditFragment.10(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a(1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView);
  }
  
  protected void s()
  {
    AEEditorLoadingView localAEEditorLoadingView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView;
    if (localAEEditorLoadingView != null) {
      localAEEditorLoadingView.a();
    }
    d();
  }
  
  public void t()
  {
    a().a(getActivity(), true);
  }
  
  public void u()
  {
    s();
    i();
  }
  
  public void v() {}
  
  protected void w()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_TEMPLATE", false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */