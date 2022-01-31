package com.tencent.biz.qqstory.takevideo;

import ajya;
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
import avxp;
import avxr;
import avze;
import avzw;
import avzx;
import awab;
import axgo;
import axim;
import axkt;
import bbdh;
import bbfj;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ved;
import vfq;
import vfy;
import vhk;
import vhm;
import vhy;
import vix;
import vjb;
import vje;
import vjr;
import vsa;
import vzl;
import vzu;

public class HWEditLocalVideoPlayer
  extends vhk
  implements Handler.Callback, avxp, vhy
{
  protected int a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avze jdField_a_of_type_Avze;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected LocalMediaInfo a;
  public NeoVideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  protected List<vje> a;
  protected boolean a;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  public final boolean b;
  private boolean c = true;
  private boolean d;
  
  public HWEditLocalVideoPlayer(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = avxr.jdField_b_of_type_Boolean;
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
  
  private Bitmap a(@NonNull vje paramvje)
  {
    Object localObject3 = null;
    Object localObject1 = vje.a(paramvje);
    if (localObject1 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    Object localObject2 = localObject1;
    if (i != 0) {
      localObject2 = vzl.a((Bitmap)localObject1, 360 - i);
    }
    avzx localavzx = new avzx();
    localavzx.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
    Object localObject4 = localObject3;
    if (vje.a(paramvje))
    {
      localObject4 = localObject3;
      if (avzw.a(vje.a(paramvje))) {
        switch (vje.a(paramvje))
        {
        default: 
          localObject1 = null;
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localavzx.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            ved.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
      if (vje.b(paramvje))
      {
        localObject2 = localObject1;
        if (vje.b(paramvje) != null)
        {
          localObject4 = (awab)avzw.a(106);
          if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)) {
            break label387;
          }
          ((awab)localObject4).a(vje.b(paramvje), i);
        }
      }
      for (;;)
      {
        ((awab)localObject4).init();
        localObject2 = localavzx.a((Bitmap)localObject1, (GPUBaseFilter)localObject4);
        ved.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((awab)localObject4).destroy();
        localObject2 = localObject1;
        if ((localObject3 != null) && (localObject3 != vje.a(paramvje)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localavzx.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = vzl.a((Bitmap)localObject2, i);
        }
        if ((localObject1 == vje.a(paramvje)) && (!vje.a(paramvje)) && (!vje.b(paramvje))) {
          break label399;
        }
        return localObject1;
        localObject1 = avzw.a(7);
        break;
        localObject1 = avzw.a(4);
        break;
        localObject1 = avzw.a(6);
        break;
        localObject1 = avzw.a(5);
        break;
        label387:
        ((awab)localObject4).a(vje.b(paramvje));
      }
      label399:
      return paramvje.jdField_c_of_type_AndroidGraphicsBitmap;
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
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable skip");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (vje)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((vje)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((vje)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((vje)localObject).jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          vje localvje = (vje)((Iterator)localObject).next();
          if ((!localvje.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localvje.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localvje.jdField_c_of_type_Int);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        ved.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
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
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131755791);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setDimAmount(0.0F);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559386);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371557));
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
  
  private void a(@NonNull vje paramvje)
  {
    ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramvje.jdField_c_of_type_Int));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)vje.a(paramvje), (int)vje.b(paramvje));
      if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramvje.jdField_c_of_type_Int;
      return;
      if (paramvje.jdField_a_of_type_JavaLangString == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)vje.a(paramvje), (int)vje.b(paramvje));
        if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, ajya.a(2131705682));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(paramvje.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(paramvje.jdField_a_of_type_JavaLangString, paramvje.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.j();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
        vje localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        if (localvje.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(3);
          break;
          ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
          a(localvje);
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
      this.jdField_a_of_type_Vhm.jdField_a_of_type_Vfy.a(true);
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((vje.a((vje)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((vje)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Vhm.jdField_a_of_type_Vfy.a(false);
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_Vhm.jdField_a_of_type_Vfy.a(true);
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
  
  public void V_()
  {
    super.V_();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onResume();
    n();
  }
  
  public void X_()
  {
    super.X_();
    this.c = false;
    if (this.jdField_a_of_type_Avze != null)
    {
      this.jdField_a_of_type_Avze.c();
      this.jdField_a_of_type_Avze = null;
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
      vje localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return vje.b(localvje) - vje.a(localvje);
    }
    ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((vje)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List<? extends vjr> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      bool1 = vhm.a(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768);
      boolean bool2 = VideoEnvironment.b(7);
      ved.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label394;
      }
    }
    label394:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView = ((NeoVideoFilterPlayView)a(2131367669));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(0);
      if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12))
      {
        int i = vzu.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRotate(i);
        if ((i == 90) || (i == 270))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getLayoutParams();
          EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(bbdh.k() * localEditTakeVideoSource.a() / localEditTakeVideoSource.b()));
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setDecodeListener(this);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayListener(new vjb(this));
      }
      a(vhy.class, this);
      this.jdField_a_of_type_Vhm.jdField_a_of_type_Vfy.a(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
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
      ved.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.k();
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    int i;
    vje localvje;
    if ((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Avze != null)
      {
        this.jdField_a_of_type_Avze.c();
        this.jdField_a_of_type_Avze = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)vje.a(localvje));
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)vje.b(localvje));
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localvje.jdField_a_of_type_JavaLangString;
      ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localvje);
    }
    for (;;)
    {
      boolean bool = vzu.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      ved.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (paramInt < i)
      {
        localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localvje.jdField_a_of_type_JavaLangString;
      }
      else
      {
        ved.d("Q.qqstory.record.HWEditLocalVideoPlayer", new Throwable(), "fragment index %d invalid, fragment count %d, again count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
    }
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
      if (!axkt.j()) {
        return;
      }
      localEditVideoParams = (EditVideoParams)this.jdField_a_of_type_Vix.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((localEditVideoParams != null) && (bbfj.d(this.jdField_a_of_type_Vix.getActivity())))
      {
        localObject = localEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        int m = ((Bundle)localObject).getInt("ptv_template_kind", -999);
        j = ((Bundle)localObject).getInt("dance_machine_session_type", -999);
        str = ((Bundle)localObject).getString("dance_machine_session_uin", "");
        k = ((Bundle)localObject).getInt("dance_machine_score", 0);
        if (m == 3)
        {
          boolean bool = axgo.a().a();
          this.jdField_a_of_type_Vix.getActivity().runOnUiThread(new HWEditLocalVideoPlayer.5(this));
          localObject = "";
          if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            localObject = ((EditTakeVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_b_of_type_JavaLangString;
          }
          localIntent = new Intent();
          localIntent.putExtra("KEY_AUDIO_FILE_PATH", (String)localObject);
          localIntent.putExtra("KEY_VIDEO_FILE_PATH", this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          localIntent.putExtra(EditVideoParams.class.getName(), localEditVideoParams);
          localIntent.putExtra("KEY_AUDIO_CHANNEL", axim.o);
          localIntent.putExtra("KEY_BITRATE", axim.n);
          localIntent.putExtra("KEY_AUDIO_FORMAT", axim.p);
          localIntent.putExtra("KEY_SAMPLE_RATE", axim.q);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("DIDI", 1, "enter Rank mHaveDanceRankShowed=true");
          }
          localObject = this.jdField_a_of_type_Vix.getActivity();
          if (!bool) {
            break label391;
          }
        }
      }
    }
    for (;;)
    {
      DanceMachineQQBrowserActivity.a((Activity)localObject, j, str, i, localEditVideoParams.jdField_a_of_type_Int, 0, k, localIntent);
      localObject = (vfq)a(vfq.class);
      if (localObject == null) {
        break;
      }
      ((vfq)localObject).a(paramLong / 1000000L);
      return;
      label391:
      i = 0;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Vhm.a();
    vje localvje;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(i);
      vje.a(localvje, paramBitmap);
      if ((!vje.b(localvje)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      vje.a(localvje, paramBoolean);
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
    int i = this.jdField_a_of_type_Vhm.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      vje.b((vje)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
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
      paramMessage = (vje)this.jdField_a_of_type_JavaUtilList.get(i);
      ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(vje.a(paramMessage)));
      c(vje.a(paramMessage));
      a(paramMessage);
      a(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label167:
      ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void b(int paramInt)
  {
    ved.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Vhm.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      vje localvje = (vje)this.jdField_a_of_type_JavaUtilList.get(i);
      if (vje.a(localvje) != paramInt)
      {
        vje.a(localvje, paramInt);
        vje.c(localvje, true);
      }
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
    a(0);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.4(this), 200L);
  }
  
  public void g() {}
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onPause();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (vje)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        this.jdField_a_of_type_AndroidOsHandler.post(new HWEditLocalVideoPlayer.3(this, i));
      }
    }
    return true;
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new HWEditLocalVideoPlayer.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */