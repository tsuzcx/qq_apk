import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class bbgz
  implements Callable<List<bbgm>>
{
  bbgz(bbgx parambbgx, int paramInt1, int paramInt2) {}
  
  public List<bbgm> a()
  {
    Object localObject = bbgx.a(this.jdField_a_of_type_Bbgx).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    bbgm localbbgm;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localbbgm = (bbgm)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbgx.isCancelled()) {
          break label141;
        }
      }
      if (!bbgx.a(this.jdField_a_of_type_Bbgx).equals(bbgx.b(this.jdField_a_of_type_Bbgx))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localbbgm = (bbgm)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Bbgx.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localbbgm.a(bbgx.a(this.jdField_a_of_type_Bbgx));
        if (localbbgm.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localbbgm);
        if (-1 == i)
        {
          localArrayList.add(localbbgm);
          break;
        }
        if (((bbgm)localArrayList.get(i)).c() >= localbbgm.c()) {
          break;
        }
        localArrayList.set(i, localbbgm);
        break;
      }
      long l = localbbgm.c();
      localbbgm.a(bbgx.b(this.jdField_a_of_type_Bbgx));
      if (localbbgm.c() == -9223372036854775808L) {
        localbbgm.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgz
 * JD-Core Version:    0.7.0.1
 */