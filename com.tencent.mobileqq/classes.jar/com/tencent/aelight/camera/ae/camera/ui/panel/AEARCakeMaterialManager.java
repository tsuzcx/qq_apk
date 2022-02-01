package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class AEARCakeMaterialManager
{
  AEARCakeMaterialAdapter a;
  AEARCakePanel.AEARCakePanelListener b;
  private final CopyOnWriteArrayList<AEGiftMaterial> c = new CopyOnWriteArrayList();
  private volatile boolean d = false;
  private String e;
  private int f = -1;
  private AEGiftMaterial g;
  private AEMaterialManager h = (AEMaterialManager)AEQIMManager.a(1);
  private AEARCakeMaterialManager.IARCakeDownloadListener i;
  private AEARCakeMaterial j;
  private boolean k;
  private final ArrayList<AEARCakeMaterialManager.IARcakeMgrListener> l = new ArrayList();
  private AEMaterialDownloader.MaterialDownloadListener m = new AEARCakeMaterialManager.3(this);
  
  public static AEARCakeMaterialManager a()
  {
    return AEARCakeMaterialManager.Holder.a();
  }
  
  private void a(List<AEGiftMaterial> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEGiftMaterial)paramList.next();
      if (localObject != null)
      {
        localObject = ((AEGiftMaterial)localObject).c();
        if (localObject != null) {
          ((AEARCakeMaterial)localObject).A = AEMaterialManager.a((AEMaterialMetaData)localObject);
        }
      }
    }
  }
  
  private void b(AEARCakeMaterial paramAEARCakeMaterial)
  {
    if (paramAEARCakeMaterial == null) {
      return;
    }
    if (paramAEARCakeMaterial.B) {
      return;
    }
    if (TextUtils.isEmpty(paramAEARCakeMaterial.m)) {
      return;
    }
    if (this.h == null) {
      return;
    }
    c(paramAEARCakeMaterial);
  }
  
  private void c(AEARCakeMaterial paramAEARCakeMaterial)
  {
    AEQLog.a("AEARCakeMaterialManager", "arcake : doRealDownload");
    this.j = paramAEARCakeMaterial;
    AEMaterialManager localAEMaterialManager = this.h;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEARCakeMaterial, this.m);
  }
  
  public void a(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter)
  {
    this.a = paramAEARCakeMaterialAdapter;
  }
  
  public void a(AEARCakeMaterialManager.IARCakeDownloadListener paramIARCakeDownloadListener)
  {
    this.i = paramIARCakeDownloadListener;
  }
  
  public void a(AEARCakeMaterialManager.IARcakeMgrListener paramIARcakeMgrListener)
  {
    if (paramIARcakeMgrListener == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "registerListener---the listener param is null");
      return;
    }
    AEQLog.a("AEARCakeMaterialManager", "arcake :registerListener");
    if (!this.l.contains(paramIARcakeMgrListener))
    {
      AEQLog.a("AEARCakeMaterialManager", "add listener");
      this.l.add(paramIARcakeMgrListener);
    }
  }
  
  public void a(AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    this.b = paramAEARCakePanelListener;
  }
  
  public void a(AEARCakeMaterial paramAEARCakeMaterial)
  {
    this.j = paramAEARCakeMaterial;
  }
  
  public void a(AEGiftMaterial paramAEGiftMaterial)
  {
    AEARCakeMaterial localAEARCakeMaterial = paramAEGiftMaterial.c();
    if (localAEARCakeMaterial == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "can not set select first material,arcakematerial is null ");
      return;
    }
    this.f = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : setSelectMaterial");
    localStringBuilder.append(localAEARCakeMaterial.t);
    localStringBuilder.append(" : ");
    localStringBuilder.append(localAEARCakeMaterial.A);
    localStringBuilder.append(": mSelectedPosition");
    localStringBuilder.append(this.f);
    AEQLog.a("AEARCakeMaterialManager", localStringBuilder.toString());
    if ((!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (!localAEARCakeMaterial.A))
    {
      AEQLog.d("AEARCakeMaterialManager", "net work not available");
      ThreadManager.getUIHandler().post(new AEARCakeMaterialManager.1(this));
      return;
    }
    a(paramAEGiftMaterial, this.f);
    if (localAEARCakeMaterial.A)
    {
      if (!AEResUtil.e())
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131907500), 0).show();
        ThreadManager.excute(new AEARCakeMaterialManager.2(this), 64, null, true);
        return;
      }
      paramAEGiftMaterial = new StringBuilder();
      paramAEGiftMaterial.append("arcake : mMaterialPanelListener");
      paramAEGiftMaterial.append(this.b);
      AEQLog.a("AEARCakeMaterialManager", paramAEGiftMaterial.toString());
      paramAEGiftMaterial = this.b;
      if (paramAEGiftMaterial != null) {
        paramAEGiftMaterial.a(localAEARCakeMaterial);
      }
    }
    else
    {
      b(localAEARCakeMaterial);
    }
  }
  
  public void a(AEGiftMaterial paramAEGiftMaterial, int paramInt)
  {
    if (paramAEGiftMaterial == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "arcake gift is null ,can not set anything");
      return;
    }
    this.f = paramInt;
    this.g = paramAEGiftMaterial;
    if (paramAEGiftMaterial.c() == null) {
      AEQLog.d("AEARCakeMaterialManager", "arcake material is null, can not set anything");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  @WorkerThread
  public List<AEGiftMaterial> b()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arcake : getMaterialsSync---mHasLoaded=");
      ((StringBuilder)localObject1).append(this.d);
      AEQLog.b("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
      if (this.d)
      {
        localObject1 = new ArrayList(this.c);
        return localObject1;
      }
      localObject1 = AEGiftMaterialConfigParser.a();
      a((List)localObject1);
      this.c.clear();
      this.c.addAll((Collection)localObject1);
      this.d = true;
      localObject1 = new ArrayList(this.c);
      return localObject1;
    }
    finally {}
  }
  
  public void b(AEARCakeMaterialManager.IARcakeMgrListener paramIARcakeMgrListener)
  {
    this.l.remove(paramIARcakeMgrListener);
  }
  
  public AEGiftMaterial c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.k;
  }
  
  public AEARCakeMaterialManager.IARCakeDownloadListener e()
  {
    return this.i;
  }
  
  public AEARCakeMaterial f()
  {
    return this.j;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public String h()
  {
    Object localObject2 = (PeakAppInterface)AECaptureContext.a();
    Object localObject1 = "you";
    this.e = "you";
    if (localObject2 == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "app interface is null");
      return this.e;
    }
    String str = AECameraPrefsUtil.a().b("key_ae_arcake_preview", "", 4);
    if ((!TextUtils.isEmpty(str)) && ("1".equals(str)))
    {
      this.e = "you";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arcake preview status info : ");
      ((StringBuilder)localObject1).append(this.e);
      AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
      return this.e;
    }
    str = AECameraPrefsUtil.a().b("key_ae_arcake_touin", "", 4);
    if (!TextUtils.isEmpty(str))
    {
      IFriendDataService localIFriendDataService = (IFriendDataService)((PeakAppInterface)localObject2).getRuntimeService(IFriendDataService.class, "all");
      if (localIFriendDataService != null)
      {
        localObject2 = localIFriendDataService.getFriend(str, true, true, true);
        if (localObject2 != null) {
          localObject1 = ((Friends)localObject2).getFriendNick();
        }
        this.e = ((String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("arcake current user is giver info : ");
        ((StringBuilder)localObject1).append(this.e);
        AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
        return this.e;
      }
    }
    this.e = ((PeakAppInterface)localObject2).getCurrentNickname();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake mSelectedARShowInfo current user: ");
    ((StringBuilder)localObject1).append(this.e);
    AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
    return this.e;
  }
  
  public String i()
  {
    String str = h();
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(0, 4));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public void j()
  {
    AEQLog.a("AEARCakeMaterialManager", "arcake : downloadFirstSelectMaterial ");
    Object localObject = this.c;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = (AEGiftMaterial)this.c.get(0);
      if (localObject == null)
      {
        AEQLog.d("AEARCakeMaterialManager", "can not set select first material,giftMaterial is null ");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake : can find ");
      localStringBuilder.append(((AEGiftMaterial)localObject).a());
      AEQLog.a("AEARCakeMaterialManager", localStringBuilder.toString());
      a((AEGiftMaterial)localObject);
      return;
    }
    AEQLog.d("AEARCakeMaterialManager", "can not set select first material");
  }
  
  public void k()
  {
    try
    {
      AEQLog.b("AEARCakeMaterialManager", "arcake : onConfigUpdated---");
      this.d = false;
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        ((AEARCakeMaterialManager.IARcakeMgrListener)localIterator.next()).a();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager
 * JD-Core Version:    0.7.0.1
 */