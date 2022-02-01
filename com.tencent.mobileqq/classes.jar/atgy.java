import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class atgy
  extends amoe
{
  private List<atha> a;
  
  public atgy(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public athb a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (athb)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(athb paramathb)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramathb);
    notifyDataSetChanged();
  }
  
  public void a(List<atha> paramList)
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
    atgz localatgz;
    athb localathb;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559168, null);
      localatgz = new atgz();
      localatgz.c = ((ImageView)localView.findViewById(2131367233));
      localatgz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367256));
      localView.setTag(localatgz);
      long l2 = System.currentTimeMillis();
      localathb = a(paramInt);
      l1 = l2;
      if (localathb != null)
      {
        localatgz.jdField_a_of_type_JavaLangString = localathb.e;
        localatgz.c.setImageBitmap(a(1, localathb.e));
        l1 = System.currentTimeMillis() - l2;
        str = localathb.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label236;
        }
        paramView = localathb.e;
      }
    }
    for (;;)
    {
      localatgz.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localatgz = (atgz)paramView.getTag();
      localView = paramView;
      break;
      label236:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localathb.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgy
 * JD-Core Version:    0.7.0.1
 */