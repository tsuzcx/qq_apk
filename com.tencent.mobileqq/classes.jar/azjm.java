import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.2;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class azjm
  implements azjg
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aziz jdField_a_of_type_Aziz;
  private azjl jdField_a_of_type_Azjl;
  private azjn jdField_a_of_type_Azjn;
  private azjx jdField_a_of_type_Azjx;
  private azkc jdField_a_of_type_Azkc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private azjx b;
  
  public azjm(QQAppInterface paramQQAppInterface, aziz paramaziz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aziz = paramaziz;
    this.jdField_a_of_type_Azkc = new azkc();
    this.jdField_a_of_type_Azjn = new azjn(paramaziz);
    this.jdField_a_of_type_Azjl = new azjl();
  }
  
  private void b(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool1 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
      boolean bool2 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
      if (bool1)
      {
        this.jdField_a_of_type_Azjx = new azkb();
        if ((azjb.jdField_b_of_type_Int == 3) && (bool2)) {
          this.b = new azka();
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector mainSensor: " + azjb.jdField_a_of_type_Int + " secondarySensor: " + azjb.jdField_b_of_type_Int + " hasDetector: " + bool1 + " hasCounter: " + bool2 + " final sensor: " + this.jdField_a_of_type_Azjx.a());
        }
      }
    }
    for (;;)
    {
      if (azjb.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Azjl.a(this);
        this.jdField_a_of_type_Azjx.a(this);
        if (this.b != null) {
          this.b.a(this);
        }
      }
      return;
      if (azjb.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Azjx = new azjf();
        break;
      }
      this.jdField_a_of_type_Azjx = new azjw();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector compatibility. API<19 ACCELEROMETER");
      }
      if (azjb.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Azjx = new azjf();
      } else {
        this.jdField_a_of_type_Azjx = new azjw();
      }
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Azjx.b();
    int j = this.jdField_a_of_type_Azjl.a();
    if ((i == 0) && (j == 0)) {
      return 0;
    }
    return Math.max(j, i);
  }
  
  public void a()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
      if ((l < 40001L) || (l == 41042L) || (b() != 41042)) {
        break label112;
      }
      if (!AppInterface.isAppOnForeground(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label93;
      }
      this.jdField_a_of_type_Aziz.a();
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus ", Boolean.valueOf(bool1) });
      }
      return;
      label93:
      if (QLog.isColorLevel())
      {
        QLog.d("LocationBaseStateDetector", 2, "[status][auto] notifyCheckStatus background");
        bool1 = false;
        continue;
        label112:
        boolean bool2 = this.jdField_a_of_type_Azjx.a();
        if ((this.b == null) || (this.b.a())) {}
        for (bool1 = true;; bool1 = false)
        {
          boolean bool3 = this.jdField_a_of_type_Azjl.b();
          if (QLog.isColorLevel()) {
            QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus step1:", Boolean.valueOf(bool2), " step2:", Boolean.valueOf(bool1), " dist:", Boolean.valueOf(bool3) });
          }
          if ((!bool2) || (!bool1) || (!bool3)) {
            break label237;
          }
          this.jdField_a_of_type_Aziz.a();
          bool1 = true;
          break;
        }
      }
      else
      {
        label237:
        bool1 = false;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Azjn.a(paramLong);
  }
  
  public void a(Application paramApplication)
  {
    b(paramApplication);
    this.jdField_a_of_type_Azjx.a(this.jdField_a_of_type_Azkc);
    this.jdField_a_of_type_Azjx.a(paramApplication);
    if (this.b != null)
    {
      this.b.a(this.jdField_a_of_type_Azkc);
      this.b.a(paramApplication);
    }
    if (azjb.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Azjl.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationBaseStateDetector.1(this), azjb.i);
      return;
      this.jdField_a_of_type_Azkc.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] stopDetector. delay:", Boolean.valueOf(paramBoolean) });
    }
    if (azjb.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Azjl.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Azjx.a(paramBoolean);
      if (this.b != null) {
        this.b.a(paramBoolean);
      }
      this.jdField_a_of_type_Azjn.a();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
      this.jdField_a_of_type_Azkc.b();
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_Azjx.c();
    int j;
    if (this.b != null)
    {
      j = this.b.c();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getNewMovementStatus mainStatus:", Integer.valueOf(i), " assistStatus:", Integer.valueOf(j) });
      }
      if ((i == 40001) && (j == 41042)) {
        i = j;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_Azjl.a(this.jdField_a_of_type_Aziz.a());
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getNewMovementStatus  stepStatus: ", azjb.a(i), " distanceStatus:", azjb.a(j) });
      }
      if (j == 41042) {
        i = j;
      }
      return i;
    }
  }
  
  public void b()
  {
    Object localObject;
    int k;
    int i;
    if (QLog.isColorLevel())
    {
      if (!azjb.jdField_b_of_type_Boolean) {
        break label855;
      }
      localObject = this.jdField_a_of_type_Azjl.a();
      k = this.jdField_a_of_type_Azkc.b();
      j = this.jdField_a_of_type_Azjx.a();
      i = j;
      if (this.b != null)
      {
        int m = this.b.a();
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] mainStatus:", Integer.valueOf(j), " assistStatus:", Integer.valueOf(m) });
        }
        i = j;
        if (j == 40001) {
          if (m != 41012)
          {
            i = j;
            if (m != 41013) {}
          }
          else
          {
            i = m;
          }
        }
      }
      if ((k != 41014) && (k != 41031)) {
        break label867;
      }
    }
    label855:
    label867:
    for (int j = k;; j = i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LOC : ").append(localObject).append("\n").append("          ").append(this.jdField_a_of_type_Azjn.a()).append("\n").append("          updateTime : ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Azkc.a()))).append("\n");
      localStringBuilder.append("STEP: ").append(azjb.a(i)).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_Azjx.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_Azjx.b()) })).append("\n");
      if (this.b != null) {
        localStringBuilder.append("STEP2: ").append(azjb.a(i)).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.b.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.b.b()) })).append("\n");
      }
      if (azjb.jdField_b_of_type_Boolean)
      {
        i = this.jdField_a_of_type_Azjl.a(this.jdField_a_of_type_Aziz.a());
        localStringBuilder.append("DIST: ").append(azjb.a(i));
      }
      localStringBuilder.append("GPS : ").append(azjb.a(k)).append(" ").append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_Azkc.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_Azkc.b()) })).append("\n");
      if ((this.b != null) && (this.b.a() > 0L)) {
        localStringBuilder.append(" walk-time2: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.b.a()))).append("\n");
      }
      if (this.jdField_a_of_type_Azjx.a() > 0L) {
        localStringBuilder.append(" walk-time: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Azjx.a()))).append("\n");
      }
      if (this.jdField_a_of_type_Azkc.b() > 0L) {
        localStringBuilder.append(" still-time: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Azkc.b()))).append("\n");
      }
      localStringBuilder.append("LAST: ").append(azjb.a(j)).append(" at ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date())).append("\n");
      localStringBuilder.append("CATE: ").append(azjb.a(this.jdField_a_of_type_Azjn.a()));
      localObject = localStringBuilder.toString();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.post(new LocationBaseStateDetector.2(this, (String)localObject));
      }
      QLog.d("LocationBaseStateDetector", 2, "[status][autoLoc] detect. " + (String)localObject);
      return;
      localObject = this.jdField_a_of_type_Azkc.a();
      break;
    }
  }
  
  public int c()
  {
    int j = this.jdField_a_of_type_Azkc.b();
    int k = this.jdField_a_of_type_Azjx.a();
    int i = k;
    if (this.b != null)
    {
      int m = this.b.a();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getMovementStatus mainStatus:", Integer.valueOf(k), " assistStatus:", Integer.valueOf(m) });
      }
      i = k;
      if (k == 40001) {
        if (m != 41012)
        {
          i = k;
          if (m != 41013) {}
        }
        else
        {
          i = m;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getMovementStatus gpsStatus: ", azjb.a(j), " stepStatus: ", Integer.valueOf(i) });
    }
    if ((j == 41014) || (j == 41031)) {
      i = j;
    }
    return i;
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_Azjn.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, "[status][auto] getCategoryStatus return status: " + i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjm
 * JD-Core Version:    0.7.0.1
 */