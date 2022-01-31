package com.tencent.mobileqq.armap.map;

import abny;
import abob;
import aboc;
import abod;
import aboe;
import abof;
import abog;
import aboh;
import abok;
import abol;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ARMapPOIStarDialog
  extends Dialog
{
  int jdField_a_of_type_Int;
  public long a;
  public Context a;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public ArMapInterface a;
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new abny(this);
  public SanHuaView a;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int;
  public long b;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ProgressBar b;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  RelativeLayout d;
  public String d;
  
  public ARMapPOIStarDialog(Context paramContext, long paramLong1, long paramLong2, String paramString1, int paramInt, String paramString2, String paramString3, ArMapInterface paramArMapInterface)
  {
    super(paramContext, 2131624516);
    setContentView(2130970241);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    paramArMapInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    b();
    this.jdField_a_of_type_AndroidWidgetProgressBar.postDelayed(new aboc(this), 1500L);
    ThreadManager.postImmediately(new abod(this, paramArMapInterface, paramLong1, paramLong2), null, false);
  }
  
  private void a(ItemInfo paramItemInfo, int paramInt)
  {
    if ((paramItemInfo == null) || (paramItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo == null) || (paramItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Long != this.jdField_b_of_type_Long) || (paramItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Int != 11)) {
      return;
    }
    if ((paramInt != -1) && (paramItemInfo.e > 0))
    {
      this.jdField_b_of_type_Boolean = true;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ThreadManager.getUIHandler().postDelayed(new abok(this), 500L);
      }
      for (;;)
      {
        if (((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).a != null) {
          ((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).a.queueEvent(new abol(this, paramItemInfo));
        }
        this.jdField_c_of_type_Boolean = true;
        return;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "数据异常，请稍候再试", 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842301);
        this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ARMapPOIStarDialog", 2, "itemInfo:" + paramItemInfo + " -- taskStatus:" + paramInt);
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437332, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842301);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new abob(this, paramLong));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("你已领取" + paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369720));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361926));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369724));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369727));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369700));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364003));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369722));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369719));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369721));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363581));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369726));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aboe(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363852));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369723));
    Object localObject1 = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject1).getAttributes();
    localLayoutParams.width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.height = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    ((Window)localObject1).setAttributes(localLayoutParams);
    localObject1 = (ARMapManager)((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(209);
    if (localObject1 != null)
    {
      Object localObject3 = ((ARMapManager)localObject1).d() + "/17_armap_cardbg@2x.png";
      Object localObject2 = ((ARMapManager)localObject1).d() + "/17_armap_detailbg@2x.png";
      localObject3 = Drawable.createFromPath((String)localObject3);
      localObject2 = Drawable.createFromPath((String)localObject2);
      if (localObject3 != null) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject3);
      }
      if (localObject2 != null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
      }
      this.jdField_d_of_type_JavaLangString = ((ARMapManager)localObject1).b();
    }
    int i = (localLayoutParams.width - AIOUtils.a(300.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    int j = (localLayoutParams.height - AIOUtils.a(400.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this.jdField_a_of_type_AndroidContentContext, localLayoutParams.width / 2 - i, localLayoutParams.height / 2 - j);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(AIOUtils.a(300.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(400.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
  }
  
  public void a()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(300.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(400.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(500L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new abof(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.show();
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(300.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(400.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, paramInt1 - j, 0, paramInt2 - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(500L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public void a(POIInfo paramPOIInfo, List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramPOIInfo == null))
    {
      if (isShowing()) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437332, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapPOIStarDialog", 2, "bindData failed");
      }
    }
    ItemInfo localItemInfo;
    Object localObject;
    label360:
    do
    {
      do
      {
        return;
      } while ((paramPOIInfo.jdField_a_of_type_Long != this.jdField_b_of_type_Long) || (paramPOIInfo.jdField_a_of_type_Int != 11));
      localItemInfo = (ItemInfo)paramList.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapPOIStarDialog", 2, "bindView itemInfo:" + localItemInfo + "  status:" + paramInt);
      }
      localObject = "" + this.jdField_a_of_type_Long;
      String str1 = "" + localItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Long;
      String str2 = "" + localItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_b_of_type_Long;
      if (paramInt != 0) {
        break;
      }
      paramList = "1";
      ReportController.b(null, "dc01440", "", "", "0X8007A03", "0X8007A03", 0, 0, (String)localObject, str1, str2, paramList);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (!TextUtils.isEmpty(paramPOIInfo.jdField_d_of_type_JavaLangString))
      {
        paramList = URLDrawable.URLDrawableOptions.obtain();
        paramList.mRequestHeight = AIOUtils.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramList.mRequestWidth = AIOUtils.a(170.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramList.mLoadingDrawable = new ColorDrawable(0);
        paramList.mFailedDrawable = paramList.mLoadingDrawable;
        paramList = URLDrawable.getDrawable(paramPOIInfo.jdField_d_of_type_JavaLangString, paramList);
        if (paramList.getStatus() != 1) {
          break label451;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramList);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aboh(this, paramPOIInfo, paramInt));
    } while (paramInt == -1);
    if (paramInt == 0) {
      a(localItemInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438792, new Object[] { this.jdField_c_of_type_JavaLangString }));
      return;
      if (paramInt == 1)
      {
        paramList = "2";
        break;
      }
      paramList = "";
      break;
      label451:
      localObject = new abog(this, paramPOIInfo);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject);
      break label360;
      a(localItemInfo.jdField_a_of_type_JavaLangString, paramPOIInfo.jdField_b_of_type_Long);
    }
  }
  
  protected void onStop()
  {
    if (!((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
    {
      super.onStop();
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapPOIStarDialog
 * JD-Core Version:    0.7.0.1
 */