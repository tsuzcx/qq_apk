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

public class bfun
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public bfvp a;
  private ArrayList<bfur> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bfun(SparseArray<bfvn> paramSparseArray)
  {
    this.jdField_a_of_type_Bfvp = new bfvp();
    this.jdField_a_of_type_Bfvp.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bfur a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      bfur localbfur = (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbfur.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localbfur.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<bfvb> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bfur localbfur = (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localbfur instanceof bfvb)) && (((bfvb)localbfur).g != 3)) {
        localArrayList.add((bfvb)localbfur);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfvp.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, bfur parambfur)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bfvp.a(parambfur);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambfur);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bfur localbfur = a(paramInt);
    if (localbfur != null)
    {
      localbfur.a(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_Bfvp.b(localbfur);
    }
  }
  
  public void a(bfur parambfur)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bfvp.a(parambfur);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambfur);
    }
  }
  
  public void a(ArrayList<bfvb> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      bfvb localbfvb = (bfvb)paramArrayList.get(i);
      this.jdField_a_of_type_Bfvp.a(localbfvb);
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
          this.jdField_a_of_type_Bfvp.c((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = bfus.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((bfur)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof bfva)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (bfva)localObject;
        if (i == 0) {
          break label266;
        }
        bfva localbfva = (bfva)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (bfva)localObject;
        if (TextUtils.isEmpty(localbfva.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((bfva)localObject).a))
        {
          ((bfva)localObject).a = localbfva.a;
          continue;
        }
        ((bfva)localObject).a = (((bfva)localObject).a + "\n" + localbfva.a);
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
      if (!((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
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
      j += ((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<bfuv> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bfur localbfur = (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localbfur instanceof bfuv)) {
        localArrayList.add((bfuv)localbfur);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Bfvp.c((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bfur)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    bfur localbfur = (bfur)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbfur.c = paramInt;
    this.jdField_a_of_type_Bfvp.a(paramViewHolder, localbfur, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_Bfvp.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_Bfvp.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_Bfvp.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_Bfvp.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfun
 * JD-Core Version:    0.7.0.1
 */