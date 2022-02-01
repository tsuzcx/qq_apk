import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class azdf
  implements azdc
{
  private int jdField_a_of_type_Int;
  private azda jdField_a_of_type_Azda;
  private azdb jdField_a_of_type_Azdb = new azdb(this, azcv.F);
  private ArrayList<azex> jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  
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
      azex localazex1 = (azex)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      azex localazex2 = (azex)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      d3 = azdk.a(localazex1.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, localazex2.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      l = Math.abs(localazex2.jdField_a_of_type_Long - localazex1.jdField_a_of_type_Long);
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
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", azcv.a(41042) });
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
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", azcv.a(40001) });
    }
    return 40001;
  }
  
  public azex a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      localObject = null;
    }
    azex localazex;
    do
    {
      return localObject;
      localazex = (azex)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject = localazex;
    } while (System.currentTimeMillis() - localazex.jdField_a_of_type_Long <= azcv.N);
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
    }
    return null;
  }
  
  ArrayList<azex> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azex localazex = (azex)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localazex.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localazex);
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
    this.jdField_a_of_type_Azdb.b(azcv.I);
    this.jdField_a_of_type_Azdb.a();
  }
  
  public void a(azda paramazda)
  {
    this.jdField_a_of_type_Azda = paramazda;
  }
  
  public void a(azex paramazex)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 2) {
      this.jdField_a_of_type_Azdb.b(azcv.H);
    }
    b(paramazex);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramazex });
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
      azex localazex = (azex)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (System.currentTimeMillis() - localazex.jdField_a_of_type_Long <= azcv.H + 30000)
      {
        int i = ((ArrayList)localObject).size() - 2;
        if (i >= 0) {
          if (localazex.jdField_a_of_type_Long - ((azex)((ArrayList)localObject).get(i)).jdField_a_of_type_Long > azcv.K) {}
        }
        for (localObject = (azex)((ArrayList)localObject).get(i);; localObject = null)
        {
          if (localObject == null) {
            break label313;
          }
          double d = azdk.a(localazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((azex)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          long l = localazex.jdField_a_of_type_Long - ((azex)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazex.jdField_a_of_type_Long), " time2:", Long.valueOf(((azex)localObject).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
          }
          if (l <= azcv.I + 30000)
          {
            if (d >= azcv.J) {}
            for (bool = true;; bool = false)
            {
              return bool;
              i -= 1;
              break;
            }
          }
          if (d >= azcv.G) {}
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
    this.jdField_a_of_type_Azdb.b();
  }
  
  public void b(azex paramazex)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      azex localazex = (azex)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localazex.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localazex);
      }
      i += 1;
    }
    localArrayList.add(paramazex);
    if (QLog.isColorLevel())
    {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", Integer.valueOf(localArrayList.size()), " location:", paramazex });
      paramazex = new StringBuilder(10);
      i = 0;
      while (i < localArrayList.size())
      {
        paramazex.append(((azex)localArrayList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramazex.toString() });
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
    azex localazex = (azex)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - localazex.jdField_a_of_type_Long > azcv.H + 30000) {
      return false;
    }
    int i = ((ArrayList)localObject).size() - 2;
    if (i >= 0) {
      if (localazex.jdField_a_of_type_Long - ((azex)((ArrayList)localObject).get(i)).jdField_a_of_type_Long <= azcv.L) {}
    }
    for (localObject = (azex)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        double d = azdk.a(localazex.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((azex)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        if (QLog.isColorLevel()) {
          QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazex.jdField_a_of_type_Long), " time2:", Long.valueOf(((azex)localObject).jdField_a_of_type_Long) });
        }
        if (d < azcv.G)
        {
          return true;
          i -= 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localazex.jdField_a_of_type_Long) });
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
      if (this.jdField_a_of_type_Azda != null) {
        this.jdField_a_of_type_Azda.a();
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
 * Qualified Name:     azdf
 * JD-Core Version:    0.7.0.1
 */