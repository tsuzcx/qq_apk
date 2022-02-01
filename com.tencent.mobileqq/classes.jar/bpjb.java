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

public class bpjb
  extends botu
{
  private static final SparseArray<bpim> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  bohm jdField_a_of_type_Bohm = new bpjc(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, bpim.a(99, 1, 0, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, bpim.a(99, 3, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, bpim.a(99, 5, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, bpim.a(99, 7, 0, botf.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, bpim.a(99, 4, 0, boiv.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, bpim.a(99, 6, 0, bosq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, bpim.a(99, 9, 0, EditVideoSpeedFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(13, bpim.a(99, 8, 0, bosq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, bpim.a(99, 16, 0, bosq.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, bpim.a(99, 2, 0, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, bpim.a(99, 15, 0, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, bpim.a(99, 10, 1, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, bpim.a(99, 10, 2, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, bpim.a(99, 13, 0, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, bpim.a(99, 12, 1, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, bpim.a(99, 12, 2, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, bpim.a(99, 14, 0, bpjb.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, bpim.a(99, 11, 0, bpjb.class));
  }
  
  public bpjb(@NonNull botw parambotw)
  {
    super(parambotw);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_Botw.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (botu)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof botf))
      {
        localObject2 = (botf)localObject1;
        if (!((botf)localObject2).a().b())
        {
          if (!((botf)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((botf)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((botf)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bosq))
      {
        localObject1 = (bosq)localObject1;
        localObject2 = new JSONObject();
        ((bosq)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bosq.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bosq.a);
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
    ((bohj)bogd.a(5)).a(this.jdField_a_of_type_Bohm);
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    super.a(paramInt, parambpel);
    if (parambpel.a.saveMode != 0) {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(7));
    }
    b();
    a(3006, null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (bpim)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
    ((bohj)bogd.a(5)).b(this.jdField_a_of_type_Bohm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjb
 * JD-Core Version:    0.7.0.1
 */