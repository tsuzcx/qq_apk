import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class ayds
  implements Callable<List<aydj>>
{
  ayds(aydq paramaydq, int paramInt1, int paramInt2) {}
  
  public List<aydj> a()
  {
    Object localObject = aydq.a(this.jdField_a_of_type_Aydq).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    aydj localaydj;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localaydj = (aydj)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Aydq.isCancelled()) {
          break label141;
        }
      }
      if (!aydq.a(this.jdField_a_of_type_Aydq).equals(aydq.b(this.jdField_a_of_type_Aydq))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localaydj = (aydj)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Aydq.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localaydj.a(aydq.a(this.jdField_a_of_type_Aydq));
        if (localaydj.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localaydj);
        if (-1 == i)
        {
          localArrayList.add(localaydj);
          break;
        }
        if (((aydj)localArrayList.get(i)).c() >= localaydj.c()) {
          break;
        }
        localArrayList.set(i, localaydj);
        break;
      }
      long l = localaydj.c();
      localaydj.a(aydq.b(this.jdField_a_of_type_Aydq));
      if (localaydj.c() == -9223372036854775808L) {
        localaydj.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayds
 * JD-Core Version:    0.7.0.1
 */