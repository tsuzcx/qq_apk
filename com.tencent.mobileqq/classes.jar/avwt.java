import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class avwt
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<avwu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<avwp, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  avwt(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(avwp paramavwp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramavwp);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramavwp, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramavwp, localLocationRoom1);
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
    paramString = new avwp(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((avwu)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(avwp paramavwp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramavwp = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramavwp);
      if ((paramavwp != null) && (paramavwp.a() != null)) {
        paramavwp.a().a();
      }
      return;
    }
  }
  
  void a(avwp paramavwp, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramavwp)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramavwp);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((avwu)((Iterator)???).next()).b(paramavwp, paramInt);
        }
      }
    }
  }
  
  void a(avwp paramavwp, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avwu)localIterator.next()).a(paramavwp, paramInt1, paramInt2);
    }
  }
  
  void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    LocationRoom localLocationRoom = a(paramavwp);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((avwu)paramList.next()).a(paramavwp, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(avwu paramavwu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramavwu);
      return;
    }
  }
  
  void b(avwp paramavwp, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramavwp);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((avwu)((Iterator)???).next()).a(paramavwp, paramInt);
      }
    }
  }
  
  public void b(avwu paramavwu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramavwu)) {
        this.jdField_a_of_type_JavaUtilList.add(paramavwu);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwt
 * JD-Core Version:    0.7.0.1
 */