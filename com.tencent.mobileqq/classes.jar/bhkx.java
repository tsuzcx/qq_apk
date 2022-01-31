import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bhkx
  implements bhkr
{
  bhkx(bhkw parambhkw) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bhkw.a(this.a))
      {
        Object localObject2 = (List)bhkw.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bhkw.a(this.a).remove(Integer.valueOf(paramInt2));
          bhkw.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bhky)((Iterator)???).next();
            bhkw.a(this.a).a(((bhky)localObject2).jdField_a_of_type_Int, ((bhky)localObject2).b, ((bhky)localObject2).c, new Object[] { ((bhky)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkx
 * JD-Core Version:    0.7.0.1
 */