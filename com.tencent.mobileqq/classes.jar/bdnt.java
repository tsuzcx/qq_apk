import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdnt
  implements apqa
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bdnt(bdnm parambdnm) {}
  
  public List<apsm> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new apsm(7, 7, null));
    aube localaube = (aube)bdnm.a(this.jdField_a_of_type_Bdnm).getManager(14);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      EmoticonPackage localEmoticonPackage = localaube.a(String.valueOf(i));
      if (localEmoticonPackage != null)
      {
        localArrayList.add(new apsm(10, 7, localEmoticonPackage));
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
        localaube.a(localEmoticonPackage);
        apne.a().a(bdnm.a(this.jdField_a_of_type_Bdnm));
        ((apnf)bdnm.a(this.jdField_a_of_type_Bdnm).getManager(43)).a(String.valueOf(i), apnf.c, null, true, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnt
 * JD-Core Version:    0.7.0.1
 */