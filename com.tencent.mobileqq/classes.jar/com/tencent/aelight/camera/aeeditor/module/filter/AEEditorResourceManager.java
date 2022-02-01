package com.tencent.aelight.camera.aeeditor.module.filter;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPath.Editor.FILES;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.FILES;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorPagStickerConfig;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader;
import com.tencent.aelight.camera.aeeditor.manage.AEditorMaterialManager;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.FileUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class AEEditorResourceManager
  extends AEEditorResourceDownloader
{
  private static volatile AEEditorResourceManager jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorResourceManager;
  public static final String d;
  private static final String jdField_e_of_type_JavaLangString;
  private final MutableLiveData<List<MetaCategory>> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private final int jdField_b_of_type_Int = ((Integer)ParamsUtil.b(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7))).intValue();
  private final MutableLiveData<List<MetaCategory>> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> c;
  protected volatile boolean c;
  private final MutableLiveData<List<MetaCategory>> jdField_d_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> jdField_d_of_type_JavaUtilMap = new LinkedHashMap();
  protected volatile boolean d;
  private final MutableLiveData<List<MetaCategory>> jdField_e_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> jdField_e_of_type_JavaUtilMap = new LinkedHashMap();
  private final MutableLiveData<List<MetaCategory>> jdField_f_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> jdField_f_of_type_JavaUtilMap = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> g = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> h = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> i = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> j = new LinkedHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("text");
    jdField_e_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("frame");
    jdField_d_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  private AEEditorResourceManager()
  {
    super("camera/ae_camera_editor_download_resources.json", AEEditorPath.EDITOR.FILES.jdField_b_of_type_JavaLangString, 4, "[AEEditor2]AEEditorResourceManager");
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static AEEditorResourceManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorResourceManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorResourceManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorResourceManager = new AEEditorResourceManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorResourceManager;
  }
  
  @Nullable
  private String b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    Object localObject = a(paramAEEditorDownloadResBean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getId());
    paramAEEditorDownloadResBean = localStringBuilder.toString();
    if (new File(paramAEEditorDownloadResBean).exists()) {
      return paramAEEditorDownloadResBean;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAEEditorDownloadResBean);
    ((StringBuilder)localObject).append(".ttf");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAEEditorDownloadResBean);
    ((StringBuilder)localObject).append(".otf");
    paramAEEditorDownloadResBean = ((StringBuilder)localObject).toString();
    if (new File(paramAEEditorDownloadResBean).exists()) {
      return paramAEEditorDownloadResBean;
    }
    return null;
  }
  
  @WorkerThread
  private void k()
  {
    a(AEPath.Editor.FILES.jdField_d_of_type_JavaLangString, "editor_filter_update_template.json", "camera/ae_camera_editor_display_effects.json", this.g);
    a(AEPath.Editor.FILES.jdField_d_of_type_JavaLangString, "editor_text_sticker_update_template.json", "camera/editor_text_stickers_default.json", this.j);
    a(AEPath.Editor.FILES.jdField_e_of_type_JavaLangString, "editor_frame_update_template.json", "camera/ae_camera_editor_frame.json", this.i);
    a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json", "camera/ae_camera_editor_pic_template.json", this.h);
    a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "camera/ae_camera_editor_text.json", this.jdField_f_of_type_JavaUtilMap);
  }
  
  @WorkerThread
  private void l()
  {
    synchronized (this.jdField_d_of_type_JavaUtilMap)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      Object localObject1 = a("camera/ae_camera_editor_fonts.json");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AEQLog.d(this.jdField_c_of_type_JavaLangString, "setupFontListConfig---read assets json content empty");
        return;
      }
      Object localObject3 = (List)GsonUtils.json2Obj((String)localObject1, new AEEditorResourceManager.1(this).getType());
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupFontListConfig---size = ");
      if (localObject3 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((List)localObject3).size());
      }
      localStringBuilder.append(localObject1);
      AEQLog.b(str, localStringBuilder.toString());
      if (localObject3 != null)
      {
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
          this.jdField_d_of_type_JavaUtilMap.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @WorkerThread
  private void m()
  {
    synchronized (this.jdField_f_of_type_JavaUtilMap)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      Iterator localIterator1 = a().f().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((MetaCategory)localIterator1.next()).materials.iterator();
        while (localIterator2.hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localIterator2.next();
          AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
          localAEEditorDownloadResBean.setId(localMetaMaterial.id);
          localAEEditorDownloadResBean.setUrl(localMetaMaterial.packageUrl);
          localAEEditorDownloadResBean.setMd5(localMetaMaterial.packageMd5);
          String str = (String)localMetaMaterial.additionalFields.get("preDownload");
          if (!TextUtils.isEmpty(str)) {
            localAEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
          }
          this.jdField_f_of_type_JavaUtilMap.put(localMetaMaterial.id, localAEEditorDownloadResBean);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  @WorkerThread
  private void n()
  {
    if (new File("camera/text").exists())
    {
      AEQLog.b("[AEEditor2]AEEditorResourceManager", "ensureSetupTextConfig---pag file is already copied");
      return;
    }
    FileUtils.a(BaseApplicationImpl.getContext(), "camera/text", jdField_e_of_type_JavaLangString);
  }
  
  @NonNull
  public Pair<String, String> a(@NonNull String paramString, int paramInt)
  {
    Object localObject = a(paramString);
    if (localObject != null) {
      localObject = b((AEEditorDownloadResBean)localObject);
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AEQLog.d("[AEEditor2]AEEditorResourceManager", "font not find.");
      return new Pair(localObject, "ERROR_CANNOT_FIND_VALID_FONT");
    }
    if (paramInt == 1) {
      return new Pair(localObject, "SUCCESS_GET_VALID_FONT");
    }
    if (a(paramString))
    {
      AEQLog.d("[AEEditor2]AEEditorResourceManager", "fontExceededLimit.");
      return new Pair(localObject, "ERROR_EXCEEDED_FONT_LIMIT");
    }
    synchronized (this.jdField_e_of_type_JavaUtilMap)
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = b(paramString);
      if (localAEEditorDownloadResBean != null) {
        this.jdField_e_of_type_JavaUtilMap.put(paramString, localAEEditorDownloadResBean);
      }
      paramString = new Pair(localObject, "SUCCESS_GET_VALID_FONT");
      return paramString;
    }
  }
  
  public MutableLiveData<List<MetaCategory>> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  @Nullable
  public AEEditorDownloadResBean a(@NonNull String paramString)
  {
    l();
    m();
    return b(paramString);
  }
  
  @Nullable
  @WorkerThread
  public AEEditorPagStickerConfig a(@NonNull String paramString)
  {
    return (AEEditorPagStickerConfig)GsonUtils.json2Obj(b(paramString), new AEEditorResourceManager.2(this).getType());
  }
  
  public String a()
  {
    a();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIPhotoConfig"));
  }
  
  public String a(MetaMaterial paramMetaMaterial, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("filter");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public String a(String paramString, int paramInt)
  {
    return (String)a(paramString, paramInt).first;
  }
  
  public List<MetaCategory> a()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.jdField_d_of_type_JavaLangString, "editor_filter_update_template.json", "camera/ae_camera_editor_display_effects.json", false);
  }
  
  @NonNull
  public Map<String, AEEditorDownloadResBean> a()
  {
    l();
    return new HashMap(this.jdField_d_of_type_JavaUtilMap);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map<String, AEEditorDownloadResBean> paramMap)
  {
    Object localObject1 = this.jdField_c_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkNeedDownload... json:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" defaultJson:");
    ((StringBuilder)localObject2).append(paramString3);
    AEQLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
    long l = System.currentTimeMillis();
    try
    {
      paramString1 = AEditorMaterialManager.a().a(paramString1, paramString2, paramString3, true);
      if ((paramString1 != null) && (paramString1.size() != 0))
      {
        paramMap.clear();
        paramString2 = this.jdField_c_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("checkNeedDownload... groupList size:");
        paramString3.append(paramString1.size());
        AEQLog.a(paramString2, paramString3.toString());
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = ((MetaCategory)paramString1.next()).materials.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (MetaMaterial)paramString2.next();
            localObject1 = new AEEditorDownloadResBean();
            ((AEEditorDownloadResBean)localObject1).setId(paramString3.id);
            ((AEEditorDownloadResBean)localObject1).setUrl(paramString3.packageUrl);
            ((AEEditorDownloadResBean)localObject1).setMd5(paramString3.packageMd5);
            localObject2 = (String)paramString3.additionalFields.get("preDownload");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((AEEditorDownloadResBean)localObject1).setPreDownload(Integer.parseInt((String)localObject2));
            }
            paramMap.put(paramString3.id, localObject1);
          }
        }
        paramString1 = this.jdField_c_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append("checkNeedDownload... cost:");
        paramString2.append(System.currentTimeMillis() - l);
        AEQLog.a(paramString1, paramString2.toString());
        return;
      }
      AEQLog.d(this.jdField_c_of_type_JavaLangString, "checkNeedDownload... groupList is empty.");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  protected void a(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    k();
    Iterator localIterator = this.g.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.h.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    String str;
    while (this.g.containsKey(paramString))
    {
      str = "AEEditorFilter";
      break;
    }
    if (this.jdField_d_of_type_JavaUtilMap.containsKey(paramString)) {}
    while (this.jdField_f_of_type_JavaUtilMap.containsKey(paramString))
    {
      str = "AEEditorFont";
      break;
    }
    if ((paramString != null) && (paramString.contains("effect_"))) {
      str = "AEEditorEffect";
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str)) {
      AEBaseDataReporter.a().a(paramBoolean, 3, str, paramString, paramInt, paramLong);
    }
  }
  
  public boolean a()
  {
    return new File(a()).exists();
  }
  
  public boolean a(@NonNull String paramString)
  {
    synchronized (this.jdField_e_of_type_JavaUtilMap)
    {
      paramString = (AEEditorDownloadResBean)this.jdField_e_of_type_JavaUtilMap.get(paramString);
      boolean bool = false;
      if (paramString != null) {
        return false;
      }
      if (this.jdField_e_of_type_JavaUtilMap.size() >= this.jdField_b_of_type_Int) {
        bool = true;
      }
      return bool;
    }
  }
  
  public MutableLiveData<List<MetaCategory>> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public AEEditorDownloadResBean b(String paramString)
  {
    Map localMap = this.jdField_d_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.jdField_d_of_type_JavaUtilMap.get(paramString);
    }
    localMap = this.jdField_f_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.jdField_f_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public String b()
  {
    a();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIVideoConfig"));
  }
  
  public String b(MetaMaterial paramMetaMaterial)
  {
    paramMetaMaterial = FilterMetaMaterialKt.a(paramMetaMaterial);
    if (paramMetaMaterial.isEmpty()) {
      return null;
    }
    a();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial);
    if (localAEEditorDownloadResBean == null)
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.g.get(paramMetaMaterial);
      if (localAEEditorDownloadResBean == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(localAEEditorDownloadResBean));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramMetaMaterial);
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(localAEEditorDownloadResBean));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public String b(MetaMaterial paramMetaMaterial, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("segmentation");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public List<MetaCategory> b()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.jdField_e_of_type_JavaLangString, "editor_frame_update_template.json", "camera/ae_camera_editor_frame.json", false);
  }
  
  protected void b(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    Iterator localIterator = this.j.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    l();
    localIterator = this.jdField_d_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    m();
    localIterator = this.jdField_f_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!a(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  public boolean b()
  {
    return new File(b()).exists();
  }
  
  public MutableLiveData<List<MetaCategory>> c()
  {
    return this.jdField_c_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public String c(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("effectInfo.json");
    return localStringBuilder.toString();
  }
  
  public String c(MetaMaterial paramMetaMaterial, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("frame");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    a();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(localAEEditorDownloadResBean));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public List<MetaCategory> c()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json", "camera/ae_camera_editor_pic_template.json", false);
  }
  
  public void c()
  {
    a("AIPhotoConfig", null);
  }
  
  public MutableLiveData<List<MetaCategory>> d()
  {
    return this.jdField_d_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
  }
  
  public String d(MetaMaterial paramMetaMaterial)
  {
    String str = FilterMetaMaterialKt.b(paramMetaMaterial);
    if (!str.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramMetaMaterial));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String d(MetaMaterial paramMetaMaterial, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("text");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public List<MetaCategory> d()
  {
    return AEditorMaterialManager.a().a();
  }
  
  public void d()
  {
    AEQLog.b(this.jdField_c_of_type_JavaLangString, "loadAssets");
    ThreadManager.excute(new AEEditorResourceManager.4(this), 64, null, true);
  }
  
  public MutableLiveData<List<MetaCategory>> e()
  {
    return this.jdField_e_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public String e(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
  }
  
  public String e(MetaMaterial paramMetaMaterial, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sticker");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public List<MetaCategory> e()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.jdField_b_of_type_JavaLangString, "editor_text_sticker_update_template.json", "camera/editor_text_stickers_default.json", false);
  }
  
  public void e()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadFilter...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.5(this), 64, null, true);
      return;
    }
    List localList = a();
    a().postValue(localList);
  }
  
  public MutableLiveData<List<MetaCategory>> f()
  {
    return this.jdField_f_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public String f(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public List<MetaCategory> f()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "camera/ae_camera_editor_text.json", false);
  }
  
  public void f()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadFrame...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.6(this), 64, null, true);
      return;
    }
    List localList = b();
    b().postValue(localList);
  }
  
  public String g(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_text.png");
    return localStringBuilder.toString();
  }
  
  public void g()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadPicTemplate...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.7(this), 64, null, true);
      return;
    }
    List localList = c();
    c().postValue(localList);
  }
  
  public String h(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_texture.png");
    return localStringBuilder.toString();
  }
  
  public void h()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadAutoTemplate...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.8(this), 64, null, true);
      return;
    }
    List localList = d();
    d().postValue(localList);
  }
  
  public String i(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("template.json");
    return localStringBuilder.toString();
  }
  
  public void i()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadSticker...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.9(this), 64, null, true);
      return;
    }
    List localList = e();
    e().postValue(localList);
  }
  
  public String j(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("content.json");
    return localStringBuilder.toString();
  }
  
  public void j()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadText...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.10(this), 64, null, true);
      return;
    }
    List localList = f();
    f().postValue(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager
 * JD-Core Version:    0.7.0.1
 */