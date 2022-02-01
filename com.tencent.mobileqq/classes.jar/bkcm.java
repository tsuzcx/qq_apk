import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bkcm
  implements bkcg
{
  bkcm(bkcl parambkcl) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bkcl.a(this.a))
      {
        Object localObject2 = (List)bkcl.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bkcl.a(this.a).remove(Integer.valueOf(paramInt2));
          bkcl.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bkcn)((Iterator)???).next();
            bkcl.a(this.a).a(((bkcn)localObject2).jdField_a_of_type_Int, ((bkcn)localObject2).b, ((bkcn)localObject2).c, new Object[] { ((bkcn)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcm
 * JD-Core Version:    0.7.0.1
 */