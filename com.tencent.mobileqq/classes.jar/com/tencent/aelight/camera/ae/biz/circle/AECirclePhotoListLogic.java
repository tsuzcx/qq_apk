package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleTitleChipPart;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.view.AEEditorCancelableProgressDialog;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.aeeditor.record.AEEditorBaseRecord;
import com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.usq.u;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class AECirclePhotoListLogic
  implements MediaScanner.OnMediaScannerListener
{
  private static final ArrayList<String> s = new AECirclePhotoListLogic.1();
  private static int u = 3000;
  private static int v = 3000;
  private AEEditorCancelableProgressDialog A;
  private volatile boolean B = false;
  private volatile boolean C = false;
  private volatile CountDownLatch D;
  private MovieExporter E;
  protected long a;
  public WeakReference<AECirclePhotoListFragment> b;
  public PhotoCommonBaseData<OtherCommonData> c;
  public PhotoListBaseData d;
  public AECirclePhotoListLogic.PhotoListGuideData e;
  public ArrayList<LocalMediaInfo> f = new ArrayList();
  AECirclePhotoListPart g;
  AECircleAlbumListPart h;
  AECirclePreviewPart i;
  AECircleSelectPanelPart j;
  AECircleTitleChipPart k;
  AECircleRecomAutoTemplatePart l;
  public final AEAlbumLogicData m = new AEAlbumLogicData();
  private List<AECirclePhotoListLogic.InitResult> n = new ArrayList();
  private boolean o = false;
  private ArrayList<String> p;
  private boolean q;
  private String r = "";
  private int t = 0;
  private boolean w = false;
  private String x;
  private boolean y;
  private final Map<String, String> z = new HashMap();
  
  public AECirclePhotoListLogic(AECirclePhotoListFragment paramAECirclePhotoListFragment)
  {
    Object localObject;
    if (paramAECirclePhotoListFragment == null) {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    this.b = new WeakReference(paramAECirclePhotoListFragment);
    this.c = AEPhotoCommonDataCreator.a();
    this.c.addHoldNember();
    this.d = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PhotoListLogic new，fragment = ");
      ((StringBuilder)localObject).append(paramAECirclePhotoListFragment);
      ((StringBuilder)localObject).append(",PhotoCommonData = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    this.a = System.currentTimeMillis();
  }
  
  /* Error */
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 185	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore_3
    //   5: lload_3
    //   6: ldc2_w 186
    //   9: lcmp
    //   10: ifgt +141 -> 151
    //   13: lload_3
    //   14: ldc2_w 188
    //   17: lcmp
    //   18: ifge +6 -> 24
    //   21: goto +130 -> 151
    //   24: new 191	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 192	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore 6
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 195	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   39: invokevirtual 199	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: bipush 19
    //   46: invokevirtual 203	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   49: invokestatic 209	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: istore_1
    //   53: aload 6
    //   55: bipush 18
    //   57: invokevirtual 203	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: invokestatic 209	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload 6
    //   66: bipush 12
    //   68: invokevirtual 203	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   71: astore_0
    //   72: iload_1
    //   73: invokestatic 212	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:b	()I
    //   76: if_icmpgt +43 -> 119
    //   79: iload_2
    //   80: invokestatic 214	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:c	()I
    //   83: if_icmple +6 -> 89
    //   86: goto +33 -> 119
    //   89: invokestatic 217	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:a	()Ljava/util/ArrayList;
    //   92: aload_0
    //   93: invokevirtual 221	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   96: istore 5
    //   98: iload 5
    //   100: ifne +12 -> 112
    //   103: iconst_3
    //   104: istore_1
    //   105: aload 6
    //   107: invokevirtual 224	android/media/MediaMetadataRetriever:release	()V
    //   110: iload_1
    //   111: ireturn
    //   112: aload 6
    //   114: invokevirtual 224	android/media/MediaMetadataRetriever:release	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: iconst_2
    //   120: istore_1
    //   121: goto -16 -> 105
    //   124: astore_0
    //   125: goto +19 -> 144
    //   128: astore_0
    //   129: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   139: iconst_5
    //   140: istore_1
    //   141: goto -36 -> 105
    //   144: aload 6
    //   146: invokevirtual 224	android/media/MediaMetadataRetriever:release	()V
    //   149: aload_0
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramLocalMediaInfo	LocalMediaInfo
    //   52	89	1	i1	int
    //   63	21	2	i2	int
    //   4	10	3	l1	long
    //   96	3	5	bool	boolean
    //   31	114	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   33	86	124	finally
    //   89	98	124	finally
    //   129	139	124	finally
    //   33	86	128	java/lang/Exception
    //   89	98	128	java/lang/Exception
  }
  
  public static EditorPicInfo a(@NonNull String paramString)
  {
    AEQLog.a("AECirclePhotoListLogic", "[prepareEditorPicInfo]");
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    localEditorPicInfo.picPath = paramString;
    localEditorPicInfo.originPicWidth = localSize.getWidth();
    localEditorPicInfo.originPicHeight = localSize.getHeight();
    if ((localEditorPicInfo.originPicHeight != 0.0D) && (localEditorPicInfo.originPicWidth != 0.0D))
    {
      double d1 = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (d1 <= 0.333333343267441D)
      {
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = ((localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight);
        localEditorPicInfo.w = 1.0D;
        localEditorPicInfo.h = (localEditorPicInfo.originPicWidth / 0.333333343267441D * 1.0D / localEditorPicInfo.originPicHeight);
        return localEditorPicInfo;
      }
      if (d1 >= 1.777777791023254D)
      {
        localEditorPicInfo.x = ((localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) * 1.0D / 2.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = (localEditorPicInfo.originPicHeight * 1.777777791023254D * 1.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.h = 1.0D;
        return localEditorPicInfo;
      }
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = 0.0D;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = 1.0D;
      return localEditorPicInfo;
    }
    localEditorPicInfo.x = 0.0D;
    localEditorPicInfo.y = 0.0D;
    localEditorPicInfo.w = 1.0D;
    localEditorPicInfo.h = 1.0D;
    return localEditorPicInfo;
  }
  
  public static ArrayList<String> a()
  {
    return s;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.c.selectedPhotoList);
    ArrayList localArrayList = new ArrayList();
    int i2 = 0;
    int i1 = 0;
    while (i1 < localLinkedList.size())
    {
      String str = (String)localLinkedList.get(i1);
      Object localObject2;
      if (TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleClickNextBtnForOnlyPhoto--empty path, drop it: ");
        ((StringBuilder)localObject2).append(str);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject2).toString());
      }
      else if (!new File(str).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleClickNextBtnForOnlyPhoto--file not exists, drop it: ");
        ((StringBuilder)localObject2).append(str);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject2).toString());
      }
      else
      {
        ((ArrayList)localObject1).add(a(str));
        localObject2 = new AEPhotoCropInfoWrapper();
        ((AEPhotoCropInfoWrapper)localObject2).a = a(str);
        localObject2 = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject2).a);
        ((AEAlbumImageModel)localObject2).setOriginPath(str);
        localArrayList.add(localObject2);
      }
      i1 += 1;
    }
    if (CollectionUtils.isEmpty((Collection)localObject1))
    {
      QQToast.makeText(((AECirclePhotoListFragment)this.b.get()).getActivity(), 2064187565, 0).show();
      return;
    }
    paramBundle.putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject1);
    paramBundle.putSerializable("ae_album_selected_media_models", localArrayList);
    paramBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", this.m.canPickVideo);
    paramBundle.putBoolean("key_qcircle_publish_back_edit", this.o);
    localObject1 = this.p;
    if (localObject1 != null) {
      paramBundle.putStringArrayList("key_qcircle_publish_out_imagepath", (ArrayList)localObject1);
    }
    i1 = AECameraEntry.y.a();
    if (AECameraEntryManager.r(((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent())) {
      i1 = AECameraEntry.A.a();
    }
    localObject1 = ((AECirclePhotoListFragment)this.b.get()).getActivity();
    if (AECameraEntryManager.t(((Activity)localObject1).getIntent()))
    {
      paramBundle = new Intent();
      paramBundle.putExtra("ae_album_selected_media_models", localArrayList);
      ((Activity)localObject1).setResult(-1, paramBundle);
      ((Activity)localObject1).finish();
      return;
    }
    if ((paramInt != 1) && ((paramInt == 2) || (paramInt == 3))) {
      i2 = 1;
    }
    paramBundle.putInt("ae_video_editor_entrance_id", paramInt);
    paramBundle.putSerializable("ae_editor_photo_path", this.c.selectedPhotoList);
    AEEditorLauncher.a(((AECirclePhotoListFragment)this.b.get()).getActivity(), i2, paramBundle, i1);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          QQToast.makeText(paramContext, HardCodeUtil.a(2064187576), 0).show();
          return;
        }
        QQToast.makeText(paramContext, HardCodeUtil.a(2064187573), 0).show();
        return;
      }
      QQToast.makeText(paramContext, HardCodeUtil.a(2064187575), 0).show();
      return;
    }
    QQToast.makeText(paramContext, "请选择2秒到1小时之间的视频", 0).show();
  }
  
  @WorkerThread
  private void a(ArrayList<AEAlbumVideoModel> paramArrayList)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    do
    {
      if (i1 >= i2) {
        break;
      }
      AEAlbumVideoModel localAEAlbumVideoModel = (AEAlbumVideoModel)paramArrayList.get(i1);
      LocalMediaInfo localLocalMediaInfo = c(localAEAlbumVideoModel.getPath());
      localAEAlbumVideoModel.setOriginPath(localAEAlbumVideoModel.getPath());
      i1 += 1;
      this.D = new CountDownLatch(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("batchCompress---begin, index=");
      localStringBuilder.append(i1);
      AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.14(this, i1, i2));
      a(localLocalMediaInfo, new AECirclePhotoListLogic.15(this, i1, localAEAlbumVideoModel));
      if (this.D != null)
      {
        try
        {
          this.D.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        this.D = null;
      }
    } while ((!this.B) && (!this.C));
  }
  
  private void a(ArrayList<AEAlbumMediaBaseModel> paramArrayList, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    Activity localActivity = ((AECirclePhotoListFragment)this.b.get()).getActivity();
    Object localObject = localActivity.getIntent();
    if (AECameraEntryManager.t((Intent)localObject))
    {
      AEQLog.b("AECirclePhotoListLogic", "doRealJumpForMix---is additional pick case, setResult and finish");
      paramBundle = new Intent();
      paramBundle.putExtra("ae_album_selected_media_models", paramArrayList);
      paramBundle.putExtra("PeakConstants.selectedMediaInfoHashMap.recovery", this.c.selectedMediaInfoHashMap);
      paramBundle.putExtra("key_qcircle_publish_back_edit", this.o);
      localActivity.setResult(-1, paramBundle);
      localActivity.finish();
      return;
    }
    paramBundle.putSerializable("ae_album_selected_media_models", paramArrayList);
    paramBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap.recovery", this.c.selectedMediaInfoHashMap);
    paramBundle.putBoolean("key_qcircle_publish_back_edit", this.o);
    paramBundle.putInt("ae_video_editor_entrance_id", paramInt);
    paramBundle.putSerializable("ae_editor_photo_path", this.c.selectedPhotoList);
    paramInt = AECameraEntry.y.a();
    if (AECameraEntryManager.r((Intent)localObject)) {
      paramInt = AECameraEntry.A.a();
    }
    if (paramArrayList.size() == 1)
    {
      localObject = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ArrayList)localObject).add(((AEAlbumMediaBaseModel)paramArrayList.next()).getPath());
      }
      paramBundle.putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject);
      AEEditorLauncher.a(localActivity, 1, paramBundle, paramInt);
      return;
    }
    AEEditorLauncher.a(localActivity, 2, paramBundle, paramInt);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.n.add(new AECirclePhotoListLogic.InitResult(this, paramInt));
    }
  }
  
  public static int b()
  {
    return u;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    if (!StringUtil.isEmpty((String)localObject))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append((String)localObject);
      paramLocalMediaInfo.append(".mp4");
      paramLocalMediaInfo = paramLocalMediaInfo.toString();
    }
    else
    {
      paramLocalMediaInfo = paramLocalMediaInfo.path.split("/");
      if (paramLocalMediaInfo.length > 0) {
        paramLocalMediaInfo = paramLocalMediaInfo[(paramLocalMediaInfo.length - 1)];
      } else {
        paramLocalMediaInfo = "";
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEEditorPath.EDITOR.CACHE.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLocalMediaInfo);
    return ((StringBuilder)localObject).toString();
  }
  
  private String b(String paramString)
  {
    Object localObject3 = AEEditorResourceManager.a().w();
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      localObject3 = ((List)localObject3).iterator();
      do
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MetaCategory)((Iterator)localObject3).next();
      } while ((localObject2 == null) || (((MetaCategory)localObject2).materials == null));
      Iterator localIterator = ((MetaCategory)localObject2).materials.iterator();
      localObject2 = localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MetaMaterial)localIterator.next();
        if ((localObject1 != null) && (paramString.equals(((MetaMaterial)localObject1).id)) && (((MetaMaterial)localObject1).additionalFields != null))
        {
          localObject1 = MetaMaterialKt.a((MetaMaterial)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.c.selectedPhotoList);
    int i1 = 0;
    boolean bool = false;
    while (i1 < localLinkedList.size())
    {
      String str1 = (String)localLinkedList.get(i1);
      Object localObject;
      if (TextUtils.isEmpty(str1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: ");
        ((StringBuilder)localObject).append(str1);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject).toString());
      }
      else if (!new File(str1).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: ");
        ((StringBuilder)localObject).append(str1);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = c(str1);
        if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1))
        {
          int i2 = a((LocalMediaInfo)localObject);
          if ((i2 != 2) && (i2 != 0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: ");
            ((StringBuilder)localObject).append(str1);
            AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new AEAlbumVideoModel(str1);
            ((AEAlbumVideoModel)localObject).setOriginPath(str1);
            localArrayList1.add(localObject);
            if (i2 == 2)
            {
              String str2 = (String)this.z.get(str1);
              if (TextUtils.isEmpty(str2))
              {
                localArrayList2.add(localObject);
              }
              else
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("hit cache, no need compress for: ");
                localStringBuilder.append(str1);
                AEQLog.a("AECirclePhotoListLogic", localStringBuilder.toString());
                ((AEAlbumVideoModel)localObject).setPath(str2);
              }
            }
            bool = true;
          }
        }
        else
        {
          localObject = new AEPhotoCropInfoWrapper();
          ((AEPhotoCropInfoWrapper)localObject).a = a(str1);
          localObject = new AEAlbumImageModel(str1, ((AEPhotoCropInfoWrapper)localObject).a);
          ((AEAlbumImageModel)localObject).setOriginPath(str1);
          localArrayList1.add(localObject);
        }
      }
      i1 += 1;
    }
    if (CollectionUtils.isEmpty(localArrayList1))
    {
      AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
      QQToast.makeText(((AECirclePhotoListFragment)this.b.get()).getActivity(), 2064187566, 0).show();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      a(localArrayList1, bool, paramInt, paramBundle);
      return;
    }
    if (this.A == null)
    {
      this.A = new AEEditorCancelableProgressDialog(((AECirclePhotoListFragment)this.b.get()).getActivity());
      this.A.a(((AECirclePhotoListFragment)this.b.get()).getString(2064187707));
      this.A.a(new AECirclePhotoListLogic.11(this));
    }
    this.A.show();
    AEQLog.a("AECirclePhotoListLogic", "after show, submit compress task");
    ThreadManagerV2.excute(new AECirclePhotoListLogic.12(this, localArrayList2, localArrayList1, bool, paramInt, paramBundle), 16, new AECirclePhotoListLogic.13(this), true);
  }
  
  private void b(Intent paramIntent)
  {
    if (!"album".equals(paramIntent.getStringExtra("tab"))) {
      return;
    }
    this.m.initialHasPickedNum = 0;
    this.p = paramIntent.getStringArrayListExtra("key_qcircle_publish_out_imagepath");
    long l1 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getLong("key_ae_editor_record_type", 0L, 0);
    if (l1 == 2L)
    {
      paramIntent = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_files", "", 0);
      if (!TextUtils.isEmpty(paramIntent)) {
        try
        {
          paramIntent = (ArrayList)AEEditorBaseRecord.a(new JSONObject(paramIntent), "mediaList", ArrayList.class);
          if (paramIntent == null) {
            return;
          }
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            AEAlbumMediaBaseModel localAEAlbumMediaBaseModel = (AEAlbumMediaBaseModel)paramIntent.next();
            this.c.selectedPhotoList.add(localAEAlbumMediaBaseModel.getOriginPath());
          }
          if (l1 != 1L) {
            return;
          }
        }
        catch (Exception paramIntent)
        {
          AEQLog.a("AECirclePhotoListLogic", "initBackEditData", paramIntent);
          return;
        }
      }
    }
    else
    {
      paramIntent = AEEditorRecordDataManager.a().a(this.p);
      if (paramIntent != null) {
        this.c.selectedPhotoList.addAll(paramIntent);
      }
    }
  }
  
  public static int c()
  {
    return v;
  }
  
  @Nullable
  private LocalMediaInfo c(String paramString)
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.c.selectedMediaInfoHashMap.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new LinkedList(this.f);
      localObject2 = localObject1;
      if (!CollectionUtils.isEmpty((Collection)localObject3))
      {
        localObject3 = ((List)localObject3).iterator();
        do
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (LocalMediaInfo)((Iterator)localObject3).next();
        } while ((localObject2 == null) || (TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)) || (!((LocalMediaInfo)localObject2).path.equals(paramString)));
      }
    }
    return localObject2;
  }
  
  private EncoderWriter.OutputConfig c(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.b();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = paramIntent.getExtras();
    if (localObject == null) {
      return;
    }
    paramIntent = ((Bundle)localObject).getString("tab");
    if ((!TextUtils.isEmpty(paramIntent)) && (!"album".equals(paramIntent))) {
      return;
    }
    this.e = new AECirclePhotoListLogic.PhotoListGuideData(this);
    this.e.e = false;
    paramIntent = this.b;
    if ((paramIntent != null) && (paramIntent.get() != null) && (((AECirclePhotoListFragment)this.b.get()).e().booleanValue())) {
      this.e.e = true;
    }
    paramIntent = ((Bundle)localObject).getString("editor_filter_id");
    boolean bool1 = TextUtils.isEmpty(paramIntent) ^ true;
    boolean bool2 = TextUtils.isEmpty(((Bundle)localObject).getString("editor_text_sticker_id")) ^ true;
    boolean bool3 = TextUtils.isEmpty(((Bundle)localObject).getString("editor_image_template_id")) ^ true;
    boolean bool4 = TextUtils.isEmpty(((Bundle)localObject).getString("editor_text_id")) ^ true;
    boolean bool5 = TextUtils.isEmpty(((Bundle)localObject).getString("editor_frame_id")) ^ true;
    boolean bool6 = TextUtils.isEmpty(((Bundle)localObject).getString("editor_video_template_id")) ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool6))
    {
      if ((!bool3) && (!bool5))
      {
        localObject = this.e;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).b = -1;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).a = 0;
      }
      else
      {
        localObject = this.e;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).b = 2;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).a = 1;
      }
    }
    else
    {
      localObject = this.e;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).b = 1;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).a = 0;
    }
    int i1 = this.e.b;
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        localObject = this.e;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).c = 0;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).f = 3;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).g = 4;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).h = (-ViewUtils.dip2px(20.0F));
        this.e.i = ViewUtils.dip2px(6.0F);
      }
    }
    else
    {
      localObject = this.e;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).c = 1;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).f = 0;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).g = 3;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).h = 0;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).i = ViewUtils.dip2px(6.0F);
    }
    if (bool1)
    {
      paramIntent = b(paramIntent);
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("勾选后进入下一步可预览");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("滤镜");
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).d = localStringBuilder.toString();
      return;
    }
    if (bool2)
    {
      this.e.d = "勾选后进入下一步可预览贴纸效果";
      return;
    }
    if (bool3)
    {
      this.e.d = "勾选后进入下一步可预览大片效果";
      return;
    }
    if (bool4)
    {
      this.e.d = "勾选后进入下一步可添加别致文字哟";
      return;
    }
    if (bool5)
    {
      this.e.d = "勾选后进入下一步可预览边框效果";
      return;
    }
    if (bool6)
    {
      this.e.d = "勾选后进入下一步可预览大片效果";
      return;
    }
    this.e.d = "";
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(paramIntent)) {
      PeakIpcController.a(paramIntent, "action_qcircle_picker_ready");
    }
  }
  
  private void q()
  {
    Intent localIntent = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent();
    if (this.m.canMixPhotoAndVideo)
    {
      this.c.maxSelectNum = this.m.maxSelectNumForMix;
      this.d.B = true;
      this.c.isSingleMode = false;
      return;
    }
    this.c.maxSelectNum = this.m.maxSelectNumForNormal;
    this.d.B = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.c.maxSelectNum > 1) {
      this.c.isSingleMode = false;
    }
    if (localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.c.isSingleMode = false;
    }
  }
  
  private void r()
  {
    if (!AEKitForQQ.a())
    {
      this.n.add(new AECirclePhotoListLogic.InitResult(this, -1));
    }
    else
    {
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
    TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.n(), new AECirclePhotoListLogic.8(this));
  }
  
  private void s()
  {
    this.n.size();
  }
  
  @Nullable
  public LocalMediaInfo a(Object paramObject)
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.c.selectedMediaInfoHashMap.get(paramObject);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.c;
      localObject2 = localObject1;
      if (localPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.c.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 15;
    } else {
      i1 = QzoneConfig.getMaxPhotoNumInRecentPhoto();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AECirclePhotoListLogic:QueryPhotoTask", 4, "getLocalMediaInfo start ");
    }
    long l1 = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(this.r)) && (this.r.equals(this.c.albumId)))
    {
      this.c.mMediaQueryHelper.queryNext(i1);
    }
    else
    {
      this.r = this.c.albumId;
      this.c.createMediaQueryHelper(BaseApplicationImpl.getContext());
      this.c.mMediaQueryHelper.queryNext(i1);
    }
    List localList = this.c.mMediaQueryHelper.mediaList;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalMediaInfo end, cost ");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localStringBuilder.append("ms");
      QLog.d("AECirclePhotoListLogic:QueryPhotoTask", 4, localStringBuilder.toString());
    }
    LogTag.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.c.selectedPhotoList != null) && (this.c.selectedPhotoList.size() != 0))
    {
      i1 = 0;
      while (i1 < this.c.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.c.selectedPhotoList.get(i1))) {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i1 += 1;
      }
    }
    return localList;
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = this.c.selectedPhotoList;
    HashMap localHashMap1 = this.c.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.c.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.c.allMediaInfoHashMap.get(str);
      }
      if (localObject != null)
      {
        localHashMap2.put(str, localObject);
      }
      else
      {
        localObject = (LocalMediaInfo)localHashMap1.get(str);
        if (localObject != null) {
          localHashMap2.put(str, localObject);
        }
      }
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    paramIntent.putExtra("ALBUM_ID", this.c.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.c.albumName);
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    this.d.N = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.q = paramIntent.getBooleanExtra("BUNDLE_KEY_FS_CAN_ONLY_EDIT_VIDEO", false);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.d.N) && (l1 - l2 < 60000L))
      {
        this.c.albumName = QAlbumUtil.sLastAlbumName;
        this.c.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.c.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.c.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.c.albumId == null)
    {
      localObject = this.c;
      ((PhotoCommonBaseData)localObject).albumId = "$RecentAlbumId";
      ((PhotoCommonBaseData)localObject).albumName = null;
    }
    this.d.Q = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.c.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.c.selectedPhotoList == null) {
      this.c.selectedPhotoList = new ArrayList();
    }
    if (this.c.selectedMediaInfoHashMap == null) {
      this.c.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.c.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.c.selectedMediaInfoHashMap.clear();
      this.c.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.c.selectedIndex = new ArrayList();
    this.c.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    this.c.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localObject = this.c;
    ((PhotoCommonBaseData)localObject).filter = MediaFileFilter.getFilter(((PhotoCommonBaseData)localObject).showMediaType);
    if (paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false))
    {
      this.c.filter.needVideo = false;
      this.c.filter.needGif = false;
    }
    this.d.O = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.d.O) {
      this.d.P = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.d.F = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
    paramIntent.removeExtra("PHOTOLIST_START_POSITION");
    this.c.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    int i1;
    if (this.c.showMediaType == 2)
    {
      paramContext = paramContext.getResources();
      i1 = 2064187677;
    }
    else
    {
      paramContext = paramContext.getResources();
      i1 = 2064187676;
    }
    this.x = paramContext.getString(i1);
    this.m.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramContext = this.m;
    paramContext.minSelectNumForMix = 2;
    paramContext.maxSelectNumForMix = 30;
    paramContext.minSelectNumForNormal = -2147483648;
    paramContext.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    this.m.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    this.m.initialHasPickedNum = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.m.canPickVideo = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    q();
    paramContext = new StringBuilder();
    paramContext.append("initData---aeAlbumData=");
    paramContext.append(this.m);
    AEQLog.b("AECirclePhotoListLogic", paramContext.toString());
    this.c.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.c.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    paramContext = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getStringExtra("albumName");
    localObject = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramContext)))
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.c;
      localPhotoCommonBaseData.albumName = paramContext;
      localPhotoCommonBaseData.albumId = ((String)localObject);
    }
    this.y = (AECameraEntryManager.t(paramIntent) ^ true);
    this.r = ((String)localObject);
    this.c.createMediaQueryHelper(BaseApplicationImpl.getContext());
    u = 3000;
    v = 3000;
    c(paramIntent);
    if (paramIntent.getBooleanExtra("key_qcircle_from_mid_page", false))
    {
      paramContext = (HashMap)paramIntent.getExtras().getSerializable("key_qcircle_mid_page_photo_path");
      if (paramContext != null)
      {
        localObject = (ArrayList)paramIntent.getExtras().getSerializable("QCIRCLE_PUBLISH_MID_PAGE_NEW_PHOTO_PATH");
        if (localObject != null) {
          this.c.selectedPhotoList.addAll((Collection)localObject);
        }
        if (this.c.selectedMediaInfoHashMap == null) {
          this.c.selectedMediaInfoHashMap = new HashMap();
        }
        this.c.selectedMediaInfoHashMap.putAll(paramContext);
      }
    }
    if (!paramIntent.getBooleanExtra("key_qcircle_publish_from_preview", false))
    {
      this.o = paramIntent.getBooleanExtra("key_qcircle_publish_back_edit", false);
      if (this.o)
      {
        b(paramIntent);
        return;
      }
      if (this.q) {
        paramIntent = "_flash_show_publish";
      } else {
        paramIntent = "_qq_circle_publish";
      }
      if (LocalMultiProcConfig.getInt4Uin(paramIntent, 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1)
      {
        if (this.b.get() != null)
        {
          paramIntent = (Fragment)this.b.get();
          paramIntent = DialogUtil.a(paramIntent.getActivity(), 230).setTitle(paramIntent.getActivity().getResources().getString(2064187688)).setPositiveButton(paramIntent.getActivity().getString(2064187462), new AECirclePhotoListLogic.3(this, paramIntent)).setNegativeButton(paramIntent.getActivity().getString(2064187459), new AECirclePhotoListLogic.2(this));
          ThreadManager.getUIHandler().postDelayed(new AECirclePhotoListLogic.4(this, paramIntent), 200L);
        }
      }
      else
      {
        AEEditorRecordDataManager.j();
        if ((AEEditorRecordDataManager.a().e()) && (this.b.get() != null))
        {
          paramIntent = (Fragment)this.b.get();
          paramIntent = DialogUtil.a(paramIntent.getActivity(), 230).setTitle(paramIntent.getActivity().getResources().getString(2064187689)).setPositiveButton(paramIntent.getActivity().getString(2064187462), new AECirclePhotoListLogic.6(this)).setNegativeButton(paramIntent.getActivity().getString(2064187459), new AECirclePhotoListLogic.5(this));
          ThreadManager.getUIHandler().postDelayed(new AECirclePhotoListLogic.7(this, paramIntent), 200L);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent();
    int i1;
    if (this.c.selectedPhotoList != null) {
      i1 = this.c.selectedPhotoList.size();
    } else {
      i1 = 0;
    }
    StatisticConstants.b(paramView, i1);
    if ((this.b.get() != null) && (((AECirclePhotoListFragment)this.b.get()).getActivity() != null)) {
      ((AECirclePhotoListFragment)this.b.get()).getActivity().setResult(0, ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent());
    }
    ((AECirclePhotoListFragment)this.b.get()).d();
    ((AECirclePhotoListFragment)this.b.get()).getActivity().finish();
    AlbumUtil.anim(((AECirclePhotoListFragment)this.b.get()).getActivity(), false, false);
    AEBaseDataReporter.a().b(System.currentTimeMillis() - this.a);
  }
  
  public void a(AECircleAlbumListPart paramAECircleAlbumListPart)
  {
    this.h = paramAECircleAlbumListPart;
  }
  
  public void a(AECirclePhotoListPart paramAECirclePhotoListPart)
  {
    this.g = paramAECirclePhotoListPart;
  }
  
  public void a(AECirclePreviewPart paramAECirclePreviewPart)
  {
    this.i = paramAECirclePreviewPart;
  }
  
  public void a(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart)
  {
    this.l = paramAECircleRecomAutoTemplatePart;
  }
  
  public void a(AECircleSelectPanelPart paramAECircleSelectPanelPart)
  {
    this.j = paramAECircleSelectPanelPart;
  }
  
  public void a(AECircleTitleChipPart paramAECircleTitleChipPart)
  {
    this.k = paramAECircleTitleChipPart;
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    Object localObject = this.E;
    if (localObject != null) {
      ((MovieExporter)localObject).cancelCompress();
    }
    this.E = new MovieExporter();
    localObject = b(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = c(paramLocalMediaInfo);
    this.E.compressVideo(paramLocalMediaInfo.path, (String)localObject, localOutputConfig, new AECirclePhotoListLogic.16(this, paramVideoCompressListener, (String)localObject));
  }
  
  public boolean a(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = a(paramLocalMediaInfo);
    if ((i1 != 0) && (i1 != 2))
    {
      a(paramContext, i1);
      return false;
    }
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.f.clear();
    if (this.b.get() != null)
    {
      if (((AECirclePhotoListFragment)this.b.get()).getActivity() == null) {
        return false;
      }
      if (paramList == null)
      {
        this.g.a(paramList);
        if (paramBoolean) {
          this.g.i().post(new AECirclePhotoListLogic.9(this));
        }
        return false;
      }
      this.f.addAll(paramList);
      this.g.a(paramList);
      if ((paramBoolean) && (paramList.isEmpty())) {
        this.g.i().post(new AECirclePhotoListLogic.10(this));
      }
      if (!this.w)
      {
        this.w = true;
        paramList = (AECirclePhotoListFragment)this.b.get();
        if ((paramList != null) && (paramList.getActivity() != null))
        {
          paramList = paramList.getActivity().getIntent();
          if (AECameraEntryManager.o(paramList))
          {
            long l2 = System.currentTimeMillis();
            long l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
            l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
            if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L))
            {
              AEBaseDataReporter.a().a(l1, l2);
              d(paramList);
            }
          }
        }
      }
      SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
      return true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.c.albumName))
    {
      if (this.x.equals(this.c.albumName)) {
        return;
      }
      this.x = this.c.albumName;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    r();
    s();
    Object localObject = (AECirclePhotoListFragment)this.b.get();
    if (localObject != null) {
      ((AECirclePhotoListFragment)localObject).a();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("editor_video_template_id", ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getExtras().getString("editor_video_template_id"));
    ((Bundle)localObject).putSerializable("ae_album_selected_media_models", ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getExtras().getSerializable("ae_album_selected_media_models"));
    ((Bundle)localObject).putSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL", ((AECirclePhotoListFragment)this.b.get()).getActivity().getIntent().getExtras().getSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL"));
    String str = ((AECirclePhotoListFragment)this.b.get()).i;
    AECirclePhotoListFragment localAECirclePhotoListFragment = (AECirclePhotoListFragment)this.b.get();
    ((Bundle)localObject).putBoolean("ae_video_editor_entrance_mid_page", str.equals("midPageMultiReplace"));
    if ((!paramBoolean) && (!this.q))
    {
      a(1, (Bundle)localObject);
      return;
    }
    b(1, (Bundle)localObject);
  }
  
  public void d(boolean paramBoolean)
  {
    r();
    s();
    if (paramBoolean)
    {
      b(2, new Bundle());
      return;
    }
    a(2, new Bundle());
  }
  
  public boolean d()
  {
    return this.y;
  }
  
  public PhotoCommonBaseData<OtherCommonData> e()
  {
    return this.c;
  }
  
  public PhotoListBaseData f()
  {
    return this.d;
  }
  
  public AEAlbumLogicData g()
  {
    return this.m;
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic close，fragment = ");
      localStringBuilder.append(this.b.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.c);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.c.releaseCommonData();
  }
  
  public String i()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null)
    {
      if (((AECirclePhotoListFragment)localWeakReference.get()).e().booleanValue()) {
        return "2";
      }
      return "1";
    }
    return "";
  }
  
  public void j()
  {
    if (!this.d.z) {
      AlbumThumbManager.getInstance(((AECirclePhotoListFragment)this.b.get()).getActivity()).clear();
    }
    h();
  }
  
  protected void k()
  {
    MovieExporter localMovieExporter = this.E;
    if (localMovieExporter != null) {
      localMovieExporter.cancelCompress();
    }
  }
  
  public void l()
  {
    if (this.c.selectedPhotoList != null) {
      this.c.selectedPhotoList.clear();
    }
    if (this.c.selectedMediaInfoHashMap != null) {
      this.c.selectedMediaInfoHashMap.clear();
    }
  }
  
  public void m()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((PhotoCommonBaseData)localObject).selectedPhotoList != null))
    {
      int i2 = this.c.selectedPhotoList.size();
      AEBaseReportParam.a().n().d = AEBaseReportParam.a().S();
      localObject = this.c.selectedPhotoList.iterator();
      boolean bool2 = false;
      long l1 = 0L;
      int i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = a(((Iterator)localObject).next());
        if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
        {
          i1 += 1;
          l1 += localLocalMediaInfo.mDuration / 1000L;
        }
      }
      if (i1 > 0)
      {
        AEBaseReportParam.a().n().v = AEBaseReportParam.g.longValue();
        AEBaseReportParam.a().n().w = i1;
        AEBaseReportParam.a().n().x = l1;
        i2 -= i1;
      }
      else
      {
        AEBaseReportParam.a().n().v = AEBaseReportParam.d.longValue();
      }
      AEBaseDataReporter.a().a(i2);
      if (this.m.initialHasPickedNum > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      AEReportUtils.a(bool1, i2, i1, i());
      boolean bool1 = bool2;
      if (i1 > 0) {
        bool1 = true;
      }
      c(bool1);
    }
  }
  
  public void n()
  {
    int i2 = this.c.selectedPhotoList.size();
    Iterator localIterator = this.c.selectedPhotoList.iterator();
    boolean bool = false;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = a(localIterator.next());
      if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
        i1 += 1;
      }
    }
    AEReportUtils.a(i2, i2 - i1, i1);
    if (i1 > 0) {
      bool = true;
    }
    d(bool);
  }
  
  public void o()
  {
    AECircleAlbumListPart localAECircleAlbumListPart = this.h;
    if (localAECircleAlbumListPart != null) {
      localAECircleAlbumListPart.a(false, false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public boolean p()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic
 * JD-Core Version:    0.7.0.1
 */