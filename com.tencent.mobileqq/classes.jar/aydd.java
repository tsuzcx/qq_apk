import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class aydd
  implements aavo
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<ayda> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public aydd(Context paramContext, List<PicInfo> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      if (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && ((!TextUtils.isEmpty(paramContext.d)) || (!TextUtils.isEmpty(paramContext.e)))) {}
        for (paramContext = new aycq(this.jdField_a_of_type_AndroidContentContext, paramContext);; paramContext = new aycp(this.jdField_a_of_type_AndroidContentContext, paramContext))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
          i += 1;
          break;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public ayda a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (ayda)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public ayda a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (ayda)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public ArrayList<PicInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ayda)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      ((ayda)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).c();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ayda localayda = (ayda)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localayda.a(bool);
        i += 1;
        break;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ayda b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          localObject1 = (ayda)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydd
 * JD-Core Version:    0.7.0.1
 */