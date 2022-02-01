import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class bbzm
  implements Callable<List<bbzd>>
{
  bbzm(bbzk parambbzk, int paramInt1, int paramInt2) {}
  
  public List<bbzd> a()
  {
    Object localObject = bbzk.a(this.jdField_a_of_type_Bbzk).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    bbzd localbbzd;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localbbzd = (bbzd)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbzk.isCancelled()) {
          break label141;
        }
      }
      if (!bbzk.a(this.jdField_a_of_type_Bbzk).equals(bbzk.b(this.jdField_a_of_type_Bbzk))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localbbzd = (bbzd)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbzk.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localbbzd.a(bbzk.a(this.jdField_a_of_type_Bbzk));
        if (localbbzd.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localbbzd);
        if (-1 == i)
        {
          localArrayList.add(localbbzd);
          break;
        }
        if (((bbzd)localArrayList.get(i)).c() >= localbbzd.c()) {
          break;
        }
        localArrayList.set(i, localbbzd);
        break;
      }
      long l = localbbzd.c();
      localbbzd.a(bbzk.b(this.jdField_a_of_type_Bbzk));
      if (localbbzd.c() == -9223372036854775808L) {
        localbbzd.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzm
 * JD-Core Version:    0.7.0.1
 */