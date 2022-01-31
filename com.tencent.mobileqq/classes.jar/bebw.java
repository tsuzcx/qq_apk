import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class bebw
  implements bebq
{
  bebw(bebv parambebv) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (bebv.a(this.a))
      {
        Object localObject2 = (List)bebv.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          bebv.a(this.a).remove(Integer.valueOf(paramInt2));
          bebv.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (bebx)((Iterator)???).next();
            bebv.a(this.a).a(((bebx)localObject2).jdField_a_of_type_Int, ((bebx)localObject2).b, ((bebx)localObject2).c, new Object[] { ((bebx)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bebw
 * JD-Core Version:    0.7.0.1
 */