import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class awke<M extends awog, V extends awws>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (awog)this.a.get(paramInt);
  }
  
  protected abstract awrd<M, V> a(int paramInt);
  
  protected abstract awws a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList");
    }
    this.a.clear();
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList， size:" + paramList.size());
      }
      this.a.addAll(paramList);
    }
    for (;;)
    {
      paramList = this.a.iterator();
      while (paramList.hasNext()) {
        if (paramList.next() == null) {
          paramList.remove();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList， null");
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void a(List<M> paramList, boolean paramBoolean)
  {
    a(paramList);
    super.notifyDataSetChanged();
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
    awog localawog = a(paramInt);
    if (localawog == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    awrd localawrd;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localawrd = a(paramInt);
      paramView.setTag(2131379215, localawrd);
      paramView.setTag(2131379218, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131379213, localawog);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131379214, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131379212, Integer.valueOf(getCount()));
      }
      localawrd.a(localawog, paramViewGroup);
      return paramView;
      paramViewGroup = (awws)paramView.getTag(2131379218);
      localawrd = (awrd)paramView.getTag(2131379215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awke
 * JD-Core Version:    0.7.0.1
 */