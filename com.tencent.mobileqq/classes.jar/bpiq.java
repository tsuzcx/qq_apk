import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bpiq
  extends botu
{
  private static final SparseArray<bpim> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bpim.a(98, 1, 0, bpiq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bpim.a(98, 12, 0, bpiq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bpim.a(98, 2, 0, bpiq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bpim.a(98, 5, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, bpim.a(98, 3, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, bpim.a(98, 6, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bpim.a(98, 4, 0, bosf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, bpim.a(98, 9, 0, bosl.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bpim.a(98, 10, 0, bpin.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bpim.a(98, 8, 1, bpit.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bpim.a(98, 8, 2, bpit.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bpim.a(98, 11, 0, bpin.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Botw.a().iterator();
    while (localIterator.hasNext())
    {
      botu localbotu = (botu)localIterator.next();
      if (paramClass.isInstance(localbotu)) {
        return localbotu;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (botf)a(botf.class);
    if ((localObject != null) && (!((botf)localObject).c()))
    {
      if (!((botf)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((botf)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((botf)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (bosf)a(bosf.class);
    if ((localObject != null) && (((bosf)localObject).b())) {
      localHashSet.add(Integer.valueOf(2));
    }
    return localHashSet;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (bpim)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (botu)a(paramObject.a());
      if ((paramObject instanceof botf))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bosf))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bosl))
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
 * Qualified Name:     bpiq
 * JD-Core Version:    0.7.0.1
 */