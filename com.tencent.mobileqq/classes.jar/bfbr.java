import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import java.util.Iterator;
import java.util.List;

public class bfbr
  extends BaseAdapter
  implements View.OnClickListener, bhww
{
  int jdField_a_of_type_Int = -1;
  bhxa jdField_a_of_type_Bhxa = a(paramContext);
  public String a;
  private List<bfbu> jdField_a_of_type_JavaUtilList;
  
  public bfbr(OpenCardContainer paramOpenCardContainer, Context paramContext) {}
  
  private void a(bfbv parambfbv, int paramInt, View paramView)
  {
    paramView = (bfbu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bfbv.a(parambfbv).setText(paramView.b);
    if (paramView.jdField_a_of_type_Boolean)
    {
      bfbv.a(parambfbv).setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    }
    for (;;)
    {
      if (paramView.jdField_a_of_type_JavaLangString != null) {
        OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, bfbv.a(parambfbv), paramView.jdField_a_of_type_JavaLangString);
      }
      return;
      bfbv.a(parambfbv).setVisibility(4);
    }
  }
  
  protected bhxa a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    paramContext = OpenCardContainer.c;
    int[] arrayOfInt1 = OpenCardContainer.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = OpenCardContainer.b;
    return new bfbt(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bfbu)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bfbu localbfbu = (bfbu)localIterator.next();
      if (localbfbu.jdField_a_of_type_Long == paramLong) {
        localbfbu.jdField_a_of_type_Boolean = true;
      } else {
        localbfbu.jdField_a_of_type_Boolean = false;
      }
    }
    notifyDataSetChanged();
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, bhxb parambhxb, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {}
    for (int i = this.jdField_a_of_type_Bhxa.a(paramContext, paramView, paramInt, paramObject, parambhxb, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  public void a(List<bfbu> paramList, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        break label33;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
      return;
      label33:
      if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          bfbu localbfbu = (bfbu)paramString.next();
          if (localbfbu.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a()) {
            localbfbu.jdField_a_of_type_Boolean = true;
          } else {
            localbfbu.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean) {}
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new bfbv(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, null);
      View localView = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559546, paramViewGroup, false);
      bfbv.a(paramView, (URLImageView)localView.findViewById(2131379991));
      bfbv.a(paramView, (TextView)localView.findViewById(2131379994));
      bfbv.a(paramView, (ImageView)localView.findViewById(2131376310));
      bfbv.a(paramView, (Button)localView.findViewById(2131365096));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(bcwh.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, 66.0F)));
      paramViewGroup = paramView;
      paramView = localView;
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramView);
      bfbv.a(paramViewGroup).setOnClickListener(new bfbs(this, paramInt));
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramViewGroup, this);
      return paramView;
      paramViewGroup = (bfbv)paramView.getTag();
    }
  }
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      OpenCardContainer.a((OpenCardContainer)localObject, i);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    }
    label137:
    label138:
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label67:
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      label79:
      if (((Iterator)localObject).hasNext())
      {
        if (!((bfbu)((Iterator)localObject).next()).jdField_a_of_type_Boolean) {
          break label137;
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
        i = 1;
      }
      for (;;)
      {
        break label79;
        if (i != 0) {
          break label138;
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
        break;
      }
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbr
 * JD-Core Version:    0.7.0.1
 */