import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class anqh
{
  private int jdField_a_of_type_Int;
  public Context a;
  protected anpk a;
  public SessionInfo a;
  protected ApolloPanelListView a;
  protected QQAppInterface a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public List<annl> a;
  public int b = 0;
  public int c;
  public int d;
  protected int e = -1;
  protected int f = 4;
  
  public anqh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public View a()
  {
    return null;
  }
  
  public annl a(String paramString)
  {
    return null;
  }
  
  public anpk a()
  {
    return this.jdField_a_of_type_Anpk;
  }
  
  public ArrayList<annl> a(int paramInt)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(View paramView, int paramInt) {}
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public View b()
  {
    View localView = a();
    a(localView, 0);
    return localView;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] highlightItemIndex=", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      QLog.e("ApolloViewBinder", 1, "[setHighlightItemIndex] no panel data, set failed");
    }
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()));
      this.e = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] set success, highlightItemIndex=", Integer.valueOf(paramInt) });
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Anpk == null) {
            this.jdField_a_of_type_Anpk = new anpk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          }
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener == null) {
            this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new anqi(this);
          }
          this.jdField_a_of_type_Anpk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_Anpk.a(this.c);
          this.jdField_a_of_type_Anpk.b(this.f);
          this.jdField_a_of_type_Anpk.c(this.e);
          this.jdField_a_of_type_Anpk.a(this.jdField_a_of_type_JavaUtilList);
        } while (!(paramView instanceof ApolloPanelListView));
        paramView = (ApolloPanelListView)paramView;
        paramView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
        paramView.setAdapter(this.jdField_a_of_type_Anpk);
      } while (this.e == -1);
      int j = this.e / this.f;
      i = j;
      if (this.e % this.f != 0) {
        i = j + 1;
      }
    } while (i >= this.jdField_a_of_type_Anpk.getCount());
    paramView.smoothScrollToPosition(i);
  }
  
  public void c_(List<annl> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqh
 * JD-Core Version:    0.7.0.1
 */