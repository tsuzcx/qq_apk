import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class atpu
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<atpv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<atpq, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  atpu(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(atpq paramatpq)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramatpq);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramatpq, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramatpq, localLocationRoom1);
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
    paramString = new atpq(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((atpv)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(atpq paramatpq)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramatpq = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramatpq);
      if ((paramatpq != null) && (paramatpq.a() != null)) {
        paramatpq.a().a();
      }
      return;
    }
  }
  
  void a(atpq paramatpq, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramatpq)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramatpq);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((atpv)((Iterator)???).next()).b(paramatpq, paramInt);
        }
      }
    }
  }
  
  void a(atpq paramatpq, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((atpv)localIterator.next()).a(paramatpq, paramInt1, paramInt2);
    }
  }
  
  void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    LocationRoom localLocationRoom = a(paramatpq);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((atpv)paramList.next()).a(paramatpq, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(atpv paramatpv)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramatpv);
      return;
    }
  }
  
  void b(atpq paramatpq, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramatpq);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((atpv)((Iterator)???).next()).a(paramatpq, paramInt);
      }
    }
  }
  
  public void b(atpv paramatpv)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramatpv)) {
        this.jdField_a_of_type_JavaUtilList.add(paramatpv);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpu
 * JD-Core Version:    0.7.0.1
 */