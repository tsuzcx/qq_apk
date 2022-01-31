import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class blfz
  extends RecyclerView.Adapter<blgd>
  implements blgf
{
  public static blab a;
  public static blab b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkpl jdField_a_of_type_Bkpl;
  private bkth jdField_a_of_type_Bkth;
  private bkzy jdField_a_of_type_Bkzy;
  private blfq jdField_a_of_type_Blfq;
  private blft jdField_a_of_type_Blft;
  private blgc jdField_a_of_type_Blgc;
  private String jdField_a_of_type_JavaLangString = "";
  private List<blab> jdField_a_of_type_JavaUtilList;
  private Map<String, blgd> jdField_a_of_type_JavaUtilMap;
  
  public blfz(@NonNull Context paramContext, @NonNull blft paramblft, @NonNull blgc paramblgc, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blft = paramblft;
    this.jdField_a_of_type_Bkpl = ((bkpl)this.jdField_a_of_type_Blft.a(65537, new Object[0]));
    this.jdField_a_of_type_Bkth = this.jdField_a_of_type_Bkpl.a();
    this.jdField_a_of_type_Blgc = paramblgc;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a().c(18));
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull blab paramblab)
  {
    if (paramblab.jdField_f_of_type_Int == 0)
    {
      b = paramblab;
      new StringBuilder().append(bnpl.jdField_a_of_type_JavaLangString).append(paramblab.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bkth.a(paramblab);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bkth.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bkth.b(i);
      this.jdField_a_of_type_Blft.a(393218, new Object[] { paramblab });
    }
    while ((paramblab.jdField_f_of_type_Int != 4) && (paramblab.jdField_f_of_type_Int != 5) && (paramblab.jdField_f_of_type_Int != 6) && (paramblab.jdField_f_of_type_Int != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Blft.a(655361, new Object[] { paramblab });
  }
  
  private void a(String paramString, blgd paramblgd)
  {
    try
    {
      Iterator localIterator = blig.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          blig.a().b(paramString, paramblgd);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, blif paramblif)
  {
    try
    {
      Iterator localIterator = blig.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          blig.a().a(paramString, paramblif);
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
  
  private void b(@NonNull blab paramblab)
  {
    if ((paramblab.e) || (TextUtils.isEmpty(paramblab.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (bdin.b(this.jdField_a_of_type_AndroidContentContext))
    {
      c(paramblab);
      return;
    }
    d(paramblab);
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
      paramString = (blgd)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Blab == null) || (!paramString.jdField_a_of_type_Blab.e));
    a(paramString.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull blab paramblab)
  {
    paramblab = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131710216)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698629)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694953), new blgb(this, paramblab)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690648), new blga(this));
    if (paramblab != null) {}
    try
    {
      if (!paramblab.isShowing()) {
        paramblab.show();
      }
      return;
    }
    catch (Throwable paramblab) {}
  }
  
  private void d(@NonNull blab paramblab)
  {
    blgd localblgd = (blgd)this.jdField_a_of_type_JavaUtilMap.get(paramblab.jdField_a_of_type_JavaLangString);
    if (localblgd != null) {
      localblgd.b();
    }
    bljn.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + paramblab.jdField_a_of_type_JavaLangString);
    blig.a().a(paramblab.jdField_a_of_type_JavaLangString, localblgd);
    blig.a().a(this.jdField_a_of_type_Blft, this.jdField_a_of_type_Bkzy, paramblab);
  }
  
  private void e(@NonNull blab paramblab)
  {
    this.jdField_a_of_type_Blft.a(655362, new Object[] { paramblab });
  }
  
  private void f(@NonNull blab paramblab)
  {
    this.jdField_a_of_type_Blft.a(655363, new Object[] { paramblab });
  }
  
  public blgd a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558497, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558498, paramViewGroup, false)) {
      return new blgd(paramViewGroup, this.jdField_a_of_type_Blgc, this, this.jdField_a_of_type_Int);
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
  
  public void a(View paramView, @NonNull blab paramblab, int paramInt)
  {
    if (bljm.a(paramView)) {}
    label142:
    label189:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bliy.a().b(paramInt);
        bliy.a().f("3");
        bliy.a().c(paramblab.jdField_f_of_type_Int);
        jdField_a_of_type_Blab = paramblab;
        bljn.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + paramblab.jdField_f_of_type_Int);
        bljn.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + paramblab.jdField_a_of_type_JavaLangString);
        if (!blab.b(paramblab)) {
          break label189;
        }
        if (!paramblab.d) {
          break label142;
        }
        a(paramblab);
      }
      for (;;)
      {
        bliu.a().c(paramblab.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bdin.a())
        {
          jdField_a_of_type_Blab = null;
          b = null;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718836), 0).a();
        }
        else
        {
          b(paramblab);
        }
      }
      if (paramblab.jdField_f_of_type_Int == 2)
      {
        e(paramblab);
        bliu.a().c(paramblab.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramblab.jdField_f_of_type_Int != 3);
    f(paramblab);
    bliu.a().c(paramblab.jdField_a_of_type_JavaLangString);
  }
  
  public void a(blgd paramblgd)
  {
    super.onViewAttachedToWindow(paramblgd);
    if ((paramblgd.jdField_a_of_type_Blab != null) && (!TextUtils.isEmpty(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)) && (blab.b(paramblgd.jdField_a_of_type_Blab)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, paramblgd);
      paramblgd.a();
      a(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, paramblgd);
    }
  }
  
  public void a(blgd paramblgd, int paramInt)
  {
    blab localblab = (blab)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramblgd.a(localblab, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localblab.j)))
    {
      bliy.a().c(paramblgd.jdField_a_of_type_Blab.jdField_f_of_type_Int);
      bliy.a().b(paramInt + 1);
      bliu.a().f(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<blab> paramList)
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
      blig.a().b((String)localEntry.getKey(), (blif)localEntry.getValue());
    }
  }
  
  public void b(blgd paramblgd)
  {
    super.onViewDetachedFromWindow(paramblgd);
    if ((paramblgd.jdField_a_of_type_Blab != null) && (!TextUtils.isEmpty(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)) && (blab.b(paramblgd.jdField_a_of_type_Blab)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString);
      paramblgd.a();
      a(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, paramblgd);
      b(paramblgd.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfz
 * JD-Core Version:    0.7.0.1
 */