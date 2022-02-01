import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class axxk
  implements axxh
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private axwb jdField_a_of_type_Axwb = new axwb(40001);
  private axwp jdField_a_of_type_Axwp = new axwp(new axxl(this), Math.max(axwj.e, axwj.s));
  private axwr jdField_a_of_type_Axwr;
  private axxc jdField_a_of_type_Axxc;
  private axyl jdField_a_of_type_Axyl;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  private axyl jdField_b_of_type_Axyl;
  private boolean jdField_b_of_type_Boolean = true;
  
  axxk()
  {
    a(false);
    this.jdField_a_of_type_Axwr = new axwr("vehicle", axwj.C);
    this.jdField_a_of_type_Axwr.a(new axxm(this));
    this.jdField_a_of_type_Axxc = new axxc(axwj.o, axwj.p, new axxn(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i = axwj.n;; i = axwj.m)
    {
      this.jdField_a_of_type_Axwp.b(i);
      return;
    }
  }
  
  public double a()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public int a()
  {
    return axwj.q;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Axyl == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Axyl.jdField_a_of_type_Long;
  }
  
  public axyl a()
  {
    if ((this.jdField_b_of_type_Axyl != null) && (this.jdField_b_of_type_Axyl.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] getLastLatLngForPOI. out of date location. location: " + this.jdField_b_of_type_Axyl);
      }
      this.jdField_b_of_type_Axyl = null;
    }
    return this.jdField_b_of_type_Axyl;
  }
  
  void a()
  {
    this.jdField_a_of_type_Axwp.a();
    if (this.jdField_a_of_type_Axwb.a("vehicle_start")) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(double paramDouble)
  {
    if (paramDouble > axwj.w)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. Too fast rate : " + paramDouble);
      }
      return;
    }
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > axwj.t))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. enter session rate : " + paramDouble);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Axxc.b();
      a(true);
      label114:
      if (!this.jdField_a_of_type_Boolean) {
        break label488;
      }
      if ((paramDouble <= axwj.v) || (paramDouble >= axwj.w)) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
      this.jdField_a_of_type_Axwb.a(41014);
      this.jdField_a_of_type_Axxc.b();
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
      if (l2 < axwj.r) {
        break label114;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Axwb.a();
      this.jdField_a_of_type_Axxc.b();
      a(false);
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by still. rate : " + paramDouble + " still time: " + l2);
      break label114;
      label355:
      if (this.jdField_a_of_type_Axwb.a != 41014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_CYCLING rate : " + paramDouble);
        }
        this.jdField_a_of_type_Axwb.a(41031);
        this.jdField_a_of_type_Axxc.a();
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
      this.jdField_a_of_type_Axxc.b();
      a(true);
    }
    if (this.jdField_b_of_type_Double < axwj.t)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Axwb.a();
      this.jdField_a_of_type_Axxc.b();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by step. rate : " + this.jdField_b_of_type_Double + " step time: " + paramLong2);
      }
    }
  }
  
  void a(axyl paramaxyl)
  {
    if ((paramaxyl == null) || (paramaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) || ((paramaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude == 0.0D) && (paramaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude == 0.0D)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaxyl);
      }
      this.jdField_a_of_type_Axwr.a();
      this.jdField_a_of_type_Axwb.a();
    }
    long l;
    do
    {
      do
      {
        return;
        if (paramaxyl.jdField_a_of_type_Float < axwj.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect record poi loc: " + paramaxyl);
          }
          this.jdField_b_of_type_Axyl = paramaxyl;
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Boolean) || (paramaxyl.jdField_a_of_type_Float <= axwj.s)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaxyl);
      return;
      if ((this.jdField_a_of_type_Axyl == null) || (this.jdField_a_of_type_Axyl.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. firstSet or reset mLastLocation: " + this.jdField_a_of_type_Axyl);
        }
        this.jdField_a_of_type_Axyl = paramaxyl;
        return;
      }
      l -= this.jdField_a_of_type_Axyl.jdField_a_of_type_Long;
      if (l >= axwj.n * 2 / 3)
      {
        double d = axwy.a(this.jdField_a_of_type_Axyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng) / l * 3600.0D;
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaxyl + " internal " + l + " rate : " + d);
        }
        if (d < axwj.w) {
          this.jdField_a_of_type_Axwr.a(d);
        }
        for (;;)
        {
          this.jdField_a_of_type_Axyl = paramaxyl;
          this.jdField_a_of_type_Double = d;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. dirty rate : " + d);
          }
          this.jdField_a_of_type_Axwr.a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. mLastLocation: " + this.jdField_a_of_type_Axyl + " internal: " + l);
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
    if (this.jdField_a_of_type_Axwb.a("vehicle_getStatus")) {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Axwb.a;
  }
  
  long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    this.jdField_a_of_type_Axwp.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxk
 * JD-Core Version:    0.7.0.1
 */