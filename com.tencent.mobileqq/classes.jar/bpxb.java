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

public class bpxb
  extends bpen
{
  private static final SparseArray<bpwx> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bpwx.a(98, 1, 0, bpxb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bpwx.a(98, 12, 0, bpxb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bpwx.a(98, 2, 0, bpxb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bpwx.a(98, 5, 0, bpcv.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bpwx.a(98, 3, 0, bpcv.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bpwx.a(98, 6, 0, bpcv.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(11, bpwx.a(98, 4, 0, bpap.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bpwx.a(98, 7, 0, EditVideoArtFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(19, bpwx.a(98, 9, 0, bpau.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bpwx.a(98, 10, 0, bpwy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bpwx.a(98, 8, 1, bpxe.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bpwx.a(98, 8, 2, bpxe.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bpwx.a(98, 11, 0, bpwy.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bpep.a().iterator();
    while (localIterator.hasNext())
    {
      bpen localbpen = (bpen)localIterator.next();
      if (paramClass.isInstance(localbpen)) {
        return localbpen;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bpcv)a(bpcv.class);
    if ((localObject != null) && (!((bpcv)localObject).c()))
    {
      if (!((bpcv)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bpcv)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bpcv)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)a(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).b())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (bpap)a(bpap.class);
    if ((localObject != null) && (((bpap)localObject).b())) {
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
    paramObject = (bpwx)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bpen)a(paramObject.a());
      if ((paramObject instanceof bpcv))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bpap))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bpau))
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
 * Qualified Name:     bpxb
 * JD-Core Version:    0.7.0.1
 */