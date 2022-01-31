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

public class bkpw
  extends bjwu
{
  private static final SparseArray<bkph> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  bjbn jdField_a_of_type_Bjbn = new bkpx(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bkph.a(99, 1, 0, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bkph.a(99, 3, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bkph.a(99, 5, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bkph.a(99, 7, 0, bjvc.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bkph.a(99, 4, 0, bjdd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(30, bkph.a(99, 6, 0, bjtg.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(28, bkph.a(99, 9, 0, bjxt.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(29, bkph.a(99, 8, 0, bjtg.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, bkph.a(99, 16, 0, bjtg.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bkph.a(99, 2, 0, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bkph.a(99, 15, 0, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bkph.a(99, 10, 1, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bkph.a(99, 10, 2, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bkph.a(99, 13, 0, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, bkph.a(99, 12, 1, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, bkph.a(99, 12, 2, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bkph.a(99, 14, 0, bkpw.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, bkph.a(99, 11, 0, bkpw.class));
  }
  
  public bkpw(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_Bjww.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bjwu)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof bjvc))
      {
        localObject2 = (bjvc)localObject1;
        if (!((bjvc)localObject2).a().b())
        {
          if (!((bjvc)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((bjvc)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((bjvc)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bjtg))
      {
        localObject1 = (bjtg)localObject1;
        localObject2 = new JSONObject();
        ((bjtg)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bjtg.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bjtg.a);
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
    ((bjbk)bjae.a(5)).a(this.jdField_a_of_type_Bjbn);
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    super.a(paramInt, parambkkm);
    if (parambkkm.a.saveMode != 0) {
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
    paramObject = (bkph)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
    ((bjbk)bjae.a(5)).b(this.jdField_a_of_type_Bjbn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpw
 * JD-Core Version:    0.7.0.1
 */