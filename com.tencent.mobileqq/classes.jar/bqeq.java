import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.12;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.7;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.9;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bqeq
  extends bqgi
  implements bqbr, bqnb, bqnc, IEventReceiver
{
  public static final String a;
  public static String b;
  public int a;
  private final long jdField_a_of_type_Long;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bqex(this);
  bqez jdField_a_of_type_Bqez;
  bqfa jdField_a_of_type_Bqfa;
  bqfb jdField_a_of_type_Bqfb;
  private bqgw jdField_a_of_type_Bqgw = new bqer(this);
  public bqlg a;
  brhj jdField_a_of_type_Brhj = new bqet(this);
  public ProviderViewEditContainer a;
  protected DoodleLayout a;
  protected Runnable a;
  public boolean a;
  protected byte[] a;
  private long b;
  public boolean b;
  protected boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = win.e;
    jdField_b_of_type_JavaLangString = "EditVideoDoodle";
  }
  
  public bqeq(@NonNull bqgk parambqgk, long paramLong)
  {
    super(parambqgk);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.7(this);
    this.jdField_a_of_type_Bqlg = new bqey(this);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        d();
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    int k;
    int j;
    int i;
    float f;
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_Bqgk.a() != null) && (!this.jdField_a_of_type_Bqgk.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f = j / i;
      if (!this.jdField_a_of_type_Bqgk.a().getTakePicToVideo()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
      }
      j = bdep.jdField_a_of_type_Int;
      i = bdep.b;
      if (bdep.a(a())) {
        break label328;
      }
      i = bdep.c(a());
    }
    for (;;)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setLayoutParams(localLayoutParams);
      }
      return;
      label328:
      i = bdep.b;
      if (Build.MODEL.equals("Lenovo L78011")) {
        i -= LiuHaiUtils.a(a());
      }
    }
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt, paramBoolean);
  }
  
  public JobSegment<bqua, bqua> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return (JobSegment)wnu.a(bqul.class, new Object[] { this, (bqbs)a(bqbs.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)wnu.a(bqub.class, new Object[] { this, (bqbs)a(bqbs.class), Integer.valueOf(paramInt) });
  }
  
  @NonNull
  public DoodleLayout a()
  {
    d();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131365677));
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    PtvTemplateManager.a(localAppInterface).a(localAppInterface, this.jdField_a_of_type_Brhj, false);
    ThreadManager.excute(new EditVideoDoodle.5(this), 64, null, true);
    a(bqbr.class, this);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Bqgk.a(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a().a(anzj.a(2131702669), true, 0L, new bqes(this));
    this.jdField_a_of_type_Bqgk.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      return;
      l = SystemClock.elapsedRealtime();
    } while (l - this.jdField_b_of_type_Long <= 4000L);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoDoodle.12(this));
    this.jdField_b_of_type_Long = l;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.jdField_d_of_type_Boolean = false;
    switch (paramInt2)
    {
    case 8: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 32: 
    case 35: 
    case 37: 
    case 38: 
    case 39: 
    case 43: 
    case 45: 
    default: 
      a(0);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a(4);
              return;
              a(0);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
              return;
              a(0);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(false);
              return;
            } while ((paramInt1 == 9) || (paramInt1 == paramInt2));
            d();
            a(0);
            return;
          } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
          return;
          a(8);
          return;
          if (paramInt1 != 9)
          {
            d();
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.h();
            a(0);
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
          return;
        } while (paramInt1 == 8);
        d();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.m();
        a(0);
        return;
      } while (paramInt1 != 36);
      this.jdField_d_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(true);
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().a(paramInt1, paramInt2, paramBoolean);
    if ((!paramBoolean) && (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle != null))
    {
      Bundle localBundle = this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjh.jdField_a_of_type_JavaLangString);
      if (localBundle != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(localBundle);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjx.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    this.jdField_a_of_type_Bqgk.a().setWordId(a().b());
    this.jdField_a_of_type_Bqgk.a().setStickerId(a().c());
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("all_doodle_text", a().a());
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    if (a().b(paramInt).size() > 0)
    {
      localObject1 = (bpqh)bplq.a(4);
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((bpqh)localObject1).a();
    }
    label280:
    label337:
    int i;
    label396:
    Object localObject3;
    int j;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d())
    {
      if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      }
    }
    else
    {
      if (a().b(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Bqgk;
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label959;
        }
        localObject1 = "2";
        ((bqgk)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        yuq.a("0X80076C0");
      }
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Bqgk;
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label967;
        }
        localObject1 = "2";
        ((bqgk)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        yuq.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label975;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label988;
        }
        localObject3 = this.jdField_a_of_type_Bqgk;
        j = this.jdField_a_of_type_Bqgk.b();
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label980;
        }
        localObject1 = "2";
        label455:
        ((bqgk)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        yuq.a("0X80076E0", yuq.b);
        yuq.b("0X80075EA", yuq.jdField_a_of_type_Int);
        parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        parambqua.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label527:
        if (localObject2[1] <= 0) {
          break label1019;
        }
        localObject3 = this.jdField_a_of_type_Bqgk;
        j = this.jdField_a_of_type_Bqgk.b();
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label1011;
        }
        localObject1 = "2";
        label564:
        ((bqgk)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        yuq.a("0X80076E1");
        yuq.b("0X80075EB");
        parambqua.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().b(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1392;
      }
      localObject4 = a().a(paramInt);
      localObject1 = a().b(paramInt);
      localObject3 = new StringBuilder();
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        localObject6 = (List)((Map.Entry)localObject5).getValue();
        if ((localObject6 != null) && (((List)localObject6).size() > 0))
        {
          localObject5 = (String)((Map.Entry)localObject5).getKey();
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            String str = (String)((Iterator)localObject6).next();
            ((StringBuilder)localObject3).append((String)localObject5).append(':').append(str).append(',');
          }
        }
      }
      if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalPhotoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalPhotoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
        break;
      }
      if (!(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break;
      }
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalGifSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalGifSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      break;
      label959:
      localObject1 = "1";
      break label280;
      label967:
      localObject1 = "1";
      break label337;
      label975:
      i = 0;
      break label396;
      label980:
      localObject1 = "1";
      break label455;
      label988:
      if ((i == 0) || (!bqug.a(0))) {
        break label527;
      }
      yuq.b("0X80075EA", yuq.jdField_a_of_type_Int);
      break label527;
      label1011:
      localObject1 = "1";
      break label564;
      label1019:
      if ((i != 0) && (bqug.a(1))) {
        yuq.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    yuk.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject4).append(((bqjl)((Iterator)localObject1).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
    }
    yuk.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_Bqgk;
      j = this.jdField_a_of_type_Bqgk.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_Bqgk.a())
      {
        localObject1 = "2";
        ((bqgk)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        yuq.a("0X80076E3", yuq.b);
        yuq.b("0X80075ED", yuq.jdField_a_of_type_Int);
        parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1285:
        if (localObject2[1] <= 0) {
          break label1698;
        }
        this.jdField_a_of_type_Bqgk.b("pub_poi", this.jdField_a_of_type_Bqgk.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        yuq.a("0X80076E4");
        yuq.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1669;
        }
        parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1392:
        localObject2 = a().a(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1718;
        }
        j = 1;
        label1413:
        if (j == 0) {
          break label1732;
        }
        localObject3 = this.jdField_a_of_type_Bqgk;
        i = this.jdField_a_of_type_Bqgk.b();
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label1724;
        }
        localObject1 = "2";
        label1447:
        ((bqgk)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        yuq.a("0X80076E2", yuq.b);
        yuq.b("0X80075EC", yuq.jdField_a_of_type_Int);
        parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        parambqua.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject3 = a().a(paramInt);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label1782;
      }
      localObject1 = "";
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject2 = (String)localObject1 + (String)((List)localObject3).get(paramInt);
        localObject1 = localObject2;
        if (paramInt != ((List)localObject3).size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break;
      if ((i == 0) || (!bqug.a(2))) {
        break label1285;
      }
      yuq.b("0X80075ED", yuq.jdField_a_of_type_Int);
      break label1285;
      label1669:
      parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      parambqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1392;
      label1698:
      if ((i == 0) || (!bqug.a(3))) {
        break label1392;
      }
      yuq.b("0X80075EE");
      break label1392;
      label1718:
      j = 0;
      break label1413;
      label1724:
      localObject1 = "1";
      break label1447;
      label1732:
      if ((i != 0) && (bqug.a(4))) {
        yuq.b("0X80075EC", yuq.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Bqgk.b("person_gra", this.jdField_a_of_type_Bqgk.b(), 0, new String[] { localObject1 });
    label1782:
    Object localObject2 = bplg.a().getCurrentAccountUin();
    if (bqox.jdField_b_of_type_Boolean) {}
    for (Object localObject1 = parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription;; localObject1 = "")
    {
      ShortVideoUtils.a((String)localObject2, (String)localObject1);
      if (((a().a() == null) || (a().a().jdField_a_of_type_JavaUtilList == null) || (a().a().jdField_a_of_type_JavaUtilList.size() <= 0)) && ((a().a() == null) || (a().a().jdField_a_of_type_JavaUtilList == null) || (a().a().jdField_a_of_type_JavaUtilList.size() <= 0))) {
        break;
      }
      parambqua.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasFace = true;
      return;
    }
  }
  
  public void a(long paramLong)
  {
    a().setFaceLayerPosition(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    bqgu localbqgu = (bqgu)a(bqgu.class);
    if (localbqgu != null) {
      localbqgu.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_Bqgk.a(paramAnimation);
  }
  
  public void a(bqpe parambqpe)
  {
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      ((wta)wth.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_Bqgk.b(6);
    if (this.jdField_a_of_type_Bqgk.a())
    {
      parambqpe = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      yup.a("video_edit", "add_place", 0, 0, new String[] { parambqpe, "", str, "" });
      return;
      parambqpe = "1";
      break;
    }
  }
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    a().a(paramMap);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramJSONObject);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      bqgu localbqgu = (bqgu)a(bqgu.class);
      if (localbqgu != null) {
        localbqgu.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false);
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    case 4: 
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 3: 
      this.jdField_a_of_type_Bqgk.a(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.q();
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    case 6: 
      a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_Bqgk.a());
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Bqgk.a(0);
      }
    case 11: 
      this.jdField_d_of_type_Long = ((Long)paramMessage.obj).longValue();
      return true;
    }
    paramMessage = (Long[])paramMessage.obj;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTimeStamp(paramMessage[0].longValue(), false);
    }
    return true;
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    }
    return null;
  }
  
  public void aY_()
  {
    super.aY_();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void ad_()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_Bqgk.a();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().e();
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.c)) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 7: 
      if ((this.jdField_a_of_type_Bqgk.a(13)) || (this.jdField_a_of_type_Bqgk.a(14)) || (this.jdField_a_of_type_Bqgk.a(15)) || (this.jdField_a_of_type_Bqgk.a(16)))
      {
        yuk.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Bqgk.a(36);
        return;
      }
      this.jdField_a_of_type_Bqgk.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_Bqgk.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_Bqgk.a(5, paramObject);
      return;
    case 4: 
      this.jdField_a_of_type_Bqgk.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_Bqgk.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_Bqgk.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_Bqgk.b(paramAnimation);
  }
  
  public void b(String paramString)
  {
    bqgk localbqgk = this.jdField_a_of_type_Bqgk;
    if (this.jdField_a_of_type_Bqgk.a()) {}
    for (String str = "2";; str = "1")
    {
      localbqgk.a("exp_editpoi", 0, 0, new String[] { str });
      yuq.a("0X80076CF");
      yuq.b("0X80075E4");
      paramString = new bqfd(this.jdField_a_of_type_Bqgw, paramString);
      this.jdField_a_of_type_Bqgk.a(3, paramString);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bqgk.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {}
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b());
  }
  
  public void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      yuk.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label740;
      }
    }
    label740:
    for (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131365676)))
    {
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f == born.c.a()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      if (!bqgk.a(this.jdField_a_of_type_Long, 1)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.p();
      }
      this.jdField_b_of_type_Boolean = true;
      j();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setupPersonality();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoDoodle(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.w();
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle != null)
      {
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjh.jdField_a_of_type_JavaLangString) != null) {
          this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjh.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_Bqgk.a());
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjh.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjx.jdField_a_of_type_JavaLangString) != null) {
            this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjx.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_Bqgk.a());
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle(bqjx.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle("VoteLayer");
          if (localObject1 != null)
          {
            localObject1 = (InteractPasterParcelData)((Bundle)localObject1).getParcelable("vote_paster");
            localObject2 = (bqbw)this.jdField_a_of_type_Bqgk.a(bqbw.class);
            if (localObject2 != null) {
              ((bqbw)localObject2).a((InteractPasterParcelData)localObject1);
            }
          }
        }
      }
      bpue.a().a(this.jdField_a_of_type_Bqgk.h(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
      if (localObject1 != null)
      {
        ((DoodleEditView)localObject1).setFrom(1);
        ((DoodleEditView)localObject1).a(bqgk.a(this.jdField_a_of_type_Long, 134217728));
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqcu.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setLiuHaiParentView(this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if ((localObject1 != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null))
        {
          int i = 0;
          if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
            i = ((EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(new bqeu(this, i));
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject1).a());
          ((DoodleEditView)localObject1).setDoodleEditViewListener(new bqev(this));
        }
        a(2131365851).setOnTouchListener(new bqew(this));
      }
      localObject1 = wjj.a();
      Object localObject2 = new bqfa(this);
      this.jdField_a_of_type_Bqfa = ((bqfa)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = wjj.a();
      localObject2 = new bqez(this);
      this.jdField_a_of_type_Bqez = ((bqez)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = wjj.a();
      localObject2 = new bqfb(this);
      this.jdField_a_of_type_Bqfb = ((bqfb)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void g()
  {
    this.c = true;
    if (this.jdField_a_of_type_Bqfa != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Bqfa);
    }
    if (this.jdField_a_of_type_Bqez != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Bqez);
    }
    if (this.jdField_a_of_type_Bqfb != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Bqfb);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(null);
    }
    bpue.a().a(this.jdField_a_of_type_Bqgk.h());
  }
  
  public boolean m_()
  {
    if (System.currentTimeMillis() < this.jdField_d_of_type_Long) {}
    while ((!bqgk.a(this.jdField_a_of_type_Long, 1)) || (!TextUtils.isEmpty(a().a(this.jdField_a_of_type_Bqgk.a())))) {
      return false;
    }
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Int == 28) {
      this.jdField_a_of_type_Bqgk.a(0);
    }
    return true;
  }
  
  public void o()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Bqgk.a(0);
  }
  
  public void p()
  {
    this.jdField_a_of_type_Bqgk.e();
  }
  
  public void q()
  {
    this.jdField_a_of_type_Bqgk.g();
  }
  
  public void r()
  {
    this.jdField_a_of_type_Bqhs.a().postDelayed(new EditVideoDoodle.9(this), 200L);
  }
  
  public void s()
  {
    a().b();
  }
  
  public void t()
  {
    this.jdField_a_of_type_Bqgk.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqeq
 * JD-Core Version:    0.7.0.1
 */