import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class ayrj
  implements ayrg
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private ayqa jdField_a_of_type_Ayqa = new ayqa(40001);
  private ayqo jdField_a_of_type_Ayqo = new ayqo(new ayrk(this), Math.max(ayqi.e, ayqi.s));
  private ayqq jdField_a_of_type_Ayqq;
  private ayrb jdField_a_of_type_Ayrb;
  private aysk jdField_a_of_type_Aysk;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  private aysk jdField_b_of_type_Aysk;
  private boolean jdField_b_of_type_Boolean = true;
  
  ayrj()
  {
    a(false);
    this.jdField_a_of_type_Ayqq = new ayqq("vehicle", ayqi.C);
    this.jdField_a_of_type_Ayqq.a(new ayrl(this));
    this.jdField_a_of_type_Ayrb = new ayrb(ayqi.o, ayqi.p, new ayrm(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i = ayqi.n;; i = ayqi.m)
    {
      this.jdField_a_of_type_Ayqo.b(i);
      return;
    }
  }
  
  public double a()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public int a()
  {
    return ayqi.q;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Aysk == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Aysk.jdField_a_of_type_Long;
  }
  
  public aysk a()
  {
    if ((this.jdField_b_of_type_Aysk != null) && (this.jdField_b_of_type_Aysk.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] getLastLatLngForPOI. out of date location. location: " + this.jdField_b_of_type_Aysk);
      }
      this.jdField_b_of_type_Aysk = null;
    }
    return this.jdField_b_of_type_Aysk;
  }
  
  void a()
  {
    this.jdField_a_of_type_Ayqo.a();
    if (this.jdField_a_of_type_Ayqa.a("vehicle_start")) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(double paramDouble)
  {
    if (paramDouble > ayqi.w)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. Too fast rate : " + paramDouble);
      }
      return;
    }
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > ayqi.t))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. enter session rate : " + paramDouble);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ayrb.b();
      a(true);
      label114:
      if (!this.jdField_a_of_type_Boolean) {
        break label488;
      }
      if ((paramDouble <= ayqi.v) || (paramDouble >= ayqi.w)) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
      this.jdField_a_of_type_Ayqa.a(41014);
      this.jdField_a_of_type_Ayrb.b();
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
      if (l2 < ayqi.r) {
        break label114;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ayqa.a();
      this.jdField_a_of_type_Ayrb.b();
      a(false);
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by still. rate : " + paramDouble + " still time: " + l2);
      break label114;
      label355:
      if (this.jdField_a_of_type_Ayqa.a != 41014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_CYCLING rate : " + paramDouble);
        }
        this.jdField_a_of_type_Ayqa.a(41031);
        this.jdField_a_of_type_Ayrb.a();
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
      this.jdField_a_of_type_Ayrb.b();
      a(true);
    }
    if (this.jdField_b_of_type_Double < ayqi.t)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ayqa.a();
      this.jdField_a_of_type_Ayrb.b();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by step. rate : " + this.jdField_b_of_type_Double + " step time: " + paramLong2);
      }
    }
  }
  
  void a(aysk paramaysk)
  {
    if ((paramaysk == null) || (paramaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) || ((paramaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude == 0.0D) && (paramaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude == 0.0D)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaysk);
      }
      this.jdField_a_of_type_Ayqq.a();
      this.jdField_a_of_type_Ayqa.a();
    }
    long l;
    do
    {
      do
      {
        return;
        if (paramaysk.jdField_a_of_type_Float < ayqi.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect record poi loc: " + paramaysk);
          }
          this.jdField_b_of_type_Aysk = paramaysk;
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Boolean) || (paramaysk.jdField_a_of_type_Float <= ayqi.s)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaysk);
      return;
      if ((this.jdField_a_of_type_Aysk == null) || (this.jdField_a_of_type_Aysk.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. firstSet or reset mLastLocation: " + this.jdField_a_of_type_Aysk);
        }
        this.jdField_a_of_type_Aysk = paramaysk;
        return;
      }
      l -= this.jdField_a_of_type_Aysk.jdField_a_of_type_Long;
      if (l >= ayqi.n * 2 / 3)
      {
        double d = ayqx.a(this.jdField_a_of_type_Aysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng) / l * 3600.0D;
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramaysk + " internal " + l + " rate : " + d);
        }
        if (d < ayqi.w) {
          this.jdField_a_of_type_Ayqq.a(d);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aysk = paramaysk;
          this.jdField_a_of_type_Double = d;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. dirty rate : " + d);
          }
          this.jdField_a_of_type_Ayqq.a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. mLastLocation: " + this.jdField_a_of_type_Aysk + " internal: " + l);
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
    if (this.jdField_a_of_type_Ayqa.a("vehicle_getStatus")) {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Ayqa.a;
  }
  
  long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    this.jdField_a_of_type_Ayqo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrj
 * JD-Core Version:    0.7.0.1
 */