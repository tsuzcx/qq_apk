import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class awiq
  implements Callable<List<awih>>
{
  awiq(awio paramawio, int paramInt1, int paramInt2) {}
  
  public List<awih> a()
  {
    Object localObject = awio.a(this.jdField_a_of_type_Awio).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    awih localawih;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localawih = (awih)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Awio.isCancelled()) {
          break label141;
        }
      }
      if (!awio.a(this.jdField_a_of_type_Awio).equals(awio.b(this.jdField_a_of_type_Awio))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localawih = (awih)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Awio.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localawih.a(awio.a(this.jdField_a_of_type_Awio));
        if (localawih.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localawih);
        if (-1 == i)
        {
          localArrayList.add(localawih);
          break;
        }
        if (((awih)localArrayList.get(i)).c() >= localawih.c()) {
          break;
        }
        localArrayList.set(i, localawih);
        break;
      }
      long l = localawih.c();
      localawih.a(awio.b(this.jdField_a_of_type_Awio));
      if (localawih.c() == -9223372036854775808L) {
        localawih.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiq
 * JD-Core Version:    0.7.0.1
 */