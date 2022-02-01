import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class awix
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<awiy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<awit, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  awix(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(awit paramawit)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramawit);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramawit, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramawit, localLocationRoom1);
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
    paramString = new awit(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((awiy)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(awit paramawit)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramawit = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramawit);
      if ((paramawit != null) && (paramawit.a() != null)) {
        paramawit.a().a();
      }
      return;
    }
  }
  
  void a(awit paramawit, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramawit)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramawit);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((awiy)((Iterator)???).next()).b(paramawit, paramInt);
        }
      }
    }
  }
  
  void a(awit paramawit, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awiy)localIterator.next()).a(paramawit, paramInt1, paramInt2);
    }
  }
  
  void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    LocationRoom localLocationRoom = a(paramawit);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((awiy)paramList.next()).a(paramawit, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(awiy paramawiy)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramawiy);
      return;
    }
  }
  
  void b(awit paramawit, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramawit);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((awiy)((Iterator)???).next()).a(paramawit, paramInt);
      }
    }
  }
  
  public void b(awiy paramawiy)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramawiy)) {
        this.jdField_a_of_type_JavaUtilList.add(paramawiy);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awix
 * JD-Core Version:    0.7.0.1
 */