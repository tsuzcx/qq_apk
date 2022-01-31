import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class avkj<M extends avol, V extends avwx>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (avol)this.a.get(paramInt);
  }
  
  protected abstract avri<M, V> a(int paramInt);
  
  protected abstract avwx a(int paramInt, ViewGroup paramViewGroup);
  
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
    avol localavol = a(paramInt);
    if (localavol == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    avri localavri;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localavri = a(paramInt);
      paramView.setTag(2131313375, localavri);
      paramView.setTag(2131313378, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131313373, localavol);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131313374, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131313372, Integer.valueOf(getCount()));
      }
      localavri.a(localavol, paramViewGroup);
      return paramView;
      paramViewGroup = (avwx)paramView.getTag(2131313378);
      localavri = (avri)paramView.getTag(2131313375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avkj
 * JD-Core Version:    0.7.0.1
 */