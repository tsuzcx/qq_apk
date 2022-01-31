package com.tencent.biz.qqstory.takevideo;

import ajyc;
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
import avxn;
import avxp;
import avzc;
import avzu;
import avzv;
import avzz;
import axgm;
import axik;
import axkr;
import bbct;
import bbev;
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
import veg;
import vft;
import vgb;
import vhn;
import vhp;
import vib;
import vja;
import vje;
import vjh;
import vju;
import vsd;
import vzo;
import vzx;

public class HWEditLocalVideoPlayer
  extends vhn
  implements Handler.Callback, avxn, vib
{
  protected int a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avzc jdField_a_of_type_Avzc;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected LocalMediaInfo a;
  public NeoVideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  protected List<vjh> a;
  protected boolean a;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  public final boolean b;
  private boolean c = true;
  private boolean d;
  
  public HWEditLocalVideoPlayer(@NonNull vhp paramvhp)
  {
    super(paramvhp);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = avxp.jdField_b_of_type_Boolean;
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
  
  private Bitmap a(@NonNull vjh paramvjh)
  {
    Object localObject3 = null;
    Object localObject1 = vjh.a(paramvjh);
    if (localObject1 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    Object localObject2 = localObject1;
    if (i != 0) {
      localObject2 = vzo.a((Bitmap)localObject1, 360 - i);
    }
    avzv localavzv = new avzv();
    localavzv.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
    Object localObject4 = localObject3;
    if (vjh.a(paramvjh))
    {
      localObject4 = localObject3;
      if (avzu.a(vjh.a(paramvjh))) {
        switch (vjh.a(paramvjh))
        {
        default: 
          localObject1 = null;
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localavzv.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
      if (vjh.b(paramvjh))
      {
        localObject2 = localObject1;
        if (vjh.b(paramvjh) != null)
        {
          localObject4 = (avzz)avzu.a(106);
          if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)) {
            break label387;
          }
          ((avzz)localObject4).a(vjh.b(paramvjh), i);
        }
      }
      for (;;)
      {
        ((avzz)localObject4).init();
        localObject2 = localavzv.a((Bitmap)localObject1, (GPUBaseFilter)localObject4);
        veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((avzz)localObject4).destroy();
        localObject2 = localObject1;
        if ((localObject3 != null) && (localObject3 != vjh.a(paramvjh)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localavzv.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = vzo.a((Bitmap)localObject2, i);
        }
        if ((localObject1 == vjh.a(paramvjh)) && (!vjh.a(paramvjh)) && (!vjh.b(paramvjh))) {
          break label399;
        }
        return localObject1;
        localObject1 = avzu.a(7);
        break;
        localObject1 = avzu.a(4);
        break;
        localObject1 = avzu.a(6);
        break;
        localObject1 = avzu.a(5);
        break;
        label387:
        ((avzz)localObject4).a(vjh.b(paramvjh));
      }
      label399:
      return paramvjh.jdField_c_of_type_AndroidGraphicsBitmap;
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
      veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable skip");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (vjh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((vjh)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((vjh)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((vjh)localObject).jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          vjh localvjh = (vjh)((Iterator)localObject).next();
          if ((!localvjh.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localvjh.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localvjh.jdField_c_of_type_Int);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        veg.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
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
  
  private void a(@NonNull vjh paramvjh)
  {
    veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramvjh.jdField_c_of_type_Int));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)vjh.a(paramvjh), (int)vjh.b(paramvjh));
      if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramvjh.jdField_c_of_type_Int;
      return;
      if (paramvjh.jdField_a_of_type_JavaLangString == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)vjh.a(paramvjh), (int)vjh.b(paramvjh));
        if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, ajyc.a(2131705671));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.a().equalsIgnoreCase(paramvjh.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.h();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(paramvjh.jdField_a_of_type_JavaLangString, paramvjh.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.j();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.d();
        }
        if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
        vjh localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        if (localvjh.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(3);
          break;
          veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
          a(localvjh);
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
      this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgb.a(true);
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((vjh.a((vjh)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((vjh)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgb.a(false);
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgb.a(true);
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
    if (this.jdField_a_of_type_Avzc != null)
    {
      this.jdField_a_of_type_Avzc.c();
      this.jdField_a_of_type_Avzc = null;
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
      vjh localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return vjh.b(localvjh) - vjh.a(localvjh);
    }
    veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((vjh)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public List<? extends vju> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      bool1 = vhp.a(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768);
      boolean bool2 = VideoEnvironment.b(7);
      veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
      if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12))
      {
        int i = vzx.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRotate(i);
        if ((i == 90) || (i == 270))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getLayoutParams();
          EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(bbct.k() * localEditTakeVideoSource.a() / localEditTakeVideoSource.b()));
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setDecodeListener(this);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayListener(new vje(this));
      }
      a(vib.class, this);
      this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgb.a(false);
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
      veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
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
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    int i;
    vjh localvjh;
    if ((paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Avzc != null)
      {
        this.jdField_a_of_type_Avzc.c();
        this.jdField_a_of_type_Avzc = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)vjh.a(localvjh));
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)vjh.b(localvjh));
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localvjh.jdField_a_of_type_JavaLangString;
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localvjh);
    }
    for (;;)
    {
      boolean bool = vzx.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (paramInt < i)
      {
        localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localvjh.jdField_a_of_type_JavaLangString;
      }
      else
      {
        veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", new Throwable(), "fragment index %d invalid, fragment count %d, again count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
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
      if (!axkr.j()) {
        return;
      }
      localEditVideoParams = (EditVideoParams)this.jdField_a_of_type_Vja.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((localEditVideoParams != null) && (bbev.d(this.jdField_a_of_type_Vja.getActivity())))
      {
        localObject = localEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        int m = ((Bundle)localObject).getInt("ptv_template_kind", -999);
        j = ((Bundle)localObject).getInt("dance_machine_session_type", -999);
        str = ((Bundle)localObject).getString("dance_machine_session_uin", "");
        k = ((Bundle)localObject).getInt("dance_machine_score", 0);
        if (m == 3)
        {
          boolean bool = axgm.a().a();
          this.jdField_a_of_type_Vja.getActivity().runOnUiThread(new HWEditLocalVideoPlayer.5(this));
          localObject = "";
          if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            localObject = ((EditTakeVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_b_of_type_JavaLangString;
          }
          localIntent = new Intent();
          localIntent.putExtra("KEY_AUDIO_FILE_PATH", (String)localObject);
          localIntent.putExtra("KEY_VIDEO_FILE_PATH", this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          localIntent.putExtra(EditVideoParams.class.getName(), localEditVideoParams);
          localIntent.putExtra("KEY_AUDIO_CHANNEL", axik.o);
          localIntent.putExtra("KEY_BITRATE", axik.n);
          localIntent.putExtra("KEY_AUDIO_FORMAT", axik.p);
          localIntent.putExtra("KEY_SAMPLE_RATE", axik.q);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.jdField_b_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("DIDI", 1, "enter Rank mHaveDanceRankShowed=true");
          }
          localObject = this.jdField_a_of_type_Vja.getActivity();
          if (!bool) {
            break label391;
          }
        }
      }
    }
    for (;;)
    {
      DanceMachineQQBrowserActivity.a((Activity)localObject, j, str, i, localEditVideoParams.jdField_a_of_type_Int, 0, k, localIntent);
      localObject = (vft)a(vft.class);
      if (localObject == null) {
        break;
      }
      ((vft)localObject).a(paramLong / 1000000L);
      return;
      label391:
      i = 0;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Vhp.a();
    vjh localvjh;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(i);
      vjh.a(localvjh, paramBitmap);
      if ((!vjh.b(localvjh)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      vjh.a(localvjh, paramBoolean);
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
    int i = this.jdField_a_of_type_Vhp.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      vjh.b((vjh)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
      paramMessage = (vjh)this.jdField_a_of_type_JavaUtilList.get(i);
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(b(vjh.a(paramMessage)));
      c(vjh.a(paramMessage));
      a(paramMessage);
      a(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label167:
      veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void b(int paramInt)
  {
    veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Vhp.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      vjh localvjh = (vjh)this.jdField_a_of_type_JavaUtilList.get(i);
      if (vjh.a(localvjh) != paramInt)
      {
        vjh.a(localvjh, paramInt);
        vjh.c(localvjh, true);
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
      paramMessage = (vjh)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
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