import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController.1;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;

public class bdnp
{
  private static bdnp jdField_a_of_type_Bdnp;
  private aqyg jdField_a_of_type_Aqyg;
  public boolean a;
  @Deprecated
  public boolean b;
  private boolean c;
  
  private bdnp()
  {
    ThreadManager.executeOnSubThread(new AIOVideoPlayController.1(this));
  }
  
  public static bdnp a()
  {
    if (jdField_a_of_type_Bdnp == null) {}
    try
    {
      if (jdField_a_of_type_Bdnp == null) {
        jdField_a_of_type_Bdnp = new bdnp();
      }
      return jdField_a_of_type_Bdnp;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Aqyg != null) {
      return this.jdField_a_of_type_Aqyg.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Aqyg != null) {
      return this.jdField_a_of_type_Aqyg.b;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Aqyg != null) {
      return this.jdField_a_of_type_Aqyg.c;
    }
    return false;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Aqyg != null) {
      return this.jdField_a_of_type_Aqyg.d;
    }
    return false;
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131378150);
    if (paramView != null) {
      paramView.c();
    }
  }
  
  public void a(aqyg paramaqyg)
  {
    this.jdField_a_of_type_Aqyg = paramaqyg;
  }
  
  public boolean a()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 8) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(localObject[7]) != 0) {
          continue;
        }
        this.c = false;
        if (Integer.parseInt(localObject[9]) != 0) {
          continue;
        }
        this.b = false;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.b = true;
        continue;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): mDPCAllow =" + this.c + ", mEnbleAutoPlayInNotPAAIO = " + this.b);
      }
      return this.c;
      this.c = true;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (a())
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null) {
        return false;
      }
      if (paramInt1 == 3)
      {
        if ((!NetworkUtils.isWifiConnected(paramContext)) || (!bmhv.e(localQQAppInterface))) {
          break label169;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "allowAutoPlay(): playType=" + paramInt1 + ", uinType = " + paramInt2 + ", result = " + bool + ", mDPCAllow = " + this.c);
      }
      return bool;
      if (paramInt1 == 1)
      {
        if (paramInt2 == 1) {
          bool = b();
        } else {
          bool = c();
        }
      }
      else if (paramInt1 == 2)
      {
        if (paramInt2 == 1) {
          bool = d();
        } else {
          bool = e();
        }
      }
      else {
        label169:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnp
 * JD-Core Version:    0.7.0.1
 */