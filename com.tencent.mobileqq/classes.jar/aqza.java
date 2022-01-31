import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class aqza
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<aqzb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<aqyw, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  aqza(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(aqyw paramaqyw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramaqyw);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramaqyw, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramaqyw, localLocationRoom1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "getLocationRoom: invoked. mLocationRoomMap size: " + this.jdField_a_of_type_JavaUtilMap.size() + " locationRoom: " + localLocationRoom1);
      }
      return localLocationRoom1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    paramString = new aqyw(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((aqzb)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(aqyw paramaqyw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramaqyw = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramaqyw);
      if ((paramaqyw != null) && (paramaqyw.a() != null)) {
        paramaqyw.a().a();
      }
      return;
    }
  }
  
  void a(aqyw paramaqyw, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramaqyw)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramaqyw);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((aqzb)((Iterator)???).next()).b(paramaqyw, paramInt);
        }
      }
    }
  }
  
  void a(aqyw paramaqyw, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aqzb)localIterator.next()).a(paramaqyw, paramInt1, paramInt2);
    }
  }
  
  void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    LocationRoom localLocationRoom = a(paramaqyw);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((aqzb)paramList.next()).a(paramaqyw, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(aqzb paramaqzb)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramaqzb);
      return;
    }
  }
  
  void b(aqyw paramaqyw, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramaqyw);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((aqzb)((Iterator)???).next()).a(paramaqyw, paramInt);
      }
    }
  }
  
  public void b(aqzb paramaqzb)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramaqzb)) {
        this.jdField_a_of_type_JavaUtilList.add(paramaqzb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqza
 * JD-Core Version:    0.7.0.1
 */