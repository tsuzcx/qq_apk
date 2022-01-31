import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.NegativeChildrenLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class bhyd
  extends bhxx
  implements View.OnClickListener
{
  private bhyg jdField_a_of_type_Bhyg;
  HashMap<Integer, DislikeInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  bhyc b;
  View jdField_g_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_h_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_h_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_i_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_i_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_j_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_j_of_type_JavaUtilArrayList = new ArrayList();
  
  public bhyd(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Bhyc = new bhye(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560080, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected int a()
  {
    int m = this.jdField_g_of_type_JavaUtilArrayList.size();
    int k = m;
    if (this.jdField_h_of_type_JavaUtilArrayList.size() > m) {
      k = this.jdField_h_of_type_JavaUtilArrayList.size();
    }
    m = k;
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > k) {
      m = this.jdField_i_of_type_JavaUtilArrayList.size();
    }
    k = m;
    if (this.jdField_j_of_type_JavaUtilArrayList.size() > m) {
      k = this.jdField_j_of_type_JavaUtilArrayList.size();
    }
    m = k;
    if (k > 6) {
      m = 6;
    }
    return m;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<AdDislikeInfo> paramArrayList)
  {
    b();
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramArrayList.next();
        if (localAdDislikeInfo != null)
        {
          if (localAdDislikeInfo.a != 0) {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localAdDislikeInfo.a), localAdDislikeInfo);
          }
          for (;;)
          {
            localStringBuilder.append(localAdDislikeInfo.toString());
            localStringBuilder.append("\n");
            break;
            switch (localAdDislikeInfo.b)
            {
            default: 
              break;
            case 1: 
              this.jdField_g_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
              break;
            case 2: 
              this.jdField_h_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
              break;
            case 3: 
              this.jdField_i_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(1)))
    {
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
      boolean bool = true;
      if (this.jdField_g_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_g_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_g_of_type_JavaUtilArrayList, this.jdField_g_of_type_AndroidViewView, 2130841344, paramArrayList.a, bool);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(2))) {
        break label563;
      }
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
      bool = true;
      if (this.jdField_h_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_h_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_h_of_type_JavaUtilArrayList, this.jdField_h_of_type_AndroidViewView, 2130841346, paramArrayList.a, bool);
      label352:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(3))) {
        break label589;
      }
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
      bool = true;
      if (this.jdField_i_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_i_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_i_of_type_JavaUtilArrayList, this.jdField_i_of_type_AndroidViewView, 2130841337, paramArrayList.a, bool);
    }
    for (;;)
    {
      paramArrayList = new DislikeInfo();
      paramArrayList.a = alud.a(2131706326);
      paramArrayList.c = 0;
      this.jdField_j_of_type_JavaUtilArrayList.add(paramArrayList);
      a(this.jdField_j_of_type_JavaUtilArrayList, this.jdField_j_of_type_AndroidViewView, 2130841328, paramArrayList.a, false);
      this.jdField_j_of_type_AndroidViewView.findViewById(2131368562).setVisibility(0);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("KandianNegativeWindowForAd", 1, "setData:" + localStringBuilder.toString());
      }
      return;
      a(new ArrayList(), this.jdField_g_of_type_AndroidViewView, 2130841344, alud.a(2131706310), false);
      break;
      label563:
      a(new ArrayList(), this.jdField_h_of_type_AndroidViewView, 2130841346, alud.a(2131706313), false);
      break label352;
      label589:
      a(new ArrayList(), this.jdField_i_of_type_AndroidViewView, 2130841337, alud.a(2131706314), false);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364771));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370026));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364266));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371044));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371045));
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131371038);
    this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131371046);
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131371042);
    this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131371036);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.findViewById(2131376442).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    ((ImageView)paramView.findViewById(2131366384).findViewById(2131369349)).setOnClickListener(this);
    this.jdField_i_of_type_Int = ((int)bdgk.i());
    this.jdField_j_of_type_Int = ((int)bdgk.j());
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298618));
    this.k = (this.jdField_i_of_type_Int - this.l * 2);
    setWidth(this.k);
    this.m = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298594));
    setOnDismissListener(new bhyf(this));
  }
  
  public void a(bhyg parambhyg)
  {
    this.jdField_a_of_type_Bhyg = parambhyg;
  }
  
  protected int b()
  {
    if (this.jdField_h_of_type_Int <= 0)
    {
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_h_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    }
    int k = (a() + 1) * this.m + this.jdField_h_of_type_Int;
    b(this.jdField_g_of_type_AndroidViewView);
    int m = this.jdField_g_of_type_AndroidViewView.getMeasuredHeight() * this.n + this.jdField_h_of_type_Int;
    if (k > m) {
      return k;
    }
    return m;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_g_of_type_JavaUtilArrayList.clear();
    this.jdField_h_of_type_JavaUtilArrayList.clear();
    this.jdField_i_of_type_JavaUtilArrayList.clear();
    this.jdField_j_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(pgq parampgq, ArrayList<AdDislikeInfo> paramArrayList)
  {
    int n = 0;
    Object localObject = null;
    int m;
    int k;
    if (parampgq != null)
    {
      m = parampgq.b;
      k = parampgq.a;
    }
    for (parampgq = parampgq.a();; parampgq = localObject)
    {
      if (parampgq != null) {
        n = ors.a(parampgq);
      }
      a(m, k, n, paramArrayList);
      return;
      k = 0;
      m = 0;
    }
  }
  
  protected void d()
  {
    this.f.clear();
    a(this.jdField_g_of_type_JavaUtilArrayList.size(), this.jdField_g_of_type_AndroidViewView);
    a(this.jdField_h_of_type_JavaUtilArrayList.size(), this.jdField_h_of_type_AndroidViewView);
    a(this.jdField_i_of_type_JavaUtilArrayList.size(), this.jdField_i_of_type_AndroidViewView);
    a(this.jdField_j_of_type_JavaUtilArrayList.size(), this.jdField_j_of_type_AndroidViewView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371038: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).a, this.jdField_b_of_type_Bhyc);
      a(true);
      return;
    case 2131371046: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2))).a, this.jdField_b_of_type_Bhyc);
      a(true);
      return;
    case 2131371042: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_g_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3))).a, this.jdField_b_of_type_Bhyc);
      a(true);
      return;
    case 2131371036: 
      if (this.jdField_a_of_type_Bhyg != null) {
        this.jdField_a_of_type_Bhyg.a();
      }
      dismiss();
      return;
    }
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhyd
 * JD-Core Version:    0.7.0.1
 */