import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import java.util.Iterator;
import java.util.List;

public class aykk
  extends aykz
{
  public aykk(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      NearbyMomentFragment.a(this.a).a().remove(paramString);
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      NearbyMomentFragment.b(this.a, paramString.c);
    }
    if (NearbyMomentFragment.a(this.a).a().size() == 0) {
      this.a.a(1);
    }
    NearbyMomentFragment.a(this.a).remove(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    aylx localaylx = NearbyMomentFragment.a(this.a, paramString);
    if (localaylx != null)
    {
      if (localaylx.g > 0) {
        localaylx.g -= 1;
      }
      if ((localaylx.jdField_a_of_type_JavaUtilList != null) && (localaylx.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = localaylx.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (aylv)localIterator.next();
        } while (paramString.a != paramLong);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        localaylx.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      return;
      paramString = null;
    }
  }
  
  public void b(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      paramString.g += 1;
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      if (!paramString.jdField_a_of_type_Boolean)
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.f += 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void c(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString instanceof ayma))
    {
      paramString = (ayma)paramString;
      paramString.e += 1;
    }
    for (;;)
    {
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      return;
      if ((paramString instanceof aylu))
      {
        paramString = (aylu)paramString;
        paramString.e += 1;
      }
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString != null) && (paramString.jdField_a_of_type_Boolean))
    {
      paramString.jdField_a_of_type_Boolean = false;
      if (paramString.f > 0) {
        paramString.f -= 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykk
 * JD-Core Version:    0.7.0.1
 */