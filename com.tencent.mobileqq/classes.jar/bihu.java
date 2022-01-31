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

public class bihu
  extends bifz
  implements Handler.Callback, bigl, bjhw, HWDecodeListener
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LocalMediaInfo a;
  protected VideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  public List<bihw> a;
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
  
  public bihu(@NonNull bigb parambigb)
  {
    super(parambigb);
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
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, bjgz parambjgz)
  {
    if ((paramBitmap == null) || (parambjgz == null)) {
      return null;
    }
    Object localObject = vnb.a(paramBitmap.getWidth(), paramBitmap.getHeight(), awmc.jdField_a_of_type_Int, awmc.jdField_b_of_type_Int);
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    int i = bjgs.jdField_a_of_type_Int;
    if (k > i) {
      j = (int)(j * i / k);
    }
    for (;;)
    {
      j = autt.a(j);
      i = autt.a(i);
      parambjgz.a(j, i);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = bacm.a(paramContext, bacm.c(paramBitmap), 0.4F, 25.0F);
        parambjgz = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (!paramContext.isMutable()) {
            break label205;
          }
        }
        label205:
        for (parambjgz = paramContext;; parambjgz = paramContext.copy(paramContext.getConfig(), true))
        {
          localCanvas.setBitmap(parambjgz);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          parambjgz = paramContext;
          paramContext = vlc.a(vlc.a(parambjgz, j, i, true), paramBitmap);
          ((GaussianBlurFilter)localObject).destroy();
          return paramContext;
        }
      }
      paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      Canvas localCanvas = new Canvas();
      if (paramContext.isMutable()) {}
      for (parambjgz = paramContext;; parambjgz = paramContext.copy(paramContext.getConfig(), true))
      {
        localCanvas.setBitmap(parambjgz);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        parambjgz = paramContext;
        break;
      }
      i = k;
    }
  }
  
  private Bitmap a(@NonNull bihw parambihw, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = 180;
    Object localObject2 = bihw.a(parambihw);
    long l2 = this.jdField_a_of_type_Bigb.c() / 1000000L;
    Object localObject1;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject1 = bjhp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        return null;
      }
      bjgz localbjgz;
      label126:
      Object localObject3;
      if (vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
      {
        i = 0;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = vms.a((Bitmap)localObject2, i);
        }
        localbjgz = new bjgz();
        if (!this.jdField_d_of_type_Boolean) {
          break label500;
        }
        localObject1 = a(a(), (Bitmap)localObject1, localbjgz);
        localObject3 = bhey.a(bhey.jdField_c_of_type_Int);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((QQFilterRenderManager)localObject3).getBusinessOperation().hasAvOrSpecialEffect())
          {
            if (paramBoolean) {
              l1 = this.jdField_a_of_type_Bigb.c();
            }
            localObject3 = localbjgz.a((Bitmap)localObject1, l1);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((!bihw.a(parambihw)) || (!bjgy.a(bihw.a(parambihw)))) {
          break label635;
        }
        switch (bihw.a(parambihw))
        {
        default: 
          localObject1 = null;
          label251:
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localbjgz.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            urk.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
        if (bihw.b(parambihw))
        {
          localObject2 = localObject1;
          if (bihw.b(parambihw) != null)
          {
            bjhd localbjhd = (bjhd)bjgy.a(106);
            localbjhd.a(bihw.b(parambihw));
            localbjhd.init();
            localObject2 = localbjgz.a((Bitmap)localObject1, localbjhd);
            urk.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localbjhd.destroy();
            localObject2 = localObject1;
          }
        }
        if ((localObject3 != null) && (localObject3 != bihw.a(parambihw)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localbjgz.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = vms.a((Bitmap)localObject2, 360 - i);
        }
        localObject2 = localObject1;
        if (this.jdField_e_of_type_Boolean) {
          localObject2 = vms.a((Bitmap)localObject1, 90.0F);
        }
        if ((localObject2 != bihw.a(parambihw)) || (bihw.a(parambihw)) || (bihw.b(parambihw)))
        {
          return localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
            break;
          }
          i = 0;
          break;
          label500:
          if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
          {
            localObject2 = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
            localObject1 = a(localbjgz, (Bitmap)localObject1, a(), a().getString(2131633733, new Object[] { localObject2 }));
            break label126;
          }
          localbjgz.a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
          break label126;
          localObject1 = bjgy.a(7);
          break label251;
          localObject1 = bjgy.a(4);
          break label251;
          localObject1 = bjgy.a(6);
          break label251;
          localObject1 = bjgy.a(5);
          break label251;
        }
        return parambihw.jdField_c_of_type_AndroidGraphicsBitmap;
        localObject1 = localObject2;
        continue;
        label635:
        localObject3 = null;
        localObject1 = localObject2;
      }
    }
  }
  
  public static Bitmap a(bjgz parambjgz, Bitmap paramBitmap, Context paramContext, String paramString)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int j = (int)(k * 16.0F / 9.0F);
    int i = bjgs.jdField_a_of_type_Int;
    if (j > i) {}
    for (j = (int)(k * i / j);; j = k)
    {
      j = autt.a(j);
      i = autt.a(i);
      parambjgz.a(j, i);
      parambjgz = new bjhn(paramContext, paramString);
      parambjgz.a(k, m, j, i);
      paramContext = new GLImage();
      paramContext.loadTextureSync(paramBitmap);
      paramBitmap = GlUtil.captureFrame(parambjgz.a(paramContext.getTexture()), j, i);
      parambjgz.a();
      return paramBitmap;
      i = j;
    }
  }
  
  private void a(@NonNull bihw parambihw)
  {
    urk.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambihw.jdField_c_of_type_Int));
    if (parambihw.jdField_a_of_type_JavaLangString == null)
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
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bihw.a(parambihw), (int)bihw.b(parambihw));
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, ajjy.a(2131639882));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambihw.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambihw.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambihw.jdField_a_of_type_JavaLangString, parambihw.jdField_b_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_Bigb.a() != null) && (!this.jdField_a_of_type_Bigb.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f1 = j / i;
      j = awmc.jdField_a_of_type_Int;
      i = awmc.jdField_b_of_type_Int;
      if (awmc.a(a())) {
        break label333;
      }
    }
    label333:
    for (int i = awmc.c(a());; i = awmc.jdField_b_of_type_Int)
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
  
  public void B_()
  {
    super.B_();
    if (this.f)
    {
      this.jdField_a_of_type_Bigb.B();
      this.f = false;
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihw localbihw = (bihw)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbihw != null) {
        return bihw.a(localbihw);
      }
    }
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihw localbihw = (bihw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return bihw.b(localbihw) - bihw.a(localbihw);
    }
    urk.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bihw)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    urk.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List<? extends biio> a()
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
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new bjli();
        bjlh.a(this.jdField_a_of_type_JavaLangString, (bjli)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = localObject.a[0];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = localObject.a[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
      }
      bool1 = bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
      boolean bool2 = VideoEnvironment.b(7);
      urk.d("Q.qqstory.record.HWEditImportVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label642;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131302051));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
        break label647;
      }
      this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      label334:
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_fit_center", false);
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if (this.jdField_d_of_type_Boolean) {
        if (!vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
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
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = (VideoStoryDataBean)this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        if ((localObject != null) && (((VideoStoryDataBean)localObject).isLandTakePicToVideo()))
        {
          bool1 = true;
          this.jdField_e_of_type_Boolean = bool1;
        }
      }
      else if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
      {
        if (!vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          break label753;
        }
      }
      for (i = j;; i = 0)
      {
        localObject = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(a().getString(2131633733, new Object[] { localObject }), i);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bihv(this));
        a(bigl.class, this);
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditImportVideoPlayer.2(this), 200L);
        return;
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
        bool1 = false;
        break;
        if (((this.jdField_a_of_type_Bigb.a() != null) && (this.jdField_a_of_type_Bigb.a().isLandTakePicToVideo())) || (!vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        }
        for (;;)
        {
          if (!vnb.a()) {
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
    bihw localbihw;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbihw = (bihw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbihw.jdField_a_of_type_JavaLangString == null)
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
        this.jdField_a_of_type_Bigb.B();
        this.f = false;
      }
      return;
      urk.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
      a(localbihw);
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
      urk.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f1, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f1, 0);
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject;
    if (i > 1) {
      if (paramInt < i)
      {
        localObject = (bihw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambitz.a.hasFragments = true;
        parambitz.a.videoNeedRotate = false;
        parambitz.a.videoRangeStart = ((int)bihw.a((bihw)localObject));
        parambitz.a.videoRangeEnd = ((int)bihw.b((bihw)localObject));
        urk.b("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : %s", localObject);
      }
    }
    for (;;)
    {
      parambitz.a.putExtra("local_import", Boolean.valueOf(true));
      parambitz.a.putExtra("video_rotation", Integer.valueOf(this.jdField_d_of_type_Int));
      boolean bool = vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambitz.a.putExtra("landscape_video", Boolean.valueOf(bool));
      parambitz.a.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.jdField_d_of_type_Boolean));
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
      {
        localObject = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("vip_forward_name");
        parambitz.a.putExtra("video_forward_watermark", a().getString(2131633733, new Object[] { localObject }));
        parambitz.a.putExtra("is_video_forward", Boolean.valueOf(true));
      }
      return;
      urk.d("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      if (i == 1)
      {
        localObject = (bihw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambitz.a.videoNeedRotate = false;
        parambitz.a.videoRangeStart = this.jdField_b_of_type_Int;
        parambitz.a.videoRangeEnd = this.jdField_c_of_type_Int;
        parambitz.a.hwEncodeRecordVideo = true;
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
    int i = this.jdField_a_of_type_Bigb.a();
    bihw localbihw;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbihw = (bihw)this.jdField_a_of_type_JavaUtilList.get(i);
      bihw.a(localbihw, paramBitmap);
      if ((!bihw.b(localbihw)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bihw.a(localbihw, paramBoolean);
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
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bihw.b((bihw)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
        localbibw = (bibw)a(bibw.class);
        if (localbibw != null) {
          localbibw.d();
        }
      }
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
    bibw localbibw = (bibw)a(bibw.class);
    if (localbibw != null) {
      localbibw.ae_();
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
      paramMessage = (bihw)this.jdField_a_of_type_JavaUtilList.get(i);
      urk.b("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(bihw.a(paramMessage)));
      a(bihw.a(paramMessage));
      a(paramMessage);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label180:
      urk.e("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
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
    urk.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihw localbihw = (bihw)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bihw.a(localbihw) != paramInt)
      {
        bihw.a(localbihw, paramInt);
        bihw.c(localbihw, true);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void bb_()
  {
    super.bb_();
  }
  
  public void bf_()
  {
    super.bf_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
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
    if ((bhnt.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Bigb.g();
      float f1 = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (urp.a((int)f1, 0L, 30L)) {
        urp.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f1), urp.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (bihw)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        urk.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
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
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Int == 42) {}
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
    this.jdField_a_of_type_Bigb.a(paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihu
 * JD-Core Version:    0.7.0.1
 */