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

public class bmix
  implements IEventReceiver
{
  public static bnjl a;
  public int a;
  public Intent a;
  public Bundle a;
  public ViewGroup a;
  public RelativeLayout a;
  protected blpf a;
  protected bmea a;
  protected bmed a;
  protected bmeg a;
  protected bmek a;
  public bmex a;
  protected bmfc a;
  public bmfh a;
  protected bmfp a;
  protected bmgc a;
  protected bmgi a;
  public bmgo a;
  public bmgy a;
  protected bmha a;
  public bmhd a;
  protected bmhv a;
  protected bmhz a;
  public bmij a;
  protected bmik a;
  protected bmil a;
  protected bmip a;
  protected bmir a;
  protected bmit a;
  protected bmjd a;
  protected bmjf a;
  protected bmji a;
  protected bmjk a;
  protected bmjn a;
  protected bmjr a;
  protected bmjt a;
  protected bmjv a;
  public bmjx a;
  protected bmke a;
  public bmkf a;
  protected bmkg a;
  protected bmki a;
  protected bmul a;
  protected bmyb a;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private SimpleObserver<bmwn> jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver;
  public EditGifImage a;
  public EditPicRawImage a;
  public EditVideoArtFilter a;
  public EditVideoFilter a;
  protected EditVideoGuide a;
  public EditVideoParams a;
  protected HWEditLocalVideoPlayer a;
  protected List<bmiv> a;
  protected Map<Class<? extends bmiw>, bmiw> a;
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
  
  public bmix()
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
      wsv.c("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() + " , isEditCamera:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
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
        localJSONObject1.put("lens_id", blmo.jdField_b_of_type_JavaLangString);
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
      yvu.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", localJSONObject1.toString(), localJSONObject2.toString() });
      return;
      i = 2;
      break;
    }
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_Bmkf == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
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
  
  private boolean a(bmwn parambmwn)
  {
    if (parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath != null);
      if (parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData != null)
      {
        wsv.c("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath != null) || (parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (parambmwn.jdField_b_of_type_Boolean) || (parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0));
    return false;
  }
  
  private void b()
  {
    d(0);
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<bmwn> paramObserver)
  {
    bmwn localbmwn = new bmwn(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbmwn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localbmwn.jdField_b_of_type_JavaLangString == null) {
      localbmwn.jdField_b_of_type_JavaLangString = bmxg.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.a())) || (((EditLocalGifSource)paramEditSource).a.size() <= 0)) {
        break label140;
      }
    }
    label140:
    for (localbmwn.jdField_a_of_type_Bmwt = new bmwt((String)((EditLocalGifSource)paramEditSource).a.get(0));; localbmwn.jdField_a_of_type_Bmwt = new bmwt(paramEditSource.a()))
    {
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((bmiv)paramEditSource.next()).a(0, localbmwn);
      }
    }
    a(localbmwn);
    b(localbmwn);
    wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localbmwn.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bmkf.a(alpo.a(2131704219), false, 500L);
    Stream.of(localbmwn).map(new bmwq((bmee)a(bmee.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new bmxe(bmew.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private void c(bmwn parambmwn)
  {
    if (parambmwn.jdField_a_of_type_Int != 1) {}
    do
    {
      do
      {
        return;
        localObject = bkka.a(bkka.jdField_c_of_type_Int);
      } while ((localObject == null) || (!((QQFilterRenderManager)localObject).hasQQFilter(183)));
      localObject = ((QQFilterRenderManager)localObject).getQQFilters(183);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    Object localObject = (PKFilter)((List)localObject).get(0);
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("has_game_pk_filter", Boolean.valueOf(true));
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_video_path", ((PKFilter)localObject).getPKVideoPath());
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_cover_path", ((PKFilter)localObject).getPKCoverPath());
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("game_pk_result_path", ((PKFilter)localObject).getPKTitleBmgPath());
    wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "put pk encode config at manager : video=" + ((PKFilter)localObject).getPKVideoPath() + ",pkCover=" + ((PKFilter)localObject).getPKCoverPath() + " pk result=" + ((PKFilter)localObject).getPKTitleBmgPath());
  }
  
  private void c(EditVideoParams.EditSource paramEditSource, Observer<bmwn> paramObserver)
  {
    Object localObject = new bmwn(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((bmwn)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azds.r;
    ((bmwn)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = azds.s;
    ((bmwn)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (((bmwn)localObject).jdField_b_of_type_JavaLangString == null) {
      ((bmwn)localObject).jdField_b_of_type_JavaLangString = bmxg.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    ((bmwn)localObject).jdField_a_of_type_Bmwt = new bmwt(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((bmiv)paramEditSource.next()).a(0, (bmwn)localObject);
    }
    a((bmwn)localObject);
    b((bmwn)localObject);
    wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bmwn)localObject).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bmkf.a(alpo.a(2131704208), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new bmxe(false)).map(new bmxj());
    localObject = this.jdField_a_of_type_Bmkf.getActivity();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new bmwu((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Bmhd != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Bmhd.a(0));
      }
      localObject = paramEditSource;
      if (this.jdField_a_of_type_Bmgi != null) {
        localObject = paramEditSource.map(this.jdField_a_of_type_Bmgi.a(0));
      }
      ((Stream)localObject).map(new bmxf()).map((StreamFunction)ume.a(bmwl.class, new Object[0])).map(new bmxi(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
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
        wta.a("video_edit", "pub_slides", 0, 0, new String[0]);
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
        wta.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      return;
      a("pub_video", 0, 0, new String[] { "", String.valueOf(a(paramInt)) });
      Bosses.get().postJob(new bmjb(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
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
      ((bmiv)localIterator.next()).m();
    }
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_Bmhd != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bmhd.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.e();
      }
      if (this.jdField_a_of_type_Bmhd != null) {
        this.jdField_a_of_type_Bmhd.s();
      }
    }
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_Bmir != null) {
      this.jdField_a_of_type_Bmir.b(false);
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)))
    {
      if (this.jdField_a_of_type_Bmhz == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_a_of_type_Bmhz.a();
    }
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    p();
    if (this.jdField_b_of_type_Boolean)
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((bmiv)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label94;
      }
      i += 1;
    }
    label94:
    for (;;)
    {
      break;
      if (i == 0) {
        wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
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
          throw new RuntimeException(alpo.a(2131704270));
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
      localObject = (bmjh)a(bmjh.class);
      if (localObject != null)
      {
        l2 = ((bmjh)localObject).a(paramInt);
        wsv.a("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
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
            throw new RuntimeException(alpo.a(2131704273));
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
    if (this.jdField_a_of_type_Bmgo != null) {
      return this.jdField_a_of_type_Bmgo.a();
    }
    return null;
  }
  
  public View a(long paramLong)
  {
    if (this.jdField_a_of_type_Bmgo != null) {
      return this.jdField_a_of_type_Bmgo.a(paramLong);
    }
    return null;
  }
  
  public bmgo a()
  {
    return this.jdField_a_of_type_Bmgo;
  }
  
  public bmhd a()
  {
    return this.jdField_a_of_type_Bmhd;
  }
  
  @Nullable
  public bmiw a(Class<? extends bmiw> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (bmiw)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public bmkf a()
  {
    return this.jdField_a_of_type_Bmkf;
  }
  
  public bmvb a()
  {
    if (this.jdField_a_of_type_Bmir != null) {
      return this.jdField_a_of_type_Bmir.a();
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
  
  protected SimpleObserver<bmwn> a()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver != null) {
      return this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver;
    }
    return new bmjc(this, SystemClock.uptimeMillis());
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.jdField_a_of_type_JavaLangString.length())) {
      return ":" + paramString.substring(PtvTemplateManager.jdField_a_of_type_JavaLangString.length());
    }
    return "";
  }
  
  public List<bmiv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public xjv a()
  {
    if (this.jdField_a_of_type_Bmjx != null) {
      return this.jdField_a_of_type_Bmjx.a();
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    p();
    E();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Intent localIntent = this.jdField_a_of_type_Bmkf.getActivity().getIntent();
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((bkwm.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bkwm.c(localIntent)))
      {
        if (this.jdField_a_of_type_Bmkf.getActivity() != null) {
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
        localObject = (bmjh)a(bmjh.class);
        if (localObject != null) {
          ((bmjh)localObject).k();
        }
        if ((!bkwm.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!bkwm.c(localIntent))) {
          break;
        }
        D();
        return;
        label190:
        if (this.jdField_a_of_type_Bmkf.getActivity().getIntent() == null) {
          localObject = "";
        } else if (this.jdField_a_of_type_Bmkf.getActivity().getIntent().getBundleExtra("state") == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_Bmkf.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
      }
    }
    wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    return;
    Object localObject = a();
    if (((localEditSource instanceof EditRecordVideoSource)) || ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource)))
    {
      a(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        wta.a("video_edit", "pub_local", 0, 1, new String[0]);
      }
    }
    for (;;)
    {
      D();
      return;
      if (((localEditSource instanceof EditLocalPhotoSource)) || ((localEditSource instanceof EditTakePhotoSource)))
      {
        b();
        azds.y = 5000;
        azds.z = 125;
        azds.x = 0;
        azds.E = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
        {
          azds.J = i;
          c(localEditSource, (Observer)localObject);
          break;
        }
      }
      if ((localEditSource instanceof EditLocalGifSource))
      {
        azds.y = 5000;
        azds.z = 125;
        azds.x = 0;
        azds.E = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
        }
        azds.J = i;
        b(localEditSource, (Observer)localObject);
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    bmjh localbmjh = (bmjh)a(bmjh.class);
    if (localbmjh != null)
    {
      if (!(localbmjh instanceof HWEditLocalVideoPlayer)) {
        break label43;
      }
      ((HWEditLocalVideoPlayer)localbmjh).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
    label43:
    while (!(localbmjh instanceof bmkq)) {
      return;
    }
    ((bmkq)localbmjh).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
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
      ((bmiv)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    p();
    E();
    if (this.jdField_b_of_type_Boolean)
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_a_of_type_Int != paramInt) || (paramInt == 5) || (paramInt == 39))
    {
      if (this.jdField_a_of_type_Boolean) {
        wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_a_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bmiv)localIterator.next()).a(i, this.jdField_a_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a().a(paramInt, paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a(paramLong);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 14) {
      wta.a("story_grp", "clk_send", 0, 0, new String[0]);
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
        b("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), bfij.a(paramContext) });
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
      this.jdField_a_of_type_Bmkf.a(-1, paramIntent, 2130772028, 0, true);
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
      this.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(paramIntent, 10004);
      wta.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 11: 
      paramPublishParam = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramInt = -1;
      if (localIterator.hasNext())
      {
        bmiv localbmiv = (bmiv)localIterator.next();
        if (!(localbmiv instanceof bmdy)) {
          break label399;
        }
        paramInt = ((bmdy)localbmiv).a();
        paramPublishParam = ((bmdy)localbmiv).a();
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
      this.jdField_a_of_type_Bmkf.a(-1, paramIntent, 2130772028, 0, true);
      return;
      this.jdField_a_of_type_Bmkf.a(-1, paramIntent, 2130772028, 0, true);
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
      ((bmiv)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  public void a(bmkf parambmkf, EditVideoParams paramEditVideoParams)
  {
    p();
    if ((parambmkf == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Bmkf != parambmkf) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Bmkf = parambmkf;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((bmiv)paramEditVideoParams.next()).a(parambmkf);
      continue;
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { parambmkf, paramEditVideoParams });
    }
  }
  
  public void a(bmwn parambmwn)
  {
    Object localObject = parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<bmwn> paramObserver)
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
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
      azds.y = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      azds.z = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      azds.x = 0;
      azds.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azds.J = i;
        i = ((EditRecordVideoSource)localObject1).f;
        j = ((EditRecordVideoSource)localObject1).g;
        str1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject1).e;
        str2 = ((EditRecordVideoSource)localObject1).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) || (!a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144))) {
          break label743;
        }
        localObject1 = null;
        if (this.jdField_a_of_type_Bmhz != null) {
          localObject1 = this.jdField_a_of_type_Bmhz.a();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((bmlk)((Iterator)localObject1).next()).jdField_c_of_type_Int));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
      azds.y = 5000;
      azds.z = 125;
      azds.x = 0;
      azds.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azds.J = i;
        j = ((EditLocalVideoSource)localObject1).a();
        k = ((EditLocalVideoSource)localObject1).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
      azds.y = 5000;
      azds.z = 125;
      azds.x = 0;
      azds.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        azds.J = i;
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
    throw new IllegalArgumentException(alpo.a(2131704214) + paramEditSource);
    wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
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
      localObject1 = new bmwn(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str3;
      ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (m * 1000 + l);
      ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azds.r;
      if (azfz.f())
      {
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (azfz.b() * 1000);
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(azfz.f()));
      }
      ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = azds.s;
      ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str4;
      ((bmwn)localObject1).jdField_b_of_type_JavaLangString = bmxg.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
      localObject2 = this.jdField_a_of_type_Bmkf.getActivity();
      boolean bool2;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() == 5))
      {
        bool2 = true;
        ((bmwn)localObject1).jdField_a_of_type_Bmwv = new bmwv((Activity)localObject2, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
          break label1147;
        }
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(k));
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
        c((bmwn)localObject1);
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((bmiv)((Iterator)localObject2).next()).a(n, (bmwn)localObject1);
        }
        bool2 = false;
        break;
        label1147:
        ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      localObject2 = ((bmwn)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty(((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
          ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject2);
        }
      }
      else
      {
        label1211:
        a((bmwn)localObject1);
        b((bmwn)localObject1);
        wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((bmwn)localObject1).jdField_b_of_type_JavaLangString });
        this.jdField_a_of_type_Bmkf.a(alpo.a(2131704157), false, 500L);
        localObject2 = Stream.of(localObject1).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
        if (((bmwn)localObject1).jdField_a_of_type_Int != 1) {
          break label1684;
        }
        if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
          break label1659;
        }
        localObject1 = new bmxa(null, (bmjh)a(bmjh.class), n);
        label1339:
        localObject2 = ((Stream)localObject2).map((StreamFunction)localObject1);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bmhd != null)
        {
          localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bmhd.a(n));
          if ((this.jdField_a_of_type_Bmhd.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a()) && (c() == 0L)) {
            break label1813;
          }
          localObject1 = ((Stream)localObject1).map(new bmwp(this.jdField_a_of_type_Bmhd, (bmef)a(bmef.class), n));
        }
      }
    }
    label1684:
    label1813:
    for (;;)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Bmgi != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bmgi.a(n));
      }
      localObject1 = localObject2;
      Object localObject3;
      if (this.jdField_a_of_type_Bmik != null)
      {
        localObject3 = this.jdField_a_of_type_Bmik.a(n);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Stream)localObject2).map((StreamFunction)localObject3);
        }
      }
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {}
      for (localObject1 = ((Stream)localObject1).map(new bmxb());; localObject1 = ((Stream)localObject1).map(new bmxf()).map((StreamFunction)ume.a(bmwl.class, new Object[0])))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", bkwm.b(this.jdField_a_of_type_Bmkf.getActivity().getIntent()));
        }
        ((Stream)localObject1).map(new bmxi(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        localObject3 = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((bmwn)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
        localPublishVideoEntry.videoDoodleDescription += (String)localObject2;
        break label1211;
        label1659:
        localObject1 = new bmww(null, (bmjh)a(bmjh.class), n);
        break label1339;
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
        {
          localObject1 = new bmxa(null, (bmjh)a(bmjh.class), 0);
          break label1339;
        }
        localObject1 = new bmww();
        break label1339;
      }
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((bmiv)paramEditSource.next()).aY_();
      }
      break;
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    wsv.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    long l = paramEditVideoParams.jdField_a_of_type_Long;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label188:
    label612:
    int i;
    if (paramEditVideoParams.jdField_a_of_type_Int == 11)
    {
      localObject = new bmdy(this, l);
      this.jdField_a_of_type_Bmgo = ((bmgo)localObject);
      localArrayList.add(localObject);
      if ((!bkwm.a(this.jdField_a_of_type_Bmkf.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!bkwm.c(this.jdField_a_of_type_Bmkf.getActivity().getIntent())))
      {
        localObject = new bmfh(this);
        this.jdField_a_of_type_Bmfh = ((bmfh)localObject);
        localArrayList.add(localObject);
      }
      localObject = new bmed(this);
      this.jdField_a_of_type_Bmed = ((bmed)localObject);
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
        localArrayList.add(new yxj(this));
      }
      label257:
      if ((paramEditVideoParams.b()) && (blqf.jdField_a_of_type_Boolean))
      {
        localObject = new bmfp(this);
        this.jdField_a_of_type_Bmfp = ((bmfp)localObject);
        localArrayList.add(localObject);
        if (a(l, 16777216)) {
          this.jdField_a_of_type_Bmfp.jdField_a_of_type_Boolean = true;
        }
      }
      if (a(l, 1024))
      {
        localObject = new bmgi(this);
        this.jdField_a_of_type_Bmgi = ((bmgi)localObject);
        localArrayList.add(localObject);
      }
      if ((a(l, 536870912)) || (a(l, 1)) || (a(l, 8)))
      {
        localObject = new bmhd(this, l);
        this.jdField_a_of_type_Bmhd = ((bmhd)localObject);
        localArrayList.add(localObject);
        localObject = new bmji(this);
        this.jdField_a_of_type_Bmji = ((bmji)localObject);
        localArrayList.add(localObject);
        localObject = new bmjk(this);
        this.jdField_a_of_type_Bmjk = ((bmjk)localObject);
        localArrayList.add(localObject);
        if ((a(l, 274877906944L)) && (paramEditVideoParams.jdField_a_of_type_Int == 1) && (((DynamicTextConfigManager)blmf.a(7)).c()))
        {
          localObject = new bmha(this, paramEditVideoParams.e);
          this.jdField_a_of_type_Bmha = ((bmha)localObject);
          localArrayList.add(localObject);
        }
      }
      if (a(l, 256))
      {
        if ((paramEditVideoParams.jdField_a_of_type_Int != 1) && (paramEditVideoParams.jdField_a_of_type_Int != 2) && (paramEditVideoParams.jdField_a_of_type_Int != 11) && (paramEditVideoParams.jdField_a_of_type_Int != 12) && (paramEditVideoParams.jdField_a_of_type_Int != 3) && (paramEditVideoParams.jdField_a_of_type_Int != 13)) {
          break label1853;
        }
        localObject = new bmju(this, a(l, 2097152));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 512))
      {
        localObject = new bmil(this);
        this.jdField_a_of_type_Bmil = ((bmil)localObject);
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
        localObject = new bmex(this);
        this.jdField_a_of_type_Bmex = ((bmex)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 8192))
      {
        if (!bkwm.c(this.jdField_a_of_type_Bmkf.getActivity().getIntent())) {
          break label1882;
        }
        localObject = new bmfc(this);
        this.jdField_a_of_type_Bmfc = ((bmfc)localObject);
        localArrayList.add(localObject);
      }
      label793:
      if (a(l, 32768))
      {
        localObject = new bmeg(this);
        this.jdField_a_of_type_Bmeg = ((bmeg)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 131072))
      {
        localObject = new bmjd(this);
        this.jdField_a_of_type_Bmjd = ((bmjd)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 1048576))
      {
        localObject = new bmjt(this);
        this.jdField_a_of_type_Bmjt = ((bmjt)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (a(l, 262144)))
      {
        localObject = new bmhz(this);
        this.jdField_a_of_type_Bmhz = ((bmhz)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 8388608))
      {
        localObject = new bmjr(this);
        this.jdField_a_of_type_Bmjr = ((bmjr)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 67108864))
      {
        localObject = new bmjx(this);
        this.jdField_a_of_type_Bmjx = ((bmjx)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 268435456))
      {
        localObject = new bmki(this);
        this.jdField_a_of_type_Bmki = ((bmki)localObject);
        localArrayList.add(localObject);
        localObject = new bmul(this);
        this.jdField_a_of_type_Bmul = ((bmul)localObject);
        localArrayList.add(localObject);
        localObject = new bmij(this, this.jdField_a_of_type_Bmki, this.jdField_a_of_type_Bmul);
        this.jdField_a_of_type_Bmij = ((bmij)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 134217728))
      {
        localObject = new bmit(this);
        this.jdField_a_of_type_Bmit = ((bmit)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 16))
      {
        localObject = new bmke(this);
        this.jdField_a_of_type_Bmke = ((bmke)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 33554432))
      {
        localObject = new bmir(this);
        this.jdField_a_of_type_Bmir = ((bmir)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 4294967296L))
      {
        localObject = new bmgy(this, l);
        this.jdField_a_of_type_Bmgy = ((bmgy)localObject);
        localArrayList.add(localObject);
      }
      if ((bkwm.c.a(paramEditVideoParams.f)) && ((paramEditVideoParams.c()) || (paramEditVideoParams.a()) || (paramEditVideoParams.b())))
      {
        localObject = new bmyb(this);
        this.jdField_a_of_type_Bmyb = ((bmyb)localObject);
        localArrayList.add(localObject);
      }
      if (a(paramEditVideoParams.jdField_a_of_type_Long, 8589934592L))
      {
        localObject = new bmhv(this, l);
        this.jdField_a_of_type_Bmhv = ((bmhv)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))) {
        localArrayList.add(new bmfw(this));
      }
      if (a(paramEditVideoParams.jdField_a_of_type_Long, 34359738368L))
      {
        localObject = new bmip(this);
        this.jdField_a_of_type_Bmip = ((bmip)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 137438953472L))
      {
        localObject = new bmgc(this);
        this.jdField_a_of_type_Bmgc = ((bmgc)localObject);
        localArrayList.add(localObject);
      }
      if (a(l, 16384))
      {
        i = paramEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
        if (i != -1) {
          break label1965;
        }
        wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", " curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
      }
    }
    for (;;)
    {
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      wsv.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        wsv.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((bmiv)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 12)
      {
        localObject = new oiu(this, l);
        this.jdField_a_of_type_Bmgo = ((bmgo)localObject);
        localArrayList.add(localObject);
        break;
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 14)
      {
        localObject = new bmjv(this);
        this.jdField_a_of_type_Bmjv = ((bmjv)localObject);
        localArrayList.add(localObject);
        break;
      }
      localObject = new bmgo(this, l);
      this.jdField_a_of_type_Bmgo = ((bmgo)localObject);
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
        localArrayList.add(new bmkq(this));
        break label188;
      }
      if (paramEditVideoParams.i())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break label188;
      }
      localObject = new bmjf(this);
      this.jdField_a_of_type_Bmjf = ((bmjf)localObject);
      localArrayList.add(localObject);
      break label188;
      label1823:
      localObject = new blpf(this, false);
      this.jdField_a_of_type_Blpf = ((blpf)localObject);
      localArrayList.add(localObject);
      break label257;
      label1853:
      localObject = new EditVideoFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break label612;
      label1882:
      if (!bkwm.a(this.jdField_a_of_type_Bmkf.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localObject = new bmjn(this);
        this.jdField_a_of_type_Bmjn = ((bmjn)localObject);
        localArrayList.add(localObject);
        break label793;
      }
      localObject = new bmfc(this);
      this.jdField_a_of_type_Bmfc = ((bmfc)localObject);
      localArrayList.add(localObject);
      break label793;
      label1965:
      this.jdField_a_of_type_Bmea = new bmea(this, i, true);
      localArrayList.add(this.jdField_a_of_type_Bmea);
    }
  }
  
  public void a(Class<? extends bmiw> paramClass, bmiw parambmiw)
  {
    p();
    E();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(parambmiw)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + parambmiw.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    bmiw localbmiw = (bmiw)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbmiw == null) {
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), parambmiw);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, parambmiw);
      return;
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localbmiw, parambmiw });
    }
  }
  
  public void a(Error paramError)
  {
    wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).a(paramError);
    }
    wta.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bmkf.b();
      QQToast.a(this.jdField_a_of_type_Bmkf.a(), alpo.a(2131704139), 0).a();
      paramError = (bmjh)a(bmjh.class);
    } while (paramError == null);
    paramError.l();
  }
  
  public void a(String paramString)
  {
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onDlnaVideoSaved videoPath " + paramString);
    if (paramString != null)
    {
      bizt localbizt = bizt.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      bizm.e(this.jdField_a_of_type_Bmkf.getActivity(), localbizt, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      Bosses.get().postJob(new bmiz(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<bmiv> paramList) {}
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    bmjh localbmjh = (bmjh)a(bmjh.class);
    if (localbmjh != null)
    {
      if (!(localbmjh instanceof HWEditLocalVideoPlayer)) {
        break label41;
      }
      ((HWEditLocalVideoPlayer)localbmjh).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    label41:
    while (!(localbmjh instanceof bmkq)) {
      return;
    }
    ((bmkq)localbmjh).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
      throw new RuntimeException(alpo.a(2131704182));
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
      ((bmiv)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_a_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(bmwn parambmwn)
  {
    long l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              wsv.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
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
    Bosses.get().postJob(new bmja(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
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
    if (this.jdField_a_of_type_Bmgy != null) {
      return this.jdField_a_of_type_Bmgy.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  protected void c()
  {
    bmjh localbmjh = (bmjh)a(bmjh.class);
    if (localbmjh != null) {
      localbmjh.k();
    }
    this.jdField_a_of_type_Bmkf.a(0, null, 2130772028, 0);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1)
    {
      int i = g();
      wta.b("time_edit", 1, (int)(System.currentTimeMillis() - d()), new String[] { wta.b(i), "1", "", "" });
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bmgo != null) {
      this.jdField_a_of_type_Bmgo.b(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).i_(paramBoolean);
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
    if (this.jdField_a_of_type_Bmhd != null) {
      i = this.jdField_a_of_type_Bmhd.a(a());
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
    if ((this.jdField_a_of_type_Bmkf instanceof EditVideoActivity)) {
      return ((EditVideoActivity)this.jdField_a_of_type_Bmkf).jdField_a_of_type_Long;
    }
    if ((this.jdField_a_of_type_Bmkf instanceof EditPicActivity)) {
      return ((EditPicActivity)this.jdField_a_of_type_Bmkf).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public void d()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_Bmhd != null)
    {
      Object localObject = this.jdField_a_of_type_Bmhd.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).j();
      }
      localObject = this.jdField_a_of_type_Bmhd.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((bmmg)localObject).a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Bmkf.a(alpo.a(2131704106), false, 500L);
          this.jdField_a_of_type_Bmhd.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Bmhd.a().o();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_Bmhd.a().a();
      j = i;
      if (localObject != null)
      {
        ((bmmk)localObject).i();
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
      if (this.jdField_a_of_type_Blpf == null) {
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
    if ((this.jdField_a_of_type_Bmir != null) && (this.jdField_a_of_type_Bmir.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjk });
      return true;
    }
    if ((this.jdField_a_of_type_Bmkg != null) && (this.jdField_a_of_type_Bmkg.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjk });
      return true;
    }
    if ((this.jdField_a_of_type_Bmjk != null) && (this.jdField_a_of_type_Bmjk.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjk });
      return true;
    }
    if ((this.jdField_a_of_type_Bmji != null) && (this.jdField_a_of_type_Bmji.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmji });
      return true;
    }
    if ((this.jdField_a_of_type_Bmjx != null) && (this.jdField_a_of_type_Bmjx.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjx });
      return true;
    }
    if ((this.jdField_a_of_type_Bmki != null) && (this.jdField_a_of_type_Bmki.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmki });
      return true;
    }
    if ((this.jdField_a_of_type_Bmul != null) && (this.jdField_a_of_type_Bmul.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmul });
      return true;
    }
    if ((this.jdField_a_of_type_Bmik != null) && (this.jdField_a_of_type_Bmik.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmik });
      return true;
    }
    if ((this.jdField_a_of_type_Blpf != null) && (this.jdField_a_of_type_Blpf.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Blpf });
      return true;
    }
    if ((this.jdField_a_of_type_Bmil != null) && (this.jdField_a_of_type_Bmil.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmil });
      return true;
    }
    if ((this.jdField_a_of_type_Bmhd != null) && (this.jdField_a_of_type_Bmhd.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmhd });
      return true;
    }
    if ((this.jdField_a_of_type_Bmex != null) && (this.jdField_a_of_type_Bmex.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmex });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_a_of_type_Bmeg != null) && (this.jdField_a_of_type_Bmeg.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmeg });
      return true;
    }
    if ((this.jdField_a_of_type_Bmgy != null) && (this.jdField_a_of_type_Bmgy.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmgy });
      return true;
    }
    if ((this.jdField_a_of_type_Bmgo != null) && (this.jdField_a_of_type_Bmgo.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmgo });
      return true;
    }
    if ((this.jdField_a_of_type_Bmjv != null) && (this.jdField_a_of_type_Bmjv.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmjv });
      return true;
    }
    if ((this.jdField_a_of_type_Bmyb != null) && (this.jdField_a_of_type_Bmyb.a()))
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Bmyb });
      return true;
    }
    e();
    return true;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Bmhz != null)
    {
      List localList = this.jdField_a_of_type_Bmhz.a();
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
    blen.a().d();
    String str;
    if (a())
    {
      str = "2";
      a("clk_left", 0, 0, new String[] { str });
      wtb.a("0X80076B6");
      wtb.b("0X80075C2");
      wtb.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007823");
      if (this.jdField_a_of_type_Bmhd == null) {
        break label349;
      }
    }
    label312:
    label349:
    for (int j = this.jdField_a_of_type_Bmhd.b();; j = 0)
    {
      int i = j;
      if (this.jdField_a_of_type_Bmil != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bmil.a())) {
          i = j + 1;
        }
      }
      j = i;
      if (this.jdField_a_of_type_Bmex != null) {
        j = i + this.jdField_a_of_type_Bmex.jdField_a_of_type_Int;
      }
      i = j;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
          i = j + 4;
        }
      }
      wsv.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(i));
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
        wtb.a("0X80076B7");
        wtb.b("0X80075C3");
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) {
          break label312;
        }
        str = alpo.a(2131704217);
      }
      for (;;)
      {
        bhpy localbhpy = bhpy.a(this.jdField_a_of_type_Bmkf.a(), false);
        localbhpy.a(str);
        localbhpy.a(alpo.a(2131704261), 3);
        localbhpy.d(alpo.a(2131704179));
        localbhpy.a(new bmiy(this, localbhpy));
        localbhpy.show();
        return;
        str = "1";
        break;
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_d_of_type_Boolean)) {
          str = alpo.a(2131704277);
        } else {
          str = alpo.a(2131704253);
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmgo != null) {
      this.jdField_a_of_type_Bmgo.b(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Bmyb != null) && (this.jdField_a_of_type_Bmyb.jdField_a_of_type_Boolean);
  }
  
  public int f()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bmkf == null) {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
    }
    label92:
    Object localObject2;
    do
    {
      return;
      a(this.jdField_a_of_type_Bmkf.a());
      a();
      localObject1 = this.jdField_a_of_type_Bmkf.getActivity();
      if ((localObject1 instanceof EditPicActivity)) {}
      switch (((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1))
      {
      default: 
        if (f() != 7) {
          break label223;
        }
        bkjt.a(this.jdField_a_of_type_Bmkf.a());
        localObject2 = xir.a();
      }
    } while (localObject2 == null);
    Object localObject1 = ((xir)localObject2).a();
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
      bnbe.f();
      break label92;
      bnbe.g();
      break label92;
      bnbe.h();
      break label92;
      label223:
      break;
      int m = ((List)localObject1).size();
      int k = ((xir)localObject2).a();
      localObject2 = this.jdField_a_of_type_Bmkf.getActivity().getIntent();
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
          wta.a("video_edit_slides", "clk_pub", k, 0, new String[] { wta.a(j) + "", ((List)localObject1).size() + "", m - i + "", i + "" });
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
      ((bmiv)localIterator.next()).al_();
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
    this.jdField_a_of_type_Bmkf = null;
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
    Object localObject = this.jdField_a_of_type_Bmkf.getActivity().getIntent();
    this.jdField_a_of_type_AndroidOsBundle = bllw.a((Intent)localObject);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).a();
    }
    if ((bkwm.a((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bkwm.c((Intent)localObject)))
    {
      bngs.c(this.jdField_a_of_type_Bmkf.getActivity());
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
      if (this.jdField_a_of_type_Bmjt != null) {
        wta.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      if (!a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 64)) {
        break label236;
      }
      jdField_a_of_type_Bnjl = new bnjl();
    }
    label236:
    do
    {
      return;
      localObject = "1";
      break;
      localObject = this.jdField_a_of_type_Bmkf.getActivity().findViewById(2131373261);
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).z_();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).f();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).bd_();
    }
  }
  
  public void n()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).aZ_();
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bmiv)localIterator.next()).g();
      }
      i();
    }
    if ((jdField_a_of_type_Bnjl != null) && (!azga.c())) {
      jdField_a_of_type_Bnjl.a();
    }
    bncp.a().b();
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
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a().k();
    }
    a(19);
    if (xir.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_Bmhd.a().k();
    a(47);
    if (xir.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  void s()
  {
    if (this.jdField_a_of_type_Bmhd != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bmhd.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.d();
      }
    }
  }
  
  void t()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Bmex;
    ((bmex)localObject).jdField_a_of_type_Int += d();
    if (this.jdField_a_of_type_Int == 11) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Bmhd.a();
      ((DoodleLayout)localObject).i();
      bmmg localbmmg = ((DoodleLayout)localObject).a();
      i = j;
      if (localbmmg != null)
      {
        i = j;
        if (localbmmg.a.a())
        {
          this.jdField_a_of_type_Bmkf.a(alpo.a(2131704174), false, 500L);
          this.jdField_a_of_type_Bmhd.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).o();
          i = 1;
        }
      }
    } while (i != 0);
    u();
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bmkf.b();
    Object localObject3 = this.jdField_a_of_type_Bmhd.a();
    Object localObject1 = ((DoodleLayout)localObject3).a(0);
    Object localObject2 = ((DoodleLayout)localObject3).b(0);
    this.jdField_a_of_type_Bmex.jdField_a_of_type_ArrayOfInt[0] = localObject1[0];
    this.jdField_a_of_type_Bmex.jdField_a_of_type_ArrayOfInt[1] = localObject1[1];
    this.jdField_a_of_type_Bmex.jdField_a_of_type_ArrayOfInt[2] = localObject2[0];
    this.jdField_a_of_type_Bmex.jdField_a_of_type_ArrayOfInt[3] = localObject2[1];
    this.jdField_a_of_type_Bmex.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject3).a().b();
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
        localObject1 = xmn.c((Bitmap)localObject2, (Bitmap)localObject3);
        wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
      }
    }
    this.jdField_a_of_type_Bmex.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
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
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a().l();
    }
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_Bmhd != null) {
      this.jdField_a_of_type_Bmhd.a().s();
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
 * Qualified Name:     bmix
 * JD-Core Version:    0.7.0.1
 */