import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class atll
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<atlm> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<atlh, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  atll(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(atlh paramatlh)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramatlh);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramatlh, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramatlh, localLocationRoom1);
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
    paramString = new atlh(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((atlm)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(atlh paramatlh)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramatlh = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramatlh);
      if ((paramatlh != null) && (paramatlh.a() != null)) {
        paramatlh.a().a();
      }
      return;
    }
  }
  
  void a(atlh paramatlh, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramatlh)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramatlh);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((atlm)((Iterator)???).next()).b(paramatlh, paramInt);
        }
      }
    }
  }
  
  void a(atlh paramatlh, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((atlm)localIterator.next()).a(paramatlh, paramInt1, paramInt2);
    }
  }
  
  void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    LocationRoom localLocationRoom = a(paramatlh);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((atlm)paramList.next()).a(paramatlh, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(atlm paramatlm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramatlm);
      return;
    }
  }
  
  void b(atlh paramatlh, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramatlh);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((atlm)((Iterator)???).next()).a(paramatlh, paramInt);
      }
    }
  }
  
  public void b(atlm paramatlm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramatlm)) {
        this.jdField_a_of_type_JavaUtilList.add(paramatlm);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atll
 * JD-Core Version:    0.7.0.1
 */