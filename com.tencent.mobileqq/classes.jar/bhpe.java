import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bhpe
  implements bhoy
{
  bhpe(bhpd parambhpd) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bhpd.a(this.a))
      {
        Object localObject2 = (List)bhpd.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bhpd.a(this.a).remove(Integer.valueOf(paramInt2));
          bhpd.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bhpf)((Iterator)???).next();
            bhpd.a(this.a).a(((bhpf)localObject2).jdField_a_of_type_Int, ((bhpf)localObject2).b, ((bhpf)localObject2).c, new Object[] { ((bhpf)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhpe
 * JD-Core Version:    0.7.0.1
 */