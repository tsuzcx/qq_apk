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

public class benk
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public beom a;
  private ArrayList<beno> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public benk(SparseArray<beok> paramSparseArray)
  {
    this.jdField_a_of_type_Beom = new beom();
    this.jdField_a_of_type_Beom.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public beno a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (beno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      beno localbeno = (beno)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbeno.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbeno.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<beny> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      beno localbeno = (beno)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbeno instanceof beny)) && (((beny)localbeno).g != 3)) {
        localArrayList.add((beny)localbeno);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beom.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, beno parambeno)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Beom.a(parambeno);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambeno);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    beno localbeno = a(paramInt);
    if (localbeno != null)
    {
      localbeno.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Beom.b(localbeno);
    }
  }
  
  public void a(beno parambeno)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Beom.a(parambeno);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambeno);
    }
  }
  
  public void a(ArrayList<beny> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      beny localbeny = (beny)paramArrayList.get(i);
      this.jdField_a_of_type_Beom.a(localbeny);
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
          this.jdField_a_of_type_Beom.c((beno)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = benp.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((beno)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (beno)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof benx)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (benx)localObject;
        if (i == 0) {
          break label266;
        }
        benx localbenx = (benx)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (benx)localObject;
        if (TextUtils.isEmpty(localbenx.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((benx)localObject).a))
        {
          ((benx)localObject).a = localbenx.a;
          continue;
        }
        ((benx)localObject).a = (((benx)localObject).a + "\n" + localbenx.a);
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
      if (!((beno)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((beno)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<bens> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      beno localbeno = (beno)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbeno instanceof bens)) {
        localArrayList.add((bens)localbeno);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Beom.c((beno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((beno)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((beno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((beno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    beno localbeno = (beno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbeno.c = paramInt;
    this.jdField_a_of_type_Beom.a(paramViewHolder, localbeno, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Beom.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Beom.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Beom.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Beom.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benk
 * JD-Core Version:    0.7.0.1
 */