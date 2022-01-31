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

public class awug
{
  private static awug jdField_a_of_type_Awug;
  private aman jdField_a_of_type_Aman;
  public boolean a;
  @Deprecated
  public boolean b;
  private boolean c;
  
  private awug()
  {
    ThreadManager.executeOnSubThread(new AIOVideoPlayController.1(this));
  }
  
  public static awug a()
  {
    if (jdField_a_of_type_Awug == null) {}
    try
    {
      if (jdField_a_of_type_Awug == null) {
        jdField_a_of_type_Awug = new awug();
      }
      return jdField_a_of_type_Awug;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Aman != null) {
      return this.jdField_a_of_type_Aman.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Aman != null) {
      return this.jdField_a_of_type_Aman.b;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Aman != null) {
      return this.jdField_a_of_type_Aman.c;
    }
    return false;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Aman != null) {
      return this.jdField_a_of_type_Aman.d;
    }
    return false;
  }
  
  public void a(aman paramaman)
  {
    this.jdField_a_of_type_Aman = paramaman;
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131310781);
    if (paramView != null) {
      paramView.c();
    }
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
        if ((!NetworkUtils.isWifiConnected(paramContext)) || (!bgmq.f(localQQAppInterface))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awug
 * JD-Core Version:    0.7.0.1
 */