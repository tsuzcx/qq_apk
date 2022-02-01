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
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bqid
  extends bqgi
  implements Handler.Callback, bqgu, brgz, HWDecodeListener
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LocalMediaInfo a;
  protected VideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  public List<bqif> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  final boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean;
  boolean f = false;
  
  public bqid(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
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
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, brgc parambrgc)
  {
    if ((paramBitmap == null) || (parambrgc == null)) {
      return null;
    }
    Object localObject = zqb.a(paramBitmap.getWidth(), paramBitmap.getHeight(), bdep.jdField_a_of_type_Int, bdep.jdField_b_of_type_Int);
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    int i = brfv.jdField_a_of_type_Int;
    if (k > i) {
      j = (int)(j * i / k);
    }
    for (;;)
    {
      j = bbgg.a(j);
      i = bbgg.a(i);
      parambrgc.a(j, i);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = bhmq.a(paramContext, bhmq.c(paramBitmap), 0.4F, 25.0F);
        parambrgc = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (!paramContext.isMutable()) {
            break label205;
          }
        }
        label205:
        for (parambrgc = paramContext;; parambrgc = paramContext.copy(paramContext.getConfig(), true))
        {
          localCanvas.setBitmap(parambrgc);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          parambrgc = paramContext;
          paramContext = zoc.a(zoc.a(parambrgc, j, i, true), paramBitmap);
          ((GaussianBlurFilter)localObject).destroy();
          return paramContext;
        }
      }
      paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      Canvas localCanvas = new Canvas();
      if (paramContext.isMutable()) {}
      for (parambrgc = paramContext;; parambrgc = paramContext.copy(paramContext.getConfig(), true))
      {
        localCanvas.setBitmap(parambrgc);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        parambrgc = paramContext;
        break;
      }
      i = k;
    }
  }
  
  private Bitmap a(@NonNull bqif parambqif, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = 180;
    Object localObject2 = bqif.a(parambqif);
    long l2 = this.jdField_a_of_type_Bqgk.c() / 1000000L;
    Object localObject1;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject1 = brgs.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        return null;
      }
      brgc localbrgc;
      label126:
      Object localObject3;
      if (zqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
      {
        i = 0;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = zps.a((Bitmap)localObject2, i);
        }
        localbrgc = new brgc();
        if (!this.jdField_d_of_type_Boolean) {
          break label500;
        }
        localObject1 = a(a(), (Bitmap)localObject1, localbrgc);
        localObject3 = boec.a(boec.jdField_c_of_type_Int);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((QQFilterRenderManager)localObject3).getBusinessOperation().hasAvOrSpecialEffect())
          {
            if (paramBoolean) {
              l1 = this.jdField_a_of_type_Bqgk.c();
            }
            localObject3 = localbrgc.a((Bitmap)localObject1, l1);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((!bqif.a(parambqif)) || (!brgb.a(bqif.a(parambqif)))) {
          break label635;
        }
        switch (bqif.a(parambqif))
        {
        default: 
          localObject1 = null;
          label251:
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localbrgc.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            yuk.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
          }
          break;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (bqif.b(parambqif))
        {
          localObject2 = localObject1;
          if (bqif.b(parambqif) != null)
          {
            brgg localbrgg = (brgg)brgb.a(106);
            localbrgg.a(bqif.b(parambqif));
            localbrgg.init();
            localObject2 = localbrgc.a((Bitmap)localObject1, localbrgg);
            yuk.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localbrgg.destroy();
            localObject2 = localObject1;
          }
        }
        if ((localObject3 != null) && (localObject3 != bqif.a(parambqif)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localbrgc.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = zps.a((Bitmap)localObject2, 360 - i);
        }
        localObject2 = localObject1;
        if (this.jdField_e_of_type_Boolean) {
          localObject2 = zps.a((Bitmap)localObject1, 90.0F);
        }
        if ((localObject2 != bqif.a(parambqif)) || (bqif.a(parambqif)) || (bqif.b(parambqif)))
        {
          return localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
            break;
          }
          i = 0;
          break;
          label500:
          if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
          {
            localObject2 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
            localObject1 = a(localbrgc, (Bitmap)localObject1, a(), a().getString(2131698447, new Object[] { localObject2 }));
            break label126;
          }
          localbrgc.a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
          break label126;
          localObject1 = brgb.a(7);
          break label251;
          localObject1 = brgb.a(4);
          break label251;
          localObject1 = brgb.a(6);
          break label251;
          localObject1 = brgb.a(5);
          break label251;
        }
        return parambqif.jdField_c_of_type_AndroidGraphicsBitmap;
        localObject1 = localObject2;
        continue;
        label635:
        localObject3 = null;
        localObject1 = localObject2;
      }
    }
  }
  
  public static Bitmap a(brgc parambrgc, Bitmap paramBitmap, Context paramContext, String paramString)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int j = (int)(k * 16.0F / 9.0F);
    int i = brfv.jdField_a_of_type_Int;
    if (j > i) {}
    for (j = (int)(k * i / j);; j = k)
    {
      j = bbgg.a(j);
      i = bbgg.a(i);
      parambrgc.a(j, i);
      parambrgc = new brgq(paramContext, paramString);
      parambrgc.a(k, m, j, i);
      paramContext = new GLImage();
      paramContext.loadTextureSync(paramBitmap);
      paramBitmap = GlUtil.captureFrame(parambrgc.a(paramContext.getTexture()), j, i);
      parambrgc.a();
      return paramBitmap;
      i = j;
    }
  }
  
  private void a(@NonNull bqif parambqif)
  {
    yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambqif.jdField_c_of_type_Int));
    if (parambqif.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bqif.a(parambqif), (int)bqif.b(parambqif));
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, anzj.a(2131704570));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambqif.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambqif.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambqif.jdField_a_of_type_JavaLangString, parambqif.jdField_b_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
      return 7;
    case 6: 
      return 6;
    case 5: 
      return 5;
    }
    return 4;
  }
  
  private void n()
  {
    int k;
    int j;
    float f1;
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_Bqgk.a() != null) && (!this.jdField_a_of_type_Bqgk.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f1 = j / i;
      j = bdep.jdField_a_of_type_Int;
      i = bdep.jdField_b_of_type_Int;
      if (bdep.a(a())) {
        break label333;
      }
    }
    label333:
    for (int i = bdep.c(a());; i = bdep.jdField_b_of_type_Int)
    {
      k = (int)(j / f1);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f1) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setLayoutParams(localLayoutParams);
      }
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size viewWidth ane viewHeight:" + j + " " + k);
      return;
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Bqgk.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bqif localbqif = (bqif)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbqif != null) {
        return bqif.a(localbqif);
      }
    }
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      bqif localbqif = (bqif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return bqif.b(localbqif) - bqif.a(localbqif);
    }
    yuk.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bqif)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    yuk.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List<? extends bqix> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    int j = -90;
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    boolean bool1;
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new brkg();
        brkf.a(this.jdField_a_of_type_JavaLangString, (brkg)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = localObject.a[0];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = localObject.a[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
      }
      bool1 = bqgk.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
      boolean bool2 = VideoEnvironment.b(7);
      yuk.d("Q.qqstory.record.HWEditImportVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label642;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131368199));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
        break label647;
      }
      this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      label334:
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_fit_center", false);
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if (this.jdField_d_of_type_Boolean) {
        if (!zqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          break label758;
        }
      }
    }
    label476:
    label746:
    label753:
    label758:
    for (int i = -90;; i = 0)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(i);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = (VideoStoryDataBean)this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        if ((localObject != null) && (((VideoStoryDataBean)localObject).isLandTakePicToVideo()))
        {
          bool1 = true;
          this.jdField_e_of_type_Boolean = bool1;
        }
      }
      else if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
      {
        if (!zqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          break label753;
        }
      }
      for (i = j;; i = 0)
      {
        localObject = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(a().getString(2131698447, new Object[] { localObject }), i);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bqie(this));
        a(bqgu.class, this);
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditImportVideoPlayer.2(this), 200L);
        return;
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
        bool1 = false;
        break;
        if (((this.jdField_a_of_type_Bqgk.a() != null) && (this.jdField_a_of_type_Bqgk.a().isLandTakePicToVideo())) || (!zqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        }
        for (;;)
        {
          if (!zqb.a()) {
            break label746;
          }
          n();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
            this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(180);
          }
        }
        break label334;
        bool1 = false;
        break label476;
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
    bqif localbqif;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbqif = (bqif)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbqif.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_e_of_type_Int = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.f)
      {
        this.jdField_a_of_type_Bqgk.B();
        this.f = false;
      }
      return;
      yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
      a(localbqif);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    if ((f1 == 0.0F) || (f1 > 0.95F))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1));
      a(paramInt1);
      yuk.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f1, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f1, 0);
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject;
    if (i > 1) {
      if (paramInt < i)
      {
        localObject = (bqif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambqua.a.hasFragments = true;
        parambqua.a.videoNeedRotate = false;
        parambqua.a.videoRangeStart = ((int)bqif.a((bqif)localObject));
        parambqua.a.videoRangeEnd = ((int)bqif.b((bqif)localObject));
        yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : %s", localObject);
      }
    }
    for (;;)
    {
      parambqua.a.putExtra("local_import", Boolean.valueOf(true));
      parambqua.a.putExtra("video_rotation", Integer.valueOf(this.jdField_d_of_type_Int));
      boolean bool = zqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambqua.a.putExtra("landscape_video", Boolean.valueOf(bool));
      parambqua.a.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.jdField_d_of_type_Boolean));
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
      {
        localObject = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
        parambqua.a.putExtra("video_forward_watermark", a().getString(2131698447, new Object[] { localObject }));
        parambqua.a.putExtra("is_video_forward", Boolean.valueOf(true));
      }
      return;
      yuk.d("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      if (i == 1)
      {
        localObject = (bqif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambqua.a.videoNeedRotate = false;
        parambqua.a.videoRangeStart = this.jdField_b_of_type_Int;
        parambqua.a.videoRangeEnd = this.jdField_c_of_type_Int;
        parambqua.a.hwEncodeRecordVideo = true;
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Bqgk.a();
    bqif localbqif;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbqif = (bqif)this.jdField_a_of_type_JavaUtilList.get(i);
      bqif.a(localbqif, paramBitmap);
      if ((!bqif.b(localbqif)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bqif.a(localbqif, paramBoolean);
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
    int i = this.jdField_a_of_type_Bqgk.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bqif.b((bqif)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.h();
        this.f = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
        localbqch = (bqch)a(bqch.class);
        if (localbqch != null) {
          localbqch.d();
        }
      }
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
    bqch localbqch = (bqch)a(bqch.class);
    if (localbqch != null) {
      localbqch.ab_();
    }
    this.f = true;
  }
  
  public boolean a(long paramLong)
  {
    return false;
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
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label180;
      }
      paramMessage = (bqif)this.jdField_a_of_type_JavaUtilList.get(i);
      yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(bqif.a(paramMessage)));
      a(bqif.a(paramMessage));
      a(paramMessage);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label180:
      yuk.e("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void aU_()
  {
    super.aU_();
  }
  
  public void aY_()
  {
    super.aY_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.f);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
    return;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
  }
  
  public void b(int paramInt)
  {
    yuk.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Bqgk.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bqif localbqif = (bqif)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bqif.a(localbqif) != paramInt)
      {
        bqif.a(localbqif, paramInt);
        bqif.c(localbqif, true);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_e_of_type_Int = 1;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.jdField_e_of_type_Int != 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
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
    if ((bpty.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Bqgk.g();
      float f1 = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (yup.a((int)f1, 0L, 30L)) {
        yup.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f1), yup.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (bqif)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
        a(new HWEditImportVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void j()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  public void k()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Int == 42) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoFilterPlayView.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      this.jdField_e_of_type_Int = 2;
      return;
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
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
    this.jdField_a_of_type_Bqgk.a(paramLong2);
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
  
  public void y_()
  {
    super.y_();
    if (this.f)
    {
      this.jdField_a_of_type_Bqgk.B();
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqid
 * JD-Core Version:    0.7.0.1
 */