import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class aruq
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<arur> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<arum, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  aruq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(arum paramarum)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramarum);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramarum, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramarum, localLocationRoom1);
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
    paramString = new arum(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((arur)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(arum paramarum)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramarum = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramarum);
      if ((paramarum != null) && (paramarum.a() != null)) {
        paramarum.a().a();
      }
      return;
    }
  }
  
  void a(arum paramarum, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramarum)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramarum);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((arur)((Iterator)???).next()).b(paramarum, paramInt);
        }
      }
    }
  }
  
  void a(arum paramarum, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((arur)localIterator.next()).a(paramarum, paramInt1, paramInt2);
    }
  }
  
  void a(arum paramarum, LocationRoom.Venue paramVenue, List<aruk> paramList)
  {
    LocationRoom localLocationRoom = a(paramarum);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((arur)paramList.next()).a(paramarum, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(arur paramarur)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramarur);
      return;
    }
  }
  
  void b(arum paramarum, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramarum);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((arur)((Iterator)???).next()).a(paramarum, paramInt);
      }
    }
  }
  
  public void b(arur paramarur)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramarur)) {
        this.jdField_a_of_type_JavaUtilList.add(paramarur);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aruq
 * JD-Core Version:    0.7.0.1
 */