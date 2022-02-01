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
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AEARCakeMaterialManager
{
  private int jdField_a_of_type_Int = -1;
  AEARCakeMaterialAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter;
  AEARCakePanel.AEARCakePanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener;
  private AEGiftMaterial jdField_a_of_type_ComTencentAelightCameraAeDataAEGiftMaterial;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = (AEMaterialManager)AEQIMManager.a(1);
  private AEMaterialDownloader.MaterialDownloadListener jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener = new AEARCakeMaterialManager.2(this);
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<AEARCakeMaterialManager.IARcakeMgrListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final CopyOnWriteArrayList<AEGiftMaterial> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static AEARCakeMaterialManager a()
  {
    return AEARCakeMaterialManager.Holder.a();
  }
  
  private void a(AEARCakeMaterial paramAEARCakeMaterial)
  {
    if (paramAEARCakeMaterial == null) {
      return;
    }
    if (paramAEARCakeMaterial.f) {
      return;
    }
    if (TextUtils.isEmpty(paramAEARCakeMaterial.k)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager == null) {
      return;
    }
    b(paramAEARCakeMaterial);
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
        localObject = ((AEGiftMaterial)localObject).a();
        if (localObject != null) {
          ((AEARCakeMaterial)localObject).e = AEMaterialManager.a((AEMaterialMetaData)localObject);
        }
      }
    }
  }
  
  private void b(AEARCakeMaterial paramAEARCakeMaterial)
  {
    AEQLog.a("AEARCakeMaterialManager", "arcake : doRealDownload");
    AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEARCakeMaterial, this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AEGiftMaterial a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGiftMaterial;
  }
  
  public String a()
  {
    Object localObject2 = (PeakAppInterface)AECaptureContext.a();
    Object localObject1 = "you";
    this.jdField_a_of_type_JavaLangString = "you";
    if (localObject2 == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "app interface is null");
      return this.jdField_a_of_type_JavaLangString;
    }
    String str = AECameraPrefsUtil.a().a("key_ae_arcake_preview", "", 4);
    if ((!TextUtils.isEmpty(str)) && ("1".equals(str)))
    {
      this.jdField_a_of_type_JavaLangString = "you";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arcake preview status info : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
      return this.jdField_a_of_type_JavaLangString;
    }
    str = AECameraPrefsUtil.a().a("key_ae_arcake_touin", "", 4);
    if (!TextUtils.isEmpty(str))
    {
      IFriendDataService localIFriendDataService = (IFriendDataService)((PeakAppInterface)localObject2).getRuntimeService(IFriendDataService.class, "all");
      if (localIFriendDataService != null)
      {
        localObject2 = localIFriendDataService.getFriend(str, true, true, true);
        if (localObject2 != null) {
          localObject1 = ((Friends)localObject2).getFriendNick();
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("arcake current user is giver info : ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
        return this.jdField_a_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_JavaLangString = ((PeakAppInterface)localObject2).getCurrentNickname();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake mSelectedARShowInfo current user: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    AEQLog.a("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @WorkerThread
  public List<AEGiftMaterial> a()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arcake : getMaterialsSync---mHasLoaded=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      AEQLog.b("AEARCakeMaterialManager", ((StringBuilder)localObject1).toString());
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        return localObject1;
      }
      localObject1 = AEGiftMaterialConfigParser.a();
      a((List)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject1);
      this.jdField_a_of_type_Boolean = true;
      localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    AEQLog.a("AEARCakeMaterialManager", "arcake : downloadFirstSelectMaterial ");
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = (AEGiftMaterial)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
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
  
  public void a(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter = paramAEARCakeMaterialAdapter;
  }
  
  public void a(AEARCakeMaterialManager.IARcakeMgrListener paramIARcakeMgrListener)
  {
    if (paramIARcakeMgrListener == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "registerListener---the listener param is null");
      return;
    }
    AEQLog.a("AEARCakeMaterialManager", "arcake :registerListener");
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramIARcakeMgrListener))
    {
      AEQLog.a("AEARCakeMaterialManager", "add listener");
      this.jdField_a_of_type_JavaUtilArrayList.add(paramIARcakeMgrListener);
    }
  }
  
  public void a(AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = paramAEARCakePanelListener;
  }
  
  public void a(AEGiftMaterial paramAEGiftMaterial)
  {
    AEARCakeMaterial localAEARCakeMaterial = paramAEGiftMaterial.a();
    if (localAEARCakeMaterial == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "can not set select first material,arcakematerial is null ");
      return;
    }
    this.jdField_a_of_type_Int = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : setSelectMaterial");
    localStringBuilder.append(localAEARCakeMaterial.p);
    localStringBuilder.append(" : ");
    localStringBuilder.append(localAEARCakeMaterial.e);
    localStringBuilder.append(": mSelectedPosition");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    AEQLog.a("AEARCakeMaterialManager", localStringBuilder.toString());
    if ((!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (!localAEARCakeMaterial.e))
    {
      AEQLog.d("AEARCakeMaterialManager", "net work not available");
      ToastUtil.a().a(HardCodeUtil.a(2131716132));
      return;
    }
    a(paramAEGiftMaterial, this.jdField_a_of_type_Int);
    if (localAEARCakeMaterial.e)
    {
      if (!AEResUtil.a())
      {
        QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709780), 0).a();
        ThreadManager.excute(new AEARCakeMaterialManager.1(this), 64, null, true);
        return;
      }
      paramAEGiftMaterial = new StringBuilder();
      paramAEGiftMaterial.append("arcake : mMaterialPanelListener");
      paramAEGiftMaterial.append(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener);
      AEQLog.a("AEARCakeMaterialManager", paramAEGiftMaterial.toString());
      paramAEGiftMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener;
      if (paramAEGiftMaterial != null) {
        paramAEGiftMaterial.a(localAEARCakeMaterial);
      }
    }
    else
    {
      a(localAEARCakeMaterial);
    }
  }
  
  public void a(AEGiftMaterial paramAEGiftMaterial, int paramInt)
  {
    if (paramAEGiftMaterial == null)
    {
      AEQLog.d("AEARCakeMaterialManager", "arcake gift is null ,can not set anything");
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGiftMaterial = paramAEGiftMaterial;
    if (paramAEGiftMaterial.a() == null) {
      AEQLog.d("AEARCakeMaterialManager", "arcake material is null, can not set anything");
    }
  }
  
  public String b()
  {
    String str = a();
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
  
  public void b()
  {
    try
    {
      AEQLog.b("AEARCakeMaterialManager", "arcake : onConfigUpdated---");
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public void b(AEARCakeMaterialManager.IARcakeMgrListener paramIARcakeMgrListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramIARcakeMgrListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager
 * JD-Core Version:    0.7.0.1
 */