import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bfjm
  implements bfjg
{
  bfjm(bfjl parambfjl) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bfjl.a(this.a))
      {
        Object localObject2 = (List)bfjl.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bfjl.a(this.a).remove(Integer.valueOf(paramInt2));
          bfjl.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bfjn)((Iterator)???).next();
            bfjl.a(this.a).a(((bfjn)localObject2).jdField_a_of_type_Int, ((bfjn)localObject2).b, ((bfjn)localObject2).c, new Object[] { ((bfjn)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfjm
 * JD-Core Version:    0.7.0.1
 */