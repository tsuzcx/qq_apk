package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.IAEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser.AEMaterialConfigParseException;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager;", "Lcom/tencent/aelight/camera/ae/control/IAEQIMManager;", "()V", "mAEMaterialList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "mCosmeticMaterialList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mFavoriteCategory", "mFavoriteListLock", "", "mFileAccessLock", "mFilterList", "mHasLoaded", "", "mMaterialListLock", "mPtvTemplateObservable", "Lcom/tencent/mobileqq/shortvideo/common/Observable;", "mStickerMaterialList", "mUseFlashShowMaterial", "selectedMaterialId", "", "getSelectedMaterialId", "()Ljava/lang/String;", "setSelectedMaterialId", "(Ljava/lang/String;)V", "addAdapterObserver", "", "adapterObserver", "Lcom/tencent/mobileqq/shortvideo/common/Observer;", "eventId", "", "addMaterialToFavorite", "info", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "checkCategoryMaterialsUsable", "category", "checkParamsFilesExist", "clearSelectedMaterial", "deleteMaterialFolder", "templateInfo", "findMaterialListIndex", "material", "", "id", "findSameMaterial", "getCosmeticMaterialList", "getFavoriteGroupName", "getFilterList", "getMaterial", "categoryId", "getMaterialListWithFavorite", "loadFavorite", "getStickerMaterial", "initAsync", "forceRefresh", "initMaterialList", "initSync", "isCosmeticCategory", "cat", "isFavoriteMaterial", "isFilterCategory", "isStickerMaterialCategory", "isTemplateUsable", "loadAndCheckMaterialListUpdate", "oldJsonFile", "Ljava/io/File;", "newJsonFile", "loadFavoriteMaterials", "loadMaterialListFromAssets", "loadMaterialListFromFile", "cacheFile", "notifyEventId", "o", "notifyFavoriteMaterialsUpdated", "notifyMaterialsUpdated", "onConfigRequestCancel", "onConfigRequestDone", "onDestroy", "onInit", "readAndParseConfigFile", "refreshMaterialOfFavorite", "removeAdapterObserver", "observer", "removeMaterialFromFavorite", "resetFlagsWhenLoadFail", "saveFavoriteMaterials", "setSelectedMaterialAndNotify", "addToRecent", "startDownloadDataAsync", "app", "Lcom/tencent/common/app/AppInterface;", "downloadDir", "data", "listener", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "startDownloadMaterial", "startDownloadStickerMaterialAsync", "supportFilament", "useFlashShowMaterial", "enable", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialManager
  extends IAEQIMManager
{
  public static final AEFlashShowMaterialManager.Companion a = new AEFlashShowMaterialManager.Companion(null);
  private static AEMaterialMetaData n;
  private boolean b = true;
  private volatile boolean c;
  private final Object d = new Object();
  private final Object e = new Object();
  private final Object f = new Object();
  private final CopyOnWriteArrayList<AEMaterialCategory> g = new CopyOnWriteArrayList();
  private final CopyOnWriteArrayList<AEMaterialCategory> h = new CopyOnWriteArrayList();
  private final ArrayList<AEMaterialCategory> i = new ArrayList();
  private final ArrayList<AEMaterialCategory> j = new ArrayList();
  private AEMaterialCategory k = new AEMaterialCategory(q());
  private Observable l;
  @NotNull
  private String m = "";
  
  public AEFlashShowMaterialManager()
  {
    AEMaterialCategory localAEMaterialCategory = this.k;
    if (localAEMaterialCategory != null) {
      localAEMaterialCategory.a = ((List)new ArrayList());
    }
  }
  
  private final int a(List<? extends AEMaterialMetaData> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return -1;
      }
      int i1 = 0;
      int i2 = ((Collection)paramList).size();
      while (i1 < i2)
      {
        if (Intrinsics.areEqual(((AEMaterialMetaData)paramList.get(i1)).m, paramString)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private final List<AEMaterialCategory> a(File paramFile)
  {
    List localList = (List)new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty((CharSequence)paramFile)) {
      return localList;
    }
    paramFile = AEMaterialConfigParser.a(paramFile);
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return localList;
      }
      return (List)paramFile;
    }
    return localList;
  }
  
  private final List<AEMaterialCategory> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return paramFile1;
      }
      if (paramFile1 == null) {
        Intrinsics.throwNpe();
      }
      Iterator localIterator1 = paramFile1.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject1 = (AEMaterialCategory)localIterator1.next();
        paramFile2 = (AEMaterialCategory)null;
        Iterator localIterator2 = localList.iterator();
        Object localObject2;
        do
        {
          paramFile1 = paramFile2;
          if (!localIterator2.hasNext()) {
            break;
          }
          paramFile1 = (AEMaterialCategory)localIterator2.next();
          if (paramFile1 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = paramFile1.d;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
        } while (!Intrinsics.areEqual(localObject2, ((AEMaterialCategory)localObject1).d));
        if (paramFile1 == null)
        {
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          paramFile1 = ((AEMaterialCategory)localObject1).a.iterator();
          while (paramFile1.hasNext())
          {
            paramFile2 = (AEMaterialMetaData)paramFile1.next();
            Intrinsics.checkExpressionValueIsNotNull(paramFile2, "item");
            e(paramFile2);
          }
        }
        else
        {
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localIterator2 = ((AEMaterialCategory)localObject1).a.iterator();
          while (localIterator2.hasNext())
          {
            localObject2 = (AEMaterialMetaData)localIterator2.next();
            localObject1 = (AEMaterialMetaData)null;
            Iterator localIterator3 = paramFile1.a.iterator();
            do
            {
              paramFile2 = (File)localObject1;
              if (!localIterator3.hasNext()) {
                break;
              }
              paramFile2 = (AEMaterialMetaData)localIterator3.next();
            } while (!Intrinsics.areEqual(((AEMaterialMetaData)localObject2).m, paramFile2.m));
            if (paramFile2 == null)
            {
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "oldItem");
              e((AEMaterialMetaData)localObject2);
            }
            else if ((Intrinsics.areEqual(((AEMaterialMetaData)localObject2).s, paramFile2.s) ^ true))
            {
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "oldItem");
              e((AEMaterialMetaData)localObject2);
            }
          }
        }
      }
      return localList;
    }
    return paramFile1;
  }
  
  private final void a(AEMaterialCategory paramAEMaterialCategory)
  {
    if (paramAEMaterialCategory != null)
    {
      paramAEMaterialCategory = paramAEMaterialCategory.a;
      if (paramAEMaterialCategory != null)
      {
        paramAEMaterialCategory = paramAEMaterialCategory.iterator();
        while (paramAEMaterialCategory.hasNext())
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramAEMaterialCategory.next();
          if (localAEMaterialMetaData != null) {
            localAEMaterialMetaData.A = a(localAEMaterialMetaData);
          }
        }
      }
    }
  }
  
  private final AEMaterialMetaData b(String paramString)
  {
    synchronized (this.g)
    {
      Object localObject = this.h.iterator();
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((AEMaterialCategory)((Iterator)localObject).next()).a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while (!Intrinsics.areEqual(localAEMaterialMetaData.m, paramString));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNormalStickerMaterial---found id=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)localObject).toString());
      }
      return localAEMaterialMetaData;
      paramString = Unit.INSTANCE;
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final void b(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    AEMaterialDownloader.a(paramAppInterface, paramAEMaterialMetaData, paramString, (AEMaterialDownloader.MaterialDownloadListener)new AEFlashShowMaterialManager.startDownloadMaterial.downloadListener.1(this, paramMaterialDownloadListener));
    paramString = new StringBuilder();
    paramString.append("【START】startDownloadMaterial :");
    if (paramAEMaterialMetaData == null) {
      paramAppInterface = "null";
    } else {
      paramAppInterface = paramAEMaterialMetaData.m;
    }
    paramString.append(paramAppInterface);
    AEQLog.b("AEFlashShowMaterialManager", paramString.toString());
  }
  
  private final boolean b(AEMaterialCategory paramAEMaterialCategory)
  {
    if (paramAEMaterialCategory == null) {
      return false;
    }
    if (paramAEMaterialCategory.b == 10003) {
      return true;
    }
    return !paramAEMaterialCategory.g;
  }
  
  private final boolean c(AEMaterialCategory paramAEMaterialCategory)
  {
    if (paramAEMaterialCategory == null) {
      return false;
    }
    if (paramAEMaterialCategory.b == 10002) {
      return true;
    }
    return !paramAEMaterialCategory.g;
  }
  
  @WorkerThread
  private final void d(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initMaterialList enter---forceRefresh=");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)???).toString());
    }
    for (;;)
    {
      try
      {
        if ((this.c) && (!paramBoolean))
        {
          AEQLog.b("AEFlashShowMaterialManager", "initMaterialList---has inited, fast return");
          return;
        }
        this.c = true;
        ??? = Unit.INSTANCE;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("filament isSupport: ");
        ((StringBuilder)???).append(c());
        AEQLog.b("AEFlashShowMaterialManager", ((StringBuilder)???).toString());
        ??? = new Ref.ObjectRef();
      }
      finally
      {
        Object localObject7;
        continue;
        throw localObject3;
        continue;
        int i1 = 0;
        continue;
        i1 = 1;
        continue;
        i1 = 0;
        continue;
        i1 = 1;
        if (i1 == 0) {
          continue;
        }
        continue;
      }
      synchronized (this.f)
      {
        ((Ref.ObjectRef)???).element = n();
        localObject7 = Unit.INSTANCE;
        ??? = (Collection)((Ref.ObjectRef)???).element;
        if ((??? != null) && (!((Collection)???).isEmpty())) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 != 0)
        {
          AEQLog.d("AEFlashShowMaterialManager", "initMaterialList: materials is empty !");
          return;
        }
        ??? = (List)((Ref.ObjectRef)???).element;
        if (??? != null) {
          synchronized (this.e)
          {
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.g.addAll((Collection)???);
            ??? = ((List)???).iterator();
            if (((Iterator)???).hasNext())
            {
              localObject7 = (AEMaterialCategory)((Iterator)???).next();
              if (localObject7 == null) {
                continue;
              }
              Object localObject8 = (Collection)((AEMaterialCategory)localObject7).a;
              if (localObject8 == null) {
                continue;
              }
              if (!((Collection)localObject8).isEmpty()) {
                continue;
              }
              continue;
              if (i1 != 0)
              {
                localObject8 = (Collection)((AEMaterialCategory)localObject7).h;
                if (localObject8 == null) {
                  continue;
                }
                if (!((Collection)localObject8).isEmpty()) {
                  continue;
                }
                continue;
              }
              a((AEMaterialCategory)localObject7);
              if (c((AEMaterialCategory)localObject7))
              {
                this.j.add(localObject7);
                continue;
              }
              if (b((AEMaterialCategory)localObject7))
              {
                this.i.add(localObject7);
                continue;
              }
              if (!d((AEMaterialCategory)localObject7)) {
                continue;
              }
              localObject8 = new ArrayList();
              AEMaterialConfigParser.a((List)((AEMaterialCategory)localObject7).h, (List)localObject8);
              localObject7 = ((Iterable)localObject8).iterator();
              if (((Iterator)localObject7).hasNext())
              {
                a((AEMaterialCategory)((Iterator)localObject7).next());
                continue;
              }
              this.h.addAll((Collection)localObject8);
              continue;
            }
            ??? = Unit.INSTANCE;
          }
        }
        m();
        synchronized (this.e)
        {
          if ((this.h.size() > 0) && ((true ^ Intrinsics.areEqual(q(), ((AEMaterialCategory)this.h.get(0)).d)))) {
            this.h.add(0, this.k);
          }
          Unit localUnit = Unit.INSTANCE;
          if (QLog.isColorLevel())
          {
            long l2 = System.currentTimeMillis();
            ??? = new StringBuilder();
            ((StringBuilder)???).append("initMaterialList, mStickerMaterialList.size = ");
            ((StringBuilder)???).append(this.h.size());
            QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)???).toString());
            ??? = new StringBuilder();
            ((StringBuilder)???).append("initMaterialList exit, cost = ");
            ((StringBuilder)???).append(l2 - l1);
            ((StringBuilder)???).append("ms");
            QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)???).toString());
          }
          l();
          return;
        }
      }
    }
  }
  
  private final boolean d(AEMaterialCategory paramAEMaterialCategory)
  {
    if (paramAEMaterialCategory == null) {
      return false;
    }
    if (paramAEMaterialCategory.b == 10001) {
      return true;
    }
    return !paramAEMaterialCategory.g;
  }
  
  private final void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMaterialFolder: ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.m);
    if (((File)localObject).exists()) {
      FileUtils.deleteDirectory(((File)localObject).getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.m);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.deleteDirectory(paramAEMaterialMetaData.getPath());
    }
  }
  
  private final boolean f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject = paramAEMaterialMetaData.e();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    boolean bool3 = localFile1.exists();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!((File)localObject).exists())
      {
        bool1 = false;
        try
        {
          File localFile2 = new File(paramAEMaterialMetaData.g());
          if (!localFile2.exists()) {
            return false;
          }
          ZipUtils.unZipFile(localFile2, paramAEMaterialMetaData.f());
          return true;
        }
        catch (Exception paramAEMaterialMetaData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AEFlashShowMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", (Throwable)paramAEMaterialMetaData);
          }
          if ((localFile1.exists()) || (((File)localObject).exists())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final AEMaterialMetaData g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject1 = (AEMaterialMetaData)null;
    Iterator localIterator1 = this.g.iterator();
    Object localObject2;
    int i1;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialCategory)localIterator1.next();
      } while (((AEMaterialCategory)localObject2).a == null);
      int i2 = 0;
      Iterator localIterator2 = ((AEMaterialCategory)localObject2).a.iterator();
      do
      {
        localObject2 = localObject1;
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialMetaData)localIterator2.next();
      } while (!Intrinsics.areEqual(localObject2, paramAEMaterialMetaData));
      i1 = 1;
      localObject1 = localObject2;
    } while (i1 == 0);
    return localObject2;
  }
  
  @JvmStatic
  @NotNull
  public static final String j()
  {
    return a.a();
  }
  
  @JvmStatic
  @Nullable
  public static final AEMaterialMetaData k()
  {
    return a.b();
  }
  
  private final void l()
  {
    Object localObject = getApp();
    if (localObject != null) {
      ((AppInterface)localObject).notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    }
    localObject = this.l;
    if (localObject != null) {
      ((Observable)localObject).a(116, new Object[] { null });
    }
  }
  
  private final void m()
  {
    AEMaterialCategory localAEMaterialCategory = this.k;
    Object localObject1;
    Object localObject4;
    Object localObject6;
    Ref.ObjectRef localObjectRef;
    if (localAEMaterialCategory != null)
    {
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication().runtime");
      localObject4 = ((AppRuntime)localObject1).getAccount();
      if (this.b) {
        localObject1 = "recent_template_flash_show_list";
      } else {
        localObject1 = "recent_template_list_new";
      }
      ??? = AECameraPrefsUtil.a();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append((String)localObject1);
      ((StringBuilder)localObject6).append((String)localObject4);
      localObject1 = ((AECameraPrefsUtil)???).b(((StringBuilder)localObject6).toString(), null, 0);
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("loadFavoriteMaterials list=");
        ((StringBuilder)localObject4).append((String)localObject1);
        QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)localObject4).toString());
      }
      if (localObject1 == null) {
        return;
      }
      localObject1 = (CharSequence)localObject1;
      localObject1 = ((Collection)new Regex("\\$").split((CharSequence)localObject1, 0)).toArray(new String[0]);
      if (localObject1 != null)
      {
        localObject6 = (String[])localObject1;
        localObjectRef = new Ref.ObjectRef();
      }
    }
    for (;;)
    {
      int i1;
      synchronized (this.d)
      {
        localObject1 = localAEMaterialCategory.a;
        if (localObject1 != null) {
          ((List)localObject1).clear();
        }
        int i2 = localObject6.length;
        i1 = 0;
        if (i1 < i2)
        {
          localObject1 = (CharSequence)localObject6[i1];
          localObject1 = ((Collection)new Regex("\\|").split((CharSequence)localObject1, 0)).toArray(new String[0]);
          if (localObject1 != null)
          {
            localObjectRef.element = ((String[])localObject1);
            if (((String[])localObjectRef.element).length != 2) {
              break label429;
            }
            localObject1 = ((String[])localObjectRef.element)[0];
            if (localObject1 == null) {
              break label418;
            }
            localObject1 = b((String)localObject1);
            if (localAEMaterialCategory.a.contains(localObject1)) {
              break label429;
            }
            if (localObject1 == null) {
              break label423;
            }
            localObject4 = ((AEMaterialMetaData)localObject1).m;
            if (Intrinsics.areEqual(localObject4, "0")) {
              break label429;
            }
            localAEMaterialCategory.a.add(localObject1);
            break label429;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        localObject1 = Unit.INSTANCE;
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      return;
      label418:
      Object localObject3 = null;
      continue;
      label423:
      localObject4 = null;
      continue;
      label429:
      i1 += 1;
    }
  }
  
  private final List<AEMaterialCategory> n()
  {
    Object localObject1;
    if (this.b) {
      localObject1 = "camera_flash_show_update_template.json";
    } else {
      localObject1 = "camera_story_update_template.json";
    }
    Object localObject3 = new File(AEPath.CAMERA.FILES.j, (String)localObject1);
    Object localObject2 = new File(AEPath.CAMERA.FILES.j, "camera_flash_show_default_template.json");
    List localList;
    if (!((File)localObject3).exists())
    {
      if (!((File)localObject2).exists())
      {
        localObject1 = o();
        AEQLog.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        p();
        return localObject1;
      }
      try
      {
        localObject1 = a((File)localObject2);
        AEQLog.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
      {
        FileUtils.deleteFile(((File)localObject2).getPath());
        localObject2 = o();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
        ((StringBuilder)localObject3).append(localAEMaterialConfigParseException1);
        AEQLog.d("AEFlashShowMaterialManager", ((StringBuilder)localObject3).toString());
        p();
        return localObject2;
      }
    }
    else
    {
      if (!((File)localObject2).exists()) {}
      for (;;)
      {
        try
        {
          localList = a((File)localObject3);
          FileUtils.moveFile(((File)localObject3).getPath(), ((File)localObject2).getPath());
          AEQLog.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
          return localList;
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          FileUtils.deleteFile(((File)localObject3).getPath());
          localList = o();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("readAndParseConfigFile -> oldJson not exists: exception:");
          ((StringBuilder)localObject3).append(localAEMaterialConfigParseException2);
          AEQLog.d("AEFlashShowMaterialManager", ((StringBuilder)localObject3).toString());
          p();
        }
        try
        {
          localList = a(localAEMaterialConfigParseException2, (File)localObject3);
          FileUtils.deleteFile(localAEMaterialConfigParseException2.getPath());
          FileUtils.moveFile(((File)localObject3).getPath(), localAEMaterialConfigParseException2.getPath());
          AEQLog.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> try check update ");
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
        {
          localList = o();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("loadMaterialListFromAssets  -> oldJson exists: exception:");
          ((StringBuilder)localObject3).append(localAEMaterialConfigParseException3);
          AEQLog.d("AEFlashShowMaterialManager", ((StringBuilder)localObject3).toString());
          p();
        }
      }
    }
    return localList;
  }
  
  private final List<AEMaterialCategory> o()
  {
    List localList = (List)new ArrayList();
    Object localObject = getApp();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app");
    localObject = CameraOperationHelper.a((Context)((AppInterface)localObject).getApp());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localList;
    }
    try
    {
      localObject = AEMaterialConfigParser.a((String)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AEMaterialConfigParser.p…alListFromConfig(content)");
      localObject = (List)localObject;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return localList;
        }
        return localObject;
      }
      return localList;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMaterialListFromAssets err=");
      localStringBuilder.append(localAEMaterialConfigParseException.getMessage());
      QLog.d("AEFlashShowMaterialManager", 4, localStringBuilder.toString());
    }
    return localList;
  }
  
  private final void p()
  {
    AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqKuaishanCamera", 4);
    try
    {
      this.c = false;
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final String q()
  {
    String str = HardCodeUtil.a(2131906828);
    Intrinsics.checkExpressionValueIsNotNull(str, "HardCodeUtil.qqStr(R.str….qqstr_qbpublic_17d37de5)");
    return str;
  }
  
  private final void r()
  {
    Observable localObservable = this.l;
    if ((localObservable != null) && (localObservable != null)) {
      localObservable.a(111, new Object[] { this.k });
    }
  }
  
  @NotNull
  public final String a()
  {
    return this.m;
  }
  
  public final void a(int paramInt)
  {
    try
    {
      Observable localObservable = this.l;
      if (localObservable != null) {
        localObservable.a(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt, @Nullable Object paramObject)
  {
    Observable localObservable = this.l;
    if (localObservable != null)
    {
      if (localObservable != null) {
        localObservable.a(paramInt, new Object[] { paramObject });
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("notifyEventId eventId=");
        paramObject.append(paramInt);
        QLog.d("AEFlashShowMaterialManager", 2, paramObject.toString());
      }
    }
  }
  
  public final void a(@Nullable AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedMaterialAndNotify---info=");
    String str;
    if (paramAEMaterialMetaData == null) {
      str = "null";
    } else {
      str = paramAEMaterialMetaData.m;
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", addToRecent=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEFlashShowMaterialManager", localStringBuilder.toString());
    n = paramAEMaterialMetaData;
    AEFlashShowBottomPanelViewModel.a.a().postValue(paramAEMaterialMetaData);
    a(113, null);
  }
  
  public final void a(@Nullable AppInterface paramAppInterface, @Nullable AEMaterialMetaData paramAEMaterialMetaData, @Nullable AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    a(paramAppInterface, AEPath.CAMERA.FILES.h, paramAEMaterialMetaData, paramMaterialDownloadListener);
  }
  
  public final void a(@Nullable AppInterface paramAppInterface, @Nullable String paramString, @Nullable AEMaterialMetaData paramAEMaterialMetaData, @Nullable AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    ThreadManager.excute((Runnable)new AEFlashShowMaterialManager.startDownloadDataAsync.1(this, paramAppInterface, paramString, paramAEMaterialMetaData, paramMaterialDownloadListener), 128, null, true);
  }
  
  public final void a(@Nullable Observer paramObserver)
  {
    try
    {
      Observable localObservable = this.l;
      if (localObservable != null) {
        localObservable.a(paramObserver);
      }
      return;
    }
    finally {}
  }
  
  public final void a(@Nullable Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.l == null) {
        this.l = new Observable();
      }
      Observable localObservable = this.l;
      if (localObservable != null) {
        localObservable.a(paramObserver, new int[] { paramInt });
      }
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.m = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    d(paramBoolean);
  }
  
  public final boolean a(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    boolean bool;
    if (paramAEMaterialMetaData != null) {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)paramAEMaterialMetaData.t)) {
          bool = f(paramAEMaterialMetaData);
        }
      }
      finally {}
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void b()
  {
    AEQLog.b("AEFlashShowMaterialManager", "onConfigRequestDone---notify all wait thread");
  }
  
  public final void b(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.d()) {
      return;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        localObject1 = this.k;
        if (localObject1 != null)
        {
          localObject1 = ((AEMaterialCategory)localObject1).a;
          String str = paramAEMaterialMetaData.m;
          Intrinsics.checkExpressionValueIsNotNull(str, "info.id");
          int i1 = a((List)localObject1, str);
          if (i1 == -1)
          {
            localObject1 = this.k;
            if (localObject1 != null)
            {
              localObject1 = ((AEMaterialCategory)localObject1).a;
              if (localObject1 != null) {
                ((List)localObject1).add(0, paramAEMaterialMetaData);
              }
            }
            paramAEMaterialMetaData.Z = false;
            r();
            if (QLog.isColorLevel()) {
              QLog.d("AEFlashShowMaterialManager", 2, "addMaterialToFavorite not exist before");
            }
          }
          else if (i1 >= 0)
          {
            paramAEMaterialMetaData.Z = false;
            r();
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("addMaterialToFavorite index=");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = Unit.INSTANCE;
          AEFlashShowBottomPanelViewModel.a.b().postValue(paramAEMaterialMetaData);
          return;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    ThreadManager.excute((Runnable)new AEFlashShowMaterialManager.initAsync.1(this, paramBoolean), 64, null, false);
  }
  
  @NotNull
  public final List<AEMaterialCategory> c(boolean paramBoolean)
  {
    return (List)this.h;
  }
  
  public final void c(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.d()) {
      return;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        localObject1 = this.k;
        if (localObject1 != null)
        {
          localObject1 = ((AEMaterialCategory)localObject1).a;
          String str = paramAEMaterialMetaData.m;
          Intrinsics.checkExpressionValueIsNotNull(str, "info.id");
          if (a((List)localObject1, str) == -1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AEFlashShowMaterialManager", 2, "removeMaterialFromFavorite, material not exist!");
            }
          }
          else
          {
            paramAEMaterialMetaData.Z = true;
            r();
            AEFlashShowBottomPanelViewModel.a.b().postValue(paramAEMaterialMetaData);
          }
          paramAEMaterialMetaData = Unit.INSTANCE;
          return;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = FeatureManager.Features.LIGHT_SDK.supportAceEngine();
      return bool;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public final void d()
  {
    ??? = this.k;
    if (??? != null) {
      ??? = ((AEMaterialCategory)???).a;
    } else {
      ??? = null;
    }
    ??? = (Collection)???;
    int i1;
    if ((??? != null) && (!((Collection)???).isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return;
    }
    synchronized (this.d)
    {
      Object localObject2 = new StringBuilder();
      Object localObject4 = this.k;
      if (localObject4 != null)
      {
        localObject4 = ((AEMaterialCategory)localObject4).a;
        if (localObject4 != null) {
          CollectionsKt.removeAll((List)localObject4, (Function1)AEFlashShowMaterialManager.saveFavoriteMaterials.1.1.INSTANCE);
        }
      }
      localObject4 = this.k;
      if (localObject4 != null)
      {
        localObject4 = ((AEMaterialCategory)localObject4).a;
        if (localObject4 != null)
        {
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (AEMaterialMetaData)((Iterator)localObject4).next();
            if ((!TextUtils.isEmpty((CharSequence)((AEMaterialMetaData)localObject5).m)) && ((Intrinsics.areEqual(localObject5, AEMaterialMetaData.l) ^ true)))
            {
              ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject5).m);
              ((StringBuilder)localObject2).append("|");
              ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject5).n);
              ((StringBuilder)localObject2).append("$");
            }
          }
        }
      }
      boolean bool = TextUtils.isEmpty((CharSequence)((StringBuilder)localObject2).toString());
      if (bool) {
        return;
      }
      localObject4 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "BaseApplicationImpl.getApplication()");
      localObject4 = ((BaseApplicationImpl)localObject4).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "BaseApplicationImpl.getApplication().runtime");
      localObject4 = ((AppRuntime)localObject4).getAccount();
      Object localObject5 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recent_template_flash_show_list");
      localStringBuilder.append((String)localObject4);
      ((AECameraPrefsUtil)localObject5).a(localStringBuilder.toString(), ((StringBuilder)localObject2).toString(), 0);
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("saveFavoriteMaterials list=");
        ((StringBuilder)localObject4).append(localObject2);
        QLog.d("AEFlashShowMaterialManager", 2, ((StringBuilder)localObject4).toString());
      }
      localObject2 = Unit.INSTANCE;
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public final boolean d(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    boolean bool2 = false;
    if (paramAEMaterialMetaData == null) {
      return false;
    }
    if (paramAEMaterialMetaData.d()) {
      return false;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        localObject1 = this.k;
        if (localObject1 != null)
        {
          localObject1 = ((AEMaterialCategory)localObject1).a;
          String str = paramAEMaterialMetaData.m;
          Intrinsics.checkExpressionValueIsNotNull(str, "info.id");
          boolean bool1 = bool2;
          if (a((List)localObject1, str) != -1)
          {
            boolean bool3 = paramAEMaterialMetaData.Z;
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
          return bool1;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public final void e()
  {
    ??? = this.k;
    if (??? != null) {
      ??? = ((AEMaterialCategory)???).a;
    } else {
      ??? = null;
    }
    ??? = (Collection)???;
    int i1;
    if ((??? != null) && (!((Collection)???).isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return;
    }
    synchronized (this.d)
    {
      Object localObject2 = this.k;
      if (localObject2 != null)
      {
        localObject2 = ((AEMaterialCategory)localObject2).a;
        if (localObject2 != null)
        {
          if (CollectionsKt.removeAll((List)localObject2, (Function1)AEFlashShowMaterialManager.refreshMaterialOfFavorite.1.1.INSTANCE)) {
            r();
          }
          localObject2 = Unit.INSTANCE;
        }
      }
      return;
    }
  }
  
  public final void f()
  {
    n = (AEMaterialMetaData)null;
  }
  
  @NotNull
  public final List<AEMaterialCategory> g()
  {
    return (List)this.j;
  }
  
  @NotNull
  public final List<AEMaterialCategory> h()
  {
    return (List)this.i;
  }
  
  public void onDestroy()
  {
    AEQLog.b("AEFlashShowMaterialManager", "onDestroy");
  }
  
  public void onInit()
  {
    AEQLog.b("AEFlashShowMaterialManager", "onInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager
 * JD-Core Version:    0.7.0.1
 */