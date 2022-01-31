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

public class biyz
  extends bifz
{
  private static final SparseArray<biyv> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, biyv.a(98, 1, 0, biyz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, biyv.a(98, 12, 0, biyz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, biyv.a(98, 2, 0, biyz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, biyv.a(98, 5, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, biyv.a(98, 3, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, biyv.a(98, 6, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(11, biyv.a(98, 4, 0, bibz.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, biyv.a(98, 7, 0, EditVideoArtFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(19, biyv.a(98, 9, 0, bice.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, biyv.a(98, 10, 0, biyw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, biyv.a(98, 8, 1, bizc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, biyv.a(98, 8, 2, bizc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, biyv.a(98, 11, 0, biyw.class));
  }
  
  private <T> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_Bigb.a().iterator();
    while (localIterator.hasNext())
    {
      bifz localbifz = (bifz)localIterator.next();
      if (paramClass.isInstance(localbifz)) {
        return localbifz;
      }
    }
    return null;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (bief)a(bief.class);
    if ((localObject != null) && (!((bief)localObject).c()))
    {
      if (!((bief)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((bief)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((bief)localObject).a().a().a()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)a(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).b())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (bibz)a(bibz.class);
    if ((localObject != null) && (((bibz)localObject).b())) {
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
    paramObject = (biyv)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.a(a());
      }
      paramObject.a();
      paramObject = (bifz)a(paramObject.a());
      if ((paramObject instanceof bief))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof bibz))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof bice))
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
 * Qualified Name:     biyz
 * JD-Core Version:    0.7.0.1
 */