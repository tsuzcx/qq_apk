import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bnsy
  extends bnec
{
  private static final SparseArray<bnsu> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bnsu.a(98, 1, 0, bnsy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bnsu.a(98, 12, 0, bnsy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bnsu.a(98, 2, 0, bnsy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bnsu.a(98, 5, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, bnsu.a(98, 3, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, bnsu.a(98, 6, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bnsu.a(98, 4, 0, bncn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, bnsu.a(98, 9, 0, bnct.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bnsu.a(98, 10, 0, bnsv.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bnsu.a(98, 8, 1, bntb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bnsu.a(98, 8, 2, bntb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bnsu.a(98, 11, 0, bnsv.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bnee.a().iterator();
    while (localIterator.hasNext())
    {
      bnec localbnec = (bnec)localIterator.next();
      if (paramClass.isInstance(localbnec)) {
        return localbnec;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bndn)a(bndn.class);
    if ((localObject != null) && (!((bndn)localObject).c()))
    {
      if (!((bndn)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bndn)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bndn)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (bncn)a(bncn.class);
    if ((localObject != null) && (((bncn)localObject).b())) {
      localHashSet.add(Integer.valueOf(2));
    }
    return localHashSet;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (bnsu)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bnec)a(paramObject.a());
      if ((paramObject instanceof bndn))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bncn))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bnct))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged save report");
        return;
      }
      QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged unsupported report");
      return;
    }
    QZLog.w("QzoneEditPicturePartRep", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state for reporting" });
  }
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof Object[])))
    {
      long l = ((Long)((Object[])(Object[])paramMessage.obj)[0]).longValue();
      View localView = (View)((Object[])(Object[])paramMessage.obj)[1];
      QZLog.d("QzoneEditPicturePartRep", 2, "handleEditVideoMessage " + l + " " + localView);
    }
    return super.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsy
 * JD-Core Version:    0.7.0.1
 */