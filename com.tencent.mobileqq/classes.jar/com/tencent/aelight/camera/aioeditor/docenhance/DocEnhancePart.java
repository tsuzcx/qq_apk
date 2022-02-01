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
import com.gyailib.library.GYAISceneChain;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Arrays;
import java.util.HashSet;

public class DocEnhancePart
  extends EditVideoPart
{
  private static final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private GYAISceneChain jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet.add("绘画");
    jdField_a_of_type_JavaUtilHashSet.add("名片");
    jdField_a_of_type_JavaUtilHashSet.add("幻灯片");
    jdField_a_of_type_JavaUtilHashSet.add("票据");
    jdField_a_of_type_JavaUtilHashSet.add("文本");
    jdField_a_of_type_JavaUtilHashSet.add("报纸");
    jdField_a_of_type_JavaUtilHashSet.add("文档");
    jdField_a_of_type_JavaUtilHashSet.add("文字");
    jdField_a_of_type_JavaUtilHashSet.add("证件");
    jdField_a_of_type_JavaUtilHashSet.add("身份证");
    jdField_a_of_type_JavaUtilHashSet.add("书法");
    jdField_a_of_type_JavaUtilHashSet.add("银行卡");
    jdField_a_of_type_JavaUtilHashSet.add("图表_账单");
    jdField_a_of_type_JavaUtilHashSet.add("书");
  }
  
  public DocEnhancePart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private String a(Bitmap paramBitmap)
  {
    return VideoFilterViewPager.a(paramBitmap);
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
      int i;
      if (paramBoolean) {
        i = a().getDimensionPixelSize(2063990796);
      } else {
        i = a().getDimensionPixelSize(2063990795);
      }
      localMarginLayoutParams.bottomMargin = i;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClickEnter--mIsEnhanced=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mRawPicPath=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mEnhancedPicPath=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mEnhancePoints=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfFloat));
    AEQLog.b("DocEnhancePart", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      DocEnhanceFragment.a((Activity)a(), 7532, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Int);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      DocEnhanceFragment.a((Activity)a(), 7532, this.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Int);
      return;
    }
    h();
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(a(), 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2064515146));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2064515145));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2064515117), new DocEnhancePart.2(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2064515119), new DocEnhancePart.3(this));
    localQQCustomDialog.setCanceledOnTouchOutside(true);
    localQQCustomDialog.show();
  }
  
  private void h()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
    if (localBitmap != null)
    {
      if (localBitmap.isRecycled()) {
        return;
      }
      ThreadManager.excute(new DocEnhancePart.4(this, localBitmap), 64, null, false);
    }
  }
  
  private void j()
  {
    AEQLog.b("DocEnhancePart", "clearEnhancementInfo---");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_Int;
    StringBuilder localStringBuilder;
    if (i != 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong business: ");
      localStringBuilder.append(i);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
      return;
    }
    i = this.jdField_b_of_type_Int;
    if ((i != 0) && (i != 4) && (i != 25))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong state: ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
    }
    if (!jdField_a_of_type_JavaUtilHashSet.contains(this.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShowEntrance---wrong sub label: ");
      localStringBuilder.append(this.c);
      AEQLog.d("DocEnhancePart", localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = a(2064122114);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2064056444);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new DocEnhancePart.1(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((7532 == paramInt1) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("RESULT_KEY_IS_ENHANCED", false);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult--mIsEnhanced=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", mRawPicPath=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      AEQLog.b("DocEnhancePart", ((StringBuilder)localObject).toString());
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("RESULT_KEY_ENHANCED_PIC_PATH");
        localObject = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a((Bitmap)localObject, false);
        VideoFilterTools.a().a((Bitmap)localObject);
        this.jdField_a_of_type_ArrayOfFloat = paramIntent.getFloatArrayExtra("RESULT_KEY_ENHANCED_POINTS_ARRAY");
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("RESULT_KEY_ENHANCED_COLOR_CONFIG", 2);
      }
      else
      {
        paramIntent = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramIntent, false);
        VideoFilterTools.a().a(paramIntent);
        j();
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.x();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt2 == 24)
    {
      j();
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
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
            break label79;
          }
          if (paramInt2 != 4) {
            return;
          }
        }
        l();
        a(true);
        return;
      }
      label79:
      k();
      return;
    }
    l();
    a(false);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramGenerateContext = paramGenerateContext.a;
      paramGenerateContext.jdField_a_of_type_Int += 1;
    }
    AEBaseReportParam.a().e(this.jdField_a_of_type_Boolean);
  }
  
  public void e()
  {
    super.e();
    GYAISceneChain localGYAISceneChain = this.jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
    if (localGYAISceneChain != null)
    {
      localGYAISceneChain.cleanupModelData();
      this.jdField_a_of_type_ComGyailibLibraryGYAISceneChain = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart
 * JD-Core Version:    0.7.0.1
 */