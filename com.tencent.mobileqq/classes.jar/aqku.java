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

public class aqku
  extends akis
{
  private List<aqkw> a;
  
  public aqku(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public aqkx a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (aqkx)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(aqkx paramaqkx)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramaqkx);
    notifyDataSetChanged();
  }
  
  public void a(List<aqkw> paramList)
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
    aqkx localaqkx;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559099, null);
      paramViewGroup = new aqkv();
      paramViewGroup.c = ((ImageView)localView.findViewById(2131366914));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366937));
      localView.setTag(paramViewGroup);
      long l2 = System.currentTimeMillis();
      localaqkx = a(paramInt);
      l1 = l2;
      if (localaqkx != null)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = localaqkx.e;
        paramViewGroup.c.setImageBitmap(a(1, localaqkx.e));
        l1 = System.currentTimeMillis() - l2;
        str = localaqkx.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label213;
        }
        paramView = localaqkx.e;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      return localView;
      paramViewGroup = (aqkv)paramView.getTag();
      localView = paramView;
      break;
      label213:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localaqkx.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqku
 * JD-Core Version:    0.7.0.1
 */