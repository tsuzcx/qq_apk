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

public class bkpl
  extends bjwu
{
  private static final SparseArray<bkph> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bkph.a(98, 1, 0, bkpl.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bkph.a(98, 12, 0, bkpl.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bkph.a(98, 2, 0, bkpl.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bkph.a(98, 5, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bkph.a(98, 3, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bkph.a(98, 6, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(11, bkph.a(98, 4, 0, bjsw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bkph.a(98, 7, 0, EditVideoArtFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(19, bkph.a(98, 9, 0, bjtb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bkph.a(98, 10, 0, bkpi.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bkph.a(98, 8, 1, bkpo.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bkph.a(98, 8, 2, bkpo.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bkph.a(98, 11, 0, bkpi.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bjww.a().iterator();
    while (localIterator.hasNext())
    {
      bjwu localbjwu = (bjwu)localIterator.next();
      if (paramClass.isInstance(localbjwu)) {
        return localbjwu;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bjvc)a(bjvc.class);
    if ((localObject != null) && (!((bjvc)localObject).c()))
    {
      if (!((bjvc)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bjvc)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bjvc)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)a(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).b())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (bjsw)a(bjsw.class);
    if ((localObject != null) && (((bjsw)localObject).b())) {
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
    paramObject = (bkph)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bjwu)a(paramObject.a());
      if ((paramObject instanceof bjvc))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bjsw))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bjtb))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpl
 * JD-Core Version:    0.7.0.1
 */