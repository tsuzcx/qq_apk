import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class ayzw
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public azay a;
  private ArrayList<azaa> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ayzw(SparseArray<azaw> paramSparseArray)
  {
    this.jdField_a_of_type_Azay = new azay();
    this.jdField_a_of_type_Azay.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public azaa a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      azaa localazaa = (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localazaa.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localazaa.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<azak> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azaa localazaa = (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localazaa instanceof azak)) && (((azak)localazaa).g != 3)) {
        localArrayList.add((azak)localazaa);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azay.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, azaa paramazaa)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Azay.a(paramazaa);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramazaa);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    azaa localazaa = a(paramInt);
    if (localazaa != null)
    {
      localazaa.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Azay.b(localazaa);
    }
  }
  
  public void a(azaa paramazaa)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Azay.a(paramazaa);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramazaa);
    }
  }
  
  public void a(ArrayList<azak> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      azak localazak = (azak)paramArrayList.get(i);
      this.jdField_a_of_type_Azay.a(localazak);
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
          this.jdField_a_of_type_Azay.c((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = azab.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((azaa)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof azaj)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (azaj)localObject;
        if (i == 0) {
          break label266;
        }
        azaj localazaj = (azaj)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (azaj)localObject;
        if (TextUtils.isEmpty(localazaj.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((azaj)localObject).a))
        {
          ((azaj)localObject).a = localazaj.a;
          continue;
        }
        ((azaj)localObject).a = (((azaj)localObject).a + "\n" + localazaj.a);
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
      if (!((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<azae> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azaa localazaa = (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localazaa instanceof azae)) {
        localArrayList.add((azae)localazaa);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Azay.c((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((azaa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    azaa localazaa = (azaa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localazaa.c = paramInt;
    this.jdField_a_of_type_Azay.a(paramViewHolder, localazaa, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Azay.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Azay.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Azay.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Azay.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayzw
 * JD-Core Version:    0.7.0.1
 */