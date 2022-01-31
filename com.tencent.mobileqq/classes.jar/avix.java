import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class avix
  implements Callable<List<avio>>
{
  avix(aviv paramaviv, int paramInt1, int paramInt2) {}
  
  public List<avio> a()
  {
    Object localObject = aviv.a(this.jdField_a_of_type_Aviv).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    avio localavio;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localavio = (avio)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Aviv.isCancelled()) {
          break label141;
        }
      }
      if (!aviv.a(this.jdField_a_of_type_Aviv).equals(aviv.b(this.jdField_a_of_type_Aviv))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localavio = (avio)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Aviv.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localavio.a(aviv.a(this.jdField_a_of_type_Aviv));
        if (localavio.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localavio);
        if (-1 == i)
        {
          localArrayList.add(localavio);
          break;
        }
        if (((avio)localArrayList.get(i)).c() >= localavio.c()) {
          break;
        }
        localArrayList.set(i, localavio);
        break;
      }
      long l = localavio.c();
      localavio.a(aviv.b(this.jdField_a_of_type_Aviv));
      if (localavio.c() == -9223372036854775808L) {
        localavio.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avix
 * JD-Core Version:    0.7.0.1
 */