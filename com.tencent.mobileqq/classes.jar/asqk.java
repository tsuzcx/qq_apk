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
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class asqk
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private asmq jdField_a_of_type_Asmq;
  private asmt jdField_a_of_type_Asmt;
  private asmw jdField_a_of_type_Asmw;
  private asnq jdField_a_of_type_Asnq;
  private aspq jdField_a_of_type_Aspq;
  private asqm jdField_a_of_type_Asqm;
  asud jdField_a_of_type_Asud;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private List<asnq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public asqk(asmq paramasmq, asqm paramasqm, asmw paramasmw, asud paramasud, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Asmq = paramasmq;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Asnq = new asnq();
    this.jdField_a_of_type_Asnq.mType = 1;
    this.jdField_a_of_type_Asqm = paramasqm;
    this.jdField_a_of_type_Asmw = paramasmw;
    this.jdField_a_of_type_Asud = paramasud;
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
          if (paramString.equals(((asnq)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public asnq a(int paramInt)
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
          localObject1 = (asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<asnq> a()
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
  
  public void a(int paramInt, asnq paramasnq)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramasnq);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Asnq.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(asms paramasms)
  {
    if ((this.jdField_a_of_type_Asmt != null) && (this.jdField_a_of_type_Asmt.itemView != null)) {
      this.jdField_a_of_type_Asmt.a(paramasms);
    }
  }
  
  public void a(aspq paramaspq)
  {
    this.jdField_a_of_type_Aspq = paramaspq;
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
      if (((asnq)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
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
  
  public void a(List<asnq> paramList)
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
    if (this.jdField_a_of_type_Asmt != null) {
      this.jdField_a_of_type_Asmt.a();
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
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof asmr)) {
        return 6;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof asmy)) {
        return 7;
      }
      if (((asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
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
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject1 = (asmz)paramViewHolder;
      Object localObject2 = (asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asmz)localObject1).a((asmz)localObject1, (asnq)localObject2, i);
      if ((this.jdField_a_of_type_Asqm != null) && (this.jdField_a_of_type_Asqm.c() == paramInt) && (!((asmz)localObject1).a.b())) {
        ((asmz)localObject1).a.c();
      }
      while (this.jdField_a_of_type_Aspq != null)
      {
        this.jdField_a_of_type_Aspq.a(((asnq)localObject2).mUin);
        break;
        ((asmz)localObject1).a.d();
      }
      localObject1 = (asnb)paramViewHolder;
      ((asnb)localObject1).a((asnb)localObject1, this.jdField_a_of_type_Asnq);
      continue;
      localObject1 = (asml)paramViewHolder;
      ((asml)localObject1).a((asml)localObject1, null, this.c);
      continue;
      localObject1 = (asnl)paramViewHolder;
      localObject2 = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asnl)localObject1).a((MiniAppRecommInfo)localObject2, i);
      continue;
      localObject1 = (asmm)paramViewHolder;
      localObject2 = (asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asmm)localObject1).a((asmm)localObject1, (asnq)localObject2, i);
      continue;
      localObject1 = (asmt)paramViewHolder;
      localObject2 = (asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asmt)localObject1).a((asnq)localObject2, i);
      continue;
      localObject1 = (asmx)paramViewHolder;
      localObject2 = (asnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = n;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asmx)localObject1).a((asnq)localObject2, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    Object localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        return null;
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new asmz(paramViewGroup, this.jdField_a_of_type_Asqm, this.jdField_a_of_type_Asmq, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new asnb(paramViewGroup, this.jdField_a_of_type_Asqm);
        return new asml(((LayoutInflater)localObject).inflate(2131561121, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Asqm, this.b);
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new bmpr(this.jdField_a_of_type_AndroidAppActivity, 2131563055, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((bmpr)localObject).a() == null);
      paramViewGroup.addView(((bmpr)localObject).a(), localLayoutParams);
      return new asmm(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Asqm, (bmpr)localObject);
    case 5: 
      return new asnl(((LayoutInflater)localObject).inflate(2131559441, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    case 6: 
      paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new asmt(paramViewGroup, this.jdField_a_of_type_Asmw);
      if (this.jdField_a_of_type_Asmt != null) {
        this.jdField_a_of_type_Asmt.a();
      }
      this.jdField_a_of_type_Asmt = ((asmt)paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new asmx(paramViewGroup, this.jdField_a_of_type_Asud);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof asmt)) {
      ((asmt)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqk
 * JD-Core Version:    0.7.0.1
 */