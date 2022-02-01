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

public class aszx
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aswh jdField_a_of_type_Aswh;
  private aswk jdField_a_of_type_Aswk;
  private aswn jdField_a_of_type_Aswn;
  private asxh jdField_a_of_type_Asxh;
  private aszd jdField_a_of_type_Aszd;
  private aszz jdField_a_of_type_Aszz;
  atdp jdField_a_of_type_Atdp;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private List<asxh> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public aszx(aswh paramaswh, aszz paramaszz, aswn paramaswn, atdp paramatdp, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Aswh = paramaswh;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Asxh = new asxh();
    this.jdField_a_of_type_Asxh.mType = 1;
    this.jdField_a_of_type_Aszz = paramaszz;
    this.jdField_a_of_type_Aswn = paramaswn;
    this.jdField_a_of_type_Atdp = paramatdp;
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
          if (paramString.equals(((asxh)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public asxh a(int paramInt)
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
          localObject1 = (asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<asxh> a()
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
  
  public void a(int paramInt, asxh paramasxh)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramasxh);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Asxh.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(aswj paramaswj)
  {
    if ((this.jdField_a_of_type_Aswk != null) && (this.jdField_a_of_type_Aswk.itemView != null)) {
      this.jdField_a_of_type_Aswk.a(paramaswj);
    }
  }
  
  public void a(aszd paramaszd)
  {
    this.jdField_a_of_type_Aszd = paramaszd;
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
      if (((asxh)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
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
  
  public void a(List<asxh> paramList)
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
    if (this.jdField_a_of_type_Aswk != null) {
      this.jdField_a_of_type_Aswk.a();
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
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof aswi)) {
        return 6;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof aswp)) {
        return 7;
      }
      if (((asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
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
      Object localObject1 = (aswq)paramViewHolder;
      Object localObject2 = (asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((aswq)localObject1).a((aswq)localObject1, (asxh)localObject2, i);
      if ((this.jdField_a_of_type_Aszz != null) && (this.jdField_a_of_type_Aszz.c() == paramInt) && (!((aswq)localObject1).a.b())) {
        ((aswq)localObject1).a.c();
      }
      while (this.jdField_a_of_type_Aszd != null)
      {
        this.jdField_a_of_type_Aszd.a(((asxh)localObject2).mUin);
        break;
        ((aswq)localObject1).a.d();
      }
      localObject1 = (asws)paramViewHolder;
      ((asws)localObject1).a((asws)localObject1, this.jdField_a_of_type_Asxh);
      continue;
      localObject1 = (aswc)paramViewHolder;
      ((aswc)localObject1).a((aswc)localObject1, null, this.c);
      continue;
      localObject1 = (asxc)paramViewHolder;
      localObject2 = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((asxc)localObject1).a((MiniAppRecommInfo)localObject2, i);
      continue;
      localObject1 = (aswd)paramViewHolder;
      localObject2 = (asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((aswd)localObject1).a((aswd)localObject1, (asxh)localObject2, i);
      continue;
      localObject1 = (aswk)paramViewHolder;
      localObject2 = (asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((aswk)localObject1).a((asxh)localObject2, i);
      continue;
      localObject1 = (aswo)paramViewHolder;
      localObject2 = (asxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = n;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((aswo)localObject1).a((asxh)localObject2, i);
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
        return new aswq(paramViewGroup, this.jdField_a_of_type_Aszz, this.jdField_a_of_type_Aswh, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new asws(paramViewGroup, this.jdField_a_of_type_Aszz);
        return new aswc(((LayoutInflater)localObject).inflate(2131561186, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aszz, this.b);
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new bnxu(this.jdField_a_of_type_AndroidAppActivity, 2131563097, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((bnxu)localObject).a() == null);
      paramViewGroup.addView(((bnxu)localObject).a(), localLayoutParams);
      return new aswd(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aszz, (bnxu)localObject);
    case 5: 
      return new asxc(((LayoutInflater)localObject).inflate(2131559393, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    case 6: 
      paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new aswk(paramViewGroup, this.jdField_a_of_type_Aswn);
      if (this.jdField_a_of_type_Aswk != null) {
        this.jdField_a_of_type_Aswk.a();
      }
      this.jdField_a_of_type_Aswk = ((aswk)paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new aswo(paramViewGroup, this.jdField_a_of_type_Atdp);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof aswk)) {
      ((aswk)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszx
 * JD-Core Version:    0.7.0.1
 */