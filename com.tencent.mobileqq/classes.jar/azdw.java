import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class azdw
  implements azdt
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private azcn jdField_a_of_type_Azcn = new azcn(40001);
  private azdb jdField_a_of_type_Azdb = new azdb(new azdx(this), Math.max(azcv.e, azcv.s));
  private azdd jdField_a_of_type_Azdd;
  private azdo jdField_a_of_type_Azdo;
  private azex jdField_a_of_type_Azex;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  private azex jdField_b_of_type_Azex;
  private boolean jdField_b_of_type_Boolean = true;
  
  azdw()
  {
    a(false);
    this.jdField_a_of_type_Azdd = new azdd("vehicle", azcv.C);
    this.jdField_a_of_type_Azdd.a(new azdy(this));
    this.jdField_a_of_type_Azdo = new azdo(azcv.o, azcv.p, new azdz(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i = azcv.n;; i = azcv.m)
    {
      this.jdField_a_of_type_Azdb.b(i);
      return;
    }
  }
  
  public double a()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public int a()
  {
    return azcv.q;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Azex == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Azex.jdField_a_of_type_Long;
  }
  
  public azex a()
  {
    if ((this.jdField_b_of_type_Azex != null) && (this.jdField_b_of_type_Azex.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] getLastLatLngForPOI. out of date location. location: " + this.jdField_b_of_type_Azex);
      }
      this.jdField_b_of_type_Azex = null;
    }
    return this.jdField_b_of_type_Azex;
  }
  
  void a()
  {
    this.jdField_a_of_type_Azdb.a();
    if (this.jdField_a_of_type_Azcn.a("vehicle_start")) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(double paramDouble)
  {
    if (paramDouble > azcv.w)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. Too fast rate : " + paramDouble);
      }
      return;
    }
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > azcv.t))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. enter session rate : " + paramDouble);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Azdo.b();
      a(true);
      label114:
      if (!this.jdField_a_of_type_Boolean) {
        break label488;
      }
      if ((paramDouble <= azcv.v) || (paramDouble >= azcv.w)) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
      this.jdField_a_of_type_Azcn.a(41014);
      this.jdField_a_of_type_Azdo.b();
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
      if (l2 < azcv.r) {
        break label114;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azcn.a();
      this.jdField_a_of_type_Azdo.b();
      a(false);
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by still. rate : " + paramDouble + " still time: " + l2);
      break label114;
      label355:
      if (this.jdField_a_of_type_Azcn.a != 41014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_CYCLING rate : " + paramDouble);
        }
        this.jdField_a_of_type_Azcn.a(41031);
        this.jdField_a_of_type_Azdo.a();
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
      this.jdField_a_of_type_Azdo.b();
      a(true);
    }
    if (this.jdField_b_of_type_Double < azcv.t)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azcn.a();
      this.jdField_a_of_type_Azdo.b();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by step. rate : " + this.jdField_b_of_type_Double + " step time: " + paramLong2);
      }
    }
  }
  
  void a(azex paramazex)
  {
    if ((paramazex == null) || (paramazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) || ((paramazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude == 0.0D) && (paramazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude == 0.0D)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazex);
      }
      this.jdField_a_of_type_Azdd.a();
      this.jdField_a_of_type_Azcn.a();
    }
    long l;
    do
    {
      do
      {
        return;
        if (paramazex.jdField_a_of_type_Float < azcv.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect record poi loc: " + paramazex);
          }
          this.jdField_b_of_type_Azex = paramazex;
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Boolean) || (paramazex.jdField_a_of_type_Float <= azcv.s)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazex);
      return;
      if ((this.jdField_a_of_type_Azex == null) || (this.jdField_a_of_type_Azex.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. firstSet or reset mLastLocation: " + this.jdField_a_of_type_Azex);
        }
        this.jdField_a_of_type_Azex = paramazex;
        return;
      }
      l -= this.jdField_a_of_type_Azex.jdField_a_of_type_Long;
      if (l >= azcv.n * 2 / 3)
      {
        double d = azdk.a(this.jdField_a_of_type_Azex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng) / l * 3600.0D;
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramazex + " internal " + l + " rate : " + d);
        }
        if (d < azcv.w) {
          this.jdField_a_of_type_Azdd.a(d);
        }
        for (;;)
        {
          this.jdField_a_of_type_Azex = paramazex;
          this.jdField_a_of_type_Double = d;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. dirty rate : " + d);
          }
          this.jdField_a_of_type_Azdd.a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. mLastLocation: " + this.jdField_a_of_type_Azex + " internal: " + l);
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
    if (this.jdField_a_of_type_Azcn.a("vehicle_getStatus")) {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Azcn.a;
  }
  
  long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    this.jdField_a_of_type_Azdb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdw
 * JD-Core Version:    0.7.0.1
 */