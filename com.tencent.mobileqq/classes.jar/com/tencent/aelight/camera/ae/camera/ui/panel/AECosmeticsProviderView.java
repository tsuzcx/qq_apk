package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.control.IAEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.facedetect.GenderType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$ItemClickListener;", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cosmeticListManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "cosmeticsViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;", "genderType", "", "getGenderType", "()I", "setGenderType", "(I)V", "mApp", "Lcom/tencent/common/app/AppInterface;", "kotlin.jvm.PlatformType", "mCosmeticDataChangeObserver", "com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView$mCosmeticDataChangeObserver$1", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView$mCosmeticDataChangeObserver$1;", "mTemplateManager", "Lcom/tencent/aelight/camera/ae/control/IAEQIMManager;", "pendingSelectItem", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "viewModelStoreOwner", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "bindLifeCycle", "", "partManager", "Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;", "getCosmeticMaterialList", "", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "initAsync", "initViewModel", "loadCosmeticList", "loadDataFromAsset", "", "loadFilterFromAsset", "loadRealFilters", "onDestroy", "onDownloadFinish", "info", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "isUsable", "resCode", "onItemClick", "item", "position", "onProgressUpdate", "progress", "onProviderDismiss", "onProviderShow", "onResume", "sortByGender", "cosmeticList", "startDownloadStickerMaterialAsync", "app", "data", "listener", "unAssetZip", "assetName", "", "destName", "versionCode", "unzipAndCopyAssetToSdcard", "versionFile", "Ljava/io/File;", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AECosmeticsProviderView
  extends FrameLayout
  implements DYAEEffectListHolder.ItemClickListener, AEMaterialDownloader.MaterialDownloadListener
{
  public static final AECosmeticsProviderView.Companion a = new AECosmeticsProviderView.Companion(null);
  private AEPituCameraUnit b;
  private AECosmeticsViewModel c;
  private final AppInterface d = AECaptureContext.a();
  private DYAEEffectItem e;
  private final DYAEEffectListHolder f = new DYAEEffectListHolder(paramContext, (ViewGroup)this, (DYAEEffectListHolder.ItemClickListener)this);
  private int g = GenderType.DEFAULT.value;
  private IAEQIMManager h = DYAEBeautyPanelConfigHolder.a().f();
  private final AECosmeticsProviderView.mCosmeticDataChangeObserver.1 i = new AECosmeticsProviderView.mCosmeticDataChangeObserver.1(this);
  
  public AECosmeticsProviderView(@NotNull Context paramContext)
  {
    super(paramContext);
    e();
    this.d.registObserver((BusinessObserver)this.i);
  }
  
  private final List<DYAEEffectItem> a(List<? extends DYAEEffectItem> paramList)
  {
    if (this.g == GenderType.MALE.value) {
      return CollectionsKt.sortedWith((Iterable)paramList, (Comparator)new AECosmeticsProviderView.sortByGender..inlined.sortedBy.1());
    }
    if (((((Collection)paramList).isEmpty() ^ true)) && (DYAEEffectItemExtKt.a(paramList.get(0)))) {
      ((DYAEEffectItem)paramList.get(0)).b(2147483646);
    }
    return CollectionsKt.sortedWith((Iterable)paramList, (Comparator)new AECosmeticsProviderView.sortByGender..inlined.sortedBy.2());
  }
  
  private final void a(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    IAEQIMManager localIAEQIMManager = this.h;
    if ((localIAEQIMManager instanceof AEFlashShowMaterialManager))
    {
      AEQLog.b("AECosmeticProviderView", "download in flash mode");
      ((AEFlashShowMaterialManager)localIAEQIMManager).a(paramAppInterface, paramAEMaterialMetaData, paramMaterialDownloadListener);
      return;
    }
    if ((localIAEQIMManager instanceof AEMaterialManager))
    {
      AEQLog.b("AECosmeticProviderView", "download in default mode");
      ((AEMaterialManager)localIAEQIMManager).a(paramAppInterface, paramAEMaterialMetaData, paramMaterialDownloadListener);
    }
  }
  
  /* Error */
  private final void a(java.io.File paramFile, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 252	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: getstatic 258	com/tencent/aelight/camera/ae/AEPath$CAMERA$CACHE:a	Ljava/lang/String;
    //   14: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 5
    //   20: ldc_w 264
    //   23: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 266	java/io/File
    //   30: dup
    //   31: aload 5
    //   33: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 276	java/io/File:exists	()Z
    //   46: ifeq +9 -> 55
    //   49: aload 5
    //   51: invokevirtual 279	java/io/File:delete	()Z
    //   54: pop
    //   55: aload_0
    //   56: invokevirtual 283	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:getContext	()Landroid/content/Context;
    //   59: aload_2
    //   60: aload 5
    //   62: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: invokestatic 292	com/tencent/mobileqq/utils/FileUtils:copyAssetToFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 5
    //   71: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: aload_3
    //   75: iconst_0
    //   76: invokestatic 296	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   79: new 298	java/io/OutputStreamWriter
    //   82: dup
    //   83: new 300	java/io/FileOutputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 303	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: checkcast 305	java/io/OutputStream
    //   94: getstatic 311	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   97: invokespecial 314	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   100: checkcast 316	java/io/Writer
    //   103: astore_1
    //   104: aload_1
    //   105: instanceof 318
    //   108: ifeq +11 -> 119
    //   111: aload_1
    //   112: checkcast 318	java/io/BufferedWriter
    //   115: astore_1
    //   116: goto +15 -> 131
    //   119: new 318	java/io/BufferedWriter
    //   122: dup
    //   123: aload_1
    //   124: sipush 8192
    //   127: invokespecial 321	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   130: astore_1
    //   131: aload_1
    //   132: checkcast 323	java/io/Closeable
    //   135: astore_3
    //   136: aconst_null
    //   137: checkcast 250	java/lang/Throwable
    //   140: astore_2
    //   141: aload_2
    //   142: astore_1
    //   143: aload_3
    //   144: checkcast 318	java/io/BufferedWriter
    //   147: aload 4
    //   149: invokevirtual 326	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: astore_1
    //   154: getstatic 332	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   157: astore 4
    //   159: aload_3
    //   160: aload_2
    //   161: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   164: return
    //   165: astore_2
    //   166: goto +8 -> 174
    //   169: astore_2
    //   170: aload_2
    //   171: astore_1
    //   172: aload_2
    //   173: athrow
    //   174: aload_3
    //   175: aload_1
    //   176: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	AECosmeticsProviderView
    //   0	181	1	paramFile	java.io.File
    //   0	181	2	paramString1	String
    //   0	181	3	paramString2	String
    //   0	181	4	paramString3	String
    //   7	63	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   143	152	165	finally
    //   154	159	165	finally
    //   172	174	165	finally
    //   143	152	169	java/lang/Throwable
    //   154	159	169	java/lang/Throwable
  }
  
  /* Error */
  private final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 266	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 342	java/io/File:isFile	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 7
    //   20: invokevirtual 279	java/io/File:delete	()Z
    //   23: pop
    //   24: new 266	java/io/File
    //   27: dup
    //   28: aload 7
    //   30: ldc_w 344
    //   33: invokespecial 347	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 7
    //   40: invokevirtual 276	java/io/File:exists	()Z
    //   43: ifeq +172 -> 215
    //   46: aload 8
    //   48: invokevirtual 276	java/io/File:exists	()Z
    //   51: ifeq +133 -> 184
    //   54: aload 8
    //   56: invokevirtual 342	java/io/File:isFile	()Z
    //   59: ifeq +125 -> 184
    //   62: new 349	java/io/InputStreamReader
    //   65: dup
    //   66: new 351	java/io/FileInputStream
    //   69: dup
    //   70: aload 8
    //   72: invokespecial 352	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: checkcast 354	java/io/InputStream
    //   78: getstatic 311	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   81: invokespecial 357	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   84: checkcast 359	java/io/Reader
    //   87: astore 4
    //   89: aload 4
    //   91: instanceof 361
    //   94: ifeq +13 -> 107
    //   97: aload 4
    //   99: checkcast 361	java/io/BufferedReader
    //   102: astore 4
    //   104: goto +17 -> 121
    //   107: new 361	java/io/BufferedReader
    //   110: dup
    //   111: aload 4
    //   113: sipush 8192
    //   116: invokespecial 364	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   119: astore 4
    //   121: aload 4
    //   123: checkcast 323	java/io/Closeable
    //   126: astore 9
    //   128: aconst_null
    //   129: checkcast 250	java/lang/Throwable
    //   132: astore 5
    //   134: aload 5
    //   136: astore 4
    //   138: aload 9
    //   140: checkcast 361	java/io/BufferedReader
    //   143: checkcast 359	java/io/Reader
    //   146: invokestatic 370	kotlin/io/TextStreamsKt:readText	(Ljava/io/Reader;)Ljava/lang/String;
    //   149: astore 6
    //   151: aload 9
    //   153: aload 5
    //   155: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   158: aload 6
    //   160: astore 4
    //   162: goto +27 -> 189
    //   165: astore_1
    //   166: goto +9 -> 175
    //   169: astore_1
    //   170: aload_1
    //   171: astore 4
    //   173: aload_1
    //   174: athrow
    //   175: aload 9
    //   177: aload 4
    //   179: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: athrow
    //   184: ldc_w 372
    //   187: astore 4
    //   189: aload 4
    //   191: aload_3
    //   192: invokestatic 376	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   195: iconst_1
    //   196: ixor
    //   197: ifeq +18 -> 215
    //   200: aload 7
    //   202: invokevirtual 279	java/io/File:delete	()Z
    //   205: pop
    //   206: aload_0
    //   207: aload 8
    //   209: aload_1
    //   210: aload_2
    //   211: aload_3
    //   212: invokespecial 378	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:a	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 7
    //   217: invokevirtual 276	java/io/File:exists	()Z
    //   220: ifeq +4 -> 224
    //   223: return
    //   224: aload_0
    //   225: aload 8
    //   227: aload_1
    //   228: aload_2
    //   229: aload_3
    //   230: invokespecial 378	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:a	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   233: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	AECosmeticsProviderView
    //   0	234	1	paramString1	String
    //   0	234	2	paramString2	String
    //   0	234	3	paramString3	String
    //   87	103	4	localObject	Object
    //   132	22	5	localThrowable	java.lang.Throwable
    //   149	10	6	str	String
    //   8	208	7	localFile1	java.io.File
    //   36	190	8	localFile2	java.io.File
    //   126	50	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   138	151	165	finally
    //   173	175	165	finally
    //   138	151	169	java/lang/Throwable
  }
  
  private final void e()
  {
    IAEQIMManager localIAEQIMManager = this.h;
    if ((localIAEQIMManager instanceof AEFlashShowMaterialManager))
    {
      ((AEFlashShowMaterialManager)localIAEQIMManager).b(false);
      return;
    }
    if ((localIAEQIMManager instanceof AEMaterialManager)) {
      ((AEMaterialManager)localIAEQIMManager).b(false);
    }
  }
  
  private final void f()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      Object localObject2 = AEViewModelProviders.a((ViewModelStoreOwner)localObject1).get(AECosmeticsViewModel.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "AEViewModelProviders.of(…icsViewModel::class.java)");
      this.c = ((AECosmeticsViewModel)localObject2);
      localObject2 = this.c;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
      }
      localObject2 = ((AECosmeticsViewModel)localObject2).b();
      localObject1 = (LifecycleOwner)localObject1;
      ((LiveData)localObject2).observe((LifecycleOwner)localObject1, (Observer)new AECosmeticsProviderView.initViewModel..inlined.let.lambda.1(this));
      localObject2 = this.c;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
      }
      ((AECosmeticsViewModel)localObject2).a().observe((LifecycleOwner)localObject1, (Observer)new AECosmeticsProviderView.initViewModel..inlined.let.lambda.2(this));
    }
    g();
  }
  
  private final void g()
  {
    ThreadManager.getFileThreadHandler().post((Runnable)new AECosmeticsProviderView.loadCosmeticList.1(this));
  }
  
  private final List<AEMaterialCategory> getCosmeticMaterialList()
  {
    Object localObject = this.h;
    if ((localObject instanceof AEFlashShowMaterialManager))
    {
      AEQLog.b("AECosmeticProviderView", "get list from  flash mode");
      return ((AEFlashShowMaterialManager)localObject).h();
    }
    if ((localObject instanceof AEMaterialManager))
    {
      AEQLog.b("AECosmeticProviderView", "get list from default mode");
      localObject = ((AEMaterialManager)localObject).d();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "templateManager.cosmeticMaterialList");
      return localObject;
    }
    return CollectionsKt.emptyList();
  }
  
  private final boolean h()
  {
    return false;
  }
  
  private final List<DYAEEffectItem> i()
  {
    Object localObject1 = (Iterable)getCosmeticMaterialList();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((AEMaterialCategory)((Iterator)localObject1).next()).a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.materialList");
      CollectionsKt.addAll(localCollection, (Iterable)localObject2);
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (j < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (AEMaterialMetaData)localObject2;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "material");
      DYAEMaterialItem localDYAEMaterialItem = new DYAEMaterialItem((AEMaterialMetaData)localObject2);
      localDYAEMaterialItem.a(j);
      try
      {
        String str = ((AEMaterialMetaData)localObject2).K;
        Intrinsics.checkExpressionValueIsNotNull(str, "material.orderFemale");
        k = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        int k;
        label195:
        break label195;
      }
      k = 0;
      localDYAEMaterialItem.b(k);
      localDYAEMaterialItem.c(((AEMaterialMetaData)localObject2).Y);
      localCollection.add(localDYAEMaterialItem);
      j += 1;
    }
    return (List)localCollection;
  }
  
  /* Error */
  private final List<DYAEEffectItem> j()
  {
    // Byte code:
    //   0: new 252	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 553
    //   14: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: ldc_w 264
    //   23: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 6
    //   29: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: getfield 147	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:g	I
    //   38: getstatic 556	com/tencent/ttpic/facedetect/GenderType:FEMALE	Lcom/tencent/ttpic/facedetect/GenderType;
    //   41: getfield 145	com/tencent/ttpic/facedetect/GenderType:value	I
    //   44: if_icmpne +40 -> 84
    //   47: new 252	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   54: astore 6
    //   56: aload 6
    //   58: ldc_w 553
    //   61: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 6
    //   67: ldc_w 558
    //   70: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 6
    //   81: goto +37 -> 118
    //   84: new 252	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   91: astore 6
    //   93: aload 6
    //   95: ldc_w 553
    //   98: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: ldc_w 558
    //   107: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 6
    //   118: new 252	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   125: astore 7
    //   127: aload 7
    //   129: getstatic 561	com/tencent/aelight/camera/ae/AEPath$CAMERA$FILES:a	Ljava/lang/String;
    //   132: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 7
    //   138: bipush 47
    //   140: invokevirtual 564	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: ldc_w 553
    //   149: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 9
    //   160: new 485	java/util/ArrayList
    //   163: dup
    //   164: invokespecial 486	java/util/ArrayList:<init>	()V
    //   167: checkcast 206	java/util/List
    //   170: astore 10
    //   172: aload_0
    //   173: invokevirtual 568	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:getResources	()Landroid/content/res/Resources;
    //   176: astore 7
    //   178: aload 7
    //   180: ldc_w 570
    //   183: invokestatic 421	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   186: aload 7
    //   188: invokevirtual 576	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   191: aload 6
    //   193: invokevirtual 582	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   196: astore 6
    //   198: aload 6
    //   200: ldc_w 584
    //   203: invokestatic 421	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   206: new 349	java/io/InputStreamReader
    //   209: dup
    //   210: aload 6
    //   212: getstatic 311	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   215: invokespecial 357	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   218: checkcast 359	java/io/Reader
    //   221: astore 6
    //   223: aload 6
    //   225: instanceof 361
    //   228: ifeq +13 -> 241
    //   231: aload 6
    //   233: checkcast 361	java/io/BufferedReader
    //   236: astore 6
    //   238: goto +17 -> 255
    //   241: new 361	java/io/BufferedReader
    //   244: dup
    //   245: aload 6
    //   247: sipush 8192
    //   250: invokespecial 364	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   253: astore 6
    //   255: aload 6
    //   257: checkcast 323	java/io/Closeable
    //   260: astore 12
    //   262: aconst_null
    //   263: checkcast 250	java/lang/Throwable
    //   266: astore 7
    //   268: aload 7
    //   270: astore 6
    //   272: new 586	org/json/JSONObject
    //   275: dup
    //   276: aload 12
    //   278: checkcast 361	java/io/BufferedReader
    //   281: checkcast 359	java/io/Reader
    //   284: invokestatic 370	kotlin/io/TextStreamsKt:readText	(Ljava/io/Reader;)Ljava/lang/String;
    //   287: invokespecial 587	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   290: astore 11
    //   292: aload 12
    //   294: aload 7
    //   296: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   299: aload 11
    //   301: ldc_w 589
    //   304: invokevirtual 592	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   307: astore 7
    //   309: aload 7
    //   311: astore 6
    //   313: aload 7
    //   315: instanceof 594
    //   318: ifne +6 -> 324
    //   321: aconst_null
    //   322: astore 6
    //   324: aload 6
    //   326: checkcast 594	java/lang/String
    //   329: astore 6
    //   331: aload 6
    //   333: ifnull +6 -> 339
    //   336: goto +8 -> 344
    //   339: ldc_w 372
    //   342: astore 6
    //   344: aload_0
    //   345: aload 8
    //   347: aload 9
    //   349: aload 6
    //   351: invokespecial 596	com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload 11
    //   356: ldc_w 597
    //   359: invokevirtual 592	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   362: astore 6
    //   364: aload 6
    //   366: ifnull +421 -> 787
    //   369: aload 6
    //   371: checkcast 599	org/json/JSONArray
    //   374: astore 11
    //   376: iconst_0
    //   377: istore_1
    //   378: aload 11
    //   380: invokevirtual 602	org/json/JSONArray:length	()I
    //   383: istore 5
    //   385: iconst_1
    //   386: istore_2
    //   387: iload_1
    //   388: iload 5
    //   390: if_icmpge +394 -> 784
    //   393: aload 11
    //   395: iload_1
    //   396: invokevirtual 603	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   399: astore 6
    //   401: aload 6
    //   403: ifnull +370 -> 773
    //   406: aload 6
    //   408: checkcast 586	org/json/JSONObject
    //   411: astore 15
    //   413: aload 15
    //   415: ldc_w 605
    //   418: invokevirtual 592	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   421: astore 6
    //   423: aload 6
    //   425: ifnull +337 -> 762
    //   428: aload 6
    //   430: checkcast 594	java/lang/String
    //   433: astore 13
    //   435: aload 15
    //   437: ldc_w 607
    //   440: invokevirtual 592	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   443: astore 6
    //   445: aload 6
    //   447: ifnull +304 -> 751
    //   450: aload 6
    //   452: checkcast 594	java/lang/String
    //   455: astore 12
    //   457: aload 15
    //   459: ldc_w 609
    //   462: invokevirtual 612	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   465: astore 7
    //   467: aload 7
    //   469: astore 6
    //   471: aload 7
    //   473: instanceof 594
    //   476: ifne +6 -> 482
    //   479: aconst_null
    //   480: astore 6
    //   482: aload 6
    //   484: checkcast 594	java/lang/String
    //   487: astore 7
    //   489: aload 15
    //   491: ldc_w 614
    //   494: invokevirtual 612	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   497: astore 8
    //   499: aload 8
    //   501: astore 6
    //   503: aload 8
    //   505: instanceof 537
    //   508: ifne +6 -> 514
    //   511: aconst_null
    //   512: astore 6
    //   514: aload 6
    //   516: checkcast 537	java/lang/Integer
    //   519: astore 14
    //   521: aload 15
    //   523: ldc_w 616
    //   526: invokevirtual 612	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   529: astore 8
    //   531: aload 8
    //   533: astore 6
    //   535: aload 8
    //   537: instanceof 537
    //   540: ifne +6 -> 546
    //   543: aconst_null
    //   544: astore 6
    //   546: aload 6
    //   548: checkcast 537	java/lang/Integer
    //   551: astore 8
    //   553: new 252	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   560: astore 6
    //   562: aload 6
    //   564: aload 9
    //   566: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 6
    //   572: bipush 47
    //   574: invokevirtual 564	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 6
    //   580: aload 13
    //   582: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 6
    //   588: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: astore 13
    //   593: iload_2
    //   594: istore_3
    //   595: new 266	java/io/File
    //   598: dup
    //   599: aload 13
    //   601: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   604: invokevirtual 276	java/io/File:exists	()Z
    //   607: ifeq +135 -> 742
    //   610: aload 7
    //   612: ifnull +10 -> 622
    //   615: aload 7
    //   617: astore 6
    //   619: goto +45 -> 664
    //   622: new 252	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   629: astore 6
    //   631: aload 6
    //   633: ldc_w 618
    //   636: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 6
    //   642: aload 13
    //   644: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 6
    //   650: ldc_w 620
    //   653: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 6
    //   659: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: astore 6
    //   664: new 622	com/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem
    //   667: dup
    //   668: iload_2
    //   669: invokestatic 626	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   672: aload 12
    //   674: aload 6
    //   676: aload 13
    //   678: invokespecial 629	com/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   681: astore 6
    //   683: iconst_m1
    //   684: istore 4
    //   686: aload 14
    //   688: ifnull +12 -> 700
    //   691: aload 14
    //   693: invokevirtual 632	java/lang/Integer:intValue	()I
    //   696: istore_3
    //   697: goto +5 -> 702
    //   700: iconst_m1
    //   701: istore_3
    //   702: aload 6
    //   704: iload_3
    //   705: invokevirtual 633	com/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem:a	(I)V
    //   708: iload 4
    //   710: istore_3
    //   711: aload 8
    //   713: ifnull +9 -> 722
    //   716: aload 8
    //   718: invokevirtual 632	java/lang/Integer:intValue	()I
    //   721: istore_3
    //   722: aload 6
    //   724: iload_3
    //   725: invokevirtual 634	com/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem:b	(I)V
    //   728: aload 10
    //   730: aload 6
    //   732: invokeinterface 635 2 0
    //   737: pop
    //   738: iload_2
    //   739: iconst_1
    //   740: iadd
    //   741: istore_3
    //   742: iload_1
    //   743: iconst_1
    //   744: iadd
    //   745: istore_1
    //   746: iload_3
    //   747: istore_2
    //   748: goto -361 -> 387
    //   751: new 637	kotlin/TypeCastException
    //   754: dup
    //   755: ldc_w 639
    //   758: invokespecial 640	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   761: athrow
    //   762: new 637	kotlin/TypeCastException
    //   765: dup
    //   766: ldc_w 639
    //   769: invokespecial 640	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   772: athrow
    //   773: new 637	kotlin/TypeCastException
    //   776: dup
    //   777: ldc_w 642
    //   780: invokespecial 640	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   783: athrow
    //   784: aload 10
    //   786: areturn
    //   787: new 637	kotlin/TypeCastException
    //   790: dup
    //   791: ldc_w 644
    //   794: invokespecial 640	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   797: athrow
    //   798: astore 7
    //   800: goto +12 -> 812
    //   803: astore 7
    //   805: aload 7
    //   807: astore 6
    //   809: aload 7
    //   811: athrow
    //   812: aload 12
    //   814: aload 6
    //   816: invokestatic 338	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   819: goto +6 -> 825
    //   822: aload 7
    //   824: athrow
    //   825: goto -3 -> 822
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	this	AECosmeticsProviderView
    //   377	369	1	j	int
    //   386	362	2	k	int
    //   594	153	3	m	int
    //   684	25	4	n	int
    //   383	8	5	i1	int
    //   7	808	6	localObject1	Object
    //   125	491	7	localObject2	Object
    //   798	1	7	localObject3	Object
    //   803	20	7	localThrowable	java.lang.Throwable
    //   32	685	8	localObject4	Object
    //   158	407	9	str1	String
    //   170	615	10	localList	List
    //   290	104	11	localObject5	Object
    //   260	553	12	localObject6	Object
    //   433	244	13	str2	String
    //   519	173	14	localInteger	Integer
    //   411	111	15	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   272	292	798	finally
    //   809	812	798	finally
    //   272	292	803	java/lang/Throwable
  }
  
  public final void a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
    }
    localObject = (List)((AECosmeticsViewModel)localObject).a().getValue();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "cosmeticsViewModel.cosme…sLiveData.value ?: return");
      AECosmeticsViewModel localAECosmeticsViewModel = this.c;
      if (localAECosmeticsViewModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
      }
      localAECosmeticsViewModel.a().postValue(a((List)localObject));
    }
  }
  
  public void a(@NotNull DYAEEffectItem paramDYAEEffectItem, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEEffectItem, "item");
    Object localObject;
    if (!paramDYAEEffectItem.h())
    {
      this.e = paramDYAEEffectItem;
      if (!paramDYAEEffectItem.i())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start download material, material_id = ");
        ((StringBuilder)localObject).append(paramDYAEEffectItem.a());
        AEQLog.a("AECosmeticProviderView", ((StringBuilder)localObject).toString());
        paramDYAEEffectItem.b(true);
        a(this.d, ((DYAEMaterialItem)paramDYAEEffectItem).g(), (AEMaterialDownloader.MaterialDownloadListener)this);
        this.f.a(false);
      }
    }
    else
    {
      this.e = ((DYAEEffectItem)null);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cosmeticsViewModel");
      }
      ((AECosmeticsViewModel)localObject).a(paramDYAEEffectItem);
    }
    AEBaseDataReporter.a().b(paramDYAEEffectItem.b(), AEProviderViewModel.a.b(paramDYAEEffectItem));
  }
  
  public final void a(@NotNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoStoryCapturePartManager, "partManager");
    this.b = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    f();
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d()
  {
    this.d.unRegistObserver((BusinessObserver)this.i);
  }
  
  public final int getGenderType()
  {
    return this.g;
  }
  
  public void onDownloadFinish(@Nullable AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("material download finish, id = ");
      localStringBuilder.append(paramAEMaterialMetaData.m);
      localStringBuilder.append(", isUsable = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", resCode = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AECosmeticProviderView", localStringBuilder.toString());
      paramAEMaterialMetaData.B = false;
      paramAEMaterialMetaData.C = 0;
      paramAEMaterialMetaData.A = paramBoolean;
      post((Runnable)new AECosmeticsProviderView.onDownloadFinish.1(this, paramBoolean, paramAEMaterialMetaData));
    }
  }
  
  public void onProgressUpdate(@Nullable AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramAEMaterialMetaData != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("material download update id = ");
      localStringBuilder.append(paramAEMaterialMetaData.m);
      localStringBuilder.append(", progress = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("AECosmeticProviderView", localStringBuilder.toString());
      post((Runnable)new AECosmeticsProviderView.onProgressUpdate.1(this, paramAEMaterialMetaData, paramInt));
    }
  }
  
  public final void setGenderType(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView
 * JD-Core Version:    0.7.0.1
 */