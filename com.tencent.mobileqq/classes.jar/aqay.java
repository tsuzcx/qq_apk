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
import java.util.ArrayList;
import java.util.List;

public class aqay
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private apxo jdField_a_of_type_Apxo;
  private apxr jdField_a_of_type_Apxr;
  private apxu jdField_a_of_type_Apxu;
  private apyo jdField_a_of_type_Apyo;
  private aqae jdField_a_of_type_Aqae;
  private aqba jdField_a_of_type_Aqba;
  aqds jdField_a_of_type_Aqds;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private List<apyo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public aqay(apxo paramapxo, aqba paramaqba, apxu paramapxu, aqds paramaqds, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Apxo = paramapxo;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Apyo = new apyo();
    this.jdField_a_of_type_Apyo.mType = 1;
    this.jdField_a_of_type_Aqba = paramaqba;
    this.jdField_a_of_type_Apxu = paramapxu;
    this.jdField_a_of_type_Aqds = paramaqds;
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
          if (paramString.equals(((apyo)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public apyo a(int paramInt)
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
          localObject1 = (apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<apyo> a()
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
  
  public void a(int paramInt, apyo paramapyo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramapyo);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Apyo.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(apxq paramapxq)
  {
    if ((this.jdField_a_of_type_Apxr != null) && (this.jdField_a_of_type_Apxr.itemView != null)) {
      this.jdField_a_of_type_Apxr.a(paramapxq);
    }
  }
  
  public void a(aqae paramaqae)
  {
    this.jdField_a_of_type_Aqae = paramaqae;
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
      if (((apyo)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
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
  
  public void a(List<apyo> paramList)
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
    if (this.jdField_a_of_type_Apxr != null) {
      this.jdField_a_of_type_Apxr.a();
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
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof apxp)) {
        return 6;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof apxw)) {
        return 7;
      }
      if (((apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
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
    case 3: 
    default: 
      return;
    case 0: 
      paramViewHolder = (apxx)paramViewHolder;
      localObject = (apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (apyo)localObject, i);
      if ((this.jdField_a_of_type_Aqba != null) && (this.jdField_a_of_type_Aqba.c() == paramInt) && (!paramViewHolder.a.b())) {
        paramViewHolder.a.c();
      }
      while (this.jdField_a_of_type_Aqae != null)
      {
        this.jdField_a_of_type_Aqae.a(((apyo)localObject).mUin);
        return;
        paramViewHolder.a.d();
      }
    case 1: 
      paramViewHolder = (apxz)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Apyo);
      return;
    case 2: 
      paramViewHolder = (apxl)paramViewHolder;
      paramViewHolder.a(paramViewHolder, null, this.c);
      return;
    case 5: 
      paramViewHolder = (apyj)paramViewHolder;
      localObject = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a((MiniAppRecommInfo)localObject, i);
      return;
    case 4: 
      paramViewHolder = (apxm)paramViewHolder;
      localObject = (apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a(paramViewHolder, (apyo)localObject, i);
      return;
    case 6: 
      paramViewHolder = (apxr)paramViewHolder;
      localObject = (apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramViewHolder.a((apyo)localObject, i);
      return;
    }
    paramViewHolder = (apxv)paramViewHolder;
    Object localObject = (apyo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    i = n;
    if (paramInt == 0) {
      i = this.jdField_a_of_type_Int;
    }
    paramViewHolder.a((apyo)localObject, i);
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
        return new apxx(paramViewGroup, this.jdField_a_of_type_Aqba, this.jdField_a_of_type_Apxo, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new apxz(paramViewGroup, this.jdField_a_of_type_Aqba);
        return new apxl(((LayoutInflater)localObject).inflate(2131560922, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqba, this.b);
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new bkdl(this.jdField_a_of_type_AndroidAppActivity, 2131562807, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((bkdl)localObject).a() == null);
      paramViewGroup.addView(((bkdl)localObject).a(), localLayoutParams);
      return new apxm(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqba, (bkdl)localObject);
    case 5: 
      return new apyj(((LayoutInflater)localObject).inflate(2131559305, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    case 6: 
      paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new apxr(paramViewGroup, this.jdField_a_of_type_Apxu);
      if (this.jdField_a_of_type_Apxr != null) {
        this.jdField_a_of_type_Apxr.a();
      }
      this.jdField_a_of_type_Apxr = ((apxr)paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new apxv(paramViewGroup, this.jdField_a_of_type_Aqds);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof apxr)) {
      ((apxr)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqay
 * JD-Core Version:    0.7.0.1
 */