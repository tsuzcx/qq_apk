import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bous
  extends botu
  implements Handler.Callback, boud, bpqi, HWDecodeListener
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LocalMediaInfo a;
  protected VideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  public List<bouu> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  final boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  
  public bous(@NonNull botw parambotw)
  {
    super(parambotw);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 1: 
      return 5;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 8: 
      return 3;
    }
    return 4;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, bppu parambppu)
  {
    if ((paramBitmap == null) || (parambppu == null)) {
      return null;
    }
    Object localObject = zfl.a(paramBitmap.getWidth(), paramBitmap.getHeight(), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    int i = bppn.jdField_a_of_type_Int;
    if (k > i) {
      j = (int)(j * i / k);
    }
    for (;;)
    {
      j = bbhm.a(j);
      i = bbhm.a(i);
      parambppu.a(j, i);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = bheg.a(paramContext, bheg.c(paramBitmap), 0.4F, 25.0F);
        parambppu = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (!paramContext.isMutable()) {
            break label205;
          }
        }
        label205:
        for (parambppu = paramContext;; parambppu = paramContext.copy(paramContext.getConfig(), true))
        {
          localCanvas.setBitmap(parambppu);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          parambppu = paramContext;
          paramContext = zdr.a(zdr.a(parambppu, j, i, true), paramBitmap);
          ((GaussianBlurFilter)localObject).destroy();
          return paramContext;
        }
      }
      paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      Canvas localCanvas = new Canvas();
      if (paramContext.isMutable()) {}
      for (parambppu = paramContext;; parambppu = paramContext.copy(paramContext.getConfig(), true))
      {
        localCanvas.setBitmap(parambppu);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        parambppu = paramContext;
        break;
      }
      i = k;
    }
  }
  
  private Bitmap a(@NonNull bouu parambouu, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = 180;
    Object localObject2 = bouu.a(parambouu);
    long l2 = this.jdField_a_of_type_Botw.b() / 1000000L;
    Object localObject1;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject1 = bpqb.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        localObject2 = null;
        return localObject2;
      }
      label84:
      bppu localbppu;
      if (zfl.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
      {
        i = 0;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.rotateBitmap((Bitmap)localObject2, i);
        }
        localbppu = new bppu();
        if (!this.jdField_c_of_type_Boolean) {
          break label406;
        }
        localObject1 = a(a(), (Bitmap)localObject1, localbppu);
        label130:
        localObject2 = bmvb.a(bmvb.jdField_c_of_type_Int);
        if ((localObject2 == null) || (!((QQFilterRenderManager)localObject2).getBusinessOperation().hasAvOrSpecialEffect())) {
          break label424;
        }
        if (paramBoolean) {
          l1 = this.jdField_a_of_type_Botw.b();
        }
        localObject2 = localbppu.a((Bitmap)localObject1, l1);
        if (localObject2 == null) {
          break label424;
        }
        localObject1 = localObject2;
      }
      label406:
      label424:
      for (;;)
      {
        localObject2 = localObject1;
        if (bouu.a(parambouu))
        {
          localObject2 = localObject1;
          if (bouu.b(parambouu) != null)
          {
            bppw localbppw = (bppw)bppt.a(106);
            localbppw.a(bouu.b(parambouu));
            localbppw.init();
            localObject2 = localbppu.a((Bitmap)localObject1, localbppw);
            ykq.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localbppw.destroy();
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
        if ((0 != 0) && (bouu.a(parambouu) != null) && (localObject1 != null)) {
          throw new NullPointerException();
        }
        localbppu.a();
        localObject2 = localObject1;
        if (i != 0) {
          localObject2 = UIUtils.rotateBitmap((Bitmap)localObject1, 360 - i);
        }
        localObject1 = localObject2;
        if (this.jdField_d_of_type_Boolean) {
          localObject1 = UIUtils.rotateBitmap((Bitmap)localObject2, 90.0F);
        }
        localObject2 = localObject1;
        if (localObject1 != bouu.a(parambouu)) {
          break;
        }
        localObject2 = localObject1;
        if (bouu.b(parambouu)) {
          break;
        }
        localObject2 = localObject1;
        if (bouu.a(parambouu)) {
          break;
        }
        return parambouu.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
          break label84;
        }
        i = 0;
        break label84;
        localbppu.a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        break label130;
      }
    }
  }
  
  private void a(@NonNull bouu parambouu)
  {
    ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambouu.jdField_c_of_type_Int));
    if (parambouu.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bouu.a(parambouu), (int)bouu.b(parambouu));
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.d(3, anvx.a(2131705151));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambouu.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambouu.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambouu.jdField_a_of_type_JavaLangString, parambouu.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.d(3, "");
      }
    }
  }
  
  private int b(int paramInt)
  {
    return 0;
  }
  
  private void d()
  {
    int k;
    int j;
    float f;
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_Botw.a() != null) && (!this.jdField_a_of_type_Botw.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f = j / i;
      j = ScreenUtil.SCREEN_WIDTH;
      i = ScreenUtil.SCREEN_HIGHT;
      if (ScreenUtil.checkDeviceHasNavigationBar(a())) {
        break label333;
      }
    }
    label333:
    for (int i = ScreenUtil.getRealHeight(a());; i = ScreenUtil.SCREEN_HIGHT)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setLayoutParams(localLayoutParams);
      }
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size viewWidth ane viewHeight:" + j + " " + k);
      return;
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bouu)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    ykq.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new bptj();
        bpti.a(this.jdField_a_of_type_JavaLangString, (bptj)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = localObject.a[0];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = localObject.a[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131368368));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
        break label486;
      }
      this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_fit_center", false);
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if (this.jdField_c_of_type_Boolean) {
        if (!zfl.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          break label592;
        }
      }
    }
    label585:
    label587:
    label592:
    for (int i = -90;; i = 0)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(i);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = (VideoStoryDataBean)this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        if ((localObject == null) || (!((VideoStoryDataBean)localObject).isLandTakePicToVideo())) {
          break label587;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_d_of_type_Boolean = bool;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bout(this));
        a(boud.class, this);
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditImportVideoPlayer.2(this), 200L);
        return;
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
        label486:
        if (((this.jdField_a_of_type_Botw.a() != null) && (this.jdField_a_of_type_Botw.a().isLandTakePicToVideo())) || (!zfl.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        }
        for (;;)
        {
          if (!zfl.a()) {
            break label585;
          }
          d();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
            this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(180);
          }
        }
        break;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVolume(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = a(paramInt);
    bouu localbouu;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbouu = (bouu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbouu.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_e_of_type_Int = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_Botw.y();
        this.jdField_e_of_type_Boolean = false;
      }
      return;
      ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
      a(localbouu);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1));
      a(paramInt1);
      ykq.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    bouu localbouu;
    if (i > 1) {
      if (paramInt < i)
      {
        localbouu = (bouu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambpel.a.hasFragments = true;
        parambpel.a.videoNeedRotate = false;
        parambpel.a.videoRangeStart = ((int)bouu.a(localbouu));
        parambpel.a.videoRangeEnd = ((int)bouu.b(localbouu));
        ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : %s", localbouu);
      }
    }
    for (;;)
    {
      parambpel.a.putExtra("local_import", Boolean.valueOf(true));
      parambpel.a.putExtra("video_rotation", Integer.valueOf(this.jdField_d_of_type_Int));
      boolean bool = zfl.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambpel.a.putExtra("landscape_video", Boolean.valueOf(bool));
      parambpel.a.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.jdField_c_of_type_Boolean));
      return;
      ykq.d("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      if (i == 1)
      {
        localbouu = (bouu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambpel.a.videoNeedRotate = false;
        parambpel.a.videoRangeStart = this.jdField_b_of_type_Int;
        parambpel.a.videoRangeEnd = this.jdField_c_of_type_Int;
        parambpel.a.hwEncodeRecordVideo = true;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Botw.a();
    bouu localbouu;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbouu = (bouu)this.jdField_a_of_type_JavaUtilList.get(i);
      bouu.a(localbouu, paramBitmap);
      if ((!bouu.a(localbouu)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bouu.a(localbouu, paramBoolean);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public void a(TransferData paramTransferData)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTransferData(paramTransferData);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (paramLong != 0L) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Botw.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bouu.b((bouu)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.h();
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
        localbosc = (bosc)a(bosc.class);
        if (localbosc != null) {
          localbosc.d();
        }
      }
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
    bosc localbosc = (bosc)a(bosc.class);
    if (localbosc != null) {
      localbosc.c();
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      case 3: 
      default: 
      case 1: 
        do
        {
          return true;
        } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_e_of_type_Int = 1;
        return true;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
      this.jdField_e_of_type_Int = 0;
      return true;
    }
    return false;
  }
  
  public void aG_()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
  }
  
  public void aH_()
  {
    super.aH_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void aI_()
  {
    super.aI_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.jdField_e_of_type_Int != 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
  }
  
  public void aL_()
  {
    super.aL_();
  }
  
  public void b()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_e_of_type_Int = 1;
  }
  
  public void b(int paramInt)
  {
    ykq.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Botw.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bouu localbouu = (bouu)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bouu.a(localbouu) != paramInt)
      {
        bouu.a(localbouu, paramInt);
        bouu.c(localbouu, true);
      }
    }
  }
  
  public void c()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  public void g()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.g();
    if ((bomw.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Botw.f();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (ykv.a((int)f, 0L, 30L)) {
        ykv.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), ykv.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (bouu)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
        a(new HWEditImportVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Botw.y();
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditImportVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Botw.a(paramLong2);
    a(new HWEditImportVideoPlayer.5(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    a(new HWEditImportVideoPlayer.6(this), 0L);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    a(new HWEditImportVideoPlayer.4(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bous
 * JD-Core Version:    0.7.0.1
 */