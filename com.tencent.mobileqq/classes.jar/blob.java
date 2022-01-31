import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class blob
  extends blnt
{
  public blob(Object paramObject)
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
    bncp localbncp = bncp.a();
    blob localblob = localbncp.a[paramInt];
    if ((localblob != null) && (localblob.b().equals(b()))) {
      localbncp.a(null, paramActivity, paramInt);
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    bncp.a().a(localQIMFilterCategoryItem, paramActivity, paramInt);
    ((blnl)blmf.a(5)).a[paramInt].a(this);
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
 * Qualified Name:     blob
 * JD-Core Version:    0.7.0.1
 */