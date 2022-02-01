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
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.VideoUtil;
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
  private static int jdField_b_of_type_Int = 3000;
  private static int jdField_c_of_type_Int = 3000;
  private static final ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new AECirclePhotoListLogic.1();
  private int jdField_a_of_type_Int = 0;
  protected long a;
  public final AEAlbumLogicData a;
  public AECirclePhotoListLogic.PhotoListGuideData a;
  AECircleAlbumListPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart;
  AECirclePhotoListPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart;
  AECirclePreviewPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePreviewPart;
  AECircleSelectPanelPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleSelectPanelPart;
  AECircleTitleChipPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart;
  private AEEditorCancelableProgressDialog jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog;
  public PhotoCommonBaseData<OtherCommonData> a;
  public PhotoListBaseData a;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private String jdField_a_of_type_JavaLangString = "";
  public ArrayList<LocalMediaInfo> a;
  private List<AECirclePhotoListLogic.InitResult> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  public WeakReference<AECirclePhotoListFragment> a;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d = false;
  private volatile boolean e = false;
  
  public AECirclePhotoListLogic(AECirclePhotoListFragment paramAECirclePhotoListFragment)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData = new AEAlbumLogicData();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAECirclePhotoListFragment);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic new，fragment = ");
      localStringBuilder.append(paramAECirclePhotoListFragment);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a()
  {
    return jdField_b_of_type_Int;
  }
  
  /* Error */
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 161	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore_3
    //   5: lload_3
    //   6: ldc2_w 162
    //   9: lcmp
    //   10: ifgt +141 -> 151
    //   13: lload_3
    //   14: ldc2_w 164
    //   17: lcmp
    //   18: ifge +6 -> 24
    //   21: goto +130 -> 151
    //   24: new 167	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 168	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore 6
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 171	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   39: invokevirtual 175	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: bipush 19
    //   46: invokevirtual 179	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   49: invokestatic 185	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: istore_1
    //   53: aload 6
    //   55: bipush 18
    //   57: invokevirtual 179	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: invokestatic 185	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload 6
    //   66: bipush 12
    //   68: invokevirtual 179	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   71: astore_0
    //   72: iload_1
    //   73: invokestatic 187	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:a	()I
    //   76: if_icmpgt +43 -> 119
    //   79: iload_2
    //   80: invokestatic 189	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:b	()I
    //   83: if_icmple +6 -> 89
    //   86: goto +33 -> 119
    //   89: invokestatic 192	com/tencent/aelight/camera/ae/biz/circle/AECirclePhotoListLogic:a	()Ljava/util/ArrayList;
    //   92: aload_0
    //   93: invokevirtual 196	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   96: istore 5
    //   98: iload 5
    //   100: ifne +12 -> 112
    //   103: iconst_3
    //   104: istore_1
    //   105: aload 6
    //   107: invokevirtual 199	android/media/MediaMetadataRetriever:release	()V
    //   110: iload_1
    //   111: ireturn
    //   112: aload 6
    //   114: invokevirtual 199	android/media/MediaMetadataRetriever:release	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: iconst_2
    //   120: istore_1
    //   121: goto -16 -> 105
    //   124: astore_0
    //   125: goto +19 -> 144
    //   128: astore_0
    //   129: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   139: iconst_5
    //   140: istore_1
    //   141: goto -36 -> 105
    //   144: aload 6
    //   146: invokevirtual 199	android/media/MediaMetadataRetriever:release	()V
    //   149: aload_0
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramLocalMediaInfo	LocalMediaInfo
    //   52	89	1	i	int
    //   63	21	2	j	int
    //   4	10	3	l	long
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
  
  @Nullable
  private LocalMediaInfo a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
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
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.a();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  @NotNull
  private String a(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    if (!StringUtil.a((String)localObject))
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
    ((StringBuilder)localObject).append(AEEditorPath.EDITOR.CACHE.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLocalMediaInfo);
    return ((StringBuilder)localObject).toString();
  }
  
  private String a(String paramString)
  {
    Object localObject3 = AEEditorResourceManager.a().a();
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
  
  public static ArrayList<String> a()
  {
    return jdField_c_of_type_JavaUtilArrayList;
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < ((List)localObject2).size())
    {
      String str = (String)((List)localObject2).get(i);
      Object localObject3;
      if (TextUtils.isEmpty(str))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleClickNextBtnForOnlyPhoto--empty path, drop it: ");
        ((StringBuilder)localObject3).append(str);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject3).toString());
      }
      else if (!new File(str).exists())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleClickNextBtnForOnlyPhoto--file not exists, drop it: ");
        ((StringBuilder)localObject3).append(str);
        AEQLog.d("AECirclePhotoListLogic", ((StringBuilder)localObject3).toString());
      }
      else
      {
        ((ArrayList)localObject1).add(a(str));
        localObject3 = new AEPhotoCropInfoWrapper();
        ((AEPhotoCropInfoWrapper)localObject3).a = a(str);
        localObject3 = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject3).a);
        ((AEAlbumImageModel)localObject3).setOriginPath(str);
        localArrayList.add(localObject3);
      }
      i += 1;
    }
    if (CollectionUtils.isEmpty((Collection)localObject1))
    {
      QQToast.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2064515218, 0).a();
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject1);
    ((Bundle)localObject2).putSerializable("ae_album_selected_media_models", localArrayList);
    ((Bundle)localObject2).putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo);
    ((Bundle)localObject2).putBoolean("key_qcircle_publish_back_edit", this.jdField_a_of_type_Boolean);
    localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject1 != null) {
      ((Bundle)localObject2).putStringArrayList("key_qcircle_publish_out_imagepath", (ArrayList)localObject1);
    }
    i = AECameraEntry.y.a();
    if (AECameraEntryManager.m(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = AECameraEntry.A.a();
    }
    localObject1 = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    if (AECameraEntryManager.o(((Activity)localObject1).getIntent()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("ae_album_selected_media_models", localArrayList);
      ((Activity)localObject1).setResult(-1, (Intent)localObject2);
      ((Activity)localObject1).finish();
      return;
    }
    if ((paramInt != 1) && ((paramInt == 2) || (paramInt == 3))) {
      j = 1;
    }
    ((Bundle)localObject2).putInt("ae_video_editor_entrance_id", paramInt);
    AEEditorLauncher.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), j, (Bundle)localObject2, i);
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
          QQToast.a(paramContext, HardCodeUtil.a(2064515229), 0).a();
          return;
        }
        QQToast.a(paramContext, HardCodeUtil.a(2064515226), 0).a();
        return;
      }
      QQToast.a(paramContext, HardCodeUtil.a(2064515228), 0).a();
      return;
    }
    QQToast.a(paramContext, "请选择2秒到1小时之间的视频", 0).a();
  }
  
  @WorkerThread
  private void a(ArrayList<AEAlbumVideoModel> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    do
    {
      if (i >= j) {
        break;
      }
      AEAlbumVideoModel localAEAlbumVideoModel = (AEAlbumVideoModel)paramArrayList.get(i);
      LocalMediaInfo localLocalMediaInfo = a(localAEAlbumVideoModel.getPath());
      localAEAlbumVideoModel.setOriginPath(localAEAlbumVideoModel.getPath());
      i += 1;
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("batchCompress---begin, index=");
      localStringBuilder.append(i);
      AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.14(this, i, j));
      a(localLocalMediaInfo, new AECirclePhotoListLogic.15(this, i, localAEAlbumVideoModel));
      if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch != null)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = null;
      }
    } while ((!this.d) && (!this.e));
  }
  
  private void a(ArrayList<AEAlbumMediaBaseModel> paramArrayList, boolean paramBoolean, int paramInt)
  {
    Activity localActivity = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    Object localObject2 = localActivity.getIntent();
    if (AECameraEntryManager.o((Intent)localObject2))
    {
      AEQLog.b("AECirclePhotoListLogic", "doRealJumpForMix---is additional pick case, setResult and finish");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("ae_album_selected_media_models", paramArrayList);
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap.recovery", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
      ((Intent)localObject1).putExtra("key_qcircle_publish_back_edit", this.jdField_a_of_type_Boolean);
      localActivity.setResult(-1, (Intent)localObject1);
      localActivity.finish();
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("ae_album_selected_media_models", paramArrayList);
    ((Bundle)localObject1).putSerializable("PeakConstants.selectedMediaInfoHashMap.recovery", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    ((Bundle)localObject1).putBoolean("key_qcircle_publish_back_edit", this.jdField_a_of_type_Boolean);
    ((Bundle)localObject1).putInt("ae_video_editor_entrance_id", paramInt);
    paramInt = AECameraEntry.y.a();
    if (AECameraEntryManager.m((Intent)localObject2)) {
      paramInt = AECameraEntry.A.a();
    }
    if (paramArrayList.size() == 1)
    {
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ArrayList)localObject2).add(((AEAlbumMediaBaseModel)paramArrayList.next()).getPath());
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      AEEditorLauncher.a(localActivity, 1, (Bundle)localObject1, paramInt);
      return;
    }
    AEEditorLauncher.a(localActivity, 2, (Bundle)localObject1, paramInt);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new AECirclePhotoListLogic.InitResult(this, paramInt));
    }
  }
  
  public static int b()
  {
    return jdField_c_of_type_Int;
  }
  
  private void b(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    int i = 0;
    boolean bool = false;
    while (i < localLinkedList.size())
    {
      String str1 = (String)localLinkedList.get(i);
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
        localObject = a(str1);
        if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1))
        {
          int j = a((LocalMediaInfo)localObject);
          if ((j != 2) && (j != 0))
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
            if (j == 2)
            {
              String str2 = (String)this.jdField_a_of_type_JavaUtilMap.get(str1);
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
      i += 1;
    }
    if (CollectionUtils.isEmpty(localArrayList1))
    {
      AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
      QQToast.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2064515219, 0).a();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      a(localArrayList1, bool, paramInt);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog = new AEEditorCancelableProgressDialog(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2064515420));
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.a(new AECirclePhotoListLogic.11(this));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEEditorCancelableProgressDialog.show();
    AEQLog.a("AECirclePhotoListLogic", "after show, submit compress task");
    ThreadManagerV2.excute(new AECirclePhotoListLogic.12(this, localArrayList2, localArrayList1, bool, paramInt), 16, new AECirclePhotoListLogic.13(this), true);
  }
  
  private void c(Intent paramIntent)
  {
    if (!"album".equals(paramIntent.getStringExtra("tab"))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum = 0;
    this.jdField_b_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("key_qcircle_publish_out_imagepath");
    long l = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getLong("key_ae_editor_record_type", 0L, 0);
    if (l == 2L)
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
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localAEAlbumMediaBaseModel.getOriginPath());
          }
          if (l != 1L) {
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
      paramIntent = AEEditorRecordDataManager.a().a(this.jdField_b_of_type_JavaUtilArrayList);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.addAll(paramIntent);
      }
    }
  }
  
  private void d(Intent paramIntent)
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
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData = new AECirclePhotoListLogic.PhotoListGuideData(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_Boolean = false;
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
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_b_of_type_Int = -1;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_a_of_type_Int = 0;
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_b_of_type_Int = 2;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_b_of_type_Int = 1;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_a_of_type_Int = 0;
    }
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_c_of_type_Int = 0;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).d = 3;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).e = 4;
        ((AECirclePhotoListLogic.PhotoListGuideData)localObject).f = (-ViewUtils.a(20.0F));
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.g = ViewUtils.a(6.0F);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_c_of_type_Int = 1;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).d = 0;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).e = 3;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).f = 0;
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).g = ViewUtils.a(6.0F);
    }
    if (bool1)
    {
      paramIntent = a(paramIntent);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("勾选后进入下一步可预览");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("滤镜");
      ((AECirclePhotoListLogic.PhotoListGuideData)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "勾选后进入下一步可预览贴纸效果";
      return;
    }
    if (bool3)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "勾选后进入下一步可预览大片效果";
      return;
    }
    if (bool4)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "勾选后进入下一步可添加别致文字哟";
      return;
    }
    if (bool5)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "勾选后进入下一步可预览边框效果";
      return;
    }
    if (bool6)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "勾选后进入下一步可预览大片效果";
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic$PhotoListGuideData.jdField_a_of_type_JavaLangString = "";
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(paramIntent)) {
      PeakIpcController.a(paramIntent, "action_qcircle_picker_ready");
    }
  }
  
  private void h()
  {
    Intent localIntent = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForMix;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    }
    if (localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    }
  }
  
  private void i()
  {
    if (!AEKitForQQ.a())
    {
      this.jdField_a_of_type_JavaUtilList.add(new AECirclePhotoListLogic.InitResult(this, -1));
    }
    else
    {
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
    TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AECirclePhotoListLogic.8(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public AEAlbumLogicData a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData;
  }
  
  @Nullable
  public LocalMediaInfo a(Object paramObject)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramObject);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
      localObject2 = localObject1;
      if (localPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
  }
  
  public PhotoCommonBaseData<OtherCommonData> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
  }
  
  public PhotoListBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 15;
    } else {
      i = QzoneConfig.getMaxPhotoNumInRecentPhoto();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AECirclePhotoListLogic:QueryPhotoTask", 4, "getLocalMediaInfo start ");
    }
    long l = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.queryNext(i);
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.createMediaQueryHelper(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.queryNext(i);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.mediaList;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalMediaInfo end, cost ");
      localStringBuilder.append(System.currentTimeMillis() - l);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i))) {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic close，fragment = ");
      localStringBuilder.append(this.jdField_a_of_type_MqqUtilWeakReference.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
      ((PhotoCommonBaseData)localObject).albumId = "$RecentAlbumId";
      ((PhotoCommonBaseData)localObject).albumName = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.t = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    ((PhotoCommonBaseData)localObject).filter = MediaFileFilter.getFilter(((PhotoCommonBaseData)localObject).showMediaType);
    if (paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.needVideo = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.needGif = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.e = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
    paramIntent.removeExtra("PHOTOLIST_START_POSITION");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData;
    ((AEAlbumLogicData)localObject).minSelectNumForMix = 2;
    ((AEAlbumLogicData)localObject).maxSelectNumForMix = 30;
    ((AEAlbumLogicData)localObject).minSelectNumForNormal = -2147483648;
    ((AEAlbumLogicData)localObject).canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    h();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initData---aeAlbumData=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData);
    AEQLog.b("AECirclePhotoListLogic", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    localObject = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
      localPhotoCommonBaseData.albumName = ((String)localObject);
      localPhotoCommonBaseData.albumId = str;
    }
    this.jdField_c_of_type_Boolean = (AECameraEntryManager.o(paramIntent) ^ true);
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.createMediaQueryHelper(BaseApplicationImpl.getContext());
    jdField_b_of_type_Int = 3000;
    jdField_c_of_type_Int = 3000;
    d(paramIntent);
    if (!paramIntent.getBooleanExtra("key_qcircle_publish_from_preview", false))
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_qcircle_publish_back_edit", false);
      if (this.jdField_a_of_type_Boolean)
      {
        c(paramIntent);
        return;
      }
      if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1)
      {
        if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
        {
          paramIntent = (Fragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
          paramIntent = DialogUtil.a(paramIntent.getActivity(), 230).setTitle(paramIntent.getActivity().getResources().getString(2064515401)).setPositiveButton(paramIntent.getActivity().getString(2064515120), new AECirclePhotoListLogic.3(this, paramIntent)).setNegativeButton(paramIntent.getActivity().getString(2064515117), new AECirclePhotoListLogic.2(this));
          ThreadManager.getUIHandler().postDelayed(new AECirclePhotoListLogic.4(this, paramIntent), 200L);
        }
      }
      else
      {
        AEEditorRecordDataManager.e();
        if ((AEEditorRecordDataManager.a().a()) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
        {
          paramIntent = (Fragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
          paramIntent = DialogUtil.a(paramIntent.getActivity(), 230).setTitle(paramIntent.getActivity().getResources().getString(2064515402)).setPositiveButton(paramIntent.getActivity().getString(2064515120), new AECirclePhotoListLogic.6(this)).setNegativeButton(paramIntent.getActivity().getString(2064515117), new AECirclePhotoListLogic.5(this));
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
    paramView = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null)) {
      ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().setResult(0, ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent());
    }
    ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    AlbumUtil.anim(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
    AEBaseDataReporter.a().b(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(AECircleAlbumListPart paramAECircleAlbumListPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart = paramAECircleAlbumListPart;
  }
  
  public void a(AECirclePhotoListPart paramAECirclePhotoListPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart = paramAECirclePhotoListPart;
  }
  
  public void a(AECirclePreviewPart paramAECirclePreviewPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePreviewPart = paramAECirclePreviewPart;
  }
  
  public void a(AECircleSelectPanelPart paramAECircleSelectPanelPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleSelectPanelPart = paramAECircleSelectPanelPart;
  }
  
  public void a(AECircleTitleChipPart paramAECircleTitleChipPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart = paramAECircleTitleChipPart;
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
    if (localObject != null) {
      ((MovieExporter)localObject).cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    localObject = a(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, (String)localObject, localOutputConfig, new AECirclePhotoListLogic.16(this, paramVideoCompressListener, (String)localObject));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))
    {
      if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) {
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    int i = a(paramLocalMediaInfo);
    if ((i != 0) && (i != 2))
    {
      a(paramContext, i);
      return false;
    }
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      if (((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null) {
        return false;
      }
      if (paramList == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart.a(paramList);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart.a().post(new AECirclePhotoListLogic.9(this));
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart.a(paramList);
      if ((paramBoolean) && (paramList.isEmpty())) {
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart.a().post(new AECirclePhotoListLogic.10(this));
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        paramList = (AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if ((paramList != null) && (paramList.getActivity() != null))
        {
          paramList = paramList.getActivity().getIntent();
          if (AECameraEntryManager.k(paramList))
          {
            long l2 = System.currentTimeMillis();
            long l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
            l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
            if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L))
            {
              AEBaseDataReporter.a().a(l1, l2);
              e(paramList);
            }
          }
        }
      }
      SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.m) {
      AlbumThumbManager.getInstance(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    a();
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
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
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
  }
  
  public void b(boolean paramBoolean)
  {
    i();
    j();
    if (paramBoolean)
    {
      b(1);
      return;
    }
    a(1);
  }
  
  protected void c()
  {
    MovieExporter localMovieExporter = this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
    if (localMovieExporter != null) {
      localMovieExporter.cancelCompress();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    i();
    j();
    if (paramBoolean)
    {
      b(2);
      return;
    }
    a(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if ((localObject != null) && (((PhotoCommonBaseData)localObject).selectedPhotoList != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
      AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString = AEBaseReportParam.a().b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      boolean bool2 = false;
      long l = 0L;
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = a(((Iterator)localObject).next());
        if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
        {
          i += 1;
          l += localLocalMediaInfo.mDuration / 1000L;
        }
      }
      if (i > 0)
      {
        AEBaseReportParam.a().a().b = AEBaseReportParam.g.longValue();
        AEBaseReportParam.a().a().f = i;
        AEBaseReportParam.a().a().c = l;
        j -= i;
      }
      else
      {
        AEBaseReportParam.a().a().b = AEBaseReportParam.d.longValue();
      }
      AEBaseDataReporter.a().a(j);
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      AEReportUtils.a(bool1, j, i);
      boolean bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
      b(bool1);
    }
  }
  
  public void f()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    boolean bool = false;
    int i = 0;
    while (localIterator.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = a(localIterator.next());
      if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
        i += 1;
      }
    }
    AEReportUtils.a(j, j - i, i);
    if (i > 0) {
      bool = true;
    }
    c(bool);
  }
  
  public void g()
  {
    AECircleAlbumListPart localAECircleAlbumListPart = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart;
    if (localAECircleAlbumListPart != null) {
      localAECircleAlbumListPart.a(false, false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic
 * JD-Core Version:    0.7.0.1
 */