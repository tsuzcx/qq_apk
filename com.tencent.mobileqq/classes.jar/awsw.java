import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.1;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.2;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.3;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.5;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.8;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awsw
  implements View.OnClickListener
{
  public static boolean a;
  protected Handler a;
  protected View a;
  protected WindowManager a;
  protected Button a;
  public ImageView a;
  public TextView a;
  protected awrn a;
  public awsf a;
  protected awss a;
  protected awtb a;
  public BaseChatPie a;
  public Emoticon a;
  protected MagicfaceContainerView a;
  Runnable a;
  protected String a;
  protected View b;
  protected Button b;
  public TextView b;
  public awss b;
  protected MagicfaceContainerView b;
  protected boolean b;
  public Button c;
  protected TextView c;
  protected Button d;
  public TextView d;
  protected Button e;
  protected Button f;
  
  static
  {
    String str1 = DeviceInfoUtil.getCpuType();
    if (str1 != null)
    {
      String str2 = str1.toLowerCase();
      if ((!str2.contains("marvell")) && (!str2.contains("armv5")) && (!str2.contains("armv6"))) {
        break label76;
      }
    }
    label76:
    for (jdField_a_of_type_Boolean = false;; jdField_a_of_type_Boolean = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "cpuType=" + str1);
      }
      return;
    }
  }
  
  public awsw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.jdField_b_of_type_Boolean);
    }
  }
  
  public static boolean a()
  {
    if ((DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  public void a()
  {
    if (!DeviceInfoUtil.isSupportOpenGlES20())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.getDispalyWidth(), DeviceInfoUtil.getDispalyHeight()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT < 26) {
      localLayoutParams.type = 2002;
    }
    for (;;)
    {
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = paramInt;
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {}
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
          return;
        }
        catch (Exception localException1)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException1);
          return;
        }
        localException1.type = 2038;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
        }
      }
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    bggl localbggl = (bggl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((localbggl != null) && (localbggl.a != 1)) {
      localbggl.e();
    }
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Awss != null) && (((View)this.jdField_a_of_type_Awss).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_Awtb != null)
      {
        this.jdField_a_of_type_Awtb.onPlayEnd();
        this.jdField_a_of_type_Awtb = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_Awss == null) || (((View)this.jdField_b_of_type_Awss).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_Awtb == null);
        this.jdField_a_of_type_Awtb.onPlayEnd();
        this.jdField_a_of_type_Awtb = null;
        return;
        if ((this.jdField_a_of_type_Awsf == null) || (!this.jdField_a_of_type_Awsf.a())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_Awtb == null);
      this.jdField_a_of_type_Awtb.onPlayEnd();
      this.jdField_a_of_type_Awtb = null;
      return;
      if (paramInt1 != 1) {
        break;
      }
      this.jdField_a_of_type_Awrn = awsf.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Awrn != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_Awtb == null);
    this.jdField_a_of_type_Awtb.onPlayEnd();
    this.jdField_a_of_type_Awtb = null;
    return;
    this.jdField_a_of_type_JavaLangString = paramEmoticon.epId;
    b();
    this.jdField_a_of_type_Awsf = new awsf(this);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Awss).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_Awss;
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Awsf);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(0);
      ((SurfaceView)localObject2).setZOrderOnTop(true);
      ((SurfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new awsn();
      ((awsn)localObject3).a((awrz)localObject2);
      this.jdField_a_of_type_Awsf.a((awsn)localObject3);
      this.jdField_a_of_type_Awsf.a(new awsy(this, paramInt1, (TextView)localObject1));
      this.jdField_a_of_type_Awsf.a(new awsz(this, l, paramInt1));
      if (!((awss)localObject2).a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_Awsf.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_Awss, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.5(this));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Awss).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_Awss.setIsFullScreen(this.jdField_a_of_type_Awrn.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject2 = this.jdField_b_of_type_Awss;
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Awsf);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.8(this), 200L);
    ((awss)localObject2).setSurfaceCreatelistener(new awta(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void a(Emoticon paramEmoticon, awtb paramawtb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_Awtb = paramawtb;
    if (!a())
    {
      if (this.jdField_a_of_type_Awtb != null)
      {
        this.jdField_a_of_type_Awtb.onPlayEnd();
        this.jdField_a_of_type_Awtb = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      paramawtb = new Emoticon();
      paramawtb.eId = paramEmoticon.eId;
      paramawtb.epId = paramEmoticon.epId;
      paramawtb.magicValue = paramEmoticon.magicValue;
      paramawtb.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramawtb;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MagicfaceViewController.3(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideSoftInput();
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131561963, null);
        this.jdField_a_of_type_Awss = ((awss)localView.findViewById(2131370690));
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370691));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370704));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370692));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370701));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370689));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370702));
        this.e = ((Button)localView.findViewById(2131370703));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.e.setOnClickListener(this);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label415;
      }
    }
    label415:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131561962, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131561964, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2131561966, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370700);
      this.jdField_b_of_type_Awss = ((awss)localView.findViewById(2131370693));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370695));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370699));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370697));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370694));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370696));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370698));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
      }
      return;
      localView = View.inflate(BaseApplicationImpl.getContext(), 2131561965, null);
      break;
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Awsf != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      g();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Awsf.b())
    {
      this.e.setBackgroundResource(2130847191);
      return;
    }
    this.e.setBackgroundResource(2130847190);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Awsf.c())
    {
      this.f.setBackgroundResource(2130847140);
      return;
    }
    this.f.setBackgroundResource(2130847188);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.2(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_AndroidWidgetButton.getTag() == null) {}
    Emoticon localEmoticon;
    do
    {
      return;
      localEmoticon = (Emoticon)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    } while (localEmoticon.jobType != 2);
    if ((this.jdField_a_of_type_Awsf != null) && (this.jdField_a_of_type_Awsf.a() >= 0)) {
      if (this.jdField_a_of_type_Awsf.a() != 0) {
        break label83;
      }
    }
    label83:
    for (localEmoticon.magicValue = "value=1";; localEmoticon.magicValue = ("value=" + this.jdField_a_of_type_Awsf.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.magicfaceSend(localEmoticon);
      g();
      a(localEmoticon, null);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Awsf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_Awss).setVisibility(8);
      this.jdField_a_of_type_Awss.setSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_Awss).setVisibility(8);
      this.jdField_b_of_type_Awss.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView();
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label160:
      break label160;
    }
    if (this.jdField_a_of_type_Awsf.a())
    {
      localObject = this.jdField_a_of_type_Awsf;
      ((awsf)localObject).a(new awsx(this, (awsf)localObject));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awtb != null)
      {
        this.jdField_a_of_type_Awtb.onPlayEnd();
        this.jdField_a_of_type_Awtb = null;
      }
      return;
      this.jdField_a_of_type_Awsf.h();
    }
  }
  
  public void h()
  {
    g();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131370689: 
    case 2131370694: 
    case 2131370701: 
    case 2131370702: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        continue;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        continue;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        if (this.jdField_a_of_type_Awsf != null)
        {
          this.jdField_a_of_type_Awsf.f();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.1(this), 300L);
          continue;
          f();
        }
      }
    case 2131370703: 
      bool3 = this.jdField_a_of_type_Awsf.b();
      localawsf = this.jdField_a_of_type_Awsf;
      if (!bool3)
      {
        bool1 = true;
        label275:
        localawsf.a(bool1);
        c();
        localawsf = this.jdField_a_of_type_Awsf;
        if (bool3) {
          break label356;
        }
      }
      label356:
      for (bool1 = bool2;; bool1 = false)
      {
        localawsf.c(bool1);
        if (bool3) {
          break;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        break;
        bool1 = false;
        break label275;
      }
    }
    bool2 = this.jdField_a_of_type_Awsf.c();
    awsf localawsf = this.jdField_a_of_type_Awsf;
    if (!bool2)
    {
      bool1 = true;
      label381:
      localawsf.b(bool1);
      d();
      localawsf = this.jdField_a_of_type_Awsf;
      if (bool2) {
        break label461;
      }
    }
    label461:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localawsf.c(bool1);
      if (bool2) {
        break;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      break;
      bool1 = false;
      break label381;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsw
 * JD-Core Version:    0.7.0.1
 */