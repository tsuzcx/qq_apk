import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjcc
  extends bjbs
{
  public bjcc(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "apply " + toString());
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bjbf localbjbf = (bjbf)((Iterator)localObject).next();
      if ((localbjbf instanceof bjbh)) {
        localArrayList.add(((bjbh)localbjbf).a);
      }
    }
    ((bjbk)bjae.a(5)).a[paramInt].a(this);
    localObject = (QIMFilterCategoryItem)this.a;
    bkqo.a().a((QIMFilterCategoryItem)localObject, paramInt);
    if ((QLog.isColorLevel()) && (localObject != null)) {
      QLog.i("QCombo", 2, "setApplyedFilterGroup" + ((QIMFilterCategoryItem)localObject).b);
    }
    bjbh.a(paramActivity, localArrayList, this, paramInt);
    return 0;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bjbf)localIterator.next();
      if ((localObject instanceof bjbh))
      {
        localObject = ((bjbh)localObject).a;
        if ((localObject != null) && (((FilterDesc)localObject).predownload == 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    bkqo.a().b(localQIMFilterCategoryItem, paramActivity, paramInt);
  }
  
  public int d()
  {
    int k = 0;
    Iterator localIterator = this.b.iterator();
    int i = 0;
    int j = k;
    if (localIterator.hasNext())
    {
      j = ((bjbf)localIterator.next()).a;
      if (j == 2) {
        j = 1;
      }
    }
    else
    {
      if (j == 0) {
        break label67;
      }
      b(2);
      return 2;
    }
    if (j == 1) {
      i = 1;
    }
    for (;;)
    {
      break;
      label67:
      if (i != 0)
      {
        b(2);
        return 1;
      }
      b(3);
      return 3;
    }
  }
  
  public String toString()
  {
    return "Filter" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcc
 * JD-Core Version:    0.7.0.1
 */