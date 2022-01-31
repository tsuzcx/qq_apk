import android.graphics.Rect;
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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.1;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.2;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.3;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.5;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.8;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arhw
  implements View.OnClickListener
{
  public static boolean a;
  protected Handler a;
  protected View a;
  protected WindowManager a;
  protected Button a;
  public ImageView a;
  public TextView a;
  protected argn a;
  public arhf a;
  protected arhs a;
  protected arib a;
  public BaseChatPie a;
  public Emoticon a;
  protected MagicfaceContainerView a;
  Runnable a;
  protected String a;
  protected View b;
  protected Button b;
  public TextView b;
  public arhs b;
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
    String str1 = babp.g();
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
  
  public arhw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
    if (!babp.d())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(babp.g(), babp.h()) >= 720L)
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
    localLayoutParams.type = 2002;
    localLayoutParams.flags = 131112;
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
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
      }
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    azfo localazfo = (azfo)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(223);
    if ((localazfo != null) && (localazfo.a != 1)) {
      localazfo.e();
    }
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Arhs != null) && (((View)this.jdField_a_of_type_Arhs).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_Arib != null)
      {
        this.jdField_a_of_type_Arib.a();
        this.jdField_a_of_type_Arib = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_Arhs == null) || (((View)this.jdField_b_of_type_Arhs).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_Arib == null);
        this.jdField_a_of_type_Arib.a();
        this.jdField_a_of_type_Arib = null;
        return;
        if ((this.jdField_a_of_type_Arhf == null) || (!this.jdField_a_of_type_Arhf.a())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_Arib == null);
      this.jdField_a_of_type_Arib.a();
      this.jdField_a_of_type_Arib = null;
      return;
      if (paramInt1 != 1) {
        break;
      }
      this.jdField_a_of_type_Argn = arhf.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Argn != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_Arib == null);
    this.jdField_a_of_type_Arib.a();
    this.jdField_a_of_type_Arib = null;
    return;
    this.jdField_a_of_type_JavaLangString = paramEmoticon.epId;
    b();
    this.jdField_a_of_type_Arhf = new arhf(this);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Arhs).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_Arhs;
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Arhf);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(0);
      ((SurfaceView)localObject2).setZOrderOnTop(true);
      ((SurfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new arhn();
      ((arhn)localObject3).a((argz)localObject2);
      this.jdField_a_of_type_Arhf.a((arhn)localObject3);
      this.jdField_a_of_type_Arhf.a(new arhy(this, paramInt1, (TextView)localObject1));
      this.jdField_a_of_type_Arhf.a(new arhz(this, l, paramInt1));
      if (!((arhs)localObject2).a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_Arhf.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_Arhs, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.5(this));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Arhs).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_Arhs.setIsFullScreen(this.jdField_a_of_type_Argn.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject2 = this.jdField_b_of_type_Arhs;
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Arhf);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.8(this), 200L);
    ((arhs)localObject2).setSurfaceCreatelistener(new aria(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void a(Emoticon paramEmoticon, arib paramarib)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_Arib = paramarib;
    if (!a())
    {
      if (this.jdField_a_of_type_Arib != null)
      {
        this.jdField_a_of_type_Arib.a();
        this.jdField_a_of_type_Arib = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      paramarib = new Emoticon();
      paramarib.eId = paramEmoticon.eId;
      paramarib.epId = paramEmoticon.epId;
      paramarib.magicValue = paramEmoticon.magicValue;
      paramarib.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramarib;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.al();
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131495939, null);
        this.jdField_a_of_type_Arhs = ((arhs)localView.findViewById(2131304041));
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131304042));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304055));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304043));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131304052));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131304040));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131304053));
        this.e = ((Button)localView.findViewById(2131304054));
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
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131495938, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131495940, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2131495942, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131304051);
      this.jdField_b_of_type_Arhs = ((arhs)localView.findViewById(2131304044));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131304046));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304050));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304048));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131304045));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131304047));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304049));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
      }
      return;
      localView = View.inflate(BaseApplicationImpl.getContext(), 2131495941, null);
      break;
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Arhf != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      g();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Arhf.b())
    {
      this.e.setBackgroundResource(2130846081);
      return;
    }
    this.e.setBackgroundResource(2130846080);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arhf.c())
    {
      this.f.setBackgroundResource(2130846036);
      return;
    }
    this.f.setBackgroundResource(2130846078);
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
    if ((this.jdField_a_of_type_Arhf != null) && (this.jdField_a_of_type_Arhf.a() >= 0)) {
      if (this.jdField_a_of_type_Arhf.a() != 0) {
        break label83;
      }
    }
    label83:
    for (localEmoticon.magicValue = "value=1";; localEmoticon.magicValue = ("value=" + this.jdField_a_of_type_Arhf.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localEmoticon);
      g();
      a(localEmoticon, null);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Arhf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_Arhs).setVisibility(8);
      this.jdField_a_of_type_Arhs.setSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_Arhs).setVisibility(8);
      this.jdField_b_of_type_Arhs.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
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
    if (this.jdField_a_of_type_Arhf.a())
    {
      localObject = this.jdField_a_of_type_Arhf;
      ((arhf)localObject).a(new arhx(this, (arhf)localObject));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Arib != null)
      {
        this.jdField_a_of_type_Arib.a();
        this.jdField_a_of_type_Arib = null;
      }
      return;
      this.jdField_a_of_type_Arhf.h();
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
    case 2131304040: 
    case 2131304045: 
    case 2131304052: 
      do
      {
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      } while (this.jdField_a_of_type_Arhf == null);
      this.jdField_a_of_type_Arhf.f();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.1(this), 300L);
      return;
    case 2131304053: 
      f();
      return;
    case 2131304054: 
      bool3 = this.jdField_a_of_type_Arhf.b();
      paramView = this.jdField_a_of_type_Arhf;
      if (!bool3)
      {
        bool1 = true;
        label259:
        paramView.a(bool1);
        c();
        paramView = this.jdField_a_of_type_Arhf;
        if (bool3) {
          break label335;
        }
      }
      label335:
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        if (bool3) {
          break;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        return;
        bool1 = false;
        break label259;
      }
    }
    bool2 = this.jdField_a_of_type_Arhf.c();
    paramView = this.jdField_a_of_type_Arhf;
    if (!bool2)
    {
      bool1 = true;
      label359:
      paramView.b(bool1);
      d();
      paramView = this.jdField_a_of_type_Arhf;
      if (bool2) {
        break label434;
      }
    }
    label434:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramView.c(bool1);
      if (bool2) {
        break;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break label359;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arhw
 * JD-Core Version:    0.7.0.1
 */