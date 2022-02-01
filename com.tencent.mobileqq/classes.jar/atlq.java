import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class atlq
  extends atls
{
  Comparator<FavFileInfo> jdField_a_of_type_JavaUtilComparator = new atlr(this);
  Map<Long, FavFileInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  atlq(atlm paramatlm)
  {
    super(paramatlm);
  }
  
  FavFileInfo a(long paramLong)
  {
    return (FavFileInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
  }
  
  List<FavFileInfo> a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    if (paramInt == 2) {
      return this.b;
    }
    if (paramInt == 3) {
      return this.c;
    }
    if (paramInt == 4) {
      return this.d;
    }
    if (paramInt == 5) {
      return this.e;
    }
    return this.e;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    QLog.i(atlm.a, 1, atlm.b + "FavFileRecords clear...");
  }
  
  void a(List<FavFileInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList;
    if (paramInt == 1) {
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    }
    int i;
    for (;;)
    {
      Iterator localIterator = paramList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
        if (localFavFileInfo != null)
        {
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFavFileInfo.a))) {
            QLog.w(atlm.a, 1, atlm.b + "addOrUpdateFileRecords favfile is exsited, favid:" + localFavFileInfo.a);
          }
          localArrayList.add(localFavFileInfo);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFavFileInfo.a), localFavFileInfo);
          i = 1;
        }
      }
      if (paramInt == 2) {
        localArrayList = this.b;
      } else if (paramInt == 3) {
        localArrayList = this.c;
      } else if (paramInt == 4) {
        localArrayList = this.d;
      } else if (paramInt == 5) {
        localArrayList = this.e;
      } else {
        localArrayList = this.e;
      }
    }
    if (i != 0) {
      Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
    }
    QLog.i(atlm.a, 1, atlm.b + "addOrUpdateFileRecords recordType:" + paramInt + " addsize:" + paramList.size() + " recordSize:" + localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlq
 * JD-Core Version:    0.7.0.1
 */