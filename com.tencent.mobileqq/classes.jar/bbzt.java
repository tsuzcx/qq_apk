import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class bbzt
  implements Callable<List<bbzg>>
{
  bbzt(bbzr parambbzr, int paramInt1, int paramInt2) {}
  
  public List<bbzg> a()
  {
    Object localObject = bbzr.a(this.jdField_a_of_type_Bbzr).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    bbzg localbbzg;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localbbzg = (bbzg)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbzr.isCancelled()) {
          break label141;
        }
      }
      if (!bbzr.a(this.jdField_a_of_type_Bbzr).equals(bbzr.b(this.jdField_a_of_type_Bbzr))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localbbzg = (bbzg)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbzr.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localbbzg.a(bbzr.a(this.jdField_a_of_type_Bbzr));
        if (localbbzg.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localbbzg);
        if (-1 == i)
        {
          localArrayList.add(localbbzg);
          break;
        }
        if (((bbzg)localArrayList.get(i)).c() >= localbbzg.c()) {
          break;
        }
        localArrayList.set(i, localbbzg);
        break;
      }
      long l = localbbzg.c();
      localbbzg.a(bbzr.b(this.jdField_a_of_type_Bbzr));
      if (localbbzg.c() == -9223372036854775808L) {
        localbbzg.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzt
 * JD-Core Version:    0.7.0.1
 */