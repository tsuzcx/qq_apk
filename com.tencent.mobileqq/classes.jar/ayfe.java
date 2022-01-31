import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ayfe<M extends ayjj, V extends ayrv>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (ayjj)this.a.get(paramInt);
  }
  
  protected abstract aymg<M, V> a(int paramInt);
  
  protected abstract ayrv a(int paramInt, ViewGroup paramViewGroup);
  
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
    ayjj localayjj = a(paramInt);
    if (localayjj == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    aymg localaymg;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localaymg = a(paramInt);
      paramView.setTag(2131379915, localaymg);
      paramView.setTag(2131379918, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131379913, localayjj);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131379914, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131379912, Integer.valueOf(getCount()));
      }
      localaymg.a(localayjj, paramViewGroup);
      return paramView;
      paramViewGroup = (ayrv)paramView.getTag(2131379918);
      localaymg = (aymg)paramView.getTag(2131379915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayfe
 * JD-Core Version:    0.7.0.1
 */