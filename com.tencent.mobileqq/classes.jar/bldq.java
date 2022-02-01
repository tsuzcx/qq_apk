import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bldq
  implements bldk
{
  bldq(bldp parambldp) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bldp.a(this.a))
      {
        Object localObject2 = (List)bldp.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bldp.a(this.a).remove(Integer.valueOf(paramInt2));
          bldp.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bldr)((Iterator)???).next();
            bldp.a(this.a).a(((bldr)localObject2).jdField_a_of_type_Int, ((bldr)localObject2).b, ((bldr)localObject2).c, new Object[] { ((bldr)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldq
 * JD-Core Version:    0.7.0.1
 */