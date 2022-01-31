import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class ansi
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private anov jdField_a_of_type_Anov;
  private anoy jdField_a_of_type_Anoy;
  anpg jdField_a_of_type_Anpg;
  private anpv jdField_a_of_type_Anpv;
  private anrl jdField_a_of_type_Anrl;
  private ansk jdField_a_of_type_Ansk;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private List<anpv> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public ansi(anov paramanov, ansk paramansk, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Anov = paramanov;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Anpv = new anpv();
    this.jdField_a_of_type_Anpv.mType = 1;
    this.jdField_a_of_type_Ansk = paramansk;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = paramGdtAppReceiver;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(String paramString)
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        j = -1;
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramString.equals(((anpv)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public anpv a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < i) {
          localObject1 = (anpv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<anpv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, anpv paramanpv)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramanpv);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Anpv.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(anox paramanox)
  {
    if ((this.jdField_a_of_type_Anoy != null) && (this.jdField_a_of_type_Anoy.itemView != null)) {
      this.jdField_a_of_type_Anoy.a(paramanox);
    }
  }
  
  public void a(anrl paramanrl)
  {
    this.jdField_a_of_type_Anrl = paramanrl;
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    int k = 1;
    int j = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramMiniAppRecommInfo == null)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((anpv)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
    }
    for (i = 1;; i = 0)
    {
      if (paramMiniAppRecommInfo.appInfoList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = paramMiniAppRecommInfo;
        label81:
        if (j >= getItemCount()) {
          break label139;
        }
        if (getItemViewType(j) == 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(j, paramMiniAppRecommInfo);
          i = k;
        }
      }
      label139:
      for (;;)
      {
        if (i == 0) {
          break label140;
        }
        notifyDataSetChanged();
        return;
        i += 1;
        break;
        j += 1;
        break label81;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = null;
      }
      label140:
      break;
    }
  }
  
  public void a(List<anpv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anpg != null) {
      this.jdField_a_of_type_Anpg.a();
    }
    if (this.jdField_a_of_type_Anoy != null) {
      this.jdField_a_of_type_Anoy.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 2;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof anpd)) {
        return 3;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof anow)) {
        return 6;
      }
      if (((anpv)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
        return 4;
      }
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    switch (getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
      paramViewHolder = (anpb)paramViewHolder;
      localObject = (anpv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (anpv)localObject, i);
      if ((this.jdField_a_of_type_Ansk != null) && (this.jdField_a_of_type_Ansk.c() == paramInt) && (!paramViewHolder.a.b())) {
        paramViewHolder.a.c();
      }
      while (this.jdField_a_of_type_Anrl != null)
      {
        this.jdField_a_of_type_Anrl.a(((anpv)localObject).mUin);
        return;
        paramViewHolder.a.d();
      }
    case 1: 
      paramViewHolder = (anpc)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Anpv);
      return;
    case 2: 
      paramViewHolder = (anos)paramViewHolder;
      paramViewHolder.a(paramViewHolder, null, this.c);
      return;
    case 3: 
      paramViewHolder = (anpg)paramViewHolder;
      localObject = (anpd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (anpd)localObject, i);
      return;
    case 5: 
      paramViewHolder = (anps)paramViewHolder;
      localObject = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a((MiniAppRecommInfo)localObject, i);
      return;
    case 4: 
      paramViewHolder = (anot)paramViewHolder;
      localObject = (anpv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (anpv)localObject, i);
      return;
    }
    paramViewHolder = (anoy)paramViewHolder;
    Object localObject = (anpv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    i = n;
    if (paramInt == 0) {
      i = this.jdField_a_of_type_Int;
    }
    paramViewHolder.a((anpv)localObject, i);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    Object localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return null;
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new anpb(paramViewGroup, this.jdField_a_of_type_Ansk, this.jdField_a_of_type_Anov, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new anpc(paramViewGroup, this.jdField_a_of_type_Ansk);
        return new anos(((LayoutInflater)localObject).inflate(2131495164, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ansk, this.b);
        paramViewGroup = new anpg(((LayoutInflater)localObject).inflate(2131495175, paramViewGroup, false), this.jdField_a_of_type_Ansk, this.jdField_a_of_type_Anov, this.jdField_a_of_type_AndroidAppActivity);
        if (this.jdField_a_of_type_Anpg != null) {
          this.jdField_a_of_type_Anpg.a();
        }
        this.jdField_a_of_type_Anpg = ((anpg)paramViewGroup);
        return paramViewGroup;
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new bgrz(this.jdField_a_of_type_AndroidAppActivity, 2131497006, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((bgrz)localObject).a() == null);
      paramViewGroup.addView(((bgrz)localObject).a(), localLayoutParams);
      return new anot(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ansk, (bgrz)localObject);
    case 5: 
      return new anps(((LayoutInflater)localObject).inflate(2131493692, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    }
    paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramViewGroup = new anoy(paramViewGroup, this.jdField_a_of_type_Ansk);
    if (this.jdField_a_of_type_Anoy != null) {
      this.jdField_a_of_type_Anoy.a();
    }
    this.jdField_a_of_type_Anoy = ((anoy)paramViewGroup);
    return paramViewGroup;
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof anpg)) {
      ((anpg)paramViewHolder).a();
    }
    while (!(paramViewHolder instanceof anoy)) {
      return;
    }
    ((anoy)paramViewHolder).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansi
 * JD-Core Version:    0.7.0.1
 */