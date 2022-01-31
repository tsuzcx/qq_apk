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

public class beko
  extends beki
  implements View.OnClickListener
{
  private bekr jdField_a_of_type_Bekr;
  HashMap<Integer, DislikeInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  bekn b;
  View jdField_f_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_f_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_g_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_h_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_h_of_type_JavaUtilArrayList = new ArrayList();
  View jdField_i_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_i_of_type_JavaUtilArrayList = new ArrayList();
  
  public beko(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Bekn = new bekp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494412, null);
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
    int k = this.jdField_f_of_type_JavaUtilArrayList.size();
    int j = k;
    if (this.jdField_g_of_type_JavaUtilArrayList.size() > k) {
      j = this.jdField_g_of_type_JavaUtilArrayList.size();
    }
    k = j;
    if (this.jdField_h_of_type_JavaUtilArrayList.size() > j) {
      k = this.jdField_h_of_type_JavaUtilArrayList.size();
    }
    j = k;
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > k) {
      j = this.jdField_i_of_type_JavaUtilArrayList.size();
    }
    k = j;
    if (j > 6) {
      k = 6;
    }
    return k;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<AdDislikeInfo> paramArrayList)
  {
    b();
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
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
              this.jdField_f_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
              break;
            case 2: 
              this.jdField_g_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
              break;
            case 3: 
              this.jdField_h_of_type_JavaUtilArrayList.add(localAdDislikeInfo);
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(1)))
    {
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
      boolean bool = true;
      if (this.jdField_f_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_f_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_f_of_type_JavaUtilArrayList, this.jdField_f_of_type_AndroidViewView, 2130841148, paramArrayList.a, bool);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(2))) {
        break label563;
      }
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
      bool = true;
      if (this.jdField_g_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_g_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_g_of_type_JavaUtilArrayList, this.jdField_g_of_type_AndroidViewView, 2130841150, paramArrayList.a, bool);
      label352:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(3))) {
        break label589;
      }
      paramArrayList = (DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
      bool = true;
      if (this.jdField_h_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_h_of_type_JavaUtilArrayList.add(paramArrayList);
        bool = false;
      }
      a(this.jdField_h_of_type_JavaUtilArrayList, this.jdField_h_of_type_AndroidViewView, 2130841141, paramArrayList.a, bool);
    }
    for (;;)
    {
      paramArrayList = new DislikeInfo();
      paramArrayList.a = ajjy.a(2131640146);
      paramArrayList.c = 0;
      this.jdField_i_of_type_JavaUtilArrayList.add(paramArrayList);
      a(this.jdField_i_of_type_JavaUtilArrayList, this.jdField_i_of_type_AndroidViewView, 2130841133, paramArrayList.a, false);
      this.jdField_i_of_type_AndroidViewView.findViewById(2131302744).setVisibility(0);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("KandianNegativeWindowForAd", 1, "setData:" + localStringBuilder.toString());
      }
      return;
      a(new ArrayList(), this.jdField_f_of_type_AndroidViewView, 2130841148, ajjy.a(2131640130), false);
      break;
      label563:
      a(new ArrayList(), this.jdField_g_of_type_AndroidViewView, 2130841150, ajjy.a(2131640133), false);
      break label352;
      label589:
      a(new ArrayList(), this.jdField_h_of_type_AndroidViewView, 2130841141, ajjy.a(2131640134), false);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131299132));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131304072));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131298645));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305047));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305048));
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131305042);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131305049);
    this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131305045);
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131305040);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView.findViewById(2131310123).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    ((ImageView)paramView.findViewById(2131300683).findViewById(2131303431)).setOnClickListener(this);
    this.jdField_h_of_type_Int = ((int)babp.i());
    this.jdField_i_of_type_Int = ((int)babp.j());
    this.k = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131167498));
    this.j = (this.jdField_h_of_type_Int - this.k * 2);
    setWidth(this.j);
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131167475));
    setOnDismissListener(new bekq(this));
  }
  
  public void a(bekr parambekr)
  {
    this.jdField_a_of_type_Bekr = parambekr;
  }
  
  protected int b()
  {
    if (this.jdField_g_of_type_Int <= 0)
    {
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_g_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    }
    int j = (a() + 1) * this.l + this.jdField_g_of_type_Int;
    b(this.jdField_f_of_type_AndroidViewView);
    int k = this.jdField_f_of_type_AndroidViewView.getMeasuredHeight() * this.m + this.jdField_g_of_type_Int;
    if (j > k) {
      return j;
    }
    return k;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_f_of_type_JavaUtilArrayList.clear();
    this.jdField_g_of_type_JavaUtilArrayList.clear();
    this.jdField_h_of_type_JavaUtilArrayList.clear();
    this.jdField_i_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(oqh paramoqh, ArrayList<AdDislikeInfo> paramArrayList)
  {
    int m = 0;
    Object localObject = null;
    int k;
    int j;
    if (paramoqh != null)
    {
      k = paramoqh.b;
      j = paramoqh.a;
    }
    for (paramoqh = paramoqh.a();; paramoqh = localObject)
    {
      if (paramoqh != null) {
        m = obz.a(paramoqh);
      }
      a(k, j, m, paramArrayList);
      return;
      j = 0;
      k = 0;
    }
  }
  
  protected void d()
  {
    this.e.clear();
    a(this.jdField_f_of_type_JavaUtilArrayList.size(), this.jdField_f_of_type_AndroidViewView);
    a(this.jdField_g_of_type_JavaUtilArrayList.size(), this.jdField_g_of_type_AndroidViewView);
    a(this.jdField_h_of_type_JavaUtilArrayList.size(), this.jdField_h_of_type_AndroidViewView);
    a(this.jdField_i_of_type_JavaUtilArrayList.size(), this.jdField_i_of_type_AndroidViewView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131305042: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_f_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).a, this.jdField_b_of_type_Bekn);
      a(true);
      return;
    case 2131305049: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_f_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2))).a, this.jdField_b_of_type_Bekn);
      a(true);
      return;
    case 2131305045: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.jdField_f_of_type_JavaUtilArrayList, ((DislikeInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3))).a, this.jdField_b_of_type_Bekn);
      a(true);
      return;
    case 2131305040: 
      if (this.jdField_a_of_type_Bekr != null) {
        this.jdField_a_of_type_Bekr.a();
      }
      dismiss();
      return;
    }
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beko
 * JD-Core Version:    0.7.0.1
 */