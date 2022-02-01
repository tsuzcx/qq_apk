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
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorFramePanel
  extends FrameLayout
{
  public static final String a;
  private MaterialClassifierView b;
  private FrameMaterialContentAdapter c;
  private TAVCutImageSession d;
  private ImageTemplateControlListener e;
  private final List<MetaCategory> f = new ArrayList();
  private final List<MetaMaterial> g = new ArrayList();
  private List<String> h;
  private final List<MetaMaterial> i = new ArrayList();
  private MetaMaterial j = null;
  private final SparseArray<String> k = new SparseArray();
  private final SparseArray<String> l = new SparseArray();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AEEditor2]");
    localStringBuilder.append(AEEditorFramePanel.class.getSimpleName());
    a = localStringBuilder.toString();
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
  
  private void a(@NonNull Context paramContext)
  {
    this.b = ((MaterialClassifierView)View.inflate(paramContext, 2064056436, this).findViewById(2063990967));
    this.b.setOnClearButtonClickListener(new AEEditorFramePanel.1(this));
    this.b.setCategoryItemListener(new AEEditorFramePanel.2(this));
    this.c = new FrameMaterialContentAdapter(paramContext);
    this.c.a(c());
    this.b.setup(this.c, this.f, this.g);
  }
  
  private void a(String paramString, int paramInt, MetaMaterial paramMetaMaterial)
  {
    int m = this.d.getCurrentIndex();
    if ("frame".equals(FrameMetaMaterialKt.c(paramMetaMaterial)))
    {
      this.d.addFrame(m, paramString, String.valueOf(Color.parseColor(FrameMetaMaterialKt.a(paramMetaMaterial))));
      this.k.put(m, paramMetaMaterial.id);
      this.l.put(m, FrameMetaMaterialKt.a(paramMetaMaterial));
    }
    else
    {
      this.d.addFrame(m, paramString);
      this.k.put(m, paramMetaMaterial.id);
      this.l.put(m, null);
    }
    paramString = this.b;
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
    localAEQCircleReport.a(paramString, QCircleConstants.y, "0");
  }
  
  private ApplyMaterialTask c()
  {
    return new AEEditorFramePanel.4(this);
  }
  
  public String a(int paramInt)
  {
    return (String)this.k.get(paramInt);
  }
  
  public void a()
  {
    if (this.d != null)
    {
      setSelectedIndex(-1);
      this.k.put(this.d.getCurrentIndex(), null);
      this.l.put(this.d.getCurrentIndex(), null);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    TAVCutImageSession localTAVCutImageSession = this.d;
    if (localTAVCutImageSession != null)
    {
      int m = localTAVCutImageSession.getCurrentIndex();
      this.k.put(m, paramString1);
      this.l.put(m, paramString2);
    }
  }
  
  public void a(List<String> paramList)
  {
    Object localObject1 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSolidFrame... colorList size:");
    localStringBuilder.append(paramList.size());
    AEQLog.a((String)localObject1, localStringBuilder.toString());
    this.h = paramList;
    localObject1 = this.j;
    if (localObject1 == null)
    {
      AEQLog.a(a, "updateSolidFrame... mSolidFrame == null");
      return;
    }
    localObject1 = FrameMetaMaterialKt.b((MetaMaterial)localObject1);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    int n = 0;
    Object localObject3;
    if (!bool)
    {
      localObject1 = ((String)localObject1).split(";");
      int i1 = localObject1.length;
      m = 0;
      while (m < i1)
      {
        localStringBuilder = localObject1[m];
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateSolidFrame... solid frame default color:");
        ((StringBuilder)localObject3).append(localStringBuilder);
        AEQLog.a((String)localObject2, ((StringBuilder)localObject3).toString());
        paramList.add(localStringBuilder);
        m += 1;
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = new Gson();
    localStringBuilder = new StringBuilder();
    int m = n;
    while (m < paramList.size())
    {
      localObject3 = (MetaMaterial)((Gson)localObject2).fromJson(((Gson)localObject2).toJson(this.j), MetaMaterial.class);
      FrameMetaMaterialKt.a((MetaMaterial)localObject3, (String)paramList.get(m));
      localStringBuilder.append((String)paramList.get(m));
      localStringBuilder.append(" ");
      ((ArrayList)localObject1).add(localObject3);
      m += 1;
    }
    paramList = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateSolidFrame... add color list:");
    ((StringBuilder)localObject2).append(localStringBuilder.toString());
    AEQLog.a(paramList, ((StringBuilder)localObject2).toString());
    this.g.clear();
    this.g.addAll(this.i);
    this.g.addAll((Collection)localObject1);
    paramList = this.f.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (MetaCategory)paramList.next();
      if (((MetaCategory)localObject1).id.equals(MetaMaterialKt.g(this.j)))
      {
        ((MetaCategory)localObject1).materials.clear();
        ((MetaCategory)localObject1).materials.addAll(this.g);
      }
    }
    this.b.a();
    ThreadManager.getUIHandler().postDelayed(new AEEditorFramePanel.3(this), 100L);
  }
  
  public boolean a(String paramString)
  {
    FrameMaterialContentAdapter localFrameMaterialContentAdapter = this.c;
    if (localFrameMaterialContentAdapter != null) {
      return localFrameMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  public void b()
  {
    this.k.clear();
    this.l.clear();
  }
  
  public void b(int paramInt)
  {
    if (this.c != null) {
      setSelectedIndex((String)this.k.get(paramInt), (String)this.l.get(paramInt));
    }
  }
  
  public boolean c(int paramInt)
  {
    return TextUtils.isEmpty((CharSequence)this.k.get(paramInt)) ^ true;
  }
  
  public List<MetaMaterial> getFrameMaterials()
  {
    return this.g;
  }
  
  public void setControlListener(ImageTemplateControlListener paramImageTemplateControlListener)
  {
    this.e = paramImageTemplateControlListener;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.c.b(paramInt);
    MaterialClassifierView localMaterialClassifierView = this.b;
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
    List localList = this.c.b();
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
        int m = 0;
        int n = 0;
        if (bool)
        {
          m = n;
          while (m < localList.size())
          {
            if (localList.get(m) == null) {
              return;
            }
            if (paramString1.equals(((MetaMaterial)localList.get(m)).id))
            {
              setSelectedIndex(m);
              return;
            }
            m += 1;
          }
        }
        while (m < localList.size())
        {
          if (localList.get(m) == null) {
            return;
          }
          String str = FrameMetaMaterialKt.a((MetaMaterial)localList.get(m));
          if ((!TextUtils.isEmpty(str)) && (paramString1.equals(((MetaMaterial)localList.get(m)).id)) && (paramString2.equals(str)))
          {
            setSelectedIndex(m);
            return;
          }
          m += 1;
        }
      }
      setSelectedIndex(-1);
    }
  }
  
  public void setTavCutImageSession(TAVCutImageSession paramTAVCutImageSession)
  {
    this.d = paramTAVCutImageSession;
  }
  
  public void setTemplateMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.i.clear();
    this.f.clear();
    this.f.addAll(paramList);
    this.g.clear();
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
            if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.h(localMetaMaterial))) {
              localIterator.remove();
            }
          }
          else if ((FilterMetaMaterialKt.g(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.i(localMetaMaterial))) {
            localIterator.remove();
          }
          if ("frame".equals(FrameMetaMaterialKt.c(localMetaMaterial)))
          {
            String str = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setTemplateMaterials... has solid frame remove material color:");
            localStringBuilder.append(FrameMetaMaterialKt.a(localMetaMaterial));
            AEQLog.a(str, localStringBuilder.toString());
            this.j = localMetaMaterial;
            localIterator.remove();
          }
        }
        this.g.addAll(localMetaCategory.materials);
        this.i.addAll(localMetaCategory.materials);
      }
    }
    if (this.j != null)
    {
      paramList = this.h;
      if ((paramList != null) && (paramList.size() != 0))
      {
        a(this.h);
        this.h.clear();
      }
    }
    this.b.a();
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    FrameMaterialContentAdapter localFrameMaterialContentAdapter = this.c;
    if (localFrameMaterialContentAdapter != null) {
      localFrameMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel
 * JD-Core Version:    0.7.0.1
 */