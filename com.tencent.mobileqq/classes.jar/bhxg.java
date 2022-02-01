import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhxg
  implements asmy
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bhxg(bhwz parambhwz) {}
  
  public List<aspt> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aspt(7, 7, null));
    axfj localaxfj = (axfj)bhwz.a(this.jdField_a_of_type_Bhwz).getManager(14);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      EmoticonPackage localEmoticonPackage = localaxfj.a(String.valueOf(i));
      if (localEmoticonPackage != null)
      {
        localArrayList.add(new aspt(10, 7, localEmoticonPackage));
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
        localaxfj.a(localEmoticonPackage);
        askc.a().a(bhwz.a(this.jdField_a_of_type_Bhwz));
        ((askd)bhwz.a(this.jdField_a_of_type_Bhwz).getManager(43)).a(String.valueOf(i), askd.c, null, true, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxg
 * JD-Core Version:    0.7.0.1
 */