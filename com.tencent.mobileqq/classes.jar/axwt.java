import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class axwt
  implements axwq
{
  private int jdField_a_of_type_Int;
  private axwo jdField_a_of_type_Axwo;
  private axwp jdField_a_of_type_Axwp = new axwp(this, axwj.F);
  private ArrayList<axyl> jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  
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
      axyl localaxyl1 = (axyl)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      axyl localaxyl2 = (axyl)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      d3 = axwy.a(localaxyl1.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, localaxyl2.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      l = Math.abs(localaxyl2.jdField_a_of_type_Long - localaxyl1.jdField_a_of_type_Long);
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
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", axwj.a(41042) });
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
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", axwj.a(40001) });
    }
    return 40001;
  }
  
  public axyl a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      localObject = null;
    }
    axyl localaxyl;
    do
    {
      return localObject;
      localaxyl = (axyl)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject = localaxyl;
    } while (System.currentTimeMillis() - localaxyl.jdField_a_of_type_Long <= axwj.N);
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
    }
    return null;
  }
  
  ArrayList<axyl> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      axyl localaxyl = (axyl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localaxyl.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localaxyl);
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
    this.jdField_a_of_type_Axwp.b(axwj.I);
    this.jdField_a_of_type_Axwp.a();
  }
  
  public void a(axwo paramaxwo)
  {
    this.jdField_a_of_type_Axwo = paramaxwo;
  }
  
  public void a(axyl paramaxyl)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 2) {
      this.jdField_a_of_type_Axwp.b(axwj.H);
    }
    b(paramaxyl);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramaxyl });
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
      axyl localaxyl = (axyl)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (System.currentTimeMillis() - localaxyl.jdField_a_of_type_Long <= axwj.H + 30000)
      {
        int i = ((ArrayList)localObject).size() - 2;
        if (i >= 0) {
          if (localaxyl.jdField_a_of_type_Long - ((axyl)((ArrayList)localObject).get(i)).jdField_a_of_type_Long > axwj.K) {}
        }
        for (localObject = (axyl)((ArrayList)localObject).get(i);; localObject = null)
        {
          if (localObject == null) {
            break label313;
          }
          double d = axwy.a(localaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((axyl)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          long l = localaxyl.jdField_a_of_type_Long - ((axyl)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaxyl.jdField_a_of_type_Long), " time2:", Long.valueOf(((axyl)localObject).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
          }
          if (l <= axwj.I + 30000)
          {
            if (d >= axwj.J) {}
            for (bool = true;; bool = false)
            {
              return bool;
              i -= 1;
              break;
            }
          }
          if (d >= axwj.G) {}
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
    this.jdField_a_of_type_Axwp.b();
  }
  
  public void b(axyl paramaxyl)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      axyl localaxyl = (axyl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localaxyl.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localaxyl);
      }
      i += 1;
    }
    localArrayList.add(paramaxyl);
    if (QLog.isColorLevel())
    {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", Integer.valueOf(localArrayList.size()), " location:", paramaxyl });
      paramaxyl = new StringBuilder(10);
      i = 0;
      while (i < localArrayList.size())
      {
        paramaxyl.append(((axyl)localArrayList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramaxyl.toString() });
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
    axyl localaxyl = (axyl)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - localaxyl.jdField_a_of_type_Long > axwj.H + 30000) {
      return false;
    }
    int i = ((ArrayList)localObject).size() - 2;
    if (i >= 0) {
      if (localaxyl.jdField_a_of_type_Long - ((axyl)((ArrayList)localObject).get(i)).jdField_a_of_type_Long <= axwj.L) {}
    }
    for (localObject = (axyl)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        double d = axwy.a(localaxyl.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((axyl)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        if (QLog.isColorLevel()) {
          QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaxyl.jdField_a_of_type_Long), " time2:", Long.valueOf(((axyl)localObject).jdField_a_of_type_Long) });
        }
        if (d < axwj.G)
        {
          return true;
          i -= 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaxyl.jdField_a_of_type_Long) });
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
      if (this.jdField_a_of_type_Axwo != null) {
        this.jdField_a_of_type_Axwo.a();
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
 * Qualified Name:     axwt
 * JD-Core Version:    0.7.0.1
 */