package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class DocEnhanceFragment
  extends AEFullScreenPublicFragment
  implements View.OnClickListener
{
  private static final int jdField_b_of_type_Int = ViewConfiguration.get(BaseApplicationImpl.getContext()).getScaledTouchSlop();
  private static final int jdField_c_of_type_Int = ViewConfiguration.getLongPressTimeout();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 2;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GYAIDocEnhance jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance = new GYAIDocEnhance();
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private float jdField_b_of_type_Float;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  @Nullable
  private Bitmap a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {
      return this.jdField_c_of_type_AndroidGraphicsBitmap;
    }
    if (i == 2) {
      return this.jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance.documentDeshadow(this.jdField_c_of_type_AndroidGraphicsBitmap);
    }
    if (i == 3) {
      return this.jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance.documentEnhance(this.jdField_c_of_type_AndroidGraphicsBitmap);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setSelected(false);
    this.jdField_c_of_type_AndroidWidgetImageView.setSelected(false);
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(false);
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {
      this.jdField_b_of_type_AndroidWidgetImageView.setSelected(true);
    } else if (i == 2) {
      this.jdField_c_of_type_AndroidWidgetImageView.setSelected(true);
    } else if (i == 3) {
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(true);
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16725252);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2064056443, 0, 0, 0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2064056442, 0, 0, 0);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    a();
    n();
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, float[] paramArrayOfFloat, int paramInt2)
  {
    if (!FeatureManager.Features.LIGHT_SDK.init())
    {
      AEQLog.d("DocEnhanceFragment", "jumpToMeForResult---light sdk not ready");
      ThreadManager.getUIHandler().post(new DocEnhanceFragment.1());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_RAW_PIC_PATH", paramString1);
    localIntent.putExtra("ARG_ENHANCED_PIC_PATH", paramString2);
    localIntent.putExtra("ARG_ENHANCED_POINTS_ARRAY", paramArrayOfFloat);
    localIntent.putExtra("ARG_ENHANCED_COLOR_CONFIG", paramInt2);
    QPublicFragmentActivityForMultiProcess.a(paramActivity, localIntent, DocEnhanceFragment.class, paramInt1);
  }
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    ThreadManager.excute(new DocEnhanceFragment.5(this, paramFragmentActivity), 64, null, false);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= jdField_c_of_type_Int) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    float f1 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
    float f2 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    boolean bool2;
    if (Math.sqrt(f1 * f1 + f2 * f2) <= jdField_b_of_type_Int) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("considerAClick inTapTime=");
    paramMotionEvent.append(bool1);
    paramMotionEvent.append(", inTapDis=");
    paramMotionEvent.append(bool2);
    AEQLog.a("DocEnhanceFragment", paramMotionEvent.toString());
    return (bool1) && (bool2);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a(1);
      return;
    }
    a(2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
  
  private void d()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(localFragmentActivity);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("RESULT_KEY_IS_ENHANCED", this.jdField_a_of_type_Boolean);
      localFragmentActivity.setResult(-1, localIntent);
      localFragmentActivity.finish();
    }
  }
  
  private void e()
  {
    g();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    m();
    this.jdField_a_of_type_Int = 1;
    a();
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getContext(), 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2064515151));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2064515150));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2064515117), new DocEnhanceFragment.6(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2064515119), new DocEnhanceFragment.7(this));
    localQQCustomDialog.setCanceledOnTouchOutside(true);
    localQQCustomDialog.show();
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance.documentDetect(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doEnhancementOnFirstEnter---detect points=");
    ((StringBuilder)localObject2).append(Arrays.toString((float[])localObject1));
    AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (localObject1.length == 8))
    {
      int i = 0;
      while (i < 4)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfFloat;
        int j = i * 2;
        localObject1[j] /= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        localObject2 = this.jdField_a_of_type_ArrayOfFloat;
        j += 1;
        localObject1[j] /= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        i += 1;
      }
      i();
    }
    else
    {
      j();
    }
    m();
    k();
    if ((localObject1 != null) && (localObject1.length == 8))
    {
      long l2 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doEnhancementOnFirstEnter---cost=");
      ((StringBuilder)localObject1).append(l2 - l1);
      AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject1).toString());
    }
  }
  
  private void i()
  {
    boolean bool = AECameraPrefsUtil.a().a("sp_key_doc_enhance_has_shown_adjust_guide_bubble", false, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkShowGuideBubble---hasShown=");
    localStringBuilder.append(bool);
    AEQLog.b("DocEnhanceFragment", localStringBuilder.toString());
    if (bool) {
      return;
    }
    AECameraPrefsUtil.a().a("sp_key_doc_enhance_has_shown_adjust_guide_bubble", true, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(2064515148);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(2064515149);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
  }
  
  private void k()
  {
    Bitmap localBitmap1 = a();
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      Bitmap localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if ((localBitmap2 != null) && (localBitmap2 != localBitmap1) && (localBitmap2 != this.jdField_a_of_type_AndroidGraphicsBitmap) && (localBitmap2 != this.jdField_c_of_type_AndroidGraphicsBitmap)) {
        localBitmap2.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = localBitmap1;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void l()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doEnhancementOnAdjustPointsChanged---mAdjustPoints=");
    ((StringBuilder)localObject).append(Arrays.toString(this.jdField_a_of_type_ArrayOfFloat));
    AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    if ((localObject != null) && (localObject.length == 8))
    {
      m();
      k();
    }
  }
  
  private void m()
  {
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if (arrayOfFloat != null)
    {
      if (arrayOfFloat.length != 8) {
        return;
      }
      arrayOfFloat = new float[8];
      int i = 0;
      while (i < 4)
      {
        int j = i * 2;
        arrayOfFloat[j] = (this.jdField_a_of_type_ArrayOfFloat[j] * this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
        j += 1;
        arrayOfFloat[j] = (this.jdField_a_of_type_ArrayOfFloat[j] * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        i += 1;
      }
      Bitmap localBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance.documentWarp(this.jdField_a_of_type_AndroidGraphicsBitmap, arrayOfFloat);
    }
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    k();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i == 1)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0) && (a(paramMotionEvent)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
          return false;
        }
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (a(paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("considerAClick mConfigPanelRect=");
          localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect);
          localStringBuilder.append(", ev=");
          localStringBuilder.append(i);
          localStringBuilder.append(",");
          localStringBuilder.append(j);
          AEQLog.a("DocEnhanceFragment", localStringBuilder.toString());
          if (j < this.jdField_a_of_type_AndroidGraphicsRect.top)
          {
            c();
            return true;
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 3721) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.jdField_a_of_type_ArrayOfFloat = paramIntent.getFloatArrayExtra("RESULT_ADJUST_POINTS_ARRAY");
      l();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      c();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2064122787: 
      e();
      return;
    case 2064122762: 
      d();
      return;
    case 2064122760: 
      b();
      return;
    case 2064122749: 
      onBackEvent();
      return;
    }
    DocEnhanceAdjustFragment.a(getActivity(), 3721, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfFloat);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ARG_RAW_PIC_PATH");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaLangString = str;
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str);
      }
      str = paramBundle.getString("ARG_ENHANCED_PIC_PATH");
      float[] arrayOfFloat = paramBundle.getFloatArray("ARG_ENHANCED_POINTS_ARRAY");
      if ((!TextUtils.isEmpty(str)) && (arrayOfFloat != null) && (arrayOfFloat.length == 8))
      {
        this.jdField_a_of_type_ArrayOfFloat = arrayOfFloat;
        this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str);
        this.jdField_a_of_type_Int = paramBundle.getInt("ARG_ENHANCED_COLOR_CONFIG", 2);
        this.jdField_a_of_type_Boolean = true;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate--mIsEnhanced=");
      paramBundle.append(this.jdField_a_of_type_Boolean);
      paramBundle.append(", mRawPicPath=");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(", mEnhancedPicPath=");
      paramBundle.append(str);
      paramBundle.append(", mEnhancePoints=");
      paramBundle.append(Arrays.toString(this.jdField_a_of_type_ArrayOfFloat));
      AEQLog.b("DocEnhanceFragment", paramBundle.toString());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064318563, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    localBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122303));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122787));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122746));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122760));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122749));
    this.e = ((TextView)paramView.findViewById(2064122762));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)paramView.findViewById(2064122003));
    paramBundle = getContext();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(UIUtils.a(paramBundle, 10.0F), UIUtils.a(paramBundle, 11.0F), UIUtils.a(paramBundle, 10.0F), UIUtils.a(paramBundle, 11.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    localBubbleTextView.jdField_a_of_type_Int = -1;
    localBubbleTextView.jdField_b_of_type_Float = UIUtils.a(paramBundle, 6.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122568));
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122354);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122312));
    this.f = ((TextView)paramView.findViewById(2064122752));
    paramView.setOnClickListener(new DocEnhanceFragment.2(this));
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122353);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122312));
    this.g = ((TextView)paramView.findViewById(2064122752));
    paramView.setOnClickListener(new DocEnhanceFragment.3(this));
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122352);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122312));
    this.h = ((TextView)paramView.findViewById(2064122752));
    paramView.setOnClickListener(new DocEnhanceFragment.4(this));
    this.f.setText(2064515143);
    this.g.setText(2064515142);
    this.h.setText(2064515141);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056441);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2064056437);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2064056436);
    a();
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      m();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment
 * JD-Core Version:    0.7.0.1
 */