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

public class blbs
  extends RecyclerView.Adapter<blbw>
  implements blby
{
  public static bkvu a;
  public static bkvu b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkle jdField_a_of_type_Bkle;
  private bkpa jdField_a_of_type_Bkpa;
  private bkvr jdField_a_of_type_Bkvr;
  private blbj jdField_a_of_type_Blbj;
  private blbm jdField_a_of_type_Blbm;
  private blbv jdField_a_of_type_Blbv;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bkvu> jdField_a_of_type_JavaUtilList;
  private Map<String, blbw> jdField_a_of_type_JavaUtilMap;
  
  public blbs(@NonNull Context paramContext, @NonNull blbm paramblbm, @NonNull blbv paramblbv, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blbm = paramblbm;
    this.jdField_a_of_type_Bkle = ((bkle)this.jdField_a_of_type_Blbm.a(65537, new Object[0]));
    this.jdField_a_of_type_Bkpa = this.jdField_a_of_type_Bkle.a();
    this.jdField_a_of_type_Blbv = paramblbv;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkvr = ((bkvr)blmf.a().c(18));
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull bkvu parambkvu)
  {
    if (parambkvu.jdField_f_of_type_Int == 0)
    {
      b = parambkvu;
      new StringBuilder().append(bnkz.jdField_a_of_type_JavaLangString).append(parambkvu.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bkpa.a(parambkvu);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bkpa.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bkpa.b(i);
      this.jdField_a_of_type_Blbm.a(393218, new Object[] { parambkvu });
    }
    while ((parambkvu.jdField_f_of_type_Int != 4) && (parambkvu.jdField_f_of_type_Int != 5) && (parambkvu.jdField_f_of_type_Int != 6) && (parambkvu.jdField_f_of_type_Int != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Blbm.a(655361, new Object[] { parambkvu });
  }
  
  private void a(String paramString, blbw paramblbw)
  {
    try
    {
      Iterator localIterator = bldz.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bldz.a().b(paramString, paramblbw);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, bldy parambldy)
  {
    try
    {
      Iterator localIterator = bldz.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bldz.a().a(paramString, parambldy);
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
  
  private void b(@NonNull bkvu parambkvu)
  {
    if ((parambkvu.e) || (TextUtils.isEmpty(parambkvu.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (bdee.b(this.jdField_a_of_type_AndroidContentContext))
    {
      c(parambkvu);
      return;
    }
    d(parambkvu);
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
      paramString = (blbw)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Bkvu == null) || (!paramString.jdField_a_of_type_Bkvu.e));
    a(paramString.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull bkvu parambkvu)
  {
    parambkvu = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131710204)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698617)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694951), new blbu(this, parambkvu)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690648), new blbt(this));
    if (parambkvu != null) {}
    try
    {
      if (!parambkvu.isShowing()) {
        parambkvu.show();
      }
      return;
    }
    catch (Throwable parambkvu) {}
  }
  
  private void d(@NonNull bkvu parambkvu)
  {
    blbw localblbw = (blbw)this.jdField_a_of_type_JavaUtilMap.get(parambkvu.jdField_a_of_type_JavaLangString);
    if (localblbw != null) {
      localblbw.b();
    }
    blfg.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + parambkvu.jdField_a_of_type_JavaLangString);
    bldz.a().a(parambkvu.jdField_a_of_type_JavaLangString, localblbw);
    bldz.a().a(this.jdField_a_of_type_Blbm, this.jdField_a_of_type_Bkvr, parambkvu);
  }
  
  private void e(@NonNull bkvu parambkvu)
  {
    this.jdField_a_of_type_Blbm.a(655362, new Object[] { parambkvu });
  }
  
  private void f(@NonNull bkvu parambkvu)
  {
    this.jdField_a_of_type_Blbm.a(655363, new Object[] { parambkvu });
  }
  
  public blbw a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558497, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558498, paramViewGroup, false)) {
      return new blbw(paramViewGroup, this.jdField_a_of_type_Blbv, this, this.jdField_a_of_type_Int);
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
  
  public void a(View paramView, @NonNull bkvu parambkvu, int paramInt)
  {
    if (blff.a(paramView)) {}
    label142:
    label189:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bler.a().b(paramInt);
        bler.a().f("3");
        bler.a().c(parambkvu.jdField_f_of_type_Int);
        jdField_a_of_type_Bkvu = parambkvu;
        blfg.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + parambkvu.jdField_f_of_type_Int);
        blfg.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + parambkvu.jdField_a_of_type_JavaLangString);
        if (!bkvu.b(parambkvu)) {
          break label189;
        }
        if (!parambkvu.d) {
          break label142;
        }
        a(parambkvu);
      }
      for (;;)
      {
        blen.a().c(parambkvu.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bdee.a())
        {
          jdField_a_of_type_Bkvu = null;
          b = null;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718824), 0).a();
        }
        else
        {
          b(parambkvu);
        }
      }
      if (parambkvu.jdField_f_of_type_Int == 2)
      {
        e(parambkvu);
        blen.a().c(parambkvu.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (parambkvu.jdField_f_of_type_Int != 3);
    f(parambkvu);
    blen.a().c(parambkvu.jdField_a_of_type_JavaLangString);
  }
  
  public void a(blbw paramblbw)
  {
    super.onViewAttachedToWindow(paramblbw);
    if ((paramblbw.jdField_a_of_type_Bkvu != null) && (!TextUtils.isEmpty(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)) && (bkvu.b(paramblbw.jdField_a_of_type_Bkvu)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, paramblbw);
      paramblbw.a();
      a(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, paramblbw);
    }
  }
  
  public void a(blbw paramblbw, int paramInt)
  {
    bkvu localbkvu = (bkvu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramblbw.a(localbkvu, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbkvu.j)))
    {
      bler.a().c(paramblbw.jdField_a_of_type_Bkvu.jdField_f_of_type_Int);
      bler.a().b(paramInt + 1);
      blen.a().f(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<bkvu> paramList)
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
      bldz.a().b((String)localEntry.getKey(), (bldy)localEntry.getValue());
    }
  }
  
  public void b(blbw paramblbw)
  {
    super.onViewDetachedFromWindow(paramblbw);
    if ((paramblbw.jdField_a_of_type_Bkvu != null) && (!TextUtils.isEmpty(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)) && (bkvu.b(paramblbw.jdField_a_of_type_Bkvu)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString);
      paramblbw.a();
      a(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, paramblbw);
      b(paramblbw.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbs
 * JD-Core Version:    0.7.0.1
 */