package com.tencent.aelight.camera.ae.play;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPath.PLAY;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.control.AEQIMAsyncManager;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class AEPlayShowMaterialManager
  extends AEQIMAsyncManager
{
  public static final int EVENT_MATERIAL_LIST_UPDATED = 1;
  private static final String TAG = "AEPlayShowMaterialManager";
  private AEMaterialManager mMaterialManager;
  private Observable mObservable = new Observable();
  private List<AEMaterialCategory> mPsCategoryList = new LinkedList();
  private final Object mPsCategoryListLock = new Object();
  private String preLoadUrl;
  
  private Map<String, AEMaterialMetaData> buildMaterialDataMap(@Nullable List<AEMaterialCategory> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "buildMaterialDataMap");
    }
    if (paramList == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    paramList = new LinkedList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEMaterialCategory)paramList.next();
      if ((localObject != null) && (((AEMaterialCategory)localObject).a != null) && (((AEMaterialCategory)localObject).a.size() != 0))
      {
        localObject = new LinkedList(((AEMaterialCategory)localObject).a).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localAEMaterialMetaData.m)) && (!TextUtils.isEmpty(localAEMaterialMetaData.s))) {
            localHashMap.put(localAEMaterialMetaData.m, localAEMaterialMetaData);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void deleteMaterialZipAndDir(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMaterialZipAndDir, AEMaterialMetaData.id=");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.m);
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.m);
    if (((File)localObject).exists()) {
      FileUtils.deleteFile(((File)localObject).getPath());
    }
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.deleteDirectory(paramAEMaterialMetaData.getPath());
    }
  }
  
  private void diffTwoListAndDeleteOutdatedMaterial(@NonNull List<AEMaterialCategory> paramList1, @NonNull List<AEMaterialCategory> paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "diffTwoListAndDeleteOutdatedMaterial");
    }
    paramList1 = buildMaterialDataMap(paramList1);
    Map localMap = buildMaterialDataMap(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramList1 = (Map.Entry)localIterator.next();
      String str = (String)paramList1.getKey();
      paramList2 = (AEMaterialMetaData)paramList1.getValue();
      if (paramList2 != null)
      {
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (AEMaterialMetaData)localMap.get(str);
          if ((paramList1 != null) && ((paramList1.P == 4) || (paramList1.P == 5) || (paramList1.P == 6) || (paramList1.P == 7)) && (!paramList1.s.equals(paramList2.s))) {
            paramList1 = paramList2;
          } else {
            paramList1 = null;
          }
        }
        if ((paramList1 != null) && ((paramList1.P == 4) || (paramList1.P == 5) || (paramList1.P == 6) || (paramList1.P == 7))) {
          deleteMaterialZipAndDir(paramList1);
        }
      }
    }
  }
  
  private AEMaterialManager getAEMaterialManager()
  {
    if (this.mMaterialManager == null) {
      this.mMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    }
    return this.mMaterialManager;
  }
  
  private List<AEMaterialCategory> getFilteredPsCategoryList(List<AEMaterialCategory> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return reAssemblePsCategory(paramList, buildMaterialDataMap(new LinkedList(getAEMaterialManager().e())));
  }
  
  private boolean isNotOrdinaryMaterialUsable(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=");
      localStringBuilder.append(paramAEMaterialMetaData.m);
      QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
    }
    switch (paramAEMaterialMetaData.P)
    {
    default: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      getAEMaterialManager();
      return AEMaterialManager.a(paramAEMaterialMetaData);
    }
    return true;
  }
  
  private void notifyMaterialListUpdated()
  {
    AEQLog.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  private List<AEMaterialCategory> parsePsCategoryListFromConfig(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, CameraDataServiceHandler.a);
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Categories != null) && (localGetPlayShowCatMatTreeRsp.Categories.size() != 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < localGetPlayShowCatMatTreeRsp.Categories.size())
      {
        PSMetaCategory localPSMetaCategory = (PSMetaCategory)localGetPlayShowCatMatTreeRsp.Categories.get(i);
        if ((localPSMetaCategory != null) && (localPSMetaCategory.materials != null) && (localPSMetaCategory.materials.size() != 0))
        {
          LinkedList localLinkedList2 = new LinkedList();
          int j = 0;
          int k;
          for (;;)
          {
            int m = localPSMetaCategory.materials.size();
            k = 2;
            if (j >= m) {
              break;
            }
            Object localObject = (PSMetaMaterial)localPSMetaCategory.materials.get(j);
            if ((localObject != null) && (!TextUtils.isEmpty(((PSMetaMaterial)localObject).id)) && (!TextUtils.isEmpty(((PSMetaMaterial)localObject).thumbUrl)))
            {
              if (localHashMap.containsKey(((PSMetaMaterial)localObject).id))
              {
                paramString = (AEMaterialMetaData)localHashMap.get(((PSMetaMaterial)localObject).id);
              }
              else
              {
                paramString = new AEMaterialMetaData();
                paramString.m = ((PSMetaMaterial)localObject).id;
                paramString.t = ((PSMetaMaterial)localObject).id;
                paramString.r = ((PSMetaMaterial)localObject).packageUrl;
                paramString.s = ((PSMetaMaterial)localObject).packageMd5;
                paramString.P = ((PSMetaMaterial)localObject).type;
                paramString.R = ((PSMetaMaterial)localObject).thumbUrl;
                paramString.Q = localPSMetaCategory.id;
                paramString.S = ((PSMetaMaterial)localObject).name;
                Map localMap = ((PSMetaMaterial)localObject).additionalFields;
                if (localMap != null)
                {
                  paramString.T = ((String)localMap.get("web_url"));
                  paramString.U = ((String)localMap.get("mini_app_id"));
                  paramString.H = ((String)localMap.get("takeSameName"));
                  paramString.I = ((String)localMap.get("minimum_device_level"));
                  paramString.J = ((String)localMap.get("shield_devices"));
                }
                paramString.L = shouldShowPlayMaterial(paramString);
              }
              if ((paramString.P != 4) && (paramString.P != 5) && (paramString.P != 6) && (paramString.P != 7))
              {
                if (paramString.P == 2)
                {
                  if (TextUtils.isEmpty(paramString.T))
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("can not show h5 play material, empty webUrl, id:");
                    ((StringBuilder)localObject).append(paramString.m);
                    AEQLog.d("AEPlayShowMaterialManager", ((StringBuilder)localObject).toString());
                    break label647;
                  }
                }
                else if ((paramString.P == 3) && (!TextUtils.isEmpty(paramString.U))) {
                  break label647;
                }
              }
              else {
                if ((TextUtils.isEmpty(paramString.r)) || (TextUtils.isEmpty(paramString.s))) {
                  break label647;
                }
              }
              if (!paramString.L)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("can not show play material id:");
                ((StringBuilder)localObject).append(paramString.m);
                AEQLog.a("AEPlayShowMaterialManager", ((StringBuilder)localObject).toString());
              }
              else
              {
                localHashMap.put(((PSMetaMaterial)localObject).id, paramString);
                localLinkedList2.add(paramString);
              }
            }
            label647:
            j += 1;
          }
          if (localLinkedList2.size() > 0)
          {
            paramString = new AEMaterialCategory();
            paramString.d = localPSMetaCategory.name;
            paramString.c = localPSMetaCategory.id;
            j = k;
            if (localPSMetaCategory.onlyFlag) {
              j = 1;
            }
            paramString.e = j;
            paramString.f = localPSMetaCategory.defaultFlag;
            paramString.a = localLinkedList2;
            localLinkedList1.add(paramString);
          }
        }
        i += 1;
      }
      return localLinkedList1;
    }
    return new LinkedList();
  }
  
  private List<AEMaterialCategory> reAssemblePsCategory(@NonNull List<AEMaterialCategory> paramList, @NonNull Map<String, AEMaterialMetaData> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.preLoadUrl = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      while (j < localAEMaterialCategory.a.size())
      {
        localObject = (AEMaterialMetaData)localAEMaterialCategory.a.get(j);
        if (((AEMaterialMetaData)localObject).P != 0)
        {
          ((AEMaterialMetaData)localObject).A = isNotOrdinaryMaterialUsable((AEMaterialMetaData)localObject);
          localLinkedList2.add(localObject);
          if (((AEMaterialMetaData)localObject).P == 2) {
            this.preLoadUrl = ((AEMaterialMetaData)localObject).T;
          }
        }
        else if (paramMap.containsKey(((AEMaterialMetaData)localObject).m))
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramMap.get(((AEMaterialMetaData)localObject).m);
          localAEMaterialMetaData.R = ((AEMaterialMetaData)localObject).R;
          localAEMaterialMetaData.Q = localAEMaterialCategory.c;
          localAEMaterialMetaData.S = ((AEMaterialMetaData)localObject).S;
          if ((TextUtils.isEmpty(localAEMaterialMetaData.H)) && (!TextUtils.isEmpty(((AEMaterialMetaData)localObject).H))) {
            localAEMaterialMetaData.H = ((AEMaterialMetaData)localObject).H;
          }
          localLinkedList2.add(localAEMaterialMetaData);
        }
        j += 1;
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new AEMaterialCategory();
        ((AEMaterialCategory)localObject).d = localAEMaterialCategory.d;
        ((AEMaterialCategory)localObject).e = localAEMaterialCategory.e;
        ((AEMaterialCategory)localObject).c = localAEMaterialCategory.c;
        ((AEMaterialCategory)localObject).a = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private boolean shouldShowPlayMaterial(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null)
    {
      AEQLog.a("AEPlayShowMaterialManager", " info is null ");
      return true;
    }
    if (ParamsUtil.a(paramAEMaterialMetaData.I) > ParamsUtil.b()) {
      return false;
    }
    if (paramAEMaterialMetaData.J != null)
    {
      String str = ParamsUtil.c();
      if (paramAEMaterialMetaData.J.contains(str)) {
        return false;
      }
    }
    return true;
  }
  
  private void updatePsCategoryListAsync()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private List<AEMaterialCategory> updatePsCategoryListInternal()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    Object localObject1 = new File(AEPath.PLAY.a);
    Object localObject2 = new File(AEPath.PLAY.b);
    if (!((File)localObject2).exists())
    {
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updatePsCategoryListInternal, updatedConfig=null, thread=");
        ((StringBuilder)localObject2).append(Thread.currentThread());
        QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject2).toString());
      }
      if (!((File)localObject1).exists())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updatePsCategoryListInternal, defaultConfig=null, thread=");
          ((StringBuilder)localObject1).append(Thread.currentThread());
          QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject1).toString());
        }
        return new LinkedList();
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updatePsCategoryListInternal, defaultConfig=");
        ((StringBuilder)localObject2).append(((File)localObject1).getPath());
        ((StringBuilder)localObject2).append(", thread=");
        ((StringBuilder)localObject2).append(Thread.currentThread());
        QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject2).toString());
      }
      return getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.a((File)localObject1)));
    }
    if (QLog.isDevelopLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updatePsCategoryListInternal, updatedConfig=");
      ((StringBuilder)localObject3).append(((File)localObject2).getPath());
      ((StringBuilder)localObject3).append(", thread=");
      ((StringBuilder)localObject3).append(Thread.currentThread());
      QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject3).toString());
    }
    if (!((File)localObject1).exists())
    {
      if (QLog.isDevelopLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updatePsCategoryListInternal, defaultConfig=null, thread=");
        ((StringBuilder)localObject3).append(Thread.currentThread());
        QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject3).toString());
      }
      localObject3 = getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.a((File)localObject2)));
      FileUtils.moveFile(((File)localObject2).getPath(), ((File)localObject1).getPath());
      return localObject3;
    }
    if (QLog.isDevelopLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updatePsCategoryListInternal, defaultConfig=");
      ((StringBuilder)localObject3).append(((File)localObject1).getPath());
      ((StringBuilder)localObject3).append(", thread=");
      ((StringBuilder)localObject3).append(Thread.currentThread());
      QLog.d("AEPlayShowMaterialManager", 4, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = parsePsCategoryListFromConfig(QIMPtvTemplateManager.a((File)localObject1));
    List localList = parsePsCategoryListFromConfig(QIMPtvTemplateManager.a((File)localObject2));
    diffTwoListAndDeleteOutdatedMaterial((List)localObject3, localList);
    localObject3 = getFilteredPsCategoryList(localList);
    FileUtils.deleteFile(((File)localObject1).getPath());
    FileUtils.moveFile(((File)localObject2).getPath(), ((File)localObject1).getPath());
    return localObject3;
  }
  
  public void addObserver(Observer paramObserver, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addObserver, observer=");
      localStringBuilder.append(paramObserver);
      localStringBuilder.append(", eventId=");
      localStringBuilder.append(paramInt);
      QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
    }
    this.mObservable.a(paramObserver, new int[] { paramInt });
  }
  
  public void clearCategoryList()
  {
    synchronized (this.mPsCategoryListLock)
    {
      if (this.mPsCategoryList != null) {
        this.mPsCategoryList.clear();
      }
      return;
    }
  }
  
  @Nullable
  public String getPreLoadUrl()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPreLoadUrl, preLoadUrl=");
      localStringBuilder.append(this.preLoadUrl);
      QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
    }
    return this.preLoadUrl;
  }
  
  public List<AEMaterialCategory> getPsCategoryList()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.mPsCategoryList);
  }
  
  protected void initIndeed()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    updatePsCategoryListAsync();
  }
  
  public void refresh()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    updatePsCategoryListAsync();
  }
  
  public void removeObserver(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeObserver, eventId=");
      localStringBuilder.append(paramInt);
      QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
    }
    this.mObservable.a(paramInt);
  }
  
  public void removeObserver(Observer paramObserver)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeObserver, observer=");
      localStringBuilder.append(paramObserver);
      QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
    }
    this.mObservable.a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager
 * JD-Core Version:    0.7.0.1
 */