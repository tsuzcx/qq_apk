import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class avcu
{
  private static String b = "LocationDataHandler";
  private String jdField_a_of_type_JavaLangString;
  private final List<avcv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<avcq, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  avcu(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(avcq paramavcq)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramavcq);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramavcq, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramavcq, localLocationRoom1);
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
    paramString = new avcq(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((avcv)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  void a(avcq paramavcq)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramavcq = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramavcq);
      if ((paramavcq != null) && (paramavcq.a() != null)) {
        paramavcq.a().a();
      }
      return;
    }
  }
  
  void a(avcq paramavcq, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramavcq)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramavcq);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((avcv)((Iterator)???).next()).b(paramavcq, paramInt);
        }
      }
    }
  }
  
  void a(avcq paramavcq, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avcv)localIterator.next()).a(paramavcq, paramInt1, paramInt2);
    }
  }
  
  void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    LocationRoom localLocationRoom = a(paramavcq);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((avcv)paramList.next()).a(paramavcq, paramVenue, localLocationRoom.c());
    }
  }
  
  public void a(avcv paramavcv)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramavcv);
      return;
    }
  }
  
  void b(avcq paramavcq, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramavcq);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)???).hasNext()) {
        ((avcv)((Iterator)???).next()).a(paramavcq, paramInt);
      }
    }
  }
  
  public void b(avcv paramavcv)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramavcv)) {
        this.jdField_a_of_type_JavaUtilList.add(paramavcv);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcu
 * JD-Core Version:    0.7.0.1
 */