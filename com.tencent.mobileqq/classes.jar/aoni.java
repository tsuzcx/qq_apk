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

public class aoni
  extends aimu
{
  private List<aonk> a;
  
  public aoni(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public aonl a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (aonl)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(aonl paramaonl)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramaonl);
    notifyDataSetChanged();
  }
  
  public void a(List<aonk> paramList)
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
    aonl localaonl;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559059, null);
      paramViewGroup = new aonj();
      paramViewGroup.c = ((ImageView)localView.findViewById(2131366785));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366808));
      localView.setTag(paramViewGroup);
      long l2 = System.currentTimeMillis();
      localaonl = a(paramInt);
      l1 = l2;
      if (localaonl != null)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = localaonl.e;
        paramViewGroup.c.setImageBitmap(a(1, localaonl.e));
        l1 = System.currentTimeMillis() - l2;
        str = localaonl.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label213;
        }
        paramView = localaonl.e;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      return localView;
      paramViewGroup = (aonj)paramView.getTag();
      localView = paramView;
      break;
      label213:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localaonl.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoni
 * JD-Core Version:    0.7.0.1
 */