import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneGiftFullScreenViewController.2;
import java.util.ArrayList;
import java.util.List;

public class bmuu
  implements View.OnClickListener
{
  public static boolean a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected Handler a;
  protected View a;
  protected WindowManager a;
  public Button a;
  protected ImageView a;
  protected awyb a;
  public awzg a;
  public bmur a;
  protected MagicfaceContainerView a;
  protected String a;
  private List<bmuy> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected View b;
  protected boolean b;
  
  static
  {
    String str = bhlo.g();
    if (str != null)
    {
      str = str.toLowerCase();
      if ((str.contains("marvell")) || (str.contains("armv5")) || (str.contains("armv6"))) {
        jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    jdField_a_of_type_Boolean = true;
  }
  
  public bmuu(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private void a()
  {
    if (!bhlo.d())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(bhlo.g(), bhlo.h()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          if (!Settings.canDrawOverlays((Context)localObject)) {
            ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
          }
        }
        for (int i = 0; i != 0; i = 1) {
          for (;;)
          {
            localObject = new WindowManager.LayoutParams();
            ((WindowManager.LayoutParams)localObject).type = 2002;
            ((WindowManager.LayoutParams)localObject).flags = 131112;
            ((WindowManager.LayoutParams)localObject).gravity = 51;
            ((WindowManager.LayoutParams)localObject).x = 0;
            ((WindowManager.LayoutParams)localObject).y = paramInt;
            ((WindowManager.LayoutParams)localObject).width = -1;
            ((WindowManager.LayoutParams)localObject).height = -2;
            ((WindowManager.LayoutParams)localObject).format = 1;
            this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
            if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {}
            try
            {
              this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
              try
              {
                this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
                return;
              }
              catch (Exception localException1)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException1);
                return;
              }
              if (localException1.checkSelfPermission("android.settings.action.MANAGE_WRITE_SETTINGS") != 0)
              {
                localException1.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
                i = 0;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException2);
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    if ((DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null) {
      if (!this.jdField_b_of_type_Boolean) {
        break label130;
      }
    }
    label130:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131562017, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131562019, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2131562021, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370549);
      this.jdField_a_of_type_Awzg = ((awzg)localView.findViewById(2131370542));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370544));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370543));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370547));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bmur != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_a_of_type_Awzg).setVisibility(8);
      this.jdField_a_of_type_Awzg.setSurfaceCreatelistener(null);
    }
    try
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      label109:
      if (this.jdField_a_of_type_Bmur.a())
      {
        bmur localbmur = this.jdField_a_of_type_Bmur;
        localbmur.a(new bmuv(this, localbmur));
        return;
      }
      this.jdField_a_of_type_Bmur.a();
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public View a(String paramString1, String paramString2, bmux parambmux)
  {
    return a(paramString1, paramString2, false, parambmux);
  }
  
  public View a(String paramString1, String paramString2, boolean paramBoolean, bmux parambmux)
  {
    if (Build.VERSION.SDK_INT <= 17) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Awzg != null) && (((View)this.jdField_a_of_type_Awzg).getVisibility() == 0))
      {
        localObject1 = new bmuy(this);
        ((bmuy)localObject1).jdField_a_of_type_JavaLangString = paramString1;
        ((bmuy)localObject1).jdField_a_of_type_Boolean = paramBoolean;
        ((bmuy)localObject1).b = paramString2;
        ((bmuy)localObject1).jdField_a_of_type_Bmux = parambmux;
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        return null;
      }
      if ((this.jdField_a_of_type_Bmur != null) && (this.jdField_a_of_type_Bmur.a())) {
        return null;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return null;
      }
      this.jdField_a_of_type_Awyb = bmur.a(paramString1, paramString2);
      if (this.jdField_a_of_type_Awyb == null) {
        return null;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      b();
      this.jdField_a_of_type_Bmur = new bmur(this);
      Object localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      Object localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_a_of_type_Awzg, (ViewGroup.LayoutParams)localObject2);
      if (!paramBoolean) {
        a(0);
      }
      ((ViewGroup)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (paramBoolean)
      {
        localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).topMargin = bhtq.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = bhtq.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = bhtq.a(15.0F);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = bhtq.a(15.0F);
        this.jdField_a_of_type_Awzg.setIsFullScreen(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setTouchEffect(true);
        ((View)this.jdField_a_of_type_Awzg).setClickable(false);
        ((View)this.jdField_a_of_type_Awzg).setFocusable(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setFocusable(false);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new QzoneGiftFullScreenViewController.2(this));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_Awzg).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_a_of_type_Awzg.setIsFullScreen(this.jdField_a_of_type_Awyb.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Awzg;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((SurfaceView)localObject1).setZOrderOnTop(true);
      ((SurfaceView)localObject1).getHolder().setFormat(-2);
      localObject2 = new awzb();
      ((awzb)localObject2).a((awyn)localObject1);
      this.jdField_a_of_type_Bmur.a((awzb)localObject2);
      this.jdField_a_of_type_Bmur.a(new bmuw(this, l, parambmux));
      this.jdField_a_of_type_Bmur.a(paramString1, paramString2);
    }
    catch (SecurityException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Bmur != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8))
    {
      c();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuu
 * JD-Core Version:    0.7.0.1
 */