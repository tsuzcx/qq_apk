package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
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
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.filter.AEFilterExtendBean;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.TextMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.SolidData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorImageTemplatePanel
  extends FrameLayout
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  public static final String a = "AEEditorImageTemplatePanel";
  private static boolean jdField_a_of_type_Boolean = true;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  public final SparseArray<String> a;
  private ImageTemplateControlListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
  private TemplateMaterialContentAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter;
  private AEEditorStickerViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel;
  private AEEditorTextViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel;
  private MaterialClassifierView jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, MetaMaterial> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long jdField_b_of_type_Long = -1L;
  private HashMap<Integer, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private final List<MetaMaterial> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private List<AEEditorImageInfo> c;
  
  public AEEditorImageTemplatePanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorImageTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorImageTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    a(paramContext);
  }
  
  private ApplyMaterialLocalTask a()
  {
    return new AEEditorImageTemplatePanel.3(this);
  }
  
  private List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          String str2 = localJSONObject.optString("id");
          if (!TextUtils.isEmpty(str2))
          {
            String str1;
            if (!"text_default".equals(str2))
            {
              str1 = str2;
              if (!"__default__".equals(str2)) {}
            }
            else
            {
              str1 = localJSONObject.optString("font");
            }
            localArrayList.add(str1);
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    paramMetaMaterial = new AEEditorImageTemplatePanel.5(this, paramMetaMaterial, System.currentTimeMillis(), paramInt);
    ThreadManager.getFileThreadHandler().post(paramMetaMaterial);
  }
  
  private void a(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    paramJSONObject = paramJSONObject.getJSONObject("filter");
    String str1 = paramJSONObject.optString("id");
    float f1 = (float)paramJSONObject.optDouble("intensity");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = AEEditorResourceManager.a().a(paramMetaMaterial, str1);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(str2);
      paramJSONObject.append(File.separator);
      paramJSONObject.append("effectInfo.json");
      paramJSONObject = new File(paramJSONObject.toString());
      if (paramJSONObject.exists())
      {
        AEFilterExtendBean localAEFilterExtendBean = (AEFilterExtendBean)new Gson().fromJson(FileUtils.readFileContent(paramJSONObject), new AEEditorImageTemplatePanel.6(this).getType());
        if (localAEFilterExtendBean == null) {
          return;
        }
        boolean bool = TextUtils.isEmpty(localAEFilterExtendBean.getLutID());
        paramMetaMaterial = null;
        if (!bool)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(str2);
          paramJSONObject.append(File.separator);
          paramJSONObject.append(localAEFilterExtendBean.getLutID());
          paramJSONObject.append(".png");
          paramJSONObject = paramJSONObject.toString();
        }
        else
        {
          paramJSONObject = null;
        }
        float f2 = localAEFilterExtendBean.getDefaultEffectAlpha();
        if ((f1 < 0.0F) || (f1 > 1.0F)) {
          f1 = f2;
        }
        f2 = localAEFilterExtendBean.getGlowStrength();
        Map localMap = localAEFilterExtendBean.getAdjustParams();
        if (!TextUtils.isEmpty(localAEFilterExtendBean.getMotionID()))
        {
          paramMetaMaterial = new StringBuilder();
          paramMetaMaterial.append(str2);
          paramMetaMaterial.append(File.separator);
          paramMetaMaterial.append(localAEFilterExtendBean.getMotionID());
          paramMetaMaterial = paramMetaMaterial.toString();
        }
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateTemplateAEKitModel(paramInt, f1, paramJSONObject, f2, localMap, paramMetaMaterial);
        paramMetaMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
        if (paramMetaMaterial != null) {
          paramMetaMaterial.a(str1, paramJSONObject, f1);
        }
      }
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView = ((MaterialClassifierView)View.inflate(paramContext, 2064318570, this).findViewById(2064122044));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter = new TemplateMaterialContentAdapter(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter.a(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setup(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setCategoryItemListener(new AEEditorImageTemplatePanel.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setOnClearButtonClickListener(new AEEditorImageTemplatePanel.2(this));
    long l = LocalMultiProcConfig.getLong("sp_key_use_template", this.jdField_a_of_type_Long);
    if (System.currentTimeMillis() - l > QzoneConfig.getShowUseTemplateDialog()) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    boolean bool2 = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener != null)
    {
      boolean bool1 = bool2;
      if (!ImageTemplateMaterialExKt.a(paramMetaMaterial))
      {
        bool1 = bool2;
        if (!ImageTemplateMaterialExKt.b(paramMetaMaterial)) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener.d(bool1);
    }
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    ThreadManager.excute(new AEEditorImageTemplatePanel.4(this, paramMetaMaterial, paramMaterialStatusCallback), 64, null, false);
  }
  
  private void a(boolean paramBoolean)
  {
    ImageTemplateControlListener localImageTemplateControlListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
    if (localImageTemplateControlListener != null) {
      localImageTemplateControlListener.e(paramBoolean);
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      if (!Build.HARDWARE.matches("qcom")) {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      } else if (Build.VERSION.SDK_INT < 21) {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      } else if (Build.VERSION.SDK_INT >= 23) {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(Process.is64Bit());
      } else {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  private boolean a(List<String> paramList, Map<String, MetaMaterial> paramMap)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramMap == null) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        if (!paramMap.containsKey(localObject)) {
          return false;
        }
        localObject = (MetaMaterial)paramMap.get(localObject);
        if (localObject == null) {
          return false;
        }
        if (!TextMetaMaterialKt.a((MetaMaterial)localObject)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    paramJSONObject = paramJSONObject.optJSONArray("sticker");
    if (paramJSONObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("id");
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = AEEditorResourceManager.a().e(paramMetaMaterial, str1);
            if (new File(str2).exists())
            {
              JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("offset");
              float f4 = 0.5F;
              float f3;
              float f2;
              if (localJSONObject != null)
              {
                f3 = (float)((JSONObject)localObject).getJSONObject("offset").getDouble("x");
                f2 = (float)((JSONObject)localObject).getJSONObject("offset").getDouble("y");
              }
              else
              {
                f2 = 0.5F;
                f3 = 0.5F;
              }
              if (Double.compare(((JSONObject)localObject).optDouble("scale"), (0.0D / 0.0D)) != 0) {
                f4 = (float)((JSONObject)localObject).optDouble("scale");
              }
              float f1;
              if (Double.compare(((JSONObject)localObject).optDouble("rotation"), (0.0D / 0.0D)) != 0) {
                f1 = (float)((JSONObject)localObject).optDouble("rotation");
              } else if (Double.compare(((JSONObject)localObject).optDouble("rotate"), (0.0D / 0.0D)) != 0) {
                f1 = (float)((JSONObject)localObject).optDouble("rotate");
              } else {
                f1 = 0.0F;
              }
              localObject = new StickerModel();
              ((StickerModel)localObject).setMaterialId(str1);
              ((StickerModel)localObject).setFilePath(str2);
              ((StickerModel)localObject).setCenterX(f3);
              ((StickerModel)localObject).setCenterY(f2);
              ((StickerModel)localObject).setScale(f4);
              ((StickerModel)localObject).setRotate(f1);
              ((StickerModel)localObject).setStartTime(0.0F);
              ((StickerModel)localObject).setDuration(2.0F);
              ((StickerModel)localObject).setMaxScale(2.0F);
              ((StickerModel)localObject).setMinScale(0.05F);
              localArrayList.add(localObject);
            }
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.addSticker(paramInt, localArrayList, false);
        return;
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    paramInt = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    QzoneConfig.getInstance();
    if (paramInt < QzoneConfig.getAEPicTemPlateFilterCount()) {
      return true;
    }
    paramInt = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    QzoneConfig.getInstance();
    if ((paramInt == QzoneConfig.getAEPicTemPlateFilterCount()) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(0) != null)) {
      return true;
    }
    if (a())
    {
      paramInt = ParamsUtil.a();
      QzoneConfig.getInstance();
      if (paramInt <= QzoneConfig.getAEPicTemPlateFilterLevelForQcom())
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "qcom not apply filter");
        return false;
      }
    }
    paramInt = ParamsUtil.a();
    QzoneConfig.getInstance();
    if (paramInt <= QzoneConfig.getAEPicTemPlateFilterLevel())
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "low level not apply filter");
      return false;
    }
    QzoneConfig.getInstance();
    String str = QzoneConfig.getAEPicTemPlateFilterBlackList();
    if ((!TextUtils.isEmpty(str)) && (str.contains(Build.MODEL)))
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "blacklist not apply filter");
      return false;
    }
    return true;
  }
  
  private void c()
  {
    d();
    TAVCutImageSession localTAVCutImageSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
    localTAVCutImageSession.updateAndRenderTemplate(localTAVCutImageSession.getCurrentIndex());
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setClearButtonEnable(false);
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex()), Boolean.valueOf(true));
  }
  
  private void c(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("text");
    if (localJSONArray != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          Object localObject = localJSONObject.optString("id");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject = AEEditorResourceManager.a().d(paramMetaMaterial, (String)localObject);
            if ("text_default".equals(localObject)) {
              paramJSONObject = AEEditorResourceManager.a().c();
            } else if ("__default__".equals(localObject)) {
              paramJSONObject = AEEditorResourceManager.a().c();
            }
            if (TextUtils.isEmpty(paramJSONObject))
            {
              paramJSONObject = jdField_a_of_type_JavaLangString;
              paramMetaMaterial = new StringBuilder();
              paramMetaMaterial.append("applyText error, pag file is null， textId = ");
              paramMetaMaterial.append((String)localObject);
              AEQLog.d(paramJSONObject, paramMetaMaterial.toString());
              return;
            }
            if (new File(paramJSONObject).exists())
            {
              float f3;
              float f2;
              if (localJSONObject.getJSONObject("offset") != null)
              {
                f3 = (float)localJSONObject.getJSONObject("offset").getDouble("x");
                f2 = (float)localJSONObject.getJSONObject("offset").getDouble("y");
              }
              else
              {
                f2 = 0.5F;
                f3 = 0.5F;
              }
              float f4;
              if (Double.compare(localJSONObject.optDouble("scale"), (0.0D / 0.0D)) != 0) {
                f4 = (float)localJSONObject.optDouble("scale");
              } else {
                f4 = 0.5F;
              }
              float f1;
              if (Double.compare(localJSONObject.optDouble("rotation"), (0.0D / 0.0D)) != 0) {
                f1 = (float)localJSONObject.optDouble("rotation");
              } else if (Double.compare(localJSONObject.optDouble("rotate"), (0.0D / 0.0D)) != 0) {
                f1 = (float)localJSONObject.optDouble("rotate");
              } else {
                f1 = 0.0F;
              }
              StickerModel localStickerModel = new StickerModel();
              localStickerModel.setMaterialId((String)localObject);
              localStickerModel.setFilePath(paramJSONObject);
              localStickerModel.setCenterX(f3);
              localStickerModel.setCenterY(f2);
              localStickerModel.setScale(f4);
              localStickerModel.setRotate(f1);
              localStickerModel.setStartTime(0.0F);
              localStickerModel.setDuration(2.0F);
              localStickerModel.setMaxScale(2.0F);
              localStickerModel.setMinScale(0.05F);
              paramJSONObject = localJSONObject.optString("content");
              if (!TextUtils.isEmpty(paramJSONObject))
              {
                ArrayList localArrayList2 = new ArrayList();
                TextItem localTextItem = new TextItem();
                localTextItem.setText(paramJSONObject);
                if (!TextUtils.isEmpty(localJSONObject.optString("textColor"))) {
                  localTextItem.setTextColor(Color.parseColor(localJSONObject.optString("textColor")));
                }
                if (!TextUtils.isEmpty(localJSONObject.optString("font")))
                {
                  localTextItem.setFontPath(AEEditorResourceManager.a().a(localJSONObject.optString("font"), 0));
                  if (("text_default".equals(localObject)) || ("__default__".equals(localObject))) {
                    localStickerModel.setMaterialId(localJSONObject.optString("font"));
                  }
                }
                localArrayList2.add(localTextItem);
                localStickerModel.setTextItems(localArrayList2);
              }
              paramJSONObject = (MetaMaterial)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
              if (paramJSONObject != null)
              {
                localObject = new SolidData();
                ((SolidData)localObject).setColor(TextMetaMaterialKt.c(paramJSONObject));
                localStickerModel.getSolidItems().put("bgcolor", localObject);
              }
              localArrayList1.add(localStickerModel);
            }
          }
        }
        i += 1;
      }
      if (localArrayList1.size() > 0) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.addSticker(paramInt, localArrayList1, false);
      }
    }
  }
  
  private void d()
  {
    if (((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex())).getMediaEffectModel().getPreSegModel() != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener.G();
    }
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
    ((TAVCutImageSession)localObject).clearAllWithoutUpdate(((TAVCutImageSession)localObject).getCurrentIndex());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
    if (localObject != null)
    {
      ((ImageTemplateControlListener)localObject).F();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener.E();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.delete(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex());
    AEBaseReportParam.a().a().d.put(Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex()), "none");
  }
  
  private void d(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    paramJSONObject = paramJSONObject.optJSONObject("segmentation");
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("id");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = AEEditorResourceManager.a().b(paramMetaMaterial, paramJSONObject);
        if (new File(paramJSONObject).exists())
        {
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyPreSeg(paramInt, paramJSONObject);
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener.G();
        }
      }
    }
  }
  
  private void e(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    Object localObject1 = paramJSONObject.optJSONObject("frame");
    if (localObject1 != null)
    {
      paramJSONObject = ((JSONObject)localObject1).optString("id");
      localObject1 = ((JSONObject)localObject1).optString("frameColor");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        Object localObject2 = AEEditorResourceManager.a().c(paramMetaMaterial, paramJSONObject);
        if (new File((String)localObject2).exists())
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateTemplateFrame(paramInt, (String)localObject2);
          } else {
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateTemplateFrame(paramInt, (String)localObject2, String.valueOf(Color.parseColor((String)localObject1)));
          }
          localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener;
          if (localObject2 != null) {
            ((ImageTemplateControlListener)localObject2).b(paramJSONObject, (String)localObject1);
          }
        }
      }
      if (paramMetaMaterial != null) {
        AEBaseReportParam.a().a().d.put(Integer.valueOf(paramInt), paramMetaMaterial.id);
      }
    }
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
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "pic scrolled, updateSelectIndex");
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter != null)
    {
      String str = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      boolean bool = TextUtils.isEmpty(str);
      int i = 0;
      if (bool)
      {
        if ((this.jdField_b_of_type_JavaUtilHashMap.size() > paramInt) && (((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).booleanValue()))
        {
          setSelectedIndex(0);
          return;
        }
        setSelectedIndex(-1);
        return;
      }
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)this.jdField_b_of_type_JavaUtilList.get(i);
        if ((localMetaMaterial != null) && (str.equals(localMetaMaterial.id)))
        {
          setSelectedIndex(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)) ^ true;
  }
  
  public boolean a(String paramString)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter;
    if (localTemplateMaterialContentAdapter != null) {
      return localTemplateMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter;
    if (localTemplateMaterialContentAdapter != null) {
      return localTemplateMaterialContentAdapter.a(paramString, paramBoolean);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    long l = this.jdField_a_of_type_Long;
    if (l != -1L) {
      LocalMultiProcConfig.putLong("sp_key_use_template", l);
    }
  }
  
  public void setControlListener(ImageTemplateControlListener paramImageTemplateControlListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateImageTemplateControlListener = paramImageTemplateControlListener;
  }
  
  public void setImageInfos(List<AEEditorImageInfo> paramList)
  {
    this.c = paramList;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    setSelectedIndex(paramInt, false);
  }
  
  public void setSelectedIndex(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("template select position:");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter.a(paramInt, paramBoolean);
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
    if (paramInt != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((MaterialClassifierView)localObject).setClearButtonEnable(paramBoolean);
  }
  
  public void setTavCutImageSession(TAVCutImageSession paramTAVCutImageSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
    int j = paramTAVCutImageSession.getMediaModelsMd5().size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModelsMd5().get(i));
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Boolean.valueOf(false));
      i += 1;
    }
  }
  
  public void setTemplateMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    boolean bool1 = true;
    while (paramList.hasNext())
    {
      Object localObject1 = (MetaCategory)paramList.next();
      if (localObject1 != null)
      {
        boolean bool2 = bool1;
        if ("99999999".equals(((MetaCategory)localObject1).id)) {
          bool2 = false;
        }
        bool1 = bool2;
        if (((MetaCategory)localObject1).materials != null)
        {
          Object localObject2 = ((MetaCategory)localObject1).materials.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject2).next();
            MetaMaterialKt.a(localMetaMaterial, ((MetaCategory)localObject1).id);
            if (paramBoolean)
            {
              if ((FilterMetaMaterialKt.e(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.a(localMetaMaterial))) {
                ((Iterator)localObject2).remove();
              }
            }
            else if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.b(localMetaMaterial))) {
              ((Iterator)localObject2).remove();
            }
          }
          localObject1 = ((MetaCategory)localObject1).materials.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MetaMaterial)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              MetaMaterialKt.a((MetaMaterial)localObject2, true);
              MetaMaterialKt.b((MetaMaterial)localObject2, false);
              this.jdField_b_of_type_JavaUtilList.add(localObject2);
            }
          }
        }
      }
    }
    if (!bool1)
    {
      paramList = new MetaMaterial();
      paramList.id = "TEMPLATE_NON_ID";
      paramList.thumbUrl = "thumbNon";
      this.jdField_b_of_type_JavaUtilList.add(0, paramList);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setCategoryLayoutVisibility(bool1);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.a();
  }
  
  public void setTextViewModel(AEEditorTextViewModel paramAEEditorTextViewModel, AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel = paramAEEditorTextViewModel;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel = paramAEEditorStickerViewModel;
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateTemplateMaterialContentAdapter;
    if (localTemplateMaterialContentAdapter != null) {
      localTemplateMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel
 * JD-Core Version:    0.7.0.1
 */