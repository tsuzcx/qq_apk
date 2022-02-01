import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class azjl
  implements azji
{
  private int jdField_a_of_type_Int;
  private azjg jdField_a_of_type_Azjg;
  private azjh jdField_a_of_type_Azjh = new azjh(this, azjb.F);
  private ArrayList<azld> jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  
  public double a()
  {
    double d1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
      d1 = 0.0D;
    }
    double d3;
    long l;
    double d2;
    do
    {
      return d1;
      azld localazld1 = (azld)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      azld localazld2 = (azld)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      d3 = azjq.a(localazld1.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, localazld2.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      l = Math.abs(localazld2.jdField_a_of_type_Long - localazld1.jdField_a_of_type_Long);
      d2 = d3 / (l * 1.0D);
      d1 = d2;
    } while (!QLog.isColorLevel());
    QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getLastSampleRate. distance: " + d3, " interval: " + l, " rate: " + d2 });
    return d2;
  }
  
  public int a()
  {
    if (a()) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getFirstDelayForMoving no hit ");
    }
    return 150000;
  }
  
  public int a(int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", azjb.a(41042) });
      }
      paramInt = 41042;
    }
    do
    {
      return paramInt;
      if (paramInt != 41042) {
        break;
      }
    } while (!b());
    return 40001;
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", azjb.a(40001) });
    }
    return 40001;
  }
  
  public azld a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      localObject = null;
    }
    azld localazld;
    do
    {
      return localObject;
      localazld = (azld)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject = localazld;
    } while (System.currentTimeMillis() - localazld.jdField_a_of_type_Long <= azjb.N);
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
    }
    return null;
  }
  
  ArrayList<azld> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azld localazld = (azld)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localazld.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localazld);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] startDetector.");
    }
    this.jdField_a_of_type_Azjh.b(azjb.I);
    this.jdField_a_of_type_Azjh.a();
  }
  
  public void a(azjg paramazjg)
  {
    this.jdField_a_of_type_Azjg = paramazjg;
  }
  
  public void a(azld paramazld)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 2) {
      this.jdField_a_of_type_Azjh.b(azjb.H);
    }
    b(paramazld);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramazld });
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    Object localObject = a();
    if (((ArrayList)localObject).size() < 2) {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isMoving size < 2");
      }
    }
    label313:
    for (;;)
    {
      return false;
      azld localazld = (azld)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (System.currentTimeMillis() - localazld.jdField_a_of_type_Long <= azjb.H + 30000)
      {
        int i = ((ArrayList)localObject).size() - 2;
        if (i >= 0) {
          if (localazld.jdField_a_of_type_Long - ((azld)((ArrayList)localObject).get(i)).jdField_a_of_type_Long > azjb.K) {}
        }
        for (localObject = (azld)((ArrayList)localObject).get(i);; localObject = null)
        {
          if (localObject == null) {
            break label313;
          }
          double d = azjq.a(localazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((azld)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          long l = localazld.jdField_a_of_type_Long - ((azld)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazld.jdField_a_of_type_Long), " time2:", Long.valueOf(((azld)localObject).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
          }
          if (l <= azjb.I + 30000)
          {
            if (d >= azjb.J) {}
            for (bool = true;; bool = false)
            {
              return bool;
              i -= 1;
              break;
            }
          }
          if (d >= azjb.G) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] stopDetector.");
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Azjh.b();
  }
  
  public void b(azld paramazld)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      azld localazld = (azld)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localazld.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localazld);
      }
      i += 1;
    }
    localArrayList.add(paramazld);
    if (QLog.isColorLevel())
    {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", Integer.valueOf(localArrayList.size()), " location:", paramazld });
      paramazld = new StringBuilder(10);
      i = 0;
      while (i < localArrayList.size())
      {
        paramazld.append(((azld)localArrayList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramazld.toString() });
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public boolean b()
  {
    Object localObject = a();
    if (((ArrayList)localObject).size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isNotMoving size < 2");
      }
      return false;
    }
    azld localazld = (azld)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - localazld.jdField_a_of_type_Long > azjb.H + 30000) {
      return false;
    }
    int i = ((ArrayList)localObject).size() - 2;
    if (i >= 0) {
      if (localazld.jdField_a_of_type_Long - ((azld)((ArrayList)localObject).get(i)).jdField_a_of_type_Long <= azjb.L) {}
    }
    for (localObject = (azld)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        double d = azjq.a(localazld.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((azld)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        if (QLog.isColorLevel()) {
          QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazld.jdField_a_of_type_Long), " time2:", Long.valueOf(((azld)localObject).jdField_a_of_type_Long) });
        }
        if (d < azjb.G)
        {
          return true;
          i -= 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazld.jdField_a_of_type_Long) });
      }
      return false;
    }
  }
  
  public void c()
  {
    boolean bool1 = b();
    boolean bool2 = a();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] notifyCheckStatus notmoving:", Boolean.valueOf(bool1), " isMoving:", Boolean.valueOf(bool2) });
    }
    if ((bool1) || (bool2)) {
      if (this.jdField_a_of_type_Azjg != null) {
        this.jdField_a_of_type_Azjg.a();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus listener empty");
      return;
    }
    QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus miss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjl
 * JD-Core Version:    0.7.0.1
 */