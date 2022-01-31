package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleBtnOperationHelper;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateDoodleImageSegment;
import com.tencent.biz.qqstory.takevideo.publish.Publishable;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oio;
import oip;
import oiq;
import oir;
import ois;
import oit;
import oiu;
import oiv;
import oiw;
import oix;
import oiy;

public class EditVideoDoodle
  extends EditVideoPart
  implements EditDoodleExport, DoodleLayout.DoodleBtnOperationHelper, DoodleLayout.DoodleEventListener, Publishable, IEventReceiver
{
  public static final String a;
  public int a;
  public Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private EditVideoPoiPickerCallback jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback = new oio(this);
  public DoodleEmojiManager.POIPostersRequestCallback a;
  public DoodleLayout a;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = new ois(this);
  public LocationFacePackage a;
  PtvTemplateManager.DoodleInfoLoadObserver jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new oiu(this);
  public Runnable a;
  oiv jdField_a_of_type_Oiv;
  oiw jdField_a_of_type_Oiw;
  oix jdField_a_of_type_Oix;
  public oiy a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.c;
  }
  
  public EditVideoDoodle(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new oiq(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new oir(this);
    this.jdField_b_of_type_Int = paramInt;
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
        j();
      } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_Oiy.a(a());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Oiy);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new oip(this));
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 12))
      {
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = VideoUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() * 1280 / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.l(), (int)(DeviceInfoUtil.l() * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
    for (;;)
    {
      localObject1 = Dispatchers.get();
      Object localObject2 = new oiw(this);
      this.jdField_a_of_type_Oiw = ((oiw)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = Dispatchers.get();
      localObject2 = new oiv(this);
      this.jdField_a_of_type_Oiv = ((oiv)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = Dispatchers.get();
      localObject2 = new oix(this);
      this.jdField_a_of_type_Oix = ((oix)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131362976));
      break;
      label476:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() >= (float)DeviceInfoUtil.l() * 1.0F / (float)DeviceInfoUtil.m()) && (((EditLocalVideoSource)localObject1).a.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.l(), (int)(DeviceInfoUtil.l() * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
        }
        else if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() < 1.0F) && ((((EditLocalVideoSource)localObject1).a.rotation == 90) || (((EditLocalVideoSource)localObject1).a.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.l(), (int)(DeviceInfoUtil.l() * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    ((DoodleEmojiManager)SuperManager.a(8)).a(LocationUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback);
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
  }
  
  public Bitmap a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(paramInt);
  }
  
  @NonNull
  public DoodleLayout a()
  {
    j();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public JobSegment a(int paramInt)
  {
    if (((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return new HWEncodeGenerateDoodleImageSegment(this, (EditFilterExport)a(EditFilterExport.class), paramInt);
    }
    return new GenerateDoodleImageSegment(this, (EditFilterExport)a(EditFilterExport.class), paramInt);
  }
  
  @NonNull
  public Collection a()
  {
    Object localObject = ((DoodleEmojiManager)SuperManager.a(8)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject).next();
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localDoodleEmojiItem);
      if (localDoodleEmojiItem.jdField_a_of_type_Int == 1)
      {
        NormalFacePackage localNormalFacePackage = new NormalFacePackage(localDoodleEmojiItem.jdField_a_of_type_JavaLangString);
        localNormalFacePackage.b = localDoodleEmojiItem.d;
        localNormalFacePackage.c = localDoodleEmojiItem.b;
        localNormalFacePackage.d = localDoodleEmojiItem.c;
        localNormalFacePackage.f = localDoodleEmojiItem.a();
        localNormalFacePackage.a(localDoodleEmojiItem.f);
        if (("1".equals(localNormalFacePackage.jdField_a_of_type_JavaLangString)) && (!NetworkUtil.g(a()))) {
          localNormalFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130843460);
        }
        localArrayList.add(localNormalFacePackage);
      }
      else if (localDoodleEmojiItem.jdField_a_of_type_Int == 2)
      {
        if ((!TextUtils.isEmpty(localDoodleEmojiItem.b)) && (NetworkUtil.g(a()))) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = localDoodleEmojiItem.b;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130843583);
        }
      }
    }
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    b(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
    Object localObject2 = (DoodleEmojiManager)SuperManager.a(8);
    ((DoodleEmojiManager)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364376));
    this.jdField_a_of_type_Oiy = new oiy(null);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = new LocationFacePackage("Location-Package");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Boolean = true;
      localObject1 = DoodleEmojiManager.c((DoodleEmojiManager)localObject2, "0");
      localObject2 = DoodleEmojiManager.a((DoodleEmojiManager)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!NetworkUtil.g(a()))) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a((String)localObject1);
      a(EditDoodleExport.class, this);
      return;
      label156:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130843583);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 8: 
    case 9: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
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
            return;
            a(4);
            return;
            a(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
            return;
            a(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
            return;
          } while (paramInt1 == 9);
          j();
          if ((paramObject != null) && (paramObject == Boolean.TRUE)) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(2);
          }
          for (;;)
          {
            a(0);
            return;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(1);
          }
        } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
        return;
        a(8);
        return;
      } while (paramInt1 == 9);
      k();
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d();
      a(0);
      return;
    } while (paramInt1 == 8);
    j();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e();
    a(0);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.c();
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() == 1) {
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((FaceLayer.FaceAndTextItem)((List)localObject1).get(0)).a();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().b(paramInt))
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
      {
        localObject1 = "2";
        ((EditVideoPartManager)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        VideoEditReport.a("0X80076C0");
      }
    }
    else
    {
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label690;
        }
        localObject1 = "2";
        ((EditVideoPartManager)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        VideoEditReport.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((EditVideoPartManager)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E0", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((EditVideoPartManager)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E1");
        VideoEditReport.b("0X80075EB");
        paramGenerateContext.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().b(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1146;
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
      localObject1 = "1";
      break;
      label690:
      localObject1 = "1";
      break label202;
      label698:
      i = 0;
      break label261;
      label703:
      localObject1 = "1";
      break label320;
      label711:
      if ((i == 0) || (!GeneratePicArgs.a(0))) {
        break label392;
      }
      VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (GeneratePicArgs.a(1))) {
        VideoEditReport.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    SLog.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((FaceLayer.FaceAndTextItem)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((FaceLayer.FaceAndTextItem)((List)localObject1).get(0)).a();
    }
    SLog.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
      j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
      {
        localObject1 = "2";
        label946:
        ((EditVideoPartManager)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        VideoEditReport.a("0X80076E3", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasFace = true;
        label1031:
        if (localObject2[1] <= 0) {
          break label1448;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b("pub_poi", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        VideoEditReport.a("0X80076E4");
        VideoEditReport.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1419;
        }
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1138:
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasPoi = true;
        label1146:
        localObject2 = a().a(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1468;
        }
        j = 1;
        label1167:
        if (j == 0) {
          break label1482;
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label1474;
        }
        localObject1 = "2";
        label1201:
        ((EditVideoPartManager)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        VideoEditReport.a("0X80076E2", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().a(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramGenerateContext = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramGenerateContext + (String)((List)localObject2).get(paramInt);
        paramGenerateContext = (GenerateContext)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramGenerateContext = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!GeneratePicArgs.a(2))) {
        break label1031;
      }
      VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
      break label1031;
      label1419:
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1138;
      label1448:
      if ((i == 0) || (!GeneratePicArgs.a(3))) {
        break label1146;
      }
      VideoEditReport.b("0X80075EE");
      break label1146;
      label1468:
      j = 0;
      break label1167;
      label1474:
      localObject1 = "1";
      break label1201;
      label1482:
      if ((i != 0) && (GeneratePicArgs.a(4))) {
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b("person_gra", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { paramGenerateContext });
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.g())
    {
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    a().a(paramMotionEvent);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramAnimation);
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 1) {
      ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(6);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
    {
      paramItem = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      StoryReportor.a("video_edit", "add_place", 0, 0, new String[] { paramItem, "", str, "" });
      return;
      paramItem = "1";
      break;
    }
  }
  
  public void a(String paramString)
  {
    EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
    for (String str = "2";; str = "1")
    {
      localEditVideoPartManager.a("exp_editpoi", 0, 0, new String[] { str });
      VideoEditReport.a("0X80076CF");
      VideoEditReport.b("0X80075E4");
      paramString = new EditVideoDoodle.LocationCallback(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback, paramString);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(3, paramString);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    default: 
      bool = false;
    case 4: 
    case 5: 
      return bool;
    case 1: 
    case 2: 
    case 3: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return a().a(paramMotionEvent);
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    }
    return null;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().b();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    QQToast.a(a(), "表情个数已达上限", 0).a();
  }
  
  public void b(int paramInt, Object paramObject)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(13)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(14)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(15)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(16)))
      {
        SLog.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(5);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(paramAnimation);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setCurrentItem(1);
  }
  
  public boolean c_()
  {
    if ((EditVideoPartManager.a(this.jdField_b_of_type_Int, 4)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()))))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(5);
      }
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(27);
          return true;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f != 27);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Oiw != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Oiw);
    }
    if (this.jdField_a_of_type_Oiv != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Oiv);
    }
    if (this.jdField_a_of_type_Oix != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Oix);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Oiy = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new oit(this), 200L);
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.g();
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle
 * JD-Core Version:    0.7.0.1
 */