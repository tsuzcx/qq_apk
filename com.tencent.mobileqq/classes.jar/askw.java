import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class askw
  extends askp
{
  public asda a;
  
  public askw(QQAppInterface paramQQAppInterface, askv paramaskv)
  {
    if ((paramaskv.a instanceof CameraEmoticonInfo)) {}
    for (int i = QQManagerFactory.CAMERA_EMOTION_DB_MANAGER;; i = QQManagerFactory.FAVROAMING_DB_MANAGER)
    {
      this.a = ((asda)paramQQAppInterface.getManager(i));
      return;
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public List<askm> a(boolean paramBoolean)
  {
    Object localObject = this.a.b();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new askv((EmoticonInfo)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askw
 * JD-Core Version:    0.7.0.1
 */