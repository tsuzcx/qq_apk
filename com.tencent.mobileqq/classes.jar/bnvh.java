import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bnvh
  extends RecyclerView.Adapter<bnvl>
  implements bnvn
{
  public static bnpf a;
  public static bnpf b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bndy jdField_a_of_type_Bndy;
  private bnii jdField_a_of_type_Bnii;
  private bnpc jdField_a_of_type_Bnpc;
  private bnuy jdField_a_of_type_Bnuy;
  private bnvb jdField_a_of_type_Bnvb;
  private bnvk jdField_a_of_type_Bnvk;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bnpf> jdField_a_of_type_JavaUtilList;
  private Map<String, bnvl> jdField_a_of_type_JavaUtilMap;
  
  public bnvh(@NonNull Context paramContext, @NonNull bnvb parambnvb, @NonNull bnvk parambnvk, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnvb = parambnvb;
    this.jdField_a_of_type_Bndy = ((bndy)this.jdField_a_of_type_Bnvb.a(65537, new Object[0]));
    this.jdField_a_of_type_Bnii = this.jdField_a_of_type_Bndy.a();
    this.jdField_a_of_type_Bnvk = parambnvk;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a().c(18));
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull bnpf parambnpf)
  {
    if (parambnpf.g == 0)
    {
      b = parambnpf;
      new StringBuilder().append(bqgc.jdField_a_of_type_JavaLangString).append(parambnpf.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bnii.a(parambnpf);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bnii.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bnii.b(i);
      this.jdField_a_of_type_Bnvb.a(393218, new Object[] { parambnpf });
    }
    while ((parambnpf.g != 4) && (parambnpf.g != 5) && (parambnpf.g != 6) && (parambnpf.g != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Bnvb.a(655361, new Object[] { parambnpf });
  }
  
  private void a(String paramString, bnvl parambnvl)
  {
    try
    {
      Iterator localIterator = bnxt.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bnxt.a().b(paramString, parambnvl);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, bnxs parambnxs)
  {
    try
    {
      Iterator localIterator = bnxt.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bnxt.a().a(paramString, parambnxs);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return b != null;
  }
  
  private void b(@NonNull bnpf parambnpf)
  {
    if ((parambnpf.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(parambnpf.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (bgnt.b(this.jdField_a_of_type_AndroidContentContext))
    {
      c(parambnpf);
      return;
    }
    d(parambnpf);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilMap.get(paramString) == null);
      paramString = (bnvl)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Bnpf == null) || (!paramString.jdField_a_of_type_Bnpf.jdField_f_of_type_Boolean));
    a(paramString.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull bnpf parambnpf)
  {
    parambnpf = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131708592)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131697516)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694081), new bnvj(this, parambnpf)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690582), new bnvi(this));
    if (parambnpf != null) {}
    try
    {
      if (!parambnpf.isShowing()) {
        parambnpf.show();
      }
      return;
    }
    catch (Throwable parambnpf) {}
  }
  
  private void d(@NonNull bnpf parambnpf)
  {
    bnvl localbnvl = (bnvl)this.jdField_a_of_type_JavaUtilMap.get(parambnpf.jdField_a_of_type_JavaLangString);
    if (localbnvl != null) {
      localbnvl.b();
    }
    bnzb.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + parambnpf.jdField_a_of_type_JavaLangString);
    bnxt.a().a(parambnpf.jdField_a_of_type_JavaLangString, localbnvl);
    bnxt.a().a(this.jdField_a_of_type_Bnvb, this.jdField_a_of_type_Bnpc, parambnpf);
  }
  
  private void e(@NonNull bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnvb.a(655362, new Object[] { parambnpf });
  }
  
  private void f(@NonNull bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnvb.a(655363, new Object[] { parambnpf });
  }
  
  public bnvl a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558509, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558510, paramViewGroup, false)) {
      return new bnvl(paramViewGroup, this.jdField_a_of_type_Bnvk, this, this.jdField_a_of_type_Int);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          localObject = (String)((Map.Entry)localObject).getKey();
          if (localObject != null) {
            b((String)localObject);
          }
        }
      }
    }
  }
  
  public void a(View paramView, @NonNull bnpf parambnpf, int paramInt)
  {
    if (bnyz.a(paramView)) {}
    label142:
    label189:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bnyl.a().b(paramInt);
        bnyl.a().f("3");
        bnyl.a().c(parambnpf.g);
        jdField_a_of_type_Bnpf = parambnpf;
        bnzb.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + parambnpf.g);
        bnzb.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + parambnpf.jdField_a_of_type_JavaLangString);
        if (!bnpf.b(parambnpf)) {
          break label189;
        }
        if (!parambnpf.e) {
          break label142;
        }
        a(parambnpf);
      }
      for (;;)
      {
        bnyh.a().d(parambnpf.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bgnt.a())
        {
          jdField_a_of_type_Bnpf = null;
          b = null;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131716972), 0).a();
        }
        else
        {
          b(parambnpf);
        }
      }
      if (parambnpf.g == 2)
      {
        e(parambnpf);
        bnyh.a().d(parambnpf.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (parambnpf.g != 3);
    f(parambnpf);
    bnyh.a().d(parambnpf.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bnvl parambnvl)
  {
    super.onViewAttachedToWindow(parambnvl);
    if ((parambnvl.jdField_a_of_type_Bnpf != null) && (!TextUtils.isEmpty(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)) && (bnpf.b(parambnvl.jdField_a_of_type_Bnpf)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambnvl);
      parambnvl.a();
      a(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambnvl);
    }
  }
  
  public void a(bnvl parambnvl, int paramInt)
  {
    bnpf localbnpf = (bnpf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambnvl.a(localbnpf, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbnpf.k)))
    {
      bnyl.a().c(parambnvl.jdField_a_of_type_Bnpf.g);
      bnyl.a().b(paramInt + 1);
      bnyh.a().g(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(parambnvl, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<bnpf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bnxt.a().b((String)localEntry.getKey(), (bnxs)localEntry.getValue());
    }
  }
  
  public void b(bnvl parambnvl)
  {
    super.onViewDetachedFromWindow(parambnvl);
    if ((parambnvl.jdField_a_of_type_Bnpf != null) && (!TextUtils.isEmpty(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)) && (bnpf.b(parambnvl.jdField_a_of_type_Bnpf)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString);
      parambnvl.a();
      a(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambnvl);
      b(parambnvl.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvh
 * JD-Core Version:    0.7.0.1
 */