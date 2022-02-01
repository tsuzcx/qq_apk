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

public class artg
  extends aliy
{
  private List<arti> a;
  
  public artg(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public artj a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (artj)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(artj paramartj)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramartj);
    notifyDataSetChanged();
  }
  
  public void a(List<arti> paramList)
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
    arth localarth;
    artj localartj;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559175, null);
      localarth = new arth();
      localarth.c = ((ImageView)localView.findViewById(2131367253));
      localarth.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367279));
      localView.setTag(localarth);
      long l2 = System.currentTimeMillis();
      localartj = a(paramInt);
      l1 = l2;
      if (localartj != null)
      {
        localarth.jdField_a_of_type_JavaLangString = localartj.e;
        localarth.c.setImageBitmap(a(1, localartj.e));
        l1 = System.currentTimeMillis() - l2;
        str = localartj.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label236;
        }
        paramView = localartj.e;
      }
    }
    for (;;)
    {
      localarth.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localarth = (arth)paramView.getTag();
      localView = paramView;
      break;
      label236:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localartj.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artg
 * JD-Core Version:    0.7.0.1
 */