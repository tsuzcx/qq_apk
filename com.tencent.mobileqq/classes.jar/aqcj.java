import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aqcj
{
  public static void a(ArrayList<ColorNote> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramArrayList.next();
      Integer localInteger = Integer.valueOf(localColorNote.getServiceType());
      if (localHashMap.containsKey(localInteger))
      {
        ((ArrayList)localHashMap.get(localInteger)).add(localColorNote);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localColorNote);
        localHashMap.put(localInteger, localArrayList);
      }
    }
    tcc.a((List)localHashMap.get(Integer.valueOf(16908290)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcj
 * JD-Core Version:    0.7.0.1
 */