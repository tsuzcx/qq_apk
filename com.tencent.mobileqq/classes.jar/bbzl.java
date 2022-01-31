import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class bbzl
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public bcan a;
  private ArrayList<bbzp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bbzl(SparseArray<bcal> paramSparseArray)
  {
    this.jdField_a_of_type_Bcan = new bcan();
    this.jdField_a_of_type_Bcan.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bbzp a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      bbzp localbbzp = (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbbzp.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbbzp.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<bbzz> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bbzp localbbzp = (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbbzp instanceof bbzz)) && (((bbzz)localbbzp).g != 3)) {
        localArrayList.add((bbzz)localbbzp);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcan.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, bbzp parambbzp)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcan.a(parambbzp);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambbzp);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bbzp localbbzp = a(paramInt);
    if (localbbzp != null)
    {
      localbbzp.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Bcan.b(localbbzp);
    }
  }
  
  public void a(bbzp parambbzp)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcan.a(parambbzp);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambbzp);
    }
  }
  
  public void a(ArrayList<bbzz> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      bbzz localbbzz = (bbzz)paramArrayList.get(i);
      this.jdField_a_of_type_Bcan.a(localbbzz);
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
          this.jdField_a_of_type_Bcan.c((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = bbzq.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((bbzp)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof bbzy)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (bbzy)localObject;
        if (i == 0) {
          break label266;
        }
        bbzy localbbzy = (bbzy)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (bbzy)localObject;
        if (TextUtils.isEmpty(localbbzy.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((bbzy)localObject).a))
        {
          ((bbzy)localObject).a = localbbzy.a;
          continue;
        }
        ((bbzy)localObject).a = (((bbzy)localObject).a + "\n" + localbbzy.a);
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
      if (!((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<bbzt> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bbzp localbbzp = (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbbzp instanceof bbzt)) {
        localArrayList.add((bbzt)localbbzp);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcan.c((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    bbzp localbbzp = (bbzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbbzp.c = paramInt;
    this.jdField_a_of_type_Bcan.a(paramViewHolder, localbbzp, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Bcan.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Bcan.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Bcan.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Bcan.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzl
 * JD-Core Version:    0.7.0.1
 */