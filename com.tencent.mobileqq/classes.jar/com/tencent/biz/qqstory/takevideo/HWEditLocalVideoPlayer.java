package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ofj;
import ofk;
import ofm;
import ofn;
import ofo;
import ofp;
import ofq;

public class HWEditLocalVideoPlayer
  extends EditVideoPart
  implements Handler.Callback, EditVideoPlayerExport, HWDecodeListener
{
  public int a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LocalMediaInfo a;
  protected NeoVideoFilterPlayView a;
  private Mp4ReEncoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private ofq jdField_a_of_type_Ofq;
  public boolean a;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  public final boolean b;
  private boolean c = true;
  private boolean d;
  
  public HWEditLocalVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = Constants.jdField_b_of_type_Boolean;
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
  
  private Bitmap a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    Object localObject3 = null;
    Object localObject1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo);
    if (localObject1 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    Object localObject2 = localObject1;
    if (i != 0) {
      localObject2 = UIUtils.a((Bitmap)localObject1, 360 - i);
    }
    GPUBitmapImageRender localGPUBitmapImageRender = new GPUBitmapImageRender();
    localGPUBitmapImageRender.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
    Object localObject4 = localObject3;
    if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
    {
      localObject4 = localObject3;
      if (FilterFactory.a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))) {
        switch (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
        {
        default: 
          localObject1 = null;
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).a();
            localObject3 = localGPUBitmapImageRender.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).c();
            SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo))
      {
        localObject2 = localObject1;
        if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo) != null)
        {
          localObject4 = (GPUImagePixelationFilter)FilterFactory.a(106);
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10) {
            break label372;
          }
          ((GPUImagePixelationFilter)localObject4).a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo), i);
        }
      }
      for (;;)
      {
        ((GPUImagePixelationFilter)localObject4).a();
        localObject2 = localGPUBitmapImageRender.a((Bitmap)localObject1, (GPUBaseFilter)localObject4);
        SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((GPUImagePixelationFilter)localObject4).c();
        localObject2 = localObject1;
        if ((localObject3 != null) && (localObject3 != HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localGPUBitmapImageRender.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.a((Bitmap)localObject2, i);
        }
        if ((localObject1 == HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) && (!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) && (!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo))) {
          break label384;
        }
        return localObject1;
        localObject1 = FilterFactory.a(7);
        break;
        localObject1 = FilterFactory.a(4);
        break;
        localObject1 = FilterFactory.a(6);
        break;
        localObject1 = FilterFactory.a(5);
        break;
        label372:
        ((GPUImagePixelationFilter)localObject4).a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      }
      label384:
      return paramMp4VideoFragmentInfo.jdField_c_of_type_AndroidGraphicsBitmap;
      localObject1 = localObject2;
      localObject3 = localObject4;
    }
  }
  
  private ofq a(int paramInt)
  {
    if ((Build.MODEL.equalsIgnoreCase("MX5")) || (Build.MODEL.contains("vivo X5")) || (Build.MODEL.equalsIgnoreCase("M2 Note")) || (Build.MODEL.equalsIgnoreCase("m1 metal")) || (Build.MODEL.equalsIgnoreCase("HLA Note3")) || (Build.MODEL.equalsIgnoreCase("OPPO R7")) || (Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new ofq(this, 3, 1, paramInt);
    }
    return new ofq(this, 30, 0, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable skip");
      return;
    }
    if (this.jdField_a_of_type_Ofq == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_Ofq = a(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Ofq, 300L);
        }
      }
      if (this.jdField_a_of_type_Ofq == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)((Iterator)localObject).next();
          if ((!localMp4VideoFragmentInfo.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_Ofq = a(localMp4VideoFragmentInfo.jdField_c_of_type_Int);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Ofq, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_Ofq == null)
      {
        SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Ofq.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ofq.b), Integer.valueOf(this.jdField_a_of_type_Ofq.jdField_c_of_type_Int));
      return;
    }
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_Ofq.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ofq.b), Integer.valueOf(this.jdField_a_of_type_Ofq.jdField_c_of_type_Int));
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        n();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setDimAmount(0.0F);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog error " + paramContext.getMessage());
      }
    }
  }
  
  private void a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramMp4VideoFragmentInfo.jdField_c_of_type_Int));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramMp4VideoFragmentInfo.jdField_c_of_type_Int;
      return;
      if (paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.g();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "正在处理中...");
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.g();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString, paramMp4VideoFragmentInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.i();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        if (localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(3);
          break;
          SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
          a(localMp4VideoFragmentInfo);
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoButton.a(true);
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoButton.a(false);
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoButton.a(true);
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
  
  public void H_()
  {
    super.H_();
    this.c = true;
    a(0);
  }
  
  public void I_()
  {
    super.I_();
    this.c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder.c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder = null;
    }
    if (this.jdField_a_of_type_Ofq != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ofq);
      this.jdField_a_of_type_Ofq = null;
    }
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo) - HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo);
    }
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      bool1 = EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768);
      boolean bool2 = VideoEnvironment.b(7);
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label379;
      }
    }
    label379:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView = ((NeoVideoFilterPlayView)a(2131364384));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)
      {
        int i = VideoUtils.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRotate(i);
        if ((i == 90) || (i == 270))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getLayoutParams();
          EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(DeviceInfoUtil.l() * localEditTakeVideoSource.a() / localEditTakeVideoSource.b()));
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setDecodeListener(this);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayListener(new ofj(this));
      }
      a(EditVideoPlayerExport.class, this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoButton.a(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ofk(this), 200L);
      return;
      throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1));
      c(paramInt1);
      SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.j();
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "onActivityResult mHaveDanceRankShowed=false");
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    int i;
    HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder.c();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo));
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo));
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString;
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localMp4VideoFragmentInfo);
    }
    for (;;)
    {
      boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (paramInt < i)
      {
        localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString;
      }
      else
      {
        SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", new Throwable(), "fragment index %d invalid, fragment count %d, again count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
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
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(long paramLong)
  {
    int i = 1;
    EditVideoParams localEditVideoParams;
    Object localObject;
    int j;
    String str;
    int k;
    Intent localIntent;
    if (!this.d)
    {
      this.d = true;
      if (!MediaCodecDPC.j()) {
        return;
      }
      localEditVideoParams = (EditVideoParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((localEditVideoParams != null) && (NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity())))
      {
        localObject = localEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        int m = ((Bundle)localObject).getInt("ptv_template_kind", -999);
        j = ((Bundle)localObject).getInt("dance_machine_session_type", -999);
        str = ((Bundle)localObject).getString("dance_machine_session_uin", "");
        k = ((Bundle)localObject).getInt("dance_machine_score", 0);
        if (m == 3)
        {
          boolean bool = DanceGameVideoManager.a().b();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().runOnUiThread(new ofo(this));
          localObject = "";
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            localObject = ((EditTakeVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_b_of_type_JavaLangString;
          }
          localIntent = new Intent();
          localIntent.putExtra("KEY_AUDIO_FILE_PATH", (String)localObject);
          localIntent.putExtra("KEY_VIDEO_FILE_PATH", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          localIntent.putExtra(EditVideoParams.class.getName(), localEditVideoParams);
          localIntent.putExtra("KEY_AUDIO_CHANNEL", CodecParam.o);
          localIntent.putExtra("KEY_BITRATE", CodecParam.n);
          localIntent.putExtra("KEY_AUDIO_FORMAT", CodecParam.p);
          localIntent.putExtra("KEY_SAMPLE_RATE", CodecParam.q);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("DIDI", 1, "enter Rank mHaveDanceRankShowed=true");
          }
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
          if (!bool) {
            break label391;
          }
        }
      }
    }
    for (;;)
    {
      DanceMachineQQBrowserActivity.a((Activity)localObject, j, str, i, localEditVideoParams.jdField_a_of_type_Int, 0, k, localIntent);
      localObject = (EditSubtitleExport)a(EditSubtitleExport.class);
      if (localObject == null) {
        break;
      }
      ((EditSubtitleExport)localObject).a(paramLong / 1000000L);
      return;
      label391:
      i = 0;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
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
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.g();
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
      paramMessage = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMessage)));
      c(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMessage));
      a(paramMessage);
      a(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label167:
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void b(long paramLong) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putBoolean("IS_FIRST_FRAME_DECODED", this.d);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.g();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ofn(this), 200L);
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onResume();
    n();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onPause();
  }
  
  public void h() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        this.jdField_a_of_type_AndroidOsHandler.post(new ofm(this, i));
      }
    }
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
  }
  
  public void k() {}
  
  public void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ofp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */