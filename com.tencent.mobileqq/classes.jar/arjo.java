import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arjo
{
  public int a;
  public List<arjp> a;
  public boolean a;
  public boolean b;
  
  private int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0;; i = ((arjp)localIterator.next()).jdField_a_of_type_JavaUtilList.size() + i)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      long l = System.currentTimeMillis();
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (Math.abs(l - ((arjp)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long) > 60000L) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public arjp a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        localObject1 = (arjp)this.jdField_a_of_type_JavaUtilList.get(0);
      }
    }
    return localObject1;
  }
  
  public arjp a(String paramString)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        if (paramString.equals(((arjp)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString))
        {
          paramString = (arjp)this.jdField_a_of_type_JavaUtilList.get(i);
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilList.add(0, paramString);
      }
      return paramString;
      i += 1;
      break;
      paramString = null;
    }
  }
  
  public void a(arjp paramarjp, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt;
    a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramarjp)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramarjp);
    }
    if ((paramarjp == null) || (paramarjp.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.add(0, paramarjp);
      while ((a() > 500) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mProfileComplete").append("=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ").append("mProfileComplete").append("=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ").append("mShowCard").append("=").append(this.b);
    localStringBuilder.append(" ").append("mMaxLikeCount").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ").append("mTags").append("=").append(" [");
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        arjp localarjp = (arjp)this.jdField_a_of_type_JavaUtilList.get(i);
        localStringBuilder.append("\n");
        localStringBuilder.append("index_").append(i).append("=").append(localarjp.toString());
        i += 1;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjo
 * JD-Core Version:    0.7.0.1
 */