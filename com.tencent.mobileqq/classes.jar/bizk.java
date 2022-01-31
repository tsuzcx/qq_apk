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

public class bizk
  extends bifz
{
  private static final SparseArray<biyv> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  bhgv jdField_a_of_type_Bhgv = new bizl(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, biyv.a(99, 1, 0, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, biyv.a(99, 3, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, biyv.a(99, 5, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, biyv.a(99, 7, 0, bief.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, biyv.a(99, 4, 0, bhil.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(30, biyv.a(99, 6, 0, bicj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(28, biyv.a(99, 9, 0, bigy.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(29, biyv.a(99, 8, 0, bicj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, biyv.a(99, 16, 0, bicj.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, biyv.a(99, 2, 0, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, biyv.a(99, 15, 0, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, biyv.a(99, 10, 1, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, biyv.a(99, 10, 2, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, biyv.a(99, 13, 0, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, biyv.a(99, 12, 1, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, biyv.a(99, 12, 2, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, biyv.a(99, 14, 0, bizk.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, biyv.a(99, 11, 0, bizk.class));
  }
  
  public bizk(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_Bigb.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bifz)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof bief))
      {
        localObject2 = (bief)localObject1;
        if (!((bief)localObject2).a().b())
        {
          if (!((bief)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((bief)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((bief)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof bicj))
      {
        localObject1 = (bicj)localObject1;
        localObject2 = new JSONObject();
        ((bicj)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(bicj.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(bicj.a);
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
    ((bhgs)bhfm.a(5)).a(this.jdField_a_of_type_Bhgv);
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    if (parambitz.a.saveMode != 0) {
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
    paramObject = (biyv)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
    ((bhgs)bhfm.a(5)).b(this.jdField_a_of_type_Bhgv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizk
 * JD-Core Version:    0.7.0.1
 */