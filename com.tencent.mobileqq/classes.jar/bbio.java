import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bbio<M extends bbmw, V extends bbvh>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (bbmw)this.a.get(paramInt);
  }
  
  protected abstract bbps<M, V> a(int paramInt);
  
  protected abstract bbvh a(int paramInt, ViewGroup paramViewGroup);
  
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
    bbmw localbbmw = a(paramInt);
    Object localObject2;
    Object localObject1;
    if (localbbmw == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      localObject2 = null;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    if (paramView == null)
    {
      localObject1 = a(paramInt, paramViewGroup);
      paramView = ((bbvh)localObject1).a();
      localObject2 = a(paramInt);
      paramView.setTag(2131380931, localObject2);
      paramView.setTag(2131380935, localObject1);
    }
    for (;;)
    {
      paramView.setTag(2131380929, localbbmw);
      if (((bbvh)localObject1).a() != null)
      {
        ((bbvh)localObject1).a().setTag(2131380930, Integer.valueOf(paramInt));
        ((bbvh)localObject1).a().setTag(2131380928, Integer.valueOf(getCount()));
      }
      ((bbps)localObject2).a(localbbmw, (bbvh)localObject1);
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (bbvh)paramView.getTag(2131380935);
      localObject2 = (bbps)paramView.getTag(2131380931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbio
 * JD-Core Version:    0.7.0.1
 */