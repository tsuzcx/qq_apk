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

public class bowt
  extends RecyclerView.Adapter<bowv>
  implements bowx
{
  public static boqu a;
  public static boqu b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bofh jdField_a_of_type_Bofh;
  private bojq jdField_a_of_type_Bojq;
  private boqr jdField_a_of_type_Boqr;
  private bowk jdField_a_of_type_Bowk;
  private bown jdField_a_of_type_Bown;
  private bowu jdField_a_of_type_Bowu;
  private String jdField_a_of_type_JavaLangString = "";
  private List<boqu> jdField_a_of_type_JavaUtilList;
  private Map<String, bowv> jdField_a_of_type_JavaUtilMap;
  
  public bowt(@NonNull Context paramContext, @NonNull bown parambown, @NonNull bowu parambowu, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bown = parambown;
    this.jdField_a_of_type_Bofh = ((bofh)this.jdField_a_of_type_Bown.a(65537, new Object[0]));
    this.jdField_a_of_type_Bojq = this.jdField_a_of_type_Bofh.a();
    this.jdField_a_of_type_Bowu = parambowu;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a().c(18));
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull boqu paramboqu)
  {
    if (paramboqu.g == 0)
    {
      b = paramboqu;
      new StringBuilder().append(brhn.jdField_a_of_type_JavaLangString).append(paramboqu.jdField_f_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bojq.a(paramboqu);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bojq.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bojq.b(i);
      this.jdField_a_of_type_Bown.a(393218, new Object[] { paramboqu });
    }
    while ((paramboqu.g != 4) && (paramboqu.g != 5) && (paramboqu.g != 6) && (paramboqu.g != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Bown.a(655361, new Object[] { paramboqu });
  }
  
  private void a(String paramString, bowv parambowv)
  {
    try
    {
      Iterator localIterator = bozd.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bozd.a().b(paramString, parambowv);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, bozc parambozc)
  {
    try
    {
      Iterator localIterator = bozd.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          bozd.a().a(paramString, parambozc);
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
  
  private void b(@NonNull boqu paramboqu)
  {
    if ((paramboqu.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(paramboqu.jdField_a_of_type_JavaLangString))) {
      return;
    }
    c(paramboqu);
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
      paramString = (bowv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Boqu == null) || (!paramString.jdField_a_of_type_Boqu.jdField_f_of_type_Boolean));
    a(paramString.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull boqu paramboqu)
  {
    bowv localbowv = (bowv)this.jdField_a_of_type_JavaUtilMap.get(paramboqu.jdField_a_of_type_JavaLangString);
    if (localbowv != null) {
      localbowv.b();
    }
    bpam.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + paramboqu.jdField_a_of_type_JavaLangString);
    bozd.a().a(paramboqu.jdField_a_of_type_JavaLangString, localbowv);
    bozd.a().a(this.jdField_a_of_type_Bown, this.jdField_a_of_type_Boqr, paramboqu);
  }
  
  private void d(@NonNull boqu paramboqu)
  {
    this.jdField_a_of_type_Bown.a(655362, new Object[] { paramboqu });
  }
  
  private void e(@NonNull boqu paramboqu)
  {
    this.jdField_a_of_type_Bown.a(655363, new Object[] { paramboqu });
  }
  
  public bowv a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558510, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558511, paramViewGroup, false)) {
      return new bowv(paramViewGroup, this.jdField_a_of_type_Bowu, this, this.jdField_a_of_type_Int);
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
  
  public void a(View paramView, @NonNull boqu paramboqu, int paramInt)
  {
    if (bpak.a(paramView)) {}
    label140:
    label187:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bozv.a().c(paramInt);
        bozv.a().f("3");
        bozv.a().d(paramboqu.g);
        jdField_a_of_type_Boqu = paramboqu;
        bpam.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + paramboqu.g);
        bpam.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + paramboqu.jdField_a_of_type_JavaLangString);
        if (!boqu.b(paramboqu)) {
          break label187;
        }
        if (!paramboqu.e) {
          break label140;
        }
        a(paramboqu);
      }
      for (;;)
      {
        bozr.a().d(paramboqu.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!bhnv.a())
        {
          jdField_a_of_type_Boqu = null;
          b = null;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131717088), 0).a();
        }
        else
        {
          b(paramboqu);
        }
      }
      if (paramboqu.g == 2)
      {
        d(paramboqu);
        bozr.a().d(paramboqu.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramboqu.g != 3);
    e(paramboqu);
    bozr.a().d(paramboqu.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bowv parambowv)
  {
    super.onViewAttachedToWindow(parambowv);
    if ((parambowv.jdField_a_of_type_Boqu != null) && (!TextUtils.isEmpty(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (boqu.b(parambowv.jdField_a_of_type_Boqu)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambowv);
      parambowv.a();
      a(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambowv);
    }
  }
  
  public void a(bowv parambowv, int paramInt)
  {
    boqu localboqu = (boqu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambowv.a(localboqu, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localboqu.k)))
    {
      bozv.a().d(parambowv.jdField_a_of_type_Boqu.g);
      bozv.a().c(paramInt + 1);
      bozr.a().g(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(parambowv, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<boqu> paramList)
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
      bozd.a().b((String)localEntry.getKey(), (bozc)localEntry.getValue());
    }
  }
  
  public void b(bowv parambowv)
  {
    super.onViewDetachedFromWindow(parambowv);
    if ((parambowv.jdField_a_of_type_Boqu != null) && (!TextUtils.isEmpty(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (boqu.b(parambowv.jdField_a_of_type_Boqu)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
      parambowv.a();
      a(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambowv);
      b(parambowv.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowt
 * JD-Core Version:    0.7.0.1
 */