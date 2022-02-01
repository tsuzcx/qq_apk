package com.tencent.aelight.camera.aeeditor.module.frame;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.tavcut.session.TAVCutImageSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorFramePanel
  extends FrameLayout
{
  public static final String a;
  private final SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private MetaMaterial jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
  private FrameMaterialContentAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter;
  private ImageTemplateControlListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
  private MaterialClassifierView jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final SparseArray<String> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<MetaMaterial> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<String> c;
  private final List<MetaMaterial> d = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AEEditor2]");
    localStringBuilder.append(AEEditorFramePanel.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public AEEditorFramePanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorFramePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorFramePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private ApplyMaterialTask a()
  {
    return new AEEditorFramePanel.4(this);
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView = ((MaterialClassifierView)View.inflate(paramContext, 2064318564, this).findViewById(2064122044));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setOnClearButtonClickListener(new AEEditorFramePanel.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setCategoryItemListener(new AEEditorFramePanel.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter = new FrameMaterialContentAdapter(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter.a(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setup(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
  }
  
  private void a(String paramString, int paramInt, MetaMaterial paramMetaMaterial)
  {
    int i = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex();
    if ("frame".equals(FrameMetaMaterialKt.c(paramMetaMaterial)))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.addFrame(i, paramString, String.valueOf(Color.parseColor(FrameMetaMaterialKt.a(paramMetaMaterial))));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramMetaMaterial.id);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(i, FrameMetaMaterialKt.a(paramMetaMaterial));
    }
    else
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.addFrame(i, paramString);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramMetaMaterial.id);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(i, null);
    }
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    }
    paramString.setClearButtonEnable(bool);
    AEQCircleReport localAEQCircleReport = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      paramString = "";
    } else {
      paramString = paramMetaMaterial.id;
    }
    localAEQCircleReport.a(paramString, QCircleConstants.KEY_PIC, "0");
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public List<MetaMaterial> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      setSelectedIndex(-1);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex(), null);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex(), null);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter != null) {
      setSelectedIndex((String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), (String)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    TAVCutImageSession localTAVCutImageSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
    if (localTAVCutImageSession != null)
    {
      int i = localTAVCutImageSession.getCurrentIndex();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString1);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(i, paramString2);
    }
  }
  
  public void a(List<String> paramList)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSolidFrame... colorList size:");
    localStringBuilder.append(paramList.size());
    AEQLog.a((String)localObject1, localStringBuilder.toString());
    this.c = paramList;
    localObject1 = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
    if (localObject1 == null)
    {
      AEQLog.a(jdField_a_of_type_JavaLangString, "updateSolidFrame... mSolidFrame == null");
      return;
    }
    localObject1 = FrameMetaMaterialKt.b((MetaMaterial)localObject1);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    int j = 0;
    Object localObject3;
    if (!bool)
    {
      localObject1 = ((String)localObject1).split(";");
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder = localObject1[i];
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateSolidFrame... solid frame default color:");
        ((StringBuilder)localObject3).append(localStringBuilder);
        AEQLog.a((String)localObject2, ((StringBuilder)localObject3).toString());
        paramList.add(localStringBuilder);
        i += 1;
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = new Gson();
    localStringBuilder = new StringBuilder();
    int i = j;
    while (i < paramList.size())
    {
      localObject3 = (MetaMaterial)((Gson)localObject2).fromJson(((Gson)localObject2).toJson(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial), MetaMaterial.class);
      FrameMetaMaterialKt.a((MetaMaterial)localObject3, (String)paramList.get(i));
      localStringBuilder.append((String)paramList.get(i));
      localStringBuilder.append(" ");
      ((ArrayList)localObject1).add(localObject3);
      i += 1;
    }
    paramList = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateSolidFrame... add color list:");
    ((StringBuilder)localObject2).append(localStringBuilder.toString());
    AEQLog.a(paramList, ((StringBuilder)localObject2).toString());
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(this.d);
    this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject1);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (MetaCategory)paramList.next();
      if (((MetaCategory)localObject1).id.equals(MetaMaterialKt.d(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)))
      {
        ((MetaCategory)localObject1).materials.clear();
        ((MetaCategory)localObject1).materials.addAll(this.jdField_b_of_type_JavaUtilList);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.a();
    ThreadManager.getUIHandler().postDelayed(new AEEditorFramePanel.3(this), 100L);
  }
  
  public boolean a(int paramInt)
  {
    return TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)) ^ true;
  }
  
  public boolean a(String paramString)
  {
    FrameMaterialContentAdapter localFrameMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter;
    if (localFrameMaterialContentAdapter != null) {
      return localFrameMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void setControlListener(ImageTemplateControlListener paramImageTemplateControlListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener = paramImageTemplateControlListener;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter.b(paramInt);
    MaterialClassifierView localMaterialClassifierView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    }
    localMaterialClassifierView.setClearButtonEnable(bool);
  }
  
  public void setSelectedIndex(String paramString1, String paramString2)
  {
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter.a();
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        setSelectedIndex(-1);
      }
      else
      {
        boolean bool = TextUtils.isEmpty(paramString2);
        int i = 0;
        int j = 0;
        if (bool)
        {
          i = j;
          while (i < localList.size())
          {
            if (localList.get(i) == null) {
              return;
            }
            if (paramString1.equals(((MetaMaterial)localList.get(i)).id))
            {
              setSelectedIndex(i);
              return;
            }
            i += 1;
          }
        }
        while (i < localList.size())
        {
          if (localList.get(i) == null) {
            return;
          }
          String str = FrameMetaMaterialKt.a((MetaMaterial)localList.get(i));
          if ((!TextUtils.isEmpty(str)) && (paramString1.equals(((MetaMaterial)localList.get(i)).id)) && (paramString2.equals(str)))
          {
            setSelectedIndex(i);
            return;
          }
          i += 1;
        }
      }
      setSelectedIndex(-1);
    }
  }
  
  public void setTavCutImageSession(TAVCutImageSession paramTAVCutImageSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
  }
  
  public void setTemplateMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.d.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)paramList.next();
      if (localMetaCategory.materials != null)
      {
        Iterator localIterator = localMetaCategory.materials.iterator();
        while (localIterator.hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
          MetaMaterialKt.a(localMetaMaterial, localMetaCategory.id);
          if (paramBoolean)
          {
            if ((FilterMetaMaterialKt.e(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.a(localMetaMaterial))) {
              localIterator.remove();
            }
          }
          else if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.b(localMetaMaterial))) {
            localIterator.remove();
          }
          if ("frame".equals(FrameMetaMaterialKt.c(localMetaMaterial)))
          {
            String str = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setTemplateMaterials... has solid frame remove material color:");
            localStringBuilder.append(FrameMetaMaterialKt.a(localMetaMaterial));
            AEQLog.a(str, localStringBuilder.toString());
            this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
            localIterator.remove();
          }
        }
        this.jdField_b_of_type_JavaUtilList.addAll(localMetaCategory.materials);
        this.d.addAll(localMetaCategory.materials);
      }
    }
    if (this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
    {
      paramList = this.c;
      if ((paramList != null) && (paramList.size() != 0))
      {
        a(this.c);
        this.c.clear();
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.a();
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    FrameMaterialContentAdapter localFrameMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameFrameMaterialContentAdapter;
    if (localFrameMaterialContentAdapter != null) {
      localFrameMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel
 * JD-Core Version:    0.7.0.1
 */