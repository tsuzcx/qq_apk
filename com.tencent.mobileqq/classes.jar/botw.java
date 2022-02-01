import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class botw
  implements IEventReceiver
{
  public static bppu a;
  public int a;
  public Intent a;
  public Bundle a;
  public ViewGroup a;
  public RelativeLayout a;
  protected boiv a;
  protected borr a;
  protected boru a;
  public bosf a;
  protected bosl a;
  public bosq a;
  protected bosz a;
  protected botb a;
  public botf a;
  protected botr a;
  protected boub a;
  protected boug a;
  protected boul a;
  protected boun a;
  public bouo a;
  protected bpfu a;
  private VideoStoryDataBean a;
  public EditPicRawImage a;
  public EditVideoParams a;
  public EditVideoSpeedFilter a;
  protected HWEditLocalVideoPlayer a;
  protected List<botu> a;
  protected Map<Class<? extends botv>, botv> a;
  protected final AtomicInteger a;
  protected boolean a;
  public int b;
  protected List<Error> b;
  public boolean b;
  private int c;
  protected boolean c;
  public boolean d = true;
  
  public botw()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Bouo == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void b()
  {
    c(0);
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<bpel> paramObserver)
  {
    Object localObject = new bpel(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((bpel)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    ((bpel)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    ((bpel)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (((bpel)localObject).jdField_b_of_type_JavaLangString == null) {
      ((bpel)localObject).jdField_b_of_type_JavaLangString = bpfc.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    ((bpel)localObject).jdField_a_of_type_Bpeq = new bpeq(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((botu)paramEditSource.next()).a(0, (bpel)localObject);
    }
    a((bpel)localObject);
    b((bpel)localObject);
    ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bpel)localObject).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bouo.a(anvx.a(2131703307), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new bpfa(false)).map(new bpff());
    localObject = this.jdField_a_of_type_Bouo.getActivity();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new bper((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Botf != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Botf.a(0));
      }
      paramEditSource.map(new bpfb()).map((StreamFunction)weg.a(bpek.class, new Object[0])).map(new bpfe(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
    }
  }
  
  private void c(int paramInt)
  {
    if (!a()) {
      Bosses.get().postJob(new botz(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_slide_show_video", false)) {
      ykv.a("video_edit", "pub_slides", 0, 0, new String[0]);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 104) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        ykv.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      return;
    }
  }
  
  private void z()
  {
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      ykq.c("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() + " , isEditCamera:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() != 120) {
        break label320;
      }
      i = 1;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()) {
        break label325;
      }
    }
    label320:
    label325:
    for (int j = 1;; j = 2)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("lens_id", bogm.jdField_b_of_type_JavaLangString);
        localJSONObject1.put("lens_tab", a().getLensTabId());
        localJSONObject1.put("watermark_id", a().getWatermarkId());
        localJSONObject1.put("music_id", a().getSongMid());
        localJSONObject1.put("filter_id", a().getFilterId());
        localJSONObject1.put("sticker_id", a().getStickerId());
        localJSONObject1.put("word_id", a().getWordId());
        if (a().getMusicType() == 1) {
          localJSONObject1.put("music_play_time", a().getMusciPlayTime());
        }
        localJSONObject1.put("video_duration", a().getVideoDuration());
        localJSONObject2.put("music_type", a().getMusicType());
        localJSONObject2.put("filter_type", a().getFilterType());
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      aanb.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", localJSONObject1.toString(), localJSONObject2.toString() });
      return;
      i = 2;
      break;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    n();
    if (this.jdField_b_of_type_Boolean)
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((botu)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label94;
      }
      i += 1;
    }
    label94:
    for (;;)
    {
      break;
      if (i == 0) {
        ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
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
          throw new RuntimeException(anvx.a(2131703369));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      case 4: 
        return l * 4L;
      case 3: 
        return ((float)l / 1.5F);
      }
    }
  }
  
  public long a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
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
          throw new RuntimeException(anvx.a(2131703372));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      case 4: 
        return l * 4L;
      case 3: 
        return ((float)l / 1.5F);
      }
    }
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.a();
    }
    return localBitmap;
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  View a()
  {
    if (this.jdField_a_of_type_Botb != null) {
      return this.jdField_a_of_type_Botb.a();
    }
    return null;
  }
  
  public botf a()
  {
    return this.jdField_a_of_type_Botf;
  }
  
  @Nullable
  public botv a(Class<? extends botv> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (botv)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public bouo a()
  {
    return this.jdField_a_of_type_Bouo;
  }
  
  public VideoStoryDataBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean == null)
    {
      VideoStoryDataBean localVideoStoryDataBean2 = (VideoStoryDataBean)a().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
      VideoStoryDataBean localVideoStoryDataBean1 = localVideoStoryDataBean2;
      if (localVideoStoryDataBean2 == null) {
        localVideoStoryDataBean1 = new VideoStoryDataBean();
      }
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = localVideoStoryDataBean1;
    }
    return this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  }
  
  protected SimpleObserver<bpel> a()
  {
    return new boua(this, SystemClock.uptimeMillis());
  }
  
  public List<botu> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    n();
    A();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Intent localIntent = this.jdField_a_of_type_Bouo.getActivity().getIntent();
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((bnlb.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bnlb.c(localIntent)))
      {
        if (this.jdField_a_of_type_Bouo.getActivity() != null) {
          break label189;
        }
        localObject = "";
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
        {
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = new EditLocalPhotoSource((String)localObject, localLocalMediaInfo);
        }
        o();
        this.jdField_b_of_type_Boolean = true;
        localObject = (boud)a(boud.class);
        if (localObject != null) {
          ((boud)localObject).l();
        }
        if ((!bnlb.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!bnlb.c(localIntent))) {
          break;
        }
        z();
        return;
        label189:
        if (this.jdField_a_of_type_Bouo.getActivity().getIntent() == null) {
          localObject = "";
        } else if (this.jdField_a_of_type_Bouo.getActivity().getIntent().getBundleExtra("state") == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_Bouo.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
      }
    }
    ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    return;
    Object localObject = a();
    if (((localEditSource instanceof EditRecordVideoSource)) || ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource)))
    {
      a(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        ykv.a("video_edit", "pub_local", 0, 1, new String[0]);
      }
    }
    while ((!(localEditSource instanceof EditLocalPhotoSource)) && (!(localEditSource instanceof EditTakePhotoSource)))
    {
      z();
      return;
    }
    b();
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
    {
      CodecParam.mSaveMode = i;
      b(localEditSource, (Observer)localObject);
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    boud localboud = (boud)a(boud.class);
    if (localboud != null)
    {
      if (!(localboud instanceof HWEditLocalVideoPlayer)) {
        break label43;
      }
      ((HWEditLocalVideoPlayer)localboud).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
    label43:
    while (!(localboud instanceof bous)) {
      return;
    }
    ((bous)localboud).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    n();
    A();
    if (this.jdField_b_of_type_Boolean)
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_a_of_type_Int != paramInt) || (paramInt == 2))
    {
      if (this.jdField_a_of_type_Boolean) {
        ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_a_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((botu)localIterator.next()).a(i, this.jdField_a_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a().a(paramInt, paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a(paramLong);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 14) {
      ykv.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = a();
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int i;
    if ((localObject instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)localObject).jdField_b_of_type_Int == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = b();
      if (a()) {}
      for (localObject = "2";; localObject = "1")
      {
        a("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), bjlo.a(paramContext) });
        return;
        i = 2;
        break;
        if (!(localObject instanceof EditTakePhotoSource)) {
          break label165;
        }
        if (((EditTakePhotoSource)localObject).jdField_a_of_type_Int == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
      }
      label165:
      i = 3;
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bouo.a(-1, paramIntent, 2130772030, 0, true);
      return;
    case 11: 
      paramPublishParam = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramInt = -1;
      if (localIterator.hasNext())
      {
        botu localbotu = (botu)localIterator.next();
        if (!(localbotu instanceof boro)) {
          break label185;
        }
        paramInt = ((boro)localbotu).a();
        paramPublishParam = ((boro)localbotu).a();
      }
      break;
    }
    label185:
    for (;;)
    {
      break;
      paramIntent.putExtra("theme_id", paramInt);
      paramIntent.putExtra("theme_name", paramPublishParam);
      paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish", 2, "getPublishIntent");
      }
      this.jdField_a_of_type_Bouo.a(-1, paramIntent, 2130772030, 0, true);
      return;
      this.jdField_a_of_type_Bouo.a(-1, paramIntent, 2130772030, 0, true);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    n();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  public void a(bouo parambouo, EditVideoParams paramEditVideoParams)
  {
    n();
    if ((parambouo == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Bouo != parambouo) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Bouo = parambouo;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((botu)paramEditVideoParams.next()).a(parambouo);
      continue;
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { parambouo, paramEditVideoParams });
    }
  }
  
  public void a(bpel parambpel)
  {
    Object localObject = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<bpel> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject2;
    int i;
    int j;
    String str1;
    float f;
    int k;
    Object localObject1;
    boolean bool1;
    int m;
    int n;
    boolean bool2;
    if ((paramEditSource instanceof EditRecordVideoSource))
    {
      localObject2 = (EditRecordVideoSource)paramEditSource;
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      CodecParam.mRecordFrames = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null)
      {
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();
        CodecParam.mSaveMode = i;
        i = ((EditRecordVideoSource)localObject2).f;
        j = ((EditRecordVideoSource)localObject2).g;
        str1 = ((EditRecordVideoSource)localObject2).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject2).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject2).e;
        localObject1 = ((EditRecordVideoSource)localObject2).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject2).jdField_a_of_type_Boolean;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(0));
        String str2 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str2, Integer.valueOf(localArrayList.size()));
        String str3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
        this.jdField_b_of_type_JavaUtilList.clear();
        m = 0;
        if (m >= localArrayList.size()) {
          break label1505;
        }
        n = ((Integer)localArrayList.get(m)).intValue();
        c(n);
        localObject2 = new bpel(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str2;
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (m * 1000 + l);
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
        if (bddt.f())
        {
          ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (bddt.b() * 1000);
          ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(bddt.f()));
        }
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str3;
        ((bpel)localObject2).jdField_b_of_type_JavaLangString = bpfc.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
        localObject3 = this.jdField_a_of_type_Bouo.getActivity();
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
          break label1021;
        }
        bool2 = true;
        label474:
        ((bpel)localObject2).jdField_a_of_type_Bpes = new bpes((Activity)localObject3, i, j, str1, f, bool2, k, 0.0D, 0.0D, (String)localObject1, bool1);
        if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
          break label1027;
        }
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(k));
      ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(f()));
      ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((botu)((Iterator)localObject3).next()).a(n, (bpel)localObject2);
      }
      i = 0;
      break;
      if ((paramEditSource instanceof EditLocalVideoSource))
      {
        localObject2 = (EditLocalVideoSource)paramEditSource;
        ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
        CodecParam.mRecordTime = 5000;
        CodecParam.mRecordFrames = 125;
        CodecParam.mIsSmooth = 0;
        CodecParam.mEnableTotalTimeAdjust = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
        for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
        {
          CodecParam.mSaveMode = i;
          j = ((EditLocalVideoSource)localObject2).a();
          k = ((EditLocalVideoSource)localObject2).b();
          i = Math.min(j, k);
          j = Math.max(j, k);
          str1 = ((EditLocalVideoSource)localObject2).a();
          f = i * 1.0F / j;
          k = ((EditLocalVideoSource)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
          localObject1 = "";
          bool1 = false;
          ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
          break;
        }
      }
      if ((paramEditSource instanceof EditTakeVideoSource))
      {
        localObject1 = (EditTakeVideoSource)paramEditSource;
        ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
        CodecParam.mRecordTime = 5000;
        CodecParam.mRecordFrames = 125;
        CodecParam.mIsSmooth = 0;
        CodecParam.mEnableTotalTimeAdjust = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
        for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
        {
          CodecParam.mSaveMode = i;
          i = ((EditTakeVideoSource)localObject1).a();
          j = ((EditTakeVideoSource)localObject1).b();
          str1 = ((EditTakeVideoSource)localObject1).a();
          f = i * 1.0F / j;
          k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
          localObject1 = "";
          bool1 = false;
          break;
        }
      }
      throw new IllegalArgumentException(anvx.a(2131703313) + paramEditSource);
      label1021:
      bool2 = false;
      break label474;
      label1027:
      ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
    }
    Object localObject3 = ((bpel)localObject2).jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (TextUtils.isEmpty(((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
        ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject3);
      }
    }
    else
    {
      label1091:
      a((bpel)localObject2);
      b((bpel)localObject2);
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bpel)localObject2).jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_Bouo.a(anvx.a(2131703259), false, 500L);
      localObject3 = Stream.of(localObject2).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
      if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
        break label1461;
      }
      localObject2 = new bpew(null, (boud)a(boud.class), 0);
      label1208:
      localObject3 = ((Stream)localObject3).map((StreamFunction)localObject2);
      localObject2 = localObject3;
      if (this.jdField_a_of_type_Botf != null)
      {
        localObject2 = ((Stream)localObject3).map(this.jdField_a_of_type_Botf.a(n));
        if ((this.jdField_a_of_type_Botf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a()) && (b() == 0L)) {
          break label1540;
        }
        localObject2 = ((Stream)localObject2).map(new bpen(this.jdField_a_of_type_Botf, (bort)a(bort.class), n));
      }
    }
    label1540:
    for (;;)
    {
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {}
      for (localObject2 = ((Stream)localObject2).map(new bpex());; localObject2 = ((Stream)localObject2).map(new bpfb()).map((StreamFunction)weg.a(bpek.class, new Object[0])))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", bnlb.b(this.jdField_a_of_type_Bouo.getActivity().getIntent()));
        }
        ((Stream)localObject2).map(new bpfe(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        StringBuilder localStringBuilder = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((bpel)localObject2).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
        localPublishVideoEntry.videoDoodleDescription += (String)localObject3;
        break label1091;
        label1461:
        localObject2 = new bpet();
        break label1208;
      }
      label1505:
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((botu)paramEditSource.next()).p();
      }
      return;
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ykq.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.jdField_c_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramEditVideoParams.jdField_a_of_type_Int == 11)
    {
      localObject = new boro(this, i);
      this.jdField_a_of_type_Botb = ((botb)localObject);
      localArrayList.add(localObject);
      if ((!bnlb.a(this.jdField_a_of_type_Bouo.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!bnlb.c(this.jdField_a_of_type_Bouo.getActivity().getIntent())))
      {
        localObject = new bosq(this);
        this.jdField_a_of_type_Bosq = ((bosq)localObject);
        localArrayList.add(localObject);
      }
      localObject = new borr(this);
      this.jdField_a_of_type_Borr = ((borr)localObject);
      localArrayList.add(localObject);
      if (!paramEditVideoParams.a()) {
        break label739;
      }
      localObject = new EditPicRawImage(this, i);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
      label183:
      if (a(i, 2))
      {
        if (paramEditVideoParams.jdField_a_of_type_Int != 14) {
          break label833;
        }
        localArrayList.add(new aaor(this));
      }
      label215:
      if ((a(i, 1024)) || (a(i, 1)) || (a(i, 8)))
      {
        localObject = new botf(this, i);
        this.jdField_a_of_type_Botf = ((botf)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 256))
      {
        localObject = new EditVideoSpeedFilter(this, true);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter = ((EditVideoSpeedFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(i, 4)))
      {
        localObject = new bosf(this);
        this.jdField_a_of_type_Bosf = ((bosf)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 512))
      {
        if (!bnlb.c(this.jdField_a_of_type_Bouo.getActivity().getIntent())) {
          break label862;
        }
        localObject = new bosl(this);
        this.jdField_a_of_type_Bosl = ((bosl)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (a(i, 16))
      {
        localObject = new boun(this);
        this.jdField_a_of_type_Boun = ((boun)localObject);
        localArrayList.add(localObject);
      }
      if ((bnlb.c.a(paramEditVideoParams.f)) && ((paramEditVideoParams.c()) || (paramEditVideoParams.a()) || (paramEditVideoParams.b())))
      {
        localObject = new bpfu(this);
        this.jdField_a_of_type_Bpfu = ((bpfu)localObject);
        localArrayList.add(localObject);
      }
      if (a(paramEditVideoParams.jdField_c_of_type_Int, 4096))
      {
        paramEditVideoParams = new botr(this);
        this.jdField_a_of_type_Botr = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      if (a(i, 16384))
      {
        paramEditVideoParams = new bosz(this);
        this.jdField_a_of_type_Bosz = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      ykq.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        ykq.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((botu)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 12)
      {
        localObject = new oxh(this, i);
        this.jdField_a_of_type_Botb = ((botb)localObject);
        localArrayList.add(localObject);
        break;
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 14)
      {
        localObject = new boul(this);
        this.jdField_a_of_type_Boul = ((boul)localObject);
        localArrayList.add(localObject);
        break;
      }
      localObject = new botb(this, i);
      this.jdField_a_of_type_Botb = ((botb)localObject);
      localArrayList.add(localObject);
      break;
      label739:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.d())
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label183;
        }
        localArrayList.add(new bous(this));
        break label183;
      }
      if (paramEditVideoParams.g())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break label183;
      }
      localObject = new boub(this);
      this.jdField_a_of_type_Boub = ((boub)localObject);
      localArrayList.add(localObject);
      break label183;
      label833:
      localObject = new boiv(this, false);
      this.jdField_a_of_type_Boiv = ((boiv)localObject);
      localArrayList.add(localObject);
      break label215;
      label862:
      if (!bnlb.a(this.jdField_a_of_type_Bouo.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localObject = new boug(this);
        this.jdField_a_of_type_Boug = ((boug)localObject);
        localArrayList.add(localObject);
      }
      else
      {
        localObject = new bosl(this);
        this.jdField_a_of_type_Bosl = ((bosl)localObject);
        localArrayList.add(localObject);
      }
    }
  }
  
  public void a(Class<? extends botv> paramClass, botv parambotv)
  {
    n();
    A();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(parambotv)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + parambotv.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    botv localbotv = (botv)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbotv == null) {
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), parambotv);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, parambotv);
      return;
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localbotv, parambotv });
    }
  }
  
  public void a(Error paramError)
  {
    ykq.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).a(paramError);
    }
    ykv.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bouo.b();
      QQToast.a(this.jdField_a_of_type_Bouo.a(), anvx.a(2131703241), 0).a();
      paramError = (boud)a(boud.class);
    } while (paramError == null);
    paramError.aG_();
  }
  
  public void a(String paramString)
  {
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onDlnaVideoSaved videoPath " + paramString);
    if (paramString != null)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      QZoneHelper.forwardToDLNAActivity(this.jdField_a_of_type_Bouo.getActivity(), localUserInfo, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new boty(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<botu> paramList) {}
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boud localboud = (boud)a(boud.class);
    if (localboud != null)
    {
      if (!(localboud instanceof HWEditLocalVideoPlayer)) {
        break label41;
      }
      ((HWEditLocalVideoPlayer)localboud).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    label41:
    while (!(localboud instanceof bous)) {
      return;
    }
    ((bous)localboud).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    n();
    A();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int)
    {
    default: 
      return 999;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.jdField_c_of_type_Int);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_a_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(bpel parambpel)
  {
    long l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              ykq.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public boolean b()
  {
    n();
    A();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d();
  }
  
  public int c()
  {
    if (b())
    {
      if (a()) {
        return 3;
      }
      return 4;
    }
    if (a()) {
      return 1;
    }
    return 2;
  }
  
  protected void c()
  {
    boud localboud = (boud)a(boud.class);
    if (localboud != null) {
      localboud.l();
    }
    this.jdField_a_of_type_Bouo.a(0, null, 2130772030, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).e(paramBoolean);
    }
  }
  
  public boolean c()
  {
    n();
    A();
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (!b())) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
  }
  
  public int d()
  {
    int i = 0;
    if (this.jdField_a_of_type_Botf != null) {
      i = this.jdField_a_of_type_Botf.a(a());
    }
    return i;
  }
  
  public void d()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_Botf != null)
    {
      Object localObject = this.jdField_a_of_type_Botf.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).h();
      }
      localObject = this.jdField_a_of_type_Botf.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((bowb)localObject).a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Bouo.a(anvx.a(2131703208), false, 500L);
          this.jdField_a_of_type_Botf.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Botf.a().m();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_Botf.a().a();
      j = i;
      if (localObject != null)
      {
        ((bowf)localObject).i();
        j = i;
      }
    }
    if (j == 0) {
      f();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Botb != null) {
      this.jdField_a_of_type_Botb.a(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Boiv != null) && (this.jdField_a_of_type_Boiv.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Boiv });
      return true;
    }
    if ((this.jdField_a_of_type_Botf != null) && (this.jdField_a_of_type_Botf.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Botf });
      return true;
    }
    if ((this.jdField_a_of_type_Bosf != null) && (this.jdField_a_of_type_Bosf.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bosf });
      return true;
    }
    if ((this.jdField_a_of_type_Botb != null) && (this.jdField_a_of_type_Botb.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Botb });
      return true;
    }
    if ((this.jdField_a_of_type_Boul != null) && (this.jdField_a_of_type_Boul.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Boul });
      return true;
    }
    if ((this.jdField_a_of_type_Bpfu != null) && (this.jdField_a_of_type_Bpfu.l_()))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bpfu });
      return true;
    }
    e();
    return true;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e()
  {
    n();
    A();
    bnqm.a().d();
    ykw.a("0X80076B6");
    ykw.b("0X80075C2");
    if (this.jdField_a_of_type_Botf != null) {}
    for (int i = this.jdField_a_of_type_Botf.b();; i = 0)
    {
      int j = i;
      if (this.jdField_a_of_type_Bosf != null) {
        j = i + this.jdField_a_of_type_Bosf.jdField_a_of_type_Int;
      }
      ykq.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
      if (j < 3)
      {
        c();
        return;
      }
      ykw.a("0X80076B7");
      ykw.b("0X80075C3");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) {}
      for (String str = anvx.a(2131703316);; str = anvx.a(2131703352))
      {
        bkzi localbkzi = bkzi.a(this.jdField_a_of_type_Bouo.a(), false);
        localbkzi.a(str);
        localbkzi.a(anvx.a(2131703360), 3);
        localbkzi.d(anvx.a(2131703280));
        localbkzi.a(new botx(this, localbkzi));
        localbkzi.show();
        return;
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Bpfu != null) && (this.jdField_a_of_type_Bpfu.jdField_a_of_type_Boolean);
  }
  
  public int f()
  {
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int;
    int i = j;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      i = j;
      if (j != 9) {
        i = 2;
      }
    }
    return i;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bouo == null) {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
    }
    label92:
    Object localObject2;
    do
    {
      return;
      a(this.jdField_a_of_type_Bouo.a());
      a();
      localObject1 = this.jdField_a_of_type_Bouo.getActivity();
      if ((localObject1 instanceof EditPicActivity)) {}
      switch (((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1))
      {
      default: 
        if (e() != 7) {
          break label211;
        }
        localObject2 = yzz.a();
      }
    } while (localObject2 == null);
    Object localObject1 = ((yzz)localObject2).a();
    Object localObject3 = ((List)localObject1).iterator();
    int i = 0;
    label129:
    if (((Iterator)localObject3).hasNext())
    {
      if (((SlideItemInfo)((Iterator)localObject3).next()).jdField_b_of_type_Int != 1) {
        break label428;
      }
      i += 1;
    }
    label428:
    for (;;)
    {
      break label129;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      bpii.b();
      break label92;
      bpii.c();
      break label92;
      bpii.d();
      break label92;
      label211:
      break;
      int m = ((List)localObject1).size();
      int k = ((yzz)localObject2).a();
      localObject2 = this.jdField_a_of_type_Bouo.getActivity().getIntent();
      int j;
      if (localObject2 != null)
      {
        localObject3 = (EditVideoParams)((Intent)localObject2).getParcelableExtra(EditVideoParams.class.getName());
        if (localObject3 != null) {
          j = ((EditVideoParams)localObject3).a("extra_ablum_type", -1);
        }
      }
      for (;;)
      {
        if (k == 11) {}
        for (k = 0;; k = 1)
        {
          ykv.a("video_edit_slides", "clk_pub", k, 0, new String[] { ykv.a(j) + "", ((List)localObject1).size() + "", m - i + "", i + "" });
          return;
          j = ((Intent)localObject2).getIntExtra("extra_ablum_type", -1);
          break;
        }
        j = -1;
      }
    }
  }
  
  public int g()
  {
    if (b())
    {
      if (a()) {
        return 3;
      }
      return 4;
    }
    if (a()) {
      return 1;
    }
    return 2;
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bouo = null;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return 0;
    case 11: 
      return 2;
    case 4: 
    case 12: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public void h()
  {
    n();
    A();
    this.jdField_c_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_Bouo.getActivity().getIntent();
    this.jdField_a_of_type_AndroidOsBundle = boga.a((Intent)localObject);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).a();
    }
    if ((bnlb.a((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bnlb.c((Intent)localObject)))
    {
      LiuHaiUtils.c(this.jdField_a_of_type_Bouo.getActivity());
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    if (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_c_of_type_Int, 64)) {
      jdField_a_of_type_Bppu = new bppu();
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_Bouo.getActivity().findViewById(2131374124);
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).j();
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).aI_();
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).aH_();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).aL_();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((botu)localIterator.next()).g();
      }
      g();
    }
    if ((jdField_a_of_type_Bppu != null) && (!bddu.b())) {
      jdField_a_of_type_Bppu.a();
    }
    bpjt.a().b();
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void n()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a().i();
    }
    a(9);
    if (yzz.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void p()
  {
    this.jdField_a_of_type_Botf.a().i();
    a(19);
    if (yzz.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  void q()
  {
    if (this.jdField_a_of_type_Botf != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Botf.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.d();
      }
    }
  }
  
  void r()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Bosf;
    ((bosf)localObject).jdField_a_of_type_Int += d();
    if (this.jdField_a_of_type_Int == 7) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Botf.a();
      ((DoodleLayout)localObject).g();
      bowb localbowb = ((DoodleLayout)localObject).a();
      i = j;
      if (localbowb != null)
      {
        i = j;
        if (localbowb.a.a())
        {
          this.jdField_a_of_type_Bouo.a(anvx.a(2131703275), false, 500L);
          this.jdField_a_of_type_Botf.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).m();
          i = 1;
        }
      }
    } while (i != 0);
    s();
  }
  
  public void s()
  {
    this.jdField_a_of_type_Bouo.b();
    Object localObject1 = this.jdField_a_of_type_Botf.a();
    Object localObject2 = ((DoodleLayout)localObject1).a(0);
    Object localObject3 = ((DoodleLayout)localObject1).b(0);
    this.jdField_a_of_type_Bosf.jdField_a_of_type_ArrayOfInt[0] = localObject2[0];
    this.jdField_a_of_type_Bosf.jdField_a_of_type_ArrayOfInt[1] = localObject2[1];
    this.jdField_a_of_type_Bosf.jdField_a_of_type_ArrayOfInt[2] = localObject3[0];
    this.jdField_a_of_type_Bosf.jdField_a_of_type_ArrayOfInt[3] = localObject3[1];
    this.jdField_a_of_type_Bosf.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject1).a().b();
    localObject2 = a();
    if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()))
    {
      ykq.e("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone fail");
      return;
    }
    localObject3 = ((DoodleLayout)localObject1).a();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = zdr.c((Bitmap)localObject2, (Bitmap)localObject3);
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone merged");
    }
    this.jdField_a_of_type_Bosf.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(7);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a().j();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Botf != null) {
      this.jdField_a_of_type_Botf.a().q();
    }
  }
  
  public void v()
  {
    w();
    a(0);
  }
  
  public void w()
  {
    ThreadManager.getUIHandler().post(new EditVideoPartManager.5(this));
  }
  
  public void x()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).m();
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_Botf != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Botf.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.e();
      }
      if (this.jdField_a_of_type_Botf != null) {
        this.jdField_a_of_type_Botf.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botw
 * JD-Core Version:    0.7.0.1
 */