import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class avfg
  implements zec
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<avfd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public avfg(Context paramContext, List<PicInfo> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      if (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((ShortVideoUtils.a()) && ((!TextUtils.isEmpty(paramContext.d)) || (!TextUtils.isEmpty(paramContext.e)))) {}
        for (paramContext = new avet(this.jdField_a_of_type_AndroidContentContext, paramContext);; paramContext = new aves(this.jdField_a_of_type_AndroidContentContext, paramContext))
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
  
  public avfd a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (avfd)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public avfd a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (avfd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public ArrayList<PicInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((avfd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      ((avfd)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).c();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      avfd localavfd = (avfd)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localavfd.a(bool);
        i += 1;
        break;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public avfd b(int paramInt)
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
          localObject1 = (avfd)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avfg
 * JD-Core Version:    0.7.0.1
 */