import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ayqs
  implements ayqp
{
  private int jdField_a_of_type_Int;
  private ayqn jdField_a_of_type_Ayqn;
  private ayqo jdField_a_of_type_Ayqo = new ayqo(this, ayqi.F);
  private ArrayList<aysk> jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  
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
      aysk localaysk1 = (aysk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      aysk localaysk2 = (aysk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      d3 = ayqx.a(localaysk1.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, localaysk2.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      l = Math.abs(localaysk2.jdField_a_of_type_Long - localaysk1.jdField_a_of_type_Long);
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
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", ayqi.a(41042) });
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
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", ayqi.a(40001) });
    }
    return 40001;
  }
  
  public aysk a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      localObject = null;
    }
    aysk localaysk;
    do
    {
      return localObject;
      localaysk = (aysk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject = localaysk;
    } while (System.currentTimeMillis() - localaysk.jdField_a_of_type_Long <= ayqi.N);
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
    }
    return null;
  }
  
  ArrayList<aysk> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      aysk localaysk = (aysk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localaysk.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localaysk);
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
    this.jdField_a_of_type_Ayqo.b(ayqi.I);
    this.jdField_a_of_type_Ayqo.a();
  }
  
  public void a(ayqn paramayqn)
  {
    this.jdField_a_of_type_Ayqn = paramayqn;
  }
  
  public void a(aysk paramaysk)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 2) {
      this.jdField_a_of_type_Ayqo.b(ayqi.H);
    }
    b(paramaysk);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramaysk });
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
      aysk localaysk = (aysk)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (System.currentTimeMillis() - localaysk.jdField_a_of_type_Long <= ayqi.H + 30000)
      {
        int i = ((ArrayList)localObject).size() - 2;
        if (i >= 0) {
          if (localaysk.jdField_a_of_type_Long - ((aysk)((ArrayList)localObject).get(i)).jdField_a_of_type_Long > ayqi.K) {}
        }
        for (localObject = (aysk)((ArrayList)localObject).get(i);; localObject = null)
        {
          if (localObject == null) {
            break label313;
          }
          double d = ayqx.a(localaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((aysk)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          long l = localaysk.jdField_a_of_type_Long - ((aysk)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaysk.jdField_a_of_type_Long), " time2:", Long.valueOf(((aysk)localObject).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
          }
          if (l <= ayqi.I + 30000)
          {
            if (d >= ayqi.J) {}
            for (bool = true;; bool = false)
            {
              return bool;
              i -= 1;
              break;
            }
          }
          if (d >= ayqi.G) {}
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
    this.jdField_a_of_type_Ayqo.b();
  }
  
  public void b(aysk paramaysk)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      aysk localaysk = (aysk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localaysk.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localaysk);
      }
      i += 1;
    }
    localArrayList.add(paramaysk);
    if (QLog.isColorLevel())
    {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", Integer.valueOf(localArrayList.size()), " location:", paramaysk });
      paramaysk = new StringBuilder(10);
      i = 0;
      while (i < localArrayList.size())
      {
        paramaysk.append(((aysk)localArrayList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramaysk.toString() });
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
    aysk localaysk = (aysk)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - localaysk.jdField_a_of_type_Long > ayqi.H + 30000) {
      return false;
    }
    int i = ((ArrayList)localObject).size() - 2;
    if (i >= 0) {
      if (localaysk.jdField_a_of_type_Long - ((aysk)((ArrayList)localObject).get(i)).jdField_a_of_type_Long <= ayqi.L) {}
    }
    for (localObject = (aysk)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        double d = ayqx.a(localaysk.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((aysk)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        if (QLog.isColorLevel()) {
          QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaysk.jdField_a_of_type_Long), " time2:", Long.valueOf(((aysk)localObject).jdField_a_of_type_Long) });
        }
        if (d < ayqi.G)
        {
          return true;
          i -= 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localaysk.jdField_a_of_type_Long) });
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
      if (this.jdField_a_of_type_Ayqn != null) {
        this.jdField_a_of_type_Ayqn.a();
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
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */