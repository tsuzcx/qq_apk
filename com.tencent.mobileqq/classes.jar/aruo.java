import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class aruo
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<arup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<aruk, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  aruo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(aruk paramaruk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramaruk);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramaruk, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramaruk, localLocationRoom1);
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
    paramString = new aruk(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((arup)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(aruk paramaruk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramaruk = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramaruk);
      if ((paramaruk != null) && (paramaruk.a() != null)) {
        paramaruk.a().a();
      }
      return;
    }
  }
  
  void a(aruk paramaruk, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramaruk)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramaruk);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((arup)((Iterator)???).next()).b(paramaruk, paramInt);
        }
      }
    }
  }
  
  void a(aruk paramaruk, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((arup)localIterator.next()).a(paramaruk, paramInt1, paramInt2);
    }
  }
  
  void a(aruk paramaruk, LocationRoom.Venue paramVenue, List<arui> paramList)
  {
    LocationRoom localLocationRoom = a(paramaruk);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((arup)paramList.next()).a(paramaruk, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(arup paramarup)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramarup);
      return;
    }
  }
  
  void b(aruk paramaruk, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramaruk);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((arup)((Iterator)???).next()).a(paramaruk, paramInt);
      }
    }
  }
  
  public void b(arup paramarup)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramarup)) {
        this.jdField_a_of_type_JavaUtilList.add(paramarup);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aruo
 * JD-Core Version:    0.7.0.1
 */