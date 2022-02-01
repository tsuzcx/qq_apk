import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bkvf
  implements bkuz
{
  bkvf(bkve parambkve) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bkve.a(this.a))
      {
        Object localObject2 = (List)bkve.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bkve.a(this.a).remove(Integer.valueOf(paramInt2));
          bkve.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bkvg)((Iterator)???).next();
            bkve.a(this.a).a(((bkvg)localObject2).jdField_a_of_type_Int, ((bkvg)localObject2).b, ((bkvg)localObject2).c, new Object[] { ((bkvg)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvf
 * JD-Core Version:    0.7.0.1
 */