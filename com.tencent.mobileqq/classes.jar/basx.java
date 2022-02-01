import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class basx
  implements Callable<List<baso>>
{
  basx(basv parambasv, int paramInt1, int paramInt2) {}
  
  public List<baso> a()
  {
    Object localObject = basv.a(this.jdField_a_of_type_Basv).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    baso localbaso;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localbaso = (baso)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Basv.isCancelled()) {
          break label141;
        }
      }
      if (!basv.a(this.jdField_a_of_type_Basv).equals(basv.b(this.jdField_a_of_type_Basv))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localbaso = (baso)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_Basv.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localbaso.a(basv.a(this.jdField_a_of_type_Basv));
        if (localbaso.c() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localbaso);
        if (-1 == i)
        {
          localArrayList.add(localbaso);
          break;
        }
        if (((baso)localArrayList.get(i)).c() >= localbaso.c()) {
          break;
        }
        localArrayList.set(i, localbaso);
        break;
      }
      long l = localbaso.c();
      localbaso.a(basv.b(this.jdField_a_of_type_Basv));
      if (localbaso.c() == -9223372036854775808L) {
        localbaso.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basx
 * JD-Core Version:    0.7.0.1
 */