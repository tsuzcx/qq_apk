import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bfkd
  implements bfjx
{
  bfkd(bfkc parambfkc) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bfkc.a(this.a))
      {
        Object localObject2 = (List)bfkc.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bfkc.a(this.a).remove(Integer.valueOf(paramInt2));
          bfkc.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bfke)((Iterator)???).next();
            bfkc.a(this.a).a(((bfke)localObject2).jdField_a_of_type_Int, ((bfke)localObject2).b, ((bfke)localObject2).c, new Object[] { ((bfke)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkd
 * JD-Core Version:    0.7.0.1
 */