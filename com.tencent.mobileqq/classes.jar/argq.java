import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class argq
  extends argj
{
  public aqyq a;
  
  public argq(QQAppInterface paramQQAppInterface, argp paramargp)
  {
    if ((paramargp.a instanceof CameraEmoticonInfo)) {}
    for (int i = 333;; i = 149)
    {
      this.a = ((aqyq)paramQQAppInterface.getManager(i));
      return;
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public List<argg> a(boolean paramBoolean)
  {
    Object localObject = this.a.b();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new argp((EmoticonInfo)((Iterator)localObject).next()));
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
 * Qualified Name:     argq
 * JD-Core Version:    0.7.0.1
 */