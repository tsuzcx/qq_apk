import android.os.Bundle;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class aycm
  extends amct
{
  private aycm(SignTextEditFragment paramSignTextEditFragment) {}
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      SignTextEditFragment.a(this.a, 2);
    }
    for (;;)
    {
      return;
      paramObject = (Bundle)paramObject;
      int i = paramObject.getInt("param_searchResult", 0);
      paramObject = (ArrayList)paramObject.getSerializable("param_topicInfoList");
      if ((paramObject == null) || (paramObject.size() <= 0)) {
        if (i == 0) {
          SignTextEditFragment.a(this.a, 3);
        }
      }
      while (this.a.jdField_a_of_type_Aklo.a(paramObject, true))
      {
        this.a.jdField_a_of_type_Aklo.notifyDataSetChanged();
        return;
        SignTextEditFragment.a(this.a, 2);
        continue;
        SignTextEditFragment.a(this.a, 4);
      }
    }
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null)
    {
      SignTextEditFragment.a(this.a, 2);
      return;
    }
    Object localObject = (Bundle)paramObject;
    int j = ((Bundle)localObject).getInt("param_atIndex");
    int k = ((Bundle)localObject).getInt("param_atKeyLen");
    paramObject = ((Bundle)localObject).getString("param_atKey");
    long l = ((Bundle)localObject).getLong("param_reqTs");
    localObject = (ArrayList)((Bundle)localObject).getSerializable("param_topicInfoList");
    int i;
    if (localObject == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("onGetTopicWithKey[%b,%d] key=[%s] [atIndex=%d, keyLen=%d],reqTs=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), paramObject, Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l) }));
      }
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        break label240;
      }
      SignTextEditFragment.a(this.a, 3);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aklo.a((List)localObject, false)) {
        this.a.jdField_a_of_type_Aklo.notifyDataSetChanged();
      }
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setTag(new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramObject, Long.valueOf(l) });
      return;
      i = ((List)localObject).size();
      break;
      label240:
      SignTextEditFragment.a(this.a, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycm
 * JD-Core Version:    0.7.0.1
 */