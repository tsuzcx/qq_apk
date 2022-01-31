import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class babc
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public bace a;
  private ArrayList<babg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public babc(SparseArray<bacc> paramSparseArray)
  {
    this.jdField_a_of_type_Bace = new bace();
    this.jdField_a_of_type_Bace.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public babg a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (babg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      babg localbabg = (babg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbabg.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbabg.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<babq> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      babg localbabg = (babg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbabg instanceof babq)) && (((babq)localbabg).g != 3)) {
        localArrayList.add((babq)localbabg);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bace.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, babg parambabg)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bace.a(parambabg);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambabg);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    babg localbabg = a(paramInt);
    if (localbabg != null)
    {
      localbabg.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Bace.b(localbabg);
    }
  }
  
  public void a(babg parambabg)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bace.a(parambabg);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambabg);
    }
  }
  
  public void a(ArrayList<babq> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      babq localbabq = (babq)paramArrayList.get(i);
      this.jdField_a_of_type_Bace.a(localbabq);
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
          this.jdField_a_of_type_Bace.c((babg)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = babh.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((babg)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (babg)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof babp)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (babp)localObject;
        if (i == 0) {
          break label266;
        }
        babp localbabp = (babp)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (babp)localObject;
        if (TextUtils.isEmpty(localbabp.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((babp)localObject).a))
        {
          ((babp)localObject).a = localbabp.a;
          continue;
        }
        ((babp)localObject).a = (((babp)localObject).a + "\n" + localbabp.a);
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
      if (!((babg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((babg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<babk> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      babg localbabg = (babg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbabg instanceof babk)) {
        localArrayList.add((babk)localbabg);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bace.c((babg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((babg)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((babg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((babg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    babg localbabg = (babg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbabg.c = paramInt;
    this.jdField_a_of_type_Bace.a(paramViewHolder, localbabg, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Bace.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Bace.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Bace.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Bace.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babc
 * JD-Core Version:    0.7.0.1
 */