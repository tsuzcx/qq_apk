import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class bgec
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public bgfe a;
  private ArrayList<bgeg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bgec(SparseArray<bgfc> paramSparseArray)
  {
    this.jdField_a_of_type_Bgfe = new bgfe();
    this.jdField_a_of_type_Bgfe.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bgeg a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
      QLog.e("XMediaEditor", 2, "getEditItemInfo index out of bound, index:" + paramInt + ", mItemList.size():" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return null;
  }
  
  public String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bgeg localbgeg = (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbgeg.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbgeg.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<bgeq> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bgeg localbgeg = (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbgeg instanceof bgeq)) && (((bgeq)localbgeg).g != 3)) {
        localArrayList.add((bgeq)localbgeg);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bgfe.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, bgeg parambgeg)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bgfe.a(parambgeg);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambgeg);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bgeg localbgeg = a(paramInt);
    if (localbgeg != null)
    {
      localbgeg.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Bgfe.b(localbgeg);
    }
  }
  
  public void a(bgeg parambgeg)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bgfe.a(parambgeg);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambgeg);
    }
  }
  
  public void a(ArrayList<bgeq> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      bgeq localbgeq = (bgeq)paramArrayList.get(i);
      this.jdField_a_of_type_Bgfe.a(localbgeq);
      i += 1;
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    int i = 0;
    int j;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_Bgfe.c((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = bgeh.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((bgeg)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof bgep)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (bgep)localObject;
        if (i == 0) {
          break label266;
        }
        bgep localbgep = (bgep)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (bgep)localObject;
        if (TextUtils.isEmpty(localbgep.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((bgep)localObject).a))
        {
          ((bgep)localObject).a = localbgep.a;
          continue;
        }
        ((bgep)localObject).a = (((bgep)localObject).a + "\n" + localbgep.a);
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      continue;
      label244:
      notifyDataSetChanged();
      return;
      label249:
      continue;
      label252:
      i += 1;
    }
    for (;;)
    {
      j -= 1;
      break;
      label266:
      i = 1;
      continue;
      label271:
      i = 0;
    }
  }
  
  public boolean a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int b()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      j += ((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<bgek> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bgeg localbgeg = (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbgeg instanceof bgek)) {
        localArrayList.add((bgek)localbgeg);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bgfe.c((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    bgeg localbgeg = (bgeg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbgeg.c = paramInt;
    this.jdField_a_of_type_Bgfe.a(paramViewHolder, localbgeg, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Bgfe.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Bgfe.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Bgfe.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Bgfe.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgec
 * JD-Core Version:    0.7.0.1
 */