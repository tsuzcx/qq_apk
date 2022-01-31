import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class ayib
  implements Callable<List<ayhs>>
{
  ayib(ayhz paramayhz, int paramInt1, int paramInt2) {}
  
  public List<ayhs> a()
  {
    Object localObject = ayhz.a(this.jdField_a_of_type_Ayhz).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    ayhs localayhs;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localayhs = (ayhs)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Ayhz.isCancelled()) {
          break label141;
        }
      }
      if (!ayhz.a(this.jdField_a_of_type_Ayhz).equals(ayhz.b(this.jdField_a_of_type_Ayhz))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localayhs = (ayhs)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Ayhz.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localayhs.a(ayhz.a(this.jdField_a_of_type_Ayhz));
        if (localayhs.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localayhs);
        if (-1 == i)
        {
          localArrayList.add(localayhs);
          break;
        }
        if (((ayhs)localArrayList.get(i)).c() >= localayhs.c()) {
          break;
        }
        localArrayList.set(i, localayhs);
        break;
      }
      long l = localayhs.c();
      localayhs.a(ayhz.b(this.jdField_a_of_type_Ayhz));
      if (localayhs.c() == -9223372036854775808L) {
        localayhs.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayib
 * JD-Core Version:    0.7.0.1
 */