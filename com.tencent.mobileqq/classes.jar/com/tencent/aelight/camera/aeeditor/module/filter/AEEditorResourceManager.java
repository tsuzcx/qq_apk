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
  public static final String l;
  private static final String m;
  private static volatile AEEditorResourceManager n;
  @NonNull
  private final Map<String, AEEditorDownloadResBean> A = new LinkedHashMap();
  private final int B = ((Integer)ParamsUtil.b(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7))).intValue();
  protected volatile boolean j = false;
  protected volatile boolean k = false;
  private final MutableLiveData<List<MetaCategory>> o = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> p = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> q = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> r = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> s = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> t = new MutableLiveData();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> u = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> v = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> w = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> x = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> y = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> z = new LinkedHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("text");
    m = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("frame");
    l = localStringBuilder.toString();
  }
  
  private AEEditorResourceManager()
  {
    super("camera/ae_camera_editor_download_resources.json", AEEditorPath.EDITOR.FILES.b, 4, "[AEEditor2]AEEditorResourceManager");
  }
  
  @WorkerThread
  private void E()
  {
    a(AEPath.Editor.FILES.d, "editor_filter_update_template.json", "camera/ae_camera_editor_display_effects.json", this.x);
    a(AEPath.Editor.FILES.d, "editor_text_sticker_update_template.json", "camera/editor_text_stickers_default.json", this.A);
    a(AEPath.Editor.FILES.e, "editor_frame_update_template.json", "camera/ae_camera_editor_frame.json", this.z);
    a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json", "camera/ae_camera_editor_pic_template.json", this.y);
    a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "camera/ae_camera_editor_text.json", this.w);
  }
  
  @WorkerThread
  private void F()
  {
    synchronized (this.u)
    {
      if (this.j) {
        return;
      }
      this.j = true;
      Object localObject1 = a("camera/ae_camera_editor_fonts.json");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AEQLog.d(this.d, "setupFontListConfig---read assets json content empty");
        return;
      }
      Object localObject3 = (List)GsonUtils.json2Obj((String)localObject1, new AEEditorResourceManager.1(this).getType());
      String str = this.d;
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
          this.u.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
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
  private void G()
  {
    synchronized (this.w)
    {
      if (this.k) {
        return;
      }
      this.k = true;
      Iterator localIterator1 = a().B().iterator();
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
          this.w.put(localMetaMaterial.id, localAEEditorDownloadResBean);
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
  private void H()
  {
    if (new File("camera/text").exists())
    {
      AEQLog.b("[AEEditor2]AEEditorResourceManager", "ensureSetupTextConfig---pag file is already copied");
      return;
    }
    FileUtils.a(BaseApplicationImpl.getContext(), "camera/text", m);
  }
  
  public static AEEditorResourceManager a()
  {
    if (n == null) {
      try
      {
        if (n == null) {
          n = new AEEditorResourceManager();
        }
      }
      finally {}
    }
    return n;
  }
  
  @Nullable
  private String c(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
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
  
  public List<MetaCategory> A()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json", "camera/editor_text_stickers_default.json", false);
  }
  
  public List<MetaCategory> B()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "camera/ae_camera_editor_text.json", false);
  }
  
  public String C()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public String D()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
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
    return (String)b(paramString, paramInt).first;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map<String, AEEditorDownloadResBean> paramMap)
  {
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkNeedDownload... json:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" defaultJson:");
    ((StringBuilder)localObject2).append(paramString3);
    AEQLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
    long l1 = System.currentTimeMillis();
    try
    {
      paramString1 = AEditorMaterialManager.a().a(paramString1, paramString2, paramString3, true);
      if ((paramString1 != null) && (paramString1.size() != 0))
      {
        paramMap.clear();
        paramString2 = this.d;
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
        paramString1 = this.d;
        paramString2 = new StringBuilder();
        paramString2.append("checkNeedDownload... cost:");
        paramString2.append(System.currentTimeMillis() - l1);
        AEQLog.a(paramString1, paramString2.toString());
        return;
      }
      AEQLog.d(this.d, "checkNeedDownload... groupList is empty.");
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
    E();
    Iterator localIterator = this.x.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.y.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.z.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (this.e.containsKey(paramString)) {}
    String str;
    while (this.x.containsKey(paramString))
    {
      str = "AEEditorFilter";
      break;
    }
    if (this.u.containsKey(paramString)) {}
    while (this.w.containsKey(paramString))
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
  
  @NonNull
  public Pair<String, String> b(@NonNull String paramString, int paramInt)
  {
    Object localObject = e(paramString);
    if (localObject != null) {
      localObject = c((AEEditorDownloadResBean)localObject);
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
    if (g(paramString))
    {
      AEQLog.d("[AEEditor2]AEEditorResourceManager", "fontExceededLimit.");
      return new Pair(localObject, "ERROR_EXCEEDED_FONT_LIMIT");
    }
    synchronized (this.v)
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = f(paramString);
      if (localAEEditorDownloadResBean != null) {
        this.v.put(paramString, localAEEditorDownloadResBean);
      }
      paramString = new Pair(localObject, "SUCCESS_GET_VALID_FONT");
      return paramString;
    }
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
  
  protected void b(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    Iterator localIterator = this.A.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    F();
    localIterator = this.u.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    G();
    localIterator = this.w.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  public String c(MetaMaterial paramMetaMaterial)
  {
    paramMetaMaterial = FilterMetaMaterialKt.m(paramMetaMaterial);
    if (paramMetaMaterial.isEmpty()) {
      return null;
    }
    b();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.e.get(paramMetaMaterial);
    if (localAEEditorDownloadResBean == null)
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.x.get(paramMetaMaterial);
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
    b();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.e.get(paramString);
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
  
  public MutableLiveData<List<MetaCategory>> d()
  {
    return this.o;
  }
  
  @Nullable
  @WorkerThread
  public AEEditorPagStickerConfig d(@NonNull String paramString)
  {
    return (AEEditorPagStickerConfig)GsonUtils.json2Obj(b(paramString), new AEEditorResourceManager.2(this).getType());
  }
  
  public String d(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("effectInfo.json");
    return localStringBuilder.toString();
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
  
  public MutableLiveData<List<MetaCategory>> e()
  {
    return this.p;
  }
  
  @Nullable
  public AEEditorDownloadResBean e(@NonNull String paramString)
  {
    F();
    G();
    return f(paramString);
  }
  
  public String e(MetaMaterial paramMetaMaterial)
  {
    String str = FilterMetaMaterialKt.o(paramMetaMaterial);
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
  
  public MutableLiveData<List<MetaCategory>> f()
  {
    return this.q;
  }
  
  public AEEditorDownloadResBean f(String paramString)
  {
    Map localMap = this.u;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.u.get(paramString);
    }
    localMap = this.w;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.w.get(paramString);
    }
    return null;
  }
  
  public String f(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> g()
  {
    return this.r;
  }
  
  public String g(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public boolean g(@NonNull String paramString)
  {
    synchronized (this.v)
    {
      paramString = (AEEditorDownloadResBean)this.v.get(paramString);
      boolean bool = false;
      if (paramString != null) {
        return false;
      }
      if (this.v.size() >= this.B) {
        bool = true;
      }
      return bool;
    }
  }
  
  public MutableLiveData<List<MetaCategory>> h()
  {
    return this.s;
  }
  
  public String h(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_text.png");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> i()
  {
    return this.t;
  }
  
  public String i(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_texture.png");
    return localStringBuilder.toString();
  }
  
  public String j(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("template.json");
    return localStringBuilder.toString();
  }
  
  public void j()
  {
    a("AIPhotoConfig", null);
  }
  
  public String k(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("content.json");
    return localStringBuilder.toString();
  }
  
  public boolean k()
  {
    return new File(l()).exists();
  }
  
  public String l()
  {
    b();
    return a((AEEditorDownloadResBean)this.e.get("AIPhotoConfig"));
  }
  
  public boolean m()
  {
    return new File(n()).exists();
  }
  
  public String n()
  {
    b();
    return a((AEEditorDownloadResBean)this.e.get("AIVideoConfig"));
  }
  
  @NonNull
  public Map<String, AEEditorDownloadResBean> o()
  {
    F();
    return new HashMap(this.u);
  }
  
  public void p()
  {
    AEQLog.b(this.d, "loadAssets");
    ThreadManager.excute(new AEEditorResourceManager.4(this), 64, null, true);
  }
  
  public void q()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadFilter...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.5(this), 64, null, true);
      return;
    }
    List localList = w();
    d().postValue(localList);
  }
  
  public void r()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadFrame...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.6(this), 64, null, true);
      return;
    }
    List localList = x();
    e().postValue(localList);
  }
  
  public void s()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadPicTemplate...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.7(this), 64, null, true);
      return;
    }
    List localList = y();
    f().postValue(localList);
  }
  
  public void t()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadAutoTemplate...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.8(this), 64, null, true);
      return;
    }
    List localList = z();
    g().postValue(localList);
  }
  
  public void u()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadSticker...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.9(this), 64, null, true);
      return;
    }
    List localList = A();
    h().postValue(localList);
  }
  
  public void v()
  {
    AEQLog.a("[AEEditor2]AEEditorResourceManager", "loadText...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new AEEditorResourceManager.10(this), 64, null, true);
      return;
    }
    List localList = B();
    i().postValue(localList);
  }
  
  public List<MetaCategory> w()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.d, "editor_filter_update_template.json", "camera/ae_camera_editor_display_effects.json", false);
  }
  
  public List<MetaCategory> x()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.e, "editor_frame_update_template.json", "camera/ae_camera_editor_frame.json", false);
  }
  
  public List<MetaCategory> y()
  {
    return AEditorMaterialManager.a().a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json", "camera/ae_camera_editor_pic_template.json", false);
  }
  
  public List<MetaCategory> z()
  {
    return AEditorMaterialManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager
 * JD-Core Version:    0.7.0.1
 */