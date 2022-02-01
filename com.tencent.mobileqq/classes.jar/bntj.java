import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bntj
  extends bnec
{
  private static final SparseArray<bnsu> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  bmru jdField_a_of_type_Bmru = new bntk(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bnsu.a(99, 1, 0, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bnsu.a(99, 3, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, bnsu.a(99, 5, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, bnsu.a(99, 7, 0, bndn.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, bnsu.a(99, 4, 0, bmtd.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, bnsu.a(99, 6, 0, bncy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bnsu.a(99, 9, 0, EditVideoSpeedFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(13, bnsu.a(99, 8, 0, bncy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, bnsu.a(99, 16, 0, bncy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bnsu.a(99, 2, 0, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bnsu.a(99, 15, 0, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bnsu.a(99, 10, 1, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bnsu.a(99, 10, 2, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bnsu.a(99, 13, 0, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, bnsu.a(99, 12, 1, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, bnsu.a(99, 12, 2, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bnsu.a(99, 14, 0, bntj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, bnsu.a(99, 11, 0, bntj.class));
  }
  
  public bntj(@NonNull bnee parambnee)
  {
    super(parambnee);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_Bnee.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bnec)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof bndn))
      {
        localObject2 = (bndn)localObject1;
        if (!((bndn)localObject2).a().b())
        {
          if (!((bndn)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((bndn)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((bndn)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bncy))
      {
        localObject1 = (bncy)localObject1;
        localObject2 = new JSONObject();
        ((bncy)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bncy.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bncy.a);
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
    a(3000, null);
    ((bmrr)bmql.a(5)).a(this.jdField_a_of_type_Bmru);
  }
  
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    super.a(paramInt, parambnot);
    if (parambnot.a.saveMode != 0) {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(7));
    }
    b();
    a(3006, null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (bnsu)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 9) && (paramMessage.arg1 == 12)) {
      a(paramMessage.arg1, null);
    }
    return super.a(paramMessage);
  }
  
  public void g()
  {
    super.g();
    ((bmrr)bmql.a(5)).b(this.jdField_a_of_type_Bmru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntj
 * JD-Core Version:    0.7.0.1
 */