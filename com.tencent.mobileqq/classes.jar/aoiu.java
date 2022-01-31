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

public class aoiu
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aofg jdField_a_of_type_Aofg;
  private aofj jdField_a_of_type_Aofj;
  aofr jdField_a_of_type_Aofr;
  private aogh jdField_a_of_type_Aogh;
  private aohx jdField_a_of_type_Aohx;
  private aoiw jdField_a_of_type_Aoiw;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private List<aogh> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public aoiu(aofg paramaofg, aoiw paramaoiw, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Aofg = paramaofg;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aogh = new aogh();
    this.jdField_a_of_type_Aogh.mType = 1;
    this.jdField_a_of_type_Aoiw = paramaoiw;
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
          if (paramString.equals(((aogh)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public aogh a(int paramInt)
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
          localObject1 = (aogh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<aogh> a()
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
  
  public void a(int paramInt, aogh paramaogh)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramaogh);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aogh.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(aofi paramaofi)
  {
    if ((this.jdField_a_of_type_Aofj != null) && (this.jdField_a_of_type_Aofj.itemView != null)) {
      this.jdField_a_of_type_Aofj.a(paramaofi);
    }
  }
  
  public void a(aohx paramaohx)
  {
    this.jdField_a_of_type_Aohx = paramaohx;
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
      if (((aogh)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
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
  
  public void a(List<aogh> paramList)
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
    if (this.jdField_a_of_type_Aofr != null) {
      this.jdField_a_of_type_Aofr.a();
    }
    if (this.jdField_a_of_type_Aofj != null) {
      this.jdField_a_of_type_Aofj.a();
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
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof aofo)) {
        return 3;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof aofh)) {
        return 6;
      }
      if (((aogh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
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
      paramViewHolder = (aofm)paramViewHolder;
      localObject = (aogh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (aogh)localObject, i);
      if ((this.jdField_a_of_type_Aoiw != null) && (this.jdField_a_of_type_Aoiw.c() == paramInt) && (!paramViewHolder.a.b())) {
        paramViewHolder.a.c();
      }
      while (this.jdField_a_of_type_Aohx != null)
      {
        this.jdField_a_of_type_Aohx.a(((aogh)localObject).mUin);
        return;
        paramViewHolder.a.d();
      }
    case 1: 
      paramViewHolder = (aofn)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Aogh);
      return;
    case 2: 
      paramViewHolder = (aofd)paramViewHolder;
      paramViewHolder.a(paramViewHolder, null, this.c);
      return;
    case 3: 
      paramViewHolder = (aofr)paramViewHolder;
      localObject = (aofo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (aofo)localObject, i);
      return;
    case 5: 
      paramViewHolder = (aogd)paramViewHolder;
      localObject = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a((MiniAppRecommInfo)localObject, i);
      return;
    case 4: 
      paramViewHolder = (aofe)paramViewHolder;
      localObject = (aogh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (aogh)localObject, i);
      return;
    }
    paramViewHolder = (aofj)paramViewHolder;
    Object localObject = (aogh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    i = n;
    if (paramInt == 0) {
      i = this.jdField_a_of_type_Int;
    }
    paramViewHolder.a((aogh)localObject, i);
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
        return new aofm(paramViewGroup, this.jdField_a_of_type_Aoiw, this.jdField_a_of_type_Aofg, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new aofn(paramViewGroup, this.jdField_a_of_type_Aoiw);
        return new aofd(((LayoutInflater)localObject).inflate(2131560739, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aoiw, this.b);
        paramViewGroup = new aofr(((LayoutInflater)localObject).inflate(2131560750, paramViewGroup, false), this.jdField_a_of_type_Aoiw, this.jdField_a_of_type_Aofg, this.jdField_a_of_type_AndroidAppActivity);
        if (this.jdField_a_of_type_Aofr != null) {
          this.jdField_a_of_type_Aofr.a();
        }
        this.jdField_a_of_type_Aofr = ((aofr)paramViewGroup);
        return paramViewGroup;
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new biay(this.jdField_a_of_type_AndroidAppActivity, 2131562603, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((biay)localObject).a() == null);
      paramViewGroup.addView(((biay)localObject).a(), localLayoutParams);
      return new aofe(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aoiw, (biay)localObject);
    case 5: 
      return new aogd(((LayoutInflater)localObject).inflate(2131559261, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    }
    paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramViewGroup = new aofj(paramViewGroup, this.jdField_a_of_type_Aoiw);
    if (this.jdField_a_of_type_Aofj != null) {
      this.jdField_a_of_type_Aofj.a();
    }
    this.jdField_a_of_type_Aofj = ((aofj)paramViewGroup);
    return paramViewGroup;
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof aofr)) {
      ((aofr)paramViewHolder).a();
    }
    while (!(paramViewHolder instanceof aofj)) {
      return;
    }
    ((aofj)paramViewHolder).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoiu
 * JD-Core Version:    0.7.0.1
 */