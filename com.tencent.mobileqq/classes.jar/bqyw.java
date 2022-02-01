import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bqyw
  extends bqgi
{
  private static final SparseArray<bqys> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bqys.a(98, 1, 0, bqyw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bqys.a(98, 12, 0, bqyw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bqys.a(98, 2, 0, bqyw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bqys.a(98, 5, 0, bqeq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bqys.a(98, 3, 0, bqeq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bqys.a(98, 6, 0, bqeq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(11, bqys.a(98, 4, 0, bqck.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bqys.a(98, 7, 0, EditVideoArtFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(19, bqys.a(98, 9, 0, bqcp.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bqys.a(98, 10, 0, bqyt.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bqys.a(98, 8, 1, bqyz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bqys.a(98, 8, 2, bqyz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bqys.a(98, 11, 0, bqyt.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bqgk.a().iterator();
    while (localIterator.hasNext())
    {
      bqgi localbqgi = (bqgi)localIterator.next();
      if (paramClass.isInstance(localbqgi)) {
        return localbqgi;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bqeq)a(bqeq.class);
    if ((localObject != null) && (!((bqeq)localObject).c()))
    {
      if (!((bqeq)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bqeq)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bqeq)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)a(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).b())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (bqck)a(bqck.class);
    if ((localObject != null) && (((bqck)localObject).b())) {
      localHashSet.add(Integer.valueOf(2));
    }
    return localHashSet;
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
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    paramObject = (bqys)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bqgi)a(paramObject.a());
      if ((paramObject instanceof bqeq))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bqck))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bqcp))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged save report");
        return;
      }
      if ((paramObject instanceof EditVideoArtFilter))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged art filter report");
        return;
      }
      QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged unsupported report");
      return;
    }
    QZLog.w("QzoneEditPicturePartRep", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state for reporting" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyw
 * JD-Core Version:    0.7.0.1
 */