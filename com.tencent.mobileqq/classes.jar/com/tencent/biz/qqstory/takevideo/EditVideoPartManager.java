package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.biz.qqstory.takevideo.publish.DoodleRotateSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import com.tencent.biz.qqstory.takevideo.publish.MergeThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import com.tencent.biz.qqstory.takevideo.publish.ResizeBitmapSegment;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EditVideoPartManager
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = 0;
  protected Intent a;
  protected EditGifImage a;
  protected EditGifSpeedControl a;
  protected EditJumpToPtu a;
  protected EditLocalVideoPlayer a;
  protected EditPicCropPart a;
  protected EditPicRawImage a;
  protected EditPicSave a;
  protected EditVideoArtFilter a;
  protected EditVideoButton a;
  protected EditVideoDoodle a;
  protected EditVideoFilter a;
  protected EditVideoFragment a;
  protected EditVideoGuide a;
  protected EditVideoLabel a;
  protected EditVideoMusic a;
  public EditVideoParams a;
  protected EditVideoPermission a;
  protected EditVideoPlayer a;
  protected EditVideoPoi a;
  protected EditVideoPoiSearch a;
  protected EditVideoSave a;
  protected EditVideoShareGroup a;
  protected EditVideoShareTo a;
  protected EditVideoTag a;
  EditVideoUi jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi;
  protected List<EditVideoPart> a;
  protected Map<Class<? extends EditVideoPart.EditExport>, EditVideoPart.EditExport> a;
  protected final AtomicInteger a;
  protected boolean a;
  protected int b;
  protected List<Error> b;
  private AtomicInteger b;
  protected boolean b;
  protected boolean c = false;
  public boolean d;
  
  public EditVideoPartManager()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private EditVideoPart a(@NonNull EditVideoParams paramEditVideoParams)
  {
    if (paramEditVideoParams.a())
    {
      paramEditVideoParams = new EditPicRawImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.e())
    {
      paramEditVideoParams = new EditGifImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if ((paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
      return new HWEditLocalVideoPlayer(this);
    }
    if ((paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      if (paramEditVideoParams.g()) {
        return new HWEditLocalVideoPlayer(this);
      }
      paramEditVideoParams = new EditLocalVideoPlayer(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.g()) {
      return new HWEditLocalVideoPlayer(this);
    }
    paramEditVideoParams = new EditVideoPlayer(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPlayer = paramEditVideoParams;
    return paramEditVideoParams;
  }
  
  private void a(EditVideoParams.EditSource paramEditSource)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localGenerateContext.jdField_b_of_type_JavaLangString == null) {
      localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.a())) || (((EditLocalGifSource)paramEditSource).a.size() <= 0)) {
        break label139;
      }
    }
    label139:
    for (localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs((String)((EditLocalGifSource)paramEditSource).a.get(0));; localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(paramEditSource.a()))
    {
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((EditVideoPart)paramEditSource.next()).a(0, localGenerateContext);
      }
    }
    a(localGenerateContext);
    b(localGenerateContext);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localGenerateContext.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703836), false, 500L);
    Stream.of(localGenerateContext).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new MergePicSegment(EditPicConstants.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(a(localGenerateContext));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private boolean a(GenerateContext paramGenerateContext)
  {
    if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath != null);
      if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData != null)
      {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath != null) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (paramGenerateContext.jdField_b_of_type_Boolean) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0));
    return false;
  }
  
  private void b()
  {
    b(0);
  }
  
  private void b(int paramInt)
  {
    label52:
    String str2;
    if (a())
    {
      a("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label158;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        paramInt = b();
        str2 = a(str1);
        if (!a()) {
          break label163;
        }
      }
    }
    label158:
    label163:
    for (String str1 = "2";; str1 = "1")
    {
      b("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      return;
      a("pub_video", 0, 0, new String[] { "", String.valueOf(a(paramInt)) });
      Bosses.get().postJob(new EditVideoPartManager.6(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
      break;
      paramInt = 0;
      break label52;
    }
  }
  
  private void b(EditVideoParams.EditSource paramEditSource)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i;
    int j;
    String str1;
    float f;
    int k;
    String str2;
    boolean bool1;
    ArrayList localArrayList;
    String str3;
    String str4;
    if ((paramEditSource instanceof EditRecordVideoSource))
    {
      localObject1 = (EditRecordVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = (int)((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      CodecParam.mRecordFrames = ((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        i = ((EditRecordVideoSource)localObject1).f;
        j = ((EditRecordVideoSource)localObject1).g;
        str1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject1).e;
        str2 = ((EditRecordVideoSource)localObject1).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) || (!a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768))) {
          break label1041;
        }
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment != null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((VideoFragmentInfo)((Iterator)localObject1).next()).c));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        j = ((EditLocalVideoSource)localObject1).a();
        k = ((EditLocalVideoSource)localObject1).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        i = ((EditTakeVideoSource)localObject1).a();
        j = ((EditTakeVideoSource)localObject1).b();
        str1 = ((EditTakeVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        break;
      }
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131703767) + paramEditSource);
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    int m = 1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
    this.jdField_b_of_type_JavaUtilList.clear();
    int n = 0;
    label759:
    int i1;
    GenerateContext localGenerateContext;
    label914:
    label957:
    Object localObject2;
    if (n < localArrayList.size())
    {
      i1 = ((Integer)localArrayList.get(n)).intValue();
      b(i1);
      localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str3;
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (n * 1000 + l);
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str4;
      localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      boolean bool2;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() == 5))
      {
        bool2 = true;
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs((Activity)localObject1, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if (!(paramEditSource instanceof EditLocalVideoSource)) {
          break label1065;
        }
        localGenerateContext.c = 0;
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(localGenerateContext.c));
        if (!(paramEditSource instanceof EditTakeVideoSource)) {
          break label1075;
        }
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((EditVideoPart)((Iterator)localObject1).next()).a(i1, localGenerateContext);
        }
        label1041:
        localArrayList.add(Integer.valueOf(0));
        m = 0;
        break;
        bool2 = false;
        break label914;
        label1065:
        localGenerateContext.c = k;
        break label957;
        label1075:
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      a(localGenerateContext);
      b(localGenerateContext);
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localGenerateContext.jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703765), false, 500L);
      localObject1 = Stream.of(localGenerateContext).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1305;
      }
      localObject1 = ((Stream)localObject1).map(new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), i1));
      label1205:
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a(i1));
      }
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1357;
      }
    }
    label1305:
    label1357:
    for (Object localObject1 = ((Stream)localObject2).map(new HWEncodeMergeThumbSegment());; localObject1 = ((Stream)localObject2).map(new MergeThumbSegment()).map(new DoodleRotateSegment()))
    {
      ((Stream)localObject1).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localGenerateContext));
      n += 1;
      break label759;
      break;
      if (m != 0)
      {
        localObject1 = ((Stream)localObject1).map(new GenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), i1));
        break label1205;
      }
      localObject1 = ((Stream)localObject1).map(new GenerateThumbSegment());
      break label1205;
    }
  }
  
  private void c(EditVideoParams.EditSource paramEditSource)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localGenerateContext.jdField_b_of_type_JavaLangString == null) {
      localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).a(0, localGenerateContext);
    }
    a(localGenerateContext);
    b(localGenerateContext);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localGenerateContext.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703822), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localGenerateContext).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new MergePicSegment(false)).map(new ResizeBitmapSegment());
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new GeneratePicThumbSegment((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a(0));
      }
      paramEditSource.map(new MergeThumbSegment()).map(new DoodleRotateSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localGenerateContext));
      return;
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a();
    }
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    o();
    v();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing, %s", new Throwable());
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((EditVideoPart)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label105;
      }
      i += 1;
    }
    label105:
    for (;;)
    {
      break;
      if (i == 0) {
        SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled. %s", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditLocalGifSource)))
        {
          l = 5000L;
        }
        else if ((localObject instanceof EditLocalVideoSource))
        {
          localObject = (EditLocalVideoSource)localObject;
          l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
          if (l == 0L) {
            l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
        }
        else if ((localObject instanceof EditTakeVideoSource))
        {
          l = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        else
        {
          throw new RuntimeException(HardCodeUtil.a(2131703839));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      }
    }
  }
  
  public long a(int paramInt)
  {
    Object localObject;
    long l2;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768)))
    {
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null)
      {
        l2 = ((EditVideoPlayerExport)localObject).a(paramInt);
        SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label146;
        }
        l1 = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a())
        {
        default: 
          return l1;
          if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
          {
            l1 = 5000L;
          }
          else if ((localObject instanceof EditLocalVideoSource))
          {
            localObject = (EditLocalVideoSource)localObject;
            l1 = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
            if (l1 == 0L) {
              l1 = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
            }
          }
          else if ((localObject instanceof EditTakeVideoSource))
          {
            l1 = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
          else
          {
            throw new RuntimeException(HardCodeUtil.a(2131703877));
          }
          break;
        case 1: 
          return l1 / 2L;
        case 2: 
          label146:
          return l1 * 2L;
        }
      }
      l2 = 0L;
    }
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.a();
    }
    return localBitmap;
  }
  
  @Nullable
  public EditVideoPart.EditExport a(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  protected SimpleObserver<GenerateContext> a(GenerateContext paramGenerateContext)
  {
    return new EditVideoPartManager.7(this, paramGenerateContext, SystemClock.uptimeMillis());
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.jdField_a_of_type_JavaLangString.length())) {
      return ":" + paramString.substring(PtvTemplateManager.jdField_a_of_type_JavaLangString.length());
    }
    return "";
  }
  
  public void a()
  {
    int i = 0;
    o();
    v();
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).h();
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localObject });
      if ((!(localObject instanceof EditRecordVideoSource)) && (!(localObject instanceof EditLocalVideoSource)) && (!(localObject instanceof EditTakeVideoSource))) {
        break label131;
      }
      b((EditVideoParams.EditSource)localObject);
      if ((localObject instanceof EditLocalVideoSource)) {
        StoryReportor.a("video_edit", "pub_local", 0, 0, new String[] { "1" });
      }
    }
    label131:
    do
    {
      return;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
      return;
      if (((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditTakePhotoSource)))
      {
        b();
        CodecParam.mRecordTime = 5000;
        CodecParam.mRecordFrames = 125;
        CodecParam.mIsSmooth = 0;
        CodecParam.mEnableTotalTimeAdjust = 0;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
        {
          CodecParam.mSaveMode = i;
          c((EditVideoParams.EditSource)localObject);
          StoryReportor.a("video_edit", "pub_local", 0, 0, new String[0]);
          return;
        }
      }
    } while (!(localObject instanceof EditLocalGifSource));
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
    }
    CodecParam.mSaveMode = i;
    a((EditVideoParams.EditSource)localObject);
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    o();
    v();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if (this.jdField_b_of_type_Int != paramInt)
    {
      if (this.jdField_a_of_type_Boolean) {
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_b_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(i, this.jdField_b_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b() == 14) {
      StoryReportor.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = a();
    paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int i;
    if ((paramContext instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)paramContext).jdField_b_of_type_Int == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("report_entrance_type", 0);
      int k = b();
      if (a())
      {
        paramContext = "2";
        label90:
        b("clk_publish", k, 0, new String[] { paramContext, String.valueOf(l), String.valueOf(i), j + "" });
        if (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768))
        {
          i = d();
          if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
            break label361;
          }
          paramContext = "0";
          label181:
          b("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b() != 16) {
          break label368;
        }
      }
      label361:
      label368:
      for (i = 1;; i = 0)
      {
        paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("story_default_label");
        l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("story_topic_id", 0L);
        if ((i != 0) && (!TextUtils.isEmpty(paramContext)) && (l > 0L)) {
          StoryReportor.a("content_flow", "clk_hot_pub", 0, 0, new String[] { String.valueOf(l), paramContext });
        }
        return;
        i = 2;
        break;
        if ((paramContext instanceof EditTakeVideoSource))
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("currentCamera", 2) == 1)
          {
            i = 1;
            break;
          }
          i = 2;
          break;
        }
        if (!(paramContext instanceof EditTakePhotoSource)) {
          break label373;
        }
        if (((EditTakePhotoSource)paramContext).jdField_a_of_type_Int == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        paramContext = "1";
        break label90;
        paramContext = "1";
        break label181;
      }
      label373:
      i = 3;
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0);
      return;
    }
    paramIntent.setClassName("com.tencent.mobileqq", ForwardRecentActivity.class.getName());
    paramIntent.putExtra("forward_type", 21);
    paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
    paramIntent.putExtra("k_qzone", true);
    paramIntent.putExtra("k_qqstory", true);
    paramIntent.putExtra("forward_thumb", paramPublishParam.c);
    paramIntent.putExtra("forward_urldrawable", true);
    paramIntent.putExtra("forward_urldrawable_big_url", paramPublishParam.c);
    paramIntent.putExtra("forward_urldrawable_thumb_url", paramPublishParam.c);
    paramIntent.putExtra("k_dataline", false);
    paramIntent.putExtra("k_smartdevice", false);
    paramIntent.putExtra("k_favorites", false);
    paramIntent.putExtra("k_phonecontacts", false);
    paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
    paramIntent.putExtra("forward_source_from_pre_guide", true);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(paramIntent, 10010);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    o();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new EditVideoButton(this, i);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
    localArrayList.add(localObject);
    localArrayList.add(a(paramEditVideoParams));
    if (a(i, 256))
    {
      localObject = new EditVideoGuide(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 32))
    {
      localObject = new EditVideoMusic(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = ((EditVideoMusic)localObject);
      localArrayList.add(localObject);
    }
    if ((a(i, 1)) || (a(i, 4)) || (a(i, 8)))
    {
      localObject = new EditVideoDoodle(this, i);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoPoi(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi = ((EditVideoPoi)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoPoiSearch(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch = ((EditVideoPoiSearch)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 64))
    {
      if (paramEditVideoParams.jdField_a_of_type_Int == 1)
      {
        localObject = new EditVideoFilterNeo(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
    }
    else
    {
      if (a(i, 128))
      {
        localObject = new EditVideoLabel(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel = ((EditVideoLabel)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.a()) || (paramEditVideoParams.e())) && (a(i, 16)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(i, 2)))
      {
        localObject = new EditPicCropPart(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 1024))
      {
        if (!paramEditVideoParams.a()) {
          break label751;
        }
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (a(i, 4096))
      {
        localObject = new EditGifSpeedControl(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifSpeedControl = ((EditGifSpeedControl)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 16384))
      {
        localObject = new EditVideoPermission(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPermission = ((EditVideoPermission)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 131072))
      {
        localObject = new EditVideoShareTo(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoShareTo = ((EditVideoShareTo)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (a(i, 32768)))
      {
        paramEditVideoParams = new EditVideoFragment(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      if (a(i, 2097152))
      {
        paramEditVideoParams = new EditVideoShareGroup(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoShareGroup = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      if (a(i, 4194304))
      {
        paramEditVideoParams = new EditVideoTag(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((EditVideoPart)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      localObject = new EditVideoFilter(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break;
      label751:
      localObject = new EditVideoSave(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave = ((EditVideoSave)localObject);
      localArrayList.add(localObject);
    }
  }
  
  public void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    o();
    if ((paramEditVideoUi == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi != paramEditVideoUi) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi = paramEditVideoUi;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((EditVideoPart)paramEditVideoParams.next()).a(paramEditVideoUi);
      continue;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramEditVideoUi, paramEditVideoParams });
    }
  }
  
  public void a(GenerateContext paramGenerateContext)
  {
    Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    o();
    v();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(paramEditExport)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + paramEditExport.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    EditVideoPart.EditExport localEditExport = (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localEditExport == null) {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), paramEditExport);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramEditExport);
      return;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localEditExport, paramEditExport });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      Bosses.get().postJob(new EditVideoPartManager.4(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<EditVideoPart> paramList) {}
  
  protected void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    for (;;)
    {
      try
      {
        if (!this.d) {
          continue;
        }
        i = 3;
        VideoSourceHelper.nativeSetPlayStepFrameCount(i);
        if (!this.d) {
          continue;
        }
        i = 2;
        VideoSourceHelper.nativeSetPlayGapFrameCount(i);
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "VideoSourceHelper error:", localThrowable);
        continue;
        VideoSourceHelper.nativeSetPlayAFMute(this.d);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b(paramBoolean);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public boolean a()
  {
    o();
    v();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int == paramInt;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int)
    {
    default: 
      return 999;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_b_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(GenerateContext paramGenerateContext)
  {
    long l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new EditVideoPartManager.5(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifSpeedControl != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifSpeedControl.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifSpeedControl });
      return true;
    }
    d();
    return true;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.jdField_b_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int c()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a(a());
    }
    int j = i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment != null)
    {
      List localList = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a();
      if (localList != null) {
        return localList.size();
      }
    }
    return 1;
  }
  
  public void d()
  {
    o();
    v();
    Object localObject;
    if (a())
    {
      localObject = "2";
      a("clk_left", 0, 0, new String[] { localObject });
      VideoEditReport.a("0X80076B6");
      VideoEditReport.b("0X80075C2");
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle == null) {
        break label478;
      }
    }
    label444:
    label478:
    for (int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.b();; j = 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoLabel.a())) {
          i = j + 1;
        }
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
        j = i;
        if (localObject != null)
        {
          j = i;
          if (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).g)) {
            j = i + 1;
          }
        }
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart != null) {
        i = j + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_Int;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
          j = i + 4;
        }
      }
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
      if (j < 4)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) && (!HardCodeUtil.a(2131703826).equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.get("extra_publish_text"))))
        {
          localObject = HardCodeUtil.a(2131703873);
          DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 230, (String)localObject, null, HardCodeUtil.a(2131703848), HardCodeUtil.a(2131703791), new EditVideoPartManager.1(this), new EditVideoPartManager.2(this)).show();
          return;
          localObject = "1";
          break;
        }
        c();
        return;
      }
      if (a())
      {
        localObject = "2";
        a("clk_left_float", 0, 0, new String[] { localObject });
        VideoEditReport.a("0X80076B7");
        VideoEditReport.b("0X80075C3");
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) {
          break label444;
        }
        localObject = HardCodeUtil.a(2131703755);
      }
      for (;;)
      {
        ActionSheet localActionSheet = ActionSheet.createFullScreenDialog(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), false);
        localActionSheet.setMainTitle((CharSequence)localObject);
        localActionSheet.addButton(HardCodeUtil.a(2131703825), 3);
        localActionSheet.addCancelButton(HardCodeUtil.a(2131703790));
        localActionSheet.setOnButtonClickListener(new EditVideoPartManager.3(this, localActionSheet));
        localActionSheet.show();
        return;
        localObject = "1";
        break;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.d)) {
          localObject = "放弃本次GIF编辑？";
        } else {
          localObject = HardCodeUtil.a(2131703941);
        }
      }
    }
  }
  
  public void e()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      LineLayer localLineLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a().a();
      i = j;
      if (localLineLayer != null)
      {
        i = j;
        if (localLineLayer.a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703739), false, 500L);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a().h();
          i = 1;
        }
      }
    }
    if (i == 0) {
      f();
    }
  }
  
  public void f()
  {
    a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a());
    a();
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    if ((localActivity instanceof EditPicActivity)) {}
    switch (localActivity.getIntent().getIntExtra("editpic_cameratype", -1))
    {
    default: 
      return;
    case 1: 
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      NewFlowCameraReporter.c();
      return;
    case 2: 
      NewFlowCameraReporter.d();
      return;
    }
    NewFlowCameraReporter.e();
  }
  
  public void g()
  {
    int i = 0;
    o();
    v();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
      EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      }
      CodecParam.mSaveMode = i;
      c(localEditSource);
      return;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate publish", new Throwable());
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.jdField_a_of_type_Int == 2)) {
      a(10);
    }
  }
  
  public void i()
  {
    o();
    v();
    this.c = true;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a();
    }
    if (a()) {}
    for (localObject = "2";; localObject = "1")
    {
      a("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoShareTo != null) {
        StoryReportor.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).c();
    }
  }
  
  public void k()
  {
    if (this.jdField_b_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).U_();
    }
    if ((!a()) || (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32)))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "getAudioResource, edit photo = %s", Boolean.valueOf(a()));
      GloableValue.a();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).f();
    }
    if ((!a()) || (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32)))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "releaseAudioResource, edit photo = %s", Boolean.valueOf(a()));
      GloableValue.b();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).V_();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).d();
      }
    }
    this.c = false;
  }
  
  protected void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void p()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    if (localDoodleLayout != null) {
      localDoodleLayout.a.c();
    }
  }
  
  void q()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart;
    ((EditPicCropPart)localObject).jdField_a_of_type_Int += c();
    if (this.jdField_b_of_type_Int == 11) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      LineLayer localLineLayer = ((DoodleLayout)localObject).a();
      i = j;
      if (localLineLayer != null)
      {
        i = j;
        if (localLineLayer.a.a())
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703959), false, 500L);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).h();
          i = 1;
        }
      }
    } while (i != 0);
    r();
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    Object localObject2 = ((DoodleLayout)localObject1).a(0);
    Object localObject3 = ((DoodleLayout)localObject1).b(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[0] = localObject2[0];
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[1] = localObject2[1];
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[2] = localObject3[0];
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[3] = localObject3[1];
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject1).a().a();
    localObject3 = ((DoodleLayout)localObject1).a();
    localObject2 = a();
    if (localObject2 == null) {
      return;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      long l = SystemClock.uptimeMillis();
      localObject1 = BitmapUtils.c((Bitmap)localObject2, (Bitmap)localObject3);
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(11);
  }
  
  void s()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    a(0);
    a(12);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.h();
      u();
    }
    a(0);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new EditVideoPartManager.8(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */