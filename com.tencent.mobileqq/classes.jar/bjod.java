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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class bjod
  extends BaseAdapter
  implements View.OnClickListener, blpr
{
  int jdField_a_of_type_Int = -1;
  blpv jdField_a_of_type_Blpv = a(paramContext);
  public String a;
  private List<bjog> jdField_a_of_type_JavaUtilList;
  
  public bjod(OpenCardContainer paramOpenCardContainer, Context paramContext) {}
  
  private void a(bjoh parambjoh, int paramInt, View paramView)
  {
    paramView = (bjog)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bjoh.a(parambjoh).setText(paramView.b);
    if (paramView.jdField_a_of_type_Boolean)
    {
      bjoh.a(parambjoh).setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    }
    for (;;)
    {
      if (paramView.jdField_a_of_type_JavaLangString != null) {
        OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, bjoh.a(parambjoh), paramView.jdField_a_of_type_JavaLangString);
      }
      return;
      bjoh.a(parambjoh).setVisibility(4);
    }
  }
  
  protected blpv a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298726);
    int j = paramContext.getResources().getDimensionPixelSize(2131298727);
    paramContext = OpenCardContainer.c;
    int[] arrayOfInt1 = OpenCardContainer.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = OpenCardContainer.b;
    return new bjof(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bjog)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bjog localbjog = (bjog)localIterator.next();
      if (localbjog.jdField_a_of_type_Long == paramLong) {
        localbjog.jdField_a_of_type_Boolean = true;
      } else {
        localbjog.jdField_a_of_type_Boolean = false;
      }
    }
    notifyDataSetChanged();
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blpv != null) {}
    for (int i = this.jdField_a_of_type_Blpv.a(paramContext, paramView, paramInt, paramObject, paramblpw, paramOnClickListener);; i = 0)
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
  
  public void a(List<bjog> paramList, String paramString)
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
          bjog localbjog = (bjog)paramString.next();
          if (localbjog.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a()) {
            localbjog.jdField_a_of_type_Boolean = true;
          } else {
            localbjog.jdField_a_of_type_Boolean = false;
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
  
  public void e(boolean paramBoolean) {}
  
  public void f() {}
  
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
    bjoh localbjoh;
    if (paramView == null)
    {
      localbjoh = new bjoh(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, null);
      paramView = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559687, paramViewGroup, false);
      bjoh.a(localbjoh, (URLImageView)paramView.findViewById(2131381190));
      bjoh.a(localbjoh, (TextView)paramView.findViewById(2131381193));
      bjoh.a(localbjoh, (ImageView)paramView.findViewById(2131377293));
      bjoh.a(localbjoh, (Button)paramView.findViewById(2131365380));
      paramView.setTag(localbjoh);
      paramView.setTag(-3, Integer.valueOf(bhgr.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, 66.0F)));
    }
    for (;;)
    {
      a(localbjoh, paramInt, paramView);
      bjoh.a(localbjoh).setOnClickListener(new bjoe(this, paramInt));
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), localbjoh, this);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbjoh = (bjoh)paramView.getTag();
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
        if (!((bjog)((Iterator)localObject).next()).jdField_a_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */