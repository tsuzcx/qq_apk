import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class baao
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public babq a;
  private ArrayList<baas> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public baao(SparseArray<babo> paramSparseArray)
  {
    this.jdField_a_of_type_Babq = new babq();
    this.jdField_a_of_type_Babq.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public baas a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (baas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      baas localbaas = (baas)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbaas.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbaas.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<babc> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      baas localbaas = (baas)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbaas instanceof babc)) && (((babc)localbaas).g != 3)) {
        localArrayList.add((babc)localbaas);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Babq.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, baas parambaas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Babq.a(parambaas);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambaas);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    baas localbaas = a(paramInt);
    if (localbaas != null)
    {
      localbaas.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Babq.b(localbaas);
    }
  }
  
  public void a(baas parambaas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Babq.a(parambaas);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambaas);
    }
  }
  
  public void a(ArrayList<babc> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      babc localbabc = (babc)paramArrayList.get(i);
      this.jdField_a_of_type_Babq.a(localbabc);
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
          this.jdField_a_of_type_Babq.c((baas)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = baat.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((baas)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (baas)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof babb)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (babb)localObject;
        if (i == 0) {
          break label266;
        }
        babb localbabb = (babb)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (babb)localObject;
        if (TextUtils.isEmpty(localbabb.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((babb)localObject).a))
        {
          ((babb)localObject).a = localbabb.a;
          continue;
        }
        ((babb)localObject).a = (((babb)localObject).a + "\n" + localbabb.a);
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
      if (!((baas)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((baas)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<baaw> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      baas localbaas = (baas)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbaas instanceof baaw)) {
        localArrayList.add((baaw)localbaas);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Babq.c((baas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((baas)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((baas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((baas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    baas localbaas = (baas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbaas.c = paramInt;
    this.jdField_a_of_type_Babq.a(paramViewHolder, localbaas, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Babq.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Babq.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Babq.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Babq.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baao
 * JD-Core Version:    0.7.0.1
 */