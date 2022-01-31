import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class ankh<T extends anho>
  extends BaseAdapter
  implements afdw
{
  public int a;
  public aeov a;
  public Context a;
  public SessionInfo a;
  private ArkHorizontalListView jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView;
  private LinkedList<T> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public int b;
  
  public ankh(Context paramContext, SessionInfo paramSessionInfo, ArkHorizontalListView paramArkHorizontalListView, aeov paramaeov)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView = paramArkHorizontalListView;
    this.jdField_a_of_type_Aeov = paramaeov;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public T a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= getCount() - 1)) {
      return null;
    }
    return (anho)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
    int i = 0;
    while ((i < paramInt) && (i < j))
    {
      anho localanho = (anho)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      if (localanho != null) {
        localanho.destroyContainerByRemove();
      }
      i += 1;
    }
    notifyDataSetChanged();
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.b != paramInt2)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.b = paramInt2;
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramInt, paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(afds paramafds, int paramInt)
  {
    int i;
    if ((paramInt == 1) || (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = BaseChatItemLayout.n;
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296297);
      int m = localResources.getDimensionPixelSize(2131296289);
      int n = MessageForArkApp.dp2px(paramafds.getWidth());
      i = anjs.d - (i * 2 + j + k) - n - m;
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) || (paramInt != 1)) {
        break label185;
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        paramafds = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
        if ((paramafds != null) && (!(paramafds instanceof LinearLayout)))
        {
          paramafds.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, -1));
          paramafds.requestLayout();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
        }
      }
      return;
      label185:
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) && (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()) && (this.b != i))
      {
        this.b = i;
        paramafds = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(paramInt + 1);
        if ((paramafds != null) && (!(paramafds instanceof LinearLayout)))
        {
          paramafds.setLayoutParams(new ViewGroup.LayoutParams(this.b, -1));
          paramafds.requestLayout();
        }
      }
    }
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(ankl paramankl, T paramT)
  {
    Object localObject2 = paramT.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramT.clickTail(paramankl, null, this.jdField_a_of_type_AndroidContentContext);
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new anki(this, paramankl));
      paramT = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramT != null)
      {
        paramankl.b.setVisibility(0);
        paramankl.jdField_a_of_type_AndroidWidgetTextView.setText(paramT);
      }
    }
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new ankj(this, str, paramankl));
  }
  
  public boolean a(afdt paramafdt)
  {
    return false;
  }
  
  public boolean a(afdt paramafdt, String paramString1, String paramString2)
  {
    QLog.d("ArkOpenView", 1, "ArkHorizontalListViewAdapter OpenCardView containerWrapper=" + paramafdt + ", view=" + paramString1 + ", meta=" + paramString2);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
      {
        anho localanho = ((anho)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).extendArkCardByOpen(paramafdt, paramString1, paramString2);
        if (localanho != null) {
          a(i + 1, localanho);
        }
      }
      else
      {
        return false;
      }
      i += 1;
    }
  }
  
  public T b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      return null;
    }
    return (anho)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size()) || (paramT == null)) {}
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilLinkedList.set(paramInt, paramT);
          paramInt += 1;
          i = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getFirstVisiblePosition();
        } while ((paramInt < i) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getLastVisiblePosition()));
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChildAt(paramInt - i);
      } while (localObject == null);
      localObject = (ankl)((View)localObject).getTag();
    } while (localObject == null);
    paramT.attachArkView(this, (ankl)localObject, paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + 2;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getCount() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      anho localanho = a(paramInt);
      if (paramView == null)
      {
        paramView = new ankl();
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558666, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362807));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)localView.findViewById(2131362809));
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362821));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131369738));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362798));
        paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131362813);
        paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362808));
        paramView.b = ((LinearLayout)localView.findViewById(2131362805));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362804));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362806));
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getParent();
        if ((paramViewGroup instanceof BaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)paramViewGroup);
        }
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        if (localanho != null) {
          localanho.attachArkView(this, paramViewGroup, paramInt);
        }
        return localView;
        paramViewGroup = (ankl)paramView.getTag();
        localView = paramView;
      }
    }
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramViewGroup.getContext());
    }
    if (paramInt == 0) {}
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = this.b)
    {
      localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, -1));
      localView.setVisibility(0);
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankh
 * JD-Core Version:    0.7.0.1
 */