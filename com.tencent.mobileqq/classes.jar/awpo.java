import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class awpo
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<awpp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<awpk, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  awpo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(awpk paramawpk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramawpk);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramawpk, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramawpk, localLocationRoom1);
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
    paramString = new awpk(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((awpp)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(awpk paramawpk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramawpk = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramawpk);
      if ((paramawpk != null) && (paramawpk.a() != null)) {
        paramawpk.a().a();
      }
      return;
    }
  }
  
  void a(awpk paramawpk, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramawpk)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramawpk);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((awpp)((Iterator)???).next()).b(paramawpk, paramInt);
        }
      }
    }
  }
  
  void a(awpk paramawpk, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awpp)localIterator.next()).a(paramawpk, paramInt1, paramInt2);
    }
  }
  
  void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    LocationRoom localLocationRoom = a(paramawpk);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((awpp)paramList.next()).a(paramawpk, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(awpp paramawpp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramawpp);
      return;
    }
  }
  
  void b(awpk paramawpk, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramawpk);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((awpp)((Iterator)???).next()).a(paramawpk, paramInt);
      }
    }
  }
  
  public void b(awpp paramawpp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramawpp)) {
        this.jdField_a_of_type_JavaUtilList.add(paramawpp);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpo
 * JD-Core Version:    0.7.0.1
 */