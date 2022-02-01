import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bgdd
  extends BaseAdapter
{
  public bgde a;
  protected List<String> a = new ArrayList();
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.add(paramString);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560645, null, false);
      paramView = new bgdf(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380118));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bgdf)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdd
 * JD-Core Version:    0.7.0.1
 */