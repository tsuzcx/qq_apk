import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bnbx
  extends bmiv
{
  private static final SparseArray<bnbi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  blno jdField_a_of_type_Blno = new bnby(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bnbi.a(99, 1, 0, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bnbi.a(99, 3, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bnbi.a(99, 5, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bnbi.a(99, 7, 0, bmhd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bnbi.a(99, 4, 0, blpf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(30, bnbi.a(99, 6, 0, bmfh.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(28, bnbi.a(99, 9, 0, bmju.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(29, bnbi.a(99, 8, 0, bmfh.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, bnbi.a(99, 16, 0, bmfh.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bnbi.a(99, 2, 0, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bnbi.a(99, 15, 0, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bnbi.a(99, 10, 1, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bnbi.a(99, 10, 2, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bnbi.a(99, 13, 0, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, bnbi.a(99, 12, 1, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, bnbi.a(99, 12, 2, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bnbi.a(99, 14, 0, bnbx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, bnbi.a(99, 11, 0, bnbx.class));
  }
  
  public bnbx(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_Bmix.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bmiv)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof bmhd))
      {
        localObject2 = (bmhd)localObject1;
        if (!((bmhd)localObject2).a().b())
        {
          if (!((bmhd)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((bmhd)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((bmhd)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bmfh))
      {
        localObject1 = (bmfh)localObject1;
        localObject2 = new JSONObject();
        ((bmfh)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bmfh.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bmfh.a);
            if (!((JSONObject)localObject1).has("comboItem")) {
              break label237;
            }
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has combo item" });
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(4));
          }
          catch (JSONException localJSONException)
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", localJSONException);
          }
          continue;
          label237:
          if (localJSONException.has("musicItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has music item" });
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(2));
          }
          else if (localJSONException.has("filterItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has filter item" });
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    a_(3000, null);
    ((blnl)blmf.a(5)).a(this.jdField_a_of_type_Blno);
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    if (parambmwn.a.saveMode != 0) {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(7));
    }
    d();
    a_(3006, null);
  }
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 9) && (paramMessage.arg1 == 28)) {
      a_(paramMessage.arg1, null);
    }
    return super.a(paramMessage);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    paramObject = (bnbi)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3006) {
        paramObject.a(this.jdField_a_of_type_JavaUtilSet);
      }
      paramObject.a();
      return;
    }
    QZLog.w("QzoneEditVideoPartRepor", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state " + paramInt });
  }
  
  public void g()
  {
    super.g();
    ((blnl)blmf.a(5)).b(this.jdField_a_of_type_Blno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbx
 * JD-Core Version:    0.7.0.1
 */