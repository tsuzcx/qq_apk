package com.tencent.biz.qqstory.takevideo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import anvx;
import bblb;
import bbld;
import bbmq;
import bbni;
import bbnj;
import bbnn;
import bddt;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ykq;
import ymb;
import ymj;
import ynu;
import ynw;
import yoi;
import ypk;
import ypn;
import yqa;
import yya;
import zfl;

public class HWEditLocalVideoPlayer
  extends ynu
  implements Handler.Callback, bblb, yoi
{
  protected int a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbmq jdField_a_of_type_Bbmq;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected LocalMediaInfo a;
  public NeoVideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  protected List<ypn> a;
  protected boolean a;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  public final boolean b;
  private boolean c = true;
  private boolean d;
  
  public HWEditLocalVideoPlayer(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = bbld.jdField_b_of_type_Boolean;
    QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "HWEditLocalVideoPlayer. ENABLE_FLOW = " + this.jdField_b_of_type_Boolean);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  private Bitmap a(@NonNull ypn paramypn)
  {
    Object localObject3 = null;
    Object localObject1 = ypn.a(paramypn);
    if (localObject1 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    Object localObject2 = localObject1;
    if (i != 0) {
      localObject2 = UIUtils.rotateBitmap((Bitmap)localObject1, 360 - i);
    }
    bbnj localbbnj = new bbnj();
    localbbnj.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
    Object localObject4 = localObject3;
    if (ypn.a(paramypn))
    {
      localObject4 = localObject3;
      if (bbni.a(ypn.a(paramypn))) {
        switch (ypn.a(paramypn))
        {
        default: 
          localObject1 = null;
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localbbnj.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            ykq.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
            localObject4 = localObject3;
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (ypn.b(paramypn))
      {
        localObject2 = localObject1;
        if (ypn.b(paramypn) != null)
        {
          localObject4 = (bbnn)bbni.a(106);
          if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 10) && (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 12)) {
            break label387;
          }
          ((bbnn)localObject4).a(ypn.b(paramypn), i);
        }
      }
      for (;;)
      {
        ((bbnn)localObject4).init();
        localObject2 = localbbnj.a((Bitmap)localObject1, (GPUBaseFilter)localObject4);
        ykq.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((bbnn)localObject4).destroy();
        localObject2 = localObject1;
        if ((localObject3 != null) && (localObject3 != ypn.a(paramypn)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localbbnj.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.rotateBitmap((Bitmap)localObject2, i);
        }
        if ((localObject1 == ypn.a(paramypn)) && (!ypn.a(paramypn)) && (!ypn.b(paramypn))) {
          break label399;
        }
        return localObject1;
        localObject1 = bbni.a(7);
        break;
        localObject1 = bbni.a(4);
        break;
        localObject1 = bbni.a(6);
        break;
        localObject1 = bbni.a(5);
        break;
        label387:
        ((bbnn)localObject4).a(ypn.b(paramypn));
      }
      label399:
      return paramypn.jdField_c_of_type_AndroidGraphicsBitmap;
      localObject1 = localObject2;
      localObject3 = localObject4;
    }
  }
  
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable a(int paramInt)
  {
    if ((Build.MODEL.equalsIgnoreCase("MX5")) || (Build.MODEL.contains("vivo X5")) || (Build.MODEL.equalsIgnoreCase("M2 Note")) || (Build.MODEL.equalsIgnoreCase("m1 metal")) || (Build.MODEL.equalsIgnoreCase("HLA Note3")) || (Build.MODEL.equalsIgnoreCase("OPPO R7")) || (Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 3, 1, paramInt);
    }
    return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 30, 0, paramInt);
  }
  
  private void a(@NonNull ypn paramypn)
  {
    ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramypn.jdField_c_of_type_Int));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)ypn.a(paramypn), (int)ypn.b(paramypn));
      if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramypn.jdField_c_of_type_Int;
      return;
      if (paramypn.jdField_a_of_type_JavaLangString == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.f();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)ypn.a(paramypn), (int)ypn.b(paramypn));
        if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, anvx.a(2131705155));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(paramypn.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.f();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(paramypn.jdField_a_of_type_JavaLangString, paramypn.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
        }
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
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable skip");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (ypn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((ypn)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((ypn)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((ypn)localObject).jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ypn localypn = (ypn)((Iterator)localObject).next();
          if ((!localypn.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localypn.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localypn.jdField_c_of_type_Int);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        ykq.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
  }
  
  private void c(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
    }
    for (;;)
    {
      m();
      return;
      if ((paramInt == 3) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        ypn localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        if (localypn.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(3);
          break;
          ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
          a(localypn);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
    }
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Ynw.jdField_a_of_type_Ymj.a(true);
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((ypn.a((ypn)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((ypn)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Ynw.jdField_a_of_type_Ymj.a(false);
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_Ynw.jdField_a_of_type_Ymj.a(true);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void S_()
  {
    super.S_();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onResume();
    n();
  }
  
  public void T_()
  {
    super.T_();
    this.c = false;
    if (this.jdField_a_of_type_Bbmq != null)
    {
      this.jdField_a_of_type_Bbmq.a();
      this.jdField_a_of_type_Bbmq = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      ypn localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return ypn.b(localypn) - ypn.a(localypn);
    }
    ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((ypn)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List<? extends yqa> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      bool1 = ynw.a(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, 32768);
      boolean bool2 = VideoEnvironment.getAVCodecSurpportFeature(7);
      ykq.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label394;
      }
    }
    label394:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView = ((NeoVideoFilterPlayView)a(2131368368));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(0);
      if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 10) || (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 12))
      {
        int i = zfl.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRotate(i);
        if ((i == 90) || (i == 270))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getLayoutParams();
          EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(DeviceInfoUtil.getWidth() * localEditTakeVideoSource.getWidth() / localEditTakeVideoSource.getHeight()));
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setDecodeListener(this);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayListener(new ypk(this));
      }
      a(yoi.class, this);
      this.jdField_a_of_type_Ynw.jdField_a_of_type_Ymj.a(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
      return;
      throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
    }
  }
  
  public void a(int paramInt)
  {
    ykq.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Ynw.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ypn localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (ypn.a(localypn) != paramInt)
      {
        ypn.a(localypn, paramInt);
        ypn.c(localypn, true);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1));
      c(paramInt1);
      ykq.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.i();
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "onActivityResult mHaveDanceRankShowed=false");
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView == null) {
      return;
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    int i;
    ypn localypn;
    if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Bbmq != null)
      {
        this.jdField_a_of_type_Bbmq.a();
        this.jdField_a_of_type_Bbmq = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)ypn.a(localypn));
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)ypn.b(localypn));
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localypn.jdField_a_of_type_JavaLangString;
      ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localypn);
    }
    for (;;)
    {
      boolean bool = zfl.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      ykq.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (paramInt < i)
      {
        localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localypn.jdField_a_of_type_JavaLangString;
      }
      else
      {
        ykq.d("Q.qqstory.record.HWEditLocalVideoPlayer", new Throwable(), "fragment index %d invalid, fragment count %d, again count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(long paramLong)
  {
    if (!this.d)
    {
      this.d = true;
      if (bddt.i()) {}
    }
    ymb localymb;
    do
    {
      return;
      localymb = (ymb)a(ymb.class);
    } while (localymb == null);
    localymb.a(paramLong / 1000000L);
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Ynw.a();
    ypn localypn;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localypn = (ypn)this.jdField_a_of_type_JavaUtilList.get(i);
      ypn.a(localypn, paramBitmap);
      if ((!ypn.b(localypn)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ypn.a(localypn, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = paramBundle.getBoolean("IS_FIRST_FRAME_DECODED", false);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Ynw.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      ypn.b((ypn)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      case 3: 
      default: 
        return true;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.f();
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label167;
      }
      paramMessage = (ypn)this.jdField_a_of_type_JavaUtilList.get(i);
      ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(ypn.a(paramMessage)));
      c(ypn.a(paramMessage));
      a(paramMessage);
      b(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label167:
      ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void b(long paramLong) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putBoolean("IS_FIRST_FRAME_DECODED", this.d);
  }
  
  public void c()
  {
    super.c();
    this.c = true;
    b(0);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.f();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onPause();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.4(this), 200L);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (ypn)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        this.jdField_a_of_type_AndroidOsHandler.post(new HWEditLocalVideoPlayer.3(this, i));
      }
    }
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new HWEditLocalVideoPlayer.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */