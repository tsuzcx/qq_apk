import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhmi
  implements EmoticonListProvider
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bhmi(bhmb parambhmb) {}
  
  public void a(List<Integer> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList);
    }
  }
  
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new EmotionPanelInfo(7, 7, null));
    awyr localawyr = (awyr)bhmb.a(this.jdField_a_of_type_Bhmb).getManager(QQManagerFactory.EMOTICON_MANAGER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      EmoticonPackage localEmoticonPackage = localawyr.a(String.valueOf(i));
      if (localEmoticonPackage != null)
      {
        localArrayList.add(new EmotionPanelInfo(10, 7, localEmoticonPackage));
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
        localawyr.a(localEmoticonPackage);
        asig.a().a(bhmb.a(this.jdField_a_of_type_Bhmb));
        ((asih)bhmb.a(this.jdField_a_of_type_Bhmb).getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(String.valueOf(i), asih.c, null, true, 0);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmi
 * JD-Core Version:    0.7.0.1
 */