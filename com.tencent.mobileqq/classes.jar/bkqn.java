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

public class bkqn
  extends bjxl
{
  private static final SparseArray<bkpy> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  bjce jdField_a_of_type_Bjce = new bkqo(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bkpy.a(99, 1, 0, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, bkpy.a(99, 3, 0, bjvt.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, bkpy.a(99, 5, 0, bjvt.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, bkpy.a(99, 7, 0, bjvt.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bkpy.a(99, 4, 0, bjdu.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(30, bkpy.a(99, 6, 0, bjtx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(28, bkpy.a(99, 9, 0, bjyk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(29, bkpy.a(99, 8, 0, bjtx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, bkpy.a(99, 16, 0, bjtx.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bkpy.a(99, 2, 0, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bkpy.a(99, 15, 0, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bkpy.a(99, 10, 1, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bkpy.a(99, 10, 2, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bkpy.a(99, 13, 0, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, bkpy.a(99, 12, 1, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, bkpy.a(99, 12, 2, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bkpy.a(99, 14, 0, bkqn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, bkpy.a(99, 11, 0, bkqn.class));
  }
  
  public bkqn(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_Bjxn.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bjxl)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof bjvt))
      {
        localObject2 = (bjvt)localObject1;
        if (!((bjvt)localObject2).a().b())
        {
          if (!((bjvt)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((bjvt)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((bjvt)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bjtx))
      {
        localObject1 = (bjtx)localObject1;
        localObject2 = new JSONObject();
        ((bjtx)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bjtx.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bjtx.a);
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
    ((bjcb)bjav.a(5)).a(this.jdField_a_of_type_Bjce);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    if (parambkld.a.saveMode != 0) {
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
    paramObject = (bkpy)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
    ((bjcb)bjav.a(5)).b(this.jdField_a_of_type_Bjce);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqn
 * JD-Core Version:    0.7.0.1
 */