import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class anwo
  extends aiab
{
  private List<anwq> a;
  
  public anwo(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public anwr a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (anwr)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(anwr paramanwr)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramanwr);
    notifyDataSetChanged();
  }
  
  public void a(List<anwq> paramList)
  {
    this.a = new ArrayList(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l3 = System.currentTimeMillis();
    View localView;
    anwr localanwr;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131493490, null);
      paramViewGroup = new anwp();
      paramViewGroup.c = ((ImageView)localView.findViewById(2131301175));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301198));
      localView.setTag(paramViewGroup);
      long l2 = System.currentTimeMillis();
      localanwr = a(paramInt);
      l1 = l2;
      if (localanwr != null)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = localanwr.e;
        paramViewGroup.c.setImageBitmap(a(1, localanwr.e));
        l1 = System.currentTimeMillis() - l2;
        str = localanwr.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label213;
        }
        paramView = localanwr.e;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      return localView;
      paramViewGroup = (anwp)paramView.getTag();
      localView = paramView;
      break;
      label213:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localanwr.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwo
 * JD-Core Version:    0.7.0.1
 */