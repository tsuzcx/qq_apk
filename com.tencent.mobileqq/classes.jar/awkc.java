import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class awkc<M extends awoe, V extends awwq>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (awoe)this.a.get(paramInt);
  }
  
  protected abstract awrb<M, V> a(int paramInt);
  
  protected abstract awwq a(int paramInt, ViewGroup paramViewGroup);
  
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
    awoe localawoe = a(paramInt);
    if (localawoe == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    awrb localawrb;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localawrb = a(paramInt);
      paramView.setTag(2131379210, localawrb);
      paramView.setTag(2131379213, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131379208, localawoe);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131379209, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131379207, Integer.valueOf(getCount()));
      }
      localawrb.a(localawoe, paramViewGroup);
      return paramView;
      paramViewGroup = (awwq)paramView.getTag(2131379213);
      localawrb = (awrb)paramView.getTag(2131379210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awkc
 * JD-Core Version:    0.7.0.1
 */