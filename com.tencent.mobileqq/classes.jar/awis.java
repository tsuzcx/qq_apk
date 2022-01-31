import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class awis
  implements Callable<List<awij>>
{
  awis(awiq paramawiq, int paramInt1, int paramInt2) {}
  
  public List<awij> a()
  {
    Object localObject = awiq.a(this.jdField_a_of_type_Awiq).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    awij localawij;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localawij = (awij)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Awiq.isCancelled()) {
          break label141;
        }
      }
      if (!awiq.a(this.jdField_a_of_type_Awiq).equals(awiq.b(this.jdField_a_of_type_Awiq))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localawij = (awij)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Awiq.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localawij.a(awiq.a(this.jdField_a_of_type_Awiq));
        if (localawij.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localawij);
        if (-1 == i)
        {
          localArrayList.add(localawij);
          break;
        }
        if (((awij)localArrayList.get(i)).c() >= localawij.c()) {
          break;
        }
        localArrayList.set(i, localawij);
        break;
      }
      long l = localawij.c();
      localawij.a(awiq.b(this.jdField_a_of_type_Awiq));
      if (localawij.c() == -9223372036854775808L) {
        localawij.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awis
 * JD-Core Version:    0.7.0.1
 */