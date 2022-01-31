import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class bcdu
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public bcew a;
  private ArrayList<bcdy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcdu(SparseArray<bceu> paramSparseArray)
  {
    this.jdField_a_of_type_Bcew = new bcew();
    this.jdField_a_of_type_Bcew.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bcdy a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      bcdy localbcdy = (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbcdy.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbcdy.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<bcei> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bcdy localbcdy = (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbcdy instanceof bcei)) && (((bcei)localbcdy).g != 3)) {
        localArrayList.add((bcei)localbcdy);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcew.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, bcdy parambcdy)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcew.a(parambcdy);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambcdy);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bcdy localbcdy = a(paramInt);
    if (localbcdy != null)
    {
      localbcdy.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Bcew.b(localbcdy);
    }
  }
  
  public void a(bcdy parambcdy)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcew.a(parambcdy);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambcdy);
    }
  }
  
  public void a(ArrayList<bcei> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      bcei localbcei = (bcei)paramArrayList.get(i);
      this.jdField_a_of_type_Bcew.a(localbcei);
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
          this.jdField_a_of_type_Bcew.c((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = bcdz.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((bcdy)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof bceh)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (bceh)localObject;
        if (i == 0) {
          break label266;
        }
        bceh localbceh = (bceh)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (bceh)localObject;
        if (TextUtils.isEmpty(localbceh.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((bceh)localObject).a))
        {
          ((bceh)localObject).a = localbceh.a;
          continue;
        }
        ((bceh)localObject).a = (((bceh)localObject).a + "\n" + localbceh.a);
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
      if (!((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<bcec> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bcdy localbcdy = (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbcdy instanceof bcec)) {
        localArrayList.add((bcec)localbcdy);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bcew.c((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    bcdy localbcdy = (bcdy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbcdy.c = paramInt;
    this.jdField_a_of_type_Bcew.a(paramViewHolder, localbcdy, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Bcew.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Bcew.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Bcew.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Bcew.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdu
 * JD-Core Version:    0.7.0.1
 */