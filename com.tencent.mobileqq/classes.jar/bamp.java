import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bamp
  implements anhx
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bamp(bami parambami) {}
  
  public List<ankb> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ankb(7, 7, null));
    arnz localarnz = (arnz)bami.a(this.jdField_a_of_type_Bami).getManager(14);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      EmoticonPackage localEmoticonPackage = localarnz.a(String.valueOf(i));
      if (localEmoticonPackage != null)
      {
        localArrayList.add(new ankb(10, 7, localEmoticonPackage));
      }
      else
      {
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.epId = String.valueOf(i);
        localEmoticonPackage.wordingId = -1L;
        localEmoticonPackage.jobType = 4;
        localEmoticonPackage.isMagicFaceDownloading = false;
        localEmoticonPackage.valid = true;
        localEmoticonPackage.status = 0;
        localEmoticonPackage.aio = true;
        localarnz.a(localEmoticonPackage);
        anfi.a().a(bami.a(this.jdField_a_of_type_Bami));
        ((anfj)bami.a(this.jdField_a_of_type_Bami).getManager(43)).a(String.valueOf(i), anfj.c, null, true, 0);
      }
    }
    return localArrayList;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bamp
 * JD-Core Version:    0.7.0.1
 */