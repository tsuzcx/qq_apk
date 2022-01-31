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
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.6;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
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

public class bmnj
  implements IEventReceiver
{
  public static bnnx a;
  public int a;
  public Intent a;
  public Bundle a;
  public ViewGroup a;
  public RelativeLayout a;
  protected bltr a;
  protected bmim a;
  protected bmip a;
  protected bmis a;
  protected bmiw a;
  public bmjj a;
  protected bmjo a;
  public bmjt a;
  protected bmkb a;
  protected bmko a;
  protected bmku a;
  public bmla a;
  public bmlk a;
  protected bmlm a;
  public bmlp a;
  protected bmmh a;
  protected bmml a;
  public bmmv a;
  protected bmmw a;
  protected bmmx a;
  protected bmnb a;
  protected bmnd a;
  protected bmnf a;
  protected bmnp a;
  protected bmnr a;
  protected bmnu a;
  protected bmnw a;
  protected bmnz a;
  protected bmod a;
  protected bmof a;
  protected bmoh a;
  public bmoj a;
  protected bmoq a;
  public bmor a;
  protected bmos a;
  protected bmou a;
  protected bmyx a;
  protected bncn a;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private SimpleObserver<bnaz> jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver;
  public EditGifImage a;
  public EditPicRawImage a;
  public EditVideoArtFilter a;
  public EditVideoFilter a;
  protected EditVideoGuide a;
  public EditVideoParams a;
  protected HWEditLocalVideoPlayer a;
  protected List<bmnh> a;
  protected Map<Class<? extends bmni>, bmni> a;
  protected final AtomicInteger a;
  protected boolean a;
  public int b;
  protected List<Error> b;
  public boolean b;
  private int c;
  protected boolean c;
  private int d;
  public boolean d;
  public boolean e = true;
  
  public bmnj()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void D()
  {
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      wxe.c("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() + " , isEditCamera:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() != 120) {
        break label304;
      }
      i = 1;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()) {
        break label309;
      }
    }
    label304:
    label309:
    for (int j = 1;; j = 2)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("lens_id", blra.jdField_b_of_type_JavaLangString);
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
      zaj.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", localJSONObject1.toString(), localJSONObject2.toString() });
      return;
      i = 2;
      break;
    }
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_Bmor == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    return (paramInt & paramLong) == paramInt;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) == paramLong2;
  }
  
  private boolean a(bnaz parambnaz)
  {
    if (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath != null);
      if (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData != null)
      {
        wxe.c("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath != null) || (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (parambnaz.jdField_b_of_type_Boolean) || (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0));
    return false;
  }
  
  private void b()
  {
    d(0);
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<bnaz> paramObserver)
  {
    bnaz localbnaz = new bnaz(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbnaz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localbnaz.jdField_b_of_type_JavaLangString == null) {
      localbnaz.jdField_b_of_type_JavaLangString = bnbs.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.a())) || (((EditLocalGifSource)paramEditSource).a.size() <= 0)) {
        break label140;
      }
    }
    label140:
    for (localbnaz.jdField_a_of_type_Bnbf = new bnbf((String)((EditLocalGifSource)paramEditSource).a.get(0));; localbnaz.jdField_a_of_type_Bnbf = new bnbf(paramEditSource.a()))
    {
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((bmnh)paramEditSource.next()).a(0, localbnaz);
      }
    }
    a(localbnaz);
    b(localbnaz);
    wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localbnaz.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bmor.a(alud.a(2131704231), false, 500L);
    Stream.of(localbnaz).map(new bnbc((bmiq)a(bmiq.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new bnbq(bmji.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private void c(bnaz parambnaz)
  {
    if (parambnaz.jdField_a_of_type_Int != 1) {}
    do
    {
      do
      {
        return;
        localObject = bkoh.a(bkoh.jdField_c_of_type_Int);
      } while ((localObject == null) || (!((QQFilterRenderManager)localObject).hasQQFilter(183)));
      localObject = ((QQFilterRenderManager)localObject).getQQFilters(183);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    Object localObject = (PKFilter)((List)localObject).get(0);
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("has_game_pk_filter", Boolean.valueOf(true));
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_video_path", ((PKFilter)localObject).getPKVideoPath());
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_cover_path", ((PKFilter)localObject).getPKCoverPath());
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_result_path", ((PKFilter)localObject).getPKTitleBmgPath());
    wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "put pk encode config at manager : video=" + ((PKFilter)localObject).getPKVideoPath() + ",pkCover=" + ((PKFilter)localObject).getPKCoverPath() + " pk result=" + ((PKFilter)localObject).getPKTitleBmgPath());
  }
  
  private void c(EditVideoParams.EditSource paramEditSource, Observer<bnaz> paramObserver)
  {
    Object localObject = new bnaz(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((bnaz)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azib.r;
    ((bnaz)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = azib.s;
    ((bnaz)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (((bnaz)localObject).jdField_b_of_type_JavaLangString == null) {
      ((bnaz)localObject).jdField_b_of_type_JavaLangString = bnbs.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    ((bnaz)localObject).jdField_a_of_type_Bnbf = new bnbf(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((bmnh)paramEditSource.next()).a(0, (bnaz)localObject);
    }
    a((bnaz)localObject);
    b((bnaz)localObject);
    wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bnaz)localObject).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bmor.a(alud.a(2131704220), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new bnbq(false)).map(new bnbv());
    localObject = this.jdField_a_of_type_Bmor.getActivity();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new bnbg((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Bmlp != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Bmlp.a(0));
      }
      localObject = paramEditSource;
      if (this.jdField_a_of_type_Bmku != null) {
        localObject = paramEditSource.map(this.jdField_a_of_type_Bmku.a(0));
      }
      ((Stream)localObject).map(new bnbr()).map((StreamFunction)uqn.a(bnax.class, new Object[0])).map(new bnbu(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
    }
  }
  
  private void d(int paramInt)
  {
    String str1;
    if (a())
    {
      a("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label218;
      }
      paramInt = 1;
      label51:
      if (paramInt != 0)
      {
        paramInt = b();
        String str2 = a(str1);
        if (!a()) {
          break label223;
        }
        str1 = "2";
        label77:
        b("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_slide_show_video", false)) {
        wxj.a("video_edit", "pub_slides", 0, 0, new String[0]);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() != 104) {
        break label230;
      }
    }
    label218:
    label223:
    label230:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        wxj.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      return;
      a("pub_video", 0, 0, new String[] { "", String.valueOf(a(paramInt)) });
      Bosses.get().postJob(new bmnn(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
      break;
      paramInt = 0;
      break label51;
      str1 = "1";
      break label77;
    }
  }
  
  public void A()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).m();
    }
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_Bmlp != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bmlp.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.e();
      }
      if (this.jdField_a_of_type_Bmlp != null) {
        this.jdField_a_of_type_Bmlp.s();
      }
    }
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_Bmnd != null) {
      this.jdField_a_of_type_Bmnd.b(false);
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)))
    {
      if (this.jdField_a_of_type_Bmml == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_a_of_type_Bmml.a();
    }
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    p();
    if (this.jdField_b_of_type_Boolean)
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((bmnh)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label94;
      }
      i += 1;
    }
    label94:
    for (;;)
    {
      break;
      if (i == 0) {
        wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
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
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a())
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
          throw new RuntimeException(alud.a(2131704282));
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
    Object localObject;
    long l2;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)))
    {
      localObject = (bmnt)a(bmnt.class);
      if (localObject != null)
      {
        l2 = ((bmnt)localObject).a(paramInt);
        wxe.a("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label154;
        }
        l1 = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a())
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
            throw new RuntimeException(alud.a(2131704285));
          }
          break;
        case 1: 
          return l1 / 2L;
        case 2: 
          return l1 * 2L;
        case 4: 
          return l1 * 4L;
        case 3: 
          label154:
          return ((float)l1 / 1.5F);
        }
      }
      l2 = 0L;
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
    if (this.jdField_a_of_type_Bmla != null) {
      return this.jdField_a_of_type_Bmla.a();
    }
    return null;
  }
  
  public View a(long paramLong)
  {
    if (this.jdField_a_of_type_Bmla != null) {
      return this.jdField_a_of_type_Bmla.a(paramLong);
    }
    return null;
  }
  
  public bmla a()
  {
    return this.jdField_a_of_type_Bmla;
  }
  
  public bmlp a()
  {
    return this.jdField_a_of_type_Bmlp;
  }
  
  @Nullable
  public bmni a(Class<? extends bmni> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (bmni)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public bmor a()
  {
    return this.jdField_a_of_type_Bmor;
  }
  
  public bmzn a()
  {
    if (this.jdField_a_of_type_Bmnd != null) {
      return this.jdField_a_of_type_Bmnd.a();
    }
    return null;
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
  
  protected SimpleObserver<bnaz> a()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver != null) {
      return this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver;
    }
    return new bmno(this, SystemClock.uptimeMillis());
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.jdField_a_of_type_JavaLangString.length())) {
      return ":" + paramString.substring(PtvTemplateManager.jdField_a_of_type_JavaLangString.length());
    }
    return "";
  }
  
  public List<bmnh> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public xoe a()
  {
    if (this.jdField_a_of_type_Bmoj != null) {
      return this.jdField_a_of_type_Bmoj.a();
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    p();
    E();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Intent localIntent = this.jdField_a_of_type_Bmor.getActivity().getIntent();
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((blat.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (blat.c(localIntent)))
      {
        if (this.jdField_a_of_type_Bmor.getActivity() != null) {
          break label190;
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
        q();
        this.jdField_b_of_type_Boolean = true;
        localObject = (bmnt)a(bmnt.class);
        if (localObject != null) {
          ((bmnt)localObject).k();
        }
        if ((!blat.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!blat.c(localIntent))) {
          break;
        }
        D();
        return;
        label190:
        if (this.jdField_a_of_type_Bmor.getActivity().getIntent() == null) {
          localObject = "";
        } else if (this.jdField_a_of_type_Bmor.getActivity().getIntent().getBundleExtra("state") == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_Bmor.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
      }
    }
    wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    return;
    Object localObject = a();
    if (((localEditSource instanceof EditRecordVideoSource)) || ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource)))
    {
      a(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        wxj.a("video_edit", "pub_local", 0, 1, new String[0]);
      }
    }
    for (;;)
    {
      D();
      return;
      if (((localEditSource instanceof EditLocalPhotoSource)) || ((localEditSource instanceof EditTakePhotoSource)))
      {
        b();
        azib.y = 5000;
        azib.z = 125;
        azib.x = 0;
        azib.E = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
        {
          azib.J = i;
          c(localEditSource, (Observer)localObject);
          break;
        }
      }
      if ((localEditSource instanceof EditLocalGifSource))
      {
        azib.y = 5000;
        azib.z = 125;
        azib.x = 0;
        azib.E = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
        }
        azib.J = i;
        b(localEditSource, (Observer)localObject);
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    bmnt localbmnt = (bmnt)a(bmnt.class);
    if (localbmnt != null)
    {
      if (!(localbmnt instanceof HWEditLocalVideoPlayer)) {
        break label43;
      }
      ((HWEditLocalVideoPlayer)localbmnt).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
    label43:
    while (!(localbmnt instanceof bmpc)) {
      return;
    }
    ((bmpc)localbmnt).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10004) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    p();
    E();
    if (this.jdField_b_of_type_Boolean)
    {
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_a_of_type_Int != paramInt) || (paramInt == 5) || (paramInt == 39))
    {
      if (this.jdField_a_of_type_Boolean) {
        wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_a_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bmnh)localIterator.next()).a(i, this.jdField_a_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a().a(paramInt, paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a(paramLong);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 14) {
      wxj.a("story_grp", "clk_send", 0, 0, new String[0]);
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
      if (a())
      {
        localObject = "2";
        label81:
        b("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), bfms.a(paramContext) });
        if (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144))
        {
          i = e();
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
            break label224;
          }
        }
      }
      label224:
      for (paramContext = "0";; paramContext = "1")
      {
        b("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        return;
        i = 2;
        break;
        if (!(localObject instanceof EditTakePhotoSource)) {
          break label231;
        }
        if (((EditTakePhotoSource)localObject).jdField_a_of_type_Int == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        localObject = "1";
        break label81;
      }
      label231:
      i = 3;
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bmor.a(-1, paramIntent, 2130772028, 0, true);
      return;
    case 101: 
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
      paramIntent.putExtra("forward_source_from_shoot_quick", true);
      this.jdField_a_of_type_Bmor.getActivity().startActivityForResult(paramIntent, 10004);
      wxj.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 11: 
      paramPublishParam = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramInt = -1;
      if (localIterator.hasNext())
      {
        bmnh localbmnh = (bmnh)localIterator.next();
        if (!(localbmnh instanceof bmik)) {
          break label399;
        }
        paramInt = ((bmik)localbmnh).a();
        paramPublishParam = ((bmik)localbmnh).a();
      }
      break;
    }
    label399:
    for (;;)
    {
      break;
      paramIntent.putExtra("theme_id", paramInt);
      paramIntent.putExtra("theme_name", paramPublishParam);
      paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish", 2, "getPublishIntent");
      }
      this.jdField_a_of_type_Bmor.a(-1, paramIntent, 2130772028, 0, true);
      return;
      this.jdField_a_of_type_Bmor.a(-1, paramIntent, 2130772028, 0, true);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    p();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  public void a(bmor parambmor, EditVideoParams paramEditVideoParams)
  {
    p();
    if ((parambmor == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Bmor != parambmor) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Bmor = parambmor;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((bmnh)paramEditVideoParams.next()).a(parambmor);
      continue;
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { parambmor, paramEditVideoParams });
    }
  }
  
  public void a(bnaz parambnaz)
  {
    Object localObject = parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<bnaz> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1;
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
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
      azib.y = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      azib.z = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      azib.x = 0;
      azib.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azib.J = i;
        i = ((EditRecordVideoSource)localObject1).f;
        j = ((EditRecordVideoSource)localObject1).g;
        str1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject1).e;
        str2 = ((EditRecordVideoSource)localObject1).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) || (!a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144))) {
          break label743;
        }
        localObject1 = null;
        if (this.jdField_a_of_type_Bmml != null) {
          localObject1 = this.jdField_a_of_type_Bmml.a();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((bmpw)((Iterator)localObject1).next()).jdField_c_of_type_Int));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
      azib.y = 5000;
      azib.z = 125;
      azib.x = 0;
      azib.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azib.J = i;
        j = ((EditLocalVideoSource)localObject1).a();
        k = ((EditLocalVideoSource)localObject1).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
      azib.y = 5000;
      azib.z = 125;
      azib.x = 0;
      azib.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azib.J = i;
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
    throw new IllegalArgumentException(alud.a(2131704226) + paramEditSource);
    wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    label743:
    localArrayList.add(Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
    this.jdField_b_of_type_JavaUtilList.clear();
    int m = 0;
    int n;
    Object localObject2;
    if (m < localArrayList.size())
    {
      n = ((Integer)localArrayList.get(m)).intValue();
      d(n);
      localObject1 = new bnaz(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str3;
      ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (m * 1000 + l);
      ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azib.r;
      if (azki.f())
      {
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (azki.b() * 1000);
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(azki.f()));
      }
      ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = azib.s;
      ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str4;
      ((bnaz)localObject1).jdField_b_of_type_JavaLangString = bnbs.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
      localObject2 = this.jdField_a_of_type_Bmor.getActivity();
      boolean bool2;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() == 5))
      {
        bool2 = true;
        ((bnaz)localObject1).jdField_a_of_type_Bnbh = new bnbh((Activity)localObject2, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
          break label1147;
        }
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(k));
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
        c((bnaz)localObject1);
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((bmnh)((Iterator)localObject2).next()).a(n, (bnaz)localObject1);
        }
        bool2 = false;
        break;
        label1147:
        ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      localObject2 = ((bnaz)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty(((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
          ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject2);
        }
      }
      else
      {
        label1211:
        a((bnaz)localObject1);
        b((bnaz)localObject1);
        wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bnaz)localObject1).jdField_b_of_type_JavaLangString });
        this.jdField_a_of_type_Bmor.a(alud.a(2131704169), false, 500L);
        localObject2 = Stream.of(localObject1).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
        if (((bnaz)localObject1).jdField_a_of_type_Int != 1) {
          break label1684;
        }
        if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
          break label1659;
        }
        localObject1 = new bnbm(null, (bmnt)a(bmnt.class), n);
        label1339:
        localObject2 = ((Stream)localObject2).map((StreamFunction)localObject1);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bmlp != null)
        {
          localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bmlp.a(n));
          if ((this.jdField_a_of_type_Bmlp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a()) && (c() == 0L)) {
            break label1813;
          }
          localObject1 = ((Stream)localObject1).map(new bnbb(this.jdField_a_of_type_Bmlp, (bmir)a(bmir.class), n));
        }
      }
    }
    label1684:
    label1813:
    for (;;)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Bmku != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bmku.a(n));
      }
      localObject1 = localObject2;
      Object localObject3;
      if (this.jdField_a_of_type_Bmmw != null)
      {
        localObject3 = this.jdField_a_of_type_Bmmw.a(n);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Stream)localObject2).map((StreamFunction)localObject3);
        }
      }
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {}
      for (localObject1 = ((Stream)localObject1).map(new bnbn());; localObject1 = ((Stream)localObject1).map(new bnbr()).map((StreamFunction)uqn.a(bnax.class, new Object[0])))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", blat.b(this.jdField_a_of_type_Bmor.getActivity().getIntent()));
        }
        ((Stream)localObject1).map(new bnbu(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        localObject3 = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((bnaz)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
        localPublishVideoEntry.videoDoodleDescription += (String)localObject2;
        break label1211;
        label1659:
        localObject1 = new bnbi(null, (bmnt)a(bmnt.class), n);
        break label1339;
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
        {
          localObject1 = new bnbm(null, (bmnt)a(bmnt.class), 0);
          break label1339;
        }
        localObject1 = new bnbi();
        break label1339;
      }
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((bmnh)paramEditSource.next()).aV_();
      }
      break;
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    wxe.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    long l = paramEditVideoParams.jdField_a_of_type_Long;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label188:
    label612:
    int i;
    if (paramEditVideoParams.jdField_a_of_type_Int == 11)
    {
      localObject = new bmik(this, l);
      this.jdField_a_of_type_Bmla = ((bmla)localObject);
      localArrayList.add(localObject);
      if ((!blat.a(this.jdField_a_of_type_Bmor.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!blat.c(this.jdField_a_of_type_Bmor.getActivity().getIntent())))
      {
        localObject = new bmjt(this);
        this.jdField_a_of_type_Bmjt = ((bmjt)localObject);
        localArrayList.add(localObject);
      }
      localObject = new bmip(this);
      this.jdField_a_of_type_Bmip = ((bmip)localObject);
      localArrayList.add(localObject);
      if (!paramEditVideoParams.a()) {
        break label1690;
      }
      localObject = new EditPicRawImage(this, l);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
      if (a(l, 2048))
      {
        localObject = new EditVideoGuide(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 2))
      {
        if (paramEditVideoParams.jdField_a_of_type_Int != 14) {
          break label1823;
        }
        localArrayList.add(new zby(this));
      }
      label257:
      if ((paramEditVideoParams.b()) && (blur.jdField_a_of_type_Boolean))
      {
        localObject = new bmkb(this);
        this.jdField_a_of_type_Bmkb = ((bmkb)localObject);
        localArrayList.add(localObject);
        if (a(l, 16777216)) {
          this.jdField_a_of_type_Bmkb.jdField_a_of_type_Boolean = true;
        }
      }
      if (a(l, 1024))
      {
        localObject = new bmku(this);
        this.jdField_a_of_type_Bmku = ((bmku)localObject);
        localArrayList.add(localObject);
      }
      if ((a(l, 536870912)) || (a(l, 1)) || (a(l, 8)))
      {
        localObject = new bmlp(this, l);
        this.jdField_a_of_type_Bmlp = ((bmlp)localObject);
        localArrayList.add(localObject);
        localObject = new bmnu(this);
        this.jdField_a_of_type_Bmnu = ((bmnu)localObject);
        localArrayList.add(localObject);
        localObject = new bmnw(this);
        this.jdField_a_of_type_Bmnw = ((bmnw)localObject);
        localArrayList.add(localObject);
        if ((a(l, 274877906944L)) && (paramEditVideoParams.jdField_a_of_type_Int == 1) && (((DynamicTextConfigManager)blqr.a(7)).c()))
        {
          localObject = new bmlm(this, paramEditVideoParams.e);
          this.jdField_a_of_type_Bmlm = ((bmlm)localObject);
          localArrayList.add(localObject);
        }
      }
      if (a(l, 256))
      {
        if ((paramEditVideoParams.jdField_a_of_type_Int != 1) && (paramEditVideoParams.jdField_a_of_type_Int != 2) && (paramEditVideoParams.jdField_a_of_type_Int != 11) && (paramEditVideoParams.jdField_a_of_type_Int != 12) && (paramEditVideoParams.jdField_a_of_type_Int != 3) && (paramEditVideoParams.jdField_a_of_type_Int != 13)) {
          break label1853;
        }
        localObject = new bmog(this, a(l, 2097152));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 512))
      {
        localObject = new bmmx(this);
        this.jdField_a_of_type_Bmmx = ((bmmx)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.a()) || (paramEditVideoParams.e())) && (a(l, 128)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(l, 4)))
      {
        localObject = new bmjj(this);
        this.jdField_a_of_type_Bmjj = ((bmjj)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 8192))
      {
        if (!blat.c(this.jdField_a_of_type_Bmor.getActivity().getIntent())) {
          break label1882;
        }
        localObject = new bmjo(this);
        this.jdField_a_of_type_Bmjo = ((bmjo)localObject);
        localArrayList.add(localObject);
      }
      label793:
      if (a(l, 32768))
      {
        localObject = new bmis(this);
        this.jdField_a_of_type_Bmis = ((bmis)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 131072))
      {
        localObject = new bmnp(this);
        this.jdField_a_of_type_Bmnp = ((bmnp)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 1048576))
      {
        localObject = new bmof(this);
        this.jdField_a_of_type_Bmof = ((bmof)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (a(l, 262144)))
      {
        localObject = new bmml(this);
        this.jdField_a_of_type_Bmml = ((bmml)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 8388608))
      {
        localObject = new bmod(this);
        this.jdField_a_of_type_Bmod = ((bmod)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 67108864))
      {
        localObject = new bmoj(this);
        this.jdField_a_of_type_Bmoj = ((bmoj)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 268435456))
      {
        localObject = new bmou(this);
        this.jdField_a_of_type_Bmou = ((bmou)localObject);
        localArrayList.add(localObject);
        localObject = new bmyx(this);
        this.jdField_a_of_type_Bmyx = ((bmyx)localObject);
        localArrayList.add(localObject);
        localObject = new bmmv(this, this.jdField_a_of_type_Bmou, this.jdField_a_of_type_Bmyx);
        this.jdField_a_of_type_Bmmv = ((bmmv)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 134217728))
      {
        localObject = new bmnf(this);
        this.jdField_a_of_type_Bmnf = ((bmnf)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 16))
      {
        localObject = new bmoq(this);
        this.jdField_a_of_type_Bmoq = ((bmoq)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 33554432))
      {
        localObject = new bmnd(this);
        this.jdField_a_of_type_Bmnd = ((bmnd)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 4294967296L))
      {
        localObject = new bmlk(this, l);
        this.jdField_a_of_type_Bmlk = ((bmlk)localObject);
        localArrayList.add(localObject);
      }
      if ((blat.c.a(paramEditVideoParams.f)) && ((paramEditVideoParams.c()) || (paramEditVideoParams.a()) || (paramEditVideoParams.b())))
      {
        localObject = new bncn(this);
        this.jdField_a_of_type_Bncn = ((bncn)localObject);
        localArrayList.add(localObject);
      }
      if (a(paramEditVideoParams.jdField_a_of_type_Long, 8589934592L))
      {
        localObject = new bmmh(this, l);
        this.jdField_a_of_type_Bmmh = ((bmmh)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))) {
        localArrayList.add(new bmki(this));
      }
      if (a(paramEditVideoParams.jdField_a_of_type_Long, 34359738368L))
      {
        localObject = new bmnb(this);
        this.jdField_a_of_type_Bmnb = ((bmnb)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 137438953472L))
      {
        localObject = new bmko(this);
        this.jdField_a_of_type_Bmko = ((bmko)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 16384))
      {
        i = paramEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
        if (i != -1) {
          break label1965;
        }
        wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", " curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
      }
    }
    for (;;)
    {
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      wxe.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        wxe.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((bmnh)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 12)
      {
        localObject = new oiu(this, l);
        this.jdField_a_of_type_Bmla = ((bmla)localObject);
        localArrayList.add(localObject);
        break;
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 14)
      {
        localObject = new bmoh(this);
        this.jdField_a_of_type_Bmoh = ((bmoh)localObject);
        localArrayList.add(localObject);
        break;
      }
      localObject = new bmla(this, l);
      this.jdField_a_of_type_Bmla = ((bmla)localObject);
      localArrayList.add(localObject);
      break;
      label1690:
      if (paramEditVideoParams.e())
      {
        localObject = new EditGifImage(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage = ((EditGifImage)localObject);
        localArrayList.add(localObject);
        break label188;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.d())
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label188;
        }
        localArrayList.add(new bmpc(this));
        break label188;
      }
      if (paramEditVideoParams.i())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break label188;
      }
      localObject = new bmnr(this);
      this.jdField_a_of_type_Bmnr = ((bmnr)localObject);
      localArrayList.add(localObject);
      break label188;
      label1823:
      localObject = new bltr(this, false);
      this.jdField_a_of_type_Bltr = ((bltr)localObject);
      localArrayList.add(localObject);
      break label257;
      label1853:
      localObject = new EditVideoFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break label612;
      label1882:
      if (!blat.a(this.jdField_a_of_type_Bmor.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localObject = new bmnz(this);
        this.jdField_a_of_type_Bmnz = ((bmnz)localObject);
        localArrayList.add(localObject);
        break label793;
      }
      localObject = new bmjo(this);
      this.jdField_a_of_type_Bmjo = ((bmjo)localObject);
      localArrayList.add(localObject);
      break label793;
      label1965:
      this.jdField_a_of_type_Bmim = new bmim(this, i, true);
      localArrayList.add(this.jdField_a_of_type_Bmim);
    }
  }
  
  public void a(Class<? extends bmni> paramClass, bmni parambmni)
  {
    p();
    E();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(parambmni)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + parambmni.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    bmni localbmni = (bmni)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbmni == null) {
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), parambmni);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, parambmni);
      return;
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localbmni, parambmni });
    }
  }
  
  public void a(Error paramError)
  {
    wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).a(paramError);
    }
    wxj.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bmor.b();
      QQToast.a(this.jdField_a_of_type_Bmor.a(), alud.a(2131704151), 0).a();
      paramError = (bmnt)a(bmnt.class);
    } while (paramError == null);
    paramError.l();
  }
  
  public void a(String paramString)
  {
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onDlnaVideoSaved videoPath " + paramString);
    if (paramString != null)
    {
      bjea localbjea = bjea.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      bjdt.e(this.jdField_a_of_type_Bmor.getActivity(), localbjea, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      Bosses.get().postJob(new bmnl(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<bmnh> paramList) {}
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    bmnt localbmnt = (bmnt)a(bmnt.class);
    if (localbmnt != null)
    {
      if (!(localbmnt instanceof HWEditLocalVideoPlayer)) {
        break label41;
      }
      ((HWEditLocalVideoPlayer)localbmnt).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    label41:
    while (!(localbmnt instanceof bmpc)) {
      return;
    }
    ((bmpc)localbmnt).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    p();
    E();
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
  
  public long b()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    if ((localObject instanceof EditRecordVideoSource)) {
      return ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditLocalGifSource))) {
      return 5000L;
    }
    long l;
    if ((localObject instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)localObject;
      l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      if (l == 0L) {
        return ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
    }
    else
    {
      if ((localObject instanceof EditTakeVideoSource)) {
        return ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      throw new RuntimeException(alud.a(2131704194));
    }
    return l;
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.jdField_d_of_type_Int);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_a_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(bnaz parambnaz)
  {
    long l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              wxe.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
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
    Bosses.get().postJob(new bmnm(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public boolean b()
  {
    p();
    E();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d();
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.jdField_b_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
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
  
  public long c()
  {
    if (this.jdField_a_of_type_Bmlk != null) {
      return this.jdField_a_of_type_Bmlk.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  protected void c()
  {
    bmnt localbmnt = (bmnt)a(bmnt.class);
    if (localbmnt != null) {
      localbmnt.k();
    }
    this.jdField_a_of_type_Bmor.a(0, null, 2130772028, 0);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1)
    {
      int i = g();
      wxj.b("time_edit", 1, (int)(System.currentTimeMillis() - d()), new String[] { wxj.b(i), "1", "", "" });
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bmla != null) {
      this.jdField_a_of_type_Bmla.b(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).i_(paramBoolean);
    }
  }
  
  public boolean c()
  {
    p();
    E();
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (!b())) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
  }
  
  public int d()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bmlp != null) {
      i = this.jdField_a_of_type_Bmlp.a(a());
    }
    int j = i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public long d()
  {
    if ((this.jdField_a_of_type_Bmor instanceof EditVideoActivity)) {
      return ((EditVideoActivity)this.jdField_a_of_type_Bmor).jdField_a_of_type_Long;
    }
    if ((this.jdField_a_of_type_Bmor instanceof EditPicActivity)) {
      return ((EditPicActivity)this.jdField_a_of_type_Bmor).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public void d()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_Bmlp != null)
    {
      Object localObject = this.jdField_a_of_type_Bmlp.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).j();
      }
      localObject = this.jdField_a_of_type_Bmlp.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((bmqs)localObject).a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Bmor.a(alud.a(2131704118), false, 500L);
          this.jdField_a_of_type_Bmlp.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Bmlp.a().o();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_Bmlp.a().a();
      j = i;
      if (localObject != null)
      {
        ((bmqw)localObject).i();
        j = i;
      }
    }
    if (j == 0) {
      f();
    }
  }
  
  void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    for (;;)
    {
      try
      {
        if (!this.jdField_d_of_type_Boolean) {
          continue;
        }
        i = 3;
        VideoSourceHelper.nativeSetPlayStepFrameCount(i);
        if (!this.jdField_d_of_type_Boolean) {
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
        VideoSourceHelper.nativeSetPlayAFMute(this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Bltr == null) {
        continue;
      }
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Bmnd != null) && (this.jdField_a_of_type_Bmnd.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmnw });
      return true;
    }
    if ((this.jdField_a_of_type_Bmos != null) && (this.jdField_a_of_type_Bmos.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmnw });
      return true;
    }
    if ((this.jdField_a_of_type_Bmnw != null) && (this.jdField_a_of_type_Bmnw.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmnw });
      return true;
    }
    if ((this.jdField_a_of_type_Bmnu != null) && (this.jdField_a_of_type_Bmnu.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmnu });
      return true;
    }
    if ((this.jdField_a_of_type_Bmoj != null) && (this.jdField_a_of_type_Bmoj.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmoj });
      return true;
    }
    if ((this.jdField_a_of_type_Bmou != null) && (this.jdField_a_of_type_Bmou.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmou });
      return true;
    }
    if ((this.jdField_a_of_type_Bmyx != null) && (this.jdField_a_of_type_Bmyx.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmyx });
      return true;
    }
    if ((this.jdField_a_of_type_Bmmw != null) && (this.jdField_a_of_type_Bmmw.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmmw });
      return true;
    }
    if ((this.jdField_a_of_type_Bltr != null) && (this.jdField_a_of_type_Bltr.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bltr });
      return true;
    }
    if ((this.jdField_a_of_type_Bmmx != null) && (this.jdField_a_of_type_Bmmx.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmmx });
      return true;
    }
    if ((this.jdField_a_of_type_Bmlp != null) && (this.jdField_a_of_type_Bmlp.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmlp });
      return true;
    }
    if ((this.jdField_a_of_type_Bmjj != null) && (this.jdField_a_of_type_Bmjj.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjj });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_a_of_type_Bmis != null) && (this.jdField_a_of_type_Bmis.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmis });
      return true;
    }
    if ((this.jdField_a_of_type_Bmlk != null) && (this.jdField_a_of_type_Bmlk.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmlk });
      return true;
    }
    if ((this.jdField_a_of_type_Bmla != null) && (this.jdField_a_of_type_Bmla.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmla });
      return true;
    }
    if ((this.jdField_a_of_type_Bmoh != null) && (this.jdField_a_of_type_Bmoh.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmoh });
      return true;
    }
    if ((this.jdField_a_of_type_Bncn != null) && (this.jdField_a_of_type_Bncn.a()))
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bncn });
      return true;
    }
    e();
    return true;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Bmml != null)
    {
      List localList = this.jdField_a_of_type_Bmml.a();
      if (localList != null) {
        return localList.size();
      }
    }
    return 1;
  }
  
  public void e()
  {
    p();
    E();
    bliu.a().d();
    String str;
    if (a())
    {
      str = "2";
      a("clk_left", 0, 0, new String[] { str });
      wxk.a("0X80076B6");
      wxk.b("0X80075C2");
      wxk.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007823");
      if (this.jdField_a_of_type_Bmlp == null) {
        break label349;
      }
    }
    label312:
    label349:
    for (int j = this.jdField_a_of_type_Bmlp.b();; j = 0)
    {
      int i = j;
      if (this.jdField_a_of_type_Bmmx != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bmmx.a())) {
          i = j + 1;
        }
      }
      j = i;
      if (this.jdField_a_of_type_Bmjj != null) {
        j = i + this.jdField_a_of_type_Bmjj.jdField_a_of_type_Int;
      }
      i = j;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
          i = j + 4;
        }
      }
      wxe.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(i));
      if (i < 3)
      {
        c();
        return;
        str = "1";
        break;
      }
      if (a())
      {
        str = "2";
        a("clk_left_float", 0, 0, new String[] { str });
        wxk.a("0X80076B7");
        wxk.b("0X80075C3");
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) {
          break label312;
        }
        str = alud.a(2131704229);
      }
      for (;;)
      {
        bhuf localbhuf = bhuf.a(this.jdField_a_of_type_Bmor.a(), false);
        localbhuf.a(str);
        localbhuf.a(alud.a(2131704273), 3);
        localbhuf.d(alud.a(2131704191));
        localbhuf.a(new bmnk(this, localbhuf));
        localbhuf.show();
        return;
        str = "1";
        break;
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_d_of_type_Boolean)) {
          str = alud.a(2131704289);
        } else {
          str = alud.a(2131704265);
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmla != null) {
      this.jdField_a_of_type_Bmla.b(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Bncn != null) && (this.jdField_a_of_type_Bncn.jdField_a_of_type_Boolean);
  }
  
  public int f()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bmor == null) {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
    }
    label92:
    Object localObject2;
    do
    {
      return;
      a(this.jdField_a_of_type_Bmor.a());
      a();
      localObject1 = this.jdField_a_of_type_Bmor.getActivity();
      if ((localObject1 instanceof EditPicActivity)) {}
      switch (((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1))
      {
      default: 
        if (f() != 7) {
          break label223;
        }
        bkoa.a(this.jdField_a_of_type_Bmor.a());
        localObject2 = xna.a();
      }
    } while (localObject2 == null);
    Object localObject1 = ((xna)localObject2).a();
    Object localObject3 = ((List)localObject1).iterator();
    int i = 0;
    label141:
    if (((Iterator)localObject3).hasNext())
    {
      if (((SlideItemInfo)((Iterator)localObject3).next()).jdField_b_of_type_Int != 1) {
        break label436;
      }
      i += 1;
    }
    label436:
    for (;;)
    {
      break label141;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      bnfq.f();
      break label92;
      bnfq.g();
      break label92;
      bnfq.h();
      break label92;
      label223:
      break;
      int m = ((List)localObject1).size();
      int k = ((xna)localObject2).a();
      localObject2 = this.jdField_a_of_type_Bmor.getActivity().getIntent();
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
          wxj.a("video_edit_slides", "clk_pub", k, 0, new String[] { wxj.a(j) + "", ((List)localObject1).size() + "", m - i + "", i + "" });
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
  
  public void g()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.jdField_a_of_type_Int == 2)) {
      a(10);
    }
  }
  
  public int h()
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
  
  public void h()
  {
    p();
    E();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).ai_();
    }
  }
  
  public int i()
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
    case 2: 
      return 5;
    }
    return 1;
  }
  
  public void i()
  {
    this.jdField_a_of_type_Bmor = null;
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void j()
  {
    p();
    E();
    this.jdField_c_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_Bmor.getActivity().getIntent();
    this.jdField_a_of_type_AndroidOsBundle = blqi.a((Intent)localObject);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).a();
    }
    if ((blat.a((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (blat.c((Intent)localObject)))
    {
      bnle.c(this.jdField_a_of_type_Bmor.getActivity());
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    if (a())
    {
      localObject = "2";
      a("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bmof != null) {
        wxj.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      if (!a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 64)) {
        break label236;
      }
      jdField_a_of_type_Bnnx = new bnnx();
    }
    label236:
    do
    {
      return;
      localObject = "1";
      break;
      localObject = this.jdField_a_of_type_Bmor.getActivity().findViewById(2131373313);
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).z_();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).f();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).ba_();
    }
  }
  
  public void n()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnh)localIterator.next()).aW_();
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bmnh)localIterator.next()).g();
      }
      i();
    }
    if ((jdField_a_of_type_Bnnx != null) && (!azkj.c())) {
      jdField_a_of_type_Bnnx.a();
    }
    bnhb.a().b();
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void p()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void q()
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a().k();
    }
    a(19);
    if (xna.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_Bmlp.a().k();
    a(47);
    if (xna.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  void s()
  {
    if (this.jdField_a_of_type_Bmlp != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bmlp.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.d();
      }
    }
  }
  
  void t()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Bmjj;
    ((bmjj)localObject).jdField_a_of_type_Int += d();
    if (this.jdField_a_of_type_Int == 11) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Bmlp.a();
      ((DoodleLayout)localObject).i();
      bmqs localbmqs = ((DoodleLayout)localObject).a();
      i = j;
      if (localbmqs != null)
      {
        i = j;
        if (localbmqs.a.a())
        {
          this.jdField_a_of_type_Bmor.a(alud.a(2131704186), false, 500L);
          this.jdField_a_of_type_Bmlp.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).o();
          i = 1;
        }
      }
    } while (i != 0);
    u();
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bmor.b();
    Object localObject3 = this.jdField_a_of_type_Bmlp.a();
    Object localObject1 = ((DoodleLayout)localObject3).a(0);
    Object localObject2 = ((DoodleLayout)localObject3).b(0);
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_ArrayOfInt[0] = localObject1[0];
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_ArrayOfInt[1] = localObject1[1];
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_ArrayOfInt[2] = localObject2[0];
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_ArrayOfInt[3] = localObject2[1];
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject3).a().b();
    localObject2 = a();
    if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
      return;
    }
    localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 1)
    {
      localObject3 = ((DoodleLayout)localObject3).a();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        long l = SystemClock.uptimeMillis();
        localObject1 = xqw.c((Bitmap)localObject2, (Bitmap)localObject3);
        wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
      }
    }
    this.jdField_a_of_type_Bmjj.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(11);
  }
  
  void v()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    a(0);
    a(12);
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a().l();
    }
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_Bmlp != null) {
      this.jdField_a_of_type_Bmlp.a().s();
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.d();
    }
    z();
    a(0);
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new EditVideoPartManager.6(this), 5, null, true);
    }
    ThreadManager.getUIHandler().post(new EditVideoPartManager.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnj
 * JD-Core Version:    0.7.0.1
 */