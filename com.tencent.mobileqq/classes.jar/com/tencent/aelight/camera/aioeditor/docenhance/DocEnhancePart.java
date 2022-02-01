package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.Arrays;
import java.util.HashSet;
import mqq.os.MqqHandler;

public class DocEnhancePart
  extends EditVideoPart
{
  private static final HashSet<String> a = new HashSet();
  private float[] b;
  private boolean c;
  private int d;
  private String e;
  private String f;
  private View g;
  private boolean h = true;
  private String i;
  private int j;
  
  static
  {
    a.add("绘画");
    a.add("名片");
    a.add("幻灯片");
    a.add("票据");
    a.add("文本");
    a.add("报纸");
    a.add("文档");
    a.add("文字");
    a.add("证件");
    a.add("身份证");
    a.add("书法");
    a.add("银行卡");
    a.add("图表_账单");
    a.add("书");
  }
  
  public DocEnhancePart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private String a(Bitmap paramBitmap)
  {
    return this.t.a(paramBitmap);
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.g.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
      int k;
      if (paramBoolean) {
        k = s().getDimensionPixelSize(2063859723);
      } else {
        k = s().getDimensionPixelSize(2063859722);
      }
      localMarginLayoutParams.bottomMargin = k;
      this.g.setLayoutParams(localLayoutParams);
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClickEnter--mIsEnhanced=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mRawPicPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mEnhancedPicPath=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mEnhancePoints=");
    localStringBuilder.append(Arrays.toString(this.b));
    AEQLog.b("DocEnhancePart", localStringBuilder.toString());
    if (this.c)
    {
      DocEnhanceFragment.a((Activity)u(), 7532, this.e, this.f, this.b, this.d);
      return;
    }
    if (!TextUtils.isEmpty(this.e))
    {
      DocEnhanceFragment.a((Activity)u(), 7532, this.e, null, null, this.d);
      return;
    }
    i();
  }
  
  private void d()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(u(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2064187488));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2064187487));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2064187459), new DocEnhancePart.2(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2064187461), new DocEnhancePart.3(this));
    localQQCustomDialog.setCanceledOnTouchOutside(true);
    localQQCustomDialog.show();
  }
  
  private void i()
  {
    Bitmap localBitmap = this.t.H();
    if (localBitmap != null)
    {
      if (localBitmap.isRecycled()) {
        return;
      }
      ThreadManager.excute(new DocEnhancePart.4(this, localBitmap), 64, null, false);
    }
  }
  
  private void k()
  {
    AEQLog.b("DocEnhancePart", "clearEnhancementInfo---");
    this.c = false;
    this.f = null;
    this.b = null;
    this.e = null;
  }
  
  private void l()
  {
    this.g.setVisibility(8);
  }
  
  private void m()
  {
    int k = this.t.I.a;
    StringBuilder localStringBuilder;
    if (k != 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong business: ");
      localStringBuilder.append(k);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
      return;
    }
    k = this.j;
    if ((k != 0) && (k != 4) && (k != 25))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong state: ");
      localStringBuilder.append(this.j);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
    }
    if (!a.contains(this.i))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong sub label: ");
      localStringBuilder.append(this.i);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
      return;
    }
    if ((AEResUtil.d(AEResInfo.LIGHT_RES_BASE_PACKAGE)) && (AEResUtil.d(AEResInfo.AE_RES_BASE_PACKAGE)) && (AEResUtil.d(AEResInfo.LIGHT_RES_BUNDLE_SCENE)))
    {
      if ((FeatureManager.Features.LIGHT_SDK.init()) && (FeatureManager.Features.PTU_TOOLS.init()) && (FeatureManager.Features.PTU_ALGO.init()) && (FeatureManager.Features.IMAGE_ALGO.init()))
      {
        this.g.setVisibility(0);
        return;
      }
      AEQLog.d("DocEnhancePart", "checkShowEntrance---features init fail");
      return;
    }
    AEQLog.d("DocEnhancePart", "checkShowEntrance---res not exist");
  }
  
  public void a()
  {
    super.a();
    this.g = d(2063991014);
    this.g.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 21) {
      this.g.setBackgroundResource(2063925413);
    }
    this.g.setOnClickListener(new DocEnhancePart.1(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((7532 == paramInt1) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.c = paramIntent.getBooleanExtra("RESULT_KEY_IS_ENHANCED", false);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult--mIsEnhanced=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mRawPicPath=");
      ((StringBuilder)localObject).append(this.e);
      AEQLog.b("DocEnhancePart", ((StringBuilder)localObject).toString());
      if (this.c)
      {
        this.f = paramIntent.getStringExtra("RESULT_KEY_ENHANCED_PIC_PATH");
        localObject = BitmapFactory.decodeFile(this.f);
        this.t.a((Bitmap)localObject, false);
        VideoFilterTools.a().a((Bitmap)localObject);
        this.b = paramIntent.getFloatArrayExtra("RESULT_KEY_ENHANCED_POINTS_ARRAY");
        this.d = paramIntent.getIntExtra("RESULT_KEY_ENHANCED_COLOR_CONFIG", 2);
      }
      else
      {
        paramIntent = BitmapFactory.decodeFile(this.e);
        this.t.a(paramIntent, false);
        VideoFilterTools.a().a(paramIntent);
        k();
      }
      this.t.J();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.j = paramInt2;
    if (paramInt2 == 24)
    {
      k();
      if (this.h) {
        ThreadManager.excute(new DocEnhancePart.5(this), 16, null, false);
      }
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 13)
      {
        if (paramInt2 != 25)
        {
          if (paramInt2 == 3) {
            break label74;
          }
          if (paramInt2 != 4) {
            return;
          }
        }
        m();
        a(true);
        return;
      }
      label74:
      l();
      return;
    }
    m();
    a(false);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.c)
    {
      paramGenerateContext = paramGenerateContext.l;
      paramGenerateContext.f += 1;
    }
    AEBaseReportParam.a().e(this.c);
  }
  
  public void a(String paramString)
  {
    if (!this.h) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.h = false;
    }
    this.i = paramString;
    ThreadManager.getUIHandler().post(new DocEnhancePart.6(this, paramString));
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart
 * JD-Core Version:    0.7.0.1
 */