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

public class biwy
  extends RecyclerView.Adapter<bixc>
  implements bixe
{
  public static bire a;
  public static bire b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bijd jdField_a_of_type_Bijd;
  private bikl jdField_a_of_type_Bikl;
  private birb jdField_a_of_type_Birb;
  private biwp jdField_a_of_type_Biwp;
  private biws jdField_a_of_type_Biws;
  private bixb jdField_a_of_type_Bixb;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bire> jdField_a_of_type_JavaUtilList;
  private Map<String, bixc> jdField_a_of_type_JavaUtilMap;
  
  public biwy(@NonNull Context paramContext, @NonNull biws parambiws, @NonNull bixb parambixb, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biws = parambiws;
    this.jdField_a_of_type_Bijd = ((bijd)this.jdField_a_of_type_Biws.a(65537, new Object[0]));
    this.jdField_a_of_type_Bikl = this.jdField_a_of_type_Bijd.a();
    this.jdField_a_of_type_Bixb = parambixb;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Birb = ((birb)bjav.a().c(18));
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull bire parambire)
  {
    if (parambire.jdField_f_of_type_Int == 0)
    {
      b = parambire;
      new StringBuilder().append(bkzp.jdField_a_of_type_JavaLangString).append(parambire.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bikl.a(parambire);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bikl.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bikl.b(i);
      this.jdField_a_of_type_Biws.a(393218, new Object[] { parambire });
    }
    while ((parambire.jdField_f_of_type_Int != 4) && (parambire.jdField_f_of_type_Int != 5) && (parambire.jdField_f_of_type_Int != 6) && (parambire.jdField_f_of_type_Int != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Biws.a(655361, new Object[] { parambire });
  }
  
  private void a(String paramString, bixc parambixc)
  {
    try
    {
      Iterator localIterator = bizf.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bizf.a().b(paramString, parambixc);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, bize parambize)
  {
    try
    {
      Iterator localIterator = bizf.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bizf.a().a(paramString, parambize);
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
  
  private void b(@NonNull bire parambire)
  {
    if ((parambire.e) || (TextUtils.isEmpty(parambire.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (bbfj.b(this.jdField_a_of_type_AndroidContentContext))
    {
      c(parambire);
      return;
    }
    d(parambire);
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
      paramString = (bixc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Bire == null) || (!paramString.jdField_a_of_type_Bire.e));
    a(paramString.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull bire parambire)
  {
    parambire = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131709832)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698327)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694794), new bixa(this, parambire)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690596), new biwz(this));
    if (parambire != null) {}
    try
    {
      if (!parambire.isShowing()) {
        parambire.show();
      }
      return;
    }
    catch (Throwable parambire) {}
  }
  
  private void d(@NonNull bire parambire)
  {
    bixc localbixc = (bixc)this.jdField_a_of_type_JavaUtilMap.get(parambire.jdField_a_of_type_JavaLangString);
    if (localbixc != null) {
      localbixc.b();
    }
    bjah.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + parambire.jdField_a_of_type_JavaLangString);
    bizf.a().a(parambire.jdField_a_of_type_JavaLangString, localbixc);
    bizf.a().a(this.jdField_a_of_type_Biws, this.jdField_a_of_type_Birb, parambire);
  }
  
  private void e(@NonNull bire parambire)
  {
    this.jdField_a_of_type_Biws.a(655362, new Object[] { parambire });
  }
  
  private void f(@NonNull bire parambire)
  {
    this.jdField_a_of_type_Biws.a(655363, new Object[] { parambire });
  }
  
  public bixc a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558493, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558494, paramViewGroup, false)) {
      return new bixc(paramViewGroup, this.jdField_a_of_type_Bixb, this, this.jdField_a_of_type_Int);
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
  
  public void a(View paramView, @NonNull bire parambire, int paramInt)
  {
    if (bjag.a(paramView)) {}
    label142:
    label189:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bizx.a().b(paramInt);
        bizx.a().f("3");
        bizx.a().c(parambire.jdField_f_of_type_Int);
        jdField_a_of_type_Bire = parambire;
        bjah.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + parambire.jdField_f_of_type_Int);
        bjah.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + parambire.jdField_a_of_type_JavaLangString);
        if (!bire.b(parambire)) {
          break label189;
        }
        if (!parambire.d) {
          break label142;
        }
        a(parambire);
      }
      for (;;)
      {
        bizt.a().b(parambire.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bbfj.a())
        {
          jdField_a_of_type_Bire = null;
          b = null;
          bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718402), 0).a();
        }
        else
        {
          b(parambire);
        }
      }
      if (parambire.jdField_f_of_type_Int == 2)
      {
        e(parambire);
        bizt.a().b(parambire.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (parambire.jdField_f_of_type_Int != 3);
    f(parambire);
    bizt.a().b(parambire.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bixc parambixc)
  {
    super.onViewAttachedToWindow(parambixc);
    if ((parambixc.jdField_a_of_type_Bire != null) && (!TextUtils.isEmpty(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)) && (bire.b(parambixc.jdField_a_of_type_Bire)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, parambixc);
      parambixc.a();
      a(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, parambixc);
    }
  }
  
  public void a(bixc parambixc, int paramInt)
  {
    bire localbire = (bire)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambixc.a(localbire, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbire.i)))
    {
      bizx.a().c(parambixc.jdField_a_of_type_Bire.jdField_f_of_type_Int);
      bizx.a().b(paramInt + 1);
      bizt.a().e(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<bire> paramList)
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
      bizf.a().b((String)localEntry.getKey(), (bize)localEntry.getValue());
    }
  }
  
  public void b(bixc parambixc)
  {
    super.onViewDetachedFromWindow(parambixc);
    if ((parambixc.jdField_a_of_type_Bire != null) && (!TextUtils.isEmpty(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)) && (bire.b(parambixc.jdField_a_of_type_Bire)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString);
      parambixc.a();
      a(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, parambixc);
      b(parambixc.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwy
 * JD-Core Version:    0.7.0.1
 */