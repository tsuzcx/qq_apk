import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bjju
  implements bjjo
{
  bjju(bjjt parambjjt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bjjt.a(this.a))
      {
        Object localObject2 = (List)bjjt.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bjjt.a(this.a).remove(Integer.valueOf(paramInt2));
          bjjt.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bjjv)((Iterator)???).next();
            bjjt.a(this.a).a(((bjjv)localObject2).jdField_a_of_type_Int, ((bjjv)localObject2).b, ((bjjv)localObject2).c, new Object[] { ((bjjv)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjju
 * JD-Core Version:    0.7.0.1
 */