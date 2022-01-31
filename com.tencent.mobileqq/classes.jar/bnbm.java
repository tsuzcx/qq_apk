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

public class bnbm
  extends bmiv
{
  private static final SparseArray<bnbi> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bnbi.a(98, 1, 0, bnbm.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bnbi.a(98, 12, 0, bnbm.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bnbi.a(98, 2, 0, bnbm.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bnbi.a(98, 5, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bnbi.a(98, 3, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bnbi.a(98, 6, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(11, bnbi.a(98, 4, 0, bmex.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bnbi.a(98, 7, 0, EditVideoArtFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(19, bnbi.a(98, 9, 0, bmfc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bnbi.a(98, 10, 0, bnbj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bnbi.a(98, 8, 1, bnbp.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bnbi.a(98, 8, 2, bnbp.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bnbi.a(98, 11, 0, bnbj.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bmix.a().iterator();
    while (localIterator.hasNext())
    {
      bmiv localbmiv = (bmiv)localIterator.next();
      if (paramClass.isInstance(localbmiv)) {
        return localbmiv;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bmhd)a(bmhd.class);
    if ((localObject != null) && (!((bmhd)localObject).c()))
    {
      if (!((bmhd)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bmhd)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bmhd)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)a(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).b())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (bmex)a(bmex.class);
    if ((localObject != null) && (((bmex)localObject).b())) {
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
    paramObject = (bnbi)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bmiv)a(paramObject.a());
      if ((paramObject instanceof bmhd))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bmex))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bmfc))
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
 * Qualified Name:     bnbm
 * JD-Core Version:    0.7.0.1
 */