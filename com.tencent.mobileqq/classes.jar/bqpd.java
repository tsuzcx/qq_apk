import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class bqpd
  extends bqow
{
  public List<bqpe> a;
  public boolean b;
  public String f;
  
  public bqpd(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static List<bqpe> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new bqpe(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public bqpe a(String paramString)
  {
    if ((!bhsr.a(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bqpe localbqpe = (bqpe)localIterator.next();
        if (paramString.equals(localbqpe.f)) {
          return localbqpe;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "LocationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((bqpe)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((bqpe)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    throw new IndexOutOfBoundsException("getCategory with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.c).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append("items=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isLocating=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqpd
 * JD-Core Version:    0.7.0.1
 */