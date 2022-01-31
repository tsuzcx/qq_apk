import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ayjn<M extends ayns, V extends aywe>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (ayns)this.a.get(paramInt);
  }
  
  protected abstract ayqp<M, V> a(int paramInt);
  
  protected abstract aywe a(int paramInt, ViewGroup paramViewGroup);
  
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
    ayns localayns = a(paramInt);
    if (localayns == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    ayqp localayqp;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localayqp = a(paramInt);
      paramView.setTag(2131379973, localayqp);
      paramView.setTag(2131379976, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131379971, localayns);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131379972, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131379970, Integer.valueOf(getCount()));
      }
      localayqp.a(localayns, paramViewGroup);
      return paramView;
      paramViewGroup = (aywe)paramView.getTag(2131379976);
      localayqp = (ayqp)paramView.getTag(2131379973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayjn
 * JD-Core Version:    0.7.0.1
 */