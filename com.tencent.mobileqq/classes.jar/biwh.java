import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class biwh
  extends RecyclerView.Adapter<biwl>
  implements biwn
{
  public static biqn a;
  public static biqn b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private biim jdField_a_of_type_Biim;
  private biju jdField_a_of_type_Biju;
  private biqk jdField_a_of_type_Biqk;
  private bivy jdField_a_of_type_Bivy;
  private biwb jdField_a_of_type_Biwb;
  private biwk jdField_a_of_type_Biwk;
  private String jdField_a_of_type_JavaLangString = "";
  private List<biqn> jdField_a_of_type_JavaUtilList;
  private Map<String, biwl> jdField_a_of_type_JavaUtilMap;
  
  public biwh(@NonNull Context paramContext, @NonNull biwb parambiwb, @NonNull biwk parambiwk, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biwb = parambiwb;
    this.jdField_a_of_type_Biim = ((biim)this.jdField_a_of_type_Biwb.a(65537, new Object[0]));
    this.jdField_a_of_type_Biju = this.jdField_a_of_type_Biim.a();
    this.jdField_a_of_type_Biwk = parambiwk;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Biqk = ((biqk)bjae.a().c(18));
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull biqn parambiqn)
  {
    if (parambiqn.jdField_f_of_type_Int == 0)
    {
      b = parambiqn;
      new StringBuilder().append(bkyy.jdField_a_of_type_JavaLangString).append(parambiqn.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Biju.a(parambiqn);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Biju.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Biju.b(i);
      this.jdField_a_of_type_Biwb.a(393218, new Object[] { parambiqn });
    }
    while ((parambiqn.jdField_f_of_type_Int != 4) && (parambiqn.jdField_f_of_type_Int != 5) && (parambiqn.jdField_f_of_type_Int != 6) && (parambiqn.jdField_f_of_type_Int != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Biwb.a(655361, new Object[] { parambiqn });
  }
  
  private void a(String paramString, biwl parambiwl)
  {
    try
    {
      Iterator localIterator = biyo.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          biyo.a().b(paramString, parambiwl);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, biyn parambiyn)
  {
    try
    {
      Iterator localIterator = biyo.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          biyo.a().a(paramString, parambiyn);
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
  
  private void b(@NonNull biqn parambiqn)
  {
    if ((parambiqn.e) || (TextUtils.isEmpty(parambiqn.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (bbev.b(this.jdField_a_of_type_AndroidContentContext))
    {
      c(parambiqn);
      return;
    }
    d(parambiqn);
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
      paramString = (biwl)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Biqn == null) || (!paramString.jdField_a_of_type_Biqn.e));
    a(paramString.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull biqn parambiqn)
  {
    parambiqn = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131709821)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698317)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694793), new biwj(this, parambiqn)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690596), new biwi(this));
    if (parambiqn != null) {}
    try
    {
      if (!parambiqn.isShowing()) {
        parambiqn.show();
      }
      return;
    }
    catch (Throwable parambiqn) {}
  }
  
  private void d(@NonNull biqn parambiqn)
  {
    biwl localbiwl = (biwl)this.jdField_a_of_type_JavaUtilMap.get(parambiqn.jdField_a_of_type_JavaLangString);
    if (localbiwl != null) {
      localbiwl.b();
    }
    bizq.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + parambiqn.jdField_a_of_type_JavaLangString);
    biyo.a().a(parambiqn.jdField_a_of_type_JavaLangString, localbiwl);
    biyo.a().a(this.jdField_a_of_type_Biwb, this.jdField_a_of_type_Biqk, parambiqn);
  }
  
  private void e(@NonNull biqn parambiqn)
  {
    this.jdField_a_of_type_Biwb.a(655362, new Object[] { parambiqn });
  }
  
  private void f(@NonNull biqn parambiqn)
  {
    this.jdField_a_of_type_Biwb.a(655363, new Object[] { parambiqn });
  }
  
  public biwl a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558493, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558494, paramViewGroup, false)) {
      return new biwl(paramViewGroup, this.jdField_a_of_type_Biwk, this, this.jdField_a_of_type_Int);
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
  
  public void a(View paramView, @NonNull biqn parambiqn, int paramInt)
  {
    if (bizp.a(paramView)) {}
    label142:
    label189:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bizg.a().b(paramInt);
        bizg.a().f("3");
        bizg.a().c(parambiqn.jdField_f_of_type_Int);
        jdField_a_of_type_Biqn = parambiqn;
        bizq.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + parambiqn.jdField_f_of_type_Int);
        bizq.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + parambiqn.jdField_a_of_type_JavaLangString);
        if (!biqn.b(parambiqn)) {
          break label189;
        }
        if (!parambiqn.d) {
          break label142;
        }
        a(parambiqn);
      }
      for (;;)
      {
        bizc.a().b(parambiqn.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bbev.a())
        {
          jdField_a_of_type_Biqn = null;
          b = null;
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718391), 0).a();
        }
        else
        {
          b(parambiqn);
        }
      }
      if (parambiqn.jdField_f_of_type_Int == 2)
      {
        e(parambiqn);
        bizc.a().b(parambiqn.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (parambiqn.jdField_f_of_type_Int != 3);
    f(parambiqn);
    bizc.a().b(parambiqn.jdField_a_of_type_JavaLangString);
  }
  
  public void a(biwl parambiwl)
  {
    super.onViewAttachedToWindow(parambiwl);
    if ((parambiwl.jdField_a_of_type_Biqn != null) && (!TextUtils.isEmpty(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)) && (biqn.b(parambiwl.jdField_a_of_type_Biqn)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, parambiwl);
      parambiwl.a();
      a(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, parambiwl);
    }
  }
  
  public void a(biwl parambiwl, int paramInt)
  {
    biqn localbiqn = (biqn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambiwl.a(localbiqn, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbiqn.i)))
    {
      bizg.a().c(parambiwl.jdField_a_of_type_Biqn.jdField_f_of_type_Int);
      bizg.a().b(paramInt + 1);
      bizc.a().e(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<biqn> paramList)
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
      biyo.a().b((String)localEntry.getKey(), (biyn)localEntry.getValue());
    }
  }
  
  public void b(biwl parambiwl)
  {
    super.onViewDetachedFromWindow(parambiwl);
    if ((parambiwl.jdField_a_of_type_Biqn != null) && (!TextUtils.isEmpty(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)) && (biqn.b(parambiwl.jdField_a_of_type_Biqn)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString);
      parambiwl.a();
      a(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, parambiwl);
      b(parambiwl.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwh
 * JD-Core Version:    0.7.0.1
 */