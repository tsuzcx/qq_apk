import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class bohz
  extends bohr
{
  public bohz(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return super.a(paramActivity, paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    super.a(paramActivity, paramInt);
    bpjt localbpjt = bpjt.a();
    bohz localbohz = localbpjt.a[paramInt];
    if ((localbohz != null) && (localbohz.b().equals(b()))) {
      localbpjt.a(null, paramActivity, paramInt);
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    bpjt.a().a(localQIMFilterCategoryItem, paramActivity, paramInt);
    ((bohj)bogd.a(5)).a[paramInt].a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject.hashCode() == hashCode();
  }
  
  public int hashCode()
  {
    return ((QIMFilterCategoryItem)this.a).a.hashCode();
  }
  
  public String toString()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    return localQIMFilterCategoryItem.a + localQIMFilterCategoryItem.hashCode() + localQIMFilterCategoryItem.g + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohz
 * JD-Core Version:    0.7.0.1
 */