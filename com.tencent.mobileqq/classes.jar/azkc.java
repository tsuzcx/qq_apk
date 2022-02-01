import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class azkc
  implements azjz
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private azit jdField_a_of_type_Azit = new azit(40001);
  private azjh jdField_a_of_type_Azjh = new azjh(new azkd(this), Math.max(azjb.e, azjb.s));
  private azjj jdField_a_of_type_Azjj;
  private azju jdField_a_of_type_Azju;
  private azld jdField_a_of_type_Azld;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  private azld jdField_b_of_type_Azld;
  private boolean jdField_b_of_type_Boolean = true;
  
  azkc()
  {
    a(false);
    this.jdField_a_of_type_Azjj = new azjj("vehicle", azjb.C);
    this.jdField_a_of_type_Azjj.a(new azke(this));
    this.jdField_a_of_type_Azju = new azju(azjb.o, azjb.p, new azkf(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i = azjb.n;; i = azjb.m)
    {
      this.jdField_a_of_type_Azjh.b(i);
      return;
    }
  }
  
  public double a()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public int a()
  {
    return azjb.q;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Azld == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Azld.jdField_a_of_type_Long;
  }
  
  public azld a()
  {
    if ((this.jdField_b_of_type_Azld != null) && (this.jdField_b_of_type_Azld.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] getLastLatLngForPOI. out of date location. location: " + this.jdField_b_of_type_Azld);
      }
      this.jdField_b_of_type_Azld = null;
    }
    return this.jdField_b_of_type_Azld;
  }
  
  void a()
  {
    this.jdField_a_of_type_Azjh.a();
    if (this.jdField_a_of_type_Azit.a("vehicle_start")) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(double paramDouble)
  {
    if (paramDouble > azjb.w)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. Too fast rate : " + paramDouble);
      }
      return;
    }
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > azjb.t))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. enter session rate : " + paramDouble);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Azju.b();
      a(true);
      label114:
      if (!this.jdField_a_of_type_Boolean) {
        break label488;
      }
      if ((paramDouble <= azjb.v) || (paramDouble >= azjb.w)) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
      this.jdField_a_of_type_Azit.a(41014);
      this.jdField_a_of_type_Azju.b();
      a(false);
    }
    for (;;)
    {
      if (paramDouble >= 3.0D) {
        break label451;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. still start rate : " + paramDouble);
      }
      this.jdField_a_of_type_Long = l1;
      return;
      if ((!this.jdField_a_of_type_Boolean) || (paramDouble >= 3.0D) || (this.jdField_a_of_type_Long <= 0L)) {
        break label114;
      }
      long l2 = l1 - this.jdField_a_of_type_Long;
      if (l2 < azjb.r) {
        break label114;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azit.a();
      this.jdField_a_of_type_Azju.b();
      a(false);
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by still. rate : " + paramDouble + " still time: " + l2);
      break label114;
      label355:
      if (this.jdField_a_of_type_Azit.a != 41014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_CYCLING rate : " + paramDouble);
        }
        this.jdField_a_of_type_Azit.a(41031);
        this.jdField_a_of_type_Azju.a();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
    }
    label451:
    if (QLog.isColorLevel()) {
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. still end rate : " + paramDouble);
    }
    this.jdField_a_of_type_Long = 0L;
    return;
    label488:
    if (QLog.isColorLevel()) {
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. out of session rate : " + paramDouble);
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_b_of_type_Long != paramLong1) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Long = paramLong1;
      this.jdField_a_of_type_Azju.b();
      a(true);
    }
    if (this.jdField_b_of_type_Double < azjb.t)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azit.a();
      this.jdField_a_of_type_Azju.b();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by step. rate : " + this.jdField_b_of_type_Double + " step time: " + paramLong2);
      }
    }
  }
  
  void a(azld paramazld)
  {
    if ((paramazld == null) || (paramazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) || ((paramazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude == 0.0D) && (paramazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude == 0.0D)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazld);
      }
      this.jdField_a_of_type_Azjj.a();
      this.jdField_a_of_type_Azit.a();
    }
    long l;
    do
    {
      do
      {
        return;
        if (paramazld.jdField_a_of_type_Float < azjb.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect record poi loc: " + paramazld);
          }
          this.jdField_b_of_type_Azld = paramazld;
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Boolean) || (paramazld.jdField_a_of_type_Float <= azjb.s)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazld);
      return;
      if ((this.jdField_a_of_type_Azld == null) || (this.jdField_a_of_type_Azld.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. firstSet or reset mLastLocation: " + this.jdField_a_of_type_Azld);
        }
        this.jdField_a_of_type_Azld = paramazld;
        return;
      }
      l -= this.jdField_a_of_type_Azld.jdField_a_of_type_Long;
      if (l >= azjb.n * 2 / 3)
      {
        double d = azjq.a(this.jdField_a_of_type_Azld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng) / l * 3600.0D;
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazld + " internal " + l + " rate : " + d);
        }
        if (d < azjb.w) {
          this.jdField_a_of_type_Azjj.a(d);
        }
        for (;;)
        {
          this.jdField_a_of_type_Azld = paramazld;
          this.jdField_a_of_type_Double = d;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. dirty rate : " + d);
          }
          this.jdField_a_of_type_Azjj.a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. mLastLocation: " + this.jdField_a_of_type_Azld + " internal: " + l);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  double b()
  {
    return this.jdField_a_of_type_Double;
  }
  
  int b()
  {
    if (this.jdField_a_of_type_Azit.a("vehicle_getStatus")) {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Azit.a;
  }
  
  long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    this.jdField_a_of_type_Azjh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkc
 * JD-Core Version:    0.7.0.1
 */