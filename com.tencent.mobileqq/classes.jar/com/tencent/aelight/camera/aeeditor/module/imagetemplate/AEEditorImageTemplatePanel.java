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
import com.tencent.qcircle.tavcut.bean.SolidData;
import com.tencent.qcircle.tavcut.bean.TextItem;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qphone.base.util.QLog;
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
  public static final String a = "AEEditorImageTemplatePanel";
  private static boolean k = true;
  private static Boolean t;
  public final SparseArray<String> b = new SparseArray();
  private MaterialClassifierView c;
  private TemplateMaterialContentAdapter d;
  private TAVCutImageSession e;
  private ImageTemplateControlListener f;
  private final List<MetaCategory> g = new ArrayList();
  private final List<MetaMaterial> h = new ArrayList();
  private int i = -1;
  private List<AEEditorImageInfo> j;
  private long l = -1L;
  private AEEditorTextViewModel m;
  private AEEditorStickerViewModel n;
  private ConcurrentHashMap<String, MetaMaterial> o;
  private boolean p;
  private long q = -1L;
  private HashMap<Integer, String> r = new HashMap();
  private HashMap<Integer, Boolean> s = new HashMap();
  
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
    a(paramContext);
  }
  
  private List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i1 = 0;
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
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
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.p) {
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
        this.e.updateTemplateAEKitModel(paramInt, f1, paramJSONObject, f2, localMap, paramMetaMaterial);
        paramMetaMaterial = this.f;
        if (paramMetaMaterial != null) {
          paramMetaMaterial.a(str1, paramJSONObject, f1);
        }
      }
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.c = ((MaterialClassifierView)View.inflate(paramContext, 2064056442, this).findViewById(2063990967));
    this.d = new TemplateMaterialContentAdapter(paramContext);
    this.d.a(d());
    this.c.setup(this.d, this.g, this.h);
    this.c.setCategoryItemListener(new AEEditorImageTemplatePanel.1(this));
    this.c.setOnClearButtonClickListener(new AEEditorImageTemplatePanel.2(this));
    long l1 = LocalMultiProcConfig.getLong("sp_key_use_template", this.l);
    if (System.currentTimeMillis() - l1 > QzoneConfig.getShowUseTemplateDialog()) {
      k = true;
    }
    this.o = new ConcurrentHashMap();
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    boolean bool2 = false;
    this.p = false;
    if (this.f != null)
    {
      boolean bool1 = bool2;
      if (!ImageTemplateMaterialExKt.a(paramMetaMaterial))
      {
        bool1 = bool2;
        if (!ImageTemplateMaterialExKt.b(paramMetaMaterial)) {
          bool1 = true;
        }
      }
      this.f.d(bool1);
    }
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (this.p) {
      return;
    }
    ThreadManager.excute(new AEEditorImageTemplatePanel.4(this, paramMetaMaterial, paramMaterialStatusCallback), 64, null, false);
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
      int i1 = 0;
      while (i1 < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i1);
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
        i1 += 1;
      }
      if (localArrayList.size() > 0)
      {
        this.e.addSticker(paramInt, localArrayList, false);
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ImageTemplateControlListener localImageTemplateControlListener = this.f;
    if (localImageTemplateControlListener != null) {
      localImageTemplateControlListener.e(paramBoolean);
    }
  }
  
  public static boolean b()
  {
    if (t == null) {
      if (!Build.HARDWARE.matches("qcom")) {
        t = Boolean.valueOf(false);
      } else if (Build.VERSION.SDK_INT < 21) {
        t = Boolean.valueOf(false);
      } else if (Build.VERSION.SDK_INT >= 23) {
        t = Boolean.valueOf(Process.is64Bit());
      } else {
        t = Boolean.valueOf(false);
      }
    }
    return t.booleanValue();
  }
  
  private void c(int paramInt, JSONObject paramJSONObject, MetaMaterial paramMetaMaterial)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("text");
    if (localJSONArray != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i1);
        if (localJSONObject != null)
        {
          Object localObject = localJSONObject.optString("id");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject = AEEditorResourceManager.a().d(paramMetaMaterial, (String)localObject);
            if ("text_default".equals(localObject)) {
              paramJSONObject = AEEditorResourceManager.a().C();
            } else if ("__default__".equals(localObject)) {
              paramJSONObject = AEEditorResourceManager.a().C();
            }
            if (TextUtils.isEmpty(paramJSONObject))
            {
              paramJSONObject = a;
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
              paramJSONObject = (MetaMaterial)this.o.get(localObject);
              if (paramJSONObject != null)
              {
                localObject = new SolidData();
                ((SolidData)localObject).setColor(TextMetaMaterialKt.i(paramJSONObject));
                localStickerModel.getSolidItems().put("bgcolor", localObject);
              }
              localArrayList1.add(localStickerModel);
            }
          }
        }
        i1 += 1;
      }
      if (localArrayList1.size() > 0) {
        this.e.addSticker(paramInt, localArrayList1, false);
      }
    }
  }
  
  private ApplyMaterialLocalTask d()
  {
    return new AEEditorImageTemplatePanel.3(this);
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
          this.e.applyPreSeg(paramInt, paramJSONObject);
          this.f.X();
        }
      }
    }
  }
  
  private boolean d(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    paramInt = this.b.size();
    QzoneConfig.getInstance();
    if (paramInt < QzoneConfig.getAEPicTemPlateFilterCount()) {
      return true;
    }
    paramInt = this.b.size();
    QzoneConfig.getInstance();
    if ((paramInt == QzoneConfig.getAEPicTemPlateFilterCount()) && (this.b.get(0) != null)) {
      return true;
    }
    if (b())
    {
      paramInt = ParamsUtil.b();
      QzoneConfig.getInstance();
      if (paramInt <= QzoneConfig.getAEPicTemPlateFilterLevelForQcom())
      {
        AEQLog.d(a, "qcom not apply filter");
        return false;
      }
    }
    paramInt = ParamsUtil.b();
    QzoneConfig.getInstance();
    if (paramInt <= QzoneConfig.getAEPicTemPlateFilterLevel())
    {
      AEQLog.d(a, "low level not apply filter");
      return false;
    }
    QzoneConfig.getInstance();
    String str = QzoneConfig.getAEPicTemPlateFilterBlackList();
    if ((!TextUtils.isEmpty(str)) && (str.contains(Build.MODEL)))
    {
      AEQLog.d(a, "blacklist not apply filter");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    f();
    TAVCutImageSession localTAVCutImageSession = this.e;
    localTAVCutImageSession.updateAndRenderTemplate(localTAVCutImageSession.getCurrentIndex());
    this.i = 0;
    this.d.b(this.i);
    this.c.setClearButtonEnable(false);
    this.s.put(Integer.valueOf(this.e.getCurrentIndex()), Boolean.valueOf(true));
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
            this.e.updateTemplateFrame(paramInt, (String)localObject2);
          } else {
            this.e.updateTemplateFrame(paramInt, (String)localObject2, String.valueOf(Color.parseColor((String)localObject1)));
          }
          localObject2 = this.f;
          if (localObject2 != null) {
            ((ImageTemplateControlListener)localObject2).b(paramJSONObject, (String)localObject1);
          }
        }
      }
      if (paramMetaMaterial != null) {
        AEBaseReportParam.a().n().h.put(Integer.valueOf(paramInt), paramMetaMaterial.id);
      }
    }
  }
  
  private void f()
  {
    if (((MediaModel)this.e.getMediaModels().get(this.e.getCurrentIndex())).getMediaEffectModel().getPreSegModel() != null) {
      this.f.X();
    }
    Object localObject = this.e;
    ((TAVCutImageSession)localObject).clearAllWithoutUpdate(((TAVCutImageSession)localObject).getCurrentIndex());
    localObject = this.f;
    if (localObject != null)
    {
      ((ImageTemplateControlListener)localObject).W();
      this.f.V();
    }
    this.b.delete(this.e.getCurrentIndex());
    AEBaseReportParam.a().n().h.put(Integer.valueOf(this.e.getCurrentIndex()), "none");
  }
  
  public void a()
  {
    this.p = true;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "pic scrolled, updateSelectIndex");
    }
    if (this.d != null)
    {
      String str = (String)this.b.get(paramInt);
      boolean bool = TextUtils.isEmpty(str);
      int i1 = 0;
      if (bool)
      {
        if ((this.s.size() > paramInt) && (((Boolean)this.s.get(Integer.valueOf(paramInt))).booleanValue()))
        {
          setSelectedIndex(0);
          return;
        }
        setSelectedIndex(-1);
        return;
      }
      while (i1 < this.h.size())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)this.h.get(i1);
        if ((localMetaMaterial != null) && (str.equals(localMetaMaterial.id)))
        {
          setSelectedIndex(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.d;
    if (localTemplateMaterialContentAdapter != null) {
      return localTemplateMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.d;
    if (localTemplateMaterialContentAdapter != null) {
      return localTemplateMaterialContentAdapter.a(paramString, paramBoolean);
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    return TextUtils.isEmpty((CharSequence)this.b.get(paramInt)) ^ true;
  }
  
  public String c(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public void c()
  {
    this.b.clear();
    long l1 = this.l;
    if (l1 != -1L) {
      LocalMultiProcConfig.putLong("sp_key_use_template", l1);
    }
  }
  
  public List<MetaMaterial> getTemplateMaterials()
  {
    return this.h;
  }
  
  public void setControlListener(ImageTemplateControlListener paramImageTemplateControlListener)
  {
    this.f = paramImageTemplateControlListener;
  }
  
  public void setImageInfos(List<AEEditorImageInfo> paramList)
  {
    this.j = paramList;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    setSelectedIndex(paramInt, false);
  }
  
  public void setSelectedIndex(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("template select position:");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.d.a(paramInt, paramBoolean);
    this.i = paramInt;
    Object localObject = this.c;
    if (paramInt != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((MaterialClassifierView)localObject).setClearButtonEnable(paramBoolean);
  }
  
  public void setTavCutImageSession(TAVCutImageSession paramTAVCutImageSession)
  {
    this.e = paramTAVCutImageSession;
    int i2 = paramTAVCutImageSession.getMediaModelsMd5().size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.r.put(Integer.valueOf(i1), this.e.getMediaModelsMd5().get(i1));
      this.s.put(Integer.valueOf(i1), Boolean.valueOf(false));
      i1 += 1;
    }
  }
  
  public void setTemplateMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.g.clear();
    this.g.addAll(paramList);
    this.h.clear();
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
              if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.h(localMetaMaterial))) {
                ((Iterator)localObject2).remove();
              }
            }
            else if ((FilterMetaMaterialKt.g(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.i(localMetaMaterial))) {
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
              this.h.add(localObject2);
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
      this.h.add(0, paramList);
    }
    this.c.setCategoryLayoutVisibility(bool1);
    this.c.a();
  }
  
  public void setTextViewModel(AEEditorTextViewModel paramAEEditorTextViewModel, AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    this.m = paramAEEditorTextViewModel;
    this.n = paramAEEditorStickerViewModel;
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    TemplateMaterialContentAdapter localTemplateMaterialContentAdapter = this.d;
    if (localTemplateMaterialContentAdapter != null) {
      localTemplateMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel
 * JD-Core Version:    0.7.0.1
 */