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

public class asqu
  extends amck
{
  private List<asqw> a;
  
  public asqu(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public asqx a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (asqx)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(asqx paramasqx)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramasqx);
    notifyDataSetChanged();
  }
  
  public void a(List<asqw> paramList)
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
    asqv localasqv;
    asqx localasqx;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559168, null);
      localasqv = new asqv();
      localasqv.c = ((ImageView)localView.findViewById(2131367182));
      localasqv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367205));
      localView.setTag(localasqv);
      long l2 = System.currentTimeMillis();
      localasqx = a(paramInt);
      l1 = l2;
      if (localasqx != null)
      {
        localasqv.jdField_a_of_type_JavaLangString = localasqx.e;
        localasqv.c.setImageBitmap(a(1, localasqx.e));
        l1 = System.currentTimeMillis() - l2;
        str = localasqx.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label236;
        }
        paramView = localasqx.e;
      }
    }
    for (;;)
    {
      localasqv.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localasqv = (asqv)paramView.getTag();
      localView = paramView;
      break;
      label236:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localasqx.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqu
 * JD-Core Version:    0.7.0.1
 */